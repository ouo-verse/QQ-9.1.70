package d;

import android.os.SystemClock;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.i0.c.a;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.q;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes.dex */
public class a extends d.b implements a.InterfaceC8083a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f392522e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f392523f = false;

    /* renamed from: g, reason: collision with root package name */
    public static int f392524g;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f392525a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.i0.c.a f392526b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f392527c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.y.d f392528d;

    /* compiled from: P */
    /* renamed from: d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C10147a implements com.tencent.mobileqq.msf.core.y.d {
        C10147a() {
        }

        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOff() {
            if (a.this.f392525a.get() && a.this.f392526b != null) {
                try {
                    a.this.f392526b.c();
                } catch (Exception e16) {
                    QLog.w("ConnQualityStat", 1, "onScreenOff", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.core.y.d
        public void onScreenOn() {
            boolean isScreenOn = MsfSdkUtils.isScreenOn();
            if (a.this.f392525a.get() && a.this.f392526b != null) {
                try {
                    a.this.f392526b.a(isScreenOn);
                } catch (Exception e16) {
                    QLog.w("ConnQualityStat", 1, "onScreenOn", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b extends j.d {

        /* renamed from: i, reason: collision with root package name */
        volatile AtomicBoolean f392530i = new AtomicBoolean(false);

        /* renamed from: j, reason: collision with root package name */
        private long f392531j = 0;

        /* renamed from: k, reason: collision with root package name */
        private int f392532k = 0;

        /* renamed from: l, reason: collision with root package name */
        private HashMap<String, Integer> f392533l = null;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: d.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C10148a {

            /* renamed from: a, reason: collision with root package name */
            private static final b f392534a = new b();
        }

        public static b c() {
            return C10148a.f392534a;
        }

        private void d() {
            a("closeConnCount", String.valueOf(this.f392532k));
            a("closeConnReason", String.valueOf(this.f392533l.keySet()));
            a("msf.event.freqCloseConn", true, 0L, this.f392532k);
        }

        public void b(com.tencent.qphone.base.a aVar) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f392530i.compareAndSet(false, true)) {
                String str = aVar.toString();
                if (this.f392533l == null) {
                    this.f392533l = new HashMap<>();
                }
                if (currentTimeMillis - this.f392531j > MiniBoxNoticeInfo.MIN_5) {
                    if (this.f392532k > 10) {
                        d();
                        QLog.d("freqCloseConn", 1, "closeConnCount:" + this.f392532k + " ,reasonMap:" + this.f392533l.keySet());
                    }
                    this.f392532k = 1;
                    this.f392531j = currentTimeMillis;
                    this.f392533l.clear();
                    this.f392533l.put(str, 1);
                } else {
                    this.f392532k++;
                    if (this.f392533l.containsKey(str) && this.f392533l.get(str) != null) {
                        HashMap<String, Integer> hashMap = this.f392533l;
                        hashMap.put(str, Integer.valueOf(hashMap.get(str).intValue() + 1));
                    } else {
                        this.f392533l.put(str, 1);
                    }
                }
                this.f392530i.set(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        private com.tencent.mobileqq.msf.core.d f392536b;

        /* renamed from: a, reason: collision with root package name */
        private boolean f392535a = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f392537c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: d.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C10149a {

            /* renamed from: a, reason: collision with root package name */
            private static final c f392538a = new c();
        }

        public static c a() {
            return C10149a.f392538a;
        }

        public void b(boolean z16) {
            com.tencent.mobileqq.msf.core.d dVar;
            this.f392535a = z16;
            if (!z16) {
                a.f392523f = false;
            }
            if (z16 && (dVar = this.f392536b) != null && k.a(dVar)) {
                a.f392523f = true;
            }
        }

        public void c(boolean z16, com.tencent.mobileqq.msf.core.d dVar) {
            this.f392535a = z16;
            this.f392536b = dVar;
            this.f392537c = false;
            a.f392523f = false;
        }

        public void d() {
            com.tencent.mobileqq.msf.core.d dVar;
            int i3;
            if (this.f392535a && (dVar = this.f392536b) != null) {
                if (com.tencent.mobileqq.msf.core.d.f247921x.equals(dVar.f247935l)) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (k.a(this.f392536b)) {
                    a.f392523f = true;
                    QLog.i("ConnQualityStat", 1, "conn is cross oper!!! " + this.f392536b.toString());
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().e()));
                    hashMap.put("netType", String.valueOf(i3));
                    hashMap.put(TtmlNode.TAG_REGION, this.f392536b.f247936m);
                    hashMap.put("oper", this.f392536b.f247937n);
                    hashMap.put("vip", this.f392536b.b());
                    hashMap.put("uintime", String.valueOf(MsfCore.sCore.getAccountCenter().e() + "_" + i3 + "_" + System.currentTimeMillis()));
                    if (MsfService.getCore().getStatReporter() != null) {
                        MsfService.getCore().getStatReporter().a(g.G2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class d extends j.d {
        d() {
        }

        public void b(long j3) {
            if (j3 > 0) {
                a(g.f247769x2, true, j3, 0L);
            }
        }
    }

    a(com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f392525a = atomicBoolean;
        this.f392526b = null;
        C10147a c10147a = new C10147a();
        this.f392528d = c10147a;
        this.f392527c = aVar;
        com.tencent.mobileqq.msf.core.y.a.h().a(c10147a);
        atomicBoolean.set(com.tencent.mobileqq.msf.core.i0.a.v().w());
        if (atomicBoolean.get()) {
            if ((!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !com.tencent.mobileqq.msf.core.i0.a.v().r()) || com.tencent.mobileqq.msf.core.i0.a.v().o()) {
                this.f392526b = new com.tencent.mobileqq.msf.core.i0.c.b(aVar);
            } else {
                this.f392526b = new w(aVar);
            }
            this.f392526b.a(this);
            return;
        }
        QLog.d("ConnQualityStat", 1, "weakNetDetectEnable =" + atomicBoolean.get());
    }

    public static a c(com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        if (f392522e == null) {
            synchronized (a.class) {
                if (f392522e == null) {
                    f392522e = new a(aVar);
                }
            }
        }
        return f392522e;
    }

    public void d() {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            aVar.b();
        }
        c.a().b(false);
    }

    public void e(int i3, long j3, q qVar) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.a(i3, j3, qVar);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onConnOpenFailed", e16);
            }
        }
        c.a().b(false);
    }

    public void f(long j3, long j16) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.a(j3, j16, false);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onPingRecved", e16);
            }
        }
    }

    public void g(com.tencent.qphone.base.a aVar) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar2;
        if (this.f392525a.get() && (aVar2 = this.f392526b) != null) {
            try {
                aVar2.a(aVar);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onConnClose", e16);
            }
        }
        c.a().b(false);
    }

    public void h(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.a(toServiceMsg);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onPingRecved", e16);
            }
        }
    }

    public void i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null && toServiceMsg != null && fromServiceMsg != null) {
            try {
                aVar.a(fromServiceMsg.getRequestSsoSeq());
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onPingRecved", e16);
            }
        }
    }

    public void j(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.a(toServiceMsg, fromServiceMsg, dVar);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onQuickSendResp", e16);
            }
        }
    }

    public void k(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, int i3) {
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            fromServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, Boolean.valueOf(f392523f));
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConnQualityStat", 2, "onRecvSendChatMsgResp ssoReq=" + fromServiceMsg.getRequestSsoSeq() + " weaknet=" + o() + " cross=" + f392523f + " xgSent=" + ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.FALSE)).booleanValue());
        }
        if (toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET_BOOT)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_BOOT, 0L)).longValue();
            if (elapsedRealtime > 0) {
                MsfCore.sCore.getStatReporter().a(elapsedRealtime);
            }
        }
        if (this.f392525a.get() && this.f392526b != null) {
            try {
                synchronized (this) {
                    this.f392526b.a(toServiceMsg, fromServiceMsg, z16, 0);
                }
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onRecvSendChatMsgResp", e16);
            }
        }
    }

    public void l(Socket socket, int i3, int i16) {
        if (this.f392525a.get() && this.f392526b != null) {
            try {
                if (NetConnInfoCenter.isWifiConn()) {
                    this.f392526b.b(socket, i16);
                } else {
                    this.f392526b.a(socket, i16);
                }
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onConnOpened", e16);
            }
        }
        if (MsfService.serviceInitStart > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ConnQualityStat", 2, "onConnOpened netType: " + i3 + " serviceInit: " + MsfService.serviceInitStart + " cost:" + (SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
            }
            d dVar = new d();
            dVar.a("netType", String.valueOf(i3));
            dVar.a(QCircleWeakNetReporter.KEY_COST, String.valueOf(SystemClock.elapsedRealtime() - MsfService.serviceInitStart));
            dVar.b(SystemClock.elapsedRealtime() - MsfService.serviceInitStart);
            MsfService.serviceInitStart = 0L;
        }
    }

    public void m(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.b(toServiceMsg);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onPingSent", e16);
            }
        }
    }

    public void n(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (!fromServiceMsg.getMsfCommand().equals(MsfCommand._msf_HeartbeatAlive) && !fromServiceMsg.getMsfCommand().equals(MsfCommand._msf_QuickHeartBeat)) {
            if (this.f392525a.get() && (aVar = this.f392526b) != null) {
                try {
                    aVar.a(toServiceMsg, fromServiceMsg);
                    return;
                } catch (Exception e16) {
                    QLog.w("ConnQualityStat", 1, "onRecvRespPkg", e16);
                    return;
                }
            }
            return;
        }
        i(toServiceMsg, fromServiceMsg);
    }

    public boolean o() {
        if (this.f392526b != null && this.f392525a.get()) {
            return this.f392526b.a();
        }
        return false;
    }

    public void p(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.d(toServiceMsg);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onSendChatMsg", e16);
            }
        }
    }

    public void q(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (toServiceMsg != null && toServiceMsg.isNeedCallback() && !BaseConstants.CMD_SSO_LOGIN_MERGE.equals(toServiceMsg.getServiceCmd())) {
            f392524g++;
        }
        if (toServiceMsg != null && (toServiceMsg.getMsfCommand().equals(MsfCommand._msf_HeartbeatAlive) || toServiceMsg.getMsfCommand().equals(MsfCommand._msf_QuickHeartBeat))) {
            h(toServiceMsg);
            return;
        }
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.e(toServiceMsg);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onSendReqPkg", e16);
            }
        }
    }

    public void r(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.i0.c.a aVar;
        if (this.f392525a.get() && (aVar = this.f392526b) != null) {
            try {
                aVar.c(toServiceMsg);
            } catch (Exception e16) {
                QLog.w("ConnQualityStat", 1, "onQuickSendReqBefore", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a.InterfaceC8083a
    public void onNormalToWeakNet(int i3) {
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a.InterfaceC8083a
    public void onWeakNetToNormal(int i3) {
    }
}
