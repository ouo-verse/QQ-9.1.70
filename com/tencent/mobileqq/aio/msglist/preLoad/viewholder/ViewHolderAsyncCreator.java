package com.tencent.mobileqq.aio.msglist.preLoad.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0015\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00130\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/preLoad/viewholder/ViewHolderAsyncCreator;", "", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "e", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Ljava/lang/ref/WeakReference;", "recycleViewRef", "", "viewHolderType", "d", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Ljava/lang/ref/WeakReference;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "Lkotlin/Pair;", "createCollection", "c", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ViewHolderAsyncCreator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ViewHolderAsyncCreator f192687a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f192687a = new ViewHolderAsyncCreator();
        }
    }

    ViewHolderAsyncCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(RecyclerView.RecycledViewPool recycledViewPool, WeakReference<RecyclerView> weakReference, int i3, Continuation<? super RecyclerView.ViewHolder> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ViewHolderAsyncCreator$createViewHolder$2(weakReference, i3, recycledViewPool, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ViewHolderAsyncCreator$putViewHolder$2(recyclerView, viewHolder, null), continuation);
    }

    public final void c(@NotNull RecyclerView recyclerView, @NotNull CoroutineScope scope, @NotNull List<Pair<Integer, Integer>> createCollection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, recyclerView, scope, createCollection);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(createCollection, "createCollection");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ViewHolderAsyncCreator$create$1(recyclerView, createCollection, null), 3, null);
    }
}
