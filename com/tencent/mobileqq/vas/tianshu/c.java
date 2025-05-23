package com.tencent.mobileqq.vas.tianshu;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0005B%\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/tianshu/c;", "", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Lcom/tencent/mobileqq/vas/tianshu/a;", "a", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "callback", "", "c", "", "isClick", "Lcom/tencent/mobileqq/vas/tianshu/b;", "info", "b", "", "I", "adId", "appId", "", "", "Ljava/util/List;", "needParams", "<init>", "(IILjava/util/List;)V", "d", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int adId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> needParams;

    public c(int i3, int i16, @NotNull List<String> needParams) {
        Intrinsics.checkNotNullParameter(needParams, "needParams");
        this.adId = i3;
        this.appId = i16;
        this.needParams = needParams;
    }

    @Nullable
    public final ADInfo a(@Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
        ADInfo aDInfo = new ADInfo(null, null, 3, null);
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
                        String key = mapEntry.key.get();
                        String value = mapEntry.value.get();
                        if (QLog.isColorLevel()) {
                            QLog.w("VasTianShuRequest", 1, "argList[" + i3 + "] : " + key + " " + value);
                        }
                        if (this.needParams.contains(key)) {
                            Map<String, String> a16 = aDInfo.a();
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            a16.put(key, value);
                        }
                        i3 = i16;
                    }
                    aDInfo.getReportInfo().e(String.valueOf(adItem.iAdId.get()));
                    ReportInfo reportInfo = aDInfo.getReportInfo();
                    String str = adItem.traceinfo.get();
                    Intrinsics.checkNotNullExpressionValue(str, "traceinfo.get()");
                    reportInfo.h(str);
                    aDInfo.getReportInfo().g("tianshu." + this.appId);
                    aDInfo.getReportInfo().f("tianshu." + this.appId);
                    return aDInfo;
                }
            }
            QLog.w("VasTianShuRequest", 1, "ads is null");
            return null;
        }
        QLog.w("VasTianShuRequest", 1, "rsp null");
        return null;
    }

    public final void b(boolean isClick, @NotNull ReportInfo info) {
        String str;
        Intrinsics.checkNotNullParameter(info, "info");
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = info.getAppid();
        tianShuReportData.mPageId = info.getPageId();
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = info.getAdId();
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        if (isClick) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mPositionId = String.valueOf(this.adId);
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = info.getTraceInfo();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public final void c(@NotNull TianShuGetAdvCallback callback) {
        List<TianShuAdPosItemData> listOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = this.adId;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, callback);
    }
}
