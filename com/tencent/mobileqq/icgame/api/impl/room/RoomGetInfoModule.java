package com.tencent.mobileqq.icgame.api.impl.room;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.icgame.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RoomGetInfoModule extends IQQLiveBaseModule implements IRoomGetInfoModule {
    @Override // com.tencent.mobileqq.icgame.api.room.IRoomGetInfoModule
    public void getRoomRealTimeInfo(long j3, String str, final GetRoomInfoCallback getRoomInfoCallback) {
        ny0.b bVar = new ny0.b();
        bVar.f421572a = j3;
        if (!TextUtils.isEmpty(str)) {
            bVar.f421573b = str.getBytes();
        }
        ((com.tencent.mobileqq.icgame.sso.c) this.sdkImpl.getExtModule("sso_module")).f("trpc.qlive.ilive_metrics_svr.IliveMetricsSvr", "GetRealTimeMetrics", MessageNano.toByteArray(bVar), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.room.RoomGetInfoModule.1
            @Override // com.tencent.mobileqq.icgame.sso.g
            public void onReceive(int i3, boolean z16, i iVar) {
                if (z16) {
                    try {
                        getRoomInfoCallback.onSuccess(t42.b.c(ny0.c.c(iVar.e())));
                        return;
                    } catch (Exception e16) {
                        getRoomInfoCallback.onFailed(-1, e16.getMessage());
                        return;
                    }
                }
                getRoomInfoCallback.onFailed(iVar.b(), iVar.c());
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
    }
}
