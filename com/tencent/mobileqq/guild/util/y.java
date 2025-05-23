package com.tencent.mobileqq.guild.util;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.ipc.IpcArguments;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y {
    public static void b(Class<? extends AbsIpcMethod> cls, EIPCResultCallback eIPCResultCallback, Object... objArr) {
        c(cls.getCanonicalName(), eIPCResultCallback, objArr);
    }

    public static void c(final String str, final EIPCResultCallback eIPCResultCallback, Object... objArr) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("args", new IpcArguments(objArr));
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, str, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.util.x
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                y.e(str, eIPCResultCallback, eIPCResult);
            }
        });
    }

    private static String d(String str, Object... objArr) {
        return "[GuildIpcUtils] IpcCall: " + str + "(" + GuildDebugUtils.b(objArr) + ") fail";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, EIPCResultCallback eIPCResultCallback, EIPCResult eIPCResult) {
        f(str, eIPCResult);
        if (eIPCResultCallback != null) {
            eIPCResultCallback.onCallback(eIPCResult);
        }
    }

    private static void f(String str, EIPCResult eIPCResult) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("method", str);
        if (eIPCResult == null) {
            z16 = false;
        } else {
            boolean isSuccess = eIPCResult.isSuccess();
            hashMap.put("code", String.valueOf(eIPCResult.code));
            z16 = isSuccess;
        }
        com.tencent.xaction.log.b.a("GuildIpcUtils", 4, "reportMetric method=" + str + " result=" + z16);
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCount(GuildCounterNames.GUILD_IPC_SUCC_RATE, z16, hashMap);
    }

    public static EIPCResult g(Class<? extends AbsIpcMethod> cls, Object... objArr) {
        return h(cls.getCanonicalName(), objArr);
    }

    @NonNull
    public static EIPCResult h(String str, Object... objArr) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("args", new IpcArguments(objArr));
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, str, bundle);
        f(str, callServer);
        if (callServer != null) {
            return callServer;
        }
        return EIPCResult.createExceptionResult(new NullPointerException(d(str, objArr)));
    }
}
