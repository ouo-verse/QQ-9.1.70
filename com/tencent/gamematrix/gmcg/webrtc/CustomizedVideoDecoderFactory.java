package com.tencent.gamematrix.gmcg.webrtc;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.medialab.video.decoder.VDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.VideoCodecInfo;
import org.tencwebrtc.VideoDecoder;
import org.tencwebrtc.VideoDecoderFactory;
import org.tencwebrtc.ae;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CustomizedVideoDecoderFactory implements VideoDecoderFactory {
    private static String decoderType = null;
    private static boolean dumpVideoStreamEnabled = false;
    private static boolean isDefaultDecoder = false;
    private static int mVDecoderLevel = 4;
    private static int mVdecoderFrameRate = 60;
    private static boolean tunneledPlaybackEnabled;
    private MediaCodecList mAllCodecs;
    MediaCodecInfo[] mAllInfos;

    @Nullable
    private final EglBase.Context sharedContext;

    public CustomizedVideoDecoderFactory(@Nullable EglBase.Context context) {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        this.mAllCodecs = mediaCodecList;
        this.mAllInfos = mediaCodecList.getCodecInfos();
        CGLog.i("CustomizedVideoDecoderFactory: mAllCodecs.getCodecInfos()");
        this.sharedContext = context;
    }

    @Nullable
    private MediaCodecInfo findCodecForType(CodecMimeType codecMimeType) {
        CGLog.i("findCodecForType: " + codecMimeType);
        int length = this.mAllInfos.length;
        int i3 = 0;
        while (true) {
            MediaCodecInfo mediaCodecInfo = null;
            if (i3 >= length) {
                return null;
            }
            try {
                mediaCodecInfo = this.mAllInfos[i3];
            } catch (IllegalArgumentException e16) {
                CGLog.e("Cannot retrieve decoder codec info" + e16);
            }
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                if (isSupportedCodec(mediaCodecInfo, codecMimeType)) {
                    return mediaCodecInfo;
                }
            } else if (mediaCodecInfo == null) {
                CGLog.i("Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT");
            } else if (mediaCodecInfo.isEncoder()) {
                CGLog.i("info.isEncoder()");
            }
            i3++;
        }
    }

    public static long getDecodeTimeMs() {
        if (isDefaultDecoder) {
            return DefaultVideoDecoder.getDecodeTimeMs();
        }
        return VDecoder.d();
    }

    public static long getFrameHeight() {
        if (isDefaultDecoder) {
            return DefaultVideoDecoder.getFrameHeight();
        }
        return VDecoder.e();
    }

    public static long getFrameWidth() {
        if (isDefaultDecoder) {
            return DefaultVideoDecoder.getFrameWidth();
        }
        return VDecoder.f();
    }

    public static long getFramesDecoded() {
        if (isDefaultDecoder) {
            return DefaultVideoDecoder.getFramesDecoded();
        }
        return VDecoder.g();
    }

    private boolean isCodecAllowed(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.")) {
            return true;
        }
        return false;
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, CodecMimeType codecMimeType) {
        CGLog.i("isSupportedCodec: " + mediaCodecInfo.getName() + ", type:" + codecMimeType);
        if (!MediaCodecUtils.codecSupportsType(mediaCodecInfo, codecMimeType)) {
            CGLog.i("!MediaCodecUtils.codecSupportsType return false");
            return false;
        }
        try {
            if (MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(codecMimeType.mimeType())) == null) {
                CGLog.i("MediaCodecUtils.selectColorFormat return false");
                return false;
            }
            boolean isCodecAllowed = isCodecAllowed(mediaCodecInfo);
            if (isCodecAllowed) {
                CGLog.i("codec name=" + mediaCodecInfo.getName());
            } else {
                CGLog.i("isCodecAllowed=false, codec name=" + mediaCodecInfo.getName());
            }
            return isCodecAllowed;
        } catch (IllegalArgumentException e16) {
            CGLog.e("Cannot retrieve decoder capabilities:" + e16);
            return false;
        }
    }

    public static void setCallback(VideoDecoder.DecodeCallback decodeCallback) {
        if (isDefaultDecoder) {
            DefaultVideoDecoder.setCallback(decodeCallback);
        } else {
            VDecoder.m(decodeCallback);
        }
    }

    public static void setDecodeType(String str) {
        decoderType = str;
        if (str.equalsIgnoreCase("default")) {
            isDefaultDecoder = true;
        } else {
            isDefaultDecoder = false;
        }
        CGLog.i("  isDefaultDecoder:" + isDefaultDecoder);
    }

    public static void setDumpVideoStreamEnabled(boolean z16) {
        dumpVideoStreamEnabled = z16;
    }

    public static void setLowLatency(boolean z16) {
        if (isDefaultDecoder) {
            DefaultVideoDecoder.setLowLatency(z16);
        }
    }

    public static void setSkipRender(boolean z16) {
        if (isDefaultDecoder) {
            DefaultVideoDecoder.setSkipRender(z16);
        } else {
            VDecoder.n(z16);
        }
        CGLog.i(decoderType + " setSkipRender=" + z16);
    }

    public static void setSurface(Surface surface) {
        if (isDefaultDecoder) {
            DefaultVideoDecoder.setSurface(surface);
        } else {
            VDecoder.o(surface);
        }
    }

    public static void setTunneledPlaybackEnable(boolean z16) {
        tunneledPlaybackEnabled = z16;
    }

    public static void setVDecoderFrameRate(int i3) {
        mVdecoderFrameRate = i3;
    }

    public static void setVDecoderLogLevel(int i3) {
        mVDecoderLevel = i3;
    }

    public static void setVDecoderPerfCb(VDecoder.b bVar) {
        if (!isDefaultDecoder) {
            VDecoder.p(bVar);
        }
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return ae.a(this, str);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        CGLog.i("hardwareVideoDecoderFactory");
        linkedHashSet.addAll(Arrays.asList(supportedCodecs()));
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[linkedHashSet.size()]);
    }

    public VideoCodecInfo[] supportedCodecs() {
        ArrayList arrayList = new ArrayList();
        CodecMimeType[] codecMimeTypeArr = {CodecMimeType.VP8, CodecMimeType.VP9, CodecMimeType.H264, CodecMimeType.H265};
        for (int i3 = 0; i3 < 4; i3++) {
            CodecMimeType codecMimeType = codecMimeTypeArr[i3];
            MediaCodecInfo findCodecForType = findCodecForType(codecMimeType);
            if (findCodecForType != null) {
                String name = codecMimeType.name();
                if (codecMimeType == CodecMimeType.H264 && isH264HighProfileSupported(findCodecForType)) {
                    arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(codecMimeType, true)));
                }
                CGLog.i("Add supported codec " + codecMimeType);
                arrayList.add(new VideoCodecInfo(name, MediaCodecUtils.getCodecProperties(codecMimeType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    @Override // org.tencwebrtc.VideoDecoderFactory
    @Nullable
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        CodecMimeType valueOf = CodecMimeType.valueOf(videoCodecInfo.name);
        MediaCodecInfo findCodecForType = findCodecForType(valueOf);
        if (findCodecForType == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = findCodecForType.getCapabilitiesForType(valueOf.mimeType());
        if (isDefaultDecoder) {
            CGLog.i("Create DefaultVideoDecoder");
            return new DefaultVideoDecoder(findCodecForType.getName(), valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, capabilitiesForType).intValue());
        }
        CGLog.i("Create VDecoder, dumpVideoStreamEanble: " + dumpVideoStreamEnabled + "VDecoderLogLevel: " + mVDecoderLevel + "tunneledPlaybackEnabled: " + tunneledPlaybackEnabled);
        return new VDecoder(findCodecForType.getName(), valueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, capabilitiesForType).intValue(), dumpVideoStreamEnabled, mVDecoderLevel, tunneledPlaybackEnabled, mVdecoderFrameRate, this.sharedContext);
    }
}
