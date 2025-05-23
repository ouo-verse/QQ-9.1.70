package com.tencent.zplan.encode;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.zplan.encode.utils.MediaCodecEncodeType;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f385331a;

        /* renamed from: b, reason: collision with root package name */
        private int f385332b;

        /* renamed from: c, reason: collision with root package name */
        private int f385333c;

        /* renamed from: d, reason: collision with root package name */
        private int f385334d;

        /* renamed from: e, reason: collision with root package name */
        private int f385335e;

        /* renamed from: f, reason: collision with root package name */
        private int f385336f;

        public MediaCodec a() {
            int i3;
            int i16;
            String mediaFormat;
            if (!TextUtils.isEmpty(this.f385331a) && (i3 = this.f385332b) != -1 && (i16 = this.f385333c) != -1 && this.f385336f != -1) {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.f385331a, i16, i3);
                int i17 = this.f385336f;
                if (i17 != -1) {
                    createAudioFormat.setInteger("max-input-size", i17);
                }
                int i18 = this.f385334d;
                if (i18 != -1) {
                    createAudioFormat.setInteger("bitrate", i18);
                }
                int i19 = this.f385335e;
                if (i19 != -1) {
                    createAudioFormat.setInteger("aac-profile", i19);
                }
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f385331a);
                    createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (d.f()) {
                        MediaFormat inputFormat = createEncoderByType.getInputFormat();
                        MediaFormat outputFormat = createEncoderByType.getOutputFormat();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("audio inputFormat: ");
                        String str = "null";
                        if (inputFormat == null) {
                            mediaFormat = "null";
                        } else {
                            mediaFormat = inputFormat.toString();
                        }
                        sb5.append(mediaFormat);
                        d.a("SR_MP4_Factory", 1, sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("audio outputFormat: ");
                        if (outputFormat != null) {
                            str = outputFormat.toString();
                        }
                        sb6.append(str);
                        d.a("SR_MP4_Factory", 1, sb6.toString());
                    }
                    return createEncoderByType;
                } catch (Throwable th5) {
                    d.c("SR_MP4_Factory", 1, "create audio encoder error:", th5);
                    return null;
                }
            }
            throw new IllegalArgumentException("build params invalid");
        }

        public b b(int i3) {
            this.f385334d = i3;
            return this;
        }

        public b c(int i3) {
            this.f385332b = i3;
            return this;
        }

        public b d(int i3) {
            this.f385336f = i3;
            return this;
        }

        public b e(String str) {
            this.f385331a = str;
            return this;
        }

        public b f(int i3) {
            this.f385335e = i3;
            return this;
        }

        public b g(int i3) {
            this.f385333c = i3;
            return this;
        }

        b() {
            this.f385331a = "audio/mp4a-latm";
            this.f385332b = -1;
            this.f385333c = -1;
            this.f385334d = -1;
            this.f385335e = -1;
            this.f385336f = -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f385337a;

        /* renamed from: b, reason: collision with root package name */
        private int f385338b;

        /* renamed from: c, reason: collision with root package name */
        private int f385339c;

        /* renamed from: d, reason: collision with root package name */
        private int f385340d;

        /* renamed from: e, reason: collision with root package name */
        private int f385341e;

        /* renamed from: f, reason: collision with root package name */
        private int f385342f;

        /* renamed from: g, reason: collision with root package name */
        private int f385343g;

        /* renamed from: h, reason: collision with root package name */
        private int f385344h;

        /* renamed from: i, reason: collision with root package name */
        private MediaCodecEncodeType f385345i;

        public MediaCodec a() {
            int i3;
            int i16;
            int e16;
            String mediaFormat;
            String str = this.f385337a;
            if (str != null && (i3 = this.f385342f) != -1 && (i16 = this.f385343g) != -1) {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i3, i16);
                if (this.f385345i == MediaCodecEncodeType.SURFACE) {
                    e16 = 2130708361;
                } else {
                    int[] f16 = e.f(this.f385337a);
                    if (f16 != null) {
                        e16 = e.e(f16);
                    } else {
                        d.b("SR_MP4_Factory", 1, "colorFormats is null");
                        return null;
                    }
                }
                d.b("SR_MP4_Factory", 1, "colorFormat:" + e16);
                createVideoFormat.setInteger("color-format", e16);
                int i17 = this.f385344h;
                if (i17 != -1) {
                    createVideoFormat.setInteger("max-input-size", i17);
                }
                int i18 = this.f385339c;
                if (i18 != -1) {
                    createVideoFormat.setInteger("bitrate", i18);
                }
                int i19 = this.f385340d;
                if (i19 != -1) {
                    createVideoFormat.setInteger("bitrate-mode", i19);
                }
                int i26 = this.f385338b;
                if (i26 != -1) {
                    createVideoFormat.setInteger("frame-rate", i26);
                }
                int i27 = this.f385341e;
                if (i27 != -1) {
                    createVideoFormat.setInteger("i-frame-interval", i27);
                }
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f385337a);
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (d.f()) {
                        MediaFormat inputFormat = createEncoderByType.getInputFormat();
                        MediaFormat outputFormat = createEncoderByType.getOutputFormat();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("video inputFormat: ");
                        String str2 = "null";
                        if (inputFormat == null) {
                            mediaFormat = "null";
                        } else {
                            mediaFormat = inputFormat.toString();
                        }
                        sb5.append(mediaFormat);
                        d.a("SR_MP4_Factory", 1, sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("video outputFormat: ");
                        if (outputFormat != null) {
                            str2 = outputFormat.toString();
                        }
                        sb6.append(str2);
                        d.a("SR_MP4_Factory", 1, sb6.toString());
                    }
                    return createEncoderByType;
                } catch (Throwable th5) {
                    d.c("SR_MP4_Factory", 1, "create video encoder error:", th5);
                    return null;
                }
            }
            throw new IllegalArgumentException("build params invalid");
        }

        public c b(int i3) {
            this.f385339c = i3;
            return this;
        }

        public c c(int i3) {
            this.f385340d = i3;
            return this;
        }

        public c d(MediaCodecEncodeType mediaCodecEncodeType) {
            this.f385345i = mediaCodecEncodeType;
            return this;
        }

        public c e(int i3) {
            this.f385338b = i3;
            return this;
        }

        public c f(int i3) {
            this.f385343g = i3;
            return this;
        }

        public c g(int i3) {
            this.f385341e = i3;
            return this;
        }

        public c h(int i3) {
            this.f385344h = i3;
            return this;
        }

        public c i(String str) {
            this.f385337a = str;
            return this;
        }

        public c j(int i3) {
            this.f385342f = i3;
            return this;
        }

        c() {
            this.f385337a = "video/avc";
            this.f385338b = -1;
            this.f385339c = -1;
            this.f385340d = -1;
            this.f385341e = -1;
            this.f385342f = -1;
            this.f385343g = -1;
            this.f385344h = -1;
            this.f385345i = MediaCodecEncodeType.SURFACE;
        }
    }

    public static b c() {
        return new b();
    }

    public static c d() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(int[] iArr) {
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 != 39) {
                switch (i16) {
                    case 19:
                        d.b("SR_MP4_Factory", 1, "COLOR_FormatYUV420Planar");
                        break;
                    case 20:
                        d.b("SR_MP4_Factory", 1, "COLOR_FormatYUV420PackedPlanar");
                        break;
                    case 21:
                        d.b("SR_MP4_Factory", 1, "COLOR_FormatYUV420SemiPlanar");
                        break;
                }
            } else {
                d.b("SR_MP4_Factory", 1, "COLOR_FormatYUV420PackedSemiPlanar");
            }
            i3 = i16;
            if (i3 > 0) {
                if (i3 > 0) {
                    return 21;
                }
                return i3;
            }
        }
        if (i3 > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= codecCount || mediaCodecInfo != null) {
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        z16 = false;
                        break;
                    }
                    if (supportedTypes[i16].equals(str)) {
                        break;
                    }
                    i16++;
                }
                if (z16) {
                    mediaCodecInfo = codecInfoAt;
                }
            }
            i3++;
        }
        if (mediaCodecInfo == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        d.b("SR_MP4_Factory", 1, "getMediaCodecList: " + mediaCodecInfo.getName());
        return capabilitiesForType.colorFormats;
    }
}
