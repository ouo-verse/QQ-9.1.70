package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.voiceChange.VipVoiceChange$subCmd0x1ReqAuth;
import com.tencent.pb.voiceChange.VipVoiceChange$subCmd0x1RspAuth;
import com.tencent.pb.voiceChange.VipVoiceChange$voiceChangeReq;
import com.tencent.pb.voiceChange.VipVoiceChange$voiceChangeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class VoiceChangeHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195222d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<a> f195223e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3, int i16, Object obj, boolean z16);
    }

    public VoiceChangeHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195222d = qQAppInterface;
        }
    }

    public void D2(int i3, int i16, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), aVar);
            return;
        }
        this.f195223e = new WeakReference<>(aVar);
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("voiceChange.Auth");
        createToServiceMsg.extraData.putInt("callId", i16);
        VipVoiceChange$voiceChangeReq vipVoiceChange$voiceChangeReq = new VipVoiceChange$voiceChangeReq();
        vipVoiceChange$voiceChangeReq.int32_platform.set(109);
        vipVoiceChange$voiceChangeReq.int32_sub_cmd.set(1);
        vipVoiceChange$voiceChangeReq.str_qq_version.set(AppSetting.f99551k);
        VipVoiceChange$subCmd0x1ReqAuth vipVoiceChange$subCmd0x1ReqAuth = new VipVoiceChange$subCmd0x1ReqAuth();
        vipVoiceChange$subCmd0x1ReqAuth.int32_item_id.set(i16);
        vipVoiceChange$voiceChangeReq.msg_subcmd0x1_req_auth.set(vipVoiceChange$subCmd0x1ReqAuth);
        vipVoiceChange$voiceChangeReq.setHasFlag(true);
        createToServiceMsg.putWupBuffer(vipVoiceChange$voiceChangeReq.toByteArray());
        if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeHandler", 2, "sendReqToSVR funcType=" + i3 + ", voiceID:" + i16);
        }
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.voicechange.e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Bundle bundle;
        boolean z16;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!"voiceChange.Auth".equals(fromServiceMsg.getServiceCmd())) {
            return;
        }
        try {
            bundle = new Bundle();
            bundle.putInt("callId", toServiceMsg.extraData.getInt("callId"));
            if (fromServiceMsg.isSuccess() && obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        } catch (Exception e16) {
            QLog.e("VoiceChangeHandler", 1, "onReceive prb.mergeFrom error: " + e16.getMessage());
        }
        if (!z16) {
            QLog.e("VoiceChangeHandler", 1, "onReceive~ isSuccess=false ,data=" + PkgTools.toHexStr((byte[]) obj));
            ReportCenter.f().r("voiceChange.Auth", 100, fromServiceMsg.getBusinessFailCode(), this.appRuntime.getAccount(), 0, HardCodeUtil.qqStr(R.string.vin), true);
            bundle.putInt("result", -1);
            super.notifyUI(1, false, bundle);
            return;
        }
        VipVoiceChange$voiceChangeRsp vipVoiceChange$voiceChangeRsp = new VipVoiceChange$voiceChangeRsp();
        vipVoiceChange$voiceChangeRsp.mergeFrom((byte[]) obj);
        int i3 = vipVoiceChange$voiceChangeRsp.int32_sub_cmd.get();
        VipVoiceChange$subCmd0x1RspAuth vipVoiceChange$subCmd0x1RspAuth = vipVoiceChange$voiceChangeRsp.msg_subcmd0x1_rsp_auth.get();
        int i16 = vipVoiceChange$subCmd0x1RspAuth.int32_ret.get();
        String str = vipVoiceChange$subCmd0x1RspAuth.str_error_msg.get();
        String str2 = vipVoiceChange$subCmd0x1RspAuth.str_active_url.get();
        bundle.putInt("result", i16);
        if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeHandler", 2, "VoiceChangeHandler onReceive~ ret=" + i16 + ",msg=" + str + ", url=" + str2 + ", funcType=" + i3 + ", actStr=" + ((String) null));
        }
        bundle.putString("message", str);
        bundle.putString(VipFunCallConstants.KEY_SV_URL, str2);
        bundle.putString(VipFunCallConstants.KEY_SV_ACTSTR, null);
        WeakReference<a> weakReference = this.f195223e;
        if (weakReference != null && weakReference.get() != null) {
            aVar = this.f195223e.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(i3, i16, bundle, false);
        } else {
            QLog.e("VoiceChangeHandler", 1, "VoiceChangeHandler onReceive~ null == callback ret=" + i16 + ",msg=" + str + ", url=" + str2 + ", funcType=" + i3 + ", actStr=" + ((String) null));
        }
        this.f195223e = null;
    }
}
