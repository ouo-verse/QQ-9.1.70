package com.tencent.mobileqq.troop.troopreddot.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.config.aj;
import com.tencent.mobileqq.troop.api.handler.c;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca$ReqBody;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca$RspBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9$GroupAppUnreadInfo;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9$ReqBody;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRedDotHandler extends TroopBaseHandler implements qt2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f301007e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f301008d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f301009e;

        a(long j3, int i3) {
            this.f301008d = j3;
            this.f301009e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopRedDotHandler.this, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onGetTroopAuth(boolean z16, long j3, String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), str, bArr);
                return;
            }
            if (this.f301008d == j3 && str.equals("SUBCMD_GET_TROOP_AUTH_FOR_REDPOINT")) {
                if (z16 && bArr != null) {
                    TroopRedDotHandler.this.H2("" + this.f301008d, bArr, this.f301009e);
                }
                ((BaseBusinessHandler) TroopRedDotHandler.this).appRuntime.removeObserver(this);
            }
        }
    }

    public TroopRedDotHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(String str, byte[] bArr, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopRedDotHandler", 2, "clearTroopAIORedDot, troopUin=" + str);
        }
        cmd0x8ca$ReqBody cmd0x8ca_reqbody = new cmd0x8ca$ReqBody();
        cmd0x8ca_reqbody.opt_uint32_sub_cmd.set(3L);
        try {
            cmd0x8ca_reqbody.opt_uint64_from_uin.set(Long.parseLong(this.appRuntime.getCurrentAccountUin()));
            cmd0x8ca_reqbody.opt_uint64_group_code.set(Long.parseLong(str));
            cmd0x8ca_reqbody.opt_bytes_group_sig.set(ByteStringMicro.copyFrom(bArr));
            cmd0x8ca_reqbody.opt_uint64_appid.set(j3);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2250);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(2);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x8ca_reqbody.toByteArray()));
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x8ca_2");
            toServiceMsg.extraData.putString("troopUin", str);
            toServiceMsg.extraData.putString("type", String.valueOf(j3));
            toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRedDotHandler", 2, "clearTroopAIORedDot error, NumberFormatException, troopUin : " + str);
            }
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("troopUin");
            String string2 = toServiceMsg.extraData.getString("type");
            if (fromServiceMsg.getResultCode() != 1000) {
                notifyUI(i.f298024e, false, new Object[]{string, string2, Boolean.TRUE});
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    cmd0x8ca$RspBody cmd0x8ca_rspbody = new cmd0x8ca$RspBody();
                    try {
                        cmd0x8ca_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        aj.a().c(this.appRuntime, String.valueOf(cmd0x8ca_rspbody.opt_uint64_group_code.get()));
                        notifyUI(i.f298024e, true, new Object[]{string, string2, Boolean.TRUE});
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopRedDotHandler", 2, "handleClearTroopAioRedDot, succ, troopUin=" + string);
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException unused) {
                        notifyUI(i.f298024e, false, new Object[]{string, string2, Boolean.TRUE});
                        return;
                    }
                }
                notifyUI(i.f298024e, false, new Object[]{string, string2, Boolean.TRUE});
            } catch (InvalidProtocolBufferMicroException unused2) {
                notifyUI(i.f298024e, false, new Object[]{string, string2, Boolean.TRUE});
            }
        }
    }

    private boolean K2(long j3, oidb_0x8c9$GroupAppUnreadInfo oidb_0x8c9_groupappunreadinfo, List<com.tencent.mobileqq.troop.unreadmsg.a> list, StringBuilder sb5) {
        long j16 = oidb_0x8c9_groupappunreadinfo.opt_uint64_appid.get();
        com.tencent.mobileqq.troop.unreadmsg.a aVar = new com.tencent.mobileqq.troop.unreadmsg.a();
        aVar.f301844a = j16;
        aVar.f301845b = String.valueOf(j3);
        aVar.f301847d = oidb_0x8c9_groupappunreadinfo.opt_int32_group_unread_num.get();
        aVar.f301846c = oidb_0x8c9_groupappunreadinfo.opt_int32_group_album_passive_cnt.get();
        aj.a().d(this.appRuntime, j3, aVar);
        if (QLog.isDevelopLevel()) {
            sb5.append("add photoinfo, groupCode = ");
            sb5.append(j3);
            sb5.append(", appid = ");
            sb5.append(aVar.f301844a);
            sb5.append(", messageNum = ");
            sb5.append(aVar.f301846c);
            sb5.append(", newPhotoes = ");
            sb5.append(aVar.f301847d);
        }
        list.add(aVar);
        return L2(false, aVar);
    }

    private boolean L2(boolean z16, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        if (aVar.f301844a == 1102858908) {
            int i3 = aVar.f301847d;
            if (i3 == -1 || i3 > 0 || i3 == 0) {
                return true;
            }
            return z16;
        }
        return z16;
    }

    private void M2(long j3, int i3) {
        this.appRuntime.addDefaultObservers(new a(j3, i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean] */
    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ?? r132;
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                int i3 = mergeFrom.uint32_result.get();
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.troopgetnews..troop.notification_center", 4, "handle_oidb_0x8c9_2|oidb_sso.OIDBSSOPkg.result = " + i3);
                }
                if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = mergeFrom.bytes_bodybuffer.get().toByteArray();
                    try {
                        oidb_0x8c9$RspBody oidb_0x8c9_rspbody = new oidb_0x8c9$RspBody();
                        oidb_0x8c9_rspbody.mergeFrom(byteArray);
                        long j3 = oidb_0x8c9_rspbody.opt_uint64_group_code.get();
                        boolean z16 = true;
                        if (oidb_0x8c9_rspbody.rpt_group_app_unread_info.has()) {
                            List<oidb_0x8c9$GroupAppUnreadInfo> list = oidb_0x8c9_rspbody.rpt_group_app_unread_info.get();
                            arrayList = new ArrayList();
                            StringBuilder sb5 = new StringBuilder();
                            Iterator<oidb_0x8c9$GroupAppUnreadInfo> it = list.iterator();
                            boolean z17 = false;
                            while (it.hasNext()) {
                                boolean z18 = z16;
                                if (K2(j3, it.next(), arrayList, sb5)) {
                                    z17 = z18;
                                }
                                z16 = z18;
                            }
                            r132 = z16;
                            if (QLog.isDevelopLevel()) {
                                QLog.i("Q.troopgetnews..troop.notification_center", 4, sb5.toString());
                            }
                            if (z17) {
                                int i16 = i.C;
                                Object[] objArr = new Object[3];
                                objArr[0] = String.valueOf(j3);
                                Boolean bool = Boolean.FALSE;
                                objArr[r132 == true ? 1 : 0] = bool;
                                objArr[2] = bool;
                                notifyUI(i16, r132, objArr);
                            }
                        } else {
                            r132 = 1;
                            arrayList = null;
                        }
                        int i17 = oidb_0x8c9_rspbody.opt_int32_show_red_point_mobile.get();
                        int i18 = i.f298028m;
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Boolean.FALSE;
                        objArr2[r132] = arrayList;
                        objArr2[2] = Integer.valueOf(i17);
                        notifyUI(i18, r132, objArr2);
                    } catch (Exception e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("Q.troopgetnews..troop.notification_center", 4, "handle_oidb_0x8c9_2|exception = " + e16.toString());
                        }
                    }
                }
            } catch (Exception e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.troopgetnews..troop.notification_center", 4, "handle_oidb_0x8c9_2| oidb_sso parseFrom byte " + e17.toString());
                }
            }
        }
    }

    @Override // qt2.a
    public void b(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            super.notifyUI(i3, z16, obj);
        }
    }

    @Override // qt2.a
    public void b2(String str, List<Long> list, boolean z16) {
        long longValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, list, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TROOP_GET_NEWS, 2, "send_oidb_0x8c9_2, troopUin = " + str + ", appIds : " + list);
        }
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        long j3 = -1;
        if (currentAccountUin != null) {
            try {
                longValue = Long.valueOf(currentAccountUin).longValue();
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_GET_NEWS, 2, "myUin error: myUin = " + currentAccountUin + ", strTroopUin = " + str);
                    return;
                }
                return;
            }
        } else {
            longValue = -1;
        }
        if (str != null) {
            j3 = Long.valueOf(str).longValue();
        }
        oidb_0x8c9$ReqBody oidb_0x8c9_reqbody = new oidb_0x8c9$ReqBody();
        oidb_0x8c9_reqbody.opt_uint64_from_uin.set(longValue);
        oidb_0x8c9_reqbody.opt_uint64_group_code.set(j3);
        oidb_0x8c9_reqbody.rpt_uint64_appid.set(list);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2249);
        PBUInt32Field pBUInt32Field = oidb_sso_oidbssopkg.uint32_service_type;
        if (!z16) {
            i3 = 2;
        }
        pBUInt32Field.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8c9_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x8c9_2");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f301007e == null) {
            HashSet hashSet = new HashSet();
            this.f301007e = hashSet;
            hashSet.add("OidbSvc.0x8c9_2");
            this.f301007e.add("OidbSvc.0x8ca_2");
        }
        return this.f301007e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopRedDotHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return i.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRedDotHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRedDotHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRedDotHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                return;
            }
            return;
        }
        if ("OidbSvc.0x8c9_2".equals(fromServiceMsg.getServiceCmd())) {
            J2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x8ca_2".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // qt2.a
    public void v2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            c cVar = (c) this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
            byte[] I0 = cVar.I0(parseLong);
            if (I0 != null) {
                H2(str, I0, i3);
            } else {
                M2(parseLong, i3);
                cVar.P0(parseLong, "SUBCMD_GET_TROOP_AUTH_FOR_REDPOINT");
            }
        } catch (Exception unused) {
        }
    }
}
