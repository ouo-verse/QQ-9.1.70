package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.userlevel.IQQLiveUserLevelChangeListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveUserLevelService extends IQQLiveModule {
    void registerUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener);

    void unRegisterUserLevelChangedListener(IQQLiveUserLevelChangeListener iQQLiveUserLevelChangeListener);
}
