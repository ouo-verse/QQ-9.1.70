package com.tencent.mobileqq.aio.msglist.preLoad;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0010\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/preLoad/AIOPreLoadStrategy;", "Lcom/tencent/aio/api/refreshLoad/a;", "Landroidx/recyclerview/widget/RecyclerView;", "aioRecycleView", "", "j", "k", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "b", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "<init>", "(Lcom/tencent/aio/api/list/IListUIOperationApi;)V", "c", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOPreLoadStrategy extends com.tencent.aio.api.refreshLoad.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f192684c;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IListUIOperationApi listUIOperationApi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/preLoad/AIOPreLoadStrategy$a;", "", "", "TAG", "Ljava/lang/String;", "", "threshold", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f192684c = new a(null);
        }
    }

    public AIOPreLoadStrategy(@NotNull IListUIOperationApi listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listUIOperationApi);
        } else {
            this.listUIOperationApi = listUIOperationApi;
            listUIOperationApi.i().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPreLoadStrategy.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOPreLoadStrategy.this);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull final RecyclerView recyclerView, int dx5, final int dy5) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, dx5, dy5);
                    final AIOPreLoadStrategy aIOPreLoadStrategy = AIOPreLoadStrategy.this;
                    aIOPreLoadStrategy.b(new Function0<Unit>(dy5, recyclerView, aIOPreLoadStrategy) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPreLoadStrategy$1$onScrolled$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int $dy;
                        final /* synthetic */ RecyclerView $recyclerView;
                        final /* synthetic */ AIOPreLoadStrategy this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$dy = dy5;
                            this.$recyclerView = recyclerView;
                            this.this$0 = aIOPreLoadStrategy;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, Integer.valueOf(dy5), recyclerView, aIOPreLoadStrategy);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            int i3 = this.$dy;
                            if (i3 < 0 && this.$recyclerView.canScrollVertically(i3)) {
                                this.this$0.k(this.$recyclerView);
                                return;
                            }
                            int i16 = this.$dy;
                            if (i16 <= 0 || !this.$recyclerView.canScrollVertically(i16)) {
                                return;
                            }
                            this.this$0.j(this.$recyclerView);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final RecyclerView aioRecycleView) {
        a(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPreLoadStrategy$autoLoadMore$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOPreLoadStrategy this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerView.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int computeVerticalScrollOffset = RecyclerView.this.computeVerticalScrollOffset();
                int computeVerticalScrollRange = RecyclerView.this.computeVerticalScrollRange();
                int computeVerticalScrollExtent = RecyclerView.this.computeVerticalScrollExtent();
                if ((computeVerticalScrollRange - computeVerticalScrollOffset) - computeVerticalScrollExtent <= computeVerticalScrollExtent * 4) {
                    this.this$0.d();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final RecyclerView aioRecycleView) {
        c(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPreLoadStrategy$autoUpFetch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOPreLoadStrategy this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerView.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (RecyclerView.this.computeVerticalScrollOffset() <= RecyclerView.this.computeVerticalScrollExtent() * 4) {
                    this.this$0.e();
                }
            }
        });
    }
}
