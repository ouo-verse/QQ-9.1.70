package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "<anonymous parameter 0>", "", "", "<anonymous parameter 1>", "", "invoke", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;[Ljava/lang/Object;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedIPCApiImpl$initGuildTaskQueueManager$1 extends Lambda implements Function2 {
    public static final FeedIPCApiImpl$initGuildTaskQueueManager$1 INSTANCE = new FeedIPCApiImpl$initGuildTaskQueueManager$1();

    FeedIPCApiImpl$initGuildTaskQueueManager$1() {
        super(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        GuildTaskQueueManager.m().C();
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Void invoke(@NotNull AbsIpcMethod.a aVar, @NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 1>");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                FeedIPCApiImpl$initGuildTaskQueueManager$1.c();
            }
        }, 16, null, false);
        return null;
    }
}
