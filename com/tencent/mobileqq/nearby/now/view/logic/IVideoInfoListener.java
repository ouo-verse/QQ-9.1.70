package com.tencent.mobileqq.nearby.now.view.logic;

import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoInfoListener extends QRouteApi {
    void handleDeviceNavChange();

    void hideLoading();

    IVideoInfoListener init(Object obj, IStoryPlayController iStoryPlayController, IShortVideoCommentsView iShortVideoCommentsView, boolean z16);

    void scrollToTop();

    void showLoading();
}
