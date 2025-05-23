package com.tencent.qqlive.tvkplayer.postprocess.api;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.TVKVideoFxType;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKPostProcessorFactory {
    private static final String TAG = "TVKPlayer[TVKPostProcessorFactory]";

    /* renamed from: com.tencent.qqlive.tvkplayer.postprocess.api.TVKPostProcessorFactory$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType;

        static {
            int[] iArr = new int[TVKVideoFxType.values().length];
            $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType = iArr;
            try {
                iArr[TVKVideoFxType.EFFECT_VR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_SDR_ENHANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_COLOR_BLINDNESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_SUPER_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_COLOR_CORRECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_GAUSSIAN_BLUR_VIDEO_OVERLAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_DOLBY_VISION_SOFT_RENDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[TVKVideoFxType.EFFECT_TVM_SUPER_RESOLUTION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[TVKAudioEffectType.values().length];
            $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType = iArr2;
            try {
                iArr2[TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_SURROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType[TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_PANO_SURROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType[TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_CLEAR_VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType[TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_LIVE_CONCERT.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static <T extends ITVKAudioFx> T createAudioFx(TVKAudioEffectType tVKAudioEffectType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$audio$TVKAudioEffectType[tVKAudioEffectType.ordinal()];
        if (i3 == 1) {
            return (T) createAudioFx("com.tencent.qqlive.tvkplayer.postprocess.tpprocessor.TVKSurroundFx");
        }
        if (i3 == 2) {
            return (T) createAudioFx("com.tencent.qqlive.tvkplayer.postprocess.tpprocessor.TVKPanoSurroundFx");
        }
        if (i3 == 3) {
            return (T) createAudioFx("com.tencent.qqlive.tvkplayer.postprocess.tpprocessor.TVKClearVoiceFx");
        }
        if (i3 != 4) {
            return null;
        }
        return (T) createAudioFx("com.tencent.qqlive.tvkplayer.postprocess.tpprocessor.TVKLiveConcertFx");
    }

    public static ITVKMonetSurfaceTexture createMonetSurfaceTexture(SurfaceTexture surfaceTexture, boolean z16) {
        try {
            return (ITVKMonetSurfaceTexture) Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKMonetSurfaceTexture").getConstructor(SurfaceTexture.class, Boolean.TYPE).newInstance(surfaceTexture, Boolean.valueOf(z16));
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "createMonetSurfaceTexture has exception:" + th5.toString());
            return null;
        }
    }

    public static <T extends ITVKVideoFx> T createVideoFx(TVKVideoFxType tVKVideoFxType) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$qqlive$tvkplayer$api$postprocess$effect$video$TVKVideoFxType[tVKVideoFxType.ordinal()]) {
            case 1:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKVRFxV2");
            case 2:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKSDREnhanceFx");
            case 3:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKColorBlindnessFx");
            case 4:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKSuperResolutionFx");
            case 5:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKColorCorrectionFx");
            case 6:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKGaussianBlurVideoOverlayFx");
            case 7:
                return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKDolbyVisionSoftRenderFx");
            case 8:
                try {
                    return (T) createVideoFx("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKTVMSuperResolutionFx");
                } catch (Exception unused) {
                    return null;
                }
            default:
                return null;
        }
    }

    public static ITVKVideoFxProcessorInternal createVideoFxProcessor(Looper looper) {
        try {
            return (ITVKVideoFxProcessorInternal) Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKMonetProcessorV2").getConstructor(Looper.class).newInstance(looper);
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "createVideoFxProcessor has exception:" + th5.toString());
            return null;
        }
    }

    private static <T extends ITVKAudioFx> T createAudioFx(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "createAudioFx has exception:" + th5.toString());
            return null;
        }
    }

    private static <T extends ITVKVideoFx> T createVideoFx(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "createVideoFx has exception:" + th5.toString());
            return null;
        }
    }
}
