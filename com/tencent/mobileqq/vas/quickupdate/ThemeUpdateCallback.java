package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeUpdateCallback extends BaseUpdateCallback {
    public static final long BID_THEME = 3;
    public static final String TAG = "ThemeUpdateCallback";
    public static ThemeUpdateCallback sInstance = new ThemeUpdateCallback();
    public static final String SCID_THEME_PREFIX = "theme.";
    public static String SCID_THEME_ZIP_PREFIX = SCID_THEME_PREFIX;

    public ThemeUpdateCallback() {
        ThemeUpdateBusiness.setStartDownloadInterceptor();
    }

    private boolean checkNewVersionValid(String str) {
        if (!str.startsWith("theme.android") && !str.endsWith(PluginUtils.CONFIG_FILE_EXTEND_NAME)) {
            return false;
        }
        QLog.e(TAG, 1, "VasUpdate getItemInfo checkNewVersionValid filter scid = " + str);
        return true;
    }

    private void onThemeComplete(String str, String str2, String str3, int i3, int i16) {
        ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).onThemeComplete(str, str2, str3, i3, i16);
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean deleteFiles(long j3, String str) {
        String cfgPath;
        if (!ThemeUtil.isIOSTheme(str)) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            if (!TextUtils.isEmpty(iDFromSCID)) {
                ThemeLocator themeId = new ThemeLocator().setThemeId(iDFromSCID);
                if (str.startsWith(SCID_THEME_ZIP_PREFIX)) {
                    cfgPath = themeId.init(BaseApplication.getContext(), str, "").getZipPath();
                } else {
                    cfgPath = themeId.getCfgPath(BaseApplication.getContext());
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "deleteFiles: " + cfgPath);
                }
                return new File(cfgPath).delete();
            }
            return false;
        }
        QLog.e(TAG, 1, "deleteFiles ignore ios theme:" + str);
        return false;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void doOnCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
        if (!ThemeUtil.isIOSTheme(str)) {
            onThemeComplete(str, str2, str3, i3, i16);
            return;
        }
        QLog.e(TAG, 1, "onCompleted ignore ios theme:" + str);
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void doOnProgress(long j3, String str, String str2, long j16, long j17) {
        if (!ThemeUtil.isIOSTheme(str)) {
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).onThemeProgress(str, j16, j17);
        }
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void download(String str, QuickUpdateListener quickUpdateListener, boolean z16) {
        super.download(str, quickUpdateListener, z16);
        if (str.startsWith(SCID_THEME_ZIP_PREFIX) && ThemeUpdateBusiness.isSupportNewScid()) {
            p23.c.f424977a.e(str);
        }
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public long getBID() {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public TagItemInfo getItemInfo(long j3, String str) {
        if ("theme_mapping_config_android".equals(str)) {
            TagItemInfo tagItemInfo = new TagItemInfo();
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            tagItemInfo.strSavePath = getSavePath(BaseApplication.getContext(), str);
            return tagItemInfo;
        }
        if (checkNewVersionValid(str)) {
            return null;
        }
        if (!ThemeUtil.isIOSTheme(str)) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            if (!TextUtils.isEmpty(iDFromSCID)) {
                TagItemInfo tagItemInfo2 = new TagItemInfo();
                ThemeLocator themeId = new ThemeLocator().setThemeId(iDFromSCID);
                if (str.startsWith(SCID_THEME_ZIP_PREFIX)) {
                    tagItemInfo2.bPreConfig = false;
                    tagItemInfo2.bSaveInDir = false;
                    tagItemInfo2.strSavePath = themeId.init(BaseApplication.getContext(), str, "").getZipPath();
                } else {
                    tagItemInfo2.bPreConfig = true;
                    tagItemInfo2.bSaveInDir = false;
                    tagItemInfo2.strSavePath = themeId.getCfgPath(BaseApplication.getContext());
                }
                return tagItemInfo2;
            }
        } else {
            QLog.e(TAG, 1, "getItemInfo ignore ios theme:" + str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean isFileExists(long j3, String str) {
        String cfgPath;
        if (!ThemeUtil.isIOSTheme(str)) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            if (!TextUtils.isEmpty(iDFromSCID)) {
                ThemeLocator themeId = new ThemeLocator().setThemeId(iDFromSCID);
                if (str.startsWith(SCID_THEME_ZIP_PREFIX)) {
                    cfgPath = themeId.init(BaseApplication.getContext(), str, "").getZipPath();
                } else {
                    cfgPath = themeId.getCfgPath(BaseApplication.getContext());
                }
                return new File(cfgPath).exists();
            }
            return false;
        }
        return false;
    }
}
