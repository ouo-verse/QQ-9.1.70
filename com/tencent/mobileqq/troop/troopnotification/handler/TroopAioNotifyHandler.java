package com.tencent.mobileqq.troop.troopnotification.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nt2.a;
import tencent.im.oidb.oidb_0x928.oidb_0x928$NoticeInfo;
import tencent.im.oidb.oidb_0x928.oidb_0x928$ReqBody;
import tencent.im.oidb.oidb_0x928.oidb_0x928$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNotifyHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    public TroopAioNotifyHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        oidb_0x928$RspBody oidb_0x928_rspbody = new oidb_0x928$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x928_rspbody);
        long j3 = toServiceMsg.extraData.getLong("troopUin");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "<---- handleGetTroopAioNotifyFeeds, troopUin=" + j3 + ", ret=" + parseOIDBPkg);
        }
        if (parseOIDBPkg == 0) {
            try {
                List<oidb_0x928$NoticeInfo> list = oidb_0x928_rspbody.notice_info_list.get();
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    oidb_0x928$NoticeInfo oidb_0x928_noticeinfo = list.get(i3);
                    TroopAIONotifyItem troopAIONotifyItem = new TroopAIONotifyItem();
                    troopAIONotifyItem.f294764id = oidb_0x928_noticeinfo.f436014id.get();
                    troopAIONotifyItem.title = oidb_0x928_noticeinfo.title.get();
                    troopAIONotifyItem.summary = oidb_0x928_noticeinfo.summary.get();
                    troopAIONotifyItem.url = oidb_0x928_noticeinfo.url.get();
                    troopAIONotifyItem.icon = oidb_0x928_noticeinfo.icon.get();
                    troopAIONotifyItem.type = oidb_0x928_noticeinfo.type.get();
                    troopAIONotifyItem.expireTime = oidb_0x928_noticeinfo.show_expire.get();
                    troopAIONotifyItem.hideMode = oidb_0x928_noticeinfo.hide_mode.get();
                    troopAIONotifyItem.troopUin = String.valueOf(j3);
                    troopAIONotifyItem.appId = oidb_0x928_noticeinfo.app_id.get();
                    if (!arrayList.contains(troopAIONotifyItem)) {
                        arrayList.add(troopAIONotifyItem);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "handleGetTroopAioNotifyFeeds, serverList=" + arrayList.size() + " ---->");
                }
                notifyUI(d.f298010e, true, new Object[]{String.valueOf(j3), arrayList});
                return;
            } catch (Exception e16) {
                notifyUI(d.f298010e, false, new Object[]{String.valueOf(j3), new ArrayList()});
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "handleGetTroopAioNotifyFeeds exp:, " + e16.toString() + " ---->");
                    return;
                }
                return;
            }
        }
        notifyUI(d.f298010e, false, new Object[]{String.valueOf(j3), new ArrayList()});
    }

    @Override // nt2.a
    public void b(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            super.notifyUI(i3, z16, obj);
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
            hashSet.add("OidbSvc.0x928");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopNotificationHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if ("OidbSvc.0x928".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // nt2.a
    public void s1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        try {
            String n3 = AppSetting.n();
            oidb_0x928$ReqBody oidb_0x928_reqbody = new oidb_0x928$ReqBody();
            oidb_0x928_reqbody.group_id.set(j3);
            oidb_0x928_reqbody.platform.set(2);
            oidb_0x928_reqbody.version.set(n3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x928", 2344, 0, oidb_0x928_reqbody.toByteArray());
            makeOIDBPkg.extraData.putLong("troopUin", j3);
            sendPbReq(makeOIDBPkg);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "getTroopAioNotifyFeeds, troopUin=" + j3 + ", version=" + n3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_TROOP_NOTIFY_FEEDS_DATA, 2, "getTroopAioNotifyFeeds, exp:", e16);
            }
        }
    }
}
