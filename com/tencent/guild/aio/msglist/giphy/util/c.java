package com.tencent.guild.aio.msglist.giphy.util;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0006*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\bB\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/giphy/util/c;", "Landroid/view/View;", "T", "", "view", "", "c", "(Landroid/view/View;)V", "a", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "vg", "Lkotlin/Function1;", "onRemove", "b", "Ljava/lang/Class;", "Ljava/lang/Class;", "cls", "Ljava/util/Stack;", "Ljava/util/Stack;", "viewScrap", "<init>", "(Ljava/lang/Class;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c<T extends View> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<T> cls;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Stack<T> viewScrap;

    public c(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        this.cls = cls;
        this.viewScrap = new Stack<>();
    }

    private final void c(T view) {
        this.viewScrap.push(view);
    }

    @Nullable
    public final T a() {
        if (this.viewScrap.isEmpty()) {
            return null;
        }
        return this.viewScrap.pop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@NotNull ViewGroup vg5, @NotNull Function1<? super T, Unit> onRemove) {
        Intrinsics.checkNotNullParameter(vg5, "vg");
        Intrinsics.checkNotNullParameter(onRemove, "onRemove");
        ArrayList<View> arrayList = new ArrayList();
        int childCount = vg5.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = vg5.getChildAt(i3);
            if (Intrinsics.areEqual(childAt.getClass(), this.cls)) {
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type T of com.tencent.guild.aio.msglist.giphy.util.GuildRecycler");
                arrayList.add(childAt);
            }
        }
        for (View view : arrayList) {
            c(view);
            vg5.removeView(view);
            onRemove.invoke(view);
        }
    }
}
