package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.confighandler.DefaultConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements Manager {

    /* renamed from: d, reason: collision with root package name */
    final String f196939d;

    /* renamed from: e, reason: collision with root package name */
    String f196940e;

    /* renamed from: i, reason: collision with root package name */
    PromotionResDownload f196943i;

    /* renamed from: f, reason: collision with root package name */
    PromotionConfigInfo f196941f = null;

    /* renamed from: h, reason: collision with root package name */
    private g f196942h = null;

    /* renamed from: m, reason: collision with root package name */
    com.tencent.mobileqq.ar.ARPromotionMgr.b f196944m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements SyncLoadTask.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f196945a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f196946b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f196947c;

        a(AppInterface appInterface, String str, b bVar) {
            this.f196945a = appInterface;
            this.f196946b = str;
            this.f196947c = bVar;
        }

        @Override // com.tencent.mobileqq.utils.SyncLoadTask.a
        public void a(boolean z16, ArrayList<SyncLoadTask> arrayList) {
            g gVar = (g) arrayList.get(0);
            if (d.this.f196942h != null && d.this.f196942h == gVar && this.f196945a != null) {
                QLog.w(d.this.f196939d, 1, "\u5f02\u6b65\u52a0\u8f7dconfig\u8fd4\u56de, bsuc[" + z16 + "], TAG[" + gVar.mTAG + "], isEnableFromLocal[" + c.c() + "], config[" + gVar.f196952a + "]");
                if (z16) {
                    d.this.o(gVar.f196952a);
                    d.this.n(this.f196945a);
                }
                d.this.f196942h = null;
            } else {
                QLog.w(d.this.f196939d, 1, "\u5f02\u6b65\u52a0\u8f7dconfig\u8fd4\u56de[" + this.f196946b + "], \u4f46\u539f\u8bf7\u6c42\u53d6\u6d88\u4e86");
            }
            b bVar = this.f196947c;
            if (bVar != null) {
                bVar.a(d.this.e());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(PromotionConfigInfo promotionConfigInfo);
    }

    public d(AppInterface appInterface) {
        this.f196943i = null;
        long b16 = QQAudioHelper.b();
        String str = "ARPromotion_" + b16;
        this.f196939d = str;
        this.f196940e = appInterface.getAccount();
        QLog.w(str, 1, "PromotionMgr, mUin[" + LogUtil.getSafePrintUin(this.f196940e) + "]");
        this.f196943i = new PromotionResDownload(b16);
    }

    public void c(PromotionResDownload.b bVar) {
        PromotionResDownload promotionResDownload = this.f196943i;
        if (promotionResDownload != null) {
            promotionResDownload.b(bVar);
        }
    }

    void d(AppInterface appInterface) {
        com.tencent.mobileqq.shortvideo.ptvfilter.gesture.a.a();
        if (this.f196944m == null) {
            this.f196944m = new com.tencent.mobileqq.ar.ARPromotionMgr.b();
        }
        this.f196944m.d(appInterface);
    }

    public PromotionConfigInfo e() {
        return this.f196941f;
    }

    public boolean f() {
        boolean z16;
        synchronized (PromotionConfigInfo.class) {
            if (this.f196941f != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    protected boolean g() {
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ar_360_manage_remove", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(String str, AppInterface appInterface, b bVar) {
        if (!g()) {
            return false;
        }
        if (f() && c.f196937b != -1) {
            return false;
        }
        g gVar = this.f196942h;
        if (gVar == null) {
            if (TextUtils.isEmpty(this.f196940e) && appInterface != null) {
                this.f196940e = appInterface.getCurrentAccountUin();
            }
            gVar = new g(this.f196939d, this.f196940e, appInterface);
            this.f196942h = gVar;
        }
        if (gVar.isNeedRunTask()) {
            QLog.w(this.f196939d, 1, "\u5f02\u6b65\u52a0\u8f7dconfig[" + str + "]");
            ArrayList arrayList = new ArrayList();
            arrayList.add(gVar);
            SyncLoadTask.requestSyncTask(null, arrayList, new a(appInterface, str, bVar));
        } else {
            QLog.w(this.f196939d, 1, "\u5f02\u6b65\u52a0\u8f7dconfig[" + str + "], \u5df2\u7ecf\u5728\u52a0\u8f7d\u4e2d");
        }
        return true;
    }

    void i(String str) {
        PromotionResDownload promotionResDownload = this.f196943i;
        if (promotionResDownload != null) {
            promotionResDownload.c();
        }
        BusinessCommonConfig.sendConfigUpdateNotify(2, str);
    }

    public void j(QQAppInterface qQAppInterface, String str, PromotionConfigInfo promotionConfigInfo) {
        boolean z16;
        if (!g()) {
            return;
        }
        String str2 = this.f196939d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onGetEntryConfig, from server, configInfo[");
        if (promotionConfigInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("]");
        QLog.w(str2, 1, sb5.toString());
        if (promotionConfigInfo != null) {
            o(promotionConfigInfo);
            g gVar = this.f196942h;
            if (gVar != null) {
                gVar.clean();
                this.f196942h = null;
            }
        }
        if (h("onGetConfig", qQAppInterface, null)) {
            return;
        }
        i(str);
        n(qQAppInterface);
    }

    public void k(QQAppInterface qQAppInterface, String str, DefaultConfigInfo defaultConfigInfo) {
        if (!g()) {
            return;
        }
        if (!f()) {
            QLog.w(this.f196939d, 1, "onGetResConfig, 365\u8fd8\u6ca1\u52a0\u8f7d");
            return;
        }
        PromotionConfigInfo e16 = e();
        if (e16 == null) {
            QLog.w(this.f196939d, 1, "onGetResConfig, 365\u4e3anull");
            return;
        }
        int g16 = ty2.a.g(this.f196940e);
        QLog.w(this.f196939d, 1, "onGetResConfig, 365\u5df2\u7ecf\u52a0\u8f7d\u4e86, [" + e16.config364Version + "], ver[" + g16 + "]");
        if (TextUtils.equals(str, "test")) {
            g16 = -1;
        }
        if (g16 == e16.config364Version) {
            return;
        }
        o(null);
        j(qQAppInterface, null, null);
    }

    public void l(PromotionResDownload.b bVar) {
        PromotionResDownload promotionResDownload = this.f196943i;
        if (promotionResDownload != null) {
            promotionResDownload.p(bVar);
        }
    }

    public void m(AppInterface appInterface, String str) {
        if (this.f196943i != null) {
            if (f()) {
                this.f196943i.r(e());
                this.f196943i.q(appInterface, false, str, 0);
                return;
            }
            QLog.w(this.f196939d, 1, "requestDownload, \u914d\u7f6e\u8fd8\u672a\u521d\u59cb\u5316");
            return;
        }
        QLog.w(this.f196939d, 1, "requestDownload, \u4e0b\u8f7d\u5668\u4e3a\u7a7a");
        if (!QQAudioHelper.f()) {
        } else {
            throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.pfj));
        }
    }

    void n(AppInterface appInterface) {
        PromotionResDownload promotionResDownload;
        PromotionConfigInfo e16 = e();
        if (QQAudioHelper.j()) {
            QLog.w(this.f196939d, 1, "requestPreDownload, PromotionConfigInfo[" + e16 + "], isDevicesSupport[" + c.a() + "]");
        }
        if (!c.a() || e16 == null || !e16.mainswitch || e16.operationInfos.size() == 0) {
            return;
        }
        d(appInterface);
        PromotionConfigInfo e17 = e();
        if (e17 != null && (promotionResDownload = this.f196943i) != null) {
            promotionResDownload.r(e17);
            this.f196943i.q(appInterface, true, e16.activityid, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(PromotionConfigInfo promotionConfigInfo) {
        Throwable th5;
        synchronized (PromotionConfigInfo.class) {
            if (promotionConfigInfo == null) {
                if (QQAudioHelper.f()) {
                    th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
                    QLog.w(this.f196939d, 1, "setConfigInfo, old[" + this.f196941f + "], new[" + promotionConfigInfo + "]", th5);
                    this.f196941f = promotionConfigInfo;
                }
            }
            th5 = null;
            QLog.w(this.f196939d, 1, "setConfigInfo, old[" + this.f196941f + "], new[" + promotionConfigInfo + "]", th5);
            this.f196941f = promotionConfigInfo;
        }
        this.f196942h = null;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.w(this.f196939d, 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
        g gVar = this.f196942h;
        if (gVar != null) {
            gVar.clean();
            this.f196942h = null;
        }
        PromotionResDownload promotionResDownload = this.f196943i;
        if (promotionResDownload != null) {
            promotionResDownload.g();
            this.f196943i = null;
        }
        com.tencent.mobileqq.ar.ARPromotionMgr.b bVar = this.f196944m;
        if (bVar != null) {
            bVar.c();
            this.f196944m = null;
        }
        o(null);
    }
}
