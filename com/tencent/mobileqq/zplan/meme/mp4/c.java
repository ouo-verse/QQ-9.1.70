package com.tencent.mobileqq.zplan.meme.mp4;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f334104a = "audio/mp4a-latm";

        /* renamed from: b, reason: collision with root package name */
        private int f334105b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f334106c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f334107d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f334108e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f334109f = -1;

        a() {
        }

        public MediaCodec a() {
            int i3;
            int i16;
            String mediaFormat;
            if (!TextUtils.isEmpty(this.f334104a) && (i3 = this.f334105b) != -1 && (i16 = this.f334106c) != -1 && this.f334109f != -1) {
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.f334104a, i16, i3);
                int i17 = this.f334109f;
                if (i17 != -1) {
                    createAudioFormat.setInteger("max-input-size", i17);
                }
                int i18 = this.f334107d;
                if (i18 != -1) {
                    createAudioFormat.setInteger("bitrate", i18);
                }
                int i19 = this.f334108e;
                if (i19 != -1) {
                    createAudioFormat.setInteger("aac-profile", i19);
                }
                createAudioFormat.setInteger("pcm-encoding", 2);
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f334104a);
                    createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (QLog.isColorLevel()) {
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
                        QLog.d("SR_MP4_Factory", 1, sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("audio outputFormat: ");
                        if (outputFormat != null) {
                            str = outputFormat.toString();
                        }
                        sb6.append(str);
                        QLog.d("SR_MP4_Factory", 1, sb6.toString());
                    }
                    return createEncoderByType;
                } catch (Throwable th5) {
                    QLog.e("SR_MP4_Factory", 1, "create audio encoder error:", th5);
                    return null;
                }
            }
            throw new IllegalArgumentException("build params invalid");
        }

        public a b(int i3) {
            this.f334107d = i3;
            return this;
        }

        public a c(int i3) {
            this.f334105b = i3;
            return this;
        }

        public a d(int i3) {
            this.f334109f = i3;
            return this;
        }

        public a e(String str) {
            this.f334104a = str;
            return this;
        }

        public a f(int i3) {
            this.f334108e = i3;
            return this;
        }

        public a g(int i3) {
            this.f334106c = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f334110a = "video/avc";

        /* renamed from: b, reason: collision with root package name */
        private int f334111b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f334112c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f334113d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f334114e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f334115f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f334116g = -1;

        b() {
        }

        public MediaCodec a() {
            String mediaFormat;
            String str = this.f334110a;
            if (str != null && this.f334114e != -1 && this.f334115f != -1) {
                int[] f16 = c.f(str);
                if (f16 != null) {
                    int e16 = c.e(f16);
                    QLog.e("SR_MP4_Factory", 1, "colorFormat:" + e16);
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.f334110a, this.f334114e, this.f334115f);
                    createVideoFormat.setInteger("color-format", e16);
                    int i3 = this.f334116g;
                    if (i3 != -1) {
                        createVideoFormat.setInteger("max-input-size", i3);
                    }
                    int i16 = this.f334112c;
                    if (i16 != -1) {
                        createVideoFormat.setInteger("bitrate", i16);
                    }
                    int i17 = this.f334111b;
                    if (i17 != -1) {
                        createVideoFormat.setInteger("frame-rate", i17);
                    }
                    int i18 = this.f334113d;
                    if (i18 != -1) {
                        createVideoFormat.setInteger("i-frame-interval", i18);
                    }
                    try {
                        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f334110a);
                        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                        if (QLog.isColorLevel()) {
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
                            QLog.d("SR_MP4_Factory", 1, sb5.toString());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("video outputFormat: ");
                            if (outputFormat != null) {
                                str2 = outputFormat.toString();
                            }
                            sb6.append(str2);
                            QLog.d("SR_MP4_Factory", 1, sb6.toString());
                        }
                        return createEncoderByType;
                    } catch (Throwable th5) {
                        QLog.e("SR_MP4_Factory", 1, "create video encoder error:", th5);
                        return null;
                    }
                }
                QLog.e("SR_MP4_Factory", 1, "colorFormats is null");
                return null;
            }
            throw new IllegalArgumentException("build params invalid");
        }

        public b b(int i3) {
            this.f334112c = i3;
            return this;
        }

        public b c(int i3) {
            this.f334111b = i3;
            return this;
        }

        public b d(int i3) {
            this.f334115f = i3;
            return this;
        }

        public b e(int i3) {
            this.f334113d = i3;
            return this;
        }

        public b f(int i3) {
            this.f334116g = i3;
            return this;
        }

        public b g(String str) {
            this.f334110a = str;
            return this;
        }

        public b h(int i3) {
            this.f334114e = i3;
            return this;
        }
    }

    public static a c() {
        return new a();
    }

    public static b d() {
        return new b();
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
                        QLog.e("SR_MP4_Factory", 1, "COLOR_FormatYUV420Planar");
                        break;
                    case 20:
                        QLog.e("SR_MP4_Factory", 1, "COLOR_FormatYUV420PackedPlanar");
                        break;
                    case 21:
                        QLog.e("SR_MP4_Factory", 1, "COLOR_FormatYUV420SemiPlanar");
                        break;
                }
            } else {
                QLog.e("SR_MP4_Factory", 1, "COLOR_FormatYUV420PackedSemiPlanar");
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
        QLog.e("SR_MP4_Factory", 1, "getMediaCodecList: " + mediaCodecInfo.getName());
        return capabilitiesForType.colorFormats;
    }
}
