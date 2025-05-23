package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.AppStatusCallbackSingleton;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.app.lifecycle.IFragmentLifecycleCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vas.adv.negativefeedback.lifecycle.NFBLifeCycleCallback;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QBaseActivityInjectUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "qqBaseActivity.QBaseActivityInjectUtil";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static HashMap<String, Class<com.tencent.mobileqq.app.anim.a>> sAnimationSetterClasses;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<com.tencent.mobileqq.app.displaymetric.b> sDisplayMetricCheckerList;
    private static ArrayList sDisplayMetricCheckerList_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<BaseActivityLifecycleCallbacks> sGlobalCallbacks;
    private static ArrayList sGlobalCallbacks_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<IFragmentLifecycleCallback> sGlobalFragmentLifeCycleList;
    private static ArrayList sGlobalFragmentLifeCycleList_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<AppStatusCallbackSingleton.IAppStatusCallback> sInjectAppStatusCallbackList;
    private static ArrayList sInjectAppStatusCallbackList_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<IBaseActivityInjectInterface> sInjectInterfaceList;
    private static ArrayList sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<IActivityModuleProvider> sInjectModuleProviderList;
    private static ArrayList sInjectModuleProviderList_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_ComsBaseActivityConfig.yml", version = 1)
    public static ArrayList<BaseActivityLifecycleCallbacks> sInstanceCallbacks;
    private static ArrayList sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sInjectModuleProviderList_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(DefaultActivityModuleProvider.class);
        ArrayList arrayList2 = new ArrayList();
        sInjectAppStatusCallbackList_AutoGenClazzList_QAutoInjectTransform = arrayList2;
        arrayList2.add(b.class);
        ArrayList arrayList3 = new ArrayList();
        sGlobalFragmentLifeCycleList_AutoGenClazzList_QAutoInjectTransform = arrayList3;
        arrayList3.add(com.tencent.mobileqq.app.lifecycle.c.class);
        ArrayList arrayList4 = new ArrayList();
        sGlobalCallbacks_AutoGenClazzList_QAutoInjectTransform = arrayList4;
        arrayList4.add(BaseActivityLifecycleCallbackImpl.class);
        ArrayList arrayList5 = new ArrayList();
        sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform = arrayList5;
        arrayList5.add(com.tencent.mobileqq.app.lifecycle.d.class);
        sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform.add(com.tencent.mobileqq.app.lifecycle.b.class);
        sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform.add(df1.d.class);
        sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform.add(NFBLifeCycleCallback.class);
        ArrayList arrayList6 = new ArrayList();
        sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform = arrayList6;
        arrayList6.add(BaseActivityInjectImpl.class);
        ArrayList arrayList7 = new ArrayList();
        sDisplayMetricCheckerList_AutoGenClazzList_QAutoInjectTransform = arrayList7;
        arrayList7.add(com.tencent.mobileqq.app.utils.g.class);
        sGlobalCallbacks = new ArrayList<>();
        sInjectInterfaceList = new ArrayList<>();
        sInjectModuleProviderList = new ArrayList<>();
        sInstanceCallbacks = new ArrayList<>();
        sInjectAppStatusCallbackList = new ArrayList<>();
        sGlobalFragmentLifeCycleList = new ArrayList<>();
        HashMap<String, Class<com.tencent.mobileqq.app.anim.a>> hashMap = new HashMap<>();
        sAnimationSetterClasses = hashMap;
        hashMap.put("babyQ", com.tencent.mobileqq.anim.b.class);
        sAnimationSetterClasses.put("aio", com.tencent.mobileqq.anim.a.class);
        sDisplayMetricCheckerList = new ArrayList<>();
        initInjectVariable();
    }

    public QBaseActivityInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private static void initInjectVariable() {
        com.tencent.mobileqq.qroute.utils.b.c(sInjectModuleProviderList_AutoGenClazzList_QAutoInjectTransform, sInjectModuleProviderList);
        com.tencent.mobileqq.qroute.utils.b.c(sInjectAppStatusCallbackList_AutoGenClazzList_QAutoInjectTransform, sInjectAppStatusCallbackList);
        com.tencent.mobileqq.qroute.utils.b.c(sGlobalFragmentLifeCycleList_AutoGenClazzList_QAutoInjectTransform, sGlobalFragmentLifeCycleList);
        com.tencent.mobileqq.qroute.utils.b.c(sGlobalCallbacks_AutoGenClazzList_QAutoInjectTransform, sGlobalCallbacks);
        com.tencent.mobileqq.qroute.utils.b.c(sInstanceCallbacks_AutoGenClazzList_QAutoInjectTransform, sInstanceCallbacks);
        com.tencent.mobileqq.qroute.utils.b.c(sInjectInterfaceList_AutoGenClazzList_QAutoInjectTransform, sInjectInterfaceList);
        com.tencent.mobileqq.qroute.utils.b.c(sDisplayMetricCheckerList_AutoGenClazzList_QAutoInjectTransform, sDisplayMetricCheckerList);
    }
}
