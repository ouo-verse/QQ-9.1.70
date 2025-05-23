package com.tencent.qmethod.monitor.report.base.reporter.uvreport;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.config.CacheTime;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.GeneralRule;
import com.tencent.qmethod.monitor.config.HighFrequency;
import com.tencent.qmethod.monitor.config.Silence;
import com.tencent.qmethod.monitor.config.bean.ConfigRule;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.config.c;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u000f\u0010\u0014\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/uvreport/AppConfigReport;", "Landroid/os/Handler;", "", "g", "j", "Lcom/tencent/qmethod/monitor/config/c;", "networkConfig", "i", "ruleConfig", "", "eventCode", "Lorg/json/JSONArray;", "e", "Lcom/tencent/qmethod/monitor/config/bean/ConfigRule;", TransferConfig.ExtendParamFloats.KEY_RULE, "c", "Lcom/tencent/qmethod/monitor/config/bean/e;", "sceneSampleRate", "f", "d", h.F, "()V", DownloadInfo.spKey_Config, "k", "(Ljava/lang/String;)V", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class AppConfigReport extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final AppConfigReport f343851a = new AppConfigReport();

    AppConfigReport() {
        super(ThreadManager.f343506c.b());
    }

    private final String c(ConfigRule rule, String eventCode) {
        String str;
        GeneralRule generalRule = rule.getCom.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ExtendParamFloats.KEY_RULE java.lang.String();
        if (generalRule != null) {
            str = generalRule.getValue();
        } else {
            str = "";
        }
        HighFrequency highFrequency = rule.getHighFrequency();
        if (highFrequency != null) {
            str = str + "#" + highFrequency.name();
        }
        CacheTime cacheTime = rule.getCacheTime();
        if (cacheTime != null) {
            str = str + "#" + cacheTime.name();
        }
        Silence silence = rule.getSilence();
        if (silence != null) {
            str = str + "#" + silence.name();
        }
        return or3.a.f423465b.b(eventCode, DTConstants.TAG.API, rule.getModule(), NetworkUtil.f343513c.c(rule.getCom.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants.TAG.API java.lang.String()), rule.getPage(), str);
    }

    private final String d() {
        return or3.a.c(or3.a.f423465b, "globalConfig", DTConstants.TAG.API, com.tencent.qmethod.monitor.a.f343451h.e().getGlobalConfigType().name(), null, null, null, 56, null);
    }

    private final JSONArray e(c ruleConfig, String eventCode) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, ConfigRule>> it = ruleConfig.h().entrySet().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(f343851a.c(it.next().getValue(), eventCode));
        }
        Iterator<Map.Entry<String, e>> it5 = ruleConfig.j().entrySet().iterator();
        while (it5.hasNext()) {
            jSONArray.mo162put(f343851a.f(it5.next().getValue(), eventCode));
        }
        return jSONArray;
    }

    private final String f(e sceneSampleRate, String eventCode) {
        return or3.a.c(or3.a.f423465b, eventCode, "sample", sceneSampleRate.getScene(), String.valueOf(sceneSampleRate.getRate()), String.valueOf(sceneSampleRate.getMaxReport()), null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        or3.a aVar = or3.a.f423465b;
        JSONArray e16 = e(com.tencent.qmethod.monitor.a.f343451h.e(), "appConfig");
        e16.mo162put(f343851a.d());
        aVar.a(e16);
    }

    private final void i(c networkConfig) {
        c cVar = new c();
        for (Map.Entry<String, ConfigRule> entry : networkConfig.h().entrySet()) {
            cVar.h().put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, e> entry2 : networkConfig.j().entrySet()) {
            cVar.j().put(entry2.getKey(), entry2.getValue());
        }
        for (Map.Entry<String, ConfigRule> entry3 : com.tencent.qmethod.monitor.a.f343451h.e().h().entrySet()) {
            if (cVar.h().get(entry3.getKey()) == null) {
                cVar.h().put(entry3.getKey(), entry3.getValue());
            }
        }
        for (Map.Entry<String, e> entry4 : com.tencent.qmethod.monitor.a.f343451h.e().j().entrySet()) {
            if (cVar.j().get(entry4.getKey()) == null) {
                cVar.j().put(entry4.getKey(), entry4.getValue());
            }
        }
        or3.a.f423465b.a(e(cVar, "mergeConfig"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        String d16 = f.d("network_config");
        if (d16 != null) {
            try {
                if (TextUtils.isEmpty(d16)) {
                    return;
                }
                c k3 = ConfigManager.f343549h.k(new JSONObject(NetworkUtil.f343513c.d(d16)));
                or3.a aVar = or3.a.f423465b;
                AppConfigReport appConfigReport = f343851a;
                aVar.a(appConfigReport.e(k3, "networkConfig"));
                appConfigReport.i(k3);
            } catch (Exception e16) {
                o.d("AppConfigReport", "reportNetworkConfig", e16);
            }
        }
    }

    public final void h() {
        post(new Runnable() { // from class: com.tencent.qmethod.monitor.report.base.reporter.uvreport.AppConfigReport$reportConfig$1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug() || SampleHelper.z(SampleHelper.f343779l, 0.001d, 0, 0, 6, null)) {
                    try {
                        AppConfigReport appConfigReport = AppConfigReport.f343851a;
                        appConfigReport.g();
                        appConfigReport.j();
                    } catch (Exception e16) {
                        o.d("AppConfigReport", "reportConfig error", e16);
                    }
                }
            }
        });
    }

    public final void k(@NotNull String config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        f.g("network_config", config);
    }
}
