package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes11.dex */
public interface IQQAvatarDataService extends IRuntimeService {
    Bitmap getBitmapFromCache(String str);

    String getCustomFaceFilePath(int i3, String str, int i16);

    String getCustomFaceFilePath(int i3, String str, int i16, int i17);

    String getCustomFaceFilePath(Setting setting, int i3, String str, int i16, int i17);

    String getCustomFaceFilePath(Setting setting, int i3, String str, int i16, int i17, FaceInfo faceInfo);

    String getCustomFaceFilePath(boolean z16, String str);

    String getCustomFaceFilePathBySetting(Setting setting, int i3, int i16);

    String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16);

    String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16);

    String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16, @NonNull FaceInfo faceInfo);

    Setting getFaceSetting(String str);

    String getHistoryAvatarPath();

    String getOldCustomFaceFilePath(int i3, String str);

    Pair<Boolean, Setting> getQQHeadSetting(int i3, String str, int i16);

    Setting getQQHeadSettingFromDB(String str);

    Drawable getRoundFaceDrawable(Bitmap bitmap);

    Setting getSettingFromDb(String str);

    String getZplanAvatarFilePath(String str, int i3);

    void initFaceSettingCache();

    boolean isFaceFileExist(int i3, String str, int i16, int i17);

    boolean isFaceFileExist(FaceInfo faceInfo);

    boolean isSupportDecodeHeadSize();

    void putBitmapToCache(String str, Bitmap bitmap, byte b16);

    void removeBitmapFromCache(String str);

    void removeFaceFileCache(FaceInfo faceInfo);

    void removeFaceIconCache(int i3, String str, int i16);

    void removeFaceIconCacheApollo(int i3, String str, int i16);

    void setHistoryAvatarPath(String str);

    void updateSettingTableCache(Setting setting);
}
