package androidx.fragment.app;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"findFragment", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "(Landroid/view/View;)Landroidx/fragment/app/Fragment;", "fragment-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View findFragment) {
        Intrinsics.checkNotNullParameter(findFragment, "$this$findFragment");
        F f16 = (F) FragmentManager.findFragment(findFragment);
        Intrinsics.checkNotNullExpressionValue(f16, "FragmentManager.findFragment(this)");
        return f16;
    }
}
