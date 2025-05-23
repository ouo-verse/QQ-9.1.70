package com.tencent.guild.aio.article.msglist;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/i;", "Lcom/tencent/mvi/api/ability/d;", "<init>", "()V", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class i implements com.tencent.mvi.api.ability.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/i$a;", "Lcom/tencent/guild/aio/article/msglist/i;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends i {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/i$b;", "Lcom/tencent/guild/aio/article/msglist/i;", "", "a", "I", "()I", "index", "b", "springBackDistance", "<init>", "(II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int springBackDistance;

        public b(int i3, int i16) {
            this.index = i3;
            this.springBackDistance = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: b, reason: from getter */
        public final int getSpringBackDistance() {
            return this.springBackDistance;
        }
    }
}
