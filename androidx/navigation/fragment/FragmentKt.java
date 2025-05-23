package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroidx/fragment/app/Fragment;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class FragmentKt {
    @NotNull
    public static final NavController findNavController(@NotNull Fragment findNavController) {
        Intrinsics.checkParameterIsNotNull(findNavController, "$this$findNavController");
        NavController findNavController2 = NavHostFragment.findNavController(findNavController);
        Intrinsics.checkExpressionValueIsNotNull(findNavController2, "NavHostFragment.findNavController(this)");
        return findNavController2;
    }
}
