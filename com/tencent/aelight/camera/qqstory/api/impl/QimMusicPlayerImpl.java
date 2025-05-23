package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.music.g;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import fr.f;
import qs.e;

/* loaded from: classes32.dex */
public class QimMusicPlayerImpl implements IQimMusicPlayer {
    @Override // com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer
    public boolean checkMusicCanPlay(MusicItemInfo musicItemInfo) {
        return ((g) f.d().g(8)).h(musicItemInfo);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer
    public void clearMusic() {
        ((g) f.d().g(8)).i();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer
    public boolean requestDownLoadMusicInfo(MusicItemInfo musicItemInfo, e eVar) {
        return ((g) f.d().g(8)).v(musicItemInfo, eVar);
    }
}
