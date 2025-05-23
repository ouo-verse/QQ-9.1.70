package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Cover;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoAttr;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoEvent;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoView;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoViewKt;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayState;
import com.tencent.hippykotlin.demo.pages.base.Video;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage;
import com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPVideoView extends ComposeView<GCPVideoViewAttr, GCPVideoViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPVideoView.class, "showPlayIcon", "getShowPlayIcon()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPVideoView.class, UIJsPlugin.EVENT_SHOW_LOADING, "getShowLoading()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPVideoView.class, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "getPlayState()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPVideoView.class, "remainPlayTime", "getRemainPlayTime()Ljava/lang/String;", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty playState$delegate;
    public final ReadWriteProperty remainPlayTime$delegate;
    public int timeoutFlag;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public GCPVideoView() {
        c.a(Boolean.TRUE);
        c.a(Boolean.FALSE);
        this.playState$delegate = c.a(QVideoPlayState.NONE);
        this.remainPlayTime$delegate = c.a("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPVideoViewAttr access$getAttr(GCPVideoView gCPVideoView) {
        return (GCPVideoViewAttr) gCPVideoView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPVideoViewEvent access$getEvent(GCPVideoView gCPVideoView) {
        return (GCPVideoViewEvent) gCPVideoView.getEvent();
    }

    public static final boolean access$shouldShowLoading(GCPVideoView gCPVideoView) {
        return gCPVideoView.getPlayState() == QVideoPlayState.PREPARE || gCPVideoView.getPlayState() == QVideoPlayState.BUFFERING;
    }

    public static final boolean access$shouldShowPlayIcon(GCPVideoView gCPVideoView) {
        return gCPVideoView.getPlayState() == QVideoPlayState.NONE || gCPVideoView.getPlayState() == QVideoPlayState.EORROR || gCPVideoView.getPlayState() == QVideoPlayState.PAUSEING;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsFlexStart();
                        return Unit.INSTANCE;
                    }
                });
                final GCPVideoView gCPVideoView = GCPVideoView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.borderRadius(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPVideoView gCPVideoView2 = GCPVideoView.this;
                        QQCirVideoViewKt.QQCirVideo(vVar2, new Function1<QQCirVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQCirVideoView qQCirVideoView) {
                                QQCirVideoView qQCirVideoView2 = qQCirVideoView;
                                final GCPVideoView gCPVideoView3 = GCPVideoView.this;
                                qQCirVideoView2.attr(new Function1<QQCirVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQCirVideoAttr qQCirVideoAttr) {
                                        QQCirVideoAttr qQCirVideoAttr2 = qQCirVideoAttr;
                                        qQCirVideoAttr2.mo113backgroundColor(h.INSTANCE.b());
                                        qQCirVideoAttr2.feedPbToken = GCPVideoView.access$getAttr(GCPVideoView.this).getFeed().feedPbToken;
                                        Video video = GCPVideoView.access$getAttr(GCPVideoView.this).getFeed().video;
                                        if (video == null) {
                                            video = new Video(0, 0, 8);
                                        }
                                        qQCirVideoAttr2.video = video;
                                        Cover cover = GCPVideoView.access$getAttr(GCPVideoView.this).getFeed().cover;
                                        if (cover == null) {
                                            cover = new Cover("", "");
                                        }
                                        qQCirVideoAttr2.cover = cover;
                                        float m3 = qQCirVideoAttr2.getPagerData().m() - 32.0f;
                                        GCPVideoView.Companion companion = GCPVideoView.Companion;
                                        qQCirVideoAttr2.getPagerId();
                                        companion.getClass();
                                        qQCirVideoAttr2.autoFillMaxSize = new com.tencent.kuikly.core.base.w(m3, Math.min(440.8889f, qQCirVideoAttr2.getPagerData().l() - 250.0f));
                                        qQCirVideoAttr2.autoFillMinSize = new com.tencent.kuikly.core.base.w(248.0f, m3 * 0.5625f);
                                        GCPVideoViewAttr access$getAttr = GCPVideoView.access$getAttr(GCPVideoView.this);
                                        qQCirVideoAttr2.setPlayControl((QVideoPlayControl) access$getAttr.playControl$delegate.getValue(access$getAttr, GCPVideoViewAttr.$$delegatedProperties[0]));
                                        qQCirVideoAttr2.title = GCPVideoView.access$getAttr(GCPVideoView.this).getFeed().content;
                                        b pager = qQCirVideoAttr2.getPager();
                                        Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage");
                                        GameContentPage gameContentPage = (GameContentPage) pager;
                                        qQCirVideoAttr2.setMuted(((Boolean) gameContentPage.isUserSetupDefaultMuted$delegate.getValue(gameContentPage, GameContentPage.$$delegatedProperties[3])).booleanValue());
                                        qQCirVideoAttr2.index = GCPVideoView.access$getAttr(GCPVideoView.this).index;
                                        qQCirVideoAttr2.preloadDownloadEnable = !qQCirVideoAttr2.getPager().getPageData().getIsIOS();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPVideoView gCPVideoView4 = GCPVideoView.this;
                                qQCirVideoView2.event(new Function1<QQCirVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQCirVideoEvent qQCirVideoEvent) {
                                        final QQCirVideoEvent qQCirVideoEvent2 = qQCirVideoEvent;
                                        final GCPVideoView gCPVideoView5 = GCPVideoView.this;
                                        qQCirVideoEvent2.onClickVideoHandlerFn = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Long l3) {
                                                long longValue = l3.longValue();
                                                Function1<? super Long, Unit> function1 = GCPVideoView.access$getEvent(GCPVideoView.this).onClickVideoHandlerFn;
                                                if (function1 != null) {
                                                    function1.invoke(Long.valueOf(longValue));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GCPVideoView gCPVideoView6 = GCPVideoView.this;
                                        qQCirVideoEvent2.playStateDidChangedHandler = new Function1<QVideoPlayState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QVideoPlayState qVideoPlayState) {
                                                final QVideoPlayState qVideoPlayState2 = qVideoPlayState;
                                                if (qVideoPlayState2 == QVideoPlayState.PREPARE) {
                                                    final GCPVideoView gCPVideoView7 = GCPVideoView.this;
                                                    final int i3 = gCPVideoView7.timeoutFlag + 1;
                                                    gCPVideoView7.timeoutFlag = i3;
                                                    QQCirVideoEvent qQCirVideoEvent3 = qQCirVideoEvent2;
                                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            int i16 = i3;
                                                            GCPVideoView gCPVideoView8 = gCPVideoView7;
                                                            if (i16 == gCPVideoView8.timeoutFlag) {
                                                                gCPVideoView8.playState$delegate.setValue(gCPVideoView8, GCPVideoView.$$delegatedProperties[2], qVideoPlayState2);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(qQCirVideoEvent3.getPagerId(), 500, function0);
                                                } else {
                                                    GCPVideoView gCPVideoView8 = GCPVideoView.this;
                                                    gCPVideoView8.timeoutFlag++;
                                                    gCPVideoView8.playState$delegate.setValue(gCPVideoView8, GCPVideoView.$$delegatedProperties[2], qVideoPlayState2);
                                                    if (qVideoPlayState2 == QVideoPlayState.EORROR) {
                                                        IPagerIdKtxKt.getBridgeModule(qQCirVideoEvent2).toast("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GCPVideoView gCPVideoView7 = GCPVideoView.this;
                                        qQCirVideoEvent2.playTimeDidChangedHandler = new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.2.2.3
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Float f16, Float f17) {
                                                GCPVideoView.this.updateRemainPlayTimeStr(f16.floatValue(), f17.floatValue());
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                        tVar2.mo141height(40.0f);
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(h.INSTANCE.j(), 0.0f), new j(new h(0, 0, 0, 0.5f), 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPVideoView gCPVideoView3 = GCPVideoView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GCPVideoView.this.getPlayState() != QVideoPlayState.NONE);
                            }
                        };
                        final GCPVideoView gCPVideoView4 = GCPVideoView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GCPVideoView gCPVideoView5 = GCPVideoView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GCPVideoView gCPVideoView6 = GCPVideoView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.fontWeight500();
                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                GCPVideoView gCPVideoView7 = GCPVideoView.this;
                                                ceVar2.text((String) gCPVideoView7.remainPlayTime$delegate.getValue(gCPVideoView7, GCPVideoView.$$delegatedProperties[3]));
                                                ceVar2.color(h.INSTANCE.m());
                                                Attr.absolutePosition$default(ceVar2, 0.0f, 12.0f, 12.0f, 0.0f, 9, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPVideoView gCPVideoView5 = GCPVideoView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 3, null);
                                        tVar2.size(48.0f, 44.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPVideoView gCPVideoView6 = GCPVideoView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final GCPVideoView gCPVideoView7 = GCPVideoView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ClickParams clickParams2 = clickParams;
                                                if (!GCPVideoView.access$shouldShowLoading(GCPVideoView.this)) {
                                                    if (GCPVideoView.access$shouldShowPlayIcon(GCPVideoView.this)) {
                                                        Function1<Object, Unit> function1 = GCPVideoView.access$getEvent(GCPVideoView.this).onClickPlayVideoIconHandlerFn;
                                                        if (function1 != null) {
                                                            function1.invoke(clickParams2);
                                                        }
                                                    } else {
                                                        Function1<Object, Unit> function12 = GCPVideoView.access$getEvent(GCPVideoView.this).onClickPauseVideoIconHandlerFn;
                                                        if (function12 != null) {
                                                            function12.invoke(clickParams2);
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPVideoView gCPVideoView7 = GCPVideoView.this;
                                ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(GCPVideoView.access$shouldShowLoading(GCPVideoView.this));
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        i.a(conditionView, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(f fVar) {
                                                        fVar.size(20.0f, 20.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPVideoView gCPVideoView8 = GCPVideoView.this;
                                ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final GCPVideoView gCPVideoView9 = GCPVideoView.this;
                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final GCPVideoView gCPVideoView10 = GCPVideoView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoView.body.1.2.6.5.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(24.0f, 24.0f);
                                                        if (GCPVideoView.access$shouldShowPlayIcon(GCPVideoView.this)) {
                                                            b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAYAAABV7bNHAAABNklEQVR4Ae3baXmEMBgA4UpAAhIqYR1UwlbCOgAJ6wAJlYAEJERCJEyvf22O3oVkXgnzkOTjujkmSZIkSRJwAlYg8moDFmA0Dpwpm7oNBYxApC4A5x4DXficraurCVj5gm72p8ryctnxMwIw9hjIZcfPC8DFQHUBuDNQ68uOvzMZqMWxgDKXHf9rAgYDfXnZGWj/N8GUuT9R5rJj3wIwGqhuAQYD7fFq4lgCMBiobDZQWTBQhYG8gr5lMdCXjnoDReDWOShtS8cxUMy/QjLQNT01G2gFTj4Pei/mnwEZaE4vJwOt6bnGQCG9zxgoArNvVuuPTQ1UPrYNVJiCDVSYgg20+o3ip45tv5OO+SnYL+0fevnSft7vsb0DwADE/R7bOwDc7/vY3gFgfPPHYQCuze4zkiRJ0iPn8+pHMFaPUQAAAABJRU5ErkJggg==", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABIAgMAAAAog1vUAAAACVBMVEUAAAD///////9zeKVjAAAAAnRSTlMAgJsrThgAAAAgSURBVDjLYxgpIGvVKgcGBsZVq1aOCo0KjQoNlNAIAQD+yr9BvIhyfAAAAABJRU5ErkJggg==", false, 2, null);
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GCPVideoViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPVideoViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        updateRemainPlayTimeStr(0.0f, ((GCPVideoViewAttr) getAttr()).getFeed().video != null ? r0.duration / 1000.0f : 0.0f);
    }

    public final QVideoPlayState getPlayState() {
        return (QVideoPlayState) this.playState$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void updateRemainPlayTimeStr(float f16, float f17) {
        int i3 = (int) (f17 - f16);
        int i16 = (i3 % 3600) / 60;
        int i17 = i3 % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            this.remainPlayTime$delegate.setValue(this, $$delegatedProperties[3], stayTwoBitNumber(i18) + ':' + stayTwoBitNumber(i16) + ':' + stayTwoBitNumber(i17));
            return;
        }
        this.remainPlayTime$delegate.setValue(this, $$delegatedProperties[3], stayTwoBitNumber(i16) + ':' + stayTwoBitNumber(i17));
    }

    public final String stayTwoBitNumber(int i3) {
        if (i3 < 10) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('0');
            sb5.append(i3);
            return sb5.toString();
        }
        return i3 + "";
    }
}
