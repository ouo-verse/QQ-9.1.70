package com.qzone.common.activities.base;

import android.view.KeyEvent;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface ActivityCallBackInterface {
    void onBackPressed();

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    boolean onKeyUp(int i3, KeyEvent keyEvent);

    void onUserLeaveHint();

    void onWindowFocusChanged(boolean z16);
}
