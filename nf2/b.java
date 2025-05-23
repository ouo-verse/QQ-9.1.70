package nf2;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Landroid/content/Context;", "Landroidx/lifecycle/LifecycleOwner;", "a", "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "getLifeCycleOwner", "qqecommerce-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    @Nullable
    public static final LifecycleOwner a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Activity i3 = KRCSSViewExtensionKt.i(context);
            if (i3 instanceof FragmentActivity) {
                List<Fragment> fragments = ((FragmentActivity) i3).getSupportFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "act.supportFragmentManager.fragments");
                for (Fragment fragment : fragments) {
                    if (fragment instanceof QPublicBaseFragment) {
                        return ((QPublicBaseFragment) fragment).getViewLifecycleOwner();
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
