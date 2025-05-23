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
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StImage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StVideo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleVideoView$newStyleBody$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchSingleVideoView $ctx;
    public final /* synthetic */ float $mediaHeight;
    public final /* synthetic */ float $mediaWidth;
    public final /* synthetic */ QSearchTemplateReportInfo $reportInfo;
    public final /* synthetic */ e $reportParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchSingleVideoView$newStyleBody$1(QSearchSingleVideoView qSearchSingleVideoView, float f16, QSearchTemplateReportInfo qSearchTemplateReportInfo, e eVar, float f17) {
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
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.1
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
        QQCirVideoViewKt.QQCirVideo(viewContainer2, new Function1<QQCirVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QQCirVideoView qQCirVideoView) {
                QQCirVideoView qQCirVideoView2 = qQCirVideoView;
                final QSearchSingleVideoView qSearchSingleVideoView3 = QSearchSingleVideoView.this;
                final float f19 = f17;
                final float f26 = f18;
                final e eVar3 = eVar2;
                qQCirVideoView2.attr(new Function1<QQCirVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.2.1
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
                final QSearchSingleVideoView qSearchSingleVideoView4 = QSearchSingleVideoView.this;
                qQCirVideoView2.event(new Function1<QQCirVideoEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QQCirVideoEvent qQCirVideoEvent) {
                        final QQCirVideoEvent qQCirVideoEvent2 = qQCirVideoEvent;
                        qQCirVideoEvent2.playStateDidChangedHandler = new Function1<QVideoPlayState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.2.2.1
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
                        final QSearchSingleVideoView qSearchSingleVideoView5 = QSearchSingleVideoView.this;
                        qQCirVideoEvent2.playTimeDidChangedHandler = new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.2.2.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Float f27, Float f28) {
                                float floatValue = f27.floatValue();
                                f28.floatValue();
                                QSearchSingleVideoView qSearchSingleVideoView6 = QSearchSingleVideoView.this;
                                qSearchSingleVideoView6.playDuration$delegate.setValue(qSearchSingleVideoView6, QSearchSingleVideoView.$$delegatedProperties[1], Float.valueOf(floatValue));
                                return Unit.INSTANCE;
                            }
                        };
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        com.tencent.kuikly.core.views.w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                        tVar2.mo141height(40.0f);
                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.35f), 0.0f), new j(h.INSTANCE.j(), 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        com.tencent.kuikly.core.views.w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.4
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                        tVar2.mo141height(40.0f);
                        tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new j(new h(0, 0, 0, 0.35f), 0.0f), new j(h.INSTANCE.j(), 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final QSearchSingleVideoView qSearchSingleVideoView3 = this.$ctx;
        ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).isShowCollectionIcon);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.6
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                com.tencent.kuikly.core.views.w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.6.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.6.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 10.0f, 12.0f, 0.0f, 0.0f, 12, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.6.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.6.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, QUIToken.INSTANCE.image("copy", h.INSTANCE.m()), false, 2, null);
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
        final QSearchSingleVideoView qSearchSingleVideoView4 = this.$ctx;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = ((Number) r0.playDuration$delegate.getValue(QSearchSingleVideoView.this, QSearchSingleVideoView.$$delegatedProperties[1])).floatValue();
                return Float.valueOf(floatValue);
            }
        };
        final QSearchSingleVideoView qSearchSingleVideoView5 = this.$ctx;
        BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                final QSearchSingleVideoView qSearchSingleVideoView6 = QSearchSingleVideoView.this;
                com.tencent.kuikly.core.views.w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.8.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.8.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 12.0f, 10.0f, 0.0f, 9, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchSingleVideoView qSearchSingleVideoView7 = QSearchSingleVideoView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.8.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QSearchSingleVideoView qSearchSingleVideoView8 = QSearchSingleVideoView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.8.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        float floatValue;
                                        Object valueOf;
                                        float floatValue2;
                                        Object valueOf2;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.fontFamily(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                        floatValue = ((Number) r0.playDuration$delegate.getValue(QSearchSingleVideoView.this, QSearchSingleVideoView.$$delegatedProperties[1])).floatValue();
                                        float f19 = 60;
                                        int i3 = (int) (floatValue / f19);
                                        if (i3 >= 0 && i3 < 10) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append('0');
                                            sb5.append(i3);
                                            valueOf = sb5.toString();
                                        } else {
                                            valueOf = Integer.valueOf(i3);
                                        }
                                        floatValue2 = ((Number) r5.playDuration$delegate.getValue(QSearchSingleVideoView.this, QSearchSingleVideoView.$$delegatedProperties[1])).floatValue();
                                        int i16 = (int) (floatValue2 % f19);
                                        if (i16 >= 0 && i16 < 10) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append('0');
                                            sb6.append(i16);
                                            valueOf2 = sb6.toString();
                                        } else {
                                            valueOf2 = Integer.valueOf(i16);
                                        }
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(valueOf);
                                        sb7.append(':');
                                        sb7.append(valueOf2);
                                        ceVar2.text(sb7.toString());
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
        final QSearchSingleVideoView qSearchSingleVideoView6 = this.$ctx;
        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.9
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(QSearchSingleVideoView.access$getPlayControl(QSearchSingleVideoView.this) == QVideoPlayControl.PLAY);
            }
        };
        final QSearchSingleVideoView qSearchSingleVideoView7 = this.$ctx;
        ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                final QSearchSingleVideoView qSearchSingleVideoView8 = QSearchSingleVideoView.this;
                com.tencent.kuikly.core.views.w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 12.0f, 0.0f, 0.0f, 10.0f, 6, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1.2.1
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
                        final QSearchSingleVideoView qSearchSingleVideoView9 = QSearchSingleVideoView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final QSearchSingleVideoView qSearchSingleVideoView10 = QSearchSingleVideoView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
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
                final QSearchSingleVideoView qSearchSingleVideoView9 = QSearchSingleVideoView.this;
                com.tencent.kuikly.core.views.w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 10.0f, 12.0f, 3, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchSingleVideoView qSearchSingleVideoView10 = QSearchSingleVideoView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, QUIToken.INSTANCE.image("pause_filled", h.INSTANCE.m()), false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchSingleVideoView qSearchSingleVideoView11 = QSearchSingleVideoView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final QSearchSingleVideoView qSearchSingleVideoView12 = QSearchSingleVideoView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.10.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchSingleVideoView qSearchSingleVideoView13 = QSearchSingleVideoView.this;
                                                QVideoPlayControl qVideoPlayControl = QVideoPlayControl.PAUSE;
                                                KProperty<Object>[] kPropertyArr = QSearchSingleVideoView.$$delegatedProperties;
                                                qSearchSingleVideoView13.setPlayControl(qVideoPlayControl);
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
        final QSearchSingleVideoView qSearchSingleVideoView8 = this.$ctx;
        ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final QSearchSingleVideoView qSearchSingleVideoView9 = QSearchSingleVideoView.this;
                com.tencent.kuikly.core.views.w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 10.0f, 12.0f, 3, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchSingleVideoView qSearchSingleVideoView10 = QSearchSingleVideoView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, QUIToken.INSTANCE.image("play_filled", h.INSTANCE.m()), false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchSingleVideoView qSearchSingleVideoView11 = QSearchSingleVideoView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final QSearchSingleVideoView qSearchSingleVideoView12 = QSearchSingleVideoView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView.newStyleBody.1.11.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchSingleVideoView qSearchSingleVideoView13 = QSearchSingleVideoView.this;
                                                QVideoPlayControl qVideoPlayControl = QVideoPlayControl.PLAY;
                                                KProperty<Object>[] kPropertyArr = QSearchSingleVideoView.$$delegatedProperties;
                                                qSearchSingleVideoView13.setPlayControl(qVideoPlayControl);
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
        final QSearchSingleVideoView qSearchSingleVideoView9 = this.$ctx;
        viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1.12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Event event) {
                Event event2 = event;
                QSearchPicture qSearchPicture = QSearchSingleVideoView.access$getAttr(QSearchSingleVideoView.this).getMediaInfo().pictureInfo;
                if (qSearchPicture != null && qSearchPicture.jumpLink != null) {
                    final QSearchSingleVideoView qSearchSingleVideoView10 = QSearchSingleVideoView.this;
                    event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleVideoView$newStyleBody$1$12$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            Function0<Unit> function03 = QSearchSingleVideoView.access$getEvent(QSearchSingleVideoView.this).videoClick;
                            if (function03 != null) {
                                function03.invoke();
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
