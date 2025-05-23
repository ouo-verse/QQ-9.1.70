package com.tencent.mobileqq.troop.service.api.impl;

import GeneralSettings.ReqGetSettings;
import GeneralSettings.ReqHeader;
import GeneralSettings.ReqSetSettings;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespHeader;
import GeneralSettings.RespSetSettings;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BizTroopServiceApiImpl extends BaseProtocolCoder implements IBizTroopServiceApi {
    static IPatchRedirector $redirector_ = null;
    public static final String WUP_PROFILE_SERVANTNAME = "KQQ.ProfileService.ProfileServantObj";

    public BizTroopServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object decodeGeneralSettings(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RespHeader respHeader = (RespHeader) decodePacket(fromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
        RespGetSettings respGetSettings = (RespGetSettings) decodePacket(fromServiceMsg.getWupBuffer(), "RespGetSettings", new RespGetSettings());
        if (respHeader == null || respHeader.Result != 0) {
            return null;
        }
        return respGetSettings;
    }

    private Object decodeSetGeneralSettings(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        RespHeader respHeader = (RespHeader) decodePacket(fromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
        RespSetSettings respSetSettings = (RespSetSettings) decodePacket(fromServiceMsg.getWupBuffer(), "RespSetSettings", new RespSetSettings());
        if (respHeader == null || respHeader.Result != 0) {
            return null;
        }
        return respSetSettings;
    }

    private boolean handleGetGeneralSettings(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqGetSettings reqGetSettings = new ReqGetSettings(toServiceMsg.extraData.getInt("Revision"), (ArrayList) toServiceMsg.extraData.getSerializable("Paths"), toServiceMsg.extraData.getLong("Offset"), toServiceMsg.extraData.getLong("Count"));
        ReqHeader reqHeader = new ReqHeader(0);
        uniPacket.setServantName(WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("ReqGetSettings");
        uniPacket.put("ReqHeader", reqHeader);
        uniPacket.put("ReqGetSettings", reqGetSettings);
        return true;
    }

    private boolean handleSetGeneralSettings(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqSetSettings reqSetSettings = new ReqSetSettings((ArrayList) toServiceMsg.extraData.getSerializable("Settings"));
        ReqHeader reqHeader = new ReqHeader(0);
        uniPacket.setServantName(WUP_PROFILE_SERVANTNAME);
        uniPacket.setFuncName("ReqSetSettings");
        uniPacket.put("ReqHeader", reqHeader);
        uniPacket.put("ReqSetSettings", reqSetSettings);
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new String[0];
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi
    public Object handleDecode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("ProfileService.ReqGetSettings".equals(serviceCmd)) {
            return decodeGeneralSettings(toServiceMsg, fromServiceMsg);
        }
        if ("ProfileService.ReqSetSettings".equals(serviceCmd)) {
            return decodeSetGeneralSettings(toServiceMsg, fromServiceMsg);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.service.api.IBizTroopServiceApi
    public boolean handleRequest(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if ("ProfileService.ReqGetSettings".equals(serviceCmd)) {
            return handleGetGeneralSettings(toServiceMsg, uniPacket);
        }
        if ("ProfileService.ReqSetSettings".equals(serviceCmd)) {
            return handleSetGeneralSettings(toServiceMsg, uniPacket);
        }
        return false;
    }
}
