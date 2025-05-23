package com.tencent.mobileqq.richmedia.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LiteTcpConnection implements b {

    /* renamed from: d, reason: collision with root package name */
    private int f281469d;

    /* renamed from: f, reason: collision with root package name */
    private Socket f281471f;

    /* renamed from: g, reason: collision with root package name */
    private OutputStream f281472g;

    /* renamed from: j, reason: collision with root package name */
    private int f281475j;

    /* renamed from: l, reason: collision with root package name */
    private c f281477l;

    /* renamed from: o, reason: collision with root package name */
    private ConnManager f281480o;

    /* renamed from: p, reason: collision with root package name */
    private long f281481p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mobileqq.richmedia.conn.a f281482q;

    /* renamed from: s, reason: collision with root package name */
    private a f281484s;

    /* renamed from: t, reason: collision with root package name */
    private ReadRunnable f281485t;

    /* renamed from: u, reason: collision with root package name */
    private bd f281486u;

    /* renamed from: v, reason: collision with root package name */
    private bc f281487v;

    /* renamed from: a, reason: collision with root package name */
    private ReentrantLock f281466a = new ReentrantLock(true);

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f281467b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f281468c = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private InetSocketAddress f281473h = null;

    /* renamed from: i, reason: collision with root package name */
    private MsfSocketInputBuffer f281474i = null;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f281478m = new AtomicBoolean(false);

    /* renamed from: n, reason: collision with root package name */
    private AtomicBoolean f281479n = new AtomicBoolean(false);

    /* renamed from: w, reason: collision with root package name */
    public long f281488w = 0;

    /* renamed from: k, reason: collision with root package name */
    private d f281476k = new d();

    /* renamed from: e, reason: collision with root package name */
    private int f281470e = 32768;

    /* renamed from: r, reason: collision with root package name */
    private HandlerThread f281483r = ThreadManagerV2.newFreeHandlerThread("SubTitle-CONN", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class ReadRunnable implements Runnable {
        ReadRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MsfSocketInputBuffer msfSocketInputBuffer;
            while (LiteTcpConnection.this.f281479n.get()) {
                try {
                    msfSocketInputBuffer = LiteTcpConnection.this.f281474i;
                    if (msfSocketInputBuffer == null) {
                        return;
                    }
                    while (!msfSocketInputBuffer.isDataAvailable(10000)) {
                        if (!LiteTcpConnection.this.f281479n.get()) {
                            return;
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "read exception " + e16.getMessage() + ";");
                    }
                    LiteTcpConnection.this.m(1);
                }
                if (!LiteTcpConnection.this.f281479n.get()) {
                    return;
                }
                LiteTcpConnection.this.f281476k.b(msfSocketInputBuffer);
                msfSocketInputBuffer.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            if (LiteTcpConnection.this.f281484s != null) {
                LiteTcpConnection.this.f281484s.sendEmptyMessage(3);
            }
        }

        public void b() {
            a aVar = LiteTcpConnection.this.f281484s;
            if (aVar != null) {
                aVar.sendEmptyMessage(2);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                LiteTcpConnection liteTcpConnection = LiteTcpConnection.this;
                liteTcpConnection.p(liteTcpConnection.f281482q);
            } else if (i3 == 2) {
                LiteTcpConnection.this.n();
            } else if (i3 == 3) {
                LiteTcpConnection.this.f281483r.quit();
                LiteTcpConnection.this.f281483r = null;
                LiteTcpConnection.this.f281484s = null;
            }
        }
    }

    public LiteTcpConnection(ConnManager connManager, long j3, com.tencent.mobileqq.richmedia.conn.a aVar, int i3, int i16) {
        this.f281475j = 0;
        this.f281480o = connManager;
        this.f281469d = i16;
        this.f281481p = j3;
        this.f281482q = aVar;
        this.f281475j = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(int i3) {
        c cVar;
        QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn at : ConnId:" + this.f281481p + " Src:" + i3);
        boolean z16 = false;
        this.f281479n.set(false);
        try {
        } catch (InterruptedException e16) {
            e = e16;
        } catch (Exception e17) {
            e = e17;
        }
        if (this.f281471f != null && this.f281467b.get()) {
            if (this.f281466a.tryLock(30000L, TimeUnit.MILLISECONDS)) {
                try {
                    a aVar = this.f281484s;
                    if (aVar != null) {
                        aVar.a();
                    }
                    this.f281474i = null;
                    this.f281472g = null;
                    try {
                        Socket socket = this.f281471f;
                        if (socket != null) {
                            socket.close();
                        }
                    } catch (Exception unused) {
                    }
                    this.f281467b.set(false);
                    this.f281471f = null;
                    if (this.f281486u != null) {
                        this.f281486u = null;
                    }
                    this.f281487v = null;
                    this.f281485t = null;
                    try {
                        z16 = true;
                    } catch (InterruptedException e18) {
                        e = e18;
                        z16 = true;
                        QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn Error.", e);
                        cVar = this.f281477l;
                        if (cVar != null) {
                        }
                        QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn End. connId:" + this.f281481p + " isCloseSuccess:" + z16);
                    } catch (Exception e19) {
                        e = e19;
                        z16 = true;
                        QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn Error.", e);
                        cVar = this.f281477l;
                        if (cVar != null) {
                        }
                        QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn End. connId:" + this.f281481p + " isCloseSuccess:" + z16);
                    }
                } finally {
                    this.f281466a.unlock();
                }
            } else {
                this.f281468c.set(true);
            }
            cVar = this.f281477l;
            if (cVar != null) {
                cVar.b(this.f281481p, this);
            }
            QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "CloseConn End. connId:" + this.f281481p + " isCloseSuccess:" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f281478m.get()) {
            if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "do send data break ");
                return;
            }
            return;
        }
        try {
            this.f281478m.set(true);
            try {
                byte[] g16 = this.f281480o.g();
                if (g16 == null) {
                    this.f281478m.set(false);
                    return;
                }
                OutputStream outputStream = this.f281472g;
                if (outputStream != null) {
                    outputStream.write(g16);
                    outputStream.flush();
                }
                this.f281478m.set(false);
            } catch (Exception unused) {
                this.f281478m.set(false);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "By SendWorker :" + e16.getMessage() + ";");
            }
            m(2);
        }
    }

    private int o(Throwable th5, boolean z16) {
        String lowerCase = th5.toString().toLowerCase();
        if (!z16) {
            return 3;
        }
        if (lowerCase.indexOf("illegal") > -1) {
            return 1;
        }
        if (lowerCase.indexOf("route to host") > -1) {
            return 2;
        }
        if (lowerCase.indexOf("unreachable") > -1) {
            return 3;
        }
        if (lowerCase.indexOf(QCircleDaTongConstant.ElementParamValue.PERMISSION) > -1) {
            return 4;
        }
        if (lowerCase.indexOf("refused") > -1) {
            return 5;
        }
        if (lowerCase.indexOf("reset") > -1) {
            return 6;
        }
        if (lowerCase.indexOf("timeoutexception") > -1 || lowerCase.indexOf(") after") > -1) {
            return 7;
        }
        if (lowerCase.indexOf("unknownhost") > -1) {
            return 8;
        }
        if (lowerCase.indexOf("unresolved") > -1) {
            return 9;
        }
        if (lowerCase.indexOf("enotsock") > -1) {
            return 10;
        }
        if (lowerCase.indexOf("enobufs") > -1) {
            return 11;
        }
        if (lowerCase.indexOf("ebadf") > -1) {
            return 12;
        }
        if (lowerCase.indexOf(QCircleDaTongConstant.ElementParamValue.OPERATION) > -1) {
            return 7;
        }
        if (lowerCase.indexOf(HippyReporter.RemoveEngineReason.INVALID) > -1) {
            return 13;
        }
        return 14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int p(com.tencent.mobileqq.richmedia.conn.a aVar) {
        int i3;
        boolean z16;
        int o16;
        SocketAddress remoteSocketAddress;
        QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "Try openConn : host:" + aVar.f281490d + " port:" + aVar.f281491e + " ConnId:" + this.f281481p);
        boolean z17 = false;
        if ((this.f281468c.get() || this.f281467b.get()) && this.f281468c.get()) {
            this.f281468c.set(false);
            m(2);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            if (this.f281466a.tryLock(30000L, TimeUnit.MILLISECONDS)) {
                long j3 = -1;
                try {
                    this.f281473h = new InetSocketAddress(aVar.f281490d, aVar.f281491e);
                    this.f281467b.set(false);
                    Socket socket = new Socket();
                    this.f281471f = socket;
                    socket.setKeepAlive(true);
                    this.f281471f.setTcpNoDelay(true);
                    this.f281471f.setSoTimeout(this.f281469d);
                    this.f281471f.setSendBufferSize(524288);
                    j3 = SystemClock.uptimeMillis();
                    this.f281471f.connect(this.f281473h, this.f281475j);
                    this.f281488w = SystemClock.uptimeMillis() - j3;
                    this.f281472g = this.f281471f.getOutputStream();
                    this.f281474i = new MsfSocketInputBuffer(this.f281471f, this.f281470e, "US-ASCII", -1);
                    this.f281485t = new ReadRunnable();
                    bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("LiteTcpReadThread", 0);
                    this.f281486u = newHandlerRecycleThread;
                    this.f281487v = newHandlerRecycleThread.b();
                    this.f281479n.set(true);
                    this.f281487v.post(this.f281485t);
                    this.f281467b.set(true);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    StringBuilder sb5 = new StringBuilder("HostInfo");
                    if (this.f281482q.f281490d.contains("htdata") && (remoteSocketAddress = this.f281471f.getRemoteSocketAddress()) != null && (remoteSocketAddress instanceof InetSocketAddress)) {
                        String hostAddress = ((InetSocketAddress) remoteSocketAddress).getAddress().getHostAddress();
                        sb5.append("HostAddr:");
                        sb5.append(hostAddress);
                        sb5.append("-");
                    }
                    try {
                        QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Success at : host:" + aVar.f281490d + " port:" + aVar.f281491e + " ConnId:" + this.f281481p + " ConnectCost:" + j3 + " remoteHost:" + sb5.toString() + " LocalPort:" + this.f281471f.getLocalPort());
                    } catch (Throwable th6) {
                        th = th6;
                        i3 = 0;
                        z17 = true;
                        try {
                            boolean h16 = this.f281480o.h();
                            QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Error : host:" + aVar.f281490d + " port:" + aVar.f281491e + " ConnId:" + this.f281481p + " ConnectCost:" + j3 + " hasNet:" + h16, th);
                            o16 = o(th, h16);
                            try {
                                this.f281466a.unlock();
                                i3 = o16;
                            } catch (InterruptedException e16) {
                                e = e16;
                                i3 = o16;
                                QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Error Interrupted : host:" + aVar.f281490d + " port:" + aVar.f281491e, e);
                                z16 = z17;
                                int i16 = i3;
                                long uptimeMillis2 = SystemClock.uptimeMillis();
                                if (this.f281477l != null) {
                                }
                                if (!z16) {
                                }
                                return i16;
                            }
                            z16 = z17;
                            int i162 = i3;
                            long uptimeMillis22 = SystemClock.uptimeMillis();
                            if (this.f281477l != null) {
                            }
                            if (!z16) {
                            }
                            return i162;
                        } finally {
                            try {
                                this.f281466a.unlock();
                            } catch (InterruptedException e17) {
                                e = e17;
                                QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Error Interrupted : host:" + aVar.f281490d + " port:" + aVar.f281491e, e);
                                z16 = z17;
                                int i1622 = i3;
                                long uptimeMillis222 = SystemClock.uptimeMillis();
                                if (this.f281477l != null) {
                                }
                                if (!z16) {
                                }
                                return i1622;
                            }
                        }
                    }
                    try {
                        i3 = 0;
                        z17 = true;
                    } catch (InterruptedException e18) {
                        i3 = 0;
                        z17 = true;
                        QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Error Interrupted : host:" + aVar.f281490d + " port:" + aVar.f281491e, e);
                        z16 = z17;
                        int i16222 = i3;
                        long uptimeMillis2222 = SystemClock.uptimeMillis();
                        if (this.f281477l != null) {
                        }
                        if (!z16) {
                        }
                        return i16222;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z17 = true;
                    i3 = 14;
                    boolean h162 = this.f281480o.h();
                    QLog.e("PeakAudioTransHandler LiteTcpConnection", 1, "OpenConn Error : host:" + aVar.f281490d + " port:" + aVar.f281491e + " ConnId:" + this.f281481p + " ConnectCost:" + j3 + " hasNet:" + h162, th);
                    o16 = o(th, h162);
                    this.f281466a.unlock();
                    i3 = o16;
                    z16 = z17;
                    int i162222 = i3;
                    long uptimeMillis22222 = SystemClock.uptimeMillis();
                    if (this.f281477l != null) {
                    }
                    if (!z16) {
                    }
                    return i162222;
                }
            } else {
                i3 = 14;
            }
        } catch (InterruptedException e19) {
            e = e19;
            i3 = 14;
        }
        z16 = z17;
        int i1622222 = i3;
        long uptimeMillis222222 = SystemClock.uptimeMillis();
        if (this.f281477l != null) {
            QLog.d("PeakAudioTransHandler LiteTcpConnection", 1, "OnConnectionConnected : ID:" + this.f281481p + " IsSuccess:" + z16 + " SsoSocketConnStat:" + i1622222 + " Conncost:" + (uptimeMillis222222 - uptimeMillis) + " ms");
            this.f281477l.a(z16, this.f281481p, this, this.f281482q, i1622222);
        }
        if (!z16) {
            this.f281484s.b();
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", "" + i1622222);
            hashMap.put("connect_ip", "" + aVar.f281490d);
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubtitleTcpState", true, 0L, 0L, hashMap, null);
            this.f281484s.a();
        }
        return i1622222;
    }

    @Override // com.tencent.mobileqq.richmedia.conn.b
    public void a(c cVar) {
        this.f281477l = cVar;
    }

    @Override // com.tencent.mobileqq.richmedia.conn.b
    public void connect() {
        this.f281483r.start();
        a aVar = new a(this.f281483r.getLooper());
        this.f281484s = aVar;
        aVar.sendEmptyMessage(1);
    }

    @Override // com.tencent.mobileqq.richmedia.conn.b
    public void disConnect() {
        m(3);
    }
}
