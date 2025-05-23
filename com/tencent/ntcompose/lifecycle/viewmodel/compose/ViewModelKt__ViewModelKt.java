package com.tencent.ntcompose.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.c;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aS\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0004\b\f\u0010\r\u001aK\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u0011*\u00020\u0010*\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "VM", "Lkotlin/reflect/KClass;", "modelClass", "Lcom/tencent/ntcompose/lifecycle/viewmodel/k;", "viewModelStoreOwner", "", "key", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "factory", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "c", "(Lkotlin/reflect/KClass;Lcom/tencent/ntcompose/lifecycle/viewmodel/k;Ljava/lang/String;Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;Landroidx/compose/runtime/Composer;II)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "a", "(Lcom/tencent/ntcompose/lifecycle/viewmodel/k;Lkotlin/reflect/KClass;Ljava/lang/String;Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "Lcom/tencent/ntcompose/lifecycle/common/b;", "viewModel", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;", "lifecycle", "", "b", "(Lcom/tencent/ntcompose/lifecycle/common/b;Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;Landroidx/compose/runtime/Composer;I)V", "ntcompose_release"}, k = 5, mv = {1, 7, 1}, xs = "com/tencent/ntcompose/lifecycle/viewmodel/compose/ViewModelKt")
/* loaded from: classes34.dex */
public final /* synthetic */ class ViewModelKt__ViewModelKt {
    public static final <VM extends g> VM a(k kVar, KClass<VM> modelClass, String str, i.b bVar, b extras) {
        i b16;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (bVar != null) {
            b16 = i.INSTANCE.a(kVar.getViewModelStore(), bVar, extras);
        } else if (kVar instanceof c) {
            b16 = i.INSTANCE.a(kVar.getViewModelStore(), ((c) kVar).getDefaultViewModelProviderFactory(), extras);
        } else {
            b16 = i.INSTANCE.b(kVar, xo3.a.f448236a, extras);
        }
        if (str != null) {
            return (VM) b16.a(str, modelClass);
        }
        return (VM) b16.b(modelClass);
    }

    public static final <viewModel extends com.tencent.ntcompose.lifecycle.common.b> void b(final viewModel viewmodel, final Lifecycle lifecycle, Composer composer, final int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(viewmodel, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Composer startRestartGroup = composer.startRestartGroup(547513149);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(viewmodel) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(lifecycle) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547513149, i3, -1, "com.tencent.ntcompose.lifecycle.viewmodel.compose.observeLifecycleEvents (ViewModel.kt:162)");
            }
            lifecycle.a(viewmodel);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.lifecycle.viewmodel.compose.ViewModelKt__ViewModelKt$observeLifecycleEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (TviewModel;Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;I)V */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i17) {
                a.b(com.tencent.ntcompose.lifecycle.common.b.this, lifecycle, composer2, i3 | 1);
            }
        });
    }

    public static final <VM extends g> VM c(KClass<VM> modelClass, k kVar, String str, i.b bVar, b bVar2, Composer composer, int i3, int i16) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        composer.startReplaceableGroup(-606437003);
        if ((i16 & 2) != 0) {
            Object consume = composer.consume(CompositionLocalsKt.f());
            if (consume != null) {
                kVar = (k) consume;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }
        if ((i16 & 4) != 0) {
            str = null;
        }
        if ((i16 & 8) != 0) {
            bVar = null;
        }
        if ((i16 & 16) != 0) {
            if (kVar instanceof c) {
                bVar2 = ((c) kVar).a();
            } else {
                bVar2 = b.a.f339329b;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606437003, i3, -1, "com.tencent.ntcompose.lifecycle.viewmodel.compose.viewModel (ViewModel.kt:72)");
        }
        VM vm5 = (VM) a.a(kVar, modelClass, str, bVar, bVar2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return vm5;
    }
}
