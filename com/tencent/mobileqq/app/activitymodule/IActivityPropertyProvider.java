package com.tencent.mobileqq.app.activitymodule;

import android.app.Activity;
import android.content.Intent;
import mqq.app.AppRuntime;

/* loaded from: classes11.dex */
public interface IActivityPropertyProvider {
    Activity getActivity();

    AppRuntime getAppRuntime();

    String getCurrentAccountUinFromRuntime();

    Intent getIntent();
}
