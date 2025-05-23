package com.qq.e.comm.constants;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.ADActivity;
import com.qq.e.tg.LandscapeADActivity;
import com.qq.e.tg.PortraitADActivity;
import com.qq.e.tg.RewardvideoLandscapeADActivity;
import com.qq.e.tg.RewardvideoPortraitADActivity;
import com.qq.e.tg.TransPortraitADActivity;

/* loaded from: classes3.dex */
public class CustomPkgConstants {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38132a = ADActivity.class.getName();

    /* renamed from: b, reason: collision with root package name */
    private static final String f38133b = PortraitADActivity.class.getName();

    /* renamed from: c, reason: collision with root package name */
    private static final String f38134c = RewardvideoPortraitADActivity.class.getName();

    /* renamed from: d, reason: collision with root package name */
    private static final String f38135d = LandscapeADActivity.class.getName();

    /* renamed from: e, reason: collision with root package name */
    private static final String f38136e = RewardvideoLandscapeADActivity.class.getName();

    /* renamed from: f, reason: collision with root package name */
    private static final String f38137f = TransPortraitADActivity.class.getName();

    private static Class a(String str) throws ClassNotFoundException {
        if (GlobalSetting.getOutDexClassLoader() != null) {
            try {
                return GlobalSetting.getOutDexClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return Class.forName(str);
    }

    public static Class getADActivityClass() throws Exception {
        return a(getADActivityName());
    }

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        if (!StringUtil.isEmpty(customADActivityClassName)) {
            return customADActivityClassName;
        }
        return f38132a;
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static Class getLandscapeADActivityClass() throws Exception {
        return a(getLandscapeADActivityName());
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        if (!StringUtil.isEmpty(customLandscapeActivityClassName)) {
            return customLandscapeActivityClassName;
        }
        return f38135d;
    }

    public static Class getPortraitADActivityClass() throws Exception {
        return a(getPortraitADActivityName());
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        if (!StringUtil.isEmpty(customPortraitActivityClassName)) {
            return customPortraitActivityClassName;
        }
        return f38133b;
    }

    public static Class getRewardvideoLandscapeADActivityClass() throws Exception {
        return a(getRewardvideoLandscapeADActivityName());
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        if (!StringUtil.isEmpty(customRewardvideoLandscapeActivityClassName)) {
            return customRewardvideoLandscapeActivityClassName;
        }
        return f38136e;
    }

    public static Class getRewardvideoPortraitADActivityClass() throws Exception {
        return a(getRewardvideoPortraitADActivityName());
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        if (!StringUtil.isEmpty(customRewardvideoPortraitActivityClassName)) {
            return customRewardvideoPortraitActivityClassName;
        }
        return f38134c;
    }

    public static String getTransPortraitADActivityClassName() {
        String customTransPortraitActivityClassName = GlobalSetting.getCustomTransPortraitActivityClassName();
        if (!StringUtil.isEmpty(customTransPortraitActivityClassName)) {
            return customTransPortraitActivityClassName;
        }
        return f38137f;
    }
}
