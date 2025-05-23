package com.tencent.mobileqq.msf.core.net.s;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends BaseThread {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: q, reason: collision with root package name */
    private static final String f249067q = "ReqAllFailSocket";

    /* renamed from: r, reason: collision with root package name */
    private static final int f249068r = 10000;

    /* renamed from: a, reason: collision with root package name */
    private Socket f249069a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f249070b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f249071c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f249072d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f249073e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.d f249074f;

    /* renamed from: g, reason: collision with root package name */
    private LinkedBlockingDeque<ToServiceMsg> f249075g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f249076h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f249077i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f249078j;

    /* renamed from: k, reason: collision with root package name */
    protected long f249079k;

    /* renamed from: l, reason: collision with root package name */
    protected long f249080l;

    /* renamed from: m, reason: collision with root package name */
    private long f249081m;

    /* renamed from: n, reason: collision with root package name */
    private String f249082n;

    /* renamed from: o, reason: collision with root package name */
    private MsfCore f249083o;

    /* renamed from: p, reason: collision with root package name */
    private int f249084p;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class b extends BaseThread {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(e.this.f249071c);
                int i3 = 0;
                while (true) {
                    if (e.this.f249072d.get() || !e.this.f249073e.get()) {
                        if (i3 <= 0) {
                            i3 = dataInputStream.readInt() - 4;
                            if (i3 <= 33) {
                                e eVar = e.this;
                                eVar.f249076h = true;
                                eVar.f249079k = SystemClock.elapsedRealtime() - e.this.f249081m;
                                QLog.d(e.f249067q, 1, e.this.f249084p + " recv sso ping");
                            } else if (i3 == 62) {
                                e eVar2 = e.this;
                                eVar2.f249077i = true;
                                eVar2.f249080l = SystemClock.elapsedRealtime() - e.this.f249081m;
                                QLog.d(e.f249067q, 1, e.this.f249084p + " recv heartbeat ping");
                            }
                        } else {
                            dataInputStream.readByte();
                            i3--;
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                e.this.f249082n = "readError";
                e.this.a();
            }
        }

        /* synthetic */ b(e eVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class c extends BaseThread {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            byte[] nativeEncodeRequest;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            while (!e.this.f249073e.get()) {
                try {
                    ToServiceMsg toServiceMsg = (ToServiceMsg) e.this.f249075g.take();
                    String serviceCmd = toServiceMsg.getServiceCmd();
                    try {
                        bArr = t.a(toServiceMsg, serviceCmd, 0, 0);
                    } catch (Exception e16) {
                        QLog.d(e.f249067q, 1, "", e16);
                        bArr = null;
                    }
                    if (591 == CodecWarpper.getSharedObjectVersion()) {
                        nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), 0, toServiceMsg.getUin(), toServiceMsg.getUinType(), (byte) 0, toServiceMsg.getWupBuffer(), true);
                    } else {
                        if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                            nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), 0, toServiceMsg.getUin(), toServiceMsg.getUinType(), (byte) 0, (byte) 0, bArr, null, toServiceMsg.getWupBuffer(), true);
                        }
                        nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), 0, toServiceMsg.getUin(), toServiceMsg.getUinType(), (byte) 0, bArr, null, toServiceMsg.getWupBuffer(), true);
                    }
                    if (e.this.f249072d.get()) {
                        e.this.a(toServiceMsg.getServiceCmd(), toServiceMsg.getMsfCommand(), nativeEncodeRequest);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    e.this.a();
                }
            }
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) aVar);
        }
    }

    public e(MsfCore msfCore, com.tencent.mobileqq.msf.core.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, dVar, Integer.valueOf(i3));
            return;
        }
        this.f249072d = new AtomicBoolean(false);
        this.f249073e = new AtomicBoolean(false);
        this.f249075g = new LinkedBlockingDeque<>(1000);
        this.f249076h = false;
        this.f249077i = false;
        this.f249078j = false;
        this.f249079k = 0L;
        this.f249080l = 0L;
        this.f249081m = 0L;
        this.f249082n = "";
        this.f249083o = msfCore;
        this.f249074f = dVar;
        this.f249084p = i3;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (b()) {
            a aVar = null;
            new c(this, aVar).start();
            new b(this, aVar).start();
            e();
            d();
        }
    }

    private boolean b() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f249074f.b(), this.f249074f.d());
        try {
            Socket socket = new Socket();
            this.f249069a = socket;
            socket.setTcpNoDelay(true);
            this.f249069a.setKeepAlive(true);
            this.f249069a.connect(inetSocketAddress, this.f249074f.f());
            this.f249070b = this.f249069a.getOutputStream();
            this.f249071c = this.f249069a.getInputStream();
            this.f249072d.set(true);
            this.f249078j = true;
            this.f249081m = SystemClock.elapsedRealtime();
            QLog.d(f249067q, 1, this.f249084p + " conn " + this.f249074f.b() + ":" + this.f249074f.d() + " succ");
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f249082n = "connFail";
            QLog.d(f249067q, 1, this.f249084p + " conn " + this.f249074f.b() + ":" + this.f249074f.d() + " fail");
            return false;
        }
    }

    private void d() {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_HEARTBEATALIVE);
        toServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
        toServiceMsg.setRequestSsoSeq(this.f249083o.getNextSeq());
        toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
        toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
        a(toServiceMsg);
    }

    private void e() {
        int length = ProcessConstant.MSF.getBytes().length + 13 + 1 + 0 + 4;
        byte length2 = (byte) ProcessConstant.MSF.getBytes().length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).putInt(20140601).putInt(0).put(length2).put(ProcessConstant.MSF.getBytes()).put((byte) 0).putInt(0);
        try {
            a(ProcessConstant.MSF, MsfCommand.msf_ssoping, allocate.array());
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f249074f.b() + "|" + this.f249074f.d() + "|" + this.f249076h + "|" + this.f249077i + "|" + this.f249082n + "|" + this.f249078j + "|" + this.f249079k + "|" + this.f249080l;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a();
            this.f249073e.set(true);
        }
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        try {
            this.f249075g.add(toServiceMsg);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(f249067q, 1, "addSendQueu fail,", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        QLog.d(f249067q, 1, this.f249084p + " closeConn");
        Socket socket = this.f249069a;
        if (socket != null) {
            try {
                try {
                    socket.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                this.f249069a = null;
                this.f249072d.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, MsfCommand msfCommand, byte[] bArr) throws IOException {
        if (msfCommand != MsfCommand.openConn) {
            try {
                this.f249070b.write(bArr);
                this.f249070b.flush();
                QLog.d(f249067q, 1, this.f249084p + " send " + str);
            } catch (Throwable th5) {
                th5.printStackTrace();
                a();
            }
        }
        return bArr.length;
    }
}
