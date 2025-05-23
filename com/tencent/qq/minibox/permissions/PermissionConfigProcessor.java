package com.tencent.qq.minibox.permissions;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import ps3.a;

/* loaded from: classes22.dex */
public class PermissionConfigProcessor extends BaseConfigParser<a> {
    public static a c() {
        return (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100862");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        if (bArr.length != 0) {
            String str = new String(bArr, StandardCharsets.UTF_8);
            QLog.i("game.permission.PermissionConfigProcessor", 1, "parse: config=" + str);
            return a.a(str);
        }
        QLog.i("game.permission.PermissionConfigProcessor", 1, "parse empty content");
        return new a();
    }
}
