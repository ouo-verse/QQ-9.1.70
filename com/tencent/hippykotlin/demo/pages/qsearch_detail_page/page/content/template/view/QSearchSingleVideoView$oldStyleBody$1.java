package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import com.tencent.hippykotlin.demo.pages.base.Cover;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoAttr;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoEvent;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoView;
import com.tencent.hippykotlin.demo.pages.base.QQCirVideoViewKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayState;
import com.tencent.hippykotlin.demo.pages.base.Video;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StImage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StVideo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleVideoView$oldStyleBody$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchSingleVideoView $ctx;
    public final /* synthetic */ float $mediaHeight;
    public final /* synthetic */ float $mediaWidth;
    public final /* synthetic */ QSearchTemplateReportInfo $reportInfo;
    public final /* synthetic */ e $reportParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchSingleVideoView$oldStyleBody$1(QSearchSingleVideoView qSearchSingleVideoView, float f16, QSearchTemplateReportInfo qSearchTemplateReportInfo, e eVar, float f17) {
        super(1);
        this.$ctx = qSearchSingleVideoView;
        this.$mediaHeight = f16;
        this.$reportInfo = qSearchTemplateReportInfo;
        this.$reportParams = eVar;
        this.$mediaWidth = f17;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final QSearchSingleVideoView qSearchSingleVideoView = this.$ctx;
        final float f16 = this.$mediaHeight;
        final QSearchTemplateReportInfo qSearchTemplateReportInfo = this.$reportInfo;
        final e eVar = this.$reportParams;
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(m mVar) {
                m mVar2 = mVar;
                mVar2.mo113backgroundColor(h.INSTANCE.b());
                mVar2.borderRadius(QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).borderRadius);
                mVar2.mo141height(f16);
                QSearchTemplateReportInfo qSearchTemplateReportInfo2 = qSearchTemplateReportInfo;
                if (qSearchTemplateReportInfo2 != null) {
                    EcommerceExtKt.vr$default(mVar2, null, qSearchTemplateReportInfo2.eid, eVar, null, String.valueOf(qSearchTemplateReportInfo2.hashCode()), true, 9);
                }
                return Unit.INSTANCE;
            }
        });
        final QSearchSingleVideoView qSearchSingleVideoView2 = this.$ctx;
        final float f17 = this.$mediaWidth;
        final float f18 = this.$mediaHeight;
        final e eVar2 = this.$reportParams;
        QQCirVideoViewKt.QQCirVideo(viewContainer2, new Function1<QQCirVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QQCirVideoView qQCirVideoView) {
                QQCirVideoView qQCirVideoView2 = qQCirVideoView;
                final QSearchSingleVideoView qSearchSingleVideoView3 = QSearchSingleVideoView.this;
                qQCirVideoView2.ref(qQCirVideoView2, new Function1<aa<QQCirVideoView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<QQCirVideoView> aaVar) {
                        QSearchSingleVideoView.this.videoRef = aaVar;
                        return Unit.INSTANCE;
                    }
                });
                final QSearchSingleVideoView qSearchSingleVideoView4 = QSearchSingleVideoView.this;
                final float f19 = f17;
                final float f26 = f18;
                final e eVar3 = eVar2;
                qQCirVideoView2.attr(new Function1<QQCirVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.2.2
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
                        StVideo stVideo = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getStFeedEx().stFeed.video;
                        qQCirVideoAttr2.playUrl = stVideo != null ? stVideo.playUrl : null;
                        StVideo stVideo2 = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getStFeedEx().stFeed.video;
                        qQCirVideoAttr2.video = new Video(stVideo2 != null ? stVideo2.fileSize : 0, stVideo2 != null ? stVideo2.width : 0, stVideo2 != null ? stVideo2.height : 0, stVideo2 != null ? stVideo2.duration : 0);
                        StImage stImage = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getStFeedEx().stFeed.cover;
                        String str3 = "";
                        if (stImage == null || (str = stImage.picUrl) == null) {
                            str = "";
                        }
                        if (stImage != null && (str2 = stImage.layerPicUrl) != null) {
                            str3 = str2;
                        }
                        qQCirVideoAttr2.cover = new Cover(str, str3);
                        qQCirVideoAttr2.autoFillMaxSize = new w(f19, f26);
                        qQCirVideoAttr2.autoFillMinSize = new w(f19, 0.0f);
                        qQCirVideoAttr2.setPlayControl(QSearchSingleVideoView.access$getPlayControl(QSearchSingleVideoView.this));
                        qQCirVideoAttr2.title = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getStFeedEx().stFeed.content;
                        qQCirVideoAttr2.setMuted(QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getMuted());
                        qQCirVideoAttr2.index = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).index;
                        qQCirVideoAttr2.preloadDownloadEnable = !qQCirVideoAttr2.getPager().getPageData().getIsIOS();
                        qQCirVideoAttr2.loop = true;
                        qQCirVideoAttr2.exactSize = true;
                        qQCirVideoAttr2.extDtReportParams = eVar3;
                        qQCirVideoAttr2.disableAppendHostAfterIP = true;
                        qQCirVideoAttr2.adaptHeight = true;
                        return Unit.INSTANCE;
                    }
                });
                qQCirVideoView2.event(new Function1<QQCirVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.2.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QQCirVideoEvent qQCirVideoEvent) {
                        final QQCirVideoEvent qQCirVideoEvent2 = qQCirVideoEvent;
                        qQCirVideoEvent2.playStateDidChangedHandler = new Function1<QVideoPlayState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QVideoPlayState qVideoPlayState) {
                                QVideoPlayState qVideoPlayState2 = qVideoPlayState;
                                QVideoPlayState qVideoPlayState3 = QVideoPlayState.EORROR;
                                if ((qVideoPlayState2 == qVideoPlayState3 || qVideoPlayState2 == QVideoPlayState.END) && qVideoPlayState2 == qVideoPlayState3) {
                                    IPagerIdKtxKt.getBridgeModule(QQCirVideoEvent.this).toast("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
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
        final QSearchSingleVideoView qSearchSingleVideoView3 = this.$ctx;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QSearchSingleVideoView.access$getPlayControl(QSearchSingleVideoView.this) == QVideoPlayControl.PLAY);
            }
        };
        final QSearchSingleVideoView qSearchSingleVideoView4 = this.$ctx;
        ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final QSearchSingleVideoView qSearchSingleVideoView5 = QSearchSingleVideoView.this;
                com.tencent.kuikly.core.views.w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 6, null);
                                tVar2.size(32.0f, 40.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QSearchDetailViewModel qSearchDetailViewModel;
                                        b pager = u.this.getPager();
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
                        final QSearchSingleVideoView qSearchSingleVideoView6 = QSearchSingleVideoView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final QSearchSingleVideoView qSearchSingleVideoView7 = QSearchSingleVideoView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.4.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(16.0f, 16.0f);
                                        if (QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getMuted()) {
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
        ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.5
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                com.tencent.kuikly.core.views.w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.5.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.5.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.oldStyleBody.1.5.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(48.0f, 48.0f);
                                        b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
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
        final QSearchSingleVideoView qSearchSingleVideoView5 = this.$ctx;
        viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Event event) {
                Event event2 = event;
                QSearchPicture qSearchPicture = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getMediaInfo().pictureInfo;
                if (qSearchPicture != null && qSearchPicture.jumpLink != null) {
                    final QSearchSingleVideoView qSearchSingleVideoView6 = QSearchSingleVideoView.this;
                    event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$oldStyleBody$1$6$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            Function0<Unit> function02 = QSearchSingleVideoView.access$getEvent(QSearchSingleVideoView.this).videoClick;
                            if (function02 != null) {
                                function02.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
