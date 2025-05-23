package com.tencent.mobileqq.zplan.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.avatar.a;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanAvatarUploadParam;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import com.tencent.mobileqq.zplan.avatar.edit.e;
import com.tencent.mobileqq.zplan.avatar.edit.g;
import com.tencent.zplan.meme.Priority;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\rH&J:\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0011H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J2\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH&J:\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0004H&JC\u0010)\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010\u001aH&\u00a2\u0006\u0004\b)\u0010*J*\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0,H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanEditAvatarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "avatarData", "", "recordPath", "Lcom/tencent/mobileqq/zplan/avatar/edit/e;", "listener", "", "composeAvatar", "saveDir", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/zplan/avatar/edit/g;", "setUploadHandler", "avatarFilePath", "editAvatarData", "", "isSyncQzone", "Lcom/tencent/mobileqq/zplan/avatar/edit/j;", "uploadParam", "pageSource", "uploadAvatar", "getZPlanEditAvatarToggleSwitch", "preRecordActionInSummary", "preRecordActionInMall", "", "id", "path", "currAppearanceKey", "cropType", "getAvatarPathV2", "dirSubPath", "", "avatarDataList", "Lcom/tencent/zplan/meme/Priority;", "priority", "reqFrom", "Lcom/tencent/mobileqq/zplan/avatar/a;", "avatarRecordListener", "firstScreenCnt", "recordBatchEditAvatar", "(Ljava/util/List;Lcom/tencent/zplan/meme/Priority;ILcom/tencent/mobileqq/zplan/avatar/a;Ljava/lang/Integer;)V", "url", "Lkotlin/Function2;", "callback", "downloadShpImagePackage", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEditAvatarApi extends QRouteApi {
    void composeAvatar(@NotNull d avatarData, @NotNull String recordPath, @NotNull e listener);

    void composeAvatar(@NotNull d avatarData, @NotNull String recordPath, @NotNull String saveDir, @NotNull e listener);

    void downloadShpImagePackage(@NotNull String url, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    @NotNull
    String getAvatarPathV2(int id5, @NotNull String path, @Nullable d editAvatarData, @NotNull String currAppearanceKey, int cropType);

    @NotNull
    String getAvatarPathV2(int id5, @NotNull String path, @Nullable d editAvatarData, @NotNull String currAppearanceKey, int cropType, @NotNull String dirSubPath);

    boolean getZPlanEditAvatarToggleSwitch();

    void preRecordActionInMall(@NotNull AppRuntime app);

    void preRecordActionInSummary(@NotNull AppRuntime app);

    void recordBatchEditAvatar(@NotNull List<d> avatarDataList, @NotNull Priority priority, int reqFrom, @Nullable a avatarRecordListener, @Nullable Integer firstScreenCnt);

    void setUploadHandler(@NotNull AppRuntime app, @Nullable g listener);

    void uploadAvatar(@NotNull AppRuntime app, @Nullable String avatarFilePath, @NotNull d editAvatarData, boolean isSyncQzone, @NotNull ZPlanAvatarUploadParam uploadParam, @NotNull String pageSource);
}
