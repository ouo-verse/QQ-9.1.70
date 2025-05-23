package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.al;
import com.tencent.mobileqq.troop.api.handler.j;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$RspGroupInfo;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22$AppInfo;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22$ReqBody;
import tencent.im.oidb.cmd0xd22.Oidb_0xd22$RspBody;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23$AppInfo;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23$GroupInfo;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23$ReqBody;
import tencent.im.oidb.cmd0xd23.Oidb_0xd23$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.opengroup.jstoken$ReqBody;
import tencent.im.opengroup.jstoken$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTokenHandler extends TroopBaseHandler implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f296255e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Long> f296256f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, ArrayList<stTroopMemberInfo>> f296257h;

    public TroopTokenHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f296256f = new HashMap<>();
            this.f296257h = null;
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            Oidb_0xd23$RspBody oidb_0xd23$RspBody = new Oidb_0xd23$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xd23$RspBody);
            if (parseOIDBPkg == 0) {
                if (oidb_0xd23$RspBody.bind_flag.has()) {
                    i3 = oidb_0xd23$RspBody.bind_flag.get();
                } else {
                    i3 = -1;
                }
                if (oidb_0xd23$RspBody.group_code.has()) {
                    j3 = oidb_0xd23$RspBody.group_code.get();
                } else {
                    j3 = -1;
                }
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD23_2, true, new Object[]{Integer.valueOf(i3), Long.valueOf(j3)});
            } else {
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD23_2, false, null);
            }
            QLog.i("TroopAbility.TroopHandler", 1, "handleBindTroopForThirdApp result: " + parseOIDBPkg);
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            Oidb_0xd22$RspBody oidb_0xd22$RspBody = new Oidb_0xd22$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xd22$RspBody);
            if (parseOIDBPkg == 0) {
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD22_1, true, new Object[]{oidb_0xd22$RspBody.create_group_url.get().toStringUtf8()});
            } else {
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD22_1, false, null);
            }
            QLog.i("TroopAbility.Handler", 1, "handleGetCreateTroopTokenForThirdApp result: " + parseOIDBPkg);
        }
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            Oidb_0xd22$RspBody oidb_0xd22$RspBody = new Oidb_0xd22$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xd22$RspBody);
            if (parseOIDBPkg == 0) {
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD22_2, true, new Object[]{oidb_0xd22$RspBody.join_group_token.get().toStringUtf8(), String.valueOf(oidb_0xd22$RspBody.group_code.get())});
            } else {
                notifyUI(e.TYPE_NOTIFY_OIDB_0XD22_2, false, null);
            }
            QLog.i("TroopAbility.Handler", 1, "handleGetJoinTroopTokenForThirdApp result: " + parseOIDBPkg);
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        if (toServiceMsg != null && fromServiceMsg != null) {
            boolean z18 = toServiceMsg.extraData.getBoolean("lastPage");
            oidb_0x88d$RspBody oidb_0x88d_rspbody = new oidb_0x88d$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x88d_rspbody);
            if (parseOIDBPkg == 0 && oidb_0x88d_rspbody.stzrspgroupinfo.has()) {
                List<oidb_0x88d$RspGroupInfo> list = oidb_0x88d_rspbody.stzrspgroupinfo.get();
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    oidb_0x88d$RspGroupInfo oidb_0x88d_rspgroupinfo = list.get(i3);
                    long j3 = oidb_0x88d_rspgroupinfo.uint64_group_code.get();
                    if (oidb_0x88d_rspgroupinfo.stgroupinfo.has()) {
                        oidb_0x88d$GroupInfo oidb_0x88d_groupinfo = oidb_0x88d_rspgroupinfo.stgroupinfo.get();
                        TroopInfo findTroopInfo = ((ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(j3));
                        if (findTroopInfo == null) {
                            findTroopInfo = new TroopInfo(j3);
                        }
                        if (oidb_0x88d_groupinfo.uint32_is_conf_group.has()) {
                            if (oidb_0x88d_groupinfo.uint32_is_conf_group.get() == 1) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            findTroopInfo.isNewTroop = z17;
                        }
                        if (oidb_0x88d_groupinfo.uint32_hl_guild_appid.has()) {
                            findTroopInfo.hlGuildAppid = oidb_0x88d_groupinfo.uint32_hl_guild_appid.get();
                        }
                        if (oidb_0x88d_groupinfo.uint32_hl_guild_sub_type.has()) {
                            findTroopInfo.hlGuildSubType = oidb_0x88d_groupinfo.uint32_hl_guild_sub_type.get();
                        }
                        if (oidb_0x88d_groupinfo.uint32_hl_guild_orgid.has()) {
                            findTroopInfo.hlGuildOrgid = oidb_0x88d_groupinfo.uint32_hl_guild_orgid.get();
                        }
                        if (oidb_0x88d_groupinfo.uint32_is_allow_hl_guild_binary.has()) {
                            findTroopInfo.hlGuildBinary = oidb_0x88d_groupinfo.uint32_is_allow_hl_guild_binary.get();
                        }
                        QLog.i("TroopAbility.TroopHandler", 1, "troop uin: " + findTroopInfo.troopuin + " isNewTroop:" + findTroopInfo.isNewTroop + " hlGuideBinary: " + findTroopInfo.hlGuildBinary + " hlGuildAppid: " + findTroopInfo.hlGuildAppid + " hlGuildSubType: " + findTroopInfo.hlGuildSubType + " hlGuildOrgid: " + findTroopInfo.hlGuildOrgid);
                    }
                }
                int i16 = e.TYPE_NOTIFY_BATCH_GET_TROOP_PROFILE;
                if (parseOIDBPkg == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                notifyUI(i16, z16, new Object[]{Boolean.valueOf(z18)});
            }
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int i16 = toServiceMsg.extraData.getInt("appid");
            String string = toServiceMsg.extraData.getString("openGroupId");
            String string2 = toServiceMsg.extraData.getString("token");
            String string3 = toServiceMsg.extraData.getString("url");
            int i17 = toServiceMsg.extraData.getInt("seq");
            int resultCode = fromServiceMsg.getResultCode();
            if (resultCode == 1000) {
                jstoken$RspBody jstoken_rspbody = new jstoken$RspBody();
                try {
                    jstoken_rspbody.mergeFrom((byte[]) obj);
                    if (jstoken_rspbody.uint32_result.get() != 0) {
                        notifyUI(e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, new Object[]{0, null, null, null, 0, 0, null, Integer.valueOf(toServiceMsg.extraData.getInt("seq")), Integer.valueOf(jstoken_rspbody.uint32_result.get())});
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp: rspBody.uint32_result.get():" + jstoken_rspbody.uint32_result.get());
                            return;
                        }
                        return;
                    }
                    int i18 = jstoken_rspbody.uint32_frequency.get();
                    String stringUtf8 = jstoken_rspbody.bytes_err_info.get().toStringUtf8();
                    int i19 = jstoken_rspbody.uint32_token_time_out.get();
                    List<ByteStringMicro> list = jstoken_rspbody.rpt_bytes_apilist.get();
                    ArrayList arrayList = new ArrayList();
                    Iterator<ByteStringMicro> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().toStringUtf8());
                    }
                    notifyUI(e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, true, new Object[]{Integer.valueOf(i16), string, string2, string3, Integer.valueOf(i18), Integer.valueOf(i19), arrayList, Integer.valueOf(i17), Integer.valueOf(jstoken_rspbody.uint32_result.get())});
                    QLog.d("TroopTokenHandler", 2, "uint32_frequency:" + i18 + "|erroInfo:" + stringUtf8 + "|rpt_bytes_apilist:" + jstoken_rspbody.rpt_bytes_apilist.get().toString() + "|uint32_result:" + jstoken_rspbody.uint32_result);
                    return;
                } catch (Exception e16) {
                    notifyUI(e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, null);
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopTokenHandler.troop.openapi", 2, "handleTroopOpenApiVerifyRsp, onReceive" + e16.toString());
                        return;
                    }
                    return;
                }
            }
            notifyUI(e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY, false, new Object[]{0, null, null, null, 0, 0, null, Integer.valueOf(i17), -1001});
            if (QLog.isColorLevel()) {
                QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp: resp.getResultCode():" + resultCode);
                return;
            }
            return;
        }
        int i26 = e.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY;
        Object[] objArr = new Object[9];
        objArr[0] = 0;
        objArr[1] = null;
        objArr[2] = null;
        objArr[3] = null;
        objArr[4] = 0;
        objArr[5] = 0;
        objArr[6] = null;
        if (toServiceMsg == null) {
            i3 = -1;
        } else {
            i3 = toServiceMsg.extraData.getInt("seq");
        }
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = -1001;
        notifyUI(i26, false, objArr);
        if (QLog.isColorLevel()) {
            QLog.d("TroopTokenHandler", 2, "handleTroopOpenApiVerifyRsp: req == null || resp == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void D0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("TroopAbility.TroopHandler", 1, "getCreateTroopTokenForThirdApp appId: " + i3 + " orgId: " + i16);
        Oidb_0xd22$ReqBody oidb_0xd22$ReqBody = new Oidb_0xd22$ReqBody();
        Oidb_0xd22$AppInfo oidb_0xd22$AppInfo = new Oidb_0xd22$AppInfo();
        oidb_0xd22$AppInfo.appid.set(i3);
        oidb_0xd22$AppInfo.organization_id.set(i16);
        oidb_0xd22$ReqBody.app_info.set(oidb_0xd22$AppInfo);
        sendPbReq(makeOIDBPkg("OidbSvc.0xd22_1", 3362, 1, oidb_0xd22$ReqBody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void F1(int i3, String str, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16));
            return;
        }
        if (i3 != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1809);
            oidb_sso_oidbssopkg.uint32_service_type.set(127);
            ByteBuffer allocate = ByteBuffer.allocate(str.getBytes().length + 6);
            allocate.putInt(i3);
            allocate.putShort((short) str.getBytes().length);
            allocate.put(str.getBytes());
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x711_127");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putString("openId", str);
            createToServiceMsg.extraData.putString("token", str2);
            createToServiceMsg.extraData.putInt("appid", i3);
            createToServiceMsg.extraData.putInt("seq", i16);
            sendPbReq(createToServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void G1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("TroopAbility.Handler", 1, "getJoinTroopTokenForThirdApp appId: " + i3 + " organizationId: " + i16);
        Oidb_0xd22$ReqBody oidb_0xd22$ReqBody = new Oidb_0xd22$ReqBody();
        Oidb_0xd22$AppInfo oidb_0xd22$AppInfo = new Oidb_0xd22$AppInfo();
        oidb_0xd22$AppInfo.appid.set(i3);
        oidb_0xd22$AppInfo.organization_id.set(i16);
        oidb_0xd22$ReqBody.app_info.set(oidb_0xd22$AppInfo);
        sendPbReq(makeOIDBPkg("OidbSvc.0xd22_2", 3362, 2, oidb_0xd22$ReqBody.toByteArray()));
    }

    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp:");
        }
        int i3 = toServiceMsg.extraData.getInt("appid");
        String string = toServiceMsg.extraData.getString("openId");
        String string2 = toServiceMsg.extraData.getString("token");
        int i16 = toServiceMsg.extraData.getInt("seq");
        if (!fromServiceMsg.isSuccess()) {
            notifyUI(e.TYPE_GET_UIN_BY_OPEN_ID, false, new Object[]{Integer.valueOf(i3), string, string2, "", Integer.valueOf(i16), Integer.valueOf(fromServiceMsg.getResultCode()), null});
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            int i17 = mergeFrom.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, resultCode:" + i17);
            }
            byte[] byteArray = mergeFrom.bytes_bodybuffer.get().toByteArray();
            if (i17 == 0) {
                byte[] bArr = new byte[4];
                System.arraycopy(byteArray, 0, bArr, 0, 4);
                String str = ByteBuffer.wrap(bArr).getInt() + "";
                Object obj2 = new Object();
                al.a().c(this.appRuntime, str, obj2);
                notifyUI(e.TYPE_GET_UIN_BY_OPEN_ID, true, new Object[]{Integer.valueOf(i3), string, string2, str, Integer.valueOf(i16), Integer.valueOf(fromServiceMsg.getResultCode()), obj2});
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTokenHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, uin:" + str);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_GET_UIN_BY_OPEN_ID, 2, "pkg.mergeFrom:" + e16.toString());
            }
            notifyUI(e.TYPE_GET_UIN_BY_OPEN_ID, false, new Object[]{Integer.valueOf(i3), string, string2, "", Integer.valueOf(i16), Integer.valueOf(fromServiceMsg.getResultCode()), null});
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void X0(int i3, int i16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str);
            return;
        }
        QLog.i("TroopAbility.TroopHandler", 1, "bindTroopForThirdApp appid: " + i3 + " orgid: " + i16 + " troopUin: " + j3 + " appName: " + str);
        Oidb_0xd23$ReqBody oidb_0xd23$ReqBody = new Oidb_0xd23$ReqBody();
        Oidb_0xd23$AppInfo oidb_0xd23$AppInfo = new Oidb_0xd23$AppInfo();
        oidb_0xd23$AppInfo.appid.set(i3);
        oidb_0xd23$AppInfo.organization_id.set(i16);
        Oidb_0xd23$GroupInfo oidb_0xd23$GroupInfo = new Oidb_0xd23$GroupInfo();
        oidb_0xd23$GroupInfo.group_code.set(j3);
        oidb_0xd23$GroupInfo.group_name.set(str);
        oidb_0xd23$AppInfo.group_info.set(oidb_0xd23$GroupInfo);
        oidb_0xd23$ReqBody.app_info.set(oidb_0xd23$AppInfo);
        E2(makeOIDBPkg("OidbSvc.0xd23_2", 3363, 2, oidb_0xd23$ReqBody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void e0(int i3, String str, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
            return;
        }
        jstoken$ReqBody jstoken_reqbody = new jstoken$ReqBody();
        jstoken_reqbody.uint32_appid.set(i3);
        if (!TextUtils.isEmpty(str)) {
            jstoken_reqbody.bytes_group_openid.set(ByteStringMicro.copyFromUtf8(str));
        }
        if (!TextUtils.isEmpty(str2)) {
            jstoken_reqbody.bytes_jstoken.set(ByteStringMicro.copyFromUtf8(str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            jstoken_reqbody.bytes_url.set(ByteStringMicro.copyFromUtf8(str3));
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("GroupOpen.CheckJsApiToken");
        createToServiceMsg.putWupBuffer(jstoken_reqbody.toByteArray());
        createToServiceMsg.extraData.putInt("appid", i3);
        createToServiceMsg.extraData.putString("url", str3);
        createToServiceMsg.extraData.putString("openGroupId", str);
        createToServiceMsg.extraData.putString("token", str2);
        createToServiceMsg.extraData.putInt("seq", i16);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f296255e == null) {
            HashSet hashSet = new HashSet();
            this.f296255e = hashSet;
            hashSet.add("OidbSvc.0xd22_1");
            this.f296255e.add("OidbSvc.0xd22_2");
            this.f296255e.add("OidbSvc.0xd23_2");
            this.f296255e.add("GroupOpen.CheckJsApiToken");
            this.f296255e.add("OidbSvc.0x88d_75");
            this.f296255e.add("OidbSvc.0x711_127");
        }
        return this.f296255e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "TroopTokenHandler";
    }

    @Override // com.tencent.mobileqq.troop.api.handler.j
    public void o(List<TroopInfo> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16));
            return;
        }
        if (list != null && !list.isEmpty()) {
            oidb_0x88d$ReqBody oidb_0x88d_reqbody = new oidb_0x88d$ReqBody();
            oidb_0x88d_reqbody.uint32_appid.set(200000020);
            for (TroopInfo troopInfo : list) {
                oidb_0x88d$GroupInfo oidb_0x88d_groupinfo = new oidb_0x88d$GroupInfo();
                oidb_0x88d_groupinfo.uint32_is_conf_group.set(0);
                oidb_0x88d_groupinfo.uint32_hl_guild_appid.set(0);
                oidb_0x88d_groupinfo.uint32_hl_guild_sub_type.set(0);
                oidb_0x88d_groupinfo.uint32_hl_guild_orgid.set(0);
                oidb_0x88d_groupinfo.uint32_is_allow_hl_guild_binary.set(0);
                oidb_0x88d$ReqGroupInfo oidb_0x88d_reqgroupinfo = new oidb_0x88d$ReqGroupInfo();
                try {
                    oidb_0x88d_reqgroupinfo.uint64_group_code.set(Long.parseLong(troopInfo.troopuin));
                } catch (NumberFormatException e16) {
                    QLog.e("TroopTokenHandler", 1, e16, new Object[0]);
                }
                oidb_0x88d_reqgroupinfo.stgroupinfo.set(oidb_0x88d_groupinfo);
                oidb_0x88d_reqbody.stzreqgroupinfo.add(oidb_0x88d_reqgroupinfo);
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x88d_75", 2189, 75, oidb_0x88d_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("subCmd", 12);
            makeOIDBPkg.extraData.putBoolean("lastPage", z16);
            E2(makeOIDBPkg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.class;
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
                    QLog.d("TroopTokenHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopTokenHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xd22_1".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xd22_2".equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xd23_2".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("GroupOpen.CheckJsApiToken".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0x88d_75".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x711_127".equals(fromServiceMsg.getServiceCmd())) {
                    J2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopTokenHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
