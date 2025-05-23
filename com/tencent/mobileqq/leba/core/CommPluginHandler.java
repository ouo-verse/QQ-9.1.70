package com.tencent.mobileqq.leba.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.data.LebaUnitedConfigHelper;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.leba.pb.PluginConfig$BatchGetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig$BatchGetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig$GetResourceResp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

/* loaded from: classes15.dex */
public class CommPluginHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f240346d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f240347e;

    public CommPluginHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f240346d = false;
            this.f240347e = appInterface;
        }
    }

    protected void D2(PluginConfig$GetResourceReq pluginConfig$GetResourceReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) pluginConfig$GetResourceReq);
            return;
        }
        QLog.i("Leba.CommPluginHandler", 1, "batchGetPluginList");
        if (pluginConfig$GetResourceReq == null) {
            QLog.i("Leba.CommPluginHandler", 1, "batchGetPluginList return for getResourceReq is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(pluginConfig$GetResourceReq);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f240347e.getCurrentAccountUin(), "PluginConfig.dynamic_plugin");
        PluginConfig$BatchGetResourceReq pluginConfig$BatchGetResourceReq = new PluginConfig$BatchGetResourceReq();
        pluginConfig$BatchGetResourceReq.req_list.set(arrayList);
        toServiceMsg.putWupBuffer(pluginConfig$BatchGetResourceReq.toByteArray());
        toServiceMsg.extraData.putString("uin", this.f240347e.getCurrentAccountUin());
        toServiceMsg.extraData.putInt("mode", pluginConfig$GetResourceReq.mode.get());
        toServiceMsg.extraData.putInt("style", pluginConfig$GetResourceReq.style.get());
        sendPbReq(toServiceMsg);
    }

    public void E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!LebaUnitedConfigHelper.c()) {
            return;
        }
        LebaHelper G2 = G2(this.f240347e, "getAllPluginList");
        if (G2 == null) {
            QLog.e("Leba.CommPluginHandler", 1, "getAllPluginList lebaHelper is null");
            return;
        }
        LebaHelper.a d16 = LebaHelper.d();
        if (d16.f240358a) {
            D2(G2.l(d16.f240359b, d16.f240360c));
        } else {
            D2(G2.k());
        }
    }

    public void F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!LebaUnitedConfigHelper.c()) {
            return;
        }
        int i3 = 2;
        QLog.i("Leba.CommPluginHandler", 2, "getAnotherStyleAllPluginList: start", new RuntimeException("getAllPluginList: another: "));
        LebaHelper.a d16 = LebaHelper.d();
        if (!d16.f240358a) {
            QLog.e("Leba.CommPluginHandler", 1, "getAnotherStyleAllPluginList not enable");
            return;
        }
        if (d16.f240360c != 1) {
            i3 = 1;
        }
        int m3 = f.m(this.f240347e, d16.f240359b, i3);
        if (m3 > 0) {
            QLog.i("Leba.CommPluginHandler", 1, "getAnotherStyleAllPluginList: lebaGroupSeq= " + m3);
            return;
        }
        LebaHelper G2 = G2(this.f240347e, "getAllPluginListWhenLocalDataEmpty");
        if (G2 == null) {
            QLog.e("Leba.CommPluginHandler", 1, "getAnotherStyleAllPluginList lebaHelper is null");
            return;
        }
        PluginConfig$GetResourceReq l3 = G2.l(d16.f240359b, i3);
        if (l3 == null) {
            QLog.e("Leba.CommPluginHandler", 1, "getAnotherStyleAllPluginList getResourceReq is null");
        } else {
            D2(l3);
        }
    }

    public LebaHelper G2(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LebaHelper) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface, (Object) str);
        }
        if (appInterface == null) {
            QLog.e("Leba.CommPluginHandler", 1, "getLebaHelper isEmpty appInterface = null");
            return null;
        }
        Object lebaHelper = ((ILebaHelperService) appInterface.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
        if (lebaHelper == null) {
            QLog.e("Leba.CommPluginHandler", 1, "getLebaHelper isEmpty method = " + str);
            return null;
        }
        return (LebaHelper) lebaHelper;
    }

    public void H2(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            LebaPluginLogic.h(appRuntime);
        }
    }

    protected void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        List<PluginConfig$GetResourceResp> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Leba.CommPluginHandler", 2, "handleBatchGetPluginList");
        }
        LebaHelper G2 = G2(this.f240347e, "handleBatchGetPluginList");
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = toServiceMsg.extraData.getInt("mode", 0);
        int i16 = toServiceMsg.extraData.getInt("style", 0);
        String str = "";
        int i17 = -1;
        if (z16) {
            try {
                PluginConfig$BatchGetResourceResp mergeFrom = new PluginConfig$BatchGetResourceResp().mergeFrom((byte[]) obj);
                if (mergeFrom.errcode.has()) {
                    i17 = mergeFrom.errcode.get();
                }
                if (i17 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (mergeFrom.errmsg.has()) {
                    str = mergeFrom.errmsg.get();
                }
                if (z17) {
                    if (mergeFrom.resp_list.has()) {
                        list = mergeFrom.resp_list.get();
                    } else {
                        list = null;
                    }
                    if (list != null && !list.isEmpty()) {
                        for (PluginConfig$GetResourceResp pluginConfig$GetResourceResp : list) {
                            if (pluginConfig$GetResourceResp != null) {
                                if ((pluginConfig$GetResourceResp.plugin_type.get() == 4034 || pluginConfig$GetResourceResp.plugin_type.get() == 4032 || pluginConfig$GetResourceResp.plugin_type.get() == 4033 || pluginConfig$GetResourceResp.plugin_type.get() == 4042) && G2 != null) {
                                    G2.n(true, pluginConfig$GetResourceResp, i3, i16);
                                }
                            }
                        }
                    } else {
                        QLog.d("Leba.CommPluginHandler", 1, "handleBatchGetPluginList respInfoList is null");
                    }
                }
            } catch (Exception e16) {
                QLog.d("Leba.CommPluginHandler", 1, "handleBatchGetPluginList exp:" + e16.toString());
            }
            if (!z17 && z16) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18 && G2 != null) {
                G2.n(false, null, 0, 0);
            }
            QLog.d("Leba.CommPluginHandler", 1, "handleBatchGetPluginList finalResult:", Boolean.valueOf(z18), ",ssoSuc=", Boolean.valueOf(z16), ",busiSuc=", Boolean.valueOf(z17), ",busiErrCode=", Integer.valueOf(i17), ",errMsg=", str);
        }
        z17 = false;
        if (!z17) {
        }
        z18 = false;
        if (!z18) {
            G2.n(false, null, 0, 0);
        }
        QLog.d("Leba.CommPluginHandler", 1, "handleBatchGetPluginList finalResult:", Boolean.valueOf(z18), ",ssoSuc=", Boolean.valueOf(z16), ",busiSuc=", Boolean.valueOf(z17), ",busiErrCode=", Integer.valueOf(i17), ",errMsg=", str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("PluginConfig.dynamic_plugin");
            this.allowCmdSet.add("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList");
            this.allowCmdSet.add("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList");
            this.allowCmdSet.add("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetStyle");
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

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f240346d = true;
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && !msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if ("PluginConfig.dynamic_plugin".equals(serviceCmd)) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList".equals(serviceCmd)) {
                LebaPluginLogic.q(this.f240347e, toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList".equals(serviceCmd)) {
                LebaPluginLogic.t(this.f240347e, toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetStyle".equals(serviceCmd)) {
                    LebaPluginLogic.v(this.f240347e, toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.d("Leba.CommPluginHandler", 1, "req or res is null");
    }
}
