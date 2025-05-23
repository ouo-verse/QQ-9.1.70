package com.tencent.mobileqq.guild.discoveryv2.util;

import android.view.View;
import com.tencent.ad.tangram.util.AdUIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u001b\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0004\u001a\f\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"T", "", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroid/view/View;", "Lkotlinx/coroutines/flow/Flow;", "", "a", "", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ExtKt {
    @NotNull
    public static final Flow<Unit> a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return FlowKt.callbackFlow(new ExtKt$attachedFromWindow$1(view, null));
    }

    public static final double c(@Nullable View view) {
        return AdUIUtils.getPercentageOfGlobalVisibleRect(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T b(@Nullable Object obj) {
        return obj;
    }
}
