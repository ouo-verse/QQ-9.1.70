package org.tencwebrtc;

import android.support.annotation.Nullable;
import android.view.Surface;
import java.util.Arrays;
import java.util.LinkedHashSet;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.VideoDecoder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DefaultVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "DefaultVideoDecoderFactory";
    private final VideoDecoderFactory hardwareVideoDecoderFactory;

    @Nullable
    private final VideoDecoderFactory platformSoftwareVideoDecoderFactory;
    private final VideoDecoderFactory softwareVideoDecoderFactory;

    public DefaultVideoDecoderFactory(@Nullable EglBase.Context context) {
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(context);
        this.platformSoftwareVideoDecoderFactory = new PlatformSoftwareVideoDecoderFactory(context);
    }

    public static long getDecodeTimeMs() {
        return MediaCodecVideoDecoderFactory.getDecodeTimeMs();
    }

    public static long getFrameHeight() {
        return MediaCodecVideoDecoderFactory.getFrameHeight();
    }

    public static long getFrameWidth() {
        return MediaCodecVideoDecoderFactory.getFrameWidth();
    }

    public static long getFramesDecoded() {
        return MediaCodecVideoDecoderFactory.getFramesDecoded();
    }

    public static void setCallback(VideoDecoder.DecodeCallback decodeCallback) {
        AndroidVideoDecoder.setCallback(decodeCallback);
        EglRenderer.setCallback(decodeCallback);
    }

    public static void setDeviceType(boolean z16) {
        MediaCodecWrapperFactoryImpl.setDeviceType(z16);
    }

    public static void setLowLatency(boolean z16) {
        MediaCodecWrapperFactoryImpl.setLowLatency(z16);
    }

    public static void setSkipRender(boolean z16) {
        AndroidVideoDecoder.setSkipRender(z16);
        Logging.v(TAG, "DefaultVideoDecoderFactory, setSkipRender=" + z16);
    }

    public static void setSurface(Surface surface) {
        MediaCodecVideoDecoderFactory.setSurface(surface);
        Logging.v(TAG, "DefaultVideoDecoderFactory, setsurface");
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return ae.a(this, str);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Logging.d(TAG, "softwareVideoDecoderFactory");
        linkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
        Logging.d(TAG, "hardwareVideoDecoderFactory");
        linkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
        if (this.platformSoftwareVideoDecoderFactory != null) {
            Logging.d(TAG, "platformSoftwareVideoDecoderFactory");
            linkedHashSet.addAll(Arrays.asList(this.platformSoftwareVideoDecoderFactory.getSupportedCodecs()));
        }
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoDecoderFactory videoDecoderFactory;
        VideoDecoder createDecoder = this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo);
        VideoDecoder createDecoder2 = this.hardwareVideoDecoderFactory.createDecoder(videoCodecInfo);
        if (createDecoder == null && (videoDecoderFactory = this.platformSoftwareVideoDecoderFactory) != null) {
            createDecoder = videoDecoderFactory.createDecoder(videoCodecInfo);
        }
        if (createDecoder2 == null || createDecoder == null) {
            return createDecoder2 != null ? createDecoder2 : createDecoder;
        }
        return new VideoDecoderFallback(createDecoder, createDecoder2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
        this.softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
        this.hardwareVideoDecoderFactory = videoDecoderFactory;
        this.platformSoftwareVideoDecoderFactory = null;
    }
}
