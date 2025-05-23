package com.tencent.mobileqq.winkpublish.util;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AlbumUtil {
    public static final int MEDIA_TYPE_CAMERA = 2;
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final HashMap<String, Integer> MEDIA_TYPE_MAPS;
    public static final int MEDIA_TYPE_NONE = -1;
    public static final int MEDIA_TYPE_VIDEO = 1;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        MEDIA_TYPE_MAPS = hashMap;
        hashMap.put("image", 0);
        hashMap.put("video", 1);
        hashMap.put(MimeHelper.MIME_TYPE_MOBILEQQ, 2);
    }

    public static URL generateAlbumThumbURL(LocalMediaInfo localMediaInfo) {
        return generateAlbumThumbURL(localMediaInfo, null);
    }

    public static int getMediaType(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return -1;
        }
        String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
        if (mimeType == null) {
            return 0;
        }
        Integer num = MEDIA_TYPE_MAPS.get(mimeType[0]);
        if (num == null) {
            QLog.w("QAlbumUtil", 1, "getMediaType fail : " + localMediaInfo.mMimeType + " - " + mimeType[0]);
            return -1;
        }
        return num.intValue();
    }

    public static boolean isImage(LocalMediaInfo localMediaInfo) {
        if (getMediaType(localMediaInfo) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isVideo(LocalMediaInfo localMediaInfo) {
        if (getMediaType(localMediaInfo) == 1) {
            return true;
        }
        return false;
    }

    public static URL generateAlbumThumbURL(LocalMediaInfo localMediaInfo, String str) {
        StringBuilder sb5 = new StringBuilder(QAlbumUtil.PROTOCOL_ALBUM_THUMB);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(localMediaInfo.path);
        if (str != null) {
            sb5.append("#");
            sb5.append(str);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("SelectPhotoTrace", 2, e16.getMessage(), e16);
            return null;
        }
    }
}
