package com.tencent.mobileqq.troop.roamsetting;

import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import GeneralSettings.Setting;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.u;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoamSettingHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    public RoamSettingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(boolean z16, String str, Map<String, Integer> map, RoamSettingServiceImpl roamSettingServiceImpl, Setting setting, int i3, String str2) {
        if (!z16 && (z16 || !roamSettingServiceImpl.enableRetry())) {
            if (QLog.isColorLevel()) {
                QLog.d("RoamSettingHandler", 2, "-->" + str2 + " not notifyUI, path=" + setting.Path + " value=" + setting.Value + "uploadSuccess=" + z16 + " enableRetry=" + roamSettingServiceImpl.enableRetry());
                return;
            }
            return;
        }
        notifyUI(i3, z16, new Object[]{str, map});
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, RespGetSettings respGetSettings) {
        int i3;
        if (fromServiceMsg == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoamSettingHandler", 2, "handleGetGeneralSettingAll cmd=" + fromServiceMsg.getMsfCommand() + " resp.isSucc=" + fromServiceMsg.isSuccess() + " resultCode=" + fromServiceMsg.getResultCode());
        }
        IRoamSettingService iRoamSettingService = (IRoamSettingService) this.appRuntime.getRuntimeService(IRoamSettingService.class, "");
        if (fromServiceMsg.isSuccess()) {
            int i16 = toServiceMsg.extraData.getInt("Revision");
            int i17 = toServiceMsg.extraData.getInt("respRevision", -1);
            boolean z16 = toServiceMsg.extraData.getBoolean("needTroopSettings");
            long j3 = toServiceMsg.extraData.getLong("Offset");
            if (respGetSettings == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("RoamSettingHandler", 2, "handlerGetGeneralSettingAll, data == null");
                }
                ((RoamSettingServiceImpl) iRoamSettingService).onGetAllSettingsFinish(false, true);
                notifyUI(1, false, new Object[]{Boolean.TRUE});
                return;
            }
            ArrayList<Setting> arrayList = respGetSettings.Settings;
            Object obj = "null";
            if (arrayList != null && arrayList.size() != 0) {
                if (i17 != -1 && i17 < respGetSettings.Revision) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RoamSettingHandler", 2, "respRevision != data.Revision, load settings again, respRev=" + i17 + " data.Rev=" + respGetSettings.Revision);
                    }
                    ((RoamSettingServiceImpl) iRoamSettingService).onGetAllSettingsFinish(false, false);
                    iRoamSettingService.loadAllRoamSettings(z16);
                    notifyUI(1, true, new Object[]{Boolean.FALSE});
                    return;
                }
                if (i17 == -1) {
                    i3 = respGetSettings.Revision;
                } else {
                    i3 = i17;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("oldRevision=");
                    sb5.append(i16);
                    sb5.append(" lastRespRevision=");
                    sb5.append(i3);
                    sb5.append(" total=");
                    sb5.append(respGetSettings.Total);
                    sb5.append(" offset=");
                    sb5.append(j3);
                    sb5.append(" data.settings.size=");
                    ArrayList<Setting> arrayList2 = respGetSettings.Settings;
                    if (arrayList2 != null) {
                        obj = Integer.valueOf(arrayList2.size());
                    }
                    sb5.append(obj);
                    QLog.d("RoamSettingHandler", 2, sb5.toString());
                }
                ((IBizTroopDBUtilsApi) QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings(respGetSettings.Settings, this.appRuntime);
                long size = j3 + respGetSettings.Settings.size();
                if (respGetSettings.Total > size) {
                    ((RoamSettingServiceImpl) iRoamSettingService).loadRoamSettingsByPage(i16, size, i3, z16, null);
                    notifyUI(1, true, new Object[]{Boolean.FALSE});
                    return;
                } else {
                    ((IBizTroopDBUtilsApi) QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(respGetSettings.Revision, this.appRuntime);
                    ((RoamSettingServiceImpl) iRoamSettingService).onGetAllSettingsFinish(true, true);
                    notifyUI(1, true, new Object[]{Boolean.TRUE});
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("handlerGetGeneralSettingAll, data.Settings=");
                ArrayList<Setting> arrayList3 = respGetSettings.Settings;
                if (arrayList3 != null) {
                    obj = Integer.valueOf(arrayList3.size());
                }
                sb6.append(obj);
                QLog.d("RoamSettingHandler", 2, sb6.toString());
            }
            ((IBizTroopDBUtilsApi) QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(respGetSettings.Revision, this.appRuntime);
            ((RoamSettingServiceImpl) iRoamSettingService).onGetAllSettingsFinish(true, true);
            notifyUI(1, true, new Object[]{Boolean.TRUE});
            return;
        }
        ((RoamSettingServiceImpl) iRoamSettingService).onGetAllSettingsFinish(false, true);
        notifyUI(1, false, new Object[]{Boolean.TRUE});
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, RespSetSettings respSetSettings) {
        Object valueOf;
        ArrayList<Setting> arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("Settings");
        int i3 = toServiceMsg.extraData.getInt("localRevision");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handlerUploadRoamSettingNewValue isSuccess = ");
            sb5.append(fromServiceMsg.isSuccess());
            sb5.append(" reqLocalRevision=");
            sb5.append(i3);
            sb5.append(" data.Revision=");
            if (respSetSettings == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(respSetSettings.Revision);
            }
            sb5.append(valueOf);
            QLog.d("RoamSettingHandler", 2, sb5.toString());
        }
        boolean z16 = false;
        if (fromServiceMsg.isSuccess()) {
            if (respSetSettings != null) {
                if (i3 + 1 == respSetSettings.Revision) {
                    ((IBizTroopDBUtilsApi) QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettings(arrayList, this.appRuntime);
                    ((IBizTroopDBUtilsApi) QRoute.api(IBizTroopDBUtilsApi.class)).saveGeneralSettingsRevision(respSetSettings.Revision, this.appRuntime);
                    ((RoamSettingServiceImpl) this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(true, false);
                } else {
                    ((RoamSettingServiceImpl) this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(true, true);
                }
            }
            z16 = true;
        } else {
            ((RoamSettingServiceImpl) this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).onUploadRomingSettingsFinish(false, false);
        }
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RoamSettingHandler", 2, "handlerUploadRoamSettingNewValue  settings is null.");
                return;
            }
            return;
        }
        L2(arrayList, z16);
    }

    private Map<String, Integer> K2(ArrayList<Setting> arrayList) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Setting setting = arrayList.get(i3);
                String str = setting.Path;
                if (str != null && str.length() != 0 && (split = str.split("\\.")) != null && split.length != 0) {
                    hashMap.put(split[split.length - 1], Integer.valueOf(Integer.parseInt(setting.Value)));
                }
            }
        }
        return hashMap;
    }

    private void L2(ArrayList<Setting> arrayList, boolean z16) {
        Map<String, Integer> K2 = K2(arrayList);
        RoamSettingServiceImpl roamSettingServiceImpl = (RoamSettingServiceImpl) this.appRuntime.getRuntimeService(IRoamSettingService.class, "");
        Iterator<Setting> it = arrayList.iterator();
        while (it.hasNext()) {
            Setting next = it.next();
            String str = next.Path;
            if (str != null) {
                F2(z16, str, K2, roamSettingServiceImpl, next, 2, "handleUploadRoamsSettingNewValue");
            }
        }
    }

    public void G2(int i3, long j3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoamSettingHandler", 2, "getAllGeneralSettings.localRevision=" + i3 + " offset=" + j3 + " respRevision=" + i16 + " isNeedGetTroopMsgFilter=" + z16);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        u.c().a(arrayList);
        H2(arrayList, i3, j3, i16, 100, z16);
    }

    public void H2(ArrayList<String> arrayList, int i3, long j3, int i16, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, arrayList, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoamSettingHandler", 2, "GeneralSettings getGeneralSettings start offset =" + j3);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("ProfileService.ReqGetSettings");
        createToServiceMsg.extraData.putSerializable("Paths", arrayList);
        createToServiceMsg.extraData.putInt("Revision", i3);
        createToServiceMsg.extraData.putLong("Offset", j3);
        createToServiceMsg.extraData.putLong("Count", j16);
        createToServiceMsg.extraData.putInt("respRevision", i16);
        createToServiceMsg.extraData.putBoolean("needTroopSettings", z16);
        send(createToServiceMsg);
    }

    public void M2(int i3, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) concurrentHashMap);
            return;
        }
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            concurrentHashMap2.putAll(concurrentHashMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : concurrentHashMap2.entrySet()) {
                arrayList.add(new Setting((String) entry.getKey(), ((Integer) entry.getValue()).toString()));
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("ProfileService.ReqSetSettings");
            createToServiceMsg.extraData.putSerializable("Settings", arrayList);
            createToServiceMsg.extraData.putSerializable("localRevision", Integer.valueOf(i3));
            send(createToServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("ProfileService.ReqGetSettings");
            this.allowCmdSet.add("ProfileService.ReqSetSettings");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("RoamSettingHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("ProfileService.ReqGetSettings".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, (RespGetSettings) obj);
                return;
            } else {
                if ("ProfileService.ReqSetSettings".equals(fromServiceMsg.getServiceCmd())) {
                    J2(toServiceMsg, fromServiceMsg, (RespSetSettings) obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RoamSettingHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
