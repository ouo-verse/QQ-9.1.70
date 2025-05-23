package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark;

import a35.b;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NBPSchemeGeneratorKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPVasSsoRepo;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.FocusableMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerRect;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMapMarker;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerTransform;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerUIScheduler;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed.NBPFeedMarkerUIConfig;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import o25.a;
import o25.h;
import oicq.wlogin_sdk.tools.util;
import z25.c;
import z25.d;

/* loaded from: classes31.dex */
public final class NBPLandMarkerViewModel extends FocusableMarker implements IMarkerCollection, INBPMapMarkerUpdate {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "onlineUserList", "getOnlineUserList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "areaName", "getAreaName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "onlineNum", "getOnlineNum()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "adUrl", "getAdUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "areaMsgList", "getAreaMsgList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerViewModel.class, "msgBubbleAnimationTick", "getMsgBubbleAnimationTick()I", 0)};
    public static final Companion Companion = new Companion();
    public String adJumpUrl;
    public final Lazy adSize$delegate;
    public final ReadWriteProperty adUrl$delegate;
    public final a area;
    public final ReadWriteProperty areaMsgList$delegate;
    public String areaMsgRequestTimeoutRef;
    public final ReadWriteProperty areaName$delegate;
    public String areaRequestTimeoutRef;
    public final Lazy bgSize$delegate;
    public final NBPLandMarkerContext context;
    public int currentScheduleIndex;
    public final Lazy key$delegate;
    public NBPLandInfo landInfo;
    public final Lazy markerViewSize$delegate;
    public String msgBubbleAnimateTimeoutRef;
    public boolean msgBubbleAnimating;
    public final ReadWriteProperty msgBubbleAnimationTick$delegate;
    public final Lazy msgBubbleSize$delegate;
    public final ReadWriteProperty onlineNum$delegate;
    public final ReadWriteProperty onlineUserList$delegate;
    public NBPLatLng position;
    public final NBPLandMarkerRepo repo;
    public final List<String> schedulingMsgList;
    public final Lazy summaryTextMaxWidth$delegate;
    public final Lazy viewBuilder$delegate;
    public final Lazy zIndex$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public static final boolean access$hasChange(NBPLandMarkerViewModel nBPLandMarkerViewModel, b bVar, NBPLandInfo nBPLandInfo) {
        nBPLandMarkerViewModel.getClass();
        return (bVar.f25443e == nBPLandInfo.roomId && bVar.f25442d == nBPLandInfo.areaId) ? false : true;
    }

