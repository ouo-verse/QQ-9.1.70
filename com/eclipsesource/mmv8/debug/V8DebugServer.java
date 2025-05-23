package com.eclipsesource.mmv8.debug;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8Value;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8DebugServer {
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
    private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
    private static final String HEADER_TYPE = "Type: ";
    private static final String HEADER_V8_VERSION = "V8-Version: ";
    private static final String J2V8_VERSION = "4.0.0";
    private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
    private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
    private static final int PROTOCOL_BUFFER_SIZE = 4096;
    private static final Charset PROTOCOL_CHARSET;
    private static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES;
    private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
    private static final String PROTOCOL_EOL = "\r\n";
    private static final byte[] PROTOCOL_EOL_BYTES;
    private static final String PROTOCOL_VERSION = "1";
    private static final String SET_LISTENER = "setListener";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private static final String V8_VERSION = "4.10.253";
    private Socket client;
    private V8Object debugObject;
    private V8Object runningStateDcp;
    private V8 runtime;
    private ServerSocket server;
    private V8Object stoppedStateDcp;
    private boolean waitForConnection;
    private Object clientLock = new Object();
    private boolean traceCommunication = false;
    private List<String> requests = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class ClientLoop implements Runnable {
        private int from;

        ClientLoop() {
        }

        private int indexOf(byte[] bArr, byte[] bArr2, int i3, int i16) {
            int length = bArr.length;
            while (i3 < i16) {
                for (int i17 = 0; i17 <= length; i17++) {
                    if (i17 == length) {
                        return i3;
                    }
                    int i18 = i3 + i17;
                    if (i18 < i16 && bArr2[i18] == bArr[i17]) {
                    }
                    i3++;
                }
                i3++;
            }
            return -1;
        }

        private byte[] join(byte[] bArr, byte[] bArr2, int i3, int i16) {
            byte[] bArr3 = new byte[bArr.length + i16];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, i3, bArr3, bArr.length, i16);
            return bArr3;
        }

        private void processClientRequests() throws IOException {
            InputStream inputStream;
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[4096];
            synchronized (V8DebugServer.this.clientLock) {
                inputStream = V8DebugServer.this.client.getInputStream();
            }
            int i3 = 0;
            boolean z16 = false;
            byte[] bArr3 = bArr;
            int i16 = -1;
            while (true) {
                int read = inputStream.read(bArr2, i3, 4096 - i3);
                if (read > 0) {
                    int i17 = read + i3;
                    this.from = 0;
                    do {
                        if (i16 < 0) {
                            i16 = readContentLength(bArr2, i17);
                            if (i16 < 0) {
                                break;
                            }
                        }
                        if (!z16 && !(z16 = skipToolInfo(bArr2, i17))) {
                            break;
                        }
                        int min = Math.min(i16 - bArr3.length, i17 - this.from);
                        bArr3 = join(bArr3, bArr2, this.from, min);
                        this.from += min;
                        if (bArr3.length == i16) {
                            String str = new String(bArr3, V8DebugServer.PROTOCOL_CHARSET);
                            synchronized (V8DebugServer.this.requests) {
                                V8DebugServer.this.requests.add(str);
                            }
                            z16 = false;
                            bArr3 = bArr;
                            i16 = -1;
                        }
                    } while (this.from < i17);
                    int i18 = this.from;
                    if (i18 < i17) {
                        System.arraycopy(bArr2, i18, bArr2, 0, i17 - i18);
                        i3 = i17 - this.from;
                    } else {
                        i3 = 0;
                    }
                } else {
                    return;
                }
            }
        }

        private int readContentLength(byte[] bArr, int i3) throws IOException {
            int length;
            int indexOf;
            int indexOf2 = indexOf(V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES, bArr, this.from, i3);
            if (indexOf2 < 0 || (indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, (length = indexOf2 + V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES.length), i3)) < 0) {
                return -1;
            }
            String str = new String(bArr, length, indexOf - length, V8DebugServer.PROTOCOL_CHARSET);
            try {
                int parseInt = Integer.parseInt(str.trim());
                this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
                return parseInt;
            } catch (Exception unused) {
                throw new IOException("Invalid content length header: '" + str + "' in message" + new String(bArr, V8DebugServer.PROTOCOL_CHARSET));
            }
        }

        private boolean skipToolInfo(byte[] bArr, int i3) {
            int indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, this.from, i3);
            if (indexOf < 0) {
                return false;
            }
            this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
            return true;
        }

        private void startHandshake() throws IOException {
            V8DebugServer.this.sendMessage(V8DebugServer.HEADER_V8_VERSION + V8DebugServer.V8_VERSION + "\r\n" + V8DebugServer.HEADER_PROTOCOL_VERSION + "1\r\n" + V8DebugServer.HEADER_EMBEDDING_HOST + "j2v8 " + V8DebugServer.J2V8_VERSION + "\r\n" + V8DebugServer.HEADER_TYPE + UploadQualityReportBuilder.STATE_CONNECT + "\r\n", "");
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Socket accept = V8DebugServer.this.server.accept();
                    accept.setTcpNoDelay(true);
                    synchronized (V8DebugServer.this.clientLock) {
                        V8DebugServer.this.client = accept;
                        V8DebugServer.this.waitForConnection = false;
                        V8DebugServer.this.clientLock.notifyAll();
                    }
                    startHandshake();
                    processClientRequests();
                } catch (Exception e16) {
                    synchronized (V8DebugServer.this.clientLock) {
                        if (V8DebugServer.this.client != null) {
                            try {
                                V8DebugServer.this.client.close();
                            } catch (IOException unused) {
                            }
                            V8DebugServer.this.client = null;
                        }
                        V8DebugServer.this.logError(e16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class EventHandler implements JavaVoidCallback {
        EventHandler() {
        }

        private void safeRelease(Releasable releasable) {
            if (releasable != null) {
                releasable.release();
            }
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x009e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:159), block:B:43:0x009d */
        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            Releasable releasable;
            V8Object v8Object2;
            Releasable releasable2;
            int integer;
            if (v8Array != null && !v8Array.isUndefined()) {
                Releasable releasable3 = null;
                try {
                    try {
                        integer = v8Array.getInteger(0);
                        v8Object2 = v8Array.getObject(1);
                    } catch (Exception e16) {
                        e = e16;
                        v8Object2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        releasable = null;
                        safeRelease(releasable3);
                        safeRelease(releasable);
                        throw th;
                    }
                    try {
                        V8Object object = v8Array.getObject(2);
                        if (V8DebugServer.this.traceCommunication) {
                            String str = "unknown";
                            switch (integer) {
                                case 1:
                                    str = "Break";
                                    break;
                                case 2:
                                    str = "Exception";
                                    break;
                                case 3:
                                    str = "NewFunction";
                                    break;
                                case 4:
                                    str = "BeforeCompile";
                                    break;
                                case 5:
                                    str = "AfterCompile";
                                    break;
                                case 6:
                                    str = "CompileError";
                                    break;
                                case 7:
                                    str = "PromiseEvent";
                                    break;
                                case 8:
                                    str = "AsyncTaskEvent";
                                    break;
                            }
                            System.out.println("V8 has emmitted an event of type " + str);
                        }
                        if (!V8DebugServer.this.isConnected()) {
                            safeRelease(v8Object2);
                            safeRelease(object);
                            return;
                        }
                        if (integer == 1) {
                            V8DebugServer.this.enterBreakLoop(v8Object2, object);
                        } else if (integer == 5 || integer == 6) {
                            V8DebugServer.this.sendCompileEvent(object);
                        }
                        safeRelease(v8Object2);
                        safeRelease(object);
                    } catch (Exception e17) {
                        e = e17;
                        V8DebugServer.this.logError(e);
                        safeRelease(v8Object2);
                        safeRelease(null);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    releasable = null;
                    releasable3 = releasable2;
                    safeRelease(releasable3);
                    safeRelease(releasable);
                    throw th;
                }
            }
        }
    }

    static {
        Charset forName = Charset.forName("UTF-8");
        PROTOCOL_CHARSET = forName;
        PROTOCOL_EOL_BYTES = "\r\n".getBytes(forName);
        PROTOCOL_CONTENT_LENGTH_BYTES = PROTOCOL_CONTENT_LENGTH_HEADER.getBytes(forName);
    }

    public V8DebugServer(V8 v85, int i3, boolean z16) {
        this.runtime = v85;
        this.waitForConnection = z16;
        V8Object object = v85.getObject(DEBUG_OBJECT_NAME);
        if (object == null) {
            System.err.println("Cannot initialize debugger server - global debug object not found.");
            return;
        }
        try {
            this.debugObject = object.getObject("Debug");
            object.release();
            v85.executeVoidScript("(function() {\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_BREAK_EVENT + " = function (break_id,breakpoints_hit) {\n  return new " + DEBUG_OBJECT_NAME + ".BreakEvent(break_id,breakpoints_hit);\n }\n " + DEBUG_OBJECT_NAME + ".Debug. " + MAKE_COMPILE_EVENT + " = function(script,type) {\n  var scripts = " + DEBUG_OBJECT_NAME + ".Debug.scripts()\n  for (var i in scripts) {\n   if (scripts[i].id == script.id()) {\n     return new " + DEBUG_OBJECT_NAME + ".CompileEvent(scripts[i], type);\n   }\n  }\n  return {toJSONProtocol: function() {return ''}}\n }\n})()");
            try {
                this.server = new ServerSocket(i3);
            } catch (Exception e16) {
                logError(e16);
            }
        } catch (Throwable th5) {
            object.release();
            throw th5;
        }
    }

    public static void configureV8ForDebugging() {
        try {
            V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterBreakLoop(V8Object v8Object, V8Object v8Object2) throws IOException {
        V8Object v8Object3;
        try {
            V8Array v8Array = new V8Array(this.runtime);
            try {
                v8Array.push(false);
                this.stoppedStateDcp = v8Object.executeObjectFunction("debugCommandProcessor", v8Array);
                v8Array.release();
                int integer = v8Object.getInteger("break_id");
                V8Array array = v8Object2.getArray("break_points_hit_");
                V8Array v8Array2 = new V8Array(this.runtime);
                try {
                    v8Array2.push(integer);
                    v8Array2.push((V8Value) array);
                    v8Object3 = this.debugObject.executeObjectFunction(MAKE_BREAK_EVENT, v8Array2);
                } catch (Throwable th5) {
                    th = th5;
                    v8Object3 = null;
                }
                try {
                    String executeStringFunction = v8Object3.executeStringFunction("toJSONProtocol", null);
                    if (this.traceCommunication) {
                        System.out.println("Sending event (Break):\n" + executeStringFunction);
                    }
                    sendJson(executeStringFunction);
                    v8Array2.release();
                    array.release();
                    v8Object3.release();
                    while (isConnected() && !this.stoppedStateDcp.executeBooleanFunction("isRunning", null)) {
                        try {
                            processRequests(10L);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    v8Array2.release();
                    array.release();
                    if (v8Object3 != null) {
                        v8Object3.release();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                v8Array.release();
                throw th7;
            }
        } finally {
            this.stoppedStateDcp.release();
            this.stoppedStateDcp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected() {
        boolean z16;
        Socket socket;
        synchronized (this.clientLock) {
            if (this.server != null && (socket = this.client) != null && socket.isConnected()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private void processRequest(String str) throws IOException {
        if (this.traceCommunication) {
            System.out.println("Got message: \n" + str.substring(0, Math.min(str.length(), 1000)));
        }
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        V8Object v8Object = this.stoppedStateDcp;
        if (v8Object == null) {
            v8Object = this.runningStateDcp;
        }
        String obj = v8Object.executeFunction("processDebugJSONRequest", v8Array).toString();
        if (this.stoppedStateDcp == null && obj.contains("\"running\":false")) {
            obj = obj.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
            v8Object.add("running_", true);
        }
        if (this.traceCommunication) {
            System.out.println("Returning response: \n" + obj.substring(0, Math.min(obj.length(), 1000)));
        }
        sendJson(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCompileEvent(V8Object v8Object) throws IOException {
        Throwable th5;
        V8Object v8Object2;
        if (!isConnected()) {
            return;
        }
        int integer = v8Object.getInteger("type_");
        V8Object object = v8Object.getObject("script_");
        V8Array v8Array = new V8Array(this.runtime);
        try {
            v8Array.push((V8Value) object);
            v8Array.push(integer);
            v8Object2 = this.debugObject.executeObjectFunction(MAKE_COMPILE_EVENT, v8Array);
        } catch (Throwable th6) {
            th5 = th6;
            v8Object2 = null;
        }
        try {
            String executeStringFunction = v8Object2.executeStringFunction("toJSONProtocol", null);
            if (this.traceCommunication) {
                System.out.println("Sending event (CompileEvent):\n" + executeStringFunction.substring(0, Math.min(executeStringFunction.length(), 1000)));
            }
            if (executeStringFunction.length() > 0) {
                sendJson(executeStringFunction);
            }
            v8Array.release();
            object.release();
            v8Object2.release();
        } catch (Throwable th7) {
            th5 = th7;
            v8Array.release();
            object.release();
            if (v8Object2 != null) {
                v8Object2.release();
            }
            throw th5;
        }
    }

    private void sendJson(String str) throws IOException {
        sendMessage("", str.replace("\\/", "/"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(String str, String str2) throws IOException {
        synchronized (this.clientLock) {
            if (isConnected()) {
                Charset charset = PROTOCOL_CHARSET;
                byte[] bytes = str2.getBytes(charset);
                this.client.getOutputStream().write((str + PROTOCOL_CONTENT_LENGTH_HEADER + Integer.toString(bytes.length) + "\r\n\r\n").getBytes(charset));
                if (bytes.length > 0) {
                    this.client.getOutputStream().write(bytes);
                }
            } else {
                throw new IOException("There is no connected client.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.eclipsesource.mmv8.debug.V8DebugServer$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.eclipsesource.mmv8.V8Value] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private void setupEventHandler() {
        V8Array v8Array;
        V8Function v8Function;
        ?? r16 = 0;
        V8Array v8Array2 = null;
        this.debugObject.registerJavaMethod(new EventHandler(), DEBUG_BREAK_HANDLER);
        try {
            v8Function = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
        } catch (Throwable th5) {
            th = th5;
            v8Array = null;
        }
        try {
            v8Array2 = new V8Array(this.runtime).push((V8Value) v8Function);
            this.debugObject.executeFunction(SET_LISTENER, v8Array2);
            if (v8Function != null && !v8Function.isReleased()) {
                v8Function.release();
            }
            if (v8Array2 != null && !v8Array2.isReleased()) {
                v8Array2.release();
            }
        } catch (Throwable th6) {
            th = th6;
            V8Array v8Array3 = v8Array2;
            r16 = v8Function;
            v8Array = v8Array3;
            if (r16 != 0 && !r16.isReleased()) {
                r16.release();
            }
            if (v8Array != null && !v8Array.isReleased()) {
                v8Array.release();
            }
            throw th;
        }
    }

    public int getPort() {
        ServerSocket serverSocket = this.server;
        if (serverSocket != null && serverSocket.isBound()) {
            return this.server.getLocalPort();
        }
        return -1;
    }

    public void logError(Throwable th5) {
        th5.printStackTrace();
    }

    public void processRequests(long j3) throws InterruptedException {
        String[] strArr;
        if (this.server == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            synchronized (this.requests) {
                List<String> list = this.requests;
                strArr = (String[]) list.toArray(new String[list.size()]);
                this.requests.clear();
            }
            for (String str : strArr) {
                try {
                    processRequest(str);
                } catch (Exception e16) {
                    logError(e16);
                }
            }
            if (strArr.length <= 0) {
                if (j3 > 0) {
                    LockMethodProxy.sleep(10L);
                }
                if (j3 <= 0 || currentTimeMillis + j3 <= System.currentTimeMillis()) {
                    return;
                }
            }
        }
    }

    public void setTraceCommunication(boolean z16) {
        this.traceCommunication = z16;
    }

    public void start() {
        if (this.server == null) {
            return;
        }
        boolean z16 = this.waitForConnection;
        BaseThread baseThread = new BaseThread(new ClientLoop(), "J2V8 Debugger Server");
        baseThread.setDaemon(true);
        baseThread.start();
        setupEventHandler();
        this.runningStateDcp = this.runtime.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
        if (z16) {
            synchronized (this.clientLock) {
                while (this.waitForConnection) {
                    try {
                        LockMethodProxy.wait(this.clientLock);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            try {
                processRequests(100L);
            } catch (InterruptedException unused2) {
            }
        }
    }

    public void stop() {
        try {
            this.server.close();
            synchronized (this.clientLock) {
                Socket socket = this.client;
                if (socket != null) {
                    socket.close();
                    this.client = null;
                }
            }
        } catch (IOException e16) {
            logError(e16);
        }
        V8Object v8Object = this.runningStateDcp;
        if (v8Object != null) {
            v8Object.release();
            this.runningStateDcp = null;
        }
        V8Object v8Object2 = this.debugObject;
        if (v8Object2 != null) {
            v8Object2.release();
            this.debugObject = null;
        }
        V8Object v8Object3 = this.stoppedStateDcp;
        if (v8Object3 != null) {
            v8Object3.release();
            this.stoppedStateDcp = null;
        }
    }
}
