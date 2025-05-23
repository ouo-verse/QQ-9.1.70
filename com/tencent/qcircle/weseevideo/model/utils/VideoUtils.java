package com.tencent.qcircle.weseevideo.model.utils;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.asset.URLAsset;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoUtils {
    private static final String TAG = "VideoUtils";

    public static boolean checkExternalStorageCanRead() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                if (new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead()) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static URLAsset createAsset(String str) {
        try {
            return new URLAsset(str);
        } catch (Exception e16) {
            Logger.e(TAG, (e16.getMessage() + ",file exists:" + FileUtils.exists(str)) + ",external storage read:" + checkExternalStorageCanRead());
            return null;
        }
    }

    protected static String extractMetadataRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
        if (mediaMetadataRetriever != null) {
            return mediaMetadataRetriever.extractMetadata(9);
        }
        return "0";
    }

    public static int getDurationImmediately(String str) {
        if (!TextUtils.isEmpty(str)) {
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever2.setDataSource(str);
                        int intValue = Integer.valueOf(extractMetadataRetriever(mediaMetadataRetriever2)).intValue();
                        releaseRetriever(mediaMetadataRetriever2);
                        return intValue;
                    } catch (Exception e16) {
                        e = e16;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        Logger.e(TAG, e.toString());
                        releaseRetriever(mediaMetadataRetriever);
                        return 0;
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        releaseRetriever(mediaMetadataRetriever);
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return 0;
    }

    protected static void releaseRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
    }
}
