package com.tencent.qqmini.sdk.launcher.shell;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IActivityResultManager {
    void addActivityResultListener(IActivityResultListener iActivityResultListener);

    void addRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener);

    void removeActivityResultListener(IActivityResultListener iActivityResultListener);

    void removeRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener);
}
