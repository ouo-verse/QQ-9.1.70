package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IVHostCallback {
    void onHostActivityBackPress();

    void onHostActivityDestroy();

    void onHostActivityNewIntent(Intent intent);

    void onHostActivityPause();

    void onHostActivityResult(int i3, int i16, Intent intent);

    void onHostActivityResume();

    void onHostActivityStop();

    void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);
}
