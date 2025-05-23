package com.tencent.qqnt.robot.api.impl;

import com.tencent.mobileqq.aio.longshot.d;
import com.tencent.qqnt.robot.api.IRobotShareDebugApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotShareDebugApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotShareDebugApi;", "()V", "getQRCodeGenerateFailSwitch", "", "setQRCodeGenerateFailSwitch", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotShareDebugApiImpl implements IRobotShareDebugApi {
    @Override // com.tencent.qqnt.robot.api.IRobotShareDebugApi
    public boolean getQRCodeGenerateFailSwitch() {
        return d.INSTANCE.a();
    }

    @Override // com.tencent.qqnt.robot.api.IRobotShareDebugApi
    public void setQRCodeGenerateFailSwitch(boolean r26) {
        d.INSTANCE.b(r26);
    }
}
