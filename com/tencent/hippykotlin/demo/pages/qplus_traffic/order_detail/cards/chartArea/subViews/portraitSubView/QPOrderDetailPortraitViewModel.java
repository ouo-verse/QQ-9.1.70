package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.city_views.QPPromoteCity;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusAudienceDist;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusFeatureDist;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusInteractData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailPortraitViewModel implements IQPOrderDetailCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailPortraitViewModel.class, "currentPortraitViewIndex", "getCurrentPortraitViewIndex()I", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPOrderDetailPortraitViewModel.class, "provinceInfoList", "getProvinceInfoList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public boolean ageShouldShow;
    public boolean areaShouldShow;
    public Pair<String, Float>[][] audienceInfoList;
    public final ReadWriteProperty currentPortraitViewIndex$delegate = c.a(0);
    public boolean genderShouldShow;
    public final QPlusAudienceDist infoList;
    public final ReadWriteProperty provinceInfoList$delegate;
    public final Map<String, Set<String>> provinceMap;

    public QPOrderDetailPortraitViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        QPlusInteractData qPlusInteractData;
        QPlusPromotionDetail qPlusPromotionDetail = qPlusGetPromotionDetailRsp.promotionDetail;
        this.infoList = (qPlusPromotionDetail == null || (qPlusInteractData = qPlusPromotionDetail.interactData) == null) ? null : qPlusInteractData.audienceDist;
        this.provinceInfoList$delegate = c.b();
        this.provinceMap = new LinkedHashMap();
        this.audienceInfoList = new Pair[][]{ageInfoList(), sexInfoList()};
        genProvinceInfoList();
    }

    public final Pair<String, Float>[] ageInfoList() {
        int i3;
        QPlusAudienceDist qPlusAudienceDist = this.infoList;
        ArrayList<QPlusFeatureDist> arrayList = qPlusAudienceDist != null ? qPlusAudienceDist.ageDist : null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += ((QPlusFeatureDist) it.next()).percent;
            }
        } else {
            i3 = 0;
        }
        int max = Math.max(1, i3);
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<T> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(new Pair(((QPlusFeatureDist) it5.next()).featureName, Float.valueOf(r5.percent / max)));
            }
        }
        this.ageShouldShow = !arrayList2.isEmpty();
        Object[] array = arrayList2.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Pair[]) array;
    }

    public final void genProvinceInfoList() {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitViewModel$genProvinceInfoList$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r11v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.util.Set<java.lang.String>>] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                ArrayList arrayListOf;
                Map map;
                int collectionSizeOrDefault;
                b k3;
                Object d16;
                Object first;
                Object last;
                b k16;
                Object d17;
                e eVar2 = eVar;
                b l3 = eVar2 != null ? eVar2.l("result") : null;
                ArrayList arrayList = new ArrayList();
                if (l3 != null && (k16 = l3.k(1)) != null) {
                    int c16 = k16.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d17 = Boolean.valueOf(k16.e(i3));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d17 = Integer.valueOf(k16.i(i3));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d17 = Long.valueOf(k16.m(i3));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d17 = k16.o(i3);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d17 = Double.valueOf(k16.g(i3));
                        } else {
                            d17 = k16.d(i3);
                        }
                        if (d17 != null) {
                            arrayList.add(new QPPromoteCity(null, null, null, null, null, 63).decode((e) d17).fullname);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                if (l3 != null && (k3 = l3.k(0)) != null) {
                    QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel = QPOrderDetailPortraitViewModel.this;
                    int c17 = k3.c();
                    for (int i16 = 0; i16 < c17; i16++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boolean.valueOf(k3.e(i16));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Integer.valueOf(k3.i(i16));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Long.valueOf(k3.m(i16));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = k3.o(i16);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Double.valueOf(k3.g(i16));
                        } else {
                            d16 = k3.d(i16);
                        }
                        if (d16 != null) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            QPPromoteCity decode = new QPPromoteCity(null, null, null, null, null, 63).decode((e) d16);
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) decode.cidx);
                            int intValue = ((Number) first).intValue();
                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) decode.cidx);
                            linkedHashSet.addAll(arrayList.subList(intValue, ((Number) last).intValue()));
                            qPOrderDetailPortraitViewModel.provinceMap.put(decode.fullname, linkedHashSet);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                QPlusAudienceDist qPlusAudienceDist = QPOrderDetailPortraitViewModel.this.infoList;
                ArrayList<QPlusFeatureDist> arrayList2 = qPlusAudienceDist != null ? qPlusAudienceDist.cityDist : null;
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    ArrayList arrayList3 = new ArrayList();
                    Ref.IntRef intRef = new Ref.IntRef();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("\u5317\u4eac\u5e02", "\u5929\u6d25\u5e02", "\u91cd\u5e86\u5e02", "\u4e0a\u6d77\u5e02");
                    Object[] array = arrayList2.toArray(new QPlusFeatureDist[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    for (Object obj : array) {
                        QPlusFeatureDist qPlusFeatureDist = (QPlusFeatureDist) obj;
                        if (arrayListOf.contains(qPlusFeatureDist.featureName)) {
                            int i17 = qPlusFeatureDist.percent;
                            String str = qPlusFeatureDist.featureName;
                            arrayList3.add(new ProvinceModel(i17, str, new Pair[]{new Pair(str, Integer.valueOf(i17))}));
                        }
                    }
                    QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel2 = QPOrderDetailPortraitViewModel.this;
                    Object[] array2 = arrayList2.toArray(new QPlusFeatureDist[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    qPOrderDetailPortraitViewModel2.getClass();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (QPlusFeatureDist qPlusFeatureDist2 : (QPlusFeatureDist[]) array2) {
                        for (Map.Entry entry : qPOrderDetailPortraitViewModel2.provinceMap.entrySet()) {
                            if (((Set) entry.getValue()).contains(qPlusFeatureDist2.featureName)) {
                                Collection collection = (Collection) linkedHashMap.get(entry.getKey());
                                if (collection == null || collection.isEmpty()) {
                                    linkedHashMap.put(entry.getKey(), new ArrayList());
                                }
                                ArrayList arrayList4 = (ArrayList) linkedHashMap.get(entry.getKey());
                                if (arrayList4 != null) {
                                    arrayList4.add(new Pair(qPlusFeatureDist2.featureName, Integer.valueOf(qPlusFeatureDist2.percent)));
                                }
                            }
                        }
                    }
                    map = MapsKt__MapsKt.toMap(linkedHashMap);
                    for (Map.Entry entry2 : map.entrySet()) {
                        Iterable iterable = (Iterable) entry2.getValue();
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
                        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
                        Iterator it = iterable.iterator();
                        while (it.hasNext()) {
                            arrayList5.add(Integer.valueOf(((Number) ((Pair) it.next()).getSecond()).intValue()));
                        }
                        Iterator it5 = arrayList5.iterator();
                        if (it5.hasNext()) {
                            Object next = it5.next();
                            while (it5.hasNext()) {
                                next = Integer.valueOf(((Number) next).intValue() + ((Number) it5.next()).intValue());
                            }
                            int intValue2 = ((Number) next).intValue();
                            intRef.element = intValue2;
                            int max = Math.max(1, intValue2);
                            intRef.element = max;
                            String str2 = (String) entry2.getKey();
                            Object[] array3 = ((Collection) entry2.getValue()).toArray(new Pair[0]);
                            Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            arrayList3.add(new ProvinceModel(max, str2, (Pair[]) array3));
                        } else {
                            throw new UnsupportedOperationException("Empty collection can't be reduced.");
                        }
                    }
                    QPOrderDetailPortraitViewModel.this.getProvinceInfoList().addAll(arrayList3);
                    QPOrderDetailPortraitViewModel.this.areaShouldShow = true;
                }
                return Unit.INSTANCE;
            }
        };
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.getClass();
        e eVar = new e();
        eVar.t("cityLevel", 3);
        currentBridgeModule.callNativeMethod("getFullMapInfo", eVar, function1);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailPortraitView();
    }

    public final int getCurrentPortraitViewIndex() {
        return ((Number) this.currentPortraitViewIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<ProvinceModel> getProvinceInfoList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.provinceInfoList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setCurrentPortraitViewIndex(int i3) {
        this.currentPortraitViewIndex$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public final Pair<String, Float>[] sexInfoList() {
        int i3;
        QPlusAudienceDist qPlusAudienceDist = this.infoList;
        ArrayList<QPlusFeatureDist> arrayList = qPlusAudienceDist != null ? qPlusAudienceDist.sexDist : null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += ((QPlusFeatureDist) it.next()).percent;
            }
        } else {
            i3 = 0;
        }
        int max = Math.max(1, i3);
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<T> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(new Pair(((QPlusFeatureDist) it5.next()).featureName, Float.valueOf(r5.percent / max)));
            }
        }
        this.genderShouldShow = !arrayList2.isEmpty();
        Object[] array = arrayList2.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Pair[]) array;
    }
}
