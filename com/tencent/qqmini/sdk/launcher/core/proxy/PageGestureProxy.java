package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.view.MotionEvent;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public interface PageGestureProxy {
    void onActivityCreate(Activity activity);

    void onActivityDestroy(Activity activity);

    void onActivityFinish(Activity activity);

    void onActivityPause(Activity activity);

    void onActivityResume(Activity activity);

    void onActivityStop(Activity activity);

    void onCreateMiniAppInfo(MiniAppInfo miniAppInfo);

    void onLoadUrl(IMiniAppContext iMiniAppContext);

    void onMoveTaskToBack(Activity activity);

    void onPageWebViewInit();

    void onProcessTouchEvent(MotionEvent motionEvent);

    boolean onViewReleasedAndNeedScrollOriginPosition(MotionEvent motionEvent);

    void updateColorSignPath(String str);
}
