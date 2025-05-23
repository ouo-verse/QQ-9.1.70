package com.tencent.biz.qqcircle.wink;

import android.content.Context;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004J4\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/wink/h;", "", "Landroid/content/Context;", "context", "", "clientTraceId", "", IProfileCardConst.KEY_FROM_TYPE, "schemaUrl", "", "a", "errCode", "", "intercept", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f93953a = new h();

    h() {
    }

    public final void a(@Nullable Context context, @Nullable String clientTraceId, int fromType, @NotNull String schemaUrl) {
        Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
        ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClick(context, clientTraceId, fromType, schemaUrl);
    }

    public final void b(@Nullable Context context, @Nullable String clientTraceId, int fromType, @NotNull String errCode, boolean intercept) {
        Intrinsics.checkNotNullParameter(errCode, "errCode");
        ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClickBroken(clientTraceId, fromType, errCode, intercept);
    }
}
