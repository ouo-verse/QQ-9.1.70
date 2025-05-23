package com.tencent.mobileqq.winkpublish.util;

import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes21.dex */
public class LocalMediaInfoGenerator {
    public static final String MEDIA_MIME_TYPE_EMPTY_PLACEHOLDER = "MEDIA_MIME_TYPE_EMPTY_PLACEHOLDER";
    private static final String TAG = "LocalMediaInfoGenerator";

    public static LocalMediaInfo buildLocalMediaInfoForEmptyPlaceholder() {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMimeType = MEDIA_MIME_TYPE_EMPTY_PLACEHOLDER;
        return localMediaInfo;
    }

    public static ArrayList<LocalMediaInfo> buildLocalMediaInfos(List<String> list) {
        LocalMediaInfo buildLocalMediaInfosForPic;
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (QAlbumUtil.getMediaType(str) == 1) {
                    buildLocalMediaInfosForPic = buildLocalMediaInfosForVideo(str);
                } else {
                    buildLocalMediaInfosForPic = buildLocalMediaInfosForPic(str);
                }
                arrayList.add(buildLocalMediaInfosForPic);
            }
        }
        return arrayList;
    }

    public static LocalMediaInfo buildLocalMediaInfosForPic(String str) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        localMediaInfo.mMimeType = "image/jpeg";
        parseLocalMediaInfoForPic(localMediaInfo);
        fillOriginalPath(localMediaInfo, str);
        return localMediaInfo;
    }

    public static LocalMediaInfo buildLocalMediaInfosForVideo(String str) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = str;
        localMediaInfo.mMimeType = "video/mp4";
        parseLocalMediaInfo(localMediaInfo);
        fillOriginalPath(localMediaInfo, str);
        return localMediaInfo;
    }

    private static void fillOriginalPath(LocalMediaInfo localMediaInfo, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        localMediaInfo.mOriginPath = arrayList;
    }

    public static void fixVideoWidthAndHeight(LocalMediaInfo localMediaInfo) {
        int i3 = localMediaInfo.mediaHeight;
        int i16 = localMediaInfo.mediaWidth;
        int i17 = localMediaInfo.rotation;
        if (i17 == 90 || i17 == 270) {
            localMediaInfo.mediaWidth = i3;
            localMediaInfo.mediaHeight = i16;
            localMediaInfo.rotation = 0;
        }
    }

    private static void getDuration(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    private static int getImageRotation(String str) {
        int i3;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    i3 = 270;
                } else {
                    i3 = 90;
                }
            } else {
                i3 = 180;
            }
            return i3;
        } catch (IOException unused) {
            QLog.e(TAG, 1, "get image rotation failed");
            return 0;
        }
    }

    private static void getRotation(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
    }

    private static void getWidthAndHeight(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
    }

    private static boolean parseLocalMediaInfo(@NonNull LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String str = localMediaInfo.path;
        QLog.i(TAG, 1, "start decode video file: " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            getDuration(localMediaInfo, mediaMetadataRetriever);
            getRotation(localMediaInfo, mediaMetadataRetriever);
            getWidthAndHeight(localMediaInfo, mediaMetadataRetriever);
            fixVideoWidthAndHeight(localMediaInfo);
            ms.a.f(TAG, "video info: \n [duration: " + localMediaInfo.mDuration + ", \nrotation: " + localMediaInfo.rotation + ", \nwidth: " + localMediaInfo.mediaWidth + ", \nheight: " + localMediaInfo.mediaHeight + ", \n");
            try {
                mediaMetadataRetriever.release();
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return true;
            }
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            try {
                QLog.i(TAG, 1, "decode local video info failed, video path: " + str);
                QLog.e(TAG, 1, th, new Object[0]);
                if (mediaMetadataRetriever2 != null) {
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception e17) {
                        QLog.e(TAG, 1, e17, new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th7) {
                if (mediaMetadataRetriever2 != null) {
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception e18) {
                        QLog.e(TAG, 1, e18, new Object[0]);
                    }
                }
                throw th7;
            }
        }
    }

    private static void parseLocalMediaInfoForPic(@NonNull LocalMediaInfo localMediaInfo) {
        if (TextUtils.isEmpty(localMediaInfo.path)) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localMediaInfo.path, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        int imageRotation = getImageRotation(localMediaInfo.path);
        if (imageRotation == 90 || imageRotation == 270) {
            i3 = i16;
            i16 = i3;
        }
        localMediaInfo.mediaWidth = i3;
        localMediaInfo.mediaHeight = i16;
        localMediaInfo.rotation = imageRotation;
    }
}
