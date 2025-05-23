package mqq.app;

import android.app.Application;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface QActivityLifecycleCallbacks extends Application.ActivityLifecycleCallbacks {
    void onProcessBackground();

    void onProcessForeground();
}
