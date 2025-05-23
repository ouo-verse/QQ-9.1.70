package com.tencent.mobileqq.statistics;

import com.tencent.beacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.immediate.BeaconTransferResult;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BeaconRealTimeReportHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f289893e;

    /* renamed from: d, reason: collision with root package name */
    final ConcurrentHashMap<Integer, BeaconImmediateReportCallback> f289894d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f289893e = BeaconRealTimeReportHandler.class.getName();
        }
    }

    protected BeaconRealTimeReportHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f289894d = new ConcurrentHashMap<>();
        }
    }

    static int E2(int i3) {
        if (i3 == 1000) {
            return 0;
        }
        return i3;
    }

    public void D2(BeaconTransferArgs beaconTransferArgs, BeaconImmediateReportCallback beaconImmediateReportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) beaconTransferArgs, (Object) beaconImmediateReportCallback);
            return;
        }
        if (beaconTransferArgs == null) {
            QLog.e("BeaconRealTimeReport.Handler", 1, "[sendReport] error: ", new Throwable("beaconArgs is null"));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(beaconTransferArgs.getCommand());
        int c16 = ds.c();
        createToServiceMsg.addAttribute("attr_beacon_session_id", Integer.valueOf(c16));
        createToServiceMsg.putWupBuffer(beaconTransferArgs.getData());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
        if (beaconImmediateReportCallback != null) {
            this.f289894d.put(Integer.valueOf(c16), beaconImmediateReportCallback);
        }
        QLog.d("BeaconRealTimeReport.Handler", 1, "[sendReport] send a real-time report. session: ", Integer.valueOf(c16), ". msg: ", createToServiceMsg);
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
            hashSet.add("trpc.Beacon.BeaconLogServerLC.blslongconnection.SsoProcess");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
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
        Object attribute = toServiceMsg.getAttribute("attr_beacon_session_id");
        if (attribute instanceof Integer) {
            BeaconTransferResult beaconTransferResult = new BeaconTransferResult();
            int E2 = E2(fromServiceMsg.getResultCode());
            beaconTransferResult.setCode(E2);
            beaconTransferResult.setBizCode(E2);
            beaconTransferResult.setBizMsg(fromServiceMsg.getBusinessFailMsg());
            beaconTransferResult.setBizBuffer(fromServiceMsg.getWupBuffer());
            int intValue = ((Integer) attribute).intValue();
            BeaconImmediateReportCallback beaconImmediateReportCallback = this.f289894d.get(Integer.valueOf(intValue));
            this.f289894d.remove(Integer.valueOf(intValue));
            if (beaconImmediateReportCallback != null) {
                beaconImmediateReportCallback.onResponse(beaconTransferResult);
            }
            QLog.d("BeaconRealTimeReport.Handler", 1, "[onReceive] receive a real-time response. cb: ", beaconImmediateReportCallback, ". msg: ", fromServiceMsg);
            return;
        }
        QLog.e("BeaconRealTimeReport.Handler", 1, "[onReceive] error: session id is null.", new Throwable("SessionId is null"));
    }
}
