package com.tencent.mobileqq.friends.intimate;

import NS_COMM.COMM;
import NS_MINI_APP_MISC.MISC$StGetFriendPlayListV2Req;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.troop.h;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.widget.util.MutualMarkDialogUtil;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.trpcprotocol.friends_mutualmark.change.change.MutualChange$Info;
import com.tencent.trpcprotocol.friends_mutualmark.change.change.MutualChange$Req;
import com.tencent.trpcprotocol.friends_mutualmark.wear.wear.wear$Req;
import com.tencent.trpcprotocol.friends_mutualmark.wear.wear.wear$Rsp;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e$GroupList;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e$ReqBody;
import tencent.im.oidb.cmd0xe3e.oidb_0xe3e$RspBody;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$ReqBody;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$RspBody;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3$ReqBody;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3$RspBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$ReqBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$RspBody;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c$ReqBody;
import tencent.im.oidb.oidb_0xd84$ReqBody;
import tencent.intimate_relation.intimate_relation$IntimateInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class IntimateInfoHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static long f211744e;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f211745d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            f211744e = -1L;
        }
    }

    public IntimateInfoHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f211745d = qQAppInterface;
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        int i16;
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xe3e$RspBody oidb_0xe3e_rspbody = new oidb_0xe3e$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe3e_rspbody);
            ArrayList arrayList = new ArrayList();
            if (parseOIDBPkg == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("intimate_relationship", 2, "HandleGetTroopWithCommonFriendsList is Success");
                }
                if (oidb_0xe3e_rspbody.uint32_cache_time_seconds.has()) {
                    i3 = oidb_0xe3e_rspbody.uint32_cache_time_seconds.get();
                    if (i3 == 0 || i3 > 3600) {
                        i3 = 200;
                    }
                    h.l(String.valueOf(((Long) toServiceMsg.getAttribute("frienduin", 0L)).longValue()), System.currentTimeMillis());
                } else {
                    i3 = 0;
                }
                if (oidb_0xe3e_rspbody.rpt_group_list.has()) {
                    List<oidb_0xe3e$GroupList> list = oidb_0xe3e_rspbody.rpt_group_list.get();
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        com.tencent.mobileqq.activity.contact.troop.c cVar = new com.tencent.mobileqq.activity.contact.troop.c();
                        oidb_0xe3e$GroupList oidb_0xe3e_grouplist = list.get(i17);
                        if (oidb_0xe3e_grouplist.uint64_group_code.has()) {
                            j3 = oidb_0xe3e_grouplist.uint64_group_code.get();
                        } else {
                            j3 = 0;
                        }
                        if (oidb_0xe3e_grouplist.uint32_common_friend_count.has()) {
                            i16 = oidb_0xe3e_grouplist.uint32_common_friend_count.get();
                        } else {
                            i16 = 0;
                        }
                        cVar.f181390a = j3;
                        cVar.f181391b = i16;
                        arrayList.add(cVar);
                    }
                }
                notifyUI(8, true, new Object[]{Integer.valueOf(i3), arrayList});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("intimate_relationship", 2, "HandleGetTroopWithCommonFriendsList is failed");
            }
            notifyUI(8, false, new Object[]{0, arrayList});
        }
    }

    private void J2(long j3, boolean z16) {
        notifyUI(11, true, new Object[]{Long.valueOf(j3), Boolean.valueOf(z16)});
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xcf3$RspBody>() { // from class: tencent.im.oidb.oidb_0xcf3.oidb_0xcf3$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"intimate_list"}, new Object[]{null}, oidb_0xcf3$RspBody.class);
            public final PBRepeatMessageField<intimate_relation$IntimateInfo> intimate_list = PBField.initRepeatMessage(intimate_relation$IntimateInfo.class);
        });
        String string = toServiceMsg.extraData.getString("friendUin");
        if (parseOIDBPkg == 0) {
            ((c) this.f211745d.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).t(string);
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("handleDisbandIntimateRelationship, friendUin: %s, isSuccess: %s, result: %s", string, Boolean.valueOf(z16), Integer.valueOf(parseOIDBPkg)));
        }
        notifyUI(1, z16, new Object[]{string, Boolean.FALSE});
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IntimateInfo intimateInfo;
        boolean z16;
        oidb_0xcf4$RspBody oidb_0xcf4_rspbody = new oidb_0xcf4$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xcf4_rspbody);
        String string = toServiceMsg.extraData.getString("friendUin");
        if (parseOIDBPkg == 0) {
            intimateInfo = IntimateInfo.copyFrom(this.f211745d, oidb_0xcf4_rspbody);
            z16 = true;
        } else {
            intimateInfo = null;
            z16 = false;
        }
        if (intimateInfo != null) {
            c cVar = (c) this.f211745d.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
            IntimateInfo m3 = cVar.m(string);
            if (m3 != null) {
                intimateInfo.lastAnimAfterScore = m3.lastAnimAfterScore;
                intimateInfo.lastAnimAfterFriendDays = m3.lastAnimAfterFriendDays;
                if (QLog.isColorLevel()) {
                    QLog.d("intimate_relationship", 2, "handleGetIntimateInfo old: " + m3);
                }
            }
            cVar.w(string, intimateInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("handleGetIntimateInfo, isSuccess: %s, result: %s, intimateInfo: %s", Boolean.valueOf(z16), Integer.valueOf(parseOIDBPkg), intimateInfo));
        }
        notifyUI(0, z16, new Object[]{string, intimateInfo});
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IntimateInfo intimateInfo;
        boolean z16;
        oidb_0x1250$RspBody oidb_0x1250_rspbody = new oidb_0x1250$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x1250_rspbody);
        String string = toServiceMsg.extraData.getString("friendUin");
        if (parseOIDBPkg == 0) {
            intimateInfo = b.a(this.f211745d, oidb_0x1250_rspbody);
            z16 = true;
        } else {
            intimateInfo = null;
            z16 = false;
        }
        if (intimateInfo != null) {
            c cVar = (c) this.f211745d.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
            IntimateInfo m3 = cVar.m(string);
            if (m3 != null) {
                intimateInfo.lastAnimAfterScore = m3.lastAnimAfterScore;
                intimateInfo.lastAnimAfterFriendDays = m3.lastAnimAfterFriendDays;
                if (QLog.isColorLevel()) {
                    QLog.d("intimate_relationship", 2, "handleGetIntimateInfo old: " + m3);
                }
            }
            cVar.w(string, intimateInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("handleGetIntimateInfo, isSuccess: %s, result: %s, intimateInfo: %s", Boolean.valueOf(z16), Integer.valueOf(parseOIDBPkg), intimateInfo));
        }
        notifyUI(9, z16, new Object[]{string, intimateInfo});
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long longValue = ((Long) toServiceMsg.getAttribute("toUin", 0L)).longValue();
        long longValue2 = ((Long) toServiceMsg.getAttribute("fromUin", 0L)).longValue();
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "handleSendDateTypeEventToServer " + longValue + " " + longValue2);
        }
        oidb_0xcf4$RspBody oidb_0xcf4_rspbody = new oidb_0xcf4$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xcf4_rspbody);
        if (parseOIDBPkg == 0) {
            long j3 = oidb_0xcf4_rspbody.uint64_from_uin.get();
            long j16 = oidb_0xcf4_rspbody.uint64_to_uin.get();
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "handleSendDateTypeEventToServer succ: " + j3 + " " + j16);
            }
            notifyUI(6, true, new Object[]{Long.valueOf(j16)});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("intimate_relationship", 2, "handleSendDateTypeEventToServer failed result:" + parseOIDBPkg);
        }
        notifyUI(6, false, new Object[]{Long.valueOf(longValue)});
    }

    private void T2() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            MutualMarkDialogUtil.d(QBaseActivity.sTopActivity, null, false, System.currentTimeMillis());
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.friends.intimate.IntimateInfoHandler.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) IntimateInfoHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        MutualMarkDialogUtil.d(QBaseActivity.sTopActivity, null, false, System.currentTimeMillis());
                    }
                }
            });
        }
    }

    private void X2(boolean z16) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isStartLoading", z16);
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "MutualMarkIpcClient", "notifyUpdateWebCardLoading", bundle, null);
        } catch (Exception e16) {
            QLog.e("IntimateInfoHandler", 1, "push msg list to flutter failed", e16);
        }
    }

    private void Y2(ToServiceMsg toServiceMsg, boolean z16) {
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("changedCardId", ((Long) toServiceMsg.getAttribute("changedCardId")).longValue());
            bundle.putLong("changedCardUin", ((Long) toServiceMsg.getAttribute("changedCardUin")).longValue());
            bundle.putBoolean("isWearing", z16);
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "MutualMarkIpcClient", "notifyUpdateWebCard", bundle, null);
        } catch (Exception e16) {
            QLog.e("IntimateInfoHandler", 1, "push msg list to flutter failed", e16);
        }
    }

    public void E2(int i3, List<com.tencent.mobileqq.activity.contact.troop.c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("intimate_relationship", 2, "TroopWithCommonFriendsNotify");
        }
        notifyUI(8, true, new Object[]{Integer.valueOf(i3), list});
    }

    public void F2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("intimate_relationship", 1, "disbandIntimateRelationship friendUin is empty!");
            notifyUI(1, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, relationshipType: %s", str, Integer.valueOf(i3)));
        }
        try {
            oidb_0xcf3$ReqBody oidb_0xcf3_reqbody = new oidb_0xcf3$ReqBody();
            oidb_0xcf3_reqbody.sub_cmd.set(2);
            oidb_0xcf3_reqbody.target_uin.set(Long.valueOf(str).longValue());
            oidb_0xcf3_reqbody.intimate_type.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xcf3", 3315, 0, oidb_0xcf3_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("friendUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("intimate_relationship", 1, "disbandIntimateRelationship", e16);
            notifyUI(1, false, new Object[]{str, Boolean.FALSE});
        }
    }

    public void G2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("intimate_relationship", 1, "getIntimateInfo friendUin is empty!");
            notifyUI(0, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("getIntimateInfo, friendUin: %s", str));
        }
        try {
            oidb_0xcf4$ReqBody oidb_0xcf4_reqbody = new oidb_0xcf4$ReqBody();
            oidb_0xcf4$CommonBody oidb_0xcf4_commonbody = new oidb_0xcf4$CommonBody();
            ArrayList arrayList = new ArrayList();
            oidb_0xd6c$ReqBody oidb_0xd6c_reqbody = new oidb_0xd6c$ReqBody();
            oidb_0xd6c_reqbody.uint64_host_uin.set(Long.valueOf(this.f211745d.getCurrentAccountUin()).longValue());
            oidb_0xd6c_reqbody.uint64_friend_uin.set(Long.valueOf(str).longValue());
            oidb_0xcf4_commonbody.uint32_oidb_cmd.set(3436);
            oidb_0xcf4_commonbody.string_oidb_body.set(ByteStringMicro.copyFrom(oidb_0xd6c_reqbody.toByteArray()));
            arrayList.add(oidb_0xcf4_commonbody);
            oidb_0xcf4_reqbody.rpt_msg_common_reqbody.set(arrayList);
            oidb_0xcf4_reqbody.uint64_from_uin.set(Long.valueOf(this.f211745d.getCurrentAccountUin()).longValue());
            oidb_0xcf4_reqbody.uint64_to_uin.set(Long.valueOf(str).longValue());
            oidb_0xcf4_reqbody.bool_qzone_dna.set(true);
            oidb_0xcf4_reqbody.bool_new_dna.set(z16);
            oidb_0xcf4$CommonBody oidb_0xcf4_commonbody2 = new oidb_0xcf4$CommonBody();
            oidb_0xcf4_commonbody2.uint32_oidb_cmd.set(3460);
            MISC$StGetFriendPlayListV2Req mISC$StGetFriendPlayListV2Req = new MISC$StGetFriendPlayListV2Req();
            mISC$StGetFriendPlayListV2Req.friendUin.set(str);
            mISC$StGetFriendPlayListV2Req.pageSize.set(1);
            oidb_0xd84$ReqBody oidb_0xd84_reqbody = new oidb_0xd84$ReqBody();
            oidb_0xd84_reqbody.bytes_xmitinfo.set(ByteStringMicro.copyFrom(mISC$StGetFriendPlayListV2Req.toByteArray()));
            oidb_0xcf4_commonbody2.string_oidb_body.set(ByteStringMicro.copyFrom(oidb_0xd84_reqbody.toByteArray()));
            oidb_0xcf4_reqbody.rpt_msg_common_reqbody.add(oidb_0xcf4_commonbody2);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xcf4", 3316, 0, oidb_0xcf4_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("friendUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            e16.printStackTrace();
            notifyUI(0, false, new Object[]{str, null});
        }
    }

    public void H2(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("intimate_relationship", 2, "getTroopWithCommonFriendsList troopuin:" + j3);
        }
        oidb_0xe3e$ReqBody oidb_0xe3e_reqbody = new oidb_0xe3e$ReqBody();
        oidb_0xe3e_reqbody.uint64_friend_uin.set(j3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe3e", 3646, i3, oidb_0xe3e_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("frienduin", Long.valueOf(j3));
        sendPbReq(makeOIDBPkg);
    }

    public void I2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("intimate_relationship", 1, "getIntimateInfo friendUin is empty!");
            notifyUI(9, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("getIntimateInfo, friendUin: %s", str));
        }
        try {
            oidb_0x1250$ReqBody oidb_0x1250_reqbody = new oidb_0x1250$ReqBody();
            oidb_0xcf4$CommonBody oidb_0xcf4_commonbody = new oidb_0xcf4$CommonBody();
            ArrayList arrayList = new ArrayList();
            oidb_0xd6c$ReqBody oidb_0xd6c_reqbody = new oidb_0xd6c$ReqBody();
            oidb_0xd6c_reqbody.uint64_host_uin.set(Long.valueOf(this.f211745d.getCurrentAccountUin()).longValue());
            oidb_0xd6c_reqbody.uint64_friend_uin.set(Long.valueOf(str).longValue());
            oidb_0xcf4_commonbody.uint32_oidb_cmd.set(3436);
            oidb_0xcf4_commonbody.string_oidb_body.set(ByteStringMicro.copyFrom(oidb_0xd6c_reqbody.toByteArray()));
            arrayList.add(oidb_0xcf4_commonbody);
            oidb_0x1250_reqbody.rpt_msg_common_reqbody.set(arrayList);
            oidb_0x1250_reqbody.uint64_to_uin.set(Long.valueOf(str).longValue());
            oidb_0x1250_reqbody.bool_qzone_dna.set(true);
            oidb_0x1250_reqbody.bool_new_dna.set(z16);
            oidb_0xcf4$CommonBody oidb_0xcf4_commonbody2 = new oidb_0xcf4$CommonBody();
            oidb_0xcf4_commonbody2.uint32_oidb_cmd.set(3460);
            MISC$StGetFriendPlayListV2Req mISC$StGetFriendPlayListV2Req = new MISC$StGetFriendPlayListV2Req();
            mISC$StGetFriendPlayListV2Req.friendUin.set(str);
            mISC$StGetFriendPlayListV2Req.pageSize.set(1);
            COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
            COMM.Entry entry = new COMM.Entry();
            entry.key.set("scene");
            entry.value.set("closeness");
            stCommonExt.mapInfo.add(entry);
            mISC$StGetFriendPlayListV2Req.ext.set(stCommonExt);
            oidb_0xd84$ReqBody oidb_0xd84_reqbody = new oidb_0xd84$ReqBody();
            oidb_0xd84_reqbody.bytes_xmitinfo.set(ByteStringMicro.copyFrom(mISC$StGetFriendPlayListV2Req.toByteArray()));
            oidb_0xcf4_commonbody2.string_oidb_body.set(ByteStringMicro.copyFrom(oidb_0xd84_reqbody.toByteArray()));
            oidb_0x1250_reqbody.rpt_msg_common_reqbody.add(oidb_0xcf4_commonbody2);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x1250_0", 4688, 0, oidb_0x1250_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("friendUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            e16.printStackTrace();
            notifyUI(9, false, new Object[]{str, null});
        }
    }

    public void L2(boolean z16, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("intimate_relationship", 2, String.format("receive disband intimateLover: retcode %s, errmsg %s", Integer.valueOf(i3), str));
        }
        notifyUI(1, z16, new Object[]{str2, Boolean.FALSE});
    }

    public void N2(boolean z16, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str, str2, str3);
        } else {
            notifyUI(4, z16, new Object[]{str, str2, str3});
        }
    }

    public void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new wear$Rsp());
            if (parseOIDBPkg == 0) {
                J2(((Long) toServiceMsg.getAttribute("changedCardId")).longValue(), false);
                Y2(toServiceMsg, false);
                MutualMarkDialogUtil.e();
            }
            QLog.i("IntimateInfoHandler", 1, "handleWearResult: " + parseOIDBPkg);
        }
    }

    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new wear$Rsp());
            if (parseOIDBPkg == 0) {
                J2(((Long) toServiceMsg.getAttribute("changedCardId")).longValue(), true);
                Y2(toServiceMsg, true);
                MutualMarkDialogUtil.e();
            }
            QLog.i("IntimateInfoHandler", 1, "handleWearResult: " + parseOIDBPkg);
        }
    }

    public void S2(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (!g.b(BaseApplication.getContext())) {
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f171140iv0));
            return;
        }
        f211744e = j3;
        QQAppInterface qQAppInterface = this.f211745d;
        if (qQAppInterface == null) {
            return;
        }
        ((PaiYiPaiHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).M2(String.valueOf(j3), String.valueOf(j3), 0, 0);
        T2();
        X2(true);
    }

    public void U2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        MutualChange$Req mutualChange$Req = new MutualChange$Req();
        if (!TextUtils.isEmpty(str) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, "IntimateInfoHandler")) {
            long parseLong = Long.parseLong(str);
            mutualChange$Req.uin.set(parseLong);
            mutualChange$Req.f381295id.set(44L);
            mutualChange$Req.type.set(1);
            mutualChange$Req.current_time.set(NetConnInfoCenter.getServerTimeMillis() / 1000);
            MutualChange$Info mutualChange$Info = new MutualChange$Info();
            mutualChange$Info.level.set(1L);
            mutualChange$Req.new_info.set(mutualChange$Info);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x127b_1", 4731, 1, mutualChange$Req.toByteArray());
            makeOIDBPkg.addAttribute("changedCardId", 44L);
            makeOIDBPkg.addAttribute("changedCardUin", Long.valueOf(parseLong));
            sendPbReq(makeOIDBPkg);
        }
    }

    public void V2(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        if (!g.b(BaseApplication.getContext())) {
            QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f171140iv0));
            return;
        }
        wear$Req wear_req = new wear$Req();
        wear_req.uin.set(j3);
        wear_req.f381296id.set(j16);
        PBEnumField pBEnumField = wear_req.action;
        if (z16) {
            i3 = 1;
        }
        pBEnumField.set(i3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x1254_0", 4692, 0, wear_req.toByteArray());
        makeOIDBPkg.addAttribute("changedCardId", Long.valueOf(j16));
        makeOIDBPkg.addAttribute("changedCardUin", Long.valueOf(j3));
        sendPbReq(makeOIDBPkg);
        T2();
        X2(true);
    }

    public void W2(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "sendDateTypeEventToServer " + j3 + " " + i3);
        }
        oidb_0xcf4$ReqBody oidb_0xcf4_reqbody = new oidb_0xcf4$ReqBody();
        long longAccountUin = this.f211745d.getLongAccountUin();
        oidb_0xcf4_reqbody.uint64_from_uin.set(longAccountUin);
        oidb_0xcf4_reqbody.uint64_to_uin.set(j3);
        oidb_0xcf4_reqbody.eDateType.set(i3);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xcf4_1", 3316, 1, oidb_0xcf4_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("toUin", Long.valueOf(j3));
        makeOIDBPkg.addAttribute("fromUin", Long.valueOf(longAccountUin));
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public List<BusinessObserver> getObservers(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f211745d.getBusinessObserver(i3);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        if ("OidbSvc.0xcf3".equals(fromServiceMsg.getServiceCmd())) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xcf4".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xcf4_1".equals(fromServiceMsg.getServiceCmd())) {
            Q2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe3e".equals(fromServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvcTrpcTcp.0x1250_0".equals(fromServiceMsg.getServiceCmd())) {
            O2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvcTrpcTcp.0x1254_0".equals(fromServiceMsg.getServiceCmd())) {
            R2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvcTrpcTcp.0x127b_1".equals(fromServiceMsg.getServiceCmd())) {
            P2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
