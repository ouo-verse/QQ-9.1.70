package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshFooter extends ComposeView<ECRefreshFooterAttr, ECRefreshFooterEvent> {
    public aa<FooterRefreshView> footerRefreshRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECRefreshFooterAttr access$getAttr(ECRefreshFooter eCRefreshFooter) {
        return (ECRefreshFooterAttr) eCRefreshFooter.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECRefreshFooterEvent access$getEvent(ECRefreshFooter eCRefreshFooter) {
        return (ECRefreshFooterEvent) eCRefreshFooter.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ECRefreshFooter eCRefreshFooter = ECRefreshFooter.this;
                z.a(viewContainer, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FooterRefreshView footerRefreshView) {
                        final FooterRefreshView footerRefreshView2 = footerRefreshView;
                        final ECRefreshFooter eCRefreshFooter2 = ECRefreshFooter.this;
                        footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                ECRefreshFooter.this.footerRefreshRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshFooter eCRefreshFooter3 = ECRefreshFooter.this;
                        footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(x xVar) {
                                x xVar2 = xVar;
                                ECRefreshFooterAttr access$getAttr = ECRefreshFooter.access$getAttr(ECRefreshFooter.this);
                                xVar2.k(((Number) access$getAttr.preloadDistance$delegate.getValue(access$getAttr, ECRefreshFooterAttr.$$delegatedProperties[2])).floatValue());
                                xVar2.allCenter();
                                xVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                        ECRefreshFooterAttr access$getAttr = ECRefreshFooter.access$getAttr(ECRefreshFooter.this);
                        FooterRefreshState footerRefreshState = (FooterRefreshState) access$getAttr.footerRefreshState$delegate.getValue(access$getAttr, ECRefreshFooterAttr.$$delegatedProperties[1]);
                        final ECRefreshFooter eCRefreshFooter4 = ECRefreshFooter.this;
                        companion.b(footerRefreshState, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.3

                            /* compiled from: P */
                            /* renamed from: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter$body$1$1$3$WhenMappings */
                            /* loaded from: classes31.dex */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[FooterRefreshState.values().length];
                                    try {
                                        iArr[FooterRefreshState.REFRESHING.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[FooterRefreshState.IDLE.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Boolean bool) {
                                bool.booleanValue();
                                ECRefreshFooterAttr access$getAttr2 = ECRefreshFooter.access$getAttr(ECRefreshFooter.this);
                                int i3 = WhenMappings.$EnumSwitchMapping$0[((FooterRefreshState) access$getAttr2.footerRefreshState$delegate.getValue(access$getAttr2, ECRefreshFooterAttr.$$delegatedProperties[1])).ordinal()];
                                if (i3 == 1) {
                                    ECRefreshFooter.access$getAttr(ECRefreshFooter.this).setFooterRefreshText("\u52a0\u8f7d\u66f4\u591a\u4e2d..");
                                    Function0<Unit> function0 = ECRefreshFooter.access$getEvent(ECRefreshFooter.this).onRefreshingHandlerFn;
                                    if (function0 != null) {
                                        function0.invoke();
                                    }
                                } else if (i3 == 2) {
                                    ECRefreshFooter.access$getAttr(ECRefreshFooter.this).setFooterRefreshText("\u52a0\u8f7d\u66f4\u591a");
                                    FooterRefreshView b16 = ECRefreshFooter.this.getFooterRefreshRef().b();
                                    if (b16 != null) {
                                        b16.t(FooterRefreshEndState.SUCCESS);
                                    }
                                } else if (i3 == 3) {
                                    ECRefreshFooter.access$getAttr(ECRefreshFooter.this).setFooterRefreshText(ECRefreshFooter.access$getAttr(ECRefreshFooter.this).footerNoMoreText);
                                    FooterRefreshView b17 = ECRefreshFooter.this.getFooterRefreshRef().b();
                                    if (b17 != null) {
                                        b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                                    }
                                } else if (i3 == 4) {
                                    ECRefreshFooter.access$getAttr(ECRefreshFooter.this).setFooterRefreshText("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
                                    FooterRefreshView b18 = ECRefreshFooter.this.getFooterRefreshRef().b();
                                    if (b18 != null) {
                                        b18.t(FooterRefreshEndState.FAILURE);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshFooter eCRefreshFooter5 = ECRefreshFooter.this;
                        footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(y yVar) {
                                y yVar2 = yVar;
                                final ECRefreshFooter eCRefreshFooter6 = ECRefreshFooter.this;
                                VisibilityEventKt.e(yVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        FooterRefreshView b16;
                                        FooterRefreshView b17 = ECRefreshFooter.this.getFooterRefreshRef().b();
                                        if ((b17 != null ? b17.getRefreshState() : null) == FooterRefreshState.IDLE && (b16 = ECRefreshFooter.this.getFooterRefreshRef().b()) != null) {
                                            b16.p();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECRefreshFooter eCRefreshFooter7 = ECRefreshFooter.this;
                                yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FooterRefreshState footerRefreshState2) {
                                        FooterRefreshState footerRefreshState3 = footerRefreshState2;
                                        Function1<? super FooterRefreshState, Unit> function1 = ECRefreshFooter.access$getEvent(ECRefreshFooter.this).refreshStateDidChangeHandlerFn;
                                        if (function1 != null) {
                                            function1.invoke(footerRefreshState3);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECRefreshFooter eCRefreshFooter8 = ECRefreshFooter.this;
                                yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        FooterRefreshView b16;
                                        FooterRefreshView b17 = ECRefreshFooter.this.getFooterRefreshRef().b();
                                        FooterRefreshState refreshState = b17 != null ? b17.getRefreshState() : null;
                                        if ((refreshState == FooterRefreshState.IDLE || refreshState == FooterRefreshState.FAILURE) && (b16 = ECRefreshFooter.this.getFooterRefreshRef().b()) != null) {
                                            b16.p();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshFooter eCRefreshFooter6 = ECRefreshFooter.this;
                        w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final ECRefreshFooter eCRefreshFooter7 = ECRefreshFooter.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(ECRefreshFooter.access$getAttr(ECRefreshFooter.this).footerHeight);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECRefreshFooter eCRefreshFooter8 = ECRefreshFooter.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ECRefreshFooter eCRefreshFooter9 = ECRefreshFooter.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.color(ECRefreshFooter.access$getAttr(ECRefreshFooter.this).footerTextColor);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ECRefreshFooterAttr access$getAttr2 = ECRefreshFooter.access$getAttr(ECRefreshFooter.this);
                                                ceVar2.text((String) access$getAttr2.footerRefreshText$delegate.getValue(access$getAttr2, ECRefreshFooterAttr.$$delegatedProperties[0]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshFooter eCRefreshFooter7 = ECRefreshFooter.this;
                        ConditionViewKt.c(footerRefreshView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ECRefreshFooterAttr access$getAttr2 = ECRefreshFooter.access$getAttr(ECRefreshFooter.this);
                                return Boolean.valueOf(((Boolean) access$getAttr2.showIphoneXSafeBottom$delegate.getValue(access$getAttr2, ECRefreshFooterAttr.$$delegatedProperties[3])).booleanValue() && footerRefreshView2.getPager().getPageData().getIsIphoneX());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.7
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter.body.1.1.7.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                tVar2.mo141height(34.0f);
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
        return new ECRefreshFooterAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECRefreshFooterEvent();
    }

    public final aa<FooterRefreshView> getFooterRefreshRef() {
        aa<FooterRefreshView> aaVar = this.footerRefreshRef;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("footerRefreshRef");
        return null;
    }
}
