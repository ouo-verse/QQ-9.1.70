package com.tencent.thumbplayer.core.codec.capability;

import com.tencent.thumbplayer.core.codec.common.TPMimeTypes;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;

/* loaded from: classes26.dex */
public class TPMediaCodecCapabilityForWanosFromSystemProperty {
    private static final String SYSTEMPROP_AUDIO_DECODER_WANOS_ENABLE = "ro.vendor.audio.wanos.enable";
    private static Boolean sIsCurrentDeviceSupportWanosAudioDecode;

    private static boolean getIsWanosAudioDecodeSupported() {
        return "true".equalsIgnoreCase(TPSystemInfo.getSystemProp(SYSTEMPROP_AUDIO_DECODER_WANOS_ENABLE, "false"));
    }

    public static boolean isWanosAudioDecodeSupported() {
        if (sIsCurrentDeviceSupportWanosAudioDecode == null) {
            synchronized (TPMediaCodecCapabilityForWanosFromSystemProperty.class) {
                if (sIsCurrentDeviceSupportWanosAudioDecode == null) {
                    sIsCurrentDeviceSupportWanosAudioDecode = Boolean.valueOf(getIsWanosAudioDecodeSupported());
                }
            }
        }
        return sIsCurrentDeviceSupportWanosAudioDecode.booleanValue();
    }

    public static boolean isWanosAudioType(String str) {
        if (TPMimeTypes.AUDIO_CAVS.equals(str)) {
            return true;
        }
        return false;
    }
}
