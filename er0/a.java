package er0;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Ler0/a;", "", "Ljava/util/ArrayList;", "Ler0/a$a;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "navigationInfoList", "", "J", "()J", "d", "(J)V", "firstUnreadSeq", "c", "e", "unreadCount", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<C10261a> navigationInfoList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long firstUnreadSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long unreadCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ler0/a$a;", "", "other", "", "equals", "", "toString", "", "a", "J", "()J", "msgSeq", "", "b", "I", "()I", "type", "<init>", "(JI)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: er0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C10261a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public C10261a(long j3, int i3) {
            this.msgSeq = j3;
            this.type = i3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            C10261a c10261a = (C10261a) other;
            if (c10261a != null && c10261a.msgSeq == this.msgSeq && c10261a.type == this.type) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "GuildAioNavigateInfo{ msgSeq = " + this.msgSeq + ", type = " + this.type + "}";
        }
    }

    /* renamed from: a, reason: from getter */
    public final long getFirstUnreadSeq() {
        return this.firstUnreadSeq;
    }

    @NotNull
    public final ArrayList<C10261a> b() {
        return this.navigationInfoList;
    }

    /* renamed from: c, reason: from getter */
    public final long getUnreadCount() {
        return this.unreadCount;
    }

    public final void d(long j3) {
        this.firstUnreadSeq = j3;
    }

    public final void e(long j3) {
        this.unreadCount = j3;
    }
}
