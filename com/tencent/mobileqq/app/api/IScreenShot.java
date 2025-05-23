package com.tencent.mobileqq.app.api;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IScreenShot {
    boolean activate();

    void disactivate();

    Bitmap getCacheBitmap();

    boolean isInit();

    boolean isShowing();

    void screenShotAndExit() throws Exception;

    void setCachedBitmap(Bitmap bitmap);
}
