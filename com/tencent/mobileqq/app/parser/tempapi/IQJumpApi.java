package com.tencent.mobileqq.app.parser.tempapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IQJumpApi extends QRouteApi {
    boolean backToFileScheme();

    void buildMapActivityProxy(String str);

    String forwardGetFilePath(Context context, Uri uri);

    boolean gestureGetJumpLock(Context context, String str);

    String getSecurityVerifyPluginDataKey();

    View getSplashWidget(Activity activity, Drawable drawable, Drawable drawable2);

    void handleByColorNote();

    void handleStartGroupAudio(QBaseActivity qBaseActivity, String str);

    void nearByEnterNewGame(Context context);

    String parseJumpActionName(AppRuntime appRuntime, Context context, String str);

    String parseJumpServerName(AppRuntime appRuntime, Context context, String str);

    void qzoneLaunchForPreview(Context context, Bundle bundle);

    void releaseMapActivityProxy();

    void startForwardActivity(Context context, Intent intent);
}
