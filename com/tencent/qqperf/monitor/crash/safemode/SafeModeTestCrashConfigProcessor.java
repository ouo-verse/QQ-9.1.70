package com.tencent.qqperf.monitor.crash.safemode;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class SafeModeTestCrashConfigProcessor extends BaseConfigParser<a> {

    /* loaded from: classes25.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        boolean f363208d = false;

        public boolean a() {
            return this.f363208d;
        }

        void b(String str) {
            if (StringUtil.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("startup_crash_switch")) {
                    this.f363208d = jSONObject.getBoolean("startup_crash_switch");
                }
            } catch (Throwable th5) {
                wy3.c.d("SafeModeTestCrashConfigProcessor", "CrashDefendConfig parse failed!", th5);
            }
        }

        public String toString() {
            return "SafeModeTestCrashConfig{isNeedStartUpCrash=" + this.f363208d + '}';
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        wy3.c.e("SafeModeTestCrashConfigProcessor", "defaultConfig !");
        return new a();
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
            aVar = new a();
        } catch (Throwable th6) {
            th5 = th6;
            aVar = null;
        }
        try {
            aVar.b(str);
            wy3.c.a("SafeModeTestCrashConfigProcessor", "parse: \n" + str);
            return aVar;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                wy3.c.d("SafeModeTestCrashConfigProcessor", "parse failed!", th5);
            } catch (Throwable unused) {
            }
            return aVar;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean z16) {
        super.onReceive(z16);
        wy3.c.e("SafeModeTestCrashConfigProcessor", "onReceive end! b=" + z16);
    }
}
