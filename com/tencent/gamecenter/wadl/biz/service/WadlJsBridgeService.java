package com.tencent.gamecenter.wadl.biz.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlJsBridgeService extends AppService implements Handler.Callback {
    public static final int ACTION_VM_JUMP_APP_START = 104;
    public static final int ACTION_VM_PAUSE = 105;
    public static final int ACTION_VM_RESTART = 103;
    public static final String INTENT_PARAMS_ID = "id";
    public static final String KEY_ACTION_NAME = "action_name";
    private static String TAG = "WadlJsBridgeService";
    private Handler handler;
    private int startId;

    public WadlJsBridgeService() {
        QLog.i(TAG, 1, "WadlJsBridgeService new instance");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str = (String) message.obj;
        QLog.i(TAG, 1, "handleMessage what=" + message.what + "," + message.obj);
        switch (message.what) {
            case 103:
                IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
                if (iQQGameDLService != null) {
                    iQQGameDLService.doResumeAction(3, str);
                    break;
                }
                break;
            case 104:
                IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                if (iMiniAppService != null) {
                    iMiniAppService.startAppByAppid(MobileQQ.sMobileQQ, str, "", "", LaunchScene.LAUNCH_SCENE_VM_NOTIFICATION, null);
                    break;
                }
                break;
            case 105:
                IQQGameDLService iQQGameDLService2 = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
                if (iQQGameDLService2 != null) {
                    iQQGameDLService2.doPauseAction(3, str);
                    break;
                }
                break;
        }
        stopSelf(this.startId);
        return false;
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        QLog.i(TAG, 1, "onCreate...");
        this.handler = new Handler(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.handler = null;
        QLog.i(TAG, 1, "Service is Destroyed");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        this.startId = i16;
        QLog.i(TAG, 1, "onStartCommand flags=," + i3 + ",startId=" + i16 + ",intent=" + intent);
        if (intent != null && this.handler != null) {
            int intExtra = intent.getIntExtra("action_name", 0);
            String stringExtra = intent.getStringExtra("id");
            QLog.i(TAG, 1, "onStartCommand action=" + intExtra + ",id=" + stringExtra);
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.what = intExtra;
            obtainMessage.obj = stringExtra;
            this.handler.sendMessage(obtainMessage);
            return 2;
        }
        return 2;
    }
}
