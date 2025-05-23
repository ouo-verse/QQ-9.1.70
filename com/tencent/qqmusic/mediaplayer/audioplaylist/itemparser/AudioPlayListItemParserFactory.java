package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

/* loaded from: classes23.dex */
public class AudioPlayListItemParserFactory {
    public static AudioPlayListItemParser createParser(String str) {
        if (!str.startsWith("http") && str.endsWith(".cue")) {
            return new CueItemParser(str);
        }
        return null;
    }
}
