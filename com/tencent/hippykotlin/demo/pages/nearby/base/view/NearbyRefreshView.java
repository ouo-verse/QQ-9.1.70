package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.RefreshViewState;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyRefreshView extends ComposeView<NearbyRefreshAttr, NearbyRefreshEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyRefreshView.class, "refreshText", "getRefreshText()Ljava/lang/String;", 0)};
    public String refreshingText = "\u63a8\u8350\u4e2d";
    public String defaultText = "\u4e0b\u62c9\u5237\u65b0";
    public String pullingToReadyText = "\u677e\u624b\u5373\u53ef\u5237\u65b0";
    public final ReadWriteProperty refreshText$delegate = c.a("\u4e0b\u62c9\u5237\u65b0");

    public NearbyRefreshView() {
        RefreshViewState refreshViewState = RefreshViewState.IDLE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyRefreshAttr access$getAttr(NearbyRefreshView nearbyRefreshView) {
        return (NearbyRefreshAttr) nearbyRefreshView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(65.0f);
                        mVar2.flexDirectionRow();
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NearbyRefreshView nearbyRefreshView = NearbyRefreshView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NearbyRefreshView.access$getAttr(NearbyRefreshView.this).getRefreshState();
                    }
                };
                final NearbyRefreshView nearbyRefreshView2 = NearbyRefreshView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.3

                    /* compiled from: P */
                    /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1$3$WhenMappings */
                    /* loaded from: classes31.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[RefreshViewState.values().length];
                            try {
                                iArr[RefreshViewState.REFRESHING.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[RefreshViewState.PULLING.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        int i3 = WhenMappings.$EnumSwitchMapping$0[NearbyRefreshView.access$getAttr(NearbyRefreshView.this).getRefreshState().ordinal()];
                        if (i3 == 1) {
                            NearbyRefreshView nearbyRefreshView3 = NearbyRefreshView.this;
                            nearbyRefreshView3.refreshText$delegate.setValue(nearbyRefreshView3, NearbyRefreshView.$$delegatedProperties[0], nearbyRefreshView3.refreshingText);
                        } else if (i3 != 2) {
                            NearbyRefreshView nearbyRefreshView4 = NearbyRefreshView.this;
                            nearbyRefreshView4.refreshText$delegate.setValue(nearbyRefreshView4, NearbyRefreshView.$$delegatedProperties[0], nearbyRefreshView4.defaultText);
                        } else {
                            NearbyRefreshView nearbyRefreshView5 = NearbyRefreshView.this;
                            nearbyRefreshView5.refreshText$delegate.setValue(nearbyRefreshView5, NearbyRefreshView.$$delegatedProperties[0], nearbyRefreshView5.pullingToReadyText);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NearbyRefreshView nearbyRefreshView3 = NearbyRefreshView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NearbyRefreshView.access$getAttr(NearbyRefreshView.this).getRefreshState() == RefreshViewState.REFRESHING);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        i.a(conditionView, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(h hVar) {
                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(f fVar) {
                                        f fVar2 = fVar;
                                        fVar2.h(!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode());
                                        fVar2.transform(new u(0.8f, 0.8f));
                                        fVar2.marginRight(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyRefreshView nearbyRefreshView4 = NearbyRefreshView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NearbyRefreshView nearbyRefreshView5 = NearbyRefreshView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                NearbyRefreshView nearbyRefreshView6 = NearbyRefreshView.this;
                                ceVar2.text((String) nearbyRefreshView6.refreshText$delegate.getValue(nearbyRefreshView6, NearbyRefreshView.$$delegatedProperties[0]));
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.color(4289111718L);
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
        return new NearbyRefreshAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyRefreshEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
    }
}
