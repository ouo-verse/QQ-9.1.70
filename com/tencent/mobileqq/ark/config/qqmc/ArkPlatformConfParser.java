package com.tencent.mobileqq.ark.config.qqmc;

import androidx.annotation.NonNull;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.ark.util.a;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import d91.g;
import e91.h;

/* loaded from: classes11.dex */
public class ArkPlatformConfParser extends BaseConfigParser<g> {
    public static g d() {
        return (g) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100640");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g defaultConfig() {
        return new g();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(g gVar) {
        if (gVar == null) {
            QLog.i("ArkApp.ArkPlatformConfParser", 1, "newConf is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkPlatformConfParser", 1, "[onUpdate]\u00a0t,\u00a0content\u00a0=\u00a0" + gVar.b());
        }
        a.a();
        e91.g c16 = gVar.c();
        if (c16 == null) {
            QLog.i("ArkApp.ArkPlatformConfParser", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
        } else {
            ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(c16.g(), c16.f395984n, c16.f395971a);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public g parse(@NonNull byte[] bArr) {
        e91.g gVar;
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkPlatformConfParser", 1, "ArkPlatformConfigBean [onParsed] , content = " + str);
        }
        try {
            gVar = (e91.g) as.e(str, h.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("ArkApp.ArkPlatformConfParser", 1, "readJsonOrXml:" + str + "fail", e16);
            gVar = null;
        }
        return new g(str, gVar);
    }
}
