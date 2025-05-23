package o71;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static int a(String str) {
        String extractMetadata;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                QLog.i("FormatDetector", 1, "detectFormatSupport: mimeType=" + extractMetadata);
            } catch (Exception e16) {
                QLog.e("FormatDetector", 1, "detectFormatSupport:", e16);
            }
            if (!TextUtils.isEmpty(extractMetadata) && extractMetadata.startsWith("video/")) {
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(17);
                QLog.i("FormatDetector", 1, "detectFormatSupport: hasVideo=" + extractMetadata2);
                if (TextUtils.isEmpty(extractMetadata2) || !extractMetadata2.equalsIgnoreCase("yes")) {
                    QLog.e("FormatDetector", 1, "detectFormatSupport: no video content!");
                    return -1;
                }
                mediaMetadataRetriever.release();
                return 0;
            }
            QLog.e("FormatDetector", 1, "detectFormatSupport: wrong mimeType=" + extractMetadata);
            return -1;
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
