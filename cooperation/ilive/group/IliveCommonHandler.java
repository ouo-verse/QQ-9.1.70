package cooperation.ilive.group;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.pb.LiveGroupTips$GetLiveGroupTipsReq;
import cooperation.ilive.pb.LiveGroupTips$GetLiveGroupTipsRsp;
import o05.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveCommonHandler extends BusinessHandler {
    protected IliveCommonHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        LiveGroupTips$GetLiveGroupTipsRsp liveGroupTips$GetLiveGroupTipsRsp = new LiveGroupTips$GetLiveGroupTipsRsp();
        try {
            liveGroupTips$GetLiveGroupTipsRsp.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("IliveCommonHandler", 2, "handleGetIliveGroupTipsData, isSuccess = " + fromServiceMsg.isSuccess());
        }
        String str = (String) toServiceMsg.getAttribute("source");
        if (fromServiceMsg.isSuccess()) {
            notifyUI(1, true, new Object[]{str, a.a(liveGroupTips$GetLiveGroupTipsRsp)});
        } else {
            notifyUI(1, false, new Object[]{str});
        }
    }

    public void E2(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("IliveCommonHandler", 2, "sendPbRequest. IliveGroup troopUin = " + str2 + " anchorUid = " + str + " source = " + str3);
        }
        LiveGroupTips$GetLiveGroupTipsReq liveGroupTips$GetLiveGroupTipsReq = new LiveGroupTips$GetLiveGroupTipsReq();
        liveGroupTips$GetLiveGroupTipsReq.anchor_uid.set(str);
        liveGroupTips$GetLiveGroupTipsReq.group_id.set(Long.parseLong(str2));
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQLive.GetLiveGroupTips");
        createToServiceMsg.putWupBuffer(liveGroupTips$GetLiveGroupTipsReq.toByteArray());
        createToServiceMsg.setTimeout(10000L);
        createToServiceMsg.addAttribute("source", str3);
        super.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return IliveGroupObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("QQLive.GetLiveGroupTips".equals(fromServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
