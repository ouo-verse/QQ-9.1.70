package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import fr.f;
import ns.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AELaunchMusicConfigManagerImpl implements IAELaunchMusicConfigManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager
    public MusicItemInfo getMusicItemById(int i3, int i16) {
        return ((QIMMusicConfigManager) f.c(2)).A(i3, i16);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager
    public void getSingleFullMusicInfo(String str, boolean z16, a aVar) {
        ((QIMMusicConfigManager) f.c(2)).C(str, z16, aVar);
    }
}
