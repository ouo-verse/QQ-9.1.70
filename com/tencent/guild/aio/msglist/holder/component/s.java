package com.tencent.guild.aio.msglist.holder.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/s;", "Lol3/b;", "<init>", "()V", "a", "b", "Lcom/tencent/guild/aio/msglist/holder/component/s$b;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class s implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/s$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "b", "(Lcom/tencent/aio/api/runtime/a;)V", "context", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.s$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class AioContextWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private com.tencent.aio.api.runtime.a context;

        public AioContextWrapper() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final com.tencent.aio.api.runtime.a getContext() {
            return this.context;
        }

        public final void b(@Nullable com.tencent.aio.api.runtime.a aVar) {
            this.context = aVar;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AioContextWrapper) && Intrinsics.areEqual(this.context, ((AioContextWrapper) other).context)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            com.tencent.aio.api.runtime.a aVar = this.context;
            if (aVar == null) {
                return 0;
            }
            return aVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "AioContextWrapper(context=" + this.context + ")";
        }

        public AioContextWrapper(@Nullable com.tencent.aio.api.runtime.a aVar) {
            this.context = aVar;
        }

        public /* synthetic */ AioContextWrapper(com.tencent.aio.api.runtime.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/s$b;", "Lcom/tencent/guild/aio/msglist/holder/component/s;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/guild/aio/msglist/holder/component/s$a;", "d", "Lcom/tencent/guild/aio/msglist/holder/component/s$a;", "a", "()Lcom/tencent/guild/aio/msglist/holder/component/s$a;", "setContextWrapper", "(Lcom/tencent/guild/aio/msglist/holder/component/s$a;)V", "contextWrapper", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.s$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class GetAioContext extends s {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private AioContextWrapper contextWrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAioContext(@NotNull AioContextWrapper contextWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(contextWrapper, "contextWrapper");
            this.contextWrapper = contextWrapper;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AioContextWrapper getContextWrapper() {
            return this.contextWrapper;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetAioContext) && Intrinsics.areEqual(this.contextWrapper, ((GetAioContext) other).contextWrapper)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.contextWrapper.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetAioContext(contextWrapper=" + this.contextWrapper + ")";
        }
    }

    public /* synthetic */ s(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    s() {
    }
}
