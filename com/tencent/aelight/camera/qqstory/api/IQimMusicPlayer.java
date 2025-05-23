package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import qs.e;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQimMusicPlayer extends QRouteApi {
    boolean checkMusicCanPlay(MusicItemInfo musicItemInfo);

    void clearMusic();

    boolean requestDownLoadMusicInfo(MusicItemInfo musicItemInfo, e eVar);
}
