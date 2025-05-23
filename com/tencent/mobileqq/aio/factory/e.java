package com.tencent.mobileqq.aio.factory;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.AIORecyclePoolFactory;
import com.tencent.aio.api.list.i;
import com.tencent.aio.api.list.k;
import com.tencent.mobileqq.aio.msglist.AIOMsgItemFactoryProvider;
import com.tencent.mobileqq.aio.msglist.preLoad.viewholder.ViewHolderAsyncCreator;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\n\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/e;", "Lcom/tencent/aio/api/list/i;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "subViewType", "Lcom/tencent/aio/api/list/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "Lcom/tencent/aio/api/list/k;", "c", "Lcom/tencent/mobileqq/aio/msglist/x;", "Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/x;)V", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f188789b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x factoryProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

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
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/aio/factory/e$b", "Lcom/tencent/aio/api/list/k;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/Fragment;", "hostFragment", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "recycledViewPool", "Landroidx/recyclerview/widget/AIORecycleView;", "aioRecycleView", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements k {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.list.k
        public void a(@NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull AIORecycleView aioRecycleView, @NotNull CoroutineScope scope) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recycledViewPool, aioRecycleView, scope);
                return;
            }
            Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
            Intrinsics.checkNotNullParameter(aioRecycleView, "aioRecycleView");
            Intrinsics.checkNotNullParameter(scope, "scope");
            QLog.d("ItemCellFactory", 1, "preCreateViewHolder----start-----");
            ViewHolderAsyncCreator.f192687a.c(aioRecycleView, scope, com.tencent.mobileqq.aio.msglist.b.f190447a.c());
        }

        @Override // com.tencent.aio.api.list.k
        @Nullable
        public RecyclerView.RecycledViewPool b(@NotNull Context context, @NotNull Fragment hostFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.RecycledViewPool) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) hostFragment);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
            RecyclerView.RecycledViewPool b16 = AIORecyclePoolFactory.f69112b.b(new AIORecyclePoolFactory.a(hostFragment));
            Iterator<T> it = com.tencent.mobileqq.aio.msglist.b.f190447a.b().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                b16.setMaxRecycledViews(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
            }
            return b16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f188789b = new a(null);
        }
    }

    public e() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.aio.api.list.i
    @NotNull
    public com.tencent.aio.api.list.a<? extends ol3.b, ? extends MviUIState> a(@NotNull ViewGroup parent, int viewType, int subViewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.list.a) iPatchRedirector.redirect((short) 3, this, parent, Integer.valueOf(viewType), Integer.valueOf(subViewType));
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        boolean T = MsgExtKt.T(viewType);
        com.tencent.mobileqq.aio.msglist.holder.i a16 = this.factoryProvider.a(viewType);
        Intrinsics.checkNotNull(a16);
        return a16.b(parent, T, viewType, subViewType, this.factoryProvider);
    }

    @Override // com.tencent.aio.api.list.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return i.a.a(this);
    }

    @Override // com.tencent.aio.api.list.f
    @Nullable
    public k c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (k) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    public e(@NotNull x factoryProvider) {
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.factoryProvider = factoryProvider;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) factoryProvider);
        }
    }

    public /* synthetic */ e(x xVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AIOMsgItemFactoryProvider.f190341a : xVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, xVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
