package com.tencent.sqshow.zootopia.avatar.scene.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.lua.ZootopiaSceneLuaPlugin;
import com.tencent.mobileqq.z1.lua.a;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00132\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/scene/impl/AvatarSceneApiImpl;", "Lcom/tencent/sqshow/zootopia/avatar/scene/IAvatarSceneApi;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Lcom/tencent/mobileqq/z1/lua/a;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "engineDestroy", "", "viewType", "isSameViewType", "currentViewType", "enterFirstFrame", "onAvatarSceneChanged", "curViewType", "I", "<init>", "()V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarSceneApiImpl implements IAvatarSceneApi, ZPlanEngineStatusUpdateListener, a {
    private static final String TAG = "AvatarSceneApiImpl_";
    private int curViewType;

    public AvatarSceneApiImpl() {
        ZPlanServiceHelper.I.E0(this);
        ZootopiaSceneLuaPlugin.INSTANCE.a().b(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi
    /* renamed from: currentViewType, reason: from getter */
    public int getCurViewType() {
        return this.curViewType;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.c(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi
    public void enterFirstFrame(int viewType) {
        QLog.i(TAG, 1, "enterFirstFrame viewType:" + viewType);
        this.curViewType = viewType;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi
    public boolean isSameViewType(int viewType) {
        boolean isEngineReady = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
        QLog.i(TAG, 1, "isSameViewType viewType:" + viewType + ",curViewType:" + this.curViewType + ",isEngineReady:" + isEngineReady);
        return this.curViewType == viewType && isEngineReady;
    }

    @Override // com.tencent.mobileqq.z1.lua.a
    public void onAvatarSceneChanged(int viewType) {
        QLog.i(TAG, 1, "onAvatarSceneChanged viewType:" + viewType);
        this.curViewType = viewType;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        QLog.i(TAG, 1, "connect:" + connect);
        if (connect) {
            return;
        }
        this.curViewType = 0;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        QLog.i(TAG, 1, "engineDestroy, curViewType reset to 0");
        this.curViewType = 0;
    }
}
