package g92;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a {
    void handleRestart(ViewGroup viewGroup, String str, String str2, String str3, String str4);

    void initView(ViewGroup viewGroup, String str, String str2, String str3, String str4);

    void onActivityResult(int i3, int i16, Intent intent);

    void onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle, String str, String str2, String str3, String str4);

    void onDestroy();

    void onNewIntent(String str, String str2, String str3, String str4);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void openUrl(String str);

    void updateView(ViewGroup viewGroup, String str, String str2, String str3, String str4);
}
