package com.tencent.luggage.wxa.z;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.n0.i;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f146140a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f146141b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f146142c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f146143d;

    /* renamed from: e, reason: collision with root package name */
    public final String f146144e;

    /* renamed from: f, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f146145f;

    public a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        this.f146140a = (String) com.tencent.luggage.wxa.n0.a.a((Object) str);
        this.f146144e = str2;
        this.f146145f = codecCapabilities;
        boolean z26 = true;
        if (!z16 && codecCapabilities != null && a(codecCapabilities)) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.f146141b = z18;
        if (codecCapabilities != null && e(codecCapabilities)) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f146142c = z19;
        if (!z17 && (codecCapabilities == null || !c(codecCapabilities))) {
            z26 = false;
        }
        this.f146143d = z26;
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z16, boolean z17) {
        return new a(str, str2, codecCapabilities, z16, z17);
    }

    public static a d(String str) {
        return new a(str, null, null, false, false);
    }

    public static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        if (v.f135103a >= 21 && f(codecCapabilities)) {
            return true;
        }
        return false;
    }

    public static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public boolean b(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f146145f;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i3)) {
            return true;
        }
        c("sampleRate.support, " + i3);
        return false;
    }

    public final void c(String str) {
        Log.d(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "NoSupport [" + str + "] [" + this.f146140a + ", " + this.f146144e + "] [" + v.f135107e + "]");
    }

    public static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.f135103a >= 21 && d(codecCapabilities);
    }

    public static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f146145f;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean a(String str) {
        String b16;
        if (str == null || this.f146144e == null || (b16 = i.b(str)) == null) {
            return true;
        }
        if (!this.f146144e.equals(b16)) {
            c("codec.mime " + str + ", " + b16);
            return false;
        }
        Pair b17 = d.b(str);
        if (b17 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == ((Integer) b17.first).intValue() && codecProfileLevel.level >= ((Integer) b17.second).intValue()) {
                return true;
            }
        }
        c("codec.profileLevel, " + str + ", " + b16);
        return false;
    }

    public final void b(String str) {
        Log.d(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedSupport [" + str + "] [" + this.f146140a + ", " + this.f146144e + "] [" + v.f135107e + "]");
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public boolean a(int i3, int i16, double d16) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f146145f;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i3, i16, d16)) {
            return true;
        }
        if (i3 < i16 && a(videoCapabilities, i16, i3, d16)) {
            b("sizeAndRate.rotated, " + i3 + HippyTKDListViewAdapter.X + i16 + HippyTKDListViewAdapter.X + d16);
            return true;
        }
        c("sizeAndRate.support, " + i3 + HippyTKDListViewAdapter.X + i16 + HippyTKDListViewAdapter.X + d16);
        return false;
    }

    public Point a(int i3, int i16) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f146145f;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(v.a(i3, widthAlignment) * widthAlignment, v.a(i16, heightAlignment) * heightAlignment);
    }

    public boolean a(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f146145f;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        if (a(this.f146140a, this.f146144e, audioCapabilities.getMaxInputChannelCount()) >= i3) {
            return true;
        }
        c("channelCount.support, " + i3);
        return false;
    }

    public static int a(String str, String str2, int i3) {
        int i16;
        if (i3 > 1 || ((v.f135103a >= 26 && i3 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i3;
        }
        if ("audio/ac3".equals(str2)) {
            i16 = 6;
        } else {
            i16 = "audio/eac3".equals(str2) ? 16 : 30;
        }
        Log.w(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i3 + " to " + i16 + "]");
        return i16;
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return v.f135103a >= 19 && b(codecCapabilities);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i16, double d16) {
        if (d16 != -1.0d && d16 > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i3, i16, d16);
        }
        return videoCapabilities.isSizeSupported(i3, i16);
    }
}
