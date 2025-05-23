package com.tencent.qcircle.weseevideo.editor.sticker.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.LyricParserManager;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WEmptyLineProvider;

/* loaded from: classes22.dex */
public class LyricParseHelper {
    public static final String LYRIC_FROMAT_LRC = "LRC";
    public static final String LYRIC_FROMAT_QRC = "QRC";
    private static final String TAG = "LyricParseHelper";

    @Deprecated
    public static Lyric parseTextToLyric(String str, boolean z16) {
        return parseTextToLyric(WEmptyLineProvider.class, str, z16);
    }

    public static <T extends IParserProvider> void registerParserProvider(@NonNull Class<T> cls, @NonNull T t16) {
        LyricParserManager.getInstance().registerProvider(cls, t16);
    }

    public static <T extends IParserProvider> Lyric parseTextToLyric(@NonNull Class<T> cls, @Nullable String str, boolean z16) {
        Lyric parse;
        if (str == null || str.length() <= 0) {
            return null;
        }
        IParserProvider provider = LyricParserManager.getInstance().getProvider(cls);
        try {
            if (z16) {
                IParser createQrcParser = provider.createQrcParser();
                createQrcParser.init(str);
                parse = createQrcParser.parse();
            } else {
                IParser createLrcParser = provider.createLrcParser();
                createLrcParser.init(str);
                parse = createLrcParser.parse();
            }
            if (parse == null) {
                return null;
            }
            if (parse.mSentences.size() > 0) {
                return parse;
            }
            return null;
        } catch (Exception e16) {
            Log.e(TAG, "parse exception:", e16);
            return null;
        }
    }
}
