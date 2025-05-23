package com.tencent.guild.aio.msglist.holder.component;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "key", "Leq0/g;", "template", "", "a", "Landroid/view/View;", "b", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class k {
    public static final void a(@NotNull a aVar, int i3, @NotNull eq0.g template) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(template, "template");
        if (i3 != 11) {
            switch (i3) {
                case 0:
                    template.f(aVar.d1());
                    return;
                case 1:
                    template.c(aVar.d1());
                    return;
                case 2:
                    template.n(aVar.d1());
                    return;
                case 3:
                    template.g(aVar.d1());
                    return;
                case 4:
                    template.s(aVar.d1());
                    return;
                case 5:
                    if (template != null) {
                        template.i(aVar.d1());
                        return;
                    }
                    return;
                case 6:
                    template.t(aVar.d1());
                    return;
                case 7:
                    if (template != null) {
                        template.j(aVar.d1());
                        return;
                    }
                    return;
                case 8:
                    if (template != null) {
                        template.o(aVar.d1());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        template.g(aVar.d1());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static final View b(@NotNull a aVar, int i3, @NotNull eq0.g template) {
        View view;
        View view2;
        View view3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(template, "template");
        if (template instanceof eq0.e) {
            if (i3 == 3) {
                aVar.h1(template.b());
            }
        } else {
            switch (i3) {
                case 0:
                    aVar.h1(template.a());
                    break;
                case 1:
                    aVar.h1(template.e());
                    break;
                case 2:
                    aVar.h1(template.k());
                    break;
                case 3:
                    aVar.h1(template.b());
                    break;
                case 4:
                    aVar.h1(template.r());
                    break;
                case 5:
                    if (template != null) {
                        view = template.q();
                    } else {
                        view = null;
                    }
                    aVar.h1(view);
                    break;
                case 6:
                    aVar.h1(template.l());
                    break;
                case 7:
                    if (template != null) {
                        view2 = template.m();
                    } else {
                        view2 = null;
                    }
                    aVar.h1(view2);
                    break;
                case 8:
                    if (template != null) {
                        view3 = template.p();
                    } else {
                        view3 = null;
                    }
                    aVar.h1(view3);
                    break;
                case 9:
                    aVar.h1(template.h());
                    break;
            }
        }
        return null;
    }
}
