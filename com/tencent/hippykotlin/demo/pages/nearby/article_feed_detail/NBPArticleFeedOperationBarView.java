package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import p35.n;

/* loaded from: classes31.dex */
public final class NBPArticleFeedOperationBarView extends ComposeView<NBPArticleFeedOperationBarViewAttr, l> {
    static {
        Reflection.mutableProperty1(new MutablePropertyReference1Impl(NBPArticleFeedOperationBarView.class, "likeAnimationIng", "getLikeAnimationIng()Z", 0));
    }

    public NBPArticleFeedOperationBarView() {
        c.a(Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        NBPArticleFeedModel nBPArticleFeedModel = ((NBPArticleFeedOperationBarViewAttr) getAttr()).feedModel;
        final NBPArticleFeedModel nBPArticleFeedModel2 = null;
        if (nBPArticleFeedModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedModel");
            nBPArticleFeedModel = null;
        }
        final n feed = nBPArticleFeedModel.getFeed();
        if (feed == null) {
            feed = new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287);
        }
        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM = ((NBPArticleFeedOperationBarViewAttr) getAttr()).f114204vm;
        if (nBPArticleFeedDetailVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPArticleFeedDetailVM = null;
        }
        NBPArticleFeedModel nBPArticleFeedModel3 = ((NBPArticleFeedOperationBarViewAttr) getAttr()).feedModel;
        if (nBPArticleFeedModel3 != null) {
            nBPArticleFeedModel2 = nBPArticleFeedModel3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("feedModel");
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = nBPArticleFeedDetailVM;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                if (NBPArticleFeedModel.this.isHeadFeed) {
                                    tVar2.paddingLeft(13.0f);
                                    tVar2.paddingRight(10.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = nBPArticleFeedDetailVM2;
                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel7 = nBPArticleFeedModel6;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                        n feed2 = nBPArticleFeedModel7.getFeed();
                                        String str = feed2 != null ? feed2.f425193d : null;
                                        e eVar = new e();
                                        eVar.t("nearby_kl_action_type", !nBPArticleFeedModel7.likeData.getIcon().isLiked ? 1 : 0);
                                        Unit unit = Unit.INSTANCE;
                                        nBPArticleFeedDetailVM5.dtReportElementClick(str, "em_nearby_like_btn", eVar);
                                        NBPArticleFeedDetailVM.this.onLikeIconClick(nBPArticleFeedModel7, false, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginLeft(4.0f);
                                        tVar2.size(24.0f, 24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPArticleFeedModel.this.likeData.getIcon().iconAnimation);
                                    }
                                };
                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                        ay.a(conditionView, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ax axVar) {
                                                ax axVar2 = axVar;
                                                final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                                axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(av avVar) {
                                                        String str;
                                                        String str2;
                                                        av avVar2 = avVar;
                                                        avVar2.positionAbsolute();
                                                        avVar2.m142left(-8.0f);
                                                        avVar2.m150top(-8.0f);
                                                        avVar2.h(false);
                                                        avVar2.size(40.0f, 40.0f);
                                                        if (NBPArticleFeedModel.this.likeData.getIcon().isLiked) {
                                                            if (PageDataExtKt.isNightMode(avVar2.getPagerData())) {
                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_7tYJi6oYD-1.json";
                                                            } else {
                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_55FdJSnLGKG.json";
                                                            }
                                                            avVar2.src(str2);
                                                        } else {
                                                            if (PageDataExtKt.isNightMode(avVar2.getPagerData())) {
                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_KCsvbm0RM64.json";
                                                            } else {
                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_c983EAY1cWP.json";
                                                            }
                                                            avVar2.src(str);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPArticleFeedModel nBPArticleFeedModel12 = NBPArticleFeedModel.this;
                                                axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aw awVar) {
                                                        aw awVar2 = awVar;
                                                        final NBPArticleFeedModel nBPArticleFeedModel13 = NBPArticleFeedModel.this;
                                                        FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPArticleFeedModel.this.likeData.resetIconAnimation();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPArticleFeedModel nBPArticleFeedModel14 = NBPArticleFeedModel.this;
                                                        awVar2.i(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPArticleFeedModel.this.likeData.startIconAnimation();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPArticleFeedModel nBPArticleFeedModel15 = NBPArticleFeedModel.this;
                                                        awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.3.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPArticleFeedModel.this.likeData.resetIconAnimation();
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
                                final NBPArticleFeedModel nBPArticleFeedModel10 = NBPArticleFeedModel.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPArticleFeedModel nBPArticleFeedModel11 = NBPArticleFeedModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.m142left(-8.0f);
                                                afVar2.m150top(-8.0f);
                                                afVar2.size(40.0f, 40.0f);
                                                if (NBPArticleFeedModel.this.likeData.staticLiked()) {
                                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAn1BMVEUAAADlJVLkKVj3U1ziI1n5V1vnLVrhIVreGVrlKlr6VFrfGlr7WFriHFvxQ1r7WFv5U1r4VFr2TVj1UFzwQlr4VVr0SlvaFFnsOlr6WVruPVrrN1nbE1ntPVnpM1ruO1r6V1vwQFruPFr0SVrsOFr3UFryRFr2TFrnLFrrNFrlJ1r5U1roMFrhIFrjJFr6V1rqMlrgG1rdGFrzRlrcFFo3ph39AAAAIXRSTlMAECAgz+/f38+gX++fL7+8f29DMO/fn1/fz891v6+QX4++ml+yAAACL0lEQVRo3u2SfXOiMBCHgx7tlXoqWFtbr+0JBd9AsPb7f7bbJTCL9mUwG/lrn5BfNlmHZ8ioBEEQBEEQBEEQBEEQfsDxB49unrujgdc/6XhlJ38c+dCxTDDKGwwagsnAzYmRZ1XbJ+2J2vl32pla/GrPzbcABGaORT6dlJ873eotJKB7Y1ve8fZL4FID98vO2KY33saxDki9+AHWGmziUjbtmL3YAJ/v7U9NxG6fLb6Pl0hchh66ijHrpj7EqI6GXO9kaUjA/WB4RxRFSwACoD1W1YMHdRXpZH5yPzLGYYk9c7HPu+kIOESHAyaEnlSUEzOhX+ECxT1LPEzO40DlE0t8lxhzxxIvgCTBgFEtelsV2K5WPXXgwha3B6UE76oXxvCuemYu5v25nsMwXIRNWh0gzyzxPDTmlSWemIt7isXwrTXh0W6oeMzfDHlVTGb0rjU+R6xh0AYnBlYzxSVYG9FTbF7gNQVMSD2LegsLFXWt93PFx3kqzuZF2cC5Sos0hQl5QlEtVR+izBtlh95Vehbk5ZtXKQwNlVTUD4Jem+bWgLdbM3ltmzc4mqxWzY0+AK9186YFv5R9eteb3e6zanfkdRRg3wyaHyGvbTPLyzdnOLJsB4GlPruMl8zZtzC8HDN6L8qfW4aXad7v9xlMnRW/L+klM8HwMs3vXXjJ/H5ER140M7w8Hj5A+AF05iVzTUdeMt9q719HdUzv5hq0D0oQBEEQBEEQBEEQBKE9/wFFiEq+642ELgAAAABJRU5ErkJggg==";
                                                } else if (PageDataExtKt.isNightMode(afVar2.getPagerData())) {
                                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAOVBMVEUAAAD///////////////////////////////////////////////////////////////////////8KOjVvAAAAEnRSTlMA3yDvEM9/v18woGCfr0JwkG+63umMAAABw0lEQVRo3u3Y23KCMBSFYZMACUd1v//DtkSdZakwJTvdV+u/6pRpP8kBMl4YY4wxxhhjjDHGDmruUxtEQpyS31wZ8xVp57uvzi5R3pregH4IgmKqynqwG7q5ySZX8a5TeP7POM3x9XOfb9fJ2joBU2yfdFfL7R7SawL77qGl7wkIWe2eV/wYIVdyQ/rxq5Dl/sE2FzS6avKY10yzmXSXzeeQv8KkX1UkiOH35mqxlD6MUNCvsGHdoBcEGe6meR0irdvvbpDGHV2RpcINp71J2Nuyi/6W/XrDuxd3J3Kdhka3pMtW6BV/phjpvmygJhUcRcKloICtUFYoXCUtPnBZIjKXTpEKLp2rGbDtUEftUDtsY9vFNZc9CfxmbZQ9Ccay505SvyNi0QyJ8sUYS140Iz6uaqxjyQ2rj7nu/BHqhleaokXOfvxOMMOabiflrsYxE4erdMq9aVEcoWQ54Q56FCfc0Fu7kK1dyNYuZGsXsrEL2R+6eAlXl50/dpvqLGRrF7K1C9nOhRw+ygnuf9VDtnQhW7uQrV3I1i5kaxeymYtGybKxC3mOpi5kMXQhB8lFuEb5weXv4xljjDHGGGOMMcb+3hc8HyZzil1rvAAAAABJRU5ErkJggg==";
                                                } else {
                                                    str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAM1BMVEUAAAAKCw4ICAsLDA4LCw0QEBALDA4KDA4LDA0KCw0KCwsJCw4KDA0KDAwMDA4LDA4LDA4GWpimAAAAEHRSTlMA3yDvXhDPf7+gMHCvQJCPzyHOpQAAAcFJREFUaN7t2NlugzAQhWG8ADZLMu//tC2E9KQ0oOJx5ur8V1Wt6IsXFqVhjDHGGGOMMcYYO6kdcxdEQsrR70biOiLdNPrq7JzkpfwCDDkISrEq68Hu6Pa+H3EVZx23ObmUp/T8e1in62QtpJxTt9F9Lbd/SM8NHPqHFr83IKxqv434mCBXckP89a+wysODbRsUXTU5rmem3W26W82fJUftbRkZVSSI/Pfi6nCU3qxQ0J+wvFygDYIMd9e0LJHWHQ4vkNadjchcYcLxaBOOLtmon7JfJnw4eLiRyza0uiNddkJHfEyx0kPZQmUVnERCU1DApVBWKDwlHb5wWSIylW6RCi7dqwmw7VIn7VI7XMa2h2squxP43dkouxPEsvtOVD8jUtEOifLBmAoeNHhIKNc6lUxY/Zrrrr9C3fFIUzTL1a/fC3ZY0+2i3Nd4zcTLVbzk3rQoXqFkvuBmPYo33DBYu5CtXcjWLmRrF7KxC9mfungIV5edP3fb6ixkaxeytQvZzoUc3soj3E81QEbx4y5kaxeytQvZ2oVs7UI2dzfOeWMX8pRMXchi7+KX5ATXKJ/d+ns8Y4wxxhhjjDHG2P/7AkJjInCMtIwFAAAAAElFTkSuQmCC";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
                                                afVar2.m152visibility(NBPArticleFeedModel.this.likeData.showStatic());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                        NBPLikeNumberViewKt.NBPLikeNumber(vVar2, new Function1<NBPLikeNumberView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPLikeNumberView nBPLikeNumberView) {
                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                nBPLikeNumberView.attr(new Function1<NBPLikeNumAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPLikeNumAttr nBPLikeNumAttr) {
                                        NBPLikeNumAttr nBPLikeNumAttr2 = nBPLikeNumAttr;
                                        nBPLikeNumAttr2.mo141height(20.0f);
                                        nBPLikeNumAttr2.marginLeft(6.0f);
                                        nBPLikeNumAttr2.overflow(true);
                                        nBPLikeNumAttr2.fontSize = 16.0f;
                                        if (NBPArticleFeedModel.this.isHeadFeed) {
                                            nBPLikeNumAttr2.m144maxWidth(38.0f);
                                        } else {
                                            nBPLikeNumAttr2.mo153width(40.0f);
                                        }
                                        nBPLikeNumAttr2.innerHeight = 20.0f;
                                        nBPLikeNumAttr2.fontWeight = 400;
                                        nBPLikeNumAttr2.color = QUIToken.color$default("text_primary");
                                        nBPLikeNumAttr2.setData(NBPArticleFeedModel.this.likeData);
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
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = nBPArticleFeedDetailVM;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                if (NBPArticleFeedModel.this.isHeadFeed) {
                                    tVar2.paddingLeft(10.0f);
                                    tVar2.paddingRight(10.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM3;
                        final NBPArticleFeedModel nBPArticleFeedModel7 = NBPArticleFeedModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel7;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel8;
                                        KProperty<Object>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                        nBPArticleFeedDetailVM6.onCommentClick(nBPArticleFeedModel9, CommentPanelState.None);
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                        n feed2 = nBPArticleFeedModel8.getFeed();
                                        nBPArticleFeedDetailVM7.dtReportElementClick(feed2 != null ? feed2.f425193d : null, "em_nearby_comment_btn", null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        afVar2.o();
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hsSty9_X1fp.png", false, 2, null);
                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedModel nBPArticleFeedModel8 = NBPArticleFeedModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPArticleFeedModel nBPArticleFeedModel9 = NBPArticleFeedModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.fontWeight400();
                                        if (NBPArticleFeedModel.this.isHeadFeed) {
                                            ceVar2.m144maxWidth(38.0f);
                                        } else {
                                            ceVar2.mo153width(40.0f);
                                        }
                                        ceVar2.marginLeft(6.0f);
                                        if (NBPArticleFeedModel.this.getCommentCount() != 0) {
                                            int commentCount = NBPArticleFeedModel.this.getCommentCount();
                                            if (commentCount > 99) {
                                                str = "99+";
                                            } else if (commentCount > 0) {
                                                str = String.valueOf(commentCount);
                                            } else {
                                                str = "";
                                            }
                                        } else {
                                            str = "\u8bc4\u8bba";
                                        }
                                        TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final n nVar = feed;
                final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPArticleFeedModel nBPArticleFeedModel7 = nBPArticleFeedModel6;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                if (NBPArticleFeedModel.this.isHeadFeed) {
                                    tVar2.paddingLeft(10.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = nBPArticleFeedDetailVM4;
                        final NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel6;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel8;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
                                    
                                        if (com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt.isCityWalk(r1) == true) goto L8;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                        NBPArticleFeedModel nBPArticleFeedModel10 = nBPArticleFeedModel9;
                                        nBPArticleFeedDetailVM7.getClass();
                                        n feed2 = nBPArticleFeedModel10.getFeed();
                                        boolean z16 = feed2 != null;
                                        if (z16) {
                                            KLog.INSTANCE.i("NBPArticleFeedDetailVM", "onShareClick is citywalk");
                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u6b64\u7c7b\u578b\u52a8\u6001\u4e0d\u652f\u6301\u5206\u4eab", QToastMode.Info);
                                        } else {
                                            KLog kLog = KLog.INSTANCE;
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onShareClick: ");
                                            m3.append(nBPArticleFeedDetailVM7.appId);
                                            m3.append(", ");
                                            n feed3 = nBPArticleFeedModel10.getFeed();
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, feed3 != null ? feed3.f425193d : null, kLog, "NBPArticleFeedDetailVM");
                                            QQNearbyModule.openFeedShare$default(QQNearbyModule.Companion.getInstance(), nBPArticleFeedDetailVM7.appId, 2, null, nBPArticleFeedModel10.getFeed(), false, null, 52);
                                        }
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM8 = NBPArticleFeedDetailVM.this;
                                        n feed4 = nBPArticleFeedModel9.getFeed();
                                        nBPArticleFeedDetailVM8.dtReportElementClick(feed4 != null ? feed4.f425193d : null, "em_nearby_share_btn", null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final float f16 = NearbyProUtilsKt.isCityWalk(n.this) ? 0.5f : 1.0f;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final float f17 = f16;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        afVar2.o();
                                        afVar2.m147opacity(f17);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Ig7vZhM2U_j.png", false, 2, null);
                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (!nBPArticleFeedModel6.isHeadFeed) {
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final float f17 = f16;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedOperationBarView.body.1.4.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.color(QUIToken.color$default("text_primary"));
                                            ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                            ceVar2.lineHeight(20.0f);
                                            ceVar2.fontWeight400();
                                            ceVar2.marginLeft(6.0f);
                                            TextViewExtKt.textWithLineHeightFix(ceVar2, "\u5206\u4eab");
                                            ceVar2.m147opacity(f17);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPArticleFeedOperationBarViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
