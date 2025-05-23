package com.tencent.shadow.core.runtime.skin.loader;

import android.os.Environment;
import java.io.File;

/* loaded from: classes25.dex */
public class SkinPkgInfo {
    private int mSkinId;
    private String mSkinName;
    private static final String SKIN_NAME = "blackNight2.skin";
    private static final String SKIN_DIR = Environment.getExternalStorageDirectory() + File.separator + SKIN_NAME;

    /* JADX INFO: Access modifiers changed from: protected */
    public SkinPkgInfo(int i3, String str) {
        this.mSkinId = i3;
        this.mSkinName = str;
    }

    public static String getAssetDir() {
        return SkinResFactory.SKIN_THEME_APK_ASSET_DIR;
    }

    public static String getInstallDir() {
        return ContextHolder.getContext().getFilesDir() + "/" + SkinResFactory.SKIN_THEME_APK_SAVE_DIR;
    }

    public String getAssetPath() {
        return this.mSkinName;
    }

    public String getInstallPath() {
        return ContextHolder.getContext().getFilesDir() + "/" + SkinResFactory.SKIN_THEME_APK_SAVE_DIR + "/blackNight2.skin";
    }

    public int getSkinId() {
        return this.mSkinId;
    }

    public String getSkinName() {
        return this.mSkinName;
    }
}
