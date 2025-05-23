package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

/* loaded from: classes23.dex */
public class MP3Recognition implements IAudioRecognition {
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        if (MP3FileCheck.isMp3File(str)) {
            return AudioFormat.AudioType.MP3;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        if (!TextUtils.isEmpty(str) && (str.toLowerCase().endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION) || str.endsWith(".mp3.tmp") || str.endsWith(".mp3.mqcc") || str.endsWith(".ofl") || str.endsWith(".efe"))) {
            return AudioFormat.AudioType.MP3;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
