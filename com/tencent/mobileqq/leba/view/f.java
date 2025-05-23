package com.tencent.mobileqq.leba.view;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0004\u0010\u0014\r\u000eB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J(\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/leba/view/f;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "layoutId", "", "e", "maxCount", "g", "forcePreCount", "f", "Landroid/view/View;", "c", "d", "Lcom/tencent/mobileqq/leba/view/f$d;", "a", "Lcom/tencent/mobileqq/leba/view/f$d;", "mViewCache", "Lcom/tencent/mobileqq/leba/view/f$b;", "b", "Lcom/tencent/mobileqq/leba/view/f$b;", "mLayoutInflater", "", "Ljava/lang/String;", "tag", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mViewCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b mLayoutInflater;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/leba/view/f$a;", "", "", "DEFAULT_PRELOAD_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.view.f$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/leba/view/f$b;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "layoutId", "Lcom/tencent/mobileqq/leba/view/f$c;", "callback", "", "a", "Landroid/view/View;", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a(@Nullable ViewGroup parent, int layoutId, @Nullable c callback);

        @NotNull
        View b(@Nullable ViewGroup parent, int layoutId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/leba/view/f$c;", "", "", "layoutId", "Landroid/view/View;", "view", "", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface c {
        void a(int layoutId, @Nullable View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0002H\u0002J\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007R(\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/leba/view/f$d;", "", "Ljava/util/LinkedList;", "Ljava/lang/ref/SoftReference;", "Landroid/view/View;", "views", "b", "", "layoutId", "c", "d", "view", "", "e", "a", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mViewPools", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SparseArray<LinkedList<SoftReference<View>>> mViewPools;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mViewPools = new SparseArray<>();
            }
        }

        private final View b(LinkedList<SoftReference<View>> views) {
            if (views.isEmpty()) {
                return null;
            }
            View view = views.pop().get();
            if (view == null) {
                return b(views);
            }
            return view;
        }

        @Nullable
        public final View a(int layoutId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (View) iPatchRedirector.redirect((short) 5, (Object) this, layoutId);
            }
            return b(c(layoutId));
        }

        @NotNull
        public final LinkedList<SoftReference<View>> c(int layoutId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LinkedList) iPatchRedirector.redirect((short) 2, (Object) this, layoutId);
            }
            LinkedList<SoftReference<View>> linkedList = this.mViewPools.get(layoutId);
            if (linkedList == null) {
                LinkedList<SoftReference<View>> linkedList2 = new LinkedList<>();
                this.mViewPools.put(layoutId, linkedList2);
                return linkedList2;
            }
            return linkedList;
        }

        public final int d(int layoutId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, layoutId)).intValue();
            }
            Iterator<SoftReference<View>> it = c(layoutId).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "views.iterator()");
            int i3 = 0;
            while (it.hasNext()) {
                if (it.next().get() != null) {
                    i3++;
                } else {
                    it.remove();
                }
            }
            return i3;
        }

        public final void e(int layoutId, @Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, layoutId, (Object) view);
            } else {
                if (view == null) {
                    return;
                }
                c(layoutId).offer(new SoftReference<>(view));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/leba/view/f$e", "Lcom/tencent/mobileqq/leba/view/f$c;", "", "layoutId", "Landroid/view/View;", "view", "", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.view.f.c
        public void a(int layoutId, @Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, layoutId, (Object) view);
                return;
            }
            f.this.mViewCache.e(layoutId, view);
            com.tencent.xaction.log.b.a(f.this.tag, 4, "mViewCache + 1, viewsAvailableCount:" + f.this.mViewCache.d(layoutId));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19463);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mViewCache = new d();
        this.mLayoutInflater = com.tencent.mobileqq.leba.view.b.INSTANCE.a();
        this.tag = "PreInflateHelper_" + hashCode();
    }

    private final void e(ViewGroup parent, int layoutId) {
        this.mLayoutInflater.a(parent, layoutId, new e());
    }

    @NotNull
    public final View c(@Nullable ViewGroup parent, int layoutId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, layoutId);
        }
        return d(parent, layoutId, 5);
    }

    @NotNull
    public final View d(@Nullable ViewGroup parent, int layoutId, int maxCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, parent, Integer.valueOf(layoutId), Integer.valueOf(maxCount));
        }
        View a16 = this.mViewCache.a(layoutId);
        if (a16 != null) {
            com.tencent.xaction.log.b.a(this.tag, 4, "get view from cache!");
            g(parent, layoutId, maxCount);
            return a16;
        }
        return this.mLayoutInflater.b(parent, layoutId);
    }

    public final void f(@Nullable ViewGroup parent, int layoutId, int maxCount, int forcePreCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, parent, Integer.valueOf(layoutId), Integer.valueOf(maxCount), Integer.valueOf(forcePreCount));
            return;
        }
        int d16 = this.mViewCache.d(layoutId);
        if (d16 >= maxCount) {
            return;
        }
        int i3 = maxCount - d16;
        if (forcePreCount > 0) {
            i3 = (int) Math.min(forcePreCount, i3);
        }
        com.tencent.xaction.log.b.a(this.tag, 4, "needPreloadCount:" + i3 + ", viewsAvailableCount:" + d16);
        for (int i16 = 0; i16 < i3; i16++) {
            e(parent, layoutId);
        }
    }

    public final void g(@Nullable ViewGroup parent, int layoutId, int maxCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, parent, Integer.valueOf(layoutId), Integer.valueOf(maxCount));
        } else {
            f(parent, layoutId, maxCount, 1);
        }
    }
}
