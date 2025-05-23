package com.tencent.mobileqq.qqlive.api.common;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveSyncUserInfoCallback;
import com.tencent.mobileqq.qqlive.callback.common.IQQLiveUserCardInfoCallback;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveUserCard extends IQQLiveModule {
    void getUserCardInfo(long j3, IQQLiveUserCardInfoCallback iQQLiveUserCardInfoCallback);

    void syncUserCardInfo(IQQLiveSyncUserInfoCallback iQQLiveSyncUserInfoCallback);
}
