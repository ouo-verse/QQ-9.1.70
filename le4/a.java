package le4;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static List<Long> a(String str) {
        long j3;
        long j16;
        MediaFormat trackFormat;
        MediaExtractor mediaExtractor = new MediaExtractor();
        ArrayList arrayList = new ArrayList();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i3 = 0;
            while (true) {
                j3 = 0;
                if (i3 < trackCount) {
                    try {
                        trackFormat = mediaExtractor.getTrackFormat(i3);
                    } catch (ClassCastException | NullPointerException e16) {
                        ee4.b.c("KeyFrameTimeExtractor", "getKeyFrameTime exception, index=" + i3 + ", count=" + trackCount + ", path=" + str + ", message=" + e16.getMessage(), e16);
                    }
                    if (trackFormat.getString("mime").startsWith("video/")) {
                        mediaExtractor.selectTrack(i3);
                        j16 = trackFormat.getLong("durationUs");
                        break;
                    }
                    continue;
                    i3++;
                } else {
                    j16 = 0;
                    break;
                }
            }
            mediaExtractor.seekTo(0L, 2);
            long sampleTime = mediaExtractor.getSampleTime();
            ee4.b.a("KeyFrameTimeExtractor", String.format(Locale.getDefault(), "media start: %d", Long.valueOf(sampleTime)));
            mediaExtractor.advance();
            long j17 = 1000000;
            while (mediaExtractor.getSampleTime() >= j3) {
                if (mediaExtractor.getSampleFlags() == 1) {
                    long min = Math.min(mediaExtractor.getSampleTime() - sampleTime, j17);
                    ee4.b.a("KeyFrameTimeExtractor", String.format(Locale.getDefault(), "media step: %d", Long.valueOf(min)));
                    j17 = min;
                }
                mediaExtractor.advance();
                j3 = 0;
            }
            arrayList.add(Long.valueOf(j3));
            mediaExtractor.seekTo(j17, 2);
            long sampleTime2 = mediaExtractor.getSampleTime();
            while (sampleTime2 < j16) {
                long sampleTime3 = mediaExtractor.getSampleTime();
                if (sampleTime3 > ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                    arrayList.add(Long.valueOf(sampleTime3));
                    sampleTime2 = sampleTime3;
                } else {
                    sampleTime2 += j17;
                }
                ee4.b.a("KeyFrameTimeExtractor", String.format(Locale.getDefault(), "media timestamp: %d", Long.valueOf(sampleTime3)));
                mediaExtractor.seekTo(sampleTime2, 2);
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        mediaExtractor.release();
        return arrayList;
    }
}
