package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public interface FragmentOnAttachListener {
    @MainThread
    void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment);
}
