package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWEmptyLine;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.QrcNoDecryptParserWEmptyLine;

/* loaded from: classes22.dex */
public class WEmptyLineProvider implements IParserProvider {

    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final WEmptyLineProvider INSTANCE = new WEmptyLineProvider();

        InstanceHolder() {
        }
    }

    public static WEmptyLineProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider
    public IParser createLrcParser() {
        return new LrcParserWEmptyLine();
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider
    public IParser createQrcParser() {
        return new QrcNoDecryptParserWEmptyLine();
    }

    WEmptyLineProvider() {
    }
}
