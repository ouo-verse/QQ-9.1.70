package com.tencent.mobileqq.vashealth.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import j43.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthHippyApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthHippyApi;", "", "hasUnReadMsg", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "createHippyProvider", "", "moduleName", "isHealthModule", "canPreloadHippy", "hasNewMessage", "<init>", "()V", "Companion", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQHealthHippyApiImpl implements IQQHealthHippyApi {

    @NotNull
    private static final String TAG = "HealthHippyApiImpl";

    private final boolean hasUnReadMsg() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IConversationFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        if (((IConversationFacade) runtimeService).getUnreadCount(IPublicAccountUtil.UIN_FOR_HEALTH, 1008) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi
    public boolean canPreloadHippy() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            return false;
        }
        boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin((AppInterface) waitAppRuntime, IPublicAccountUtil.UIN_FOR_HEALTH);
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPreloadHippy enable=true isFollowPA=" + isFollowUin + " hasUnReadMsg=" + hasUnReadMsg);
        }
        if (!hasUnReadMsg || !isFollowUin) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi
    @NotNull
    public HippyAPIProvider createHippyProvider() {
        return new b();
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi
    public boolean hasNewMessage() {
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasNewMessage hasNewMsg=" + hasUnReadMsg);
        }
        return hasUnReadMsg;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi
    public boolean isHealthModule(@Nullable String moduleName) {
        return TextUtils.equals(moduleName, HippyQQConstants.ModuleName.QQ_SPORT);
    }
}
