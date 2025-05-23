package com.tencent.thumbplayer.core.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes26.dex */
public final class TPAudioPassThroughCapabilities {
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;
    public static final TPAudioPassThroughCapabilities DEFAULT_AUDIO_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[]{2}, 8);
    private static final TPAudioPassThroughCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[]{2, 5, 6}, 8);

    public TPAudioPassThroughCapabilities(@Nullable int[] iArr, int i3) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.supportedEncodings = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i3;
    }

    public static TPAudioPassThroughCapabilities getCapabilities(Context context) {
        return getCapabilities(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TPAudioPassThroughCapabilities)) {
            return false;
        }
        TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities = (TPAudioPassThroughCapabilities) obj;
        if (Arrays.equals(this.supportedEncodings, tPAudioPassThroughCapabilities.supportedEncodings) && this.maxChannelCount == tPAudioPassThroughCapabilities.maxChannelCount) {
            return true;
        }
        return false;
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public int hashCode() {
        return this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
    }

    public boolean supportsEncoding(int i3) {
        if (Arrays.binarySearch(this.supportedEncodings, i3) >= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"InlinedApi"})
    public static TPAudioPassThroughCapabilities getCapabilities(Context context, @Nullable Intent intent) {
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new TPAudioPassThroughCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return DEFAULT_AUDIO_CAPABILITIES;
    }
}
