package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.InteractViewModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Like;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GCPInteractView extends ComposeView<GCPInteractAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPInteractAttr access$getAttr(GCPInteractView gCPInteractView) {
        return (GCPInteractAttr) gCPInteractView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleLikeAnimationEnd(GCPInteractView gCPInteractView) {
        gCPInteractView.getClass();
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("handleLikeAnimationEnd flag:");
        m3.append(((GCPInteractAttr) gCPInteractView.getAttr()).getLikeAnimationFlag());
        currentBridgeModule.log(m3.toString());
        if (((GCPInteractAttr) gCPInteractView.getAttr()).getLikeAnimationFlag() != 0 && ((GCPInteractAttr) gCPInteractView.getAttr()).getLikeAnimationFlag() <= 3) {
            GCPInteractAttr gCPInteractAttr = (GCPInteractAttr) gCPInteractView.getAttr();
            gCPInteractAttr.setLikeAnimationFlag(gCPInteractAttr.getLikeAnimationFlag() + 1);
        } else {
            ((GCPInteractAttr) gCPInteractView.getAttr()).setLikeAnimationFlag(0);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(40.0f);
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                final GCPInteractView gCPInteractView = GCPInteractView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.paddingRight(10.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView2 = GCPInteractView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final GCPInteractView gCPInteractView3 = GCPInteractView.this;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        InteractViewModel interactViewModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel;
                                        if (((Number) interactViewModel.likeStatus$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[1])).intValue() == 0) {
                                            b.a.b(afVar2, "qecommerce_skin_icon_search_like_normal", false, 2, null);
                                        } else {
                                            b.a.b(afVar2, "qecommerce_skin_icon_search_like_selected", false, 2, null);
                                        }
                                        GCPInteractView gCPInteractView4 = GCPInteractView.this;
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("bindLikeAnimation flag:");
                                        m3.append(((GCPInteractAttr) gCPInteractView4.getViewAttr()).getLikeAnimationFlag());
                                        currentBridgeModule.log(m3.toString());
                                        int likeAnimationFlag = ((GCPInteractAttr) gCPInteractView4.getViewAttr()).getLikeAnimationFlag();
                                        if (likeAnimationFlag == 1) {
                                            d.a.a(afVar2, null, new u(0.8f, 0.8f), null, new a(0.5f, 0.5f), null, 21, null);
                                        } else if (likeAnimationFlag == 2) {
                                            d.a.a(afVar2, null, new u(1.2f, 1.2f), null, new a(0.5f, 0.5f), null, 21, null);
                                        } else if (likeAnimationFlag == 3) {
                                            d.a.a(afVar2, null, new u(1.0f, 1.0f), null, new a(0.5f, 0.5f), null, 21, null);
                                        }
                                        afVar2.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.1f, null, 2, null), (Object) Integer.valueOf(((GCPInteractAttr) gCPInteractView4.getViewAttr()).getLikeAnimationFlag()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPInteractView gCPInteractView4 = GCPInteractView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                                        imageEvent.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                GCPInteractView.access$handleLikeAnimationEnd(GCPInteractView.this);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView3 = GCPInteractView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GCPInteractView gCPInteractView4 = GCPInteractView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h blackTextColor;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ce.fontSize$default(ceVar2.fontWeight500(), 13.0f, null, 2, null);
                                        blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                        ceVar2.color(blackTextColor);
                                        ceVar2.lines(1);
                                        InteractViewModel interactViewModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel;
                                        ceVar2.value((String) interactViewModel.likeCountTxt$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[0]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView4 = GCPInteractView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        InteractViewModel interactViewModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel;
                                        boolean z16 = ((Number) interactViewModel.likeStatus$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[1])).intValue() == 0;
                                        if (z16) {
                                            GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel.setLikeStatus(1);
                                            Like like = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().gameFeed.like;
                                            if (like != null) {
                                                like.count++;
                                            }
                                            GCPInteractView.access$getAttr(GCPInteractView.this).setLikeAnimationFlag(1);
                                        } else {
                                            Like like2 = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().gameFeed.like;
                                            if (like2 != null) {
                                                like2.count--;
                                            }
                                            GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel.setLikeStatus(0);
                                        }
                                        Like like3 = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().gameFeed.like;
                                        int i3 = like3 != null ? like3.count : 0;
                                        if (i3 > 0) {
                                            GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel.setLikeCountTxt(Utils.INSTANCE.formatCountNumber(i3));
                                        } else {
                                            GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel.setLikeCountTxt("\u8d5e");
                                        }
                                        GameFeedModel gameFeedModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel();
                                        if (gameFeedModel != null) {
                                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                            String str = gameFeedModel.gameFeed.feedPbToken;
                                            currentBridgeModule.getClass();
                                            e eVar = new e();
                                            eVar.w("isPraise", z16);
                                            eVar.v("feedPbToken", str);
                                            currentBridgeModule.callNativeMethod("qCircleFeedLike", eVar, null);
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
                final GCPInteractView gCPInteractView2 = GCPInteractView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GCPInteractView gCPInteractView3 = GCPInteractView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.paddingRight(10.0f);
                                EcommerceExtKt.vr(tVar2, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON, new e().v("xsj_feed_id", GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().gameFeed.f114193id));
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_search_comment", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView4 = GCPInteractView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h blackTextColor;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ce.fontSize$default(ceVar2.fontWeight500(), 13.0f, null, 2, null);
                                        blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                        ceVar2.color(blackTextColor);
                                        ceVar2.lines(1);
                                        InteractViewModel interactViewModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel;
                                        ceVar2.value((String) interactViewModel.commentCountTxt$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[2]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final GCPInteractView gCPInteractView6 = GCPInteractView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GameFeedModel gameFeedModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel();
                                        if (gameFeedModel != null) {
                                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                            String str = gameFeedModel.gameFeed.feedPbToken;
                                            currentBridgeModule.getClass();
                                            e eVar = new e();
                                            eVar.v("feedPbToken", str);
                                            Unit unit = Unit.INSTANCE;
                                            currentBridgeModule.callNativeMethod("qCircleOpenComment", eVar, null);
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
                final GCPInteractView gCPInteractView3 = GCPInteractView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_search_share", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView4 = GCPInteractView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h blackTextColor;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ce.fontSize$default(ceVar2.fontWeight500(), 13.0f, null, 2, null);
                                        blackTextColor = SkinColor.INSTANCE.blackTextColor(BridgeManager.f117344a.u());
                                        ceVar2.color(blackTextColor);
                                        ceVar2.lines(1);
                                        InteractViewModel interactViewModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel().interactViewModel;
                                        ceVar2.value((String) interactViewModel.shareCountTxt$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[3]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPInteractView gCPInteractView5 = GCPInteractView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final GCPInteractView gCPInteractView6 = GCPInteractView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPInteractView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GameFeedModel gameFeedModel = GCPInteractView.access$getAttr(GCPInteractView.this).getGameFeedModel();
                                        if (gameFeedModel != null) {
                                            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("qqcircle_page_id", "10013");
                                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                            String str = gameFeedModel.gameFeed.feedPbToken;
                                            currentBridgeModule.getClass();
                                            e eVar = new e();
                                            eVar.v("feedPbToken", str);
                                            eVar.v("qCircleShareParam", m3);
                                            Unit unit = Unit.INSTANCE;
                                            currentBridgeModule.callNativeMethod("qCircleOpenSharePanel", eVar, null);
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
        return new GCPInteractAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
