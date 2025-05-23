package com.tencent.guild.aio.article.msglist;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/f;", "Lat/b;", "<init>", "()V", "a", "b", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class f implements at.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/f$a;", "Lcom/tencent/guild/aio/article/msglist/f;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends f {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/f$b;", "Lcom/tencent/guild/aio/article/msglist/f;", "", "d", "I", "a", "()I", "lastPosition", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends f {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int lastPosition;

        public b(int i3) {
            this.lastPosition = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getLastPosition() {
            return this.lastPosition;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/f$c;", "Lcom/tencent/guild/aio/article/msglist/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", UserInfo.SEX_FEMALE, "c", "()F", "springBackDistance", "e", "I", "a", "()I", "firstPosition", "f", "getLastPosition", "lastPosition", "Lcom/tencent/aio/data/msglist/a;", tl.h.F, "Lcom/tencent/aio/data/msglist/a;", "b", "()Lcom/tencent/aio/data/msglist/a;", "setFirstVisibleMsg", "(Lcom/tencent/aio/data/msglist/a;)V", "firstVisibleMsg", "i", "getLastVisibleMsg", "setLastVisibleMsg", "lastVisibleMsg", "<init>", "(FIILcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/data/msglist/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.article.msglist.f$c, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildArticleSpringBackIntent extends f {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final float springBackDistance;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int firstPosition;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int lastPosition;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private com.tencent.aio.data.msglist.a firstVisibleMsg;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private com.tencent.aio.data.msglist.a lastVisibleMsg;

        public GuildArticleSpringBackIntent(float f16, int i3, int i16, @Nullable com.tencent.aio.data.msglist.a aVar, @Nullable com.tencent.aio.data.msglist.a aVar2) {
            this.springBackDistance = f16;
            this.firstPosition = i3;
            this.lastPosition = i16;
            this.firstVisibleMsg = aVar;
            this.lastVisibleMsg = aVar2;
        }

        /* renamed from: a, reason: from getter */
        public final int getFirstPosition() {
            return this.firstPosition;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final com.tencent.aio.data.msglist.a getFirstVisibleMsg() {
            return this.firstVisibleMsg;
        }

        /* renamed from: c, reason: from getter */
        public final float getSpringBackDistance() {
            return this.springBackDistance;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildArticleSpringBackIntent)) {
                return false;
            }
            GuildArticleSpringBackIntent guildArticleSpringBackIntent = (GuildArticleSpringBackIntent) other;
            if (Float.compare(this.springBackDistance, guildArticleSpringBackIntent.springBackDistance) == 0 && this.firstPosition == guildArticleSpringBackIntent.firstPosition && this.lastPosition == guildArticleSpringBackIntent.lastPosition && Intrinsics.areEqual(this.firstVisibleMsg, guildArticleSpringBackIntent.firstVisibleMsg) && Intrinsics.areEqual(this.lastVisibleMsg, guildArticleSpringBackIntent.lastVisibleMsg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int floatToIntBits = ((((Float.floatToIntBits(this.springBackDistance) * 31) + this.firstPosition) * 31) + this.lastPosition) * 31;
            com.tencent.aio.data.msglist.a aVar = this.firstVisibleMsg;
            int i3 = 0;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            int i16 = (floatToIntBits + hashCode) * 31;
            com.tencent.aio.data.msglist.a aVar2 = this.lastVisibleMsg;
            if (aVar2 != null) {
                i3 = aVar2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "GuildArticleSpringBackIntent(springBackDistance=" + this.springBackDistance + ", firstPosition=" + this.firstPosition + ", lastPosition=" + this.lastPosition + ", firstVisibleMsg=" + this.firstVisibleMsg + ", lastVisibleMsg=" + this.lastVisibleMsg + ")";
        }
    }
}
