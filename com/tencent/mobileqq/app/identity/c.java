package com.tencent.mobileqq.app.identity;

import android.app.Activity;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface c {
    void onAccountLoginOrSwitch();

    void onActivityDestroy(Activity activity);

    void onActivityResume(Activity activity);

    void onBackgroundSwitch();

    void onConversationResume();

    void onForegroundSwitch();

    void onPreloadEveryLogin();

    void release();
}
