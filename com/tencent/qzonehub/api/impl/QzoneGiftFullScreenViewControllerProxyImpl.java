package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenViewController;

/* loaded from: classes34.dex */
public class QzoneGiftFullScreenViewControllerProxyImpl implements IQzoneGiftFullScreenViewControllerProxy {
    @Override // com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy
    public IQzoneGiftFullScreenViewController getQzoneGiftFullScreenViewController(Activity activity) {
        return new QzoneGiftFullScreenViewController(activity);
    }

    @Override // com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy
    public boolean isSupportMagicface() {
        return QzoneGiftFullScreenViewController.isSupportMagicface();
    }
}
