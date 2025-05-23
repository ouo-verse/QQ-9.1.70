package com.tencent.mobileqq.msf.core.quic;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    public static final String f249815c = "QuicContext";

    /* renamed from: d, reason: collision with root package name */
    public static final int f249816d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249817e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249818f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249819g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249820h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249821i = -3;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249822j = -3;

    /* renamed from: k, reason: collision with root package name */
    public static final int f249823k = -3;

    /* renamed from: l, reason: collision with root package name */
    public static final int f249824l = -2;

    /* renamed from: m, reason: collision with root package name */
    public static final int f249825m = -1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f249826n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static final int f249827o = -1;

    /* renamed from: p, reason: collision with root package name */
    public static final int f249828p = -2;

    /* renamed from: q, reason: collision with root package name */
    public static final int f249829q = -3;

    /* renamed from: r, reason: collision with root package name */
    public static final int f249830r = -100;

    /* renamed from: s, reason: collision with root package name */
    public static final int f249831s = -101;

    /* renamed from: t, reason: collision with root package name */
    public static final int f249832t = -102;

    /* renamed from: u, reason: collision with root package name */
    public static final int f249833u = -103;

    /* renamed from: v, reason: collision with root package name */
    public static final int f249834v = -104;

    /* renamed from: w, reason: collision with root package name */
    public static final int f249835w = -105;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f249836x = false;

    /* renamed from: a, reason: collision with root package name */
    private long f249837a;

    /* renamed from: b, reason: collision with root package name */
    private b f249838b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        }
    }

    public a() {
        this(new b());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private boolean b() {
        boolean initialize = QuicWrapper.initialize(this.f249837a);
        if (initialize) {
            f249836x = initialize;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "initialized ret=" + initialize);
        }
        return f249836x;
    }

    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        long createSyncClient = QuicWrapper.createSyncClient(this.f249837a, false, false);
        if (createSyncClient < 0) {
            QLog.i(f249815c, 1, "create syncNetClient failed, quicContext=" + Integer.toHexString(hashCode()) + " clientHandle=" + createSyncClient);
        } else if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "create syncNetClient from quicContext=" + Integer.toHexString(hashCode()) + " clientHandle=" + createSyncClient);
        }
        return createSyncClient;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QuicWrapper.releaseQuicContext(this.f249837a);
        this.f249837a = 0L;
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "releaseQuicContext");
        }
    }

    public a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        this.f249838b = bVar;
        this.f249837a = QuicWrapper.createQuicContext(bVar);
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "create quicContext " + Integer.toHexString(hashCode()) + " contextHanlde=" + Long.toHexString(this.f249837a));
        }
        b();
    }

    public boolean a(long j3, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (j3 < 0) {
            QLog.i(f249815c, 1, "clientHandle=" + j3 + " error");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore != null && msfCore.mMsfMonitorCallback != null && !TextUtils.isEmpty(name) && name.contains(q.f249791f)) {
            MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
        }
        int connect = QuicWrapper.connect(j3, str, i3, i16);
        MsfCore msfCore2 = MsfCore.sCore;
        if (msfCore2 != null && msfCore2.mMsfMonitorCallback != null && !TextUtils.isEmpty(name) && name.contains(q.f249791f)) {
            MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "connect " + str + ":" + i3 + " ret=" + connect + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return connect == 0;
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        if (j3 < 0) {
            QLog.i(f249815c, 1, "clientHandle=" + j3 + " error");
            return;
        }
        QuicWrapper.releaseSyncClient(this.f249837a, j3);
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "releaseSyncClient contextHandle=" + Long.toHexString(this.f249837a) + " clientHandle=" + Long.toHexString(j3));
        }
    }

    public QuicWrapper.QuicBundle a(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QuicWrapper.QuicBundle) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (j3 >= 0 && i3 > 0) {
            QuicWrapper.QuicBundle recv = QuicWrapper.recv(j3, i3, i16);
            if (QLog.isDevelopLevel()) {
                QLog.d(f249815c, 4, "clientHandle=" + j3 + " retcode=" + recv.retcode + " recv data_len=" + recv.data_len);
            }
            return recv;
        }
        QLog.i(f249815c, 1, "clientHandle=" + j3 + " recvLen=" + i3 + " error");
        return null;
    }

    public int a(long j3, byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (j3 < 0) {
            QLog.i(f249815c, 1, "clientHandle=" + j3 + " error");
            return -1;
        }
        int send = QuicWrapper.send(j3, bArr, i3, i16);
        if (QLog.isDevelopLevel()) {
            QLog.d(f249815c, 4, "clientHandle=" + j3 + " send len=" + i3 + " timeout=" + i16 + " n=" + send);
        }
        return send;
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        if (j3 < 0) {
            QLog.i(f249815c, 1, "clientHandle=" + Long.toHexString(j3) + " error");
            return;
        }
        QuicWrapper.closeConn(j3);
        if (QLog.isColorLevel()) {
            QLog.d(f249815c, 2, "closeConn clientHandle=" + Long.toHexString(j3));
        }
    }
}
