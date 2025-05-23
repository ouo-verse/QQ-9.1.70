package pl2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lpl2/f;", "Lpl2/b;", "Landroidx/fragment/app/Fragment;", "getFragment", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface f extends b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        @Nullable
        public static Context a(@NotNull f fVar) {
            Fragment fragment = fVar.getFragment();
            if (fragment != null) {
                return fragment.getContext();
            }
            return null;
        }

        public static boolean b(@NotNull f fVar) {
            boolean z16;
            Fragment fragment = fVar.getFragment();
            if (fragment != null && !fragment.isRemoving()) {
                FragmentActivity activity = fragment.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    @Nullable
    Fragment getFragment();
}
