package com.tencent.aelight.camera.ae.flashshow.util;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public String f65127a;

    public w(String str) {
        this.f65127a = str;
    }

    public boolean a(LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String str = localMediaInfo.path;
        ms.a.f(this.f65127a, "start decode video file: " + str);
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
            b(localMediaInfo, mediaMetadataRetriever);
            d(localMediaInfo, mediaMetadataRetriever);
            e(localMediaInfo, mediaMetadataRetriever);
            c(localMediaInfo, mediaMetadataRetriever);
            ms.a.f(this.f65127a, "video info: \n [duration: " + localMediaInfo.mDuration + ", \nrotation: " + localMediaInfo.rotation + ", \nwidth: " + localMediaInfo.mediaWidth + ", \nheight: " + localMediaInfo.mediaHeight + ", \nlog: " + localMediaInfo.longitude + ", \nlat: " + localMediaInfo.latitude + "]");
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e16) {
                ms.a.e(this.f65127a, e16);
            }
            return true;
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            try {
                ms.a.c(this.f65127a, "decode local video info failed, video path: " + str);
                ms.a.e(this.f65127a, th);
                if (mediaMetadataRetriever2 == null) {
                    return false;
                }
                try {
                    mediaMetadataRetriever2.release();
                    return false;
                } catch (Exception e17) {
                    ms.a.e(this.f65127a, e17);
                    return false;
                }
            } catch (Throwable th7) {
                if (mediaMetadataRetriever2 != null) {
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception e18) {
                        ms.a.e(this.f65127a, e18);
                    }
                }
                throw th7;
            }
        }
    }

    private void b(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    private void c(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
        if (extractMetadata != null) {
            try {
                ArrayList arrayList = new ArrayList(3);
                StringBuilder sb5 = new StringBuilder();
                int i3 = 0;
                for (char c16 : extractMetadata.toCharArray()) {
                    if (i3 >= 2) {
                        break;
                    }
                    if (c16 != '+' && c16 != '-' && c16 != '\n' && c16 != 0) {
                        if (!Character.isDigit(c16) && c16 != '.') {
                            ms.a.c("QQAlbum", "Can not under stand the location string: " + extractMetadata + " !");
                        } else {
                            sb5.append(c16);
                        }
                    } else {
                        if (sb5.length() > 0) {
                            arrayList.add(Integer.valueOf((int) (Double.parseDouble(sb5.toString()) * 1000000.0d)));
                            sb5.setLength(0);
                            i3++;
                        }
                        sb5.append(c16);
                    }
                }
                if (sb5.length() > 0) {
                    arrayList.add(Integer.valueOf((int) (Double.parseDouble(sb5.toString()) * 1000000.0d)));
                }
                if (arrayList.size() >= 2) {
                    localMediaInfo.latitude = ((Integer) arrayList.get(0)).intValue();
                    localMediaInfo.longitude = ((Integer) arrayList.get(1)).intValue();
                }
            } catch (NumberFormatException e16) {
                ms.a.d(this.f65127a, "getLocation error. ", e16);
            }
        }
    }

    private void d(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
    }

    private void e(LocalMediaInfo localMediaInfo, MediaMetadataRetriever mediaMetadataRetriever) {
        localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
    }
}
