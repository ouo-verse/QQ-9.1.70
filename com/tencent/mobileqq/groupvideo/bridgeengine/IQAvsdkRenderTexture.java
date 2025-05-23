package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IQAvsdkRenderTexture extends IBaseService {
    boolean canRender() throws NoSuchMethodException;

    void flush(boolean z16) throws NoSuchMethodException;

    int getCaptureFrameHeight() throws NoSuchMethodException;

    byte[] getCaptureFrameTexture() throws NoSuchMethodException;

    int getCaptureFrameWidth() throws NoSuchMethodException;

    byte[] getFaceFeature() throws NoSuchMethodException;

    byte[] getFrameTexture() throws NoSuchMethodException;

    int getImgAngle() throws NoSuchMethodException;

    int getImgHeight() throws NoSuchMethodException;

    int getImgWidth() throws NoSuchMethodException;

    long getNativeContext();

    void init(int i3, Object obj, long j3) throws NoSuchMethodException;

    void onPause() throws NoSuchMethodException;

    void onResume() throws NoSuchMethodException;

    void setIGLRenderTextureListener(IGLRenderTextureListener iGLRenderTextureListener) throws NoSuchMethodException;

    void unInit() throws NoSuchMethodException;

    boolean updateCurFrame() throws NoSuchMethodException;

    int uploadContent(int[] iArr) throws NoSuchMethodException;
}
