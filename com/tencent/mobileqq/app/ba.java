package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface ba {
    void notifyActivityResult(int i3, int i16, Intent intent);

    boolean notifyBackPressed();

    void notifyConfigurationChanged(Configuration configuration);

    void notifyContentView(View view);

    void notifyCreate();

    View notifyCreateView(LayoutInflater layoutInflater);

    void notifyDestroy();

    void notifyMultiWindowModeChanged(boolean z16);

    void notifyNewIntent(Intent intent);

    void notifyPause(boolean z16);

    void notifyRestoreInstanceState(Bundle bundle);

    void notifyResume(boolean z16);

    void notifySaveInstanceState(Bundle bundle);

    void notifyStart();

    void notifyStop();
}
