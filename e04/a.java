package e04;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface a {
    void onActivityResult(int i3, int i16, Intent intent);

    boolean onBackEvent();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onWindowFocusChanged();
}
