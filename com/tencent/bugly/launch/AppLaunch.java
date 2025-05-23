package com.tencent.bugly.launch;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface AppLaunch {
    void addTag(String str);

    void endSpanFromLaunch(String str);

    void install(Context context);

    void reportAppFullLaunch();

    void spanEnd(String str);

    void spanStart(String str, String str2);
}
