package com.tencent.mobileqq.avatar.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f200128d;

    a(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static a e() {
        if (f200128d == null) {
            synchronized (a.class) {
                if (f200128d == null) {
                    f200128d = new a("AvatarServerIPCModule");
                }
            }
        }
        return f200128d;
    }

    public EIPCResult b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
        }
        String choosedIP = ((IQQAvatarHandlerService) appInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedIP();
        Bundle bundle = new Bundle();
        bundle.putString("key_ip", choosedIP);
        return EIPCResult.createSuccessResult(bundle);
    }

    public EIPCResult c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
        }
        String choosedStrangerGroupIP = ((IQQAvatarHandlerService) appInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedStrangerGroupIP();
        Bundle bundle = new Bundle();
        bundle.putString("key_ip", choosedStrangerGroupIP);
        return EIPCResult.createSuccessResult(bundle);
    }

    public EIPCResult d(String str, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) appInterface);
        }
        Setting faceSetting = ((IQQAvatarDataService) appInterface.getRuntimeService(IQQAvatarDataService.class, "")).getFaceSetting(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_face_setting", faceSetting);
        return EIPCResult.createSuccessResult(bundle);
    }

    public void f(Setting setting, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) setting, (Object) appInterface);
            return;
        }
        ((IQQAvatarDataService) appInterface.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(setting);
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.persistOrReplace(setting);
        createEntityManager.close();
    }

    public void g(ArrayList<String> arrayList, long j3, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, arrayList, Long.valueOf(j3), appInterface);
            return;
        }
        if (j3 <= 0) {
            return;
        }
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) appInterface.getRuntimeService(IQQAvatarDataService.class, "");
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, arrayList.get(i3));
                if (setting != null) {
                    setting.updateTimestamp = j3;
                    iQQAvatarDataService.updateSettingTableCache(setting);
                    arrayList2.add(new UpdateTransaction(setting));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        createEntityManager.doMultiDBOperateByTransaction(arrayList2);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return null;
        }
        AppInterface appInterface = (AppInterface) waitAppRuntime;
        if ("action_get_chose_ip".equals(str)) {
            return b(appInterface);
        }
        if ("action_get_stranger_group_ip".equals(str)) {
            return c(appInterface);
        }
        if ("action_get_face_setting".equals(str)) {
            return d(bundle.getString("key_face_setting_key"), appInterface);
        }
        if ("action_update_face_setting".equals(str)) {
            f((Setting) bundle.getParcelable("key_face_setting"), appInterface);
            return null;
        }
        if (!"action_update_setting_timestamp".equals(str)) {
            return null;
        }
        g(bundle.getStringArrayList("key_key_list"), bundle.getLong("key_update_time", 0L), appInterface);
        return null;
    }
}
