package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.crmqq.structmsg.StructMsg$GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg$GetCrmQQMenuRequest;
import com.tencent.crmqq.structmsg.StructMsg$RetInfo;
import com.tencent.crmqq.structmsg.StructMsg$SendMenuEventRequest;
import com.tencent.crmqq.structmsg.StructMsg$SendMenuEventResponse;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp$CRMSendLBSInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetUserEqqListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetUserEqqListResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class EnterpriseQQHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final Long f194630e;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194631d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f194630e = 2202087152L;
        }
    }

    EnterpriseQQHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194631d = qQAppInterface;
        }
    }

    private void E2(long j3, long j16, long j17, long j18) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getEqqList: start");
        }
        mobileqq_mp$GetUserEqqListRequest mobileqq_mp_getusereqqlistrequest = new mobileqq_mp$GetUserEqqListRequest();
        mobileqq_mp_getusereqqlistrequest.version.set(1);
        mobileqq_mp_getusereqqlistrequest.begin.set(Utils.O(j3));
        mobileqq_mp_getusereqqlistrequest.limit.set(Utils.O(j16));
        mobileqq_mp_getusereqqlistrequest.seqno.set(Utils.O(j17));
        ToServiceMsg createToServiceMsg = createToServiceMsg("EqqAccountSvc.get_eqq_list");
        createToServiceMsg.putWupBuffer(mobileqq_mp_getusereqqlistrequest.toByteArray());
        createToServiceMsg.extraData.putLong("begin", j3);
        createToServiceMsg.extraData.putLong("limit", j16);
        createToServiceMsg.extraData.putLong("seqno", j17);
        createToServiceMsg.extraData.putLong("time", j18);
        sendPbReq(createToServiceMsg);
    }

    private long G2() {
        return this.f194631d.getApp().getSharedPreferences(this.f194631d.getAccount(), 0).getLong("eqq_data_seq2", 0L);
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): BEGIN");
            if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
                mobileqq_mp$CRMSendLBSInfoResponse mobileqq_mp_crmsendlbsinforesponse = new mobileqq_mp$CRMSendLBSInfoResponse();
                try {
                    mobileqq_mp_crmsendlbsinforesponse.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                if (mobileqq_mp_crmsendlbsinforesponse.ret_info.has() && mobileqq_mp_crmsendlbsinforesponse.ret_info.get().ret_code.has()) {
                    i3 = mobileqq_mp_crmsendlbsinforesponse.ret_info.get().ret_code.get();
                } else {
                    i3 = -1;
                }
                QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): errCode=" + i3);
                return;
            }
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): FAILED");
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        boolean z16;
        long j3;
        if (QLog.isDevelopLevel()) {
            QLog.d("crmtest", 4, "handleGetList, ts=" + System.currentTimeMillis());
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList begin.");
        }
        IPublicAccountObserver.b bVar = new IPublicAccountObserver.b();
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (QLog.isColorLevel()) {
                QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList result=" + resultCode);
            }
            if (resultCode != 1000) {
                bVar.f79353a = -1;
                bVar.f79355c = true;
                return;
            }
            long j16 = toServiceMsg.extraData.getLong("begin");
            toServiceMsg.extraData.getLong("seqno");
            long j17 = toServiceMsg.extraData.getLong("time");
            mobileqq_mp$GetUserEqqListResponse mobileqq_mp_getusereqqlistresponse = new mobileqq_mp$GetUserEqqListResponse();
            boolean z17 = false;
            try {
                mobileqq_mp_getusereqqlistresponse.mergeFrom((byte[]) obj);
                if (mobileqq_mp_getusereqqlistresponse.ret_info.has() && mobileqq_mp_getusereqqlistresponse.ret_info.get().ret_code.has()) {
                    i3 = mobileqq_mp_getusereqqlistresponse.ret_info.get().ret_code.get();
                } else {
                    i3 = 0;
                }
                bVar.f79353a = i3;
                if (i3 != 0) {
                    bVar.f79355c = true;
                } else {
                    if (mobileqq_mp_getusereqqlistresponse.seqno.has()) {
                        i16 = mobileqq_mp_getusereqqlistresponse.seqno.get();
                    } else {
                        i16 = 0;
                    }
                    long P = Utils.P(i16);
                    List<PublicAccountInfo> createPublicAccountInfoListFromEqq = PublicAccountInfo.createPublicAccountInfoListFromEqq(mobileqq_mp_getusereqqlistresponse.accountInfo.get(), j17);
                    bVar.f79356d = createPublicAccountInfoListFromEqq;
                    if (mobileqq_mp_getusereqqlistresponse.is_over.has() && mobileqq_mp_getusereqqlistresponse.is_over.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f79355c = z16;
                    List list = (List) ((IPublicAccountDataManager) this.f194631d.getRuntimeService(IPublicAccountDataManager.class, "all")).saveEqqAccountInfos(createPublicAccountInfoListFromEqq, j17);
                    RecentUserProxy m3 = this.f194631d.getProxyManager().m();
                    Iterator it = list.iterator();
                    boolean z18 = false;
                    while (it.hasNext()) {
                        RecentUser findRecentUser = m3.findRecentUser(((PublicAccountInfo) it.next()).getUin(), 0);
                        if (findRecentUser != null) {
                            m3.delRecentUser(findRecentUser);
                            z18 = true;
                        }
                    }
                    MqqHandler handler = this.f194631d.getHandler(Conversation.class);
                    if (z18 && handler != null) {
                        handler.sendEmptyMessage(1009);
                    }
                    if (!bVar.f79355c) {
                        if (mobileqq_mp_getusereqqlistresponse.next_pos.has()) {
                            j3 = mobileqq_mp_getusereqqlistresponse.next_pos.get();
                        } else {
                            j3 = j16 + 20;
                        }
                        E2(j3, 20L, 0L, j17);
                    } else {
                        M2(P);
                    }
                    z17 = true;
                }
            } catch (Exception e16) {
                bVar.f79353a = -1;
                bVar.f79355c = true;
                e16.printStackTrace();
            }
            notifyUI(100, z17, bVar);
            ((IPublicAccountHandler) this.f194631d.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).notifyUI(100, true, bVar);
            return;
        }
        bVar.f79353a = -1;
        bVar.f79355c = true;
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList error");
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerGetMenu,begin.");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            try {
                int resultCode = fromServiceMsg.getResultCode();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerGetMenu. result=" + resultCode);
                }
                if (resultCode == 1000) {
                    StructMsg$GetCRMMenuResponse structMsg$GetCRMMenuResponse = new StructMsg$GetCRMMenuResponse();
                    try {
                        structMsg$GetCRMMenuResponse.mergeFrom((byte[]) obj);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    int i3 = -1;
                    if (structMsg$GetCRMMenuResponse.ret_info.has()) {
                        StructMsg$RetInfo structMsg$RetInfo = structMsg$GetCRMMenuResponse.ret_info.get();
                        if (structMsg$RetInfo.ret_code.has()) {
                            i3 = structMsg$RetInfo.ret_code.get();
                        }
                        if (i3 != 0 && structMsg$RetInfo.err_info.has()) {
                            structMsg$RetInfo.err_info.get();
                        }
                    }
                    if (i3 == 0) {
                        String valueOf = String.valueOf(structMsg$GetCRMMenuResponse.uin.get());
                        EnterpriseQQManager.j(this.f194631d).n(this.f194631d, valueOf, structMsg$GetCRMMenuResponse.seqno.get(), structMsg$GetCRMMenuResponse);
                        notifyUI(1, true, valueOf);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerSendMenuEvent,begin.");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000) {
                    StructMsg$SendMenuEventResponse structMsg$SendMenuEventResponse = new StructMsg$SendMenuEventResponse();
                    try {
                        structMsg$SendMenuEventResponse.mergeFrom((byte[]) obj);
                    } catch (Exception unused) {
                    }
                    if (structMsg$SendMenuEventResponse.ret_info.has()) {
                        StructMsg$RetInfo structMsg$RetInfo = structMsg$SendMenuEventResponse.ret_info.get();
                        if (structMsg$RetInfo.ret_code.has()) {
                            i3 = structMsg$RetInfo.ret_code.get();
                        } else {
                            i3 = -1;
                        }
                        if (i3 != 0 && structMsg$RetInfo.err_info.has()) {
                            structMsg$RetInfo.err_info.get();
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    private void M2(long j3) {
        SharedPreferences.Editor edit = this.f194631d.getApp().getSharedPreferences(this.f194631d.getAccount(), 0).edit();
        edit.putLong("eqq_data_seq2", j3);
        edit.commit();
    }

    public void D2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("crmtest", 4, "getEqqList, ts=" + System.currentTimeMillis());
        }
        E2(0L, 20L, G2(), j3);
    }

    public void F2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: start");
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            StructMsg$GetCrmQQMenuRequest structMsg$GetCrmQQMenuRequest = new StructMsg$GetCrmQQMenuRequest();
            structMsg$GetCrmQQMenuRequest.seqno.set(0);
            structMsg$GetCrmQQMenuRequest.uin.set(longValue);
            ToServiceMsg createToServiceMsg = createToServiceMsg("mq_crm.get_menu");
            createToServiceMsg.putWupBuffer(structMsg$GetCrmQQMenuRequest.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: arg uin error.");
            }
            e16.printStackTrace();
        }
    }

    public void L2(String str, String str2, int i3, boolean z16, double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: start");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                StructMsg$SendMenuEventRequest structMsg$SendMenuEventRequest = new StructMsg$SendMenuEventRequest();
                structMsg$SendMenuEventRequest.uin.set(longValue);
                structMsg$SendMenuEventRequest.key.set(str2);
                structMsg$SendMenuEventRequest.type.set(i3);
                structMsg$SendMenuEventRequest.is_need_lbs.set(z16);
                if (z16) {
                    structMsg$SendMenuEventRequest.latitude.set(d16);
                    structMsg$SendMenuEventRequest.longitude.set(d17);
                }
                ToServiceMsg createToServiceMsg = createToServiceMsg("mq_crm.send_key");
                createToServiceMsg.putWupBuffer(structMsg$SendMenuEventRequest.toByteArray());
                sendPbReq(createToServiceMsg);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg uin error.");
                }
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg error.");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return y.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if ("mq_crm.get_menu".equalsIgnoreCase(serviceCmd)) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("mq_crm.send_key".equalsIgnoreCase(serviceCmd)) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("EqqAccountSvc.get_eqq_list".equalsIgnoreCase(serviceCmd)) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("CrmSvcEx.ReportLbs".equalsIgnoreCase(serviceCmd)) {
                H2(toServiceMsg, fromServiceMsg, obj);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "cmdfilter error=" + serviceCmd);
            }
        }
    }
}
