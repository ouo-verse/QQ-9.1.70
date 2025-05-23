package com.tencent.mobileqq.utils.abtest;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPClientConnectListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ABTLoginActModule extends QIPCModule implements EIPClientConnectListener {
    public static final String KEY_LOGIN = "abtest_qipc_module_name_action_login_login";
    public static final String KEY_UIN = "abtest_qipc_module_name_action_login_uin";
    public static final String MODULE_NAME = "ABTLoginActModule";
    public static final String QIPC_ACTION = "abtest_qipc_module_name_action_login";
    private static final CopyOnWriteArrayList<String> ipcList = new CopyOnWriteArrayList<>();
    private static volatile ABTLoginActModule sInstance;

    ABTLoginActModule() {
        super(MODULE_NAME);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = ipcList;
        copyOnWriteArrayList.add("qzone");
        copyOnWriteArrayList.add("video");
        copyOnWriteArrayList.add("zplan");
        copyOnWriteArrayList.add("peak");
        copyOnWriteArrayList.add("tool");
        copyOnWriteArrayList.add("mini");
        copyOnWriteArrayList.add(ProcessConstant.MINI_1);
        copyOnWriteArrayList.add(ProcessConstant.MINI_2);
        copyOnWriteArrayList.add(ProcessConstant.MINI_3);
        copyOnWriteArrayList.add(ProcessConstant.MINI_4);
        copyOnWriteArrayList.add(ProcessConstant.MINI_5);
        copyOnWriteArrayList.add("qqstranger");
        copyOnWriteArrayList.add(ProcessConstant.QQWADL);
    }

    public static ABTLoginActModule getImpl() {
        if (sInstance == null) {
            synchronized (ABTLoginActModule.class) {
                if (sInstance == null) {
                    sInstance = new ABTLoginActModule();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectSuccess$0(EIPCResult eIPCResult) {
        boolean z16;
        Bundle bundle;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doInit subproc ipc callback:");
        sb5.append(eIPCResult);
        sb5.append(" succ:");
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        ABTestUtil.log(sb5.toString());
        if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
            String string = bundle.getString(KEY_UIN);
            boolean z17 = eIPCResult.data.getBoolean(KEY_LOGIN);
            ABTestUtil.log(String.format("callback from main proc. bleUin=%s bleLogin=%s", string, Boolean.valueOf(z17)));
            ABTestController.getInstance().doInit1505(string, z17);
        }
    }

    @Override // eipc.EIPClientConnectListener
    public void connectFailed() {
        ABTestUtil.log("ABTLoginActModule #connectFailed");
    }

    @Override // eipc.EIPClientConnectListener
    public void connectSuccess(EIPCConnection eIPCConnection) {
        ABTestUtil.log("ABTLoginActModule #connectSuccess. start ipc call");
        QIPCClientHelper.getInstance().callServer(MODULE_NAME, QIPC_ACTION, null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.utils.abtest.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                ABTLoginActModule.lambda$connectSuccess$0(eIPCResult);
            }
        });
    }

    public void doInitByIpc() {
        try {
            ABTestUtil.log("registerModule proc:" + MobileQQ.sProcessId);
            QIPCClientHelper.getInstance().register(getImpl());
            QIPCClientHelper.getInstance().getClient().connect(getImpl());
        } catch (Throwable th5) {
            ABTestUtil.log(th5.getMessage());
        }
    }

    public boolean isProcEnable() {
        String qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        if (!TextUtils.isEmpty(qQProcessName)) {
            Iterator<String> it = ipcList.iterator();
            while (it.hasNext()) {
                if (qQProcessName.endsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        String str2;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ABTestUtil.log("ABTLoginActModule#onCall id=" + i3 + " act=" + str + " proc=" + MobileQQ.sProcessId);
        Bundle bundle2 = new Bundle();
        bundle2.putString(KEY_UIN, str2);
        bundle2.putBoolean(KEY_LOGIN, z16);
        callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
        return null;
    }
}
