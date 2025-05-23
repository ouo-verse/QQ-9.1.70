package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9$GetListReq;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9$GetListRsp;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9$ReqBody;
import tencent.im.oidb.cmd0xae9.Oidb_0xae9$RspBody;
import tencent.im.oidb.cmd0xae9.group_online_docs$DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs$DocId;
import tencent.im.oidb.cmd0xae9.online_docs$DocMetaData;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea$DeleteDocReq;
import tencent.im.oidb.cmd0xaea.Oidb_0xaea$ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee$ReqBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee$RspBody;
import tencent.im.oidb.cmd0xaee.Oidb_0xaee$Template;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef$ReqBody;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef$RspBody;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef$SearchDocReq;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef$SearchDocRsp;
import tencent.im.oidb.cmd0xaef.Oidb_0xaef$SearchItem;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupTeamWorkHandlerImpl extends BusinessHandler implements IGroupTeamWorkHandler {
    public static String TAG = "GroupTeamWorkHandlerImpl";
    private AppInterface app;

    public GroupTeamWorkHandlerImpl(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    public static synchronized void buildPadInfo(GPadInfo gPadInfo, group_online_docs$DocInfo group_online_docs_docinfo, long j3) {
        online_docs$DocId online_docs_docid;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        synchronized (GroupTeamWorkHandlerImpl.class) {
            if (gPadInfo != null && group_online_docs_docinfo != null) {
                online_docs$DocMetaData online_docs_docmetadata = group_online_docs_docinfo.doc_meta_data;
                if (online_docs_docmetadata != null && (online_docs_docid = online_docs_docmetadata.doc_id) != null) {
                    gPadInfo.domainId = online_docs_docid.domain_id.get();
                    if (online_docs_docid.pad_id.has()) {
                        str = online_docs_docid.pad_id.get().toStringUtf8();
                    } else {
                        str = "";
                    }
                    gPadInfo.padId = str;
                    if (online_docs_docmetadata.title.has()) {
                        str2 = online_docs_docmetadata.title.get().toStringUtf8();
                    } else {
                        str2 = "";
                    }
                    gPadInfo.title = str2;
                    gPadInfo.creatorUin = online_docs_docmetadata.creator_uin.get();
                    gPadInfo.createTime = online_docs_docmetadata.create_ts.get();
                    gPadInfo.lastEditorUin = online_docs_docmetadata.last_modify_uin.get();
                    gPadInfo.lastEditTime = online_docs_docmetadata.last_modify_ts.get() * 1000;
                    gPadInfo.ownerUin = online_docs_docmetadata.owner_uin.get();
                    boolean z16 = true;
                    if (online_docs_docmetadata.doc_type.get() == 0) {
                        gPadInfo.type = 1;
                    } else if (online_docs_docmetadata.doc_type.get() == 1) {
                        gPadInfo.type = 2;
                    } else if (online_docs_docmetadata.doc_type.get() == 2) {
                        gPadInfo.type = 3;
                    }
                    gPadInfo.creatorUid = online_docs_docmetadata.creator_uid.get();
                    gPadInfo.lastModifyUid = online_docs_docmetadata.last_modify_uid.get();
                    gPadInfo.owneruid = online_docs_docmetadata.owner_uid.get();
                    if (group_online_docs_docinfo.creator_nick.has()) {
                        str3 = group_online_docs_docinfo.creator_nick.get();
                    } else {
                        str3 = "";
                    }
                    gPadInfo.creatorCard = str3;
                    if (group_online_docs_docinfo.owner_nick.has()) {
                        str4 = group_online_docs_docinfo.owner_nick.get();
                    } else {
                        str4 = "";
                    }
                    gPadInfo.ownerCard = str4;
                    if (group_online_docs_docinfo.last_modify_nick.has()) {
                        str5 = group_online_docs_docinfo.last_modify_nick.get();
                    } else {
                        str5 = "";
                    }
                    gPadInfo.lastModifyCard = str5;
                    if (group_online_docs_docinfo.top.get() != 1) {
                        z16 = false;
                    }
                    gPadInfo.pinedFlag = z16;
                    if (group_online_docs_docinfo.doc_url.has()) {
                        str6 = group_online_docs_docinfo.doc_url.get();
                    } else {
                        str6 = "";
                    }
                    gPadInfo.pad_url = str6;
                    gPadInfo.groupCode = j3;
                }
            }
        }
    }

    public static synchronized void buildPadTemplateInfo(GroupPadTemplateInfo groupPadTemplateInfo, Oidb_0xaee$Template oidb_0xaee$Template) {
        synchronized (GroupTeamWorkHandlerImpl.class) {
            if (groupPadTemplateInfo != null && oidb_0xaee$Template != null) {
                groupPadTemplateInfo.templateID = oidb_0xaee$Template.template_id.get();
                groupPadTemplateInfo.templateName = oidb_0xaee$Template.template_name.get();
                groupPadTemplateInfo.templateType = oidb_0xaee$Template.group_type.get();
                groupPadTemplateInfo.mobThumbUrl = oidb_0xaee$Template.mob_thumb_url.get();
                groupPadTemplateInfo.mobPrevUrl = oidb_0xaee$Template.mob_prev_url.get();
                groupPadTemplateInfo.webThumUrl = oidb_0xaee$Template.web_thumb_url.get();
                groupPadTemplateInfo.webPrevUrl = oidb_0xaee$Template.web_prev_url.get();
                groupPadTemplateInfo.templateUrl = oidb_0xaee$Template.template_url.get();
                groupPadTemplateInfo.docOrSheetType = oidb_0xaee$Template.doc_type.get();
                groupPadTemplateInfo.groupCode = oidb_0xaee$Template.group_code.get();
            }
        }
    }

    public static String getClassName() {
        return GroupTeamWorkHandlerImpl.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reqDeleteGroupTeamWorkFile$0(Oidb_0xaea$ReqBody oidb_0xaea$ReqBody, long j3, String str, boolean z16, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        oidb_0xaea$ReqBody.pskey.set(ByteStringMicro.copyFromUtf8(str2));
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2794);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xaea$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IGroupTeamWorkHandler.CMD_DELETE_GROUP_TEAM_WORK_FILE);
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE, Long.valueOf(j3));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_TYPE_KEY_PAD_URL, str);
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        super.sendPbReq(createToServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reqDeleteGroupTeamWorkFile group code = " + j3 + " padUrl " + str + " isCopy: = " + z16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(IGroupTeamWorkHandler.CMD_GET_GROUP_TEAM_WORK_LIST);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_SEARCH_FOR_GROUP_TEAM_WORK_LIST);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_GET_GROUP_PAD_TEMPLATE_LIST);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_DELETE_GROUP_TEAM_WORK_FILE);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_ADD_GROUP_TEAM_WORK_LINK);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_ADD_GROUP_TEAM_WORK_COPY);
            this.allowCmdSet.add(IGroupTeamWorkHandler.CMD_GET_GOURP_TEAM_WORK_LAST_ADD_TIME);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
    public void getGroupPadTemplateList(long j3) {
        if (j3 == 0) {
            return;
        }
        Oidb_0xaee$ReqBody oidb_0xaee$ReqBody = new Oidb_0xaee$ReqBody();
        oidb_0xaee$ReqBody.group_code.set(j3);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2798);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xaee$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IGroupTeamWorkHandler.CMD_GET_GROUP_PAD_TEMPLATE_LIST);
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE, Long.valueOf(j3));
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        super.sendPbReq(createToServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getGroupPadTemplateList! groupCode = " + j3);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
    public void getGroupTeamWorkList(long j3, int i3, int i16, int i17) {
        if (j3 == 0) {
            return;
        }
        Oidb_0xae9$GetListReq oidb_0xae9$GetListReq = new Oidb_0xae9$GetListReq();
        oidb_0xae9$GetListReq.group_code.set(j3);
        oidb_0xae9$GetListReq.start.set(i3);
        oidb_0xae9$GetListReq.limit.set(i16);
        Oidb_0xae9$ReqBody oidb_0xae9$ReqBody = new Oidb_0xae9$ReqBody();
        oidb_0xae9$ReqBody.get_list_req.set(oidb_0xae9$GetListReq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2793);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xae9$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IGroupTeamWorkHandler.CMD_GET_GROUP_TEAM_WORK_LIST);
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE, Long.valueOf(j3));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_REQ_START, Integer.valueOf(i3));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_REQ_LIMIT, Integer.valueOf(i16));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_TYPE_OPERATION, Integer.valueOf(i17));
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        super.sendPbReq(createToServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getGroupTeamWorkList group code = " + j3 + " start = " + i3 + " count = " + i16);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
    public void getGroupTeamWorkListLastAddTime(long j3) {
        if (j3 != 0 && QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getAddGroupTeamWorkTime group code = " + j3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDeleteTeamWorkFile(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2 = "";
        if (fromServiceMsg == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        String str3 = (String) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_TYPE_KEY_PAD_URL);
        ((Long) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE)).longValue();
        int i3 = -1;
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (mergeFrom.uint32_result.has()) {
                i3 = mergeFrom.uint32_result.get();
                if (!mergeFrom.str_error_msg.has()) {
                    str = "";
                } else {
                    str = mergeFrom.str_error_msg.get();
                }
                if (i3 == 0) {
                    try {
                        ConcurrentHashMap<String, Entity> e16 = ((com.tencent.mobileqq.teamworkforgroup.f) ((IManagerFactoryService) this.app.getRuntimeService(IManagerFactoryService.class, "")).getManager(com.tencent.mobileqq.teamworkforgroup.f.class)).e();
                        if (!TextUtils.isEmpty(str3) && e16.containsKey(str3)) {
                            e16.remove(((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(str3));
                        }
                    } catch (InvalidProtocolBufferMicroException e17) {
                        str2 = str;
                        e = e17;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, " handleDeleteTeamWorkFile parse oidb_sso.OIDBSSOPkg failed.");
                        }
                        e.printStackTrace();
                        notifyUI(4, isSuccess, new Object[]{Integer.valueOf(i3), str2});
                        if (!QLog.isColorLevel()) {
                        }
                    }
                }
                str2 = str;
            }
        } catch (InvalidProtocolBufferMicroException e18) {
            e = e18;
        }
        notifyUI(4, isSuccess, new Object[]{Integer.valueOf(i3), str2});
        if (!QLog.isColorLevel()) {
            QLog.i(TAG, 2, " handleDeleteTeamWorkFile issuccess = " + isSuccess + " retCode = " + i3 + " error msg = " + str2);
        }
    }

    public void handleGetGroupPadTemplateList(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        ArrayList arrayList = new ArrayList();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        String str = "";
        com.tencent.mobileqq.teamworkforgroup.f fVar = (com.tencent.mobileqq.teamworkforgroup.f) ((IManagerFactoryService) this.app.getRuntimeService(IManagerFactoryService.class, "")).getManager(com.tencent.mobileqq.teamworkforgroup.f.class);
        int i3 = -1;
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            if (mergeFrom.uint32_result.has()) {
                i3 = mergeFrom.uint32_result.get();
                if (mergeFrom.str_error_msg.has()) {
                    str = mergeFrom.str_error_msg.get();
                }
                if (i3 == 0) {
                    Oidb_0xaee$RspBody oidb_0xaee$RspBody = new Oidb_0xaee$RspBody();
                    try {
                        oidb_0xaee$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        List<Oidb_0xaee$Template> list = oidb_0xaee$RspBody.list_rsp.rpt_template.get();
                        if (list != null && list.size() > 0) {
                            for (int i16 = 0; i16 < list.size(); i16++) {
                                GroupPadTemplateInfo groupPadTemplateInfo = new GroupPadTemplateInfo();
                                buildPadTemplateInfo(groupPadTemplateInfo, list.get(i16));
                                arrayList.add(groupPadTemplateInfo);
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, " handleGetGroupPadTemplateList localPadInfo: " + groupPadTemplateInfo.toString());
                                }
                            }
                            fVar.b(arrayList);
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, " handleGetGroupPadTemplateList exception: " + e16.toString());
                    }
                }
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
            }
            e17.printStackTrace();
        }
        notifyUI(3, isSuccess, new Object[]{Integer.valueOf(i3), str, arrayList});
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleGetGroupTeamWorkList(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        char c16;
        Oidb_0xae9$GetListRsp oidb_0xae9$GetListRsp;
        if (fromServiceMsg == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        int intValue = ((Integer) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_TYPE_OPERATION)).intValue();
        ((Integer) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_REQ_START)).intValue();
        long longValue = ((Long) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE)).longValue();
        ArrayList arrayList = new ArrayList();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        String str = "";
        com.tencent.mobileqq.teamworkforgroup.f fVar = (com.tencent.mobileqq.teamworkforgroup.f) ((IManagerFactoryService) this.app.getRuntimeService(IManagerFactoryService.class, "")).getManager(com.tencent.mobileqq.teamworkforgroup.f.class);
        int i16 = -1;
        try {
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            e = e16;
            i3 = 0;
        }
        if (oidb_sso_oidbssopkg.uint32_result.has()) {
            i16 = oidb_sso_oidbssopkg.uint32_result.get();
            if (oidb_sso_oidbssopkg.str_error_msg.has()) {
                str = oidb_sso_oidbssopkg.str_error_msg.get();
            }
            if (i16 == 0) {
                Oidb_0xae9$RspBody oidb_0xae9$RspBody = new Oidb_0xae9$RspBody();
                try {
                    oidb_0xae9$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    oidb_0xae9$GetListRsp = oidb_0xae9$RspBody.get_list_rsp.get();
                } catch (Exception e17) {
                    e = e17;
                    i3 = 0;
                }
                if (oidb_0xae9$GetListRsp == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " handleGetGroupTeamWorkList getListRsp null: ");
                        return;
                    }
                    return;
                }
                List<group_online_docs$DocInfo> list = oidb_0xae9$GetListRsp.doc_list.get();
                i3 = oidb_0xae9$GetListRsp.next.get();
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            for (int i17 = 0; i17 < list.size(); i17++) {
                                GPadInfo gPadInfo = new GPadInfo();
                                buildPadInfo(gPadInfo, list.get(i17), longValue);
                                arrayList.add(gPadInfo);
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, " handleGetGroupTeamWorkList localPadInfo: " + gPadInfo.toString());
                                }
                            }
                            if (intValue != 1 && intValue != 2) {
                                if (intValue == 3) {
                                    fVar.a(1, arrayList);
                                }
                            }
                            fVar.a(2, arrayList);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        try {
                            QLog.e(TAG, 1, " handleGetGroupTeamWorkList exception: " + e.toString());
                            c16 = 2;
                        } catch (InvalidProtocolBufferMicroException e19) {
                            e = e19;
                            if (QLog.isColorLevel()) {
                                c16 = 2;
                                QLog.d(TAG, 2, " handleGetGroupTeamWorkList parse oidb_sso.OIDBSSOPkg failed.");
                            } else {
                                c16 = 2;
                            }
                            e.printStackTrace();
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(i16);
                            objArr[1] = str;
                            objArr[c16] = arrayList;
                            objArr[3] = Integer.valueOf(i3);
                            objArr[4] = Integer.valueOf(intValue);
                            notifyUI(1, isSuccess, objArr);
                            if (!QLog.isColorLevel()) {
                            }
                        }
                        Object[] objArr2 = new Object[5];
                        objArr2[0] = Integer.valueOf(i16);
                        objArr2[1] = str;
                        objArr2[c16] = arrayList;
                        objArr2[3] = Integer.valueOf(i3);
                        objArr2[4] = Integer.valueOf(intValue);
                        notifyUI(1, isSuccess, objArr2);
                        if (!QLog.isColorLevel()) {
                        }
                    }
                }
                c16 = 2;
                Object[] objArr22 = new Object[5];
                objArr22[0] = Integer.valueOf(i16);
                objArr22[1] = str;
                objArr22[c16] = arrayList;
                objArr22[3] = Integer.valueOf(i3);
                objArr22[4] = Integer.valueOf(intValue);
                notifyUI(1, isSuccess, objArr22);
                if (!QLog.isColorLevel()) {
                    QLog.i(TAG, 2, " handleGetGroupTeamWorkList issuccess = " + isSuccess + " retCode = " + i16 + " error msg = " + str + " next =" + i3 + " type operation = " + intValue);
                    return;
                }
                return;
            }
        }
        i3 = 0;
        c16 = 2;
        Object[] objArr222 = new Object[5];
        objArr222[0] = Integer.valueOf(i16);
        objArr222[1] = str;
        objArr222[c16] = arrayList;
        objArr222[3] = Integer.valueOf(i3);
        objArr222[4] = Integer.valueOf(intValue);
        notifyUI(1, isSuccess, objArr222);
        if (!QLog.isColorLevel()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleGetGroupTeamWorkListLastAddTime(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        InvalidProtocolBufferMicroException invalidProtocolBufferMicroException;
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        String str;
        boolean z17;
        String str2 = "";
        if (toServiceMsg == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        long longValue = ((Long) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE)).longValue();
        int i3 = -1;
        try {
            mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            invalidProtocolBufferMicroException = e16;
        }
        if (mergeFrom.uint32_result.has()) {
            i3 = mergeFrom.uint32_result.get();
            if (!mergeFrom.str_error_msg.has()) {
                str = "";
            } else {
                str = mergeFrom.str_error_msg.get();
            }
            if (i3 == 0) {
                try {
                    Oidb_0xae9$RspBody oidb_0xae9$RspBody = new Oidb_0xae9$RspBody();
                    try {
                        oidb_0xae9$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        long j3 = oidb_0xae9$RspBody.get_add_time_rsp.get().timestamp.get();
                        if (!com.tencent.mobileqq.teamworkforgroup.f.h(this.app.getApp(), String.valueOf(longValue), "key_groupteamwork_add_timestamp", "").equals(String.valueOf(j3))) {
                            z17 = true;
                            try {
                                com.tencent.mobileqq.teamworkforgroup.f.l(this.app.getApp(), String.valueOf(longValue), "key_groupteamwork_add_timestamp", String.valueOf(j3));
                                IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
                                AppInterface appInterface = this.app;
                                iGetExternalInterface.setRedDotForTimGroupTMShow(appInterface, appInterface.getApp(), String.valueOf(longValue), IGetExternalInterface.TIM_GROUP_TM_REDDOT, true);
                            } catch (Exception e17) {
                                e = e17;
                                try {
                                    QLog.e(TAG, 1, " handleGetGroupPadTemplateList exception: " + e.toString());
                                    z16 = z17;
                                    str2 = str;
                                } catch (InvalidProtocolBufferMicroException e18) {
                                    invalidProtocolBufferMicroException = e18;
                                    z16 = z17;
                                    str2 = str;
                                    if (QLog.isColorLevel()) {
                                    }
                                    invalidProtocolBufferMicroException.printStackTrace();
                                    notifyUI(7, isSuccess, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z16)});
                                }
                                notifyUI(7, isSuccess, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z16)});
                            }
                        } else {
                            z17 = false;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z17 = false;
                    }
                    z16 = z17;
                    str2 = str;
                } catch (InvalidProtocolBufferMicroException e26) {
                    invalidProtocolBufferMicroException = e26;
                    str2 = str;
                    z16 = false;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " handleGetGroupPadTemplateList parse oidb_sso.OIDBSSOPkg failed.");
                    }
                    invalidProtocolBufferMicroException.printStackTrace();
                    notifyUI(7, isSuccess, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z16)});
                }
                notifyUI(7, isSuccess, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z16)});
            }
            str2 = str;
        }
        z16 = false;
        notifyUI(7, isSuccess, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z16)});
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleSearchForGroupTeamWorkList(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        oidb_sso$OIDBSSOPkg mergeFrom;
        Oidb_0xaef$SearchDocRsp oidb_0xaef$SearchDocRsp;
        String str = "";
        if (fromServiceMsg == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        ((Integer) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_REQ_START)).intValue();
        long longValue = ((Long) toServiceMsg.getAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE)).longValue();
        ArrayList arrayList = new ArrayList();
        int i16 = -1;
        try {
            mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            e = e16;
            i3 = 0;
            z16 = false;
        }
        if (mergeFrom.uint32_result.has()) {
            i16 = mergeFrom.uint32_result.get();
            if (mergeFrom.str_error_msg.has()) {
                str = mergeFrom.str_error_msg.get();
            }
            if (i16 == 0) {
                Oidb_0xaef$RspBody oidb_0xaef$RspBody = new Oidb_0xaef$RspBody();
                try {
                    oidb_0xaef$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    oidb_0xaef$SearchDocRsp = oidb_0xaef$RspBody.search_doc_rsp.get();
                } catch (Exception e17) {
                    e = e17;
                    i3 = 0;
                }
                if (oidb_0xaef$SearchDocRsp == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " handleSearchForGroupTeamWorkList searchDocRsp null ");
                        return;
                    }
                    return;
                }
                i3 = oidb_0xaef$SearchDocRsp.next.get();
                try {
                    if (oidb_0xaef$SearchDocRsp.is_end.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    try {
                        List<Oidb_0xaef$SearchItem> list = oidb_0xaef$SearchDocRsp.doc_list.get();
                        if (list != null && list.size() > 0) {
                            for (int i17 = 0; i17 < list.size(); i17++) {
                                GPadInfo gPadInfo = new GPadInfo();
                                ArrayList arrayList2 = new ArrayList();
                                Oidb_0xaef$SearchItem oidb_0xaef$SearchItem = list.get(i17);
                                buildPadInfo(gPadInfo, oidb_0xaef$SearchItem.doc_info.get(), longValue);
                                List<ByteStringMicro> list2 = oidb_0xaef$SearchItem.match_word.get();
                                if (list2 != null && list2.size() > 0) {
                                    for (int i18 = 0; i18 < list2.size(); i18++) {
                                        arrayList2.add(list2.get(i18).toStringUtf8());
                                    }
                                }
                                gPadInfo.searchKeyWordList.addAll(arrayList2);
                                arrayList.add(gPadInfo);
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, " handleSearchForGroupTeamWorkList localInfo = " + gPadInfo.toString());
                                }
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        try {
                            QLog.e(TAG, 1, " handleSearchForGroupTeamWorkList exception: " + e.toString());
                        } catch (InvalidProtocolBufferMicroException e19) {
                            e = e19;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, " handleSearchForGroupTeamWorkList parse oidb_sso.OIDBSSOPkg failed.");
                            }
                            e.printStackTrace();
                            notifyUI(2, isSuccess, new Object[]{Integer.valueOf(i16), str, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16)});
                            if (QLog.isColorLevel()) {
                            }
                        }
                        notifyUI(2, isSuccess, new Object[]{Integer.valueOf(i16), str, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16)});
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Exception e26) {
                    e = e26;
                    z16 = false;
                    QLog.e(TAG, 1, " handleSearchForGroupTeamWorkList exception: " + e.toString());
                    notifyUI(2, isSuccess, new Object[]{Integer.valueOf(i16), str, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16)});
                    if (QLog.isColorLevel()) {
                    }
                }
                notifyUI(2, isSuccess, new Object[]{Integer.valueOf(i16), str, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16)});
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, " handleSearchForGroupTeamWorkList issuccess = " + isSuccess + " retCode = " + i16 + " error msg = " + str + " next = " + i3 + " isEnd = " + z16);
                    return;
                }
                return;
            }
        }
        i3 = 0;
        z16 = false;
        notifyUI(2, isSuccess, new Object[]{Integer.valueOf(i16), str, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16)});
        if (QLog.isColorLevel()) {
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.teamworkforgroup.g.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (IGroupTeamWorkHandler.CMD_GET_GROUP_TEAM_WORK_LIST.equals(fromServiceMsg.getServiceCmd())) {
            handleGetGroupTeamWorkList(toServiceMsg, fromServiceMsg, obj);
        } else if (IGroupTeamWorkHandler.CMD_GET_GROUP_PAD_TEMPLATE_LIST.equals(fromServiceMsg.getServiceCmd())) {
            handleGetGroupPadTemplateList(toServiceMsg, fromServiceMsg, obj);
        } else if (IGroupTeamWorkHandler.CMD_SEARCH_FOR_GROUP_TEAM_WORK_LIST.equals(fromServiceMsg.getServiceCmd())) {
            handleSearchForGroupTeamWorkList(toServiceMsg, fromServiceMsg, obj);
        } else if (IGroupTeamWorkHandler.CMD_DELETE_GROUP_TEAM_WORK_FILE.equals(fromServiceMsg.getServiceCmd())) {
            handleDeleteTeamWorkFile(toServiceMsg, fromServiceMsg, obj);
        } else if (!IGroupTeamWorkHandler.CMD_ADD_GROUP_TEAM_WORK_LINK.equals(fromServiceMsg.getServiceCmd()) && !IGroupTeamWorkHandler.CMD_ADD_GROUP_TEAM_WORK_COPY.equals(fromServiceMsg.getServiceCmd()) && IGroupTeamWorkHandler.CMD_GET_GOURP_TEAM_WORK_LAST_ADD_TIME.equals(fromServiceMsg.getServiceCmd())) {
            handleGetGroupTeamWorkListLastAddTime(toServiceMsg, fromServiceMsg, obj);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onReceive, cmd=" + serviceCmd + ", isSucc=" + isSuccess);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
    public void reqDeleteGroupTeamWorkFile(final long j3, online_docs$DocId online_docs_docid, final String str, final boolean z16) {
        if (j3 == 0) {
            return;
        }
        Oidb_0xaea$DeleteDocReq oidb_0xaea$DeleteDocReq = new Oidb_0xaea$DeleteDocReq();
        oidb_0xaea$DeleteDocReq.group_code.set(j3);
        oidb_0xaea$DeleteDocReq.doc_id.set(online_docs_docid);
        oidb_0xaea$DeleteDocReq.copy.set(z16 ? 1 : 0);
        final Oidb_0xaea$ReqBody oidb_0xaea$ReqBody = new Oidb_0xaea$ReqBody();
        oidb_0xaea$ReqBody.delete_doc_req.set(oidb_0xaea$DeleteDocReq);
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.api.impl.a
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str2) {
                GroupTeamWorkHandlerImpl.this.lambda$reqDeleteGroupTeamWorkFile$0(oidb_0xaea$ReqBody, j3, str, z16, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
    public void reqSearchGroupTeamWorkList(long j3, String str, int i3, int i16, int i17) {
        if (j3 == 0) {
            return;
        }
        Oidb_0xaef$SearchDocReq oidb_0xaef$SearchDocReq = new Oidb_0xaef$SearchDocReq();
        oidb_0xaef$SearchDocReq.group_code.set(j3);
        oidb_0xaef$SearchDocReq.key_word.set(ByteStringMicro.copyFromUtf8(str));
        oidb_0xaef$SearchDocReq.start.set(i3);
        oidb_0xaef$SearchDocReq.limit.set(i16);
        Oidb_0xaef$ReqBody oidb_0xaef$ReqBody = new Oidb_0xaef$ReqBody();
        oidb_0xaef$ReqBody.search_doc_req.set(oidb_0xaef$SearchDocReq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2799);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xaef$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg(IGroupTeamWorkHandler.CMD_SEARCH_FOR_GROUP_TEAM_WORK_LIST);
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_GROUP_CODE, Long.valueOf(j3));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_REQ_START, Integer.valueOf(i3));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_REQ_LIMIT, Integer.valueOf(i16));
        createToServiceMsg.addAttribute(IGroupTeamWorkHandler.KEY_TYPE_KEY_WORD, str);
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        super.sendPbReq(createToServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "reqSearchGroupTeamWorkList group code = " + j3 + " start = " + i3 + " count = " + i16);
        }
    }
}
