package com.tencent.mobileqq.troop.honor.handler;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$HonorList;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$ReqBody;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHonorHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String f297530f;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f297531e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f297530f = ((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopListHandlerName();
        }
    }

    protected TroopHonorHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f297531e = appInterface;
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        List<oidb_0xdc9$HonorList> list;
        long j3;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            oidb_0xdc9$RspBody oidb_0xdc9_rspbody = new oidb_0xdc9$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xdc9_rspbody);
            if (parseOIDBPkg == 0) {
                if (oidb_0xdc9_rspbody.honor_list.has()) {
                    list = oidb_0xdc9_rspbody.honor_list.get();
                } else {
                    list = null;
                }
                if (oidb_0xdc9_rspbody.cache_ts.has()) {
                    j3 = oidb_0xdc9_rspbody.cache_ts.get();
                } else {
                    j3 = 0;
                }
                ((ITroopHonorService) this.f297531e.getRuntimeService(ITroopHonorService.class, "")).updateHostHonorList(list, toServiceMsg.extraData.getBoolean("not_update_honors", false));
                SharedPreferences sharedPreferences = this.f297531e.getApplication().getSharedPreferences(this.f297531e.getCurrentAccountUin(), 0);
                sharedPreferences.edit().putLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", j3).apply();
                sharedPreferences.edit().putLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", NetConnInfoCenter.getServerTime()).apply();
                ((TroopInfoHandler) this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName())).notifyUI(e.TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED, true, null);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonorHandler", 2, String.format("handleGetHostTroopHonorList, result = %s", Integer.valueOf(parseOIDBPkg)));
                return;
            }
            return;
        }
        QLog.d("TroopHonorHandler", 2, "handleGetHostTroopHonorList, data error");
    }

    public void F2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        SharedPreferences sharedPreferences = this.f297531e.getApplication().getSharedPreferences(this.f297531e.getCurrentAccountUin(), 0);
        long j3 = sharedPreferences.getLong("SP_HOST_HONOR_LIST_REQUEST_LIMIT_INTERVAL", 0L);
        long serverTime = NetConnInfoCenter.getServerTime() - sharedPreferences.getLong("SP_HOST_HONOR_LIST_LAST_REQUEST_TIMESTAMP", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonorHandler", 2, String.format("getHostTroopHonorList, requestInterval: %s, limitInterval: %s", Long.valueOf(serverTime), Long.valueOf(j3)));
        }
        if (serverTime < j3 && !z16) {
            QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, requestInterval < limitInterval");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        if (joinedTroopInfoFromCache != null) {
            Iterator<TroopInfo> it = joinedTroopInfoFromCache.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(Long.valueOf(it.next().troopuin));
                } catch (NumberFormatException e16) {
                    QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, convert uin exception", e16);
                }
            }
        }
        if (arrayList.isEmpty()) {
            QLog.d("TroopHonorHandler", 1, "getHostTroopHonorList, troopUinList is empty!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonorHandler", 2, String.format("getHostTroopHonorList, troopUinList size = %s", Integer.valueOf(arrayList.size())));
        }
        oidb_0xdc9$ReqBody oidb_0xdc9_reqbody = new oidb_0xdc9$ReqBody();
        oidb_0xdc9_reqbody.group_id.set(arrayList);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xdc9", 3529, 0, oidb_0xdc9_reqbody.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putBoolean("not_update_honors", z16);
        makeOIDBPkg.extraData.putAll(bundle);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopHonorHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonorHandler", 2, "REQ_TAG doesn't match.");
            }
        } else if ("OidbSvc.0xdc9".equals(fromServiceMsg.getServiceCmd())) {
            G2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
