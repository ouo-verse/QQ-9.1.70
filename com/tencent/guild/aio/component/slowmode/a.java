package com.tencent.guild.aio.component.slowmode;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/guild/aio/component/slowmode/a$a;", "Lcom/tencent/guild/aio/component/slowmode/a$b;", "Lcom/tencent/guild/aio/component/slowmode/a$c;", "Lcom/tencent/guild/aio/component/slowmode/a$d;", "Lcom/tencent/guild/aio/component/slowmode/a$e;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a$a;", "Lcom/tencent/guild/aio/component/slowmode/a;", "Lcom/tencent/qqnt/msg/data/b;", "d", "Lcom/tencent/qqnt/msg/data/b;", "a", "()Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "<init>", "(Lcom/tencent/qqnt/msg/data/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.slowmode.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1182a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.msg.data.b limitInfoData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1182a(@NotNull com.tencent.qqnt.msg.data.b limitInfoData) {
            super(null);
            Intrinsics.checkNotNullParameter(limitInfoData, "limitInfoData");
            this.limitInfoData = limitInfoData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.qqnt.msg.data.b getLimitInfoData() {
            return this.limitInfoData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a$b;", "Lcom/tencent/guild/aio/component/slowmode/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f110334d = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a$c;", "Lcom/tencent/guild/aio/component/slowmode/a;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final c f110335d = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a$d;", "Lcom/tencent/guild/aio/component/slowmode/a;", "", "d", "Z", "a", "()Z", "isLimited", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isLimited;

        public d(boolean z16) {
            super(null);
            this.isLimited = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsLimited() {
            return this.isLimited;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/a$e;", "Lcom/tencent/guild/aio/component/slowmode/a;", "", "d", "Z", "a", "()Z", NodeProps.ENABLED, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean enabled;

        public e(boolean z16) {
            super(null);
            this.enabled = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
