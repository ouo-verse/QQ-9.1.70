package com.qzone.preview;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {
    public static boolean f(PhotoParam photoParam) {
        int i3 = photoParam.appid;
        return i3 == 4 || i3 == 422 || i3 == 423;
    }

    public static long a(PhotoParam photoParam) {
        if (photoParam != null) {
            return photoParam.ownerUin;
        }
        return 0L;
    }

    public static boolean c(PhotoInfo photoInfo, PhotoParam photoParam) {
        if (photoParam != null && photoParam.appid == 4 && photoParam.isOnePictureFeed && photoInfo != null && !TextUtils.isEmpty(photoInfo.currentUrl)) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + photoInfo.lloc + ",enter url=" + photoParam.oneFeedPictruePath);
            }
            if (photoInfo.lloc.equals(photoParam.oneFeedPictruePath)) {
                if (!QZLog.isDevelopLevel()) {
                    return true;
                }
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + photoInfo.lloc + ",enter url=" + photoParam.oneFeedPictruePath + ",hit");
                return true;
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QzonePictureViewer", 4, "curSmallURL=" + photoInfo.lloc + ",enter url=" + photoParam.oneFeedPictruePath + ",not hit");
            }
        }
        return false;
    }

    public static boolean d(PhotoParam photoParam) {
        if (photoParam == null) {
            return false;
        }
        long j3 = photoParam.loginUin;
        return j3 != 0 ? photoParam.ownerUin != j3 : photoParam.ownerUin != LoginData.getInstance().getUin();
    }

    public static boolean e(PhotoInfo photoInfo) {
        return photoInfo != null && photoInfo.appid == 311;
    }

    public static boolean g(PhotoParam photoParam) {
        return photoParam != null && photoParam.appid == 311;
    }

    public static String b(PhotoInfo photoInfo, PhotoParam photoParam) {
        if (photoParam == null) {
            return null;
        }
        if (photoParam.appid != 4 || c(photoInfo, photoParam)) {
            return photoParam.ugcKey;
        }
        if (photoInfo == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(photoParam.ownerUin);
        sb5.append("_");
        sb5.append(photoParam.mFromRecent ? 4 : photoParam.appid);
        sb5.append("_");
        sb5.append(photoParam.albumid);
        sb5.append("_");
        sb5.append(photoInfo.lloc);
        return sb5.toString();
    }
}
