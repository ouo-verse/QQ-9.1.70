package com.tencent.karaoke.audiobasesdk.detect;

import com.tencent.component.utils.LogUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/detect/AudioQualityDetector;", "", "()V", "audioQualityBridge", "Lcom/tencent/karaoke/audiobasesdk/detect/AudioQualityNativeBridge;", "audioVolumeBridge", "Lcom/tencent/karaoke/audiobasesdk/detect/AudioVolumeNativeBridge;", "detectClip", "", "inBuffer", "", "detectVolume", "", "init", "", "channels", "sampleRate", "unInit", "Companion", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class AudioQualityDetector {
    public static final int ERROR_QUALITY_CLIP_CODE = -101;
    public static final int ERROR_VOLUME_CODE = -100;

    @NotNull
    public static final String TAG = "AudioQualityDetector";
    private AudioQualityNativeBridge audioQualityBridge;
    private AudioVolumeNativeBridge audioVolumeBridge;

    public final boolean detectClip(@Nullable byte[] inBuffer) {
        if (inBuffer == null) {
            LogUtil.e(TAG, "detectClip, null inBuffer");
            return false;
        }
        AudioQualityNativeBridge audioQualityNativeBridge = this.audioQualityBridge;
        if (audioQualityNativeBridge == null) {
            return false;
        }
        return audioQualityNativeBridge.clippingDetect(inBuffer, inBuffer.length);
    }

    public final int detectVolume(@Nullable byte[] inBuffer) {
        int i3;
        if (inBuffer == null) {
            return -100;
        }
        AudioVolumeNativeBridge audioVolumeNativeBridge = this.audioVolumeBridge;
        if (audioVolumeNativeBridge != null) {
            i3 = audioVolumeNativeBridge.volumeDetect(inBuffer, inBuffer.length);
        } else {
            i3 = -999;
        }
        if (i3 == -999) {
            return -100;
        }
        return i3;
    }

    public final void init(int channels, int sampleRate) {
        if (AudioQualityNativeBridge.INSTANCE.isLoaded() && AudioVolumeNativeBridge.INSTANCE.isLoaded()) {
            if (this.audioQualityBridge == null) {
                AudioQualityNativeBridge audioQualityNativeBridge = new AudioQualityNativeBridge();
                this.audioQualityBridge = audioQualityNativeBridge;
                if (audioQualityNativeBridge.initClipDetector(channels, sampleRate)) {
                    AudioQualityNativeBridge audioQualityNativeBridge2 = this.audioQualityBridge;
                    if (audioQualityNativeBridge2 != null) {
                        audioQualityNativeBridge2.setEnabled(true);
                    }
                } else {
                    LogUtil.e(TAG, "audioQualityBridge init fail");
                }
            }
            if (this.audioVolumeBridge == null) {
                AudioVolumeNativeBridge audioVolumeNativeBridge = new AudioVolumeNativeBridge();
                this.audioVolumeBridge = audioVolumeNativeBridge;
                if (!audioVolumeNativeBridge.initVolumeDetector()) {
                    LogUtil.e(TAG, "audioVolumeBridge init fail");
                }
            }
        }
    }

    public final void unInit() {
        AudioQualityNativeBridge audioQualityNativeBridge = this.audioQualityBridge;
        if (audioQualityNativeBridge != null) {
            audioQualityNativeBridge.unInitClipDetector();
        }
        AudioVolumeNativeBridge audioVolumeNativeBridge = this.audioVolumeBridge;
        if (audioVolumeNativeBridge != null) {
            audioVolumeNativeBridge.unInit();
        }
    }
}
