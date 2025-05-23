package com.tencent.qqguild.base.mvvm;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqguild/base/mvvm/b;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "lambda", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements com.tencent.mvi.base.route.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<MsgIntent, Unit> lambda;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function1<? super MsgIntent, Unit> lambda) {
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        this.lambda = lambda;
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        this.lambda.invoke(i3);
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        return a.C9235a.a(this);
    }
}
