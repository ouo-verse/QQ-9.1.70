package com.tencent.mobileqq.app.message;

import PushNotifyPack.RequestPushNotify;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc$PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc$PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc$PbGetMsgResp;
import msf.msgsvc.msg_svc$PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc$PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc$PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc$PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush$PbPushMsg;
import oicq.wlogin_sdk.request.Ticket;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$ContentItem;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$RspBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpdateItem;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m extends com.tencent.mobileqq.app.message.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<msg_comm$Msg> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(msg_comm$Msg msg_comm_msg, msg_comm$Msg msg_comm_msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg_comm_msg, (Object) msg_comm_msg2)).intValue();
            }
            return msg_comm_msg.msg_head.get().msg_time.get() - msg_comm_msg2.msg_head.get().msg_time.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends AsyncTask<Void, Void, ArrayList<String>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Oidb_0x5d0$RspBody f196039a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f196040b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f196041c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f196042d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f196043e;

        b(Oidb_0x5d0$RspBody oidb_0x5d0$RspBody, String str, String str2, int i3, int i16) {
            this.f196039a = oidb_0x5d0$RspBody;
            this.f196040b = str;
            this.f196041c = str2;
            this.f196042d = i3;
            this.f196043e = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, m.this, oidb_0x5d0$RspBody, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<String> doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (Oidb_0x5d0$ContentItem oidb_0x5d0$ContentItem : this.f196039a.rpt_msg_contentItem.get()) {
                        if (oidb_0x5d0$ContentItem.msg_general_buffer.bytes_value.get() != null && oidb_0x5d0$ContentItem.msg_general_buffer.bytes_value.get().size() > 0) {
                            Oidb_0x5d0$SnsUpateBuffer oidb_0x5d0$SnsUpateBuffer = new Oidb_0x5d0$SnsUpateBuffer();
                            oidb_0x5d0$SnsUpateBuffer.mergeFrom(oidb_0x5d0$ContentItem.msg_general_buffer.bytes_value.get().toByteArray());
                            if (oidb_0x5d0$SnsUpateBuffer.rpt_msg_sns_update_item.has()) {
                                for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : oidb_0x5d0$SnsUpateBuffer.rpt_msg_sns_update_item.get()) {
                                    if (oidb_0x5d0$SnsUpdateItem != null && oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.has() && oidb_0x5d0$SnsUpdateItem.bytes_value.has() && oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13573) {
                                        String valueOf = String.valueOf(oidb_0x5d0$SnsUpateBuffer.uint64_uin.get());
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare special care uin=" + valueOf);
                                        }
                                        if (!TextUtils.isEmpty(valueOf) && !arrayList.contains(valueOf)) {
                                            arrayList.add(valueOf);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare need time = [" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
                    }
                    return arrayList;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare handle rpt_msg_contentItem error");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare need time = [" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare need time = [" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
                }
                throw th5;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
            } else if (arrayList != null) {
                ((ISubAccountControlService) ((BaseMessageProcessor) m.this).f116342a.getRuntimeService(ISubAccountControlService.class, "")).storeSubAccountSpecialCareList(this.f196040b, this.f196041c, arrayList, this.f196042d, this.f196043e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f196045a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WtloginManager f196046b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f196047c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ msg_svc$PbThirdQQUnReadMsgNumReq f196048d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f196049e;

        c(String str, WtloginManager wtloginManager, long j3, msg_svc$PbThirdQQUnReadMsgNumReq msg_svc_pbthirdqqunreadmsgnumreq, CountDownLatch countDownLatch) {
            this.f196045a = str;
            this.f196046b = wtloginManager;
            this.f196047c = j3;
            this.f196048d = msg_svc_pbthirdqqunreadmsgnumreq;
            this.f196049e = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, m.this, str, wtloginManager, Long.valueOf(j3), msg_svc_pbthirdqqunreadmsgnumreq, countDownLatch);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                this.f196049e.countDown();
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                m.this.p1(this.f196045a, mainTicketInfo.getA2(), this.f196046b, this.f196047c, this.f196048d);
                this.f196049e.countDown();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
            }
        }
    }

    public m(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        }
    }

    private void A1(ISubAccountService iSubAccountService, long j3, long j16, long j17, int i3, StringBuffer stringBuffer, boolean z16, MessageRecord messageRecord, long j18, boolean z17, String str) {
        int i16;
        String str2;
        long j19;
        SubAccountMessage subAccountMessage = new SubAccountMessage();
        if (z17) {
            subAccountMessage.frienduin = String.valueOf(AppConstants.SYSTEM_MSG_UIN);
        } else {
            subAccountMessage.frienduin = String.valueOf(j17);
        }
        subAccountMessage.isread = z16;
        subAccountMessage.f203118msg = stringBuffer.toString();
        subAccountMessage.extInt = messageRecord.extInt;
        subAccountMessage.extLong = messageRecord.extLong;
        subAccountMessage.extraflag = messageRecord.extraflag;
        subAccountMessage.extStr = messageRecord.extStr;
        subAccountMessage.istroop = messageRecord.istroop;
        subAccountMessage.isValid = messageRecord.isValid;
        subAccountMessage.longMsgCount = messageRecord.longMsgCount;
        subAccountMessage.longMsgId = messageRecord.longMsgId;
        subAccountMessage.longMsgIndex = messageRecord.longMsgIndex;
        subAccountMessage.msgUid = messageRecord.msgUid;
        subAccountMessage.shmsgseq = messageRecord.shmsgseq;
        subAccountMessage.uniseq = messageRecord.uniseq;
        subAccountMessage.msgseq = messageRecord.msgseq;
        if (z16) {
            i16 = 0;
        } else {
            i16 = i3;
        }
        subAccountMessage.unreadNum = i16;
        subAccountMessage.msgtype = -1000;
        subAccountMessage.selfuin = String.valueOf(j3);
        if (str != null && str.length() != 0) {
            str2 = str;
        } else {
            str2 = subAccountMessage.frienduin;
        }
        subAccountMessage.sendername = str2;
        subAccountMessage.senderuin = String.valueOf(j17);
        subAccountMessage.subUin = Long.toString(j16);
        if (j18 == 0) {
            j19 = System.currentTimeMillis() / 1000;
        } else {
            j19 = j18;
        }
        subAccountMessage.time = j19;
        AppInterface appInterface = this.f116342a;
        subAccountMessage.needNotify = appInterface.isBackgroundPause;
        subAccountMessage.mTimeString = en.p(1000 * j18, true, ((ISubAccountControlService) appInterface.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
        subAccountMessage.mEmoRecentMsg = new QQText(subAccountMessage.f203118msg, 3, 16);
        if (((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).isRedPacketMsg(messageRecord)) {
            subAccountMessage.subExtr = SubAccountMessage.SUB_EXTR_RED_PACKET;
        }
        if (((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).isMessageFuDai(messageRecord)) {
            subAccountMessage.subExtr = SubAccountMessage.SUB_EXTR_RED_PACKET;
        }
        if (iSubAccountService != null) {
            iSubAccountService.addNewMessage(subAccountMessage);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount set msg read false hasData = false  unreadNum=" + subAccountMessage.unreadNum);
            if (!TextUtils.isEmpty(subAccountMessage.f203118msg)) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "msg=" + subAccountMessage.f203118msg.charAt(0));
            }
        }
    }

    private boolean B1(com.tencent.mobileqq.subaccount.logic.a aVar, String str, msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp, ISubAccountService iSubAccountService) {
        if (msg_svc_pbgetmsgresp.result.has() && msg_svc_pbgetmsgresp.result.get() == 0) {
            return false;
        }
        int i3 = msg_svc_pbgetmsgresp.result.get();
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "12015");
        hashMap.put(ISubAccountControlService.FAIL_STEP, "result_" + i3);
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, hashMap, "");
        if (i3 > 100) {
            i3 -= 100;
        }
        int i16 = i3;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i16);
        }
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, "");
        if (i16 != 1) {
            if (i16 != 1000) {
                if (i16 != 1001) {
                    if (u1(i16)) {
                        y1(aVar, str, msg_svc_pbgetmsgresp, iSubAccountService, i16);
                    } else {
                        aVar.f291121a = 1000;
                    }
                } else {
                    aVar.f291121a = 1002;
                    iSubAccountControlService.setBindUinStatus(this.f116342a, (byte) 0, str);
                    iSubAccountControlService.clearAllData(this.f116342a, str);
                }
            } else {
                aVar.f291121a = 1008;
                iSubAccountControlService.clearAllData(this.f116342a, ISubAccountControlService.UIN_ALL);
            }
        } else {
            aVar.f291121a = 1006;
        }
        l(8003, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
        }
        return true;
    }

    private void C1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        byte[] bArr;
        int i3;
        boolean z16;
        byte b16;
        long j16;
        Object valueOf;
        Object valueOf2;
        com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
        String string = toServiceMsg.extraData.getString("subAccount");
        String uin = toServiceMsg.getUin();
        aVar.f291123c = uin;
        aVar.f291124d = string;
        msg_svc$PbGetMsgResp l16 = l1((byte[]) obj, new msg_svc$PbGetMsgResp());
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
            sb5.append(toServiceMsg.getRequestSsoSeq());
            sb5.append(" msgStruct.cReplyCode: ");
            Object obj2 = "null";
            if (l16 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(l16.result.get());
            }
            sb5.append(valueOf);
            sb5.append(",hasSyncCookie:");
            if (l16 == null) {
                valueOf2 = "null";
            } else {
                valueOf2 = Boolean.valueOf(l16.sync_cookie.has());
            }
            sb5.append(valueOf2);
            sb5.append(",syncFlag:");
            if (l16 != null) {
                obj2 = Integer.valueOf(l16.sync_flag.get());
            }
            sb5.append(obj2);
            sb5.append("subUin=");
            sb5.append(string);
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, sb5.toString());
        }
        if (i1(aVar, l16)) {
            return;
        }
        ISubAccountService iSubAccountService = (ISubAccountService) this.f116342a.getRuntimeService(ISubAccountService.class, "");
        if (B1(aVar, string, l16, iSubAccountService)) {
            return;
        }
        iSubAccountService.setStatus(string, 1);
        String uin2 = fromServiceMsg.getUin();
        long j17 = -1;
        try {
            j3 = Long.parseLong(string);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 1, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
            j3 = -1;
        }
        if (s1(aVar, uin2)) {
            return;
        }
        try {
            j17 = Long.valueOf(fromServiceMsg.getUin()).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
            }
        }
        if (q1(aVar, j17)) {
            return;
        }
        if (!iSubAccountService.getNotifySwitch()) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "processSubAccountMessage return as notify off");
                return;
            }
            return;
        }
        if (l16.sync_cookie.has()) {
            bArr = l16.sync_cookie.get().toByteArray();
        } else {
            bArr = null;
        }
        if (l16.sync_flag.has()) {
            i3 = l16.sync_flag.get();
        } else {
            i3 = 2;
        }
        if (i3 < 2) {
            b16 = (byte) 1;
            z16 = false;
        } else {
            z16 = true;
            b16 = 0;
        }
        if (l16.bind_uin.has()) {
            j16 = l16.bind_uin.get();
        } else {
            j16 = 0;
        }
        List<SubAccountMessage> allMessage = iSubAccountService.getAllMessage(Long.toString(j16));
        ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
        if (stringArrayList == null) {
            stringArrayList = new ArrayList<>();
        }
        ArrayList<String> arrayList = stringArrayList;
        HashMap<String, Integer> hashMap = new HashMap<>();
        I1(aVar, string, uin, l16, iSubAccountService, j17, j3, z16, j16, allMessage, arrayList, hashMap);
        z1(string, iSubAccountService, z16, j16, allMessage, arrayList, hashMap);
        iSubAccountService.updateCookie(string, bArr);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("param_FailCode", "12016");
        hashMap2.put(ISubAccountControlService.FAIL_STEP, "success");
        hashMap2.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "actSBGetMsg", true, 0L, 0L, hashMap2, "");
        if (k1(toServiceMsg, aVar, b16, i3, j16, arrayList)) {
            return;
        }
        aVar.f291121a = 0;
        l(8003, true, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
        }
    }

    private void D1(msg_comm$Msg msg_comm_msg, FromServiceMsg fromServiceMsg, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg) {
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        long j3 = msg_comm_msghead.from_uin.get();
        long j16 = msg_comm_msghead.msg_time.get();
        long j17 = msg_onlinepush_pbpushmsg.uint64_bind_uin.get();
        if (j3 == j17) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "processSubAccountTroopMessage fromUin = bindUin:", Long.valueOf(j17), " fromUin:", Long.valueOf(j3), " msgTime:", Long.valueOf(j16));
                return;
            }
            return;
        }
        SubAccountMessage subAccountMessage = new SubAccountMessage();
        subAccountMessage.frienduin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
        subAccountMessage.unreadNum = 1;
        subAccountMessage.msgtype = -1000;
        subAccountMessage.time = j16;
        subAccountMessage.senderuin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
        subAccountMessage.subUin = String.valueOf(j17);
        subAccountMessage.istroop = 1;
        subAccountMessage.sendername = HardCodeUtil.qqStr(R.string.f229626wy);
        subAccountMessage.f203118msg = "";
        ISubAccountService iSubAccountService = (ISubAccountService) this.f116342a.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            iSubAccountService.updateTroopMsgRedDot(subAccountMessage);
            iSubAccountService.addNewMessage(subAccountMessage);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "processSubAccountTroopMessage bindUin:", Long.valueOf(j17), " fromUin:", Long.valueOf(j3), " msgTime:", Long.valueOf(j16));
        }
        com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
        aVar.f291123c = fromServiceMsg.getUin();
        aVar.f291124d = String.valueOf(j17);
        aVar.f291132l = true;
        aVar.f291133m = true;
        aVar.f291121a = 0;
        l(8003, true, aVar);
    }

    private void E1(Oidb_0x5d0$RspBody oidb_0x5d0$RspBody, String str, String str2, int i3, int i16) {
        new b(oidb_0x5d0$RspBody, str2, str, i3, i16).execute(new Void[0]);
    }

    private void F1(List<SubAccountMessage> list, ArrayList<String> arrayList, HashMap<String, Integer> hashMap, long j3, int i3) {
        String str;
        if (list != null) {
            for (SubAccountMessage subAccountMessage : list) {
                if (subAccountMessage != null && (str = subAccountMessage.frienduin) != null && str.equalsIgnoreCase(String.valueOf(j3))) {
                    arrayList.add(String.valueOf(j3));
                    hashMap.put(String.valueOf(j3), Integer.valueOf(i3));
                    return;
                }
            }
        }
    }

    private void G1(com.tencent.mobileqq.subaccount.logic.a aVar, String str, String str2, ISubAccountService iSubAccountService, long j3, long j16, long j17, List<SubAccountMessage> list, ArrayList<String> arrayList, HashMap<String, Integer> hashMap, long j18, List<msg_comm$Msg> list2, int i3, com.tencent.mobileqq.service.message.a aVar2) {
        List<MessageRecord> arrayList2;
        m mVar = this;
        List<SubAccountMessage> list3 = list;
        for (msg_comm$Msg msg_comm_msg : list2) {
            if (msg_comm_msg != null) {
                msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
                int i16 = msg_comm_msghead.msg_type.get();
                int i17 = msg_comm_msg.msg_head.get().c2c_cmd.get();
                List<MessageRecord> list4 = null;
                list4 = null;
                String str3 = null;
                if (193 == i16 || 734 == i16) {
                    if (j16 != j18) {
                        arrayList2 = new ArrayList<>();
                        MessageRecord createMsgRecordByMsgType = ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(193);
                        createMsgRecordByMsgType.selfuin = String.valueOf(j16);
                        createMsgRecordByMsgType.frienduin = String.valueOf(j18);
                        createMsgRecordByMsgType.senderuin = String.valueOf(j18);
                        createMsgRecordByMsgType.shmsgseq = msg_comm_msghead.msg_seq.get();
                        createMsgRecordByMsgType.msgUid = msg_comm_msghead.msg_uid.get();
                        createMsgRecordByMsgType.time = msg_comm_msghead.msg_time.get();
                        createMsgRecordByMsgType.istroop = 0;
                        createMsgRecordByMsgType.f203106msg = mVar.f116342a.getApp().getResources().getString(R.string.ic7);
                        createMsgRecordByMsgType.msgtype = 193;
                        arrayList2.add(createMsgRecordByMsgType);
                    }
                    arrayList2 = list4;
                } else if (mVar.v1(msg_comm_msghead, i16, i17)) {
                    if (!mVar.x1(i17)) {
                        try {
                            str3 = msg_comm_msg.msg_body.get().rich_text.get().not_online_file.get().bytes_file_name.get().toStringUtf8();
                            if (QLog.isColorLevel()) {
                                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "fileName = " + str3);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = mVar.f116342a.getApp().getResources().getString(R.string.aef);
                        }
                        MessageRecord createMsgRecordByMsgType2 = ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(-2005);
                        createMsgRecordByMsgType2.selfuin = String.valueOf(j16);
                        createMsgRecordByMsgType2.frienduin = String.valueOf(j18);
                        createMsgRecordByMsgType2.senderuin = String.valueOf(j18);
                        createMsgRecordByMsgType2.shmsgseq = msg_comm_msghead.msg_seq.get();
                        createMsgRecordByMsgType2.msgUid = msg_comm_msghead.msg_uid.get();
                        createMsgRecordByMsgType2.time = msg_comm_msghead.msg_time.get();
                        createMsgRecordByMsgType2.istroop = 0;
                        createMsgRecordByMsgType2.f203106msg = str3;
                        createMsgRecordByMsgType2.msgtype = -2005;
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(createMsgRecordByMsgType2);
                        arrayList2 = arrayList3;
                    }
                } else {
                    try {
                        list4 = mVar.L(msg_comm_msg, aVar2);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.w("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "decodeSinglePBMsg_C2C error,", e17);
                        }
                    }
                    if (!mVar.w1(list4)) {
                        arrayList2 = list4;
                    }
                }
                if (arrayList2 != null && !arrayList2.isEmpty() && list3 != null && !list.isEmpty() && arrayList2.get(0).time < list3.get(0).time) {
                    arrayList2.clear();
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    m1(aVar, str, str2, iSubAccountService, j3, j17, list, arrayList, j18, i3, msg_comm_msg, arrayList2);
                } else {
                    F1(list, arrayList, hashMap, j18, i3);
                }
                mVar = this;
                list3 = list;
            }
        }
    }

    private void H1(List<SubAccountMessage> list, ArrayList<String> arrayList, long j3, boolean z16) {
        String str;
        if (list != null && !z16) {
            for (SubAccountMessage subAccountMessage : list) {
                if (subAccountMessage != null && (str = subAccountMessage.frienduin) != null && str.equalsIgnoreCase(String.valueOf(j3))) {
                    arrayList.add(String.valueOf(j3));
                    return;
                }
            }
        }
    }

    private void I1(com.tencent.mobileqq.subaccount.logic.a aVar, String str, String str2, msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp, ISubAccountService iSubAccountService, long j3, long j16, boolean z16, long j17, List<SubAccountMessage> list, ArrayList<String> arrayList, HashMap<String, Integer> hashMap) {
        long j18;
        List<msg_comm$UinPairMsg> list2 = msg_svc_pbgetmsgresp.uin_pair_msgs.get();
        for (int i3 = 0; i3 < list2.size(); i3++) {
            msg_comm$UinPairMsg msg_comm_uinpairmsg = list2.get(i3);
            long j19 = msg_comm_uinpairmsg.peer_uin.get();
            long j26 = msg_comm_uinpairmsg.last_read_time.get() & 4294967295L;
            List<msg_comm$Msg> list3 = msg_comm_uinpairmsg.f417532msg.get();
            if (!z16) {
                arrayList.add(Long.toString(j19));
            }
            int i16 = msg_comm_uinpairmsg.unread_msg_num.get();
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + j19);
            }
            if (list3 != null && list3.size() != 0 && i16 != 0) {
                com.tencent.mobileqq.service.message.a aVar2 = new com.tencent.mobileqq.service.message.a(j16, j19, false, false, false, true);
                if (list3.size() > 0) {
                    Collections.sort(list3, new a());
                    boolean z17 = msg_comm_uinpairmsg.msg_completed.has() && msg_comm_uinpairmsg.msg_completed.get() != 0;
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + j19 + "msgList size: " + list3.size() + ",uMsgCompleted:" + z17 + ",lastReadTime:" + j26);
                    }
                    G1(aVar, str, str2, iSubAccountService, j3, j16, j17, list, arrayList, hashMap, j19, list3, i16, aVar2);
                }
            } else {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null ");
                    j18 = j19;
                    sb5.append(j18);
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, sb5.toString());
                } else {
                    j18 = j19;
                }
                F1(list, arrayList, hashMap, j18, i16);
            }
        }
    }

    private boolean i1(com.tencent.mobileqq.subaccount.logic.a aVar, msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp) {
        if (msg_svc_pbgetmsgresp != null) {
            return false;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "12014");
        hashMap.put(ISubAccountControlService.FAIL_STEP, "getmsgresp_null");
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, hashMap, "");
        l(8003, false, aVar);
        return true;
    }

    private boolean j1(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        if (oidb_sso_oidbssopkg == null || !oidb_sso_oidbssopkg.uint32_result.has() || !oidb_sso_oidbssopkg.bytes_bodybuffer.has() || oidb_sso_oidbssopkg.bytes_bodybuffer.get() == null || oidb_sso_oidbssopkg.uint32_service_type.get() != 1) {
            return true;
        }
        return false;
    }

    private boolean k1(ToServiceMsg toServiceMsg, com.tencent.mobileqq.subaccount.logic.a aVar, byte b16, int i3, long j3, ArrayList<String> arrayList) {
        if (b16 > 0) {
            if (j3 > 0) {
                String string = toServiceMsg.extraData.getString("subaccount_a2");
                if (string != null) {
                    Z0(b16, i3, String.valueOf(j3), string, arrayList);
                    aVar.f291130j = false;
                    l(8003, true, aVar);
                    return true;
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
            }
        }
        return false;
    }

    @Nullable
    private msg_svc$PbGetMsgResp l1(byte[] bArr, msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("printPBuffer", 2, HexUtil.bytes2HexStr(bArr));
            }
            return msg_svc_pbgetmsgresp.mergeFrom(bArr);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", e16);
            }
            return null;
        }
    }

    private void m1(com.tencent.mobileqq.subaccount.logic.a aVar, String str, String str2, ISubAccountService iSubAccountService, long j3, long j16, List<SubAccountMessage> list, ArrayList<String> arrayList, long j17, int i3, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2) {
        String str3;
        boolean z16;
        StringBuffer stringBuffer = new StringBuffer();
        MessageRecord messageRecord = list2.get(0);
        long j18 = messageRecord.time;
        Iterator<MessageRecord> it = list2.iterator();
        boolean z17 = false;
        while (true) {
            if (!it.hasNext()) {
                str3 = "";
                z16 = false;
                break;
            }
            MessageRecord next = it.next();
            if (next != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB mr=" + next);
                }
                String str4 = next.f203106msg;
                if (next.frienduin == null) {
                    continue;
                } else {
                    Iterator<MessageRecord> it5 = it;
                    if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equalsIgnoreCase(next.frienduin)) {
                        str3 = "";
                        String dealSysMsgContent = ((ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, "")).dealSysMsgContent(this.f116342a, str4, next.msgtype, next.senderuin);
                        if (dealSysMsgContent != null) {
                            stringBuffer.append(dealSysMsgContent);
                        }
                        z16 = true;
                    } else {
                        if (next.msgtype == -5004 && ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).isMessagePubAccount(next) && AppConstants.PUBLIC_ACCOUNT_QQ_MAIL.equals(messageRecord.senderuin)) {
                            z17 = true;
                        }
                        String buildBaseMsg = ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).buildBaseMsg(this.f116342a, next, str4);
                        stringBuffer.append(buildBaseMsg == null ? "" : buildBaseMsg);
                        it = it5;
                    }
                }
            }
        }
        if (stringBuffer.length() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
                return;
            }
            return;
        }
        String str5 = str3;
        H1(list, arrayList, j17, z16);
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        String str6 = (msg_comm_msghead == null || !msg_comm_msghead.from_nick.has()) ? null : msg_comm_msghead.from_nick.get();
        if (z16) {
            str6 = this.f116342a.getApp().getResources().getString(R.string.huc);
        }
        String str7 = str6;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "sub.account.msg isQQMail=" + z17);
        }
        aVar.f291132l = true;
        boolean z18 = z17;
        A1(iSubAccountService, j3, j16, j17, i3, stringBuffer, z18, messageRecord, j18, z16, str7);
        ((ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, str5)).bindRecentItem(this.f116342a, str, 6);
        aVar.f291133m = true;
        MessageRecord createMsgRecordByMsgType = ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(messageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField(createMsgRecordByMsgType, messageRecord);
        createMsgRecordByMsgType.istroop = 7000;
        createMsgRecordByMsgType.frienduin = str;
        int unreadCount = ((IConversationFacade) this.f116342a.getRuntimeService(IConversationFacade.class, str5)).getUnreadCount(createMsgRecordByMsgType.frienduin, createMsgRecordByMsgType.istroop);
        int unreadAllMsgNum = iSubAccountService != null ? iSubAccountService.getUnreadAllMsgNum(str) : 0;
        int i16 = unreadAllMsgNum - unreadCount;
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "sub.account.msg conversion subUin=" + str + " target=" + unreadAllMsgNum + " old=" + unreadCount + " increase=" + i16);
        }
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        arrayList2.add(createMsgRecordByMsgType);
        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, str5)).addMessage(arrayList2, str2, false, false, true);
        if (z18) {
            return;
        }
        this.f116344c.handleReceivedMessage(arrayList2.size(), true, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string;
        String string2;
        String str;
        byte[] bArr;
        boolean z16;
        Object valueOf;
        Object[] objArr;
        long j3;
        Object valueOf2;
        String str2 = "null";
        if (toServiceMsg == null) {
            string = "null";
        } else {
            string = toServiceMsg.extraData.getString("nextAction");
        }
        if (toServiceMsg == null) {
            string2 = "null";
        } else {
            string2 = toServiceMsg.extraData.getString("subAccount");
        }
        String str3 = null;
        int i3 = -1;
        try {
            msg_svc$PbBindUinMsgReadedConfirmResp mergeFrom = new msg_svc$PbBindUinMsgReadedConfirmResp().mergeFrom((byte[]) obj);
            i3 = mergeFrom.result.get();
            if (mergeFrom.sync_cookie.has()) {
                objArr = mergeFrom.sync_cookie.get().toByteArray();
            } else {
                objArr = 0;
            }
            try {
                if (mergeFrom.bind_uin.has()) {
                    j3 = mergeFrom.bind_uin.get();
                } else {
                    j3 = 0;
                }
                if (mergeFrom.errmsg.has()) {
                    str3 = mergeFrom.errmsg.get();
                }
                bArr = objArr;
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handleConfirmSubAccountMsgNumReaded() subUin=");
                    sb5.append(string2);
                    sb5.append(" lSubUin=");
                    sb5.append(j3);
                    sb5.append(" errMsg=");
                    sb5.append(str3);
                    sb5.append(" cookie=");
                    if (objArr == 0) {
                        valueOf2 = "null";
                    } else {
                        valueOf2 = Integer.valueOf(objArr.length);
                    }
                    sb5.append(valueOf2);
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, sb5.toString());
                    bArr = objArr;
                }
            } catch (Exception e16) {
                e = e16;
                String str4 = str3;
                str3 = objArr;
                str = str4;
                if (QLog.isColorLevel()) {
                    QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", e);
                }
                String str5 = str3;
                str3 = str;
                bArr = str5;
                if (QLog.isColorLevel()) {
                }
                if (i3 != 0) {
                }
                l(8011, z16, new String[]{string2, string});
            }
        } catch (Exception e17) {
            e = e17;
            str = null;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
            if (toServiceMsg == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(toServiceMsg.getRequestSsoSeq());
            }
            sb6.append(valueOf);
            sb6.append(" result=");
            sb6.append(i3);
            sb6.append(" syncCookie=");
            if (bArr != 0) {
                str2 = Integer.toString(bArr.length);
            }
            sb6.append(str2);
            sb6.append(" errms=");
            sb6.append(String.valueOf(str3));
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, sb6.toString());
        }
        if (i3 != 0) {
            ISubAccountService iSubAccountService = (ISubAccountService) this.f116342a.getRuntimeService(ISubAccountService.class, "");
            if (iSubAccountService != null) {
                iSubAccountService.updateCookie(string2, bArr);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        l(8011, z16, new String[]{string2, string});
    }

    private void o1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000 && obj != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare() req = " + toServiceMsg);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare() resultCode = " + fromServiceMsg.getResultCode() + " isSuccess = " + fromServiceMsg.isSuccess() + " resp = " + fromServiceMsg);
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (j1(mergeFrom)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare ssoPkg check error");
                        return;
                    }
                    return;
                }
                Oidb_0x5d0$RspBody oidb_0x5d0$RspBody = new Oidb_0x5d0$RspBody();
                try {
                    oidb_0x5d0$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + oidb_0x5d0$RspBody.rpt_msg_contentItem.size());
                    }
                    String valueOf = String.valueOf(oidb_0x5d0$RspBody.uint64_uin.get());
                    String valueOf2 = String.valueOf(toServiceMsg.getAttribute("subaccount"));
                    String uin = fromServiceMsg.getUin();
                    int i3 = oidb_0x5d0$RspBody.uint32_sys_time.get();
                    int i16 = oidb_0x5d0$RspBody.uint32_advise_gap.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + oidb_0x5d0$RspBody.rpt_msg_contentItem.get().size() + "  rspBody.uin=" + String.valueOf(oidb_0x5d0$RspBody.uint64_uin.get()) + "  resp.getUin()=" + fromServiceMsg.getUin() + "  sysTime=" + i3 + " adviseGap=" + i16);
                    }
                    if (!TextUtils.isEmpty(valueOf) && !"0".equals(valueOf) && TextUtils.equals(valueOf, valueOf2) && TextUtils.equals(uin, this.f116342a.getCurrentUin())) {
                        E1(oidb_0x5d0$RspBody, valueOf, uin, i3, i16);
                    } else {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare req or resp params error");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare  rspBody==null");
                    }
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubAccountSpecialCare ssoPkg.mergeFrom exception");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(String str, String str2, WtloginManager wtloginManager, long j3, msg_svc$PbThirdQQUnReadMsgNumReq msg_svc_pbthirdqqunreadmsgnumreq) {
        Ticket localTicket;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2.trim()) && (localTicket = wtloginManager.getLocalTicket(str, 16L, 64)) != null && j3 <= localTicket._expire_time) {
                long parseLong = Long.parseLong(str);
                msg_svc$PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo thirdQQReqInfo = new msg_svc$PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo();
                thirdQQReqInfo.third_uin.set(parseLong);
                thirdQQReqInfo.third_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes(str2)));
                byte[] thirdQQUnreadNumReqCookie = ((ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, "")).getThirdQQUnreadNumReqCookie(this.f116342a, str);
                if (thirdQQUnreadNumReqCookie != null) {
                    thirdQQReqInfo.third_uin_cookie.set(ByteStringMicro.copyFrom(thirdQQUnreadNumReqCookie));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getThirdQQUnreadMsgNum_PB third uin = " + str);
                }
                msg_svc_pbthirdqqunreadmsgnumreq.thirdqq_req_info.add(thirdQQReqInfo);
            }
        } catch (NumberFormatException e16) {
            QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 1, "getThirdQQUnreadMsgNum_PB error " + e16.getMessage());
        }
    }

    private boolean q1(com.tencent.mobileqq.subaccount.logic.a aVar, long j3) {
        if (j3 != -1) {
            return false;
        }
        l(8003, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "12014");
        hashMap.put(ISubAccountControlService.FAIL_STEP, "selfUin_null");
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, hashMap, "");
        return true;
    }

    private void r1(ArrayList<SimpleAccount> arrayList, TicketManager ticketManager, WtloginManager wtloginManager, long j3, msg_svc$PbThirdQQUnReadMsgNumReq msg_svc_pbthirdqqunreadmsgnumreq, CountDownLatch countDownLatch) {
        Iterator<SimpleAccount> it = arrayList.iterator();
        while (it.hasNext()) {
            SimpleAccount next = it.next();
            if (next != null) {
                String uin = next.getUin();
                if (ticketManager.useAsyncTicketInterface()) {
                    try {
                        ticketManager.getA2(Long.parseLong(uin), 16, new c(uin, wtloginManager, j3, msg_svc_pbthirdqqunreadmsgnumreq, countDownLatch));
                    } catch (NumberFormatException unused) {
                        QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 1, "parseLong error" + uin);
                        countDownLatch.countDown();
                    }
                } else {
                    String a26 = ticketManager.getA2(uin);
                    countDownLatch.countDown();
                    p1(uin, a26, wtloginManager, j3, msg_svc_pbthirdqqunreadmsgnumreq);
                }
            }
        }
    }

    private boolean s1(com.tencent.mobileqq.subaccount.logic.a aVar, String str) {
        if (str != null) {
            return false;
        }
        l(8003, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "12014");
        hashMap.put(ISubAccountControlService.FAIL_STEP, "backuin_null");
        hashMap.put(ISubAccountControlService.FAIL_LOCATION, BaseMessageHandler.TAG);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, hashMap, "");
        return true;
    }

    private boolean u1(int i3) {
        if (i3 != 1200 && i3 != 1214 && i3 != 1215 && i3 != 1218 && i3 != 1232 && i3 != 1233 && i3 != 1240 && i3 != 1241 && i3 != 1242 && i3 != 1221) {
            return false;
        }
        return true;
    }

    private boolean v1(msg_comm$MsgHead msg_comm_msghead, int i3, int i16) {
        if (s.i(i3) && msg_comm_msghead.c2c_cmd.has() && (i16 == 169 || i16 == 241 || i16 == 242 || i16 == 243 || i16 == 129 || i16 == 131 || i16 == 133)) {
            return true;
        }
        return false;
    }

    private boolean w1(List<MessageRecord> list) {
        int i3;
        if (list == null || list.size() <= 0 || ((i3 = list.get(0).istroop) != 1033 && i3 != 1034)) {
            return false;
        }
        return true;
    }

    private boolean x1(int i3) {
        if (i3 != 129 && i3 != 131 && i3 != 133 && i3 != 135 && i3 != 243) {
            return false;
        }
        return true;
    }

    private void y1(com.tencent.mobileqq.subaccount.logic.a aVar, String str, msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp, ISubAccountService iSubAccountService, int i3) {
        aVar.f291121a = 1004;
        aVar.f291129i = i3;
        aVar.f291122b = msg_svc_pbgetmsgresp.errmsg.get();
        aVar.f291132l = true;
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, "");
        iSubAccountControlService.setBindUinStatus(this.f116342a, (byte) 0, str);
        iSubAccountControlService.bindRecentItem(this.f116342a, str, 6);
        aVar.f291133m = true;
        iSubAccountService.updateA2(str, null, true);
        boolean status = iSubAccountService.setStatus(str, 3);
        iSubAccountService.updateServerError(str, i3, msg_svc_pbgetmsgresp.errmsg.get());
        iSubAccountService.clearUnreadNum(str);
        if (status) {
            int unreadCount = 1 - ((IConversationFacade) this.f116342a.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(str, 7000);
            if (unreadCount != 0) {
                ((IConversationFacade) this.f116342a.getRuntimeService(IConversationFacade.class, "")).increaseUnread(str, 7000, unreadCount);
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, str});
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "processSubAccountMessage() hint need to verify,msg num=1, subUin=" + str);
            }
        }
        this.f116342a.updateSubAccountLogin(str, false);
        this.f116342a.getApplication().refreAccountList();
    }

    private void z1(String str, ISubAccountService iSubAccountService, boolean z16, long j3, List<SubAccountMessage> list, ArrayList<String> arrayList, HashMap<String, Integer> hashMap) {
        String str2;
        boolean z17;
        int removeMessage;
        if (list != null && list.size() > 0 && z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                SubAccountMessage subAccountMessage = list.get(i3);
                if (subAccountMessage != null && (str2 = subAccountMessage.frienduin) != null && !str2.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN)) && !subAccountMessage.frienduin.equals(String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE))) {
                    Iterator<String> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (next != null && subAccountMessage.frienduin.equalsIgnoreCase(next)) {
                                z17 = true;
                                break;
                            }
                        } else {
                            z17 = false;
                            break;
                        }
                    }
                    if (z17 && hashMap.containsKey(subAccountMessage.frienduin) && iSubAccountService != null) {
                        AppInterface appInterface = this.f116342a;
                        String valueOf = String.valueOf(j3);
                        String str3 = subAccountMessage.frienduin;
                        iSubAccountService.updateUnreadNum(appInterface, valueOf, str3, hashMap.get(str3).intValue());
                    }
                    if (!z17 && iSubAccountService != null && (removeMessage = iSubAccountService.removeMessage(String.valueOf(j3), subAccountMessage.frienduin)) != 0) {
                        ((IConversationFacade) this.f116342a.getRuntimeService(IConversationFacade.class, "")).increaseUnread(str, 7000, removeMessage);
                        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, str});
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void Y0(String str, String str2) {
        long j3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + str);
        }
        try {
            j3 = Long.parseLong(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = 0;
        }
        if (j3 <= 10000) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + j3);
                return;
            }
            return;
        }
        ISubAccountService iSubAccountService = (ISubAccountService) this.f116342a.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            bArr = iSubAccountService.getCookie(str);
        } else {
            bArr = null;
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("PbMessageSvc.PbBindUinMsgReadedConfirm");
        createToServiceMsg.extraData.putBoolean("isSubAccount", true);
        createToServiceMsg.extraData.putString("subAccount", str);
        createToServiceMsg.extraData.putString("nextAction", str2);
        msg_svc$PbBindUinMsgReadedConfirmReq msg_svc_pbbinduinmsgreadedconfirmreq = new msg_svc$PbBindUinMsgReadedConfirmReq();
        msg_svc_pbbinduinmsgreadedconfirmreq.bind_uin.set(j3);
        if (bArr != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(bArr.length));
            }
            msg_svc_pbbinduinmsgreadedconfirmreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
        } else if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
        }
        createToServiceMsg.putWupBuffer(msg_svc_pbbinduinmsgreadedconfirmreq.toByteArray());
        this.f116343b.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void Z0(byte b16, int i3, String str, String str2, ArrayList<String> arrayList) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Byte.valueOf(b16), Integer.valueOf(i3), str, str2, arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + str);
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("MessageSvc.PbBindUinGetMsg");
        createToServiceMsg.extraData.putByte("cChannel", b16);
        createToServiceMsg.extraData.putInt("cSyncFlag", i3);
        createToServiceMsg.extraData.putBoolean("isSubAccount", true);
        createToServiceMsg.extraData.putString("subAccount", str);
        createToServiceMsg.extraData.putString("subaccount_a2", str2);
        if (arrayList != null && arrayList.size() > 0) {
            createToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", arrayList);
        }
        ISubAccountService iSubAccountService = (ISubAccountService) this.f116342a.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            bArr = iSubAccountService.getCookie(str);
        } else {
            bArr = null;
        }
        msg_svc$PbBindUinGetMsgReq msg_svc_pbbinduingetmsgreq = new msg_svc$PbBindUinGetMsgReq();
        if (str != null) {
            try {
                msg_svc_pbbinduingetmsgreq.bind_uin.set(Long.parseLong(str));
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
                }
            }
        }
        if (str2 != null) {
            try {
                msg_svc_pbbinduingetmsgreq.bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes(str2)));
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (bArr != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + bArr.length);
            }
            msg_svc_pbbinduingetmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(bArr));
        } else if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
        }
        msg_svc_pbbinduingetmsgreq.sync_flag.set(i3);
        createToServiceMsg.putWupBuffer(msg_svc_pbbinduingetmsgreq.toByteArray());
        this.f116343b.sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.message.a
    public boolean a1(SubAccountInfo subAccountInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) subAccountInfo)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList()");
        }
        if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin)) {
            Oidb_0x5d0$ReqBody oidb_0x5d0$ReqBody = new Oidb_0x5d0$ReqBody();
            ArrayList arrayList = new ArrayList();
            arrayList.add(9);
            oidb_0x5d0$ReqBody.rpt_uint32_fieldlist.set(arrayList);
            ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) this.f116342a.getRuntimeService(ISubAccountControlService.class, "");
            PBUInt32Field pBUInt32Field = oidb_0x5d0$ReqBody.uint32_start_time;
            AppInterface appInterface = this.f116342a;
            pBUInt32Field.set(iSubAccountControlService.getReqSubAccountSpecialCareListSysTime(appInterface, appInterface.getCurrentUin(), subAccountInfo.subuin));
            try {
                oidb_0x5d0$ReqBody.uint64_bind_uin.set(Long.parseLong(subAccountInfo.subuin));
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(1488);
                oidb_sso_oidbssopkg.uint32_result.set(0);
                oidb_sso_oidbssopkg.uint32_service_type.set(1);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d0$ReqBody.toByteArray()));
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList() uin = " + subAccountInfo.subuin);
                }
                ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("OidbSvc.0x5d0_1");
                createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
                createToServiceMsg.setTimeout(60000L);
                createToServiceMsg.addAttribute("from_where", "subaccount");
                createToServiceMsg.addAttribute("subaccount", subAccountInfo.subuin);
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList() before send request = " + createToServiceMsg);
                }
                this.f116343b.sendPbReq(createToServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList() after send request = " + createToServiceMsg);
                }
                return true;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getSubAccountSpecialCareList subAccount parselong error ");
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void b1(boolean z16, ArrayList<SimpleAccount> arrayList) {
        CountDownLatch countDownLatch;
        msg_svc$PbThirdQQUnReadMsgNumReq msg_svc_pbthirdqqunreadmsgnumreq;
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getThirdQQUnreadMsgNum_PB isCronJob = ");
            sb5.append(z16);
            sb5.append(" thirdAccount size = ");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, sb5.toString());
        }
        if (arrayList != null && arrayList.size() != 0) {
            TicketManager ticketManager = (TicketManager) this.f116342a.getManager(2);
            WtloginManager wtloginManager = (WtloginManager) this.f116342a.getManager(1);
            msg_svc$PbUnReadMsgSeqReq msg_svc_pbunreadmsgseqreq = new msg_svc$PbUnReadMsgSeqReq();
            msg_svc$PbThirdQQUnReadMsgNumReq msg_svc_pbthirdqqunreadmsgnumreq2 = new msg_svc$PbThirdQQUnReadMsgNumReq();
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            CountDownLatch countDownLatch2 = new CountDownLatch(arrayList.size());
            if (ticketManager != null && wtloginManager != null) {
                countDownLatch = countDownLatch2;
                msg_svc_pbthirdqqunreadmsgnumreq = msg_svc_pbthirdqqunreadmsgnumreq2;
                r1(arrayList, ticketManager, wtloginManager, K0, msg_svc_pbthirdqqunreadmsgnumreq2, countDownLatch);
            } else {
                countDownLatch = countDownLatch2;
                msg_svc_pbthirdqqunreadmsgnumreq = msg_svc_pbthirdqqunreadmsgnumreq2;
            }
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 1, "getA2 latch await timeout.");
            }
            if (msg_svc_pbthirdqqunreadmsgnumreq.thirdqq_req_info.has() && msg_svc_pbthirdqqunreadmsgnumreq.thirdqq_req_info.get() != null && msg_svc_pbthirdqqunreadmsgnumreq.thirdqq_req_info.get().size() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getThirdQQUnreadMsgNum_PB really send msg to service");
                }
                PBUInt32Field pBUInt32Field = msg_svc_pbthirdqqunreadmsgnumreq.source;
                if (!z16) {
                    i3 = 2;
                }
                pBUInt32Field.set(i3);
                msg_svc_pbunreadmsgseqreq.thirdqq_unread_info.set(msg_svc_pbthirdqqunreadmsgnumreq);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f116342a.getCurrentUin(), BaseConstants.CMD_MSG_UNREAD_MSG_SEQ);
                toServiceMsg.extraData.putString("action", ISubAccountControlService.ACT_GET_THIRD_QQ_UNREAD_NUM);
                toServiceMsg.extraData.putString("mainAccount", this.f116342a.getAccount());
                toServiceMsg.putWupBuffer(msg_svc_pbunreadmsgseqreq.toByteArray());
                this.f116343b.sendPbReq(toServiceMsg);
                return;
            }
            com.tencent.mobileqq.subaccount.logic.b bVar = new com.tencent.mobileqq.subaccount.logic.b();
            bVar.f291134a = this.f116342a.getAccount();
            if (QLog.isColorLevel()) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getThirdQQUnreadMsgNum_PB error no third qq info");
            }
            this.f116343b.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM, false, bVar);
            return;
        }
        com.tencent.mobileqq.subaccount.logic.b bVar2 = new com.tencent.mobileqq.subaccount.logic.b();
        bVar2.f291134a = this.f116342a.getAccount();
        if (QLog.isColorLevel()) {
            QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "getThirdQQUnreadMsgNum_PB error no third account");
        }
        this.f116343b.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM, false, bVar2);
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void c1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumError");
        }
        com.tencent.mobileqq.subaccount.logic.b bVar = new com.tencent.mobileqq.subaccount.logic.b();
        bVar.f291134a = this.f116342a.getAccount();
        this.f116343b.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM, false, bVar);
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void d1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        m mVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            c1(toServiceMsg, fromServiceMsg);
            return;
        }
        try {
            msg_svc$PbUnReadMsgSeqResp mergeFrom = new msg_svc$PbUnReadMsgSeqResp().mergeFrom((byte[]) obj);
            if (mergeFrom.thirdqq_unread_info.has() && mergeFrom.thirdqq_unread_info.get() != null) {
                msg_svc$PbThirdQQUnReadMsgNumResp msg_svc_pbthirdqqunreadmsgnumresp = mergeFrom.thirdqq_unread_info.get();
                if (msg_svc_pbthirdqqunreadmsgnumresp.result.get() == 0 && msg_svc_pbthirdqqunreadmsgnumresp.thirdqq_resp_info.get() != null) {
                    com.tencent.mobileqq.subaccount.logic.b bVar = new com.tencent.mobileqq.subaccount.logic.b();
                    int i3 = msg_svc_pbthirdqqunreadmsgnumresp.result.get();
                    String str = msg_svc_pbthirdqqunreadmsgnumresp.errmsg.get();
                    int i16 = msg_svc_pbthirdqqunreadmsgnumresp.interval.get();
                    bVar.f291138e = i16;
                    bVar.f291136c = str;
                    bVar.f291137d = i3;
                    String string = toServiceMsg.extraData.getString("mainAccount");
                    bVar.f291134a = string;
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumResp_PB: result  interval=" + i16 + " errmsg=" + str + " result=" + i3);
                    }
                    long K0 = com.tencent.mobileqq.service.message.e.K0();
                    ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) mVar.f116342a.getRuntimeService(ISubAccountControlService.class, "");
                    int i17 = 0;
                    while (i17 < msg_svc_pbthirdqqunreadmsgnumresp.thirdqq_resp_info.get().size()) {
                        msg_svc$PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo thirdQQRespInfo = msg_svc_pbthirdqqunreadmsgnumresp.thirdqq_resp_info.get().get(i17);
                        String valueOf = String.valueOf(thirdQQRespInfo.third_uin.get());
                        byte[] byteArray = thirdQQRespInfo.third_uin_cookie.get().toByteArray();
                        int i18 = thirdQQRespInfo.msg_num.get();
                        int i19 = thirdQQRespInfo.msg_flag.get();
                        int i26 = thirdQQRespInfo.redbag_time.get();
                        int i27 = i17;
                        int i28 = thirdQQRespInfo.status.get();
                        int i29 = thirdQQRespInfo.last_msg_time.get();
                        msg_svc$PbThirdQQUnReadMsgNumResp msg_svc_pbthirdqqunreadmsgnumresp2 = msg_svc_pbthirdqqunreadmsgnumresp;
                        int i36 = i16;
                        if (bVar.f291139f < i29 && i29 <= K0) {
                            bVar.f291139f = i29;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumResp_PB: thirdUin=" + valueOf + " num=" + i18 + " flag=" + i19 + " redbagtime=" + i26 + " status=" + i28 + " lastmsgtime=" + i29 + "  cookie=" + byteArray);
                        }
                        iSubAccountControlService.storeThirdQQUnreadInfo(string, valueOf, byteArray, i18, i19, i26, i28, i29);
                        i17 = i27 + 1;
                        mVar = this;
                        i16 = i36;
                        msg_svc_pbthirdqqunreadmsgnumresp = msg_svc_pbthirdqqunreadmsgnumresp2;
                    }
                    m mVar2 = mVar;
                    iSubAccountControlService.storeThirdQQUnreadMsgNumInterval(mVar2.f116342a, string, i16);
                    mVar2.f116343b.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM, true, bVar);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumResp_PB unreadNumSeqResp.result: " + msg_svc_pbthirdqqunreadmsgnumresp.result.get() + " ,unreadNumSeqResp.errmsg: " + msg_svc_pbthirdqqunreadmsgnumresp.errmsg.get() + " or thirdqq_resp_info is null");
                }
                c1(toServiceMsg, fromServiceMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return thirdqq_unread_info");
            }
            c1(toServiceMsg, fromServiceMsg);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return a valid response");
            }
            c1(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void e1(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "handleGetThirdQQUnreadMsgNumTimeOut");
        }
        com.tencent.mobileqq.subaccount.logic.b bVar = new com.tencent.mobileqq.subaccount.logic.b();
        bVar.f291134a = this.f116342a.getAccount();
        bVar.f291135b = 1;
        this.f116343b.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM, false, bVar);
    }

    @Override // com.tencent.mobileqq.app.message.a
    public void f1(RequestPushNotify requestPushNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) requestPushNotify);
        } else if (528 == requestPushNotify.stMsgInfo.shMsgType) {
            ((ISubAccountMessageProcessorHelper) QRoute.api(ISubAccountMessageProcessorHelper.class)).processSubAccountRevokeNotify(this.f116342a, requestPushNotify);
        }
    }

    @Override // com.tencent.imcore.message.i, com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "SubAccountMessageProcessor processError");
        }
        if (i3 == 4001) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
            }
            com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
            String string = toServiceMsg.extraData.getString("subAccount");
            aVar.f291123c = toServiceMsg.getUin();
            aVar.f291124d = string;
            aVar.f291121a = 1001;
            l(8003, false, aVar);
        }
    }

    @Override // com.tencent.imcore.message.i, com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "SubAccountMessageProcessor processResponse");
        }
        switch (i3) {
            case 4001:
                if (objArr != null && objArr.length == 3) {
                    C1((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 4002:
                if (objArr != null && objArr.length == 3) {
                    n1((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 4003:
                if (objArr != null && objArr.length == 3) {
                    o1((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount cmd=CMD_MESSAGESERVICE_SUBACCOUNT_SPECIAL_CARE GetSubAccountSpecialCare error");
                        return;
                    }
                    return;
                }
            case 4004:
                if (((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                    return;
                }
                if (objArr != null && objArr.length == 3) {
                    D1((msg_comm$Msg) objArr[0], (FromServiceMsg) objArr[1], (msg_onlinepush$PbPushMsg) objArr[2]);
                    return;
                } else {
                    t1(getClass().getName(), i3);
                    return;
                }
            default:
                return;
        }
    }

    public void t1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount handleGetSubAccountTroop error");
        }
    }

    @Override // com.tencent.imcore.message.i, com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "SubAccountMessageProcessor processTimeOut");
        }
        if (i3 == 4001) {
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountMessageProcessor_SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
            }
            com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
            String string = toServiceMsg.extraData.getString("subAccount");
            aVar.f291123c = toServiceMsg.getUin();
            aVar.f291124d = string;
            aVar.f291121a = 1007;
            l(8003, false, aVar);
        }
    }
}
