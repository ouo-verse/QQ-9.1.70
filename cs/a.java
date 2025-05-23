package cs;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static int a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (string.startsWith("video/")) {
                Log.d("VideoUtils", "Extractor selected track " + i3 + " (" + string + "): " + trackFormat);
                return i3;
            }
        }
        return -1;
    }
}
