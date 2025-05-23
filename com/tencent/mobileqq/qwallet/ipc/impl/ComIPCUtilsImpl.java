package com.tencent.mobileqq.qwallet.ipc.impl;

import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import eipc.EIPCResult;

/* loaded from: classes16.dex */
public class ComIPCUtilsImpl implements IComIPCUtils {
    public static final String KEY_ACTION = "action";
    public static final String KEY_MINI_LAUNCH_PARAM = "mini_launch_param";
    public static final String KEY_OPER_TYPE = "oper_type";
    public static final String KEY_RECEIVER = "receiver";
    public static final String KEY_REQ_PARAM = "req_param";
    public static final String KEY_RESULT = "res";
    public static final String KEY_UIN = "uin";
    public static final String KEY_VERSION = "version";
    public static final int OPER_TYPE_CANCEL_ALARM_NOTIFACATION = 12;
    public static final int OPER_TYPE_GET_REMINDER_SETTING_OPEN = 9;
    public static final int OPER_TYPE_REMOVE_MESSAGE_RECORD = 13;
    public static final int OPER_TYPE_SET_ALARM_NOTIFACATION = 11;
    public static final int OPER_TYPE_SET_REMINDER_SETTING_OPEN = 10;

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public void cancelAlarmNotifaction(AcsMsg acsMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt("oper_type", 12);
        bundle.putSerializable("req_param", acsMsg);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", bundle, null);
    }

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public String ipcGetGuid() {
        Bundle bundle;
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "getGuid", null);
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle.getString("res");
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public boolean isQQReminderOpen() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("oper_type", 9);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QWalletIPCModule", "ComIPCUtilsImpl", bundle2);
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            return bundle.getBoolean("res");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public void removeMessageRecord(AcsMsg acsMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt("oper_type", 13);
        bundle.putSerializable("req_param", acsMsg);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", bundle, null);
    }

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public void setAlarmNotifaction(AcsMsg acsMsg) {
        Bundle bundle = new Bundle();
        bundle.putInt("oper_type", 11);
        bundle.putSerializable("req_param", acsMsg);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", bundle, null);
    }

    @Override // com.tencent.mobileqq.qwallet.ipc.IComIPCUtils
    public void setQQReminderSwitch(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("oper_type", 10);
        bundle.putBoolean("req_param", z16);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "ComIPCUtilsImpl", bundle, null);
    }
}
