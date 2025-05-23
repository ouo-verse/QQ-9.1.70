package com.tencent.biz.pubaccount.weishi.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGrayPolicyInfo;
import com.tencent.biz.pubaccount.weishi.event.WSExpEvent;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes32.dex */
public class WSExpPolicyManager {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, d> f80644a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.config.experiment.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.config.experiment.a
        public void a(int i3, String str) {
            x.f("WSExpPolicyManager", "[WSExpPolicyManager.java][onGetExperimentFailed] errorCode:" + i3 + ", errMsg:" + str);
        }

        @Override // com.tencent.biz.pubaccount.weishi.config.experiment.a
        public void b(d dVar) {
            x.j("WSExpPolicyManager", "[WSExpPolicyManager.java][fetchExpDataFromService]");
            WSExpPolicyManager.this.q(dVar);
            c.e(dVar);
            WSExpPolicyManager.this.l(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final WSExpPolicyManager f80646a = new WSExpPolicyManager();
    }

    WSExpPolicyManager() {
    }

    private void c() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.config.experiment.WSExpPolicyManager.1
            @Override // java.lang.Runnable
            public void run() {
                x.j("WSExpPolicyManager", "[WSExpPolicyManager.java][asyncReadExpDataFromFile]");
                WSExpPolicyManager.this.q(c.d(bb.y()));
            }
        });
    }

    private stGrayPolicyInfo d() {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "0");
        return g(hashMap);
    }

    private stGrayPolicyInfo e() {
        HashMap hashMap = new HashMap();
        hashMap.put("open_apk_preload", "0");
        return g(hashMap);
    }

    private d f() {
        stGetAllABTestPolicyRsp stgetallabtestpolicyrsp = new stGetAllABTestPolicyRsp();
        stgetallabtestpolicyrsp.policyInfo = h();
        return new d(bb.y(), stgetallabtestpolicyrsp);
    }

    private stGrayPolicyInfo g(Map<String, String> map) {
        stGrayPolicyInfo stgraypolicyinfo = new stGrayPolicyInfo();
        stgraypolicyinfo.grayPolicyId = "-999999";
        stgraypolicyinfo.params = map;
        return stgraypolicyinfo;
    }

    private Map<String, stGrayPolicyInfo> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("FeedsListClient_Preload", e());
        hashMap.put("AioForwardScene", d());
        hashMap.put("FeedLoopPlay", i());
        hashMap.put("QQFollowPageMute", j());
        hashMap.put("QQFeedScaleType", k());
        return hashMap;
    }

    private stGrayPolicyInfo i() {
        HashMap hashMap = new HashMap();
        hashMap.put("loop_play_type", "0");
        return g(hashMap);
    }

    private stGrayPolicyInfo j() {
        HashMap hashMap = new HashMap();
        hashMap.put("show", "0");
        return g(hashMap);
    }

    private stGrayPolicyInfo k() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "0");
        return g(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(d dVar) {
        wz.b.b().a(new WSExpEvent(dVar));
    }

    private void m() {
        new WSExpDataModule().c(bb.y(), new a());
    }

    public static WSExpPolicyManager o() {
        return b.f80646a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(d dVar) {
        if (dVar != null) {
            if (dVar.d() != null) {
                String g16 = dVar.g();
                d dVar2 = this.f80644a.get(g16);
                if (dVar2 == null || dVar2.d() == null || dVar.d().serverTime > dVar2.d().serverTime) {
                    this.f80644a.put(g16, dVar);
                    x.j("WSExpPolicyManager", "[WSExpPolicyManager.java][writeToExpEntitiesMap] policyEntities:" + dVar);
                }
                return;
            }
        }
        x.f("WSExpPolicyManager", "[WSExpPolicyManager.java][writeToExpEntitiesMap] policyEntities is null!");
    }

    public d n() {
        String y16 = bb.y();
        d dVar = this.f80644a.get(y16);
        if (dVar != null) {
            return dVar;
        }
        d d16 = c.d(y16);
        if (d16 == null) {
            d16 = f();
        }
        this.f80644a.put(y16, d16);
        return d16;
    }

    public void p() {
        x.j("WSExpPolicyManager", "[WSExpPolicyManager.java][init] thread:" + Thread.currentThread());
        c();
        m();
    }
}
