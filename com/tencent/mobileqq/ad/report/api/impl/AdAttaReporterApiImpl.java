package com.tencent.mobileqq.ad.report.api.impl;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J4\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH\u0016J0\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\bH\u0016J\"\u0010\u000e\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/ad/report/api/impl/AdAttaReporterApiImpl;", "Lcom/tencent/mobileqq/ad/report/api/IAdAttaReporterApi;", "", AdAttaReporterApiImpl.KEY_OPERNAME, "module", "action", "", "report", "", "ext", "ext2", "uin", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "reportWithUin", "<init>", "()V", "Companion", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AdAttaReporterApiImpl implements IAdAttaReporterApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String DEVICE_LEVEL = "device_level";

    @NotNull
    private static final String HOST = "https://h.trace.qq.com/kv";

    @NotNull
    private static final String KEY_ACTION = "action";

    @NotNull
    private static final String KEY_ATTA_ID = "attaid";

    @NotNull
    private static final String KEY_ATTA_TYPE = "Atta-Type";

    @NotNull
    private static final String KEY_BAND = "band";

    @NotNull
    private static final String KEY_EVENT_CODE = "event_code";

    @NotNull
    private static final String KEY_EXT2 = "ext2";

    @NotNull
    private static final String KEY_MODEL = "model";

    @NotNull
    private static final String KEY_MODULE = "module";

    @NotNull
    private static final String KEY_OPERNAME = "opername";

    @NotNull
    private static final String KEY_OS_VERSION = "os_version";

    @NotNull
    private static final String KEY_PLATFORM = "platform";

    @NotNull
    private static final String KEY_SDK_INT = "sdk_int";

    @NotNull
    private static final String KEY_TOKEN = "token";

    @NotNull
    private static final String KEY_UIN = "uin";

    @NotNull
    private static final String KEY_VERSION_CODE = "app_version";

    @NotNull
    private static final String REQUEST_TYPE = "GET";

    @NotNull
    private static final String TAG = "AdAttaReporter";

    @NotNull
    private static final String VALUE_ATTA_ID = "0e500076682";

    @NotNull
    private static final String VALUE_ATTA_PLATFORM = "Android";

    @NotNull
    private static final String VALUE_ATTA_TYPE = "batch-report";

    @NotNull
    private static final String VALUE_TOKEN = "8864647533";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/ad/report/api/impl/AdAttaReporterApiImpl$a;", "", "", "DEVICE_LEVEL", "Ljava/lang/String;", "HOST", AutoStartMonitor.AutoStartBean.KEY_ACTION, "KEY_ATTA_ID", "KEY_ATTA_TYPE", "KEY_BAND", "KEY_EVENT_CODE", "KEY_EXT2", "KEY_MODEL", "KEY_MODULE", "KEY_OPERNAME", "KEY_OS_VERSION", "KEY_PLATFORM", "KEY_SDK_INT", "KEY_TOKEN", "KEY_UIN", "KEY_VERSION_CODE", "REQUEST_TYPE", "TAG", "VALUE_ATTA_ID", "VALUE_ATTA_PLATFORM", "VALUE_ATTA_TYPE", "VALUE_TOKEN", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.report.api.impl.AdAttaReporterApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AdAttaReporterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportWithUin$lambda$3(Map reportParams, String uin) {
        String message;
        List list;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (QLog.isColorLevel()) {
            list = MapsKt___MapsKt.toList(reportParams);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            QLog.i(TAG, 2, "reportParams: " + joinToString$default);
        }
        Uri.Builder buildUpon = Uri.parse("https://h.trace.qq.com/kv").buildUpon();
        buildUpon.appendQueryParameter("token", VALUE_TOKEN);
        buildUpon.appendQueryParameter(KEY_ATTA_ID, VALUE_ATTA_ID);
        buildUpon.appendQueryParameter("uin", uin);
        buildUpon.appendQueryParameter("platform", "Android");
        buildUpon.appendQueryParameter(KEY_BAND, Build.BOARD);
        buildUpon.appendQueryParameter("model", DeviceInfoMonitor.getModel());
        buildUpon.appendQueryParameter("app_version", AppSetting.f99551k);
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        buildUpon.appendQueryParameter(KEY_SDK_INT, String.valueOf(Build.VERSION.SDK_INT));
        buildUpon.appendQueryParameter("device_level", String.valueOf(QCircleDeviceInfoUtils.getLevel()));
        for (Map.Entry entry : reportParams.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        Bundle bundle = new Bundle();
        bundle.putString("Atta-Type", "batch-report");
        try {
            message = HttpUtil.openUrl(BaseApplication.getContext(), uri, "GET", null, bundle);
        } catch (IOException e16) {
            QLog.e(TAG, 1, "report atta IOException, url=" + uri, e16);
            message = e16.getMessage();
        } catch (ClassNotFoundException e17) {
            QLog.e(TAG, 1, "report atta ClassNotFoundException, url=" + uri, e17);
            message = e17.getMessage();
        }
        QLog.i(TAG, 1, "report atta, result = " + message);
    }

    @Override // com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi
    public void report(@NotNull String opername, @NotNull String module, @NotNull String action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, opername, module, action);
            return;
        }
        Intrinsics.checkNotNullParameter(opername, "opername");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_OPERNAME, opername);
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("event_code", opername + "#" + module + "#" + action);
        report(hashMap);
    }

    public final void reportWithUin(@NotNull final Map<String, ? extends Object> reportParams, @NotNull final String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reportParams, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(uin, "uin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.report.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AdAttaReporterApiImpl.reportWithUin$lambda$3(reportParams, uin);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi
    public void report(@NotNull String opername, @NotNull String module, @NotNull String action, @NotNull Map<String, String> ext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, opername, module, action, ext);
            return;
        }
        Intrinsics.checkNotNullParameter(opername, "opername");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ext, "ext");
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_OPERNAME, opername);
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("event_code", opername + "#" + module + "#" + action);
        hashMap.putAll(ext);
        report(hashMap);
    }

    @Override // com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi
    public void report(@NotNull String opername, @NotNull String module, @NotNull String action, @NotNull String ext2, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, opername, module, action, ext2, uin);
            return;
        }
        Intrinsics.checkNotNullParameter(opername, "opername");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(uin, "uin");
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_OPERNAME, opername);
        hashMap.put("module", module);
        hashMap.put("action", action);
        hashMap.put("event_code", opername + "#" + module + "#" + action);
        hashMap.put("ext2", ext2);
        reportWithUin(hashMap, uin);
    }

    @Override // com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi
    public void report(@NotNull Map<String, ? extends Object> reportParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reportParams);
            return;
        }
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        String currentUin = VasUtil.getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        reportWithUin(reportParams, currentUin);
    }
}
