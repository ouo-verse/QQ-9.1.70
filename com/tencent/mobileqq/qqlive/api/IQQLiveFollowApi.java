package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveFollowApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface IQQLiveFollowStateListener {
        void onFollowStateChange(long j3, long j16, int i3, String str);
    }

    void addWebFollowStateChangeListener(IQQLiveFollowStateListener iQQLiveFollowStateListener);

    void removeWebFollowStateChangeListener(IQQLiveFollowStateListener iQQLiveFollowStateListener);
}
