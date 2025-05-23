package com.tencent.rmonitor.base.config.impl;

import android.content.SharedPreferences;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class f implements i {

    /* renamed from: a, reason: collision with root package name */
    private a f365352a = null;

    private a c(SharedPreferences sharedPreferences) {
        a aVar = new a();
        if (sharedPreferences == null) {
            return aVar;
        }
        try {
            c b16 = aVar.b();
            String string = sharedPreferences.getString(SPKey.KEY_CONFIG_DATA, null);
            if (!TextUtils.isEmpty(string)) {
                b16.f365344a = new JSONObject(string);
            }
            b16.f365346c = sharedPreferences.getString(SPKey.KEY_CONFIG_LATEST_MD5_CODE, b16.f365346c);
            b16.f365347d = sharedPreferences.getLong(SPKey.KEY_CONFIG_NEXT_TIME, b16.f365347d);
            b16.f365349f = sharedPreferences.getLong(SPKey.KEY_CONFIG_LOAD_TIME, b16.f365349f);
            b a16 = aVar.a();
            String string2 = sharedPreferences.getString(SPKey.KEY_CONFIG_LAST_APPLY_PARAMS, "");
            if (!TextUtils.isEmpty(string2)) {
                a16.e(new JSONObject(string2));
            }
            b16.a("apply result from cache");
        } catch (Throwable th5) {
            a aVar2 = this.f365352a;
            if (aVar2 != null) {
                aVar = aVar2;
            }
            Logger.f365497g.e("RMonitor_config", "load apply result fail for " + th5);
        }
        return aVar;
    }

    @Override // com.tencent.rmonitor.base.config.impl.i
    public a a() {
        return c(q04.a.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    @Override // com.tencent.rmonitor.base.config.impl.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(a aVar) {
        String message;
        String jSONObject;
        boolean z16;
        String jSONObject2;
        if (aVar == null) {
            return false;
        }
        this.f365352a = aVar;
        SharedPreferences.Editor a16 = q04.a.a();
        if (a16 != null) {
            try {
                c b16 = aVar.b();
                a16.putLong(SPKey.KEY_CONFIG_NEXT_TIME, b16.f365347d);
                a16.putLong(SPKey.KEY_CONFIG_UPDATED_TIME, b16.f365348e);
                a16.putLong(SPKey.KEY_CONFIG_LOAD_TIME, b16.f365349f);
                message = "";
                if (aVar.d()) {
                    JSONObject jSONObject3 = b16.f365344a;
                    if (jSONObject3 == null) {
                        jSONObject2 = "";
                    } else {
                        jSONObject2 = jSONObject3.toString();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = "";
                    }
                    a16.putString(SPKey.KEY_CONFIG_DATA, jSONObject2);
                    a16.putString(SPKey.KEY_CONFIG_LATEST_MD5_CODE, b16.f365346c);
                }
                JSONObject a17 = aVar.a().a();
                if (a17 == null) {
                    jSONObject = "";
                } else {
                    jSONObject = a17.toString();
                }
                if (jSONObject == null) {
                    jSONObject = "";
                }
                a16.putString(SPKey.KEY_CONFIG_LAST_APPLY_PARAMS, jSONObject);
                a16.commit();
                z16 = true;
            } catch (Throwable th5) {
                message = th5.getMessage();
            }
            if (!z16) {
                Logger.f365497g.e("RMonitor_config", "save config apply data fail for " + message);
            }
            return z16;
        }
        message = "editor is null.";
        z16 = false;
        if (!z16) {
        }
        return z16;
    }
}