    public static final void access$triggerRequestAreaMsgList(final NBPLandMarkerViewModel nBPLandMarkerViewModel, final long j3, long j16) {
        nBPLandMarkerViewModel.getClass();
        KLog.INSTANCE.i("NBPLandMarkerViewModel", "requestAreaMsgList==Start intervalMillSecond=" + j16);
        if (nBPLandMarkerViewModel.areaMsgRequestTimeoutRef.length() > 0) {
            TimerKt.b(nBPLandMarkerViewModel.areaMsgRequestTimeoutRef);
            nBPLandMarkerViewModel.areaMsgRequestTimeoutRef = "";
        }
        nBPLandMarkerViewModel.areaMsgRequestTimeoutRef = TimerKt.d((int) j16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$triggerRequestAreaMsgList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NBPLandMarkerViewModel nBPLandMarkerViewModel2 = NBPLandMarkerViewModel.this;
                NBPLandInfo nBPLandInfo = nBPLandMarkerViewModel2.landInfo;
                final int i3 = nBPLandInfo.areaId;
                final long j17 = nBPLandInfo.roomId;
                final long j18 = j3;
                KLog.INSTANCE.i("NBPLandMarkerViewModel", "requestAreaMsgList==Real areaID=" + i3 + " roomID=" + j17 + " msgOffset=" + j18);
                NBPLandMarkerRepo nBPLandMarkerRepo = nBPLandMarkerViewModel2.repo;
                final Function1<b35.b, Unit> function1 = new Function1<b35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$requestAreaMsgInner$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:37:0x007f A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:24:0x005e, B:26:0x0063, B:28:0x0067, B:30:0x006b, B:32:0x0073, B:37:0x007f, B:39:0x0083, B:40:0x0089, B:41:0x008d, B:43:0x0094, B:44:0x00b0), top: B:23:0x005e }] */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:24:0x005e, B:26:0x0063, B:28:0x0067, B:30:0x006b, B:32:0x0073, B:37:0x007f, B:39:0x0083, B:40:0x0089, B:41:0x008d, B:43:0x0094, B:44:0x00b0), top: B:23:0x005e }] */
                    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(b35.b bVar) {
                        List list;
                        int collectionSizeOrDefault;
                        String str;
                        String decodeToString;
                        boolean z16;
                        String decodeToString2;
                        c45.a aVar;
                        byte[] bArr;
                        b35.b bVar2 = bVar;
                        if (bVar2 != null) {
                            NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                            nBPLandMarkerViewModel3.getClass();
                            if (!bVar2.f27853f.isEmpty()) {
                                list = CollectionsKt___CollectionsKt.toList(bVar2.f27853f);
                                ArrayList arrayList = new ArrayList();
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Object next = it.next();
                                    if (!(((z25.b) next).f451823f.f30291a.length == 0)) {
                                        arrayList.add(next);
                                    }
                                }
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                Iterator it5 = arrayList.iterator();
                                while (it5.hasNext()) {
                                    z25.b bVar3 = (z25.b) it5.next();
                                    try {
                                        d dVar = bVar3.f451822e;
                                        decodeToString = (dVar == null || (aVar = dVar.f451830e) == null || (bArr = aVar.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr);
                                    } catch (Exception e16) {
                                        KLog.INSTANCE.e("NBPLandMarkerViewModel", "handleChatMsg: " + e16);
                                        str = "";
                                    }
                                    if (decodeToString != null && decodeToString.length() != 0) {
                                        z16 = false;
                                        if (z16) {
                                            d dVar2 = bVar3.f451822e;
                                            decodeToString = String.valueOf(dVar2 != null ? Long.valueOf(dVar2.f451829d) : null);
                                        }
                                        if (decodeToString.length() > 6) {
                                            StringBuilder sb5 = new StringBuilder();
                                            String substring = decodeToString.substring(0, 6);
                                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                            sb5.append(substring);
                                            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                            decodeToString = sb5.toString();
                                        }
                                        decodeToString2 = StringsKt__StringsJVMKt.decodeToString(((c) i.b(new c(0L, 0L, 0L, null, 15, null), bVar3.f451823f.f30291a)).f451828h.f30291a);
                                        str = decodeToString + MsgSummary.STR_COLON + decodeToString2;
                                        arrayList2.add(str);
                                    }
                                    z16 = true;
                                    if (z16) {
                                    }
                                    if (decodeToString.length() > 6) {
                                    }
                                    decodeToString2 = StringsKt__StringsJVMKt.decodeToString(((c) i.b(new c(0L, 0L, 0L, null, 15, null), bVar3.f451823f.f30291a)).f451828h.f30291a);
                                    str = decodeToString + MsgSummary.STR_COLON + decodeToString2;
                                    arrayList2.add(str);
                                }
                                ArrayList arrayList3 = new ArrayList();
                                Iterator it6 = arrayList2.iterator();
                                while (it6.hasNext()) {
                                    Object next2 = it6.next();
                                    if (((String) next2).length() > 0) {
                                        arrayList3.add(next2);
                                    }
                                }
                                nBPLandMarkerViewModel3.schedulingMsgList.addAll(arrayList3);
                                if (!nBPLandMarkerViewModel3.msgBubbleAnimating) {
                                    nBPLandMarkerViewModel3.msgBubbleAnimating = true;
                                    nBPLandMarkerViewModel3.scheduleMsgBubbleAnimate(0);
                                }
                            }
                            NBPLandMarkerViewModel.access$triggerRequestAreaMsgList(NBPLandMarkerViewModel.this, bVar2.f27851d, Math.max(30000L, bVar2.f27852e));
                        } else {
                            NBPLandMarkerViewModel.access$triggerRequestAreaMsgList(NBPLandMarkerViewModel.this, j18, 30000L);
                        }
                        return Unit.INSTANCE;
                    }
                };
                nBPLandMarkerRepo.getClass();
                NBPVasSsoRepo.sendVasProxyRequest$default("trpc.qmeta.public_chat_read_svr.ChatRead", "PullMsg", new b35.a(i3, j17, j18), new Function1<PbResponse<w35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerRepo$fetchAreaMsg$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PbResponse<w35.b> pbResponse) {
                        PbResponse<w35.b> pbResponse2 = pbResponse;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchAreaMsg: id: ");
                        m3.append(i3);
                        m3.append(", ");
                        m3.append(j17);
                        m3.append(", ");
                        m3.append(j18);
                        m3.append(", ");
                        m3.append(pbResponse2.f114187msg);
                        m3.append(", ");
                        m3.append(pbResponse2.code);
                        m3.append(", ");
                        w35.b bVar = pbResponse2.rsp;
                        m3.append(bVar != null ? bVar.f444545m : null);
                        m3.append(", ");
                        w35.b bVar2 = pbResponse2.rsp;
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar2 != null ? Integer.valueOf(bVar2.f444540d) : null, kLog, "NBPLandMarkerRepo");
                        if (pbResponse2.success && pbResponse2.rsp != null) {
                            try {
                                Function1<b35.b, Unit> function12 = function1;
                                b35.b bVar3 = new b35.b(0L, 0, null, 7, null);
                                w35.b bVar4 = pbResponse2.rsp;
                                Intrinsics.checkNotNull(bVar4, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.vas_mob_proxy_svr.VasProxyRsp");
                                function12.invoke(i.b(bVar3, bVar4.f444542f.f30291a));
                            } catch (Throwable th5) {
                                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchSimpleRoomInfo decode error: ", th5, KLog.INSTANCE, "NBPLandMarkerRepo");
                                function1.invoke(null);
                            }
                        } else {
                            function1.invoke(null);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final boolean addCollectionMarker(NBPMapMarker nBPMapMarker, float f16) {
        return f16 >= NBPFeedMarkerUIConfig.Companion.getInstance().collectionAreaPercent;
    }

    public final Pair<Float, Float> calAdPosition() {
        Object firstOrNull;
        h hVar;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.area.f421833h);
        o25.b bVar = (o25.b) firstOrNull;
        if (bVar != null && (hVar = bVar.f421836e) != null) {
            Pair<Float, Float> calTablePosInArea = calTablePosInArea(new a35.a(hVar.f421860d, hVar.f421861e));
            return new Pair<>(Float.valueOf(calTablePosInArea.getFirst().floatValue() - (getAdSize().getWidth() / 2.0f)), Float.valueOf(calTablePosInArea.getSecond().floatValue() - (getAdSize().getHeight() / 2.0f)));
        }
        return new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final boolean canShowOnSubMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final Boolean clickInSide(float f16, float f17, MarkerRect markerRect) {
        float f18 = markerRect.left;
        float f19 = markerRect.width;
        float f26 = (f19 / 2.0f) + f18;
        float f27 = markerRect.top;
        float f28 = markerRect.height;
        float f29 = f28 / 2.0f;
        float f36 = f27 + f29;
        float f37 = this.context.scale;
        float f38 = (f19 * f37) / 2.0f;
        float f39 = f26 - f38;
        float f46 = f36 - ((f28 * f37) / 2.0f);
        float f47 = f38 + f26;
        float f48 = f36 + f37 + f29;
        float height = getMsgBubbleSize().getHeight() * this.context.scale;
        if (f39 < f47 && f46 < f48 && f16 >= f39 && f16 < f47 && f17 >= f46 && f17 < f48) {
            KLog.INSTANCE.i("NBPLandMarkerViewModel", "click land marker");
            onClickMarkerFromMap(f16 - f39, (f17 - f46) - height);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final w getAdSize() {
        return (w) this.adSize$delegate.getValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPMsgBubbleInfo> getAreaMsgList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.areaMsgList$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final w getBgSize() {
        return (w) this.bgSize$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final MarkerRect getMarkerRectOnScreen(NBPMapMarker nBPMapMarker) {
        return null;
    }

    public final w getMarkerViewSize() {
        return (w) this.markerViewSize$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final NBPMarkerTransform getMarkerViewTransformWhenMapChangedOnVisible(float f16, float f17, float f18, NBPMarkerUIScheduler nBPMarkerUIScheduler) {
        float f19;
        float width = (f17 / getMarkerViewSize().getWidth()) - 0.5f;
        float height = (f18 / getMarkerViewSize().getHeight()) - 0.5f;
        if (f16 < 13.6f) {
            f19 = 0.65f;
            if (f16 >= 13.0f) {
                f19 = 0.65f + (((f16 - 13.0f) / 0.6000004f) * (1 - 0.65f));
            }
        } else {
            f19 = 1.0f;
        }
        NBPLandMarkerContext nBPLandMarkerContext = this.context;
        nBPLandMarkerContext.getClass();
        nBPLandMarkerContext.scale = f19;
        return new NBPMarkerTransform(new y(width, height, 0.0f, 0.0f, 12, null), new u(f19, f19));
    }

    public final w getMsgBubbleSize() {
        return (w) this.msgBubbleSize$delegate.getValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPLandMarkOnlineUsers> getOnlineUserList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.onlineUserList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final float getSummaryTextMaxWidth() {
        return ((Number) this.summaryTextMaxWidth$delegate.getValue()).floatValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void onClickMarkerFromMap(float f16, float f17) {
        Object firstOrNull;
        boolean z16 = false;
        if (this.adJumpUrl.length() > 0) {
            Pair<Float, Float> calAdPosition = calAdPosition();
            float width = (getAdSize().getWidth() / 2.0f) + (calAdPosition.getFirst().floatValue() * this.context.scale);
            float height = (getAdSize().getHeight() / 2.0f) + (calAdPosition.getSecond().floatValue() * this.context.scale);
            float width2 = width - ((getAdSize().getWidth() * this.context.scale) / 2.0f);
            float height2 = height - ((getAdSize().getHeight() * this.context.scale) / 2.0f);
            float width3 = ((getAdSize().getWidth() * this.context.scale) / 2.0f) + width;
            float height3 = (getAdSize().getHeight() / 2.0f) + height + this.context.scale;
            if (width2 < width3 && height2 < height3 && f16 >= width2 && f16 < width3 && f17 >= height2 && f17 < height3) {
                QQNearbyModule.Companion.getInstance().launchZPlanScheme(this.adJumpUrl);
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click in ad area: "), this.adJumpUrl, KLog.INSTANCE, "NBPLandMarkerViewModel");
                return;
            }
        }
        a aVar = this.area;
        int i3 = aVar.f421830d;
        long j3 = this.landInfo.roomId;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aVar.f421833h);
        o25.b bVar = (o25.b) firstOrNull;
        String str = bVar != null ? bVar.f421837f : null;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            str = ((com.tencent.kuikly.core.module.d) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCodecModule")).urlEncode(str);
        }
        String valueOf = String.valueOf(j3);
        if (str == null) {
            str = "";
        }
        String landMarkScheme = NBPSchemeGeneratorKt.getLandMarkScheme(i3, valueOf, str);
        QQNearbyModule.Companion.getInstance().launchZPlanScheme(landMarkScheme);
        KLog.INSTANCE.i("NBPLandMarkerViewModel", "on LandMarker click: " + landMarkScheme);
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_square_icon");
        jsonWithMainPgParams.v("nearby_square_type", NtFaceConstant.SMALL);
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
    }

    public final void requestAreaInfo(final int i3, long j3) {
        KLog.INSTANCE.i("NBPLandMarkerViewModel", "requestAreaInfo==Start delay=" + j3 + " areaID=" + i3);
        if (this.areaRequestTimeoutRef.length() > 0) {
            TimerKt.b(this.areaRequestTimeoutRef);
            this.areaRequestTimeoutRef = "";
        }
        this.areaRequestTimeoutRef = TimerKt.d((int) j3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$requestAreaInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                List mutableListOf;
                final NBPLandMarkerViewModel nBPLandMarkerViewModel = NBPLandMarkerViewModel.this;
                final int i16 = i3;
                NBPLandMarkerRepo nBPLandMarkerRepo = nBPLandMarkerViewModel.repo;
                final Function1<c35.b, Unit> function1 = new Function1<c35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$requestAreaInfoInner$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:111:? A[LOOP:4: B:67:0x0101->B:111:?, LOOP_END, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:44:? A[LOOP:1: B:12:0x005a->B:44:?, LOOP_END, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:90:0x0157 A[EDGE_INSN: B:90:0x0157->B:91:0x0157 BREAK  A[LOOP:4: B:67:0x0101->B:111:?], SYNTHETIC] */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(c35.b bVar) {
                        Object first;
                        String valueOf;
                        Object obj;
                        NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers;
                        boolean z16;
                        Object obj2;
                        boolean z17;
                        c35.b bVar2 = bVar;
                        if (bVar2 != null && (!bVar2.f30265d.isEmpty())) {
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) bVar2.f30265d);
                            b bVar3 = (b) first;
                            NBPLandMarkerViewModel nBPLandMarkerViewModel2 = NBPLandMarkerViewModel.this;
                            nBPLandMarkerViewModel2.getClass();
                            int i17 = bVar3.f25446i;
                            if (i17 > 99) {
                                valueOf = "99+";
                            } else {
                                valueOf = String.valueOf(i17);
                            }
                            nBPLandMarkerViewModel2.onlineNum$delegate.setValue(nBPLandMarkerViewModel2, NBPLandMarkerViewModel.$$delegatedProperties[2], valueOf);
                            NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                            nBPLandMarkerViewModel3.getClass();
                            ArrayList arrayList = new ArrayList();
                            Iterator<NBPLandMarkOnlineUsers> it = nBPLandMarkerViewModel3.getOnlineUserList().iterator();
                            while (it.hasNext()) {
                                NBPLandMarkOnlineUsers next = it.next();
                                Iterator<T> it5 = bVar3.f25444f.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    Object next2 = it5.next();
                                    a35.d dVar = (a35.d) next2;
                                    long j16 = dVar.f25450e;
                                    a35.d dVar2 = next.userInfo;
                                    if (j16 == dVar2.f25450e) {
                                        a35.e eVar = dVar.f25449d;
                                        String str = eVar != null ? eVar.f25452e : null;
                                        a35.e eVar2 = dVar2.f25449d;
                                        if (Intrinsics.areEqual(str, eVar2 != null ? eVar2.f25452e : null)) {
                                            a35.e eVar3 = dVar.f25449d;
                                            Integer valueOf2 = eVar3 != null ? Integer.valueOf(eVar3.f25453f) : null;
                                            a35.e eVar4 = next.userInfo.f25449d;
                                            if (Intrinsics.areEqual(valueOf2, eVar4 != null ? Integer.valueOf(eVar4.f25453f) : null)) {
                                                z17 = true;
                                                if (!z17) {
                                                    obj2 = next2;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z17) {
                                    }
                                }
                                if (((a35.d) obj2) == null) {
                                    arrayList.add(next);
                                }
                            }
                            nBPLandMarkerViewModel3.getOnlineUserList().removeAll(arrayList);
                            ArrayList arrayList2 = new ArrayList();
                            for (a35.d dVar3 : bVar3.f25444f) {
                                Iterator<T> it6 = bVar3.f25445h.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it6.next();
                                    if (dVar3.f25450e == ((a35.c) obj).f25447d) {
                                        break;
                                    }
                                }
                                a35.c cVar = (a35.c) obj;
                                Iterator<NBPLandMarkOnlineUsers> it7 = nBPLandMarkerViewModel3.getOnlineUserList().iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        nBPLandMarkOnlineUsers = null;
                                        break;
                                    }
                                    nBPLandMarkOnlineUsers = it7.next();
                                    NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers2 = nBPLandMarkOnlineUsers;
                                    if (nBPLandMarkOnlineUsers2.tableInfo.f25447d == dVar3.f25450e) {
                                        a35.e eVar5 = nBPLandMarkOnlineUsers2.userInfo.f25449d;
                                        Integer valueOf3 = eVar5 != null ? Integer.valueOf(eVar5.f25453f) : null;
                                        a35.e eVar6 = dVar3.f25449d;
                                        if (Intrinsics.areEqual(valueOf3, eVar6 != null ? Integer.valueOf(eVar6.f25453f) : null)) {
                                            a35.e eVar7 = nBPLandMarkOnlineUsers2.userInfo.f25449d;
                                            String str2 = eVar7 != null ? eVar7.f25452e : null;
                                            a35.e eVar8 = dVar3.f25449d;
                                            if (Intrinsics.areEqual(str2, eVar8 != null ? eVar8.f25452e : null)) {
                                                z16 = true;
                                                if (!z16) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    z16 = false;
                                    if (!z16) {
                                    }
                                }
                                if (nBPLandMarkOnlineUsers == null) {
                                    if (cVar != null) {
                                        Pair<Float, Float> calTablePosInArea = nBPLandMarkerViewModel3.calTablePosInArea(cVar.f25448e);
                                        arrayList2.add(new NBPLandMarkOnlineUsers(dVar3, cVar, new Pair(Float.valueOf(calTablePosInArea.getFirst().floatValue() - 14.0f), Float.valueOf(calTablePosInArea.getSecond().floatValue() - 14.0f))));
                                    } else {
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("not find table id: ");
                                        m3.append(dVar3.f25450e);
                                        m3.append(", ");
                                        a35.e eVar9 = dVar3.f25449d;
                                        m3.append(eVar9 != null ? eVar9.f25451d : null);
                                        m3.append(", ");
                                        a35.e eVar10 = dVar3.f25449d;
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, eVar10 != null ? eVar10.f25452e : null, kLog, "NBPLandMarkerViewModel");
                                    }
                                }
                            }
                            nBPLandMarkerViewModel3.getOnlineUserList().addAll(arrayList2);
                            NBPLandMarkerViewModel nBPLandMarkerViewModel4 = NBPLandMarkerViewModel.this;
                            if (NBPLandMarkerViewModel.access$hasChange(nBPLandMarkerViewModel4, bVar3, nBPLandMarkerViewModel4.landInfo)) {
                                NBPLandMarkerViewModel nBPLandMarkerViewModel5 = NBPLandMarkerViewModel.this;
                                nBPLandMarkerViewModel5.landInfo = new NBPLandInfo(bVar3.f25442d, bVar3.f25443e);
                                NBPLandMarkerViewModel.access$triggerRequestAreaMsgList(nBPLandMarkerViewModel5, 0L, 0L);
                            }
                        }
                        NBPLandMarkerViewModel.this.requestAreaInfo(i16, 30000L);
                        return Unit.INSTANCE;
                    }
                };
                nBPLandMarkerRepo.getClass();
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Integer.valueOf(i16));
                NBPVasSsoRepo.sendVasProxyRequest$default("trpc.qmeta.status_square_room_svr.StatusSquareRoomSvr", "GetSimpleRoomInfo", new c35.a(mutableListOf), new Function1<PbResponse<w35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerRepo$fetchSimpleRoomInfo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PbResponse<w35.b> pbResponse) {
                        PbResponse<w35.b> pbResponse2 = pbResponse;
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchSimpleRoomInfo: id: ");
                        m3.append(i16);
                        m3.append(", code: ");
                        m3.append(pbResponse2.code);
                        m3.append(", msg: ");
                        m3.append(pbResponse2.f114187msg);
                        m3.append(", ");
                        w35.b bVar = pbResponse2.rsp;
                        List list = null;
                        byte b16 = 0;
                        m3.append(bVar != null ? bVar.f444545m : null);
                        m3.append(", ");
                        w35.b bVar2 = pbResponse2.rsp;
                        NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar2 != null ? Integer.valueOf(bVar2.f444540d) : null, kLog, "NBPLandMarkerRepo");
                        if (pbResponse2.success && pbResponse2.rsp != null) {
                            try {
                                Function1<c35.b, Unit> function12 = function1;
                                c35.b bVar3 = new c35.b(list, 1, b16 == true ? 1 : 0);
                                w35.b bVar4 = pbResponse2.rsp;
                                Intrinsics.checkNotNull(bVar4, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.vas_mob_proxy_svr.VasProxyRsp");
                                function12.invoke(i.b(bVar3, bVar4.f444542f.f30291a));
                            } catch (Throwable th5) {
                                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchSimpleRoomInfo decode error: ", th5, KLog.INSTANCE, "NBPLandMarkerRepo");
                                function1.invoke(null);
                            }
                        } else {
                            function1.invoke(null);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    public final void scheduleMsgBubbleAnimate(int i3) {
        if (this.currentScheduleIndex < this.schedulingMsgList.size() && this.msgBubbleAnimating) {
            this.msgBubbleAnimateTimeoutRef = TimerKt.d(i3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$scheduleMsgBubbleAnimate$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (NBPLandMarkerViewModel.this.getAreaMsgList().size() >= 4) {
                        CollectionsKt__MutableCollectionsKt.removeLast(NBPLandMarkerViewModel.this.getAreaMsgList());
                    }
                    com.tencent.kuikly.core.reactive.collection.c<NBPMsgBubbleInfo> areaMsgList = NBPLandMarkerViewModel.this.getAreaMsgList();
                    NBPLandMarkerViewModel nBPLandMarkerViewModel = NBPLandMarkerViewModel.this;
                    areaMsgList.add(0, new NBPMsgBubbleInfo((String) nBPLandMarkerViewModel.schedulingMsgList.get(nBPLandMarkerViewModel.currentScheduleIndex)));
                    final NBPLandMarkerViewModel nBPLandMarkerViewModel2 = NBPLandMarkerViewModel.this;
                    nBPLandMarkerViewModel2.msgBubbleAnimateTimeoutRef = TimerKt.d(16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$scheduleMsgBubbleAnimate$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            Iterator<NBPMsgBubbleInfo> it = NBPLandMarkerViewModel.this.getAreaMsgList().iterator();
                            int i16 = 0;
                            while (it.hasNext()) {
                                NBPMsgBubbleInfo next = it.next();
                                int i17 = i16 + 1;
                                if (i16 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                NBPMsgBubbleInfo nBPMsgBubbleInfo = next;
                                if (i16 == 0) {
                                    nBPMsgBubbleInfo.alpha = 1.0f;
                                    nBPMsgBubbleInfo.scale = 1.0f;
                                } else if (i16 == 1) {
                                    nBPMsgBubbleInfo.alpha = 0.8f;
                                    nBPMsgBubbleInfo.scale = 0.92f;
                                } else if (i16 == 2) {
                                    nBPMsgBubbleInfo.scale = 0.86f;
                                    nBPMsgBubbleInfo.alpha = 0.5f;
                                } else if (i16 == 3) {
                                    nBPMsgBubbleInfo.alpha = 0.0f;
                                    nBPMsgBubbleInfo.scale = 0.5f;
                                }
                                nBPMsgBubbleInfo.translateY -= 1.07f;
                                i16 = i17;
                            }
                            NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                            ReadWriteProperty readWriteProperty = nBPLandMarkerViewModel3.msgBubbleAnimationTick$delegate;
                            KProperty<?>[] kPropertyArr = NBPLandMarkerViewModel.$$delegatedProperties;
                            nBPLandMarkerViewModel3.msgBubbleAnimationTick$delegate.setValue(nBPLandMarkerViewModel3, kPropertyArr[5], Integer.valueOf(((Number) readWriteProperty.getValue(nBPLandMarkerViewModel3, kPropertyArr[5])).intValue() + 1));
                            NBPLandMarkerViewModel nBPLandMarkerViewModel4 = NBPLandMarkerViewModel.this;
                            nBPLandMarkerViewModel4.currentScheduleIndex++;
                            nBPLandMarkerViewModel4.scheduleMsgBubbleAnimate(2000);
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        this.currentScheduleIndex = 0;
        this.schedulingMsgList.clear();
        this.msgBubbleAnimating = false;
    }

    public final void setAdUrl(String str) {
        this.adUrl$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setAreaName(String str) {
        this.areaName$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final Pair<Float, Float> calTablePosInArea(a35.a aVar) {
        Object first;
        if (aVar != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.area.f421832f);
            o25.c cVar = (o25.c) first;
            int i3 = cVar.f421839e;
            int i16 = cVar.f421840f;
            float f16 = i3;
            float width = getBgSize().getWidth() / f16;
            return new Pair<>(Float.valueOf(((f16 / 2.0f) + aVar.f25440d) * width), Float.valueOf(((i16 / 2.0f) - aVar.f25441e) * width));
        }
        return new Pair<>(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }

    public NBPLandMarkerViewModel(a aVar) {
        super(1.5f, 0.5f, 0.5f);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Object firstOrNull;
        Object firstOrNull2;
        String str;
        String str2;
        String str3;
        this.area = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Function1<? super ViewContainer<?, ?>, ? extends Unit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$viewBuilder$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Function1<? super ViewContainer<?, ?>, ? extends Unit> invoke() {
                final NBPLandMarkerViewModel nBPLandMarkerViewModel = NBPLandMarkerViewModel.this;
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$viewBuilder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel2 = NBPLandMarkerViewModel.this;
                        viewContainer.addChild(new NBPLandMarkerView(), new Function1<NBPLandMarkerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel.viewBuilder.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPLandMarkerView nBPLandMarkerView) {
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                                nBPLandMarkerView.attr(new Function1<NBPLandMarkerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel.viewBuilder.2.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPLandMarkerAttr nBPLandMarkerAttr) {
                                        nBPLandMarkerAttr.f114226vm = NBPLandMarkerViewModel.this;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
            }
        });
        this.viewBuilder$delegate = lazy;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$key$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("area_");
                m3.append(NBPLandMarkerViewModel.this.area.f421830d);
                m3.append(util.base64_pad_url);
                m3.append(NBPLandMarkerViewModel.this.hashCode());
                return m3.toString();
            }
        });
        this.key$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Double>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$zIndex$2
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(22720896000L);
            }
        });
        this.zIndex$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<w>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$bgSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                Object firstOrNull3;
                w wVar;
                int i3;
                int i16;
                float m3 = (GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) * 2) / 5.0f;
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) NBPLandMarkerViewModel.this.area.f421832f);
                o25.c cVar = (o25.c) firstOrNull3;
                if (cVar != null && (i3 = cVar.f421839e) != 0 && (i16 = cVar.f421840f) != 0) {
                    KLog.INSTANCE.i("NBPLandMarkerViewModel", "area size: " + i3 + ", " + i16);
                    wVar = new w((float) i3, (float) i16);
                } else {
                    KLog.INSTANCE.i("NBPLandMarkerViewModel", "area bg size is null");
                    wVar = new w(225.0f, 180.0f);
                }
                return new w(m3, wVar.getHeight() * (m3 / wVar.getWidth()));
            }
        });
        this.bgSize$delegate = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$summaryTextMaxWidth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(NBPLandMarkerViewModel.this.getBgSize().getWidth() - 40.0f);
            }
        });
        this.summaryTextMaxWidth$delegate = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<w>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$msgBubbleSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return new w((NBPLandMarkerViewModel.this.getBgSize().getWidth() * 9.0f) / 10.0f, 70.0f);
            }
        });
        this.msgBubbleSize$delegate = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<w>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$adSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                float width = (NBPLandMarkerViewModel.this.getBgSize().getWidth() * 2.0f) / 7.0f;
                return new w(width, width / 0.77f);
            }
        });
        this.adSize$delegate = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<w>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerViewModel$markerViewSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return new w(NBPLandMarkerViewModel.this.getBgSize().getWidth(), NBPLandMarkerViewModel.this.getMsgBubbleSize().getHeight() + NBPLandMarkerViewModel.this.getBgSize().getHeight());
            }
        });
        this.markerViewSize$delegate = lazy8;
        String str4 = "";
        this.areaRequestTimeoutRef = "";
        this.areaMsgRequestTimeoutRef = "";
        this.repo = new NBPLandMarkerRepo();
        this.landInfo = new NBPLandInfo();
        this.schedulingMsgList = new ArrayList();
        this.msgBubbleAnimateTimeoutRef = "";
        this.onlineUserList$delegate = c01.c.b();
        this.areaName$delegate = c01.c.a("");
        this.onlineNum$delegate = c01.c.a("0");
        this.adUrl$delegate = c01.c.a("");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aVar.f421833h);
        o25.b bVar = (o25.b) firstOrNull;
        this.adJumpUrl = (bVar == null || (str3 = bVar.f421837f) == null) ? "" : str3;
        this.areaMsgList$delegate = c01.c.b();
        this.msgBubbleAnimationTick$delegate = c01.c.a(0);
        this.context = new NBPLandMarkerContext();
        if (aVar.f421831e != null) {
            this.position = new NBPLatLng(r1.f421846d, r1.f421847e);
        }
        o25.d dVar = aVar.f421834i;
        setAreaName((dVar == null || (str2 = dVar.f421841d) == null) ? "" : str2);
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aVar.f421833h);
        o25.b bVar2 = (o25.b) firstOrNull2;
        if (bVar2 != null && (str = bVar2.f421835d) != null) {
            str4 = str;
        }
        setAdUrl(str4);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.IMarkerCollection
    public final void resetCollection() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.INBPMapMarkerUpdate
    public final void themeConfigDidLoad() {
    }
}
