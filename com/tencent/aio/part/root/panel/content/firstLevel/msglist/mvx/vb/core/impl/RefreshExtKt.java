package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\"\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0000\u001a\"\u0010\n\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0007*\u00020\u0000H\u0000\u001a\f\u0010\f\u001a\u00020\u0004*\u00020\u0000H\u0000\u001a\f\u0010\r\u001a\u00020\u0004*\u00020\u0000H\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "refreshType", "Lkotlin/Function0;", "", "invoke", "d", "", "b", "loadMoreType", "c", "a", "f", "e", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class RefreshExtKt {
    public static final boolean a(@NotNull AIORefreshImpl checkReadyFinishLoadMoreFinish) {
        Intrinsics.checkNotNullParameter(checkReadyFinishLoadMoreFinish, "$this$checkReadyFinishLoadMoreFinish");
        if (!checkReadyFinishLoadMoreFinish.J()) {
            return false;
        }
        checkReadyFinishLoadMoreFinish.R(false);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("RefreshExt", "deal isReadyLoadMoreFinish action");
        }
        checkReadyFinishLoadMoreFinish.B();
        e(checkReadyFinishLoadMoreFinish);
        return true;
    }

    public static final boolean b(@NotNull AIORefreshImpl checkReadyRefreshFinish) {
        Intrinsics.checkNotNullParameter(checkReadyRefreshFinish, "$this$checkReadyRefreshFinish");
        if (!checkReadyRefreshFinish.K()) {
            return false;
        }
        checkReadyRefreshFinish.S(false);
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("RefreshExt", "deal isReadyRefreshFinish action");
        }
        checkReadyRefreshFinish.C();
        f(checkReadyRefreshFinish);
        return true;
    }

    public static final void c(@NotNull final AIORefreshImpl checkRealLoadMore, @NotNull final RefreshType loadMoreType, @NotNull final Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(checkRealLoadMore, "$this$checkRealLoadMore");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        e.a(loadMoreType, new Function0<Unit>(loadMoreType, invoke) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.RefreshExtKt$checkRealLoadMore$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0 $invoke;
            final /* synthetic */ RefreshType $loadMoreType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$loadMoreType = loadMoreType;
                this.$invoke = invoke;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, AIORefreshImpl.this, loadMoreType, invoke);
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
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                if ((this.$loadMoreType == RefreshType.LoadingLoadMore && RefreshExtKt.a(AIORefreshImpl.this)) || AIORefreshImpl.this.I()) {
                    return;
                }
                AIORefreshImpl.this.P(this.$loadMoreType);
                AIORefreshImpl.this.Q(true);
                this.$invoke.invoke();
            }
        });
    }

    public static final void d(@NotNull final AIORefreshImpl checkRealRefresh, @NotNull final RefreshType refreshType, @NotNull final Function0<Unit> invoke) {
        Intrinsics.checkNotNullParameter(checkRealRefresh, "$this$checkRealRefresh");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        e.a(refreshType, new Function0<Unit>(refreshType, invoke) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.RefreshExtKt$checkRealRefresh$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0 $invoke;
            final /* synthetic */ RefreshType $refreshType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$refreshType = refreshType;
                this.$invoke = invoke;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, AIORefreshImpl.this, refreshType, invoke);
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
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                if ((this.$refreshType == RefreshType.LoadingRefresh && RefreshExtKt.b(AIORefreshImpl.this)) || AIORefreshImpl.this.L()) {
                    return;
                }
                AIORefreshImpl.this.V(this.$refreshType);
                AIORefreshImpl.this.W(true);
                this.$invoke.invoke();
            }
        });
    }

    public static final void e(@NotNull AIORefreshImpl resetLoadMoreState) {
        Intrinsics.checkNotNullParameter(resetLoadMoreState, "$this$resetLoadMoreState");
        resetLoadMoreState.P(RefreshType.RefreshInit);
        resetLoadMoreState.Q(false);
        resetLoadMoreState.T(null);
    }

    public static final void f(@NotNull AIORefreshImpl resetRefreshState) {
        Intrinsics.checkNotNullParameter(resetRefreshState, "$this$resetRefreshState");
        resetRefreshState.V(RefreshType.RefreshInit);
        resetRefreshState.W(false);
        resetRefreshState.U(null);
    }
}
