package com.tencent.qqnt.chathistory.ui.file.c2c.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "Lcom/tencent/qqnt/base/mvi/b;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$b;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$c;", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$a;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "subTypeFilter", "I", "()I", "requestCont", "<init>", "(Ljava/util/List;I)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final /* data */ class C9533a extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> subTypeFilter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int requestCont;

        public C9533a() {
            this(null, 0, 3, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.requestCont;
        }

        @NotNull
        public final List<Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.subTypeFilter;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9533a)) {
                return false;
            }
            C9533a c9533a = (C9533a) other;
            if (Intrinsics.areEqual(this.subTypeFilter, c9533a.subTypeFilter) && this.requestCont == c9533a.requestCont) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.subTypeFilter.hashCode() * 31) + this.requestCont;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "FetchFileIntent(subTypeFilter=" + this.subTypeFilter + ", requestCont=" + this.requestCont + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9533a(@NotNull List<Integer> subTypeFilter, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(subTypeFilter, "subTypeFilter");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) subTypeFilter, i3);
            } else {
                this.subTypeFilter = subTypeFilter;
                this.requestCont = i3;
            }
        }

        public /* synthetic */ C9533a(List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 2) != 0 ? ExtensionsKt.m(1) : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$c;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f353568a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45341);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f353568a = new c();
            }
        }

        c() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0010\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a$b;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "lastMsgId", "b", "lastMsgSeq", "c", "lastMsgTime", "", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", "subTypeFilter", "I", "()I", "requestCont", "<init>", "(JJJLjava/util/List;I)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgSeq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long lastMsgTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> subTypeFilter;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int requestCont;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ b(long j3, long j16, long j17, List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, j16, j17, r8, (i16 & 16) != 0 ? ExtensionsKt.q() : i3);
            List list2;
            List emptyList;
            if ((i16 & 8) != 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list2 = emptyList;
            } else {
                list2 = list;
            }
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), list, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.lastMsgId;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.lastMsgSeq;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.lastMsgTime;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.requestCont;
        }

        @NotNull
        public final List<Integer> e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.subTypeFilter;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.lastMsgId == bVar.lastMsgId && this.lastMsgSeq == bVar.lastMsgSeq && this.lastMsgTime == bVar.lastMsgTime && Intrinsics.areEqual(this.subTypeFilter, bVar.subTypeFilter) && this.requestCont == bVar.requestCont) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return (((((((androidx.fragment.app.a.a(this.lastMsgId) * 31) + androidx.fragment.app.a.a(this.lastMsgSeq)) * 31) + androidx.fragment.app.a.a(this.lastMsgTime)) * 31) + this.subTypeFilter.hashCode()) * 31) + this.requestCont;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "FetchMoreFileIntent(lastMsgId=" + this.lastMsgId + ", lastMsgSeq=" + this.lastMsgSeq + ", lastMsgTime=" + this.lastMsgTime + ", subTypeFilter=" + this.subTypeFilter + ", requestCont=" + this.requestCont + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j3, long j16, long j17, @NotNull List<Integer> subTypeFilter, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(subTypeFilter, "subTypeFilter");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), subTypeFilter, Integer.valueOf(i3));
                return;
            }
            this.lastMsgId = j3;
            this.lastMsgSeq = j16;
            this.lastMsgTime = j17;
            this.subTypeFilter = subTypeFilter;
            this.requestCont = i3;
        }
    }
}
