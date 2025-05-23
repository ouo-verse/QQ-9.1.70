package com.tencent.guild.aio.halfpop;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/halfpop/b;", "", "", "o8", "Landroid/content/Context;", "getHostContext", "Lkotlin/Function0;", "listener", "Xg", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface b {
    void Xg(@NotNull Function0<Unit> listener);

    @NotNull
    Context getHostContext();

    void o8();
}
