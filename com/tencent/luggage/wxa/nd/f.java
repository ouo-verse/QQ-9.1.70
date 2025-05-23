package com.tencent.luggage.wxa.nd;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.luggage.wxa.nd.e;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f135657a;

    /* renamed from: b, reason: collision with root package name */
    public String f135658b;

    /* renamed from: c, reason: collision with root package name */
    public int f135659c;

    /* renamed from: d, reason: collision with root package name */
    public ServerSocket f135660d;

    /* renamed from: e, reason: collision with root package name */
    public e.f f135661e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(4);
            while (f.this.f135657a) {
                try {
                    newScheduledThreadPool.submit(new b(f.this.f135660d.accept()));
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static f f135665a = new f();
    }

    public synchronized void d() {
        if (this.f135657a) {
            return;
        }
        this.f135657a = true;
        try {
            String b16 = i.b();
            this.f135658b = b16;
            ServerSocket serverSocket = new ServerSocket(0, 32, InetAddress.getByName(b16));
            this.f135660d = serverSocket;
            this.f135659c = serverSocket.getLocalPort();
            BaseThread baseThread = new BaseThread(new c());
            baseThread.setName("DLNA-Server-Thread");
            baseThread.start();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public synchronized void e() {
        if (!this.f135657a) {
            return;
        }
        this.f135657a = false;
        ServerSocket serverSocket = this.f135660d;
        if (serverSocket != null && serverSocket.isClosed()) {
            try {
                this.f135660d.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public f() {
        this.f135657a = false;
        this.f135659c = -1;
    }

    public static f a() {
        return d.f135665a;
    }

    public String b() {
        return this.f135658b;
    }

    public int c() {
        return this.f135659c;
    }

    public void a(e.f fVar) {
        this.f135661e = fVar;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public Socket f135662a;

        public b(Socket socket) {
            this.f135662a = socket;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x010a A[Catch: all -> 0x0125, IOException -> 0x0127, TryCatch #0 {IOException -> 0x0127, blocks: (B:3:0x0003, B:4:0x0022, B:7:0x002b, B:11:0x0031, B:13:0x003b, B:15:0x004e, B:17:0x0067, B:18:0x0072, B:20:0x00a2, B:21:0x00a8, B:23:0x00ae, B:24:0x00b4, B:32:0x00f7, B:33:0x0112, B:45:0x0101, B:46:0x010a, B:47:0x00dd, B:50:0x00e8, B:9:0x0059), top: B:2:0x0003, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void call() {
            Socket socket;
            InputStream inputStream;
            com.tencent.luggage.wxa.pd.d dVar;
            char c16;
            String str;
            int i3;
            String str2;
            BufferedWriter bufferedWriter;
            String a16;
            int hashCode;
            try {
                try {
                    inputStream = this.f135662a.getInputStream();
                    m a17 = m.a();
                    c16 = 0;
                    dVar = new com.tencent.luggage.wxa.pd.d(false);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        str = "";
                        if (readLine == null) {
                            i3 = 0;
                            str2 = "";
                            break;
                        }
                        if (readLine.length() == 0) {
                            str2 = sb5.toString();
                            if (str2.length() > 0) {
                                com.tencent.luggage.wxa.pd.b b16 = a17.b(str2);
                                dVar.f137498a = b16;
                                String a18 = b16.a("CONTENT-LENGTH");
                                if (!TextUtils.isEmpty(a18)) {
                                    i3 = Integer.valueOf(a18).intValue();
                                }
                            }
                            i3 = 0;
                        } else {
                            sb5.append(readLine);
                            sb5.append("\r\n");
                        }
                    }
                    if (i3 > 0) {
                        char[] cArr = new char[i3];
                        str = new String(cArr, 0, bufferedReader.read(cArr));
                    }
                    Log.i("MRSubscriptionServer", "header = " + str2);
                    Log.i("MRSubscriptionServer", "body = " + str);
                    if (str2.length() > 0) {
                        dVar.f137498a = a17.b(str2);
                    }
                    if (str.length() > 0) {
                        dVar.f137499b = a17.a(str);
                    }
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.f135662a.getOutputStream()));
                    a16 = dVar.f137498a.a(AEEditorConstants.PATH);
                    hashCode = a16.hashCode();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    socket = this.f135662a;
                    if (socket == null) {
                    }
                }
                try {
                    if (hashCode != 50084583) {
                        if (hashCode == 1171555962 && a16.equals("/upnp/cb/RenderControl")) {
                            c16 = 1;
                            if (c16 != 0) {
                                dVar.f137496c = "avtEvent";
                                a(dVar, bufferedWriter);
                            } else if (c16 != 1) {
                                Log.e("MRSubscriptionServer", "Unknown request, will return 404");
                                a(bufferedWriter);
                            } else {
                                dVar.f137496c = "rdcEvent";
                                a(dVar, bufferedWriter);
                            }
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            inputStream.close();
                            this.f135662a.close();
                            socket = this.f135662a;
                            if (socket == null) {
                                return null;
                            }
                            socket.close();
                            return null;
                        }
                        c16 = '\uffff';
                        if (c16 != 0) {
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        inputStream.close();
                        this.f135662a.close();
                        socket = this.f135662a;
                        if (socket == null) {
                        }
                        socket.close();
                        return null;
                    }
                    if (a16.equals("/upnp/cb/AVTransport")) {
                        if (c16 != 0) {
                        }
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        inputStream.close();
                        this.f135662a.close();
                        socket = this.f135662a;
                        if (socket == null) {
                        }
                        socket.close();
                        return null;
                    }
                    c16 = '\uffff';
                    if (c16 != 0) {
                    }
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    inputStream.close();
                    this.f135662a.close();
                    socket = this.f135662a;
                    if (socket == null) {
                    }
                    socket.close();
                    return null;
                    socket.close();
                    return null;
                } catch (IOException unused) {
                    return null;
                }
                e16.printStackTrace();
                socket = this.f135662a;
                if (socket == null) {
                    return null;
                }
            } catch (Throwable th5) {
                Socket socket2 = this.f135662a;
                if (socket2 != null) {
                    try {
                        socket2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th5;
            }
        }

        public final void b(BufferedWriter bufferedWriter) {
            bufferedWriter.write("HTTP/1.1 500 Internal Server Error\r\nContent-Length: 0\r\n\r\n");
        }

        public final void c(BufferedWriter bufferedWriter) {
            bufferedWriter.write("HTTP/1.1 200 OK\r\nContent-Length: 0\r\n\r\n");
        }

        public final void a(com.tencent.luggage.wxa.pd.d dVar, BufferedWriter bufferedWriter) {
            e.f fVar = f.this.f135661e;
            if (fVar != null && !fVar.a(dVar)) {
                b(bufferedWriter);
            } else {
                c(bufferedWriter);
            }
        }

        public final void a(BufferedWriter bufferedWriter) {
            bufferedWriter.write("HTTP/1.1 404 Not Found\r\nContent-Length: 0\r\n\r\n");
        }
    }
}
