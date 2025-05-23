package com.tencent.mobileqq.qwallet.report.beacon.cgi.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.report.beacon.QWalletTechBeaconReport;
import com.tencent.mobileqq.qwallet.report.beacon.cgi.IQWalletCgiReport;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nl2.CgiReportBean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/report/beacon/cgi/impl/QWalletCgiReportImpl;", "Lcom/tencent/mobileqq/qwallet/report/beacon/cgi/IQWalletCgiReport;", "Lnl2/a;", "cgiReportBean", "", "isForceReport", "", "report", "", "retCode", "shouldReportRequestBody", "Lcom/tencent/mobileqq/qwallet/report/beacon/QWalletTechBeaconReport;", "reporter$delegate", "Lkotlin/Lazy;", "getReporter", "()Lcom/tencent/mobileqq/qwallet/report/beacon/QWalletTechBeaconReport;", "reporter", "isFeatureSwitchOn$delegate", "isFeatureSwitchOn", "()Z", "", "sampleRate", "I", "", "forceReportUinList", "Ljava/util/List;", "retCodesForReqBody", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletCgiReportImpl implements IQWalletCgiReport {

    @Nullable
    private final List<String> forceReportUinList;

    /* renamed from: isFeatureSwitchOn$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFeatureSwitchOn;

    /* renamed from: reporter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy reporter;

    @Nullable
    private final List<String> retCodesForReqBody;
    private final int sampleRate;

    public QWalletCgiReportImpl() {
        Lazy lazy;
        Lazy lazy2;
        List<String> list;
        String optString;
        String optString2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletTechBeaconReport>() { // from class: com.tencent.mobileqq.qwallet.report.beacon.cgi.impl.QWalletCgiReportImpl$reporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletTechBeaconReport invoke() {
                return new QWalletTechBeaconReport();
            }
        });
        this.reporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qwallet.report.beacon.cgi.impl.QWalletCgiReportImpl$isFeatureSwitchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_CGI_REPORT, false));
            }
        });
        this.isFeatureSwitchOn = lazy2;
        List<String> list2 = null;
        if (isFeatureSwitchOn()) {
            JSONObject jSONObject = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).getJSONObject(IQWalletFeatureApi.QWALLET_CGI_REPORT);
            this.sampleRate = jSONObject != null ? jSONObject.optInt(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE) : 5;
            if (jSONObject != null && (optString2 = jSONObject.optString("uin_list")) != null) {
                list = StringsKt__StringsKt.split$default((CharSequence) optString2, new String[]{","}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            this.forceReportUinList = list;
            if (jSONObject != null && (optString = jSONObject.optString("ret_code_4_req_body")) != null) {
                list2 = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
            }
            this.retCodesForReqBody = list2;
            return;
        }
        this.sampleRate = 5;
        this.forceReportUinList = null;
        this.retCodesForReqBody = null;
    }

    private final QWalletTechBeaconReport getReporter() {
        return (QWalletTechBeaconReport) this.reporter.getValue();
    }

    private final boolean isFeatureSwitchOn() {
        return ((Boolean) this.isFeatureSwitchOn.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isForceReport(CgiReportBean cgiReportBean) {
        boolean z16;
        String str;
        if (!Intrinsics.areEqual(cgiReportBean.getRetCode(), "0")) {
            return true;
        }
        List<String> list = this.forceReportUinList;
        if (list != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (str = peekAppRuntime.getCurrentAccountUin()) == null) {
                str = "";
            }
            if (list.contains(str)) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.qwallet.report.beacon.cgi.IQWalletCgiReport
    public void report(@NotNull CgiReportBean cgiReportBean) {
        Intrinsics.checkNotNullParameter(cgiReportBean, "cgiReportBean");
        getReporter().d(cgiReportBean.getEventCode(), cgiReportBean.k(), this.sampleRate, isForceReport(cgiReportBean));
    }

    @Override // com.tencent.mobileqq.qwallet.report.beacon.cgi.IQWalletCgiReport
    public boolean shouldReportRequestBody(@NotNull String retCode) {
        boolean z16;
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        List<String> list = this.retCodesForReqBody;
        if (list != null && list.contains(retCode)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }
}
