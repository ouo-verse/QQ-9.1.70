package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u00a2\u0006\u0002\b\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/util/e;", "", "", "text", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/util/c;", "", "Lkotlin/ExtensionFunctionType;", "method", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(e eVar, String str, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                eVar.a(str, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addText");
        }
    }

    void a(@NotNull String text, @Nullable Function1<? super c, Unit> method);
}
