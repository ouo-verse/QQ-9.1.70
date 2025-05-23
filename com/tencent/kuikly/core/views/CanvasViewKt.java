package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a|\u0010\u0010\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u00042O\u0010\u000f\u001aK\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0006j\u0002`\u000e*\u0094\u0001\u0010\u0011\"G\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u00062G\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/CanvasView;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lkotlin/Function3;", "Lcom/tencent/kuikly/core/views/p;", "Lkotlin/ParameterName;", "name", "context", "", "width", "height", "Lcom/tencent/kuikly/core/views/CanvasDrawCallback;", "draw", "a", "CanvasDrawCallback", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CanvasViewKt {
    public static final void a(ViewContainer<?, ?> viewContainer, final Function1<? super CanvasView, Unit> init, final Function3<? super p, ? super Float, ? super Float, Unit> draw) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        Intrinsics.checkNotNullParameter(draw, "draw");
        viewContainer.addChild(new CanvasView(), new Function1<CanvasView, Unit>() { // from class: com.tencent.kuikly.core.views.CanvasViewKt$Canvas$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CanvasView canvasView) {
                invoke2(canvasView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CanvasView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                addChild.k(draw);
                init.invoke(addChild);
            }
        });
    }
}
