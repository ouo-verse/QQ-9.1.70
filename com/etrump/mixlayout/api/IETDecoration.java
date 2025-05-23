package com.etrump.mixlayout.api;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IETDecoration {
    int currentFrameIndex();

    void deleteDescriptor();

    void deleteDescriptor(IETEngine iETEngine);

    void drawBackground(Bitmap bitmap, IETFont iETFont);

    void drawBackgroundSpace(Bitmap bitmap, IETFont iETFont, int i3, int i16);

    void drawForeground(Bitmap bitmap, IETFont iETFont);

    void drawFrameText(int i3, int i16, Bitmap bitmap, int i17, int i18, IETFont iETFont);

    void drawSceneSpace(Bitmap bitmap, int i3, int i16, IETFont iETFont);

    int getFrameDelay();

    int getFrameNum();

    Rect getMargins();

    String getText();

    void gotoFrame(int i3);

    void gotoLastFrame();

    boolean isLastFrame();

    boolean nextFrame();

    void setNativeDescriptorHandle(long j3);
}
