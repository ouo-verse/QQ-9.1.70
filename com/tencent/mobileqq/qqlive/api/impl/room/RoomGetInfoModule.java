package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.room.IRoomGetInfoModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RoomGetInfoModule extends IQQLiveBaseModule implements IRoomGetInfoModule {
    static IPatchRedirector $redirector_;

    public RoomGetInfoModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IRoomGetInfoModule
    public void getRoomRealTimeInfo(long j3, String str, GetRoomInfoCallback getRoomInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, getRoomInfoCallback);
            return;
        }
        br3.b bVar = new br3.b();
        bVar.f29011a = j3;
        if (!TextUtils.isEmpty(str)) {
            bVar.f29012b = str.getBytes();
        }
        ((com.tencent.mobileqq.qqlive.sso.c) this.sdkImpl.getExtModule("sso_module")).f("trpc.qlive.ilive_metrics_svr.IliveMetricsSvr", "GetRealTimeMetrics", MessageNano.toByteArray(bVar), new f(getRoomInfoCallback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.RoomGetInfoModule.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ GetRoomInfoCallback val$callback;

            {
                this.val$callback = getRoomInfoCallback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomGetInfoModule.this, (Object) getRoomInfoCallback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int i3, boolean z16, h hVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
                    return;
                }
                if (z16) {
                    try {
                        this.val$callback.onSuccess(com.tencent.mobileqq.qqlive.utils.d.c(br3.c.c(hVar.e())));
                        return;
                    } catch (Exception e16) {
                        this.val$callback.onFailed(-1, e16.getMessage());
                        return;
                    }
                }
                this.val$callback.onFailed(hVar.b(), hVar.c());
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
