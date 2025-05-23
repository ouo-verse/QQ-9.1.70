package com.tencent.open.manager;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xf26.oidb_0xf26$GrantReq;
import tencent.im.oidb.cmd0xf26.oidb_0xf26$ReqBody;
import tencent.im.oidb.cmd0xf26.oidb_0xf26$RevokeReq;
import tencent.im.oidb.cmd0xf26.oidb_0xf26$RspBody;
import tencent.im.oidb.oidb_0xc05$GetAuthAppListReq;
import tencent.im.oidb.oidb_0xc05$GetAuthAppListRsp;
import tencent.im.oidb.oidb_0xc05$ReqBody;
import tencent.im.oidb.oidb_0xc05$RspBody;
import tencent.im.oidb.oidb_0xccd$ReqBody;
import tencent.im.oidb.oidb_0xccd$Result;
import tencent.im.oidb.oidb_0xccd$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.oidb.qqconnect$Appinfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenAgentHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private final List<qqconnect$Appinfo> f341593d;

    /* renamed from: e, reason: collision with root package name */
    private final List<AppInfo> f341594e;

    /* renamed from: f, reason: collision with root package name */
    private BaseQQAppInterface f341595f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f341596a;

        /* renamed from: b, reason: collision with root package name */
        public int f341597b;

        /* renamed from: c, reason: collision with root package name */
        public String f341598c;

        /* renamed from: d, reason: collision with root package name */
        public oidb_0xf26$RspBody f341599d;
    }

    public OpenAgentHandler(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        this.f341593d = new ArrayList(10);
        this.f341594e = new ArrayList(10);
        this.f341595f = baseQQAppInterface;
    }

    private void F2(int i3, int i16) {
        oidb_0xc05$ReqBody oidb_0xc05_reqbody = new oidb_0xc05$ReqBody();
        oidb_0xc05$GetAuthAppListReq oidb_0xc05_getauthapplistreq = new oidb_0xc05$GetAuthAppListReq();
        oidb_0xc05_getauthapplistreq.start.set(i3);
        oidb_0xc05_getauthapplistreq.limit.set(i16);
        oidb_0xc05_reqbody.get_auth_app_list_req.set(oidb_0xc05_getauthapplistreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3077);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xc05_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xc05");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putInt("req_index", i3);
        createToServiceMsg.extraData.putInt("req_page_size", i16);
        sendPbReq(createToServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        boolean z17;
        if (fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize");
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OpenAgentHandler", 2, "handleDelAppAuthrize, parsed pkg failed", e16);
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
            } else {
                i3 = -1;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                oidb_0xccd$RspBody oidb_0xccd_rspbody = new oidb_0xccd$RspBody();
                try {
                    oidb_0xccd_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    z17 = true;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", e17);
                    }
                    z17 = false;
                }
                if (z17 && oidb_0xccd_rspbody.errcode.get() == 0) {
                    ArrayList arrayList = new ArrayList(this.f341594e.size());
                    List<oidb_0xccd$Result> list = oidb_0xccd_rspbody.Results.get();
                    if (list != null && !list.isEmpty()) {
                        for (oidb_0xccd$Result oidb_0xccd_result : list) {
                            if (oidb_0xccd_result.errcode.get() == 0) {
                                int i16 = oidb_0xccd_result.uint32_appid.get();
                                for (AppInfo appInfo : this.f341594e) {
                                    if (appInfo.c() == i16) {
                                        arrayList.add(appInfo);
                                    }
                                }
                            }
                        }
                        notifyUI(toServiceMsg, 1, true, (Object) arrayList);
                        this.f341594e.clear();
                        z16 = true;
                        if (z16) {
                            this.f341594e.clear();
                            notifyUI(toServiceMsg, 1, false, "");
                            return;
                        }
                        return;
                    }
                }
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        boolean z17;
        Object obj2 = "";
        if (fromServiceMsg.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList");
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed pkg failed", e16);
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
            } else {
                i3 = -1;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                oidb_0xc05$RspBody oidb_0xc05_rspbody = new oidb_0xc05$RspBody();
                z16 = true;
                try {
                    oidb_0xc05_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    z17 = true;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OpenAgentHandler", 2, "handleGetAuthorizeAppList, parsed rsp failed", e17);
                    }
                    z17 = false;
                }
                if (z17) {
                    if (oidb_0xc05_rspbody.wording.has()) {
                        obj2 = oidb_0xc05_rspbody.wording.get();
                    }
                    if (oidb_0xc05_rspbody.get_auth_app_list_rsp.has()) {
                        oidb_0xc05$GetAuthAppListRsp oidb_0xc05_getauthapplistrsp = oidb_0xc05_rspbody.get_auth_app_list_rsp;
                        List<qqconnect$Appinfo> list = oidb_0xc05_getauthapplistrsp.appinfos.get();
                        if (list != null) {
                            this.f341593d.addAll(list);
                            int i16 = toServiceMsg.extraData.getInt("req_index") + toServiceMsg.extraData.getInt("req_page_size");
                            if (i16 <= oidb_0xc05_getauthapplistrsp.total_count.get()) {
                                F2(i16, 10);
                            } else {
                                ArrayList arrayList = new ArrayList(this.f341593d.size());
                                Iterator<qqconnect$Appinfo> it = this.f341593d.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(new AppInfo(it.next()));
                                }
                                this.f341593d.clear();
                                notifyUI(0, true, arrayList);
                            }
                            if (z16) {
                                this.f341593d.clear();
                                notifyUI(0, false, obj2);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        QLog.d("OpenAgentHandler", 1, "onHandleAuthItemF26 success=", Boolean.valueOf(fromServiceMsg.isSuccess()));
        a aVar = new a();
        Object obj2 = toServiceMsg.getAttributes().get(StartupReportKey.AUTH_TYPE);
        if (obj2 instanceof Integer) {
            i3 = ((Integer) obj2).intValue();
        } else {
            i3 = 0;
        }
        aVar.f341596a = i3;
        if (!fromServiceMsg.isSuccess()) {
            notifyUI(toServiceMsg, 2, false, (Object) aVar);
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (!mergeFrom.uint32_result.has()) {
                notifyUI(toServiceMsg, 2, false, (Object) aVar);
                return;
            }
            if (mergeFrom.uint32_result.get() != 0) {
                aVar.f341597b = mergeFrom.uint32_result.get();
                aVar.f341598c = mergeFrom.str_error_msg.get();
                notifyUI(toServiceMsg, 2, false, (Object) aVar);
            } else {
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0xf26$RspBody oidb_0xf26_rspbody = new oidb_0xf26$RspBody();
                        oidb_0xf26_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        aVar.f341599d = oidb_0xf26_rspbody;
                        notifyUI(toServiceMsg, 2, true, (Object) aVar);
                        return;
                    } catch (Exception e16) {
                        QLog.e("OpenAgentHandler", 1, "onHandleAuthItemF26, parsed pkg failed", e16);
                        notifyUI(toServiceMsg, 2, false, (Object) aVar);
                        return;
                    }
                }
                notifyUI(toServiceMsg, 2, false, (Object) aVar);
            }
        } catch (Exception e17) {
            QLog.e("OpenAgentHandler", 1, "onHandleAuthItemF26, parsed pkg failed", e17);
            notifyUI(toServiceMsg, 2, false, (Object) aVar);
        }
    }

    public void D2(List<AppInfo> list, com.tencent.open.manager.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OpenAgentHandler", 2, "deleteAppAuthorize, size=" + list.size());
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (AppInfo appInfo : list) {
            if (appInfo.c() > 0) {
                arrayList.add(Integer.valueOf(appInfo.c()));
            }
        }
        oidb_0xccd$ReqBody oidb_0xccd_reqbody = new oidb_0xccd$ReqBody();
        oidb_0xccd_reqbody.uint32_appids.set(arrayList);
        oidb_0xccd_reqbody.platform.set(1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3277);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xccd_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xccd", aVar);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        this.f341594e.addAll(list);
        sendPbReq(createToServiceMsg);
    }

    public void E2() {
        if (QLog.isColorLevel()) {
            QLog.d("OpenAgentHandler", 2, "getAuthorizedAppList");
        }
        F2(0, 10);
    }

    public void J2(int i3, int i16, List<Integer> list, int i17, String str, String str2, com.tencent.open.manager.a aVar) {
        QLog.d("OpenAgentHandler", 1, "operateAuthItem appId=", Integer.valueOf(i3), ", type=", Integer.valueOf(i16), ", source=", Integer.valueOf(i17));
        oidb_0xf26$ReqBody oidb_0xf26_reqbody = new oidb_0xf26$ReqBody();
        oidb_0xf26_reqbody.appid.set(i3);
        oidb_0xf26_reqbody.app_type.set(1);
        oidb_0xf26_reqbody.source_from.set(i17);
        if (i17 == 1) {
            oidb_0xf26_reqbody.openid.set(str);
            oidb_0xf26_reqbody.openkey.set(str2);
        }
        if (i16 == 2) {
            oidb_0xf26$GrantReq oidb_0xf26_grantreq = new oidb_0xf26$GrantReq();
            oidb_0xf26_grantreq.auth_group_id.set(list);
            oidb_0xf26_reqbody.grant_req.set(oidb_0xf26_grantreq);
        } else if (i16 == 3) {
            oidb_0xf26$RevokeReq oidb_0xf26_revokereq = new oidb_0xf26$RevokeReq();
            oidb_0xf26_revokereq.auth_group_id.set(list);
            oidb_0xf26_reqbody.revoke_req.set(oidb_0xf26_revokereq);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3878);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xf26_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xf26", aVar);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.getAttributes().put(StartupReportKey.AUTH_TYPE, Integer.valueOf(i16));
        sendPbReq(createToServiceMsg);
    }

    public void K2(int i3, int i16, List<Integer> list, com.tencent.open.manager.a aVar) {
        J2(i3, i16, list, 0, "", "", aVar);
    }

    public void L2(int i3, int i16, List<Integer> list, String str, String str2, com.tencent.open.manager.a aVar) {
        J2(i3, i16, list, 1, str, str2, aVar);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xc05");
            this.allowCmdSet.add("OidbSvc.0xccd");
            this.allowCmdSet.add("OidbSvc.0xf26");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.open.manager.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenAgentHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        if ("OidbSvc.0xc05".equals(fromServiceMsg.getServiceCmd())) {
            H2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xccd".equals(fromServiceMsg.getServiceCmd())) {
            G2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xf26".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
