package com.tencent.mobileqq.power.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u0000 '2\u00020\u0001:\u0002\u0012\u0019B\u0007\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\t\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001e\u001a\u0004\b!\u0010\u001fR\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\u0017\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/power/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "usage", "Lcom/tencent/mobileqq/power/config/b;", "e", "", "toString", "", "d", "Z", "c", "()Z", "j", "(Z)V", "enable", "", "I", "a", "()I", h.F, "(I)V", "countThreshold", "f", "D", "b", "()D", "i", "(D)V", "cpuThreshold", "Lcom/tencent/mobileqq/power/config/b;", "()Lcom/tencent/mobileqq/power/config/b;", "highLeve", "g", "midLeve", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lowLeve", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int countThreshold;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double cpuThreshold;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.power.config.b highLeve;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.power.config.b midLeve;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.power.config.b lowLeve;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\tR\u0014\u0010\u001b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\tR\u0014\u0010 \u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\tR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0006\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/power/config/a$a;", "", "Lcom/tencent/mobileqq/power/config/a;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "", "DEFAULT_COUNT_THRESHOLD", "I", "", "DEFAULT_CPU_THRESHOLD", "D", "", "DEFAULT_ENABLE", "Z", "DEFAULT_HIGH_AVG_CPU_USAGE", "", "DEFAULT_HIGH_INTERVAL", "J", "DEFAULT_HIGH_NEED_STACK", "DEFAULT_HIGH_PRINT_COUNT", "DEFAULT_HIGH_REPEAT_TIMES", "DEFAULT_LOW_AVG_CPU_USAGE", "DEFAULT_LOW_INTERVAL", "DEFAULT_LOW_NEED_STACK", "DEFAULT_LOW_PRINT_COUNT", "DEFAULT_LOW_REPEAT_TIMES", "DEFAULT_MID_AVG_CPU_USAGE", "DEFAULT_MID_INTERVAL", "DEFAULT_MID_NEED_STACK", "DEFAULT_MID_PRINT_COUNT", "DEFAULT_MID_REPEAT_TIMES", "TAG", "<init>", "()V", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.power.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("cpuFrontMonitor");
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/power/config/a$b;", "", "", "content", "Lcom/tencent/mobileqq/power/config/a;", "a", "<init>", "()V", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f259417a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28713);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f259417a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final a a(@NotNull String content) {
            JSONObject jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            }
            Intrinsics.checkNotNullParameter(content, "content");
            a aVar = new a();
            if (TextUtils.isEmpty(content)) {
                return aVar;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(content);
                aVar.j(jSONObject2.optBoolean("cpu_front_enable", true));
                aVar.h(jSONObject2.optInt("count_threshold", 6));
                aVar.i(jSONObject2.optDouble("cpu_threshold", 0.2d));
                JSONObject optJSONObject = jSONObject2.optJSONObject("level_high");
                if (optJSONObject != null) {
                    jSONObject = jSONObject2;
                    aVar.d().f(optJSONObject.optDouble("avg_cpu_usage", 0.4d));
                    aVar.d().g(optJSONObject.optLong("intervals", 10000L));
                    aVar.d().j(optJSONObject.optInt("repeat_times", 6));
                    aVar.d().i(optJSONObject.optInt("print_count", 10));
                    aVar.d().h(optJSONObject.optBoolean("need_stack", true));
                } else {
                    jSONObject = jSONObject2;
                }
                JSONObject jSONObject3 = jSONObject;
                JSONObject optJSONObject2 = jSONObject3.optJSONObject("level_mid");
                if (optJSONObject2 != null) {
                    aVar.g().f(optJSONObject2.optDouble("avg_cpu_usage", 0.3d));
                    aVar.g().g(optJSONObject2.optLong("intervals", 10000L));
                    aVar.g().j(optJSONObject2.optInt("repeat_times", 6));
                    aVar.g().i(optJSONObject2.optInt("print_count", 10));
                    aVar.g().h(optJSONObject2.optBoolean("need_stack", false));
                }
                JSONObject optJSONObject3 = jSONObject3.optJSONObject("level_low");
                if (optJSONObject3 != null) {
                    aVar.f().f(optJSONObject3.optDouble("avg_cpu_usage", 0.2d));
                    aVar.f().g(optJSONObject3.optLong("intervals", 30000L));
                    aVar.f().j(optJSONObject3.optInt("repeat_times", 2));
                    aVar.f().i(optJSONObject3.optInt("print_count", 5));
                    aVar.f().h(optJSONObject3.optBoolean("need_stack", false));
                }
            } catch (JSONException e16) {
                QLog.w("HP_CPU", 1, "[parse] CpuConfigBean exception=" + e16);
            }
            return aVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.enable = true;
        this.countThreshold = 6;
        this.cpuThreshold = 0.2d;
        this.highLeve = new com.tencent.mobileqq.power.config.b(LEVEL.HIGH, 0.4d, 10000L, 6, 10, true);
        this.midLeve = new com.tencent.mobileqq.power.config.b(LEVEL.MEDIUM, 0.3d, 10000L, 6, 10, false);
        this.lowLeve = new com.tencent.mobileqq.power.config.b(LEVEL.LOW, 0.2d, 30000L, 2, 5, false);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.countThreshold;
    }

    public final double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        return this.cpuThreshold;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    @NotNull
    public final com.tencent.mobileqq.power.config.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.power.config.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.highLeve;
    }

    @NotNull
    public final com.tencent.mobileqq.power.config.b e(double usage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.power.config.b) iPatchRedirector.redirect((short) 11, this, Double.valueOf(usage));
        }
        if (usage >= this.highLeve.a()) {
            return this.highLeve;
        }
        if (usage >= this.midLeve.a()) {
            return this.midLeve;
        }
        return this.lowLeve;
    }

    @NotNull
    public final com.tencent.mobileqq.power.config.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.power.config.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.lowLeve;
    }

    @NotNull
    public final com.tencent.mobileqq.power.config.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.power.config.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.midLeve;
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.countThreshold = i3;
        }
    }

    public final void i(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16));
        } else {
            this.cpuThreshold = d16;
        }
    }

    public final void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.enable = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "{enable:" + this.enable + ",countThreshold:" + this.countThreshold + ",cpuThreshold:" + this.cpuThreshold + ",highLeve:" + this.highLeve + ",midLeve:" + this.midLeve + ",lowLeve:" + this.lowLeve;
    }
}
