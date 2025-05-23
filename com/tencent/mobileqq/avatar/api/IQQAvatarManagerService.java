package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
@Service(process = {"all", ProcessConstant.NEARBY})
/* loaded from: classes11.dex */
public interface IQQAvatarManagerService extends IRuntimeService {
    void addObserver(Object obj);

    void downloadFace(FaceInfo faceInfo);

    String getChooseStrangerGroupIP();

    String getChoosedIP();

    Bitmap getFaceFromCache(String str);

    String getFacePath(FaceInfo faceInfo);

    Setting getFaceSetting(String str);

    boolean isFaceFileExist(FaceInfo faceInfo);

    void putFaceToCache(String str, Bitmap bitmap, byte b16);

    void removeFaceFromCache(String str);

    void removeObserver(Object obj);

    void updateFaceSetting(Setting setting);
}
