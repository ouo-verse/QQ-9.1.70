package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import Wallet.GetMiniAppRsp;
import android.os.Bundle;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ApkgConfigManager.a f245844a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LaunchParam f245845b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ApkgConfigManager f245846c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ApkgConfigManager apkgConfigManager, ApkgConfigManager.a aVar, LaunchParam launchParam) {
        this.f245846c = apkgConfigManager;
        this.f245844a = aVar;
        this.f245845b = launchParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, apkgConfigManager, aVar, launchParam);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        a aVar;
        a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        try {
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ApkgConfigManager", 2, "fail get rsp:");
                }
                ApkgConfigManager.a aVar3 = this.f245844a;
                if (aVar3 != null) {
                    aVar3.onResult(-1, null, null, "rsp is unsuccess");
                    return;
                }
                return;
            }
            GetMiniAppRsp getMiniAppRsp = (GetMiniAppRsp) bundle.getSerializable("rsp");
            if (getMiniAppRsp != null) {
                if (getMiniAppRsp.err_code == 0) {
                    ArrayList<ApkgConfig> arrayList = getMiniAppRsp.apkg_config_list;
                    if (arrayList != null && arrayList.size() > 0 && getMiniAppRsp.apkg_config_list.get(0) != null && getMiniAppRsp.apkg_config_list.get(0).isValid()) {
                        aVar2 = this.f245846c.mConfig;
                        aVar2.a(getMiniAppRsp.apkg_config_list);
                        ApkgConfigManager.a aVar4 = this.f245844a;
                        if (aVar4 != null) {
                            aVar4.onResult(0, new MiniAppConfig(getMiniAppRsp.apkg_config_list.get(0), this.f245846c.getBaseLibInfo()), null, null);
                        }
                    } else {
                        ApkgConfigManager.a aVar5 = this.f245844a;
                        if (aVar5 != null) {
                            aVar5.onResult(-1, null, null, "rsp list not contain valid elem");
                        }
                    }
                } else {
                    if (getMiniAppRsp.isRemoveLocalConfig()) {
                        aVar = this.f245846c.mConfig;
                        aVar.a(this.f245845b);
                    }
                    ApkgConfigManager.a aVar6 = this.f245844a;
                    if (aVar6 != null) {
                        aVar6.onResult(getMiniAppRsp.err_code, null, getMiniAppRsp.getErrTips(), null);
                    }
                }
            } else {
                ApkgConfigManager.a aVar7 = this.f245844a;
                if (aVar7 != null) {
                    aVar7.onResult(-1, null, null, "rsp is null");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ApkgConfigManager", 2, "getNewestConfig GetMiniAppRsp|" + getMiniAppRsp);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
