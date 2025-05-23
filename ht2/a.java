package ht2;

import com.tencent.qqnt.kernel.nativeinterface.BindGuildInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lht2/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "Lht2/a$a;", "Lht2/a$b;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lht2/a$a;", "Lht2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/qqnt/kernel/nativeinterface/BindGuildInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", "guildList", "b", "Z", "()Z", "hasMore", "c", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "<init>", "(Ljava/util/List;ZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ht2.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class BindGuildListUpdated extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<BindGuildInfo> guildList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hasMore;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOpen;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BindGuildListUpdated(@NotNull List<BindGuildInfo> guildList, boolean z16, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(guildList, "guildList");
            this.guildList = guildList;
            this.hasMore = z16;
            this.isOpen = z17;
        }

        @NotNull
        public final List<BindGuildInfo> a() {
            return this.guildList;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BindGuildListUpdated)) {
                return false;
            }
            BindGuildListUpdated bindGuildListUpdated = (BindGuildListUpdated) other;
            if (Intrinsics.areEqual(this.guildList, bindGuildListUpdated.guildList) && this.hasMore == bindGuildListUpdated.hasMore && this.isOpen == bindGuildListUpdated.isOpen) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.guildList.hashCode() * 31;
            boolean z16 = this.hasMore;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isOpen;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "BindGuildListUpdated(guildList=" + this.guildList + ", hasMore=" + this.hasMore + ", isOpen=" + this.isOpen + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lht2/a$b;", "Lht2/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "<init>", "(Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ht2.a$b, reason: from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class BindGuildSwitchInitialized extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOpen;

        public BindGuildSwitchInitialized(boolean z16) {
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
            if ((other instanceof BindGuildSwitchInitialized) && this.isOpen == ((BindGuildSwitchInitialized) other).isOpen) {
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
            return "BindGuildSwitchInitialized(isOpen=" + this.isOpen + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
