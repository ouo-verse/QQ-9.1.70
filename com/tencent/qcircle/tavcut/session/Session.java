package com.tencent.qcircle.tavcut.session;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Session {
    int init(Context context);

    void onPause();

    void onResume();

    void release();
}
