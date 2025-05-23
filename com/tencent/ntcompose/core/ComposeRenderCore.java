package com.tencent.ntcompose.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\t\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0002\b\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ntcompose/core/ComposeRenderCore;", "", "", "a", "Lcom/tencent/kuikly/core/base/ViewContainer;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "b", "(Lcom/tencent/kuikly/core/base/ViewContainer;Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/runtime/Composition;", "Landroidx/compose/runtime/Composition;", "composition", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeRenderCore {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Composition composition;

    public final void a() {
        Composition composition = this.composition;
        if (composition != null) {
            composition.dispose();
        }
        this.composition = null;
    }

    public final void b(ViewContainer<?, ?> rootView, final Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(content, "content");
        GlobalSnapshotManager.f339199a.e();
        CoroutineContext plus = j.f339216d.plus(a.b(com.tencent.kuikly.core.manager.c.f117352a.g()));
        Recomposer recomposer = new Recomposer(plus);
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, plus, null, new ComposeRenderCore$renderComposableInRootView$1(recomposer, null), 2, null);
        Composition Composition = CompositionKt.Composition(new l(new ComposeRenderView(rootView)), recomposer);
        this.composition = Composition;
        if (Composition != null) {
            Composition.setContent(ComposableLambdaKt.composableLambdaInstance(-1899179199, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.core.ComposeRenderCore$renderComposableInRootView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    if ((i3 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1899179199, i3, -1, "com.tencent.ntcompose.core.ComposeRenderCore.renderComposableInRootView.<anonymous> (ComposeRenderCore.kt:41)");
                    }
                    CompositionLocalsKt.a(content, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
    }
}
