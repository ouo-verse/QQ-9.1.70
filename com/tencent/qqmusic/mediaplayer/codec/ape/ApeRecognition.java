package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApeRecognition implements IAudioRecognition {
    public static final String TAG = "ApeRecognition";

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AudioInformation audioInformation;
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith(Global.TRACKING_MAC)) {
            return AudioFormat.AudioType.APE;
        }
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        NativeDecoder nativeDecoder = new NativeDecoder();
        if (nativeDecoder.init(new FileDataSource(str)) == 0 && (audioInformation = nativeDecoder.getAudioInformation()) != null) {
            AudioFormat.AudioType audioType2 = audioInformation.getAudioType();
            AudioFormat.AudioType audioType3 = AudioFormat.AudioType.APE;
            if (audioType2 == audioType3) {
                return audioType3;
            }
            return audioType;
        }
        return audioType;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        if (!TextUtils.isEmpty(str) && (str.toLowerCase().contains(".ape") || str.toLowerCase().contains(".mac"))) {
            return AudioFormat.AudioType.APE;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
