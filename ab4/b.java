package ab4;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J*\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J$\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0016j\b\u0012\u0004\u0012\u00020\u0005`\u00172\u0006\u0010\u0015\u001a\u00020\u0014J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u001d\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\u00020\n8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b \u0010\u001cR\u0014\u0010#\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001c\u00a8\u0006&"}, d2 = {"Lab4/b;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lnw4/h;", "l", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "g", "", "actionId", "iAdId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "Lcom/tencent/mobileqq/tianshu/data/TianShuReportData;", "b", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "callback", "", h.F, "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "I", "e", "()I", "ACTION_ID_IMP", "c", "ACTION_ID_CLICK", "d", "ACTION_ID_CLOSE", "f", "needCntEachTime", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f25786a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int ACTION_ID_IMP = 101;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int ACTION_ID_CLICK = 102;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int ACTION_ID_CLOSE = 122;

    b() {
    }

    private final TianShuReportData b(int actionId, String iAdId, String traceInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return null;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "273";
        tianShuReportData.mPageId = "273";
        tianShuReportData.mItemId = iAdId;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = traceInfo;
        return tianShuReportData;
    }

    private final int f() {
        return ZPlanQQMC.INSTANCE.getFaceAdConfig().getPageNumbers();
    }

    private final List<TianShuAdPosItemData> g() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = f25786a.f();
        tianShuAdPosItemData.mPosId = 1307;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TianShuGetAdvCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(f25786a.g(), callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final nw4.h l(HashMap<String, String> hashMap) {
        Long longOrNull;
        Integer intOrNull;
        int i3;
        String str;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        Integer intOrNull6;
        nw4.h hVar = new nw4.h();
        String str2 = hashMap.get("adId");
        if (str2 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "this@toSlapFaceActivityInfo[\"adId\"]");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
            if (longOrNull != null) {
                hVar.f421482a = longOrNull.longValue();
                String str3 = hashMap.get("title");
                if (str3 == null) {
                    return null;
                }
                hVar.f421483b = str3;
                String str4 = hashMap.get("popup_type");
                if (str4 != null) {
                    Intrinsics.checkNotNullExpressionValue(str4, "this@toSlapFaceActivityInfo[\"popup_type\"]");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str4);
                    if (intOrNull != null) {
                        hVar.f421484c = intOrNull.intValue();
                        String str5 = hashMap.get("popup_url");
                        if (str5 == null) {
                            return null;
                        }
                        hVar.f421485d = str5;
                        String str6 = hashMap.get("first_enter_img");
                        if (str6 == null) {
                            return null;
                        }
                        hVar.f421486e = str6;
                        String str7 = hashMap.get("jump_type");
                        int i16 = 0;
                        if (str7 != null) {
                            Intrinsics.checkNotNullExpressionValue(str7, "this@toSlapFaceActivityInfo[\"jump_type\"]");
                            intOrNull6 = StringsKt__StringNumberConversionsKt.toIntOrNull(str7);
                            if (intOrNull6 != null) {
                                i3 = intOrNull6.intValue();
                                hVar.f421487f = i3;
                                str = hashMap.get("jump_url");
                                if (str != null) {
                                    return null;
                                }
                                hVar.f421488g = str;
                                String str8 = hashMap.get("type");
                                if (str8 != null) {
                                    Intrinsics.checkNotNullExpressionValue(str8, "this@toSlapFaceActivityInfo[\"type\"]");
                                    intOrNull5 = StringsKt__StringNumberConversionsKt.toIntOrNull(str8);
                                    if (intOrNull5 != null) {
                                        i16 = intOrNull5.intValue();
                                    }
                                }
                                hVar.f421489h = i16;
                                String str9 = hashMap.get("text");
                                if (str9 == null) {
                                    str9 = "";
                                }
                                hVar.f421490i = str9;
                                String str10 = hashMap.get("pop_expire");
                                if (str10 != null) {
                                    Intrinsics.checkNotNullExpressionValue(str10, "this@toSlapFaceActivityInfo[\"pop_expire\"]");
                                    intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str10);
                                    if (intOrNull2 != null) {
                                        hVar.f421491j = intOrNull2.intValue();
                                        String str11 = hashMap.get("activity_id");
                                        if (str11 == null) {
                                            return null;
                                        }
                                        hVar.f421494m = str11;
                                        String str12 = hashMap.get("btn_icon");
                                        if (str12 == null) {
                                            return null;
                                        }
                                        hVar.f421495n = str12;
                                        String str13 = hashMap.get("zplan_act_id");
                                        hVar.f421496o = str13 != null ? str13 : "";
                                        String str14 = hashMap.get("today_not_show");
                                        if (str14 != null) {
                                            hVar.f421497p = Boolean.parseBoolean(str14);
                                            String str15 = hashMap.get("priority");
                                            if (str15 != null) {
                                                Intrinsics.checkNotNullExpressionValue(str15, "this@toSlapFaceActivityInfo[\"priority\"]");
                                                intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(str15);
                                                if (intOrNull3 != null) {
                                                    hVar.f421498q = intOrNull3.intValue();
                                                    String str16 = hashMap.get("show_num");
                                                    if (str16 != null) {
                                                        Intrinsics.checkNotNullExpressionValue(str16, "this@toSlapFaceActivityInfo[\"show_num\"]");
                                                        intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull(str16);
                                                        if (intOrNull4 != null) {
                                                            hVar.f421499r = intOrNull4.intValue();
                                                            return hVar;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i3 = 0;
                        hVar.f421487f = i3;
                        str = hashMap.get("jump_url");
                        if (str != null) {
                        }
                    }
                }
            }
        }
        return null;
    }

    public final int c() {
        return ACTION_ID_CLICK;
    }

    public final int d() {
        return ACTION_ID_CLOSE;
    }

    public final int e() {
        return ACTION_ID_IMP;
    }

    public final void h(final TianShuGetAdvCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: ab4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.i(TianShuGetAdvCallback.this);
            }
        }, 128, null, true);
    }

    public final void j(int actionId, String iAdId, String traceInfo) {
        Intrinsics.checkNotNullParameter(iAdId, "iAdId");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(b(actionId, iAdId, traceInfo));
    }

    public final ArrayList<nw4.h> m(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        List<TianShuAccess.AdItem> list2;
        String num;
        List<TianShuAccess.MapEntry> list3;
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        ArrayList<nw4.h> arrayList = new ArrayList<>();
        PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField2 = getAdsRsp.mapAds;
        if (pBRepeatMessageField2 != null && (list = pBRepeatMessageField2.get()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                TianShuAccess.AdPlacementInfo adPlacementInfo2 = ((TianShuAccess.RspEntry) it.next()).value;
                if (adPlacementInfo2 != null && (adPlacementInfo = adPlacementInfo2.get()) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null && (list2 = pBRepeatMessageField.get()) != null) {
                    Intrinsics.checkNotNullExpressionValue(list2, "get()");
                    for (TianShuAccess.AdItem adItem : list2) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField3 = adItem.argList;
                        if (pBRepeatMessageField3 != null && (list3 = pBRepeatMessageField3.get()) != null) {
                            Intrinsics.checkNotNullExpressionValue(list3, "get()");
                            for (TianShuAccess.MapEntry mapEntry : list3) {
                                String str = mapEntry.key.get();
                                Intrinsics.checkNotNullExpressionValue(str, "it.key.get()");
                                String str2 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
                                hashMap.put(str, str2);
                            }
                        }
                        PBUInt32Field pBUInt32Field = adItem.iAdId;
                        if (pBUInt32Field != null && (num = Integer.valueOf(pBUInt32Field.get()).toString()) != null) {
                            hashMap.put("adId", num);
                        }
                        nw4.h l3 = f25786a.l(hashMap);
                        if (l3 == null) {
                            QLog.e("ZPlanPortalFaceAdManager", 1, "transToFaceAdList failed.");
                        } else {
                            arrayList.add(l3);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void k(b bVar, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        bVar.j(i3, str, str2);
    }
}
