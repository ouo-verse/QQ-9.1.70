package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public interface NavDirections {
    @IdRes
    int getActionId();

    @NonNull
    Bundle getArguments();
}
