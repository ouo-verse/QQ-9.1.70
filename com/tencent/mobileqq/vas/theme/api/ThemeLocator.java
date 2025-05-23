package com.tencent.mobileqq.vas.theme.api;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeLocator {
    private static final HashMap<String, ThemeLocator> sScidToLocators = new HashMap<>();
    private String themeId;
    private String unzipPath;
    private String zipPath;

    private static void createDir(ThemeLocator themeLocator) {
        try {
            File file = new File(themeLocator.getUnzipPath());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e16) {
            QLog.e("ThemeLocator", 1, "createDir error", e16);
        }
    }

    public static ThemeLocator getLocator(String str) {
        HashMap<String, ThemeLocator> hashMap = sScidToLocators;
        ThemeLocator themeLocator = hashMap.get(str);
        if (themeLocator == null) {
            synchronized (hashMap) {
                themeLocator = hashMap.get(str);
                if (themeLocator == null) {
                    themeLocator = new ThemeLocator();
                    themeLocator.setThemeId(ThemeUtil.getIDFromSCID(str));
                    hashMap.put(str, themeLocator);
                }
            }
        }
        return themeLocator;
    }

    public String getBasePath(Context context) {
        String absolutePath = context.getDir(QQTheme.INTERNAL_THEME_DIR_810, 0).getAbsolutePath();
        StringBuilder obtain = StringBuilderUtils.obtain();
        obtain.append(absolutePath);
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            obtain.append(str);
        }
        obtain.append(this.themeId);
        obtain.append(str);
        return obtain.toString();
    }

    public String getCfgPath(Context context) {
        String basePath = getBasePath(context);
        StringBuilder obtain = StringBuilderUtils.obtain();
        obtain.append(basePath);
        obtain.append("3_");
        obtain.append(getCfgScid());
        obtain.append(PluginUtils.CONFIG_FILE_EXTEND_NAME);
        return obtain.toString();
    }

    public String getCfgScid() {
        return ThemeUtil.getThemeConfigID(this.themeId);
    }

    public ThemeLocator getDIYLocator() {
        ThemeLocator init = setThemeId("999").init(BaseApplication.getContext(), "999_empty", "999_empty");
        createDir(init);
        return init;
    }

    public String getThemeId() {
        return this.themeId;
    }

    public String getUnzipPath() {
        return this.unzipPath;
    }

    public String getZipPath() {
        return this.zipPath;
    }

    public ThemeLocator init(Context context, String str, String str2) {
        String basePath = getBasePath(context);
        StringBuilder obtain = StringBuilderUtils.obtain();
        obtain.append(basePath);
        obtain.append(str);
        obtain.append(".zip");
        this.zipPath = obtain.toString();
        StringBuilder obtain2 = StringBuilderUtils.obtain();
        obtain2.append(basePath);
        obtain2.append(str);
        String str3 = File.separator;
        obtain2.append(str3);
        obtain2.append(str2);
        obtain2.append(str3);
        this.unzipPath = obtain2.toString();
        return this;
    }

    public ThemeLocator initLocalTheme() {
        return init(BaseApplication.getContext(), "test", "test");
    }

    public boolean isUnzipDirExist() {
        return new File(this.unzipPath).exists();
    }

    public boolean isZipExist() {
        return new File(this.zipPath).exists();
    }

    public ThemeLocator reset() {
        this.zipPath = null;
        this.unzipPath = null;
        return this;
    }

    public ThemeLocator setThemeId(String str) {
        this.themeId = str;
        return this;
    }

    public String toString() {
        return this.zipPath;
    }
}
