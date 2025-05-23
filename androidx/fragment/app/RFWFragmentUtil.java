package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes.dex */
public class RFWFragmentUtil {
    private static final String TAG = "RFWFragmentUtil";

    @Nullable
    public static Fragment findViewFragment(@NonNull View view) {
        Fragment findViewFragmentInner = findViewFragmentInner(view);
        if (findViewFragmentInner == null && RFWApplication.isDebug()) {
            RFWLog.i(TAG, RFWLog.USR, "view is not attach fragment");
        }
        return findViewFragmentInner;
    }

    private static Fragment findViewFragmentInner(@NonNull View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            Object parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    public static Fragment getViewFragment(View view) {
        return FragmentManager.getViewFragment(view);
    }
}
