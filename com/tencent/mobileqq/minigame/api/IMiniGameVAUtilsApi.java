package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H&JT\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H&J&\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\fH&\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVAUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSaveImageTargetFileName", "", "localFilePath", "getVaDownloadApkDir", "appId", "versionCode", "", "getVaDownloadApkName", WadlProxyConsts.EXTRA_DATA, "isApkDownloadInnerStorageEnable", "", "isDiffPatchApk", "apkFileName", "reportMiniGameCenterDC00087", "", "bussinessId", "page", "operMoudle", "moduleType", "operId", "operType", WadlReportBuilder.TableElem.GAME_APPID, "extMap", "", "saveToSharedStorageCompat", "context", "Landroid/content/Context;", "savingFile", "Ljava/io/File;", "targetFileName", "setInnerStorageDownloadFailed", "isFailed", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVAUtilsApi extends QRouteApi {
    @NotNull
    String getSaveImageTargetFileName(@NotNull String localFilePath);

    @NotNull
    String getVaDownloadApkDir(@NotNull String appId, int versionCode);

    @NotNull
    String getVaDownloadApkName(@NotNull String appId, int versionCode, @NotNull String extraData);

    boolean isApkDownloadInnerStorageEnable();

    boolean isDiffPatchApk(@NotNull String apkFileName);

    void reportMiniGameCenterDC00087(@NotNull String bussinessId, @NotNull String page, @NotNull String operMoudle, @NotNull String moduleType, @NotNull String operId, @NotNull String operType, @NotNull String gameappid, @NotNull Map<String, String> extMap);

    boolean saveToSharedStorageCompat(@Nullable Context context, @Nullable File savingFile, @Nullable String targetFileName);

    void setInnerStorageDownloadFailed(boolean isFailed);
}
