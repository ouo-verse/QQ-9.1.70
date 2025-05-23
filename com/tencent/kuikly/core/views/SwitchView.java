package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\b\u001a\u00020\u00052\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\b\u0006H\u0016J%\u0010\u000b\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\n\u00a2\u0006\u0002\b\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R+\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/views/SwitchView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/views/bt;", "Lcom/tencent/kuikly/core/views/bu;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "init", "attr", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "body", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "isOn", "()Z", "setOn", "(Z)V", "", "getWidth", "()F", "width", DomainData.DOMAIN_NAME, "height", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SwitchView extends ComposeView<bt, bu> {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118345b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SwitchView.class, "isOn", "isOn()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isOn = c01.c.a(Boolean.FALSE);

    /* JADX INFO: Access modifiers changed from: private */
    public final float getWidth() {
        return getFlexNode().U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ bt h(SwitchView switchView) {
        return (bt) switchView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ bu i(SwitchView switchView) {
        return (bu) switchView.getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float n() {
        return getFlexNode().K();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super bt, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        float K = getFlexNode().K();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (Float.isNaN(K) || Float.isNaN(Float.NaN) ? Float.isNaN(K) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - K) < 1.0E-5f) {
            ((bt) getAttr()).mo141height(31.0f);
        }
        float U = getFlexNode().U();
        if (Float.isNaN(U) || Float.isNaN(Float.NaN) ? !Float.isNaN(U) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - U) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            ((bt) getAttr()).mo153width(51.0f);
        }
        super.attr(init);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        final float thumbMargin = ((bt) getAttr()).getThumbMargin();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView$body$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                viewContainer.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                        invoke2(mVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                        Intrinsics.checkNotNullParameter(attr, "$this$attr");
                        attr.overflow(false);
                        attr.flexDirectionRow();
                        attr.alignItemsCenter();
                        attr.justifyContentFlexStart();
                    }
                });
                final SwitchView switchView = SwitchView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView$body$1.2
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
                        final SwitchView switchView2 = SwitchView.this;
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView.body.1.2.1
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
                                float n3;
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                attr.absolutePositionAllZero();
                                n3 = SwitchView.this.n();
                                attr.borderRadius(n3 / 2.0f);
                                if (SwitchView.h(SwitchView.this).m()) {
                                    attr.mo113backgroundColor(SwitchView.h(SwitchView.this).getOnColor());
                                } else {
                                    attr.mo113backgroundColor(SwitchView.h(SwitchView.this).getUnOnColor());
                                }
                                attr.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), (Object) Boolean.valueOf(SwitchView.h(SwitchView.this).m()));
                            }
                        });
                    }
                });
                final SwitchView switchView2 = SwitchView.this;
                viewContainer.event(new Function1<Event, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Event event) {
                        invoke2(event);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Event event) {
                        Intrinsics.checkNotNullParameter(event, "$this$event");
                        final SwitchView switchView3 = SwitchView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                invoke2(clickParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ClickParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                SwitchView.h(SwitchView.this).o(!SwitchView.h(SwitchView.this).m());
                                Function1<Boolean, Unit> h16 = SwitchView.i(SwitchView.this).h();
                                if (h16 != null) {
                                    h16.invoke(Boolean.valueOf(SwitchView.h(SwitchView.this).m()));
                                }
                            }
                        });
                    }
                });
                final SwitchView switchView3 = SwitchView.this;
                final float f16 = thumbMargin;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        final SwitchView switchView4 = SwitchView.this;
                        final float f17 = f16;
                        View.attr(new Function1<t, Unit>() { // from class: com.tencent.kuikly.core.views.SwitchView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                float n3;
                                float width;
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                n3 = SwitchView.this.n();
                                float f18 = n3 - (f17 * 2.0f);
                                attr.borderRadius(f18 / 2.0f);
                                attr.mo113backgroundColor(SwitchView.h(SwitchView.this).getThumbColor());
                                attr.size(f18, f18);
                                attr.margin(f17);
                                if (SwitchView.h(SwitchView.this).m()) {
                                    width = SwitchView.this.getWidth();
                                    attr.transform(new com.tencent.kuikly.core.base.y(((width - (f17 * 2.0f)) - f18) / f18, 0.0f, 0.0f, 0.0f, 12, null));
                                } else {
                                    attr.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                }
                                attr.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), (Object) Boolean.valueOf(SwitchView.h(SwitchView.this).m()));
                            }
                        });
                    }
                });
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public bt createAttr() {
        return new bt();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public bu createEvent() {
        return new bu();
    }
}
