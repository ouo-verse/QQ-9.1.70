package com.tencent.mobileqq.nearbypro.aio.processor;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.nearbypro.aio.IProcessorUtilsApi;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/processor/ProcessorUtilsImpl;", "Lcom/tencent/mobileqq/nearbypro/aio/IProcessorUtilsApi;", "", "uin", "", "isReceiveFriendNotify", "Lmqq/app/AppRuntime;", "getAppRuntime", "getFriendName", "getTempName", "<init>", "()V", "Companion", "a", "qq_nearby_pro_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ProcessorUtilsImpl implements IProcessorUtilsApi {
    private static final String TAG = "ProcessorUtilsImpl";

    @Override // com.tencent.mobileqq.nearbypro.aio.IProcessorUtilsApi
    public AppRuntime getAppRuntime() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNullExpressionValue(runtime, "getApplication().runtime");
        return runtime;
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.IProcessorUtilsApi
    public String getFriendName(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return "";
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        String friendName = ((IFriendNameService) runtimeService).getFriendName(uin);
        Intrinsics.checkNotNullExpressionValue(friendName, "friendNameService.getFriendName(uin)");
        return friendName;
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.IProcessorUtilsApi
    public String getTempName(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return uin;
        }
        try {
            String s16 = ac.s(qQAppInterface, uin, "", ac.w(10019), 3);
            return s16 == null ? uin : s16;
        } catch (Exception unused) {
            QLog.e(TAG, 1, "getName error " + uin);
            return uin;
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.aio.IProcessorUtilsApi
    public boolean isReceiveFriendNotify(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null) == null) {
            return true;
        }
        return !FriendsStatusUtil.k(uin, r0);
    }
}
