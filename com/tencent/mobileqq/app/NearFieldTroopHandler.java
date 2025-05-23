package com.tencent.mobileqq.app;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.nearfield_group.nearfield_group$BusiReqHead;
import tencent.im.nearfield_group.nearfield_group$BusiRespHead;
import tencent.im.nearfield_group.nearfield_group$GroupProfile;
import tencent.im.nearfield_group.nearfield_group$ReqExit;
import tencent.im.nearfield_group.nearfield_group$ReqGetGroupList;
import tencent.im.nearfield_group.nearfield_group$ReqJoinGroup;
import tencent.im.nearfield_group.nearfield_group$RespExit;
import tencent.im.nearfield_group.nearfield_group$RespGetGroupList;
import tencent.im.nearfield_group.nearfield_group$RespJoinGroup;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearFieldTroopHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    protected NearFieldTroopHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    public void D2(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqExit");
        nearfield_group$BusiReqHead nearfield_group_busireqhead = new nearfield_group$BusiReqHead();
        nearfield_group_busireqhead.int32_seq.set(i3);
        nearfield_group_busireqhead.int32_version.set(1);
        nearfield_group$ReqExit nearfield_group_reqexit = new nearfield_group$ReqExit();
        nearfield_group_reqexit.msg_head.set(nearfield_group_busireqhead);
        nearfield_group_reqexit.uint64_group_code.set(j3);
        toServiceMsg.putWupBuffer(nearfield_group_reqexit.toByteArray());
        toServiceMsg.setTimeout(10000L);
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "closeFace2faceTroop, troopCode:" + j3 + ", seqNo:" + i3);
        }
    }

    protected void E2(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "handleCloseFace2faceTroop:" + z16);
        }
        if (z16) {
            nearfield_group$RespExit nearfield_group_respexit = new nearfield_group$RespExit();
            try {
                nearfield_group_respexit.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NearFieldTroopHandler", 2, "handleCloseFace2faceTroop:" + e16.toString());
                }
                nearfield_group_respexit = null;
                z16 = false;
            }
            if (z16 && nearfield_group_respexit != null) {
                notifyUI(2, z16, new Object[]{nearfield_group_respexit.msg_head.get()});
                return;
            }
        }
        notifyUI(2, false, null);
    }

    protected void F2(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "handleJoinTroopResp:" + z16);
        }
        if (z16) {
            nearfield_group$RespJoinGroup nearfield_group_respjoingroup = new nearfield_group$RespJoinGroup();
            try {
                nearfield_group_respjoingroup.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NearFieldTroopHandler", 2, "handleJoinTroopResp:" + e16.toString());
                }
                nearfield_group_respjoingroup = null;
                z16 = false;
            }
            if (z16 && nearfield_group_respjoingroup != null) {
                notifyUI(3, z16, new Object[]{nearfield_group_respjoingroup.msg_head.get(), String.valueOf(nearfield_group_respjoingroup.uint64_group_code.get())});
                return;
            }
        }
        notifyUI(3, false, null);
    }

    protected void G2(boolean z16, Object obj) {
        boolean z17 = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "handleOpenFace2faceTroop:" + z17);
        }
        if (z17) {
            nearfield_group$RespGetGroupList nearfield_group_respgetgrouplist = new nearfield_group$RespGetGroupList();
            try {
                nearfield_group_respgetgrouplist.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NearFieldTroopHandler", 2, "handleOpenFace2faceTroop:" + e16.toString());
                }
                nearfield_group_respgetgrouplist = null;
                z17 = false;
            }
            if (z17 && nearfield_group_respgetgrouplist != null) {
                nearfield_group$BusiRespHead nearfield_group_busiresphead = nearfield_group_respgetgrouplist.msg_head.get();
                List<nearfield_group$GroupProfile> list = nearfield_group_respgetgrouplist.rpt_msg_group_list.get();
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        nearfield_group$GroupProfile nearfield_group_groupprofile = list.get(i3);
                        long j3 = nearfield_group_groupprofile.uint64_group_code.get();
                        String stringUtf8 = nearfield_group_groupprofile.bytes_group_name.get().toStringUtf8();
                        long j16 = nearfield_group_groupprofile.uint64_owner_uin.get();
                        String str = j3 + "";
                        arrayList.add(new com.tencent.mobileqq.facetoface.c(str, stringUtf8, j16 + "", nearfield_group_groupprofile.bytes_owner_nick.get().toStringUtf8(), nearfield_group_groupprofile.bytes_distance.get().toStringUtf8()));
                    }
                }
                notifyUI(1, z17, new Object[]{nearfield_group_busiresphead, arrayList});
                return;
            }
        }
        notifyUI(1, false, null);
    }

    public void H2(long j3, long j16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqJoinGroup");
        nearfield_group$BusiReqHead nearfield_group_busireqhead = new nearfield_group$BusiReqHead();
        nearfield_group_busireqhead.int32_seq.set(i3);
        nearfield_group_busireqhead.int32_version.set(1);
        nearfield_group$ReqJoinGroup nearfield_group_reqjoingroup = new nearfield_group$ReqJoinGroup();
        nearfield_group_reqjoingroup.msg_head.set(nearfield_group_busireqhead);
        nearfield_group_reqjoingroup.uint64_group_code.set(j3);
        nearfield_group_reqjoingroup.uint64_owner_uin.set(j16);
        nearfield_group_reqjoingroup.bytes_distance.set(ByteStringMicro.copyFromUtf8(str));
        toServiceMsg.putWupBuffer(nearfield_group_reqjoingroup.toByteArray());
        toServiceMsg.setTimeout(10000L);
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "joinTroop, troopCode:" + j3 + ", ownerUin=" + j16 + ", distance=" + str + ", seqNo:" + i3);
        }
    }

    public boolean I2(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "NearfieldGroupSvr.ReqGetGroupList");
        appoint_define$LBSInfo appoint_define_lbsinfo = (appoint_define$LBSInfo) ((ILbsUtils) QRoute.api(ILbsUtils.class)).getLbsInfo(getClass().getSimpleName());
        if (appoint_define_lbsinfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NearFieldTroopHandler", 2, "openFace2faceTroop, lbsInfo==null");
            }
            return false;
        }
        nearfield_group$BusiReqHead nearfield_group_busireqhead = new nearfield_group$BusiReqHead();
        nearfield_group_busireqhead.int32_seq.set(i3);
        nearfield_group_busireqhead.int32_version.set(1);
        nearfield_group$ReqGetGroupList nearfield_group_reqgetgrouplist = new nearfield_group$ReqGetGroupList();
        nearfield_group_reqgetgrouplist.msg_head.set(nearfield_group_busireqhead);
        nearfield_group_reqgetgrouplist.uint64_group_code.set(j3);
        nearfield_group_reqgetgrouplist.msg_lbs_info.set(appoint_define_lbsinfo);
        toServiceMsg.putWupBuffer(nearfield_group_reqgetgrouplist.toByteArray());
        toServiceMsg.setTimeout(10000L);
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "openFace2faceTroop, troopCode:" + j3 + ", seqNo:" + i3);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("NearfieldGroupSvr.ReqGetGroupList");
            this.allowCmdSet.add("NearfieldGroupSvr.ReqExit");
            this.allowCmdSet.add("NearfieldGroupSvr.ReqJoinGroup");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return bx.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null) {
            str = fromServiceMsg.getServiceCmd();
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("NearFieldTroopHandler", 2, "onReceive:" + str);
        }
        if (msgCmdFilter(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("NearFieldTroopHandler", 2, "cmdfilter error=" + str);
                return;
            }
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ("NearfieldGroupSvr.ReqGetGroupList".equalsIgnoreCase(str)) {
            G2(z16, obj);
        } else if ("NearfieldGroupSvr.ReqExit".equalsIgnoreCase(str)) {
            E2(z16, obj);
        } else if ("NearfieldGroupSvr.ReqJoinGroup".equalsIgnoreCase(str)) {
            F2(z16, obj);
        }
    }
}
