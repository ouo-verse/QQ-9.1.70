package com.tencent.mobileqq.onlinestatus.api.impl;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusCommonApi;
import com.tencent.mobileqq.onlinestatus.utils.ab;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/OnlineStatusCommonApiImpl;", "Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusCommonApi;", "Lmqq/app/AppRuntime;", "app", "", "initOnlineStatusLiteBusiness", "doInit", "<init>", "()V", "Companion", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusCommonApiImpl implements IOnlineStatusCommonApi {

    @NotNull
    private static final String TAG = "OnlineStatusCommonImpl";

    private final void initOnlineStatusLiteBusiness(AppRuntime app) {
        IKernelService iKernelService;
        IKernelOnlineStatusService onlineStatusService;
        ExpEntityInfo b16 = ab.f256333a.b("exp_qq_msg_online_status_trans_1");
        boolean isExperiment = b16.isExperiment();
        QLog.d(TAG, 1, "initOnlineStatusLiteBusiness hitExp: " + isExperiment);
        if (app != null && (iKernelService = (IKernelService) app.getRuntimeService(IKernelService.class, "")) != null && (onlineStatusService = iKernelService.getOnlineStatusService()) != null) {
            onlineStatusService.setOnlineStatusLiteBusinessSwitch(isExperiment);
        }
        b16.reportExpExposure();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusCommonApi
    public void doInit(@Nullable AppRuntime app) {
        initOnlineStatusLiteBusiness(app);
    }
}
