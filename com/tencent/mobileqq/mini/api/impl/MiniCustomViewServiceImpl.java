package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.IMiniCustomViewService;
import com.tencent.mobileqq.mini.api.ui.ICustomMiniLoadingView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniCustomViewServiceImpl implements IMiniCustomViewService {
    private static final String TAG = "MiniCustomViewServiceImpl";
    private WeakReference<ICustomMiniLoadingView> mCurrentLoadingViewRef;

    @Override // com.tencent.mobileqq.mini.api.IMiniCustomViewService
    public void hideMetaRoomLoadingView() {
        WeakReference<ICustomMiniLoadingView> weakReference = this.mCurrentLoadingViewRef;
        if (weakReference == null) {
            QLog.w(TAG, 1, "hideMetaRoomLoadingView but weak ref is null");
            return;
        }
        ICustomMiniLoadingView iCustomMiniLoadingView = weakReference.get();
        if (iCustomMiniLoadingView == null) {
            QLog.w(TAG, 1, "hideMetaRoomLoadingView but loadingView is null");
        } else {
            QLog.d(TAG, 1, "hideMetaRoomLoadingView");
            iCustomMiniLoadingView.requestHideFromJavaScript();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniCustomViewService
    public void registerMetaRoomLoadingView(ICustomMiniLoadingView iCustomMiniLoadingView) {
        if (!(iCustomMiniLoadingView instanceof ICustomMiniLoadingView)) {
            QLog.e(TAG, 1, "registerMetaRoomLoadingView but gameLoadingView is not correct:" + iCustomMiniLoadingView);
            return;
        }
        this.mCurrentLoadingViewRef = new WeakReference<>(iCustomMiniLoadingView);
    }
}
