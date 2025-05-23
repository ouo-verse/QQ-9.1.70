package com.qzone.module.personalitycomponent.coverWidget;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\nR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/module/personalitycomponent/coverWidget/l;", "", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Lcom/qzone/module/personalitycomponent/coverWidget/a;", "b", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "callback", "", "d", "", "isClick", "Lcom/qzone/module/personalitycomponent/coverWidget/m;", "info", "c", "a", "Z", "isEnable", "()Z", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f49003a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean isEnable = VasNormalToggle.VAS_WIDGET_EXPOSE_SWITCH.isEnable(true);

    l() {
    }

    public final boolean a() {
        if (StudyModeManager.t()) {
            QLog.e("QzoneWidgetTianShuTool", 1, "cur is study mode");
            return false;
        }
        if (isEnable) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
            long decodeLong = VipMMKV.INSTANCE.getTianShuExpose().decodeLong(account + "_widget_expose_time", 0L);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / ((long) 1000);
            if (decodeLong != 0 && serverTimeMillis <= decodeLong) {
                QLog.e("QzoneWidgetTianShuTool", 1, "frequency is intercept");
                return false;
            }
        }
        return true;
    }

    public final ADInfo b(TianShuAccess.GetAdsRsp getAdsRsp) {
        ADInfo aDInfo = new ADInfo(null, null, null, 7, null);
        if (getAdsRsp != null && getAdsRsp.code.get() == 0 && !getAdsRsp.mapAds.isEmpty()) {
            List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.get();
            if (list.size() >= 1) {
                int i3 = 0;
                if (list.get(0).value.lst.size() >= 1) {
                    TianShuAccess.AdItem adItem = list.get(0).value.lst.get(0);
                    List<TianShuAccess.MapEntry> argMap = adItem.argList.get();
                    Intrinsics.checkNotNullExpressionValue(argMap, "argMap");
                    for (Object obj : argMap) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        TianShuAccess.MapEntry mapEntry = (TianShuAccess.MapEntry) obj;
                        String str = mapEntry.key.get();
                        String value = mapEntry.value.get();
                        if (QLog.isColorLevel()) {
                            QLog.w("QzoneWidgetTianShuTool", 1, "argList[" + i3 + "] : " + str + " " + value);
                        }
                        if (Intrinsics.areEqual(str, "pic")) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            aDInfo.d(value);
                        } else if (Intrinsics.areEqual(str, "url")) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            aDInfo.e(value);
                        }
                        i3 = i16;
                    }
                    aDInfo.getInfo().e(String.valueOf(adItem.iAdId.get()));
                    ReportInfo info = aDInfo.getInfo();
                    String str2 = adItem.traceinfo.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "traceinfo.get()");
                    info.h(str2);
                    aDInfo.getInfo().g("tianshu.64");
                    aDInfo.getInfo().f("tianshu.64");
                    return aDInfo;
                }
            }
            QLog.w("QzoneWidgetTianShuTool", 1, "ads is null");
            return null;
        }
        QLog.w("QzoneWidgetTianShuTool", 1, "rsp null");
        return null;
    }

    public final void c(boolean isClick, ReportInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = info.getAppid();
        tianShuReportData.mPageId = info.getPageId();
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = info.getAdId();
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        if (isClick) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mPositionId = "1211";
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = info.getTraceInfo();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        if (isEnable) {
            VipMMKV.INSTANCE.getTianShuExpose().encodeLong(account + "_widget_expose_time", serverTimeMillis + 86400);
        }
    }

    public final void d(TianShuGetAdvCallback callback) {
        List<TianShuAdPosItemData> listOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1211;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, callback);
    }
}
