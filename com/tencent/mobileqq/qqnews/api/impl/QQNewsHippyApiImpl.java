package com.tencent.mobileqq.qqnews.api.impl;

import bj2.b;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqnews/api/impl/QQNewsHippyApiImpl;", "Lcom/tencent/mobileqq/qqnews/api/IQQNewsHippyApi;", "()V", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getAppRuntime", "Lmqq/app/AppRuntime;", "hasNewMessage", "", "hasUnReadMsg", "isCanPreload", "isQQNewsModule", "moduleName", "", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQNewsHippyApiImpl implements IQQNewsHippyApi {
    static IPatchRedirector $redirector_;

    public QQNewsHippyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final boolean hasUnReadMsg() {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IConversationFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        if (((IConversationFacade) runtimeService).getUnreadCount("2909288299", 1008) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi
    @NotNull
    public HippyAPIProvider createHippyProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HippyAPIProvider) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi
    public boolean hasNewMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d("QQNewsHippyApiImpl", 2, "hasNewMessage hasNewMsg=" + hasUnReadMsg);
        }
        return hasUnReadMsg;
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi
    public boolean isCanPreload() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return false;
        }
        boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, "2909288299");
        boolean hasUnReadMsg = hasUnReadMsg();
        if (QLog.isColorLevel()) {
            QLog.d("QQNewsHippyApiImpl", 2, "canPreloadHippy enable=true, isFollowPA=" + isFollowUin + ", hasUnReadMsg=" + hasUnReadMsg);
        }
        if (!hasUnReadMsg || !isFollowUin) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi
    public boolean isQQNewsModule(@NotNull String moduleName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) moduleName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return Intrinsics.areEqual(HippyQQConstants.ModuleName.QQ_NEWS_PUBLICACCOUNT, moduleName);
    }
}
