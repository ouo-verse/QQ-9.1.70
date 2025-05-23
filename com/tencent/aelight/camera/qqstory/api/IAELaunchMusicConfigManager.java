package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import ns.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAELaunchMusicConfigManager extends QRouteApi {
    public static final String JSON_KEY_H5_MUSIC_FROM = "is_from_story";

    MusicItemInfo getMusicItemById(int i3, int i16);

    void getSingleFullMusicInfo(String str, boolean z16, a aVar);
}
