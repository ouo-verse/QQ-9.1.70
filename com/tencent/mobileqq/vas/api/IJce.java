package com.tencent.mobileqq.vas.api;

import QC.LoginInfo;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.manager.TicketManager;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IJce extends IVasManager, Serializable {
    public static final int TYPE_REQ = 1;
    public static final int TYPE_STREQ = 2;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Util {
        public static LoginInfo getLoginInfo() {
            try {
                AppInterface appInterface = VasUtil.getAppInterface();
                if (appInterface == null) {
                    return null;
                }
                String currentAccountUin = appInterface.getCurrentAccountUin();
                TicketManager ticketManager = (TicketManager) appInterface.getManager(2);
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.lUin = Long.parseLong(currentAccountUin);
                loginInfo.iKeyType = 1;
                loginInfo.sSKey = VasSkey.getSkey(ticketManager, currentAccountUin);
                loginInfo.iOpplat = 2;
                loginInfo.sClientVer = ah.P();
                return loginInfo;
            } catch (Exception e16) {
                QLog.e("IJce", 1, e16, new Object[0]);
                return null;
            }
        }

        public static String reqSeq(ToServiceMsg toServiceMsg) {
            return toServiceMsg.getServiceCmd() + "_" + toServiceMsg.extraData.get(BaseBusinessHandler.SEQ_KEY);
        }
    }

    IJce build(String str, String str2);

    IJce build(String str, String str2, int i3);

    IJce build(String str, String str2, String str3, String str4);

    Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, UniPacket uniPacket);

    void encode(ToServiceMsg toServiceMsg, UniPacket uniPacket, int i3);

    String getCmd();

    void request(String str, JceStruct jceStruct, JceStruct jceStruct2, BusinessObserver businessObserver, boolean z16);
}
