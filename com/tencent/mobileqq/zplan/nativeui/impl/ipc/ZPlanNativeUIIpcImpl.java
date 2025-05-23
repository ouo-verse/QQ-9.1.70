package com.tencent.mobileqq.zplan.nativeui.impl.ipc;

import cj3.a;
import h94.FinishAIMakeFaceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z94.c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/nativeui/impl/ipc/ZPlanNativeUIIpcImpl;", "Lcj3/a;", "", "getFaceEditorFaceControlCfg", "", "avatarCharacterChanged", "data", "aiMakeFaceResult", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanNativeUIIpcImpl implements a {
    @Override // cj3.a
    public void aiMakeFaceResult(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        c.f452180e.g(new FinishAIMakeFaceData(0, data));
    }

    @Override // cj3.a
    public void avatarCharacterChanged() {
        f94.c.d(f94.c.f398021a, false, 1, null);
    }

    @Override // cj3.a
    public String getFaceEditorFaceControlCfg() {
        String jSONArray = j94.a.f409675a.c().toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "AvatarPanelCommonConfig.\u2026ntrolCfgJson().toString()");
        return jSONArray;
    }
}
