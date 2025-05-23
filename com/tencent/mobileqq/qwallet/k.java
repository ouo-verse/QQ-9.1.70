package com.tencent.mobileqq.qwallet;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\"\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u001a\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "", "clickInterval", "Lkotlin/Function0;", "", "action", "c", "", "a", "", "radius", "b", "qqpay-api_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "ViewExtensions")
/* loaded from: classes16.dex */
public final class k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/k$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f278581a;

        a(float f16) {
            this.f278581a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (outline == null || view == null) {
                return;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f278581a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/k$b", "Lcom/tencent/mobileqq/qwallet/j;", "Landroid/view/View;", "view", "", "a", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends j {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f278582f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, Function0<Unit> function0) {
            super(j3);
            this.f278582f = function0;
        }

        @Override // com.tencent.mobileqq.qwallet.j
        public void a(@Nullable View view) {
            this.f278582f.invoke();
        }
    }

    @NotNull
    public static final int[] a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new int[]{iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
    }

    public static final void b(@NotNull View view, float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOutlineProvider(new a(f16));
        view.setClipToOutline(true);
    }

    public static final void c(@NotNull View view, long j3, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        view.setOnClickListener(new b(j3, action));
    }

    public static /* synthetic */ void d(View view, long j3, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 1000;
        }
        c(view, j3, function0);
    }
}
