package com.qq.e.tg.splash.image;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.view.View;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ImageLoadingListener {
    void onLoadingComplete(String str, View view, Bitmap bitmap, Movie movie);

    void onLoadingFailed(String str, View view, int i3);

    void onLoadingStatus(String str, boolean z16);
}
