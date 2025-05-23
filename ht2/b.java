package ht2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lht2/b;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "d", "e", "Lht2/b$a;", "Lht2/b$b;", "Lht2/b$c;", "Lht2/b$d;", "Lht2/b$e;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class b implements com.tencent.qqnt.base.mvi.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lht2/b$a;", "Lht2/b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f406237a = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lht2/b$b;", "Lht2/b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ht2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C10474b extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C10474b f406238a = new C10474b();

        C10474b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lht2/b$c;", "Lht2/b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f406239a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lht2/b$d;", "Lht2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "guildId", "<init>", "(J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ht2.b$d, reason: from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class UnBindGuild extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long guildId;

        public UnBindGuild(long j3) {
            super(null);
            this.guildId = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UnBindGuild) && this.guildId == ((UnBindGuild) other).guildId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.guildId);
        }

        @NotNull
        public String toString() {
            return "UnBindGuild(guildId=" + this.guildId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lht2/b$e;", "Lht2/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "<init>", "(Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ht2.b$e, reason: from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class UpdateSwitch extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOpen;

        public UpdateSwitch(boolean z16) {
            super(null);
            this.isOpen = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateSwitch) && this.isOpen == ((UpdateSwitch) other).isOpen) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isOpen;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "UpdateSwitch(isOpen=" + this.isOpen + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
