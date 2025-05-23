package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.c;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CompatibleDataMessageCallbackService extends Service implements IDataMessageCallBackService {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i16) {
        c.a(getApplicationContext(), intent, this);
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context context, DataMessage dataMessage) {
    }
}
