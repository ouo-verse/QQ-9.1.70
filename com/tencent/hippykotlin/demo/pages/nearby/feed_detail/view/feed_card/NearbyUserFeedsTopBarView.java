package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFollowRepo$setFollowState$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$doFollow$2;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import q35.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserFeedsTopBarView extends ComposeView<NearbyUserFeedsTopBarAttr, NearbyUserFeedsTopBarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyUserFeedsTopBarView.class, "greetingBtnHighlighted", "getGreetingBtnHighlighted()Z", 0)};
    public final ReadWriteProperty greetingBtnHighlighted$delegate = c.a(Boolean.FALSE);
    public boolean isFirstDisplay = true;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyUserFeedsTopBarAttr access$getAttr(NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView) {
        return (NearbyUserFeedsTopBarAttr) nearbyUserFeedsTopBarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentSpaceBetween();
                        mVar2.marginTop(8.0f);
                        mVar2.marginBottom(8.0f);
                        mVar2.mo141height(36.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView = NearbyUserFeedsTopBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.marginLeft(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView2 = NearbyUserFeedsTopBarView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView3 = NearbyUserFeedsTopBarView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        String str;
                                        long tinyId = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId();
                                        String valueOf = String.valueOf(tinyId);
                                        boolean isHostTid = UserDataManager.INSTANCE.isHostTid(Long.valueOf(tinyId));
                                        HomepageSource homepageSource = HomepageSource.FEED_DETAIL_TOP_HEAD;
                                        NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                        NBPJumpUtil.jumpPersonaPage$default(2, valueOf, isHostTid, false, homepageSource, contentModel != null ? contentModel.getFid() : null, 8);
                                        INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).dtReporter;
                                        if (iNearbyFeedDetailDTReporter != null) {
                                            NearbyFDPUserFeedTimelineItemViewModel contentModel2 = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                            if (contentModel2 == null || (str = contentModel2.getFid()) == null) {
                                                str = "";
                                            }
                                            iNearbyFeedDetailDTReporter.dtReportElementClick(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_avatar_nickname", false);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView4 = NearbyUserFeedsTopBarView.this;
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        String str;
                                        INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).dtReporter;
                                        if (iNearbyFeedDetailDTReporter != null) {
                                            NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                            if (contentModel == null || (str = contentModel.getFid()) == null) {
                                                str = "";
                                            }
                                            iNearbyFeedDetailDTReporter.dtReportElementImp(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_avatar_nickname", false);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView3 = NearbyUserFeedsTopBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.alignItemsCenter();
                                        tVar2.marginRight(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView4 = NearbyUserFeedsTopBarView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView5 = NearbyUserFeedsTopBarView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.mo113backgroundColor(new h(4294310143L));
                                                afVar2.size(36.0f, 36.0f);
                                                afVar2.borderRadius(18.0f);
                                                NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                                b.a.b(afVar2, (String) viewModel.avatarUrl$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[1]), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView5 = NearbyUserFeedsTopBarView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                        return Boolean.valueOf(((String) viewModel.avatarDressBorderUrl$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[2])).length() > 0);
                                    }
                                };
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView6 = NearbyUserFeedsTopBarView.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView7 = NearbyUserFeedsTopBarView.this;
                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.3.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.absolutePosition(-3.0f, -3.0f, -3.0f, -3.0f);
                                                        NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                                        b.a.b(afVar2, (String) viewModel.avatarDressBorderUrl$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[2]), false, 2, null);
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
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView4 = NearbyUserFeedsTopBarView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getNickName().length() > 0);
                            }
                        };
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView5 = NearbyUserFeedsTopBarView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView6 = NearbyUserFeedsTopBarView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.alignSelfStretch();
                                                tVar2.justifyContentSpaceBetween();
                                                tVar2.mo141height(36.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView7 = NearbyUserFeedsTopBarView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontWeight500();
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.lineHeight(20.0f);
                                                        ceVar2.lines(1);
                                                        ceVar2.m144maxWidth(ceVar2.getPagerData().m() / 2);
                                                        ceVar2.text(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getNickName());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView9 = NearbyUserFeedsTopBarView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.2.5.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.lineHeight(14.0f);
                                                        ceVar2.m144maxWidth(ceVar2.getPagerData().m() / 2);
                                                        NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                                        if (contentModel == null || (str = (String) contentModel.timeInfo$delegate.getValue(contentModel, NearbyFDPUserFeedTimelineItemViewModel.$$delegatedProperties[4])) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
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
                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView2 = NearbyUserFeedsTopBarView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                        return Boolean.valueOf(((Boolean) viewModel.showGreetingBtn$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[3])).booleanValue());
                    }
                };
                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView3 = NearbyUserFeedsTopBarView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView4 = NearbyUserFeedsTopBarView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(32.0f);
                                        tVar2.marginRight(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView5 = NearbyUserFeedsTopBarView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView6 = NearbyUserFeedsTopBarView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str;
                                                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                String valueOf = String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId());
                                                String nickName = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getNickName();
                                                NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                                companion.openGreetingPage(valueOf, nickName, (String) viewModel.avatarUrl$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[1]), 22, 0);
                                                INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).dtReporter;
                                                if (iNearbyFeedDetailDTReporter != null) {
                                                    NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                                    if (contentModel == null || (str = contentModel.getFid()) == null) {
                                                        str = "";
                                                    }
                                                    iNearbyFeedDetailDTReporter.dtReportElementClick(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_greet", NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().fromFollowingTab);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView7 = NearbyUserFeedsTopBarView.this;
                                        uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                                nearbyUserFeedsTopBarView8.greetingBtnHighlighted$delegate.setValue(nearbyUserFeedsTopBarView8, NearbyUserFeedsTopBarView.$$delegatedProperties[0], Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                        uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TouchParams touchParams) {
                                                NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView9 = NearbyUserFeedsTopBarView.this;
                                                nearbyUserFeedsTopBarView9.greetingBtnHighlighted$delegate.setValue(nearbyUserFeedsTopBarView9, NearbyUserFeedsTopBarView.$$delegatedProperties[0], Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView9 = NearbyUserFeedsTopBarView.this;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                String str;
                                                NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView10 = NearbyUserFeedsTopBarView.this;
                                                if (nearbyUserFeedsTopBarView10.isFirstDisplay) {
                                                    nearbyUserFeedsTopBarView10.isFirstDisplay = false;
                                                    INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(nearbyUserFeedsTopBarView10).dtReporter;
                                                    if (iNearbyFeedDetailDTReporter != null) {
                                                        NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                                        if (contentModel == null || (str = contentModel.getFid()) == null) {
                                                            str = "";
                                                        }
                                                        iNearbyFeedDetailDTReporter.dtReportElementImp(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_greet", NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().fromFollowingTab);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView6 = NearbyUserFeedsTopBarView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView7 = NearbyUserFeedsTopBarView.this;
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.1f));
                                                NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                                tVar2.m152visibility(((Boolean) nearbyUserFeedsTopBarView8.greetingBtnHighlighted$delegate.getValue(nearbyUserFeedsTopBarView8, NearbyUserFeedsTopBarView.$$delegatedProperties[0])).booleanValue());
                                                tVar2.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.o();
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DdHUF3lfAnx.png", false, 2, null);
                                                afVar2.size(20.0f, 20.0f);
                                                afVar2.marginLeft(8.0f);
                                                afVar2.t(QUIToken.color$default("button_text_secondary_default"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.4.1.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u6253\u62db\u547c");
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.marginLeft(6.0f);
                                                ceVar2.marginRight(8.0f);
                                                ceVar2.color(QUIToken.color$default("button_text_secondary_default"));
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
                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView4 = NearbyUserFeedsTopBarView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String valueOf = String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId());
                        return Boolean.valueOf(!Intrinsics.areEqual(valueOf, NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().hostUser != null ? r1.tid : null));
                    }
                };
                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView5 = NearbyUserFeedsTopBarView.this;
                ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView6 = NearbyUserFeedsTopBarView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(32.0f);
                                        tVar2.marginRight(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView7 = NearbyUserFeedsTopBarView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str;
                                                final NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                                String valueOf = String.valueOf(viewModel.getTinyId());
                                                Function1<q35.b, Unit> function1 = new Function1<q35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$doFollow$1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(q35.b bVar) {
                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u5df2\u5173\u6ce8", QToastMode.Success);
                                                        NearbyFDPUserFeedsCardViewModel.this.setButtonText("\u5df2\u5173\u6ce8");
                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = NearbyFDPUserFeedsCardViewModel.this;
                                                        TimerKt.d(800, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$doFollow$1.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                NearbyFDPUserFeedsCardViewModel.this.setShowGreetingBtn(true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                NearbyFDPUserFeedsCardViewModel$doFollow$2 nearbyFDPUserFeedsCardViewModel$doFollow$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel$doFollow$2
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(Integer num, String str2) {
                                                        num.intValue();
                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u5173\u6ce8\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Warning);
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("setFollowState: error. msg: ", str2, KLog.INSTANCE, "NearbyFDPUserFeedsCardViewModel");
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                a aVar = new a(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), 1, valueOf, 2);
                                                NearbyFollowRepo$setFollowState$1 nearbyFollowRepo$setFollowState$1 = new NearbyFollowRepo$setFollowState$1(2, function1, nearbyFDPUserFeedsCardViewModel$doFollow$2, valueOf, 1);
                                                QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoDoFollow", 2, new c45.a(i.d(aVar))));
                                                QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nearbyFollowRepo$setFollowState$1);
                                                APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
                                                INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).dtReporter;
                                                if (iNearbyFeedDetailDTReporter != null) {
                                                    NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                                    if (contentModel == null || (str = contentModel.getFid()) == null) {
                                                        str = "";
                                                    }
                                                    iNearbyFeedDetailDTReporter.dtReportElementClick(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_focus", true);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView9 = NearbyUserFeedsTopBarView.this;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                String str;
                                                NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView10 = NearbyUserFeedsTopBarView.this;
                                                if (nearbyUserFeedsTopBarView10.isFirstDisplay) {
                                                    nearbyUserFeedsTopBarView10.isFirstDisplay = false;
                                                    INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyUserFeedsTopBarView.access$getAttr(nearbyUserFeedsTopBarView10).dtReporter;
                                                    if (iNearbyFeedDetailDTReporter != null) {
                                                        NearbyFDPUserFeedTimelineItemViewModel contentModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getContentModel();
                                                        if (contentModel == null || (str = contentModel.getFid()) == null) {
                                                            str = "";
                                                        }
                                                        iNearbyFeedDetailDTReporter.dtReportElementImp(str, String.valueOf(NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel().getTinyId()), "em_nearby_focus", true);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView8 = NearbyUserFeedsTopBarView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NearbyUserFeedsTopBarView nearbyUserFeedsTopBarView9 = NearbyUserFeedsTopBarView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsTopBarView.body.1.6.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                NearbyFDPUserFeedsCardViewModel viewModel = NearbyUserFeedsTopBarView.access$getAttr(NearbyUserFeedsTopBarView.this).getViewModel();
                                                ceVar2.text((String) viewModel.buttonText$delegate.getValue(viewModel, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[6]));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight400();
                                                ceVar2.marginLeft(10.0f);
                                                ceVar2.marginRight(10.0f);
                                                ceVar2.color(QUIToken.color$default("button_text_secondary_default"));
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
        return new NearbyUserFeedsTopBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyUserFeedsTopBarEvent();
    }
}
