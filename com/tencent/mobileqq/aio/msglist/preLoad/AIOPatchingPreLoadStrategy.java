package com.tencent.mobileqq.aio.msglist.preLoad;

import android.view.View;
import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/preLoad/AIOPatchingPreLoadStrategy;", "Lcom/tencent/mobileqq/aio/msglist/preLoad/AIOPreLoadStrategy;", "", "f", "l", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "d", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "aioCompleteFetcher", "<init>", "(Lcom/tencent/aio/api/list/IListUIOperationApi;Lkotlin/jvm/functions/Function0;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPatchingPreLoadStrategy extends AIOPreLoadStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f192681f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IListUIOperationApi listUIOperationApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Boolean> aioCompleteFetcher;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/preLoad/AIOPatchingPreLoadStrategy$a;", "", "", "TAG", "Ljava/lang/String;", "", "threshold", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f192681f = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOPatchingPreLoadStrategy(@NotNull IListUIOperationApi listUIOperationApi, @NotNull Function0<Boolean> aioCompleteFetcher) {
        super(listUIOperationApi);
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        Intrinsics.checkNotNullParameter(aioCompleteFetcher, "aioCompleteFetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listUIOperationApi, (Object) aioCompleteFetcher);
        } else {
            this.listUIOperationApi = listUIOperationApi;
            this.aioCompleteFetcher = aioCompleteFetcher;
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.f();
            l();
        }
    }

    public final void l() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        final AIORecycleView i3 = this.listUIOperationApi.i();
        if (i3.getChildCount() == 0 || i3.isLayoutSuppressed() || !this.aioCompleteFetcher.invoke().booleanValue()) {
            return;
        }
        View findViewByPosition = i3.getLayoutManager().findViewByPosition(i3.getLayoutManager().findLastVisibleItemPosition());
        if (findViewByPosition != null) {
            num = Integer.valueOf(findViewByPosition.getBottom());
        } else {
            num = null;
        }
        if (num != null && findViewByPosition.getBottom() < i3.getMeasuredHeight() - i3.getPaddingBottom()) {
            return;
        }
        b(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPatchingPreLoadStrategy$replenishPre$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOPatchingPreLoadStrategy this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORecycleView.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int computeVerticalScrollRange = AIORecycleView.this.computeVerticalScrollRange();
                int computeVerticalScrollExtent = AIORecycleView.this.computeVerticalScrollExtent();
                int computeVerticalScrollOffset = AIORecycleView.this.computeVerticalScrollOffset();
                int i16 = (computeVerticalScrollRange - computeVerticalScrollOffset) - computeVerticalScrollExtent;
                int i17 = computeVerticalScrollExtent * 4;
                AIOPatchingPreLoadStrategy aIOPatchingPreLoadStrategy = this.this$0;
                aIOPatchingPreLoadStrategy.c(new Function0<Unit>(computeVerticalScrollOffset, i17, aIOPatchingPreLoadStrategy) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPatchingPreLoadStrategy$replenishPre$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $limit;
                    final /* synthetic */ int $verticalOffset;
                    final /* synthetic */ AIOPatchingPreLoadStrategy this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$verticalOffset = computeVerticalScrollOffset;
                        this.$limit = i17;
                        this.this$0 = aIOPatchingPreLoadStrategy;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, Integer.valueOf(computeVerticalScrollOffset), Integer.valueOf(i17), aIOPatchingPreLoadStrategy);
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
                        } else if (this.$verticalOffset < this.$limit) {
                            this.this$0.e();
                            if (QLog.isColorLevel()) {
                                QLog.d("AIOPreLoadStrategy", 1, "dispatchOnRefresh");
                            }
                        }
                    }
                });
                AIOPatchingPreLoadStrategy aIOPatchingPreLoadStrategy2 = this.this$0;
                aIOPatchingPreLoadStrategy2.a(new Function0<Unit>(i16, i17, aIOPatchingPreLoadStrategy2) { // from class: com.tencent.mobileqq.aio.msglist.preLoad.AIOPatchingPreLoadStrategy$replenishPre$1.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $bottomDistance;
                    final /* synthetic */ int $limit;
                    final /* synthetic */ AIOPatchingPreLoadStrategy this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$bottomDistance = i16;
                        this.$limit = i17;
                        this.this$0 = aIOPatchingPreLoadStrategy2;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, Integer.valueOf(i16), Integer.valueOf(i17), aIOPatchingPreLoadStrategy2);
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
                        } else if (this.$bottomDistance < this.$limit) {
                            this.this$0.d();
                            if (QLog.isColorLevel()) {
                                QLog.d("AIOPreLoadStrategy", 1, "dispatchOnLoadMore");
                            }
                        }
                    }
                });
            }
        });
    }
}
