package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IQavSdkGraphicRenderMgr {
    void clearGlRender2Native(String str) throws NoSuchMethodException;

    void flushGlRender(String str) throws NoSuchMethodException;

    void setAccountUin(String str) throws NoSuchMethodException;

    void setGlRender2Native(String str, IQAvsdkRenderTexture iQAvsdkRenderTexture) throws NoSuchMethodException;
}
