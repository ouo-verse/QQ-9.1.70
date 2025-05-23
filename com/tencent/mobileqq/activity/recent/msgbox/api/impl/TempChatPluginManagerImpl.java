package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.a;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* loaded from: classes10.dex */
public class TempChatPluginManagerImpl implements Manager, ITempChatPluginManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TempChatPluginManager";
    private static ArrayList<Integer> sTempUinTypeList;
    private AppInterface mApp;
    private Map<String, a> tempChatPluginMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25128);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sTempUinTypeList = new ArrayList<Integer>() { // from class: com.tencent.mobileqq.activity.recent.msgbox.api.impl.TempChatPluginManagerImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }
            };
        }
    }

    public TempChatPluginManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ArrayList<Integer> getTempUinTypeList() {
        return sTempUinTypeList;
    }

    private void init() {
        this.tempChatPluginMap = new HashMap();
        HashMap<String, Class<? extends a>> hashMap = com.tencent.mobileqq.activity.recent.msgbox.inject.a.f185704c;
        for (String str : hashMap.keySet()) {
            Class<? extends a> cls = hashMap.get(str);
            if (cls != null) {
                try {
                    Constructor<? extends a> declaredConstructor = cls.getDeclaredConstructor(AppInterface.class);
                    declaredConstructor.setAccessible(true);
                    this.tempChatPluginMap.put(str, declaredConstructor.newInstance(this.mApp));
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "init tempChatPluginMap error: ", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager
    public synchronized a getTempChatPlugin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        Map<String, a> map = this.tempChatPluginMap;
        if (map != null) {
            return map.get(String.valueOf(i3));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager
    public boolean isCustomizeByBiz(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        Map<String, a> map = this.tempChatPluginMap;
        if (map != null) {
            return map.containsKey(String.valueOf(i3));
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = (AppInterface) appRuntime;
        if (this.tempChatPluginMap == null) {
            init();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager
    public boolean onHeadIconClickCusTempConv(Context context, int i3, String str) {
        ax c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(i3), str)).booleanValue();
        }
        a tempChatPlugin = getTempChatPlugin(i3);
        if (tempChatPlugin == null) {
            return false;
        }
        try {
            String b16 = tempChatPlugin.b(str);
            if (b16.startsWith("http")) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", b16);
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(intent, b16);
                context.startActivity(intent);
            } else if (b16.startsWith(SchemaUtils.SCHEMA_MQQAPI) && (c16 = bi.c((BaseQQAppInterface) this.mApp, context, b16)) != null) {
                c16.b();
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "onHeadIconClickCusTempConv Error: ", e16);
        }
        return true;
    }
}
