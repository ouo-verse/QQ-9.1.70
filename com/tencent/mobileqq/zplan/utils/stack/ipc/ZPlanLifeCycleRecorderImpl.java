package com.tencent.mobileqq.zplan.utils.stack.ipc;

import com.tencent.mobileqq.zplan.utils.stack.lifecycle.ProcessName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xk3.e;
import yk3.d;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J!\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J!\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J-\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096\u0001\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/ipc/ZPlanLifeCycleRecorderImpl;", "Lyk3/d;", "", "isEnginePage", "", "activityName", "", "hashCode", "processName", "", "activityCreate", "activityDestroy", "activityFinish", "activityResume", "mapId", "clearInvalidModRes", "mapName", "doEnterUeMap", "doExitUeMap", "sceneType", "sceneParams", "ueEnterAvatarScene", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanLifeCycleRecorderImpl implements d {
    private final /* synthetic */ e $$delegate_0 = e.f448113d;

    @Override // yk3.d
    public void activityCreate(boolean isEnginePage, String activityName, int hashCode, @ProcessName String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.$$delegate_0.activityCreate(isEnginePage, activityName, hashCode, processName);
    }

    @Override // yk3.d
    public void activityDestroy(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.$$delegate_0.activityDestroy(isEnginePage, activityName, hashCode);
    }

    @Override // yk3.d
    public void activityFinish(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.$$delegate_0.activityFinish(isEnginePage, activityName, hashCode);
    }

    @Override // yk3.d
    public void activityResume(boolean isEnginePage, String activityName, int hashCode, @ProcessName String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        this.$$delegate_0.activityResume(isEnginePage, activityName, hashCode, processName);
    }

    @Override // yk3.d
    public void clearInvalidModRes(int mapId) {
        this.$$delegate_0.clearInvalidModRes(mapId);
    }

    @Override // yk3.d
    public void doEnterUeMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        this.$$delegate_0.doEnterUeMap(mapId, mapName);
    }

    @Override // yk3.d
    public void doExitUeMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        this.$$delegate_0.doExitUeMap(mapId, mapName);
    }

    @Override // yk3.d
    public void ueEnterAvatarScene(int sceneType, String sceneParams) {
        this.$$delegate_0.ueEnterAvatarScene(sceneType, sceneParams);
    }
}
