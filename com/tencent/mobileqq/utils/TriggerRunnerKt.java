package com.tencent.mobileqq.utils;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Landroid/view/View;", "", "delayTime", "Landroid/view/View$OnClickListener;", "onClickListener", "", "b", "qqtroop-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TriggerRunnerKt {
    public static final void b(@NotNull final View view, final long j3, @NotNull final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.utils.eq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TriggerRunnerKt.d(view, j3, onClickListener, view2);
            }
        });
    }

    public static /* synthetic */ void c(View view, long j3, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 500;
        }
        b(view, j3, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final View this_setOnClickListenerWithTrigger, long j3, final View.OnClickListener onClickListener, View view) {
        ep epVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_setOnClickListenerWithTrigger, "$this_setOnClickListenerWithTrigger");
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Object tag = this_setOnClickListenerWithTrigger.getTag(R.id.f100975ty);
        if (tag instanceof ep) {
            epVar = (ep) tag;
        } else {
            epVar = null;
        }
        if (epVar == null) {
            epVar = new ep(j3);
            this_setOnClickListenerWithTrigger.setTag(R.id.f100975ty, epVar);
        }
        epVar.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.utils.TriggerRunnerKt$setOnClickListenerWithTrigger$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                onClickListener.onClick(this_setOnClickListenerWithTrigger);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }
}
