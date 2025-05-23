package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface ICameraEmoRoamingManagerService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(int i3, CameraEmotionData cameraEmotionData);
    }

    void asyncIncreaseEmotionClickNum(CameraEmotionData cameraEmotionData);

    long getFileLength(String str);

    i getImageSize(String str);

    boolean getIsNeedShowGuide();

    String getListVersion();

    boolean isShowCameraEmoInApp();

    void realUploadCustomEmoticon(CameraEmotionData cameraEmotionData);

    void setIsNeedShowGuide(boolean z16);

    void syncIncreaseEmoticonExposeNum(CameraEmotionData cameraEmotionData);

    void syncLocalDel();

    void syncRoaming();

    void updateListVersion(String str);

    void uploadCameraEmo(CameraEmotionData cameraEmotionData, a aVar);
}
