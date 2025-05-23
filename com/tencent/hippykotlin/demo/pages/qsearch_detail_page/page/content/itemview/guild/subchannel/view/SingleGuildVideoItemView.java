package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

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
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeed;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildVideoItemModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SingleGuildVideoItemView extends ComposeView<SingleGuildVideoItemAttr, SingleGuildVideoItemEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(SingleGuildVideoItemView.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0)};
    public boolean hasFocus;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchFocusState(SingleGuildVideoItemView singleGuildVideoItemView) {
        if (((SingleGuildVideoItemAttr) singleGuildVideoItemView.getAttr()).getPlayIndex() == ((SingleGuildVideoItemAttr) singleGuildVideoItemView.getAttr()).index) {
            if (singleGuildVideoItemView.hasFocus) {
                return;
            }
            singleGuildVideoItemView.hasFocus = true;
            singleGuildVideoItemView.setPlayControl(QVideoPlayControl.PLAY);
            return;
        }
        if (singleGuildVideoItemView.hasFocus) {
            singleGuildVideoItemView.hasFocus = false;
            if (((SingleGuildVideoItemAttr) singleGuildVideoItemView.getAttr()).getPlayIndex() == -2) {
                singleGuildVideoItemView.setPlayControl(QVideoPlayControl.PAUSE);
            } else {
                singleGuildVideoItemView.setPlayControl(QVideoPlayControl.STOP);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SingleGuildVideoItemAttr access$getAttr(SingleGuildVideoItemView singleGuildVideoItemView) {
        return (SingleGuildVideoItemAttr) singleGuildVideoItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ SingleGuildVideoItemEvent access$getEvent(SingleGuildVideoItemView singleGuildVideoItemView) {
        return (SingleGuildVideoItemEvent) singleGuildVideoItemView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.borderRadius(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                final SingleGuildVideoItemView singleGuildVideoItemView = SingleGuildVideoItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(170.0f);
                                tVar2.mo113backgroundColor(h.INSTANCE.b());
                                tVar2.overflow(true);
                                return Unit.INSTANCE;
                            }
                        });
                        final SingleGuildVideoItemView singleGuildVideoItemView2 = SingleGuildVideoItemView.this;
                        KProperty<Object>[] kPropertyArr = SingleGuildVideoItemView.$$delegatedProperties;
                        singleGuildVideoItemView2.getClass();
                        QQCirVideoViewKt.QQCirVideo(vVar2, new Function1<QQCirVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$createVideoView$1$1
                            public final /* synthetic */ float $mediaHeight = 170.0f;

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQCirVideoView qQCirVideoView) {
                                QQCirVideoView qQCirVideoView2 = qQCirVideoView;
                                final SingleGuildVideoItemView singleGuildVideoItemView3 = SingleGuildVideoItemView.this;
                                qQCirVideoView2.ref(qQCirVideoView2, new Function1<aa<QQCirVideoView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$createVideoView$1$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<QQCirVideoView> aaVar) {
                                        SingleGuildVideoItemView.this.getClass();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleGuildVideoItemView singleGuildVideoItemView4 = SingleGuildVideoItemView.this;
                                final float f16 = this.$mediaHeight;
                                qQCirVideoView2.attr(new Function1<QQCirVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$createVideoView$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQCirVideoAttr qQCirVideoAttr) {
                                        QQCirVideoAttr qQCirVideoAttr2 = qQCirVideoAttr;
                                        qQCirVideoAttr2.m140flex(1.0f);
                                        qQCirVideoAttr2.allCenter();
                                        qQCirVideoAttr2.overflow(true);
                                        StFeedEx stFeedEx = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).stFeedEx;
                                        GuildVideoItemModel guildVideoItemModel = null;
                                        if (stFeedEx == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("stFeedEx");
                                            stFeedEx = null;
                                        }
                                        qQCirVideoAttr2.feedPbToken = stFeedEx.feedPbToken;
                                        StFeedEx stFeedEx2 = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).stFeedEx;
                                        if (stFeedEx2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("stFeedEx");
                                            stFeedEx2 = null;
                                        }
                                        StFeed stFeed = stFeedEx2.stFeed;
                                        SingleGuildVideoItemView singleGuildVideoItemView5 = SingleGuildVideoItemView.this;
                                        float f17 = f16;
                                        FlexNode flexNode = SingleGuildVideoItemView.access$getAttr(singleGuildVideoItemView5).getFlexNode();
                                        Intrinsics.checkNotNull(flexNode);
                                        qQCirVideoAttr2.video = new Video((int) flexNode.U(), (int) f17, 9);
                                        GuildVideoItemModel guildVideoItemModel2 = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).data;
                                        if (guildVideoItemModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("data");
                                            guildVideoItemModel2 = null;
                                        }
                                        qQCirVideoAttr2.cover = new Cover(guildVideoItemModel2.getCover(), guildVideoItemModel2.getCover());
                                        FlexNode flexNode2 = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).getFlexNode();
                                        Intrinsics.checkNotNull(flexNode2);
                                        qQCirVideoAttr2.autoFillMaxSize = new com.tencent.kuikly.core.base.w(flexNode2.U(), f16);
                                        FlexNode flexNode3 = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).getFlexNode();
                                        Intrinsics.checkNotNull(flexNode3);
                                        qQCirVideoAttr2.autoFillMinSize = new com.tencent.kuikly.core.base.w(flexNode3.U(), 0.0f);
                                        SingleGuildVideoItemView singleGuildVideoItemView6 = SingleGuildVideoItemView.this;
                                        qQCirVideoAttr2.setPlayControl((QVideoPlayControl) singleGuildVideoItemView6.playControl$delegate.getValue(singleGuildVideoItemView6, SingleGuildVideoItemView.$$delegatedProperties[0]));
                                        GuildVideoItemModel guildVideoItemModel3 = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).data;
                                        if (guildVideoItemModel3 != null) {
                                            guildVideoItemModel = guildVideoItemModel3;
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("data");
                                        }
                                        qQCirVideoAttr2.title = guildVideoItemModel.getTitle();
                                        SingleGuildVideoItemAttr access$getAttr = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this);
                                        qQCirVideoAttr2.setMuted(((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, SingleGuildVideoItemAttr.$$delegatedProperties[0])).booleanValue());
                                        qQCirVideoAttr2.index = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).index;
                                        qQCirVideoAttr2.preloadDownloadEnable = !qQCirVideoAttr2.getPager().getPageData().getIsIOS();
                                        qQCirVideoAttr2.loop = true;
                                        qQCirVideoAttr2.exactSize = true;
                                        qQCirVideoAttr2.extDtReportParams = SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).reportParams;
                                        qQCirVideoAttr2.isLiveVideo = true;
                                        qQCirVideoAttr2.adaptHeight = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final SingleGuildVideoItemView singleGuildVideoItemView5 = SingleGuildVideoItemView.this;
                                qQCirVideoView2.event(new Function1<QQCirVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$createVideoView$1$1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QQCirVideoEvent qQCirVideoEvent) {
                                        final QQCirVideoEvent qQCirVideoEvent2 = qQCirVideoEvent;
                                        final SingleGuildVideoItemView singleGuildVideoItemView6 = SingleGuildVideoItemView.this;
                                        qQCirVideoEvent2.playStateDidChangedHandler = new Function1<QVideoPlayState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView.createVideoView.1.1.3.1
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
                                                    SingleGuildVideoItemView.access$getEvent(singleGuildVideoItemView6).getClass();
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new SingleGuildVideoItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new SingleGuildVideoItemEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(SingleGuildVideoItemView.access$getAttr(SingleGuildVideoItemView.this).getPlayIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                SingleGuildVideoItemView.access$dispatchFocusState(SingleGuildVideoItemView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setPlayControl(QVideoPlayControl qVideoPlayControl) {
        this.playControl$delegate.setValue(this, $$delegatedProperties[0], qVideoPlayControl);
    }
}
