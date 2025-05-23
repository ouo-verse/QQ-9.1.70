package a63;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.pb.TianShuAccess;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r93.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"La63/d;", "", "", "adID", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "e", "b", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "c", "La63/b;", "bubbleInfo", "d", "Lkotlin/Function1;", "responseCallback", "f", "La63/d$a;", "La63/d$a;", "currentTianShuConfig", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f25611a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TianShuConfig currentTianShuConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"La63/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "bubblePosId", "Ljava/lang/String;", "()Ljava/lang/String;", "appID", "<init>", "(ILjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a63.d$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class TianShuConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bubblePosId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appID;

        public TianShuConfig(int i3, @NotNull String appID) {
            Intrinsics.checkNotNullParameter(appID, "appID");
            this.bubblePosId = i3;
            this.appID = appID;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppID() {
            return this.appID;
        }

        /* renamed from: b, reason: from getter */
        public final int getBubblePosId() {
            return this.bubblePosId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TianShuConfig)) {
                return false;
            }
            TianShuConfig tianShuConfig = (TianShuConfig) other;
            if (this.bubblePosId == tianShuConfig.bubblePosId && Intrinsics.areEqual(this.appID, tianShuConfig.appID)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.bubblePosId * 31) + this.appID.hashCode();
        }

        @NotNull
        public String toString() {
            return "TianShuConfig(bubblePosId=" + this.bubblePosId + ", appID=" + this.appID + ")";
        }
    }

    d() {
    }

    private final void b() {
        TianShuConfig tianShuConfig;
        if (h.f430993a.g()) {
            tianShuConfig = new TianShuConfig(1416, "tianshu.247");
        } else {
            tianShuConfig = null;
        }
        currentTianShuConfig = tianShuConfig;
    }

    private final List<TianShuAdPosItemData> c() {
        Integer num;
        List<TianShuAdPosItemData> mutableListOf;
        TianShuAdPosItemData[] tianShuAdPosItemDataArr = new TianShuAdPosItemData[1];
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        TianShuConfig tianShuConfig = currentTianShuConfig;
        if (tianShuConfig != null) {
            num = Integer.valueOf(tianShuConfig.getBubblePosId());
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        tianShuAdPosItemData.mPosId = num.intValue();
        Unit unit = Unit.INSTANCE;
        tianShuAdPosItemDataArr[0] = tianShuAdPosItemData;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(tianShuAdPosItemDataArr);
        return mutableListOf;
    }

    private final void e(String adID, String traceInfo) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        TianShuConfig tianShuConfig = currentTianShuConfig;
        String str2 = null;
        if (tianShuConfig != null) {
            str = tianShuConfig.getAppID();
        } else {
            str = null;
        }
        tianShuReportData.mAppId = str;
        TianShuConfig tianShuConfig2 = currentTianShuConfig;
        if (tianShuConfig2 != null) {
            str2 = tianShuConfig2.getAppID();
        }
        tianShuReportData.mPageId = str2;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mTraceId = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + tianShuReportData.mOperTime;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionId = 101;
        tianShuReportData.mTriggerInfo = traceInfo;
        tianShuReportData.mItemId = adID;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 responseCallback, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        boolean z17;
        Intrinsics.checkNotNullParameter(responseCallback, "$responseCallback");
        w53.b.f("WinkTianShuBubbleHelper", "loadTianShuConfig: code: " + getAdsRsp.code.get() + ", size: " + getAdsRsp.mapAds.size());
        if (getAdsRsp.code.get() == 0 && !getAdsRsp.mapAds.isEmpty()) {
            int size = getAdsRsp.mapAds.size();
            for (int i3 = 0; i3 < size; i3++) {
                TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(i3);
                int i16 = rspEntry.key.get();
                List<TianShuAccess.AdItem> list = rspEntry.value.get().lst.get();
                TianShuConfig tianShuConfig = currentTianShuConfig;
                if (tianShuConfig != null && i16 == tianShuConfig.getBubblePosId()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    Iterator<TianShuAccess.AdItem> it = list.iterator();
                    if (it.hasNext()) {
                        TianShuAccess.AdItem next = it.next();
                        String str = "";
                        String str2 = str;
                        for (TianShuAccess.MapEntry mapEntry : next.argList.get()) {
                            String value = mapEntry.value.get();
                            String str3 = mapEntry.key.get();
                            if (Intrinsics.areEqual(str3, "menuID")) {
                                Intrinsics.checkNotNullExpressionValue(value, "value");
                                str = value;
                            } else if (Intrinsics.areEqual(str3, "bubbleText")) {
                                Intrinsics.checkNotNullExpressionValue(value, "value");
                                str2 = value;
                            }
                        }
                        responseCallback.invoke(new WinkBubbleInfo(str, str2, 3, 0L, next.traceinfo.get(), String.valueOf(next.iAdId.get()), 8, null));
                        return;
                    }
                }
            }
        }
    }

    public final void d(@NotNull WinkBubbleInfo bubbleInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        String tianShuADID = bubbleInfo.getTianShuADID();
        boolean z17 = false;
        if (tianShuADID != null && tianShuADID.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String tianShuTraceInfo = bubbleInfo.getTianShuTraceInfo();
            if (tianShuTraceInfo == null || tianShuTraceInfo.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                e(bubbleInfo.getTianShuADID(), bubbleInfo.getTianShuTraceInfo());
            }
        }
    }

    public final void f(@NotNull final Function1<? super WinkBubbleInfo, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        b();
        if (currentTianShuConfig == null) {
            return;
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(c(), new TianShuGetAdvCallback() { // from class: a63.c
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                d.g(Function1.this, z16, getAdsRsp);
            }
        });
    }
}
