package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountDetailPageLaunchInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0096\u0001J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountLauncherImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountLauncher;", "()V", "getJumpUrl", "", "launchInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo;", "hasRedDot", "", "launchQCircleFromPublicAccount", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "launchQCirclePublicAccountDetailPage", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountLauncherImpl implements IQCirclePublicAccountLauncher {
    private final /* synthetic */ QCirclePublicAccountLauncher $$delegate_0 = QCirclePublicAccountLauncher.INSTANCE;

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    @NotNull
    public String getJumpUrl(@Nullable QCirclePublicAccountDetailPageLaunchInfo launchInfo, boolean hasRedDot) {
        return this.$$delegate_0.getJumpUrl(launchInfo, hasRedDot);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    public void launchQCircleFromPublicAccount(@NotNull BaseQQAppInterface app, @NotNull Context context, @NotNull QCirclePublicAccountLauncherSource source) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.$$delegate_0.launchQCircleFromPublicAccount(app, context, source);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher
    public void launchQCirclePublicAccountDetailPage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0.launchQCirclePublicAccountDetailPage(context);
    }
}
