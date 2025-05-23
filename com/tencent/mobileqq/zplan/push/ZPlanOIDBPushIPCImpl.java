package com.tencent.mobileqq.zplan.push;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/ZPlanOIDBPushIPCImpl;", "Lcom/tencent/mobileqq/zplan/push/c;", "Lcom/tencent/mobileqq/zplan/push/d;", "", "cmdId", "", "buf", "", "onReceive", "", "msg", "dialogAndKickOff", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanOIDBPushIPCImpl implements c, d {
    @Override // com.tencent.mobileqq.zplan.push.d
    public void dialogAndKickOff(String msg2) {
        if (TextUtils.isEmpty(msg2)) {
            g.f335038a.c();
            return;
        }
        g gVar = g.f335038a;
        Activity e16 = gVar.e();
        if (e16 != null && !e16.isFinishing() && !e16.isDestroyed()) {
            gVar.f(e16, msg2);
        } else {
            gVar.c();
        }
    }

    @Override // com.tencent.mobileqq.zplan.push.c
    public void onReceive(int cmdId, byte[] buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.D2(cmdId, buf);
        }
    }
}
