package com.tencent.xweb.pinus.sdk.process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;

/* loaded from: classes27.dex */
public class ContentChildProcessService extends Service {
    private static final String TAG = "ContentChildProcessService";
    private ChildProcessServiceWrapper mService;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mService == null) {
            ChildProcessServiceWrapper childProcessServiceWrapper = new ChildProcessServiceWrapper(intent, this, getApplicationContext());
            this.mService = childProcessServiceWrapper;
            childProcessServiceWrapper.onCreate();
        }
        return this.mService.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mService.onDestroy();
        this.mService = null;
    }
}
