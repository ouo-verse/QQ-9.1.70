package com.tencent.mobileqq.microapp;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.out.plugins.OtherJsPlugin;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppInterface extends AppInterface {
    static IPatchRedirector $redirector_ = null;
    private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
    static final String TAG = "MiniAppInterface";
    private BroadcastReceiver accountReceiver;
    private HashMap authorizeMap;
    private EntityManagerFactory mFactory;

    public MiniAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl, (Object) str);
        } else {
            this.authorizeMap = new HashMap();
            this.accountReceiver = new b(this);
        }
    }

    private void registerAccountReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction("mqq.intent.action.EXIT_" + this.app.getPackageName());
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("com.tencent.process.exit");
        this.app.registerReceiver(this.accountReceiver, intentFilter);
    }

    public void exitProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            this.app.unregisterReceiver(this.accountReceiver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ThreadManagerV2.excute(new a(this), 16, null, true);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    public com.tencent.mobileqq.microapp.app.a getAuthorizeCenter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.microapp.app.a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.authorizeMap.containsKey(str)) {
            synchronized (this.authorizeMap) {
                if (!this.authorizeMap.containsKey(str)) {
                    this.authorizeMap.put(str, new com.tencent.mobileqq.microapp.app.a(this.app, str + "_" + getCurrentAccountUin()));
                }
            }
        }
        return (com.tencent.mobileqq.microapp.app.a) this.authorizeMap.get(str);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (this.mFactory == null) {
            this.mFactory = new QQEntityManagerFactory(getAccount());
        }
        return this.mFactory;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "miniapp";
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
        new InitMemoryCache().step();
        new InitUrlDrawable().step();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OtherJsPlugin(this));
        MiniAppController.getInstance().registeJsPlugin(arrayList);
        registerAccountReceiver();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Application OnCreate complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        MiniAppController.getInstance().onDestory();
        h.a().b();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        synchronized (this.authorizeMap) {
            this.authorizeMap.clear();
        }
    }
}
