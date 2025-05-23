package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZootopiaAvatarTextureImpl.class)
/* loaded from: classes35.dex */
public interface g {
    void clearCachedSceneLoadingAvatarTexture();

    void getSceneLoadingAvatarTexture(String str, int i3, int i16, h hVar);
}
