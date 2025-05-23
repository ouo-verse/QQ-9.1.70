package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u0003\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0017J\u001b\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/ListNotifyImpl;", "Lcom/tencent/aio/api/list/d;", "Lcom/tencent/aio/api/list/c;", "Lkotlin/Function0;", "", "notify", "c", "", "f", "", "positionStart", "itemCount", "d", "", "payload", "u", h.F, "e", "fromPosition", "toPosition", "v", "notifyDataSetChanged", "Landroid/view/View;", "view", "index", "B", "K", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/jvm/functions/Function0;", "getScopeOwner", "()Lkotlin/jvm/functions/Function0;", "scopeOwner", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/a;Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ListNotifyImpl implements com.tencent.aio.api.list.d, com.tencent.aio.api.list.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a adapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<CoroutineScope> scopeOwner;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.footer.a f69596h;

    /* JADX WARN: Multi-variable type inference failed */
    public ListNotifyImpl(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a adapter, @NotNull RecyclerView recyclerView, @NotNull Function0<? extends CoroutineScope> scopeOwner) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, adapter, recyclerView, scopeOwner);
            return;
        }
        this.f69596h = adapter.k0();
        this.adapter = adapter;
        this.recyclerView = recyclerView;
        this.scopeOwner = scopeOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final Function0<Unit> notify) {
        if (f()) {
            this.recyclerView.post(new Runnable(notify) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$innerNotify$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function0 f69597d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f69597d = notify;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) ListNotifyImpl.this, (Object) notify);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        ListNotifyImpl.this.c(this.f69597d);
                    } else {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }
            });
        } else {
            notify.invoke();
        }
    }

    private final boolean f() {
        return this.recyclerView.isComputingLayout();
    }

    @Override // com.tencent.aio.api.list.c
    public void B(@NotNull View view, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, index);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69596h.B(view, index);
        }
    }

    @Override // com.tencent.aio.api.list.c
    public void K(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69596h.K(view);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void d(final int positionStart, final int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            c(new Function0<Unit>(positionStart, itemCount) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyItemRangeChanged$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $itemCount;
                final /* synthetic */ int $positionStart;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$positionStart = positionStart;
                    this.$itemCount = itemCount;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, ListNotifyImpl.this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    aVar = ListNotifyImpl.this.adapter;
                    int i3 = this.$positionStart;
                    aVar2 = ListNotifyImpl.this.adapter;
                    aVar.notifyItemRangeChanged(i3 + aVar2.n0(), this.$itemCount);
                }
            });
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void e(final int positionStart, final int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            c(new Function0<Unit>(positionStart, itemCount) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyItemRangeRemoved$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $itemCount;
                final /* synthetic */ int $positionStart;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$positionStart = positionStart;
                    this.$itemCount = itemCount;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, ListNotifyImpl.this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    aVar = ListNotifyImpl.this.adapter;
                    int i3 = this.$positionStart;
                    aVar2 = ListNotifyImpl.this.adapter;
                    aVar.notifyItemRangeRemoved(i3 + aVar2.n0(), this.$itemCount);
                }
            });
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void h(final int positionStart, final int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            c(new Function0<Unit>(positionStart, itemCount) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyItemRangeInserted$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $itemCount;
                final /* synthetic */ int $positionStart;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$positionStart = positionStart;
                    this.$itemCount = itemCount;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, ListNotifyImpl.this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    aVar = ListNotifyImpl.this.adapter;
                    int i3 = this.$positionStart;
                    aVar2 = ListNotifyImpl.this.adapter;
                    aVar.notifyItemRangeInserted(i3 + aVar2.n0(), this.$itemCount);
                }
            });
        }
    }

    @Override // com.tencent.aio.api.list.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            c(new Function0<Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyDataSetChanged$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) ListNotifyImpl.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    } else {
                        aVar = ListNotifyImpl.this.adapter;
                        aVar.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void u(final int positionStart, final int itemCount, @Nullable final Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount), payload);
        } else {
            c(new Function0<Unit>(positionStart, itemCount, payload) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyItemRangeChanged$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $itemCount;
                final /* synthetic */ Object $payload;
                final /* synthetic */ int $positionStart;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$positionStart = positionStart;
                    this.$itemCount = itemCount;
                    this.$payload = payload;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, ListNotifyImpl.this, Integer.valueOf(positionStart), Integer.valueOf(itemCount), payload);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    aVar = ListNotifyImpl.this.adapter;
                    int i3 = this.$positionStart;
                    aVar2 = ListNotifyImpl.this.adapter;
                    aVar.notifyItemRangeChanged(i3 + aVar2.n0(), this.$itemCount, this.$payload);
                }
            });
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void v(final int fromPosition, final int toPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
        } else {
            c(new Function0<Unit>(fromPosition, toPosition) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl$notifyItemMoved$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $fromPosition;
                final /* synthetic */ int $toPosition;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$fromPosition = fromPosition;
                    this.$toPosition = toPosition;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, ListNotifyImpl.this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar2;
                    com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    aVar = ListNotifyImpl.this.adapter;
                    int i3 = this.$fromPosition;
                    aVar2 = ListNotifyImpl.this.adapter;
                    int n06 = i3 + aVar2.n0();
                    int i16 = this.$toPosition;
                    aVar3 = ListNotifyImpl.this.adapter;
                    aVar.notifyItemMoved(n06, i16 + aVar3.n0());
                }
            });
        }
    }
}
