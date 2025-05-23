package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VorbisRecognition implements IAudioRecognition {
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("OggS")) {
            return AudioFormat.AudioType.OGG;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(".ogg")) {
            return AudioFormat.AudioType.OGG;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
