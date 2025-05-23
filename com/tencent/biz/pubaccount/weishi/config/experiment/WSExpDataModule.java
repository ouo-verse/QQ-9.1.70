package com.tencent.biz.pubaccount.weishi.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSExpDataModule {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f80640a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.config.experiment.a f80641b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f80642c;

        a(String str, com.tencent.biz.pubaccount.weishi.config.experiment.a aVar, long j3) {
            this.f80640a = str;
            this.f80641b = aVar;
            this.f80642c = j3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            WSExpDataModule.this.f(lVar, this.f80640a, this.f80641b, this.f80642c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar, String str, com.tencent.biz.pubaccount.weishi.config.experiment.a aVar, long j3) {
        long uptimeMillis = SystemClock.uptimeMillis() - j3;
        g.d().p(uptimeMillis, lVar.f80994g, "", false);
        if (!lVar.d()) {
            x.f("WSExpDataModule", "[WSExpDataModule.java][handleOnSubThread] failCode:" + lVar.f80991d + ", failMsg:" + lVar.f80990c);
            g.d().r(uptimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
            if (aVar != null) {
                aVar.a(lVar.f80991d, lVar.f80990c);
                return;
            }
            return;
        }
        Object obj = lVar.f80999l;
        if (!(obj instanceof stGetAllABTestPolicyRsp)) {
            x.f("WSExpDataModule", "[WSExpDataModule.java][handleOnSubThread] task.mResultBean instanceof stGetAllABTestPolicyRsp: false! task.mResultBean:" + lVar.f80999l);
            g.d().r(uptimeMillis, lVar.f80994g, -1, "\u6570\u636e\u65e0\u6cd5\u89e3\u6790\u6216\u4e3a\u7a7a");
            if (aVar != null) {
                aVar.a(-1, "\u6570\u636e\u65e0\u6cd5\u89e3\u6790\u6216\u4e3a\u7a7a");
                return;
            }
            return;
        }
        stGetAllABTestPolicyRsp stgetallabtestpolicyrsp = (stGetAllABTestPolicyRsp) obj;
        if (aVar != null) {
            aVar.b(new d(str, stgetallabtestpolicyrsp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final l lVar, final String str, final com.tencent.biz.pubaccount.weishi.config.experiment.a aVar, final long j3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.config.experiment.WSExpDataModule.3
            @Override // java.lang.Runnable
            public void run() {
                WSExpDataModule.this.e(lVar, str, aVar, j3);
            }
        });
    }

    public void c(final String str, final com.tencent.biz.pubaccount.weishi.config.experiment.a aVar) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.config.experiment.WSExpDataModule.1
            @Override // java.lang.Runnable
            public void run() {
                WSExpDataModule.this.d(str, aVar);
            }
        });
    }

    public void d(String str, com.tencent.biz.pubaccount.weishi.config.experiment.a aVar) {
        x.j("WSExpDataModule", "[WSExpDataModule.java][fetchData] uin:" + str);
        com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.l(str), null, new a(str, aVar, SystemClock.uptimeMillis()), 4016));
    }
}
