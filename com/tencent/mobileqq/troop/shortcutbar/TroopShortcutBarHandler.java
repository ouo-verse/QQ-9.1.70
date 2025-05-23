package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e$ReqBody;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e$RspBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82$App;
import tencent.im.oidb.cmd0xe82.cmd0xe82$ClientInfo;
import tencent.im.oidb.cmd0xe82.cmd0xe82$ReqBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShortcutBarHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public AtomicLong f298591d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Long, com.tencent.mobileqq.troop.shortcutbar.importantmsg.e> f298592e;

    /* renamed from: f, reason: collision with root package name */
    private TroopShortcutBarManager f298593f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f298594h;

    public TroopShortcutBarHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f298591d = new AtomicLong(0L);
        this.f298592e = new ConcurrentHashMap<>();
        this.f298594h = qQAppInterface;
        this.f298593f = (TroopShortcutBarManager) qQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    }

    private boolean D2(long j3) {
        TroopShortcutBarInfo m3 = this.f298593f.m(Long.valueOf(j3));
        if (m3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopShortcutBarHandler", 2, "checkPullRedPoint return true", " info is null");
            }
            return true;
        }
        if (m3.getAppList().size() <= 0 || System.currentTimeMillis() <= m3.getNextFetchRedPointTsMil()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarHandler", 2, "checkPullRedPoint return true");
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        int i3;
        int i16;
        boolean z16;
        long j16;
        boolean z17;
        cmd0xe82$RspBody cmd0xe82_rspbody = new cmd0xe82$RspBody();
        long longValue = ((Long) toServiceMsg.getAttribute("troopcode", 0L)).longValue();
        int intValue = ((Integer) toServiceMsg.getAttribute(RedTouchWebviewHandler.PLUGIN_NAMESPACE, 0)).intValue();
        Object attribute = toServiceMsg.getAttribute("extData", null);
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xe82_rspbody);
        if (parseOIDBPkg == 0) {
            int i17 = cmd0xe82_rspbody.cache_ts.get();
            int i18 = cmd0xe82_rspbody.disabled.get();
            int i19 = cmd0xe82_rspbody.group_disabled.get();
            int i26 = cmd0xe82_rspbody.redpoint_cache_ts.get();
            long j17 = cmd0xe82_rspbody.switch_ts.get();
            if (QLog.isColorLevel()) {
                QLog.d("TroopShortcutBarHandler", 2, "handleGetTroopAIOShortcutBar group_disabled: " + i19 + ", disabled\uff1a" + i18 + ", troopcode:" + longValue);
            }
            ArrayList arrayList = new ArrayList();
            if (cmd0xe82_rspbody.app.has()) {
                Iterator<cmd0xe82$App> it = cmd0xe82_rspbody.app.get().iterator();
                while (it.hasNext()) {
                    arrayList.add(TroopShortcutBarApp.convertPbToShortcutBarApp(it.next()));
                }
            }
            TroopInfo k3 = ((TroopManager) this.f298594h.getManager(QQManagerFactory.TROOP_MANAGER)).k(String.valueOf(longValue));
            if (k3 != null) {
                j16 = k3.dwGroupClassExt;
            } else {
                j16 = 0;
            }
            i3 = 1;
            TroopShortcutBarInfo troopShortcutBarInfo = new TroopShortcutBarInfo(longValue, i17, i18, i19, i26, j17, j16, arrayList);
            TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) this.f298594h.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
            Long valueOf = Long.valueOf(longValue);
            if (intValue == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            troopShortcutBarManager.c(valueOf, troopShortcutBarInfo, z17, attribute);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                if (!troopShortcutBarInfo.getAppList().isEmpty()) {
                    for (int i27 = 0; i27 < troopShortcutBarInfo.getAppList().size() - 1; i27++) {
                        sb5.append(troopShortcutBarInfo.getAppList().get(i27).getAppId());
                        sb5.append("|");
                    }
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("TroopShortcutBarHandler handleGetTroopAIOShortcutBar appList:");
                sb6.append((Object) sb5);
                sb6.append(", troopCode: ");
                j3 = longValue;
                sb6.append(j3);
                QLog.i("TroopShortcutBarHandler", 2, sb6.toString());
            } else {
                j3 = longValue;
            }
            i16 = parseOIDBPkg;
        } else {
            j3 = longValue;
            i3 = 1;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("handleGetTroopAIOShortcutBar failure: result:");
            i16 = parseOIDBPkg;
            sb7.append(i16);
            QLog.e("TroopShortcutBarHandler", 1, sb7.toString());
        }
        if (i16 == 0) {
            z16 = i3;
        } else {
            z16 = 0;
        }
        Object[] objArr = new Object[i3];
        objArr[0] = Long.valueOf(j3);
        notifyUI(i3, z16, objArr);
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        MessageMicro<Oidb_0xe0e$RspBody> messageMicro = new MessageMicro<Oidb_0xe0e$RspBody>() { // from class: tencent.im.oidb.cmd0xe0e.Oidb_0xe0e$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb_0xe0e$RspBody.class);
        };
        long longValue = ((Long) toServiceMsg.getAttribute("troopcode", 0L)).longValue();
        int intValue = ((Integer) toServiceMsg.getAttribute("disabled", 0)).intValue();
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("bisadmin", Boolean.FALSE)).booleanValue();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, messageMicro);
        fromServiceMsg.getBusinessFailMsg();
        ITroopShortcutApi iTroopShortcutApi = (ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class);
        if (intValue == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        iTroopShortcutApi.setDisableCapsule(longValue, z16);
        if (booleanValue) {
            ITroopShortcutApi iTroopShortcutApi2 = (ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class);
            if (intValue == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            iTroopShortcutApi2.setDisableCapsuleSwitch(longValue, z18);
        }
        if (parseOIDBPkg == 0) {
            ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).notifyDataExpired(Long.valueOf(longValue));
            ((TroopShortcutBarManager) this.f298594h.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).A(longValue, intValue, booleanValue);
            if (QLog.isColorLevel()) {
                QLog.i("TroopShortcutBarHandler", 2, "handleSetTotalSwitch troopCode: " + longValue + ", disabled\uff1a" + intValue + ", bIsAdmin:" + booleanValue);
            }
        } else {
            QLog.e("TroopShortcutBarHandler", 1, "handleSetTotalSwitch failure: result:" + parseOIDBPkg);
        }
        if (parseOIDBPkg == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        notifyUI(2, z17, new Object[]{Long.valueOf(longValue), Integer.valueOf(intValue)});
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3 = toServiceMsg.extraData.getLong("sendSeq", 0L);
        if (this.f298592e.containsKey(Long.valueOf(j3)) && this.f298592e.get(Long.valueOf(j3)).c(fromServiceMsg, obj)) {
            this.f298592e.remove(Long.valueOf(j3));
        }
    }

    public void E2(long j3, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopShortcutBarHandler", 2, "TroopShortcutBarHandler getTroopAIOShortCutBar troopCode:" + j3 + ",troopType: " + i3);
        }
        cmd0xe82$ReqBody cmd0xe82_reqbody = new cmd0xe82$ReqBody();
        cmd0xe82_reqbody.group_id.set(j3);
        cmd0xe82_reqbody.group_type.set(i3);
        if (StudyModeManager.t()) {
            cmd0xe82_reqbody.mode.set(1);
        }
        if (D2(j3)) {
            cmd0xe82_reqbody.redpoint.set(1);
        }
        cmd0xe82$ClientInfo cmd0xe82_clientinfo = new cmd0xe82$ClientInfo();
        cmd0xe82_clientinfo.platform.set(2);
        cmd0xe82_clientinfo.version.set(AppSetting.f99551k);
        cmd0xe82_reqbody.client.set(cmd0xe82_clientinfo);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe82", 3714, 1, cmd0xe82_reqbody.toByteArray(), 30000L);
        makeOIDBPkg.addAttribute("troopcode", Long.valueOf(j3));
        makeOIDBPkg.addAttribute("trooptype", Integer.valueOf(i3));
        makeOIDBPkg.addAttribute("extData", obj);
        if (StudyModeManager.t()) {
            makeOIDBPkg.addAttribute("mode", 1);
        }
        if (cmd0xe82_reqbody.redpoint.has() && cmd0xe82_reqbody.redpoint.get() == 1) {
            makeOIDBPkg.addAttribute(RedTouchWebviewHandler.PLUGIN_NAMESPACE, 1);
        }
        sendPbReq(makeOIDBPkg);
    }

    public void I2(long j3, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopShortcutBarHandler", 2, "setTotalSwitch troopCode: " + j3 + "disabled\uff1a" + i3 + ", bIsAdmin:" + z16);
        }
        Oidb_0xe0e$ReqBody oidb_0xe0e$ReqBody = new Oidb_0xe0e$ReqBody();
        oidb_0xe0e$ReqBody.group_id.set(j3);
        oidb_0xe0e$ReqBody.disabled.set(i3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe0e", 3598, 1, oidb_0xe0e$ReqBody.toByteArray(), 30000L);
        makeOIDBPkg.addAttribute("troopcode", Long.valueOf(j3));
        makeOIDBPkg.addAttribute("disabled", Integer.valueOf(i3));
        makeOIDBPkg.addAttribute("bisadmin", Boolean.valueOf(z16));
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopShortcutBarHandler", 2, "TroopShortcutBarHandler onReceive resultCode:" + fromServiceMsg.getResultCode() + ", errMsg: " + fromServiceMsg.getBusinessFailMsg() + ", serviceCmd: " + toServiceMsg.getServiceCmd());
            }
            String serviceCmd = toServiceMsg.getServiceCmd();
            try {
                int i3 = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj).uint32_result.get();
                if (i3 != 0 && QLog.isColorLevel()) {
                    QLog.i("TroopShortcutBarHandler", 2, "TroopShortcutBarHandler onReceive return Error result:" + i3 + "cmd\uff1a" + toServiceMsg.getServiceCmd());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopShortcutBarHandler", 2, "TroopShortcutBarHandler onReceive exception: " + e16.getMessage() + "cmd\uff1a" + toServiceMsg.getServiceCmd());
                }
            }
            if ("OidbSvc.0xe82".equals(serviceCmd)) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0xe0e".equals(serviceCmd)) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvcTcp.0xea3".equals(serviceCmd)) {
                    H2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.i("TroopShortcutBarHandler", 2, "TroopShortcutBarHandler onReceive res == null || req == null");
    }
}
