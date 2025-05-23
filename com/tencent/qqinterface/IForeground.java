package com.tencent.qqinterface;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IForeground {
    void onCreate(Context context);

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
