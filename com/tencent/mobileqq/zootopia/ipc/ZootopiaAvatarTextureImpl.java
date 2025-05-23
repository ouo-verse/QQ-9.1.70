package com.tencent.mobileqq.zootopia.ipc;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZootopiaAvatarTextureImpl implements g {
    @Override // com.tencent.mobileqq.zootopia.ipc.g
    public void clearCachedSceneLoadingAvatarTexture() {
        com.tencent.mobileqq.zootopia.lua.ak.INSTANCE.a().b();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.g
    public void getSceneLoadingAvatarTexture(String str, int i3, int i16, h hVar) {
        if (hVar == null) {
            return;
        }
        hVar.a(com.tencent.mobileqq.zootopia.lua.ak.INSTANCE.a().c(str, i3, i16));
    }
}
