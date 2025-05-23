package com.tencent.mobileqq.zplan.smallhome.status.ipc;

import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain;
import kotlin.Metadata;
import sk3.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/status/ipc/ModLoadIPCForZplanImpl;", "Lsk3/b;", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "getCurrentStatusInfo", "", "mapId", "", "isFromGame", "", "enterLoadStatus", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModLoadIPCForZplanImpl implements b {
    @Override // sk3.b
    public void enterLoadStatus(int mapId, boolean isFromGame) {
        ZPlanModLoadStatusManagerForMain.f335706a.i(mapId, isFromGame);
    }

    @Override // sk3.b
    public ZPlanModLoadStatusInfo getCurrentStatusInfo() {
        return ZPlanModLoadStatusManagerForMain.f335706a.h();
    }
}
