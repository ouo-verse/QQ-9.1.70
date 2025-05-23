package com.tencent.guild.aio.util.flowbus.dispatcher;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/util/flowbus/dispatcher/a;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {
    @NotNull
    public CoroutineDispatcher a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            return Dispatchers.getMain();
        }
        return Dispatchers.getDefault();
    }
}
