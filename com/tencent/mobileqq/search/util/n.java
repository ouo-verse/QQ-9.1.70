package com.tencent.mobileqq.search.util;

import com.tencent.common.app.AppInterface;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\"\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"", "", "e", "d", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "a", "()Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lcom/tencent/qqnt/kernel/api/ae;", "b", "()Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;", "unifySearchService", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class n {
    @Nullable
    public static final IKernelService a() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        return (IKernelService) iRuntimeService;
    }

    @Nullable
    public static final com.tencent.qqnt.kernel.api.ae b() {
        IKernelService a16 = a();
        if (a16 != null) {
            return a16.getSearchService();
        }
        return null;
    }

    @Nullable
    public static final IKernelUnifySearchService c() {
        IKernelService a16 = a();
        if (a16 != null) {
            return a16.getUnifySearchService();
        }
        return null;
    }

    public static final boolean d(int i3) {
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    public static final boolean e(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }
}
