package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi;
import com.tencent.mobileqq.troop.api.impl.TroopShareWxMiniProgramApiImpl;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.protofile.join_group_link.join_group_link$GroupInfo;
import com.tencent.protofile.join_group_link.join_group_link$ReqBody;
import com.tencent.protofile.join_group_link.join_group_link$RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupProfileShareReq;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupProfileShareRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupProfileShareInfo;
import com.tencent.qqnt.kernel.nativeinterface.ICreateGroupProfileShareCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.cmd0x903.cmd0x903$ReqBody;
import tencent.im.oidb.cmd0x903.cmd0x903$RspBody;
import tencent.im.oidb.cmd0x903.cmd0x903$SubCmd0x2Req;
import tencent.im.oidb.cmd0x903.cmd0x903$SubCmd0x2Rsp;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManagerBizHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.troopmanager.api.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopshare.a f300511d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f300512e;

        a(com.tencent.mobileqq.troop.troopshare.a aVar, String str) {
            this.f300511d = aVar;
            this.f300512e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopManagerBizHandler.this, aVar, str);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            com.tencent.mobileqq.troop.troopshare.a aVar = this.f300511d;
            aVar.f301554b = -1;
            TroopManagerBizHandler.this.notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, false, aVar);
            QLog.e("TroopManagerBizHandler", 1, "[getTroopShareLink] [onError] troopUin = " + this.f300512e + ", errorCode = " + i3 + ", errorMsg = " + str);
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            join_group_link$RspBody join_group_link_rspbody = new join_group_link$RspBody();
            try {
                join_group_link_rspbody.mergeFrom(bArr);
                if (join_group_link_rspbody.error_code.has()) {
                    i16 = join_group_link_rspbody.error_code.get();
                } else {
                    i16 = 0;
                }
                if (i16 == 0 && i3 == 0) {
                    z16 = true;
                } else {
                    this.f300511d.f301554b = i16;
                }
                if (join_group_link_rspbody.group_code.has()) {
                    this.f300511d.f301553a = String.valueOf(join_group_link_rspbody.group_code.get());
                }
                if (join_group_link_rspbody.url.has()) {
                    this.f300511d.f301556d = join_group_link_rspbody.url.get();
                }
                if (join_group_link_rspbody.ark.has()) {
                    this.f300511d.f301557e = new String(join_group_link_rspbody.ark.get().toByteArray());
                }
                if (join_group_link_rspbody.token.has()) {
                    this.f300511d.f301558f = join_group_link_rspbody.token.get().toStringUtf8();
                }
                if (join_group_link_rspbody.group_info.has() && join_group_link_rspbody.group_info.get().join_group_auth.has()) {
                    this.f300511d.f301559g = join_group_link_rspbody.group_info.join_group_auth.get().toStringUtf8();
                }
                QLog.i("TroopManagerBizHandler", 1, "[getTroopShareLink] [onResult] troopUin = " + this.f300512e + ", errorCode = " + i3 + ", backData = " + this.f300511d);
            } catch (Exception e16) {
                QLog.e("TroopManagerBizHandler", 1, "[getTroopShareLink] [onResult] exception = " + e16);
            }
            TroopManagerBizHandler.this.notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, z16, this.f300511d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends TypeToken<HashMap<String, String>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopManagerBizHandler.this);
            }
        }
    }

    public TroopManagerBizHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r7 != 73) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CreateGroupProfileShareReq G2(String str, int i3) {
        CreateGroupProfileShareReq createGroupProfileShareReq = new CreateGroupProfileShareReq();
        GroupProfileShareInfo groupProfileShareInfo = createGroupProfileShareReq.info;
        groupProfileShareInfo.busiId = "group_info_share";
        groupProfileShareInfo.resourceId = str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9 && i3 != 10) {
                        if (i3 != 72) {
                        }
                    } else {
                        groupProfileShareInfo.plat = 2;
                        groupProfileShareInfo.templateName = "h5_group_info";
                    }
                } else {
                    groupProfileShareInfo.plat = 4;
                    groupProfileShareInfo.templateName = "h5_group_info";
                }
            }
            groupProfileShareInfo.plat = 1;
            groupProfileShareInfo.templateName = "ark_contact";
        } else {
            groupProfileShareInfo.plat = 5;
            groupProfileShareInfo.templateName = "h5_group_info";
        }
        return createGroupProfileShareReq;
    }

    private boolean H2(int i3) {
        if (9 == i3 && ((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).enableShareAsMiniProgram()) {
            return false;
        }
        return ((ITroopShareApi) QRoute.api(ITroopShareApi.class)).isNewShareLinkSwitchOn();
    }

    private void I2(String str, boolean z16, boolean z17) {
        int i3;
        join_group_link$ReqBody join_group_link_reqbody = new join_group_link$ReqBody();
        if (z16) {
            join_group_link_reqbody.msg_type.set(1);
        } else {
            join_group_link_reqbody.msg_type.set(3);
        }
        join_group_link_reqbody.group_code.set(Long.valueOf(str).longValue());
        join_group_link_reqbody.get_ark.set(true);
        if (z17) {
            join_group_link_reqbody.get_token.set(true);
            join_group_link$GroupInfo join_group_link_groupinfo = new join_group_link$GroupInfo();
            join_group_link_groupinfo.join_group_auth.set(ByteStringMicro.copyFromUtf8("1"));
            join_group_link_reqbody.group_info.set(join_group_link_groupinfo);
            i3 = 10;
        } else {
            i3 = 5;
        }
        int i16 = i3;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.mobileqq.troop.troopshare.a aVar = new com.tencent.mobileqq.troop.troopshare.a();
        aVar.f301555c = z16;
        aVar.f301553a = str;
        ProtoUtils.a(appInterface, new a(aVar, str), join_group_link_reqbody.toByteArray(), TroopShareWxMiniProgramApiImpl.JOIN_GROUP_LINK_CMD_0X9162, TroopShareWxMiniProgramApiImpl.JOIN_GROUP_LINK_COMMAND, i16);
    }

    private void J2(String str, boolean z16, int i3) {
        final com.tencent.mobileqq.troop.troopshare.a aVar = new com.tencent.mobileqq.troop.troopshare.a();
        aVar.f301555c = z16;
        aVar.f301553a = str;
        if (TextUtils.isEmpty(str)) {
            QLog.w("TroopManagerBizHandler", 1, "[getTroopShareLinkBy9409] troopUin is empty");
            notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, false, aVar);
            return;
        }
        s groupService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getGroupService();
        if (groupService == null) {
            QLog.w("TroopManagerBizHandler", 1, "[getTroopShareLinkBy9409] group service is null");
            notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, false, aVar);
        } else {
            groupService.createGroupProfileShare(G2(str, i3), new ICreateGroupProfileShareCallback() { // from class: com.tencent.mobileqq.troop.troopmanager.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICreateGroupProfileShareCallback
                public final void onResult(int i16, String str2, CreateGroupProfileShareRsp createGroupProfileShareRsp) {
                    TroopManagerBizHandler.this.N2(aVar, i16, str2, createGroupProfileShareRsp);
                }
            });
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String obj2;
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (fromServiceMsg.getResultCode() != 1000) {
                notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_OIDB_0X903_2, false, null);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    cmd0x903$RspBody cmd0x903_rspbody = new cmd0x903$RspBody();
                    try {
                        cmd0x903_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        if (cmd0x903_rspbody.opt_msg_get_invited_uin_list_rsp.has()) {
                            new cmd0x903$SubCmd0x2Rsp();
                            cmd0x903$SubCmd0x2Rsp cmd0x903_subcmd0x2rsp = cmd0x903_rspbody.opt_msg_get_invited_uin_list_rsp.get();
                            Long valueOf = Long.valueOf(cmd0x903_subcmd0x2rsp.opt_uint64_group_code.get());
                            List<Long> list = cmd0x903_subcmd0x2rsp.rpt_uint64_uin.get();
                            notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_OIDB_0X903_2, true, new Object[]{valueOf, list});
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("handleGetInvitedUinList:");
                                sb5.append(valueOf);
                                sb5.append(", uins=");
                                if (list == null) {
                                    obj2 = "null";
                                } else {
                                    obj2 = list.toString();
                                }
                                sb5.append(obj2);
                                QLog.d("TroopManagerBizHandler", 2, sb5.toString());
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException unused) {
                        notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_OIDB_0X903_2, false, null);
                        return;
                    }
                }
                notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_OIDB_0X903_2, false, null);
            } catch (InvalidProtocolBufferMicroException unused2) {
                notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_OIDB_0X903_2, false, null);
            }
        }
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: start");
        }
        com.tencent.mobileqq.troop.troopshare.a aVar = new com.tencent.mobileqq.troop.troopshare.a();
        boolean z16 = false;
        if (toServiceMsg != null && fromServiceMsg != null) {
            aVar.f301555c = toServiceMsg.extraData.getBoolean("isVerify");
            aVar.f301553a = toServiceMsg.extraData.getString("troopUin");
            int i3 = -1;
            if (fromServiceMsg.getResultCode() == 1000) {
                join_group_link$RspBody join_group_link_rspbody = new join_group_link$RspBody();
                try {
                    join_group_link_rspbody.mergeFrom((byte[]) obj);
                    if (join_group_link_rspbody.error_code.has()) {
                        i3 = join_group_link_rspbody.error_code.get();
                    }
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        aVar.f301554b = i3;
                    }
                    if (join_group_link_rspbody.group_code.has()) {
                        aVar.f301553a = String.valueOf(join_group_link_rspbody.group_code.get());
                    }
                    if (join_group_link_rspbody.url.has()) {
                        aVar.f301556d = join_group_link_rspbody.url.get();
                    }
                    if (join_group_link_rspbody.ark.has()) {
                        aVar.f301557e = new String(join_group_link_rspbody.ark.get().toByteArray());
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: RspBody parseFrom byte InvalidProtocolBufferMicroException");
                    }
                    e16.printStackTrace();
                }
            } else {
                aVar.f301554b = -1;
            }
            notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, z16, aVar);
            if (QLog.isColorLevel()) {
                QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink.errCode:" + aVar.f301554b + "\u3000troopUin:" + aVar.f301553a + " isVerify:" + aVar.f301555c + " shareUrl:" + aVar.f301556d);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopManagerBizHandler", 2, "handleTroopShareLink: end");
                return;
            }
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, false, aVar);
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerBizHandler", 2, "handlerBindSubAccount: req == null || resp == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N2(com.tencent.mobileqq.troop.troopshare.a aVar, int i3, String str, CreateGroupProfileShareRsp createGroupProfileShareRsp) {
        boolean z16 = false;
        QLog.i("TroopManagerBizHandler", 1, String.format("[getTroopShareLinkBy9409] errCode:%d, errMsg:%s, rsp:%s", Integer.valueOf(i3), str, createGroupProfileShareRsp));
        if (i3 == 0 && createGroupProfileShareRsp.err.code == 0) {
            z16 = true;
        }
        aVar.f301554b = createGroupProfileShareRsp.err.code;
        HashMap<String, String> O2 = O2(createGroupProfileShareRsp.platData);
        if (O2 != null) {
            aVar.f301556d = O2.get("url");
        }
        if (TextUtils.equals(createGroupProfileShareRsp.info.templateName, "ark_contact")) {
            aVar.f301557e = createGroupProfileShareRsp.templateData;
            QLog.d("TroopManagerBizHandler", 4, "[getTroopShareLinkBy9409] signedArk:" + aVar.f301557e);
        }
        notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.OBSERVER_TYPE_TROOP_LINK, z16, aVar);
    }

    @Nullable
    private HashMap<String, String> O2(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new b().getType());
        } catch (JsonSyntaxException e16) {
            QLog.e("TroopManagerBizHandler", 1, "jsonToMap e = " + e16 + " , json = " + str);
            return null;
        }
    }

    public void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0);
                        long j3 = oidb_0x5eb_udcuindata.uint64_uin.get();
                        if (oidb_0x5eb_udcuindata.uint32_global_group_level.has()) {
                            i3 = oidb_0x5eb_udcuindata.uint32_global_group_level.get();
                        } else {
                            i3 = -1;
                        }
                        notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_GET_GLOBAL_TROOP_LEVEL, z17, new Object[]{Long.valueOf(j3), Integer.valueOf(i3)});
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.a
    public void R(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
        oidb_0x5eb_reqbody.uint32_req_global_group_level.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_96", 1515, 96, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putBoolean("OidbSvc.0x5eb_96", true);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.a
    public void e(String str, boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        } else if (H2(i3)) {
            QLog.i("TroopManagerBizHandler", 2, "[getTroopShareLink] 0x9409");
            J2(str, z16, i3);
        } else {
            QLog.i("TroopManagerBizHandler", 2, "[getTroopShareLink] 0x9162");
            I2(str, z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x903_2");
            this.allowCmdSet.add("GroupSvc.JoinGroupLink");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopManagerBizHandler";
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.a
    public void l0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        QLog.i("TroopManagerBizHandler", 1, "[notifySetTroopActiveSuccess] troopUin:" + str);
        notifyUI(com.tencent.mobileqq.troop.troopmanager.api.b.TYPE_NOTIFY_ACTIVE_EXT_TROOP_SUCCESS, true, new Object[]{str});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopmanager.api.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopManagerBizHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopManagerBizHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x903_2".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("GroupSvc.JoinGroupLink".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                M2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x5eb_96".equals(fromServiceMsg.getServiceCmd())) {
                    L2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerBizHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.a
    public void w(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManagerBizHandler", 2, "getTroopShareLink: start. troopUin:" + str + ", wxMiniProgram:" + z17);
        }
        I2(str, z16, z17);
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.a
    public void x2(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
            return;
        }
        cmd0x903$SubCmd0x2Req cmd0x903_subcmd0x2req = new cmd0x903$SubCmd0x2Req();
        cmd0x903_subcmd0x2req.opt_uint64_group_code.set(l3.longValue());
        cmd0x903$ReqBody cmd0x903_reqbody = new cmd0x903$ReqBody();
        cmd0x903_reqbody.opt_msg_get_invited_uin_list_req.set(cmd0x903_subcmd0x2req);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2307);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x903_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x903_2");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }
}
