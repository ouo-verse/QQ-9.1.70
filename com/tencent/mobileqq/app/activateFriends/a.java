package com.tencent.mobileqq.app.activateFriends;

import QTimedMessage.QTimedMessage$C2CMessage;
import QTimedMessage.QTimedMessage$Client;
import QTimedMessage.QTimedMessage$Content;
import QTimedMessage.QTimedMessage$Message;
import QTimedMessage.QTimedMessage$Timer;
import QTimedMessage.QTimedMessage$User;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x75f.cmd0x75f$AddBatchReq;
import tencent.im.oidb.cmd0x75f.cmd0x75f$AddBatchRsp;
import tencent.im.oidb.cmd0x75f.cmd0x75f$ReqBody;
import tencent.im.oidb.cmd0x75f.cmd0x75f$RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9$ReqBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9$ReqHelloType;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9$RspBody;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9$RspHelloContent;
import tencent.im.oidb.cmd0x82a.cmd0x82a$MsgInfo;
import tencent.im.oidb.cmd0x82a.cmd0x82a$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends MSFServlet {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(Intent intent, Packet packet) {
        long[] longArrayExtra = intent.getLongArrayExtra("p_uin_list");
        long[] longArrayExtra2 = intent.getLongArrayExtra("p_time_list");
        String stringExtra = intent.getStringExtra("p_msg");
        int intExtra = intent.getIntExtra("p_gift_id", -1);
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "reqSendMessage | uin = " + Arrays.toString(longArrayExtra) + " | time = " + Arrays.toString(longArrayExtra2));
        }
        cmd0x75f$ReqBody cmd0x75f_reqbody = new cmd0x75f$ReqBody();
        long j3 = 1800000011;
        cmd0x75f_reqbody.uint64_appid.set(1800000011L);
        cmd0x75f_reqbody.uint32_subcmd.set(6);
        cmd0x75f$AddBatchReq cmd0x75f_addbatchreq = new cmd0x75f$AddBatchReq();
        ArrayList arrayList = new ArrayList(longArrayExtra.length);
        int i3 = 0;
        while (i3 < longArrayExtra.length) {
            QTimedMessage$Message qTimedMessage$Message = new QTimedMessage$Message();
            qTimedMessage$Message.uint64_appid.set(j3);
            QTimedMessage$User qTimedMessage$User = new QTimedMessage$User();
            qTimedMessage$User.enum_uin_type.set(3);
            cmd0x75f$AddBatchReq cmd0x75f_addbatchreq2 = cmd0x75f_addbatchreq;
            qTimedMessage$User.uint64_uin.set(getAppRuntime().getLongAccountUin());
            qTimedMessage$Message.msg_author.set(qTimedMessage$User);
            qTimedMessage$Message.uint32_main_type.set(100);
            qTimedMessage$Message.uint32_sub_type.set(1);
            qTimedMessage$Message.uint64_create_time.set(System.currentTimeMillis());
            QTimedMessage$Timer qTimedMessage$Timer = new QTimedMessage$Timer();
            int i16 = i3;
            qTimedMessage$Timer.uint64_time.set(longArrayExtra2[i3] * 1000);
            qTimedMessage$Message.msg_timer.set(qTimedMessage$Timer);
            QTimedMessage$Content qTimedMessage$Content = new QTimedMessage$Content();
            QTimedMessage$C2CMessage qTimedMessage$C2CMessage = new QTimedMessage$C2CMessage();
            QTimedMessage$User qTimedMessage$User2 = new QTimedMessage$User();
            qTimedMessage$User2.enum_uin_type.set(3);
            ArrayList arrayList2 = arrayList;
            qTimedMessage$User2.uint64_uin.set(getAppRuntime().getLongAccountUin());
            qTimedMessage$C2CMessage.msg_from_user.set(qTimedMessage$User2);
            QTimedMessage$User qTimedMessage$User3 = new QTimedMessage$User();
            qTimedMessage$User3.enum_uin_type.set(3);
            qTimedMessage$User3.uint64_uin.set(longArrayExtra[i16]);
            qTimedMessage$C2CMessage.msg_to_user.set(qTimedMessage$User3);
            QTimedMessage$Client qTimedMessage$Client = new QTimedMessage$Client();
            qTimedMessage$Client.uint32_Mobile.set(1);
            qTimedMessage$Client.uint32_PC.set(1);
            qTimedMessage$C2CMessage.msg_recv_client.set(qTimedMessage$Client);
            if (intExtra != -1) {
                QTimedMessage$C2CMessage.RichText richText = new QTimedMessage$C2CMessage.RichText();
                richText.uint32_service_id.set(51);
                richText.uint32_gift_id.set(intExtra);
                qTimedMessage$C2CMessage.msg_rich_text.set(richText);
                qTimedMessage$C2CMessage.uint32_send_rich_text_standalone.set(1);
                qTimedMessage$C2CMessage.bytes_text.set(ByteStringMicro.copyFrom(stringExtra.getBytes()));
                qTimedMessage$C2CMessage.uint32_send_text_standalone.set(1);
            } else {
                qTimedMessage$C2CMessage.bytes_text.set(ByteStringMicro.copyFrom(stringExtra.getBytes()));
                qTimedMessage$C2CMessage.uint32_send_text_standalone.set(1);
            }
            qTimedMessage$Content.msg_c2c_message.set(qTimedMessage$C2CMessage);
            qTimedMessage$Message.msg_content.set(qTimedMessage$Content);
            arrayList2.add(qTimedMessage$Message);
            i3 = i16 + 1;
            cmd0x75f_addbatchreq = cmd0x75f_addbatchreq2;
            arrayList = arrayList2;
            j3 = 1800000011;
        }
        cmd0x75f_addbatchreq.rpt_messages.set(arrayList);
        cmd0x75f_reqbody.msg_add_batch_req.set(cmd0x75f_addbatchreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1887);
        oidb_sso_oidbssopkg.uint32_service_type.set(3);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x75f_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        packet.setSSOCommand("OidbSvc.0x75f");
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(Intent intent, FromServiceMsg fromServiceMsg) {
        StringBuilder sb5;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = null;
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(1024);
            sb5.append("response.getResultCode()=");
            sb5.append(fromServiceMsg.getResultCode());
        } else {
            sb5 = null;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
            }
            try {
                byte[] bArr = new byte[r9.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", e);
                }
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                if (oidb_sso_oidbssopkg != null) {
                }
                if (sb5 == null) {
                }
            }
            if (oidb_sso_oidbssopkg != null) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (sb5 != null) {
                    sb5.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=");
                    sb5.append(i3);
                }
                if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    try {
                        cmd0x7c9$RspBody cmd0x7c9_rspbody = new cmd0x7c9$RspBody();
                        cmd0x7c9_rspbody.mergeFrom(byteArray);
                        if (cmd0x7c9_rspbody.rpt_hello_content.has()) {
                            ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) getAppRuntime().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
                            for (cmd0x7c9$RspHelloContent cmd0x7c9_rsphellocontent : cmd0x7c9_rspbody.rpt_hello_content.get()) {
                                int i16 = cmd0x7c9_rsphellocontent.uint32_next_time_gap.get();
                                int i17 = cmd0x7c9_rsphellocontent.uint32_req_type.get();
                                if (sb5 != null) {
                                    sb5.append(" type=");
                                    sb5.append(i17);
                                    sb5.append(" interval=");
                                    sb5.append(i16);
                                }
                                if (i17 == 1) {
                                    activateFriendsManager.F(i16 * 1000);
                                } else if (i17 == 2) {
                                    activateFriendsManager.G(i16 * 1000);
                                }
                            }
                        } else if (sb5 != null) {
                            sb5.append(" rspBody.rpt_hello_content hasno ");
                        }
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday|oidb_sso parseFrom byte", e18);
                        }
                    }
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "respGetBirthday | response.result = " + fromServiceMsg.getResultCode());
        }
        if (sb5 == null) {
            QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(Intent intent, FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        StringBuilder sb5 = new StringBuilder(1024);
        if (QLog.isColorLevel()) {
            sb5.append("activiate_friends|response.getResultCode()=");
            sb5.append(fromServiceMsg.getResultCode());
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = null;
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    byte[] bArr = new byte[r6.getInt() - 4];
                    ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivateFriends.Servlet", 2, "respSendReadedActivateFriends|oidb_sso parseFrom byte", e);
                    }
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                    if (oidb_sso_oidbssopkg != null) {
                    }
                    QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
            if (oidb_sso_oidbssopkg != null) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                sb5.append(" respSendReadedActivateFriends|oidb_sso.OIDBSSOPkg.result=");
                sb5.append(i3);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "respSendReadedActivateFriends | response.result = " + fromServiceMsg.getResultCode());
        }
        QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00da A[Catch: InvalidProtocolBufferMicroException -> 0x0149, TryCatch #0 {InvalidProtocolBufferMicroException -> 0x0149, blocks: (B:46:0x00b2, B:48:0x00da, B:50:0x00ee, B:60:0x012b, B:62:0x0131, B:53:0x00fa, B:55:0x011b), top: B:45:0x00b2, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(Intent intent, FromServiceMsg fromServiceMsg) {
        StringBuilder sb5;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        InvalidProtocolBufferMicroException e16;
        int i3;
        cmd0x75f$AddBatchRsp cmd0x75f_addbatchrsp;
        int i16;
        int i17;
        long[] longArray = intent.getExtras().getLongArray("p_uin_list");
        ArrayList arrayList = new ArrayList();
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) getAppRuntime().getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        Bundle bundle = new Bundle();
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(1024);
            sb5.append("rspSendMessage response.getResultCode()=");
            sb5.append(fromServiceMsg.getResultCode());
            sb5.append("send count = ");
            sb5.append(longArray.length);
        } else {
            sb5 = null;
        }
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            } catch (InvalidProtocolBufferMicroException e17) {
                oidb_sso_oidbssopkg = null;
                e16 = e17;
            }
            try {
                byte[] bArr = new byte[r4.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e18) {
                e16 = e18;
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Servlet", 2, "rspSendMessage|oidb_sso parseFrom byte", e16);
                }
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (sb5 != null) {
                }
                if (i3 != 0) {
                }
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                try {
                    cmd0x75f$RspBody cmd0x75f_rspbody = new cmd0x75f$RspBody();
                    cmd0x75f_rspbody.mergeFrom(byteArray);
                    byte[] bArr2 = new byte[r15.getInt() - 4];
                    ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr2);
                    cmd0x75f_rspbody.mergeFrom(bArr2);
                    cmd0x75f_addbatchrsp = cmd0x75f_rspbody.msg_add_batch_rsp.get();
                    if (sb5 != null) {
                    }
                    while (i16 < cmd0x75f_addbatchrsp.rpt_messages.get().size()) {
                    }
                } catch (InvalidProtocolBufferMicroException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivateFriends.Servlet", 2, "respSendTimingMsg erro ", e19);
                    }
                }
                if (arrayList.size() != longArray.length) {
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
                }
                if (i17 != 2) {
                }
                bundle.putInt("key_rt_type", i17);
                notifyObserver(intent, 113, true, bundle, b.class);
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (sb5 != null) {
                sb5.append(" respGetBirthday|oidb_sso.OIDBSSOPkg.result=");
                sb5.append(i3);
            }
            if ((i3 != 0 || i3 == 1401) && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                cmd0x75f$RspBody cmd0x75f_rspbody2 = new cmd0x75f$RspBody();
                cmd0x75f_rspbody2.mergeFrom(byteArray2);
                byte[] bArr22 = new byte[r15.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr22);
                cmd0x75f_rspbody2.mergeFrom(bArr22);
                cmd0x75f_addbatchrsp = cmd0x75f_rspbody2.msg_add_batch_rsp.get();
                if (sb5 != null) {
                    sb5.append(" rpt_messages size=");
                    sb5.append(cmd0x75f_addbatchrsp.rpt_messages.get().size());
                }
                for (i16 = 0; i16 < cmd0x75f_addbatchrsp.rpt_messages.get().size(); i16++) {
                    try {
                        long j3 = cmd0x75f_addbatchrsp.rpt_messages.get().get(i16).msg_content.msg_c2c_message.msg_to_user.uint64_uin.get();
                        arrayList.add(Long.valueOf(j3));
                        if (sb5 != null) {
                            sb5.append("{");
                            sb5.append(j3);
                            sb5.append("}");
                        }
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ActivateFriends.Servlet", 2, "respSendMessage index=" + i16);
                        }
                    }
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | response.result = " + fromServiceMsg.getResultCode());
        }
        if (arrayList.size() != longArray.length) {
            i17 = 0;
        } else if (arrayList.size() > 0) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        if (QLog.isColorLevel() && sb5 != null) {
            QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
        }
        if (i17 != 2) {
            long[] jArr = new long[arrayList.size()];
            for (int i18 = 0; i18 < arrayList.size(); i18++) {
                jArr[i18] = ((Long) arrayList.get(i18)).longValue();
            }
            activateFriendsManager.D(jArr, 2);
        }
        bundle.putInt("key_rt_type", i17);
        notifyObserver(intent, 113, true, bundle, b.class);
    }

    public static void g(QQAppInterface qQAppInterface, boolean z16, boolean z17) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), a.class);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 114);
        newIntent.putExtra("param_req_birthday", z16);
        newIntent.putExtra("param_req_memorial", z17);
        qQAppInterface.startServlet(newIntent);
    }

    public static void h(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, boolean z19) {
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "sendGetBirthDayMsgForce");
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), a.class);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 114);
        newIntent.putExtra("param_has_birthday_data", z16);
        newIntent.putExtra("param_has_memorial_data", z18);
        newIntent.putExtra("param_req_birthday", z17);
        newIntent.putExtra("param_req_memorial", z19);
        qQAppInterface.startServlet(newIntent);
    }

    public static void i(QQAppInterface qQAppInterface, ArrayList<String> arrayList) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), a.class);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 116);
        newIntent.putStringArrayListExtra("data", arrayList);
        qQAppInterface.startServlet(newIntent);
    }

    public static boolean j(QQAppInterface qQAppInterface, String str, long[] jArr, long[] jArr2, int i3) {
        if (jArr.length != 0 && jArr.length == jArr2.length) {
            NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), a.class);
            newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 113);
            newIntent.putExtra("p_msg", str);
            newIntent.putExtra("p_uin_list", jArr);
            newIntent.putExtra("p_time_list", jArr2);
            newIntent.putExtra("p_gift_id", i3);
            qQAppInterface.startServlet(newIntent);
            return true;
        }
        return false;
    }

    public void a(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("param_req_birthday", false);
        boolean booleanExtra2 = intent.getBooleanExtra("param_req_memorial", false);
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "req send get birthday message birthday=" + booleanExtra + " memorial=" + booleanExtra2);
        }
        cmd0x7c9$ReqBody cmd0x7c9_reqbody = new cmd0x7c9$ReqBody();
        ArrayList arrayList = new ArrayList(2);
        if (booleanExtra) {
            cmd0x7c9$ReqHelloType cmd0x7c9_reqhellotype = new cmd0x7c9$ReqHelloType();
            cmd0x7c9_reqhellotype.string_qua.set(QUA.getQUA3());
            cmd0x7c9_reqhellotype.uint32_req_type.set(1);
            if (intent.hasExtra("param_has_birthday_data")) {
                cmd0x7c9_reqhellotype.uint32_has_data.set(intent.getBooleanExtra("param_has_birthday_data", false) ? 1 : 0);
            }
            arrayList.add(cmd0x7c9_reqhellotype);
        }
        if (booleanExtra2) {
            cmd0x7c9$ReqHelloType cmd0x7c9_reqhellotype2 = new cmd0x7c9$ReqHelloType();
            cmd0x7c9_reqhellotype2.string_qua.set(QUA.getQUA3());
            cmd0x7c9_reqhellotype2.uint32_req_type.set(2);
            if (intent.hasExtra("param_has_memorial_data")) {
                cmd0x7c9_reqhellotype2.uint32_has_data.set(intent.getBooleanExtra("param_has_memorial_data", false) ? 1 : 0);
            }
            arrayList.add(cmd0x7c9_reqhellotype2);
        }
        cmd0x7c9_reqbody.rpt_hello_type.set(arrayList);
        cmd0x7c9_reqbody.string_qua.set(QUA.getQUA3());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1993);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x7c9_reqbody.toByteArray()));
        packet.setSSOCommand("OidbSvc.0x7c9_2");
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    public void c(Intent intent, Packet packet) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("data");
        if (stringArrayListExtra == null) {
            return;
        }
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("ActivateFriends.Servlet", 2, "activiate_friends|reqSendReadedActivateFriends size:" + stringArrayListExtra.size());
        }
        cmd0x82a$ReqBody cmd0x82a_reqbody = new cmd0x82a$ReqBody();
        cmd0x82a_reqbody.uint32_app_id.set(1001);
        cmd0x82a_reqbody.uint32_inst_id.set(AppSetting.f());
        ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
        int i17 = 0;
        while (i17 < stringArrayListExtra.size()) {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(stringArrayListExtra.get(i17));
                    String optString = jSONObject.optString("key_msg_ext_from_uin", "");
                    String optString2 = jSONObject.optString("key_msg_ext_to_uin", "");
                    String optString3 = jSONObject.optString("key_msg_ext_msg_seq", "");
                    String optString4 = jSONObject.optString("key_msg_ext_msg_type", "");
                    String optString5 = jSONObject.optString("key_msg_ext_msg_sub_type", "");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cmd0x82a$MsgInfo cmd0x82a_msginfo = new cmd0x82a$MsgInfo();
                        try {
                            cmd0x82a_msginfo.uint64_from_uin.set(Long.valueOf(optString).longValue());
                            cmd0x82a_msginfo.uint64_to_uin.set(Long.valueOf(optString2).longValue());
                            cmd0x82a_msginfo.uint32_msg_seq.set(Integer.valueOf(optString3).intValue());
                            cmd0x82a_msginfo.uint32_type.set(Integer.valueOf(optString4).intValue());
                            cmd0x82a_msginfo.uint32_subtype.set(Integer.valueOf(optString5).intValue());
                            arrayList.add(cmd0x82a_msginfo);
                        } catch (JSONException e16) {
                            e = e16;
                            i3 = 2;
                            if (QLog.isColorLevel()) {
                                QLog.i("ActivateFriends.Servlet", i3, e.getMessage(), e);
                            }
                            i17++;
                            i16 = i3;
                        }
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        i3 = 2;
                        QLog.i("ActivateFriends.Servlet", 2, e17.getMessage(), e17);
                    }
                }
                i3 = 2;
            } catch (JSONException e18) {
                e = e18;
                i3 = i16;
            }
            i17++;
            i16 = i3;
        }
        cmd0x82a_reqbody.msg_info.set(arrayList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2090);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x82a_reqbody.toByteArray()));
        packet.setSSOCommand("OidbSvc.0x82a_1");
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resp:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("ActivateFriends.Servlet", 2, sb5.toString());
        }
        if (serviceCmd.equals("OidbSvc.0x7c9_2")) {
            d(intent, fromServiceMsg);
        } else if (serviceCmd.equals("OidbSvc.0x75f")) {
            f(intent, fromServiceMsg);
        } else if (serviceCmd.equals("OidbSvc.0x82a_1")) {
            e(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        int i3 = extras.getInt(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 0);
        if (i3 != 113) {
            if (i3 != 114) {
                if (i3 == 116) {
                    c(intent, packet);
                    return;
                }
                return;
            }
            a(intent, packet);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.Servlet", 2, "req send timing message");
        }
        b(intent, packet);
    }
}
