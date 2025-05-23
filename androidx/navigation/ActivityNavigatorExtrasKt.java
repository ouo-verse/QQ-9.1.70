package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.ActivityNavigator;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2 = {"ActivityNavigatorExtras", "Landroidx/navigation/ActivityNavigator$Extras;", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", WadlProxyConsts.FLAGS, "", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ActivityNavigatorExtrasKt {
    @NotNull
    public static final ActivityNavigator.Extras ActivityNavigatorExtras(@Nullable ActivityOptionsCompat activityOptionsCompat, int i3) {
        ActivityNavigator.Extras.Builder builder = new ActivityNavigator.Extras.Builder();
        if (activityOptionsCompat != null) {
            builder.setActivityOptions(activityOptionsCompat);
        }
        builder.addFlags(i3);
        ActivityNavigator.Extras build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "ActivityNavigator.Extras\u2026(flags)\n        }.build()");
        return build;
    }

    public static /* synthetic */ ActivityNavigator.Extras ActivityNavigatorExtras$default(ActivityOptionsCompat activityOptionsCompat, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            activityOptionsCompat = null;
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return ActivityNavigatorExtras(activityOptionsCompat, i3);
    }
}
