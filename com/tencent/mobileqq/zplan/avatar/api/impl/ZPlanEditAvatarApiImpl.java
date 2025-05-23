package com.tencent.mobileqq.zplan.avatar.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.zplan.avatar.a;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanAvatarUploadParam;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils;
import com.tencent.mobileqq.zplan.avatar.edit.d;
import com.tencent.mobileqq.zplan.avatar.edit.e;
import com.tencent.mobileqq.zplan.avatar.edit.g;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.zplan.meme.Priority;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0016J:\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J2\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J:\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0004H\u0016JA\u0010)\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010\u001aH\u0016\u00a2\u0006\u0004\b)\u0010*J*\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0,H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/impl/ZPlanEditAvatarApiImpl;", "Lcom/tencent/mobileqq/zplan/avatar/api/IZPlanEditAvatarApi;", "Lcom/tencent/mobileqq/zplan/avatar/edit/d;", "avatarData", "", "recordPath", "Lcom/tencent/mobileqq/zplan/avatar/edit/e;", "listener", "", "composeAvatar", "saveDir", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/zplan/avatar/edit/g;", "setUploadHandler", "avatarFilePath", "editAvatarData", "", "isSyncQzone", "Lcom/tencent/mobileqq/zplan/avatar/edit/j;", "uploadParam", "pageSource", "uploadAvatar", "getZPlanEditAvatarToggleSwitch", "preRecordActionInSummary", "preRecordActionInMall", "", "id", "path", "currAppearanceKey", "cropType", "getAvatarPathV2", "dirSubPath", "", "avatarDataList", "Lcom/tencent/zplan/meme/Priority;", "priority", "reqFrom", "Lcom/tencent/mobileqq/zplan/avatar/a;", "avatarRecordListener", "firstScreenCnt", "recordBatchEditAvatar", "(Ljava/util/List;Lcom/tencent/zplan/meme/Priority;ILcom/tencent/mobileqq/zplan/avatar/a;Ljava/lang/Integer;)V", "url", "Lkotlin/Function2;", "callback", "downloadShpImagePackage", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanEditAvatarApiImpl implements IZPlanEditAvatarApi {
    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void composeAvatar(d avatarData, String recordPath, e listener) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(recordPath, "recordPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanEditAvatarUtils.f331613a.j(avatarData, recordPath, listener);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void downloadShpImagePackage(String url, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.c().f(url, callback);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public String getAvatarPathV2(int id5, String path, d editAvatarData, String currAppearanceKey, int cropType) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(currAppearanceKey, "currAppearanceKey");
        return ZPlanEditAvatarUtils.f331613a.B(id5, path, editAvatarData, currAppearanceKey, cropType);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public boolean getZPlanEditAvatarToggleSwitch() {
        return ZPlanEditAvatarUtils.f331613a.Y();
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void preRecordActionInMall(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Manager manager = app.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
        ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
        if (zPlanEditAvatarManager != null) {
            zPlanEditAvatarManager.p0();
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void preRecordActionInSummary(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Manager manager = app.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
        ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
        if (zPlanEditAvatarManager != null) {
            zPlanEditAvatarManager.q0();
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void recordBatchEditAvatar(List<d> avatarDataList, Priority priority, int reqFrom, a avatarRecordListener, Integer firstScreenCnt) {
        Intrinsics.checkNotNullParameter(avatarDataList, "avatarDataList");
        Intrinsics.checkNotNullParameter(priority, "priority");
        ZPlanEditAvatarUtils.f331613a.a0(avatarDataList, priority, reqFrom, avatarRecordListener, firstScreenCnt);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void setUploadHandler(AppRuntime app, g listener) {
        Intrinsics.checkNotNullParameter(app, "app");
        Manager manager = app.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
        ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
        if (zPlanEditAvatarManager != null) {
            zPlanEditAvatarManager.z0(listener);
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void uploadAvatar(AppRuntime app, String avatarFilePath, d editAvatarData, boolean isSyncQzone, ZPlanAvatarUploadParam uploadParam, String pageSource) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(editAvatarData, "editAvatarData");
        Intrinsics.checkNotNullParameter(uploadParam, "uploadParam");
        Intrinsics.checkNotNullParameter(pageSource, "pageSource");
        Manager manager = app.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
        ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
        if (zPlanEditAvatarManager != null) {
            zPlanEditAvatarManager.L0(avatarFilePath, editAvatarData, Boolean.valueOf(isSyncQzone), uploadParam, pageSource);
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public void composeAvatar(d avatarData, String recordPath, String saveDir, e listener) {
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(recordPath, "recordPath");
        Intrinsics.checkNotNullParameter(saveDir, "saveDir");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZPlanEditAvatarUtils.f331613a.k(avatarData, recordPath, saveDir, listener);
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi
    public String getAvatarPathV2(int id5, String path, d editAvatarData, String currAppearanceKey, int cropType, String dirSubPath) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(currAppearanceKey, "currAppearanceKey");
        Intrinsics.checkNotNullParameter(dirSubPath, "dirSubPath");
        return ZPlanEditAvatarUtils.f331613a.C(id5, path, editAvatarData, currAppearanceKey, cropType, dirSubPath);
    }
}
