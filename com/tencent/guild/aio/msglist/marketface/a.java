package com.tencent.guild.aio.msglist.marketface;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/msglist/marketface/a;", "Lol3/b;", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/marketface/a$a;", "Lcom/tencent/guild/aio/msglist/marketface/a;", "Lcom/tencent/guild/aio/msglist/marketface/b;", "d", "Lcom/tencent/guild/aio/msglist/marketface/b;", "a", "()Lcom/tencent/guild/aio/msglist/marketface/b;", "data", "<init>", "(Lcom/tencent/guild/aio/msglist/marketface/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.marketface.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1204a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IntentData data;

        public C1204a(@NotNull IntentData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final IntentData getData() {
            return this.data;
        }
    }
}
