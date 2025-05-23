package com.tencent.mobileqq.service.report;

import CliLogSvc.strupbuff;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f286413d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f286413d = new String[]{"CliLogSvc"};
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String str;
        uniPacket.setServantName("QQService.CliLogSvc.MainServantObj");
        uniPacket.setFuncName("UploadReq");
        String[] stringArray = toServiceMsg.extraData.getStringArray("data");
        strupbuff strupbuffVar = new strupbuff();
        HashMap hashMap = new HashMap();
        ArrayList<byte[]> arrayList = new ArrayList<>();
        for (String str2 : stringArray) {
            arrayList.add(str2.getBytes());
        }
        if (toServiceMsg.extraData.containsKey("log_key")) {
            str = toServiceMsg.extraData.getString("log_key");
        } else {
            str = "PLUG_PB";
        }
        hashMap.put(str, arrayList);
        strupbuffVar.setLogstring(hashMap);
        uniPacket.put("Data", strupbuffVar);
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f286413d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (BaseConstants.CMD_REPORTSTAT.equals(toServiceMsg.getServiceCmd())) {
            return a(toServiceMsg, uniPacket);
        }
        return false;
    }
}
