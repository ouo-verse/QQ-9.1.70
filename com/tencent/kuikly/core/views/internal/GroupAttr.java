package com.tencent.kuikly.core.views.internal;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.highway.netprobe.EchoTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J+\u0010\u000e\u001a\u00020\u00042!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\tH\u0016J-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u001b\b\u0002\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u00a2\u0006\u0002\b\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R,\u0010%\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\b\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R,\u00100\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010&\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R,\u00103\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010&\u001a\u0004\b4\u0010(\"\u0004\b5\u0010*R,\u00106\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R,\u00109\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010&\u001a\u0004\b:\u0010(\"\u0004\b;\u0010*R?\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010A8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR*\u0010I\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`H8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010O\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`H8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/kuikly/core/views/internal/GroupAttr;", "Lcom/tencent/kuikly/core/base/m;", "", "pause", "", "screenFramePause", "Lcom/tencent/kuikly/core/base/h;", "color", "highlightBackgroundColor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isHighlight", "callback", "highlightCallback", "", "src", "Lcom/tencent/kuikly/core/views/af;", "Lkotlin/ExtensionFunctionType;", "imageAttr", "backgroundImage", "Lcom/tencent/kuikly/core/base/e;", "border", "borderBottom", "borderTop", "borderLeft", "borderRight", "Lcom/tencent/kuikly/core/views/internal/HitTestMode;", "hitTestMode", "Lcom/tencent/kuikly/core/views/ImageView;", "backgroundImageView", "Lcom/tencent/kuikly/core/views/ImageView;", "getBackgroundImageView$core_release", "()Lcom/tencent/kuikly/core/views/ImageView;", "setBackgroundImageView$core_release", "(Lcom/tencent/kuikly/core/views/ImageView;)V", "Lcom/tencent/kuikly/core/views/internal/GroupView;", "highlightBackgroundView", "Lcom/tencent/kuikly/core/views/internal/GroupView;", "getHighlightBackgroundView$core_release", "()Lcom/tencent/kuikly/core/views/internal/GroupView;", "setHighlightBackgroundView$core_release", "(Lcom/tencent/kuikly/core/views/internal/GroupView;)V", "Lcom/tencent/kuikly/core/base/h;", "getHighlightBackgroundColor$core_release", "()Lcom/tencent/kuikly/core/base/h;", "setHighlightBackgroundColor$core_release", "(Lcom/tencent/kuikly/core/base/h;)V", "borderBottomView", "getBorderBottomView$core_release", "setBorderBottomView$core_release", "borderTopView", "getBorderTopView$core_release", "setBorderTopView$core_release", "borderLeftView", "getBorderLeftView$core_release", "setBorderLeftView$core_release", "borderRightView", "getBorderRightView$core_release", "setBorderRightView$core_release", "Lkotlin/jvm/functions/Function1;", "getHighlightCallback$core_release", "()Lkotlin/jvm/functions/Function1;", "setHighlightCallback$core_release", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "delayTouchDownTask", "Lkotlin/jvm/functions/Function0;", "getDelayTouchDownTask$core_release", "()Lkotlin/jvm/functions/Function0;", "setDelayTouchDownTask$core_release", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/tencent/kuikly/core/timer/CallbackRef;", "delayTimeoutRef", "Ljava/lang/String;", "getDelayTimeoutRef$core_release", "()Ljava/lang/String;", "setDelayTimeoutRef$core_release", "(Ljava/lang/String;)V", "delayUpTimeoutRef", "getDelayUpTimeoutRef$core_release", "setDelayUpTimeoutRef$core_release", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class GroupAttr extends m {
    private ImageView backgroundImageView;
    private GroupView<?, ?> borderBottomView;
    private GroupView<?, ?> borderLeftView;
    private GroupView<?, ?> borderRightView;
    private GroupView<?, ?> borderTopView;
    private String delayTimeoutRef;
    private Function0<Unit> delayTouchDownTask;
    private String delayUpTimeoutRef;
    private h highlightBackgroundColor;
    private GroupView<?, ?> highlightBackgroundView;
    private Function1<? super Boolean, Unit> highlightCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public void backgroundImage(final String src, final Function1<? super af, Unit> imageAttr) {
        af afVar;
        Intrinsics.checkNotNullParameter(src, "src");
        ImageView imageView = this.backgroundImageView;
        if (imageView != null) {
            if (imageView == null || (afVar = (af) imageView.getViewAttr()) == null) {
                return;
            }
            b.a.b(afVar, src, false, 2, null);
            if (imageAttr != null) {
                imageAttr.invoke(afVar);
                return;
            }
            return;
        }
        AbstractBaseView<?, ?> view = view();
        if (view instanceof ViewContainer) {
            ImageView imageView2 = new ImageView();
            this.backgroundImageView = imageView2;
            ViewContainer viewContainer = (ViewContainer) view;
            viewContainer.addChild(imageView2, new Function1<ImageView, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$backgroundImage$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView3) {
                    invoke2(imageView3);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ImageView addChild) {
                    Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                    A viewAttr = addChild.getViewAttr();
                    String str = src;
                    Function1<af, Unit> function1 = imageAttr;
                    af afVar2 = (af) viewAttr;
                    afVar2.absolutePositionAllZero();
                    b.a.b(afVar2, str, false, 2, null);
                    afVar2.m154zIndex(-999);
                    if (function1 != null) {
                        function1.invoke(afVar2);
                    }
                }
            });
            viewContainer.insertDomSubView(imageView2, VirtualViewKt.a(viewContainer).indexOf(imageView2));
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.kuikly.core.base.Attr] */
    public void borderBottom(final e border) {
        List<DeclarativeBaseView<?, ?>> a16;
        Object firstOrNull;
        ?? viewAttr;
        Intrinsics.checkNotNullParameter(border, "border");
        GroupView<?, ?> groupView = this.borderBottomView;
        if (groupView == null) {
            AbstractBaseView<?, ?> view = view();
            if (view instanceof ViewContainer) {
                v vVar = new v();
                this.borderBottomView = vVar;
                ViewContainer viewContainer = (ViewContainer) view;
                viewContainer.addChild(vVar, new Function1<GroupView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderBottom$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GroupView<?, ?> groupView2) {
                        invoke2(groupView2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupView<?, ?> addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        Attr.absolutePosition$default((GroupAttr) addChild.getViewAttr(), 0.0f, 0.0f, 0.0f, 0.0f, 1, null).mo141height(e.this.getLineWidth()).overflow(true).m154zIndex(999);
                        final e eVar = e.this;
                        w.a(addChild, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderBottom$1$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(v vVar2) {
                                invoke2(vVar2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(v View) {
                                Intrinsics.checkNotNullParameter(View, "$this$View");
                                A viewAttr2 = View.getViewAttr();
                                e eVar2 = e.this;
                                Attr.absolutePosition$default((t) viewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null).mo141height(eVar2.getLineWidth() * 3).m136border(eVar2);
                            }
                        });
                    }
                });
                viewContainer.insertDomSubView(vVar, VirtualViewKt.a(viewContainer).indexOf(vVar));
                return;
            }
            return;
        }
        if (groupView == null || (a16 = VirtualViewKt.a(groupView)) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
        DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) firstOrNull;
        if (declarativeBaseView == null || (viewAttr = declarativeBaseView.getViewAttr()) == 0) {
            return;
        }
        viewAttr.m136border(border);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.kuikly.core.base.Attr] */
    public void borderLeft(final e border) {
        List<DeclarativeBaseView<?, ?>> a16;
        Object firstOrNull;
        ?? viewAttr;
        Intrinsics.checkNotNullParameter(border, "border");
        GroupView<?, ?> groupView = this.borderLeftView;
        if (groupView == null) {
            AbstractBaseView<?, ?> view = view();
            if (view instanceof ViewContainer) {
                v vVar = new v();
                this.borderLeftView = vVar;
                ViewContainer viewContainer = (ViewContainer) view;
                viewContainer.addChild(vVar, new Function1<GroupView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderLeft$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GroupView<?, ?> groupView2) {
                        invoke2(groupView2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupView<?, ?> addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        Attr.absolutePosition$default((GroupAttr) addChild.getViewAttr(), 0.0f, 0.0f, 0.0f, 0.0f, 8, null).mo153width(e.this.getLineWidth()).overflow(true).m154zIndex(999);
                        final e eVar = e.this;
                        w.a(addChild, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderLeft$1$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(v vVar2) {
                                invoke2(vVar2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(v View) {
                                Intrinsics.checkNotNullParameter(View, "$this$View");
                                A viewAttr2 = View.getViewAttr();
                                e eVar2 = e.this;
                                Attr.absolutePosition$default((t) viewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 8, null).mo153width(eVar2.getLineWidth() * 3).m136border(eVar2);
                            }
                        });
                    }
                });
                viewContainer.insertDomSubView(vVar, VirtualViewKt.a(viewContainer).indexOf(vVar));
                return;
            }
            return;
        }
        if (groupView == null || (a16 = VirtualViewKt.a(groupView)) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
        DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) firstOrNull;
        if (declarativeBaseView == null || (viewAttr = declarativeBaseView.getViewAttr()) == 0) {
            return;
        }
        viewAttr.m136border(border);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.kuikly.core.base.Attr] */
    public void borderRight(final e border) {
        List<DeclarativeBaseView<?, ?>> a16;
        Object firstOrNull;
        ?? viewAttr;
        Intrinsics.checkNotNullParameter(border, "border");
        GroupView<?, ?> groupView = this.borderRightView;
        if (groupView == null) {
            AbstractBaseView<?, ?> view = view();
            if (view instanceof ViewContainer) {
                v vVar = new v();
                this.borderRightView = vVar;
                ViewContainer viewContainer = (ViewContainer) view;
                viewContainer.addChild(vVar, new Function1<GroupView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderRight$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GroupView<?, ?> groupView2) {
                        invoke2(groupView2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupView<?, ?> addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        Attr.absolutePosition$default((GroupAttr) addChild.getViewAttr(), 0.0f, 0.0f, 0.0f, 0.0f, 2, null).mo153width(e.this.getLineWidth()).overflow(true).m154zIndex(999);
                        final e eVar = e.this;
                        w.a(addChild, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderRight$1$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(v vVar2) {
                                invoke2(vVar2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(v View) {
                                Intrinsics.checkNotNullParameter(View, "$this$View");
                                A viewAttr2 = View.getViewAttr();
                                e eVar2 = e.this;
                                Attr.absolutePosition$default((t) viewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 2, null).mo153width(eVar2.getLineWidth() * 3).m136border(eVar2);
                            }
                        });
                    }
                });
                viewContainer.insertDomSubView(vVar, VirtualViewKt.a(viewContainer).indexOf(vVar));
                return;
            }
            return;
        }
        if (groupView == null || (a16 = VirtualViewKt.a(groupView)) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
        DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) firstOrNull;
        if (declarativeBaseView == null || (viewAttr = declarativeBaseView.getViewAttr()) == 0) {
            return;
        }
        viewAttr.m136border(border);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.kuikly.core.base.Attr] */
    public void borderTop(final e border) {
        List<DeclarativeBaseView<?, ?>> a16;
        Object firstOrNull;
        ?? viewAttr;
        Intrinsics.checkNotNullParameter(border, "border");
        GroupView<?, ?> groupView = this.borderTopView;
        if (groupView == null) {
            AbstractBaseView<?, ?> view = view();
            if (view instanceof ViewContainer) {
                v vVar = new v();
                this.borderTopView = vVar;
                ViewContainer viewContainer = (ViewContainer) view;
                viewContainer.addChild(vVar, new Function1<GroupView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderTop$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GroupView<?, ?> groupView2) {
                        invoke2(groupView2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupView<?, ?> addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        Attr.absolutePosition$default((GroupAttr) addChild.getViewAttr(), 0.0f, 0.0f, 0.0f, 0.0f, 4, null).mo141height(e.this.getLineWidth()).overflow(true).m154zIndex(999);
                        final e eVar = e.this;
                        w.a(addChild, new Function1<v, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$borderTop$1$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(v vVar2) {
                                invoke2(vVar2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(v View) {
                                Intrinsics.checkNotNullParameter(View, "$this$View");
                                A viewAttr2 = View.getViewAttr();
                                e eVar2 = e.this;
                                Attr.absolutePosition$default((t) viewAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null).mo141height(eVar2.getLineWidth() * 3).m136border(eVar2);
                            }
                        });
                    }
                });
                viewContainer.insertDomSubView(vVar, VirtualViewKt.a(viewContainer).indexOf(vVar));
                return;
            }
            return;
        }
        if (groupView == null || (a16 = VirtualViewKt.a(groupView)) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
        DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) firstOrNull;
        if (declarativeBaseView == null || (viewAttr = declarativeBaseView.getViewAttr()) == 0) {
            return;
        }
        viewAttr.m136border(border);
    }

    /* renamed from: getBackgroundImageView$core_release, reason: from getter */
    public final ImageView getBackgroundImageView() {
        return this.backgroundImageView;
    }

    public final GroupView<?, ?> getBorderBottomView$core_release() {
        return this.borderBottomView;
    }

    public final GroupView<?, ?> getBorderLeftView$core_release() {
        return this.borderLeftView;
    }

    public final GroupView<?, ?> getBorderRightView$core_release() {
        return this.borderRightView;
    }

    public final GroupView<?, ?> getBorderTopView$core_release() {
        return this.borderTopView;
    }

    /* renamed from: getDelayTimeoutRef$core_release, reason: from getter */
    public final String getDelayTimeoutRef() {
        return this.delayTimeoutRef;
    }

    public final Function0<Unit> getDelayTouchDownTask$core_release() {
        return this.delayTouchDownTask;
    }

    /* renamed from: getDelayUpTimeoutRef$core_release, reason: from getter */
    public final String getDelayUpTimeoutRef() {
        return this.delayUpTimeoutRef;
    }

    /* renamed from: getHighlightBackgroundColor$core_release, reason: from getter */
    public final h getHighlightBackgroundColor() {
        return this.highlightBackgroundColor;
    }

    public final GroupView<?, ?> getHighlightBackgroundView$core_release() {
        return this.highlightBackgroundView;
    }

    public final Function1<Boolean, Unit> getHighlightCallback$core_release() {
        return this.highlightCallback;
    }

    @Override // com.tencent.kuikly.core.base.m
    public void highlightBackgroundColor(h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        if (this.highlightBackgroundView == null) {
            AbstractBaseView<?, ?> view = view();
            if (view instanceof ViewContainer) {
                v vVar = new v();
                this.highlightBackgroundView = vVar;
                ViewContainer viewContainer = (ViewContainer) view;
                viewContainer.addChild(vVar, new Function1<GroupView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GroupView<?, ?> groupView) {
                        invoke2(groupView);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupView<?, ?> addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        GroupAttr groupAttr = (GroupAttr) addChild.getViewAttr();
                        groupAttr.absolutePositionAllZero();
                        groupAttr.m151touchEnable(false);
                        groupAttr.m154zIndex(EchoTask.ECHO_SERVER_EXCEPTION);
                    }
                });
                viewContainer.insertDomSubView(vVar, VirtualViewKt.a(viewContainer).indexOf(vVar));
                Object viewEvent = view.getViewEvent();
                GroupEvent groupEvent = viewEvent instanceof GroupEvent ? (GroupEvent) viewEvent : null;
                if (groupEvent != null) {
                    groupEvent.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                            invoke2(touchParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TouchParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            final GroupAttr groupAttr = GroupAttr.this;
                            groupAttr.setDelayTouchDownTask$core_release(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$2$1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    GroupAttr groupAttr2;
                                    GroupView<?, ?> highlightBackgroundView$core_release = GroupAttr.this.getHighlightBackgroundView$core_release();
                                    if (highlightBackgroundView$core_release == null || (groupAttr2 = (GroupAttr) highlightBackgroundView$core_release.getViewAttr()) == null) {
                                        return;
                                    }
                                    h highlightBackgroundColor = GroupAttr.this.getHighlightBackgroundColor();
                                    if (highlightBackgroundColor == null) {
                                        highlightBackgroundColor = h.INSTANCE.j();
                                    }
                                    groupAttr2.mo113backgroundColor(highlightBackgroundColor);
                                }
                            });
                            String delayTimeoutRef = GroupAttr.this.getDelayTimeoutRef();
                            if (delayTimeoutRef != null) {
                                TimerKt.b(delayTimeoutRef);
                            }
                            String delayUpTimeoutRef = GroupAttr.this.getDelayUpTimeoutRef();
                            if (delayUpTimeoutRef != null) {
                                TimerKt.b(delayUpTimeoutRef);
                            }
                            final GroupAttr groupAttr2 = GroupAttr.this;
                            groupAttr2.setDelayTimeoutRef$core_release(TimerKt.d(150, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$2$1.4
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
                                    Function0<Unit> delayTouchDownTask$core_release = GroupAttr.this.getDelayTouchDownTask$core_release();
                                    if (delayTouchDownTask$core_release != null) {
                                        delayTouchDownTask$core_release.invoke();
                                    }
                                    GroupAttr.this.setDelayTouchDownTask$core_release(null);
                                }
                            }));
                        }
                    });
                    groupEvent.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$2$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                            invoke2(touchParams);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TouchParams it) {
                            GroupAttr groupAttr;
                            GroupAttr groupAttr2;
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (it.getIsCancelEvent()) {
                                String delayTimeoutRef = GroupAttr.this.getDelayTimeoutRef();
                                if (delayTimeoutRef != null) {
                                    TimerKt.b(delayTimeoutRef);
                                }
                                String delayUpTimeoutRef = GroupAttr.this.getDelayUpTimeoutRef();
                                if (delayUpTimeoutRef != null) {
                                    TimerKt.b(delayUpTimeoutRef);
                                }
                                GroupAttr.this.setDelayTouchDownTask$core_release(null);
                                GroupView<?, ?> highlightBackgroundView$core_release = GroupAttr.this.getHighlightBackgroundView$core_release();
                                if (highlightBackgroundView$core_release == null || (groupAttr2 = (GroupAttr) highlightBackgroundView$core_release.getViewAttr()) == null) {
                                    return;
                                }
                                groupAttr2.mo113backgroundColor(h.INSTANCE.j());
                                return;
                            }
                            if (GroupAttr.this.getDelayTouchDownTask$core_release() != null) {
                                Function0<Unit> delayTouchDownTask$core_release = GroupAttr.this.getDelayTouchDownTask$core_release();
                                if (delayTouchDownTask$core_release != null) {
                                    delayTouchDownTask$core_release.invoke();
                                }
                                GroupAttr.this.setDelayTouchDownTask$core_release(null);
                                String delayTimeoutRef2 = GroupAttr.this.getDelayTimeoutRef();
                                if (delayTimeoutRef2 != null) {
                                    TimerKt.b(delayTimeoutRef2);
                                }
                                final GroupAttr groupAttr3 = GroupAttr.this;
                                groupAttr3.setDelayUpTimeoutRef$core_release(TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightBackgroundColor$2$2.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        GroupAttr groupAttr4;
                                        GroupView<?, ?> highlightBackgroundView$core_release2 = GroupAttr.this.getHighlightBackgroundView$core_release();
                                        if (highlightBackgroundView$core_release2 == null || (groupAttr4 = (GroupAttr) highlightBackgroundView$core_release2.getViewAttr()) == null) {
                                            return;
                                        }
                                        groupAttr4.mo113backgroundColor(h.INSTANCE.j());
                                    }
                                }));
                                return;
                            }
                            GroupView<?, ?> highlightBackgroundView$core_release2 = GroupAttr.this.getHighlightBackgroundView$core_release();
                            if (highlightBackgroundView$core_release2 == null || (groupAttr = (GroupAttr) highlightBackgroundView$core_release2.getViewAttr()) == null) {
                                return;
                            }
                            groupAttr.mo113backgroundColor(h.INSTANCE.j());
                        }
                    });
                }
            }
        }
        this.highlightBackgroundColor = color;
    }

    @Override // com.tencent.kuikly.core.base.m
    public void highlightCallback(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.highlightCallback == null) {
            this.highlightCallback = callback;
            AbstractBaseView<?, ?> view = view();
            Object viewEvent = view != null ? view.getViewEvent() : null;
            GroupEvent groupEvent = viewEvent instanceof GroupEvent ? (GroupEvent) viewEvent : null;
            if (groupEvent != null) {
                groupEvent.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightCallback$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                        invoke2(touchParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TouchParams it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        callback.invoke(Boolean.TRUE);
                    }
                });
                groupEvent.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.kuikly.core.views.internal.GroupAttr$highlightCallback$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TouchParams touchParams) {
                        invoke2(touchParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TouchParams it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        callback.invoke(Boolean.FALSE);
                    }
                });
            }
            if (groupEvent == null && getPager().getPageData().u()) {
                PagerNotFoundExceptionKt.a("highlightCallback \u4ec5\u652f\u6301\u57fa\u7840\u5bb9\u5668\u8282\u70b9");
            }
        }
    }

    public void hitTestMode(HitTestMode hitTestMode) {
        Intrinsics.checkNotNullParameter(hitTestMode, "hitTestMode");
        with("hitTestMode", Integer.valueOf(hitTestMode.ordinal()));
    }

    public void screenFramePause(boolean pause) {
        with("screenFramePause", Integer.valueOf(d.b(pause)));
    }

    public final void setBackgroundImageView$core_release(ImageView imageView) {
        this.backgroundImageView = imageView;
    }

    public final void setBorderBottomView$core_release(GroupView<?, ?> groupView) {
        this.borderBottomView = groupView;
    }

    public final void setBorderLeftView$core_release(GroupView<?, ?> groupView) {
        this.borderLeftView = groupView;
    }

    public final void setBorderRightView$core_release(GroupView<?, ?> groupView) {
        this.borderRightView = groupView;
    }

    public final void setBorderTopView$core_release(GroupView<?, ?> groupView) {
        this.borderTopView = groupView;
    }

    public final void setDelayTimeoutRef$core_release(String str) {
        this.delayTimeoutRef = str;
    }

    public final void setDelayTouchDownTask$core_release(Function0<Unit> function0) {
        this.delayTouchDownTask = function0;
    }

    public final void setDelayUpTimeoutRef$core_release(String str) {
        this.delayUpTimeoutRef = str;
    }

    public final void setHighlightBackgroundColor$core_release(h hVar) {
        this.highlightBackgroundColor = hVar;
    }

    public final void setHighlightBackgroundView$core_release(GroupView<?, ?> groupView) {
        this.highlightBackgroundView = groupView;
    }

    public final void setHighlightCallback$core_release(Function1<? super Boolean, Unit> function1) {
        this.highlightCallback = function1;
    }

    public static /* synthetic */ void hitTestMode$default(GroupAttr groupAttr, HitTestMode hitTestMode, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                hitTestMode = HitTestMode.DEFAULT_RECT;
            }
            groupAttr.hitTestMode(hitTestMode);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hitTestMode");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void backgroundImage$default(GroupAttr groupAttr, String str, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                function1 = null;
            }
            groupAttr.backgroundImage(str, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: backgroundImage");
    }
}
