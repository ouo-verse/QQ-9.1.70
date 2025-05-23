package com.tencent.mobileqq.pluginsdk;

import android.content.Context;

/* loaded from: classes16.dex */
public interface IPluginAdapter {
    public static final int CMD_GET_THREAD_LOOPER = 2;
    public static final int CMD_IS_NIGHT_MODE = 1;
    public static final int CMD_IS_SUPPORT_IMMERSIVE = 5;
    public static final int CMD_IS_SUPPORT_MUTILDEX = 4;
    public static final int CMD_IS_THEME_DEFAULT_MODE = 3;

    void initSkin(Context context);

    void initSkinEngine(Context context) throws Exception;

    Object invoke(int i3, Object obj);

    boolean isBuiltinPluginAndUpToDay(String str, PluginBaseInfo pluginBaseInfo);
}
