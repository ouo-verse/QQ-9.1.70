package com.tencent.mobileqq.zplan.ipc.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ipc.e;
import gc3.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zu4.t;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u0000 42\u00020\u0001:\u00015J\b\u0010\u0003\u001a\u00020\u0002H&J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J(\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0012H&J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006H&J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&J \u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0006H&J\b\u0010$\u001a\u00020\u000bH&J\u0018\u0010'\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%H&J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0006H&J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0012H&J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0004H&J\b\u00100\u001a\u00020\u000bH&J\u0010\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u000201H&\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/api/IZPlanIPCHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "", "category", "", "url", "filePath", WadlProxyConsts.PARAM_FILENAME, "subCategoryName", "", "downloadRemoteManagerStartFileDownload", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "reqParam", "Lcom/tencent/mobileqq/zootopia/ipc/e;", "callback", "downloadRemoteManagerDownloadResByPath", "", "needProgressCallback", "Lgc3/c;", "downloadProgressHelperBindFileDownloadProgress", "zootopiaServiceManagerStartZPlanService", "shouldCheckFloat", "zootopiaServiceManagerStopZPlanService", "from", "previewEngineHelperStartEngine", "cmdId", "", "buf", "oidbPushForMainProcessOnReceive", "gender", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "avatarCharacter", "openFilamentFaceCamera", "nativeUiIPCAvatarCharacterChanged", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "openIdRemoteManagerGetOpenIdInfoSilent", "scene", "dressInfoIpcRefreshDressInfo", "isInAvatar", "smallHomeSetIsInAvatarScene", "Lzu4/t;", "data", "bubbleIndex", "reportSmallHomeBubbleExpose", "eventAndMsgReportApiInitRegisterDatabaseModelClass", "", "msgBean", "eventAndMsgReportApiReportMsg", "Constant", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanIPCHelper extends QRouteApi {

    /* renamed from: Constant, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f333748a;

    @NotNull
    public static final String MODULE_NAME = "zplan_client_module";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/api/IZPlanIPCHelper$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f333748a = new Companion();

        Companion() {
        }
    }

    void downloadProgressHelperBindFileDownloadProgress(int category, @NotNull String url, boolean needProgressCallback, @NotNull c callback);

    void downloadRemoteManagerDownloadResByPath(@Nullable ZPlanResDownloadReq reqParam, @Nullable e callback);

    void downloadRemoteManagerStartFileDownload(int category, @Nullable String url, @Nullable String filePath, @Nullable String fileName, @Nullable String subCategoryName);

    void dressInfoIpcRefreshDressInfo(@NotNull String scene);

    void eventAndMsgReportApiInitRegisterDatabaseModelClass();

    void eventAndMsgReportApiReportMsg(@NotNull Object msgBean);

    @NotNull
    QIPCModule getIPCModule();

    void nativeUiIPCAvatarCharacterChanged();

    void oidbPushForMainProcessOnReceive(int cmdId, @NotNull byte[] buf);

    void openFilamentFaceCamera(int gender, @NotNull ZootopiaSource source, @NotNull String avatarCharacter);

    void openIdRemoteManagerGetOpenIdInfoSilent(@NotNull com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> callback);

    void previewEngineHelperStartEngine(@NotNull String from);

    void reportSmallHomeBubbleExpose(@NotNull t data, int bubbleIndex);

    void smallHomeSetIsInAvatarScene(boolean isInAvatar);

    void zootopiaServiceManagerStartZPlanService();

    void zootopiaServiceManagerStopZPlanService(boolean shouldCheckFloat);
}
