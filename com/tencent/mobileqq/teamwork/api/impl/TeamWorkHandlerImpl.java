package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bh;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.teamwork.TimDocSSOMsg$GetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg$GetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg$LoginInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg$SetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg$SetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbab.cmd0xbab$GroupGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab$GroupGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab$GroupSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab$ReqBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab$RspBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab$UserGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab$UserGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab$UserInfo;
import tencent.im.oidb.cmd0xbab.cmd0xbab$UserSetReq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkHandlerImpl extends BusinessHandler implements ITeamWorkHandler {
    private static final int UIN_TYPE_DOC_UID = 1;
    private static final int UIN_TYPE_FRIEND = 0;
    private static final int UIN_TYPE_GROUP = 3;
    private static final int UIN_TYPE_QUN = 2;
    private AppInterface app;
    private boolean enableTencentDocsAssistant;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReSendCmd f291710a;

        a(ReSendCmd reSendCmd) {
            this.f291710a = reSendCmd;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.i(ITeamWorkHandler.TAG, 1, "--- pskey async failed ---  " + str + ", domain: " + ITeamWorkHandler.DOCS_DOMAIN);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            if (QLog.isColorLevel()) {
                QLog.i(ITeamWorkHandler.TAG, 2, "--- pskey async done ---  ");
            }
            if (!TextUtils.isEmpty(map.get(ITeamWorkHandler.DOCS_DOMAIN))) {
                TeamWorkHandlerImpl.this.reTrySendCmd(this.f291710a);
            } else {
                QLog.i(ITeamWorkHandler.TAG, 1, "pskey async is empty, domain: docs.qq.com");
            }
        }
    }

    public TeamWorkHandlerImpl(AppInterface appInterface) {
        super(appInterface);
        this.enableTencentDocsAssistant = false;
        this.app = appInterface;
        this.enableTencentDocsAssistant = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getCommonConfigBooleanValue(appInterface.getApp(), appInterface.getCurrentUin(), AppConstants.Preferences.TENCENT_DOCS_CONFIG_ENABLE_ASSISTANT, false);
    }

    public static String getClassName() {
        return TeamWorkHandlerImpl.class.getName();
    }

    private void getPskeyFromServerAndRetry(ReSendCmd reSendCmd) {
        ((IPskeyManager) this.app.getRuntimeService(IPskeyManager.class, "")).replacePskey(new String[]{ITeamWorkHandler.DOCS_DOMAIN}, new a(reSendCmd));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0156 A[Catch: Exception -> 0x016b, TRY_LEAVE, TryCatch #0 {Exception -> 0x016b, blocks: (B:3:0x0007, B:5:0x002f, B:7:0x00f7, B:12:0x0108, B:13:0x0122, B:15:0x0156, B:20:0x010f, B:22:0x011d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGetGroupAuthDocsGrayTips(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        boolean z16;
        try {
            DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) toServiceMsg.getAttribute("data");
            long longValue = ((Long) toServiceMsg.getAttribute("seq")).longValue();
            cmd0xbab$RspBody cmd0xbab_rspbody = new cmd0xbab$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xbab_rspbody);
            if (parseOIDBPkg == 0) {
                cmd0xbab$GroupGetRsp cmd0xbab_groupgetrsp = cmd0xbab_rspbody.group_get_rsp.get();
                int i16 = cmd0xbab_groupgetrsp.policy.get();
                List<cmd0xbab$UserInfo> list = cmd0xbab_groupgetrsp.user_list.get();
                int i17 = cmd0xbab_groupgetrsp.total_members.get();
                int i18 = cmd0xbab_groupgetrsp.privilege_members.get();
                int i19 = cmd0xbab_groupgetrsp.privilege_flag.get();
                int i26 = cmd0xbab_groupgetrsp.member_number.get();
                int i27 = cmd0xbab_groupgetrsp.exp_remain_time.get();
                int i28 = cmd0xbab_groupgetrsp.exp_set_time.get();
                String str2 = ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j;
                StringBuilder sb5 = new StringBuilder();
                i3 = parseOIDBPkg;
                sb5.append(" handleGetGroupAuthDocsGrayTips  | policy = ");
                sb5.append(i16);
                sb5.append(" userInfoList.size() = ");
                sb5.append(list.size());
                sb5.append(" totalMembers = ");
                sb5.append(i17);
                sb5.append(" privilegeMembers = ");
                sb5.append(i18);
                sb5.append(" privilege = ");
                sb5.append(i19);
                sb5.append(" memberNum = ");
                sb5.append(i26);
                sb5.append(" remainTime = ");
                sb5.append(i27);
                sb5.append(" setTime = ");
                sb5.append(i28);
                sb5.append(" docsGrayTipsInfo.policy = ");
                sb5.append(docsGrayTipsInfo.I);
                sb5.append(" docsGrayTipsInfo.privilege = ");
                sb5.append(docsGrayTipsInfo.J);
                QLog.i(str2, 1, sb5.toString());
                if (Integer.valueOf(docsGrayTipsInfo.J).intValue() == i19 && Integer.valueOf(docsGrayTipsInfo.I).intValue() == i16) {
                    if (i28 != 0 && i27 == 0) {
                        i28 = 0;
                    }
                    setGroupAuthDocsGrayTips(docsGrayTipsInfo, i28, longValue);
                    str = "";
                    z16 = true;
                    QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleGetGroupAuthDocsGrayTips. result = " + i3 + ", isSuccess = " + z16);
                    if (z16) {
                        notifyUI(10, z16, new Object[]{docsGrayTipsInfo, str, Long.valueOf(longValue)});
                        return;
                    }
                    return;
                }
                str = this.app.getApp().getString(R.string.hyn);
            } else {
                i3 = parseOIDBPkg;
                str = docsGrayTipsInfo.G;
            }
            z16 = false;
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleGetGroupAuthDocsGrayTips. result = " + i3 + ", isSuccess = " + z16);
            if (z16) {
            }
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleGetGroupAuthDocsGrayTips exception = " + e16.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00d5 A[Catch: Exception -> 0x0116, TryCatch #0 {Exception -> 0x0116, blocks: (B:3:0x0007, B:5:0x0030, B:7:0x00ac, B:12:0x00bd, B:14:0x00d5, B:15:0x00e9, B:17:0x00ef, B:22:0x00c2, B:24:0x00d0), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ef A[Catch: Exception -> 0x0116, TRY_LEAVE, TryCatch #0 {Exception -> 0x0116, blocks: (B:3:0x0007, B:5:0x0030, B:7:0x00ac, B:12:0x00bd, B:14:0x00d5, B:15:0x00e9, B:17:0x00ef, B:22:0x00c2, B:24:0x00d0), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGetUserAuthDocsGrayTips(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        try {
            DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) toServiceMsg.getAttribute("data");
            long longValue = ((Long) toServiceMsg.getAttribute("seq")).longValue();
            cmd0xbab$RspBody cmd0xbab_rspbody = new cmd0xbab$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xbab_rspbody);
            String str = "";
            if (parseOIDBPkg == 0) {
                cmd0xbab$UserGetRsp cmd0xbab_usergetrsp = cmd0xbab_rspbody.user_get_rsp.get();
                int i3 = cmd0xbab_usergetrsp.policy.get();
                int i16 = cmd0xbab_usergetrsp.privilege_flag.get();
                int i17 = cmd0xbab_usergetrsp.member_number.get();
                int i18 = cmd0xbab_usergetrsp.exp_remain_time.get();
                int i19 = cmd0xbab_usergetrsp.exp_set_time.get();
                QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, " handleGetUserAuthDocsGrayTips  | policy=" + i3 + " privilege =" + i16 + " memberNum = " + i17 + " remainTime = " + i18 + " setTime= " + i19);
                if (Integer.valueOf(docsGrayTipsInfo.J).intValue() == i16 && Integer.valueOf(docsGrayTipsInfo.I).intValue() == i3) {
                    if (i19 != 0 && i18 == 0) {
                        i19 = 0;
                    }
                    setUserAuthDocsGrayTips(docsGrayTipsInfo, i19, longValue);
                    z16 = true;
                    if (!z16) {
                        notifyUI(8, z16, new Object[]{docsGrayTipsInfo, str, Long.valueOf(longValue)});
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, " handleGetUserAuthDocsGrayTips ,result: " + parseOIDBPkg);
                        return;
                    }
                    return;
                }
                str = this.app.getApp().getString(R.string.hyn);
            } else {
                str = docsGrayTipsInfo.G;
            }
            z16 = false;
            if (!z16) {
            }
            if (!QLog.isColorLevel()) {
            }
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleGetUserAuthDocsGrayTips exception = " + e16.toString());
        }
    }

    private boolean handleResponseTry(ReSendCmd reSendCmd) {
        if (reSendCmd != null) {
            SparseIntArray sparseIntArray = ITeamWorkHandler.responseReTryCount;
            int i3 = sparseIntArray.get(reSendCmd.f291501d, 0);
            QLog.i(ITeamWorkHandler.TAG, 1, " handleResponseTry retry cmd\uff1a" + reSendCmd.f291501d + ", retryCount: " + i3);
            if (i3 < 3) {
                sparseIntArray.put(reSendCmd.f291501d, i3 + 1);
                getPskeyFromServerAndRetry(reSendCmd);
                return true;
            }
        }
        return false;
    }

    private void handleSetGroupAuthDocsGrayTips(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        try {
            DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) toServiceMsg.getAttribute("data");
            long longValue = ((Long) toServiceMsg.getAttribute("seq")).longValue();
            cmd0xbab$RspBody cmd0xbab_rspbody = new cmd0xbab$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xbab_rspbody);
            if (parseOIDBPkg == 0) {
                cmd0xbab_rspbody.group_set_rsp.get();
                str = docsGrayTipsInfo.F;
                if ("1".equals(docsGrayTipsInfo.f291467h)) {
                    ReportController.o(null, "CliOper", "", "", "0X8009550", "0X8009550", 1, 0, "", "", "", "");
                } else if ("2".equals(docsGrayTipsInfo.f291467h)) {
                    ReportController.o(null, "CliOper", "", "", "0X8009552", "0X8009552", 1, 0, "", "", "", "");
                }
                z16 = true;
            } else {
                str = docsGrayTipsInfo.G;
                z16 = false;
            }
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleSetGroupAuthDocsGrayTips. result = " + parseOIDBPkg);
            try {
                notifyUI(11, z16, new Object[]{docsGrayTipsInfo, str, Long.valueOf(longValue)});
            } catch (Exception e16) {
                e = e16;
                QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleSetGroupAuthDocsGrayTips  exception = " + e.toString());
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void handleSetPadRightsInfo(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean isSuccess = fromServiceMsg.isSuccess();
        int intValue = ((Integer) toServiceMsg.getAttribute(ITeamWorkHandler.KEY_TYPE_LIST)).intValue();
        if (QLog.isColorLevel()) {
            QLog.i(ITeamWorkHandler.TAG, 2, " handleSetPadRightsInfo ,resultCode: " + fromServiceMsg.getResultCode());
        }
        String str = "";
        if (isSuccess) {
            TimDocSSOMsg$SetPadRightInfoRspBody timDocSSOMsg$SetPadRightInfoRspBody = new TimDocSSOMsg$SetPadRightInfoRspBody();
            try {
                timDocSSOMsg$SetPadRightInfoRspBody.mergeFrom((byte[]) obj);
                i3 = timDocSSOMsg$SetPadRightInfoRspBody.uint32_retcode.get();
            } catch (Exception e16) {
                QLog.i(ITeamWorkHandler.TAG, 1, " handleSetPadRightsInfo exception: " + e16.toString());
            }
            if (i3 != 0) {
                QLog.e(ITeamWorkHandler.TAG, 1, "error handleSetPadRightsInfo  url : ,retCode: " + i3);
                isSuccess = false;
            } else {
                str = timDocSSOMsg$SetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.i(ITeamWorkHandler.TAG, 2, " handleSetPadRightsInfo url : " + str + ",retCode: " + i3);
                }
                isSuccess = true;
            }
        }
        if (!isSuccess) {
            QLog.i(ITeamWorkHandler.TAG, 1, " handleGetPadRightsInfo faied code: " + fromServiceMsg.getResultCode());
        }
        notifyUI(6, isSuccess, new Object[]{str, Integer.valueOf(intValue)});
    }

    private void handleSetUserAuthDocsGrayTips(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        boolean z16;
        try {
            DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) toServiceMsg.getAttribute("data");
            long longValue = ((Long) toServiceMsg.getAttribute("seq")).longValue();
            cmd0xbab$RspBody cmd0xbab_rspbody = new cmd0xbab$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xbab_rspbody);
            if (parseOIDBPkg == 0) {
                cmd0xbab_rspbody.user_set_rsp.get();
                str = docsGrayTipsInfo.F;
                if ("1".equals(docsGrayTipsInfo.f291467h)) {
                    ReportController.o(null, "CliOper", "", "", "0X8009550", "0X8009550", 0, 0, "", "", "", "");
                } else if ("2".equals(docsGrayTipsInfo.f291467h)) {
                    ReportController.o(null, "CliOper", "", "", "0X8009552", "0X8009552", 0, 0, "", "", "", "");
                }
                z16 = true;
            } else {
                str = docsGrayTipsInfo.G;
                z16 = false;
            }
            try {
                notifyUI(9, z16, new Object[]{docsGrayTipsInfo, str, Long.valueOf(longValue)});
                if (QLog.isColorLevel()) {
                    QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, " handleSetUserAuthDocsGrayTips ,result: " + parseOIDBPkg);
                }
            } catch (Exception e16) {
                e = e16;
                QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " handleSetUserAuthDocsGrayTips  exception = " + e.toString());
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertCryptoUinToTrueUin$6(IGetExternalInterface.d dVar, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int optInt = jSONObject.optInt("cgicode", -1);
                String optString = jSONObject.optString("msg");
                if (optInt == 0) {
                    dVar.a(jSONObject.optString("uin"));
                } else {
                    QLog.w(ITeamWorkHandler.TAG, 1, "no result, cgicode: " + optInt + " msg: " + optString);
                    dVar.a(null);
                }
                return;
            } catch (Throwable th5) {
                QLog.e(ITeamWorkHandler.TAG, 1, th5.getLocalizedMessage(), th5);
                dVar.a(null);
                return;
            }
        }
        dVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void lambda$delRecentFilesByHttp$5(IGetExternalInterface.d dVar, Object obj) {
        JSONObject jSONObject = null;
        try {
            if (obj instanceof String) {
                JSONObject jSONObject2 = new JSONObject((String) obj);
                try {
                    if (jSONObject2.optInt("retcode", -1) != 0 && QLog.isColorLevel()) {
                        QLog.e(ITeamWorkHandler.TAG, 2, "delRecentFilesByHttp failed result" + obj);
                    }
                    jSONObject = jSONObject2;
                } catch (Throwable th5) {
                    th = th5;
                    jSONObject = jSONObject2;
                    if (QLog.isColorLevel()) {
                        QLog.e(ITeamWorkHandler.TAG, 2, th, new Object[0]);
                    }
                    if (jSONObject == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    dVar.a(jSONObject);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("retcode", -1);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITeamWorkHandler.TAG, 2, jSONObject.toString());
        }
        dVar.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getLoginInfo$3(String str, IGetExternalInterface.d dVar, String str2) {
        TimDocSSOMsg$LoginInfo timDocSSOMsg$LoginInfo = new TimDocSSOMsg$LoginInfo();
        if (!TextUtils.isEmpty(str2)) {
            timDocSSOMsg$LoginInfo.bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
        } else {
            QLog.i(ITeamWorkHandler.TAG, 1, str + "pskey async is empty, domain: " + ITeamWorkHandler.DOCS_DOMAIN);
        }
        dVar.a(timDocSSOMsg$LoginInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPadRightsInfo$0(TimDocSSOMsg$GetPadRightInfoReqBody timDocSSOMsg$GetPadRightInfoReqBody, int i3, ReSendCmd reSendCmd, String str, Object obj) {
        if (!(obj instanceof TimDocSSOMsg$LoginInfo)) {
            QLog.e(ITeamWorkHandler.TAG, 1, "---- GetPadRightInfoReqBody -- loginInfo is null ---");
            return;
        }
        timDocSSOMsg$GetPadRightInfoReqBody.msg_login_info.set((TimDocSSOMsg$LoginInfo) obj);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), ITeamWorkHandler.CMD_GET_PAD_RIGHT_INFO);
        toServiceMsg.putWupBuffer(timDocSSOMsg$GetPadRightInfoReqBody.toByteArray());
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.addAttribute(ITeamWorkHandler.KEY_TYPE_LIST, Integer.valueOf(i3));
        toServiceMsg.extraData.putParcelable(ITeamWorkHandler.KEY_RESEND_CMD, reSendCmd);
        super.sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(ITeamWorkHandler.TAG, 2, "send GetPadRightInfoReqBody,padUrl: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void lambda$getRecentFilesByHttp$4(IGetExternalInterface.d dVar, Object obj) {
        JSONObject jSONObject = null;
        try {
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                JSONObject jSONObject2 = new JSONObject((String) obj);
                try {
                    if (jSONObject2.optInt("retcode", -1) != 0 && QLog.isColorLevel()) {
                        QLog.e(ITeamWorkHandler.TAG, 2, "getRecentFilesByHttp failed result" + obj);
                    }
                    jSONObject = jSONObject2;
                } catch (Throwable th5) {
                    th = th5;
                    jSONObject = jSONObject2;
                    if (QLog.isColorLevel()) {
                        QLog.e(ITeamWorkHandler.TAG, 2, th, new Object[0]);
                    }
                    if (jSONObject == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    dVar.a(jSONObject);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("retcode", -1);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITeamWorkHandler.TAG, 2, jSONObject.toString());
        }
        dVar.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void lambda$getTemplateListByHttp$1(IGetExternalInterface.d dVar, Object obj) {
        JSONObject jSONObject = null;
        try {
            if (obj instanceof String) {
                JSONObject jSONObject2 = new JSONObject((String) obj);
                try {
                    if (jSONObject2.optInt("retcode", -1) != 0) {
                        jSONObject2.put("retcode", -1);
                        if (QLog.isColorLevel()) {
                            QLog.e(ITeamWorkHandler.TAG, 2, "failed result" + obj);
                        }
                    }
                    jSONObject = jSONObject2;
                } catch (Throwable th5) {
                    th = th5;
                    jSONObject = jSONObject2;
                    if (QLog.isColorLevel()) {
                        QLog.e(ITeamWorkHandler.TAG, 2, th, new Object[0]);
                    }
                    if (jSONObject == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    dVar.a(jSONObject);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("retcode", -1);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(ITeamWorkHandler.TAG, 2, jSONObject.toString());
        }
        dVar.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPadRightsInfo$2(TimDocSSOMsg$SetPadRightInfoReqBody timDocSSOMsg$SetPadRightInfoReqBody, int i3, List list, int i16, String str, Object obj) {
        if (obj instanceof TimDocSSOMsg$LoginInfo) {
            timDocSSOMsg$SetPadRightInfoReqBody.msg_login_info.set((TimDocSSOMsg$LoginInfo) obj);
        }
        timDocSSOMsg$SetPadRightInfoReqBody.uint32_appid.set(2);
        timDocSSOMsg$SetPadRightInfoReqBody.uint32_pad_right.set(i3);
        if (list != null && list.size() > 0) {
            timDocSSOMsg$SetPadRightInfoReqBody.rpt_msg_uin_right_info.set(list);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), ITeamWorkHandler.CMD_SET_PAD_RIGHT_INFO);
        toServiceMsg.addAttribute(ITeamWorkHandler.KEY_TYPE_LIST, Integer.valueOf(i16));
        toServiceMsg.putWupBuffer(timDocSSOMsg$SetPadRightInfoReqBody.toByteArray());
        toServiceMsg.setTimeout(30000L);
        super.sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(ITeamWorkHandler.TAG, 2, "send setPadRightsInfo,padUrl: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reTrySendCmd(ReSendCmd reSendCmd) {
        if (reSendCmd != null) {
            QLog.i(ITeamWorkHandler.TAG, 1, " reTrySendCmd retry cmd\uff1a" + reSendCmd.f291501d);
            if (reSendCmd.f291501d == 9) {
                getPadRightsInfo(reSendCmd.f291504h, reSendCmd.f291505i);
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void convertCryptoUinToTrueUin(String str, String str2, String str3, final IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("xsrf=" + str3 + "&uin=" + str, this.app.getCurrentAccountUin(), ITeamWorkHandler.URL_CONVERT_UIN, ITeamWorkHandler.DOCS_DOMAIN, "vfwebqq=" + str2 + ";TOK=" + str3, null, false, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ai
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.lambda$convertCryptoUinToTrueUin$6(IGetExternalInterface.d.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void delRecentFilesByHttp(JSONObject jSONObject, final IGetExternalInterface.d dVar) {
        if (jSONObject == null) {
            dVar.a(null);
            return;
        }
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject, this.app.getCurrentAccountUin(), ITeamWorkHandler.URL_DEL_RECENT_FILES + "?t=" + System.currentTimeMillis() + "&xsrf=" + replaceAll, ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.aj
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.lambda$delRecentFilesByHttp$5(IGetExternalInterface.d.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public boolean getEnableTencentDocsAssistant() {
        return this.enableTencentDocsAssistant;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void getGroupAuthDocsGrayTips(DocsGrayTipsInfo docsGrayTipsInfo, long j3) {
        String str;
        try {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                BaseApplication context = BaseApplication.getContext();
                if (TextUtils.isEmpty(docsGrayTipsInfo.H)) {
                    str = this.app.getApp().getString(R.string.f171139ci4);
                } else {
                    str = docsGrayTipsInfo.H;
                }
                QQToast.makeText(context, str, 0).show();
                return;
            }
            cmd0xbab$GroupGetReq cmd0xbab_groupgetreq = new cmd0xbab$GroupGetReq();
            cmd0xbab_groupgetreq.group_code.set(Long.parseLong(docsGrayTipsInfo.f291464d));
            cmd0xbab_groupgetreq.doc_url.set(docsGrayTipsInfo.f291465e);
            cmd0xbab$ReqBody cmd0xbab_reqbody = new cmd0xbab$ReqBody();
            cmd0xbab_reqbody.group_get_req.set(cmd0xbab_groupgetreq);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ITeamWorkHandler.CMD_GET_GROUP_AUTH_DOCS_TIPS_INFO, 2987, 3, cmd0xbab_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("data", docsGrayTipsInfo);
            makeOIDBPkg.addAttribute("seq", Long.valueOf(j3));
            sendPbReq(makeOIDBPkg);
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "get group auth | uin = " + docsGrayTipsInfo.f291464d + " docUrl = " + docsGrayTipsInfo.f291465e + ", msgSeq = " + j3);
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "get group auth exception = " + e16.toString());
        }
    }

    void getLoginInfo(final String str, final IGetExternalInterface.d dVar) {
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.api.impl.ak
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str2) {
                TeamWorkHandlerImpl.lambda$getLoginInfo$3(str, dVar, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void getPadRightsInfo(final int i3, final String str) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUI(5, false, new Object[]{"", Integer.valueOf(i3)});
            return;
        }
        final TimDocSSOMsg$GetPadRightInfoReqBody timDocSSOMsg$GetPadRightInfoReqBody = new TimDocSSOMsg$GetPadRightInfoReqBody();
        timDocSSOMsg$GetPadRightInfoReqBody.uint32_appid.set(2);
        timDocSSOMsg$GetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(str));
        final ReSendCmd reSendCmd = new ReSendCmd();
        reSendCmd.f291501d = 9;
        reSendCmd.f291504h = i3;
        reSendCmd.f291505i = str;
        getLoginInfo("send GetPadRightInfoReqBody", new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.am
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.this.lambda$getPadRightsInfo$0(timDocSSOMsg$GetPadRightInfoReqBody, i3, reSendCmd, str, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void getRecentFilesByHttp(String str, final IGetExternalInterface.d dVar) {
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        StringBuilder sb5 = new StringBuilder(ITeamWorkHandler.URL_GET_RECENT_FILES);
        sb5.append('?');
        sb5.append("t=");
        sb5.append(System.currentTimeMillis());
        sb5.append("&xsrf=");
        sb5.append(replaceAll);
        if (!TextUtils.isEmpty(str)) {
            sb5.append("&to_uin=");
            sb5.append(str);
        }
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(this.app.getCurrentAccountUin(), sb5.toString(), ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.al
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.lambda$getRecentFilesByHttp$4(IGetExternalInterface.d.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void getTemplateListByHttp(final IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(this.app.getCurrentAccountUin(), ITeamWorkHandler.URL_GET_TEMPLATE_LIST, ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ao
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.lambda$getTemplateListByHttp$1(IGetExternalInterface.d.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void getUserAuthDocsGrayTips(DocsGrayTipsInfo docsGrayTipsInfo, long j3) {
        String str;
        try {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                BaseApplication context = BaseApplication.getContext();
                if (TextUtils.isEmpty(docsGrayTipsInfo.H)) {
                    str = this.app.getApp().getString(R.string.f171139ci4);
                } else {
                    str = docsGrayTipsInfo.H;
                }
                QQToast.makeText(context, str, 0).show();
                return;
            }
            cmd0xbab$UserGetReq cmd0xbab_usergetreq = new cmd0xbab$UserGetReq();
            cmd0xbab_usergetreq.uin.set(Long.parseLong(docsGrayTipsInfo.f291464d));
            cmd0xbab_usergetreq.doc_url.set(docsGrayTipsInfo.f291465e);
            cmd0xbab$ReqBody cmd0xbab_reqbody = new cmd0xbab$ReqBody();
            cmd0xbab_reqbody.user_get_req.set(cmd0xbab_usergetreq);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ITeamWorkHandler.CMD_GET_USER_AUTH_DOCS_TIPS_INFO, 2987, 1, cmd0xbab_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("data", docsGrayTipsInfo);
            makeOIDBPkg.addAttribute("seq", Long.valueOf(j3));
            sendPbReq(makeOIDBPkg);
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, "get user auth | uin = " + docsGrayTipsInfo.f291464d + " docUrl = " + docsGrayTipsInfo.f291465e);
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "get user auth exception = " + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void handleGetPadRightsInfo(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        int intValue = ((Integer) toServiceMsg.getAttribute(ITeamWorkHandler.KEY_TYPE_LIST)).intValue();
        if (QLog.isColorLevel()) {
            QLog.i(ITeamWorkHandler.TAG, 2, " handleGetPadRightsInfo ,resultCode: " + fromServiceMsg.getResultCode());
        }
        String str = "";
        if (isSuccess) {
            TimDocSSOMsg$GetPadRightInfoRspBody timDocSSOMsg$GetPadRightInfoRspBody = new TimDocSSOMsg$GetPadRightInfoRspBody();
            try {
                timDocSSOMsg$GetPadRightInfoRspBody.mergeFrom((byte[]) obj);
                int i3 = timDocSSOMsg$GetPadRightInfoRspBody.uint32_retcode.get();
                if (i3 != 0) {
                    QLog.e(ITeamWorkHandler.TAG, 1, "error handleGetPadRightsInfo url : ,retCode: " + i3);
                    if (i3 == 200011 && handleResponseTry((ReSendCmd) toServiceMsg.extraData.getParcelable(ITeamWorkHandler.KEY_RESEND_CMD))) {
                        return;
                    }
                } else {
                    str = timDocSSOMsg$GetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
                    if (!timDocSSOMsg$GetPadRightInfoRspBody.uint32_pad_right.has()) {
                        QLog.e(ITeamWorkHandler.TAG, 1, "error handleGetPadRightsInfo url : " + str + ",has not padrights filed ");
                    } else {
                        int i16 = timDocSSOMsg$GetPadRightInfoRspBody.uint32_pad_right.get();
                        List<TimDocSSOMsg$UinRightInfo> list = timDocSSOMsg$GetPadRightInfoRspBody.rpt_msg_uin_right_info.get();
                        if (QLog.isColorLevel()) {
                            QLog.w(ITeamWorkHandler.TAG, 2, "pad is not exxisted ,but in other list find : false");
                        }
                        notifyUI(7, true, new Object[]{str, Integer.valueOf(i16), list});
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.i(ITeamWorkHandler.TAG, 1, " handleGetPadRightsInfo exception: " + e16.toString());
            }
            isSuccess = false;
        }
        if (!isSuccess) {
            QLog.i(ITeamWorkHandler.TAG, 1, " handleGetPadRightsInfo faied code: " + fromServiceMsg.getResultCode());
        }
        notifyUI(5, isSuccess, new Object[]{str, Integer.valueOf(intValue)});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return bh.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (ITeamWorkHandler.CMD_GET_PAD_RIGHT_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleGetPadRightsInfo(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ITeamWorkHandler.CMD_SET_PAD_RIGHT_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleSetPadRightsInfo(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ITeamWorkHandler.CMD_GET_USER_AUTH_DOCS_TIPS_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleGetUserAuthDocsGrayTips(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ITeamWorkHandler.CMD_SET_USER_AUTH_DOCS_TIPS_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleSetUserAuthDocsGrayTips(toServiceMsg, fromServiceMsg, obj);
        } else if (ITeamWorkHandler.CMD_GET_GROUP_AUTH_DOCS_TIPS_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleGetGroupAuthDocsGrayTips(toServiceMsg, fromServiceMsg, obj);
        } else if (ITeamWorkHandler.CMD_SET_GROUP_AUTH_DOCS_TIPS_INFO.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleSetGroupAuthDocsGrayTips(toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void setEnableTencentDocsAssistant(boolean z16) {
        this.enableTencentDocsAssistant = z16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void setGroupAuthDocsGrayTips(DocsGrayTipsInfo docsGrayTipsInfo, int i3, long j3) {
        String str;
        try {
            boolean z16 = false;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                BaseApplication context = BaseApplication.getContext();
                if (TextUtils.isEmpty(docsGrayTipsInfo.H)) {
                    str = this.app.getApp().getString(R.string.f171139ci4);
                } else {
                    str = docsGrayTipsInfo.H;
                }
                QQToast.makeText(context, str, 0).show();
                return;
            }
            cmd0xbab$GroupSetReq cmd0xbab_groupsetreq = new cmd0xbab$GroupSetReq();
            cmd0xbab_groupsetreq.group_code.set(Long.parseLong(docsGrayTipsInfo.f291464d));
            cmd0xbab_groupsetreq.doc_url.set(docsGrayTipsInfo.f291465e);
            cmd0xbab_groupsetreq.policy.set(Integer.valueOf(docsGrayTipsInfo.D).intValue());
            PBBoolField pBBoolField = cmd0xbab_groupsetreq.only;
            if (Integer.valueOf(docsGrayTipsInfo.E).intValue() == 1) {
                z16 = true;
            }
            pBBoolField.set(z16);
            cmd0xbab_groupsetreq.privilege_flag.set(Integer.valueOf(docsGrayTipsInfo.C).intValue());
            cmd0xbab_groupsetreq.exp_set_time.set(i3);
            cmd0xbab$ReqBody cmd0xbab_reqbody = new cmd0xbab$ReqBody();
            cmd0xbab_reqbody.group_set_req.set(cmd0xbab_groupsetreq);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ITeamWorkHandler.CMD_SET_GROUP_AUTH_DOCS_TIPS_INFO, 2987, 4, cmd0xbab_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("data", docsGrayTipsInfo);
            makeOIDBPkg.addAttribute("seq", Long.valueOf(j3));
            sendPbReq(makeOIDBPkg);
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "set group auth | uin = " + docsGrayTipsInfo.f291464d + " docUrl = " + docsGrayTipsInfo.f291465e + " setploicy = " + docsGrayTipsInfo.D + " setonly= " + docsGrayTipsInfo.E + " setprivilege=" + docsGrayTipsInfo.C + " bNeedtime = " + docsGrayTipsInfo.N + " settime=" + i3);
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "set group auth exception = " + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void setPadRightsInfo(final int i3, final String str, final int i16, final List<TimDocSSOMsg$UinRightInfo> list) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            notifyUI(6, false, new Object[]{"", Integer.valueOf(i16)});
            return;
        }
        final TimDocSSOMsg$SetPadRightInfoReqBody timDocSSOMsg$SetPadRightInfoReqBody = new TimDocSSOMsg$SetPadRightInfoReqBody();
        timDocSSOMsg$SetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(str));
        getLoginInfo("send setPadRightsInfo", new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.an
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkHandlerImpl.this.lambda$setPadRightsInfo$2(timDocSSOMsg$SetPadRightInfoReqBody, i3, list, i16, str, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHandler
    public void setUserAuthDocsGrayTips(DocsGrayTipsInfo docsGrayTipsInfo, int i3, long j3) {
        String str;
        try {
            boolean z16 = false;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                BaseApplication context = BaseApplication.getContext();
                if (TextUtils.isEmpty(docsGrayTipsInfo.H)) {
                    str = this.app.getApp().getString(R.string.f171139ci4);
                } else {
                    str = docsGrayTipsInfo.H;
                }
                QQToast.makeText(context, str, 0).show();
                return;
            }
            cmd0xbab$UserSetReq cmd0xbab_usersetreq = new cmd0xbab$UserSetReq();
            cmd0xbab_usersetreq.uin.set(Long.parseLong(docsGrayTipsInfo.f291464d));
            cmd0xbab_usersetreq.doc_url.set(docsGrayTipsInfo.f291465e);
            cmd0xbab_usersetreq.policy.set(Integer.valueOf(docsGrayTipsInfo.D).intValue());
            PBBoolField pBBoolField = cmd0xbab_usersetreq.only;
            if (Integer.valueOf(docsGrayTipsInfo.E).intValue() == 1) {
                z16 = true;
            }
            pBBoolField.set(z16);
            cmd0xbab_usersetreq.privilege_flag.set(Integer.valueOf(docsGrayTipsInfo.C).intValue());
            cmd0xbab_usersetreq.exp_set_time.set(i3);
            cmd0xbab$ReqBody cmd0xbab_reqbody = new cmd0xbab$ReqBody();
            cmd0xbab_reqbody.user_set_req.set(cmd0xbab_usersetreq);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg(ITeamWorkHandler.CMD_SET_USER_AUTH_DOCS_TIPS_INFO, 2987, 2, cmd0xbab_reqbody.toByteArray());
            makeOIDBPkg.addAttribute("data", docsGrayTipsInfo);
            makeOIDBPkg.addAttribute("seq", Long.valueOf(j3));
            sendPbReq(makeOIDBPkg);
            QLog.i(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, "set user auth | uin = " + docsGrayTipsInfo.f291464d + " docUrl = " + docsGrayTipsInfo.f291465e + " setploicy = " + docsGrayTipsInfo.D + " setonly= " + docsGrayTipsInfo.E + " setprivilege=" + docsGrayTipsInfo.C + " bNeedtime = " + docsGrayTipsInfo.N + " settime=" + i3);
        } catch (Exception e16) {
            QLog.e(ITeamWorkHandler.TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "set user auth exception = " + e16.toString());
        }
    }
}
