package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.f.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements c {
    @Override // com.heytap.mcssdk.e.c
    public void a(final Context context, BaseMode baseMode, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            final DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                f.b(new Runnable() { // from class: com.heytap.mcssdk.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        iDataMessageCallBackService.processMessage(context, dataMessage);
                    }
                });
            }
        }
    }
}
