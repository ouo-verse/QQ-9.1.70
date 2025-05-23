package com.tencent.mobileqq.troop.troopapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.GroupAppPb$AppInfo;
import tencent.im.oidb.GroupAppPb$AppList;
import tencent.im.oidb.GroupAppPb$ClientInfo;
import tencent.im.oidb.GroupAppPb$ReqBody;
import tencent.im.oidb.GroupAppPb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f299433d;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    private GroupAppPb$RspBody a(FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length != 0) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            byte[] bArr = new byte[r8.getInt() - 4];
            ByteBuffer.wrap(wupBuffer).get(bArr);
            try {
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                if (QLog.isColorLevel()) {
                    QLog.i("GroupAppsServlet", 2, "mergeFromPacket: invoked. " + (" oidbHeader: " + i3 + " errorMsg: " + str));
                }
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                GroupAppPb$RspBody groupAppPb$RspBody = new GroupAppPb$RspBody();
                try {
                    groupAppPb$RspBody.mergeFrom(byteArray);
                    return groupAppPb$RspBody;
                } catch (Exception e16) {
                    QLog.i("GroupAppsServlet", 1, "GroupAppPb mergeFromPacket: invoked.  e: " + e16);
                    return null;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.i("GroupAppsServlet", 1, "oidb mergeFromPacket: invoked.  e: " + e17);
            }
        }
        return null;
    }

    public static boolean b(AppRuntime appRuntime, long j3) {
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) appRuntime.getRuntimeService(ITroopAioAppService.class, "");
        GrayGroupAppEntity grayGroupAppEntity = iTroopAioAppService.getGrayAppInfoMap().get(Long.valueOf(j3));
        if (grayGroupAppEntity == null) {
            return true;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis - grayGroupAppEntity.updatedTimestamp > iTroopAioAppService.getRequestIntervalSecond(j3) * 1000) {
            return true;
        }
        return false;
    }

    private static void c(AppRuntime appRuntime, long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_GROUP_UIN", j3);
        appRuntime.notifyObservers(com.tencent.mobileqq.troop.observer.a.class, 1, false, bundle);
    }

    public static void d(AppRuntime appRuntime, long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("KEY_GROUP_UIN", j3);
        appRuntime.notifyObservers(com.tencent.mobileqq.troop.observer.a.class, 1, true, bundle);
    }

    private void e(long j3, GroupAppPb$RspBody groupAppPb$RspBody) {
        GroupAppPb$AppList groupAppPb$AppList = groupAppPb$RspBody.red_point_list.get();
        HashSet hashSet = new HashSet(20);
        Iterator<GroupAppPb$AppInfo> it = groupAppPb$AppList.infos.get().iterator();
        while (it.hasNext()) {
            hashSet.add(Integer.valueOf(it.next().appid.get()));
        }
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsServlet", 2, "redDotAppId: " + Arrays.toString(hashSet.toArray()));
        }
        GroupAppPb$AppList groupAppPb$AppList2 = groupAppPb$RspBody.full_list.get();
        String str = groupAppPb$AppList2.hash.get();
        ArrayList arrayList = new ArrayList(20);
        List<GroupAppPb$AppInfo> list = groupAppPb$AppList2.infos.get();
        StringBuilder sb5 = new StringBuilder();
        Iterator<GroupAppPb$AppInfo> it5 = list.iterator();
        while (true) {
            boolean z16 = true;
            if (!it5.hasNext()) {
                break;
            }
            GroupAppPb$AppInfo next = it5.next();
            TroopAIOAppInfo troopAIOAppInfo = new TroopAIOAppInfo();
            troopAIOAppInfo.appid = next.appid.get();
            troopAIOAppInfo.name = next.name.get();
            troopAIOAppInfo.url = next.url.get();
            troopAIOAppInfo.iconUrl = next.icon.get();
            if (next.is_gray.get() != 1) {
                z16 = false;
            }
            troopAIOAppInfo.isGray = z16;
            troopAIOAppInfo.simpleDayUrl = next.icon_simple_day.get();
            sb5.append("parseAndStoreFullAppInfos  simpleDayUrl is null?");
            sb5.append(TextUtils.isEmpty(troopAIOAppInfo.simpleDayUrl));
            sb5.append("\n");
            troopAIOAppInfo.simpleNightUrl = next.icon_simple_night.get();
            sb5.append("parseAndStoreFullAppInfos  simpleNightUrl is null?");
            sb5.append(TextUtils.isEmpty(troopAIOAppInfo.simpleNightUrl));
            sb5.append("\n");
            troopAIOAppInfo.iconYouth = next.icon_youth.get();
            arrayList.add(troopAIOAppInfo);
        }
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) this.f299433d.getRuntimeService(ITroopAioAppService.class, "");
        iTroopAioAppService.setFullAppListHash(str);
        iTroopAioAppService.saveFullAppListHashInSp();
        if (!g.d(arrayList)) {
            iTroopAioAppService.setFullAppsListInfos(arrayList);
            if (QLog.isColorLevel()) {
                QLog.i("GroupAppsServlet", 2, "net fullAppInfos" + h.a(iTroopAioAppService.getFullAppsListInfos()));
            }
        } else {
            ArrayList arrayList2 = new ArrayList(iTroopAioAppService.getFullAppsListInfos());
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                TroopAIOAppInfo troopAIOAppInfo2 = (TroopAIOAppInfo) it6.next();
                if (hashSet.contains(Integer.valueOf(troopAIOAppInfo2.appid))) {
                    troopAIOAppInfo2.redPoint = true;
                }
            }
            iTroopAioAppService.setFullAppsListInfos(arrayList2);
            if (QLog.isColorLevel()) {
                QLog.i("GroupAppsServlet", 2, "cache fullAppInfos" + h.a(iTroopAioAppService.getFullAppsListInfos()));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GroupAppsServlet", 1, sb5.toString());
        }
        FullListGroupAppEntity fullListGroupAppEntity = new FullListGroupAppEntity();
        fullListGroupAppEntity.troopAIOAppInfos = iTroopAioAppService.getFullAppsListInfos();
        iTroopAioAppService.fullListGroupAppsDbHelper().e(fullListGroupAppEntity);
    }

    private void f(long j3, GroupAppPb$RspBody groupAppPb$RspBody) {
        GroupAppPb$AppList groupAppPb$AppList = groupAppPb$RspBody.group_gray_list.get();
        String str = groupAppPb$AppList.hash.get();
        ArrayList arrayList = new ArrayList(20);
        for (GroupAppPb$AppInfo groupAppPb$AppInfo : groupAppPb$AppList.infos.get()) {
            TroopAIOAppInfo troopAIOAppInfo = new TroopAIOAppInfo();
            troopAIOAppInfo.appid = groupAppPb$AppInfo.appid.get();
            troopAIOAppInfo.hashVal = str;
            arrayList.add(troopAIOAppInfo);
        }
        GrayGroupAppEntity grayGroupAppEntity = new GrayGroupAppEntity();
        grayGroupAppEntity.groupUin = j3;
        grayGroupAppEntity.troopAIOAppInfos = arrayList;
        grayGroupAppEntity.updatedTimestamp = NetConnInfoCenter.getServerTimeMillis();
        grayGroupAppEntity.requestIntervalSecond = groupAppPb$RspBody.cache_interval.get();
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) this.f299433d.getRuntimeService(ITroopAioAppService.class, "");
        iTroopAioAppService.getGrayAppInfoMap().put(Long.valueOf(j3), grayGroupAppEntity);
        iTroopAioAppService.grayGroupAppsDbHelper().g(grayGroupAppEntity);
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsServlet", 2, ("parseAndStoreGrayAppInfos of " + j3) + " " + h.a(arrayList));
        }
    }

    public static void g(AppRuntime appRuntime, long j3, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsServlet", 2, "requestApps: invoked. " + ("groupUin = [" + j3 + "], groupType = [" + i3 + "]"));
        }
        GroupAppPb$ReqBody groupAppPb$ReqBody = new GroupAppPb$ReqBody();
        groupAppPb$ReqBody.group_id.set(j3);
        groupAppPb$ReqBody.group_type.set(i3);
        ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) appRuntime.getRuntimeService(ITroopAioAppService.class, "");
        String grayAppsHash = iTroopAioAppService.getGrayAppsHash(j3);
        String fullAppListHash = iTroopAioAppService.getFullAppListHash();
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsServlet", 2, "requestApps: invoked.  full: " + fullAppListHash + " gray: " + grayAppsHash + " version: " + AppSetting.f99551k + "." + AppSetting.f99542b);
        }
        groupAppPb$ReqBody.full_list_hash.set(fullAppListHash);
        groupAppPb$ReqBody.group_gray_list_hash.set(grayAppsHash);
        groupAppPb$ReqBody.mode.set(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0);
        GroupAppPb$ClientInfo groupAppPb$ClientInfo = new GroupAppPb$ClientInfo();
        groupAppPb$ClientInfo.platform.set(2);
        groupAppPb$ClientInfo.version.set(AppSetting.f99551k + "." + AppSetting.f99542b);
        groupAppPb$ReqBody.client.set(groupAppPb$ClientInfo);
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), f.class);
        newIntent.putExtra("KEY_REQ_DATA", groupAppPb$ReqBody.toByteArray());
        newIntent.putExtra("KEY_GROUP_UIN", j3);
        appRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            this.f299433d = getAppRuntime();
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        GroupAppPb$RspBody a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsServlet", 2, "onReceive: invoked. " + fromServiceMsg);
        }
        long longExtra = intent.getLongExtra("KEY_GROUP_UIN", 0L);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && (a16 = a(fromServiceMsg)) != null) {
            e(longExtra, a16);
            f(longExtra, a16);
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d(this.f299433d, longExtra);
        } else {
            c(this.f299433d, longExtra);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("KEY_REQ_DATA");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3179);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(byteArrayExtra));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        packet.setSSOCommand("OidbSvc.0xc6b");
        packet.putSendData(bArr);
    }
}
