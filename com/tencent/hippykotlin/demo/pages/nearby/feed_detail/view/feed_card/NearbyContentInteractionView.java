package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
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
import kotlin.reflect.KProperty;
import n25.l;
import r25.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyContentInteractionView extends ComposeView<NearbyContentInteractionViewAttr, NearbyContentInteractionViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyContentInteractionViewAttr access$getAttr(NearbyContentInteractionView nearbyContentInteractionView) {
        return (NearbyContentInteractionViewAttr) nearbyContentInteractionView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.paddingLeft(16.0f);
                        mVar2.paddingRight(16.0f);
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                final NearbyContentInteractionView nearbyContentInteractionView = NearbyContentInteractionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.alignSelfStretch();
                                tVar2.alignItemsCenter();
                                tVar2.positionRelative();
                                tVar2.flexDirectionRow();
                                tVar2.mo153width(72.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView2 = NearbyContentInteractionView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NearbyContentInteractionView nearbyContentInteractionView3 = NearbyContentInteractionView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                                        new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1$2$2$1$report$1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                String str;
                                                e eVar;
                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                l statusFeed = viewModel != null ? viewModel.getStatusFeed() : null;
                                                String l3 = (statusFeed == null || (eVar = statusFeed.f418093e) == null) ? null : Long.valueOf(eVar.f430610d).toString();
                                                INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).dtReporter;
                                                if (iNearbyFeedDetailDTReporter == null) {
                                                    return null;
                                                }
                                                iNearbyFeedDetailDTReporter.dtReportElementClick((statusFeed == null || (str = statusFeed.f418092d) == null) ? "" : str, l3 == null ? "" : l3, "em_nearby_like_btn", false);
                                                return Unit.INSTANCE;
                                            }
                                        }.invoke();
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        if (viewModel != null) {
                                            KProperty<Object>[] kPropertyArr = NearbyFDPStatusContentViewModel.$$delegatedProperties;
                                            viewModel.onClickLikeBtn(false, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView3 = NearbyContentInteractionView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginLeft(4.0f);
                                        tVar2.size(24.0f, 24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPLikeData nBPLikeData;
                                        NBPLikeData.IconData icon;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        if (viewModel == null || (nBPLikeData = viewModel.likeData) == null || (icon = nBPLikeData.getIcon()) == null) {
                                            return null;
                                        }
                                        return Boolean.valueOf(icon.iconAnimation);
                                    }
                                };
                                final NearbyContentInteractionView nearbyContentInteractionView5 = NearbyContentInteractionView.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NearbyContentInteractionView nearbyContentInteractionView6 = NearbyContentInteractionView.this;
                                        ay.a(conditionView, new Function1<ax, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ax axVar) {
                                                ax axVar2 = axVar;
                                                final NearbyContentInteractionView nearbyContentInteractionView7 = NearbyContentInteractionView.this;
                                                axVar2.attr(new Function1<av, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(av avVar) {
                                                        String str;
                                                        String str2;
                                                        NBPLikeData nBPLikeData;
                                                        av avVar2 = avVar;
                                                        avVar2.positionAbsolute();
                                                        avVar2.m142left(-8.0f);
                                                        avVar2.m150top(-8.0f);
                                                        boolean z16 = false;
                                                        avVar2.h(false);
                                                        avVar2.size(40.0f, 40.0f);
                                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                        NBPLikeData.IconData icon = (viewModel == null || (nBPLikeData = viewModel.likeData) == null) ? null : nBPLikeData.getIcon();
                                                        if (icon != null && icon.isLiked) {
                                                            z16 = true;
                                                        }
                                                        if (z16) {
                                                            if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_55FdJSnLGKG.json";
                                                            } else {
                                                                str2 = "https://image.superqqshow.qq.com/files/3c6784d9_7tYJi6oYD-1.json";
                                                            }
                                                            avVar2.src(str2);
                                                        } else {
                                                            if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_c983EAY1cWP.json";
                                                            } else {
                                                                str = "https://image.superqqshow.qq.com/files/3c6784d9_KCsvbm0RM64.json";
                                                            }
                                                            avVar2.src(str);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyContentInteractionView nearbyContentInteractionView8 = NearbyContentInteractionView.this;
                                                axVar2.event(new Function1<aw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aw awVar) {
                                                        aw awVar2 = awVar;
                                                        final NearbyContentInteractionView nearbyContentInteractionView9 = NearbyContentInteractionView.this;
                                                        FrameEventKt.g(awVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPLikeData nBPLikeData;
                                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                                if (viewModel != null && (nBPLikeData = viewModel.likeData) != null) {
                                                                    nBPLikeData.resetIconAnimation();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyContentInteractionView nearbyContentInteractionView10 = NearbyContentInteractionView.this;
                                                        awVar2.i(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPLikeData nBPLikeData;
                                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                                if (viewModel != null && (nBPLikeData = viewModel.likeData) != null) {
                                                                    nBPLikeData.startIconAnimation();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyContentInteractionView nearbyContentInteractionView11 = NearbyContentInteractionView.this;
                                                        awVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.3.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NBPLikeData nBPLikeData;
                                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                                if (viewModel != null && (nBPLikeData = viewModel.likeData) != null) {
                                                                    nBPLikeData.resetIconAnimation();
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
                                final NearbyContentInteractionView nearbyContentInteractionView6 = NearbyContentInteractionView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NearbyContentInteractionView nearbyContentInteractionView7 = NearbyContentInteractionView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                NBPLikeData nBPLikeData;
                                                NBPLikeData nBPLikeData2;
                                                af afVar2 = afVar;
                                                afVar2.m142left(-8.0f);
                                                afVar2.m150top(-8.0f);
                                                afVar2.size(40.0f, 40.0f);
                                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                boolean z16 = false;
                                                if ((viewModel == null || (nBPLikeData2 = viewModel.likeData) == null) ? false : nBPLikeData2.staticLiked()) {
                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAn1BMVEUAAADlJVLkKVj3U1ziI1n5V1vnLVrhIVreGVrlKlr6VFrfGlr7WFriHFvxQ1r7WFv5U1r4VFr2TVj1UFzwQlr4VVr0SlvaFFnsOlr6WVruPVrrN1nbE1ntPVnpM1ruO1r6V1vwQFruPFr0SVrsOFr3UFryRFr2TFrnLFrrNFrlJ1r5U1roMFrhIFrjJFr6V1rqMlrgG1rdGFrzRlrcFFo3ph39AAAAIXRSTlMAECAgz+/f38+gX++fL7+8f29DMO/fn1/fz891v6+QX4++ml+yAAACL0lEQVRo3u2SfXOiMBCHgx7tlXoqWFtbr+0JBd9AsPb7f7bbJTCL9mUwG/lrn5BfNlmHZ8ioBEEQBEEQBEEQBEEQfsDxB49unrujgdc/6XhlJ38c+dCxTDDKGwwagsnAzYmRZ1XbJ+2J2vl32pla/GrPzbcABGaORT6dlJ873eotJKB7Y1ve8fZL4FID98vO2KY33saxDki9+AHWGmziUjbtmL3YAJ/v7U9NxG6fLb6Pl0hchh66ijHrpj7EqI6GXO9kaUjA/WB4RxRFSwACoD1W1YMHdRXpZH5yPzLGYYk9c7HPu+kIOESHAyaEnlSUEzOhX+ECxT1LPEzO40DlE0t8lxhzxxIvgCTBgFEtelsV2K5WPXXgwha3B6UE76oXxvCuemYu5v25nsMwXIRNWh0gzyzxPDTmlSWemIt7isXwrTXh0W6oeMzfDHlVTGb0rjU+R6xh0AYnBlYzxSVYG9FTbF7gNQVMSD2LegsLFXWt93PFx3kqzuZF2cC5Sos0hQl5QlEtVR+izBtlh95Vehbk5ZtXKQwNlVTUD4Jem+bWgLdbM3ltmzc4mqxWzY0+AK9186YFv5R9eteb3e6zanfkdRRg3wyaHyGvbTPLyzdnOLJsB4GlPruMl8zZtzC8HDN6L8qfW4aXad7v9xlMnRW/L+klM8HwMs3vXXjJ/H5ER140M7w8Hj5A+AF05iVzTUdeMt9q719HdUzv5hq0D0oQBEEQBEEQBEEQBKE9/wFFiEq+642ELgAAAABJRU5ErkJggg==", false, 2, null);
                                                } else {
                                                    if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                                        str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAM1BMVEUAAAAKCw4ICAsLDA4LCw0QEBALDA4KDA4LDA0KCw0KCwsJCw4KDA0KDAwMDA4LDA4LDA4GWpimAAAAEHRSTlMA3yDvXhDPf7+gMHCvQJCPzyHOpQAAAcFJREFUaN7t2NlugzAQhWG8ADZLMu//tC2E9KQ0oOJx5ur8V1Wt6IsXFqVhjDHGGGOMMcYYO6kdcxdEQsrR70biOiLdNPrq7JzkpfwCDDkISrEq68Hu6Pa+H3EVZx23ObmUp/T8e1in62QtpJxTt9F9Lbd/SM8NHPqHFr83IKxqv434mCBXckP89a+wysODbRsUXTU5rmem3W26W82fJUftbRkZVSSI/Pfi6nCU3qxQ0J+wvFygDYIMd9e0LJHWHQ4vkNadjchcYcLxaBOOLtmon7JfJnw4eLiRyza0uiNddkJHfEyx0kPZQmUVnERCU1DApVBWKDwlHb5wWSIylW6RCi7dqwmw7VIn7VI7XMa2h2squxP43dkouxPEsvtOVD8jUtEOifLBmAoeNHhIKNc6lUxY/Zrrrr9C3fFIUzTL1a/fC3ZY0+2i3Nd4zcTLVbzk3rQoXqFkvuBmPYo33DBYu5CtXcjWLmRrF7KxC9mfungIV5edP3fb6ixkaxeytQvZzoUc3soj3E81QEbx4y5kaxeytQvZ2oVs7UI2dzfOeWMX8pRMXchi7+KX5ATXKJ/d+ns8Y4wxxhhjjDHG2P/7AkJjInCMtIwFAAAAAElFTkSuQmCC";
                                                    } else {
                                                        str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAMAAAAOusbgAAAAOVBMVEUAAAD///////////////////////////////////////////////////////////////////////8KOjVvAAAAEnRSTlMA3yDvEM9/v18woGCfr0JwkG+63umMAAABw0lEQVRo3u3Y23KCMBSFYZMACUd1v//DtkSdZakwJTvdV+u/6pRpP8kBMl4YY4wxxhhjjDHGDmruUxtEQpyS31wZ8xVp57uvzi5R3pregH4IgmKqynqwG7q5ySZX8a5TeP7POM3x9XOfb9fJ2joBU2yfdFfL7R7SawL77qGl7wkIWe2eV/wYIVdyQ/rxq5Dl/sE2FzS6avKY10yzmXSXzeeQv8KkX1UkiOH35mqxlD6MUNCvsGHdoBcEGe6meR0irdvvbpDGHV2RpcINp71J2Nuyi/6W/XrDuxd3J3Kdhka3pMtW6BV/phjpvmygJhUcRcKloICtUFYoXCUtPnBZIjKXTpEKLp2rGbDtUEftUDtsY9vFNZc9CfxmbZQ9Ccay505SvyNi0QyJ8sUYS140Iz6uaqxjyQ2rj7nu/BHqhleaokXOfvxOMMOabiflrsYxE4erdMq9aVEcoWQ54Q56FCfc0Fu7kK1dyNYuZGsXsrEL2R+6eAlXl50/dpvqLGRrF7K1C9nOhRw+ygnuf9VDtnQhW7uQrV3I1i5kaxeymYtGybKxC3mOpi5kMXQhB8lFuEb5weXv4xljjDHGGGOMMcb+3hc8HyZzil1rvAAAAABJRU5ErkJggg==";
                                                    }
                                                    b.a.b(afVar2, str, false, 2, null);
                                                }
                                                NearbyFDPStatusContentViewModel viewModel2 = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                                if (viewModel2 != null && (nBPLikeData = viewModel2.likeData) != null && nBPLikeData.showStatic()) {
                                                    z16 = true;
                                                }
                                                afVar2.m152visibility(z16);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                        NBPLikeNumberViewKt.NBPLikeNumber(vVar2, new Function1<NBPLikeNumberView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPLikeNumberView nBPLikeNumberView) {
                                final NearbyContentInteractionView nearbyContentInteractionView5 = NearbyContentInteractionView.this;
                                nBPLikeNumberView.attr(new Function1<NBPLikeNumAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPLikeNumAttr nBPLikeNumAttr) {
                                        h m3;
                                        NBPLikeNumAttr nBPLikeNumAttr2 = nBPLikeNumAttr;
                                        nBPLikeNumAttr2.mo141height(18.0f);
                                        nBPLikeNumAttr2.marginLeft(4.0f);
                                        nBPLikeNumAttr2.overflow(true);
                                        nBPLikeNumAttr2.fontSize = 16.0f;
                                        nBPLikeNumAttr2.innerHeight = 18.0f;
                                        if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                            m3 = h.INSTANCE.b();
                                        } else {
                                            m3 = h.INSTANCE.m();
                                        }
                                        nBPLikeNumAttr2.color = m3;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        nBPLikeNumAttr2.setData(viewModel != null ? viewModel.likeData : null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyContentInteractionView nearbyContentInteractionView2 = NearbyContentInteractionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.alignSelfStretch();
                                tVar2.alignItemsCenter();
                                tVar2.positionRelative();
                                tVar2.flexDirectionRow();
                                tVar2.mo153width(72.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView3 = NearbyContentInteractionView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        boolean z16;
                                        String str;
                                        e eVar;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        String str2 = null;
                                        l statusFeed = viewModel != null ? viewModel.getStatusFeed() : null;
                                        if (statusFeed != null && (eVar = statusFeed.f418093e) != null) {
                                            str2 = Long.valueOf(eVar.f430610d).toString();
                                        }
                                        if (statusFeed == null || str2 == null) {
                                            z16 = false;
                                        } else {
                                            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                            UserDataManager userDataManager = UserDataManager.INSTANCE;
                                            companion.openFeedCommentPage(1, 2, String.valueOf(userDataManager.getUserSelfInfo().tid), userDataManager.getUserSelfInfo().nickName, userDataManager.getUserSelfInfo().avatarUrl, str2, statusFeed.f418092d);
                                            z16 = true;
                                        }
                                        KLog kLog = KLog.INSTANCE;
                                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("did click content comment to open comment page result:", z16, kLog, "feed_detail_page");
                                        INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).dtReporter;
                                        if (iNearbyFeedDetailDTReporter != null) {
                                            if (statusFeed == null || (str = statusFeed.f418092d) == null) {
                                                str = "";
                                            }
                                            if (str2 == null) {
                                                str2 = "";
                                            }
                                            iNearbyFeedDetailDTReporter.dtReportElementClick(str, str2, "em_nearby_comment_btn", false);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NearbyContentInteractionView nearbyContentInteractionView5 = NearbyContentInteractionView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        h m3;
                                        af afVar2 = afVar;
                                        afVar2.q();
                                        afVar2.marginLeft(4.0f);
                                        afVar2.size(24.0f, 24.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hsSty9_X1fp.png", false, 2, null);
                                        if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                            m3 = h.INSTANCE.b();
                                        } else {
                                            m3 = h.INSTANCE.m();
                                        }
                                        afVar2.t(m3);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView5 = NearbyContentInteractionView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NearbyContentInteractionView nearbyContentInteractionView6 = NearbyContentInteractionView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h m3;
                                        String str;
                                        String str2;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                            m3 = h.INSTANCE.b();
                                        } else {
                                            m3 = h.INSTANCE.m();
                                        }
                                        ceVar2.color(m3);
                                        ceVar2.marginLeft(4.0f);
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        boolean z16 = false;
                                        if (viewModel != null && (str2 = (String) viewModel.commentCountStr$delegate.getValue(viewModel, NearbyFDPStatusContentViewModel.$$delegatedProperties[7])) != null) {
                                            if (str2.length() > 0) {
                                                z16 = true;
                                            }
                                        }
                                        if (z16) {
                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                            if (viewModel2 == null || (str = (String) viewModel2.commentCountStr$delegate.getValue(viewModel2, NearbyFDPStatusContentViewModel.$$delegatedProperties[7])) == null) {
                                                str = "";
                                            }
                                            TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                        } else {
                                            TextViewExtKt.textWithLineHeightFix(ceVar2, "\u8bc4\u8bba");
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
                final NearbyContentInteractionView nearbyContentInteractionView3 = NearbyContentInteractionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NearbyContentInteractionView nearbyContentInteractionView4 = NearbyContentInteractionView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                l statusFeed;
                                t tVar2 = tVar;
                                tVar2.alignSelfStretch();
                                tVar2.alignItemsCenter();
                                tVar2.positionRelative();
                                tVar2.flexDirectionRow();
                                tVar2.mo153width(72.0f);
                                NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                tVar2.m147opacity((viewModel == null || (statusFeed = viewModel.getStatusFeed()) == null) ? false : NearbyProUtilsKt.isCityWalk(statusFeed) ? 0.5f : 1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView5 = NearbyContentInteractionView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final NearbyContentInteractionView nearbyContentInteractionView6 = NearbyContentInteractionView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        boolean z16;
                                        String str;
                                        e eVar;
                                        l statusFeed;
                                        NearbyFDPStatusContentViewModel viewModel = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                        if ((viewModel == null || (statusFeed = viewModel.getStatusFeed()) == null) ? false : NearbyProUtilsKt.isCityWalk(statusFeed)) {
                                            IPagerIdKtxKt.getBridgeModule(uVar2).qToast("\u6b64\u7c7b\u578b\u52a8\u6001\u4e0d\u652f\u6301\u5206\u4eab", QToastMode.Info);
                                        } else {
                                            NearbyFDPStatusContentViewModel viewModel2 = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).getViewModel();
                                            String str2 = null;
                                            l statusFeed2 = viewModel2 != null ? viewModel2.getStatusFeed() : null;
                                            if (statusFeed2 != null) {
                                                QQNearbyModule.openFeedShare$default(QQNearbyModule.Companion.getInstance(), 2, 2, statusFeed2, null, false, null, 56);
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            KLog kLog = KLog.INSTANCE;
                                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                            CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("did click content comment to open share page result:", z16, kLog, "feed_detail_page");
                                            if (statusFeed2 != null && (eVar = statusFeed2.f418093e) != null) {
                                                str2 = Long.valueOf(eVar.f430610d).toString();
                                            }
                                            INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).dtReporter;
                                            if (iNearbyFeedDetailDTReporter != null) {
                                                if (statusFeed2 == null || (str = statusFeed2.f418092d) == null) {
                                                    str = "";
                                                }
                                                if (str2 == null) {
                                                    str2 = "";
                                                }
                                                iNearbyFeedDetailDTReporter.dtReportElementClick(str, str2, "em_nearby_share_btn", false);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView6 = NearbyContentInteractionView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NearbyContentInteractionView nearbyContentInteractionView7 = NearbyContentInteractionView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        h m3;
                                        af afVar2 = afVar;
                                        afVar2.q();
                                        afVar2.marginLeft(4.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Ig7vZhM2U_j.png", false, 2, null);
                                        afVar2.size(24.0f, 24.0f);
                                        if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                            m3 = h.INSTANCE.b();
                                        } else {
                                            m3 = h.INSTANCE.m();
                                        }
                                        afVar2.t(m3);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyContentInteractionView nearbyContentInteractionView7 = NearbyContentInteractionView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NearbyContentInteractionView nearbyContentInteractionView8 = NearbyContentInteractionView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyContentInteractionView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h m3;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        if (NearbyContentInteractionView.access$getAttr(NearbyContentInteractionView.this).isDarkStyle) {
                                            m3 = h.INSTANCE.b();
                                        } else {
                                            m3 = h.INSTANCE.m();
                                        }
                                        ceVar2.color(m3);
                                        ceVar2.marginLeft(4.0f);
                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u5206\u4eab");
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
        return new NearbyContentInteractionViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyContentInteractionViewEvent();
    }
}
