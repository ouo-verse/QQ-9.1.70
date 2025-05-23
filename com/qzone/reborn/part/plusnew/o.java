package com.qzone.reborn.part.plusnew;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\rJ2\u0010\u0016\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\r2\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00110\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/part/plusnew/o;", "", "", "", "adIdList", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", tl.h.F, "j", "adId", "needCnt", "i", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "Lcom/qzone/reborn/part/plusnew/c;", "l", "plusData", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Lkotlin/Function1;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "Lcom/qzone/reborn/part/plusnew/c;", "qzonePlusData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f58563a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static c qzonePlusData;

    o() {
    }

    private final List<TianShuAdPosItemData> h(List<Integer> adIdList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = adIdList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = intValue;
            arrayList.add(tianShuAdPosItemData);
        }
        return arrayList;
    }

    private final List<TianShuAdPosItemData> i(int adId, int needCnt) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = needCnt;
        tianShuAdPosItemData.mPosId = adId;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    private final int j() {
        return 1386;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        o oVar = f58563a;
        iTianshuManager.requestAdv(oVar.i(oVar.j(), 10), new TianShuGetAdvCallback() { // from class: com.qzone.reborn.part.plusnew.l
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                o.o(z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        QLog.i("QzoneNewPlusTianshuAdManager", 1, "sendQzonePlusAdRequest result:" + z16);
        o oVar = f58563a;
        Intrinsics.checkNotNullExpressionValue(getAdsRsp, "getAdsRsp");
        final c l3 = oVar.l(getAdsRsp);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.part.plusnew.m
            @Override // java.lang.Runnable
            public final void run() {
                o.p(c.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(c data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        qzonePlusData = data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(List adIdList, final c plusData, final Function1 callback) {
        Intrinsics.checkNotNullParameter(adIdList, "$adIdList");
        Intrinsics.checkNotNullParameter(plusData, "$plusData");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(f58563a.h(adIdList), new TianShuGetAdvCallback() { // from class: com.qzone.reborn.part.plusnew.k
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                o.s(c.this, callback, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(c plusData, final Function1 callback, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(plusData, "$plusData");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i("QzoneNewPlusTianshuAdManager", 1, "sendQzonePlusRedAdRequest result:" + z16);
        o oVar = f58563a;
        Intrinsics.checkNotNullExpressionValue(getAdsRsp, "getAdsRsp");
        final c k3 = oVar.k(getAdsRsp, plusData);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.part.plusnew.n
            @Override // java.lang.Runnable
            public final void run() {
                o.t(Function1.this, k3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 callback, c data) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(data, "$data");
        callback.invoke(data);
    }

    public final c g() {
        return qzonePlusData;
    }

    public final void m() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.part.plusnew.j
            @Override // java.lang.Runnable
            public final void run() {
                o.n();
            }
        }, 128, null, false);
    }

    public final void q(final List<Integer> adIdList, final c plusData, final Function1<? super c, Unit> callback) {
        Intrinsics.checkNotNullParameter(adIdList, "adIdList");
        Intrinsics.checkNotNullParameter(plusData, "plusData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.part.plusnew.i
            @Override // java.lang.Runnable
            public final void run() {
                o.r(adIdList, plusData, callback);
            }
        }, 128, null, false);
    }

    private final c k(TianShuAccess.GetAdsRsp getAdsRsp, c plusData) {
        int size;
        Object firstOrNull;
        Object obj;
        if (getAdsRsp.code.get() != 0 || getAdsRsp.mapAds.isEmpty() || (size = getAdsRsp.mapAds.size()) <= 0) {
            return plusData;
        }
        Iterator<T> it = plusData.b().iterator();
        while (it.hasNext()) {
            ((QzoneNewPlusItemData) it.next()).u(null);
        }
        for (int i3 = 0; i3 < size; i3++) {
            TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(i3);
            int i16 = rspEntry.key.get();
            List<TianShuAccess.AdItem> adItemList = rspEntry.value.get().lst.get();
            Intrinsics.checkNotNullExpressionValue(adItemList, "adItemList");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) adItemList);
            TianShuAccess.AdItem adItem = (TianShuAccess.AdItem) firstOrNull;
            if (adItem != null) {
                QzoneNewPlusRedItemData qzoneNewPlusRedItemData = new QzoneNewPlusRedItemData(null, null, false, null, null, 0, 0L, null, 255, null);
                String str = adItem.traceinfo.get();
                Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
                qzoneNewPlusRedItemData.p(str);
                for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                    String str2 = mapEntry.key.get();
                    if (str2 != null) {
                        switch (str2.hashCode()) {
                            case -2090050568:
                                if (str2.equals(QQWinkConstants.TAB_SUBTITLE)) {
                                    String str3 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str3, "arg.value.get()");
                                    qzoneNewPlusRedItemData.o(str3);
                                    break;
                                } else {
                                    break;
                                }
                            case -1651289700:
                                if (str2.equals("showRedPoint")) {
                                    qzoneNewPlusRedItemData.n(mapEntry.value.get().equals("0"));
                                    break;
                                } else {
                                    break;
                                }
                            case 563455488:
                                if (str2.equals("redPointSchema")) {
                                    String str4 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str4, "arg.value.get()");
                                    qzoneNewPlusRedItemData.k(str4);
                                    break;
                                } else {
                                    break;
                                }
                            case 701968668:
                                if (str2.equals("redPointImage")) {
                                    String str5 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str5, "arg.value.get()");
                                    qzoneNewPlusRedItemData.l(str5);
                                    break;
                                } else {
                                    break;
                                }
                            case 712026649:
                                if (str2.equals("redPointTitle")) {
                                    String str6 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str6, "arg.value.get()");
                                    qzoneNewPlusRedItemData.m(str6);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                qzoneNewPlusRedItemData.j(i16);
                qzoneNewPlusRedItemData.i(adItem.iAdId.get());
                Iterator<T> it5 = plusData.b().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (((QzoneNewPlusItemData) obj).getItemId() == i16) {
                        }
                    } else {
                        obj = null;
                    }
                }
                QzoneNewPlusItemData qzoneNewPlusItemData = (QzoneNewPlusItemData) obj;
                if (qzoneNewPlusItemData != null) {
                    qzoneNewPlusItemData.u(qzoneNewPlusRedItemData);
                }
            }
        }
        for (QzoneNewPlusItemData qzoneNewPlusItemData2 : plusData.b()) {
            int iAdId = qzoneNewPlusItemData2.getIAdId();
            String mainItemTitle = qzoneNewPlusItemData2.getMainItemTitle();
            QzoneNewPlusRedItemData redPointInfo = qzoneNewPlusItemData2.getRedPointInfo();
            Integer valueOf = redPointInfo != null ? Integer.valueOf(redPointInfo.getItemId()) : null;
            QzoneNewPlusRedItemData redPointInfo2 = qzoneNewPlusItemData2.getRedPointInfo();
            String subTitle = redPointInfo2 != null ? redPointInfo2.getSubTitle() : null;
            QzoneNewPlusRedItemData redPointInfo3 = qzoneNewPlusItemData2.getRedPointInfo();
            String redPointImage = redPointInfo3 != null ? redPointInfo3.getRedPointImage() : null;
            QzoneNewPlusRedItemData redPointInfo4 = qzoneNewPlusItemData2.getRedPointInfo();
            Boolean valueOf2 = redPointInfo4 != null ? Boolean.valueOf(redPointInfo4.getShowRedPoint()) : null;
            QzoneNewPlusRedItemData redPointInfo5 = qzoneNewPlusItemData2.getRedPointInfo();
            String redPointTitle = redPointInfo5 != null ? redPointInfo5.getRedPointTitle() : null;
            QzoneNewPlusRedItemData redPointInfo6 = qzoneNewPlusItemData2.getRedPointInfo();
            QLog.d("QzoneNewPlusTianshuAdManager", 1, "single ad(" + iAdId + ")," + mainItemTitle + "," + valueOf + "," + subTitle + "," + redPointImage + "," + valueOf2 + "," + redPointTitle + "," + (redPointInfo6 != null ? Long.valueOf(redPointInfo6.getAdId()) : null) + ",");
        }
        return plusData;
    }

    private final c l(TianShuAccess.GetAdsRsp getAdsRsp) {
        int i3;
        int i16;
        c cVar = new c(0, null, 3, null);
        if (getAdsRsp.code.get() != 0 || getAdsRsp.mapAds.isEmpty() || getAdsRsp.mapAds.size() <= 0) {
            return cVar;
        }
        TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(0);
        int i17 = rspEntry.key.get();
        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value.get();
        ArrayList<QzoneNewPlusItemData> arrayList = new ArrayList();
        for (TianShuAccess.AdItem adItem : adPlacementInfo.lst.get()) {
            List<TianShuAccess.MapEntry> list = adItem.argList.get();
            QzoneNewPlusItemData qzoneNewPlusItemData = new QzoneNewPlusItemData(0, null, null, null, null, 0, null, null, 0, 511, null);
            qzoneNewPlusItemData.o(adItem.iAdId.get());
            String str = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
            qzoneNewPlusItemData.v(str);
            for (TianShuAccess.MapEntry mapEntry : list) {
                String str2 = mapEntry.key.get();
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1178662034:
                            if (str2.equals("itemID")) {
                                try {
                                    if (TextUtils.isEmpty(mapEntry.value.get())) {
                                        i3 = 0;
                                    } else {
                                        String str3 = mapEntry.value.get();
                                        Intrinsics.checkNotNullExpressionValue(str3, "arg.value.get()");
                                        i3 = Integer.parseInt(str3);
                                    }
                                    qzoneNewPlusItemData.p(i3);
                                    break;
                                } catch (NumberFormatException e16) {
                                    qzoneNewPlusItemData.p(0);
                                    QLog.e("QzoneNewPlusTianshuAdManager", 1, e16.getMessage());
                                    break;
                                }
                            } else {
                                break;
                            }
                        case -907987551:
                            if (str2.equals(QZoneDTLoginReporter.SCHEMA)) {
                                String str4 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str4, "arg.value.get()");
                                qzoneNewPlusItemData.q(str4);
                                break;
                            } else {
                                break;
                            }
                        case 3226745:
                            if (str2.equals("icon")) {
                                String str5 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str5, "arg.value.get()");
                                qzoneNewPlusItemData.s(str5);
                                break;
                            } else {
                                break;
                            }
                        case 110371416:
                            if (str2.equals("title")) {
                                String str6 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str6, "arg.value.get()");
                                qzoneNewPlusItemData.r(str6);
                                break;
                            } else {
                                break;
                            }
                        case 1349547969:
                            if (str2.equals("sequence")) {
                                try {
                                    if (TextUtils.isEmpty(mapEntry.value.get().toString())) {
                                        i16 = 0;
                                    } else {
                                        String str7 = mapEntry.value.get();
                                        Intrinsics.checkNotNullExpressionValue(str7, "arg.value.get()");
                                        i16 = Integer.parseInt(str7);
                                    }
                                    qzoneNewPlusItemData.t(i16);
                                    break;
                                } catch (NumberFormatException e17) {
                                    qzoneNewPlusItemData.t(0);
                                    QLog.e("QzoneNewPlusTianshuAdManager", 1, e17.getMessage());
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
            arrayList.add(qzoneNewPlusItemData);
        }
        for (QzoneNewPlusItemData qzoneNewPlusItemData2 : arrayList) {
            QLog.d("QzoneNewPlusTianshuAdManager", 1, "single !!ad(" + qzoneNewPlusItemData2.getIAdId() + ")," + qzoneNewPlusItemData2.getMainItemTitle() + "," + qzoneNewPlusItemData2.getMainPicUrl() + "," + qzoneNewPlusItemData2.getItemId() + "," + qzoneNewPlusItemData2.getJumpUrl() + "," + qzoneNewPlusItemData2.getOrderNum() + ",");
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        if (arrayList.size() == 0) {
            QLog.e("QzoneNewPlusTianshuAdManager", 2, "empty ad:" + i17);
            return cVar;
        }
        c cVar2 = new c(i17, arrayList);
        QLog.d("QzoneNewPlusTianshuAdManager", 1, "ad(" + i17 + "):" + cVar2);
        return cVar2;
    }
}
