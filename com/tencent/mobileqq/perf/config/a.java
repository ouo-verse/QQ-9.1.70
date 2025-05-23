package com.tencent.mobileqq.perf.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.config.plugin.b;
import com.tencent.mobileqq.perf.config.plugin.c;
import com.tencent.mobileqq.perf.config.plugin.d;
import com.tencent.mobileqq.perf.config.plugin.e;
import com.tencent.mobileqq.perf.config.plugin.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b9\u0010:R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0007\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u000f\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/perf/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/perf/config/plugin/a;", "e", "Lcom/tencent/mobileqq/perf/config/plugin/a;", "a", "()Lcom/tencent/mobileqq/perf/config/plugin/a;", "setCpuConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/a;)V", "cpuConfig", "Lcom/tencent/mobileqq/perf/config/plugin/f;", "f", "Lcom/tencent/mobileqq/perf/config/plugin/f;", "g", "()Lcom/tencent/mobileqq/perf/config/plugin/f;", "setRegularMemConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/f;)V", "regularMemConfig", "Lcom/tencent/mobileqq/perf/config/plugin/d;", h.F, "Lcom/tencent/mobileqq/perf/config/plugin/d;", "()Lcom/tencent/mobileqq/perf/config/plugin/d;", "setHighLogConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/d;)V", "highLogConfig", "i", "setHighCmdConfig", "highCmdConfig", "Lcom/tencent/mobileqq/perf/config/plugin/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/perf/config/plugin/b;", "b", "()Lcom/tencent/mobileqq/perf/config/plugin/b;", "setEnvStateHistoryConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/b;)V", "envStateHistoryConfig", "Lcom/tencent/mobileqq/perf/config/plugin/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/perf/config/plugin/e;", "()Lcom/tencent/mobileqq/perf/config/plugin/e;", "setReceiverMonitorConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/e;)V", "receiverMonitorConfig", "Lcom/tencent/mobileqq/perf/config/plugin/c;", "D", "Lcom/tencent/mobileqq/perf/config/plugin/c;", "c", "()Lcom/tencent/mobileqq/perf/config/plugin/c;", "setGrayDex2oatConfig", "(Lcom/tencent/mobileqq/perf/config/plugin/c;)V", "grayDex2oatConfig", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private e receiverMonitorConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private c grayDex2oatConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.perf.config.plugin.a cpuConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f regularMemConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d highLogConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d highCmdConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b envStateHistoryConfig;

    public a(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jsonObject);
            return;
        }
        this.TAG = "QQPerfConfig";
        this.cpuConfig = new com.tencent.mobileqq.perf.config.plugin.a(null);
        this.regularMemConfig = new f(null);
        this.highLogConfig = new d(null);
        this.highCmdConfig = new d(null);
        this.envStateHistoryConfig = new b(null);
        this.receiverMonitorConfig = new e(null);
        this.grayDex2oatConfig = new c(null);
        this.cpuConfig = new com.tencent.mobileqq.perf.config.plugin.a(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "cpuConfig", new JSONObject()));
        this.regularMemConfig = new f(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "regularMemConfig", new JSONObject()));
        this.highLogConfig = new d(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "highLogCfg", new JSONObject()));
        this.highCmdConfig = new d(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "highCmdCfg", new JSONObject()));
        this.envStateHistoryConfig = new b(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "envStateHistoryConfig", new JSONObject()));
        this.receiverMonitorConfig = new e(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "receiverMonitorConfig", new JSONObject()));
        this.grayDex2oatConfig = new c(com.tencent.mobileqq.perf.tool.b.e(jsonObject, "grayDex2oatConfig", new JSONObject()));
    }

    @NotNull
    public final com.tencent.mobileqq.perf.config.plugin.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.perf.config.plugin.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.cpuConfig;
    }

    @NotNull
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.envStateHistoryConfig;
    }

    @NotNull
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.grayDex2oatConfig;
    }

    @NotNull
    public final d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.highCmdConfig;
    }

    @NotNull
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.highLogConfig;
    }

    @NotNull
    public final e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (e) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.receiverMonitorConfig;
    }

    @NotNull
    public final f g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.regularMemConfig;
    }
}
