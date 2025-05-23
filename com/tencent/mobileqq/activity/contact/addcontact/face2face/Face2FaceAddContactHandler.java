package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.nearfield_friend.nearfield_friend$GPS;
import tencent.im.nearfield_friend.nearfield_friend$ReqEnter;
import tencent.im.nearfield_friend.nearfield_friend$ReqExit;
import tencent.im.nearfield_friend.nearfield_friend$ReqHeartBeat;
import tencent.im.nearfield_friend.nearfield_friend$ResultInfo;
import tencent.im.nearfield_friend.nearfield_friend$RspEnter;
import tencent.im.nearfield_friend.nearfield_friend$RspExit;
import tencent.im.nearfield_friend.nearfield_friend$RspHeartBeat;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133$FaceFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133$MsgBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Face2FaceAddContactHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public Face2FaceAddContactHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, Object obj) {
        String str;
        String str2;
        boolean z17;
        nearfield_friend$ResultInfo nearfield_friend_resultinfo;
        int i3;
        int i16;
        int i17;
        int i18;
        String str3 = null;
        if (toServiceMsg != null) {
            str = toServiceMsg.extraData.getString("face2face_add_contact_session_id");
            str2 = toServiceMsg.extraData.getString("face2face_add_contact_number");
            z17 = toServiceMsg.extraData.getBoolean("face2face_add_contact_enter_after_verify", false);
        } else {
            str = null;
            str2 = null;
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactHandler", 2, "handleEnterFace2faceAddContact:" + z16 + " sessionId:" + str + " number:" + str2);
        }
        if (z16) {
            nearfield_friend$RspEnter nearfield_friend_rspenter = new nearfield_friend$RspEnter();
            try {
                nearfield_friend_rspenter.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Face2FaceAddContactHandler", 2, "handleEnterFace2faceAddContact:" + e16.toString());
                }
                nearfield_friend_rspenter = null;
                z16 = false;
            }
            if (z16 && nearfield_friend_rspenter != null) {
                if (nearfield_friend_rspenter.result.has()) {
                    nearfield_friend_resultinfo = nearfield_friend_rspenter.result.get();
                } else {
                    nearfield_friend_resultinfo = null;
                }
                String str4 = "";
                if (nearfield_friend_resultinfo != null) {
                    if (nearfield_friend_resultinfo.errcode.has()) {
                        i3 = nearfield_friend_resultinfo.errcode.get();
                    } else {
                        i3 = 0;
                    }
                    if (nearfield_friend_resultinfo.errmsg.has()) {
                        str4 = nearfield_friend_resultinfo.errmsg.get().toStringUtf8();
                    }
                } else {
                    i3 = 0;
                }
                if (nearfield_friend_rspenter.security_level.has()) {
                    i16 = nearfield_friend_rspenter.security_level.get();
                } else {
                    i16 = 0;
                }
                if (nearfield_friend_rspenter.verify_url.has()) {
                    str3 = nearfield_friend_rspenter.verify_url.get().toStringUtf8();
                }
                if (nearfield_friend_rspenter.heartbeat_time.has()) {
                    i17 = nearfield_friend_rspenter.heartbeat_time.get();
                } else {
                    i17 = 60;
                }
                if (nearfield_friend_rspenter.expire_time.has()) {
                    i18 = nearfield_friend_rspenter.expire_time.get();
                } else {
                    i18 = 1200;
                }
                notifyUI(1, true, new Object[]{str, Integer.valueOf(i3), str4, Integer.valueOf(i16), str3, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17)});
                return;
            }
        }
        notifyUI(1, false, new Object[]{str, Boolean.valueOf(z17)});
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, Object obj) {
        String str;
        int i3;
        nearfield_friend$ResultInfo nearfield_friend_resultinfo = null;
        if (toServiceMsg != null) {
            str = toServiceMsg.extraData.getString("face2face_add_contact_session_id");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactHandler", 2, "handleExitFace2FaceAddContact:" + z16 + " sessionId:" + str);
        }
        if (z16) {
            nearfield_friend$RspExit nearfield_friend_rspexit = new nearfield_friend$RspExit();
            try {
                nearfield_friend_rspexit.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Face2FaceAddContactHandler", 2, "handleExitFace2FaceAddContact:" + e16.toString());
                }
                nearfield_friend_rspexit = null;
                z16 = false;
            }
            if (z16 && nearfield_friend_rspexit != null) {
                if (nearfield_friend_rspexit.result.has()) {
                    nearfield_friend_resultinfo = nearfield_friend_rspexit.result.get();
                }
                String str2 = "";
                if (nearfield_friend_resultinfo != null) {
                    if (nearfield_friend_resultinfo.errcode.has()) {
                        i3 = nearfield_friend_resultinfo.errcode.get();
                    } else {
                        i3 = 0;
                    }
                    if (nearfield_friend_resultinfo.errmsg.has()) {
                        str2 = nearfield_friend_resultinfo.errmsg.get().toStringUtf8();
                    }
                } else {
                    i3 = 0;
                }
                notifyUI(2, true, new Object[]{str, Integer.valueOf(i3), str2});
                return;
            }
        }
        notifyUI(2, false, new Object[]{str});
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, Object obj) {
        String str;
        nearfield_friend$ResultInfo nearfield_friend_resultinfo;
        int i3;
        List<Long> list = null;
        if (toServiceMsg != null) {
            str = toServiceMsg.extraData.getString("face2face_add_contact_session_id");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactHandler", 2, "handleFace2FaceAddContactHeartBeat:" + z16 + " sessionId:" + str);
        }
        if (z16) {
            nearfield_friend$RspHeartBeat nearfield_friend_rspheartbeat = new nearfield_friend$RspHeartBeat();
            try {
                nearfield_friend_rspheartbeat.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Face2FaceAddContactHandler", 2, "handleFace2FaceAddContactHeartBeat:" + e16.toString());
                }
                nearfield_friend_rspheartbeat = null;
                z16 = false;
            }
            if (z16 && nearfield_friend_rspheartbeat != null) {
                if (nearfield_friend_rspheartbeat.result.has()) {
                    nearfield_friend_resultinfo = nearfield_friend_rspheartbeat.result.get();
                } else {
                    nearfield_friend_resultinfo = null;
                }
                String str2 = "";
                if (nearfield_friend_resultinfo != null) {
                    if (nearfield_friend_resultinfo.errcode.has()) {
                        i3 = nearfield_friend_resultinfo.errcode.get();
                    } else {
                        i3 = 0;
                    }
                    if (nearfield_friend_resultinfo.errmsg.has()) {
                        str2 = nearfield_friend_resultinfo.errmsg.get().toStringUtf8();
                    }
                } else {
                    i3 = 0;
                }
                if (nearfield_friend_rspheartbeat.uin_list.has()) {
                    list = nearfield_friend_rspheartbeat.uin_list.get();
                }
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    Iterator<Long> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(String.valueOf(it.next()));
                    }
                }
                notifyUI(3, true, new Object[]{str, Integer.valueOf(i3), str2, arrayList});
                return;
            }
        }
        notifyUI(3, false, new Object[]{str});
    }

    public void D2(byte[] bArr) {
        String str;
        String str2;
        String str3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null) {
            try {
                submsgtype0x133$MsgBody submsgtype0x133_msgbody = new submsgtype0x133$MsgBody();
                submsgtype0x133_msgbody.mergeFrom(bArr);
                List<submsgtype0x133$FaceFriend> list = null;
                if (submsgtype0x133_msgbody.uint64_uin.has()) {
                    str = String.valueOf(submsgtype0x133_msgbody.uint64_uin.get());
                } else {
                    str = null;
                }
                if (submsgtype0x133_msgbody.str_session_id.has()) {
                    str2 = submsgtype0x133_msgbody.str_session_id.get();
                } else {
                    str2 = null;
                }
                if (submsgtype0x133_msgbody.rpt_msg_friends.has()) {
                    list = submsgtype0x133_msgbody.rpt_msg_friends.get();
                }
                QLog.i("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 uin:" + str + " sessionId:" + str2);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.equals(str, this.appRuntime.getAccount())) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (submsgtype0x133$FaceFriend submsgtype0x133_facefriend : list) {
                            d dVar = new d();
                            dVar.f181080a = String.valueOf(submsgtype0x133_facefriend.uint64_friend.get());
                            if (submsgtype0x133_facefriend.bytes_name.has()) {
                                str3 = submsgtype0x133_facefriend.bytes_name.get().toStringUtf8();
                            } else {
                                str3 = "";
                            }
                            dVar.f181081b = str3;
                            if (submsgtype0x133_facefriend.uint32_type.has()) {
                                i3 = submsgtype0x133_facefriend.uint32_type.get();
                            } else {
                                i3 = 0;
                            }
                            dVar.f181082c = i3;
                            arrayList.add(dVar);
                        }
                    }
                    notifyUI(4, true, new Object[]{str, str2, arrayList});
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 decode error, e=" + th5.toString());
                return;
            }
        }
        QLog.e("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 pbData = null");
    }

    public void E2(String str, String str2, nearfield_friend$GPS nearfield_friend_gps, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, nearfield_friend_gps, bArr);
            return;
        }
        QLog.i("Face2FaceAddContactHandler", 1, "enterFace2faceAddContact sessionId=" + str + " number:" + str2);
        nearfield_friend$ReqEnter nearfield_friend_reqenter = new nearfield_friend$ReqEnter();
        nearfield_friend_reqenter.session_id.set(str);
        if (nearfield_friend_gps != null) {
            nearfield_friend_reqenter.gps_info.set(nearfield_friend_gps);
        }
        nearfield_friend_reqenter.number.set(str2);
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldFriendSvr.ReqEnter");
        if (bArr != null && bArr.length > 0) {
            nearfield_friend_reqenter.verify_sig.set(ByteStringMicro.copyFrom(bArr));
            createToServiceMsg.extraData.putBoolean("face2face_add_contact_enter_after_verify", true);
        }
        createToServiceMsg.extraData.putString("face2face_add_contact_number", str2);
        createToServiceMsg.extraData.putString("face2face_add_contact_session_id", str);
        createToServiceMsg.putWupBuffer(nearfield_friend_reqenter.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void F2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        QLog.i("Face2FaceAddContactHandler", 1, "exitFace2FaceAddContact sessionId=" + str);
        nearfield_friend$ReqExit nearfield_friend_reqexit = new nearfield_friend$ReqExit();
        nearfield_friend_reqexit.session_id.set(str);
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldFriendSvr.ReqExit");
        createToServiceMsg.extraData.putString("face2face_add_contact_session_id", str);
        createToServiceMsg.putWupBuffer(nearfield_friend_reqexit.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void G2(String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) list);
            return;
        }
        QLog.i("Face2FaceAddContactHandler", 1, "face2FaceAddContactHeartBeat sessionId=" + str);
        nearfield_friend$ReqHeartBeat nearfield_friend_reqheartbeat = new nearfield_friend$ReqHeartBeat();
        nearfield_friend_reqheartbeat.session_id.set(str);
        if (list != null && list.size() > 0) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    nearfield_friend_reqheartbeat.uin_list.add(Long.valueOf(Long.parseLong(it.next())));
                }
            } catch (Exception e16) {
                QLog.e("Face2FaceAddContactHandler", 1, "face2FaceAddContactHeartBeat error:" + e16.getMessage());
            }
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("NearFieldFriendSvr.ReqHeartBeat");
        createToServiceMsg.extraData.putString("face2face_add_contact_session_id", str);
        createToServiceMsg.putWupBuffer(nearfield_friend_reqheartbeat.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("NearFieldFriendSvr.ReqEnter");
            this.allowCmdSet.add("NearFieldFriendSvr.ReqExit");
            this.allowCmdSet.add("NearFieldFriendSvr.ReqHeartBeat");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null) {
            str = fromServiceMsg.getServiceCmd();
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactHandler", 2, "onReceive:" + str);
        }
        if (msgCmdFilter(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceAddContactHandler", 2, "msgCmdFilter error=" + str);
                return;
            }
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ("NearFieldFriendSvr.ReqEnter".equalsIgnoreCase(str)) {
            H2(toServiceMsg, fromServiceMsg, z16, obj);
        } else if ("NearFieldFriendSvr.ReqExit".equalsIgnoreCase(str)) {
            I2(toServiceMsg, fromServiceMsg, z16, obj);
        } else if ("NearFieldFriendSvr.ReqHeartBeat".equalsIgnoreCase(str)) {
            J2(toServiceMsg, fromServiceMsg, z16, obj);
        }
    }
}
