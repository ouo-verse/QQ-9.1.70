package com.tencent.guild.aio.msglist.markdown.inlineboard;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "", "Landroid/content/Context;", "a", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "e", "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "c", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "d", "()Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;", "setInlineKeyboardApi", "(Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;)V", "inlineKeyboardApi", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extras", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/api/runtime/a;Lcom/tencent/guild/aio/msglist/markdown/inlineboard/b;Landroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b inlineKeyboardApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extras;

    public a(@NotNull Context context, @Nullable com.tencent.aio.api.runtime.a aVar, @NotNull b inlineKeyboardApi, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inlineKeyboardApi, "inlineKeyboardApi");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.context = context;
        this.aioContext = aVar;
        this.inlineKeyboardApi = inlineKeyboardApi;
        this.extras = extras;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final b getInlineKeyboardApi() {
        return this.inlineKeyboardApi;
    }

    public final void e(@Nullable com.tencent.aio.api.runtime.a aVar) {
        this.aioContext = aVar;
    }

    public /* synthetic */ a(Context context, com.tencent.aio.api.runtime.a aVar, b bVar, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, bVar, (i3 & 8) != 0 ? new Bundle() : bundle);
    }
}
