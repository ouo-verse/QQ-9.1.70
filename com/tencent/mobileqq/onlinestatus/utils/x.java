package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.onlinestatus.ba;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/x;", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/x$a;", "", "Lcom/tencent/mobileqq/onlinestatus/ba;", "panelParams", "", "itemWidth", "b", "panelWidth", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.utils.x$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull ba panelParams, int panelWidth, int itemWidth) {
            int roundToInt;
            Intrinsics.checkNotNullParameter(panelParams, "panelParams");
            int dip2px = ViewUtils.dip2px(panelParams.f255570i);
            int dpToPx = ViewUtils.dpToPx(panelParams.f255568g);
            roundToInt = MathKt__MathJVMKt.roundToInt(((panelWidth + dpToPx) - (dip2px * 2)) / (itemWidth + dpToPx));
            return roundToInt;
        }

        public final int b(@NotNull ba panelParams, int itemWidth) {
            Intrinsics.checkNotNullParameter(panelParams, "panelParams");
            return (itemWidth * panelParams.f255565d) + (ViewUtils.dpToPx(panelParams.f255568g) * (panelParams.f255565d - 1)) + (ViewUtils.dip2px(panelParams.f255570i) * 2);
        }

        Companion() {
        }
    }
}
