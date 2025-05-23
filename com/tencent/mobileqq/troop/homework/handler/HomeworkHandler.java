package com.tencent.mobileqq.troop.homework.handler;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.homework.b;
import com.tencent.protofile.group_homework.value$HomeworkInfo;
import com.tencent.protofile.homework.hw_assign_homework$RspAssignHomework;
import com.tencent.protofile.homework.hw_get_homework_info$ReqGetHomeworkInfo;
import com.tencent.protofile.homework.hw_get_homework_info$RspGetHomeworkInfo;
import com.tencent.protofile.homework.hw_submit_homework$HwCommentInfo;
import com.tencent.protofile.homework.hw_submit_homework$ReqSubmitHomework;
import com.tencent.protofile.homework.hw_submit_homework$RspSubmitHomework;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xb14.oidb_0xb14$ReqBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14$RspBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14$UserInfo;
import tencent.im.troop.homework$ReqSend1V1Msg;
import tencent.im.troop.homework$RspSend1V1Msg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HomeworkHandler extends TroopBaseHandler implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f297082e;

    public HomeworkHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "handleAssignHomework");
        }
        String str2 = null;
        if (toServiceMsg != null && fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            long j3 = -1;
            if (resultCode == 1000) {
                hw_assign_homework$RspAssignHomework hw_assign_homework_rspassignhomework = new hw_assign_homework$RspAssignHomework();
                i3 = -1;
                try {
                    hw_assign_homework_rspassignhomework.mergeFrom((byte[]) obj);
                    if (hw_assign_homework_rspassignhomework.errinfo.has()) {
                        if (hw_assign_homework_rspassignhomework.errinfo.get().error_code.has()) {
                            i3 = hw_assign_homework_rspassignhomework.errinfo.get().error_code.get();
                        }
                        if (hw_assign_homework_rspassignhomework.errinfo.get().error_desc.has()) {
                            str = hw_assign_homework_rspassignhomework.errinfo.get().error_desc.get().toStringUtf8();
                        } else {
                            str = "";
                        }
                        str2 = str;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    i16 = i3;
                    z17 = false;
                }
                if (i3 == 0) {
                    try {
                        if (hw_assign_homework_rspassignhomework.hw_id.has()) {
                            j3 = hw_assign_homework_rspassignhomework.hw_id.get();
                        }
                        z16 = true;
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e = e17;
                        i16 = i3;
                        z17 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d("HomeworkHandler", 2, "handleAssignHomework: RspBody parseFrom byte InvalidProtocolBufferMicroException");
                        }
                        e.printStackTrace();
                        z16 = z17;
                        i3 = i16;
                        notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297334f, z16, new Object[]{Long.valueOf(j3), Integer.valueOf(i3)});
                        if (QLog.isColorLevel()) {
                        }
                    }
                    notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297334f, z16, new Object[]{Long.valueOf(j3), Integer.valueOf(i3)});
                    if (QLog.isColorLevel()) {
                        QLog.d("HomeworkHandler", 2, "handleAssignHomework.errCode:" + i3 + "\u3000erroDesc:" + str2 + ",homeworkID:" + j3 + ",isSuccess:" + z16);
                        return;
                    }
                    return;
                }
            } else {
                i3 = resultCode;
            }
            z16 = false;
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297334f, z16, new Object[]{Long.valueOf(j3), Integer.valueOf(i3)});
            if (QLog.isColorLevel()) {
            }
        } else {
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297334f, false, null);
            if (QLog.isColorLevel()) {
                QLog.d("HomeworkHandler", 2, "handleAssignHomework: req == null || resp == null");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        String str;
        value$HomeworkInfo value_homeworkinfo;
        String str2;
        String str3;
        int i3;
        boolean z18;
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo");
        }
        String str4 = null;
        if (toServiceMsg != null && fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            com.tencent.mobileqq.troop.homework.a aVar = new com.tencent.mobileqq.troop.homework.a();
            int i16 = -1;
            if (resultCode == 1000) {
                hw_get_homework_info$RspGetHomeworkInfo hw_get_homework_info_rspgethomeworkinfo = new hw_get_homework_info$RspGetHomeworkInfo();
                try {
                    hw_get_homework_info_rspgethomeworkinfo.mergeFrom((byte[]) obj);
                    if (hw_get_homework_info_rspgethomeworkinfo.errinfo.has()) {
                        if (hw_get_homework_info_rspgethomeworkinfo.errinfo.get().error_code.has()) {
                            i16 = hw_get_homework_info_rspgethomeworkinfo.errinfo.get().error_code.get();
                        }
                        if (hw_get_homework_info_rspgethomeworkinfo.errinfo.get().error_desc.has()) {
                            str = hw_get_homework_info_rspgethomeworkinfo.errinfo.get().error_desc.get().toStringUtf8();
                        } else {
                            str = "";
                        }
                    } else {
                        str = null;
                    }
                    if (i16 == 0) {
                        try {
                            if (hw_get_homework_info_rspgethomeworkinfo.info.has()) {
                                value_homeworkinfo = hw_get_homework_info_rspgethomeworkinfo.info.get();
                            } else {
                                value_homeworkinfo = null;
                            }
                            if (value_homeworkinfo != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo: homeworkInfo: " + value_homeworkinfo.toString());
                                }
                                if (value_homeworkinfo.content.has()) {
                                    str2 = value_homeworkinfo.content.get().toStringUtf8();
                                } else {
                                    str2 = null;
                                }
                                aVar.f296263d = str2;
                                if (value_homeworkinfo.title.has()) {
                                    str3 = value_homeworkinfo.title.get();
                                } else {
                                    str3 = null;
                                }
                                aVar.f296262c = str3;
                                if (value_homeworkinfo.course_name.has()) {
                                    str4 = value_homeworkinfo.course_name.get();
                                }
                                aVar.f296266g = str4;
                                if (value_homeworkinfo.course_id.has()) {
                                    i3 = value_homeworkinfo.course_id.get();
                                } else {
                                    i3 = 0;
                                }
                                aVar.f296267h = i3;
                                if (value_homeworkinfo.need_feedback.has()) {
                                    z18 = value_homeworkinfo.need_feedback.get();
                                } else {
                                    z18 = false;
                                }
                                aVar.f296265f = z18;
                                if (value_homeworkinfo.feedback_ts.has()) {
                                    j3 = value_homeworkinfo.feedback_ts.get();
                                } else {
                                    j3 = 0;
                                }
                                aVar.f296268i = j3;
                                if (value_homeworkinfo.syncgids.has()) {
                                    ArrayList arrayList = new ArrayList();
                                    aVar.f296269j = arrayList;
                                    arrayList.addAll(value_homeworkinfo.syncgids.get());
                                }
                            }
                            z16 = true;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            str4 = str;
                            z17 = true;
                            if (QLog.isColorLevel()) {
                                QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo: RspBody parseFrom byte InvalidProtocolBufferMicroException");
                            }
                            e.printStackTrace();
                            z16 = z17;
                            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297335h, z16, new Object[]{aVar});
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        z16 = false;
                    }
                    str4 = str;
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                    z17 = false;
                }
            } else {
                z16 = false;
            }
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297335h, z16, new Object[]{aVar});
            if (!QLog.isColorLevel()) {
                QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo.errCode:" + i16 + "\u3000erroDesc:" + str4 + ",hwInfo:" + aVar);
                return;
            }
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297335h, false, null);
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "handleGetHomeworkInfo: req == null || resp == null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "handleSubmitHomework");
        }
        String str2 = null;
        boolean z16 = false;
        if (toServiceMsg != null && fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            int i16 = -1;
            if (resultCode == 1000) {
                hw_submit_homework$RspSubmitHomework hw_submit_homework_rspsubmithomework = new hw_submit_homework$RspSubmitHomework();
                try {
                    hw_submit_homework_rspsubmithomework.mergeFrom((byte[]) obj);
                    if (hw_submit_homework_rspsubmithomework.errinfo.has()) {
                        if (hw_submit_homework_rspsubmithomework.errinfo.get().error_code.has()) {
                            i3 = hw_submit_homework_rspsubmithomework.errinfo.get().error_code.get();
                        } else {
                            i3 = -1;
                        }
                        try {
                            if (hw_submit_homework_rspsubmithomework.errinfo.get().error_desc.has()) {
                                str = hw_submit_homework_rspsubmithomework.errinfo.get().error_desc.get().toStringUtf8();
                            } else {
                                str = "";
                            }
                            str2 = str;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d("HomeworkHandler", 2, "handleSubmitHomework: RspBody parseFrom byte InvalidProtocolBufferMicroException");
                            }
                            e.printStackTrace();
                            resultCode = i3;
                            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297336i, z16, Integer.valueOf(resultCode));
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        i3 = -1;
                    }
                    if (i3 == 0) {
                        z16 = true;
                    }
                    if (hw_submit_homework_rspsubmithomework.status.has()) {
                        i16 = hw_submit_homework_rspsubmithomework.status.get();
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                    i3 = -1;
                }
                resultCode = i3;
            }
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297336i, z16, Integer.valueOf(resultCode));
            if (!QLog.isColorLevel()) {
                QLog.d("HomeworkHandler", 2, "handleSubmitHomework.errCode:" + resultCode + "\u3000erroDesc:" + str2 + ",status:" + i16);
                return;
            }
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297336i, false, null);
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "handleSubmitHomework: req == null || resp == null");
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        homework$RspSend1V1Msg homework_rspsend1v1msg = new homework$RspSend1V1Msg();
        homework$ReqSend1V1Msg homework_reqsend1v1msg = new homework$ReqSend1V1Msg();
        if (fromServiceMsg.isSuccess() && obj != null) {
            try {
                homework_rspsend1v1msg.mergeFrom((byte[]) obj);
                byte[] bArr = new byte[r9.getInt() - 4];
                ByteBuffer.wrap(toServiceMsg.getWupBuffer()).get(bArr);
                homework_reqsend1v1msg.mergeFrom(bArr);
                notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297337m, true, new Object[]{homework_rspsend1v1msg, homework_reqsend1v1msg});
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(".troop.troopManagerHomeworkHandler", 2, "handleTroopBulkSendMessageRespond", e16);
                notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297337m, false, new Object[]{null, null});
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troopManagerHomeworkHandler", 2, "handleTroopBulkSendMessageRespond failed, no response, error=", fromServiceMsg.getBusinessFailMsg());
        }
        notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297337m, false, new Object[]{null, null});
    }

    public void F2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "getHomeworkInfo homeworkID = " + j3);
        }
        hw_get_homework_info$ReqGetHomeworkInfo hw_get_homework_info_reqgethomeworkinfo = new hw_get_homework_info$ReqGetHomeworkInfo();
        hw_get_homework_info_reqgethomeworkinfo.hw_id.set(j3);
        ToServiceMsg createToServiceMsg = createToServiceMsg("HwSvc.get_homework_info");
        createToServiceMsg.putWupBuffer(hw_get_homework_info_reqgethomeworkinfo.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        try {
            oidb_0xb14$RspBody oidb_0xb14_rspbody = new oidb_0xb14$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xb14_rspbody);
            if (parseOIDBPkg == 0) {
                String valueOf = String.valueOf(oidb_0xb14_rspbody.group_id.get());
                List<oidb_0xb14$UserInfo> list = oidb_0xb14_rspbody.infos.get();
                if (list != null && !list.isEmpty()) {
                    String valueOf2 = String.valueOf(list.get(0).uin.get());
                    int i3 = list.get(0).f435983id.get();
                    String str = list.get(0).course.get();
                    String str2 = list.get(0).name.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("HomeworkHandler", 2, "handleGetHomeworkTroopIdentity. troopUin=", valueOf, ", memberUin=", valueOf2, ", identity=", Integer.valueOf(i3), ", course=", str, ", name=", str2);
                    }
                    ((IBizTroopMemberInfoService) this.appRuntime.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(valueOf, valueOf2, null, i3, str, str2);
                    notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297333e, true, new Object[]{valueOf, valueOf2, Integer.valueOf(i3), str, str2});
                    return;
                }
                return;
            }
            QLog.e("HomeworkHandler", 1, "handleGetHomeworkTroopIdentity failed! retCode = ", Integer.valueOf(parseOIDBPkg));
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297333e, false, new Object[]{"", "", 0, "", ""});
        } catch (Exception e16) {
            QLog.e("HomeworkHandler", 1, "handleGetHomeworkTroopIdentity exception. e=", e16);
            notifyUI(com.tencent.mobileqq.troop.homework.observer.a.f297333e, false, new Object[]{"", "", 0, "", ""});
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.b
    public void L(@NonNull homework$ReqSend1V1Msg homework_reqsend1v1msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) homework_reqsend1v1msg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(".troop.troopManagerHomeworkHandler", 2, "sendTroopBulkSendMessageRequest");
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("HwSvc.send_msg");
        createToServiceMsg.putWupBuffer(homework_reqsend1v1msg.toByteArray());
        E2(createToServiceMsg);
    }

    public void L2(long j3, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "submitHomework  homeworkID = " + j3 + ",troopUin = " + j16 + ",content = " + str);
        }
        hw_submit_homework$ReqSubmitHomework hw_submit_homework_reqsubmithomework = new hw_submit_homework$ReqSubmitHomework();
        hw_submit_homework_reqsubmithomework.hw_id.set(j3);
        hw_submit_homework_reqsubmithomework.gid.set(j16);
        hw_submit_homework_reqsubmithomework.status.set(2);
        hw_submit_homework$HwCommentInfo hw_submit_homework_hwcommentinfo = new hw_submit_homework$HwCommentInfo();
        hw_submit_homework_hwcommentinfo.text.set(ByteStringMicro.copyFromUtf8(str));
        hw_submit_homework_reqsubmithomework.comment_info.set(hw_submit_homework_hwcommentinfo);
        ToServiceMsg createToServiceMsg = createToServiceMsg("HwSvc.submit_homework");
        createToServiceMsg.putWupBuffer(hw_submit_homework_reqsubmithomework.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f297082e == null) {
            HashSet hashSet = new HashSet();
            this.f297082e = hashSet;
            hashSet.add("OidbSvc.0xb14");
            this.f297082e.add("HwSvc.get_homework_info");
            this.f297082e.add("HwSvc.submit_homework");
            this.f297082e.add("HwSvc.assign_homework");
            this.f297082e.add("HwSvc.send_msg");
        }
        return this.f297082e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HomeworkHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.troop.homework.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("HomeworkHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("HomeworkHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xb14".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("HwSvc.get_homework_info".equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("HwSvc.submit_homework".equals(fromServiceMsg.getServiceCmd())) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("HwSvc.assign_homework".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("HwSvc.send_msg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                    K2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.b
    public void w2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HomeworkHandler", 2, "getHomeworkTroopIdentity. troopUin = ", str, ", uin = ", str2);
        }
        try {
            oidb_0xb14$ReqBody oidb_0xb14_reqbody = new oidb_0xb14$ReqBody();
            oidb_0xb14_reqbody.type.set(1);
            oidb_0xb14_reqbody.group_id.set(Long.parseLong(str));
            oidb_0xb14_reqbody.uins.set(Collections.singletonList(Long.valueOf(Long.parseLong(str2))));
            sendPbReq(makeOIDBPkg("OidbSvc.0xb14", 2836, 0, oidb_0xb14_reqbody.toByteArray()));
        } catch (NumberFormatException unused) {
        }
    }
}
