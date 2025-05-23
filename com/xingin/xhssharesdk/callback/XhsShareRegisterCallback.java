package com.xingin.xhssharesdk.callback;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public interface XhsShareRegisterCallback {
    void onError(int i3, String str, @Nullable Exception exc);

    void onSuccess();
}
