package com.tencent.guild.aio.util;

import com.tencent.common.app.AppInterface;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "a", "", "", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class y {
    @Nullable
    public static final IQQNTWrapperSession a() {
        AppInterface appInterface;
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null || (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "")) == null) {
            return null;
        }
        return iKernelService.getWrapperSession();
    }

    public static final boolean b(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }
}
