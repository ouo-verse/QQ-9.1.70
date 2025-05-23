package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface IFavroamingDBManagerService<T extends CustomEmotionBase> extends IRuntimeService {
    String getCustomEmoticonPath(CustomEmotionData customEmotionData);

    List<CustomEmotionData> getEmoticonDataList();

    List<CustomEmotionData> getEmoticonDataListFromDB();

    List<CustomEmotionData> getLottieEmoticonDataList();

    void insertCustomEmotion(CustomEmotionData customEmotionData);

    void updateCustomEmotion(CustomEmotionData customEmotionData);
}
