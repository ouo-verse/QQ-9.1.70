package com.tencent.tavcut.core.utils;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.tavcut.core.render.log.TavLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static List<Long> a(String str, List<Long> list, long j3) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        ArrayList arrayList = new ArrayList();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    break;
                }
                if (mediaExtractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                    mediaExtractor.selectTrack(i3);
                    break;
                }
                i3++;
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                mediaExtractor.seekTo(list.get(i16).longValue(), 2);
                mediaExtractor.advance();
                arrayList.add(Long.valueOf(mediaExtractor.getSampleTime()));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        List<Long> c16 = c(arrayList, j3);
        mediaExtractor.release();
        return c16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        r2.selectTrack(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        r9 = r9.getLong("durationUs");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0041, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0043, code lost:
    
        com.tencent.tavcut.core.render.log.TavLogger.e("CutMediaExtractor", "format getLong failed", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Long> b(String str) {
        long j3;
        MediaExtractor mediaExtractor = new MediaExtractor();
        ArrayList arrayList = new ArrayList();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            int i3 = 0;
            while (true) {
                j3 = 0;
                if (i3 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("durationUs")) {
                    break;
                }
                i3++;
            }
            long j16 = 0;
            mediaExtractor.seekTo(0L, 2);
            long sampleTime = mediaExtractor.getSampleTime();
            TavLogger.d("CutMediaExtractor", String.format(Locale.getDefault(), "media start: %d", Long.valueOf(sampleTime)));
            mediaExtractor.advance();
            long j17 = 1000000;
            while (mediaExtractor.getSampleTime() >= j3) {
                if (mediaExtractor.getSampleFlags() == 1) {
                    long min = Math.min(mediaExtractor.getSampleTime() - sampleTime, j17);
                    TavLogger.d("CutMediaExtractor", String.format(Locale.getDefault(), "media step: %d", Long.valueOf(min)));
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
                TavLogger.d("CutMediaExtractor", String.format(Locale.getDefault(), "media timestamp: %d", Long.valueOf(sampleTime3)));
                mediaExtractor.seekTo(sampleTime2, 2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            TavLogger.e("CutMediaExtractor", "getKeyFrameTime:" + e16.getMessage());
        }
        mediaExtractor.release();
        return arrayList;
    }

    private static List<Long> c(List<Long> list, long j3) {
        long j16;
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        long j17 = -1;
        int i3 = 0;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (longValue != j17) {
                i3 = 0;
            } else {
                i3++;
            }
            if (i3 > 0) {
                j16 = (i3 * j3) + longValue;
            } else {
                j16 = longValue;
            }
            arrayList.add(Long.valueOf(j16));
            j17 = longValue;
        }
        return arrayList;
    }
}
