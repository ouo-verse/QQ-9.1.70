package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.ShareData;

/* loaded from: classes23.dex */
public interface ShareProxy {
    int getDefaultShareTarget();

    boolean isShareTargetAvailable(Context context, int i3);

    void onJsShareAppMessage(Object obj);

    void onJsShareAppPictureMessage(Object obj);

    void onShareActivityResult(int i3, int i16, Intent intent);

    void share(Activity activity, ShareData shareData);

    boolean shareGamePicture(Activity activity, ShareData shareData);

    void shareGameStructMessage(ShareData shareData, AsyncResult asyncResult);

    void sharePic(Activity activity, ShareData shareData);

    void showSharePanel(IMiniAppContext iMiniAppContext);
}
