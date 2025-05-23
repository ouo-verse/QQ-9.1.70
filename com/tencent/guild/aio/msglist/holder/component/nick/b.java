package com.tencent.guild.aio.msglist.holder.component.nick;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/b;", "", "Landroid/view/View;", "child", "", "a", "Lcom/tencent/guild/aio/msglist/holder/component/nick/q;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/q;", "childHelper", "", "b", "I", "position", "<init>", "(Lcom/tencent/guild/aio/msglist/holder/component/nick/q;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q childHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int position;

    public b(@NotNull q childHelper, int i3) {
        Intrinsics.checkNotNullParameter(childHelper, "childHelper");
        this.childHelper = childHelper;
        this.position = i3;
    }

    public final void a(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.childHelper.addView(child, this.position);
    }
}
