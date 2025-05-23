package com.tencent.mobileqq.nearbypro.utils;

import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"", "msg", "", "c", "b", "", "a", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class s {
    public static final long a() {
        SelfUserInfo selfUserInfo;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            return selfUserInfo.getTid();
        }
        return 0L;
    }

    public static final void b(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QQToast.makeText(BaseApplication.context, msg2, 0).show();
    }

    public static final void c(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (com.tencent.mobileqq.nearbypro.base.j.a().debug()) {
            QQToast.makeText(BaseApplication.context, msg2, 0).show();
        }
    }
}
