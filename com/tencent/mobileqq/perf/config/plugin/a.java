package com.tencent.mobileqq.perf.config.plugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/perf/config/plugin/a;", "", "", "toString", "", "a", "D", "sampleRatio", "", "b", "J", "loopInterval", "c", "eventSampleRatio", "", "d", "I", "procOnceReportLimit", "e", "dailyReportLimit", "Lorg/json/JSONObject;", "pluginJson", "<init>", "(Lorg/json/JSONObject;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public double sampleRatio;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public long loopInterval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public double eventSampleRatio;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int procOnceReportLimit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int dailyReportLimit;

    public a(@Nullable JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.loopInterval = 5000L;
        if (jSONObject != null) {
            this.sampleRatio = com.tencent.mobileqq.perf.tool.b.c(jSONObject, "sampleRatio", 0.0d);
            this.eventSampleRatio = com.tencent.mobileqq.perf.tool.b.c(jSONObject, "eventSampleRatio", 0.0d);
            this.procOnceReportLimit = com.tencent.mobileqq.perf.tool.b.d(jSONObject, "procOnceReportLimit", 0);
            this.dailyReportLimit = com.tencent.mobileqq.perf.tool.b.d(jSONObject, "dailyReportLimit", 0);
            this.loopInterval = com.tencent.mobileqq.perf.tool.b.f(jSONObject, "loopInterval", 5000L);
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BasePluginConfig(sampleRatio=" + this.sampleRatio + ", loopInterval=" + this.loopInterval + ", eventSampleRatio=" + this.eventSampleRatio + ", procOnceReportLimit=" + this.procOnceReportLimit + ", dailyReportLimit=" + this.dailyReportLimit + ')';
    }
}
