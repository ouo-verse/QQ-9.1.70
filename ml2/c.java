package ml2;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lml2/c;", "", "", "actionId", "", "adId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "a", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f416921a = new c();

    c() {
    }

    public final void a(int actionId, @Nullable String adId, @Nullable String traceInfo) {
        QLog.i("QWalletTianShuReporter", 1, "report " + actionId + TokenParser.SP + adId + TokenParser.SP + traceInfo);
        TianShuReportData tianShuReportData = new TianShuReportData();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.mobileqq.base.a.c());
        sb5.append(util.base64_pad_url);
        sb5.append(NetConnInfoCenter.getServerTime());
        tianShuReportData.mTraceId = sb5.toString();
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.56";
        tianShuReportData.mPageId = "tianshu.56";
        if (adId == null) {
            adId = "";
        }
        tianShuReportData.mItemId = adId;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTime();
        if (traceInfo == null) {
            traceInfo = "";
        }
        tianShuReportData.mTriggerInfo = traceInfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }
}
