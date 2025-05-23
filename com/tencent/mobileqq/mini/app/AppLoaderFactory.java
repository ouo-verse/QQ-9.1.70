package com.tencent.mobileqq.mini.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.MiniAppInterface;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppLoaderFactory {
    public static final String BASE_LIB_PATH_DIR;
    public static final String PATH_WXAPKG_ROOT;
    public static final String TAG = "miniapp-start";
    public static final String TAG_CHROMIUM = "miniapp-chromium";
    public static final String TAG_JS = "miniapp-JS";
    public static final String TAG_PROCESSOR = "miniapp-process";
    public static MiniAppInterface miniAppInterface;

    static {
        String str = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
        PATH_WXAPKG_ROOT = str;
        BASE_LIB_PATH_DIR = str + ".baseLib";
    }

    public static MiniAppInterface getMiniAppInterface() {
        return miniAppInterface;
    }

    public static void setMiniAppInterface(MiniAppInterface miniAppInterface2) {
        miniAppInterface = miniAppInterface2;
    }
}
