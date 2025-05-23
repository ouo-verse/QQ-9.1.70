package com.tencent.mobileqq.mutualmark.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f252286d;

    a() {
        super("MutualMarkIpcServer");
    }

    public static a b() {
        if (f252286d == null) {
            synchronized (a.class) {
                if (f252286d == null) {
                    f252286d = new a();
                }
            }
        }
        return f252286d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (!"checkLottieResource".equals(str)) {
            return null;
        }
        com.tencent.mobileqq.mutualmark.model.c lottieDownloadInfo = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo();
        if (TextUtils.isEmpty(lottieDownloadInfo.f252186a) || TextUtils.isEmpty(lottieDownloadInfo.f252187b)) {
            lottieDownloadInfo.f252186a = "";
            lottieDownloadInfo.f252187b = "";
        }
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).checkDownloadCartoonResource(qQAppInterface, lottieDownloadInfo.f252186a, lottieDownloadInfo.f252187b);
        return EIPCResult.createSuccessResult(new Bundle());
    }
}
