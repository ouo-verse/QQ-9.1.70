package com.tencent.mobileqq.qqlive.api.verified;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.auth.IQQLiveGetRealNameAuthCallback;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveVerifyService extends IQQLiveModule {
    void getRealNameAuthState(int i3, IQQLiveGetRealNameAuthCallback iQQLiveGetRealNameAuthCallback);
}
