package com.tencent.mobileqq.troop.api.access.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.access.ITroopManageAccessHandlerApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import tencent.trpcprotocol.IqunFlameManageSvrPB$GetFlameSwitchReq;
import tencent.trpcprotocol.IqunFlameManageSvrPB$GetFlameSwitchRsp;
import tencent.trpcprotocol.IqunFlameManageSvrPB$SetFlameSwitchReq;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManageAccessHandlerApiImpl implements ITroopManageAccessHandlerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String GET_FLAME_SWITCH_CMD_0X914F = "OidbSvcTrpcTcp.0x914f_0";
    private static final int GET_FLAME_SWITCH_COMMAND = 37199;
    private static final String SET_FLAME_SWITCH_CMD_0X914E = "OidbSvcTrpcTcp.0x914e_0";
    private static final int SET_FLAME_SWITCH_COMMAND = 37198;
    private static final String TAG = "TroopManageAccessHandlerApiImpl";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cs2.a f293942d;

        a(cs2.a aVar) {
            this.f293942d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageAccessHandlerApiImpl.this, (Object) aVar);
            }
        }

        private void b(int i3, String str) {
            QLog.e(TroopManageAccessHandlerApiImpl.TAG, 1, "[getFlameSwitchStatus] errCode = " + i3 + ", errMsg = " + str);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            b(i3, "[onError] " + str);
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                try {
                    this.f293942d.a(new IqunFlameManageSvrPB$GetFlameSwitchRsp().mergeFrom(bArr).switch_value.get());
                    return;
                } catch (Exception e16) {
                    b(-1, "[getFlameSwitchStatus] [onResult], e = " + e16);
                    return;
                }
            }
            b(i3, "[onResult]");
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManageAccessHandlerApiImpl.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            QLog.i(TroopManageAccessHandlerApiImpl.TAG, 1, "[getFlameSwitchStatus] [onError] errCode = " + i3);
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            QLog.i(TroopManageAccessHandlerApiImpl.TAG, 1, "[getFlameSwitchStatus] [onResult] errCode = " + i3);
        }
    }

    public TroopManageAccessHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.access.ITroopManageAccessHandlerApi
    public void getFlameSwitchStatus(long j3, cs2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), aVar);
            return;
        }
        IqunFlameManageSvrPB$GetFlameSwitchReq iqunFlameManageSvrPB$GetFlameSwitchReq = new IqunFlameManageSvrPB$GetFlameSwitchReq();
        iqunFlameManageSvrPB$GetFlameSwitchReq.group_code.set(j3);
        ProtoUtils.a((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), new a(aVar), iqunFlameManageSvrPB$GetFlameSwitchReq.toByteArray(), GET_FLAME_SWITCH_CMD_0X914F, GET_FLAME_SWITCH_COMMAND, 0);
    }

    @Override // com.tencent.mobileqq.troop.api.access.ITroopManageAccessHandlerApi
    public void setFlameSwitch(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        IqunFlameManageSvrPB$SetFlameSwitchReq iqunFlameManageSvrPB$SetFlameSwitchReq = new IqunFlameManageSvrPB$SetFlameSwitchReq();
        iqunFlameManageSvrPB$SetFlameSwitchReq.group_code.set(j3);
        iqunFlameManageSvrPB$SetFlameSwitchReq.switch_value.set(i3);
        ProtoUtils.a((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), new b(), iqunFlameManageSvrPB$SetFlameSwitchReq.toByteArray(), SET_FLAME_SWITCH_CMD_0X914E, SET_FLAME_SWITCH_COMMAND, 0);
    }
}
