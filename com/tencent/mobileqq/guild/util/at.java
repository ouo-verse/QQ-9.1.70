package com.tencent.mobileqq.guild.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/at;", "", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "d", "Lcom/tencent/qqnt/kernel/api/o;", "a", "Luh2/c;", "b", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final at f235448a = new at();

    at() {
    }

    @JvmStatic
    public static final boolean c() {
        IQQNTWrapperSession iQQNTWrapperSession;
        boolean z16;
        IGProSession iGProSession;
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Boolean bool = null;
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            iQQNTWrapperSession = iKernelService.getWrapperSession();
        } else {
            iQQNTWrapperSession = null;
        }
        if (peekAppRuntime != null && (iGProSession = (IGProSession) peekAppRuntime.getRuntimeService(IGProSession.class, "")) != null) {
            bool = Boolean.valueOf(iGProSession.isInit());
        }
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && iQQNTWrapperSession != null && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @Nullable
    public static final IGPSService d() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService = null;
        if (c()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            return (IGPSService) iRuntimeService;
        }
        QLog.e("GuildSdkUtils", 1, "safeGPSService fail, \n " + QLog.getStackTraceString(new Throwable()));
        return null;
    }

    @Nullable
    public final com.tencent.qqnt.kernel.api.o a() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        } else {
            iRuntimeService = null;
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession == null) {
            return null;
        }
        if (!iGProSession.isInit()) {
            iGProSession = null;
        }
        if (iGProSession == null) {
            return null;
        }
        return iGProSession.getFeedService();
    }

    @Nullable
    public final uh2.c b() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        } else {
            iRuntimeService = null;
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession == null) {
            return null;
        }
        if (!iGProSession.isInit()) {
            iGProSession = null;
        }
        if (iGProSession == null) {
            return null;
        }
        return iGProSession.getGProGuildMsgService();
    }
}
