package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "owner", "Landroidx/lifecycle/LifecycleOwner;", NodeProps.ENABLED, "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class OnBackPressedDispatcherKt {
    @NotNull
    public static final OnBackPressedCallback addCallback(@NotNull OnBackPressedDispatcher addCallback, @Nullable LifecycleOwner lifecycleOwner, final boolean z16, @NotNull final Function1<? super OnBackPressedCallback, Unit> onBackPressed) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z16) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Function1.this.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            addCallback.addCallback(lifecycleOwner, onBackPressedCallback);
        } else {
            addCallback.addCallback(onBackPressedCallback);
        }
        return onBackPressedCallback;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z16, function1);
    }
}
