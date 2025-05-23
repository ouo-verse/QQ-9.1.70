package com.tencent.mobileqq.app;

import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import NeighborSvc.Switch;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.proto.lbsshare.LBSShare$GetShopsByIdsReq;
import com.tencent.proto.lbsshare.LBSShare$LocationReq;
import com.tencent.proto.lbsshare.LBSShare$NearByShopsReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5$GroupInfo;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5$RspBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0$NearbyUser;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0$ReqBody;
import tencent.im.oidb.cmd0x9c0.cmd0x9c0$RspBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1$ReqBody;
import tencent.im.oidb.cmd0x9c1.cmd0x9c1$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LBSHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f194789e;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f194790d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f194789e = null;
        }
    }

    public LBSHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f194790d = qQAppInterface;
        }
    }

    public static boolean D2(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return false;
        }
        boolean j06 = qQAppInterface.getMessageFacade().j0(str, 1001);
        if (QLog.isColorLevel()) {
            QLog.d("LBSHandlerQ.nearby.follow", 2, "hasReply:" + j06);
        }
        return j06;
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (obj != null) {
            RespGetSwitches respGetSwitches = (RespGetSwitches) obj;
            if (respGetSwitches.stHeader.eReplyCode == 0) {
                Iterator<Switch> it = respGetSwitches.switches.iterator();
                while (it.hasNext()) {
                    Switch next = it.next();
                    int i3 = next.type;
                    if (i3 == 64) {
                        QQAppInterface qQAppInterface = this.f194790d;
                        if (next.is_open == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        qQAppInterface.setVisibilityForStatus(z18, true);
                    } else if (i3 == 1) {
                        INearbySPUtil iNearbySPUtil = (INearbySPUtil) QRoute.api(INearbySPUtil.class);
                        String account = this.f194790d.getAccount();
                        if (next.is_open == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        iNearbySPUtil.setVisibilityForPeople(account, z16);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(next.type);
                    if (next.is_open == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objArr[1] = Boolean.valueOf(z17);
                    notifyUI(10, true, objArr);
                }
                return;
            }
        }
        notifyUI(10, false, null);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        boolean z17 = toServiceMsg.extraData.getBoolean("k_be_share", false);
        if (obj != null && ((RespSetStateSwitch) obj).stHeader.eReplyCode == 0) {
            z16 = true;
            this.f194790d.setVisibilityForStatus(z17, true);
        } else {
            z17 = this.f194790d.getLocVisibilityForStatus();
        }
        notifyUI(9, z16, Boolean.valueOf(z17));
    }

    public static Dialog N2(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, str, R.string.cancel, R.string.heh, onClickListener, onClickListener2);
        if (createCustomDialog != null) {
            ((TextView) createCustomDialog.findViewById(R.id.bit)).setVisibility(8);
            TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setMinHeight(com.tencent.mobileqq.util.x.c(context, 35.0f));
            textView.setGravity(17);
        }
        return createCustomDialog;
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception exc;
        int i3;
        int i16;
        boolean z17;
        int i17;
        String str;
        boolean z18;
        String str2;
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i18 = -1;
        ArrayList arrayList = null;
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    cmd0x9c0$RspBody cmd0x9c0_rspbody = new cmd0x9c0$RspBody();
                    cmd0x9c0_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (cmd0x9c0_rspbody.uint32_req_interval.has()) {
                        i17 = cmd0x9c0_rspbody.uint32_req_interval.get();
                    } else {
                        i17 = -1;
                    }
                    try {
                        if (cmd0x9c0_rspbody.uint32_heartbeat_interval.has()) {
                            i18 = cmd0x9c0_rspbody.uint32_heartbeat_interval.get();
                        }
                        List<cmd0x9c0$NearbyUser> list = cmd0x9c0_rspbody.rpt_nearby_user_list.get();
                        if (list == null || list.size() <= 0) {
                            QLog.d("LBSHandler", 1, "rcv nearbyUserList is null!");
                            z17 = false;
                        }
                        if (z17) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i19 = 0; i19 < list.size(); i19++) {
                                try {
                                    String str3 = "";
                                    if (!list.get(i19).uint64_nearby_uin.has()) {
                                        str = "";
                                    } else {
                                        str = String.valueOf(list.get(i19).uint64_nearby_uin.get());
                                    }
                                    if (list.get(i19).uint32_is_frd.has() && list.get(i19).uint32_is_frd.get() == 1) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (!list.get(i19).bytes_remark.has()) {
                                        str2 = "";
                                    } else {
                                        str2 = list.get(i19).bytes_remark.get().toStringUtf8();
                                    }
                                    if (list.get(i19).bytes_nick.has()) {
                                        str3 = list.get(i19).bytes_nick.get().toStringUtf8();
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("LBSHandler", 2, "faceTofaceNearbyUser: i: " + i19 + ", nearbyUin: " + str + ", isFriend: " + z18 + ", remark: " + str2 + ", nick: " + str3);
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        arrayList2.add(new com.tencent.mobileqq.facetoface.g(str, z18, str2, str3));
                                    }
                                } catch (Exception e16) {
                                    exc = e16;
                                    i3 = i18;
                                    arrayList = arrayList2;
                                    i18 = i17;
                                    QLog.d("LBSHandler", 1, "rspFacetoFaceAddFriendReg Exception " + exc.getMessage());
                                    i16 = i3;
                                    z16 = false;
                                    notifyUI(25, z16, new Object[]{arrayList, Integer.valueOf(i18), Integer.valueOf(i16)});
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                QLog.d("LBSHandler", 1, "faceTofaceNearbyUserList is empty!");
                                z17 = false;
                            }
                            arrayList = arrayList2;
                        }
                        i16 = i18;
                        z16 = z17;
                        i18 = i17;
                    } catch (Exception e17) {
                        exc = e17;
                        i3 = i18;
                    }
                } else {
                    QLog.d("LBSHandler", 1, "rspFacetoFaceAddFriendReg: resultCode:" + oidb_sso_oidbssopkg.uint32_result.get());
                    i16 = -1;
                    z16 = z17;
                }
            } catch (Exception e18) {
                exc = e18;
                i3 = -1;
            }
        } else {
            i16 = -1;
        }
        notifyUI(25, z16, new Object[]{arrayList, Integer.valueOf(i18), Integer.valueOf(i16)});
    }

    private void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String str;
        boolean z17 = true;
        boolean z18 = false;
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String string = toServiceMsg.extraData.getString("currentAccountUin");
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                    z17 = false;
                }
                if (z17) {
                    cmd0x9c1$RspBody cmd0x9c1_rspbody = new cmd0x9c1$RspBody();
                    cmd0x9c1_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (cmd0x9c1_rspbody.uint64_uin.has()) {
                        str = String.valueOf(cmd0x9c1_rspbody.uint64_uin.get());
                    } else {
                        str = "";
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg RspUin " + str + " ReqUin " + string);
                    }
                    z18 = z17;
                } else if (QLog.isColorLevel()) {
                    QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  fail resultCode : " + oidb_sso_oidbssopkg.uint32_result.get());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg Exception " + e16.getMessage());
                }
            }
        } else {
            z18 = z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "rspFacetoFaceAddFriendUnreg  isSuccess " + z18);
        }
    }

    public void E2(int i3, int i16, int i17, String str, String str2, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, str2, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        if (i3 != 0 && i16 != 0 && i17 >= 0 && i17 <= 1 && i18 >= 0 && i19 >= 0 && i19 <= 100) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
            LBSShare$LocationReq lBSShare$LocationReq = new LBSShare$LocationReq();
            lBSShare$LocationReq.lat.set(i3);
            lBSShare$LocationReq.lng.set(i16);
            lBSShare$LocationReq.coordinate.set(i17);
            lBSShare$LocationReq.keyword.set(str);
            lBSShare$LocationReq.category.set(str2);
            lBSShare$LocationReq.page.set(i18);
            lBSShare$LocationReq.count.set(i19);
            lBSShare$LocationReq.requireMyLbs.set(i26);
            lBSShare$LocationReq.imei.set("");
            Bundle bundle = new Bundle();
            bundle.putInt("latitude", i3);
            bundle.putInt("longitude", i16);
            bundle.putInt("coordinate", i17);
            bundle.putString("keyword", str);
            bundle.putString("category", str2);
            bundle.putInt("page", i18);
            bundle.putInt("count", i19);
            bundle.putInt("requireMyLbs", i26);
            bundle.putString("imei", "");
            toServiceMsg.extraData.putBundle("req", bundle);
            toServiceMsg.putWupBuffer(lBSShare$LocationReq.toByteArray());
            sendPbReq(toServiceMsg);
        }
    }

    public void F2(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        if (i3 != 0 && i16 != 0 && i17 >= 0 && i17 <= 1) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.nearby_shops");
            LBSShare$NearByShopsReq lBSShare$NearByShopsReq = new LBSShare$NearByShopsReq();
            lBSShare$NearByShopsReq.lat.set(i3);
            lBSShare$NearByShopsReq.lng.set(i16);
            lBSShare$NearByShopsReq.coordinate.set(i17);
            lBSShare$NearByShopsReq.begin.set(i18);
            lBSShare$NearByShopsReq.limit.set(i19);
            lBSShare$NearByShopsReq.version.set(1);
            Bundle bundle = new Bundle();
            bundle.putInt("latitude", i3);
            bundle.putInt("longitude", i16);
            bundle.putInt("coordinate", i17);
            bundle.putInt("begin", i18);
            bundle.putInt("count", i19);
            toServiceMsg.extraData.putBundle("req", bundle);
            toServiceMsg.putWupBuffer(lBSShare$NearByShopsReq.toByteArray());
            sendPbReq(toServiceMsg);
        }
    }

    public void G2(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList == null) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.get_shops_by_ids");
        LBSShare$GetShopsByIdsReq lBSShare$GetShopsByIdsReq = new LBSShare$GetShopsByIdsReq();
        lBSShare$GetShopsByIdsReq.ids.set(arrayList);
        toServiceMsg.putWupBuffer(lBSShare$GetShopsByIdsReq.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void H2(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            bz.d(this, true, false, i3, i16);
        }
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            send(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqGetSwitches"));
        }
    }

    public void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            bz.d(this, false, true, 0, 0);
        }
    }

    public void K2(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        cmd0x7f5$GroupInfo cmd0x7f5_groupinfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fromServiceMsg, toServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops");
        }
        boolean z18 = false;
        if (obj != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    cmd0x7f5$RspBody cmd0x7f5_rspbody = new cmd0x7f5$RspBody();
                    cmd0x7f5_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    int i3 = cmd0x7f5_rspbody.uint32_recruit_number.get();
                    List<cmd0x7f5$GroupInfo> list = cmd0x7f5_rspbody.rpt_group_info.get();
                    if (list != null && list.size() > 0) {
                        cmd0x7f5_groupinfo = list.get(0);
                    } else {
                        cmd0x7f5_groupinfo = null;
                    }
                    notifyUI(28, z17, new Object[]{Integer.valueOf(i3), cmd0x7f5_groupinfo});
                    z18 = z17;
                } else if (QLog.isColorLevel()) {
                    QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  fail resultCode : " + oidb_sso_oidbssopkg.uint32_result.get());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops Exception " + e16.getMessage());
                }
            }
        } else {
            z18 = z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "handleGetNewNearbyTroops  isSuccess " + z18);
        }
    }

    public boolean O2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        cmd0x9c0$ReqBody cmd0x9c0_reqbody = new cmd0x9c0$ReqBody();
        cmd0x9c0_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        cmd0x9c0_reqbody.uint32_heartbeat.set(z16 ? 1 : 0);
        if (!z16) {
            appoint_define$LBSInfo appoint_define_lbsinfo = (appoint_define$LBSInfo) ((ILbsUtils) QRoute.api(ILbsUtils.class)).getLbsInfo(getClass().getSimpleName());
            if (appoint_define_lbsinfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LBSHandler", 2, "lbsInfo is null");
                }
                return false;
            }
            cmd0x9c0_reqbody.msg_lbs_info.set(appoint_define_lbsinfo);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2496);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x9c0_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x9c0_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
        return true;
    }

    public void P2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        cmd0x9c1$ReqBody cmd0x9c1_reqbody = new cmd0x9c1$ReqBody();
        cmd0x9c1_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2497);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x9c1_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x9c1_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putString("currentAccountUin", str);
        if (QLog.isColorLevel()) {
            QLog.d("LBSHandler", 2, "Face2FaceAddFriendActivity reqFacetoFaceAddFriendUnreg");
        }
        sendPbReq(createToServiceMsg);
    }

    public void S2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "NeighborSvc.ReqSetStateSwitch");
        toServiceMsg.extraData.putBoolean("k_be_share", z16);
        send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Set) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("NeighborSvc.ReqSetStateSwitch");
            this.allowCmdSet.add("NeighborSvc.ReqGetSwitches");
            this.allowCmdSet.add("NeighborSvc.ReqGetPoint");
            this.allowCmdSet.add("LbsShareSvr.location");
            this.allowCmdSet.add("LbsShareSvr.nearby_shops");
            this.allowCmdSet.add("LbsShareSvr.get_shops_by_ids");
            this.allowCmdSet.add("OidbSvc.0x9c0_0");
            this.allowCmdSet.add("OidbSvc.0x9c1_0");
            this.allowCmdSet.add("OidbSvc.0x7f5_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Class) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return bh.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 18;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("msgCmdFilter", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        BusinessHandlerUtil.checkReportErrorToMM(fromServiceMsg, getCurrentAccountUin());
        if ("NeighborSvc.ReqSetStateSwitch".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("NeighborSvc.ReqGetSwitches".equals(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("NeighborSvc.ReqGetPoint".equals(fromServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getBoolean("req_street_view")) {
                i3 = 11;
            }
            bz.e(this, i3, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("LbsShareSvr.location".equals(fromServiceMsg.getServiceCmd())) {
            if (obj != null) {
                notifyUI(15, true, new Object[]{toServiceMsg, obj});
                return;
            } else {
                notifyUI(15, false, null);
                return;
            }
        }
        if ("LbsShareSvr.nearby_shops".equals(fromServiceMsg.getServiceCmd())) {
            if (obj != null) {
                notifyUI(16, true, new Object[]{toServiceMsg, obj});
                return;
            } else {
                notifyUI(16, false, null);
                return;
            }
        }
        if ("LbsShareSvr.get_shops_by_ids".equals(fromServiceMsg.getServiceCmd())) {
            if (obj != null) {
                notifyUI(17, true, new Object[]{toServiceMsg, obj});
                return;
            } else {
                notifyUI(17, false, null);
                return;
            }
        }
        if ("OidbSvc.0x9c0_0".equals(fromServiceMsg.getServiceCmd())) {
            Q2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x9c1_0".equals(fromServiceMsg.getServiceCmd())) {
            R2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x7f5_1".equals(fromServiceMsg.getServiceCmd())) {
            K2(fromServiceMsg, toServiceMsg, obj);
        }
    }
}
