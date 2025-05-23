package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;

/* loaded from: classes22.dex */
public interface IParserProvider {
    IParser createLrcParser();

    IParser createQrcParser();
}
