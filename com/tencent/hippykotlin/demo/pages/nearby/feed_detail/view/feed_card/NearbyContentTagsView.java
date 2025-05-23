package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.k;
import n25.l;
import o25.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyContentTagsView extends ComposeView<NearbyContentTagsAttr, NearbyContentTagsEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyContentTagsView.class, "locationTagWith", "getLocationTagWith()F", 0)};
    public boolean didLayout;
    public final ReadWriteProperty locationTagWith$delegate;
    public aa<ViewContainer<?, ?>> viewRef;

    public NearbyContentTagsView() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        this.locationTagWith$delegate = c.a(Float.valueOf(Float.NaN));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyContentTagsAttr access$getAttr(NearbyContentTagsView nearbyContentTagsView) {
        return (NearbyContentTagsAttr) nearbyContentTagsView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyContentTagsView nearbyContentTagsView = NearbyContentTagsView.this;
                viewContainer2.ref(viewContainer2, new Function1<aa<ViewContainer<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<ViewContainer<?, ?>> aaVar) {
                        NearbyContentTagsView.this.viewRef = aaVar;
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NearbyContentTagsView nearbyContentTagsView2 = NearbyContentTagsView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16;
                        NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel;
                        f mapTheme;
                        NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                        String str = null;
                        if ((viewModel != null ? viewModel.getMapTheme() : null) != null) {
                            NearbyFDPStatusContentViewModel viewModel2 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                            String str2 = (viewModel2 == null || (mapTheme = viewModel2.getMapTheme()) == null) ? null : mapTheme.f421849d;
                            NearbyFDPStatusContentViewModel viewModel3 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                            if (viewModel3 != null && (nearbyFDPUserFeedTimelineItemViewModel = viewModel3.timelineItemViewModel) != null) {
                                str = nearbyFDPUserFeedTimelineItemViewModel.fromThemeId;
                            }
                            if (!Intrinsics.areEqual(str2, str)) {
                                z16 = true;
                                return Boolean.valueOf(z16);
                            }
                        }
                        z16 = false;
                        return Boolean.valueOf(z16);
                    }
                };
                final NearbyContentTagsView nearbyContentTagsView3 = NearbyContentTagsView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyContentTagsView nearbyContentTagsView4 = NearbyContentTagsView.this;
                        conditionView.addChild(new NBPTagView(), new Function1<NBPTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPTagView nBPTagView) {
                                NBPTagView nBPTagView2 = nBPTagView;
                                final NearbyContentTagsView nearbyContentTagsView5 = NearbyContentTagsView.this;
                                nBPTagView2.attr(new Function1<NBPTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPTagAttr nBPTagAttr) {
                                        String str;
                                        f mapTheme;
                                        String str2;
                                        f mapTheme2;
                                        NBPTagAttr nBPTagAttr2 = nBPTagAttr;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                        String str3 = "";
                                        if (viewModel == null || (mapTheme2 = viewModel.getMapTheme()) == null || (str = mapTheme2.f421850e) == null) {
                                            str = "";
                                        }
                                        ReadWriteProperty readWriteProperty = nBPTagAttr2.tagNameStr$delegate;
                                        KProperty<?>[] kPropertyArr = NBPTagAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(nBPTagAttr2, kPropertyArr[1], str);
                                        NearbyFDPStatusContentViewModel viewModel2 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                        if (viewModel2 != null && (mapTheme = viewModel2.getMapTheme()) != null && (str2 = mapTheme.C) != null) {
                                            str3 = str2;
                                        }
                                        nBPTagAttr2.tagIconSrc$delegate.setValue(nBPTagAttr2, kPropertyArr[0], str3);
                                        nBPTagAttr2.marginRight(8.0f);
                                        nBPTagAttr2.isDarkStyle = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).isDarkStyle;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyContentTagsView nearbyContentTagsView6 = NearbyContentTagsView.this;
                                nBPTagView2.event(new Function1<NBPTagEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPTagEvent nBPTagEvent) {
                                        NBPTagEvent nBPTagEvent2 = nBPTagEvent;
                                        final NearbyContentTagsView nearbyContentTagsView7 = NearbyContentTagsView.this;
                                        nBPTagEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str;
                                                String str2;
                                                f mapTheme;
                                                f mapTheme2;
                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                                boolean z16 = false;
                                                int i3 = 1;
                                                if (!((viewModel == null || (mapTheme2 = viewModel.getMapTheme()) == null || mapTheme2.N != 0) ? false : true)) {
                                                    if (NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel() != null) {
                                                        NearbyFDPStatusContentViewModel viewModel2 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                                        if (viewModel2 != null && (mapTheme = viewModel2.getMapTheme()) != null) {
                                                            i3 = mapTheme.N;
                                                        }
                                                        NBPJumpUtil.jumpMoodGroupPage$default(2, i3, 0, null, false, 24);
                                                        KLog kLog = KLog.INSTANCE;
                                                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("onClickMoodGroupTag with mid: ", i3, kLog, "feed_detail_page");
                                                    }
                                                } else {
                                                    NearbyFDPStatusContentViewModel viewModel3 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                                    if (viewModel3 != null) {
                                                        l statusFeed = viewModel3.getStatusFeed();
                                                        String str3 = "";
                                                        if (statusFeed != null) {
                                                            f mapTheme3 = viewModel3.getMapTheme();
                                                            NBPJumpUtil.jumpSquareFeedList$default(null, null, null, "4", false, (mapTheme3 == null || (str2 = mapTheme3.f421849d) == null) ? "" : str2, statusFeed.C, null, 144);
                                                            z16 = true;
                                                        }
                                                        KLog kLog2 = KLog.INSTANCE;
                                                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onClickThemeTag with theme id ");
                                                        f mapTheme4 = viewModel3.getMapTheme();
                                                        if (mapTheme4 != null && (str = mapTheme4.f421849d) != null) {
                                                            str3 = str;
                                                        }
                                                        m3.append(str3);
                                                        m3.append(" success:");
                                                        m3.append(z16);
                                                        kLog2.i("feed_detail_page", m3.toString());
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyContentTagsView nearbyContentTagsView8 = NearbyContentTagsView.this;
                                        nBPTagEvent2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ClickParams clickParams2 = clickParams;
                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                                if (viewModel != null) {
                                                    viewModel.onClickLikeBtn(true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(NearbyContentTagsView.this, Reflection.getOrCreateKotlinClass(NearbyUserFeedsCardView.class)));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyContentTagsView nearbyContentTagsView4 = NearbyContentTagsView.this;
                viewContainer2.addChild(new NBPTagView(), new Function1<NBPTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPTagView nBPTagView) {
                        NBPTagView nBPTagView2 = nBPTagView;
                        final NearbyContentTagsView nearbyContentTagsView5 = NearbyContentTagsView.this;
                        nBPTagView2.attr(new Function1<NBPTagAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPTagAttr nBPTagAttr) {
                                float floatValue;
                                String str;
                                NBPTagAttr nBPTagAttr2 = nBPTagAttr;
                                floatValue = ((Number) r0.locationTagWith$delegate.getValue(NearbyContentTagsView.this, NearbyContentTagsView.$$delegatedProperties[0])).floatValue();
                                nBPTagAttr2.mo153width(floatValue);
                                NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                if (viewModel == null || (str = viewModel.getLocationText()) == null) {
                                    str = "";
                                }
                                ReadWriteProperty readWriteProperty = nBPTagAttr2.tagNameStr$delegate;
                                KProperty<?>[] kPropertyArr = NBPTagAttr.$$delegatedProperties;
                                readWriteProperty.setValue(nBPTagAttr2, kPropertyArr[1], str);
                                nBPTagAttr2.tagIconSrc$delegate.setValue(nBPTagAttr2, kPropertyArr[0], "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Wy8Y0lyQyV0.png");
                                nBPTagAttr2.isDarkStyle = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).isDarkStyle;
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentTagsView nearbyContentTagsView6 = NearbyContentTagsView.this;
                        nBPTagView2.event(new Function1<NBPTagEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPTagEvent nBPTagEvent) {
                                NBPTagEvent nBPTagEvent2 = nBPTagEvent;
                                final NearbyContentTagsView nearbyContentTagsView7 = NearbyContentTagsView.this;
                                nBPTagEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
                                    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        l statusFeed;
                                        k kVar;
                                        String str;
                                        boolean z16;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                        if (viewModel != null && (statusFeed = viewModel.getStatusFeed()) != null && (kVar = statusFeed.C) != null) {
                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyContentTagsView.access$getAttr(NearbyContentTagsView.this).getViewModel();
                                            if (viewModel2 == null || (str = viewModel2.getLocationText()) == null) {
                                                str = "";
                                            }
                                            if (!(str.length() == 0) && !Intrinsics.areEqual(str, "\u672a\u77e5\u5730\u70b9")) {
                                                if (!(kVar.G.length() == 0)) {
                                                    if (!(kVar.H.length() == 0)) {
                                                        if (!(kVar.I.length() == 0)) {
                                                            if (!(kVar.M.length() == 0)) {
                                                                z16 = true;
                                                                if (z16) {
                                                                    KLog kLog = KLog.INSTANCE;
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ignore poi=");
                                                                    m3.append(kVar.f418086d);
                                                                    m3.append('(');
                                                                    m3.append(kVar.Q);
                                                                    m3.append(')');
                                                                    kLog.i("NearbyContentTagsView", m3.toString());
                                                                } else {
                                                                    KLog kLog2 = KLog.INSTANCE;
                                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("goto middlePage poi=");
                                                                    m16.append(kVar.f418086d);
                                                                    m16.append('(');
                                                                    m16.append(kVar.Q);
                                                                    m16.append(')');
                                                                    kLog2.i("NearbyContentTagsView", m16.toString());
                                                                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{i.d(kVar)});
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_middle_page&nbp_source=3&local_bundle_name=nearbypro", false, 6);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            z16 = false;
                                            if (z16) {
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyContentTagsView nearbyContentTagsView8 = NearbyContentTagsView.this;
                                FrameEventKt.d(nBPTagEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentTagsView.body.1.5.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        aa<ViewContainer<?, ?>> aaVar;
                                        ViewContainer<?, ?> b16;
                                        d frame;
                                        float floatValue;
                                        float floatValue2;
                                        d dVar2 = dVar;
                                        NearbyContentTagsView nearbyContentTagsView9 = NearbyContentTagsView.this;
                                        if (!nearbyContentTagsView9.didLayout && (aaVar = nearbyContentTagsView9.viewRef) != null && (b16 = aaVar.b()) != null && (frame = b16.getFrame()) != null) {
                                            NearbyContentTagsView nearbyContentTagsView10 = NearbyContentTagsView.this;
                                            boolean z16 = true;
                                            if (dVar2.g() <= frame.getWidth()) {
                                                floatValue = ((Number) nearbyContentTagsView10.locationTagWith$delegate.getValue(nearbyContentTagsView10, NearbyContentTagsView.$$delegatedProperties[0])).floatValue();
                                                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                                                if (Float.isNaN(floatValue) || Float.isNaN(Float.NaN) ? !Float.isNaN(floatValue) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue) >= 1.0E-5f) {
                                                    z16 = false;
                                                }
                                                if (!z16) {
                                                    nearbyContentTagsView10.locationTagWith$delegate.setValue(nearbyContentTagsView10, NearbyContentTagsView.$$delegatedProperties[0], Float.valueOf(Float.NaN));
                                                }
                                            } else {
                                                float width = frame.getWidth() - dVar2.i();
                                                floatValue2 = ((Number) nearbyContentTagsView10.locationTagWith$delegate.getValue(nearbyContentTagsView10, NearbyContentTagsView.$$delegatedProperties[0])).floatValue();
                                                if (!(width == floatValue2)) {
                                                    nearbyContentTagsView10.locationTagWith$delegate.setValue(nearbyContentTagsView10, NearbyContentTagsView.$$delegatedProperties[0], Float.valueOf(width));
                                                }
                                                nearbyContentTagsView10.didLayout = true;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyContentTagsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyContentTagsEvent();
    }
}
