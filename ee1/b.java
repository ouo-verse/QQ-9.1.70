package ee1;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.av;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.report.ATTAReporter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJJ\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t\u00a8\u0006\u0010"}, d2 = {"Lee1/b;", "", "", "operId", "operType", "pageId", "moduleId", "pageName", "moduleName", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "b", "<init>", "()V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String operId, Map reportParams, String operType, String pageId, String moduleId, String pageName, String moduleName) {
        String str;
        Object obj;
        List list;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(operId, "$operId");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        Intrinsics.checkNotNullParameter(operType, "$operType");
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(moduleId, "$moduleId");
        Intrinsics.checkNotNullParameter(pageName, "$pageName");
        Intrinsics.checkNotNullParameter(moduleName, "$moduleName");
        if (QLog.isColorLevel()) {
            list = MapsKt___MapsKt.toList(reportParams);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
            QLog.i("MetaDreamAttaReporter", 2, "report: " + operId + " reportParams: " + joinToString$default);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int netWorkType = NetworkUtil.getNetWorkType();
        if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
            netWorkType = 0;
        }
        Uri.Builder buildUpon = Uri.parse("https://h.trace.qq.com/kv").buildUpon();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "runtime?.currentUin ?: \"\"");
        }
        buildUpon.appendQueryParameter("uin", str);
        buildUpon.appendQueryParameter("time_stamp", String.valueOf(System.currentTimeMillis()));
        buildUpon.appendQueryParameter(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
        buildUpon.appendQueryParameter("os_version", Build.VERSION.RELEASE);
        buildUpon.appendQueryParameter("device_number", o.b());
        buildUpon.appendQueryParameter("device_rom", Build.DISPLAY);
        buildUpon.appendQueryParameter("device_type", Build.BRAND);
        buildUpon.appendQueryParameter("device_model", DeviceInfoMonitor.getModel());
        buildUpon.appendQueryParameter("platform", "1");
        buildUpon.appendQueryParameter("net_type", String.valueOf(AppConstants.NET_TYPE_NAME[netWorkType]));
        buildUpon.appendQueryParameter("user_ip", av.b());
        buildUpon.appendQueryParameter("resolution", MobileInfoUtil.getResolution());
        buildUpon.appendQueryParameter("attaid", "02200075861");
        buildUpon.appendQueryParameter("token", "1822933261");
        buildUpon.appendQueryParameter(WadlReportBuilder.TableElem.OPER_ID, operId);
        buildUpon.appendQueryParameter("oper_type", operType);
        buildUpon.appendQueryParameter("page_id", pageId);
        buildUpon.appendQueryParameter("module_id", moduleId);
        buildUpon.appendQueryParameter("page_name", pageName);
        buildUpon.appendQueryParameter("module_name", moduleName);
        for (Map.Entry entry : reportParams.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        Bundle bundle = new Bundle();
        bundle.putString(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
        try {
            obj = HttpUtil.openUrl(BaseApplication.getContext(), uri, "GET", null, bundle);
        } catch (IOException e16) {
            QLog.e("MetaDreamAttaReporter", 1, "report atta IOException, url=" + uri, e16);
            obj = Unit.INSTANCE;
        } catch (ClassNotFoundException e17) {
            QLog.e("MetaDreamAttaReporter", 1, "report atta ClassNotFoundException, url=" + uri, e17);
            obj = Unit.INSTANCE;
        }
        QLog.i("MetaDreamAttaReporter", 1, "report atta, result = " + obj);
    }

    public final void b(@NotNull final String operId, @NotNull final String operType, @NotNull final String pageId, @NotNull final String moduleId, @NotNull final String pageName, @NotNull final String moduleName, @NotNull final Map<String, ? extends Object> reportParams) {
        Intrinsics.checkNotNullParameter(operId, "operId");
        Intrinsics.checkNotNullParameter(operType, "operType");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        ThreadManagerV2.excute(new Runnable() { // from class: ee1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(operId, reportParams, operType, pageId, moduleId, pageName, moduleName);
            }
        }, 128, null, false);
    }
}
