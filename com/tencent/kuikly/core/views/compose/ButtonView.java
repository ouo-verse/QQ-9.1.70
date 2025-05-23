package com.tencent.kuikly.core.views.compose;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J%\u0010\u0010\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\n0\fj\u0002`\u000e\u00a2\u0006\u0002\b\u000fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/views/compose/ButtonView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/views/compose/a;", "Lcom/tencent/kuikly/core/views/compose/b;", "i", "j", "", AdMetricTag.EVENT_NAME, "", "param", "", "emit", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ButtonView extends ComposeView<a, b> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ a h(ButtonView buttonView) {
        return (a) buttonView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        invoke2(mVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(m attr) {
                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                        attr.justifyContentCenter();
                        attr.alignItemsCenter();
                    }
                });
                if (ButtonView.h(ButtonView.this).getEnableForeground()) {
                    final ButtonView buttonView = ButtonView.this;
                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(!(ButtonView.h(ButtonView.this).j() == 0.0f));
                        }
                    };
                    final ButtonView buttonView2 = ButtonView.this;
                    ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                            invoke2(conditionView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ConditionView vif) {
                            Intrinsics.checkNotNullParameter(vif, "$this$vif");
                            final ButtonView buttonView3 = ButtonView.this;
                            w.a(vif, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView.body.1.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                                    invoke2(vVar);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(v View) {
                                    Intrinsics.checkNotNullParameter(View, "$this$View");
                                    final ButtonView buttonView4 = ButtonView.this;
                                    View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView.body.1.3.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                            invoke2(tVar);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(t attr) {
                                            Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                            h foregroundColor = ButtonView.h(ButtonView.this).getForegroundColor();
                                            if (foregroundColor != null) {
                                                attr.mo113backgroundColor(foregroundColor);
                                            }
                                            attr.absolutePositionAllZero();
                                            d.a.a(attr, null, new u(ButtonView.h(ButtonView.this).j(), 1.0f), null, new com.tencent.kuikly.core.base.a(0.0f, 0.0f), null, 21, null);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
                final Function1<af, Unit> k3 = ButtonView.h(ButtonView.this).k();
                if (k3 != null) {
                    ah.a(viewContainer, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView) {
                            invoke2(imageView);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ImageView Image) {
                            Intrinsics.checkNotNullParameter(Image, "$this$Image");
                            Image.attr(k3);
                        }
                    });
                }
                final Function1<ce, Unit> l3 = ButtonView.h(ButtonView.this).l();
                if (l3 != null) {
                    final ButtonView buttonView3 = ButtonView.this;
                    cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.kuikly.core.views.compose.ButtonView$body$1$5$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
                            invoke2(textView);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextView Text) {
                            Intrinsics.checkNotNullParameter(Text, "$this$Text");
                            if (ButtonView.h(ButtonView.this).k() != null) {
                                ((ce) Text.getViewAttr()).marginLeft(5.0f);
                            }
                            Text.attr(l3);
                        }
                    });
                }
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void emit(String eventName, Object param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        super.emit(eventName, param);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a createAttr() {
        return new a();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b createEvent() {
        return new b();
    }
}
