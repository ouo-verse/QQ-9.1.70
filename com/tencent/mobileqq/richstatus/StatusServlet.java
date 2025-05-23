package com.tencent.mobileqq.richstatus;

import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.Wifi;
import PersonalState.BusiReqHead;
import PersonalState.HotRishState;
import PersonalState.LBSInfo;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.RespGetHotState;
import PersonalState.RespGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.pb.signature.SigActPb$Platform;
import com.tencent.pb.signature.SigActPb$ReqBody;
import com.tencent.pb.signature.SigActPb$RspBody;
import com.tencent.pb.signature.SigActPb$SigauthReq;
import com.tencent.pb.signature.SigActPb$SigauthRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StatusServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class RspGetHistory implements Serializable {
        static IPatchRedirector $redirector_;
        public int endTime;
        public boolean isAddFromCard;
        public boolean over;
        public ArrayList<RichStatus> richStatus;
        public int startTime;

        public RspGetHistory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public StatusServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static LBSInfo a(QQAppInterface qQAppInterface) {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, StatusServlet.class.getSimpleName());
        NearbyGroup.LBSInfo rawLbsInfo = ((ILbsUtils) QRoute.api(ILbsUtils.class)).getRawLbsInfo();
        if (rawLbsInfo != null) {
            GPS gps = rawLbsInfo.stGps;
            PersonalState.GPS gps2 = new PersonalState.GPS(gps.iLat, gps.iLon, gps.iAlt, gps.eType);
            ArrayList arrayList = new ArrayList();
            Iterator<Wifi> it = rawLbsInfo.vWifis.iterator();
            while (it.hasNext()) {
                Wifi next = it.next();
                arrayList.add(new PersonalState.Wifi(next.lMac, next.shRssi));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Cell> it5 = rawLbsInfo.vCells.iterator();
            while (it5.hasNext()) {
                Cell next2 = it5.next();
                arrayList2.add(new PersonalState.Cell(next2.shMcc, next2.shMnc, next2.iLac, next2.iCellId, next2.shRssi));
            }
            return new LBSInfo(gps2, arrayList, arrayList2);
        }
        return null;
    }

    private byte[] b(List<byte[]> list, byte b16) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1359);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        int i3 = 7;
        for (byte[] bArr : list) {
            if (bArr != null) {
                i3 = i3 + 2 + bArr.length + 4;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.putInt(0);
        allocate.put(b16);
        allocate.putShort((short) list.size());
        for (byte[] bArr2 : list) {
            if (bArr2 != null) {
                allocate.putShort((short) bArr2.length);
                allocate.put(bArr2);
                allocate.putInt(0);
            }
        }
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    private byte[] c(byte[] bArr) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1295);
        oidb_sso_oidbssopkg.uint32_service_type.set(29);
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 2);
        allocate.put((byte) 0).put((byte) bArr.length).put(bArr);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    public static void e(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo");
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), StatusServlet.class);
        newIntent.putExtra("k_cmd", 1);
        newIntent.putExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, qQAppInterface.getCurrentAccountUin());
        qQAppInterface.startServlet(newIntent);
    }

    private void g(Bundle bundle, SigActPb$RspBody sigActPb$RspBody, String str) throws InvalidProtocolBufferMicroException {
        if (sigActPb$RspBody.auth_rsp.tips_info.has()) {
            SigActPb$SigauthRsp.TipsInfo tipsInfo = new SigActPb$SigauthRsp.TipsInfo();
            tipsInfo.mergeFrom(sigActPb$RspBody.auth_rsp.tips_info.get().toByteArray());
            boolean z16 = tipsInfo.valid.get();
            if (QLog.isColorLevel()) {
                QLog.d("Signature", 2, "CMD_RICH_STATUS_AUTH ret = " + tipsInfo.ret.get() + " valid = " + z16);
            }
            bundle.putBoolean("valid", z16);
            if (z16) {
                bundle.putInt("ret", tipsInfo.ret.get());
                bundle.putInt("type", tipsInfo.type.get());
                bundle.putString("titleWording", tipsInfo.title_wording.get());
                bundle.putString("wording", tipsInfo.wording.get());
                bundle.putString("rightBtnWording", tipsInfo.right_btn_wording.get());
                bundle.putString("leftBtnWording", tipsInfo.left_btn_wording.get());
                bundle.putString("vipType", tipsInfo.vip_type.get());
                bundle.putInt("vipMonth", tipsInfo.vip_month.get());
                bundle.putString("url", tipsInfo.url.get());
            }
            if (QLog.isColorLevel()) {
                QLog.i("StatusServlet", 2, "CMD_RICH_STATUS_AUTH parseSigAuthTipsInfo " + str + " data=" + bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(QQAppInterface qQAppInterface, boolean z16) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), StatusServlet.class);
        newIntent.putExtra("k_cmd", 2);
        newIntent.putExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, qQAppInterface.getCurrentAccountUin());
        newIntent.putExtra("k_sync_ss", z16);
        qQAppInterface.startServlet(newIntent);
    }

    byte[] d(long j3, int i3, int i16) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1343);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        ByteBuffer allocate = ByteBuffer.allocate(27);
        allocate.putLong(j3).put((byte) 2).putInt(i3).putInt(i16).putInt(0).putInt(0).putShort((short) 6);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    byte[] f(boolean z16, boolean z17, long j3) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1301);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        ByteBuffer allocate = ByteBuffer.allocate(11);
        allocate.put((byte) 2).putInt(293615363).put(z16 ? (byte) 1 : (byte) 0);
        allocate.put(z17 ? (byte) 1 : (byte) 0).putInt((int) j3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:197:0x04fb. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05d0 A[Catch: Exception -> 0x0601, TryCatch #20 {Exception -> 0x0601, blocks: (B:219:0x05d0, B:220:0x05d6, B:222:0x05df, B:243:0x05b0, B:245:0x05b6), top: B:242:0x05b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x05df A[Catch: Exception -> 0x0601, TRY_LEAVE, TryCatch #20 {Exception -> 0x0601, blocks: (B:219:0x05d0, B:220:0x05d6, B:222:0x05df, B:243:0x05b0, B:245:0x05b6), top: B:242:0x05b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0466  */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean z17;
        Card r16;
        RichStatus richStatus;
        ByteBuffer wrap;
        int i3;
        oidb_sso$OIDBSSOPkg mergeFrom;
        boolean z18;
        oidb_sso$OIDBSSOPkg mergeFrom2;
        int i16;
        String str;
        String str2;
        boolean z19;
        String str3;
        int i17;
        Bundle bundle;
        boolean z26;
        int i18;
        Card r17;
        RichStatus richStatus2;
        boolean z27;
        Bundle bundle2;
        boolean z28;
        byte b16;
        String str4;
        boolean z29;
        oidb_sso$OIDBSSOPkg mergeFrom3;
        oidb_sso$OIDBSSOPkg mergeFrom4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int intExtra = intent.getIntExtra("k_cmd", 0);
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle3 = new Bundle();
        StatusManager statusManager = (StatusManager) getAppRuntime().getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager == null) {
            if (intExtra == 7) {
                if (isSuccess) {
                    try {
                        mergeFrom4 = new oidb_sso$OIDBSSOPkg().mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e16.getMessage());
                        }
                    }
                    if (mergeFrom4 != null && mergeFrom4.uint32_result.has()) {
                        if (mergeFrom4.uint32_result.get() == 0) {
                            ByteBuffer wrap2 = ByteBuffer.wrap(mergeFrom4.bytes_bodybuffer.get().toByteArray());
                            if (wrap2.get() == 0) {
                                bundle3.putByteArray("k_rspbody", wrap2.array());
                                bundle3.putInt("k_source", intent.getIntExtra("k_source", 0));
                            } else {
                                VasMonitorDT.reportErrCode("indevidual_v2_signature_set_fail", "signature_set_cRet_fail");
                            }
                        }
                        isSuccess = false;
                    }
                } else {
                    fromServiceMsg.getBusinessFailMsg();
                    VasMonitorDT.reportErrCode("indevidual_v2_signature_set_fail", "signature_set_sso_fail");
                }
                boolean z36 = isSuccess;
                str = "k_rspbody";
                str2 = "k_sync_ss";
                notifyObserver(intent, intExtra, z36, bundle3, m.class);
                isSuccess = z36;
            } else {
                str = "k_rspbody";
                str2 = "k_sync_ss";
            }
            if (intExtra == 9) {
                if (isSuccess) {
                    try {
                        int length = fromServiceMsg.getWupBuffer().length - 4;
                        byte[] bArr = new byte[length];
                        PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                        SigActPb$RspBody sigActPb$RspBody = new SigActPb$RspBody();
                        sigActPb$RspBody.mergeFrom(bArr);
                        int i19 = sigActPb$RspBody.ret.get();
                        if (i19 == 0) {
                            ByteBuffer wrap3 = ByteBuffer.wrap(sigActPb$RspBody.auth_rsp.result.get().toByteArray());
                            int i26 = wrap3.get();
                            if (i26 == 0) {
                                bundle3.putByteArray(str, wrap3.array());
                                bundle3.putInt("k_source", intent.getIntExtra("k_source", 0));
                            } else {
                                bundle3.putInt("cRet", i26);
                            }
                        } else {
                            VasMonitorDT.reportAuthResult("individual_v2_signature_auth_fail", i19);
                            bundle3.putInt("k_auth_code", i19);
                            if (i19 == -210011) {
                                bundle3.putString("k_act_url", sigActPb$RspBody.auth_rsp.url.get());
                            }
                            if (sigActPb$RspBody.auth_rsp.authfailed_appid.has()) {
                                bundle3.putInt("authAppid", sigActPb$RspBody.auth_rsp.authfailed_appid.get());
                            }
                            if (sigActPb$RspBody.auth_rsp.tips_info.has()) {
                                SigActPb$SigauthRsp.TipsInfo tipsInfo = new SigActPb$SigauthRsp.TipsInfo();
                                tipsInfo.mergeFrom(sigActPb$RspBody.auth_rsp.tips_info.get().toByteArray());
                                boolean z37 = tipsInfo.valid.get();
                                bundle3.putBoolean("valid", z37);
                                if (z37) {
                                    bundle3.putInt("type", tipsInfo.type.get());
                                    bundle3.putString("titleWording", tipsInfo.title_wording.get());
                                    bundle3.putString("wording", tipsInfo.wording.get());
                                    bundle3.putString("rightBtnWording", tipsInfo.right_btn_wording.get());
                                    bundle3.putString("leftBtnWording", tipsInfo.left_btn_wording.get());
                                    bundle3.putString("vipType", tipsInfo.vip_type.get());
                                    bundle3.putInt("vipMonth", tipsInfo.vip_month.get());
                                    bundle3.putString("url", tipsInfo.url.get());
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("StatusServlet", 2, "CMD_RICH_STATUS_AUTH, data = " + bundle3);
                                }
                            }
                        }
                        isSuccess = false;
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e17.getMessage());
                        }
                        z19 = false;
                    }
                } else {
                    VasMonitorDT.reportAuthResult("individual_v2_signature_auth_fail", -1);
                }
                z19 = isSuccess;
                notifyObserver(intent, intExtra, z19, bundle3, m.class);
            } else {
                z19 = isSuccess;
            }
            if (intExtra == 4) {
                try {
                    RspGetHistory rspGetHistory = new RspGetHistory();
                    rspGetHistory.startTime = intent.getIntExtra("k_start_time", 0);
                    rspGetHistory.endTime = intent.getIntExtra("k_end_time", Integer.MAX_VALUE);
                    rspGetHistory.isAddFromCard = false;
                    bundle3.putSerializable("k_data", rspGetHistory);
                    ByteBuffer wrap4 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                    byte[] bArr2 = new byte[wrap4.getInt() - 4];
                    wrap4.get(bArr2);
                    ByteBuffer wrap5 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr2).bytes_bodybuffer.get().toByteArray());
                    wrap5.get();
                    long j3 = wrap5.getLong();
                    wrap5.get();
                    wrap5.getInt();
                    int i27 = wrap5.getInt();
                    wrap5.getInt();
                    boolean z38 = wrap5.get() != 0;
                    short s16 = wrap5.getShort();
                    rspGetHistory.richStatus = new ArrayList<>(s16);
                    QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                    int i28 = 0;
                    while (i28 < s16) {
                        boolean z39 = z19;
                        byte[] bArr3 = new byte[wrap5.getShort()];
                        wrap5.get(bArr3);
                        short s17 = s16;
                        byte[] bArr4 = new byte[wrap5.getShort()];
                        wrap5.get(bArr4);
                        wrap5.getInt();
                        str3 = str2;
                        try {
                            int i29 = wrap5.getInt();
                            wrap5.position(wrap5.position() + 8);
                            if (i29 > i27) {
                                i17 = intExtra;
                                bundle = bundle3;
                            } else {
                                RichStatus parseStatus = RichStatus.parseStatus(bArr4);
                                i17 = intExtra;
                                bundle = bundle3;
                                try {
                                    parseStatus.time = i29;
                                    parseStatus.key = bArr3;
                                    parseStatus.feedsId = new String(bArr3);
                                    rspGetHistory.richStatus.add(parseStatus);
                                } catch (Exception e18) {
                                    e = e18;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    z26 = false;
                                    notifyObserver(intent, i17, z26, bundle, m.class);
                                    i18 = i17;
                                    if (i18 == 8) {
                                    }
                                    if (i18 != 1) {
                                    }
                                    try {
                                        ByteBuffer wrap6 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                                        byte[] bArr5 = new byte[wrap6.getInt() - 4];
                                        wrap6.get(bArr5);
                                        ByteBuffer wrap7 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr5).bytes_bodybuffer.get().toByteArray());
                                        b16 = wrap7.get();
                                        wrap7.getInt();
                                        if (wrap7.get() == 1) {
                                        }
                                        if (b16 != 0) {
                                        }
                                        bundle2 = bundle;
                                    } catch (Exception e19) {
                                        e = e19;
                                    }
                                    try {
                                        bundle2.putBoolean(str4, z29);
                                        z28 = z27;
                                    } catch (Exception e26) {
                                        e = e26;
                                        e.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.w(LogTag.RICH_STATUS, 2, e.getMessage());
                                        }
                                        z28 = false;
                                        notifyObserver(intent, i18, z28, bundle2, m.class);
                                        return;
                                    }
                                    notifyObserver(intent, i18, z28, bundle2, m.class);
                                    return;
                                }
                            }
                            i28++;
                            z19 = z39;
                            s16 = s17;
                            str2 = str3;
                            intExtra = i17;
                            bundle3 = bundle;
                        } catch (Exception e27) {
                            e = e27;
                            i17 = intExtra;
                            bundle = bundle3;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.w(LogTag.RICH_STATUS, 2, e.getMessage());
                            }
                            z26 = false;
                            notifyObserver(intent, i17, z26, bundle, m.class);
                            i18 = i17;
                            if (i18 == 8) {
                            }
                            if (i18 != 1) {
                            }
                            ByteBuffer wrap62 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                            byte[] bArr52 = new byte[wrap62.getInt() - 4];
                            wrap62.get(bArr52);
                            ByteBuffer wrap72 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr52).bytes_bodybuffer.get().toByteArray());
                            b16 = wrap72.get();
                            wrap72.getInt();
                            if (wrap72.get() == 1) {
                            }
                            if (b16 != 0) {
                            }
                            bundle2 = bundle;
                            bundle2.putBoolean(str4, z29);
                            z28 = z27;
                            notifyObserver(intent, i18, z28, bundle2, m.class);
                            return;
                        }
                    }
                    z26 = z19;
                    str3 = str2;
                    i17 = intExtra;
                    bundle = bundle3;
                    if (rspGetHistory.richStatus.isEmpty() && rspGetHistory.startTime == 0 && rspGetHistory.endTime == Integer.MAX_VALUE && (r17 = ((FriendsManager) getAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).r(String.valueOf(j3))) != null && (richStatus2 = RichStatusUtils.INSTANCE.getRichStatus(r17)) != null && !richStatus2.isEmpty()) {
                        rspGetHistory.richStatus.add(richStatus2);
                        rspGetHistory.isAddFromCard = true;
                    }
                    SignatureHandler signatureHandler = (SignatureHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
                    Iterator<RichStatus> it = rspGetHistory.richStatus.iterator();
                    while (it.hasNext()) {
                        RichStatus next = it.next();
                        if (signatureHandler != null) {
                            signatureHandler.P2(String.valueOf(j3), next.feedsId, 255, true);
                        }
                    }
                    rspGetHistory.over = z38;
                    SignatureManager signatureManager = (SignatureManager) qQAppInterface.getManager(QQManagerFactory.SIGNATURE_MANAGER);
                    if (signatureManager != null && qQAppInterface.getCurrentAccountUin().equals(Long.toString(j3))) {
                        signatureManager.t(rspGetHistory.richStatus);
                    }
                } catch (Exception e28) {
                    e = e28;
                    str3 = str2;
                }
                notifyObserver(intent, i17, z26, bundle, m.class);
                i18 = i17;
            } else {
                z26 = z19;
                str3 = str2;
                bundle = bundle3;
                i18 = intExtra;
            }
            if (i18 == 8) {
                if (z26) {
                    try {
                        mergeFrom3 = new oidb_sso$OIDBSSOPkg().mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    } catch (InvalidProtocolBufferMicroException e29) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e29.getMessage());
                        }
                    }
                    if (mergeFrom3 != null && mergeFrom3.uint32_result.has()) {
                        if (mergeFrom3.uint32_result.get() == 0) {
                            if (ByteBuffer.wrap(mergeFrom3.bytes_bodybuffer.get().toByteArray()).get() == 0) {
                                z27 = true;
                                notifyObserver(intent, i18, z27, bundle, m.class);
                            }
                        }
                        z27 = false;
                        notifyObserver(intent, i18, z27, bundle, m.class);
                    }
                }
                z27 = z26;
                notifyObserver(intent, i18, z27, bundle, m.class);
            } else {
                z27 = z26;
            }
            if (i18 != 1 || i18 == 2) {
                ByteBuffer wrap622 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr522 = new byte[wrap622.getInt() - 4];
                wrap622.get(bArr522);
                ByteBuffer wrap722 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr522).bytes_bodybuffer.get().toByteArray());
                b16 = wrap722.get();
                wrap722.getInt();
                boolean z46 = wrap722.get() == 1;
                if (b16 != 0) {
                    z29 = z46;
                    str4 = str3;
                    z27 = false;
                } else {
                    str4 = str3;
                    if (i18 == 2) {
                        try {
                            z46 = intent.getBooleanExtra(str4, false);
                        } catch (Exception e36) {
                            e = e36;
                            bundle2 = bundle;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            z28 = false;
                            notifyObserver(intent, i18, z28, bundle2, m.class);
                            return;
                        }
                    }
                    z29 = z46;
                }
                bundle2 = bundle;
                bundle2.putBoolean(str4, z29);
                z28 = z27;
                notifyObserver(intent, i18, z28, bundle2, m.class);
                return;
            }
            return;
        }
        switch (intExtra) {
            case 1:
            case 2:
                z16 = isSuccess;
                try {
                    ByteBuffer wrap8 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                    byte[] bArr6 = new byte[wrap8.getInt() - 4];
                    wrap8.get(bArr6);
                    ByteBuffer wrap9 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr6).bytes_bodybuffer.get().toByteArray());
                    byte b17 = wrap9.get();
                    wrap9.getInt();
                    boolean z47 = wrap9.get() == 1;
                    if (b17 != 0) {
                        isSuccess = false;
                        z16 = false;
                    } else if (intExtra == 2) {
                        isSuccess = false;
                        try {
                            z47 = intent.getBooleanExtra("k_sync_ss", false);
                        } catch (Exception e37) {
                            e = e37;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.w(LogTag.RICH_STATUS, 2, e.getMessage());
                            }
                            z18 = isSuccess;
                            notifyObserver(intent, intExtra, z18, bundle3, m.class);
                        }
                    } else {
                        isSuccess = false;
                    }
                    bundle3.putBoolean("k_sync_ss", z47);
                    z18 = z16;
                } catch (Exception e38) {
                    e = e38;
                    isSuccess = false;
                }
            case 3:
                try {
                    bundle3.putBoolean("k_is_first", intent.getBooleanExtra("k_is_first", true));
                    bundle3.putInt("k_fetch_sex", intent.getIntExtra("k_fetch_sex", -1));
                    UniPacket uniPacket = new UniPacket(true);
                    uniPacket.setEncodeName("utf-8");
                    uniPacket.decode(fromServiceMsg.getWupBuffer());
                    RespGetSameStateList respGetSameStateList = (RespGetSameStateList) uniPacket.getByClass("RespGetSameStateList", new RespGetSameStateList());
                    if (respGetSameStateList.oHead.iReplyCode == 0) {
                        bundle3.putSerializable("k_resp_mate", respGetSameStateList);
                        z17 = isSuccess;
                        z18 = z17;
                        break;
                    }
                    z17 = false;
                    z18 = z17;
                } catch (Exception unused) {
                    break;
                }
            case 4:
                try {
                    RspGetHistory rspGetHistory2 = new RspGetHistory();
                    rspGetHistory2.startTime = intent.getIntExtra("k_start_time", 0);
                    rspGetHistory2.endTime = intent.getIntExtra("k_end_time", Integer.MAX_VALUE);
                    rspGetHistory2.isAddFromCard = false;
                    bundle3.putSerializable("k_data", rspGetHistory2);
                    ByteBuffer wrap10 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                    byte[] bArr7 = new byte[wrap10.getInt() - 4];
                    wrap10.get(bArr7);
                    ByteBuffer wrap11 = ByteBuffer.wrap(new oidb_sso$OIDBSSOPkg().mergeFrom(bArr7).bytes_bodybuffer.get().toByteArray());
                    wrap11.get();
                    long j16 = wrap11.getLong();
                    wrap11.get();
                    wrap11.getInt();
                    int i36 = wrap11.getInt();
                    wrap11.getInt();
                    boolean z48 = wrap11.get() != 0;
                    short s18 = wrap11.getShort();
                    rspGetHistory2.richStatus = new ArrayList<>(s18);
                    QQAppInterface qQAppInterface2 = (QQAppInterface) getAppRuntime();
                    int i37 = 0;
                    while (i37 < s18) {
                        byte[] bArr8 = new byte[wrap11.getShort()];
                        wrap11.get(bArr8);
                        boolean z49 = isSuccess;
                        byte[] bArr9 = new byte[wrap11.getShort()];
                        wrap11.get(bArr9);
                        wrap11.getInt();
                        short s19 = s18;
                        int i38 = wrap11.getInt();
                        wrap11.position(wrap11.position() + 8);
                        if (i38 <= i36) {
                            RichStatus parseStatus2 = RichStatus.parseStatus(bArr9);
                            parseStatus2.time = i38;
                            parseStatus2.key = bArr8;
                            parseStatus2.feedsId = new String(bArr8);
                            rspGetHistory2.richStatus.add(parseStatus2);
                        }
                        i37++;
                        s18 = s19;
                        isSuccess = z49;
                    }
                    z16 = isSuccess;
                    if (rspGetHistory2.richStatus.isEmpty() && rspGetHistory2.startTime == 0 && rspGetHistory2.endTime == Integer.MAX_VALUE && (r16 = ((FriendsManager) getAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).r(String.valueOf(j16))) != null && (richStatus = RichStatusUtils.INSTANCE.getRichStatus(r16)) != null && !richStatus.isEmpty()) {
                        rspGetHistory2.richStatus.add(richStatus);
                        rspGetHistory2.isAddFromCard = true;
                    }
                    SignatureHandler signatureHandler2 = (SignatureHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
                    Iterator<RichStatus> it5 = rspGetHistory2.richStatus.iterator();
                    while (it5.hasNext()) {
                        RichStatus next2 = it5.next();
                        if (signatureHandler2 != null) {
                            signatureHandler2.P2(String.valueOf(j16), next2.feedsId, 255, true);
                        }
                    }
                    rspGetHistory2.over = z48;
                    SignatureManager signatureManager2 = (SignatureManager) qQAppInterface2.getManager(QQManagerFactory.SIGNATURE_MANAGER);
                    if (signatureManager2 != null && qQAppInterface2.getCurrentAccountUin().equals(Long.toString(j16))) {
                        signatureManager2.t(rspGetHistory2.richStatus);
                    }
                    z18 = z16;
                    break;
                } catch (Exception e39) {
                    e39.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.w(LogTag.RICH_STATUS, 2, e39.getMessage());
                        break;
                    }
                }
                break;
            case 5:
                if (isSuccess) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    try {
                        oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    } catch (InvalidProtocolBufferMicroException e46) {
                        e46.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e46.getMessage());
                        }
                        isSuccess = false;
                    }
                    if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                        int i39 = oidb_sso_oidbssopkg.uint32_result.get();
                        if (i39 == 0) {
                            try {
                                wrap = ByteBuffer.wrap(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                                i3 = wrap.get();
                            } catch (Exception e47) {
                                if (QLog.isColorLevel()) {
                                    QLog.w(LogTag.RICH_STATUS, 2, "onreceive.exception:" + e47.getMessage());
                                }
                                bundle3.putInt("k_error_code", -1002);
                            }
                            if (i3 == 0) {
                                short s26 = wrap.getShort();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i46 = 0; i46 < s26; i46++) {
                                    byte[] bArr10 = new byte[wrap.getShort()];
                                    wrap.get(bArr10);
                                    arrayList.add(new String(bArr10));
                                }
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                ArrayList<Integer> arrayList3 = new ArrayList<>();
                                short s27 = wrap.getShort();
                                for (int i47 = 0; i47 < s27; i47++) {
                                    byte[] bArr11 = new byte[wrap.getShort()];
                                    wrap.get(bArr11);
                                    arrayList2.add(new String(bArr11));
                                    arrayList3.add(Integer.valueOf(wrap.getInt()));
                                }
                                if (s26 > 0) {
                                    bundle3.putStringArrayList("k_status_key", arrayList);
                                    z17 = isSuccess;
                                    z18 = z17;
                                    break;
                                } else {
                                    bundle3.putStringArrayList("k_status_key", arrayList2);
                                    bundle3.putIntegerArrayList("k_status_err_code_list", arrayList3);
                                }
                            } else {
                                bundle3.putInt("k_error_code", i3);
                            }
                        } else {
                            bundle3.putInt("k_error_code", i39);
                        }
                    } else {
                        bundle3.putInt("k_error_code", -1001);
                    }
                    z17 = false;
                    z18 = z17;
                }
                z16 = isSuccess;
                z18 = z16;
                break;
            case 6:
                UniPacket uniPacket2 = new UniPacket(true);
                uniPacket2.setEncodeName("utf-8");
                uniPacket2.decode(fromServiceMsg.getWupBuffer());
                RespGetHotState respGetHotState = (RespGetHotState) uniPacket2.getByClass("RespGetHotState", new RespGetHotState());
                if (respGetHotState.oHead.iReplyCode == 0) {
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder("StatusServlet.onReceive(), decode sucess, ");
                        sb5.append(" resp.vHostRichSateList.size == ");
                        ArrayList<HotRishState> arrayList4 = respGetHotState.vHostRichSateList;
                        sb5.append(arrayList4 == null ? "-1" : Integer.valueOf(arrayList4.size()));
                        sb5.append(" ,hot state: ");
                        ArrayList<HotRishState> arrayList5 = respGetHotState.vHostRichSateList;
                        if (arrayList5 != null && arrayList5.size() > 0) {
                            Iterator<HotRishState> it6 = respGetHotState.vHostRichSateList.iterator();
                            while (it6.hasNext()) {
                                HotRishState next3 = it6.next();
                                sb5.append(" ");
                                sb5.append(next3.iActId);
                                sb5.append(":");
                                sb5.append(next3.iDataId);
                            }
                        }
                        QLog.d(LogTag.TAG_GET_HOT_RICH_STATUS, 2, sb5.toString());
                    }
                    ArrayList arrayList6 = new ArrayList(6);
                    ArrayList<HotRishState> arrayList7 = respGetHotState.vHostRichSateList;
                    if (arrayList7 != null && arrayList7.size() > 0) {
                        RichStatus Q = statusManager.Q();
                        for (int size = respGetHotState.vHostRichSateList.size() - 1; size >= 0; size--) {
                            HotRishState hotRishState = respGetHotState.vHostRichSateList.get(size);
                            if (hotRishState.iActId == Q.actionId && hotRishState.iDataId == Q.dataId) {
                                respGetHotState.vHostRichSateList.remove(size);
                            }
                        }
                        for (int i48 = 0; i48 < 6; i48++) {
                            arrayList6.add(respGetHotState.vHostRichSateList.get(i48));
                        }
                        StringBuilder sb6 = new StringBuilder();
                        Iterator it7 = arrayList6.iterator();
                        while (it7.hasNext()) {
                            HotRishState hotRishState2 = (HotRishState) it7.next();
                            sb6.append(hotRishState2.iActId);
                            sb6.append(":");
                            sb6.append(hotRishState2.iDataId);
                            sb6.append(";");
                        }
                        statusManager.f0(sb6.toString());
                    }
                    bundle3.putSerializable("k_resp_hot_status", arrayList6);
                    z16 = isSuccess;
                    z18 = z16;
                    break;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_GET_HOT_RICH_STATUS, 2, "StatusServlet.onReceive(), decode fail");
                    }
                    z18 = false;
                    break;
                }
                break;
            case 7:
                if (isSuccess) {
                    try {
                        mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    } catch (InvalidProtocolBufferMicroException e48) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e48.getMessage());
                        }
                    }
                    if (mergeFrom != null && mergeFrom.uint32_result.has()) {
                        if (mergeFrom.uint32_result.get() == 0) {
                            ByteBuffer wrap12 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                            if (wrap12.get() == 0) {
                                bundle3.putByteArray("k_rspbody", wrap12.array());
                                bundle3.putInt("k_source", intent.getIntExtra("k_source", 0));
                            }
                        }
                        z17 = false;
                        z18 = z17;
                        break;
                    }
                    z17 = isSuccess;
                    z18 = z17;
                }
                z16 = isSuccess;
                z18 = z16;
                break;
            case 8:
                if (isSuccess) {
                    try {
                        mergeFrom2 = new oidb_sso$OIDBSSOPkg().mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    } catch (InvalidProtocolBufferMicroException e49) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e49.getMessage());
                        }
                    }
                    if (mergeFrom2 != null && mergeFrom2.uint32_result.has()) {
                        if (mergeFrom2.uint32_result.get() == 0) {
                            if (ByteBuffer.wrap(mergeFrom2.bytes_bodybuffer.get().toByteArray()).get() == 0) {
                                z17 = true;
                                z18 = z17;
                                break;
                            }
                        }
                        z17 = false;
                        z18 = z17;
                    }
                    z17 = isSuccess;
                    z18 = z17;
                }
                z16 = isSuccess;
                z18 = z16;
                break;
            case 9:
                if (isSuccess) {
                    try {
                        int intExtra2 = intent.getIntExtra("k_source", 0);
                        int length2 = fromServiceMsg.getWupBuffer().length - 4;
                        byte[] bArr12 = new byte[length2];
                        PkgTools.copyData(bArr12, 0, fromServiceMsg.getWupBuffer(), 4, length2);
                        SigActPb$RspBody sigActPb$RspBody2 = new SigActPb$RspBody();
                        sigActPb$RspBody2.mergeFrom(bArr12);
                        int i49 = sigActPb$RspBody2.ret.get();
                        String str5 = sigActPb$RspBody2.desc.has() ? sigActPb$RspBody2.desc.get() : "";
                        try {
                        } catch (Exception e56) {
                            e = e56;
                        }
                        if (i49 == 0) {
                            try {
                                ByteBuffer wrap13 = ByteBuffer.wrap(sigActPb$RspBody2.auth_rsp.result.get().toByteArray());
                                int i56 = wrap13.get();
                                if (i56 == 0) {
                                    bundle3.putByteArray("k_rspbody", wrap13.array());
                                    i16 = 1;
                                } else {
                                    bundle3.putInt("cRet", i56);
                                    i16 = 1;
                                    isSuccess = false;
                                }
                                if (intExtra2 == i16) {
                                    g(bundle3, sigActPb$RspBody2, "ret==0");
                                }
                            } catch (Exception e57) {
                                e = e57;
                                try {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e.getMessage());
                                    }
                                    isSuccess = false;
                                    if (str5 != null) {
                                    }
                                    bundle3.putInt("k_source", intExtra2);
                                    if (QLog.isDevelopLevel()) {
                                    }
                                    z18 = isSuccess;
                                } catch (Exception e58) {
                                    e = e58;
                                    if (QLog.isColorLevel()) {
                                        QLog.d(LogTag.RICH_STATUS, 2, "onreceive." + e.getMessage());
                                    }
                                    z18 = false;
                                    notifyObserver(intent, intExtra, z18, bundle3, m.class);
                                }
                                notifyObserver(intent, intExtra, z18, bundle3, m.class);
                            }
                            if (str5 != null) {
                                bundle3.putString("errorDesc", str5);
                            }
                            bundle3.putInt("k_source", intExtra2);
                            if (QLog.isDevelopLevel()) {
                                QLog.i("StatusServlet", 1, String.format("CMD_RICH_STATUS_AUTH [%b,%d] errDesc=[%s]", Boolean.valueOf(isSuccess), Integer.valueOf(intExtra2), str5));
                            }
                            z18 = isSuccess;
                        } else {
                            bundle3.putInt("k_auth_code", i49);
                            if (i49 == -210011) {
                                bundle3.putString("k_act_url", sigActPb$RspBody2.auth_rsp.url.get());
                            }
                            if (sigActPb$RspBody2.auth_rsp.authfailed_appid.has()) {
                                bundle3.putInt("authAppid", sigActPb$RspBody2.auth_rsp.authfailed_appid.get());
                            }
                            g(bundle3, sigActPb$RspBody2, "ret!=0 ");
                            isSuccess = false;
                            if (str5 != null) {
                            }
                            bundle3.putInt("k_source", intExtra2);
                            if (QLog.isDevelopLevel()) {
                            }
                            z18 = isSuccess;
                        }
                    } catch (Exception e59) {
                        e = e59;
                    }
                } else {
                    z16 = isSuccess;
                    z18 = z16;
                }
            default:
                z16 = isSuccess;
                z18 = z16;
                break;
        }
        notifyObserver(intent, intExtra, z18, bundle3, m.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        AppInterface appInterface = (AppInterface) getAppRuntime();
        int intExtra = intent.getIntExtra("k_cmd", 0);
        String str = null;
        boolean z16 = true;
        switch (intExtra) {
            case 2:
                packet.setTimeout(10000L);
            case 1:
                String stringExtra = intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN);
                if (intExtra != 2) {
                    z16 = false;
                }
                packet.putSendData(f(z16, intent.getBooleanExtra("k_sync_ss", false), Long.parseLong(stringExtra)));
                str = "OidbSvc.0x515_2";
                break;
            case 3:
                ReqGetSameStateList reqGetSameStateList = new ReqGetSameStateList();
                reqGetSameStateList.oHead = new BusiReqHead();
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_cookie");
                reqGetSameStateList.vCookie = byteArrayExtra;
                if (byteArrayExtra == null) {
                    i3 = 0;
                    reqGetSameStateList.vCookie = new byte[0];
                } else {
                    i3 = 0;
                }
                RichStatus richStatus = new RichStatus("");
                richStatus.actionText = "foo";
                richStatus.actionId = intent.getIntExtra("k_action", i3);
                richStatus.dataText = "foo";
                richStatus.dataId = intent.getIntExtra("k_data", i3);
                reqGetSameStateList.oSelfRishState = new stRishState(richStatus.encode(), 0L);
                Card r16 = ((FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(appInterface.getCurrentAccountUin());
                if (r16 != null) {
                    short s16 = r16.shGender;
                    if (s16 == 0) {
                        i16 = 0;
                    } else if (s16 == 1) {
                        i16 = 1;
                    }
                }
                reqGetSameStateList.eSelfSex = i16;
                reqGetSameStateList.iPageSize = 50;
                reqGetSameStateList.oLbsInfo = a(null);
                reqGetSameStateList.eFetchSex = intent.getIntExtra("k_fetch_sex", -1);
                String stringExtra2 = intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    try {
                        reqGetSameStateList.lFriendUin = Long.parseLong(stringExtra2);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                packet.setServantName("PersonalStateSvc");
                packet.setFuncName("ReqGetSameStateList");
                packet.addRequestPacket("ReqGetSameStateList", reqGetSameStateList);
                str = "PersonalStateSvc.ReqGetSameStateList";
                break;
            case 4:
                packet.putSendData(d(Long.parseLong(intent.getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN)), Integer.valueOf(intent.getIntExtra("k_start_time", 0)).intValue(), Integer.valueOf(intent.getIntExtra("k_end_time", Integer.MAX_VALUE)).intValue()));
                str = "OidbSvc.0x53f_2";
                break;
            case 5:
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("k_status_key");
                ArrayList arrayList = new ArrayList();
                if (stringArrayListExtra != null) {
                    Iterator<String> it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getBytes());
                    }
                }
                packet.putSendData(b(arrayList, (byte) intent.getIntExtra("k_status_flag", 1)));
                str = "OidbSvc.0x54f_0";
                break;
            case 6:
                ReqGetHotState reqGetHotState = new ReqGetHotState();
                reqGetHotState.oHead = new BusiReqHead();
                packet.setServantName("PersonalStateSvc");
                packet.setFuncName("ReqGetHotState");
                packet.addRequestPacket("ReqGetHotState", reqGetHotState);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_GET_HOT_RICH_STATUS, 2, "StatusServlet.onSend()");
                }
                str = "PersonalStateSvc.ReqGetHotState";
                break;
            case 7:
                packet.putSendData(c(intent.getByteArrayExtra("k_data")));
                str = "OidbSvc.0x50f_29";
                break;
            case 8:
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(1296);
                oidb_sso_oidbssopkg.uint32_service_type.set(0);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.EMPTY);
                byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
                allocate.putInt(byteArray.length + 4);
                allocate.put(byteArray);
                packet.putSendData(allocate.array());
                if (QLog.isColorLevel()) {
                    QLog.d("StatusServlet", 2, "clearRichStatus...");
                }
                str = "OidbSvc.0x510_0";
                break;
            case 9:
                int intExtra2 = intent.getIntExtra("k_tpl_id", 0);
                int intExtra3 = intent.getIntExtra("k_font_id", 0);
                int intExtra4 = intent.getIntExtra("k_sign_len", 2);
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("k_sign_data");
                int intExtra5 = intent.getIntExtra("k_source", 0);
                SigActPb$Platform sigActPb$Platform = new SigActPb$Platform();
                sigActPb$Platform.platform.set(109L);
                sigActPb$Platform.mqqver.set(AppSetting.f99551k);
                sigActPb$Platform.osver.set(ah.t());
                SigActPb$SigauthReq sigActPb$SigauthReq = new SigActPb$SigauthReq();
                sigActPb$SigauthReq.uin_disable.set(Long.parseLong(appInterface.getCurrentAccountUin()));
                sigActPb$SigauthReq.itemid.set(intExtra2);
                sigActPb$SigauthReq.fontid.set(intExtra3);
                sigActPb$SigauthReq.data.set(ByteStringMicro.copyFrom(byteArrayExtra2));
                sigActPb$SigauthReq.len.set(intExtra4);
                SigActPb$ReqBody sigActPb$ReqBody = new SigActPb$ReqBody();
                sigActPb$ReqBody.cmd.set(2);
                sigActPb$ReqBody.plf.set(sigActPb$Platform);
                sigActPb$ReqBody.auth_req.set(sigActPb$SigauthReq);
                sigActPb$ReqBody.seq.set(System.currentTimeMillis());
                sigActPb$ReqBody.source.set(intExtra5);
                byte[] byteArray2 = sigActPb$ReqBody.toByteArray();
                byte[] bArr = new byte[byteArray2.length + 4];
                PkgTools.dWord2Byte(bArr, 0, byteArray2.length + 4);
                PkgTools.copyData(bArr, 4, byteArray2, byteArray2.length);
                packet.putSendData(bArr);
                str = "Signature.auth";
                if (QLog.isColorLevel()) {
                    QLog.d("StatusServlet", 2, "Signature.auth");
                    break;
                }
                break;
        }
        if (str != null) {
            packet.setSSOCommand(str);
        }
    }
}
