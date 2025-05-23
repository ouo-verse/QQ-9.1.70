package com.tencent.mobileqq.vas.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.api.IThemeResCheck;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.updatesystem.api.UpdateSystemFileCheck;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/ThemeResCheckImpl;", "Lcom/tencent/mobileqq/vas/api/IThemeResCheck;", "", "themeId", "scid", "unzipDir", "", "zipFileCheck", "triggerDownloadThemeRes", "checkThemeResAndDownload", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ThemeResCheckImpl implements IThemeResCheck {

    @NotNull
    private static final UnitedProxy IS_CHECK_THEME_RES;

    @NotNull
    private static final UnitedProxy IS_DOWNLOAD_THEME_WHEN_START;

    @NotNull
    private static final String TAG = "ThemeResCheckImpl";

    static {
        ar.Companion companion = com.tencent.mobileqq.vas.ar.INSTANCE;
        IS_CHECK_THEME_RES = companion.b("shouyouye", "2024-02-21", "vas_is_check_theme_res");
        IS_DOWNLOAD_THEME_WHEN_START = companion.b("shouyouye", "2024-02-21", "vas_is_download_theme_when_start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void checkThemeResAndDownload$lambda$0(ThemeResCheckImpl this$0) {
        boolean z16;
        String string;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String themeId = ThemeUtil.getThemeId();
        QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(3L);
        if (!business.isDownloadingOrUnpacking(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + themeId)) {
            if (!business.isDownloadingOrUnpacking(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO + themeId)) {
                z16 = false;
                if (!z16 && IS_CHECK_THEME_RES.isEnable(true) && !ThemeUtil.isDefaultOrDIYTheme(true) && !TextUtils.isEmpty(themeId) && ThemeUtil.isMergeVideoTheme(themeId)) {
                    string = em.b().a().getString("theme_root", null);
                    String str2 = ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + themeId;
                    if (string != null) {
                        str = "";
                    } else {
                        str = string;
                    }
                    this$0.zipFileCheck(themeId, str2, str);
                    this$0.zipFileCheck(themeId, ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO + themeId, string + "raw");
                }
                if (!IS_DOWNLOAD_THEME_WHEN_START.isEnable(false)) {
                    Intrinsics.checkNotNullExpressionValue(themeId, "themeId");
                    this$0.triggerDownloadThemeRes(themeId);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
            string = em.b().a().getString("theme_root", null);
            String str22 = ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + themeId;
            if (string != null) {
            }
            this$0.zipFileCheck(themeId, str22, str);
            this$0.zipFileCheck(themeId, ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX_VIDEO + themeId, string + "raw");
        }
        if (!IS_DOWNLOAD_THEME_WHEN_START.isEnable(false)) {
        }
    }

    private final void triggerDownloadThemeRes(String themeId) {
        QLog.i(TAG, 1, "triggerDownloadThemeRes, themeId:" + themeId);
        QQVasUpdateBusiness.getBusiness(3L).startDownload(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + themeId);
    }

    private final void zipFileCheck(String themeId, String scid, String unzipDir) {
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(themeId);
        themeLocator.init(BaseApplication.context, scid, "");
        String zipPath = themeLocator.getZipPath();
        QLog.i(TAG, 1, "checkThemeRes zipPath:" + zipPath);
        if (new File(zipPath).exists()) {
            QLog.i(TAG, 1, "checkThemeRes checkFileValid result: " + new UpdateSystemFileCheck(false, 1, null).checkFileValid(new File(zipPath), new File(unzipDir)));
            return;
        }
        QLog.i(TAG, 1, "checkThemeRes zip file no exists, zipPath:" + zipPath);
    }

    @Override // com.tencent.mobileqq.vas.api.IThemeResCheck
    public void checkThemeResAndDownload() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.v
            @Override // java.lang.Runnable
            public final void run() {
                ThemeResCheckImpl.checkThemeResAndDownload$lambda$0(ThemeResCheckImpl.this);
            }
        }, 16, null, false);
    }
}
