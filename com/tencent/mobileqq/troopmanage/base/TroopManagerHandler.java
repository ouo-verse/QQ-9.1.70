package com.tencent.mobileqq.troopmanage.base;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.mobileqq.troopmanage.pb.Oidb_0x8c2$RspBody;
import com.tencent.mobileqq.troopmanage.pb.PrettyTroopEntry;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$Entrance;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$GetManagePageRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopOperationRepo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6$RspBody;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6$RspInfo;
import tencent.im.oidb.cmd0x934.cmd0x934$Item;
import tencent.im.oidb.cmd0x934.cmd0x934$List;
import tencent.im.oidb.cmd0xaf2.oidb_0xaf2$RspBody;
import tencent.im.oidb.cmd0xb69.oidb_0xb69$RspBody;
import tencent.im.oidb.cmd0xeff.oidb_0xeff$ReqBody;
import tencent.im.oidb.cmd0xeff.oidb_0xeff$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManagerHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public TroopManagerHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            PrettyTroopEntry.GetCareTextReply getCareTextReply = new PrettyTroopEntry.GetCareTextReply();
            try {
                getCareTextReply.mergeFrom((byte[]) obj);
                notifyUI(28, true, new Object[]{getCareTextReply});
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                notifyUI(28, false, null);
                return;
            }
        }
        notifyUI(28, false, null);
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("TroopManagerHandler", 1, "mergeSSO error!!!", e16);
            }
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopWalletVisibility|oidb_sso.OIDBSSOPkg.result " + i3);
            }
            if (i3 == 0 && QLog.isColorLevel()) {
                QLog.d("TroopManagerHandler", 2, "handleSetTroopAppPermissionsucceed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2(String str, boolean z16, IntelligentManageSvrPB$GetManagePageRsp intelligentManageSvrPB$GetManagePageRsp) {
        if (!z16) {
            QLog.e("TroopManagerHandler", 1, "[getIntelligentManagerEntrance] fail, troopUin == " + str + ", resp = " + intelligentManageSvrPB$GetManagePageRsp);
            notifyUI(26, false, null);
            return;
        }
        notifyUI(26, true, new Object[]{T2(str, intelligentManageSvrPB$GetManagePageRsp)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P2(int i3, boolean z16, int i16, String str) {
        QLog.d("TroopManagerHandler", 2, "modifyInviteRobotExamine: isSuccess=" + z16 + "\uff0cerrCode=" + i16 + "\uff0cerrMsg=" + str);
        if (!z16) {
            notifyUI(30, true, Integer.valueOf(i3));
        } else {
            notifyUI(30, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(Boolean bool, boolean z16, int i3, String str) {
        QLog.d("TroopManagerHandler", 2, "modifyInviteRobotSwitch: isSuccess=" + z16 + "\uff0cerrCode=" + i3 + "\uff0cerrMsg=" + str);
        if (z16) {
            notifyUI(29, true, bool);
        } else {
            notifyUI(29, false, null);
        }
    }

    public void G2(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            QLog.i("TroopManagerHandler", 1, "[getSmartManagerEntrance] troopUin is empty!");
        } else {
            ((ITroopIntelligentManageApi) QRoute.api(ITroopIntelligentManageApi.class)).getIntelligentSettingItem(str, new ITroopIntelligentManageApi.d() { // from class: com.tencent.mobileqq.troopmanage.base.c
                @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi.d
                public final void a(boolean z16, IntelligentManageSvrPB$GetManagePageRsp intelligentManageSvrPB$GetManagePageRsp) {
                    TroopManagerHandler.this.O2(str, z16, intelligentManageSvrPB$GetManagePageRsp);
                }
            });
        }
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("TroopManagerHandler", 1, "mergeSSO error!!!", e16);
            }
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopWalletVisibility|oidb_sso.OIDBSSOPkg.result " + i3);
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                oidb_0xb69$RspBody oidb_0xb69_rspbody = new oidb_0xb69$RspBody();
                try {
                    oidb_0xb69_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0xb69_rspbody.app_info.has() && oidb_0xb69_rspbody.app_info.get().size() > 0) {
                        notifyUI(18, true, oidb_0xb69_rspbody.app_info.get());
                    }
                } catch (Exception e17) {
                    QLog.e("TroopManagerHandler", 1, "mergeFrom error!!!", e17);
                }
            }
        }
    }

    protected void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_DISBAND, 2, "handle_oidb_0x8c2|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null) {
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_DISBAND, 2, "handle_oidb_0x8c2|oidb_sso.OIDBSSOPkg.result " + i3);
                }
            } else {
                i3 = -1;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                try {
                    Oidb_0x8c2$RspBody oidb_0x8c2$RspBody = new Oidb_0x8c2$RspBody();
                    oidb_0x8c2$RspBody.mergeFrom(byteArray);
                    j3 = oidb_0x8c2$RspBody.robot_uin.get();
                    z16 = true;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TROOP_DISBAND, 2, e17.toString());
                    }
                }
                notifyUI(13, z16, new Object[]{Long.valueOf(j3)});
            }
            j3 = -1;
            z16 = false;
            notifyUI(13, z16, new Object[]{Long.valueOf(j3)});
        }
    }

    public void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xeff$RspBody>() { // from class: tencent.im.oidb.cmd0xeff.oidb_0xeff$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xeff$RspBody.class);
            });
            String string = toServiceMsg.extraData.getString("troopUin");
            boolean z16 = toServiceMsg.extraData.getBoolean(h.f248218g);
            if (parseOIDBPkg == 0) {
                notifyUI(27, true, new Object[]{Integer.valueOf(parseOIDBPkg), string, Boolean.valueOf(z16)});
                return;
            } else {
                notifyUI(27, false, new Object[]{Integer.valueOf(parseOIDBPkg), string, Boolean.valueOf(z16)});
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerHandler", 2, "handleGetTroopInfoExtBy0xef0 resp == null || res == null");
        }
    }

    public void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopWalletVisibility|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopWalletVisibility|oidb_sso.OIDBSSOPkg.result " + i3);
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                try {
                    new MessageMicro<oidb_0xaf2$RspBody>() { // from class: tencent.im.oidb.cmd0xaf2.oidb_0xaf2$RspBody
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xaf2$RspBody.class);
                    }.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    z16 = true;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TROOP_DISBAND, 2, e17.toString());
                    }
                }
                notifyUI(16, z16, new Object[]{Boolean.valueOf(z16)});
            }
            z16 = false;
            notifyUI(16, z16, new Object[]{Boolean.valueOf(z16)});
        }
    }

    public void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null) {
                    int i3 = mergeFrom.uint32_result.get();
                    if (QLog.isDevelopLevel()) {
                        QLog.i(LogTag.TAG_TROOP_MANAGE, 4, "handle_oidb_0x6f6_0 |oidb_sso.OIDBSSOPkg.result = " + i3);
                    }
                }
                if (mergeFrom != null && (pBUInt32Field = mergeFrom.uint32_result) != null && pBUInt32Field.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = mergeFrom.bytes_bodybuffer.get().toByteArray();
                    try {
                        oidb_cmd0x6f6$RspBody oidb_cmd0x6f6_rspbody = new oidb_cmd0x6f6$RspBody();
                        oidb_cmd0x6f6_rspbody.mergeFrom(byteArray);
                        List<oidb_cmd0x6f6$RspInfo> list = oidb_cmd0x6f6_rspbody.rpt_msg_rsp_info.get();
                        if (list != null) {
                            if (list.size() > 0) {
                                try {
                                    notifyUI(10, true, new Object[]{list});
                                    return;
                                } catch (Exception e16) {
                                    e = e16;
                                    z16 = true;
                                    if (QLog.isDevelopLevel()) {
                                        QLog.i(LogTag.TAG_TROOP_MANAGE, 4, "handle_oidb_0x6f6_0|exception = " + e.toString());
                                    }
                                    notifyUI(10, z16, new Object[]{null});
                                }
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        z16 = false;
                    }
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(LogTag.TAG_TROOP_MANAGE, 4, "handle_oidb_0x6f6_0 | oidb_sso parseFrom byte " + e18.toString());
                }
                notifyUI(10, false, new Object[]{null});
                return;
            }
        }
        z16 = false;
        notifyUI(10, z16, new Object[]{null});
    }

    public void R2(String str, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        } else {
            TroopOperationRepo.INSTANCE.updateRobotMemberExamine(str, i3, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.base.d
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i16, String str2) {
                    TroopManagerHandler.this.P2(i3, z16, i16, str2);
                }
            });
        }
    }

    public void S2(String str, final Boolean bool) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bool);
            return;
        }
        if (bool.booleanValue()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        TroopOperationRepo.INSTANCE.updateAllowMemberInviteRobotSwitch(str, i3, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.base.e
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str2) {
                TroopManagerHandler.this.Q2(bool, z16, i16, str2);
            }
        });
    }

    public List<com.tencent.mobileqq.troopmanage.model.a> T2(String str, IntelligentManageSvrPB$GetManagePageRsp intelligentManageSvrPB$GetManagePageRsp) {
        List<Integer> arrayList;
        List<IntelligentManageSvrPB$Entrance> arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) intelligentManageSvrPB$GetManagePageRsp);
        }
        ArrayList arrayList3 = new ArrayList();
        if (intelligentManageSvrPB$GetManagePageRsp != null && intelligentManageSvrPB$GetManagePageRsp.cmd0x934_rsp_body.lists.has()) {
            if (intelligentManageSvrPB$GetManagePageRsp.need_admin_0x934_item_ids.has()) {
                arrayList = intelligentManageSvrPB$GetManagePageRsp.need_admin_0x934_item_ids.get();
            } else {
                arrayList = new ArrayList<>();
            }
            List<cmd0x934$List> list = intelligentManageSvrPB$GetManagePageRsp.cmd0x934_rsp_body.lists.get();
            if (list != null && !list.isEmpty()) {
                Iterator<cmd0x934$List> it = list.iterator();
                while (it.hasNext()) {
                    List<cmd0x934$Item> list2 = it.next().items.get();
                    if (list2 != null && !list2.isEmpty()) {
                        for (cmd0x934$Item cmd0x934_item : list2) {
                            com.tencent.mobileqq.troopmanage.model.a b16 = com.tencent.mobileqq.troopmanage.model.a.b(cmd0x934_item, str);
                            if (b16 != null) {
                                b16.f303152f = arrayList.contains(Integer.valueOf(cmd0x934_item.f435981id.get()));
                                arrayList3.add(b16);
                            }
                        }
                    }
                }
            }
            if (intelligentManageSvrPB$GetManagePageRsp.other_entrances.has()) {
                arrayList2 = intelligentManageSvrPB$GetManagePageRsp.other_entrances.get();
            } else {
                arrayList2 = new ArrayList<>();
            }
            Iterator<IntelligentManageSvrPB$Entrance> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.troopmanage.model.a a16 = com.tencent.mobileqq.troopmanage.model.a.a(it5.next());
                if (a16 != null) {
                    arrayList3.add(a16);
                }
            }
        }
        return arrayList3;
    }

    public void U2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerHandler", 2, "setTroopLuckyCharacterSwitch troopUin = " + str + ", isOpen = " + z16);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            if (longValue == 0) {
                return;
            }
            oidb_0xeff$ReqBody oidb_0xeff_reqbody = new oidb_0xeff$ReqBody();
            PBUInt32Field pBUInt32Field = oidb_0xeff_reqbody.cmd;
            if (!z16) {
                i3 = 2;
            }
            pBUInt32Field.set(i3);
            oidb_0xeff_reqbody.group_code.set(longValue);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xeff_1", 3839, 1, oidb_0xeff_reqbody.toByteArray(), 30000L);
            makeOIDBPkg.extraData.putString("troopUin", str);
            makeOIDBPkg.extraData.putBoolean(h.f248218g, z16);
            sendPbReq(makeOIDBPkg);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("OidbSvc.0x6f6_0");
        hashSet.add("OidbSvc.0x8c2_2");
        hashSet.add("OidbSvc.0xaf2");
        hashSet.add("OidbSvc.0xb69_3");
        hashSet.add("OidbSvc.0xb69_4");
        hashSet.add("OidbSvc.0xeff_1");
        hashSet.add("vapfService.group_haoma_server.GetCareText");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            return;
        }
        if ("OidbSvc.0x6f6_0".equals(fromServiceMsg.getServiceCmd())) {
            N2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x8c2_2".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xaf2".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xb69_3".equals(fromServiceMsg.getServiceCmd())) {
            H2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xb69_4".equals(fromServiceMsg.getServiceCmd())) {
            K2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xeff_1".equals(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
        } else if ("vapfService.group_haoma_server.GetCareText".equals(fromServiceMsg.getServiceCmd())) {
            J2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
