package com.tencent.mobileqq.relation.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQStrangerAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFloatingApi;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQStrangerAppInterface extends BaseQQStrangerAppInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f280598d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStrangerAppInterface.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                if (!NewIntent.ACTION_ACCOUNT_CHANGED.equals(action) && !NewIntent.ACTION_ACCOUNT_KICKED.equals(action) && !NewIntent.ACTION_ACCOUNT_EXPIRED.equals(action) && !NewIntent.ACTION_LOGOUT.equals(action)) {
                    if (!("mqq.intent.action.EXIT_" + ((AppInterface) QQStrangerAppInterface.this).app.getPackageName()).equals(action)) {
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("QQStrangerAppInterface", 2, "***exitProcess*** receive broadcast action=" + action);
                }
                ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).exitRoom();
            }
        }
    }

    public QQStrangerAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) str);
        } else {
            this.f280598d = new a();
        }
    }

    private void registerAccountReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction("mqq.intent.action.EXIT_" + this.app.getPackageName());
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        this.app.registerReceiver(this.f280598d, intentFilter);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return !((IMatchFriendFloatingApi) QRoute.api(IMatchFriendFloatingApi.class)).checkFloatWindowShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QLog.i("QQStrangerAppInterface", 1, "onCreate");
        long currentTimeMillis = System.currentTimeMillis();
        ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).onQQStrangerProcessCreate();
        registerAccountReceiver();
        QLog.d("QQStrangerAppInterface", 1, "Preload qqstrangerprocess end time is " + System.currentTimeMillis() + " ; QQStrangerAppInterface create total time is " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("QQStrangerAppInterface", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).onQQStrangerProcessDestroy();
        try {
            this.app.unregisterReceiver(this.f280598d);
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QQStrangerAppInterface", 2, "unregisterReceiver: ", e16);
            }
        }
        super.onDestroy();
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.preExit();
        QLog.e("QQStrangerAppInterface", 1, "killed by qq");
        ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).exitRoom();
    }
}
