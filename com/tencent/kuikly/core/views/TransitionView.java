package com.tencent.kuikly.core.views;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R+\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/views/TransitionView;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/ci;", "Lcom/tencent/kuikly/core/views/cj;", "Lcom/tencent/kuikly/core/pager/c;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "viewName", "", "didInit", "didRemoveFromParentView", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "setFrameToRenderView", "pagerEvent", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "eventData", "onPagerEvent", "", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "getDidLayout", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "didLayout", "b", "Z", "didSetFrame", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TransitionView extends ViewContainer<ci, cj> implements com.tencent.kuikly.core.pager.c {

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118351c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TransitionView.class, "didLayout", "getDidLayout()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty didLayout = c01.c.a(Boolean.FALSE);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean didSetFrame;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getDidLayout() {
        return ((Boolean) this.didLayout.getValue(this, f118351c[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ci h(TransitionView transitionView) {
        return (ci) transitionView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ cj j(TransitionView transitionView) {
        return (cj) transitionView.getEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean z16) {
        this.didLayout.setValue(this, f118351c[0], Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        final com.tencent.kuikly.core.base.b animationConfig = ((ci) getAttr()).getAnimationConfig();
        if (animationConfig == null) {
            animationConfig = b.Companion.p(com.tencent.kuikly.core.base.b.INSTANCE, 0.35f, 0.9f, 1.0f, null, 8, null);
        }
        attr(new Function1<ci, Unit>() { // from class: com.tencent.kuikly.core.views.TransitionView$didInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ci ciVar) {
                invoke2(ciVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ci attr) {
                boolean didLayout;
                boolean didLayout2;
                boolean didLayout3;
                boolean didLayout4;
                boolean didLayout5;
                boolean didLayout6;
                boolean didLayout7;
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.DIRECTION_FROM_BOTTOM) {
                    didLayout7 = TransitionView.this.getDidLayout();
                    if (didLayout7 && TransitionView.h(TransitionView.this).n()) {
                        attr.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        attr.transform(new com.tencent.kuikly.core.base.y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.DIRECTION_FROM_RIGHT) {
                    didLayout5 = TransitionView.this.getDidLayout();
                    if (didLayout5 && TransitionView.h(TransitionView.this).n()) {
                        attr.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        attr.transform(new com.tencent.kuikly.core.base.y(1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.DIRECTION_FROM_LEFT) {
                    didLayout4 = TransitionView.this.getDidLayout();
                    if (didLayout4 && TransitionView.h(TransitionView.this).n()) {
                        attr.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        attr.transform(new com.tencent.kuikly.core.base.y(-1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.DIRECTION_FROM_CENTER) {
                    didLayout3 = TransitionView.this.getDidLayout();
                    if (didLayout3 && TransitionView.h(TransitionView.this).n()) {
                        attr.transform(new com.tencent.kuikly.core.base.u(1.0f, 1.0f));
                    } else {
                        attr.transform(new com.tencent.kuikly.core.base.u(0.0f, 0.0f));
                    }
                } else if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.FADE_IN_OUT) {
                    didLayout2 = TransitionView.this.getDidLayout();
                    if (didLayout2 && TransitionView.h(TransitionView.this).n()) {
                        attr.m147opacity(1.0f);
                    } else {
                        attr.m147opacity(0.0f);
                    }
                } else if (TransitionView.h(TransitionView.this).getTransitionType() == TransitionType.CUSTOM) {
                    didLayout = TransitionView.this.getDidLayout();
                    if (didLayout && TransitionView.h(TransitionView.this).n()) {
                        Function1<Attr, Unit> m3 = TransitionView.h(TransitionView.this).m();
                        if (m3 != null) {
                            m3.invoke(attr);
                        }
                    } else {
                        Function1<Attr, Unit> l3 = TransitionView.h(TransitionView.this).l();
                        if (l3 != null) {
                            l3.invoke(attr);
                        }
                    }
                }
                com.tencent.kuikly.core.base.b bVar = animationConfig;
                didLayout6 = TransitionView.this.getDidLayout();
                attr.m134animation(bVar, (Object) Boolean.valueOf(didLayout6));
                attr.m134animation(animationConfig, (Object) Boolean.valueOf(TransitionView.h(TransitionView.this).n()));
            }
        });
        event(new Function1<cj, Unit>() { // from class: com.tencent.kuikly.core.views.TransitionView$didInit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cj cjVar) {
                invoke2(cjVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cj event) {
                Intrinsics.checkNotNullParameter(event, "$this$event");
                final TransitionView transitionView = TransitionView.this;
                event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.kuikly.core.views.TransitionView$didInit$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationCompletionParams animationCompletionParams) {
                        invoke2(animationCompletionParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnimationCompletionParams it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Function1<Boolean, Unit> h16 = TransitionView.j(TransitionView.this).h();
                        if (h16 != null) {
                            h16.invoke(Boolean.valueOf(TransitionView.h(TransitionView.this).n()));
                        }
                    }
                });
            }
        });
        getPager().addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public ci createAttr() {
        return new ci();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public cj createEvent() {
        return new cj();
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onPagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }

    @Override // com.tencent.kuikly.core.pager.c
    public void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.setFrameToRenderView(frame);
        if (this.didSetFrame) {
            return;
        }
        this.didSetFrame = true;
        if (getDidLayout()) {
            return;
        }
        TimerKt.d(16, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TransitionView$setFrameToRenderView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TransitionView.this.n(true);
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }
}
