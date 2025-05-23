package com.tencent.gamecenter.wadl.sdk.dlapt;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface WadlTaskListener {
    long getAverageSpeed();

    boolean onForceInstalled(int i3, String str);

    void onInstallStart();

    boolean onPackageInstalled(String str);

    void onTaskCompleted(String str, long j3, String str2);

    void onTaskDeleted(boolean z16);

    void onTaskDetected();

    void onTaskFailed(int i3, String str);

    void onTaskPaused();

    void onTaskReceived(int i3);

    void onTaskStarted();

    void onTaskUpdate(WadlResult wadlResult);
}
