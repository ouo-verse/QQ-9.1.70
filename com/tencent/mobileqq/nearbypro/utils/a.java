package com.tencent.mobileqq.nearbypro.utils;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/a;", "", "Lqp4/c;", "areaBgInfo", "Lcq4/a;", "loc", "Landroid/graphics/Point;", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f253947a = new a();

    a() {
    }

    @NotNull
    public final Point a(@NotNull qp4.c areaBgInfo, @NotNull cq4.a loc) {
        Intrinsics.checkNotNullParameter(areaBgInfo, "areaBgInfo");
        Intrinsics.checkNotNullParameter(loc, "loc");
        int i3 = areaBgInfo.f429208b;
        int i16 = areaBgInfo.f429209c;
        float f16 = i3;
        float a16 = com.tencent.mobileqq.nearbypro.land.d.INSTANCE.a() / f16;
        return new Point((int) ((loc.f391665a + (f16 / 2.0f)) * a16), (int) (((i16 / 2.0f) - loc.f391666b) * a16));
    }
}
