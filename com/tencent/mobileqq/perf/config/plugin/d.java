package com.tencent.mobileqq.perf.config.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/d;", "Lcom/tencent/mobileqq/perf/config/plugin/a;", "", "toString", "", "f", "I", "threshold", "g", "maintainCount", h.F, "topReportMax", "", "i", "J", "monitorInterval", "Lorg/json/JSONObject;", "pluginJson", "<init>", "(Lorg/json/JSONObject;)V", "j", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int threshold;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int maintainCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int topReportMax;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long monitorInterval;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.config.plugin.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.maintainCount = 20;
        this.topReportMax = 5;
        this.monitorInterval = 2000L;
        if (jSONObject != null) {
            QLog.d("BaseHighStringMonitorCfg", 2, "[config] parse: invoked. ", " pluginJson: ", jSONObject.toString());
            try {
                if (jSONObject.has("maintainCount")) {
                    this.maintainCount = jSONObject.getInt("maintainCount");
                }
                if (jSONObject.has("topReportMax")) {
                    this.topReportMax = jSONObject.getInt("topReportMax");
                }
                if (jSONObject.has("monitorInterval")) {
                    this.monitorInterval = jSONObject.getLong("monitorInterval");
                }
                if (jSONObject.has("threshold")) {
                    this.threshold = jSONObject.getInt("threshold");
                }
            } catch (Throwable th5) {
                QLog.e("BaseHighStringMonitorCfg", 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.perf.config.plugin.a
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HighStringMonitorConfig(threshold=" + this.threshold + ", maintainCount=" + this.maintainCount + ", topReportMax=" + this.topReportMax + ", monitorInterval=" + this.monitorInterval + ", " + super.toString() + ')';
    }
}
