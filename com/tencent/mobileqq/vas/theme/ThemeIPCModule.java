package com.tencent.mobileqq.vas.theme;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

/* loaded from: classes20.dex */
public class ThemeIPCModule extends QIPCModule {
    private static String ACTION_SETUP = "setup";
    private static final String BINDER = "binder";
    public static final String NAME = "ThemeIPCModule";
    private static final String TAG = "ThemeIPCModule";
    private static ThemeIPCModule sInstance;

    ThemeIPCModule(String str) {
        super(str);
    }

    public static synchronized ThemeIPCModule getInstance() {
        ThemeIPCModule themeIPCModule;
        synchronized (ThemeIPCModule.class) {
            if (sInstance == null) {
                sInstance = new ThemeIPCModule("ThemeIPCModule");
            }
            themeIPCModule = sInstance;
        }
        return themeIPCModule;
    }

    public static void queryThemeLocation(final String str, final QueryCallback<ThemeLocator> queryCallback) {
        if (!TextUtils.isEmpty(str) && !"1000".equals(str)) {
            if ("999".equals(str)) {
                queryCallback.postQuery(new ThemeLocator().getDIYLocator());
                return;
            } else {
                QuickUpdateIPCModule.queryItemVersion(3, ThemeUtil.getThemeConfigID(str), true, new QueryItemCallback() { // from class: com.tencent.mobileqq.vas.theme.ThemeIPCModule.2
                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
                    public void onQueryItemVer(int i3, String str2, String str3) {
                        final ThemeLocator themeLocator;
                        QLog.e("ThemeIPCModule", 1, "onQueryItemVer: " + i3 + "," + str2 + "," + str3);
                        if (i3 == 0) {
                            BaseApplication context = BaseApplication.getContext();
                            themeLocator = new ThemeLocator().setThemeId(str);
                            themeLocator.init(context, str2, str3);
                        } else {
                            themeLocator = null;
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeIPCModule.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                queryCallback.postQuery(themeLocator);
                            }
                        });
                    }
                });
                return;
            }
        }
        queryCallback.postQuery(null);
    }

    public static void startSwitch(String str, ISwitchCallback iSwitchCallback) {
        Bundle bundle = new Bundle();
        if (iSwitchCallback != null) {
            bundle.putParcelable(BINDER, new BinderWarpper(iSwitchCallback.asBinder()));
        }
        bundle.putString("themeId", str);
        QIPCClientHelper.getInstance().callServer("ThemeIPCModule", ACTION_SETUP, bundle, null);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IBinder iBinder;
        ThemeSwitchCallback themeSwitchCallback;
        if (QLog.isColorLevel()) {
            QLog.d("ThemeIPCModule", 2, "onCall action = " + str);
        }
        bundle.setClassLoader(BinderWarpper.class.getClassLoader());
        String string = bundle.getString("themeId");
        if (bundle.containsKey(BINDER)) {
            iBinder = ((BinderWarpper) bundle.getParcelable(BINDER)).binder;
        } else {
            iBinder = null;
        }
        if (ACTION_SETUP.equals(str)) {
            if (iBinder != null) {
                final ISwitchCallback asInterface = ISwitchCallback.Stub.asInterface(iBinder);
                themeSwitchCallback = new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.theme.ThemeIPCModule.1
                    @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
                    public boolean beforeSwitch(ThemeLocator themeLocator) {
                        try {
                            asInterface.doSwitch(themeLocator.getThemeId(), themeLocator.getUnzipPath());
                        } catch (RemoteException e16) {
                            QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", e16);
                        }
                        return true;
                    }

                    @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
                    public void beginSwitch() {
                        try {
                            asInterface.beginSwitch();
                        } catch (RemoteException e16) {
                            QLog.e("ThemeIPCModule", 1, "beginSwitch: ", e16);
                        }
                    }

                    @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
                    public boolean postSwitch(int i16) {
                        try {
                            asInterface.postSwitch(i16);
                        } catch (RemoteException e16) {
                            QLog.e("ThemeIPCModule", 1, "postSwitch: ", e16);
                        }
                        return super.postSwitch(i16);
                    }
                };
            } else {
                themeSwitchCallback = null;
            }
            ThemeSwitcher.startSwitch(string, "200", themeSwitchCallback);
            return null;
        }
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + str);
        return RemoteProxy.onCall(this, str, bundle, i3);
    }
}
