package com.tencent.mobileqq.qqecommerce.biz.nt;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/nt/NTComposeNTSessionWrapper;", "", "()V", "getCurrentSession", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class NTComposeNTSessionWrapper {
    public static final NTComposeNTSessionWrapper INSTANCE = new NTComposeNTSessionWrapper();

    NTComposeNTSessionWrapper() {
    }

    public final IQQNTWrapperSession getCurrentSession() {
        return ((IKernelService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IKernelService.class, "all")).getWrapperSession();
    }
}
