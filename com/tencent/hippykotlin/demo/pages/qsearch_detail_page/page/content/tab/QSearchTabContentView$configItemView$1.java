package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchEmptyCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchRecommendGuideItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.QSearchFunctionItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact.QSearchContactTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression.ExpressionTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchRecommendGuideItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchRecommendGuideItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildInteractiveItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildShareScreenItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseImageDoubleAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildInteractiveDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildLiveVideoDoubleAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildLiveVideoDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildMusicDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildPlayGameDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildShareScreenDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildVoiceDoubleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp.QSearchMiniAppTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.QSearchTroopTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchCommonItemTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchHorizontalTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletVideoAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchTitleTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchVerticalTemplateView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import common.config.service.QzoneConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTabContentView$configItemView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ISearchItemModel $_data;
    public final /* synthetic */ int $_index;
    public final /* synthetic */ QSearchTabContentView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchTabContentView$configItemView$1(ISearchItemModel iSearchItemModel, int i3, QSearchTabContentView qSearchTabContentView) {
        super(1);
        this.$_data = iSearchItemModel;
        this.$_index = i3;
        this.$ctx = qSearchTabContentView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final ISearchItemModel iSearchItemModel = this.$_data;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof DoubleVideoItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel2 = this.$_data;
        final int i3 = this.$_index;
        final QSearchTabContentView qSearchTabContentView = this.$ctx;
        ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final ISearchItemModel iSearchItemModel3 = ISearchItemModel.this;
                final int i16 = i3;
                final QSearchTabContentView qSearchTabContentView2 = qSearchTabContentView;
                conditionView.addChild(new QSearchDoubleVideoItemView(), new Function1<QSearchDoubleVideoItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchDoubleVideoItemView qSearchDoubleVideoItemView) {
                        final ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                        final int i17 = i16;
                        final QSearchTabContentView qSearchTabContentView3 = qSearchTabContentView2;
                        qSearchDoubleVideoItemView.attr(new Function1<QSearchDoubleVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchDoubleVideoAttr qSearchDoubleVideoAttr) {
                                QSearchDoubleVideoAttr qSearchDoubleVideoAttr2 = qSearchDoubleVideoAttr;
                                ISearchItemModel iSearchItemModel5 = ISearchItemModel.this;
                                Intrinsics.checkNotNull(iSearchItemModel5, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel");
                                qSearchDoubleVideoAttr2.data = (DoubleVideoItemModel) iSearchItemModel5;
                                qSearchDoubleVideoAttr2.index = i17;
                                int playIndex = QSearchTabContentView.access$getAttr(qSearchTabContentView3).getViewModel().getPlayIndex();
                                ReadWriteProperty readWriteProperty = qSearchDoubleVideoAttr2.playIndex$delegate;
                                KProperty<?>[] kPropertyArr = QSearchDoubleVideoAttr.$$delegatedProperties;
                                readWriteProperty.setValue(qSearchDoubleVideoAttr2, kPropertyArr[0], Integer.valueOf(playIndex));
                                qSearchDoubleVideoAttr2.keyword = QSearchTabContentView.access$getAttr(qSearchTabContentView3).getKeyword();
                                qSearchDoubleVideoAttr2.muted$delegate.setValue(qSearchDoubleVideoAttr2, kPropertyArr[1], Boolean.valueOf(QSearchTabContentView.access$getAttr(qSearchTabContentView3).getMuted()));
                                qSearchDoubleVideoAttr2.traceId = QSearchTabContentView.access$getAttr(qSearchTabContentView3).getViewModel().repo.currentTraceId;
                                qSearchDoubleVideoAttr2.viewModel = QSearchTabContentView.access$getAttr(qSearchTabContentView3).getViewModel();
                                qSearchDoubleVideoAttr2.tabData = QSearchTabContentView.access$getAttr(qSearchTabContentView3).tabData;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel3 = this.$_data;
        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ISearchItemModel iSearchItemModel4 = ISearchItemModel.this;
                return Boolean.valueOf((iSearchItemModel4 instanceof AIPictureCardItemModel) && iSearchItemModel4.isValid());
            }
        };
        final QSearchTabContentView qSearchTabContentView2 = this.$ctx;
        final ISearchItemModel iSearchItemModel4 = this.$_data;
        ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                QSearchTabContentView qSearchTabContentView3 = QSearchTabContentView.this;
                String keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                QSearchTabContentView.this.getPagerData();
                qSearchTabContentView3.aiPictureViewModel = new QSearchAIPictureCardViewModel(keyword);
                final ISearchItemModel iSearchItemModel5 = iSearchItemModel4;
                final QSearchTabContentView qSearchTabContentView4 = QSearchTabContentView.this;
                conditionView.addChild(new QSearchAIPictureCardView(), new Function1<QSearchAIPictureCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchAIPictureCardView qSearchAIPictureCardView) {
                        final ISearchItemModel iSearchItemModel6 = ISearchItemModel.this;
                        final QSearchTabContentView qSearchTabContentView5 = qSearchTabContentView4;
                        qSearchAIPictureCardView.attr(new Function1<QSearchAIPictureCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.4.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchAIPictureCardAttr qSearchAIPictureCardAttr) {
                                QSearchAIPictureCardAttr qSearchAIPictureCardAttr2 = qSearchAIPictureCardAttr;
                                ISearchItemModel iSearchItemModel7 = ISearchItemModel.this;
                                Intrinsics.checkNotNull(iSearchItemModel7, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.AIPictureCardItemModel");
                                qSearchAIPictureCardAttr2.data = (AIPictureCardItemModel) iSearchItemModel7;
                                QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel = qSearchTabContentView5.aiPictureViewModel;
                                QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel2 = null;
                                if (qSearchAIPictureCardViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("aiPictureViewModel");
                                    qSearchAIPictureCardViewModel = null;
                                }
                                qSearchAIPictureCardAttr2.viewModel = qSearchAIPictureCardViewModel;
                                PageStatus pageStatus = QSearchTabContentView.access$getAttr(qSearchTabContentView5).getPageStatus();
                                ReadWriteProperty readWriteProperty = qSearchAIPictureCardAttr2.pageStatus$delegate;
                                KProperty<?>[] kPropertyArr = QSearchAIPictureCardAttr.$$delegatedProperties;
                                readWriteProperty.setValue(qSearchAIPictureCardAttr2, kPropertyArr[1], pageStatus);
                                qSearchAIPictureCardAttr2.listState$delegate.setValue(qSearchAIPictureCardAttr2, kPropertyArr[2], QSearchTabContentView.access$getAttr(qSearchTabContentView5).getViewModel().getListState());
                                qSearchAIPictureCardAttr2.keyword$delegate.setValue(qSearchAIPictureCardAttr2, kPropertyArr[0], QSearchTabContentView.access$getAttr(qSearchTabContentView5).getKeyword());
                                QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel3 = qSearchTabContentView5.aiPictureViewModel;
                                if (qSearchAIPictureCardViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("aiPictureViewModel");
                                } else {
                                    qSearchAIPictureCardViewModel2 = qSearchAIPictureCardViewModel3;
                                }
                                qSearchAIPictureCardAttr2.mo141height(((Number) qSearchAIPictureCardViewModel2.cardHeight$delegate.getValue(qSearchAIPictureCardViewModel2, QSearchAIPictureCardViewModel.$$delegatedProperties[3])).floatValue());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel5 = this.$_data;
        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchGuildDoubleItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel6 = this.$_data;
        final QSearchTabContentView qSearchTabContentView3 = this.$ctx;
        final int i16 = this.$_index;
        ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                ISearchItemModel iSearchItemModel7 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel7, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel");
                final SearchGuildDoubleItemModel searchGuildDoubleItemModel = (SearchGuildDoubleItemModel) iSearchItemModel7;
                final QSearchTabContentView qSearchTabContentView4 = qSearchTabContentView3;
                final int i17 = i16;
                KProperty<Object>[] kPropertyArr = QSearchTabContentView.$$delegatedProperties;
                qSearchTabContentView4.getClass();
                switch (searchGuildDoubleItemModel.type) {
                    case 5:
                        conditionView2.addChild(new GuildLiveVideoDoubleItemView(), new Function1<GuildLiveVideoDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildLiveVideoDoubleItemView.attr(new Function1<GuildLiveVideoDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildLiveVideoDoubleAttr guildLiveVideoDoubleAttr) {
                                        GuildLiveVideoDoubleAttr guildLiveVideoDoubleAttr2 = guildLiveVideoDoubleAttr;
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildLiveVideoDoubleAttr2, searchGuildDoubleItemModel2, i18);
                                        QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                        qSearchTabContentView6.getClass();
                                        guildLiveVideoDoubleAttr2.muted$delegate.setValue(guildLiveVideoDoubleAttr2, GuildLiveVideoDoubleAttr.$$delegatedProperties[0], Boolean.valueOf(qSearchTabContentView6 instanceof QSearchGuildTabContentView ? true : QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getMuted()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 6:
                        conditionView2.addChild(new GuildShareScreenDoubleItemView(), new Function1<GuildShareScreenDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildShareScreenDoubleItemView guildShareScreenDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildShareScreenDoubleItemView.attr(new Function1<GuildLiveVideoDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildLiveVideoDoubleAttr guildLiveVideoDoubleAttr) {
                                        GuildLiveVideoDoubleAttr guildLiveVideoDoubleAttr2 = guildLiveVideoDoubleAttr;
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildLiveVideoDoubleAttr2, searchGuildDoubleItemModel2, i18);
                                        QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                        qSearchTabContentView6.getClass();
                                        guildLiveVideoDoubleAttr2.muted$delegate.setValue(guildLiveVideoDoubleAttr2, GuildLiveVideoDoubleAttr.$$delegatedProperties[0], Boolean.valueOf(qSearchTabContentView6 instanceof QSearchGuildTabContentView ? true : QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getMuted()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 7:
                        conditionView2.addChild(new GuildInteractiveDoubleItemView(), new Function1<GuildInteractiveDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildInteractiveDoubleItemView guildInteractiveDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildInteractiveDoubleItemView.attr(new Function1<GuildBaseImageDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageDoubleAttr guildBaseImageDoubleAttr) {
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildBaseImageDoubleAttr, searchGuildDoubleItemModel2, i18);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 8:
                        conditionView2.addChild(new GuildMusicDoubleItemView(), new Function1<GuildMusicDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMusicDoubleItemView guildMusicDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildMusicDoubleItemView.attr(new Function1<GuildBaseImageDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageDoubleAttr guildBaseImageDoubleAttr) {
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildBaseImageDoubleAttr, searchGuildDoubleItemModel2, i18);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 9:
                        conditionView2.addChild(new GuildVoiceDoubleItemView(), new Function1<GuildVoiceDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildVoiceDoubleItemView guildVoiceDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildVoiceDoubleItemView.attr(new Function1<GuildBaseImageDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageDoubleAttr guildBaseImageDoubleAttr) {
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildBaseImageDoubleAttr, searchGuildDoubleItemModel2, i18);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 10:
                        conditionView2.addChild(new GuildPlayGameDoubleItemView(), new Function1<GuildPlayGameDoubleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildPlayGameDoubleItemView guildPlayGameDoubleItemView) {
                                final QSearchTabContentView qSearchTabContentView5 = QSearchTabContentView.this;
                                final SearchGuildDoubleItemModel searchGuildDoubleItemModel2 = searchGuildDoubleItemModel;
                                final int i18 = i17;
                                guildPlayGameDoubleItemView.attr(new Function1<GuildBaseImageDoubleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildDoubleItem$1$6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageDoubleAttr guildBaseImageDoubleAttr) {
                                        QSearchTabContentView.access$configGuildDoubleItemAttr(QSearchTabContentView.this, guildBaseImageDoubleAttr, searchGuildDoubleItemModel2, i18);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel7 = this.$_data;
        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchGuildBaseItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel8 = this.$_data;
        final QSearchTabContentView qSearchTabContentView4 = this.$ctx;
        final int i17 = this.$_index;
        ConditionViewKt.b(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                ISearchItemModel iSearchItemModel9 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel9, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel");
                final SearchGuildBaseItemModel searchGuildBaseItemModel = (SearchGuildBaseItemModel) iSearchItemModel9;
                final QSearchTabContentView qSearchTabContentView5 = qSearchTabContentView4;
                final int i18 = i17;
                KProperty<Object>[] kPropertyArr = QSearchTabContentView.$$delegatedProperties;
                qSearchTabContentView5.getClass();
                switch (searchGuildBaseItemModel.getType()) {
                    case 5:
                        conditionView2.addChild(new GuildLiveVideoItemView(), new Function1<GuildLiveVideoItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildLiveVideoItemView guildLiveVideoItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildLiveVideoItemView.attr(new Function1<GuildLiveVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildLiveVideoAttr guildLiveVideoAttr) {
                                        GuildLiveVideoAttr guildLiveVideoAttr2 = guildLiveVideoAttr;
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildLiveVideoAttr2, searchGuildBaseItemModel2, i19);
                                        QSearchTabContentView qSearchTabContentView7 = QSearchTabContentView.this;
                                        qSearchTabContentView7.getClass();
                                        guildLiveVideoAttr2.muted$delegate.setValue(guildLiveVideoAttr2, GuildLiveVideoAttr.$$delegatedProperties[0], Boolean.valueOf(qSearchTabContentView7 instanceof QSearchGuildTabContentView ? true : QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getMuted()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 6:
                        conditionView2.addChild(new GuildShareScreenItemView(), new Function1<GuildShareScreenItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildShareScreenItemView guildShareScreenItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildShareScreenItemView.attr(new Function1<GuildLiveVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildLiveVideoAttr guildLiveVideoAttr) {
                                        GuildLiveVideoAttr guildLiveVideoAttr2 = guildLiveVideoAttr;
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildLiveVideoAttr2, searchGuildBaseItemModel2, i19);
                                        QSearchTabContentView qSearchTabContentView7 = QSearchTabContentView.this;
                                        qSearchTabContentView7.getClass();
                                        guildLiveVideoAttr2.muted$delegate.setValue(guildLiveVideoAttr2, GuildLiveVideoAttr.$$delegatedProperties[0], Boolean.valueOf(qSearchTabContentView7 instanceof QSearchGuildTabContentView ? true : QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getMuted()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 7:
                        conditionView2.addChild(new GuildInteractiveItemView(), new Function1<GuildInteractiveItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildInteractiveItemView guildInteractiveItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildInteractiveItemView.attr(new Function1<GuildBaseImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageAttr guildBaseImageAttr) {
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildBaseImageAttr, searchGuildBaseItemModel2, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 8:
                        conditionView2.addChild(new GuildMusicItemView(), new Function1<GuildMusicItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMusicItemView guildMusicItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildMusicItemView.attr(new Function1<GuildBaseImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageAttr guildBaseImageAttr) {
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildBaseImageAttr, searchGuildBaseItemModel2, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 9:
                        conditionView2.addChild(new GuildVoiceItemView(), new Function1<GuildVoiceItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildVoiceItemView guildVoiceItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildVoiceItemView.attr(new Function1<GuildBaseImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageAttr guildBaseImageAttr) {
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildBaseImageAttr, searchGuildBaseItemModel2, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                    case 10:
                        conditionView2.addChild(new GuildPlayGameItemView(), new Function1<GuildPlayGameItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildPlayGameItemView guildPlayGameItemView) {
                                final QSearchTabContentView qSearchTabContentView6 = QSearchTabContentView.this;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                final int i19 = i18;
                                guildPlayGameItemView.attr(new Function1<GuildBaseImageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$createGuildItem$1$6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildBaseImageAttr guildBaseImageAttr) {
                                        QSearchTabContentView.access$configGuildItemAttr(QSearchTabContentView.this, guildBaseImageAttr, searchGuildBaseItemModel2, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel9 = this.$_data;
        Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.9
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchGuildChannelCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel10 = this.$_data;
        final QSearchTabContentView qSearchTabContentView5 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel11 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel11, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelCardItemModel");
                final SearchGuildChannelCardItemModel searchGuildChannelCardItemModel = (SearchGuildChannelCardItemModel) iSearchItemModel11;
                final QSearchTabContentView qSearchTabContentView6 = qSearchTabContentView5;
                conditionView.addChild(new GuildChannelTitleMoreCardItemView(), new Function1<GuildChannelTitleMoreCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.10.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildChannelTitleMoreCardItemView guildChannelTitleMoreCardItemView) {
                        final QSearchTabContentView qSearchTabContentView7 = QSearchTabContentView.this;
                        final SearchGuildChannelCardItemModel searchGuildChannelCardItemModel2 = searchGuildChannelCardItemModel;
                        guildChannelTitleMoreCardItemView.attr(new Function1<GuildChannelTitleMoreCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.10.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildChannelTitleMoreCardItemAttr guildChannelTitleMoreCardItemAttr) {
                                GuildChannelTitleMoreCardItemAttr guildChannelTitleMoreCardItemAttr2 = guildChannelTitleMoreCardItemAttr;
                                guildChannelTitleMoreCardItemAttr2.keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                                SearchGuildChannelCardItemModel searchGuildChannelCardItemModel3 = searchGuildChannelCardItemModel2;
                                UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).tabData;
                                guildChannelTitleMoreCardItemAttr2.data = searchGuildChannelCardItemModel3;
                                guildChannelTitleMoreCardItemAttr2.tabData = unifySearchTabInfo;
                                guildChannelTitleMoreCardItemAttr2.tabName = "\u9891\u9053";
                                guildChannelTitleMoreCardItemAttr2.traceId = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel11 = this.$_data;
        Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.11
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof ExpressionCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel12 = this.$_data;
        final QSearchTabContentView qSearchTabContentView6 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function06, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel13 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel13, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel");
                final ExpressionCardItemModel expressionCardItemModel = (ExpressionCardItemModel) iSearchItemModel13;
                final QSearchTabContentView qSearchTabContentView7 = qSearchTabContentView6;
                conditionView.addChild(new ExpressionTitleMoreCardItemView(), new Function1<ExpressionTitleMoreCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.12.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ExpressionTitleMoreCardItemView expressionTitleMoreCardItemView) {
                        final QSearchTabContentView qSearchTabContentView8 = QSearchTabContentView.this;
                        final ExpressionCardItemModel expressionCardItemModel2 = expressionCardItemModel;
                        expressionTitleMoreCardItemView.attr(new Function1<ExpressionTitleMoreCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.12.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ExpressionTitleMoreCardItemAttr expressionTitleMoreCardItemAttr) {
                                ExpressionTitleMoreCardItemAttr expressionTitleMoreCardItemAttr2 = expressionTitleMoreCardItemAttr;
                                expressionTitleMoreCardItemAttr2.keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                                ExpressionCardItemModel expressionCardItemModel3 = expressionCardItemModel2;
                                UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).tabData;
                                expressionTitleMoreCardItemAttr2.data = expressionCardItemModel3;
                                expressionTitleMoreCardItemAttr2.tabData = unifySearchTabInfo;
                                expressionTitleMoreCardItemAttr2.tabName = "\u8868\u60c5";
                                expressionTitleMoreCardItemAttr2.traceId = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId;
                                expressionTitleMoreCardItemAttr2.pageStatus$delegate.setValue(expressionTitleMoreCardItemAttr2, ExpressionTitleMoreCardItemAttr.$$delegatedProperties[0], QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getPageStatus());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel13 = this.$_data;
        Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.13
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchContactCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel14 = this.$_data;
        final QSearchTabContentView qSearchTabContentView7 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function07, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel15 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel15, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactCardItemModel");
                final SearchContactCardItemModel searchContactCardItemModel = (SearchContactCardItemModel) iSearchItemModel15;
                final QSearchTabContentView qSearchTabContentView8 = qSearchTabContentView7;
                conditionView.addChild(new QSearchContactTitleMoreCardItemView(), new Function1<QSearchContactTitleMoreCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.14.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchContactTitleMoreCardItemView qSearchContactTitleMoreCardItemView) {
                        final QSearchTabContentView qSearchTabContentView9 = QSearchTabContentView.this;
                        final SearchContactCardItemModel searchContactCardItemModel2 = searchContactCardItemModel;
                        qSearchContactTitleMoreCardItemView.attr(new Function1<QSearchContactTitleMoreCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.14.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchContactTitleMoreCardItemAttr qSearchContactTitleMoreCardItemAttr) {
                                QSearchContactTitleMoreCardItemAttr qSearchContactTitleMoreCardItemAttr2 = qSearchContactTitleMoreCardItemAttr;
                                qSearchContactTitleMoreCardItemAttr2.keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                                SearchContactCardItemModel searchContactCardItemModel3 = searchContactCardItemModel2;
                                UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).tabData;
                                qSearchContactTitleMoreCardItemAttr2.data = searchContactCardItemModel3;
                                qSearchContactTitleMoreCardItemAttr2.tabData = unifySearchTabInfo;
                                qSearchContactTitleMoreCardItemAttr2.tabName = "\u7528\u6237";
                                qSearchContactTitleMoreCardItemAttr2.traceId = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel15 = this.$_data;
        Function0<Object> function08 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.15
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchTroopCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel16 = this.$_data;
        final QSearchTabContentView qSearchTabContentView8 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function08, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel17 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel17, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopCardItemModel");
                final SearchTroopCardItemModel searchTroopCardItemModel = (SearchTroopCardItemModel) iSearchItemModel17;
                final QSearchTabContentView qSearchTabContentView9 = qSearchTabContentView8;
                conditionView.addChild(new QSearchTroopTitleMoreCardItemView(), new Function1<QSearchTroopTitleMoreCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.16.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchTroopTitleMoreCardItemView qSearchTroopTitleMoreCardItemView) {
                        final QSearchTabContentView qSearchTabContentView10 = QSearchTabContentView.this;
                        final SearchTroopCardItemModel searchTroopCardItemModel2 = searchTroopCardItemModel;
                        qSearchTroopTitleMoreCardItemView.attr(new Function1<QSearchTroopTitleMoreCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.16.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchTroopTitleMoreCardItemAttr qSearchTroopTitleMoreCardItemAttr) {
                                QSearchTroopTitleMoreCardItemAttr qSearchTroopTitleMoreCardItemAttr2 = qSearchTroopTitleMoreCardItemAttr;
                                qSearchTroopTitleMoreCardItemAttr2.keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                                SearchTroopCardItemModel searchTroopCardItemModel3 = searchTroopCardItemModel2;
                                UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).tabData;
                                qSearchTroopTitleMoreCardItemAttr2.data = searchTroopCardItemModel3;
                                qSearchTroopTitleMoreCardItemAttr2.tabData = unifySearchTabInfo;
                                qSearchTroopTitleMoreCardItemAttr2.tabName = "\u7fa4\u804a";
                                qSearchTroopTitleMoreCardItemAttr2.traceId = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel17 = this.$_data;
        Function0<Object> function09 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.17
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchMiniAppCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel18 = this.$_data;
        final QSearchTabContentView qSearchTabContentView9 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function09, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel19 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel19, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppCardItemModel");
                final SearchMiniAppCardItemModel searchMiniAppCardItemModel = (SearchMiniAppCardItemModel) iSearchItemModel19;
                final QSearchTabContentView qSearchTabContentView10 = qSearchTabContentView9;
                conditionView.addChild(new QSearchMiniAppTitleMoreCardItemView(), new Function1<QSearchMiniAppTitleMoreCardItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.18.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchMiniAppTitleMoreCardItemView qSearchMiniAppTitleMoreCardItemView) {
                        final QSearchTabContentView qSearchTabContentView11 = QSearchTabContentView.this;
                        final SearchMiniAppCardItemModel searchMiniAppCardItemModel2 = searchMiniAppCardItemModel;
                        qSearchMiniAppTitleMoreCardItemView.attr(new Function1<QSearchMiniAppTitleMoreCardItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.18.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchMiniAppTitleMoreCardItemAttr qSearchMiniAppTitleMoreCardItemAttr) {
                                QSearchMiniAppTitleMoreCardItemAttr qSearchMiniAppTitleMoreCardItemAttr2 = qSearchMiniAppTitleMoreCardItemAttr;
                                qSearchMiniAppTitleMoreCardItemAttr2.keyword = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getKeyword();
                                SearchMiniAppCardItemModel searchMiniAppCardItemModel3 = searchMiniAppCardItemModel2;
                                UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).tabData;
                                qSearchMiniAppTitleMoreCardItemAttr2.data = searchMiniAppCardItemModel3;
                                qSearchMiniAppTitleMoreCardItemAttr2.tabData = unifySearchTabInfo;
                                qSearchMiniAppTitleMoreCardItemAttr2.tabName = QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE;
                                qSearchMiniAppTitleMoreCardItemAttr2.traceId = QSearchTabContentView.access$getAttr(QSearchTabContentView.this).getViewModel().repo.currentTraceId;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel19 = this.$_data;
        Function0<Object> function010 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.19
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchEmptyCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel20 = this.$_data;
        final QSearchTabContentView qSearchTabContentView10 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function010, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel21 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel21, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchEmptyCardItemModel");
                final SearchEmptyCardItemModel searchEmptyCardItemModel = (SearchEmptyCardItemModel) iSearchItemModel21;
                final QSearchTabContentView qSearchTabContentView11 = qSearchTabContentView10;
                conditionView.addChild(new QSearchEmptyItemView(), new Function1<QSearchEmptyItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.20.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchEmptyItemView qSearchEmptyItemView) {
                        final SearchEmptyCardItemModel searchEmptyCardItemModel2 = SearchEmptyCardItemModel.this;
                        final QSearchTabContentView qSearchTabContentView12 = qSearchTabContentView11;
                        qSearchEmptyItemView.attr(new Function1<QSearchEmptyItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.20.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchEmptyItemAttr qSearchEmptyItemAttr) {
                                QSearchEmptyItemAttr qSearchEmptyItemAttr2 = qSearchEmptyItemAttr;
                                qSearchEmptyItemAttr2.text$delegate.setValue(qSearchEmptyItemAttr2, QSearchEmptyItemAttr.$$delegatedProperties[0], SearchEmptyCardItemModel.this.text);
                                qSearchEmptyItemAttr2.tabData = QSearchTabContentView.access$getAttr(qSearchTabContentView12).tabData;
                                qSearchEmptyItemAttr2.alignItemsCenter();
                                qSearchEmptyItemAttr2.paddingTop(24.0f);
                                QSearchTabContentView qSearchTabContentView13 = qSearchTabContentView12;
                                EcommerceExtKt.elementVR(qSearchEmptyItemAttr2, "em_search_no_result_card", qSearchTabContentView13.getEmptyOrErrorViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView13).getKeyword(), QSearchTabContentView.access$getAttr(qSearchTabContentView12).getViewModel().repo.currentTraceId, SearchEmptyCardItemModel.this.getReportInfo()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel21 = this.$_data;
        Function0<Object> function011 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.21
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof SearchRecommendGuideItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel22 = this.$_data;
        final QSearchTabContentView qSearchTabContentView11 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function011, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.22
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel23 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel23, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.SearchRecommendGuideItemModel");
                final SearchRecommendGuideItemModel searchRecommendGuideItemModel = (SearchRecommendGuideItemModel) iSearchItemModel23;
                final QSearchTabContentView qSearchTabContentView12 = qSearchTabContentView11;
                conditionView.addChild(new QSearchRecommendGuideItemView(), new Function1<QSearchRecommendGuideItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.22.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QSearchRecommendGuideItemView qSearchRecommendGuideItemView) {
                        final SearchRecommendGuideItemModel searchRecommendGuideItemModel2 = SearchRecommendGuideItemModel.this;
                        final QSearchTabContentView qSearchTabContentView13 = qSearchTabContentView12;
                        qSearchRecommendGuideItemView.attr(new Function1<QSearchRecommendGuideItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.22.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchRecommendGuideItemAttr qSearchRecommendGuideItemAttr) {
                                QSearchRecommendGuideItemAttr qSearchRecommendGuideItemAttr2 = qSearchRecommendGuideItemAttr;
                                qSearchRecommendGuideItemAttr2.text$delegate.setValue(qSearchRecommendGuideItemAttr2, QSearchRecommendGuideItemAttr.$$delegatedProperties[0], SearchRecommendGuideItemModel.this.text);
                                qSearchRecommendGuideItemAttr2.tabData = QSearchTabContentView.access$getAttr(qSearchTabContentView13).tabData;
                                QSearchTabContentView qSearchTabContentView14 = qSearchTabContentView13;
                                EcommerceExtKt.elementVR(qSearchRecommendGuideItemAttr2, "em_bas_parting_line", qSearchTabContentView14.getEmptyOrErrorViewReportParams(QSearchTabContentView.access$getAttr(qSearchTabContentView14).getKeyword(), QSearchTabContentView.access$getAttr(qSearchTabContentView13).getViewModel().repo.currentTraceId, SearchRecommendGuideItemModel.this.getReportInfo()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel23 = this.$_data;
        Function0<Object> function012 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.23
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof QSearchBaseTemplateModel);
            }
        };
        final ISearchItemModel iSearchItemModel24 = this.$_data;
        final int i18 = this.$_index;
        final QSearchTabContentView qSearchTabContentView12 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function012, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.24
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ConditionView conditionView2 = conditionView;
                ISearchItemModel iSearchItemModel25 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel25, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel");
                final QSearchBaseTemplateModel qSearchBaseTemplateModel = (QSearchBaseTemplateModel) iSearchItemModel25;
                final int i19 = i18;
                final String str = QSearchTabContentView.access$getAttr(qSearchTabContentView12).getViewModel().keyword;
                final String str2 = QSearchTabContentView.access$getAttr(qSearchTabContentView12).getViewModel().repo.currentTraceId;
                final QSearchTabContentViewModel viewModel = QSearchTabContentView.access$getAttr(qSearchTabContentView12).getViewModel();
                b pager = conditionView2.getPager();
                Intrinsics.checkNotNull(pager, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage");
                final QSearchDetailViewModel qSearchDetailViewModel = ((QSearchDetailPage) pager).viewModel;
                final UnifySearchTabInfo unifySearchTabInfo = QSearchTabContentView.access$getAttr(qSearchTabContentView12).tabData;
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                        final QSearchBaseTemplateModel qSearchBaseTemplateModel2 = QSearchBaseTemplateModel.this;
                        if (qSearchBaseTemplateModel2 instanceof QSearchGameTemplateModel) {
                            final int i26 = i19;
                            final String str3 = str;
                            final String str4 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel2 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo2 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchGameTemplateView(), new Function1<QSearchGameTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchGameTemplateView qSearchGameTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i27 = i26;
                                    final String str5 = str3;
                                    final String str6 = str4;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel2 = qSearchTabContentViewModel;
                                    final QSearchDetailViewModel qSearchDetailViewModel3 = qSearchDetailViewModel2;
                                    final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo2;
                                    qSearchGameTemplateView.attr(new Function1<QSearchGameTemplateAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchGameTemplateAttr qSearchGameTemplateAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchGameTemplateAttr, QSearchBaseTemplateModel.this, i27, str5, str6, qSearchTabContentViewModel2, qSearchDetailViewModel3, unifySearchTabInfo3);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchVerticalTemplateModel) {
                            final int i27 = i19;
                            final String str5 = str;
                            final String str6 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel2 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel3 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo3 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchVerticalTemplateView(), new Function1<QSearchVerticalTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchVerticalTemplateView qSearchVerticalTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i28 = i27;
                                    final String str7 = str5;
                                    final String str8 = str6;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel3 = qSearchTabContentViewModel2;
                                    final QSearchDetailViewModel qSearchDetailViewModel4 = qSearchDetailViewModel3;
                                    final UnifySearchTabInfo unifySearchTabInfo4 = unifySearchTabInfo3;
                                    qSearchVerticalTemplateView.attr(new Function1<QSearchVerticalTemplateAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchVerticalTemplateAttr qSearchVerticalTemplateAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchVerticalTemplateAttr, QSearchBaseTemplateModel.this, i28, str7, str8, qSearchTabContentViewModel3, qSearchDetailViewModel4, unifySearchTabInfo4);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchHorizontalTemplateModel) {
                            final int i28 = i19;
                            final String str7 = str;
                            final String str8 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel3 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel4 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo4 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchHorizontalTemplateView(), new Function1<QSearchHorizontalTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchHorizontalTemplateView qSearchHorizontalTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i29 = i28;
                                    final String str9 = str7;
                                    final String str10 = str8;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel4 = qSearchTabContentViewModel3;
                                    final QSearchDetailViewModel qSearchDetailViewModel5 = qSearchDetailViewModel4;
                                    final UnifySearchTabInfo unifySearchTabInfo5 = unifySearchTabInfo4;
                                    qSearchHorizontalTemplateView.attr(new Function1<QSearchHorizontalAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchHorizontalAttr qSearchHorizontalAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchHorizontalAttr, QSearchBaseTemplateModel.this, i29, str9, str10, qSearchTabContentViewModel4, qSearchDetailViewModel5, unifySearchTabInfo5);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchTitleTemplateModel) {
                            final int i29 = i19;
                            final String str9 = str;
                            final String str10 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel4 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel5 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo5 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchTitleTemplateView(), new Function1<QSearchTitleTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchTitleTemplateView qSearchTitleTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i36 = i29;
                                    final String str11 = str9;
                                    final String str12 = str10;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel5 = qSearchTabContentViewModel4;
                                    final QSearchDetailViewModel qSearchDetailViewModel6 = qSearchDetailViewModel5;
                                    final UnifySearchTabInfo unifySearchTabInfo6 = unifySearchTabInfo5;
                                    qSearchTitleTemplateView.attr(new Function1<QSearchTitleTemplateAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchTitleTemplateAttr qSearchTitleTemplateAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchTitleTemplateAttr, QSearchBaseTemplateModel.this, i36, str11, str12, qSearchTabContentViewModel5, qSearchDetailViewModel6, unifySearchTabInfo6);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchBannerTemplateModel) {
                            final int i36 = i19;
                            final String str11 = str;
                            final String str12 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel5 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel6 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo6 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchBannerTemplateView(), new Function1<QSearchBannerTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchBannerTemplateView qSearchBannerTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i37 = i36;
                                    final String str13 = str11;
                                    final String str14 = str12;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel6 = qSearchTabContentViewModel5;
                                    final QSearchDetailViewModel qSearchDetailViewModel7 = qSearchDetailViewModel6;
                                    final UnifySearchTabInfo unifySearchTabInfo7 = unifySearchTabInfo6;
                                    qSearchBannerTemplateView.attr(new Function1<QSearchBannerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchBannerAttr qSearchBannerAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchBannerAttr, QSearchBaseTemplateModel.this, i37, str13, str14, qSearchTabContentViewModel6, qSearchDetailViewModel7, unifySearchTabInfo7);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchMultiImageVideoTemplateModel) {
                            final int i37 = i19;
                            final String str13 = str;
                            final String str14 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel6 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel7 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo7 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchMultiImageVideoTemplateView(), new Function1<QSearchMultiImageVideoTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i38 = i37;
                                    final String str15 = str13;
                                    final String str16 = str14;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel7 = qSearchTabContentViewModel6;
                                    final QSearchDetailViewModel qSearchDetailViewModel8 = qSearchDetailViewModel7;
                                    final UnifySearchTabInfo unifySearchTabInfo8 = unifySearchTabInfo7;
                                    qSearchMultiImageVideoTemplateView.attr(new Function1<QSearchMultiImageVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchMultiImageVideoAttr qSearchMultiImageVideoAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchMultiImageVideoAttr, QSearchBaseTemplateModel.this, i38, str15, str16, qSearchTabContentViewModel7, qSearchDetailViewModel8, unifySearchTabInfo8);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchFileTemplateModel) {
                            final int i38 = i19;
                            final String str15 = str;
                            final String str16 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel7 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel8 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo8 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchFileTemplateView(), new Function1<QSearchFileTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchFileTemplateView qSearchFileTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i39 = i38;
                                    final String str17 = str15;
                                    final String str18 = str16;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel8 = qSearchTabContentViewModel7;
                                    final QSearchDetailViewModel qSearchDetailViewModel9 = qSearchDetailViewModel8;
                                    final UnifySearchTabInfo unifySearchTabInfo9 = unifySearchTabInfo8;
                                    qSearchFileTemplateView.attr(new Function1<QSearchFileAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.7.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchFileAttr qSearchFileAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchFileAttr, QSearchBaseTemplateModel.this, i39, str17, str18, qSearchTabContentViewModel8, qSearchDetailViewModel9, unifySearchTabInfo9);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchCommonItemTemplateModel) {
                            final int i39 = i19;
                            final String str17 = str;
                            final String str18 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel8 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel9 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo9 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchCommonItemTemplateView(), new Function1<QSearchCommonItemTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchCommonItemTemplateView qSearchCommonItemTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i46 = i39;
                                    final String str19 = str17;
                                    final String str20 = str18;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel9 = qSearchTabContentViewModel8;
                                    final QSearchDetailViewModel qSearchDetailViewModel10 = qSearchDetailViewModel9;
                                    final UnifySearchTabInfo unifySearchTabInfo10 = unifySearchTabInfo9;
                                    qSearchCommonItemTemplateView.attr(new Function1<QSearchCommonItemTemplateAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.8.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchCommonItemTemplateAttr qSearchCommonItemTemplateAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchCommonItemTemplateAttr, QSearchBaseTemplateModel.this, i46, str19, str20, qSearchTabContentViewModel9, qSearchDetailViewModel10, unifySearchTabInfo10);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchDoubleColumnTemplateModel) {
                            final int i46 = i19;
                            final String str19 = str;
                            final String str20 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel9 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel10 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo10 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchDoubleColumnTemplateView(), new Function1<QSearchDoubleColumnTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i47 = i46;
                                    final String str21 = str19;
                                    final String str22 = str20;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel10 = qSearchTabContentViewModel9;
                                    final QSearchDetailViewModel qSearchDetailViewModel11 = qSearchDetailViewModel10;
                                    final UnifySearchTabInfo unifySearchTabInfo11 = unifySearchTabInfo10;
                                    qSearchDoubleColumnTemplateView.attr(new Function1<QSearchDoubleColumnTemplateAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.9.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchDoubleColumnTemplateAttr qSearchDoubleColumnTemplateAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchDoubleColumnTemplateAttr, QSearchBaseTemplateModel.this, i47, str21, str22, qSearchTabContentViewModel10, qSearchDetailViewModel11, unifySearchTabInfo11);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (qSearchBaseTemplateModel2 instanceof QSearchPlayletTemplateModel) {
                            final int i47 = i19;
                            final String str21 = str;
                            final String str22 = str2;
                            final QSearchTabContentViewModel qSearchTabContentViewModel10 = viewModel;
                            final QSearchDetailViewModel qSearchDetailViewModel11 = qSearchDetailViewModel;
                            final UnifySearchTabInfo unifySearchTabInfo11 = unifySearchTabInfo;
                            viewContainer4.addChild(new QSearchPlayletTemplateView(), new Function1<QSearchPlayletTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt$buildTemplateView$1.10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QSearchPlayletTemplateView qSearchPlayletTemplateView) {
                                    final QSearchBaseTemplateModel qSearchBaseTemplateModel3 = QSearchBaseTemplateModel.this;
                                    final int i48 = i47;
                                    final String str23 = str21;
                                    final String str24 = str22;
                                    final QSearchTabContentViewModel qSearchTabContentViewModel11 = qSearchTabContentViewModel10;
                                    final QSearchDetailViewModel qSearchDetailViewModel12 = qSearchDetailViewModel11;
                                    final UnifySearchTabInfo unifySearchTabInfo12 = unifySearchTabInfo11;
                                    qSearchPlayletTemplateView.attr(new Function1<QSearchPlayletVideoAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt.buildTemplateView.1.10.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QSearchPlayletVideoAttr qSearchPlayletVideoAttr) {
                                            TemplateItemsKt.access$configAttr(qSearchPlayletVideoAttr, QSearchBaseTemplateModel.this, i48, str23, str24, qSearchTabContentViewModel11, qSearchDetailViewModel12, unifySearchTabInfo12);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                }.invoke(conditionView2);
                return Unit.INSTANCE;
            }
        });
        final ISearchItemModel iSearchItemModel25 = this.$_data;
        Function0<Object> function013 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.25
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ISearchItemModel.this instanceof FunctionCardItemModel);
            }
        };
        final ISearchItemModel iSearchItemModel26 = this.$_data;
        ConditionViewKt.b(viewContainer2, function013, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.26
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                ISearchItemModel iSearchItemModel27 = ISearchItemModel.this;
                Intrinsics.checkNotNull(iSearchItemModel27, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function.FunctionCardItemModel");
                final FunctionCardItemModel functionCardItemModel = (FunctionCardItemModel) iSearchItemModel27;
                conditionView.addChild(new FunctionCardView(), new Function1<FunctionCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.26.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FunctionCardView functionCardView) {
                        final FunctionCardItemModel functionCardItemModel2 = FunctionCardItemModel.this;
                        functionCardView.attr(new Function1<QSearchFunctionItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.26.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QSearchFunctionItemAttr qSearchFunctionItemAttr) {
                                QSearchFunctionItemAttr qSearchFunctionItemAttr2 = qSearchFunctionItemAttr;
                                String str = FunctionCardItemModel.this.name;
                                ReadWriteProperty readWriteProperty = qSearchFunctionItemAttr2.text$delegate;
                                KProperty<?>[] kPropertyArr = QSearchFunctionItemAttr.$$delegatedProperties;
                                readWriteProperty.setValue(qSearchFunctionItemAttr2, kPropertyArr[0], str);
                                qSearchFunctionItemAttr2.imageUrl$delegate.setValue(qSearchFunctionItemAttr2, kPropertyArr[1], FunctionCardItemModel.this.iconUrl);
                                qSearchFunctionItemAttr2.cardId$delegate.setValue(qSearchFunctionItemAttr2, kPropertyArr[2], FunctionCardItemModel.this.cardId);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView$configItemView$1.27
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.27.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView.configItemView.1.27.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.mo141height(0.0f);
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
}
