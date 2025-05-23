package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.f.f;
import com.heytap.mcssdk.f.g;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements c {
    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final com.heytap.mcssdk.c.a aVar = (com.heytap.mcssdk.c.a) baseMode;
            com.heytap.mcssdk.f.c.b("mcssdk-CallBackResultProcessor:" + aVar.toString());
            f.b(new Runnable() { // from class: com.heytap.mcssdk.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(aVar, d.k());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.heytap.mcssdk.c.a aVar, d dVar) {
        String str;
        if (aVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (dVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (dVar.q() != null) {
                int e16 = aVar.e();
                if (e16 == 12289) {
                    if (aVar.g() == 0) {
                        dVar.a(aVar.f());
                    }
                    dVar.q().onRegister(aVar.g(), aVar.f());
                    return;
                } else {
                    if (e16 == 12290) {
                        dVar.q().onUnRegister(aVar.g());
                        return;
                    }
                    if (e16 == 12298) {
                        dVar.q().onSetPushTime(aVar.g(), aVar.f());
                        return;
                    } else if (e16 == 12306) {
                        dVar.q().onGetPushStatus(aVar.g(), g.a(aVar.f()));
                        return;
                    } else {
                        if (e16 != 12309) {
                            return;
                        }
                        dVar.q().onGetNotificationStatus(aVar.g(), g.a(aVar.f()));
                        return;
                    }
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        com.heytap.mcssdk.f.c.e(str);
    }
}
