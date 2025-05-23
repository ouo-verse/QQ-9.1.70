package com.tencent.mobileqq.mutualmark.utils;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mutualmark.util.WebMutualMarkCardUpdateUtil;
import com.tencent.mobileqq.mutualmark.widget.util.MutualMarkDialogUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MutualMarkIpcClient extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile MutualMarkIpcClient f252283d;

    /* renamed from: e, reason: collision with root package name */
    private static long f252284e;

    MutualMarkIpcClient(String str) {
        super(str);
    }

    public static MutualMarkIpcClient b() {
        if (f252283d == null) {
            synchronized (MutualMarkIpcClient.class) {
                if (f252283d == null) {
                    f252283d = new MutualMarkIpcClient("MutualMarkIpcClient");
                }
            }
        }
        return f252283d;
    }

    public static void c(long j3) {
        f252284e = j3;
        try {
            QLog.d("MutualMarkIpcClient", 1, "register: " + j3);
            QIPCClientHelper.getInstance().register(b());
        } catch (Exception e16) {
            QLog.d("MutualMarkIpcClient", 1, "register error: ", e16.getMessage());
        }
    }

    public static void d(long j3) {
        if (j3 == f252284e && QIPCClientHelper.getInstance().getClient() != null) {
            try {
                QLog.d("MutualMarkIpcClient", 1, "unregister: " + j3);
                QIPCClientHelper.getInstance().getClient().unRegisterModule(b());
            } catch (Exception e16) {
                QLog.d("MutualMarkIpcClient", 1, "unregister error: ", e16.getMessage());
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, final Bundle bundle, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MutualMarkIpcClient", 4, "onCall, action[" + str + "]");
        }
        if ("notifyUpdateWebCard".equals(str)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.utils.MutualMarkIpcClient.1
                @Override // java.lang.Runnable
                public void run() {
                    MutualMarkDialogUtil.e();
                    WebMutualMarkCardUpdateUtil.b().d(bundle.getLong("changedCardId"), bundle.getLong("changedCardUin"), bundle.getBoolean("isWearing"));
                }
            });
            return null;
        }
        if (!"notifyUpdateWebCardLoading".equals(str)) {
            return null;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.utils.MutualMarkIpcClient.2
            @Override // java.lang.Runnable
            public void run() {
                MutualMarkDialogUtil.d(QBaseActivity.sTopActivity, null, false, System.currentTimeMillis());
            }
        });
        return null;
    }
}
