package com.tencent.mobileqq.qqshop.report.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqshop.message.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/msg/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/gdtad/aditem/GdtAd;", "f", "", AdMetricTag.Report.TYPE, "", "g", "gdtAd", "", "c", "b", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "traceId", "j", "o", "e", "Landroid/content/Context;", "d", DomainData.DOMAIN_NAME, "l", "k", "", "Ljava/util/Set;", "mHasCheckedExpoUin", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f274720a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> mHasCheckedExpoUin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40707);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f274720a = new b();
            mHasCheckedExpoUin = new LinkedHashSet();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(GdtAd gdtAd, int reportType) {
        if (reportType == 1) {
            m();
        }
        String c16 = c(gdtAd, reportType);
        if (TextUtils.isEmpty(c16)) {
            QLog.d("QQShopMsgReportHelper", 1, "doReport return: rt:", Integer.valueOf(reportType));
            return;
        }
        QLog.d("QQShopMsgReportHelper", 2, "reportUrl:", c16);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(c16);
        String traceId = gdtAd.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        o(traceId, reportType);
    }

    private final String c(GdtAd gdtAd, int reportType) {
        String str;
        String reportUrl;
        String reportUrl2;
        if (gdtAd == null) {
            QLog.d("QQShopMsgReportHelper", 1, "getAmsReportUrl return: ad is null: rt:", Integer.valueOf(reportType));
            return "";
        }
        String traceId = gdtAd.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        if (j(traceId, reportType)) {
            QLog.d("QQShopMsgReportHelper", 1, "getAmsReportUrl hasMsgAdReported: rt:", Integer.valueOf(reportType));
            return "";
        }
        String reportUrl3 = gdtAd.getMsgRedPointReportUrl();
        if (TextUtils.isEmpty(reportUrl3)) {
            QLog.d("QQShopMsgReportHelper", 1, "getAmsReportUrl error: url is empty: rt:", Integer.valueOf(reportType));
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(reportUrl3, "reportUrl");
        String viewId = gdtAd.getViewId();
        if (viewId == null) {
            str = "";
        } else {
            str = viewId;
        }
        reportUrl = StringsKt__StringsJVMKt.replace$default(reportUrl3, "__VIEW_ID__", str, false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(reportUrl, "reportUrl");
        reportUrl2 = StringsKt__StringsJVMKt.replace$default(reportUrl, "__RT__", String.valueOf(reportType), false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(reportUrl2, "reportUrl");
        return reportUrl2;
    }

    private final Context d() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    private final String e() {
        String currentAccountUin = com.tencent.mobileqq.ecshop.utils.a.a().getCurrentAccountUin();
        if (currentAccountUin == null) {
            return "";
        }
        return currentAccountUin;
    }

    private final GdtAd f(MsgRecord msgRecord) {
        qq_ad_get.QQAdGetRsp.AdInfo f16 = d.f274478a.f(msgRecord);
        if (f16 == null) {
            return null;
        }
        return new GdtAd(f16);
    }

    private final void g(final int reportType) {
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(1, "u_2ZRcriDgt2a46svnxKPPMw", ""), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qqshop.report.msg.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                b.h(reportType, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, int i16, String str, ArrayList msgList) {
        MsgRecord msgRecord;
        try {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            if (!msgList.isEmpty()) {
                msgRecord = (MsgRecord) msgList.get(0);
            } else {
                msgRecord = null;
            }
            b bVar = f274720a;
            GdtAd f16 = bVar.f(msgRecord);
            if (f16 == null) {
                if (i3 == 1) {
                    bVar.m();
                    return;
                }
                return;
            }
            bVar.b(f16, i3);
        } catch (Exception e16) {
            QLog.e("QQShopMsgReportHelper", 1, "getLastMsgAndReport error:", e16);
        }
    }

    private final boolean i() {
        String e16 = e();
        if (TextUtils.isEmpty(e16)) {
            return false;
        }
        return mHasCheckedExpoUin.contains(e16);
    }

    private final boolean j(String traceId, int reportType) {
        String str;
        if (TextUtils.isEmpty(traceId)) {
            return false;
        }
        if (reportType == 1) {
            str = "KEY_LAST_MSG_AD_REPORT_EXPO_TRACE_ID_";
        } else {
            str = "KEY_LAST_MSG_AD_REPORT_CLICK_TRACE_ID_";
        }
        String str2 = str + e();
        MMKVOptionEntity from = QMMKV.from(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        return TextUtils.equals(traceId, from.decodeString(str2, ""));
    }

    private final void m() {
        String e16 = e();
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        mHasCheckedExpoUin.add(e16);
    }

    private final void o(String traceId, int reportType) {
        String str;
        if (TextUtils.isEmpty(traceId)) {
            QLog.e("QQShopMsgReportHelper", 1, "updateMsgAdReportCache error: traceId is empty");
            return;
        }
        if (reportType == 1) {
            str = "KEY_LAST_MSG_AD_REPORT_EXPO_TRACE_ID_";
        } else {
            str = "KEY_LAST_MSG_AD_REPORT_CLICK_TRACE_ID_";
        }
        String str2 = str + e();
        MMKVOptionEntity from = QMMKV.from(d(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString(str2, traceId);
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d("QQShopMsgReportHelper", 1, "reportMsgClick");
            g(2);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (i()) {
                return;
            }
            QLog.d("QQShopMsgReportHelper", 1, "reportMsgExpo");
            g(1);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String e16 = e();
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        mHasCheckedExpoUin.remove(e16);
    }
}
