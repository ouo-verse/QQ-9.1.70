package com.tencent.mobileqq.perf.config.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\nR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/b;", "", "", "toString", "", "a", "I", "b", "()I", "setLogCountThreshold", "(I)V", "logCountThreshold", "setGcCountThreshold", "gcCountThreshold", "c", "setPhysicalMemoryThreshold", "physicalMemoryThreshold", "", "d", "Z", "e", "()Z", "setSwitch", "(Z)V", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "D", "()D", "setReportRatio", "(D)V", "reportRatio", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "f", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int logCountThreshold;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int gcCountThreshold;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int physicalMemoryThreshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean switch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private double reportRatio;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/b$a;", "", "", "HIGH_FREQUENCY_GC_AVG_TEN_SECOND_THRESHOLD", "I", "HIGH_FREQUENCY_LOG_AVG_TEN_SECOND_THRESHOLD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.config.plugin.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.logCountThreshold = 20000;
        this.gcCountThreshold = 20;
        this.physicalMemoryThreshold = 4096;
        if (jSONObject != null) {
            this.logCountThreshold = jSONObject.optInt("logCountThreshold", 20000);
            this.gcCountThreshold = jSONObject.optInt("gcCountThreshold", 20);
            this.reportRatio = jSONObject.optDouble("reportRatio", 0.0d);
            this.physicalMemoryThreshold = jSONObject.optInt("physicalMemoryThreshold", 4096);
            this.switch = jSONObject.optBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, false);
            QLog.i("EnvStateHistoryConfig", 1, "\u89e3\u6790\u914d\u7f6e\u6210\u529f\uff0clogCountThreshold:" + this.logCountThreshold + ", gcCountThreshold:" + this.gcCountThreshold + ", physicalMemoryThreshold:" + this.physicalMemoryThreshold + ", switch:" + this.switch);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.gcCountThreshold;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.logCountThreshold;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.physicalMemoryThreshold;
    }

    public final double d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Double) iPatchRedirector.redirect((short) 10, (Object) this)).doubleValue();
        }
        return this.reportRatio;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.switch;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "EnvStateHistoryConfig(logCountThreshold=" + this.logCountThreshold + ", gcCountThreshold=" + this.gcCountThreshold + ", physicalMemoryThreshold=" + this.physicalMemoryThreshold + ", switch=" + this.switch + ", reportRatio=" + this.reportRatio + ')';
    }
}
