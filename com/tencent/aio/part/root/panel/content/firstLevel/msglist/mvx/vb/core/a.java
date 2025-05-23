package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J<\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/a;", "", "", "id", "", "Lkotlin/Pair;", "maxSize", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "preCreate", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "poolMap", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, RecyclerView.RecycledViewPool> poolMap;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f69578b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/a$a", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0641a extends RecyclerView.RecycledViewPool {
        static IPatchRedirector $redirector_;

        C0641a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f69578b = new a();
            poolMap = new HashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public final RecyclerView.RecycledViewPool a(int id5, @NotNull List<Pair<Integer, Integer>> maxSize, @NotNull Function1<? super RecyclerView.RecycledViewPool, Unit> preCreate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (RecyclerView.RecycledViewPool) iPatchRedirector.redirect((short) 1, this, Integer.valueOf(id5), maxSize, preCreate);
        }
        Intrinsics.checkNotNullParameter(maxSize, "maxSize");
        Intrinsics.checkNotNullParameter(preCreate, "preCreate");
        HashMap<Integer, RecyclerView.RecycledViewPool> hashMap = poolMap;
        Integer valueOf = Integer.valueOf(id5);
        RecyclerView.RecycledViewPool recycledViewPool = hashMap.get(valueOf);
        if (recycledViewPool == null) {
            recycledViewPool = new C0641a();
            Iterator<T> it = maxSize.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                recycledViewPool.setMaxRecycledViews(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
            }
            preCreate.invoke(recycledViewPool);
            hashMap.put(valueOf, recycledViewPool);
        }
        return recycledViewPool;
    }
}
