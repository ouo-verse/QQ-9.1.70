package com.tencent.aelight.camera.ae;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface q {
    void finish();

    boolean m(int i3, KeyEvent keyEvent, boolean z16);

    void n(int i3, int i16);

    void onActivityPause();

    void onActivityResult(int i3, int i16, Intent intent);

    void onActivityResume();

    void onActivityStart();

    void onActivityStop();

    boolean onBackPressed();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onSaveInstanceState(Bundle bundle);

    boolean onTouchEvent(MotionEvent motionEvent, boolean z16);

    void onWindowFocusChanged(boolean z16);

    View q(ViewGroup viewGroup);
}
