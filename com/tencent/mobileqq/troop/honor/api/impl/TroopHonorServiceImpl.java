package com.tencent.mobileqq.troop.honor.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.honor.TroopHonorManager;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.config.b;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$HonorList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHonorServiceImpl implements ITroopHonorService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopHonorServiceImpl";
    AppRuntime mAppRuntime;
    TroopHonorManager manager;

    public TroopHonorServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.manager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortHonorList$0(com.tencent.mobileqq.troop.honor.config.a aVar, com.tencent.mobileqq.troop.honor.config.a aVar2) {
        int i3 = aVar.f297516m;
        int i16 = aVar2.f297516m;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void asyncGetTroopHonorListByDirect(String str, String str2, ITroopHonorService.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, cVar);
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.e(str, str2, cVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList(String str, Byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) b16);
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            return troopHonorManager.g(str, b16);
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public List<Drawable> getHonorIcon(ITroopHonorService.b bVar, ITroopHonorService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? getHonorIcon(bVar) : (List) iPatchRedirector.redirect((short) 18, (Object) this, (Object) bVar, (Object) aVar);
    }

    public TroopHonorManager getTroopHonorManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopHonorManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "mAppRuntime == null");
                return null;
            }
            return null;
        }
        return (TroopHonorManager) ((IManagerFactoryService) appRuntime.getRuntimeService(IManagerFactoryService.class, "")).getManager(TroopHonorManager.class);
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public boolean isGrayTroopHonor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            return troopHonorManager.i(str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public boolean isSupportTroopHonor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            return troopHonorManager.j(str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void notifyTroopHonorGlobalUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.manager.p();
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void notifyTroopMemberHonorUpdate(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2);
        } else {
            this.manager.r(str, str2);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
            this.manager = getTroopHonorManager();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void saveHostHonorListRichTag(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Short.valueOf(s16));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.t(s16);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void sortHonorList(List<com.tencent.mobileqq.troop.honor.config.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        } else if (list.size() > 1) {
            Collections.sort(list, new Comparator() { // from class: com.tencent.mobileqq.troop.honor.api.impl.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$sortHonorList$0;
                    lambda$sortHonorList$0 = TroopHonorServiceImpl.lambda$sortHonorList$0((com.tencent.mobileqq.troop.honor.config.a) obj, (com.tencent.mobileqq.troop.honor.config.a) obj2);
                    return lambda$sortHonorList$0;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updateConfig(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bVar, Boolean.valueOf(z16));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.u(bVar, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public boolean updateEntity(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) entity)).booleanValue();
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            return troopHonorManager.v(entity);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updateHostHonorList(List<oidb_0xdc9$HonorList> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.w(list, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updatePushTroopHonor(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, bArr, Integer.valueOf(i3));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.z(str, bArr, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updateTroopHonorAIOSwitch(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.A(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updateTroopMemberHonor(String str, String str2, String str3, byte b16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, str3, Byte.valueOf(b16), Long.valueOf(j3));
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.D(str, str2, str3, b16, j3);
        }
    }

    private List<Drawable> getHonorIcon(ITroopHonorService.b bVar) {
        if (this.manager != null && bVar.a()) {
            if (QLog.isDebugVersion() && QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getHonorIcon troopUin = " + bVar.f297498a + "memberUin = " + bVar.f297499b + " honorStr = " + bVar.f297500c + " richFlag = " + bVar.f297501d);
            }
            List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList = convertToHonorList(bVar.f297500c, bVar.f297501d);
            sortHonorList(convertToHonorList);
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mobileqq.troop.honor.config.a aVar : convertToHonorList) {
                arrayList.add(com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO).k(aVar.f297513f).d(VasApngUtil.getCacheFilePath(aVar.f297513f)).a());
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.troop.honor.api.ITroopHonorService
    public void updateHostHonorList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        TroopHonorManager troopHonorManager = this.manager;
        if (troopHonorManager != null) {
            troopHonorManager.x(z16);
        }
    }
}
