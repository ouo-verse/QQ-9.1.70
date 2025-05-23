package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emosm.cameraemotionroaming.c;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonUITestHelperService extends QRouteApi {
    IFavoriteEmoticonInfo createFavoriteEmoticonInfo();

    IHotPicSearchEmoticonInfo createHotPicSearchEmoticonInfo(int i3, int i16, String str, EmotionSearchItem emotionSearchItem);

    IPicEmoticonInfo createPicEmoticonInfo(String str);

    c getCameraEmoSendControl();
}
