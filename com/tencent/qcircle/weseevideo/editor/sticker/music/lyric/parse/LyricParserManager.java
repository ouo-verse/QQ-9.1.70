package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WEmptyLineProvider;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class LyricParserManager {
    private HashMap<String, IParserProvider> mProviderMap;

    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final LyricParserManager INSTANCE = new LyricParserManager();

        InstanceHolder() {
        }
    }

    public static LyricParserManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public <T extends IParserProvider> IParserProvider getProvider(@NonNull Class<T> cls) {
        IParserProvider iParserProvider = this.mProviderMap.get(cls.getName());
        return iParserProvider == null ? getProvider() : iParserProvider;
    }

    public <T extends IParserProvider> void registerProvider(@NonNull Class<T> cls, @NonNull T t16) {
        this.mProviderMap.put(cls.getName(), t16);
    }

    LyricParserManager() {
        this.mProviderMap = new HashMap<>();
        registerProvider(WEmptyLineProvider.class, WEmptyLineProvider.getInstance());
        registerProvider(WOEmptyLineProvider.class, WOEmptyLineProvider.getInstance());
    }

    public <T extends IParserProvider> IParserProvider getProvider() {
        return WOEmptyLineProvider.getInstance();
    }
}
