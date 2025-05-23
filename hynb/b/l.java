package hynb.b;

import android.content.Context;
import android.text.TextUtils;
import com.huya.huyasdk.data.HYNSRequest;
import com.huya.huyasdk.data.HYNSUserInfo;
import com.huya.huyasdk.data.LongRequest;
import com.huya.huyasdk.data.RegisterResultInfo;
import com.huya.huyasdk.data.ShortRequest;
import com.huya.huyasdk.data.UniPacket;
import com.huya.huyasdk.data.WSConnectParaInfo;
import com.huya.huyasdk.data.WSDeviceInfo;
import com.huya.huyasdk.data.WSHistoryMsgReq;
import com.huya.huyasdk.data.WSLaunchReq;
import com.huya.huyasdk.data.WSLaunchRsq;
import com.huya.huyasdk.data.WSPushMessage;
import com.huya.huyasdk.data.WSRegisterGroupReq;
import com.huya.huyasdk.data.WSUNVerifyReq;
import com.huya.huyasdk.data.WSUnRegisterGroupReq;
import com.huya.huyasdk.data.WSVerifyHuyaTokenReq;
import com.huya.huyasdk.jce.UserId;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l {
    public static Set<f> A = new CopyOnWriteArraySet();
    public static Set<hynb.b.c> B = new CopyOnWriteArraySet();
    public static volatile l C = null;

    /* renamed from: a, reason: collision with root package name */
    public Context f406642a;

    /* renamed from: i, reason: collision with root package name */
    public HYNSUserInfo f406650i;

    /* renamed from: s, reason: collision with root package name */
    public TimerTask f406660s;

    /* renamed from: t, reason: collision with root package name */
    public Timer f406661t;

    /* renamed from: u, reason: collision with root package name */
    public hynb.c.a f406662u;

    /* renamed from: b, reason: collision with root package name */
    public boolean f406643b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f406644c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f406645d = false;

    /* renamed from: e, reason: collision with root package name */
    public long f406646e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f406647f = "huya&CN&2052";

    /* renamed from: g, reason: collision with root package name */
    public String f406648g = "adr&1.0.0&huawei&28";

    /* renamed from: h, reason: collision with root package name */
    public boolean f406649h = true;

    /* renamed from: j, reason: collision with root package name */
    public volatile long f406651j = 0;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f406652k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f406653l = 0;

    /* renamed from: m, reason: collision with root package name */
    public Set<LongRequest> f406654m = new CopyOnWriteArraySet();

    /* renamed from: n, reason: collision with root package name */
    public final Map<Integer, ArrayList<String>> f406655n = new ConcurrentHashMap();

    /* renamed from: o, reason: collision with root package name */
    public final Map<String, hynb.b.a> f406656o = new ConcurrentHashMap();

    /* renamed from: p, reason: collision with root package name */
    public final Map<String, hynb.b.b> f406657p = new ConcurrentHashMap();

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f406658q = false;

    /* renamed from: r, reason: collision with root package name */
    public volatile UserId f406659r = null;

    /* renamed from: v, reason: collision with root package name */
    public String f406663v = "";

    /* renamed from: w, reason: collision with root package name */
    public Map<String, m> f406664w = new ConcurrentHashMap();

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f406665x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f406666y = false;

    /* renamed from: z, reason: collision with root package name */
    public n f406667z = new n(10, 1000);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            l.this.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements e {
        public c() {
        }

        @Override // hynb.b.e
        public void a(String str, String str2) {
            l.this.f406665x = false;
            m mVar = (m) l.this.f406664w.remove(str2);
            if (mVar != null) {
                hynb.p.g.f406799a.a("HuyaNetService", "onFailed retCode: " + str + " ,mRetry: " + l.this.f406653l + " ,remove webSocketClient: " + mVar);
            } else {
                hynb.p.g.f406799a.a("HuyaNetService", "onFailed retCode: " + str + " ,mRetry: " + l.this.f406653l);
            }
            l.m(l.this);
            l.this.a(r6.f406653l * 1500);
        }

        @Override // hynb.b.e
        public void b(String str) {
            hynb.p.g.f406799a.debug("HuyaNetService", "onSuccess rsp: " + str);
        }

        @Override // hynb.b.e
        public void c(int i3) {
            hynb.p.g.f406799a.a("HuyaNetService", "onRegisterGroupFailed() lRequestId:" + i3);
            ArrayList arrayList = (ArrayList) l.this.f406655n.remove(Integer.valueOf(i3));
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                hynb.b.a aVar = (hynb.b.a) l.this.f406656o.get(str);
                if (aVar != null && !aVar.f406617b) {
                    g a16 = aVar.a();
                    if (a16 != null) {
                        a16.b(new RegisterResultInfo(str, 1, ""));
                    }
                    aVar.a(true);
                }
            }
        }

        @Override // hynb.b.e
        public void d(int i3) {
            hynb.p.g.f406799a.a("HuyaNetService", "onRegisterGroupSuccess() lRequestId:" + i3);
            ArrayList arrayList = (ArrayList) l.this.f406655n.remove(Integer.valueOf(i3));
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                hynb.b.a aVar = (hynb.b.a) l.this.f406656o.get(str);
                if (aVar != null && !aVar.f406617b) {
                    g a16 = aVar.a();
                    if (a16 != null) {
                        a16.a(new RegisterResultInfo(str, 0, ""));
                    }
                    aVar.a(true);
                }
            }
        }

        @Override // hynb.b.e
        public void b(int i3) {
            hynb.p.g.f406799a.a("HuyaNetService", "onUnRegisterGroupSuccess() lRequestId:" + i3);
            ArrayList arrayList = (ArrayList) l.this.f406655n.remove(Integer.valueOf(i3));
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                hynb.b.b bVar = (hynb.b.b) l.this.f406657p.remove(str);
                if (bVar != null && !bVar.f406619b) {
                    i a16 = bVar.a();
                    if (a16 != null) {
                        a16.a(new RegisterResultInfo(str, 0, ""));
                    }
                    bVar.a(true);
                }
            }
        }

        @Override // hynb.b.e
        public void a(String str) {
            l.this.f406665x = false;
            m mVar = (m) l.this.f406664w.remove(str);
            if (mVar != null) {
                hynb.p.g.f406799a.a("HuyaNetService", "onClosed remove webSocketClient: " + mVar);
                return;
            }
            hynb.p.g.f406799a.info("HuyaNetService", "onClosed");
        }

        @Override // hynb.b.e
        public void a(m mVar, String str) {
            if (mVar == null || str == null) {
                return;
            }
            hynb.p.g.f406799a.a("HuyaNetService", "onOpen linkName: " + str + ", webSocketClient: " + mVar + ", mRetry:" + l.this.f406653l);
            l.this.f406666y = true;
            l.this.f406664w.put(str, mVar);
            if (!l.this.k().isEmpty()) {
                l lVar = l.this;
                lVar.a((List<String>) lVar.k());
                l lVar2 = l.this;
                lVar2.a(lVar2.k());
            }
            if (l.this.f406658q) {
                l lVar3 = l.this;
                lVar3.b(lVar3.f406659r);
            }
            Iterator it = l.this.f406654m.iterator();
            while (it.hasNext()) {
                l.this.j().b((LongRequest) it.next());
            }
            l.this.f406654m.clear();
        }

        @Override // hynb.b.e
        public void a(int i3) {
            hynb.p.g.f406799a.a("HuyaNetService", "onUnRegisterGroupFailed() lRequestId:" + i3);
            ArrayList arrayList = (ArrayList) l.this.f406655n.remove(Integer.valueOf(i3));
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                hynb.b.b bVar = (hynb.b.b) l.this.f406657p.remove(str);
                if (bVar != null && !bVar.f406619b) {
                    i a16 = bVar.a();
                    if (a16 != null) {
                        a16.b(new RegisterResultInfo(str, 1, ""));
                    }
                    bVar.a(true);
                }
            }
        }

        @Override // hynb.b.e
        public void a(WSPushMessage wSPushMessage) {
            l.this.f406651j = wSPushMessage.lMsgId.longValue();
            if (!l.this.a(wSPushMessage)) {
                hynb.p.g.f406799a.info("HuyaNetService", String.format("onPushMessage msg is inValid, %s", wSPushMessage));
                return;
            }
            hynb.p.g.f406799a.info("HuyaNetService", String.format("onPushMessage msg is Valid, mLastMsgId=%s", Long.valueOf(l.this.f406651j)));
            for (f fVar : l.A) {
                if (fVar != null) {
                    fVar.a(wSPushMessage);
                }
            }
        }

        @Override // hynb.b.e
        public void a() {
            hynb.p.g.f406799a.info("HuyaNetService", "onVerifySucceed");
            l.this.a((ArrayList<String>) null);
        }
    }

    public static /* synthetic */ int m(l lVar) {
        int i3 = lVar.f406653l;
        lVar.f406653l = i3 + 1;
        return i3;
    }

    public String n() {
        return this.f406648g;
    }

    public boolean o() {
        return this.f406649h;
    }

    public boolean p() {
        return this.f406644c;
    }

    public boolean q() {
        return this.f406665x;
    }

    public boolean r() {
        return this.f406666y;
    }

    public final void s() {
        this.f406660s = new a();
    }

    public synchronized void t() {
        boolean z16;
        String g16 = g();
        if (!TextUtils.isEmpty(g16)) {
            hynb.p.g.f406799a.info("HuyaNetService", "Guid loadCache " + g16);
            return;
        }
        if (!this.f406652k) {
            this.f406652k = true;
        }
        hynb.p.e eVar = hynb.p.g.f406799a;
        eVar.debug("HuyaNetService", "queryGuid ......");
        WSLaunchReq wSLaunchReq = new WSLaunchReq();
        wSLaunchReq.lUid = Long.valueOf(m());
        wSLaunchReq.sGuid = hynb.o.b.e().d();
        wSLaunchReq.sUA = n();
        wSLaunchReq.sAppSrc = e();
        WSDeviceInfo wSDeviceInfo = new WSDeviceInfo();
        hynb.c.a aVar = this.f406662u;
        if (aVar != null && aVar.isForeGround()) {
            eVar.info("HuyaNetService", "To getMid when queryGuid in the ForeGround");
            wSDeviceInfo.sMId = hynb.o.b.e().f();
        } else {
            Object[] objArr = new Object[1];
            if (this.f406662u == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            eVar.a("HuyaNetService", "not to getMid, mForeGroundApi is null ? %s ", objArr);
        }
        wSLaunchReq.tDeviceInfo = wSDeviceInfo;
        b(new HYNSRequest.Builder().sServantName("launch").sFuncName("wsLaunch").channel(1).jsonBodyObj(wSLaunchReq).build(), new b());
    }

    public final void u() {
        if (j() == null) {
            c();
        }
        b();
    }

    public static l i() {
        if (C == null) {
            synchronized (l.class) {
                if (C == null) {
                    C = new l();
                }
            }
        }
        return C;
    }

    public void c(long j3) {
        b(j3);
    }

    public void d() {
        if (j() != null) {
            j().b();
        }
    }

    public String e() {
        return this.f406647f;
    }

    public String f() {
        return this.f406663v;
    }

    public String g() {
        return hynb.o.b.e().d();
    }

    public final String h() {
        String a16;
        if (this.f406643b) {
            a16 = "testws.va.huya.com";
        } else {
            a16 = j.a().a("cdnws.api.huya.com", true);
            if (TextUtils.isEmpty(a16)) {
                a16 = "wsapi.huya.com";
            }
        }
        hynb.p.g.f406799a.info("HuyaNetService", "getHostOrIp result: " + a16 + ", mIsTestEvn: " + this.f406643b);
        return a16;
    }

    public final m j() {
        return this.f406664w.get("push");
    }

    public ArrayList<String> k() {
        return new ArrayList<>(this.f406656o.keySet());
    }

    public final String l() {
        String str;
        boolean z16 = this.f406644c;
        String a16 = a(z16 ? "wss" : "ws", z16 ? "443" : "80", "json_push");
        WSConnectParaInfo wSConnectParaInfo = new WSConnectParaInfo();
        wSConnectParaInfo.lUid = Long.valueOf(m());
        wSConnectParaInfo.sGuid = g();
        wSConnectParaInfo.sUA = n();
        wSConnectParaInfo.sAppSrc = e();
        HYNSUserInfo hYNSUserInfo = this.f406650i;
        if (hYNSUserInfo != null) {
            wSConnectParaInfo.sToken = hYNSUserInfo.udbToken;
        }
        wSConnectParaInfo.mCustomHeaders = new HashMap();
        String a17 = hynb.o.c.a(wSConnectParaInfo);
        try {
            str = URLEncoder.encode(hynb.o.a.b(a17.getBytes()), StandardCharsets.UTF_8.toString());
        } catch (Throwable th5) {
            hynb.p.g.f406799a.a("HuyaNetService", "wsConnectParaInfo URL \u7f16\u7801 fail! ", th5);
            str = null;
        }
        String format = String.format("%s?BASEINFO=%s", a16, str);
        if (str != null) {
            a16 = format;
        }
        hynb.p.g.f406799a.a("HuyaNetService", "getURL finalURL: " + a16 + ", original wsConnectParaInfoStr:" + a17);
        return a16;
    }

    public long m() {
        return this.f406646e;
    }

    public void c(String str) {
        this.f406648g = str;
    }

    public synchronized void c() {
        if (this.f406665x) {
            hynb.p.g.f406799a.info("HuyaNetService", "PushLongLink is created!");
            return;
        }
        this.f406665x = true;
        m mVar = new m("push");
        hynb.p.g.f406799a.a("HuyaNetService", "new webSocketClient: " + mVar);
        mVar.a(l(), new c());
    }

    public final synchronized void b() {
        Timer timer = this.f406661t;
        if (timer != null) {
            timer.cancel();
            this.f406661t = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements h<WSLaunchRsq> {
        public b() {
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(WSLaunchRsq wSLaunchRsq) {
            if (wSLaunchRsq != null) {
                String str = wSLaunchRsq.sGuid;
                l.this.f406663v = wSLaunchRsq.sClientIp;
                if (hynb.o.b.e().a(str) && !str.equals(hynb.o.b.e().d())) {
                    l.this.a(str);
                } else {
                    hynb.p.g.f406799a.c("HuyaNetService", "onResponse guid, rspGuid: %s, clientIP:%s", str, l.this.f406663v);
                }
            }
        }

        @Override // hynb.b.h
        public Class<WSLaunchRsq> getResponseClass() {
            return WSLaunchRsq.class;
        }

        @Override // hynb.b.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WSLaunchRsq wSLaunchRsq) {
            hynb.p.g.f406799a.error("HuyaNetService", String.format("queryGuid onError retValue: %s, errMsg: %s, rsp: %s", Integer.valueOf(i3), str, wSLaunchRsq));
        }
    }

    public void b(long j3) {
        this.f406646e = j3;
    }

    public final synchronized void a(long j3) {
        if (this.f406661t == null) {
            this.f406661t = new BaseTimer("HuyaNetService");
        }
        s();
        this.f406661t.schedule(this.f406660s, j3);
    }

    public void b(String str) {
        this.f406647f = str;
    }

    public void b(boolean z16) {
        this.f406643b = z16;
    }

    public void c(HYNSRequest hYNSRequest, h hVar) {
        Object[] objArr = new Object[3];
        boolean z16 = this.f406644c;
        objArr[0] = z16 ? "https" : "http";
        objArr[1] = this.f406643b ? "testws.va.huya.com" : "wsapi.huya.com";
        objArr[2] = z16 ? "443" : "80";
        new k().a(String.format("%s://%s:%s/json", objArr), new ShortRequest.Builder().sServantName(hYNSRequest.sServantName).sFuncName(hYNSRequest.sFuncName).sBuffer(hYNSRequest.jsonBody).build().toJsonString(), hVar, o() ? hYNSRequest.encryptOption : 0);
    }

    public void b(UserId userId) {
        this.f406658q = true;
        this.f406659r = userId;
        if (j() != null) {
            WSVerifyHuyaTokenReq wSVerifyHuyaTokenReq = new WSVerifyHuyaTokenReq();
            wSVerifyHuyaTokenReq.bAutoRegisterUid = 1;
            wSVerifyHuyaTokenReq.sAppSrc = e();
            wSVerifyHuyaTokenReq.tId = userId;
            j().b(new LongRequest.Builder().iCmdType(12).sDataObj(wSVerifyHuyaTokenReq).iEncryptType(o() ? 1 : 0).build());
            return;
        }
        a(0L);
    }

    public void a(Context context) {
        this.f406642a = context;
    }

    public void a(boolean z16) {
        this.f406649h = z16;
        hynb.p.g.f406799a.a("HuyaNetService", String.format("enableEncrypt: %s", Boolean.valueOf(z16)));
    }

    public void a(hynb.b.c cVar) {
        B.add(cVar);
        if (TextUtils.isEmpty(g())) {
            t();
        } else {
            if (TextUtils.isEmpty(g()) || cVar == null) {
                return;
            }
            cVar.a(g());
            hynb.p.g.f406799a.debug("HuyaNetService", String.format("addGuidListener callback : %s, guid: %s", cVar, g()));
        }
    }

    public void b(f fVar) {
        A.remove(fVar);
    }

    public void b(HYNSRequest hYNSRequest, h hVar) {
        int i3 = hYNSRequest.channel;
        if (i3 == 1 || i3 == 3) {
            c(hYNSRequest, hVar);
        } else if (i3 == 2) {
            a(hYNSRequest, hVar);
        }
    }

    public final void a(String str) {
        hynb.p.g.f406799a.c("HuyaNetService", "guid change, last: %s, new_guid: %s, clientIP:%s", hynb.o.b.e().d(), str, f());
        hynb.o.b.e().b(str);
        for (hynb.b.c cVar : B) {
            if (cVar != null) {
                cVar.a(str);
                hynb.p.g.f406799a.debug("HuyaNetService", String.format("notifyGuidChange callback : %s, guid: %s", cVar, str));
            }
        }
    }

    public void a(UserId userId) {
        this.f406658q = false;
        this.f406659r = null;
        if (j() != null) {
            WSUNVerifyReq wSUNVerifyReq = new WSUNVerifyReq();
            wSUNVerifyReq.tId = userId;
            j().b(new LongRequest.Builder().iCmdType(14).sDataObj(wSUNVerifyReq).iEncryptType(o() ? 1 : 0).build());
        }
    }

    public void a(f fVar) {
        A.add(fVar);
    }

    public void a(hynb.c.a aVar) {
        if (this.f406645d) {
            c();
        }
        this.f406662u = aVar;
        hynb.o.b.e().d(this.f406642a);
        t();
        j.a().a(this.f406648g);
    }

    public final boolean a(WSPushMessage wSPushMessage) {
        return a(wSPushMessage.lMsgId, this.f406667z);
    }

    public final boolean a(Long l3, n nVar) {
        if (l3.longValue() == 0) {
            hynb.p.g.f406799a.info("HuyaNetService", "add Msg server id=0, return");
            return true;
        }
        return nVar.a(l3.longValue());
    }

    public final void a(ArrayList<String> arrayList) {
        if (this.f406651j <= 0) {
            hynb.p.g.f406799a.info("HuyaNetService", "requestHistoryMsg return. mLastMsgIdForQuery is <= 0. mLastMsgId: " + this.f406651j);
            return;
        }
        long m3 = i().m();
        if ((arrayList == null || arrayList.size() == 0) && m3 <= 0) {
            hynb.p.g.f406799a.info("HuyaNetService", "requestHistoryMsg return. vGroupId is empty and not login");
            return;
        }
        WSHistoryMsgReq wSHistoryMsgReq = new WSHistoryMsgReq();
        wSHistoryMsgReq.lUid = Long.valueOf(m3);
        wSHistoryMsgReq.vGroupId = arrayList;
        wSHistoryMsgReq.lLastMsgId = Long.valueOf(this.f406651j);
        hynb.p.g.f406799a.debug("HuyaNetService", "requestHistory :" + hynb.o.c.a(wSHistoryMsgReq));
        LongRequest build = new LongRequest.Builder().iCmdType(25).sDataObj(wSHistoryMsgReq).iEncryptType(o() ? 1 : 0).build();
        if (j() != null) {
            j().b(build);
        }
    }

    public void a(List<String> list, g gVar) {
        for (String str : list) {
            if (!this.f406656o.containsKey(str)) {
                this.f406656o.put(str, new hynb.b.a(gVar));
            }
        }
        a(list);
    }

    public final void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(list);
        WSRegisterGroupReq wSRegisterGroupReq = new WSRegisterGroupReq();
        wSRegisterGroupReq.vGroupId = arrayList;
        LongRequest build = new LongRequest.Builder().iCmdType(16).sDataObj(wSRegisterGroupReq).iEncryptType(o() ? 1 : 0).build();
        this.f406655n.put(Integer.valueOf(build.getLRequestId()), arrayList);
        if (j() != null) {
            j().b(build);
        } else {
            a(0L);
        }
    }

    public void a(List<String> list, i iVar) {
        for (String str : list) {
            this.f406656o.remove(str);
            if (!this.f406657p.containsKey(str)) {
                this.f406657p.put(str, new hynb.b.b(iVar));
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(list);
        WSUnRegisterGroupReq wSUnRegisterGroupReq = new WSUnRegisterGroupReq();
        wSUnRegisterGroupReq.vGroupId = arrayList;
        LongRequest build = new LongRequest.Builder().iCmdType(18).sDataObj(wSUnRegisterGroupReq).iEncryptType(o() ? 1 : 0).build();
        this.f406655n.put(Integer.valueOf(build.getLRequestId()), arrayList);
        if (j() != null) {
            j().b(build);
        }
    }

    public void a(HYNSUserInfo hYNSUserInfo) {
        this.f406650i = hYNSUserInfo;
    }

    public final void a(HYNSRequest hYNSRequest, h hVar) {
        UniPacket uniPacket = new UniPacket();
        uniPacket.sFuncName = hYNSRequest.sFuncName;
        uniPacket.sServantName = hYNSRequest.sServantName;
        uniPacket.sBuffer = hYNSRequest.jsonBody;
        LongRequest build = new LongRequest.Builder().iCmdType(hYNSRequest.iCmdType).sData(hynb.o.c.a(uniPacket)).iEncryptType(o() ? hYNSRequest.encryptOption : 0).build();
        if (j() != null) {
            j().b(build);
        } else {
            this.f406654m.add(build);
            a(0L);
        }
    }

    public final String a(String str, String str2, String str3) {
        return String.format("%s://%s:%s/%s", str, h(), str2, str3);
    }
}
