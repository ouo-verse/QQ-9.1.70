package com.tencent.mobileqq.wink.output;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u4e16\u754c\u5934\u50cf\u66ff\u6362", path = QCircleWinkOutputRouterForQCircleAvatar.ROUTE_PATH)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/output/QCircleWinkOutputRouterForQCircleAvatar;", "Lb93/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleWinkOutputRouterForQCircleAvatar implements a {

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/qcircleavatar";

    @NotNull
    public static final String TAG = "QCircleWinkOutputRouterForQCircleAvatar";

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        b.f(TAG, "[onOutput] point=" + outputData.getOutputPoint());
        ((Activity) context).finish();
    }
}
