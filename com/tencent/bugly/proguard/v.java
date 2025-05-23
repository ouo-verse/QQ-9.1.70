package com.tencent.bugly.proguard;

import android.os.Looper;
import com.tencent.bugly.common.looper.LooperDispatchWatcher;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class v extends com.tencent.rmonitor.base.config.data.k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f98573a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f98574b = true;

    /* renamed from: c, reason: collision with root package name */
    public int f98575c = 61440;

    /* renamed from: d, reason: collision with root package name */
    public long f98576d = 2;

    /* renamed from: e, reason: collision with root package name */
    public boolean f98577e = true;

    @Override // com.tencent.rmonitor.base.config.data.k
    public final String getName() {
        return "crash";
    }

    @Override // com.tencent.rmonitor.base.config.h
    public final void parsePluginConfig(JSONObject jSONObject) {
        boolean z16;
        try {
            if (jSONObject == null) {
                Logger.f365497g.i("RMonitor_config", "crash configs is null");
                return;
            }
            if (jSONObject.has("cus_file_sample_ratio")) {
                if (Math.random() < jSONObject.getDouble("cus_file_sample_ratio")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f98573a = z16;
            }
            if (jSONObject.has("new_userinfo")) {
                this.f98574b = jSONObject.getBoolean("new_userinfo");
            }
            if (jSONObject.has("log_length")) {
                this.f98575c = jSONObject.getInt("log_length");
            }
            if (jSONObject.has("log_before_time")) {
                this.f98576d = jSONObject.getLong("log_before_time");
            }
            if (jSONObject.has("anr_msg_recorder")) {
                u a16 = u.a();
                if (jSONObject.optBoolean("anr_msg_recorder", false)) {
                    LooperDispatchWatcher.INSTANCE.register(Looper.getMainLooper(), a16.f98571a);
                    a16.f98572b = true;
                } else {
                    LooperDispatchWatcher.INSTANCE.unregister(Looper.getMainLooper(), a16.f98571a);
                    a16.f98572b = false;
                }
            }
            if (jSONObject.has("native_sub_process")) {
                aa a17 = aa.a();
                boolean optBoolean = jSONObject.optBoolean("native_sub_process", false);
                a17.f97933a = optBoolean;
                Iterator<aa.a> it = a17.f97934b.iterator();
                while (it.hasNext()) {
                    it.next().onSubProcessConfigChanged(optBoolean);
                }
            }
            if (jSONObject.has("enable_custom_data")) {
                this.f98577e = jSONObject.optBoolean("enable_custom_data");
            }
            if (jSONObject.has("dump_all_thread_stack")) {
                boolean optBoolean2 = jSONObject.optBoolean("dump_all_thread_stack", false);
                NativeCrashHandler.enableNativeDumpAllThreadStack = optBoolean2;
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    av.a("enableNativeDumpAllThreadStack: ".concat(String.valueOf(optBoolean2)), new Object[0]);
                    nativeCrashHandler.setNativeEnableDumpAllThread(Boolean.valueOf(optBoolean2));
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parseCrashConfigs", th5);
        }
    }
}
