package com.tencent.mobileqq.profilecommon.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.processor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

/* loaded from: classes16.dex */
public class ProfileCommonServiceImpl implements IProfileCommonService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCommonServiceImpl";
    private AppRuntime appRuntime;
    private a processorFactory;

    public ProfileCommonServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ProfileCommonHandler getProfileCommonHandler(AppRuntime appRuntime) {
        return (ProfileCommonHandler) ((AppInterface) appRuntime).getBusinessHandler(((IProfileHandlerApi) QRoute.api(IProfileHandlerApi.class)).getProfileCommonHandler());
    }

    public static ProfileCommonServiceImpl getProfileCommonService(AppRuntime appRuntime) {
        return (ProfileCommonServiceImpl) appRuntime.getRuntimeService(IProfileCommonService.class, "all");
    }

    @Override // com.tencent.mobileqq.profilecommon.api.IProfileCommonService
    public <T extends AbsProfileCommonProcessor> T getProcessor(Class<? extends AbsProfileCommonProcessor> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (T) this.processorFactory.a(cls) : (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
    }

    public a getProcessorFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.processorFactory;
    }

    @Override // com.tencent.mobileqq.profilecommon.api.IProfileCommonService
    public void getProfileDetailForLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
        Iterator<AbsProfileCommonProcessor> it = this.processorFactory.c().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= it.next().onGetProfileDetailRequestForLogin(oidb_0x5eb_reqbody);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getProfileDetailForLogin needRequest=%s", Boolean.valueOf(z16)));
        }
        if (z16) {
            ProfileCommonHandler profileCommonHandler = getProfileCommonHandler(this.appRuntime);
            profileCommonHandler.sendPbReq(profileCommonHandler.makeOIDBPkg("OidbSvc.0x5eb_common", 1515, 22, oidb_0x5eb_reqbody.toByteArray()));
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.api.IProfileCommonService
    public void notifyProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onProcessProfileModifyPush type=%s bytesValue=%s", Integer.valueOf(i3), Arrays.toString(byteStringMicro.toByteArray())));
        }
        Iterator<AbsProfileCommonProcessor> it = this.processorFactory.c().iterator();
        while (it.hasNext()) {
            try {
                it.next().onProcessProfileModifyPush(i3, byteStringMicro);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onProcessProfileModifyPush fail.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.api.IProfileCommonService
    public void notifyProfileModifyPushBegin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onProfileModifyPushBegin uin=%s", Long.valueOf(j3)));
        }
        Iterator<AbsProfileCommonProcessor> it = this.processorFactory.c().iterator();
        while (it.hasNext()) {
            try {
                it.next().onProcessProfileModifyPushBegin(j3);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onProfileModifyPushBegin fail.", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.api.IProfileCommonService
    public void notifyProfileModifyPushEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onProfileModifyPushEnd");
        }
        Iterator<AbsProfileCommonProcessor> it = this.processorFactory.c().iterator();
        while (it.hasNext()) {
            try {
                it.next().onProcessProfileModifyPushEnd();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onProfileModifyPushEnd fail.", e16);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.appRuntime = appRuntime;
            this.processorFactory = new a(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void responseGetProfileDetail(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("responseGetProfileDetail extras=%s success=%s udcUinData=%s", bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata));
        }
        String string = bundle.getString("processor_key");
        if (TextUtils.isEmpty(string)) {
            Iterator<AbsProfileCommonProcessor> it = this.processorFactory.c().iterator();
            while (it.hasNext()) {
                try {
                    it.next().onGetProfileDetailResponse(bundle, z16, oidb_0x5eb_udcuindata);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "responseGetProfileDetail fail.", e16);
                }
            }
            return;
        }
        AbsProfileCommonProcessor processor = getProcessor(string);
        if (processor != null) {
            try {
                processor.onGetProfileDetailResponse(bundle, z16, oidb_0x5eb_udcuindata);
            } catch (Exception e17) {
                QLog.e(TAG, 1, "responseGetProfileDetail fail.", e17);
            }
        }
    }

    public void responseSetProfileDetail(Bundle bundle, boolean z16) {
        AbsProfileCommonProcessor processor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, bundle, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("responseSetProfileDetail extras=%s success=%s", bundle, Boolean.valueOf(z16)));
        }
        String string = bundle.getString("processor_key");
        if (!TextUtils.isEmpty(string) && (processor = getProcessor(string)) != null) {
            try {
                processor.onSetProfileDetailResponse(bundle, z16);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "responseSetProfileDetail fail.", e16);
            }
        }
    }

    public AbsProfileCommonProcessor getProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.processorFactory.b(str) : (AbsProfileCommonProcessor) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
    }
}
