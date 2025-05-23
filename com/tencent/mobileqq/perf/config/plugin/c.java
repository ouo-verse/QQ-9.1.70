package com.tencent.mobileqq.perf.config.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/c;", "", "", "toString", "", "a", "Z", "c", "()Z", "setSwitch", "(Z)V", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "b", "I", "()I", "setMin_effect_sdk_int", "(I)V", "min_effect_sdk_int", "setMax_effect_sdk_int", "max_effect_sdk_int", "d", "setSys_launch_threshold", "sys_launch_threshold", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean switch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int min_effect_sdk_int;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int max_effect_sdk_int;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sys_launch_threshold;

    public c(@Nullable JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.min_effect_sdk_int = 21;
        this.max_effect_sdk_int = 30;
        this.sys_launch_threshold = 600;
        if (jSONObject != null) {
            this.min_effect_sdk_int = jSONObject.optInt("min_effect_sdk_int", 21);
            this.max_effect_sdk_int = jSONObject.optInt("max_effect_sdk_int", this.max_effect_sdk_int);
            this.switch = jSONObject.optBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, this.switch);
            this.sys_launch_threshold = jSONObject.optInt("sys_launch_threshold", this.sys_launch_threshold);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.max_effect_sdk_int;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.min_effect_sdk_int;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.switch;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.sys_launch_threshold;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "GrayDex2oatConfig(switch=" + this.switch + ", min_effect_sdk_int=" + this.min_effect_sdk_int + ", max_effect_sdk_int=" + this.max_effect_sdk_int + ", threshold=" + this.sys_launch_threshold + ')';
    }
}
