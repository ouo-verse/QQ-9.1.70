package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule;
import com.tencent.mobileqq.ark.api.module.ArkAppKoiLikeModule;
import com.tencent.mobileqq.ark.api.module.ArkAppMapModule;
import com.tencent.mobileqq.ark.api.module.ArkAppMusicModule;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModule;
import com.tencent.mobileqq.ark.api.module.ArkAppQQMsgModule;
import com.tencent.mobileqq.ark.api.module.ArkAppQQStrangerModule;
import com.tencent.mobileqq.ark.api.module.ArkAppSpringPKModule;
import com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.reminder.ark.ArkAppSendBirthdayBlessingModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqark-impl/src/main/resources/Inject_Modules.yml", version = 1)
    private static final ArrayList<Class<? extends b>> f199575a;

    static {
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f199575a = arrayList;
        arrayList.add(ArkAppQQModule.class);
        arrayList.add(ArkAppDeviceModule.class);
        arrayList.add(ArkAppDownloadModule.class);
        arrayList.add(ArkAppYYBDownloadModule.class);
        arrayList.add(ArkAppMusicModule.class);
        arrayList.add(ArkAppQQStrangerModule.class);
        arrayList.add(ArkAppMapModule.class);
        arrayList.add(ArkAppQQMsgModule.class);
        arrayList.add(ArkAppKoiLikeModule.class);
        arrayList.add(ArkAppSpringPKModule.class);
        arrayList.add(ArkAppSendBirthdayBlessingModule.class);
    }

    static int a(ark.Application application) {
        return b(application.GetSpecific("appName"));
    }

    static int b(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("com.tencent.", 0) == -1) {
            return 1;
        }
        return 0;
    }

    public static void c(ark.ModuleRegister moduleRegister, ark.Application application) {
        int a16 = a(application);
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends b>> it = f199575a.iterator();
        while (it.hasNext()) {
            try {
                b newInstance = it.next().getConstructor(ark.Application.class, Integer.TYPE).newInstance(application, Integer.valueOf(a16));
                if (newInstance.o() || a16 == 0) {
                    if (newInstance.n() || MobileQQ.sProcessId == 1) {
                        arrayList.add(newInstance);
                    }
                }
            } catch (Exception e16) {
                QLog.i("ArkApp.ArkAppModuleReg", 1, "register module fail, " + e16.toString());
            }
        }
        d(moduleRegister, arrayList);
    }

    private static void d(ark.ModuleRegister moduleRegister, List<b> list) {
        IArkConfig iArkConfig = (IArkConfig) QRoute.api(IArkConfig.class);
        for (b bVar : list) {
            if (iArkConfig != null) {
                bVar.m(iArkConfig.getAPIFrequencyConfig().get(bVar.GetTypeName()));
            }
            moduleRegister.RegCallbackWrapper(bVar);
        }
    }
}
