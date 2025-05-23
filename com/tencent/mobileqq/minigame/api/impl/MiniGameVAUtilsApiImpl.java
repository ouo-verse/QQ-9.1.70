package com.tencent.mobileqq.minigame.api.impl;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.util.DiffPatchUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016JT\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAUtilsApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAUtilsApi;", "()V", "DIFF_PATCH_FILE_PREFFIXX", "", "isInnerStorageDownloadFailed", "", "getSaveImageTargetFileName", "localFilePath", "getVaDownloadApkDir", "appId", "versionCode", "", "getVaDownloadApkName", WadlProxyConsts.EXTRA_DATA, "isApkDownloadInnerStorageEnable", "isDiffPatchApk", "apkFileName", "reportMiniGameCenterDC00087", "", "bussinessId", "page", "operMoudle", "moduleType", "operId", "operType", WadlReportBuilder.TableElem.GAME_APPID, "extMap", "", "saveToSharedStorageCompat", "context", "Landroid/content/Context;", "savingFile", "Ljava/io/File;", "targetFileName", "setInnerStorageDownloadFailed", "isFailed", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAUtilsApiImpl implements IMiniGameVAUtilsApi {
    private static final String TAG = "MiniGameVAUtilsApiImpl";
    private final String DIFF_PATCH_FILE_PREFFIXX = "diff_patch_";
    private boolean isInnerStorageDownloadFailed;

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public String getSaveImageTargetFileName(String localFilePath) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        File file = new File(localFilePath);
        String str = "";
        if (!ImageUtil.isJpgFile(localFilePath) && !ImageUtil.isPngFile(localFilePath) && !ImageUtil.isWebpFile(localFilePath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(localFilePath, options);
            String type = ImageUtil.getType(options);
            Intrinsics.checkNotNullExpressionValue(type, "getType(opts)");
            if (!TextUtils.isEmpty(type) && !Intrinsics.areEqual(type, "unknown")) {
                str = "." + type;
            }
        }
        if (TextUtils.isEmpty(str)) {
            String fileName = file.getName();
            Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) fileName, ".", 0, false, 6, (Object) null);
            str = fileName.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        return UUID.randomUUID().toString() + str;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public String getVaDownloadApkDir(String appId, int versionCode) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        File file = new File(BaseApplication.getContext().getFilesDir(), "minibox/app/download/" + appId);
        file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "dirFile.absolutePath");
        return absolutePath;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public String getVaDownloadApkName(String appId, int versionCode, String extraData) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        String str = GameCenterUtil.FILE_NAME_PRE + appId + "_" + versionCode + ".apk";
        if (TextUtils.isEmpty(extraData)) {
            return str;
        }
        MiniGameDiffPatchInfo json2DiffPatchInfo = DiffPatchUtil.INSTANCE.json2DiffPatchInfo(extraData);
        if ((json2DiffPatchInfo != null ? json2DiffPatchInfo.getDiffPatchUrl() : null) == null) {
            return str;
        }
        QLog.i(TAG, 1, "getVaDownloadApkName diff patch info:" + json2DiffPatchInfo);
        return this.DIFF_PATCH_FILE_PREFFIXX + str;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public boolean isApkDownloadInnerStorageEnable() {
        QLog.i(TAG, 1, "isApkDownloadInnerStorageEnable isInnerStorageDownloadFailed:" + this.isInnerStorageDownloadFailed);
        if (this.isInnerStorageDownloadFailed) {
            return false;
        }
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null && miniGameVAInterceptConfig.getApkDownloadInnerStorageSwitch()) {
            QLog.i(TAG, 1, "isApkDownloadInnerStorageEnable: true");
            return true;
        }
        QLog.i(TAG, 1, "isApkDownloadInnerStorageEnable: false");
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public boolean isDiffPatchApk(String apkFileName) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(apkFileName, "apkFileName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(apkFileName, this.DIFF_PATCH_FILE_PREFFIXX, false, 2, null);
        return startsWith$default;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public void reportMiniGameCenterDC00087(String bussinessId, String page, String operMoudle, String moduleType, String operId, String operType, String gameappid, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(bussinessId, "bussinessId");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(operMoudle, "operMoudle");
        Intrinsics.checkNotNullParameter(moduleType, "moduleType");
        Intrinsics.checkNotNullParameter(operId, "operId");
        Intrinsics.checkNotNullParameter(operType, "operType");
        Intrinsics.checkNotNullParameter(gameappid, "gameappid");
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        MiniAppUtils.reportMiniGameCenterDC00087(bussinessId, page, operMoudle, moduleType, operId, operType, gameappid, extMap);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    public void setInnerStorageDownloadFailed(boolean isFailed) {
        this.isInnerStorageDownloadFailed = isFailed;
        QLog.i(TAG, 1, "setInnerStorageDownloadFailed isFailed:" + isFailed);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean saveToSharedStorageCompat(Context context, File savingFile, String targetFileName) {
        boolean z16;
        boolean isBlank;
        if (context != null && savingFile != null) {
            if (targetFileName != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(targetFileName);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        return FileUtils.saveToSharedStorageCompat(context, savingFile, targetFileName, FileUtils.MediaType.PICTURE);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return false;
    }
}
