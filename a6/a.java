package a6;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.BaseFragment;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static ViewModelStore a(BaseActivity baseActivity) {
        if (baseActivity instanceof ViewModelStoreOwner) {
            return baseActivity.getViewModelStore();
        }
        return null;
    }

    public static ViewModelStore b(BaseFragment baseFragment) {
        if (baseFragment instanceof ViewModelStoreOwner) {
            return baseFragment.getViewModelStore();
        }
        return null;
    }
}
