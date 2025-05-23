package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo3.Size;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/CanvasViewPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CanvasViewPropUpdater implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final CanvasViewPropUpdater f339340a = new CanvasViewPropUpdater();

    CanvasViewPropUpdater() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        if (Intrinsics.areEqual(propKey, "drawCallback")) {
            DeclarativeBaseView<?, ?> b16 = view.b();
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.CanvasView");
            final CanvasView canvasView = (CanvasView) b16;
            Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.DrawScopeInstance");
            final k kVar = (k) propArg0;
            Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Int");
            if (kVar.q().getValue().intValue() != ((Integer) propArg1).intValue()) {
                return;
            }
            canvasView.k(new Function3<com.tencent.kuikly.core.views.p, Float, Float, Unit>() { // from class: com.tencent.ntcompose.material.CanvasViewPropUpdater$setPropToView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.p pVar, Float f16, Float f17) {
                    invoke(pVar, f16.floatValue(), f17.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.kuikly.core.views.p context, float f16, float f17) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    k.this.x(context);
                    k.this.z(new Size(f16, f17));
                    if (canvasView.getRenderView() != null) {
                        k kVar2 = k.this;
                        RenderView renderView = canvasView.getRenderView();
                        Intrinsics.checkNotNull(renderView);
                        kVar2.f(renderView);
                    }
                }
            });
            canvasView.j();
            return;
        }
        if (Intrinsics.areEqual(propKey, "drawCallbackEmpty")) {
            DeclarativeBaseView<?, ?> b17 = view.b();
            Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.kuikly.core.views.CanvasView");
            CanvasView canvasView2 = (CanvasView) b17;
            Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.DrawApiState");
            i iVar = (i) propArg0;
            iVar.q(canvasView2);
            canvasView2.getViewAttr().setProp("undoEnable", Integer.valueOf(com.tencent.kuikly.core.base.d.b(iVar.getUndoEnable())));
            return;
        }
        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
    }
}
