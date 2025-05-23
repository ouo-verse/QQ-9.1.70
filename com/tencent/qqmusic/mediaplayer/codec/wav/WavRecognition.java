package com.tencent.qqmusic.mediaplayer.codec.wav;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WavRecognition implements IAudioRecognition {
    public static boolean isWav(IDataSource iDataSource) {
        byte[] bArr = new byte[4];
        try {
            iDataSource.readAt(0L, bArr, 0, 4);
        } catch (IOException unused) {
        }
        if (bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70) {
            return true;
        }
        try {
            iDataSource.readAt(8L, bArr, 0, 4);
        } catch (IOException unused2) {
        }
        if (bArr[0] != 87 || bArr[1] != 65 || bArr[2] != 86 || bArr[3] != 69) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        if (WaveReader.isWavFormat(str)) {
            return AudioFormat.AudioType.WAV;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(".wav")) {
            return AudioFormat.AudioType.WAV;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
