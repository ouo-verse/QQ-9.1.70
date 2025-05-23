package org.tencwebrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Surface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {
    public static boolean enableTunnel = false;
    private static boolean isTvDevice = false;
    private static boolean lowLatency = true;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private static final String TAG = "MediaCodecWrapperImpl";
        private final MediaCodec mediaCodec;

        public MediaCodecWrapperImpl(MediaCodec mediaCodec) {
            this.mediaCodec = mediaCodec;
        }

        @TargetApi(18)
        private int configureLowLatency(MediaFormat mediaFormat, int i3) {
            String name = this.mediaCodec.getName();
            Logging.d(TAG, "codecName: " + name + " isTvDevice: " + MediaCodecWrapperFactoryImpl.isTvDevice);
            if ("OMX.qcom.video.decoder.avc".equalsIgnoreCase(name) || "c2.qti.avc.decoder".equalsIgnoreCase(name) || "OMX.qcom.video.decoder.hevc".equalsIgnoreCase(name) || "c2.qti.hevc.decoder".equalsIgnoreCase(name)) {
                mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
                Logging.d(TAG, "codecName: " + name + " low latency enabled");
            }
            int i16 = 2;
            if ("OMX.hisi.video.decoder.avc".equalsIgnoreCase(name) || "OMX.hisi.video.decoder.hevc".equalsIgnoreCase(name) || name.toUpperCase(Locale.ROOT).startsWith("C2.HISI")) {
                mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
                mediaFormat.setInteger("fast-output-mode", 1);
                if (MediaCodecWrapperFactoryImpl.isTvDevice && Build.VERSION.SDK_INT < 30) {
                    i3 = 2;
                }
                Logging.d(TAG, "codecName: " + name + " low latency fast output enabled, flags=" + i3);
            }
            if ("OMX.MS.AVC.Decoder".equalsIgnoreCase(name) || "OMX.MS.HEVC.Decoder".equalsIgnoreCase(name)) {
                mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
                if (MediaCodecWrapperFactoryImpl.isTvDevice && Build.VERSION.SDK_INT < 30) {
                    i3 = 2;
                }
                Logging.d(TAG, "codecName: " + name + "vendor low latency enabled, flags=" + i3);
            }
            if ("OMX.GK.AVC.Decoder".equalsIgnoreCase(name) || "OMX.GK.HEVC.Decoder".equalsIgnoreCase(name)) {
                mediaFormat.setInteger("goke.lowlatency.enable", 1);
                Logging.d(TAG, "codecName: " + name + " low latency enabled");
            }
            Locale locale = Locale.ROOT;
            if (name.toUpperCase(locale).startsWith("OMX.AMLOGIC") || name.toUpperCase(locale).startsWith("C2.AMLOGIC")) {
                mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
                mediaFormat.setInteger("vendor.low-latency.enable", 1);
                Logging.d(TAG, "codecName: " + name + " due low latency enabled");
            }
            if (name.toUpperCase(locale).startsWith("OMX.MTK") || name.toUpperCase(locale).startsWith("OMX.NVT")) {
                mediaFormat.setInteger("vendor.START.low-latency.enable", 1);
                if (!MediaCodecWrapperFactoryImpl.isTvDevice || Build.VERSION.SDK_INT >= 30) {
                    i16 = i3;
                }
                Logging.d(TAG, "codecName: " + name + "vendor low latency enabled, flags=" + i16);
                i3 = i16;
            }
            if ((name.toUpperCase(locale).startsWith("OMX.EXYNOS") || name.toUpperCase(locale).startsWith("C2.EXYNOS")) && Build.VERSION.SDK_INT >= 26) {
                mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
                Logging.d(TAG, "codecName: " + name + " vendor.rtc-ext-dec-low-latency.enable, flags=" + i3);
            }
            String property = System.getProperty("cloudgame.tunnel");
            if (!new File(Environment.getDataDirectory().getAbsolutePath() + "/cloudgame.tunnel").exists() && (property == null || !property.equals("1"))) {
                MediaCodecWrapperFactoryImpl.enableTunnel = false;
            } else {
                MediaCodecWrapperFactoryImpl.enableTunnel = true;
            }
            if (MediaCodecWrapperFactoryImpl.enableTunnel) {
                mediaFormat.setFeatureEnabled("tunneled-playback", true);
                Log.i(TAG, "codecName: " + name + " enable tunnelled playback");
            } else {
                Log.i(TAG, "codecName: " + name + " not enable tunnelled playback");
            }
            return i3;
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3) {
            Logging.d(TAG, "configure:  low latency enable: " + MediaCodecWrapperFactoryImpl.lowLatency);
            if (MediaCodecWrapperFactoryImpl.lowLatency) {
                i3 = configureLowLatency(mediaFormat, i3);
                int i16 = Build.VERSION.SDK_INT;
                if (i16 >= 30) {
                    String name = this.mediaCodec.getName();
                    if (!"OMX.hisi.video.decoder.avc".equalsIgnoreCase(name) && !"OMX.hisi.video.decoder.hevc".equalsIgnoreCase(name)) {
                        Locale locale = Locale.ROOT;
                        if (!name.toUpperCase(locale).startsWith("C2.HISI") && !name.toUpperCase(locale).startsWith("OMX.MTK")) {
                            mediaFormat.setInteger("low-latency", 1);
                            Logging.d(TAG, name + " decoder set low-latency to 1");
                        }
                    }
                    Logging.d(TAG, name + " decoder not set low-latency to 1");
                } else if (i16 > 23) {
                    mediaFormat.setInteger("vdec-lowlatency", 1);
                }
            }
            this.mediaCodec.configure(mediaFormat, surface, mediaCrypto, i3);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        @TargetApi(18)
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public int dequeueInputBuffer(long j3) {
            return this.mediaCodec.dequeueInputBuffer(j3);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j3) {
            return this.mediaCodec.dequeueOutputBuffer(bufferInfo, j3);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void flush() {
            this.mediaCodec.flush();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            return this.mediaCodec.getInputBuffers();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            return this.mediaCodec.getOutputBuffers();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            return this.mediaCodec.getOutputFormat();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
            this.mediaCodec.queueInputBuffer(i3, i16, i17, j3, i18);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void releaseOutputBuffer(int i3, boolean z16) {
            this.mediaCodec.releaseOutputBuffer(i3, z16);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        @TargetApi(19)
        public void setParameters(Bundle bundle) {
            this.mediaCodec.setParameters(bundle);
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // org.tencwebrtc.MediaCodecWrapper
        public void releaseOutputBuffer(int i3, long j3) {
            this.mediaCodec.releaseOutputBuffer(i3, j3);
        }
    }

    public static void setDeviceType(boolean z16) {
        isTvDevice = z16;
        Logging.d("MediaCodecWrapperFactoryImpl", "setDeviceType isTv: " + z16);
    }

    public static void setLowLatency(boolean z16) {
        lowLatency = z16;
    }

    @Override // org.tencwebrtc.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String str) throws IOException {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(str));
    }
}
