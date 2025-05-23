package com.tencent.mobileqq.haoliyou.sso;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.bigbrother.ServerApi$ErrorInfo;
import com.tencent.mobileqq.bigbrother.ServerApi$RspDownloadCheckRecmd;
import com.tencent.mobileqq.bigbrother.ServerApi$RspJumpCheckRecmd;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$CheckShareExtensionRsp;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$RspBody;
import tencent.im.oidb.jump_url_check.jump_url_check$RspJumpUrlCheckRecmd;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CheckForwardServlet extends MSFServlet {
    static IPatchRedirector $redirector_ = null;
    static final Map<String, Integer> CHECK_TYPE;
    static final String CMD_CHECK_DOWNLOAD = "QQApkSvc.check_download_apk";
    static final String CMD_CHECK_JUMP = "QQApkSvc.check_jump_apk";
    static final String CMD_CHECK_SHARE = "OidbSvc.0xc78_1";
    public static final String CMD_JUMP_URL_CHECK = "QQApkSvc.check_jump_url";
    public static final int CMD_TYPE_CHECK_DOWNLOAD = 3;
    public static final int CMD_TYPE_CHECK_JUMP = 4;
    static final int CMD_TYPE_CHECK_SHARE = 1;
    public static final int CMD_TYPE_JUMP_URL_CHECK = 2;
    public static final int JUMP_RET_ILLEGAL = 1;
    public static final String KEY_ALLOW_DOWNLOAD = "allow_download";
    public static final String KEY_CAN_JUMP = "can_jump";
    public static final String KEY_CMD = "CMD";
    public static final String KEY_ERR_CODE = "err_code";
    public static final String KEY_ERR_MSG = "err_msg";
    static final String KEY_EXT_INFO = "ext_info";
    public static final String KEY_JUMP = "jump";
    static final String KEY_JUMP_RESULT = "jump_result";
    public static final String KEY_JUMP_URL = "jump_url";
    static final String KEY_REQUEST_BYTES = "RequestBytes";
    public static final String KEY_REQ_ID = "req_id";
    public static final String KEY_RESULT = "result";
    private static final String TAG = "CheckForwardServlet";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashMap hashMap = new HashMap();
        CHECK_TYPE = hashMap;
        hashMap.put(CMD_CHECK_SHARE, 1);
        hashMap.put(CMD_JUMP_URL_CHECK, 2);
        hashMap.put(CMD_CHECK_DOWNLOAD, 3);
        hashMap.put(CMD_CHECK_JUMP, 4);
    }

    public CheckForwardServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void checkShare(Bundle bundle, @NotNull oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) throws InvalidProtocolBufferMicroException {
        oidb_cmd0xc78$RspBody oidb_cmd0xc78_rspbody = new oidb_cmd0xc78$RspBody();
        oidb_cmd0xc78_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
        oidb_cmd0xc78$CheckShareExtensionRsp oidb_cmd0xc78_checkshareextensionrsp = oidb_cmd0xc78_rspbody.check_share_extension_rsp.get();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onreceive result: " + oidb_cmd0xc78_checkshareextensionrsp.result.get() + ", jump: " + oidb_cmd0xc78_checkshareextensionrsp.jump_result.get());
        }
        bundle.putInt("result", oidb_cmd0xc78_checkshareextensionrsp.result.get());
        bundle.putInt(KEY_JUMP_RESULT, oidb_cmd0xc78_checkshareextensionrsp.jump_result.get());
        bundle.putString("jump_url", oidb_cmd0xc78_checkshareextensionrsp.jump_url.get());
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive with code: " + fromServiceMsg.getResultCode());
        }
        int intValue = CHECK_TYPE.get(intent.getStringExtra(KEY_CMD)).intValue();
        Bundle bundle = new Bundle();
        bundle.putString("ext_info", intent.getStringExtra("ext_info"));
        bundle.putInt(KEY_REQ_ID, intent.getIntExtra(KEY_REQ_ID, 0));
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess) {
            try {
                ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr = new byte[wrap.getInt() - 4];
                wrap.get(bArr);
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4) {
                                ServerApi$RspJumpCheckRecmd serverApi$RspJumpCheckRecmd = new ServerApi$RspJumpCheckRecmd();
                                serverApi$RspJumpCheckRecmd.mergeFrom(bArr);
                                bundle.putInt("jump", serverApi$RspJumpCheckRecmd.jump_method.get());
                                ServerApi$ErrorInfo serverApi$ErrorInfo = serverApi$RspJumpCheckRecmd.err_info.get();
                                if (serverApi$ErrorInfo != null) {
                                    bundle.putInt(KEY_ERR_CODE, serverApi$ErrorInfo.err_code.get());
                                    bundle.putString("err_msg", serverApi$ErrorInfo.err_msg.get());
                                }
                            }
                        } else {
                            ServerApi$RspDownloadCheckRecmd serverApi$RspDownloadCheckRecmd = new ServerApi$RspDownloadCheckRecmd();
                            serverApi$RspDownloadCheckRecmd.mergeFrom(bArr);
                            bundle.putBoolean(KEY_ALLOW_DOWNLOAD, serverApi$RspDownloadCheckRecmd.check_pass.get());
                            ServerApi$ErrorInfo serverApi$ErrorInfo2 = serverApi$RspDownloadCheckRecmd.err_info.get();
                            if (serverApi$ErrorInfo2 != null) {
                                bundle.putInt(KEY_ERR_CODE, serverApi$ErrorInfo2.err_code.get());
                                bundle.putString("err_msg", serverApi$ErrorInfo2.err_msg.get());
                                bundle.putString("jump_url", serverApi$ErrorInfo2.jump_url.get());
                            }
                        }
                    } else {
                        jump_url_check$RspJumpUrlCheckRecmd jump_url_check_rspjumpurlcheckrecmd = new jump_url_check$RspJumpUrlCheckRecmd();
                        jump_url_check_rspjumpurlcheckrecmd.mergeFrom(bArr);
                        bundle.putInt(KEY_ERR_CODE, jump_url_check_rspjumpurlcheckrecmd.err_code.get());
                        bundle.putString("err_msg", jump_url_check_rspjumpurlcheckrecmd.err_msg.get());
                        bundle.putBoolean(KEY_CAN_JUMP, jump_url_check_rspjumpurlcheckrecmd.can_jump.get());
                    }
                } else {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                    if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                        isSuccess = true;
                    } else {
                        isSuccess = false;
                    }
                    if (isSuccess) {
                        checkShare(bundle, oidb_sso_oidbssopkg);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                z16 = false;
            }
        }
        z16 = isSuccess;
        notifyObserver(intent, intValue, z16, bundle, CheckForwardObserver.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(KEY_CMD);
        packet.setSSOCommand(stringExtra);
        stringExtra.hashCode();
        char c16 = '\uffff';
        switch (stringExtra.hashCode()) {
            case -1061791188:
                if (stringExtra.equals(CMD_CHECK_JUMP)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1061771905:
                if (stringExtra.equals(CMD_JUMP_URL_CHECK)) {
                    c16 = 1;
                    break;
                }
                break;
            case 879540486:
                if (stringExtra.equals(CMD_CHECK_DOWNLOAD)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (((TeleScreenConfig.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100839")) != null) {
                    packet.setTimeout(r2.f200363e);
                    break;
                }
                break;
            case 1:
                packet.setTimeout(10000L);
                break;
            case 2:
                if (((TeleScreenConfig.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100839")) != null) {
                    packet.setTimeout(r2.f200362d);
                    break;
                }
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend with cmd: " + stringExtra);
        }
        packet.putSendData(fh.b(intent.getByteArrayExtra(KEY_REQUEST_BYTES)));
    }
}
