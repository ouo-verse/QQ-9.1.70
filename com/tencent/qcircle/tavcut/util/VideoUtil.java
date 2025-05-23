package com.tencent.qcircle.tavcut.util;

import android.media.MediaExtractor;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoUtil {
    private static final String TAG = "VideoUtil";

    @RequiresApi(api = 16)
    public static int getIFrameInterval(String str, long j3) {
        int i3 = 1000;
        if (!TextUtils.isEmpty(str)) {
            MediaExtractor mediaExtractor = null;
            try {
                try {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    try {
                        mediaExtractor2.setDataSource(str);
                        int i16 = 0;
                        while (true) {
                            if (i16 >= mediaExtractor2.getTrackCount()) {
                                break;
                            }
                            if (mediaExtractor2.getTrackFormat(i16).getString("mime").startsWith("video/")) {
                                mediaExtractor2.selectTrack(i16);
                                break;
                            }
                            i16++;
                        }
                        mediaExtractor2.seekTo((j3 / 2) * 1000, 0);
                        long sampleTime = mediaExtractor2.getSampleTime();
                        int sampleFlags = mediaExtractor2.getSampleFlags();
                        long j16 = 0;
                        while (mediaExtractor2.advance()) {
                            j16 = mediaExtractor2.getSampleTime() - sampleTime;
                            if (mediaExtractor2.getSampleFlags() == 1) {
                                break;
                            }
                        }
                        Logger.i(TAG, "getIFrameInterval sampleStartTime = " + sampleTime + ",sampleStartFlag = " + sampleFlags + ",duration = " + j3 + ",iFrameIntervalInUs = " + j16);
                        if (j16 > 0) {
                            i3 = (int) (j16 / 1000);
                        }
                        mediaExtractor2.release();
                    } catch (Exception e16) {
                        e = e16;
                        mediaExtractor = mediaExtractor2;
                        Logger.e(TAG, "get I frame interval exception", e);
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        return i3;
                    } catch (Throwable th5) {
                        th = th5;
                        mediaExtractor = mediaExtractor2;
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        return i3;
    }

    public static Size getVideoSize(String str) {
        return getVideoSize(str, true);
    }

    public static Size getVideoSize(String str, boolean z16) {
        int preferRotation;
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setDataSource(str);
        CGSize videoSize = ExtractorUtils.getVideoSize(assetExtractor);
        Size size = new Size((int) videoSize.width, (int) videoSize.height);
        if (z16 && ((preferRotation = assetExtractor.getPreferRotation()) == 1 || preferRotation == 3)) {
            size.setWidth((int) videoSize.height);
            size.setHeight((int) videoSize.width);
        }
        assetExtractor.release();
        return size;
    }
}
