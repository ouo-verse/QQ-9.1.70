package com.tencent.mobileqq.ark.config.qqmc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import d91.b;
import e91.i;

/* loaded from: classes11.dex */
public class ArkEnvironmentConfigParser extends BaseConfigParser<b> {
    public static b d() {
        return (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100679");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(b bVar) {
        if (bVar == null) {
            QLog.i("ArkApp.ArkEnvironmentConfigParser", 1, "newConf is null");
        } else {
            com.tencent.mobileqq.ark.b.a(bVar.c());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        e91.b bVar;
        String str = new String(bArr);
        i iVar = null;
        try {
            bVar = (e91.b) as.e(str, e91.b.class);
        } catch (QStorageInstantiateException e16) {
            e = e16;
            bVar = null;
        }
        try {
            iVar = (i) as.e(str, i.class);
        } catch (QStorageInstantiateException e17) {
            e = e17;
            QLog.i("ArkApp.ArkEnvironmentConfigParser", 1, "loadConfig:" + str + "fail", e);
            return new b(str, bVar, iVar);
        }
        return new b(str, bVar, iVar);
    }
}
