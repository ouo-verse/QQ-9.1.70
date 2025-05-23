package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.msg.data.g;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IEmoticonBusinessProxyApi extends QRouteApi {
    String getCameraEmoHandlerImplClassName();

    String getEmoticonHandlerImplClassName();

    String getEmoticonMD5(EmoticonInfo emoticonInfo);

    String getFavEmoHandlerImplClassName();

    String getFavEmoPath(EmoticonInfo emoticonInfo);

    EmotionSearchItem getSearchItem(EmoticonInfo emoticonInfo);

    String getSearchWord(EmoticonInfo emoticonInfo);

    String getVipComicMqqHandlerImplClassName();

    String getZPlanEmoPath(EmoticonInfo emoticonInfo);

    String getZPlanEmoTextSummary(EmoticonInfo emoticonInfo);

    g getZPlanPicExtBizInfo(EmoticonInfo emoticonInfo);

    boolean isAIEmoticon(EmoticonInfo emoticonInfo);

    boolean isFavoriteEmoticonType(EmoticonInfo emoticonInfo);

    boolean isHotPicFromSearchType(EmoticonInfo emoticonInfo);

    boolean isHotPicType(EmoticonInfo emoticonInfo);

    boolean isMarketFaceEmoticonType(EmoticonInfo emoticonInfo);

    boolean isZPlanEmoticonType(EmoticonInfo emoticonInfo);
}
