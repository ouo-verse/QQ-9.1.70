package com.tencent.mobileqq.app.automator.step;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class EcShopFirstRunMsgConfigs extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EcShopFirstRunMsgConfigs.this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            if (gVar.f313006d == 0 && ((Automator) EcShopFirstRunMsgConfigs.this.mAutomator).E != null) {
                String string = gVar.h().getString("path");
                if (((Automator) EcShopFirstRunMsgConfigs.this.mAutomator).E != null && !TextUtils.isEmpty(string)) {
                    if (EcShopAssistantManager.S.equals(string)) {
                        ((Automator) EcShopFirstRunMsgConfigs.this.mAutomator).E.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", gVar.P).commit();
                        ((EcshopReportHandler) ((Automator) EcShopFirstRunMsgConfigs.this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).L2();
                        if (QLog.isColorLevel()) {
                            QLog.i("Ecshop", 2, "download report json success.");
                            return;
                        }
                        return;
                    }
                    if (EcShopAssistantManager.T.equals(string)) {
                        ((Automator) EcShopFirstRunMsgConfigs.this.mAutomator).E.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", gVar.P).commit();
                        if (QLog.isColorLevel()) {
                            QLog.i("Ecshop", 2, "download behaviors json success.");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Ecshop", 2, "download json failed.");
            }
        }
    }

    public EcShopFirstRunMsgConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        int i3;
        ?? r56;
        com.tencent.mobileqq.vip.h u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
        }
        ((EcShopAssistantManager) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).d();
        a aVar = new a();
        List asList = Arrays.asList("https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_wl_conf.json", "https://imgcache.qq.com/zzapp/qqshop/stat/qqshp_client_log_jd_conf.json");
        int i16 = 0;
        int i17 = 1;
        List asList2 = Arrays.asList(EcShopAssistantManager.S, EcShopAssistantManager.T);
        List asList3 = Arrays.asList("last_modified_report_json", "last_modified_behaviors_json");
        int i18 = 0;
        while (i18 < asList.size()) {
            String str = (String) asList.get(i18);
            String str2 = (String) asList2.get(i18);
            String str3 = (String) asList3.get(i18);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (u16 = ((DownloaderFactory) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(i17)) != null) {
                String A = com.tencent.mobileqq.emosm.e.A("VIP_shop_assit_cfg", str);
                if (u16.getTask(A) == null) {
                    File file = new File(str2);
                    com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(A, file);
                    if (file.exists()) {
                        Long valueOf = Long.valueOf(file.lastModified());
                        gVar.P = ((Automator) this.mAutomator).E.getApp().getSharedPreferences("ecshop_sp", i16).getLong(str3, 0L);
                        if (valueOf.longValue() != gVar.P) {
                            r56 = 1;
                            gVar.N = true;
                        } else {
                            r56 = 1;
                        }
                    } else {
                        r56 = i17;
                    }
                    gVar.K = r56;
                    i3 = 0;
                    gVar.U = false;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", str2);
                    u16.startDownload(gVar, aVar, bundle);
                    i18++;
                    int i19 = i3;
                    i17 = r56;
                    i16 = i19;
                }
            }
            int i26 = i17;
            i3 = i16;
            r56 = i26;
            i18++;
            int i192 = i3;
            i17 = r56;
            i16 = i192;
        }
        return 7;
    }
}
