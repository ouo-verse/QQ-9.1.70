package com.tencent.mobileqq.service.friendlist;

import BumpSvc.ReqConfirmContactFriend;
import NeighborComm.ReqHeader;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.troop.c;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroup;
import friendlist.CheckFriendReq;
import friendlist.DelFriendReq;
import friendlist.DelFriendResp;
import friendlist.DelGroup;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.GetFriendsVideoAbiResp;
import friendlist.GetLastLoginInfoReq;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoReq;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoReq;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMem;
import friendlist.MovGroupMemReq;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroup;
import friendlist.RenameGroup;
import friendlist.SetGroupReq;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$ReqBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f286117h;

    /* renamed from: d, reason: collision with root package name */
    boolean f286118d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QQAppInterface> f286119e;

    /* renamed from: f, reason: collision with root package name */
    private c f286120f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f286117h = new String[]{"friendlist", "BumpSvc"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286118d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(IMutualMarkHelperApi.ELEGANT_MUTUAL_MARK, true);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f286119e = new WeakReference<>(qQAppInterface);
        this.f286120f = new c(qQAppInterface);
    }

    private long a(String str) {
        long parseLong;
        if (str == null) {
            return 0L;
        }
        if (str.length() > 0) {
            try {
                parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    private Object c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        DelFriendResp delFriendResp = (DelFriendResp) decodePacket(fromServiceMsg.getWupBuffer(), "DFRESP", new DelFriendResp());
        if (delFriendResp == null) {
            return null;
        }
        return delFriendResp;
    }

    private Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (GetFriendListResp) decodePacket(fromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
    }

    private Object e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (GetLastLoginInfoResp) decodePacket(fromServiceMsg.getWupBuffer(), "GetLastLoginInfoResp", new GetLastLoginInfoResp());
    }

    private Object f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.decode(wupBuffer);
        String funcName = uniPacket.getFuncName();
        if ("GetSimpleOnlineFriendInfoReq".equals(funcName)) {
            GetSimpleOnlineFriendInfoResp getSimpleOnlineFriendInfoResp = (GetSimpleOnlineFriendInfoResp) decodePacket(wupBuffer, "FSOLRESP", new GetSimpleOnlineFriendInfoResp());
            if (getSimpleOnlineFriendInfoResp == null || getSimpleOnlineFriendInfoResp.result == 1) {
                return null;
            }
            return getSimpleOnlineFriendInfoResp;
        }
        if (!"GetFriendsVideoAbiResp".equals(funcName)) {
            return null;
        }
        GetFriendsVideoAbiResp getFriendsVideoAbiResp = (GetFriendsVideoAbiResp) decodePacket(wupBuffer, "VABRESP", new GetFriendsVideoAbiResp());
        if (getFriendsVideoAbiResp != null && getFriendsVideoAbiResp.result == 1) {
            return null;
        }
        return getFriendsVideoAbiResp;
    }

    private Object g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        GetOnlineInfoResp getOnlineInfoResp;
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        uniPacket.decode(wupBuffer);
        if (!"GetOnlineInfoReq".equals(uniPacket.getFuncName()) || (getOnlineInfoResp = (GetOnlineInfoResp) decodePacket(wupBuffer, "GetOnlineInfoResp", new GetOnlineInfoResp())) == null) {
            return null;
        }
        getOnlineInfoResp.dwStatus = (byte) getOnlineInfoResp.dwStatus;
        return getOnlineInfoResp;
    }

    private Object h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        MovGroupMemResp movGroupMemResp = (MovGroupMemResp) decodePacket(fromServiceMsg.getWupBuffer(), "MovGroupMemResp", new MovGroupMemResp());
        if (movGroupMemResp == null) {
            return null;
        }
        return movGroupMemResp;
    }

    private Object i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return (SetGroupResp) decodePacket(fromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
    }

    private QQAppInterface j() {
        WeakReference<QQAppInterface> weakReference = this.f286119e;
        if (weakReference == null || weakReference.get() == null) {
            this.f286119e = new WeakReference<>((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null));
        }
        return this.f286119e.get();
    }

    private boolean k(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.getUin());
        if (a16 == 0) {
            return false;
        }
        long a17 = a(toServiceMsg.extraData.getString("uin"));
        if (a17 == 0) {
            return false;
        }
        CheckFriendReq checkFriendReq = new CheckFriendReq();
        checkFriendReq.uin = a16;
        checkFriendReq.fuin = a17;
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("CheckFriendReq");
        uniPacket.put("CF", checkFriendReq);
        return true;
    }

    private boolean l(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.getUin());
        int i3 = toServiceMsg.extraData.getInt("bType");
        long j3 = toServiceMsg.extraData.getLong("lToMID");
        long j16 = toServiceMsg.extraData.getLong("lFromMobile");
        long j17 = toServiceMsg.extraData.getLong("lToMobile");
        byte[] byteArray = toServiceMsg.extraData.getByteArray("vSig");
        byte b16 = toServiceMsg.extraData.getByte("bGroupId");
        String string = toServiceMsg.extraData.getString("strNickName");
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 1;
        reqHeader.lMID = a16;
        reqHeader.iAppID = AppSetting.f();
        reqHeader.eBusiType = 1;
        reqHeader.eMqqSysType = 2;
        ReqConfirmContactFriend reqConfirmContactFriend = new ReqConfirmContactFriend((byte) i3, j3, j16, j17, byteArray, b16, null, string);
        uniPacket.setServantName("BumpSvc");
        uniPacket.setFuncName("CMD_CONFIRM_CONTACT_FRIEND");
        uniPacket.put("ReqHeader", reqHeader);
        uniPacket.put("ReqConfirmContactFriend", reqConfirmContactFriend);
        return true;
    }

    private boolean m(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.getUin());
        if (a16 == 0) {
            return false;
        }
        Bundle bundle = toServiceMsg.extraData;
        long a17 = a(bundle.getString("uin"));
        if (a17 == 0 || a16 == a17) {
            return false;
        }
        byte b16 = bundle.getByte(PictureConst.KEY_DEL_TYPE);
        if (b16 != 1 && b16 != 2) {
            b16 = 1;
        }
        DelFriendReq delFriendReq = new DelFriendReq();
        if (bundle.containsKey("not_shield_tmp_session")) {
            delFriendReq.notShieldTmpSession = bundle.getInt("not_shield_tmp_session");
        }
        delFriendReq.uin = a16;
        delFriendReq.deluin = a17;
        delFriendReq.delType = b16;
        delFriendReq.version = 1;
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("DelFriendReq");
        uniPacket.put("DF", delFriendReq);
        return true;
    }

    private boolean n(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        int i3;
        short s16 = toServiceMsg.extraData.getShort(FriendListHandler.PARAMS_FRIEND_START_INDEX);
        short s17 = toServiceMsg.extraData.getShort("friendCount");
        byte b16 = toServiceMsg.extraData.getByte("groupStartIndex");
        byte b17 = toServiceMsg.extraData.getByte("groupCount");
        byte b18 = toServiceMsg.extraData.getByte("ifShowTermType");
        if (s16 > 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        Oidb_0xd50$ReqBody oidb_0xd50$ReqBody = new Oidb_0xd50$ReqBody();
        oidb_0xd50$ReqBody.appid.set(10002L);
        oidb_0xd50$ReqBody.req_music_switch.set(1);
        oidb_0xd50$ReqBody.req_ksing_switch.set(1);
        oidb_0xd50$ReqBody.req_mutualmark_lbsshare.set(1);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListService", 2, "handleGetAllInfo: invoked. ", " req lbs share profile. ");
        }
        oidb_0xd50$ReqBody.req_mutualmark_alienation.set(1);
        oidb_0xd50$ReqBody.req_aio_quick_app.set(1);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(13580L);
        arrayList.add(13581L);
        arrayList.add(13582L);
        Oidb_0xd6b$ReqBody oidb_0xd6b$ReqBody = new Oidb_0xd6b$ReqBody();
        if (this.f286118d) {
            oidb_0xd6b$ReqBody.cmd_version.set("1");
        }
        byte b19 = (byte) i3;
        GetFriendListReq getFriendListReq = new GetFriendListReq(3, b19, Long.valueOf(toServiceMsg.getUin()).longValue(), s16, s17, (byte) 0, b19, b16, b17, (byte) 0, b18, 41L, null, 0, (byte) 0, (byte) 0, oidb_0xd50$ReqBody.toByteArray(), oidb_0xd6b$ReqBody.toByteArray(), arrayList);
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("GetFriendListReq");
        uniPacket.put("FL", getFriendListReq);
        return true;
    }

    private boolean o(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.extraData.getBoolean("getSingleFriend")) {
            return s(toServiceMsg, uniPacket);
        }
        return n(toServiceMsg, uniPacket);
    }

    private boolean p(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("uin");
        long j16 = toServiceMsg.extraData.getLong("current_req_uin");
        GetLastLoginInfoReq getLastLoginInfoReq = new GetLastLoginInfoReq(j3, new LastLoginPageInfo(toServiceMsg.extraData.getLong("total_req_times"), toServiceMsg.extraData.getLong("current_req_index"), j16));
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("GetLastLoginInfoReq");
        uniPacket.put("GetLastLoginInfoReq", getLastLoginInfoReq);
        return true;
    }

    private boolean q(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long a16 = a(toServiceMsg.getUin());
        if (a16 == 0) {
            return false;
        }
        GetSimpleOnlineFriendInfoReq getSimpleOnlineFriendInfoReq = new GetSimpleOnlineFriendInfoReq(a16, (byte) 0, (byte) 0, null, toServiceMsg.extraData.getByte("ifShowTermType"), 41L, toServiceMsg.extraData.getByte("srcType"));
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("GetSimpleOnlineFriendInfoReq");
        uniPacket.put("FSOLREQ", getSimpleOnlineFriendInfoReq);
        return true;
    }

    private boolean r(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetOnlineInfoReq getOnlineInfoReq;
        long j3 = toServiceMsg.extraData.getLong("dwReqType");
        if (j3 == 0) {
            getOnlineInfoReq = new GetOnlineInfoReq(j3, toServiceMsg.extraData.getLong("dwUin"), null, 41L, true);
        } else {
            getOnlineInfoReq = new GetOnlineInfoReq(j3, 0L, toServiceMsg.extraData.getString("strMobile"), 7L, false);
        }
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("GetOnlineInfoReq");
        uniPacket.put("GetOnlineInfoReq", getOnlineInfoReq);
        return true;
    }

    private boolean s(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String string = toServiceMsg.extraData.getString(IProfileProtocolConst.PARAM_TARGET_UIN);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        GetFriendListReq getFriendListReq = new GetFriendListReq();
        getFriendListReq.reqtype = 3;
        getFriendListReq.ifReflush = (byte) 1;
        getFriendListReq.ifShowTermType = (byte) 1;
        getFriendListReq.version = 41L;
        Oidb_0xd50$ReqBody oidb_0xd50$ReqBody = new Oidb_0xd50$ReqBody();
        oidb_0xd50$ReqBody.appid.set(10002L);
        oidb_0xd50$ReqBody.req_music_switch.set(1);
        oidb_0xd50$ReqBody.req_ksing_switch.set(1);
        oidb_0xd50$ReqBody.req_mutualmark_lbsshare.set(1);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListService", 2, "handleGetSingleInfo: invoked. req lbs share profile. ");
        }
        oidb_0xd50$ReqBody.req_mutualmark_alienation.set(1);
        oidb_0xd50$ReqBody.req_aio_quick_app.set(1);
        getFriendListReq.vec0xd50Req = oidb_0xd50$ReqBody.toByteArray();
        Oidb_0xd6b$ReqBody oidb_0xd6b$ReqBody = new Oidb_0xd6b$ReqBody();
        if (this.f286118d) {
            oidb_0xd6b$ReqBody.cmd_version.set("1");
        }
        getFriendListReq.vec0xd6bReq = oidb_0xd6b$ReqBody.toByteArray();
        ArrayList<Long> arrayList = new ArrayList<>(1);
        try {
            getFriendListReq.uin = Long.parseLong(j().getCurrentAccountUin());
            arrayList.add(Long.valueOf(Long.parseLong(string)));
            getFriendListReq.uinList = arrayList;
            uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
            uniPacket.setFuncName("GetFriendListReq");
            uniPacket.put("FL", getFriendListReq);
            return true;
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean t(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        byte b16 = toServiceMsg.extraData.getByte("move_fri_type");
        if (b16 == 0) {
            return v(toServiceMsg, uniPacket);
        }
        if (b16 == 1) {
            return u(toServiceMsg, uniPacket);
        }
        return false;
    }

    private boolean u(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        byte[] bArr;
        byte b16;
        long a16 = a(toServiceMsg.getUin());
        if (a16 == 0) {
            return false;
        }
        Bundle bundle = toServiceMsg.extraData;
        String[] stringArray = bundle.getStringArray("uins");
        if (stringArray == null) {
            stringArray = new String[0];
        }
        MovGroupMemReq movGroupMemReq = new MovGroupMemReq();
        movGroupMemReq.uin = a16;
        movGroupMemReq.reqtype = (byte) 1;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeShort(stringArray.length * 5);
            for (String str : stringArray) {
                long a17 = a(str);
                if (a17 != 0 && (b16 = bundle.getByte("group_id")) >= 0) {
                    dataOutputStream.writeInt((int) a17);
                    dataOutputStream.writeByte(b16);
                }
            }
            dataOutputStream.writeShort(0);
            dataOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        movGroupMemReq.vecBody = bArr;
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("MovGroupMemReq");
        uniPacket.put("MovGroupMemReq", movGroupMemReq);
        return true;
    }

    private boolean v(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        byte b16;
        byte[] bArr;
        long a16 = a(toServiceMsg.getUin());
        if (a16 == 0) {
            return false;
        }
        Bundle bundle = toServiceMsg.extraData;
        long a17 = a(bundle.getString("uin"));
        if (a17 == 0 || (b16 = bundle.getByte("group_id")) < 0) {
            return false;
        }
        MovGroupMem movGroupMem = new MovGroupMem();
        movGroupMem.Ver = (byte) 1;
        movGroupMem.wReqLen = (short) 5;
        movGroupMem.dwUin = a17;
        movGroupMem.cGroupid = b16;
        movGroupMem.wReserveLen = (short) 0;
        MovGroupMemReq movGroupMemReq = new MovGroupMemReq();
        movGroupMemReq.uin = a16;
        movGroupMemReq.reqtype = (byte) 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeShort(5);
            dataOutputStream.writeInt((int) a17);
            dataOutputStream.writeByte(b16);
            dataOutputStream.writeShort(0);
            dataOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        movGroupMemReq.vecBody = bArr;
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("MovGroupMemReq");
        uniPacket.put("MovGroupMemReq", movGroupMemReq);
        return true;
    }

    private boolean w(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("SetGroupReq");
        SetGroupReq setGroupReq = new SetGroupReq();
        try {
            setGroupReq.uin = Long.parseLong(toServiceMsg.getUin());
            setGroupReq.reqtype = toServiceMsg.extraData.getInt("set_type");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i3 = setGroupReq.reqtype;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return false;
                        }
                        ReSortGroup reSortGroup = new ReSortGroup();
                        reSortGroup.cGroupId = toServiceMsg.extraData.getByteArray("group_id_list");
                        reSortGroup.cSortId = toServiceMsg.extraData.getByteArray("sort_id_list");
                        byte length = (byte) reSortGroup.cGroupId.length;
                        reSortGroup.cNum = length;
                        dataOutputStream.writeByte(length);
                        byte[] bArr = reSortGroup.cGroupId;
                        byte[] bArr2 = reSortGroup.cSortId;
                        for (int i16 = 0; i16 < bArr.length; i16++) {
                            dataOutputStream.writeByte(bArr[i16]);
                            dataOutputStream.writeByte(bArr2[i16]);
                        }
                    } else {
                        DelGroup delGroup = new DelGroup();
                        byte b16 = toServiceMsg.extraData.getByte("group_id");
                        delGroup.cGroupId = b16;
                        dataOutputStream.writeByte(b16);
                    }
                } else {
                    RenameGroup renameGroup = new RenameGroup();
                    renameGroup.cGroupId = toServiceMsg.extraData.getByte("group_id");
                    String string = toServiceMsg.extraData.getString("group_name");
                    renameGroup.sGroupName = string;
                    byte[] bytes = string.getBytes();
                    renameGroup.cLen = (byte) bytes.length;
                    dataOutputStream.write(renameGroup.cGroupId);
                    dataOutputStream.writeByte(renameGroup.cLen);
                    dataOutputStream.write(bytes);
                }
            } else {
                AddGroup addGroup = new AddGroup();
                addGroup.cSortId = toServiceMsg.extraData.getByte("sort_id");
                String string2 = toServiceMsg.extraData.getString("group_name");
                addGroup.sGroupName = string2;
                byte[] bytes2 = string2.getBytes();
                addGroup.cLen = (byte) bytes2.length;
                dataOutputStream.writeByte(addGroup.cSortId);
                dataOutputStream.writeByte(addGroup.cLen);
                dataOutputStream.write(bytes2);
            }
            dataOutputStream.close();
            setGroupReq.vecBody = byteArrayOutputStream.toByteArray();
            uniPacket.put("SetGroupReq", setGroupReq);
            return true;
        } catch (IOException | NumberFormatException unused) {
            return false;
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f286117h;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ("friendlist.getFriendGroupList".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return d(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.GetLastLoginInfoReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return e(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.MovGroupMemReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return h(toServiceMsg, fromServiceMsg);
        }
        if ("BumpSvc.ReqComfirmContactFriend".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return b(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.GetSimpleOnlineFriendInfoReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return f(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.GetOnlineInfoReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return g(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.delFriend".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return c(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.SetGroupReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return i(toServiceMsg, fromServiceMsg);
        }
        if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            return this.f286120f.decode(toServiceMsg, fromServiceMsg);
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void decodeRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getFriendGroupList")) {
            return o(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetLastLoginInfoReq")) {
            return p(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.delFriend")) {
            return m(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.checkFriend")) {
            return k(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetSimpleOnlineFriendInfoReq")) {
            return q(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetOnlineInfoReq")) {
            return r(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("BumpSvc.ReqComfirmContactFriend")) {
            return l(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.MovGroupMemReq")) {
            return t(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.SetGroupReq")) {
            return w(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupCardReq")) {
            return this.f286120f.encodeReqMsg(toServiceMsg, uniPacket);
        }
        return false;
    }

    private Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return fromServiceMsg;
    }
}
