package com.tencent.mobileqq.zplan.servlet;

import android.net.Uri;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONObject;
import yi3.ZPlanOperateBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/h;", "", "Lnk3/e;", "callback", "", "g", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "Lyi3/c;", "i", "", "Lcooperation/vip/pb/TianShuAccess$MapEntry;", "", "key", "c", "Lorg/json/JSONObject;", "", "d", "", "uin", "e", "Lcom/tencent/mobileqq/onlinestatus/api/IOnLineStatueHelperApi;", "b", "Lcom/tencent/mobileqq/onlinestatus/api/IOnLineStatueHelperApi;", "onlineStatusHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f335407a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final IOnLineStatueHelperApi onlineStatusHelper;

    static {
        QRouteApi api = QRoute.api(IOnLineStatueHelperApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IOnLineStatueHelperApi::class.java)");
        onlineStatusHelper = (IOnLineStatueHelperApi) api;
    }

    h() {
    }

    private final String c(List<TianShuAccess.MapEntry> list, String str) {
        Object obj;
        PBStringField pBStringField;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((TianShuAccess.MapEntry) obj).key.get(), str)) {
                break;
            }
        }
        TianShuAccess.MapEntry mapEntry = (TianShuAccess.MapEntry) obj;
        if (mapEntry == null || (pBStringField = mapEntry.value) == null) {
            return null;
        }
        return pBStringField.get();
    }

    private final float d(JSONObject jSONObject, String str) {
        return (float) jSONObject.getDouble(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(nk3.e callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        f335407a.g(callback);
    }

    private final void g(final nk3.e callback) {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1328;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.zplan.servlet.g
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                h.h(nk3.e.this, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(nk3.e callback, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16 && getAdsRsp != null) {
            ZPlanOperateBubbleInfo i3 = f335407a.i(getAdsRsp);
            QLog.i("ZPlanBubbleInfoRequest", 1, "requestUserBubbleInfoFromTianShu success, bubbleInfo:" + i3);
            callback.a(i3);
            return;
        }
        QLog.w("ZPlanBubbleInfoRequest", 1, "requestUserBubbleInfoFromTianShu result:" + z16 + " or adsRsp null, callback null");
        callback.a(null);
    }

    public final void e(long uin, final nk3.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.servlet.f
            @Override // java.lang.Runnable
            public final void run() {
                h.f(nk3.e.this);
            }
        }, 128, null, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r14 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0080 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0002, B:5:0x0016, B:7:0x001a, B:9:0x0022, B:11:0x0026, B:13:0x002c, B:16:0x0036, B:18:0x003a, B:20:0x0042, B:23:0x004a, B:25:0x005a, B:27:0x0060, B:29:0x0067, B:31:0x0072, B:37:0x0085, B:39:0x008e, B:41:0x0094, B:45:0x00a2, B:48:0x00b2, B:51:0x0080), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ZPlanOperateBubbleInfo i(TianShuAccess.GetAdsRsp getAdsRsp) {
        Object firstOrNull;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        TianShuAccess.AdPlacementInfo adPlacementInfo2;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        List<TianShuAccess.AdItem> list;
        Object firstOrNull2;
        Integer intOrNull;
        boolean z16;
        Uri parse;
        String c16;
        Integer intOrNull2;
        int intValue;
        String c17;
        JSONObject b16;
        try {
            List<TianShuAccess.RspEntry> list2 = getAdsRsp.mapAds.get();
            Intrinsics.checkNotNullExpressionValue(list2, "mapAds.get()");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            TianShuAccess.RspEntry rspEntry = (TianShuAccess.RspEntry) firstOrNull;
            if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (adPlacementInfo2 = adPlacementInfo.get()) != null && (pBRepeatMessageField = adPlacementInfo2.lst) != null && (list = pBRepeatMessageField.get()) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                TianShuAccess.AdItem adItem = (TianShuAccess.AdItem) firstOrNull2;
                if (adItem != null) {
                    PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField2 = adItem.argList;
                    List<TianShuAccess.MapEntry> list3 = pBRepeatMessageField2 != null ? pBRepeatMessageField2.get() : null;
                    if (list3 != null && !list3.isEmpty()) {
                        long j3 = adItem.iAdId.get();
                        String c18 = c(list3, "jump_type");
                        if (c18 != null && intOrNull != null) {
                            String c19 = intOrNull.intValue() == 2 ? c(list3, "jump_url") : null;
                            if (c19 != null && c19.length() != 0) {
                                z16 = false;
                                parse = !z16 ? null : Uri.parse(c19);
                                c16 = c(list3, "show_expire");
                                if (c16 != null && intOrNull2 != null) {
                                    intValue = intOrNull2.intValue();
                                    c17 = c(list3, "pic");
                                    if (c17 == null && (b16 = com.tencent.zplan.common.utils.h.f385294a.b(c(list3, "pic_position"))) != null) {
                                        return new ZPlanOperateBubbleInfo(j3, parse, intValue, new URL(c17), d(b16, "width"), d(b16, "height"), d(b16, "xFromRight"), d(b16, "yFromTop"));
                                    }
                                    return null;
                                }
                            }
                            z16 = true;
                            if (!z16) {
                            }
                            c16 = c(list3, "show_expire");
                            if (c16 != null) {
                                intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(c16);
                                intValue = intOrNull2.intValue();
                                c17 = c(list3, "pic");
                                if (c17 == null) {
                                    return null;
                                }
                                return new ZPlanOperateBubbleInfo(j3, parse, intValue, new URL(c17), d(b16, "width"), d(b16, "height"), d(b16, "xFromRight"), d(b16, "yFromTop"));
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th5) {
            QLog.e("ZPlanBubbleInfoRequest", 1, "TianShuAccess.GetAdsRsp.toBubbleInfo exception", th5);
            return null;
        }
    }
}
