package com.tencent.qqperf.crashdefend;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class CrashDefendConfigProcessor extends BaseConfigParser<a> {
    protected static void d() {
        try {
            Context q16 = CrashDefendManager.i().q();
            if (q16 == null) {
                q16 = BaseApplication.getContext();
            }
            b.c(q16, (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("crash_defend_switch"));
        } catch (Throwable th5) {
            wy3.c.d("CrashDefendConfig", "tryUpdateConfigToFile has Exception!", th5);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return a.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        Throwable th5;
        a aVar;
        String str;
        try {
            str = new String(bArr);
            wy3.c.a("CrashDefendConfig", "parse: \n" + str);
            aVar = new a();
        } catch (Throwable th6) {
            th5 = th6;
            aVar = null;
        }
        try {
            aVar.f(str);
            return aVar;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                wy3.c.d("CrashDefendConfig", "parse failed!", th5);
            } catch (Throwable unused) {
            }
            return aVar;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean z16) {
        super.onReceive(z16);
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.crashdefend.CrashDefendConfigProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    CrashDefendConfigProcessor.d();
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes25.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        boolean f363062d;

        /* renamed from: e, reason: collision with root package name */
        boolean f363063e;

        /* renamed from: f, reason: collision with root package name */
        boolean f363064f;

        /* renamed from: h, reason: collision with root package name */
        boolean f363065h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f363066i;

        a() {
            this.f363062d = false;
            this.f363063e = false;
            this.f363064f = false;
            this.f363065h = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static a a() {
            return new a(false, false, false, false);
        }

        public boolean b() {
            return this.f363064f;
        }

        public boolean c() {
            return this.f363065h;
        }

        public boolean d() {
            return this.f363062d;
        }

        public boolean e() {
            return this.f363063e;
        }

        void f(String str) {
            if (StringUtil.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("crashDefender_switch")) {
                    this.f363062d = jSONObject.optBoolean("crashDefender_switch");
                }
                if (jSONObject.has("native_crash_switch")) {
                    this.f363063e = jSONObject.getBoolean("native_crash_switch");
                }
                if (jSONObject.has("anr_switch")) {
                    this.f363064f = jSONObject.getBoolean("anr_switch");
                }
                if (jSONObject.has("config_all_clear_switch")) {
                    this.f363065h = jSONObject.getBoolean("config_all_clear_switch");
                }
                this.f363066i = jSONObject.optBoolean("test_https_pipe", false);
            } catch (Throwable th5) {
                wy3.c.d("CrashDefendConfig", "CrashDefendConfig parse failed!", th5);
            }
        }

        public String toString() {
            return "CrashDefendConfig{isEnable=" + this.f363062d + ", isNativeCrashEnable=" + this.f363063e + ", isANREnable=" + this.f363064f + ", isClearAllConfig=" + this.f363065h + '}';
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(boolean z16, boolean z17, boolean z18, boolean z19) {
            this.f363062d = z16;
            this.f363063e = z17;
            this.f363064f = z18;
            this.f363065h = z19;
        }
    }
}
