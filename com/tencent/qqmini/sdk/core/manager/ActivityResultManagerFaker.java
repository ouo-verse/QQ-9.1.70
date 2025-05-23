package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IRequestPermissionsResultListener;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ActivityResultManagerFaker implements IActivityResultManager {
    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager
    public void addActivityResultListener(IActivityResultListener iActivityResultListener) {
        ActivityResultManager.g().addActivityResultListener(iActivityResultListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager
    public void addRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener) {
        ActivityResultManager.g().addRequestPermissionResultListener(iRequestPermissionsResultListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager
    public void removeActivityResultListener(IActivityResultListener iActivityResultListener) {
        ActivityResultManager.g().removeActivityResultListener(iActivityResultListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager
    public void removeRequestPermissionResultListener(IRequestPermissionsResultListener iRequestPermissionsResultListener) {
        ActivityResultManager.g().removeRequestPermissionResultListener(iRequestPermissionsResultListener);
    }
}
