package com.tencent.qcircle.shadow.core.runtime.remoteview;

import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ShadowRemoteViewCreator {
    View createView(String str, String str2) throws ShadowRemoteViewCreateException;

    void createView(String str, String str2, ShadowRemoteViewCreateCallback shadowRemoteViewCreateCallback);
}
