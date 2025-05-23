package com.tencent.mobileqq.flock.ktx;

import android.view.View;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0003\"\u0015\u0010\r\u001a\u00020\n*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\n*\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Landroid/view/View;", "", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "", NodeProps.ON_CLICK, "c", "", "b", "(I)I", "dp", "", "a", "(F)I", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i {
    public static final int a(float f16) {
        return ImmersiveUtils.dpToPx(f16);
    }

    public static final int b(int i3) {
        return a(i3);
    }

    public static final void c(@NotNull View view, long j3, @NotNull Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new a(String.valueOf(view.hashCode()), j3, onClick));
    }

    public static /* synthetic */ void d(View view, long j3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 1000;
        }
        c(view, j3, function1);
    }
}
