package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Cover;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarAttr;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarEvent;
import com.tencent.hippykotlin.demo.pages.base.ECCirAvatarView;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoAttr;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoEvent;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoView;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoViewKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayState;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.Video;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StImage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StUser;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StVideo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StVisitor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.MultiLineHighLightTextView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.SliderPageAttr;
import com.tencent.kuikly.core.views.compose.SliderPageView;
import com.tencent.kuikly.core.views.compose.d;
import com.tencent.kuikly.core.views.compose.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SingleVideoItemView extends ComposeView<SingleVideoItemAttr, SingleVideoItemEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SingleVideoItemView.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0)};
    public boolean hasFocus;
    public aa<SliderPageView> imageBannerRef;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);
    public aa<QQCirVideoView> videoRef;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.util.Collection, java.util.ArrayList<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StImage>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.util.ArrayList] */
    public static final void access$createImageBannerView(SingleVideoItemView singleVideoItemView, final SingleVideoItemView singleVideoItemView2, final float f16, ViewContainer viewContainer) {
        singleVideoItemView.getClass();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r06 = ((SingleVideoItemAttr) singleVideoItemView2.getAttr()).getStFeedEx().stFeed.images;
        objectRef.element = r06;
        if (r06 == 0 || r06.isEmpty()) {
            objectRef.element = new ArrayList();
            StImage stImage = ((SingleVideoItemAttr) singleVideoItemView2.getAttr()).getStFeedEx().stFeed.cover;
            if (stImage != null) {
                ((ArrayList) objectRef.element).add(stImage);
            }
        }
        e.a(viewContainer, new Function1<SliderPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SliderPageView sliderPageView) {
                SliderPageView sliderPageView2 = sliderPageView;
                final SingleVideoItemView singleVideoItemView3 = SingleVideoItemView.this;
                sliderPageView2.ref(sliderPageView2, new Function1<aa<SliderPageView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<SliderPageView> aaVar) {
                        SingleVideoItemView.this.imageBannerRef = aaVar;
                        return Unit.INSTANCE;
                    }
                });
                final float f17 = f16;
                final SingleVideoItemView singleVideoItemView4 = SingleVideoItemView.this;
                final Ref.ObjectRef<ArrayList<StImage>> objectRef2 = objectRef;
                sliderPageView2.attr(new Function1<SliderPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SliderPageAttr sliderPageAttr) {
                        SliderPageAttr sliderPageAttr2 = sliderPageAttr;
                        sliderPageAttr2.q(0);
                        sliderPageAttr2.r(true);
                        sliderPageAttr2.t(f17);
                        FlexNode flexNode = SingleVideoItemView.access$getAttr(singleVideoItemView4).getFlexNode();
                        Intrinsics.checkNotNull(flexNode);
                        sliderPageAttr2.u(flexNode.U());
                        ArrayList<StImage> arrayList = objectRef2.element;
                        final SingleVideoItemView singleVideoItemView5 = singleVideoItemView4;
                        sliderPageAttr2.o(arrayList, new Function2<PageListView<?, ?>, StImage, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2$2$1$1
                            {
                                super(2);
                            }

                            /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.CharSequence, java.lang.String] */
                            /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.String] */
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(PageListView<?, ?> pageListView, StImage stImage2) {
                                PageListView<?, ?> pageListView2 = pageListView;
                                StImage stImage3 = stImage2;
                                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                                ?? r16 = stImage3.picUrl;
                                objectRef3.element = r16;
                                if (r16.length() == 0) {
                                    objectRef3.element = stImage3.layerPicUrl;
                                }
                                final SingleVideoItemView singleVideoItemView6 = SingleVideoItemView.this;
                                ah.a(pageListView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2$2$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final Ref.ObjectRef<String> objectRef4 = objectRef3;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.createImageBannerView.1.2.2.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.m140flex(1.0f);
                                                b.a.b(afVar2, objectRef4.element, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SingleVideoItemView singleVideoItemView7 = singleVideoItemView6;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.createImageBannerView.1.2.2.1.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final SingleVideoItemView singleVideoItemView8 = SingleVideoItemView.this;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.createImageBannerView.1.2.2.1.1.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<? super QQVideoView, Unit> function1 = SingleVideoItemView.access$getEvent(SingleVideoItemView.this).onVideoClick;
                                                        if (function1 != null) {
                                                            function1.invoke(null);
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
                        return Unit.INSTANCE;
                    }
                });
                final SingleVideoItemView singleVideoItemView5 = SingleVideoItemView.this;
                sliderPageView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createImageBannerView$1$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(d dVar) {
                        final SingleVideoItemView singleVideoItemView6 = SingleVideoItemView.this;
                        VisibilityEventKt.b(dVar, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.createImageBannerView.1.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                SliderPageView b16;
                                SliderPageView b17;
                                if (SingleVideoItemView.access$getPlayControl(SingleVideoItemView.this) == QVideoPlayControl.PLAY) {
                                    aa<SliderPageView> aaVar = SingleVideoItemView.this.imageBannerRef;
                                    if (aaVar != null && (b17 = aaVar.b()) != null) {
                                        b17.y();
                                    }
                                } else {
                                    aa<SliderPageView> aaVar2 = SingleVideoItemView.this.imageBannerRef;
                                    if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                        b16.z();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                if (SingleVideoItemView.access$getPlayControl(SingleVideoItemView.this) == QVideoPlayControl.PLAY) {
                    sliderPageView2.y();
                } else {
                    sliderPageView2.z();
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchFocusState(SingleVideoItemView singleVideoItemView) {
        if (((SingleVideoItemAttr) singleVideoItemView.getAttr()).getPlayIndex() == ((SingleVideoItemAttr) singleVideoItemView.getAttr()).index) {
            if (singleVideoItemView.hasFocus) {
                return;
            }
            singleVideoItemView.hasFocus = true;
            singleVideoItemView.setPlayControl(QVideoPlayControl.PLAY);
            return;
        }
        if (singleVideoItemView.hasFocus) {
            singleVideoItemView.hasFocus = false;
            if (((SingleVideoItemAttr) singleVideoItemView.getAttr()).getPlayIndex() == -2) {
                singleVideoItemView.setPlayControl(QVideoPlayControl.PAUSE);
            } else {
                singleVideoItemView.setPlayControl(QVideoPlayControl.STOP);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SingleVideoItemAttr access$getAttr(SingleVideoItemView singleVideoItemView) {
        return (SingleVideoItemAttr) singleVideoItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SingleVideoItemEvent access$getEvent(SingleVideoItemView singleVideoItemView) {
        return (SingleVideoItemEvent) singleVideoItemView.getEvent();
    }

    public static final QVideoPlayControl access$getPlayControl(SingleVideoItemView singleVideoItemView) {
        return (QVideoPlayControl) singleVideoItemView.playControl$delegate.getValue(singleVideoItemView, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        FlexNode flexNode = ((SingleVideoItemAttr) getAttr()).getFlexNode();
        Intrinsics.checkNotNull(flexNode);
        final float U = flexNode.U() / 0.75f;
        final int i3 = ((SingleVideoItemAttr) getAttr()).getStFeedEx().stFeed.type;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.borderRadius(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                final SingleVideoItemView singleVideoItemView = SingleVideoItemView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final SingleVideoItemView singleVideoItemView2 = SingleVideoItemView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                QQCirVideoView b16;
                                aa<QQVideoView> aaVar;
                                Function1<? super QQVideoView, Unit> function1 = SingleVideoItemView.access$getEvent(SingleVideoItemView.this).onVideoClick;
                                if (function1 != null) {
                                    aa<QQCirVideoView> aaVar2 = SingleVideoItemView.this.videoRef;
                                    function1.invoke((aaVar2 == null || (b16 = aaVar2.b()) == null || (aaVar = b16.videoRef) == null) ? null : aaVar.b());
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final float f16 = U;
                final int i16 = i3;
                final SingleVideoItemView singleVideoItemView2 = SingleVideoItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                return Unit.INSTANCE;
                            }
                        });
                        final float f17 = f16;
                        final int i17 = i16;
                        final SingleVideoItemView singleVideoItemView3 = singleVideoItemView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f18 = f17;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(f18);
                                        tVar2.mo113backgroundColor(h.INSTANCE.b());
                                        tVar2.overflow(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final int i18 = i17;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(i18 == 2);
                                    }
                                };
                                final SingleVideoItemView singleVideoItemView4 = singleVideoItemView3;
                                final float f19 = f17;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        SingleVideoItemView singleVideoItemView5 = SingleVideoItemView.this;
                                        SingleVideoItemView.access$createImageBannerView(singleVideoItemView5, singleVideoItemView5, f19, conditionView);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleVideoItemView singleVideoItemView5 = singleVideoItemView3;
                                final float f26 = f17;
                                ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final SingleVideoItemView singleVideoItemView6 = SingleVideoItemView.this;
                                        final float f27 = f26;
                                        KProperty<Object>[] kPropertyArr = SingleVideoItemView.$$delegatedProperties;
                                        singleVideoItemView6.getClass();
                                        QQCirVideoViewKt.QQCirVideo(conditionView, new Function1<QQCirVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createVideoView$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QQCirVideoView qQCirVideoView) {
                                                QQCirVideoView qQCirVideoView2 = qQCirVideoView;
                                                final SingleVideoItemView singleVideoItemView7 = SingleVideoItemView.this;
                                                qQCirVideoView2.ref(qQCirVideoView2, new Function1<aa<QQCirVideoView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createVideoView$1$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<QQCirVideoView> aaVar) {
                                                        SingleVideoItemView.this.videoRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SingleVideoItemView singleVideoItemView8 = SingleVideoItemView.this;
                                                final float f28 = f27;
                                                qQCirVideoView2.attr(new Function1<QQCirVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createVideoView$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QQCirVideoAttr qQCirVideoAttr) {
                                                        String str;
                                                        String str2;
                                                        QQCirVideoAttr qQCirVideoAttr2 = qQCirVideoAttr;
                                                        qQCirVideoAttr2.m140flex(1.0f);
                                                        qQCirVideoAttr2.allCenter();
                                                        qQCirVideoAttr2.overflow(true);
                                                        qQCirVideoAttr2.feedPbToken = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().feedPbToken;
                                                        StVideo stVideo = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.video;
                                                        qQCirVideoAttr2.video = new Video(stVideo != null ? stVideo.fileSize : 0, stVideo != null ? stVideo.width : 0, stVideo != null ? stVideo.height : 0, stVideo != null ? stVideo.duration : 0);
                                                        StImage stImage = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.cover;
                                                        String str3 = "";
                                                        if (stImage == null || (str = stImage.picUrl) == null) {
                                                            str = "";
                                                        }
                                                        if (stImage != null && (str2 = stImage.layerPicUrl) != null) {
                                                            str3 = str2;
                                                        }
                                                        qQCirVideoAttr2.cover = new Cover(str, str3);
                                                        FlexNode flexNode2 = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getFlexNode();
                                                        Intrinsics.checkNotNull(flexNode2);
                                                        qQCirVideoAttr2.autoFillMaxSize = new com.tencent.kuikly.core.base.w(flexNode2.U(), f28);
                                                        FlexNode flexNode3 = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getFlexNode();
                                                        Intrinsics.checkNotNull(flexNode3);
                                                        qQCirVideoAttr2.autoFillMinSize = new com.tencent.kuikly.core.base.w(flexNode3.U(), 0.0f);
                                                        qQCirVideoAttr2.setPlayControl(SingleVideoItemView.access$getPlayControl(SingleVideoItemView.this));
                                                        qQCirVideoAttr2.title = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.content;
                                                        SingleVideoItemAttr access$getAttr = SingleVideoItemView.access$getAttr(SingleVideoItemView.this);
                                                        qQCirVideoAttr2.setMuted(((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, SingleVideoItemAttr.$$delegatedProperties[0])).booleanValue());
                                                        qQCirVideoAttr2.index = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).index;
                                                        qQCirVideoAttr2.preloadDownloadEnable = !qQCirVideoAttr2.getPager().getPageData().getIsIOS();
                                                        qQCirVideoAttr2.loop = false;
                                                        qQCirVideoAttr2.exactSize = true;
                                                        qQCirVideoAttr2.extDtReportParams = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).reportParams;
                                                        qQCirVideoAttr2.adaptHeight = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SingleVideoItemView singleVideoItemView9 = SingleVideoItemView.this;
                                                qQCirVideoView2.event(new Function1<QQCirVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$createVideoView$1$1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QQCirVideoEvent qQCirVideoEvent) {
                                                        final QQCirVideoEvent qQCirVideoEvent2 = qQCirVideoEvent;
                                                        final SingleVideoItemView singleVideoItemView10 = SingleVideoItemView.this;
                                                        qQCirVideoEvent2.playStateDidChangedHandler = new Function1<QVideoPlayState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.createVideoView.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QVideoPlayState qVideoPlayState) {
                                                                QVideoPlayState qVideoPlayState2 = qVideoPlayState;
                                                                QVideoPlayState qVideoPlayState3 = QVideoPlayState.EORROR;
                                                                if (qVideoPlayState2 == qVideoPlayState3 || qVideoPlayState2 == QVideoPlayState.END) {
                                                                    if (qVideoPlayState2 == qVideoPlayState3) {
                                                                        IPagerIdKtxKt.getBridgeModule(QQCirVideoEvent.this).toast("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                                                    }
                                                                    Function0<Unit> function02 = SingleVideoItemView.access$getEvent(singleVideoItemView10).onVideoEnd;
                                                                    if (function02 != null) {
                                                                        function02.invoke();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleVideoItemView singleVideoItemView6 = singleVideoItemView3;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(SingleVideoItemView.access$getPlayControl(SingleVideoItemView.this) == QVideoPlayControl.PLAY);
                                    }
                                };
                                final SingleVideoItemView singleVideoItemView7 = singleVideoItemView3;
                                ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final SingleVideoItemView singleVideoItemView8 = SingleVideoItemView.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 6, null);
                                                        tVar2.size(32.0f, 40.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final u uVar2 = uVar;
                                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchDetailViewModel qSearchDetailViewModel;
                                                                com.tencent.kuikly.core.pager.b pager = u.this.getPager();
                                                                QSearchDetailPage qSearchDetailPage = pager instanceof QSearchDetailPage ? (QSearchDetailPage) pager : null;
                                                                if (qSearchDetailPage != null && (qSearchDetailViewModel = qSearchDetailPage.viewModel) != null) {
                                                                    qSearchDetailViewModel.setMuted(!qSearchDetailViewModel.getMuted());
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SingleVideoItemView singleVideoItemView9 = SingleVideoItemView.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final SingleVideoItemView singleVideoItemView10 = SingleVideoItemView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.6.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(16.0f, 16.0f);
                                                                SingleVideoItemAttr access$getAttr = SingleVideoItemView.access$getAttr(SingleVideoItemView.this);
                                                                if (((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, SingleVideoItemAttr.$$delegatedProperties[0])).booleanValue()) {
                                                                    b.a.b(afVar2, QUISkinImage.INSTANCE.muteIcon(), false, 2, null);
                                                                } else {
                                                                    b.a.b(afVar2, QUISkinImage.INSTANCE.unmuteIcon(), false, 2, null);
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
                                ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.7.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.7.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.absolutePositionAllZero();
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.7.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.2.7.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(48.0f, 48.0f);
                                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQCAMAAADQmBKKAAAAb1BMVEUAAAAAAAD+/v6Xl5f////////FxcVpaWn39/fx8fHu7u7////////9/f3Hx8f////////////////////c3NzT09P5+fnj4+P///+0tLTo6Oj////////////////////6+vr////////FxcX////I0MzEAAAAJHRSTlMZAOE2IL9TJ8apmu8Q8VJAkIBgz29gtH6fRIxfUDCgcNNvT1QLAD/CAAAFoElEQVR42szXCZKbMBCF4baWASPM6n2bpfr+Z8zElUQIIYP1YCr/AWa+6m6wTSug/NbUx30rBD8SQutj3ZT5CigWlDeVNhzI6OqqVlPDQfm1Ejxae7xOGBUOyj81T05fRgaFgvKr1Uw2rQLhIFUbjkgcA2MCQaXm6I4lDvI5ULrEQD4HTqvZQGrPs3RU84DsKcPVM4BKwTMmFAjKK37WJl0ftoWUCf1OnordOUs3I0NCQKrlYGm2kzSY3GXpyJAiQZ8mNJmsSOhpyW4d2rV5jwVVQQ1NqgiZqghQcF3pIaHpbYd316rXQUoMcrzhjI8pcEgvgm5miHOiiOQQydxeA10MPh2bTAcu8fIK6MJeoiCgrWCvYRFN9GQJQSXZRBEFPN544KTwRdNAt4njwYdkblNAyvTP70AzdfBEygeNvn9E+FnH1ybUKKhltw9JtKCoHQNV7LZPaNaSPbtVz0Gf7Lam2Vuz2/szkDIRHlBk1BOQiPDAojYPgure/dBCpcEzckGKnURCC5V8sFMZAAnXI2mxZO9f+SB/YRtJC3bahH6KUGhhB1q0g/ekeaA7d8to4TL3+fFBKuKgkRLh3rUH0txN0uIV3E33QSV3O1NE2NLKHkhjC8OXpi3IH9CWfqRiaEQ08Iil9EOlvRFZkMIvGh+R6oDu+Gc8PqK6AxL4gPARmfwfqAEGNOOIvh4g75k/ERA0Iv0XpIBHbNYR5X9ADfAOQjv0v+9Tb2OCfrZk4+zsAcqjT/okZ/5Eyx+gK3cqaHqSeS1nPeuvB+geu7E3ZhbwzXV3Vj1AbezG3mb5MZC53/bJfeh3r4PQvRXuEZF7QkkMiMUZec64U/MNqiLfihYEnlLqHBE5b6EsBmT3hh+R/gaZmBOyIPyL+I5tZkV53AlZELw36Vw1lWzbEARiTiX6JrpRw7YUANlTgq66oZptGQAC9rZmW0135ywBkCVJ4CvIkTTbdgAI2NuWbXsHVKAg++qO/TstCbadABBwSpJtwgFJAATszQVxJ0JAfueYj1ccNMPeFgfZsv8N9KubM8FpGAaiaGxnX5u1aQRtgdz/jEioAo2mbpbvxilzAPRkm3SWP/+6M6A4wIACAAgY8xOG5/3by3ZX36FsmH/cJwJUm/jpQBIj+nc8p2ONBhxI5qtzWI+kH0cACBirDyT9KGndigPFAVJ2lKZT2DBHU9h3k0l+dkST/IKWQQoDigO8DDJYKIbKQKForpSWuZFSGmw28A8z3mwgPdgsWAcUKkPtmE/h0J5nvhQI11+1dADj0EFHvBQI1ztFVLzjUIVOthAIl4ORdKOH28IhrJbzeVs4XT2vbxrDUpmUjxaywNk2JB8tiAttDG8aDdE13oDSvYyn3LsDvNzZME53B3jizdoRReTGfoHSxNIQWHFZk0O0TID0DD+gnggJrLwipRUSCM++1KKnYhQbR9RQMcq+5TqiWNpnwmN4KGgS3taXph5LvkRhVxTnMiDR2ZQN9veElYk9YeXozpCePlUloyhP+RriXFFQ7Ovz5MtSd2EUSBw2Enh37MI0QGltQwIvX2lJQFx2tkaxv0WTp6/iXEca9YplJYNEJ76sZHedK5u1zsUXOPe18EZ0jQav7YuvBFZCA8SJWAz40qSGhwHNJJINejycRw/EibKRRbf63vxwZJFUwGoyJutSnXY1GV/ejk7Y6fDvD77e3ix5yu30ejtuACAjf+bhxBlkAMDjkow6pnbKIoHRoBYJ/CFxE4lAbyJBaeh1Qb4f5YTNRjy0/k1WHSjlN8eIsPA4pAIBooeEhyxMWLUYw0lKQ2Y2ZzM8HWRmQ5FM2P0U/9kQ6QfpDOLgQPwtyXVPGTbV0ke13HaM2LPBQDzcJUzexywa3LruXE/DyANgXbc83LfH5n7VJAwOxCMtqrL3vD/7w7rry+o9FUB8A8dsJZtsE+dkAAAAAElFTkSuQmCC", false, 2, null);
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
                                return Unit.INSTANCE;
                            }
                        });
                        final SingleVideoItemView singleVideoItemView4 = singleVideoItemView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.margin(8.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleVideoItemView singleVideoItemView5 = SingleVideoItemView.this;
                                vVar4.addChild(new MultiLineHighLightTextView(), new Function1<MultiLineHighLightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(MultiLineHighLightTextView multiLineHighLightTextView) {
                                        final SingleVideoItemView singleVideoItemView6 = SingleVideoItemView.this;
                                        multiLineHighLightTextView.attr(new Function1<MultiLineHighLightTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(MultiLineHighLightTextAttr multiLineHighLightTextAttr) {
                                                MultiLineHighLightTextAttr multiLineHighLightTextAttr2 = multiLineHighLightTextAttr;
                                                multiLineHighLightTextAttr2.mo141height((FontModuleExtKt.qqFontScaleAddSize(14.0f) * 2) + 40.0f);
                                                multiLineHighLightTextAttr2.text = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.content;
                                                multiLineHighLightTextAttr2.highlightText = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).highlightWord;
                                                multiLineHighLightTextAttr2.lines = 2;
                                                multiLineHighLightTextAttr2.fontSize = 14.0f;
                                                multiLineHighLightTextAttr2.maxLength = 30;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleVideoItemView singleVideoItemView6 = SingleVideoItemView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.marginTop(10.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SingleVideoItemView singleVideoItemView7 = SingleVideoItemView.this;
                                        vVar6.addChild(new ECCirAvatarView(), new Function1<ECCirAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECCirAvatarView eCCirAvatarView) {
                                                ECCirAvatarView eCCirAvatarView2 = eCCirAvatarView;
                                                final SingleVideoItemView singleVideoItemView8 = SingleVideoItemView.this;
                                                eCCirAvatarView2.attr(new Function1<ECCirAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECCirAvatarAttr eCCirAvatarAttr) {
                                                        ECCirAvatarAttr eCCirAvatarAttr2 = eCCirAvatarAttr;
                                                        eCCirAvatarAttr2.size(20.0f, 20.0f);
                                                        eCCirAvatarAttr2.with("feedPB", SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().feedPbToken);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final SingleVideoItemView singleVideoItemView9 = SingleVideoItemView.this;
                                                eCCirAvatarView2.event(new Function1<ECCirAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECCirAvatarEvent eCCirAvatarEvent) {
                                                        final SingleVideoItemView singleVideoItemView10 = SingleVideoItemView.this;
                                                        eCCirAvatarEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Utils.INSTANCE.currentBridgeModule().qCircleOpenPersonalDetailPage(SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().feedPbToken);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SingleVideoItemView singleVideoItemView8 = SingleVideoItemView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final SingleVideoItemView singleVideoItemView9 = SingleVideoItemView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m140flex(1.0f);
                                                        ceVar2.marginLeft(5.0f);
                                                        ceVar2.marginRight(5.0f);
                                                        StUser stUser = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.poster;
                                                        if (stUser == null || (str = stUser.nick) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String sb5;
                                                        af afVar2 = afVar;
                                                        afVar2.size(14.0f, 14.0f);
                                                        StringBuilder sb6 = new StringBuilder();
                                                        sb6.append("qui_image://");
                                                        sb6.append("play");
                                                        String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb6, "?color=", "text_secondary");
                                                        if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                            StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                            m16.append(SkinColor.colorUniqueID);
                                                            sb5 = m16.toString();
                                                        } else {
                                                            StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                            m17.append(SkinColor.colorUniqueID);
                                                            sb5 = m17.toString();
                                                        }
                                                        b.a.b(afVar2, sb5, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final SingleVideoItemView singleVideoItemView9 = SingleVideoItemView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final SingleVideoItemView singleVideoItemView10 = SingleVideoItemView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView.body.1.3.3.3.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(4.0f);
                                                        StVisitor stVisitor = SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getStFeedEx().stFeed.visitorInfo;
                                                        ceVar2.text(QSearchUtilKt.formatBigNum(stVisitor != null ? stVisitor.viewCount : 0));
                                                        ce.fontSize$default(ceVar2, 11.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new SingleVideoItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SingleVideoItemEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(SingleVideoItemView.access$getAttr(SingleVideoItemView.this).getPlayIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.SingleVideoItemView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                SingleVideoItemView.access$dispatchFocusState(SingleVideoItemView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setPlayControl(QVideoPlayControl qVideoPlayControl) {
        this.playControl$delegate.setValue(this, $$delegatedProperties[0], qVideoPlayControl);
    }
}
