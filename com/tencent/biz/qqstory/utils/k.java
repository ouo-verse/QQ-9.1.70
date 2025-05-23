package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.util.Pair;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f94469a;

        /* renamed from: b, reason: collision with root package name */
        public long f94470b;

        public a(long j3, long j16) {
            this.f94469a = j3;
            this.f94470b = j16;
        }
    }

    public static int a(int i3) {
        int i16 = i3 % 16;
        if (i16 != 0) {
            if (i16 < 8) {
                return i3 - i16;
            }
            return i3 + (16 - i16);
        }
        return i3;
    }

    public static Pair<Integer, Integer> b(int i3, int i16, int i17, int i18) {
        return new Pair<>(Integer.valueOf(a(i3)), Integer.valueOf(a((int) ((i3 * i18) / i17))));
    }

    public static int c(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(20);
            mediaMetadataRetriever.release();
            return Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e16) {
            hd0.c.u("Q.qqstory.publish.VideoUtils", "exception", e16);
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0062, code lost:
    
        if (r13 >= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
    
        hd0.c.g("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find video track index.");
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        r4 = new java.util.ArrayList<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
    
        r1.seekTo(r5 * 1000, 2);
        r5 = r1.getSampleTime() / 1000;
        r11 = r9 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0081, code lost:
    
        if (r11 >= r14) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c4, code lost:
    
        r4.add(new com.tencent.biz.qqstory.utils.k.a(r5, r14));
        r5 = r5 + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        r4.add(new com.tencent.biz.qqstory.utils.k.a(r5, r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
    
        if (r3 >= r4.size()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r3 != (r4.size() - 1)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
    
        r4.get(r3).f94470b = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bd, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
    
        r4.get(r3).f94470b = r4.get(r3 + 1).f94469a - r4.get(r3).f94469a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
    
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c3, code lost:
    
        return r4;
     */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<a> d(String str, long j3) {
        long j16;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int i3 = 0;
            int i16 = 0;
            while (true) {
                long j17 = 0;
                if (i16 < mediaExtractor.getTrackCount()) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i16);
                    if (trackFormat.getString("mime").startsWith("video/")) {
                        if (trackFormat.containsKey("durationUs")) {
                            j16 = trackFormat.getLong("durationUs") / 1000;
                            mediaExtractor.selectTrack(i16);
                            hd0.c.a("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() find it video index = " + i16);
                        } else {
                            hd0.c.g("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find duration.");
                            mediaExtractor.release();
                            return null;
                        }
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    j16 = 0;
                    break;
                }
            }
        } catch (IOException e16) {
            hd0.c.h("Q.qqstory.publish.VideoUtils", "Open file error in getClosetKeyFramePosArray() file = " + str, e16);
            mediaExtractor.release();
            return null;
        }
    }

    @TargetApi(17)
    public static int e(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            mediaMetadataRetriever.release();
            return Integer.valueOf(extractMetadata).intValue();
        } catch (Exception e16) {
            hd0.c.u("Q.qqstory.publish.VideoUtils", "exception", e16);
            return -1;
        }
    }

    public static boolean f(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo.mediaWidth >= localMediaInfo.mediaHeight) {
            if (localMediaInfo.rotation % 180 == 0) {
                return true;
            }
        } else {
            int i3 = localMediaInfo.rotation;
            if (i3 == 90 || i3 == 270) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(int i3, int i16, int i17, int i18) {
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(i17 / f16, i18 / f17);
        int i19 = (int) (f17 * min);
        if (((int) (f16 * min)) >= i17 && i19 >= i18) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        if (!DeviceInfoMonitor.getModel().equals("MI 4LTE") && !DeviceInfoMonitor.getModel().equals("GT-I9502") && !DeviceInfoMonitor.getModel().equals("NX513J") && !DeviceInfoMonitor.getModel().equals("MI 4W") && !DeviceInfoMonitor.getModel().toUpperCase().contains("M612") && !DeviceInfoMonitor.getModel().toUpperCase().contains("M5S")) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        if (!DeviceInfoMonitor.getModel().equals("MI 9 SE") && !DeviceInfoMonitor.getModel().equals("MI 9") && !DeviceInfoMonitor.getModel().equals("MI 8 UD") && !DeviceInfoMonitor.getModel().equals("MI 8") && !DeviceInfoMonitor.getModel().equals("NEX") && !DeviceInfoMonitor.getModel().equals("NEXS")) {
            return true;
        }
        return false;
    }
}
