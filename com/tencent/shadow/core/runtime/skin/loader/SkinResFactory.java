package com.tencent.shadow.core.runtime.skin.loader;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkinResFactory {
    public static final String SKIN_THEME_APK_ASSET_DIR = "skinres";
    public static final String SKIN_THEME_APK_SAVE_DIR = "skin";
    public static final int THEMEID_1_DAY = 5;
    public static final int THEMEID_2_NIGHT = 15;

    public static SkinPkgInfo createResourceData(int i3) {
        if (i3 != 5) {
            if (i3 != 15) {
                return new SkinPkgInfo(5, "");
            }
            return new SkinPkgInfo(i3, "blackNight2.skin");
        }
        return new SkinPkgInfo(i3, "");
    }
}
