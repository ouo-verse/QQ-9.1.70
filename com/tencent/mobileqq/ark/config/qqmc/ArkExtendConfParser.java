package com.tencent.mobileqq.ark.config.qqmc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import d91.e;
import e91.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public class ArkExtendConfParser extends BaseConfigParser<e> {

    /* renamed from: d, reason: collision with root package name */
    private static e f199262d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements py2.a<e> {
        a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable e eVar) {
            if (eVar != null) {
                ArkExtendConfParser.f199262d = eVar;
            }
        }
    }

    private static d d(List<d> list, String str, String str2) {
        d dVar = null;
        for (d dVar2 : list) {
            if (dVar2.a().equals(str)) {
                if (!TextUtils.isEmpty(str2) && !dVar2.b().equals(str2)) {
                    if (dVar == null) {
                        dVar = dVar2;
                    }
                } else {
                    return dVar2;
                }
            }
        }
        return dVar;
    }

    public static Map<String, String> e(String str, String str2) {
        if (f() != null) {
            List<d> a16 = f().a();
            if (a16 != null && a16.size() != 0) {
                d d16 = d(a16, str, str2);
                if (d16 != null) {
                    QLog.d("ArkApp.ArkExtendConfParser", 1, "getArkExtendInfo " + d16.h());
                    return d16.h();
                }
            } else {
                return new HashMap();
            }
        }
        return new HashMap();
    }

    public static e f() {
        if (f199262d == null) {
            g();
        }
        return f199262d;
    }

    public static void g() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("ark_extend_info", new a());
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        return new e();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e parse(@NonNull byte[] bArr) {
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkExtendConfParser", 1, "ArkExtendConfParser [onParsed] , content = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return new e();
        }
        return e.b(str);
    }
}
