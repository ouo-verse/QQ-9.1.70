package com.tencent.mobileqq.guild.util;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u0007"}, d2 = {"Landroid/widget/TextView;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/util/e;", "", "Lkotlin/ExtensionFunctionType;", "init", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class co {
    public static final void a(@NotNull TextView textView, @NotNull Function1<? super e, Unit> init) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        f fVar = new f(textView);
        init.invoke(fVar);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(fVar.getBuilder());
    }
}
