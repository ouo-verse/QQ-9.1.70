package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.SoNotFindException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IAudioRecognition {
    AudioFormat.AudioType getAudioType(String str, byte[] bArr) throws SoNotFindException;

    AudioFormat.AudioType guessAudioType(String str);
}
