package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a<\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\u0002\b\nH\u0086\b\u00a8\u0006\u000b"}, d2 = {"dialog", "", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/DialogFragment;", "Landroidx/navigation/NavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i3, @NotNull Function1<? super DialogFragmentNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkParameterIsNotNull(dialog, "$this$dialog");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Navigator navigator = dialog.getProvider().getNavigator((Class<Navigator>) DialogFragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, UserInfo.SEX_FEMALE);
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i3, Reflection.getOrCreateKotlinClass(DialogFragment.class));
        builder.invoke(dialogFragmentNavigatorDestinationBuilder);
        dialog.destination(dialogFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i3) {
        Intrinsics.checkParameterIsNotNull(dialog, "$this$dialog");
        Navigator navigator = dialog.getProvider().getNavigator((Class<Navigator>) DialogFragmentNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        Intrinsics.reifiedOperationMarker(4, UserInfo.SEX_FEMALE);
        dialog.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i3, Reflection.getOrCreateKotlinClass(DialogFragment.class)));
    }
}
