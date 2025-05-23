package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.app.CameraEmoImg;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface ICameraEmotionRoamingDBManagerService extends IRuntimeService {
    int getCatchDataCount();

    String getCustomEmoticonPath(CameraEmotionData cameraEmotionData);

    List<String> getCustomEmoticonResIdsByType(String str);

    List<CameraEmotionData> getEmoticonDataList();

    void insertCustomEmotion(CameraEmotionData cameraEmotionData);

    void runInCurrentThread(Runnable runnable, int i3);

    List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();

    void trimCache();

    void updateCustomEmotion(CameraEmotionData cameraEmotionData);

    void updateLocalDBFromServer(List<CameraEmoImg> list, List<String> list2, List<String> list3);
}
