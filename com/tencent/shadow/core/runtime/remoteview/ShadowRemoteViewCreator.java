package com.tencent.shadow.core.runtime.remoteview;

import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ShadowRemoteViewCreator {
    View createView(String str, String str2) throws ShadowRemoteViewCreateException;

    void createView(String str, String str2, ShadowRemoteViewCreateCallback shadowRemoteViewCreateCallback);
}
