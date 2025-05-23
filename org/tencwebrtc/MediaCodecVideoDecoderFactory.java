package org.tencwebrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.support.annotation.Nullable;
import android.view.Surface;
import java.util.ArrayList;
import org.tencwebrtc.EglBase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class MediaCodecVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";

    @Nullable
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;

    @Nullable
    private final EglBase.Context sharedContext;

    public MediaCodecVideoDecoderFactory(@Nullable EglBase.Context context, @Nullable Predicate<MediaCodecInfo> predicate) {
        this.sharedContext = context;
        this.codecAllowedPredicate = predicate;
    }

    @Nullable
    private MediaCodecInfo findCodecForType(VideoCodecType videoCodecType) {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, videoCodecType)) {
                return mediaCodecInfo;
            }
        }
        return null;
    }

    public static long getDecodeTimeMs() {
        return AndroidVideoDecoder.getDecodeTimeMs();
    }

    public static long getFrameHeight() {
        return AndroidVideoDecoder.getFrameHeight();
    }

    public static long getFrameWidth() {
        return AndroidVideoDecoder.getFrameWidth();
    }

    public static long getFramesDecoded() {
        return AndroidVideoDecoder.getFramesDecoded();
    }

    private boolean isCodecAllowed(MediaCodecInfo mediaCodecInfo) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(mediaCodecInfo);
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) {
            return true;
        }
        return false;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecType videoCodecType) {
        mediaCodecInfo.getName();
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecType)) {
            return false;
        }
        try {
            if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecType.mimeType())) == null) {
                return false;
            }
            boolean isCodecAllowed = isCodecAllowed(mediaCodecInfo);
            if (isCodecAllowed) {
                Logging.d(TAG, "codec name=" + mediaCodecInfo.getName());
            }
            return isCodecAllowed;
        } catch (IllegalArgumentException e16) {
            Logging.e(TAG, "Cannot retrieve decoder capabilities", e16);
            return false;
        }
    }

    public static void setDeviceType(boolean z16) {
        MediaCodecWrapperFactoryImpl.setDeviceType(z16);
    }

    public static void setLowLatency(boolean z16) {
        MediaCodecWrapperFactoryImpl.setLowLatency(z16);
    }

    public static void setSkipRender(boolean z16) {
        AndroidVideoDecoder.setSkipRender(z16);
    }

    public static void setSurface(Surface surface) {
        AndroidVideoDecoder.setSurface(surface);
        Logging.v(TAG, "MediaCodecVideoDecoderFactory, setsurface");
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return ae.a(this, str);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecType[] videoCodecTypeArr = {VideoCodecType.H264, VideoCodecType.H265};
        for (int i3 = 0; i3 < 2; i3++) {
            VideoCodecType videoCodecType = videoCodecTypeArr[i3];
            MediaCodecInfo findCodecForType = findCodecForType(videoCodecType);
            if (findCodecForType != null) {
                String name = videoCodecType.name();
                if (videoCodecType == VideoCodecType.H264 && isH264HighProfileSupported(findCodecForType)) {
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, true)));
                }
                Logging.d(TAG, "Add supported codec " + videoCodecType);
                arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(videoCodecType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecType valueOf = VideoCodecType.valueOf(videoCodecInfo.getName());
        MediaCodecInfo findCodecForType = findCodecForType(valueOf);
        if (findCodecForType == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), findCodecForType.getName(), valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, findCodecForType.getCapabilitiesForType(valueOf.mimeType())).intValue(), this.sharedContext);
    }
}
