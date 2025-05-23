package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyFollowRepo$setFollowState$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPCityWalkMapViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.CommentClickInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentVO;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModelKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.av;
import com.tencent.kuikly.core.views.aw;
import com.tencent.kuikly.core.views.ax;
import com.tencent.kuikly.core.views.ay;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import p35.ac;
import p35.g;
import p35.n;
import q35.a;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPArticleFeedItemView extends ComposeView<NBPArticleFeedItemViewAttr, l> {
    static {
        Reflection.mutableProperty1(new MutablePropertyReference1Impl(NBPArticleFeedItemView.class, "buttonText", "getButtonText()Ljava/lang/String;", 0));
    }

    public NBPArticleFeedItemView() {
        c.a("\u5173\u6ce8");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPArticleFeedItemViewAttr access$getAttr(NBPArticleFeedItemView nBPArticleFeedItemView) {
        return (NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$isSelfFeed(NBPArticleFeedItemView nBPArticleFeedItemView) {
        String str;
        af afVar;
        if (!Intrinsics.areEqual(((NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr()).getVm().viewerUserId, ((NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr()).getVm().posterUserId)) {
            String str2 = ((NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr()).getVm().viewerUserId;
            n feed = ((NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr()).getFeed().getFeed();
            if (feed == null || (afVar = feed.f425194e) == null || (str = afVar.f433205d) == null) {
                str = "";
            }
            if (!Intrinsics.areEqual(str2, str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollToComment(NBPArticleFeedItemView nBPArticleFeedItemView, long j3, Long l3) {
        NBPFeedCommentsView b16;
        final NBPArticleFeedDetailVM vm5 = ((NBPArticleFeedItemViewAttr) nBPArticleFeedItemView.getAttr()).getVm();
        aa<NBPFeedCommentsView> aaVar = vm5.topFeedCommentsViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.getCommentOffset(j3, l3, new Function3<Float, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$scrollToComment$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Float f16, Float f17, Float f18) {
                aq<?, ?> b17;
                d frame;
                aq<?, ?> b18;
                NBPFeedCommentsView b19;
                d frame2;
                float floatValue = f16.floatValue();
                f17.floatValue();
                float floatValue2 = f18.floatValue() + floatValue;
                aa<NBPFeedCommentsView> aaVar2 = NBPArticleFeedDetailVM.this.topFeedCommentsViewRef;
                float f19 = 0.0f;
                float y16 = (((aaVar2 == null || (b19 = aaVar2.b()) == null || (frame2 = b19.getFrame()) == null) ? 0.0f : frame2.getY()) + floatValue2) - 6.0f;
                aa<aq<?, ?>> aaVar3 = NBPArticleFeedDetailVM.this.listViewRef;
                float curOffsetY = (aaVar3 == null || (b18 = aaVar3.b()) == null) ? 0.0f : b18.getCurOffsetY();
                aa<aq<?, ?>> aaVar4 = NBPArticleFeedDetailVM.this.listViewRef;
                if (aaVar4 != null && (b17 = aaVar4.b()) != null && (frame = b17.getFrame()) != null) {
                    f19 = frame.getHeight();
                }
                float max = Math.max((f19 + curOffsetY) - 200.0f, curOffsetY);
                KLog.INSTANCE.i("NBPArticleFeedItemView", "commentToTopOffset=" + y16 + ", listVisibleTop=" + curOffsetY + ", listVisibleBottom=" + max);
                if (y16 < curOffsetY) {
                    NBPArticleFeedDetailVM.this.scrollToPosition(y16);
                } else if (y16 > max) {
                    NBPArticleFeedDetailVM.this.scrollToPosition((y16 - max) + curOffsetY);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPArticleFeedModel feed = ((NBPArticleFeedItemViewAttr) getAttr()).getFeed();
        final NBPArticleFeedDetailVM vm5 = ((NBPArticleFeedItemViewAttr) getAttr()).getVm();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM = vm5;
                final NBPArticleFeedModel nBPArticleFeedModel = NBPArticleFeedModel.this;
                final NBPArticleFeedItemView nBPArticleFeedItemView = this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                        final NBPArticleFeedModel nBPArticleFeedModel2 = nBPArticleFeedModel;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPArticleFeedDetailVM.this.onItemViewClick(nBPArticleFeedModel2);
                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                                n feed2 = nBPArticleFeedModel2.getFeed();
                                nBPArticleFeedDetailVM3.dtReportElementClick(feed2 != null ? feed2.f425193d : null, "em_nearby_dynamic", null);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                        final NBPArticleFeedModel nBPArticleFeedModel3 = nBPArticleFeedModel;
                        final NBPArticleFeedItemView nBPArticleFeedItemView2 = nBPArticleFeedItemView;
                        event2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ClickParams clickParams2 = clickParams;
                                NBPArticleFeedDetailVM.this.onLikeIconClick(nBPArticleFeedModel3, true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(nBPArticleFeedItemView2, Reflection.getOrCreateKotlinClass(NBPArticleFeedItemView.class)));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = NBPArticleFeedDetailVM.this;
                        final NBPArticleFeedModel nBPArticleFeedModel4 = nBPArticleFeedModel;
                        event2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LongPressParams longPressParams) {
                                NBPArticleFeedDetailVM.this.onFeedLongPress(nBPArticleFeedModel4);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                        final NBPArticleFeedModel nBPArticleFeedModel5 = nBPArticleFeedModel;
                        VisibilityEventKt.b(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                String str;
                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                NBPArticleFeedModel nBPArticleFeedModel6 = nBPArticleFeedModel5;
                                nBPArticleFeedDetailVM6.getClass();
                                n feed2 = nBPArticleFeedModel6.getFeed();
                                nBPArticleFeedDetailVM6.dtReportElementImp(feed2 != null ? feed2.f425193d : null, "em_nearby_dynamic", null);
                                if (nBPArticleFeedDetailVM6.isNearby() && !nBPArticleFeedDetailVM6.isHost()) {
                                    if (nBPArticleFeedDetailVM6.source == 1) {
                                        n feed3 = nBPArticleFeedModel6.getFeed();
                                        if (Intrinsics.areEqual(feed3 != null ? feed3.f425193d : null, nBPArticleFeedDetailVM6.feedId)) {
                                            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "enter from feed detail first feed");
                                        }
                                    }
                                    n feed4 = nBPArticleFeedModel6.getFeed();
                                    if ((feed4 != null ? feed4.f425193d : null) != null) {
                                        Set<String> set = nBPArticleFeedDetailVM6.appearItemIds;
                                        n feed5 = nBPArticleFeedModel6.getFeed();
                                        if (feed5 == null || (str = feed5.f425193d) == null) {
                                            str = "";
                                        }
                                        set.add(str);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedItemView nBPArticleFeedItemView2 = this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = vm5;
                final NBPArticleFeedModel nBPArticleFeedModel2 = NBPArticleFeedModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(12.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.marginLeft(16.0f);
                                tVar2.marginRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final boolean access$isSelfFeed = NBPArticleFeedItemView.access$isSelfFeed(NBPArticleFeedItemView.this);
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = nBPArticleFeedDetailVM2;
                        final boolean z16 = nBPArticleFeedDetailVM3.appId == 2 && access$isSelfFeed;
                        final NBPArticleFeedModel nBPArticleFeedModel3 = nBPArticleFeedModel2;
                        final NBPArticleFeedItemView nBPArticleFeedItemView3 = NBPArticleFeedItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final String str;
                                af afVar;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(40.0f, 40.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM3;
                                final NBPArticleFeedItemView nBPArticleFeedItemView4 = nBPArticleFeedItemView3;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedItemView nBPArticleFeedItemView5 = nBPArticleFeedItemView4;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPArticleFeedDetailVM.this.onAvatarClick(NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView5).getFeed());
                                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                                n feed2 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView5).getFeed().getFeed();
                                                nBPArticleFeedDetailVM6.dtReportElementClick(feed2 != null ? feed2.f425193d : null, "em_nearby_avatar_nickname", null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedItemView nBPArticleFeedItemView6 = nBPArticleFeedItemView4;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                                n feed2 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView6).getFeed().getFeed();
                                                String str2 = feed2 != null ? feed2.f425193d : null;
                                                KProperty<Object>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                                nBPArticleFeedDetailVM7.dtReportElementImp(str2, "em_nearby_avatar_nickname", null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (NBPArticleFeedModel.this.headAvatar.length() > 0) {
                                    final NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                    com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                    afVar3.size(40.0f, 40.0f);
                                                    afVar3.borderRadius(20.0f);
                                                    afVar3.p();
                                                    b.a.b(afVar3, NBPArticleFeedModel.this.headAvatar, false, 2, null);
                                                    afVar3.mo113backgroundColor(new h(211, 211, 211, 0.3f));
                                                    afVar3.absolutePositionAllZero();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.4.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
                                            
                                                if ((r0.headAvatar.length() == 0) != false) goto L15;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                String str2;
                                                af afVar3;
                                                com.tencent.kuikly.core.views.af afVar4 = afVar2;
                                                afVar4.size(40.0f, 40.0f);
                                                afVar4.borderRadius(20.0f);
                                                afVar4.p();
                                                n feed2 = NBPArticleFeedModel.this.getFeed();
                                                if (feed2 == null || (afVar3 = feed2.f425194e) == null || (str2 = afVar3.E) == null) {
                                                    str2 = "";
                                                }
                                                b.a.b(afVar4, str2, false, 2, null);
                                                afVar4.absolutePositionAllZero();
                                                NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                                                if (nBPArticleFeedModel7.isHeadFeed) {
                                                }
                                                afVar4.mo113backgroundColor(new h(211, 211, 211, 0.3f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                n feed2 = NBPArticleFeedModel.this.getFeed();
                                if (feed2 != null && (afVar = feed2.f425194e) != null) {
                                    str = StrangerUtilsKt.getAvatarDressFrameUrl(afVar);
                                } else {
                                    str = "";
                                }
                                if (str.length() > 0) {
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final String str2 = str;
                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.2.5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                    com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                    afVar3.size(43.75f, 43.75f);
                                                    b.a.b(afVar3, str2, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedModel nBPArticleFeedModel4 = nBPArticleFeedModel2;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM2;
                        final NBPArticleFeedItemView nBPArticleFeedItemView4 = NBPArticleFeedItemView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.marginLeft(8.0f);
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM4;
                                final NBPArticleFeedItemView nBPArticleFeedItemView5 = nBPArticleFeedItemView4;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
                                    
                                        if ((r1.getStatusTitle().length() > 0) != false) goto L12;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = nBPArticleFeedDetailVM5;
                                        final NBPArticleFeedItemView nBPArticleFeedItemView6 = nBPArticleFeedItemView5;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                TextView textView2 = textView;
                                                final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        af afVar;
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.fontWeight500();
                                                        n feed2 = NBPArticleFeedModel.this.getFeed();
                                                        if (feed2 == null || (afVar = feed2.f425194e) == null || (str = afVar.f433209f) == null) {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        if (ceVar2.getPagerData().getIsAndroid()) {
                                                            ceVar2.m144maxWidth(114.0f);
                                                        } else {
                                                            ceVar2.m144maxWidth(120.0f);
                                                        }
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.textPostProcessor("emoji");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = nBPArticleFeedDetailVM6;
                                                final NBPArticleFeedItemView nBPArticleFeedItemView7 = nBPArticleFeedItemView6;
                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextEvent textEvent) {
                                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                                        final NBPArticleFeedItemView nBPArticleFeedItemView8 = nBPArticleFeedItemView7;
                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPArticleFeedDetailVM.this.onAvatarClick(NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView8).getFeed());
                                                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                                                n feed2 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView8).getFeed().getFeed();
                                                                nBPArticleFeedDetailVM9.dtReportElementClick(feed2 != null ? feed2.f425193d : null, "em_nearby_avatar_nickname", null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (!(NBPArticleFeedModel.this.getStatusIcon().length() > 0)) {
                                        }
                                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = nBPArticleFeedDetailVM5;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = nBPArticleFeedDetailVM7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.padding(NBPArticleFeedDetailVM.this.isNearby() ? 1.0f : 2.5f);
                                                        tVar2.alignItemsCenter();
                                                        if (!NBPArticleFeedDetailVM.this.isNearby()) {
                                                            tVar2.borderRadius(20.0f);
                                                            tVar2.marginLeft(2.0f);
                                                        }
                                                        tVar2.marginRight(8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = nBPArticleFeedDetailVM7;
                                                final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                                        final NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel8;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                af afVar;
                                                                j25.c cVar;
                                                                NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                                NBPArticleFeedModel nBPArticleFeedModel10 = nBPArticleFeedModel9;
                                                                if (nBPArticleFeedDetailVM11.appId == 1) {
                                                                    n feed2 = nBPArticleFeedModel10.getFeed();
                                                                    long j3 = (feed2 == null || (afVar = feed2.f425194e) == null || (cVar = afVar.f433208e0) == null) ? 0L : cVar.f409181d;
                                                                    KLog kLog = KLog.INSTANCE;
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onStatusAreaClick: ");
                                                                    m3.append(nBPArticleFeedDetailVM11.appId);
                                                                    m3.append(", ");
                                                                    m3.append(j3);
                                                                    kLog.i("NBPArticleFeedDetailVM", m3.toString());
                                                                    String str = "mqqapi://stranger/signal_square?partner_id=" + j3;
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                                        vVar9.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.positionAbsolute();
                                                                tVar2.m150top(0.0f);
                                                                tVar2.m138bottom(0.0f);
                                                                tVar2.m142left(0.0f);
                                                                tVar2.m149right(0.0f);
                                                                NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                                                tVar2.mo113backgroundColor((h) nBPArticleFeedModel11.statusBgColor$delegate.getValue(nBPArticleFeedModel11, NBPArticleFeedModel.$$delegatedProperties[7]));
                                                                tVar2.m147opacity(0.6f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                if (NBPArticleFeedModel.this.getStatusIcon().length() > 0) {
                                                    final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.4.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                    com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                    afVar2.size(10.0f, 10.0f);
                                                                    afVar2.o();
                                                                    b.a.b(afVar2, NBPArticleFeedModel.this.getStatusIcon(), false, 2, null);
                                                                    afVar2.marginRight(2.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                if (NBPArticleFeedModel.this.getStatusTitle().length() > 0) {
                                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = nBPArticleFeedDetailVM7;
                                                    final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                            final NBPArticleFeedModel nBPArticleFeedModel12 = nBPArticleFeedModel11;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.2.3.5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    h color$default;
                                                                    ce ceVar2 = ceVar;
                                                                    if (NBPArticleFeedDetailVM.this.isNearby()) {
                                                                        color$default = QUIToken.color$default("text_secondary");
                                                                    } else {
                                                                        color$default = QUIToken.color$default("text_primary");
                                                                    }
                                                                    ceVar2.color(color$default);
                                                                    ceVar2.text(nBPArticleFeedModel12.getStatusTitle());
                                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                    ceVar2.fontWeight400();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final boolean z17 = z16;
                                final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(2.0f);
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedModel nBPArticleFeedModel7 = nBPArticleFeedModel6;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(NBPArticleFeedModel.this.getJiebanTagInfo().length() > 0);
                                            }
                                        };
                                        final NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel6;
                                        ConditionViewKt.c(vVar6, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.3.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(NBPArticleFeedModel.this.getJiebanTagInfo());
                                                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 10.0f, null, 2, null, "text_secondary");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel6;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        NearbyFormatUtils nearbyFormatUtils = NearbyFormatUtils.INSTANCE;
                                                        n feed2 = NBPArticleFeedModel.this.getFeed();
                                                        ceVar2.text(nearbyFormatUtils.formatFeedTime((feed2 != null ? feed2.D : 0L) * 1000));
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (z17) {
                                            final NBPArticleFeedModel nBPArticleFeedModel10 = nBPArticleFeedModel6;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionRow();
                                                            tVar2.marginLeft(7.0f);
                                                            tVar2.alignItemsCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                    com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                    afVar2.size(11.0f, 11.0f);
                                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Fc-_PGeS7A2.png", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                                    cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final NBPArticleFeedModel nBPArticleFeedModel12 = NBPArticleFeedModel.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.3.3.5.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    String valueOf;
                                                                    ce ceVar2 = ceVar;
                                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                    ceVar2.color(new h(9474196L, 1.0f));
                                                                    ceVar2.fontWeight400();
                                                                    NearbyFormatUtils nearbyFormatUtils = NearbyFormatUtils.INSTANCE;
                                                                    n feed2 = NBPArticleFeedModel.this.getFeed();
                                                                    int i3 = feed2 != null ? feed2.P : 0;
                                                                    if (i3 > 9999) {
                                                                        valueOf = "9999+";
                                                                    } else {
                                                                        valueOf = String.valueOf(i3);
                                                                    }
                                                                    ceVar2.text(valueOf);
                                                                    ceVar2.marginLeft(2.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(access$isSelfFeed);
                            }
                        };
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM2;
                        final NBPArticleFeedModel nBPArticleFeedModel5 = nBPArticleFeedModel2;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel6 = nBPArticleFeedModel5;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        imageView2.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.5.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                afVar2.size(20.0f, 20.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ZYm6a63VKkV.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedModel nBPArticleFeedModel7 = nBPArticleFeedModel6;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.5.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                                final NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel7;
                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.5.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                                        NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel8;
                                                        nBPArticleFeedDetailVM9.getClass();
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onDeleteClick fid: ");
                                                        n feed2 = nBPArticleFeedModel9.getFeed();
                                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, feed2 != null ? feed2.f425193d : null, kLog, "NBPArticleFeedDetailVM");
                                                        nBPArticleFeedDetailVM9.onFeedLongPress(nBPArticleFeedModel9);
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
                        final NBPArticleFeedItemView nBPArticleFeedItemView5 = NBPArticleFeedItemView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.6
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
                            
                                if (com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.access$getAttr(r1).getVm().source != 1) goto L35;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                af afVar;
                                af afVar2;
                                NBPArticleFeedDetailVM vm6 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm();
                                ReadWriteProperty readWriteProperty = vm6.didClickUnFollowButton$delegate;
                                KProperty<?>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                boolean booleanValue = ((Boolean) readWriteProperty.getValue(vm6, kPropertyArr[10])).booleanValue();
                                boolean z17 = false;
                                if (!booleanValue) {
                                    n feed2 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getFeed().getFeed();
                                    if (!((feed2 == null || (afVar2 = feed2.f425194e) == null || afVar2.f433217k0 != 1) ? false : true)) {
                                        n feed3 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getFeed().getFeed();
                                        if (!((feed3 == null || (afVar = feed3.f425194e) == null || afVar.f433217k0 != 3) ? false : true)) {
                                            NBPArticleFeedDetailVM vm7 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm();
                                            if (!((Boolean) vm7.didClickFollowButton$delegate.getValue(vm7, kPropertyArr[11])).booleanValue()) {
                                                if (!NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().hasFollowed) {
                                                    if (NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().appId != 1) {
                                                        if (NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().source != 13) {
                                                            if (NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().source != 14) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    z17 = true;
                                }
                                return Boolean.valueOf(z17);
                            }
                        };
                        final NBPArticleFeedItemView nBPArticleFeedItemView6 = NBPArticleFeedItemView.this;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = nBPArticleFeedDetailVM2;
                        ConditionViewKt.b(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                af afVar;
                                ConditionView conditionView2 = conditionView;
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("following status:");
                                n feed2 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getFeed().getFeed();
                                m3.append((feed2 == null || (afVar = feed2.f425194e) == null) ? null : Integer.valueOf(afVar.f433217k0));
                                m3.append(", didClick:");
                                NBPArticleFeedDetailVM vm6 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm();
                                m3.append(((Boolean) vm6.didClickFollowButton$delegate.getValue(vm6, NBPArticleFeedDetailVM.$$delegatedProperties[11])).booleanValue());
                                kLog.i("NBPArticleFeedItemView", m3.toString());
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = nBPArticleFeedDetailVM6;
                                final NBPArticleFeedItemView nBPArticleFeedItemView7 = NBPArticleFeedItemView.this;
                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.padding(6.0f, 8.0f, 6.0f, 8.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(4.0f);
                                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedItemView nBPArticleFeedItemView8 = nBPArticleFeedItemView7;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                                                final NBPArticleFeedItemView nBPArticleFeedItemView9 = nBPArticleFeedItemView8;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Object obj;
                                                        String str;
                                                        af afVar2;
                                                        String str2;
                                                        String str3;
                                                        String l3;
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                                        NBPArticleFeedModel feed3 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView9).getFeed();
                                                        String str4 = "";
                                                        if (nBPArticleFeedDetailVM10.appId == 2) {
                                                            n feed4 = feed3.getFeed();
                                                            if (feed4 != null) {
                                                                af afVar3 = feed4.f425194e;
                                                                String str5 = (afVar3 == null || (l3 = Long.valueOf(afVar3.f433207e).toString()) == null) ? "" : l3;
                                                                af afVar4 = feed4.f425194e;
                                                                String str6 = (afVar4 == null || (str3 = afVar4.f433209f) == null) ? "" : str3;
                                                                String str7 = (afVar4 == null || (str2 = afVar4.E) == null) ? "" : str2;
                                                                KLog kLog2 = KLog.INSTANCE;
                                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onMessageBtnClick: ");
                                                                m16.append(nBPArticleFeedDetailVM10.appId);
                                                                m16.append(", ");
                                                                StringBuilder m17 = VasBusinessReportData$$ExternalSyntheticOutline0.m(m16, nBPArticleFeedDetailVM10.feedId, ", ", str5, ", ");
                                                                m17.append(str6);
                                                                m17.append(", ");
                                                                m17.append(str7);
                                                                kLog2.i("NBPArticleFeedDetailVM", m17.toString());
                                                                QQNearbyModule.Companion.getInstance().openGreetingPage(str5, str6, str7, 23, 0);
                                                            }
                                                        } else {
                                                            n feed5 = feed3.getFeed();
                                                            if (feed5 == null || (afVar2 = feed5.f425194e) == null || (obj = afVar2.f433205d) == null) {
                                                                obj = 0;
                                                            }
                                                            KLog kLog3 = KLog.INSTANCE;
                                                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onMessageBtnClick: ");
                                                            m18.append(nBPArticleFeedDetailVM10.appId);
                                                            m18.append(", ");
                                                            m18.append(obj);
                                                            kLog3.i("NBPArticleFeedDetailVM", m18.toString());
                                                            n feed6 = feed3.getFeed();
                                                            if (feed6 != null && (str = feed6.f425193d) != null) {
                                                                str4 = str;
                                                            }
                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://stranger/aio?open_id=" + obj + "&source_id=9&feed_id=" + str4, false, 6);
                                                        }
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                        n feed7 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView9).getFeed().getFeed();
                                                        String str8 = feed7 != null ? feed7.f425193d : null;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e m19 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_kl_btn_type", 2);
                                                        Unit unit = Unit.INSTANCE;
                                                        nBPArticleFeedDetailVM11.dtReportElementClick(str8, "em_nearby_greet", m19);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = NBPArticleFeedDetailVM.this;
                                                final NBPArticleFeedItemView nBPArticleFeedItemView10 = nBPArticleFeedItemView8;
                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = NBPArticleFeedDetailVM.this;
                                                        n feed3 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView10).getFeed().getFeed();
                                                        String str = feed3 != null ? feed3.f425193d : null;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e m16 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_kl_btn_type", 2);
                                                        Unit unit = Unit.INSTANCE;
                                                        nBPArticleFeedDetailVM11.dtReportElementImp(str, "em_nearby_greet", m16);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar2) {
                                                        com.tencent.kuikly.core.views.af afVar3 = afVar2;
                                                        afVar3.size(20.0f, 20.0f);
                                                        afVar3.o();
                                                        b.a.b(afVar3, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DdHUF3lfAnx.png", false, 2, null);
                                                        afVar3.t(QUIToken.color$default("button_text_secondary_default"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.7.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(2.0f);
                                                        ceVar2.text("\u6253\u62db\u547c");
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
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
                        final NBPArticleFeedItemView nBPArticleFeedItemView7 = NBPArticleFeedItemView.this;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = nBPArticleFeedDetailVM2;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPArticleFeedItemView nBPArticleFeedItemView8 = NBPArticleFeedItemView.this;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = nBPArticleFeedDetailVM7;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.padding(6.0f, 12.0f, 6.0f, 12.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.borderRadius(4.0f);
                                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedItemView nBPArticleFeedItemView9 = NBPArticleFeedItemView.this;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = nBPArticleFeedDetailVM8;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final NBPArticleFeedItemView nBPArticleFeedItemView10 = NBPArticleFeedItemView.this;
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = nBPArticleFeedDetailVM9;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        af afVar;
                                                        n feed2 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getFeed().getFeed();
                                                        String valueOf = String.valueOf((feed2 == null || (afVar = feed2.f425194e) == null) ? null : Long.valueOf(afVar.f433207e));
                                                        final NBPArticleFeedItemView nBPArticleFeedItemView11 = NBPArticleFeedItemView.this;
                                                        Function1<q35.b, Unit> function1 = new Function1<q35.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(q35.b bVar) {
                                                                NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().setButtonText("\u5df2\u5173\u6ce8");
                                                                final NBPArticleFeedItemView nBPArticleFeedItemView12 = NBPArticleFeedItemView.this;
                                                                TimerKt.d(1200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2.1.1.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm().setDidClickFollowButton(true);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        C20802 c20802 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2.1.2
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(Integer num, String str) {
                                                                num.intValue();
                                                                KLog.INSTANCE.e("NBPArticleFeedItemView", "setFollowState: error. msg: " + str);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        a aVar = new a(QQNearbyModule.Companion.getInstance().getCommonExtInfo(), 1, valueOf, 2);
                                                        NearbyFollowRepo$setFollowState$1 nearbyFollowRepo$setFollowState$1 = new NearbyFollowRepo$setFollowState$1(2, function1, c20802, valueOf, 1);
                                                        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.follow", "SsoDoFollow", 2, new c45.a(i.d(aVar))));
                                                        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nearbyFollowRepo$setFollowState$1);
                                                        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = nBPArticleFeedDetailVM10;
                                                        n feed3 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getFeed().getFeed();
                                                        String str = feed3 != null ? feed3.f425193d : null;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_kl_btn_type", 2);
                                                        Unit unit = Unit.INSTANCE;
                                                        nBPArticleFeedDetailVM11.dtReportElementClick(str, "em_nearby_focus", m3);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = nBPArticleFeedDetailVM9;
                                                final NBPArticleFeedItemView nBPArticleFeedItemView11 = NBPArticleFeedItemView.this;
                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = NBPArticleFeedDetailVM.this;
                                                        n feed2 = NBPArticleFeedItemView.access$getAttr(nBPArticleFeedItemView11).getFeed().getFeed();
                                                        String str = feed2 != null ? feed2.f425193d : null;
                                                        com.tencent.kuikly.core.nvi.serialization.json.e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("nearby_kl_btn_type", 2);
                                                        Unit unit = Unit.INSTANCE;
                                                        nBPArticleFeedDetailVM12.dtReportElementImp(str, "em_nearby_focus", m3);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedItemView nBPArticleFeedItemView10 = NBPArticleFeedItemView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPArticleFeedItemView nBPArticleFeedItemView11 = NBPArticleFeedItemView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.3.8.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(2.0f);
                                                        NBPArticleFeedDetailVM vm6 = NBPArticleFeedItemView.access$getAttr(NBPArticleFeedItemView.this).getVm();
                                                        ceVar2.text((String) vm6.buttonText$delegate.getValue(vm6, NBPArticleFeedDetailVM.$$delegatedProperties[15]));
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
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
                });
                final NBPArticleFeedModel nBPArticleFeedModel3 = NBPArticleFeedModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                        return Boolean.valueOf(((String) nBPArticleFeedModel4.contentText$delegate.getValue(nBPArticleFeedModel4, NBPArticleFeedModel.$$delegatedProperties[1])).length() > 0);
                    }
                };
                final NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginTop(8.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginRight(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                                                ceVar2.text((String) nBPArticleFeedModel8.contentText$delegate.getValue(nBPArticleFeedModel8, NBPArticleFeedModel.$$delegatedProperties[1]));
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                ceVar2.lineHeight(30.0f);
                                                ceVar2.textPostProcessor("emoji");
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
                final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.6
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                    
                        if (com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt.isCityWalk(r0) == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        n feed2 = NBPArticleFeedModel.this.getFeed();
                        boolean z16 = feed2 != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = vm5;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM3;
                        NBPCityWalkMapViewKt.NBPCityWalkMap(conditionView, new Function1<NBPCityWalkMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkMapView nBPCityWalkMapView) {
                                NBPCityWalkMapView nBPCityWalkMapView2 = nBPCityWalkMapView;
                                final float m3 = nBPCityWalkMapView2.getPagerData().m() - 32;
                                final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                                nBPCityWalkMapView2.attr(new Function1<NBPCityWalkMapViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr) {
                                        n25.l lVar;
                                        NBPCityWalkMapViewAttr nBPCityWalkMapViewAttr2 = nBPCityWalkMapViewAttr;
                                        float f16 = m3;
                                        nBPCityWalkMapViewAttr2.size(f16, f16);
                                        nBPCityWalkMapViewAttr2.marginLeft(16.0f);
                                        nBPCityWalkMapViewAttr2.marginRight(16.0f);
                                        n feed2 = nBPArticleFeedModel8.getFeed();
                                        if (feed2 != null) {
                                            lVar = NearbyProUtilsKt.toStatusFeed(feed2);
                                        } else {
                                            lVar = new n25.l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151);
                                        }
                                        nBPCityWalkMapViewAttr2.setStatusFeed(lVar);
                                        nBPCityWalkMapViewAttr2.borderRadius(10.0f);
                                        nBPCityWalkMapViewAttr2.marginTop(6.0f);
                                        nBPCityWalkMapViewAttr2.jumpArticleFeedDetailSource = 6;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM4;
                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                nBPCityWalkMapView2.event(new Function1<NBPCityWalkMapViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPCityWalkMapViewEvent nBPCityWalkMapViewEvent) {
                                        NBPCityWalkMapViewEvent nBPCityWalkMapViewEvent2 = nBPCityWalkMapViewEvent;
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedModel nBPArticleFeedModel10 = nBPArticleFeedModel9;
                                        nBPCityWalkMapViewEvent2.onMapClickHandler = new Function1<n25.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(n25.a aVar) {
                                                if (aVar == null) {
                                                    NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                                    NBPArticleFeedModel nBPArticleFeedModel11 = nBPArticleFeedModel10;
                                                    nBPArticleFeedDetailVM7.getClass();
                                                    if (!nBPArticleFeedModel11.isHeadFeed) {
                                                        KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onCityWalkClick");
                                                        nBPArticleFeedDetailVM7.onItemViewClick(nBPArticleFeedModel11);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedModel nBPArticleFeedModel11 = nBPArticleFeedModel9;
                                        nBPCityWalkMapViewEvent2.onMapLongPress = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPArticleFeedDetailVM.this.onFeedLongPress(nBPArticleFeedModel11);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                        final NBPArticleFeedModel nBPArticleFeedModel12 = nBPArticleFeedModel9;
                                        nBPCityWalkMapViewEvent2.onMapDoubleClick = new Function2<ClickParams, NBPCityWalkMapView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.7.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(ClickParams clickParams, NBPCityWalkMapView nBPCityWalkMapView3) {
                                                ClickParams clickParams2 = clickParams;
                                                NBPArticleFeedDetailVM.this.onLikeIconClick(nBPArticleFeedModel12, true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(nBPCityWalkMapView3, Reflection.getOrCreateKotlinClass(NBPArticleFeedItemView.class)));
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
                final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPArticleFeedModel.this.getImageUrl() != null);
                    }
                };
                final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = vm5;
                ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM4;
                        conditionView.addChild(new NBPArticleFeedImageView(), new Function1<NBPArticleFeedImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.9.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPArticleFeedImageView nBPArticleFeedImageView) {
                                final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = nBPArticleFeedDetailVM5;
                                nBPArticleFeedImageView.attr(new Function1<NBPArticleFeedImageViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.9.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPArticleFeedImageViewAttr nBPArticleFeedImageViewAttr) {
                                        NBPArticleFeedImageViewAttr nBPArticleFeedImageViewAttr2 = nBPArticleFeedImageViewAttr;
                                        nBPArticleFeedImageViewAttr2.feedModel = NBPArticleFeedModel.this;
                                        nBPArticleFeedImageViewAttr2.f114202vm = nBPArticleFeedDetailVM6;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
                    
                        if (r0 == false) goto L26;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z16;
                        p35.ah ahVar;
                        String str;
                        List<String> list;
                        n feed2 = NBPArticleFeedModel.this.getFeed();
                        boolean z17 = false;
                        if (!((feed2 == null || (list = feed2.I) == null || !(list.isEmpty() ^ true)) ? false : true)) {
                            n feed3 = NBPArticleFeedModel.this.getFeed();
                            if (feed3 != null && (ahVar = feed3.C) != null && (str = ahVar.Q) != null) {
                                if (str.length() > 0) {
                                    z16 = true;
                                }
                            }
                            z16 = false;
                        }
                        z17 = true;
                        return Boolean.valueOf(z17);
                    }
                };
                final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                ConditionViewKt.c(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.11
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                        conditionView.addChild(new NBPArticleFeedDetailTagView(), new Function1<NBPArticleFeedDetailTagView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.11.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPArticleFeedDetailTagView nBPArticleFeedDetailTagView) {
                                final NBPArticleFeedModel nBPArticleFeedModel12 = NBPArticleFeedModel.this;
                                nBPArticleFeedDetailTagView.attr(new Function1<NBPArticleFeedDetailTagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.11.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPArticleFeedDetailTagViewAttr nBPArticleFeedDetailTagViewAttr) {
                                        NBPArticleFeedDetailTagViewAttr nBPArticleFeedDetailTagViewAttr2 = nBPArticleFeedDetailTagViewAttr;
                                        nBPArticleFeedDetailTagViewAttr2.marginLeft(16.0f);
                                        nBPArticleFeedDetailTagViewAttr2.marginRight(16.0f);
                                        n feed2 = NBPArticleFeedModel.this.getFeed();
                                        Intrinsics.checkNotNull(feed2);
                                        nBPArticleFeedDetailTagViewAttr2.feed = feed2;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                if (!nBPArticleFeedModel11.isHeadFeed) {
                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = vm5;
                    viewContainer2.addChild(new NBPArticleFeedOperationBarView(), new Function1<NBPArticleFeedOperationBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(NBPArticleFeedOperationBarView nBPArticleFeedOperationBarView) {
                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                            final NBPArticleFeedModel nBPArticleFeedModel12 = nBPArticleFeedModel11;
                            nBPArticleFeedOperationBarView.attr(new Function1<NBPArticleFeedOperationBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.12.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPArticleFeedOperationBarViewAttr nBPArticleFeedOperationBarViewAttr) {
                                    NBPArticleFeedOperationBarViewAttr nBPArticleFeedOperationBarViewAttr2 = nBPArticleFeedOperationBarViewAttr;
                                    nBPArticleFeedOperationBarViewAttr2.marginTop(12.0f);
                                    nBPArticleFeedOperationBarViewAttr2.marginBottom(12.0f);
                                    nBPArticleFeedOperationBarViewAttr2.marginLeft(16.0f);
                                    nBPArticleFeedOperationBarViewAttr2.marginRight(16.0f);
                                    nBPArticleFeedOperationBarViewAttr2.justifyContentSpaceBetween();
                                    nBPArticleFeedOperationBarViewAttr2.f114204vm = NBPArticleFeedDetailVM.this;
                                    nBPArticleFeedOperationBarViewAttr2.feedModel = nBPArticleFeedModel12;
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                NBPArticleFeedModel nBPArticleFeedModel12 = NBPArticleFeedModel.this;
                if (nBPArticleFeedModel12.commentsData != null && nBPArticleFeedModel12.isHeadFeed) {
                    String pagerId = viewContainer2.getPagerId();
                    final NBPArticleFeedModel nBPArticleFeedModel13 = NBPArticleFeedModel.this;
                    NBPFeedCommentsData nBPFeedCommentsData = nBPArticleFeedModel13.commentsData;
                    boolean z16 = nBPArticleFeedModel13.isHeadFeed;
                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = vm5;
                    final NBPArticleFeedItemView nBPArticleFeedItemView3 = this;
                    viewContainer2.addChild(new NBPFeedCommentsView(pagerId, "pg_nearby_dynamic_detail", nBPFeedCommentsData, (i3 & 8) != 0 ? false : true, (i3 & 16) != 0 ? true : z16, (i3 & 32) != 0 ? 1000 : 0, (i3 & 64) != 0), new Function1<NBPFeedCommentsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.13
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(NBPFeedCommentsView nBPFeedCommentsView) {
                            NBPFeedCommentsView nBPFeedCommentsView2 = nBPFeedCommentsView;
                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                            final NBPArticleFeedModel nBPArticleFeedModel14 = nBPArticleFeedModel13;
                            nBPFeedCommentsView2.ref(nBPFeedCommentsView2, new Function1<aa<NBPFeedCommentsView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(aa<NBPFeedCommentsView> aaVar) {
                                    final aa<NBPFeedCommentsView> aaVar2 = aaVar;
                                    NBPArticleFeedDetailVM.this.topFeedCommentsViewRef = aaVar2;
                                    nBPArticleFeedModel14.onFeedUpdateListener = new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(n nVar) {
                                            n nVar2 = nVar;
                                            NBPFeedCommentsView b16 = aaVar2.b();
                                            if (b16 != null) {
                                                g gVar = nVar2.J;
                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel = null;
                                                g copy$default = gVar != null ? NBPFeedCommentsViewModelKt.copy$default(gVar, nVar2.G) : null;
                                                ac acVar = nVar2.E;
                                                NBPFeedCommentsViewModel nBPFeedCommentsViewModel2 = b16.f114213vm;
                                                if (nBPFeedCommentsViewModel2 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                                                } else {
                                                    nBPFeedCommentsViewModel = nBPFeedCommentsViewModel2;
                                                }
                                                nBPFeedCommentsViewModel.getClass();
                                                if (copy$default == null) {
                                                    copy$default = new g(true, 7);
                                                }
                                                if (acVar == null) {
                                                    acVar = new ac(null, 0, null, 0, 63);
                                                }
                                                nBPFeedCommentsViewModel.fillFirstPageData(copy$default, acVar, false);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPArticleFeedModel nBPArticleFeedModel15 = nBPArticleFeedModel13;
                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                            nBPFeedCommentsView2.attr(new Function1<NBPFeedCommentsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPFeedCommentsAttr nBPFeedCommentsAttr) {
                                    NBPFeedCommentsAttr nBPFeedCommentsAttr2 = nBPFeedCommentsAttr;
                                    nBPFeedCommentsAttr2.marginTop(NBPArticleFeedModel.this.getImageUrl() != null ? 10.0f : 4.0f);
                                    nBPFeedCommentsAttr2.marginBottom(12.0f);
                                    nBPFeedCommentsAttr2.quickComments = nBPArticleFeedDetailVM8.getQuickComments();
                                    return Unit.INSTANCE;
                                }
                            });
                            final NBPArticleFeedModel nBPArticleFeedModel16 = nBPArticleFeedModel13;
                            final NBPArticleFeedDetailVM nBPArticleFeedDetailVM9 = NBPArticleFeedDetailVM.this;
                            final NBPArticleFeedItemView nBPArticleFeedItemView4 = nBPArticleFeedItemView3;
                            nBPFeedCommentsView2.event(new Function1<NBPFeedCommentsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPFeedCommentsEvent nBPFeedCommentsEvent) {
                                    NBPFeedCommentsEvent nBPFeedCommentsEvent2 = nBPFeedCommentsEvent;
                                    final NBPArticleFeedModel nBPArticleFeedModel17 = NBPArticleFeedModel.this;
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM10 = nBPArticleFeedDetailVM9;
                                    final NBPArticleFeedItemView nBPArticleFeedItemView5 = nBPArticleFeedItemView4;
                                    nBPFeedCommentsEvent2.onFirstPageLoadedHandler = new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        /* JADX WARN: Type inference failed for: r5v17, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPReplyVO>, java.util.ArrayList] */
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Boolean bool, Integer num) {
                                            aa<NBPFeedCommentsView> aaVar;
                                            NBPFeedCommentsView b16;
                                            NBPCommentVO nBPCommentVO;
                                            Object obj;
                                            boolean booleanValue = bool.booleanValue();
                                            num.intValue();
                                            NBPFeedCommentsData nBPFeedCommentsData2 = NBPArticleFeedModel.this.commentsData;
                                            String str = nBPFeedCommentsData2.replyCommentId;
                                            String str2 = nBPFeedCommentsData2.replyReplyId;
                                            KLog kLog = KLog.INSTANCE;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("onFirstPageLoaded: ");
                                            sb5.append(booleanValue);
                                            sb5.append(", ");
                                            sb5.append(str);
                                            sb5.append(", ");
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(sb5, str2, kLog, "NBPArticleFeedItemView");
                                            if (booleanValue) {
                                                if (!(str == null || str.length() == 0) && (aaVar = nBPArticleFeedDetailVM10.topFeedCommentsViewRef) != null && (b16 = aaVar.b()) != null) {
                                                    NBPFeedCommentsViewModel nBPFeedCommentsViewModel = b16.f114213vm;
                                                    Pair pair = null;
                                                    if (nBPFeedCommentsViewModel == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                                                        nBPFeedCommentsViewModel = null;
                                                    }
                                                    Iterator<NBPCommentVO> it = nBPFeedCommentsViewModel.getCommentItems().iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            nBPCommentVO = null;
                                                            break;
                                                        }
                                                        nBPCommentVO = it.next();
                                                        if (Intrinsics.areEqual(nBPCommentVO.f114212id, str)) {
                                                            break;
                                                        }
                                                    }
                                                    NBPCommentVO nBPCommentVO2 = nBPCommentVO;
                                                    if (nBPCommentVO2 != null) {
                                                        Iterator it5 = nBPCommentVO2.replies.iterator();
                                                        while (true) {
                                                            if (!it5.hasNext()) {
                                                                obj = null;
                                                                break;
                                                            }
                                                            obj = it5.next();
                                                            if (Intrinsics.areEqual(((NBPReplyVO) obj).f114214id, str2)) {
                                                                break;
                                                            }
                                                        }
                                                        NBPReplyVO nBPReplyVO = (NBPReplyVO) obj;
                                                        pair = new Pair(Long.valueOf(nBPCommentVO2.key), nBPReplyVO != null ? Long.valueOf(nBPReplyVO.key) : null);
                                                    }
                                                    if (pair != null) {
                                                        NBPArticleFeedItemView.access$scrollToComment(nBPArticleFeedItemView5, ((Number) pair.component1()).longValue(), (Long) pair.component2());
                                                    }
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final NBPArticleFeedItemView nBPArticleFeedItemView6 = nBPArticleFeedItemView4;
                                    nBPFeedCommentsEvent2.onAddedHandler = new Function2<NBPCommentVO, NBPReplyVO, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.3.2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(NBPCommentVO nBPCommentVO, NBPReplyVO nBPReplyVO) {
                                            NBPReplyVO nBPReplyVO2 = nBPReplyVO;
                                            NBPArticleFeedItemView.access$scrollToComment(NBPArticleFeedItemView.this, nBPCommentVO.key, nBPReplyVO2 != null ? Long.valueOf(nBPReplyVO2.key) : null);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM11 = nBPArticleFeedDetailVM9;
                                    final NBPArticleFeedModel nBPArticleFeedModel18 = NBPArticleFeedModel.this;
                                    nBPFeedCommentsEvent2.onCommentClickHandler = new Function1<CommentClickInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.3.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(CommentClickInfo commentClickInfo) {
                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = NBPArticleFeedDetailVM.this;
                                            n feed2 = nBPArticleFeedModel18.getFeed();
                                            String str = feed2 != null ? feed2.f425193d : null;
                                            KProperty<Object>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                            nBPArticleFeedDetailVM12.dtReportElementClick(str, "em_nearby_comment_panel", null);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final NBPArticleFeedDetailVM nBPArticleFeedDetailVM12 = nBPArticleFeedDetailVM9;
                                    final NBPArticleFeedModel nBPArticleFeedModel19 = NBPArticleFeedModel.this;
                                    VisibilityEventKt.b(nBPFeedCommentsEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.13.3.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            NBPArticleFeedDetailVM nBPArticleFeedDetailVM13 = NBPArticleFeedDetailVM.this;
                                            n feed2 = nBPArticleFeedModel19.getFeed();
                                            String str = feed2 != null ? feed2.f425193d : null;
                                            KProperty<Object>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                            nBPArticleFeedDetailVM13.dtReportElementImp(str, "em_nearby_comment_panel", null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final NBPArticleFeedModel nBPArticleFeedModel14 = NBPArticleFeedModel.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.14
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPArticleFeedModel nBPArticleFeedModel15 = NBPArticleFeedModel.this;
                        return Boolean.valueOf(((Boolean) nBPArticleFeedModel15.showDivider$delegate.getValue(nBPArticleFeedModel15, NBPArticleFeedModel.$$delegatedProperties[2])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.15
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.15.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.15.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedModel nBPArticleFeedModel15 = NBPArticleFeedModel.this;
                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.16
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPArticleFeedModel.this.likeData.getDoubleClickAnimation());
                    }
                };
                final NBPArticleFeedModel nBPArticleFeedModel16 = NBPArticleFeedModel.this;
                ConditionViewKt.c(viewContainer2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1.17
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedModel nBPArticleFeedModel17 = NBPArticleFeedModel.this;
                        ay.a(conditionView, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.17.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ax axVar) {
                                ax axVar2 = axVar;
                                final NBPArticleFeedModel nBPArticleFeedModel18 = NBPArticleFeedModel.this;
                                axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.17.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(av avVar) {
                                        av avVar2 = avVar;
                                        avVar2.positionAbsolute();
                                        ClickLocation clickLocation = NBPArticleFeedModel.this.likeData.doubleClickLocation;
                                        avVar2.m142left(clickLocation.f114210x - 53.5f);
                                        avVar2.m150top(clickLocation.f114211y - 67.5f);
                                        avVar2.src("https://image.superqqshow.qq.com/files/3c6784d9_ZBp37qLwtTO.json");
                                        avVar2.size(107.0f, 135.0f);
                                        avVar2.m154zIndex(1);
                                        avVar2.transform(new com.tencent.kuikly.core.base.t(Random.INSTANCE.nextInt(-10, 11), 0.0f, 0.0f, 6, null));
                                        avVar2.h(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedModel nBPArticleFeedModel19 = NBPArticleFeedModel.this;
                                axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.17.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aw awVar) {
                                        aw awVar2 = awVar;
                                        final NBPArticleFeedModel nBPArticleFeedModel20 = NBPArticleFeedModel.this;
                                        FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.17.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPArticleFeedModel.this.likeData.setDoubleClickAnimation(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPArticleFeedModel nBPArticleFeedModel21 = NBPArticleFeedModel.this;
                                        awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView.body.1.17.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPArticleFeedModel.this.likeData.setDoubleClickAnimation(false);
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
        return new NBPArticleFeedItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
