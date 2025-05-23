package com.tencent.mobileqq.ark.config.qqmc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import d91.a;

/* loaded from: classes11.dex */
public class AIDictParser extends BaseConfigParser<a> {
    public static a d() {
        return (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100677");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(a aVar) {
        if (aVar == null) {
            QLog.i("ArkApp.AIDictParser", 1, "newConf is null");
        } else if (QLog.isColorLevel()) {
            QLog.d("ArkApp.AIDictParser", 1, "[onUpdate] , content=" + aVar.b());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        com.tencent.mobileqq.ark.dict.a aVar;
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.AIDictParser", 1, "[onParsed] , content = " + str);
        }
        try {
            aVar = (com.tencent.mobileqq.ark.dict.a) as.e(str, com.tencent.mobileqq.ark.dict.a.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("ArkApp.AIDictParser", 1, "loadConfig:" + str + "fail", e16);
            aVar = null;
        }
        return new a(str, aVar);
    }
}
