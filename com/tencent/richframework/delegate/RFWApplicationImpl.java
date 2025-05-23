package com.tencent.richframework.delegate;

import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/delegate/RFWApplicationImpl;", "Lcom/tencent/biz/richframework/delegate/IApplicationDelegate;", "()V", "getAccountId", "", "isPublicVersion", "", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RFWApplicationImpl implements IApplicationDelegate {
    @Override // com.tencent.biz.richframework.delegate.IApplicationDelegate
    @Nullable
    public String getAccountId() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    @Override // com.tencent.biz.richframework.delegate.IApplicationDelegate
    public boolean isPublicVersion() {
        return AppSetting.isPublicVersion();
    }
}
