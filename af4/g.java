package af4;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.timi.game.utils.l;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\"\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0007J\u001c\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u0007J(\u0010 \u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010\"\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010#\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006&"}, d2 = {"Laf4/g;", "", "", TtmlNode.ATTR_TTS_ORIGIN, "f", "", "roomId", "", "liveContent", "Laf4/d;", "operationItem", "", "i", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "j", "adId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "actionId", "", "g", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "tianShuGetAdvCallback", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "ads", h.F, "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "rsp", "targetAdIds", WadlProxyConsts.SCENE_ID, "Laf4/c;", "c", "e", "operationItems", "b", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f26031a = new g();

    g() {
    }

    public static /* synthetic */ List d(g gVar, TianShuAccess.GetAdsRsp getAdsRsp, List list, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 1;
        }
        return gVar.c(getAdsRsp, list, i3);
    }

    private final String f(String origin) {
        boolean z16;
        String replace$default;
        if (origin != null && origin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            replace$default = StringsKt__StringsJVMKt.replace$default(origin, " ", "", false, 4, (Object) null);
            return replace$default;
        }
        return "";
    }

    private final boolean i(long roomId, int liveContent, OperationItem operationItem) {
        boolean contains$default;
        boolean contains$default2;
        if (operationItem != null) {
            if (operationItem.getContentFilter() >= 0) {
                if (operationItem.getContentFilter() != liveContent) {
                    return false;
                }
                return true;
            }
            if (roomId > 0) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) operationItem.getBroomid(), (CharSequence) String.valueOf(roomId), false, 2, (Object) null);
                if (contains$default) {
                    return false;
                }
                if (!TextUtils.isEmpty(operationItem.getWroomid())) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) operationItem.getWroomid(), (CharSequence) String.valueOf(roomId), false, 2, (Object) null);
                    return contains$default2;
                }
                return true;
            }
        }
        return false;
    }

    private final boolean j(OperationItem operationItem, long currentTime) {
        boolean z16;
        boolean z17;
        l.h("TimiTianshuAdManager_", 1, "currentTime:" + currentTime + ", operationItem:" + operationItem);
        if (operationItem.getStartTime() != -1 && operationItem.getEndTime() != -1 && currentTime >= operationItem.getStartTime() && currentTime <= operationItem.getEndTime()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (operationItem.getStartTime() == -1 && operationItem.getEndTime() == -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    public final long a(@NotNull List<OperationItem> operationItems, long currentTime) {
        Intrinsics.checkNotNullParameter(operationItems, "operationItems");
        l.h("TimiTianshuAdManager_", 1, "findNextEndTime currentTime:" + currentTime);
        long j3 = -1L;
        for (OperationItem operationItem : operationItems) {
            if (currentTime >= operationItem.getStartTime() && currentTime <= operationItem.getEndTime()) {
                if (j3 == -1) {
                    j3 = operationItem.getEndTime();
                } else if (j3 > operationItem.getEndTime()) {
                    j3 = operationItem.getEndTime();
                }
            }
        }
        return j3;
    }

    public final long b(@NotNull List<OperationItem> operationItems, long currentTime) {
        Intrinsics.checkNotNullParameter(operationItems, "operationItems");
        l.h("TimiTianshuAdManager_", 1, "findMinStartTime currentTime:" + currentTime);
        long j3 = -1L;
        for (OperationItem operationItem : operationItems) {
            if (currentTime < operationItem.getStartTime() || currentTime > operationItem.getEndTime()) {
                if (currentTime <= operationItem.getEndTime()) {
                    if (j3 == -1) {
                        j3 = operationItem.getStartTime();
                    } else if (j3 > operationItem.getStartTime()) {
                        j3 = operationItem.getStartTime();
                    }
                }
            }
        }
        return j3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0121. Please report as an issue. */
    @NotNull
    public final List<OperationData> c(@NotNull TianShuAccess.GetAdsRsp rsp, @NotNull List<Integer> targetAdIds, int sceneId) {
        boolean z16;
        Long longOrNull;
        Long longOrNull2;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        Long longOrNull3;
        TianShuAccess.GetAdsRsp rsp2 = rsp;
        Intrinsics.checkNotNullParameter(rsp2, "rsp");
        Intrinsics.checkNotNullParameter(targetAdIds, "targetAdIds");
        ArrayList arrayList = new ArrayList();
        boolean z17 = true;
        l.h("TimiTianshuAdManager_", 1, "code:" + rsp2.code.get() + ", msg:" + rsp2.errmsg.get());
        if (rsp2.code.get() == 0 && !rsp2.mapAds.isEmpty()) {
            int size = rsp2.mapAds.size();
            int i17 = 0;
            while (i17 < size) {
                TianShuAccess.RspEntry rspEntry = rsp2.mapAds.get(i17);
                int i18 = rspEntry.key.get();
                if (targetAdIds.contains(Integer.valueOf(i18))) {
                    TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value.get();
                    ArrayList arrayList2 = new ArrayList();
                    for (TianShuAccess.AdItem adItem : adPlacementInfo.lst.get()) {
                        List<TianShuAccess.MapEntry> list = adItem.argList.get();
                        OperationItem operationItem = new OperationItem(0, 0L, 0, null, null, null, null, null, 0, 0, false, null, null, 0, null, 0L, 0L, 0L, 0, 0L, null, null, 4194303, null);
                        operationItem.B(i18);
                        operationItem.I(adItem.iAdId.get());
                        String str = adItem.traceinfo.get();
                        Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
                        operationItem.T(str);
                        operationItem.Q(sceneId);
                        for (TianShuAccess.MapEntry mapEntry : list) {
                            String str2 = mapEntry.key.get();
                            if (str2 != null) {
                                long j3 = -1;
                                switch (str2.hashCode()) {
                                    case -1606289880:
                                        if (str2.equals(AEEditorConstants.VIDEO_CLIP_END_TIME)) {
                                            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(f(mapEntry.value.get()));
                                            if (longOrNull != null) {
                                                j3 = longOrNull.longValue();
                                            }
                                            operationItem.H(j3);
                                            break;
                                        }
                                        break;
                                    case -1293058560:
                                        if (str2.equals("etimer")) {
                                            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(f(mapEntry.value.get()));
                                            if (longOrNull2 != null) {
                                                j3 = longOrNull2.longValue();
                                            }
                                            operationItem.G(j3);
                                            break;
                                        }
                                        break;
                                    case -1165461084:
                                        if (str2.equals("priority")) {
                                            String str3 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str3, "arg.value.get()");
                                            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
                                            if (intOrNull != null) {
                                                i3 = intOrNull.intValue();
                                            } else {
                                                i3 = 0;
                                            }
                                            operationItem.N(i3);
                                            break;
                                        }
                                        break;
                                    case 110986:
                                        if (str2.equals("pic")) {
                                            String str4 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str4, "arg.value.get()");
                                            operationItem.M(new TimiPicInfo(str4, 2));
                                            break;
                                        }
                                        break;
                                    case 116079:
                                        if (str2.equals("url")) {
                                            String str5 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str5, "arg.value.get()");
                                            operationItem.K(str5);
                                            break;
                                        }
                                        break;
                                    case 3059506:
                                        if (str2.equals("cont")) {
                                            String str6 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str6, "arg.value.get()");
                                            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str6);
                                            if (intOrNull2 != null) {
                                                i16 = intOrNull2.intValue();
                                            } else {
                                                i16 = -1;
                                            }
                                            operationItem.E(i16);
                                            break;
                                        }
                                        break;
                                    case 3524345:
                                        if (str2.equals("scen")) {
                                            String str7 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str7, "arg.value.get()");
                                            operationItem.P(str7);
                                            break;
                                        }
                                        break;
                                    case 3575610:
                                        if (str2.equals("type")) {
                                            String str8 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str8, "arg.value.get()");
                                            operationItem.J(str8);
                                            break;
                                        }
                                        break;
                                    case 3619493:
                                        if (str2.equals("view")) {
                                            String str9 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str9, "arg.value.get()");
                                            operationItem.U(str9);
                                            break;
                                        }
                                        break;
                                    case 150696472:
                                        if (str2.equals("broomid")) {
                                            String str10 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str10, "arg.value.get()");
                                            operationItem.D(str10);
                                            break;
                                        }
                                        break;
                                    case 1316806687:
                                        if (str2.equals("startime")) {
                                            longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(f(mapEntry.value.get()));
                                            if (longOrNull3 != null) {
                                                j3 = longOrNull3.longValue();
                                            }
                                            operationItem.R(j3);
                                            break;
                                        }
                                        break;
                                    case 1608404589:
                                        if (str2.equals("wroomid")) {
                                            String str11 = mapEntry.value.get();
                                            Intrinsics.checkNotNullExpressionValue(str11, "arg.value.get()");
                                            operationItem.V(str11);
                                            break;
                                        }
                                        break;
                                }
                            }
                        }
                        arrayList2.add(operationItem);
                    }
                    if (arrayList2.size() != 0) {
                        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList2);
                        OperationData operationData = new OperationData(i18, arrayList2);
                        z16 = true;
                        l.a("TimiTianshuAdManager_", 1, "ad(" + i18 + "):" + operationData);
                        arrayList.add(operationData);
                        i17++;
                        rsp2 = rsp;
                        z17 = z16;
                    } else {
                        z17 = true;
                        l.c("TimiTianshuAdManager_", 1, "empty ad:" + i18);
                    }
                }
                z16 = z17;
                i17++;
                rsp2 = rsp;
                z17 = z16;
            }
        }
        return arrayList;
    }

    public final boolean e(long roomId, int liveContent, @Nullable OperationItem operationItem, long currentTime) {
        if (operationItem == null || !i(roomId, liveContent, operationItem)) {
            return false;
        }
        return j(operationItem, currentTime);
    }

    public final void g(@Nullable String adId, @Nullable String traceInfo, int actionId) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            str = "";
        } else {
            str = waitAppRuntime.getAccount();
            Intrinsics.checkNotNullExpressionValue(str, "appRuntime.getAccount()");
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.277";
        tianShuReportData.mPageId = "tianshu.277";
        tianShuReportData.mItemId = adId;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = traceInfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public final void h(@NotNull TianShuGetAdvCallback tianShuGetAdvCallback, @NotNull List<? extends TianShuAdPosItemData> ads) {
        Intrinsics.checkNotNullParameter(tianShuGetAdvCallback, "tianShuGetAdvCallback");
        Intrinsics.checkNotNullParameter(ads, "ads");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(ads, tianShuGetAdvCallback);
    }
}
