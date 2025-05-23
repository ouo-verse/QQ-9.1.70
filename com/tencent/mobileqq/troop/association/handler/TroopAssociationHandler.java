package com.tencent.mobileqq.troop.association.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.association.api.a;
import com.tencent.mobileqq.troop.association.api.b;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0xede.oidb_0xede$GroupInfo;
import tencent.im.oidb.cmd0xede.oidb_0xede$ReqBody;
import tencent.im.oidb.cmd0xede.oidb_0xede$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAssociationHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f294470e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicLong f294471f;

    public TroopAssociationHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f294471f = new AtomicLong(0L);
        }
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        Iterator<oidb_0xede$GroupInfo> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("troopUin");
            int i16 = toServiceMsg.extraData.getInt("opType");
            long j3 = toServiceMsg.extraData.getLong("getseq");
            try {
                oidb_0xede$RspBody oidb_0xede_rspbody = new oidb_0xede$RspBody();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xede_rspbody);
                if (parseOIDBPkg != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp failed, result: " + parseOIDBPkg);
                    }
                    notifyUI(b.f294469e, false, new Object[]{string, Integer.valueOf(i16), Long.valueOf(j3), null});
                    return;
                }
                AllianceItem allianceItem = new AllianceItem();
                if (oidb_0xede_rspbody.uint32_group_info_size.has()) {
                    i3 = oidb_0xede_rspbody.uint32_group_info_size.get();
                } else {
                    i3 = 0;
                }
                allianceItem.associatedTroopCount = i3;
                if (i16 == 3) {
                    ((IBizTroopInfoService) this.appRuntime.getRuntimeService(IBizTroopInfoService.class, "")).setAssociatedTroopCount(string, i3);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp succ, opType: " + i16 + " count: " + i3);
                    }
                    notifyUI(b.f294469e, true, new Object[]{string, Integer.valueOf(i16), Long.valueOf(j3), allianceItem});
                    return;
                }
                long j16 = oidb_0xede_rspbody.uint64_next_group_code.get();
                ArrayList arrayList = new ArrayList();
                Iterator<oidb_0xede$GroupInfo> it5 = oidb_0xede_rspbody.rpt_group_info.get().iterator();
                while (it5.hasNext()) {
                    oidb_0xede$GroupInfo next = it5.next();
                    AssociatedTroopItem associatedTroopItem = new AssociatedTroopItem();
                    associatedTroopItem.uin = String.valueOf(next.uint64_group_code.get());
                    if (next.string_group_name.has()) {
                        it = it5;
                        associatedTroopItem.name = new String(next.string_group_name.get().toByteArray());
                    } else {
                        it = it5;
                    }
                    associatedTroopItem.maxMemberNum = next.uint32_group_member_max_num.get();
                    associatedTroopItem.memberNum = next.uint32_group_member_num.get();
                    associatedTroopItem.relateStatus = next.uint32_status.get();
                    associatedTroopItem.relateType = next.uint32_type.get();
                    associatedTroopItem.privilege = next.uint32_role.get();
                    associatedTroopItem.intro = new String(next.string_group_finger_memo.get().toByteArray());
                    associatedTroopItem.richIntro = new String(next.string_group_rich_finger_memo.get().toByteArray());
                    associatedTroopItem.groupFace = next.uint32_group_face.get();
                    associatedTroopItem.isConfGroup = next.uint32_is_conf_group.get();
                    if (i16 == 2) {
                        associatedTroopItem.seq = next.uint32_seq.get();
                        if (next.bytes_join_group_auth.has()) {
                            associatedTroopItem.joinAuth = new String(next.bytes_join_group_auth.get().toByteArray());
                        }
                    }
                    associatedTroopItem.labelList = AssociatedTroopItem.transLabel(next.rpt_group_label.get());
                    arrayList.add(associatedTroopItem);
                    it5 = it;
                }
                allianceItem.uin = String.valueOf(oidb_0xede_rspbody.uint64_alliance_id.get());
                allianceItem.adminUin = String.valueOf(oidb_0xede_rspbody.uint64_alliance_admin_uin.get());
                allianceItem.adminName = new String(oidb_0xede_rspbody.str_alliance_admin_name.get().toByteArray());
                allianceItem.createTime = oidb_0xede_rspbody.uint64_alliance_create_time.get();
                allianceItem.associatedTroopList = arrayList;
                if (j16 > 0) {
                    str = String.valueOf(j16);
                } else {
                    str = null;
                }
                allianceItem.nextTroopUin = str;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp succ, opType: " + i16 + " count: " + i3 + " allianceItem: " + allianceItem.toString());
                }
                notifyUI(b.f294469e, true, new Object[]{string, Integer.valueOf(i16), Long.valueOf(j3), allianceItem});
                return;
            } catch (Exception e16) {
                notifyUI(b.f294469e, false, new Object[]{string, Integer.valueOf(i16), Long.valueOf(j3), null});
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp e: " + e16);
                }
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAssociationHandler", 2, "handleGetRelatedTroopListResp resp == null || res == null");
        }
        notifyUI(b.f294469e, false, new Object[]{"", -1, -1, null});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f294470e == null) {
            HashSet hashSet = new HashSet();
            this.f294470e = hashSet;
            hashSet.add("OidbSvc.0xede_1");
        }
        return this.f294470e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopAssociationHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssociationHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssociationHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xede_1".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAssociationHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.association.api.a
    public long z0(String str, int i3, String str2) {
        long j3;
        long longValue;
        String str3 = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str3)).longValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAssociationHandler", 2, "getAssociatedTroopList troopUin =  " + str + " opType: " + i3 + " startTroopUin: " + str3);
        }
        long andIncrement = this.f294471f.getAndIncrement();
        oidb_0xede$ReqBody oidb_0xede_reqbody = new oidb_0xede$ReqBody();
        try {
            oidb_0xede_reqbody.uint64_group_code.set(Long.valueOf(str).longValue());
            oidb_0xede_reqbody.uint32_op_type.set(i3);
            if (TextUtils.isEmpty(str2)) {
                longValue = 0;
            } else {
                longValue = Long.valueOf(str2).longValue();
            }
            oidb_0xede_reqbody.uint64_start_group_code.set(longValue);
            j3 = andIncrement;
            try {
                ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xede_1", 3806, 1, oidb_0xede_reqbody.toByteArray(), 30000L);
                makeOIDBPkg.extraData.putString("troopUin", str);
                makeOIDBPkg.extraData.putInt("opType", i3);
                Bundle bundle = makeOIDBPkg.extraData;
                if (TextUtils.isEmpty(str2)) {
                    str3 = "0";
                }
                bundle.putString("startUin", str3);
                makeOIDBPkg.extraData.putLong("getseq", j3);
                sendPbReq(makeOIDBPkg);
            } catch (Exception e16) {
                e = e16;
                notifyUI(b.f294469e, false, new Object[]{str, Integer.valueOf(i3), Long.valueOf(j3), null});
                e.printStackTrace();
                return j3;
            }
        } catch (Exception e17) {
            e = e17;
            j3 = andIncrement;
        }
        return j3;
    }
}
