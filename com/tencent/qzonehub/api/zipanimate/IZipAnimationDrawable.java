package com.tencent.qzonehub.api.zipanimate;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.zipanimate.OnAnimationListener;
import cooperation.qzone.zipanimate.OnDrawableCallBack;
import cooperation.qzone.zipanimate.ZipFirstFrameLoadedListener;
import cooperation.qzone.zipanimate.ZipFrameLoadedListener;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IZipAnimationDrawable extends QRouteApi {
    void bindLifeCycle(Drawable drawable, Lifecycle lifecycle);

    void clearFirstFrame(Drawable drawable);

    String getAnimationResZipUrl(Drawable drawable);

    int getDuration(Drawable drawable);

    int getNumberOfFrames(Drawable drawable);

    Drawable getZipAnimationDrawable();

    Drawable getZipAnimationDrawable(String str, int i3);

    boolean hasDownloadComplete(Drawable drawable);

    boolean isOneShot(Drawable drawable);

    boolean isRunning(Drawable drawable);

    boolean isZipAnimationDrawable(Animatable animatable);

    boolean isZipDrawableShow(Drawable drawable);

    void loadAndShowFirstFrame(Drawable drawable);

    void preLoadFrame(Drawable drawable, int i3);

    void release(Animatable animatable);

    void release(Drawable drawable);

    void restartAnimation(Drawable drawable);

    void setAnimationListener(Drawable drawable, OnAnimationListener onAnimationListener);

    void setAnimationRes(Drawable drawable, String str, int i3);

    void setDrawableCallback(Drawable drawable, OnDrawableCallBack onDrawableCallBack);

    void setDrawableLoadedListener(Drawable drawable, ZipFrameLoadedListener zipFrameLoadedListener);

    void setIsShowFirstFrame(Drawable drawable, boolean z16);

    void setOneShot(Drawable drawable, boolean z16);

    void setPreloadNum(Drawable drawable, int i3);

    void setRepeatAnimation(Drawable drawable, boolean z16);

    void setScale(Drawable drawable, float f16);

    void setShowLastFrameWhenStop(Drawable drawable, boolean z16);

    void setZipFirstFrameLoadedListener(Drawable drawable, ZipFirstFrameLoadedListener zipFirstFrameLoadedListener);

    void start(Drawable drawable);

    void stop(Drawable drawable);
}
