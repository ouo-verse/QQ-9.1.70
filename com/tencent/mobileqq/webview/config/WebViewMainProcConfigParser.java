package com.tencent.mobileqq.webview.config;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/config/WebViewMainProcConfigParser;", "Lcom/tencent/mobileqq/webview/config/BaseUnitedConfig;", "Lcom/tencent/mobileqq/webview/config/WebViewMainProcConfig;", "", "content", "d", "b", "", "getGroup", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "e", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WebViewMainProcConfigParser extends BaseUnitedConfig<WebViewMainProcConfig> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WebViewMainProcConfig defaultConfig() {
        return new WebViewMainProcConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.config.BaseUnitedConfig, com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(WebViewMainProcConfig config) {
        PerfFeature.CustomFlag customFlag;
        String str;
        super.doOnConfigUpdate(config);
        boolean d16 = config != null ? config.d() : false;
        if (d16) {
            customFlag = PerfFeature.CustomFlag.WVMainProcEnable;
        } else {
            customFlag = PerfFeature.CustomFlag.WVMainProcDisEnable;
        }
        PerfFeature.a(customFlag);
        BaseApplication context = BaseApplication.getContext();
        if (d16) {
            str = "1";
        } else {
            str = "0";
        }
        CrashReport.putUserData(context, "WVMainProcEnable", str);
        if (QLog.isDevelopLevel()) {
            QLog.d("WebViewMainProc_configParser", 1, "WVMAINPROC_REPORT_doOnConfigUpdate enable=" + d16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public WebViewMainProcConfig parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            WebViewMainProcConfig webViewMainProcConfig = new WebViewMainProcConfig();
            webViewMainProcConfig.a(jSONObject);
            QLog.d("WebViewMainProc_configParser", 1, "parse result:" + webViewMainProcConfig);
            return webViewMainProcConfig;
        } catch (Exception e16) {
            QLog.d("WebViewMainProc_configParser", 1, "parse exception. ", e16);
            return defaultConfig();
        }
    }

    @Override // com.tencent.mobileqq.webview.config.BaseUnitedConfig
    public String getGroup() {
        return "webview_mainproc_config";
    }
}
