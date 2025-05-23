package com.tencent.ntcompose.activity;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ntcompose/activity/ComponentActivity;", "a", "Landroidx/compose/runtime/CompositionContext;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "b", "(Lcom/tencent/ntcompose/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {
    public static final ComponentActivity a() {
        com.tencent.kuikly.core.pager.b hostPager = com.tencent.kuikly.core.manager.c.f117352a.g().hostPager();
        Intrinsics.checkNotNull(hostPager, "null cannot be cast to non-null type com.tencent.ntcompose.activity.ComponentActivity");
        return (ComponentActivity) hostPager;
    }

    public static final void b(ComponentActivity componentActivity, CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        if (componentActivity.getDidRenderContent()) {
            return;
        }
        componentActivity.setContent$ntcompose_release(content);
        if (componentActivity.getInnerDidCreateBody()) {
            componentActivity.renderContent$ntcompose_release();
        }
    }

    public static /* synthetic */ void c(ComponentActivity componentActivity, CompositionContext compositionContext, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            compositionContext = null;
        }
        b(componentActivity, compositionContext, function2);
    }
}
