package com.tencent.mobileqq.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.ExtC2CHelperProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/helper/Inject_AIO_Outer_Helper_Provider.yml", version = 1)
    private static final ArrayList<Class<? extends d>> f189091a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/helper/Inject_Group_Outer_Helper_Provider.yml", version = 1)
    private static final ArrayList<Class<? extends d>> f189092b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f189091a = arrayList;
        arrayList.add(com.tencent.qqnt.aio.helper.provider.C2CAIOHelperProvider.class);
        arrayList.add(ExtC2CHelperProvider.class);
        ArrayList<Class<? extends d>> arrayList2 = new ArrayList<>();
        f189092b = arrayList2;
        arrayList2.add(com.tencent.qqnt.aio.helper.provider.GroupAIOHelperProvider.class);
    }

    public static Map<String, Function0<h>> a(com.tencent.aio.api.help.a aVar) {
        HashMap hashMap = new HashMap(f189091a.size());
        int i3 = 0;
        while (true) {
            ArrayList<Class<? extends d>> arrayList = f189091a;
            if (i3 < arrayList.size()) {
                try {
                    Map<String, Function0<h>> lifeCycleHelperCreator = arrayList.get(i3).getConstructor(new Class[0]).newInstance(new Object[0]).getLifeCycleHelperCreator(aVar);
                    if (lifeCycleHelperCreator != null && !lifeCycleHelperCreator.isEmpty()) {
                        hashMap.putAll(lifeCycleHelperCreator);
                    }
                } catch (Exception e16) {
                    QLog.e("AIOHelperInjector", 1, "getInjectHelpers exception", e16);
                }
                i3++;
            } else {
                return hashMap;
            }
        }
    }

    public static Map<String, Function0<h>> b(com.tencent.aio.api.help.a aVar) {
        HashMap hashMap = new HashMap(f189092b.size());
        int i3 = 0;
        while (true) {
            ArrayList<Class<? extends d>> arrayList = f189092b;
            if (i3 < arrayList.size()) {
                try {
                    Map<String, Function0<h>> lifeCycleHelperCreator = arrayList.get(i3).getConstructor(new Class[0]).newInstance(new Object[0]).getLifeCycleHelperCreator(aVar);
                    if (lifeCycleHelperCreator != null && !lifeCycleHelperCreator.isEmpty()) {
                        hashMap.putAll(lifeCycleHelperCreator);
                    }
                } catch (Exception e16) {
                    QLog.e("AIOHelperInjector", 1, "getGroupOuterHelpers exception", e16);
                }
                i3++;
            } else {
                return hashMap;
            }
        }
    }
}
