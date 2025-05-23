package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B%\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020 \u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\t\u0010\r\u001a\u00020\u0003H\u0096\u0002R\"\u0010\u0014\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "Lkotlin/Function0;", "", "c0", "d0", "", "e0", "enable", "H", "Lcom/tencent/aio/api/refreshLoad/a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "y", "g0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "f0", "()Z", "setEnablePreLoad$sdk_debug", "(Z)V", "enablePreLoad", "", BdhLogUtil.LogTag.Tag_Req, "I", "threshold", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/api/refreshLoad/a;", "preLoadStrategy", "Landroidx/recyclerview/widget/AIORecycleView;", "T", "Landroidx/recyclerview/widget/AIORecycleView;", "aioRecycleView", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;", "refreshHolder", "Lkotlinx/coroutines/CoroutineScope;", "scopeOwner", "<init>", "(Landroidx/recyclerview/widget/AIORecycleView;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;Lkotlin/jvm/functions/Function0;)V", "U", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class PreLoadRefreshImpl extends AIORefreshImpl implements Function0<Unit> {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean enablePreLoad;

    /* renamed from: R, reason: from kotlin metadata */
    private int threshold;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.aio.api.refreshLoad.a preLoadStrategy;

    /* renamed from: T, reason: from kotlin metadata */
    private final AIORecycleView aioRecycleView;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PreLoadRefreshImpl.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (PreLoadRefreshImpl.this.e0()) {
                return;
            }
            if (PreLoadRefreshImpl.this.f0()) {
                aVar = this;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                if (dy5 < 0 && recyclerView.canScrollVertically(dy5)) {
                    PreLoadRefreshImpl.this.d0();
                } else if (dy5 > 0 && recyclerView.canScrollVertically(dy5)) {
                    PreLoadRefreshImpl.this.c0();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/PreLoadRefreshImpl$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.PreLoadRefreshImpl$b, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreLoadRefreshImpl(@NotNull AIORecycleView aioRecycleView, @NotNull b refreshHolder, @NotNull Function0<? extends CoroutineScope> scopeOwner) {
        super(aioRecycleView, refreshHolder, scopeOwner);
        Intrinsics.checkNotNullParameter(aioRecycleView, "aioRecycleView");
        Intrinsics.checkNotNullParameter(refreshHolder, "refreshHolder");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, aioRecycleView, refreshHolder, scopeOwner);
            return;
        }
        this.aioRecycleView = aioRecycleView;
        this.enablePreLoad = true;
        this.threshold = 4;
        aioRecycleView.getLayoutManager().addLayoutCompleteListener(this);
        aioRecycleView.addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        r(new Function0<Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.PreLoadRefreshImpl$autoLoadMore$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) PreLoadRefreshImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AIORecycleView aIORecycleView;
                AIORecycleView aIORecycleView2;
                AIORecycleView aIORecycleView3;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                aIORecycleView = PreLoadRefreshImpl.this.aioRecycleView;
                int computeVerticalScrollOffset = aIORecycleView.computeVerticalScrollOffset();
                aIORecycleView2 = PreLoadRefreshImpl.this.aioRecycleView;
                int computeVerticalScrollRange = aIORecycleView2.computeVerticalScrollRange();
                aIORecycleView3 = PreLoadRefreshImpl.this.aioRecycleView;
                int computeVerticalScrollExtent = aIORecycleView3.computeVerticalScrollExtent();
                int i16 = (computeVerticalScrollRange - computeVerticalScrollOffset) - computeVerticalScrollExtent;
                i3 = PreLoadRefreshImpl.this.threshold;
                int i17 = i3 * computeVerticalScrollExtent;
                if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("PreLoadRefreshImpl", "autoLoadMore  computeVerticalScrollExtent " + computeVerticalScrollExtent + "  bottomDistance " + i16 + "  limit " + i17);
                }
                if (i16 <= i17) {
                    PreLoadRefreshImpl.this.u(RefreshType.PreLoadMore);
                    com.tencent.aio.base.log.a.f69187b.e("PreLoadRefreshImpl", "callLoadMore");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        s(new Function0<Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.PreLoadRefreshImpl$autoUpFetch$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) PreLoadRefreshImpl.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AIORecycleView aIORecycleView;
                AIORecycleView aIORecycleView2;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                aIORecycleView = PreLoadRefreshImpl.this.aioRecycleView;
                int computeVerticalScrollExtent = aIORecycleView.computeVerticalScrollExtent();
                aIORecycleView2 = PreLoadRefreshImpl.this.aioRecycleView;
                int computeVerticalScrollOffset = aIORecycleView2.computeVerticalScrollOffset();
                i3 = PreLoadRefreshImpl.this.threshold;
                int i16 = i3 * computeVerticalScrollExtent;
                if (com.tencent.aio.base.a.f69150c.a()) {
                    com.tencent.aio.base.log.a.f69187b.d("PreLoadRefreshImpl", "autoUpFetch  computeVerticalScrollExtent " + computeVerticalScrollExtent + "  verticalOffset " + computeVerticalScrollOffset + " limit " + i16);
                }
                if (computeVerticalScrollOffset <= i16) {
                    PreLoadRefreshImpl.this.v(RefreshType.PreRefresh);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e0() {
        if (this.preLoadStrategy != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    public void H(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, enable);
        } else {
            this.enablePreLoad = enable;
        }
    }

    public final boolean f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.enablePreLoad;
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.aio.api.refreshLoad.a aVar = this.preLoadStrategy;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        g0();
        return Unit.INSTANCE;
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    public void y(@NotNull com.tencent.aio.api.refreshLoad.a strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strategy);
            return;
        }
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        com.tencent.aio.base.log.a.f69187b.d("PreLoadRefreshImpl", "setCustomPreLoadStrategy " + strategy);
        strategy.g(this);
        this.preLoadStrategy = strategy;
    }
}
