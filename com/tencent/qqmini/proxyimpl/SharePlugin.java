package com.tencent.qqmini.proxyimpl;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes34.dex */
public class SharePlugin {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, String> f347513a = new HashMap<>();

    public static LocalMediaInfo b(String str) {
        LocalMediaInfo localMediaInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = str;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BaseImageUtil.decodeFileWithBufferedStream(str, options);
            } catch (Exception e16) {
                QLog.e(PeakConstants.TAG, 1, e16, new Object[0]);
            } catch (OutOfMemoryError e17) {
                QLog.e(PeakConstants.TAG, 1, e17, new Object[0]);
            }
            localMediaInfo.mediaWidth = options.outWidth;
            localMediaInfo.mediaHeight = options.outHeight;
            localMediaInfo.mMimeType = com.tencent.mobileqq.utils.o.getImageMimeType(str);
            localMediaInfo.fileSize = file.length();
            localMediaInfo.modifiedDate = file.lastModified();
        }
        return localMediaInfo;
    }

    public static LocalMediaInfo c(String str) {
        StringBuilder sb5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    localMediaInfo.path = str;
                    localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    localMediaInfo.mMimeType = mediaMetadataRetriever.extractMetadata(12);
                    localMediaInfo.fileSize = file.length();
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e16) {
                        QZLog.e("mini_SharePlugin", "retriever.release error" + e16);
                    }
                    return localMediaInfo;
                } catch (RuntimeException e17) {
                    QZLog.e("mini_SharePlugin", "RuntimeException" + e17);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e18) {
                        e = e18;
                        sb5 = new StringBuilder();
                        sb5.append("retriever.release error");
                        sb5.append(e);
                        QZLog.e("mini_SharePlugin", sb5.toString());
                        return null;
                    }
                    return null;
                }
            } catch (IllegalArgumentException e19) {
                QZLog.e("mini_SharePlugin", "IllegalArgumentException" + e19);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e26) {
                    e = e26;
                    sb5 = new StringBuilder();
                    sb5.append("retriever.release error");
                    sb5.append(e);
                    QZLog.e("mini_SharePlugin", sb5.toString());
                    return null;
                }
                return null;
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e27) {
                QZLog.e("mini_SharePlugin", "retriever.release error" + e27);
            }
            throw th5;
        }
    }

    private static boolean d(long j3) {
        return j3 <= ((long) PublishMoodInfo.MOOD_MAX_SINGLE_PHOTO_SIZE);
    }

    private static boolean e(long j3) {
        return j3 <= ((long) PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_DURATION);
    }

    private static boolean f(long j3) {
        return j3 <= ((long) PublishMoodInfo.MOOD_MAX_SINGLE_VIDEO_SIZE);
    }

    private static void g(final int i3) {
        if (i3 == 0) {
            return;
        }
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.SharePlugin.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                int i16 = i3;
                if ((i16 & 32) != 0) {
                    str = (String) SharePlugin.f347513a.get(32);
                } else if ((i16 & 16) != 0) {
                    str = (String) SharePlugin.f347513a.get(16);
                } else if ((i16 & 8) != 0) {
                    str = (String) SharePlugin.f347513a.get(8);
                } else if ((i16 & 4) != 0) {
                    str = (String) SharePlugin.f347513a.get(4);
                } else if ((i16 & 2) != 0) {
                    str = (String) SharePlugin.f347513a.get(2);
                } else {
                    str = (i16 & 1) != 0 ? (String) SharePlugin.f347513a.get(1) : null;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), str, 1).show();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublishMoodInfo h(PublishMoodInfo publishMoodInfo) {
        int i3;
        ArrayList<PublishMoodInfo.MediaInfo> arrayList;
        HashMap<String, LocalMediaInfo> hashMap;
        Iterator<PublishMoodInfo.MediaInfo> it;
        if (publishMoodInfo == null) {
            return null;
        }
        PublishMoodInfo publishMoodInfo2 = new PublishMoodInfo();
        publishMoodInfo2.mTag = publishMoodInfo.mTag;
        publishMoodInfo2.mPath = publishMoodInfo.mPath;
        publishMoodInfo2.mFootnote = publishMoodInfo.mFootnote;
        String str = publishMoodInfo.mText;
        int i16 = 0;
        if (str != null && !TextUtils.isEmpty(str)) {
            String filterText = PublishMoodInfo.filterText(publishMoodInfo.mText);
            int length = filterText.length();
            int i17 = PublishMoodInfo.MOOD_MAX_TEXT_COUNT;
            int i18 = length - i17;
            if (i18 > 0) {
                String str2 = publishMoodInfo.mText;
                publishMoodInfo.mText = str2.substring(0, str2.length() - i18);
                QLog.i("mini_SharePlugin", 2, "\u8d85\u51fa" + (filterText.length() - i17) + "\u4e2a\u5b57,\u622a\u65ad");
                i3 = 1;
                publishMoodInfo2.mText = publishMoodInfo.mText;
                arrayList = publishMoodInfo.mMediaInfo;
                if (arrayList != null && arrayList.size() > 0) {
                    if (publishMoodInfo.mMediaInfo.size() > PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT) {
                        i3 |= 32;
                        QLog.i("mini_SharePlugin", 2, "\u56fe\u7247+\u89c6\u9891\u4e2a\u6570\u8d85\u51fa\u5927\u5c0f");
                    }
                    hashMap = new HashMap<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    it = publishMoodInfo.mMediaInfo.iterator();
                    int i19 = 0;
                    while (it.hasNext()) {
                        PublishMoodInfo.MediaInfo next = it.next();
                        File file = new File(next.mPath);
                        if (file.exists() && file.isFile()) {
                            int i26 = next.mType;
                            if (i26 == 1) {
                                LocalMediaInfo b16 = b(next.mPath);
                                if (b16 != null) {
                                    if (d(b16.fileSize)) {
                                        arrayList2.add(next.mPath);
                                        hashMap.put(next.mPath, b16);
                                        i19++;
                                    } else {
                                        i3 |= 2;
                                        QLog.i("mini_SharePlugin", 2, "\u56fe\u7247\u8d85\u51fa\u5927\u5c0f\uff0c" + next);
                                    }
                                }
                            } else if (i26 != 2) {
                                QLog.i("mini_SharePlugin", 2, "invalid type" + next);
                            } else if (i16 >= PublishMoodInfo.MOOD_MAX_VIDEO_COUNT) {
                                i3 |= 16;
                                QLog.i("mini_SharePlugin", 2, "\u89c6\u9891\u4e2a\u6570\u8d85\u51fa\u5927\u5c0f");
                            } else {
                                LocalMediaInfo c16 = c(next.mPath);
                                if (c16 != null) {
                                    boolean f16 = f(c16.fileSize);
                                    boolean e16 = e(c16.mDuration);
                                    if (f16 && e16) {
                                        arrayList2.add(next.mPath);
                                        hashMap.put(next.mPath, c16);
                                        i16++;
                                    } else {
                                        if (!f16) {
                                            i3 |= 4;
                                        }
                                        if (!e16) {
                                            i3 |= 8;
                                        }
                                        QLog.i("mini_SharePlugin", 2, "\u5355\u4e2a\u89c6\u9891\u5927\u5c0f/\u65f6\u957f\u8d85\u51fa, " + next);
                                    }
                                }
                            }
                            if (i19 + i16 >= PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT) {
                                break;
                            }
                        } else {
                            QLog.i("mini_SharePlugin", 2, "path is not exist, " + next);
                        }
                    }
                    if (hashMap.size() > 0) {
                        publishMoodInfo2.mAllImageAndVideo = arrayList2;
                        publishMoodInfo2.mMediaInfoHashMap = hashMap;
                    }
                }
                g(i3);
                QLog.i("mini_SharePlugin", 2, "tip = " + i3);
                return publishMoodInfo2;
            }
        }
        i3 = 0;
        publishMoodInfo2.mText = publishMoodInfo.mText;
        arrayList = publishMoodInfo.mMediaInfo;
        if (arrayList != null) {
            if (publishMoodInfo.mMediaInfo.size() > PublishMoodInfo.MOOD_MAX_PHOTO_AND_VIDEO_COUNT) {
            }
            hashMap = new HashMap<>();
            ArrayList<String> arrayList22 = new ArrayList<>();
            it = publishMoodInfo.mMediaInfo.iterator();
            int i192 = 0;
            while (it.hasNext()) {
            }
            if (hashMap.size() > 0) {
            }
        }
        g(i3);
        QLog.i("mini_SharePlugin", 2, "tip = " + i3);
        return publishMoodInfo2;
    }
}
