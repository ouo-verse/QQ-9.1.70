package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.d;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends d {
    static PromotionConfigInfo D;
    final String C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !BusinessCommonConfig.BusinessNotify_QQ_to_SubProcess.equals(intent.getAction()) || intent.getIntExtra("bussinessType", 0) != 2) {
                return;
            }
            int intExtra = intent.getIntExtra("event", 0);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    h.this.q(intent.getStringExtra("config_Content"));
                    PromotionResDownload promotionResDownload = h.this.f196943i;
                    if (promotionResDownload != null) {
                        promotionResDownload.c();
                        return;
                    }
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra("bussinessSubName");
            int intExtra2 = intent.getIntExtra("download_Index", 0);
            int intExtra3 = intent.getIntExtra("download_Progress", 0);
            if (QQAudioHelper.j()) {
                QLog.w(h.this.C, 1, "receive notify, index[" + intExtra2 + "], progress[" + intExtra3 + "]");
            }
            PromotionResDownload promotionResDownload2 = h.this.f196943i;
            if (promotionResDownload2 != null) {
                promotionResDownload2.d(stringExtra, intExtra2, intExtra3);
            }
        }
    }

    public h(AppInterface appInterface) {
        super(appInterface);
        String str = "SubProcessPromotionMgr_" + QQAudioHelper.b();
        this.C = str;
        p(appInterface);
        QLog.w(str, 1, "SubProcessPromotionMgr, sProcessId[" + MobileQQ.sProcessId + "], processName[" + MobileQQ.processName + "]");
    }

    @Override // com.tencent.mobileqq.ar.ARPromotionMgr.d
    public void m(AppInterface appInterface, String str) {
        BusinessCommonConfig.notifyQQDownload(2, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.ar.ARPromotionMgr.d
    public void o(PromotionConfigInfo promotionConfigInfo) {
        super.o(promotionConfigInfo);
        synchronized (PromotionConfigInfo.class) {
            D = promotionConfigInfo;
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotionMgr.d, mqq.manager.Manager
    public void onDestroy() {
        super.onDestroy();
        D = null;
    }

    boolean p(AppInterface appInterface) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BusinessCommonConfig.BusinessNotify_QQ_to_SubProcess);
        if (appInterface.getApp().registerReceiver(new a(), intentFilter) != null) {
            return true;
        }
        return false;
    }

    void q(String str) {
        synchronized (PromotionConfigInfo.class) {
            PromotionConfigInfo a16 = ty2.a.a(this.f196940e, str);
            o(a16);
            QLog.w(this.C, 1, "reloadConfigInfo, Uin[" + this.f196940e + "] configInfo[" + a16 + "]");
        }
    }

    public void r(AppInterface appInterface, d.b bVar) {
        if (!h("snycGetConfig", appInterface, bVar)) {
            bVar.a(e());
        }
    }

    @Override // com.tencent.mobileqq.ar.ARPromotionMgr.d
    void n(AppInterface appInterface) {
    }
}
