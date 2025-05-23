package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes18.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int[] f288248a = new int[5];
    }

    public static int a(String str, a aVar) {
        int i3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            if (extractMetadata3 == null || "".equals(extractMetadata3) || "null".equals(extractMetadata3)) {
                extractMetadata3 = "0";
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                try {
                    aVar.f288248a[0] = Integer.parseInt(extractMetadata);
                    aVar.f288248a[1] = Integer.parseInt(extractMetadata2);
                    aVar.f288248a[3] = Integer.parseInt(extractMetadata4);
                    i3 = 0;
                } catch (NumberFormatException e16) {
                    QLog.e("MediaMetadataUtils", 1, "parseInt", e16);
                    i3 = -103;
                }
                try {
                    aVar.f288248a[2] = Integer.parseInt(extractMetadata3);
                    aVar.f288248a[4] = 0;
                } catch (NumberFormatException e17) {
                    QLog.e("MediaMetadataUtils", 1, "parseInt", e17);
                    aVar.f288248a[2] = 0;
                }
                return i3;
            }
            QLog.e("MediaMetadataUtils", 1, "extractMetadata:width=" + extractMetadata + " height=" + extractMetadata2);
            return -102;
        } catch (RuntimeException e18) {
            QLog.e("MediaMetadataUtils", 1, "setDataSource", e18);
            return -101;
        }
    }
}
