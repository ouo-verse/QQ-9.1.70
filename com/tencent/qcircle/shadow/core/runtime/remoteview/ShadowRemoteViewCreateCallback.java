package com.tencent.qcircle.shadow.core.runtime.remoteview;

import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ShadowRemoteViewCreateCallback {
    void onViewCreateFailed(Exception exc);

    void onViewCreateSuccess(View view);
}
