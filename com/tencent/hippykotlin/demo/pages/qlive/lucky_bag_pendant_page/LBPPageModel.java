package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRequestModel;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRspModel;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LivingCoupon;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPPageModel extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPPageModel.class, "pendantList", "getPendantList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final Lazy couponRequestModel$delegate;
    public e couponRspData;
    public double currentTime;
    public boolean isAnchor;
    public boolean isCouponRequesting;
    public boolean isLBPRequesting;
    public e lbpRspData;
    public final String pagerId;
    public final ReadWriteProperty pendantList$delegate = c.b();
    public final Lazy requestModel$delegate;
    public long roomId;

    public LBPPageModel(String str) {
        Lazy lazy;
        Lazy lazy2;
        this.pagerId = str;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LBPRequestModel>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$requestModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LBPRequestModel invoke() {
                LBPPageModel lBPPageModel = LBPPageModel.this;
                LBPRequestModel lBPRequestModel = new LBPRequestModel(lBPPageModel.pagerId);
                lBPRequestModel.roomId = lBPPageModel.roomId;
                lBPRequestModel.isAnchor = lBPPageModel.isAnchor;
                return lBPRequestModel;
            }
        });
        this.requestModel$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LiveCouponRequestModel>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$couponRequestModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LiveCouponRequestModel invoke() {
                LBPPageModel lBPPageModel = LBPPageModel.this;
                LiveCouponRequestModel liveCouponRequestModel = new LiveCouponRequestModel(lBPPageModel.pagerId);
                liveCouponRequestModel.roomId = lBPPageModel.roomId;
                return liveCouponRequestModel;
            }
        });
        this.couponRequestModel$delegate = lazy2;
        this.lbpRspData = new e();
        this.couponRspData = new e();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<LBPPendantListItem> getPendantList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.pendantList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void preDownloadResource() {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        BridgeModule.preDownloadImage$default(currentBridgeModule, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibo_coupon_bg.png");
        e eVar = new e();
        eVar.v("url", "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibo_coupon.pag");
        currentBridgeModule.callNativeMethod("preDownloadAPNGResource", eVar, null);
        BridgeModule.preDownloadImage$default(currentBridgeModule, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibolingquan_bg.png");
    }

    public final void requestCommonPendantData(final Function3<? super LBPPageModel, ? super Boolean, ? super String, Unit> function3) {
        LBPRequestModel lBPRequestModel = (LBPRequestModel) this.requestModel$delegate.getValue();
        final Function3<e, Integer, String, Unit> function32 = new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$requestCommonPendantData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                final e eVar2 = eVar;
                num.intValue();
                LBPPageModel.this.isLBPRequesting = false;
                if (!(eVar2.d() > 0)) {
                    LBPPageModel.this.getClass();
                } else {
                    BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(LBPPageModel.this.pagerId);
                    final LBPPageModel lBPPageModel = LBPPageModel.this;
                    final Function3<LBPPageModel, Boolean, String, Unit> function33 = function3;
                    bridgeModule.localServeTime(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$requestCommonPendantData$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar3) {
                            e eVar4 = eVar3;
                            LBPPageModel lBPPageModel2 = LBPPageModel.this;
                            Intrinsics.checkNotNull(eVar4);
                            lBPPageModel2.currentTime = eVar4.h("time");
                            LBPPageModel lBPPageModel3 = LBPPageModel.this;
                            lBPPageModel3.lbpRspData = eVar2;
                            LBPPageModel.access$handleResponseIfNeed(lBPPageModel3, function33);
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
        lBPRequestModel.getClass();
        BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(lBPRequestModel.pagerId);
        e eVar = new e();
        eVar.u(AudienceReportConst.ROOM_ID, lBPRequestModel.roomId);
        eVar.t("is_anchor", d.b(lBPRequestModel.isAnchor));
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QLiveSSORequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                e eVar4 = new e();
                int i3 = 0;
                String str = "";
                if (eVar3 != null) {
                    String q16 = eVar3.q("data", "");
                    if (q16.length() > 0) {
                        eVar4 = new e(q16);
                    }
                    i3 = eVar3.k("errorCode", 0);
                    str = eVar3.q("errorMsg", "");
                }
                function32.invoke(eVar4, Integer.valueOf(i3), str);
                return Unit.INSTANCE;
            }
        };
        bridgeModule.getClass();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("service", "trpc.qlive.qlive_pendant_config_svr.QlivePendantConfigSvr", "method", "GetPlayConfig");
        m3.v("reqParams", eVar);
        bridgeModule.callNativeMethod("qqLiveSSORequest", m3, function1);
    }

    public final void showNextPendantIfNeed() {
        List reversed;
        reversed = CollectionsKt___CollectionsKt.reversed(getPendantList());
        int i3 = 0;
        boolean z16 = false;
        for (Object obj : reversed) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            LBPPendantListItem lBPPendantListItem = (LBPPendantListItem) obj;
            if (!lBPPendantListItem.getShowPendant() && !z16) {
                lBPPendantListItem.setShowPendant();
                z16 = true;
            }
            i3 = i16;
        }
    }

    public final void requestData(boolean z16, e eVar, final Function3<? super LBPPageModel, ? super Boolean, ? super String, Unit> function3) {
        this.isLBPRequesting = true;
        this.isCouponRequesting = true;
        this.lbpRspData = new e();
        this.couponRspData = new e();
        ((LBPRequestModel) this.requestModel$delegate.getValue()).getClass();
        Integer valueOf = eVar != null ? Integer.valueOf(eVar.j("isCoupon")) : null;
        if (z16) {
            if (valueOf != null && valueOf.intValue() == 1) {
                this.isLBPRequesting = false;
                ((LiveCouponRequestModel) this.couponRequestModel$delegate.getValue()).requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$requestCouponPendantData$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(e eVar2, Integer num, String str) {
                        e eVar3 = eVar2;
                        num.intValue();
                        Utils.INSTANCE.logToNative("KTVLivePendant requestCouponPendantData" + eVar3);
                        LBPPageModel lBPPageModel = LBPPageModel.this;
                        lBPPageModel.isCouponRequesting = false;
                        lBPPageModel.couponRspData = eVar3;
                        LBPPageModel.access$handleResponseIfNeed(lBPPageModel, function3);
                        return Unit.INSTANCE;
                    }
                });
                return;
            } else {
                this.isCouponRequesting = false;
                requestCommonPendantData(function3);
                return;
            }
        }
        requestCommonPendantData(function3);
        ((LiveCouponRequestModel) this.couponRequestModel$delegate.getValue()).requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel$requestCouponPendantData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar2, Integer num, String str) {
                e eVar3 = eVar2;
                num.intValue();
                Utils.INSTANCE.logToNative("KTVLivePendant requestCouponPendantData" + eVar3);
                LBPPageModel lBPPageModel = LBPPageModel.this;
                lBPPageModel.isCouponRequesting = false;
                lBPPageModel.couponRspData = eVar3;
                LBPPageModel.access$handleResponseIfNeed(lBPPageModel, function3);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$handleResponseIfNeed(LBPPageModel lBPPageModel, Function3 function3) {
        ArrayList<LBPPlayDetail> arrayList;
        List<LBPPendantListItem> list;
        String str;
        ArrayList arrayList2;
        Number valueOf;
        String str2;
        if (lBPPageModel.isLBPRequesting || lBPPageModel.isCouponRequesting) {
            return;
        }
        char c16 = 0;
        boolean z16 = lBPPageModel.lbpRspData.d() > 0 || lBPPageModel.couponRspData.d() > 0;
        String str3 = "";
        if (!z16) {
            str = "";
        } else {
            Utils.INSTANCE.bridgeModule(lBPPageModel.pagerId).log("KTVLivePendant handleResponseIfNeed");
            b l3 = lBPPageModel.lbpRspData.l("detail");
            Integer num = null;
            if (l3 != null) {
                arrayList = new ArrayList();
                int c17 = l3.c();
                for (int i3 = 0; i3 < c17; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        LBPPlayDetail lBPPlayDetail = new LBPPlayDetail();
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar = (e) d16;
                        e m3 = eVar.m("conf");
                        if (m3 != null) {
                            LBPPlayConfig lBPPlayConfig = new LBPPlayConfig();
                            lBPPlayDetail.conf = lBPPlayConfig;
                            lBPPlayConfig.playType = m3.k(PlayParamConst.ParamKey.PLAY_TYPE, 0);
                            lBPPlayConfig.largeAnimationUrl = m3.q("large_animation_url", "");
                            lBPPlayConfig.pendantAnimationUrl = m3.q("pendant_animation_url", "");
                            lBPPlayConfig.pendantIcon = m3.q("pendant_icon", "");
                            lBPPlayConfig.triggeredUrl = m3.q("triggered_url", "");
                            lBPPlayConfig.text = m3.q("text", "");
                        }
                        e m16 = eVar.m("info");
                        if (m16 != null) {
                            LBPPlayInfo lBPPlayInfo = new LBPPlayInfo();
                            lBPPlayDetail.info = lBPPlayInfo;
                            lBPPlayInfo.status = m16.k("status", 0);
                            lBPPlayInfo.durationTime = m16.k(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, 0);
                            lBPPlayInfo.currTime = m16.k("curr_time", 0);
                            lBPPlayInfo.startTime = m16.k("start_time", 0);
                        }
                        arrayList.add(lBPPlayDetail);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null && (arrayList.isEmpty() ^ true)) {
                Intrinsics.checkNotNull(arrayList);
                if (((LBPPlayDetail) arrayList.get(0)).info == null) {
                    arrayList.clear();
                    Utils.INSTANCE.bridgeModule(lBPPageModel.pagerId).log("model.detail?.clear()");
                }
            }
            list = CollectionsKt___CollectionsKt.toList(lBPPageModel.getPendantList());
            for (LBPPendantListItem lBPPendantListItem : list) {
                if (lBPPendantListItem.type != 3) {
                    LBPPlayDetail detail = lBPPendantListItem.getDetail();
                    Intrinsics.checkNotNull(detail);
                    if (!lBPPageModel.hasContainSameTypeInList(arrayList, detail)) {
                        lBPPageModel.getPendantList().remove(lBPPendantListItem);
                    }
                }
            }
            if (arrayList != null) {
                LBPPlayDetail lBPPlayDetail2 = null;
                for (LBPPlayDetail lBPPlayDetail3 : arrayList) {
                    Integer pendantListItemIndex = lBPPageModel.getPendantListItemIndex(lBPPlayDetail3);
                    if (pendantListItemIndex != null) {
                        LBPPendantListItem lBPPendantListItem2 = lBPPageModel.getPendantList().get(pendantListItemIndex.intValue());
                        lBPPendantListItem2.detail$delegate.setValue(lBPPendantListItem2, LBPPendantListItem.$$delegatedProperties[c16], lBPPlayDetail3);
                        str2 = str3;
                    } else {
                        LBPPendantListItem lBPPendantListItem3 = new LBPPendantListItem();
                        lBPPendantListItem3.detail$delegate.setValue(lBPPendantListItem3, LBPPendantListItem.$$delegatedProperties[c16], lBPPlayDetail3);
                        LBPPlayInfo lBPPlayInfo2 = lBPPlayDetail3.info;
                        if (lBPPlayInfo2 != null) {
                            valueOf = Integer.valueOf(lBPPlayInfo2.currTime);
                        } else {
                            valueOf = Double.valueOf(lBPPageModel.currentTime);
                        }
                        lBPPendantListItem3.localTimeDiffServe = valueOf.doubleValue() - lBPPageModel.currentTime;
                        Utils utils = Utils.INSTANCE;
                        String str4 = lBPPageModel.pagerId;
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("localTimeDiffServe");
                        str2 = str3;
                        m17.append(lBPPendantListItem3.localTimeDiffServe);
                        utils.bridgeModule(str4).log(m17.toString());
                        Integer pendantListItemIndex2 = lBPPageModel.getPendantListItemIndex(lBPPlayDetail2);
                        if (pendantListItemIndex2 == null) {
                            pendantListItemIndex2 = -1;
                        }
                        lBPPageModel.getPendantList().add(pendantListItemIndex2.intValue() + 1, lBPPendantListItem3);
                    }
                    lBPPlayDetail2 = lBPPlayDetail3;
                    str3 = str2;
                    c16 = 0;
                }
            }
            String str5 = str3;
            Utils utils2 = Utils.INSTANCE;
            String str6 = lBPPageModel.pagerId;
            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleCouponResponseSuccess ");
            m18.append(PendantType$EnumUnboxingLocalUtility.stringValueOf(3));
            utils2.bridgeModule(str6).log(m18.toString());
            if (lBPPageModel.couponRspData.d() < 0) {
                str = str5;
            } else {
                e eVar2 = lBPPageModel.couponRspData;
                int i16 = 0;
                int k3 = eVar2.k("coupon_num", 0);
                long o16 = eVar2.o("last_pickup_ts", 0L);
                str = str5;
                String q16 = eVar2.q("discount_price", str);
                b l16 = eVar2.l("coupons");
                if (l16 != null) {
                    ArrayList arrayList3 = new ArrayList();
                    int c18 = l16.c();
                    for (int i17 = 0; i17 < c18; i17++) {
                        Object d17 = l16.d(i17);
                        if (d17 != null) {
                            Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            arrayList3.add(new LivingCoupon(((e) d17).q("coupon_batch_id", str)));
                        }
                    }
                    arrayList2 = arrayList3;
                } else {
                    arrayList2 = null;
                }
                LiveCouponRspModel liveCouponRspModel = new LiveCouponRspModel(k3, o16, q16, arrayList2);
                if (k3 > 0) {
                    utils2.bridgeModule(lBPPageModel.pagerId).log("KTVLivePendant has coupon");
                    LBPPendantListItem lBPPendantListItem4 = new LBPPendantListItem();
                    lBPPendantListItem4.type = 3;
                    lBPPendantListItem4.couponInfo$delegate.setValue(lBPPendantListItem4, LBPPendantListItem.$$delegatedProperties[2], liveCouponRspModel);
                    Iterator<LBPPendantListItem> it = lBPPageModel.getPendantList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        LBPPendantListItem next = it.next();
                        int i18 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (next.type == 3) {
                            num = Integer.valueOf(i16);
                            break;
                        }
                        i16 = i18;
                    }
                    if (num != null) {
                        lBPPageModel.getPendantList().set(num.intValue(), lBPPendantListItem4);
                    } else {
                        lBPPageModel.getPendantList().add(lBPPendantListItem4);
                    }
                }
            }
            lBPPageModel.showNextPendantIfNeed();
        }
        function3.invoke(lBPPageModel, Boolean.valueOf(z16), str);
    }

    public final Integer getPendantListItemIndex(LBPPlayDetail lBPPlayDetail) {
        LBPPlayConfig lBPPlayConfig;
        if (lBPPlayDetail == null) {
            return null;
        }
        int i3 = 0;
        Integer num = null;
        for (LBPPendantListItem lBPPendantListItem : getPendantList()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            LBPPlayDetail detail = lBPPendantListItem.getDetail();
            Integer valueOf = (detail == null || (lBPPlayConfig = detail.conf) == null) ? null : Integer.valueOf(lBPPlayConfig.playType);
            LBPPlayConfig lBPPlayConfig2 = lBPPlayDetail.conf;
            if (Intrinsics.areEqual(valueOf, lBPPlayConfig2 != null ? Integer.valueOf(lBPPlayConfig2.playType) : null)) {
                num = Integer.valueOf(i3);
            }
            i3 = i16;
        }
        return num;
    }

    public final boolean hasContainSameTypeInList(Iterable<LBPPlayDetail> iterable, LBPPlayDetail lBPPlayDetail) {
        boolean z16 = false;
        if (iterable == null) {
            return false;
        }
        int i3 = 0;
        for (LBPPlayDetail lBPPlayDetail2 : iterable) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            LBPPlayConfig lBPPlayConfig = lBPPlayDetail2.conf;
            Integer valueOf = lBPPlayConfig != null ? Integer.valueOf(lBPPlayConfig.playType) : null;
            LBPPlayConfig lBPPlayConfig2 = lBPPlayDetail.conf;
            if (Intrinsics.areEqual(valueOf, lBPPlayConfig2 != null ? Integer.valueOf(lBPPlayConfig2.playType) : null)) {
                z16 = true;
            }
            i3 = i16;
        }
        return z16;
    }
}
