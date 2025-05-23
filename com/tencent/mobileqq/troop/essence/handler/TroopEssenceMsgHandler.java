package com.tencent.mobileqq.troop.essence.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.qqnt.troop.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$BatchRspBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$ReqBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac$RspBody;
import tencent.im.oidb.cmd0xf10.oidb_0xf10$MsgContent;
import tencent.im.oidb.cmd0xf10.oidb_0xf10$MsgInfo;
import tencent.im.oidb.cmd0xf10.oidb_0xf10$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopEssenceMsgHandler extends TroopBaseHandler implements is2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f295285e;

    public TroopEssenceMsgHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(String str, boolean z16, boolean z17, int i3, String str2) {
        if (!z17) {
            QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp errCode\uff1a" + i3 + ", errMsg=" + str2);
            notifyUI(f.f298017i, false, new Object[]{str, Boolean.valueOf(z16)});
            return;
        }
        QLog.i("TroopEssenceMsgHandler", 1, "handleSettEssenceMsgShowInCardSwitchResp isChecked:" + z16);
        notifyUI(f.f298017i, true, new Object[]{str, Boolean.valueOf(z16)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(String str, boolean z16, boolean z17, int i3, String str2) {
        if (!z17) {
            QLog.e("TroopEssenceMsgHandler", 2, "handleSetEssentialMsgPrilivegeSwitchResp resp rs\uff1a" + i3 + ", errMsg=" + str2);
            notifyUI(f.f298018m, false, new Object[]{str, Boolean.valueOf(z16)});
            return;
        }
        QLog.i("TroopEssenceMsgHandler", 1, "handleSetEssentialMsgPrilivegeSwitchResp isChecked:" + z16);
        notifyUI(f.f298018m, true, new Object[]{str, Boolean.valueOf(z16)});
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xeac$BatchRspBody oidb_0xeac_batchrspbody = new oidb_0xeac$BatchRspBody();
            long j3 = toServiceMsg.extraData.getLong("troopUin");
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xeac_batchrspbody);
            if (parseOIDBPkg != 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopEssenceMsgHandler", 2, "handleBatchSetTroopEssenceMsgs failed result:" + parseOIDBPkg);
                }
                notifyUI(f.f298015f, false, new Object[]{Long.valueOf(j3), toServiceMsg.extraData.getSerializable("extdata"), oidb_0xeac_batchrspbody, Integer.valueOf(parseOIDBPkg)});
                return;
            }
            notifyUI(f.f298015f, true, new Object[]{Long.valueOf(j3), toServiceMsg.extraData.getSerializable("extdata"), oidb_0xeac_batchrspbody, Integer.valueOf(parseOIDBPkg)});
            return;
        }
        notifyUI(f.f298015f, false, new Object[]{0, null, null, -1});
    }

    public void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("troopUin");
            int i3 = toServiceMsg.extraData.getInt("source");
            try {
                oidb_0xf10$RspBody oidb_0xf10_rspbody = new oidb_0xf10$RspBody();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xf10_rspbody);
                if (parseOIDBPkg != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopEssenceMsgHandler", 2, "handleGetEssenceMsgListResp failed, result: " + parseOIDBPkg);
                    }
                    notifyUI(f.f298016h, false, null);
                    return;
                }
                int i16 = oidb_0xf10_rspbody.total_count.get();
                String str = oidb_0xf10_rspbody.jump_url.get();
                ArrayList arrayList = new ArrayList();
                for (oidb_0xf10$MsgInfo oidb_0xf10_msginfo : oidb_0xf10_rspbody.msg_list.get()) {
                    if (oidb_0xf10_msginfo != null) {
                        TroopCardEssenceMsg troopCardEssenceMsg = new TroopCardEssenceMsg();
                        troopCardEssenceMsg.troopUin = string;
                        troopCardEssenceMsg.jumpUrl = str;
                        if (troopCardEssenceMsg.msgContent == null) {
                            troopCardEssenceMsg.msgContent = new ArrayList();
                        }
                        for (oidb_0xf10$MsgContent oidb_0xf10_msgcontent : oidb_0xf10_msginfo.msg_content.get()) {
                            if (oidb_0xf10_msgcontent != null) {
                                TroopCardEssenceMsg.EssenceMsgContent essenceMsgContent = new TroopCardEssenceMsg.EssenceMsgContent();
                                essenceMsgContent.msgType = oidb_0xf10_msgcontent.msg_type.get();
                                essenceMsgContent.text = oidb_0xf10_msgcontent.text.get();
                                essenceMsgContent.faceIndext = oidb_0xf10_msgcontent.face_index.get();
                                essenceMsgContent.faceText = oidb_0xf10_msgcontent.face_text.get();
                                essenceMsgContent.imageUrl = oidb_0xf10_msgcontent.image_url.get();
                                essenceMsgContent.imageThumbnailUrl = oidb_0xf10_msgcontent.image_thumbnail_url.get();
                                essenceMsgContent.shareTitle = oidb_0xf10_msgcontent.share_title.get();
                                essenceMsgContent.shareSummary = oidb_0xf10_msgcontent.share_summary.get();
                                essenceMsgContent.shareBrief = oidb_0xf10_msgcontent.share_brief.get();
                                essenceMsgContent.shareUrl = oidb_0xf10_msgcontent.share_url.get();
                                essenceMsgContent.shareAction = oidb_0xf10_msgcontent.share_action.get();
                                essenceMsgContent.shareSource = oidb_0xf10_msgcontent.share_source.get();
                                essenceMsgContent.shareImageUrl = oidb_0xf10_msgcontent.share_image_url.get();
                                essenceMsgContent.fileThumbnailUrl = oidb_0xf10_msgcontent.file_thumbnail_url.get();
                                essenceMsgContent.fileSize = oidb_0xf10_msgcontent.file_size.get();
                                essenceMsgContent.fileName = oidb_0xf10_msgcontent.file_name.get();
                                essenceMsgContent.jumpUrlForMore = oidb_0xf10_msginfo.jump_url.get();
                                troopCardEssenceMsg.msgContent.add(essenceMsgContent);
                            }
                        }
                        arrayList.add(troopCardEssenceMsg);
                    }
                }
                notifyUI(f.f298016h, true, new Object[]{string, Integer.valueOf(i3), arrayList, Integer.valueOf(i16)});
                return;
            } catch (Exception e16) {
                notifyUI(f.f298016h, false, new Object[]{string, Integer.valueOf(i3), null});
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopEssenceMsgHandler", 2, "handleGetEssenceMsgListResp resp == null || res == null");
        }
        notifyUI(f.f298016h, false, null);
    }

    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xeac$RspBody oidb_0xeac_rspbody = new oidb_0xeac$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xeac_rspbody);
            int i3 = toServiceMsg.extraData.getInt("from");
            if (parseOIDBPkg == 0) {
                notifyUI(f.f298014e, true, new Object[]{toServiceMsg.extraData.getSerializable("extdata"), oidb_0xeac_rspbody, Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3)});
                return;
            }
            QLog.i("TroopEssenceMsgHandler", 2, "handleSetTroopEssenceMsg failed result:" + parseOIDBPkg);
            notifyUI(f.f298014e, false, new Object[]{toServiceMsg.extraData.getSerializable("extdata"), oidb_0xeac_rspbody, Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3)});
            return;
        }
        notifyUI(f.f298014e, false, new Object[]{0, null, -1});
    }

    @Override // is2.a
    public void Y(TroopEssenceMsgItem troopEssenceMsgItem, int i3) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopEssenceMsgItem, i3);
            return;
        }
        if (troopEssenceMsgItem == null) {
            return;
        }
        oidb_0xeac$ReqBody oidb_0xeac_reqbody = new oidb_0xeac$ReqBody();
        oidb_0xeac_reqbody.group_code.set(troopEssenceMsgItem.troopUin);
        oidb_0xeac_reqbody.msg_seq.set(((int) troopEssenceMsgItem.msgSeq) & (-1));
        oidb_0xeac_reqbody.msg_random.set(troopEssenceMsgItem.msgRandom);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3756);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(troopEssenceMsgItem.opType);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xeac_reqbody.toByteArray()));
        int i16 = troopEssenceMsgItem.opType;
        if (i16 == 1) {
            toServiceMsg = createToServiceMsg("OidbSvc.0xeac_1");
        } else if (i16 == 2) {
            toServiceMsg = createToServiceMsg("OidbSvc.0xeac_2");
        } else {
            toServiceMsg = null;
        }
        if (toServiceMsg != null) {
            toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            toServiceMsg.setTimeout(5000L);
            toServiceMsg.extraData.putSerializable("extdata", troopEssenceMsgItem);
            toServiceMsg.extraData.putInt("from", i3);
            sendPbReq(toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f295285e == null) {
            HashSet hashSet = new HashSet();
            this.f295285e = hashSet;
            hashSet.add("OidbSvc.0xeac_1");
            this.f295285e.add("OidbSvc.0xeac_2");
            this.f295285e.add("OidbSvc.0xeac_4");
            this.f295285e.add("OidbSvc.0xf10");
        }
        return this.f295285e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopEssenceMsgHandler";
    }

    @Override // is2.a
    public void h1(final String str, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopEssenceMsgHandler", 1, "setEssenceMsgShowInCardSwitch troopUin is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgHandler", 1, "setEssenceMsgShowInCardSwitch troopUin=" + str + ",isChecked" + z16);
        }
        TroopOperationRepo.INSTANCE.updateTroopEssenceSwitch(str, z16 ? 1 : 0, new e() { // from class: com.tencent.mobileqq.troop.essence.handler.b
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z17, int i3, String str2) {
                TroopEssenceMsgHandler.this.K2(str, z16, z17, i3, str2);
            }
        });
    }

    @Override // is2.a
    public void n0(final String str, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopEssenceMsgHandler", 1, "setEssentialMsgPrilivegeSwitch troopUin is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgHandler", 1, "setEssentialMsgPrilivegeSwitch troopUin=" + str + ",isChecked" + z16);
        }
        TroopOperationRepo troopOperationRepo = TroopOperationRepo.INSTANCE;
        if (!z16) {
            i3 = 1;
        }
        troopOperationRepo.updateTroopEssencePrivilege(str, i3, new e() { // from class: com.tencent.mobileqq.troop.essence.handler.a
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z17, int i16, String str2) {
                TroopEssenceMsgHandler.this.L2(str, z16, z17, i16, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEssenceMsgHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEssenceMsgHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopEssenceMsgHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                return;
            }
            return;
        }
        if (!"OidbSvc.0xeac_1".equals(fromServiceMsg.getServiceCmd()) && !"OidbSvc.0xeac_2".equals(fromServiceMsg.getServiceCmd())) {
            if ("OidbSvc.0xeac_4".equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0xf10".equals(fromServiceMsg.getServiceCmd())) {
                    I2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        J2(toServiceMsg, fromServiceMsg, obj);
    }
}
