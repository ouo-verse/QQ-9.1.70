package com.tencent.guild.aio.msglist.ark;

import com.tencent.guild.aio.help.GuildArkContainerHelper;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/c;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "Lcom/tencent/guild/aio/msglist/ark/c$a;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class c implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/c$a;", "Lcom/tencent/guild/aio/msglist/ark/c;", "Lcom/tencent/guild/aio/help/GuildArkContainerHelper;", "a", "Lcom/tencent/guild/aio/help/GuildArkContainerHelper;", "()Lcom/tencent/guild/aio/help/GuildArkContainerHelper;", "arkContainerHelper", "<init>", "(Lcom/tencent/guild/aio/help/GuildArkContainerHelper;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildArkContainerHelper arkContainerHelper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GuildArkContainerHelper arkContainerHelper) {
            super(null);
            Intrinsics.checkNotNullParameter(arkContainerHelper, "arkContainerHelper");
            this.arkContainerHelper = arkContainerHelper;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GuildArkContainerHelper getArkContainerHelper() {
            return this.arkContainerHelper;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
