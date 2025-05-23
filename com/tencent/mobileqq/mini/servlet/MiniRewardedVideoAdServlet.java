package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$ContextInfo;
import NS_MINI_AD.MiniAppAd$DebugInfo;
import NS_MINI_AD.MiniAppAd$DeviceInfo;
import NS_MINI_AD.MiniAppAd$PositionInfo;
import NS_MINI_AD.MiniAppAd$UserInfo;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniRewardedVideoAdServlet extends MiniAppAbstractServlet {
    public static final String KEY_AD_TYPE = "key_ad_type";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_BUSI_COOKIE = "key_busi_cookie";
    public static final String KEY_CONTEXT_INFO = "key_context_info";
    public static final String KEY_DEBUG_INFO = "key_debug_info";
    public static final String KEY_DEVICE_INFO = "key_device_info";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_GDT_COOKIE = "key_gdt_cookie";
    public static final String KEY_POSITION_INFO = "key_position_info";
    public static final String KEY_SUPPORT_HTTPS = "key_support_https";
    public static final String KEY_USER_INFO = "key_user_info";
    public static final String TAG = "MiniRewardedVideoAdServlet";
    private int index;

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive.");
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable("getRewardedVideoADInfo", fromServiceMsg);
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    notifyObserver(intent, 1027, true, bundle, MiniAppObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. MiniRewardedVideoAdServlet rsp = " + stQWebRsp);
                    }
                    notifyObserver(intent, 1027, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniRewardedVideoAdServlet resultcode fail.");
                }
                notifyObserver(intent, 1027, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onReceive error", th5);
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, this.index);
            notifyObserver(intent, 1027, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        MiniAppAd$UserInfo miniAppAd$UserInfo;
        MiniAppAd$PositionInfo miniAppAd$PositionInfo;
        MiniAppAd$DeviceInfo miniAppAd$DeviceInfo;
        MiniAppAd$ContextInfo miniAppAd$ContextInfo;
        MiniAppAd$DebugInfo miniAppAd$DebugInfo;
        this.index = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(KEY_USER_INFO);
        byte[] byteArrayExtra3 = intent.getByteArrayExtra(KEY_POSITION_INFO);
        byte[] byteArrayExtra4 = intent.getByteArrayExtra(KEY_DEVICE_INFO);
        byte[] byteArrayExtra5 = intent.getByteArrayExtra(KEY_CONTEXT_INFO);
        byte[] byteArrayExtra6 = intent.getByteArrayExtra(KEY_DEBUG_INFO);
        String stringExtra = intent.getStringExtra(KEY_GDT_COOKIE);
        boolean booleanExtra = intent.getBooleanExtra(KEY_SUPPORT_HTTPS, false);
        String stringExtra2 = intent.getStringExtra(KEY_BUSI_COOKIE);
        String stringExtra3 = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra(KEY_AD_TYPE, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        if (byteArrayExtra2 != null) {
            miniAppAd$UserInfo = new MiniAppAd$UserInfo();
            try {
                miniAppAd$UserInfo.mergeFrom(byteArrayExtra2);
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom userInfoByte exception!");
                }
                e17.printStackTrace();
            }
        } else {
            miniAppAd$UserInfo = null;
        }
        if (byteArrayExtra3 != null) {
            MiniAppAd$PositionInfo miniAppAd$PositionInfo2 = new MiniAppAd$PositionInfo();
            try {
                miniAppAd$PositionInfo2.mergeFrom(byteArrayExtra3);
            } catch (InvalidProtocolBufferMicroException e18) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom positionInfoByte exception!");
                }
                e18.printStackTrace();
            }
            miniAppAd$PositionInfo = miniAppAd$PositionInfo2;
        } else {
            miniAppAd$PositionInfo = null;
        }
        if (byteArrayExtra4 != null) {
            MiniAppAd$DeviceInfo miniAppAd$DeviceInfo2 = new MiniAppAd$DeviceInfo();
            try {
                miniAppAd$DeviceInfo2.mergeFrom(byteArrayExtra4);
            } catch (InvalidProtocolBufferMicroException e19) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom deviceInfoByte exception!");
                }
                e19.printStackTrace();
            }
            miniAppAd$DeviceInfo = miniAppAd$DeviceInfo2;
        } else {
            miniAppAd$DeviceInfo = null;
        }
        if (byteArrayExtra5 != null) {
            MiniAppAd$ContextInfo miniAppAd$ContextInfo2 = new MiniAppAd$ContextInfo();
            try {
                miniAppAd$ContextInfo2.mergeFrom(byteArrayExtra5);
            } catch (InvalidProtocolBufferMicroException e26) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom contextInfoByte exception!");
                }
                e26.printStackTrace();
            }
            miniAppAd$ContextInfo = miniAppAd$ContextInfo2;
        } else {
            miniAppAd$ContextInfo = null;
        }
        if (byteArrayExtra6 != null) {
            MiniAppAd$DebugInfo miniAppAd$DebugInfo2 = new MiniAppAd$DebugInfo();
            try {
                miniAppAd$DebugInfo2.mergeFrom(byteArrayExtra6);
            } catch (InvalidProtocolBufferMicroException e27) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom debugInfoByte exception!");
                }
                e27.printStackTrace();
            }
            miniAppAd$DebugInfo = miniAppAd$DebugInfo2;
        } else {
            miniAppAd$DebugInfo = null;
        }
        byte[] encode = new MiniAppGetAdRequest(stCommonExt, miniAppAd$UserInfo, miniAppAd$PositionInfo, miniAppAd$DeviceInfo, miniAppAd$ContextInfo, miniAppAd$DebugInfo, stringExtra, booleanExtra, stringExtra2, stringExtra3, intExtra).encode(intent, this.index, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(MiniAppGetAdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
