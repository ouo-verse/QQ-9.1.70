package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cr implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f195465d;

    public cr(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f195465d = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ReqItem) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        QLog.i("ReqDpcInfoNewItem", 1, "getCheckUpdateItemData");
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 117;
        reqItem.cOperType = (byte) 1;
        byte[] byteArray = ((IDPCApi) QRoute.api(IDPCApi.class)).buidldReqConfig(this.f195465d).toByteArray();
        byte[] bArr = new byte[byteArray.length + 4];
        PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
        PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
        reqItem.vecParam = bArr;
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) respItem);
            return;
        }
        boolean z16 = true;
        QLog.i("ReqDpcInfoNewItem", 1, "handleCheckUpdateItemData" + ((int) respItem.cResult));
        if (respItem.eServiceID == 117) {
            boolean z17 = false;
            if (respItem.cResult == 2) {
                byte[] a16 = fh.a(respItem.vecUpdate);
                if (a16 != null) {
                    ConfigurationService$RespGetConfig configurationService$RespGetConfig = new ConfigurationService$RespGetConfig();
                    try {
                        configurationService$RespGetConfig.mergeFrom(a16);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ReqDpcInfoNewItem", 2, "error: " + e16.getMessage());
                        }
                        e16.printStackTrace();
                        configurationService$RespGetConfig = null;
                    }
                    if (configurationService$RespGetConfig != null && configurationService$RespGetConfig.result.get() == 0) {
                        PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField = configurationService$RespGetConfig.config_list;
                        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                            ((IDPCApi) QRoute.api(IDPCApi.class)).onDPCResponse(configurationService$RespGetConfig, this.f195465d.getCurrentAccountUin());
                            z17 = z16;
                        } else {
                            QLog.i("ReqDpcInfoNewItem", 1, "respGetConfig has no contentlist");
                        }
                    }
                }
                z16 = false;
                z17 = z16;
            } else {
                QLog.i("ReqDpcInfoNewItem", 1, "error happend item.cResult = " + ((int) respItem.cResult));
            }
            if (!z17) {
                ((IDPCApi) QRoute.api(IDPCApi.class)).nextServerDataState(4);
            }
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }
}
