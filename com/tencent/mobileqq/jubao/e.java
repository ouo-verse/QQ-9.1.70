package com.tencent.mobileqq.jubao;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dt.api.JubaoMsgData;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xccb$C2cMsgInfo;
import tencent.im.oidb.cmd0xccb$GroupMsgInfo;
import tencent.im.oidb.cmd0xccb$GuildMsgInfo;
import tencent.im.oidb.cmd0xccb$LocalMsgInfo;
import tencent.im.oidb.cmd0xccb$ReqBody;
import tencent.im.oidb.cmd0xccb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends MSFServlet {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQAppInterface a() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0266 A[Catch: Exception -> 0x0284, TryCatch #0 {Exception -> 0x0284, blocks: (B:10:0x0027, B:12:0x0037, B:16:0x0067, B:18:0x008c, B:19:0x0094, B:21:0x009c, B:22:0x00a2, B:38:0x01e5, B:40:0x01ed, B:42:0x01f3, B:44:0x0218, B:46:0x0266, B:47:0x0272, B:50:0x01fb, B:52:0x0201, B:53:0x00d7, B:54:0x00e1, B:56:0x00e7, B:58:0x010e, B:63:0x0131, B:64:0x013d, B:66:0x0143, B:69:0x0167, B:74:0x0183, B:75:0x018f, B:77:0x0195, B:80:0x01c9), top: B:9:0x0027 }] */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        int i16;
        ArrayList arrayList;
        int i17;
        boolean z16;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        QLog.d("jubaoApiPlugin", 1, "servlet onReceive  start = ");
        try {
            int resultCode = fromServiceMsg.getResultCode();
            int resultCode2 = fromServiceMsg.getResultCode();
            int i19 = -1;
            String str = null;
            if (fromServiceMsg.isSuccess()) {
                ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr = new byte[wrap.getInt() - 4];
                wrap.get(bArr);
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                i17 = mergeFrom.uint32_result.get();
                int i26 = mergeFrom.uint32_command.get();
                if (i17 == 0 && i26 == 3275) {
                    cmd0xccb$RspBody cmd0xccb_rspbody = new cmd0xccb$RspBody();
                    cmd0xccb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    cmd0xccb_rspbody.dest_uin.get();
                    int i27 = cmd0xccb_rspbody.type.get();
                    if (cmd0xccb_rspbody.c2c_type.has()) {
                        i16 = cmd0xccb_rspbody.c2c_type.get();
                    } else {
                        i16 = -1;
                    }
                    if (cmd0xccb_rspbody.service_type.has()) {
                        i19 = cmd0xccb_rspbody.service_type.get();
                    }
                    String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(cmd0xccb_rspbody.res_id.get().toByteArray(), 0);
                    arrayList = new ArrayList();
                    if (i27 != 1 && i27 != 6) {
                        if (i27 != 2 && i27 != 3 && i27 != 4 && i27 != 5) {
                            if (i27 == 7 || i27 == 8) {
                                for (cmd0xccb$GuildMsgInfo cmd0xccb_guildmsginfo : cmd0xccb_rspbody.guild_msg.get()) {
                                    JubaoMsgData jubaoMsgData = new JubaoMsgData();
                                    int i28 = i19;
                                    jubaoMsgData.msgSeq = (int) cmd0xccb_guildmsginfo.msg_seq.get();
                                    jubaoMsgData.result = cmd0xccb_guildmsginfo.roam_flag.get();
                                    arrayList.add(jubaoMsgData);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("jubaoApiPlugin", 2, "servlet upload onReceive GuildMsgInfo = " + jubaoMsgData.toJson().toString());
                                    }
                                    i19 = i28;
                                }
                            }
                            i18 = i19;
                        } else {
                            i18 = i19;
                            for (cmd0xccb$GroupMsgInfo cmd0xccb_groupmsginfo : cmd0xccb_rspbody.group_msg.get()) {
                                JubaoMsgData jubaoMsgData2 = new JubaoMsgData();
                                jubaoMsgData2.msgSeq = cmd0xccb_groupmsginfo.msg_seq.get();
                                jubaoMsgData2.result = cmd0xccb_groupmsginfo.roam_flag.get();
                                arrayList.add(jubaoMsgData2);
                                if (QLog.isColorLevel()) {
                                    QLog.d("jubaoApiPlugin", 2, "servlet upload onReceive data = " + jubaoMsgData2.toJson().toString());
                                }
                            }
                        }
                    } else {
                        i18 = i19;
                        for (cmd0xccb$C2cMsgInfo cmd0xccb_c2cmsginfo : cmd0xccb_rspbody.c2c_msg.get()) {
                            JubaoMsgData jubaoMsgData3 = new JubaoMsgData();
                            jubaoMsgData3.msgSeq = cmd0xccb_c2cmsginfo.msg_seq.get();
                            jubaoMsgData3.msgTime = cmd0xccb_c2cmsginfo.msg_time.get();
                            jubaoMsgData3.msgRandom = cmd0xccb_c2cmsginfo.msg_random.get();
                            jubaoMsgData3.result = cmd0xccb_c2cmsginfo.roam_flag.get();
                            arrayList.add(jubaoMsgData3);
                            if (QLog.isColorLevel()) {
                                QLog.d("jubaoApiPlugin", 2, "servlet upload onReceive data = " + jubaoMsgData3.toJson().toString());
                            }
                        }
                    }
                    if (!cmd0xccb_rspbody.local_msg.has()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("jubaoApiPlugin", 2, "onReceiver first success");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("jubaoApiPlugin", 2, "onReceiver second success");
                    }
                    i3 = i18;
                    resultCode = i17;
                    str = encodeToString;
                    z16 = true;
                    QLog.d("jubaoApiPlugin", 1, "servlet upload onReceive isSucess = " + z16 + ",ssoResultCode = " + resultCode2 + ",oidbResultCode = " + i17 + ",uuid:" + str + ",c2cType:" + i16 + ",serviceType:" + i3 + "\uff0cresult=" + resultCode);
                    if (z16) {
                        intent.putExtra("jubao_uuid", str);
                        intent.putExtra("jubao_msg_list", arrayList);
                    }
                    intent.putExtra("jubao_result_code", resultCode);
                    notifyObserver(intent, 0, z16, intent.getExtras(), b.class);
                }
                resultCode = i17;
                i3 = -1;
                i16 = -1;
                arrayList = null;
            } else {
                i3 = -1;
                i16 = -1;
                arrayList = null;
                i17 = 0;
            }
            z16 = false;
            QLog.d("jubaoApiPlugin", 1, "servlet upload onReceive isSucess = " + z16 + ",ssoResultCode = " + resultCode2 + ",oidbResultCode = " + i17 + ",uuid:" + str + ",c2cType:" + i16 + ",serviceType:" + i3 + "\uff0cresult=" + resultCode);
            if (z16) {
            }
            intent.putExtra("jubao_result_code", resultCode);
            notifyObserver(intent, 0, z16, intent.getExtras(), b.class);
        } catch (Exception e16) {
            QLog.d("jubaoApiPlugin", 1, "servlet onReceive exception:  = " + e16);
            QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
            intent.putExtra("jubao_result_code", 3);
            notifyObserver(intent, 0, false, intent.getExtras(), b.class);
        }
    }

    /* JADX WARN: Not initialized variable reg: 20, insn: 0x047a: MOVE (r8 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]) (LINE:1147), block:B:205:0x047a */
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String str;
        long j3;
        long j16;
        long j17;
        String str2;
        long j18;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        String str3 = "jubao_result_code";
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        QLog.d("jubaoApiPlugin", 1, "servlet onSend  start = ");
        try {
            try {
                cmd0xccb$ReqBody cmd0xccb_reqbody = new cmd0xccb$ReqBody();
                String stringExtra = intent.getStringExtra("jubao_evil_uin");
                String stringExtra2 = intent.getStringExtra("jubao_chat_uin");
                String stringExtra3 = intent.getStringExtra("jubao_group_code");
                int intExtra = intent.getIntExtra("jubao_chat_type", 0);
                try {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        j3 = Long.parseLong(stringExtra);
                    } else {
                        j3 = 0;
                    }
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        j16 = Long.parseLong(stringExtra2);
                    } else {
                        j16 = 0;
                    }
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        j17 = Long.parseLong(stringExtra3);
                    } else {
                        j17 = 0;
                    }
                    int i28 = -1;
                    if (intExtra == 1) {
                        if (j16 == 0) {
                            i17 = 3;
                            str2 = "jubao_msg_list";
                            j18 = j17;
                            i16 = i28;
                        }
                        i17 = i27;
                        str2 = "jubao_msg_list";
                        j18 = j17;
                        i16 = i28;
                    } else if (intExtra == 1000) {
                        i27 = 1;
                        i17 = 1;
                        i16 = 0;
                        str2 = "jubao_msg_list";
                        j18 = j17;
                    } else {
                        if (intExtra != 1020) {
                            if (intExtra == 3000) {
                                if (j16 == 0) {
                                    i26 = 5;
                                } else {
                                    i26 = 4;
                                }
                                i17 = i26;
                                str2 = "jubao_msg_list";
                                j18 = j17;
                                i16 = i28;
                            } else if (intExtra != 1004) {
                                if (intExtra == 1006) {
                                    i28 = 130;
                                } else if (intExtra == 1022) {
                                    i28 = 134;
                                } else {
                                    if (intExtra == 1032 || intExtra == 1034 || intExtra == 1033) {
                                        str2 = "jubao_msg_list";
                                        j18 = j17;
                                        i3 = 156;
                                    } else if (intExtra == 10008) {
                                        i28 = 165;
                                    } else if (intExtra == 1008) {
                                        i28 = 129;
                                    } else {
                                        if (intExtra == 1001) {
                                            byte[] decode = Base64.decode(intent.getStringExtra("jubao_nearby_sig"), 0);
                                            cmd0xccb_reqbody.c2c_type.set(1);
                                            i19 = 124;
                                            cmd0xccb_reqbody.service_type.set(124);
                                            cmd0xccb_reqbody.sig.set(ByteStringMicro.copyFrom(decode));
                                        } else if (intExtra == 1024) {
                                            i28 = 58;
                                        } else if (intExtra == 1023) {
                                            i28 = 133;
                                        } else if (intExtra == 10002) {
                                            i28 = 146;
                                        } else if (intExtra == 10004) {
                                            i28 = 153;
                                        } else if (intExtra == 1005) {
                                            i28 = 201;
                                        } else if (intExtra == 1036) {
                                            i28 = 160;
                                        } else {
                                            if (intExtra == 1044) {
                                                i28 = 163;
                                            } else if (intExtra == 1045) {
                                                i28 = 166;
                                            } else if (intExtra == 1046) {
                                                byte[] decode2 = Base64.decode(intent.getStringExtra("jubao_matchfriend_sig"), 0);
                                                cmd0xccb_reqbody.sig.set(ByteStringMicro.copyFrom(decode2));
                                                cmd0xccb_reqbody.c2c_type.set(1);
                                                i19 = 172;
                                                cmd0xccb_reqbody.service_type.set(172);
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("jubaoApiPlugin", 2, " sig = " + decode2);
                                                }
                                                ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).reportJubao(a(), j3);
                                            } else {
                                                long j19 = j3;
                                                if (intExtra == 10010) {
                                                    i28 = 167;
                                                } else if (intExtra == 10014) {
                                                    str2 = "jubao_msg_list";
                                                    j18 = j17;
                                                    if (j18 == 0) {
                                                        cmd0xccb_reqbody.guild_id.set(j19);
                                                        i18 = 8;
                                                    } else {
                                                        cmd0xccb_reqbody.guild_id.set(j18);
                                                        i18 = 7;
                                                    }
                                                    int i29 = i18;
                                                    cmd0xccb_reqbody.channel_id.set(j16);
                                                    cmd0xccb_reqbody.dest_uin.set(j19);
                                                    ArrayList arrayList = new ArrayList();
                                                    ArrayList arrayList2 = (ArrayList) intent.getExtras().get(str2);
                                                    if (arrayList2 != null) {
                                                        int i36 = 0;
                                                        while (i36 < arrayList2.size()) {
                                                            cmd0xccb$GuildMsgInfo cmd0xccb_guildmsginfo = new cmd0xccb$GuildMsgInfo();
                                                            int i37 = i29;
                                                            ArrayList arrayList3 = arrayList2;
                                                            String str4 = str3;
                                                            cmd0xccb_guildmsginfo.msg_seq.set(((JubaoMsgData) arrayList2.get(i36)).msgSeq);
                                                            arrayList.add(cmd0xccb_guildmsginfo);
                                                            i36++;
                                                            i29 = i37;
                                                            str3 = str4;
                                                            arrayList2 = arrayList3;
                                                        }
                                                    }
                                                    cmd0xccb_reqbody.guild_msg.set(arrayList);
                                                    i17 = i29;
                                                    i16 = -1;
                                                    i27 = 1;
                                                } else {
                                                    str2 = "jubao_msg_list";
                                                    j18 = j17;
                                                    if (intExtra == 10007) {
                                                        byte[] decode3 = Base64.decode(intent.getStringExtra("jubao_game_sig"), 0);
                                                        cmd0xccb_reqbody.sig.set(ByteStringMicro.copyFrom(decode3));
                                                        cmd0xccb_reqbody.c2c_type.set(1);
                                                        cmd0xccb_reqbody.service_type.set(164);
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("jubaoApiPlugin", 2, " sig = " + decode3);
                                                        }
                                                        i16 = 164;
                                                    } else if (intExtra == 10019) {
                                                        i3 = 173;
                                                    } else if (intExtra == 119) {
                                                        cmd0xccb_reqbody.sig.set(ByteStringMicro.copyFrom(Base64.decode(intent.getStringExtra("jubao_nearbypro_sig"), 0)));
                                                        cmd0xccb_reqbody.c2c_type.set(1);
                                                        i16 = 174;
                                                        cmd0xccb_reqbody.service_type.set(174);
                                                        ((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).reportJubao(j19);
                                                    } else {
                                                        i16 = -1;
                                                        i27 = 1;
                                                        i17 = 1;
                                                    }
                                                    i27 = 1;
                                                    i17 = 6;
                                                }
                                            }
                                            i27 = 1;
                                            i17 = i27;
                                            str2 = "jubao_msg_list";
                                            j18 = j17;
                                            i16 = i28;
                                        }
                                        i27 = 1;
                                        str2 = "jubao_msg_list";
                                        j18 = j17;
                                        i17 = 6;
                                        i16 = i19;
                                    }
                                    i16 = i3;
                                    i27 = 1;
                                    i17 = 6;
                                }
                                i27 = 1;
                                str2 = "jubao_msg_list";
                                j18 = j17;
                                i17 = 6;
                                i16 = i28;
                            }
                        }
                        i27 = 1;
                        i17 = 1;
                        str2 = "jubao_msg_list";
                        j18 = j17;
                        i16 = 1;
                    }
                    cmd0xccb_reqbody.type.set(i17);
                    if (i17 == 6) {
                        cmd0xccb_reqbody.c2c_type.set(i27);
                        cmd0xccb_reqbody.service_type.set(i16);
                    }
                    if (i17 == 1 || i17 == 2 || i17 == 4 || i17 == 6) {
                        cmd0xccb_reqbody.dest_uin.set(j16);
                    }
                    if (i17 == 2 || i17 == 3 || i17 == 4 || i17 == 5) {
                        cmd0xccb_reqbody.group_code.set(j18);
                    }
                    String stringExtra4 = intent.getStringExtra("multi_msg_resID");
                    if (stringExtra4 != null && stringExtra4.length() != 0) {
                        cmd0xccb$LocalMsgInfo cmd0xccb_localmsginfo = new cmd0xccb$LocalMsgInfo();
                        cmd0xccb_localmsginfo.local_res_id.set(ByteStringMicro.copyFromUtf8(stringExtra4));
                        cmd0xccb_reqbody.local_msg.set(cmd0xccb_localmsginfo);
                    }
                    List<JubaoMsgData> list = (List) intent.getSerializableExtra(str2);
                    if (list != null) {
                        if (i17 != 1 && i17 != 6) {
                            if (i17 == 2 || i17 == 3 || i17 == 4 || i17 == 5) {
                                ArrayList arrayList4 = new ArrayList();
                                for (JubaoMsgData jubaoMsgData : list) {
                                    cmd0xccb$GroupMsgInfo cmd0xccb_groupmsginfo = new cmd0xccb$GroupMsgInfo();
                                    cmd0xccb_groupmsginfo.msg_seq.set(jubaoMsgData.msgSeq);
                                    QLog.d("jubaoApiPlugin", 1, "data.msgSeq :" + jubaoMsgData.msgSeq);
                                    arrayList4.add(cmd0xccb_groupmsginfo);
                                }
                                cmd0xccb_reqbody.group_msg.set(arrayList4);
                            }
                        }
                        ArrayList arrayList5 = new ArrayList();
                        for (JubaoMsgData jubaoMsgData2 : list) {
                            cmd0xccb$C2cMsgInfo cmd0xccb_c2cmsginfo = new cmd0xccb$C2cMsgInfo();
                            cmd0xccb_c2cmsginfo.msg_seq.set(jubaoMsgData2.msgSeq);
                            cmd0xccb_c2cmsginfo.msg_time.set(jubaoMsgData2.msgTime);
                            cmd0xccb_c2cmsginfo.msg_random.set(jubaoMsgData2.msgRandom);
                            arrayList5.add(cmd0xccb_c2cmsginfo);
                        }
                        cmd0xccb_reqbody.c2c_msg.set(arrayList5);
                    }
                    QLog.d("jubaoApiPlugin", 1, "servlet onSend uinTypeDst:" + i17 + " c2CType:" + i27 + " serviceType:" + i16 + " chatType:" + intExtra);
                    if (intExtra == 10014) {
                        QLog.d("jubaoApiPlugin", 1, "guildId :" + cmd0xccb_reqbody.guild_id.get() + "\n channelId : " + cmd0xccb_reqbody.channel_id.get() + "\n evilId : " + cmd0xccb_reqbody.dest_uin.get() + "\n msgInfo : " + cmd0xccb_reqbody.guild_msg.get());
                    }
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.uint32_command.set(3275);
                    oidb_sso_oidbssopkg.uint32_service_type.set(0);
                    oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xccb_reqbody.toByteArray()));
                    byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                    ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
                    allocate.putInt(byteArray.length + 4);
                    allocate.put(byteArray);
                    packet.putSendData(allocate.array());
                    packet.setSSOCommand("OidbSvc.0xccb_0");
                } catch (NumberFormatException e16) {
                    QLog.e("jubaoApiPlugin", 1, e16, new Object[0]);
                    intent.putExtra("jubao_result_code", 2);
                    notifyObserver(intent, 0, false, intent.getExtras(), b.class);
                }
            } catch (Exception e17) {
                e = e17;
                str3 = str;
                QLog.d("jubaoApiPlugin", 1, "servlet onSend exception :" + e.getStackTrace().toString());
                intent.putExtra(str3, 2);
                notifyObserver(intent, 0, false, intent.getExtras(), b.class);
            }
        } catch (Exception e18) {
            e = e18;
            QLog.d("jubaoApiPlugin", 1, "servlet onSend exception :" + e.getStackTrace().toString());
            intent.putExtra(str3, 2);
            notifyObserver(intent, 0, false, intent.getExtras(), b.class);
        }
    }
}
