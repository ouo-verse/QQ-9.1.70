package androidx.navigation;

import androidx.annotation.IdRes;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\bH\u0086\b\u00a8\u0006\t"}, d2 = {WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Landroidx/navigation/NavGraphBuilder;", "id", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/ActivityNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ActivityNavigatorDestinationBuilderKt {
    public static final void activity(@NotNull NavGraphBuilder activity, @IdRes int i3, @NotNull Function1<? super ActivityNavigatorDestinationBuilder, Unit> builder) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$activity");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Navigator navigator = activity.getProvider().getNavigator((Class<Navigator>) ActivityNavigator.class);
        Intrinsics.checkExpressionValueIsNotNull(navigator, "getNavigator(clazz.java)");
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navigator, i3);
        builder.invoke(activityNavigatorDestinationBuilder);
        activity.destination(activityNavigatorDestinationBuilder);
    }
}
