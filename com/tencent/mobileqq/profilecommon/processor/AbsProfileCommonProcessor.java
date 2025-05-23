package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* loaded from: classes16.dex */
public abstract class AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;
    protected AppRuntime appRuntime;
    protected ProfileCommonHandler handler;

    public AbsProfileCommonProcessor(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
            this.handler = getProfileCommonHandler(appRuntime);
        }
    }

    private ProfileCommonHandler getProfileCommonHandler(AppRuntime appRuntime) {
        return (ProfileCommonHandler) ((AppInterface) appRuntime).getBusinessHandler(((IProfileHandlerApi) QRoute.api(IProfileHandlerApi.class)).getProfileCommonHandler());
    }

    private void sendPbReq(ToServiceMsg toServiceMsg) {
        toServiceMsg.extraData.putString("processor_key", getProcessorKey());
        this.handler.sendPbReq(toServiceMsg);
    }

    public abstract String getProcessorKey();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getProfileDetail(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            getProfileDetail(oidb_0x5eb_reqbody, 22, bundle);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x5eb_reqbody, (Object) bundle);
        }
    }

    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        return false;
    }

    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
        }
    }

    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) byteStringMicro);
        }
    }

    public void onProcessProfileModifyPushBegin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }
    }

    public void onProcessProfileModifyPushEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void onSetProfileDetailResponse(Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bundle, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setProfileDetail(oidb_0x587$ReqBody oidb_0x587_reqbody, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setProfileDetail(oidb_0x587_reqbody, 74, bundle);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) oidb_0x587_reqbody, (Object) bundle);
        }
    }

    protected final void getProfileDetail(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, oidb_0x5eb_reqbody, Integer.valueOf(i3), bundle);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        ToServiceMsg makeOIDBPkg = this.handler.makeOIDBPkg("OidbSvc.0x5eb_common", 1515, i3, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putAll(bundle);
        sendPbReq(makeOIDBPkg);
    }

    protected final void setProfileDetail(oidb_0x587$ReqBody oidb_0x587_reqbody, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, oidb_0x587_reqbody, Integer.valueOf(i3), bundle);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        ToServiceMsg makeOIDBPkg = this.handler.makeOIDBPkg("OidbSvc.0x587_common", 1415, i3, oidb_0x587_reqbody.toByteArray());
        makeOIDBPkg.extraData.putAll(bundle);
        sendPbReq(makeOIDBPkg);
    }
}
