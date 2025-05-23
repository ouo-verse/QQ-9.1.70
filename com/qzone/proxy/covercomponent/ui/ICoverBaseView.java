package com.qzone.proxy.covercomponent.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface ICoverBaseView {
    void delayShow();

    void dispatchPullEvent(int i3, int i16);

    void draw(Canvas canvas);

    int getCoverType();

    void invalidate();

    boolean isCoverVisible();

    boolean isPaused();

    boolean loadPhoto(LoadPhotoState loadPhotoState);

    void needCoverSwitch(boolean z16);

    void onConfigurationChanged(Configuration configuration);

    void onCoverSwitch();

    void onDestroy();

    void onInvisible();

    void onPause();

    void onPullChanged(float f16);

    void onPullEnd();

    void onPullStart();

    void onResume();

    void onStart();

    void onStop();

    boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData);

    void onVisible();

    void postInvalidate();

    void setCoverBaseParent(ICoverBaseParent iCoverBaseParent);

    void setOnCoverClickListener(IOnCoverClickListener iOnCoverClickListener);

    void setRefer(int i3);

    void switchCover();
}
