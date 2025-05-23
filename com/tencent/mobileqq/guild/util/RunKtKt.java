package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lkotlin/Function0;", "", "func", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RunKtKt {
    @NotNull
    public static final Function0<Unit> a(@NotNull final Function0<Unit> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        return new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.util.RunKtKt$invokeOnceFunction$1
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
                if (!Ref.BooleanRef.this.element) {
                    func.invoke();
                }
                Ref.BooleanRef.this.element = true;
            }
        };
    }
}
