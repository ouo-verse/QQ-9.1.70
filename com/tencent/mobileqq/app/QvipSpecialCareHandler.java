package com.tencent.mobileqq.app;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.pb.remind.RemindPB$RemindItem;
import com.tencent.pb.remind.RemindPB$RemindQuota;
import com.tencent.pb.remind.RemindPB$ReqBody;
import com.tencent.pb.remind.RemindPB$RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QvipSpecialCareHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194977d;

    QvipSpecialCareHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194977d = qQAppInterface;
        }
    }

    private boolean E2(List<String> list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    private void F2(RemindPB$RspBody remindPB$RspBody) {
        if (remindPB$RspBody.rep_clear_uin.has()) {
            List<Long> list = remindPB$RspBody.rep_clear_uin.get();
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                Iterator<Long> it = list.iterator();
                while (it.hasNext()) {
                    String valueOf = String.valueOf(it.next());
                    arrayList.add(valueOf);
                    com.tencent.mobileqq.activity.specialcare.e.d(valueOf, this.f194977d);
                }
                com.tencent.mobileqq.activity.specialcare.e.c(arrayList, this.f194977d);
            }
        }
    }

    private void G2(RemindPB$RspBody remindPB$RspBody) {
        if (remindPB$RspBody.msg_quota.has()) {
            RemindPB$RemindQuota remindPB$RemindQuota = remindPB$RspBody.msg_quota.get();
            if (remindPB$RemindQuota.uint32_comm_quota.has()) {
                com.tencent.mobileqq.activity.specialcare.e.i(remindPB$RemindQuota.uint32_comm_quota.get(), this.f194977d);
            }
            if (remindPB$RemindQuota.uint32_svip_quota.has()) {
                com.tencent.mobileqq.activity.specialcare.e.j(remindPB$RemindQuota.uint32_svip_quota.get(), this.f194977d);
            }
            com.tencent.mobileqq.activity.specialcare.e.l(this.f194977d);
        }
    }

    private void H2(FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.e("QVipSpeicalCareHandler", 2, "-->report MM:cmd=" + fromServiceMsg.getServiceCmd() + ",error code=" + fromServiceMsg.getBusinessFailCode() + ",uin=" + this.f194977d.getCurrentAccountUin());
        }
        if (!fromServiceMsg.isSuccess()) {
            ReportCenter.f().r(fromServiceMsg.getServiceCmd(), 100, fromServiceMsg.getBusinessFailCode(), this.f194977d.getCurrentAccountUin(), VipFunCallConstants.MM_APPID, HardCodeUtil.qqStr(R.string.rj8), true);
        }
    }

    private void I2(FromServiceMsg fromServiceMsg, byte[] bArr) {
        RemindPB$RspBody remindPB$RspBody = new RemindPB$RspBody();
        try {
            remindPB$RspBody.mergeFrom(bArr);
        } catch (Exception e16) {
            QLog.i("SpecialRemind.Service", 1, "handle send special sound exception:" + e16.getMessage());
            e16.printStackTrace();
            remindPB$RspBody = null;
        }
        if (remindPB$RspBody != null && remindPB$RspBody.uint32_method.has()) {
            int i3 = remindPB$RspBody.uint32_method.get();
            if (remindPB$RspBody.int32_ret.has()) {
                if (remindPB$RspBody.int32_ret.get() == 0) {
                    K2(fromServiceMsg, remindPB$RspBody, i3);
                } else {
                    J2(fromServiceMsg, remindPB$RspBody, i3);
                }
            }
        }
    }

    private void J2(FromServiceMsg fromServiceMsg, RemindPB$RspBody remindPB$RspBody, int i3) {
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("SpecialRemind.Service", 2, "get count fail.");
            }
        } else {
            notifyUI(1001, fromServiceMsg.isSuccess(), Integer.valueOf(remindPB$RspBody.int32_ret.get()));
        }
    }

    private void K2(FromServiceMsg fromServiceMsg, RemindPB$RspBody remindPB$RspBody, int i3) {
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    F2(remindPB$RspBody);
                }
            } else {
                L2(remindPB$RspBody);
            }
        } else {
            G2(remindPB$RspBody);
        }
        notifyUI(1000, fromServiceMsg.isSuccess(), Integer.valueOf(i3));
    }

    private void L2(RemindPB$RspBody remindPB$RspBody) {
        List<RemindPB$RemindItem> list;
        if (remindPB$RspBody.rep_set_info.has() && (list = remindPB$RspBody.rep_set_info.get()) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (RemindPB$RemindItem remindPB$RemindItem : list) {
                if (remindPB$RemindItem.uint64_uin.has() && remindPB$RemindItem.uint32_id.has()) {
                    String valueOf = String.valueOf(remindPB$RemindItem.uint64_uin.get());
                    arrayList.add(valueOf);
                    com.tencent.mobileqq.activity.specialcare.e.h(valueOf, remindPB$RemindItem.uint32_id.get(), this.f194977d);
                }
            }
            com.tencent.mobileqq.activity.specialcare.e.g(arrayList, this.f194977d);
        }
    }

    public void D2(FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg, obj);
        } else if (fromServiceMsg.isSuccess() && obj != null) {
            I2(fromServiceMsg, (byte[]) obj);
        } else {
            H2(fromServiceMsg);
        }
    }

    public void M2(List<String> list, int i3, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, Integer.valueOf(i3), list2);
            return;
        }
        RemindPB$ReqBody remindPB$ReqBody = new RemindPB$ReqBody();
        try {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    if (i3 == 4 && E2(list)) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            remindPB$ReqBody.rep_clear_uin.add(Long.valueOf(Long.parseLong(it.next())));
                        }
                        remindPB$ReqBody.uint32_method.set(4);
                    }
                } else if (E2(list) && E2(list2) && list.size() == list2.size()) {
                    int size = list2.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        RemindPB$RemindItem remindPB$RemindItem = new RemindPB$RemindItem();
                        remindPB$RemindItem.uint64_uin.set(Long.parseLong(list.get(i16)));
                        remindPB$RemindItem.uint32_id.set(Integer.parseInt(list2.get(i16)));
                        remindPB$ReqBody.rep_set_info.add(remindPB$RemindItem);
                        remindPB$ReqBody.setHasFlag(true);
                    }
                    remindPB$ReqBody.uint32_method.set(i3);
                }
            } else {
                remindPB$ReqBody.uint32_method.set(1);
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("SpecialRemind.Service");
            createToServiceMsg.putWupBuffer(remindPB$ReqBody.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return cn.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0 && "SpecialRemind.Service".equals(fromServiceMsg.getServiceCmd())) {
            D2(fromServiceMsg, obj);
        }
    }
}
