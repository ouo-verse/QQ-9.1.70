package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;

/* loaded from: classes22.dex */
public interface IParser {
    void init(@NonNull String str);

    Lyric parse();
}
