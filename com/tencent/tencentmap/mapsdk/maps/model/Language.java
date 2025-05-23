package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum Language implements ILanguage {
    zh(1),
    zh_TW(2),
    en(3);

    private final int thisLanguageType;

    Language(int i3) {
        this.thisLanguageType = i3;
    }

    public static Language wrap(int i3) {
        for (Language language : values()) {
            if (language.getLanguageType() == i3) {
                return language;
            }
        }
        return zh;
    }

    public final int getLanguageType() {
        return this.thisLanguageType;
    }
}
