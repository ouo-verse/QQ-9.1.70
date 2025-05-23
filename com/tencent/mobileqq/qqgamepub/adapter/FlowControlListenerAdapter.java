package com.tencent.mobileqq.qqgamepub.adapter;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService;
import com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl$ResourcePermitRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class FlowControlListenerAdapter implements WadlTrpcListener {
    static IPatchRedirector $redirector_;

    public FlowControlListenerAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }

    public abstract void b(String str, String str2, int i3, long j3);

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashSet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new HashSet<String>() { // from class: com.tencent.mobileqq.qqgamepub.adapter.FlowControlListenerAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlowControlListenerAdapter.this);
                } else {
                    add("/v1/63");
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        String str2;
        String str3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, str, Long.valueOf(j3), trpcInovkeRsp);
            return;
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.RES_URL);
        String stringExtra2 = intent.getStringExtra("appName");
        long j16 = 0;
        if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
            try {
                QQGameResFlowControl$ResourcePermitRsp qQGameResFlowControl$ResourcePermitRsp = new QQGameResFlowControl$ResourcePermitRsp();
                qQGameResFlowControl$ResourcePermitRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                int i17 = qQGameResFlowControl$ResourcePermitRsp.res_state.get();
                try {
                    long j17 = qQGameResFlowControl$ResourcePermitRsp.internal_time.get();
                    try {
                        i3 = i17;
                        try {
                            ((IQQGameFlowControlService) QRoute.api(IQQGameFlowControlService.class)).saveFlowControlConfig(stringExtra, i17, j17 + NetConnInfoCenter.getServerTime());
                            str2 = stringExtra;
                            str3 = "QQGamePub_FlowControlListenerAdapter";
                            try {
                                b(stringExtra, stringExtra2, i3, j17);
                                j16 = j17;
                            } catch (Exception e16) {
                                e = e16;
                                j16 = j17;
                                a(-1L);
                                if (QLog.isColorLevel()) {
                                }
                                i16 = i3;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str2 = stringExtra;
                            str3 = "QQGamePub_FlowControlListenerAdapter";
                            j16 = j17;
                            a(-1L);
                            if (QLog.isColorLevel()) {
                                QLog.e(str3, 2, e, new Object[0]);
                            }
                            i16 = i3;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str2 = stringExtra;
                        i3 = i17;
                    }
                } catch (Exception e19) {
                    e = e19;
                    str2 = stringExtra;
                    i3 = i17;
                    str3 = "QQGamePub_FlowControlListenerAdapter";
                }
            } catch (Exception e26) {
                e = e26;
                str2 = stringExtra;
                str3 = "QQGamePub_FlowControlListenerAdapter";
                i3 = 0;
            }
            i16 = i3;
        } else {
            str2 = stringExtra;
            str3 = "QQGamePub_FlowControlListenerAdapter";
            a(j3);
        }
        if (QLog.isColorLevel()) {
            QLog.i(str3, 2, "onTrpcRs,:request:" + intent + ",cmd:" + str + ",ret:" + j3 + ",rsp resState:" + i16 + ",rsp internalTime:" + j16 + ",url:" + str2);
        }
    }
}
