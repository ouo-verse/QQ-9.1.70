package com.tencent.mobileqq.qqlive.callback.message;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveMessageCallback {
    void onFail(int i3, String str);

    void onIllegalMsg();

    void onSuccess(boolean z16);

    void onUserForbid(@Nullable String str);
}
