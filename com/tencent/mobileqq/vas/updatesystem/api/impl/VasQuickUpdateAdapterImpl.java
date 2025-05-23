package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.Constants;
import mqq.app.AppRuntime;
import sw4.d;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasQuickUpdateAdapterImpl implements IVasQuickUpdateAdapter {
    private static final String TAG = "VasQuickUpdateAdapterIm";

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public void downloadItem(AppRuntime appRuntime, long j3, String str, String str2, CallBacker callBacker) {
        IVasQuickUpdateService iVasQuickUpdateService;
        String str3;
        if (appRuntime instanceof QQAppInterface) {
            iVasQuickUpdateService = (IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
        } else {
            iVasQuickUpdateService = null;
        }
        if (iVasQuickUpdateService == null) {
            QLog.e(TAG, 1, "downloadItem, manager == null; scid: " + str + ", bid: " + j3 + " , app= " + appRuntime);
            return;
        }
        iVasQuickUpdateService.addCallBacker(callBacker);
        if (16 == j3) {
            if (!VasUpdateConstants.SCID_REDPACKET_CONFIG.equals(str) && !VasUpdateConstants.SCID_REDPACKET_300CHAR.equals(str) && !VasUpdateConstants.SCID_REDPACKET_FONT_ZIP.equals(str) && !VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
                str3 = "getFileFromLocal_redPacket";
            } else {
                str3 = "silent_download.redbag" + str;
            }
            iVasQuickUpdateService.downloadItem(j3, str, str3);
            return;
        }
        iVasQuickUpdateService.downloadItem(j3, str, "getFileFromLocal_" + j3);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public String getFileMd5(String str) {
        return MD5Utils.encodeFileHexStr(str);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public d getHttpDownloader() {
        return new VasHttpDownloaderImpl();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public String getUpdateReportAppid() {
        return "qqvas_updatemgr_complete";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public void onThemeComplete(String str, String str2, String str3, final int i3, final int i16) {
        boolean z16;
        ThemeSwitcherImpl.INSTANCE.f(str, i3);
        if (i3 != 0) {
            String iDFromSCID = ThemeUtil.getIDFromSCID(str);
            VasLogReporter.getTheme().report("theme_download_failed[themeId:" + iDFromSCID + ",from:" + str3 + ",httpCode:" + i16 + ",errorCode:" + i3 + ", scid:" + str + ", cfgScid:" + str2 + "]");
            if (ThemeUpdateBusiness.isSupportNewScid() && str.startsWith(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO) && i3 == 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!Constants.UpdateFrom.SILENT_UPDATE.equals(str3) && !z16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.api.impl.VasQuickUpdateAdapterImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), "\u4e3b\u9898\u4e0b\u8f7d\u5f02\u5e38\uff0c\u8bf7\u6362\u7f51\u7edc\u91cd\u8bd5(" + i3 + ":" + i16 + ")", 1).show();
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public void onThemeProgress(String str, long j3, long j16) {
        ThemeSwitcher.onProgress(str, j3, j16);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public boolean patch(String str, String str2, String str3) {
        return BspatchUtil.a(str, str2, str);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter
    public void onMusicThemeCleanCache() {
    }
}
