package com.tencent.mobileqq.guild.feed.util;

import androidx.recyclerview.widget.RecyclerView;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class RecyclerViewExtKt$forceResetWidthAndClear$1 extends FunctionReferenceImpl implements Function1<RecyclerView.RecycledViewPool, Unit> {
    public static final RecyclerViewExtKt$forceResetWidthAndClear$1 INSTANCE = new RecyclerViewExtKt$forceResetWidthAndClear$1();

    RecyclerViewExtKt$forceResetWidthAndClear$1() {
        super(1, RecyclerView.RecycledViewPool.class, QCircleLpReportDc05507.KEY_CLEAR, "clear()V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.RecycledViewPool recycledViewPool) {
        invoke2(recycledViewPool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull RecyclerView.RecycledViewPool p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        p06.clear();
    }
}
