package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3$GetQCallUinReq;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3$GetQCallUinRsp;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3$ReqBody;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCallCardHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f261489d;

    /* renamed from: e, reason: collision with root package name */
    private a f261490e;

    /* renamed from: f, reason: collision with root package name */
    protected Set<String> f261491f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(String str);
    }

    public QCallCardHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else {
            this.f261490e = null;
            this.f261489d = qQAppInterface;
        }
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (!fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.i("QCallCardHandler", 2, "handlerGetQcallCard  failed res.isSuccess() == false");
            }
            notifyUI(1, false, null);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("QCallCardHandler", 4, e16.getMessage(), e16);
        } catch (Exception e17) {
            QLog.w("QCallCardHandler", 4, e17.getMessage(), e17);
        }
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.i("QCallCardHandler", 2, "handle oidb_0x5e3_1|OIDBSSOPke.result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_0x5e3$RspBody oidb_0x5e3_rspbody = new oidb_0x5e3$RspBody();
            try {
                oidb_0x5e3_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e18) {
                QLog.w("QCallCardHandler", 4, e18.getMessage(), e18);
            } catch (Exception e19) {
                QLog.w("QCallCardHandler", 4, e19.getMessage(), e19);
            }
            List<Long> list = oidb_0x5e3_rspbody.rpt_uint64_not_exist_qcall_uins.get();
            if (list != null && list.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("QCallCardHandler", 2, "handlerGetQcallCard  is out of date qid:" + g.d(list.get(0).longValue()));
                }
                c cVar = (c) this.f261489d.getManager(QQManagerFactory.QCALLCARD_MANAGER);
                QCallCardInfo c16 = cVar.c(g.d(list.get(0).longValue()));
                if (c16 != null) {
                    c16.in_use_flag = 1;
                    cVar.d(c16);
                    notifyUI(1, true, null);
                } else {
                    QCallCardInfo qCallCardInfo = new QCallCardInfo();
                    qCallCardInfo.uin = g.d(list.get(0).longValue());
                    qCallCardInfo.in_use_flag = 1;
                    cVar.d(qCallCardInfo);
                    notifyUI(1, true, null);
                }
            }
            List<oidb_0x5e3$GetQCallUinRsp> list2 = oidb_0x5e3_rspbody.rpt_msg_get_qcall_uin_rsps.get();
            ArrayList arrayList = new ArrayList();
            for (oidb_0x5e3$GetQCallUinRsp oidb_0x5e3_getqcalluinrsp : list2) {
                QCallCardInfo qCallCardInfo2 = new QCallCardInfo();
                qCallCardInfo2.uin = g.d(oidb_0x5e3_getqcalluinrsp.uint64_uin.get());
                qCallCardInfo2.nickname = oidb_0x5e3_getqcalluinrsp.bytes_nick.get().toStringUtf8();
                qCallCardInfo2.gender = oidb_0x5e3_getqcalluinrsp.uint32_gender.get();
                qCallCardInfo2.birthday = oidb_0x5e3_getqcalluinrsp.uint32_birthday.get();
                qCallCardInfo2.remark = oidb_0x5e3_getqcalluinrsp.bytes_remark.get().toStringUtf8();
                qCallCardInfo2.netstatus = oidb_0x5e3_getqcalluinrsp.uint32_netstatus.get();
                qCallCardInfo2.f261492qq = g.f(oidb_0x5e3_getqcalluinrsp.uint32_qq.get());
                qCallCardInfo2.phonenum = oidb_0x5e3_getqcalluinrsp.bytes_new_gsm.get().toStringUtf8();
                qCallCardInfo2.phone_mask = oidb_0x5e3_getqcalluinrsp.uint32_mask_gsm.get();
                qCallCardInfo2.freeStatus = oidb_0x5e3_getqcalluinrsp.uint32_is_call_free.get();
                qCallCardInfo2.pstn_freeStatus = oidb_0x5e3_getqcalluinrsp.uint32_pstn.get();
                qCallCardInfo2.autoRemark = oidb_0x5e3_getqcalluinrsp.bytes_qq_auto_remark.get().toStringUtf8();
                qCallCardInfo2.qqUin2 = g.d(oidb_0x5e3_getqcalluinrsp.uint64_contact_qq.get());
                if (oidb_0x5e3_getqcalluinrsp.uint32_is_ever_pstn.has()) {
                    qCallCardInfo2.is_ever_pstn = oidb_0x5e3_getqcalluinrsp.uint32_is_ever_pstn.get();
                }
                if (oidb_0x5e3_getqcalluinrsp.uint32_vip_all_free_time.has()) {
                    qCallCardInfo2.vip_all_free_time = oidb_0x5e3_getqcalluinrsp.uint32_vip_all_free_time.get();
                }
                if (oidb_0x5e3_getqcalluinrsp.uint32_profile_card_type.has()) {
                    qCallCardInfo2.card_type = oidb_0x5e3_getqcalluinrsp.uint32_profile_card_type.get();
                }
                if (oidb_0x5e3_getqcalluinrsp.uint32_bind_qq_netstatus.has()) {
                    qCallCardInfo2.qid_qq_status = oidb_0x5e3_getqcalluinrsp.uint32_bind_qq_netstatus.get();
                }
                if (oidb_0x5e3_getqcalluinrsp.uint32_contact_qq_netstatus.has()) {
                    qCallCardInfo2.contact_qq_status = oidb_0x5e3_getqcalluinrsp.uint32_contact_qq_netstatus.get();
                }
                qCallCardInfo2.vip_left_free_time = oidb_0x5e3_getqcalluinrsp.uint32_vip_left_free_time.get();
                qCallCardInfo2.normal_all_free_time = oidb_0x5e3_getqcalluinrsp.uint32_normal_all_free_time.get();
                qCallCardInfo2.normal_left_free_time = oidb_0x5e3_getqcalluinrsp.uint32_normal_left_free_time.get();
                qCallCardInfo2.used_free_time = oidb_0x5e3_getqcalluinrsp.uint32_used_free_time.get();
                qCallCardInfo2.identity = oidb_0x5e3_getqcalluinrsp.uint32_identity.get();
                qCallCardInfo2.isPopup = oidb_0x5e3_getqcalluinrsp.uint32_if_pop_up.get();
                arrayList.add(qCallCardInfo2);
            }
            if (arrayList.size() == 0) {
                QLog.i("QCallCardHandler", 1, "handlerGetQcallCard  failed cardQCalls.size() == 0");
                notifyUI(1, false, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QCallCardHandler", 2, "handlerGetQcallCard  success");
            }
            ((c) this.f261489d.getManager(QQManagerFactory.QCALLCARD_MANAGER)).d((QCallCardInfo) arrayList.get(0));
            notifyUI(1, true, Integer.valueOf(i3));
            a aVar = this.f261490e;
            if (aVar != null) {
                aVar.a(((QCallCardInfo) arrayList.get(0)).nickname);
                return;
            }
            return;
        }
        QLog.i("QCallCardHandler", 1, "failed  result=" + i3);
        notifyUI(1, false, Integer.valueOf(i3));
    }

    public void D2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallCardHandler", 2, "getQcallCardSimpleInfo uin: " + str);
        }
        if (!StringUtil.isValideUin(str)) {
            QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin is unValid!!!");
            return;
        }
        try {
            long e16 = g.e(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(e16));
            oidb_0x5e3$GetQCallUinReq oidb_0x5e3_getqcalluinreq = new oidb_0x5e3$GetQCallUinReq();
            oidb_0x5e3_getqcalluinreq.rpt_uint64_uins.set(arrayList);
            oidb_0x5e3_getqcalluinreq.uint32_req_nick.set(1);
            oidb_0x5e3_getqcalluinreq.uint32_req_gender.set(1);
            oidb_0x5e3_getqcalluinreq.uint32_req_birthday.set(1);
            oidb_0x5e3$ReqBody oidb_0x5e3_reqbody = new oidb_0x5e3$ReqBody();
            oidb_0x5e3_reqbody.rpt_msg_get_qcall_uin_req.set(oidb_0x5e3_getqcalluinreq);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1507);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5e3_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("QcallOidbSvc.0x5e3_1");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException unused) {
            QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin String to long NumberFormatException!!!");
        }
    }

    public void F2(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f261490e = aVar;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f261491f == null) {
            HashSet hashSet = new HashSet();
            this.f261491f = hashSet;
            hashSet.add("QcallOidbSvc.0x5e3_1");
        }
        return this.f261491f;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("QCallCardHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.i("QCallCardHandler", 2, String.format("onReceive FromServiceMsg(cmd=%s,resultCode=%d)", serviceCmd, Integer.valueOf(resultCode)));
        }
        if (serviceCmd.equals("QcallOidbSvc.0x5e3_1")) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
