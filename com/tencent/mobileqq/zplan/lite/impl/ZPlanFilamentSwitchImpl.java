package com.tencent.mobileqq.zplan.lite.impl;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.lite.util.e;
import kotlin.Metadata;
import wk3.h;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/impl/ZPlanFilamentSwitchImpl;", "Lcom/tencent/mobileqq/zplan/lite/IZPlanFilamentSwitch;", "", "enableZPlanFilamentBase", "Lwk3/h;", DownloadInfo.spKey_Config, "enableSameStyle", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentSwitchImpl implements IZPlanFilamentSwitch {
    @Override // com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch
    public boolean enableSameStyle() {
        return e.f333809a.f();
    }

    @Override // com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch
    public boolean enableZPlanFilamentBase() {
        return e.f333809a.i(null);
    }

    @Override // com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch
    public boolean enableZPlanFilamentBase(h config) {
        return e.f333809a.i(config);
    }
}
