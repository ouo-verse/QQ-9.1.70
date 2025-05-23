package com.tencent.mobileqq.nearbypro.land;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/e;", "", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "c", "Lcom/tencent/mobileqq/nearbypro/land/h;", "param", "b", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Lcom/tencent/mobileqq/nearbypro/land/NearbyAreaComponent;", "a", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/nearbypro/land/h;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AreaParam param;

    @NotNull
    public final NearbyAreaComponent a(@NotNull com.tencent.mobileqq.nearbypro.part.a host) {
        Intrinsics.checkNotNullParameter(host, "host");
        Context context = host.getContext();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        AreaParam areaParam = null;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            lifecycleOwner = null;
        }
        AreaParam areaParam2 = this.param;
        if (areaParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            areaParam = areaParam2;
        }
        return new NearbyAreaComponent(context, lifecycleOwner, areaParam, host);
    }

    @NotNull
    public final e b(@NotNull AreaParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        return this;
    }

    @NotNull
    public final e c(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        return this;
    }
}
