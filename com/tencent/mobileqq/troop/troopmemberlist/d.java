package com.tencent.mobileqq.troop.troopmemberlist;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u000b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\r\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlist/d;", "", "", "Lcom/tencent/mobileqq/troop/troopmemberlist/a;", "data", "", "positive", "", "d", "j", "c", "e", h.F, "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f300628a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Long l3;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            TroopMemberInfo f16 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).f();
            Long l16 = null;
            if (f16 != null) {
                l3 = Long.valueOf(f16.last_active_time);
            } else {
                l3 = null;
            }
            TroopMemberInfo f17 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).f();
            if (f17 != null) {
                l16 = Long.valueOf(f17.last_active_time);
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(l3, l16);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Long l3;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            TroopMemberInfo f16 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).f();
            Long l16 = null;
            if (f16 != null) {
                l3 = Long.valueOf(f16.last_active_time);
            } else {
                l3 = null;
            }
            TroopMemberInfo f17 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).f();
            if (f17 != null) {
                l16 = Long.valueOf(f17.last_active_time);
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(l3, l16);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Long l3;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            TroopMemberInfo f16 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).f();
            Long l16 = null;
            if (f16 != null) {
                l3 = Long.valueOf(f16.join_time);
            } else {
                l3 = null;
            }
            TroopMemberInfo f17 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).f();
            if (f17 != null) {
                l16 = Long.valueOf(f17.join_time);
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(l3, l16);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.troopmemberlist.d$d, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8821d<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public C8821d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Long l3;
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            TroopMemberInfo f16 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).f();
            Long l16 = null;
            if (f16 != null) {
                l3 = Long.valueOf(f16.join_time);
            } else {
                l3 = null;
            }
            TroopMemberInfo f17 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).f();
            if (f17 != null) {
                l16 = Long.valueOf(f17.join_time);
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(l3, l16);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class e<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            String lowerCase = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).i().getShowNamePyFirst().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).i().getShowNamePyFirst().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(lowerCase, lowerCase2);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class f<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            String lowerCase = ((com.tencent.mobileqq.troop.troopmemberlist.a) t17).i().getShowNamePyFirst().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = ((com.tencent.mobileqq.troop.troopmemberlist.a) t16).i().getShowNamePyFirst().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(lowerCase, lowerCase2);
            return compareValues;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f300628a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(boolean z16, com.tencent.mobileqq.troop.troopmemberlist.a aVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar2) {
        int compare;
        if (aVar.h() == aVar2.h()) {
            compare = aVar.i().getShowNamePyFirst().compareTo(aVar2.i().getShowNamePyFirst());
        } else {
            compare = Intrinsics.compare(aVar.h(), aVar2.h());
        }
        if (!z16) {
            return compare * (-1);
        }
        return compare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(boolean z16, com.tencent.mobileqq.troop.troopmemberlist.a aVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar2) {
        Integer num;
        int i3;
        int compare;
        TroopMemberInfo f16 = aVar.f();
        Integer num2 = null;
        if (f16 != null) {
            num = Integer.valueOf(f16.realLevel);
        } else {
            num = null;
        }
        TroopMemberInfo f17 = aVar2.f();
        if (f17 != null) {
            num2 = Integer.valueOf(f17.realLevel);
        }
        if (Intrinsics.areEqual(num, num2)) {
            compare = aVar.i().getShowNamePyFirst().compareTo(aVar2.i().getShowNamePyFirst());
        } else {
            TroopMemberInfo f18 = aVar.f();
            int i16 = 0;
            if (f18 != null) {
                i3 = f18.realLevel;
            } else {
                i3 = 0;
            }
            TroopMemberInfo f19 = aVar2.f();
            if (f19 != null) {
                i16 = f19.realLevel;
            }
            compare = Intrinsics.compare(i3, i16);
        }
        if (!z16) {
            return compare * (-1);
        }
        return compare;
    }

    public final void c(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Boolean.valueOf(positive));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (positive) {
            if (data.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new a());
            }
        } else if (data.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new b());
        }
    }

    public final void d(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, data, Boolean.valueOf(positive));
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            j(data, positive);
        }
    }

    public final void e(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, data, Boolean.valueOf(positive));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (positive) {
            if (data.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new c());
            }
        } else if (data.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new C8821d());
        }
    }

    public final void f(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, final boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, data, Boolean.valueOf(positive));
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new Comparator() { // from class: com.tencent.mobileqq.troop.troopmemberlist.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g16;
                    g16 = d.g(positive, (a) obj, (a) obj2);
                    return g16;
                }
            });
        }
    }

    public final void h(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, final boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, data, Boolean.valueOf(positive));
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new Comparator() { // from class: com.tencent.mobileqq.troop.troopmemberlist.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i3;
                    i3 = d.i(positive, (a) obj, (a) obj2);
                    return i3;
                }
            });
        }
    }

    public final void j(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, boolean positive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, data, Boolean.valueOf(positive));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (positive) {
            if (data.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new e());
            }
        } else if (data.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(data, new f());
        }
    }
}
