package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class Navigator<D extends NavDestination> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Extras {
    }

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface Name {
        String value();
    }

    @NonNull
    public abstract D createDestination();

    @Nullable
    public abstract NavDestination navigate(@NonNull D d16, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Extras extras);

    @Nullable
    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();

    public void onRestoreState(@NonNull Bundle bundle) {
    }
}
