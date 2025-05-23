package com.tencent.mobileqq.qqfloatingwindow.listener;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IVideoOuterStatusListener {
    void onOrientationChange(boolean z16);

    void onSetVideoCover(Bitmap bitmap);

    void onSetVideoCover(Drawable drawable);

    void onVideoBuffering();

    void onVideoComplete(boolean z16);

    void onVideoError(int i3);

    void onVideoProgressUpdate(int i3);

    void onVideoSize(int i3, int i16);

    void onVideoStart(int i3);

    void onVideoStop();
}
