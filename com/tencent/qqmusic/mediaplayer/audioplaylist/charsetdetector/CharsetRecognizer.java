package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class CharsetRecognizer {
    public String getLanguage() {
        return null;
    }

    public abstract String getName();

    public abstract CharsetMatch match(CharsetDetector charsetDetector);
}
