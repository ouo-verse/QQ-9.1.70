package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider;

import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWOEmptyLine;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.QrcNoDecryptParserWOEmptyLine;

/* loaded from: classes22.dex */
public class WOEmptyLineProvider implements IParserProvider {

    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final WOEmptyLineProvider INSTANCE = new WOEmptyLineProvider();

        InstanceHolder() {
        }
    }

    public static WOEmptyLineProvider getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider
    public IParser createLrcParser() {
        return new LrcParserWOEmptyLine();
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider
    public IParser createQrcParser() {
        return new QrcNoDecryptParserWOEmptyLine();
    }

    WOEmptyLineProvider() {
    }
}
