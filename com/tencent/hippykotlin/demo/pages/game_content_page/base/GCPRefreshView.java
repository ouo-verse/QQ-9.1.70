package com.tencent.hippykotlin.demo.pages.game_content_page.base;

import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RefreshViewState;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class GCPRefreshView extends ComposeView<GCPRefreshAttr, GCPRefreshEvent> {
    public aa<APNGVView> apngViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPRefreshAttr access$getAttr(GCPRefreshView gCPRefreshView) {
        return (GCPRefreshAttr) gCPRefreshView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(48.0f);
                        mVar2.allCenter().flexDirectionRow();
                        mVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_backplate"));
                        return Unit.INSTANCE;
                    }
                });
                final GCPRefreshView gCPRefreshView = GCPRefreshView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GCPRefreshView gCPRefreshView2 = GCPRefreshView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GCPRefreshView.access$getAttr(GCPRefreshView.this).getRefreshViewState() == RefreshViewState.REFRESHING);
                            }
                        };
                        final GCPRefreshView gCPRefreshView3 = GCPRefreshView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GCPRefreshView gCPRefreshView4 = GCPRefreshView.this;
                                APNGViewKt.APNG(conditionView, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGVView aPNGVView) {
                                        APNGVView aPNGVView2 = aPNGVView;
                                        final GCPRefreshView gCPRefreshView5 = GCPRefreshView.this;
                                        aPNGVView2.ref(aPNGVView2, new Function1<aa<APNGVView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.2.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<APNGVView> aaVar) {
                                                GCPRefreshView.this.apngViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        aPNGVView2.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.2.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGAttr aPNGAttr) {
                                                APNGAttr aPNGAttr2 = aPNGAttr;
                                                aPNGAttr2.size(40.0f, 40.0f);
                                                aPNGAttr2.with("src", "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/rXujrsX8.png");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.2.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(40.0f, 40.0f);
                                                b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/YqE4iwpZ.png", false, 2, null);
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
                final GCPRefreshView gCPRefreshView2 = GCPRefreshView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GCPRefreshView gCPRefreshView3 = GCPRefreshView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView.body.1.3.1

                            /* renamed from: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1$3$1$WhenMappings */
                            /* loaded from: classes31.dex */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[RefreshViewState.values().length];
                                    try {
                                        iArr[RefreshViewState.PULLING.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[RefreshViewState.REFRESHING.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(52.0f, 11.5f);
                                int i3 = WhenMappings.$EnumSwitchMapping$0[GCPRefreshView.access$getAttr(GCPRefreshView.this).getRefreshViewState().ordinal()];
                                if (i3 == 1) {
                                    b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/z6oOxB6t.png", false, 2, null);
                                } else if (i3 != 2) {
                                    b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/w9HcPKlX.png", false, 2, null);
                                } else {
                                    afVar2.size(108.0f, 15.0f);
                                    b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/RHDKObfD.png", false, 2, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPRefreshView gCPRefreshView3 = GCPRefreshView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GCPRefreshView.access$getAttr(GCPRefreshView.this).getRefreshViewState();
                    }
                };
                final GCPRefreshView gCPRefreshView4 = GCPRefreshView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        aa<APNGVView> aaVar;
                        if (GCPRefreshView.access$getAttr(GCPRefreshView.this).getRefreshViewState() == RefreshViewState.REFRESHING && (aaVar = GCPRefreshView.this.apngViewRef) != null) {
                            aaVar.b();
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
        return new GCPRefreshAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPRefreshEvent();
    }
}
