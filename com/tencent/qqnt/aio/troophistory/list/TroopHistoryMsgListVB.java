package com.tencent.qqnt.aio.troophistory.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.msglist.AIOMsgListDataState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgListVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroid/view/View;", "view", "", NodeProps.VISIBLE, "", Constants.APK_CERTIFICATE, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "childView", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "T0", "Lcom/tencent/aio/base/mvvm/b;", "F0", "S0", "state", "u0", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "M", "Lkotlin/Lazy;", "F1", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "Landroidx/recyclerview/widget/RecyclerView;", "N", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "<init>", "()V", "P", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopHistoryMsgListVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private RecyclerView rv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgListVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.troophistory.list.TroopHistoryMsgListVB$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgListVB$b", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements c.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHistoryMsgListVB.this);
            }
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopHistoryMsgListVB.this.sendIntent(new a.c("TroopHistoryMsgListVB."));
            }
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                c.b.a.a(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60761);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHistoryMsgListVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.qqnt.aio.troophistory.list.TroopHistoryMsgListVB$emptyView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHistoryMsgListVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUIEmptyState invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QUIEmptyState build = new QUIEmptyState.Builder(TroopHistoryMsgListVB.this.getMContext()).setImageType(16).setTitle("\u6682\u65e0\u6d88\u606f").setBackgroundColorType(1).build();
                    build.setVisibility(8);
                    return build;
                }
            });
            this.emptyView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final QUIEmptyState F1() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final void G1(View view, boolean visible) {
        int i3;
        boolean z16 = false;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (view != null && view.getVisibility() == i3) {
            z16 = true;
        }
        if (!z16 && view != null) {
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.qqnt.aio.troophistory.list.b();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.S0();
            sendIntent(new a.b("TroopHistoryMsgListVB."));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, createViewParams, childView, uiHelper);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        this.rv = uiHelper.i();
        uiHelper.i0(1);
        uiHelper.l(new b());
        FrameLayout frameLayout = new FrameLayout(getMContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(childView);
        frameLayout.addView(F1(), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state, (Object) uiHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.u0(state, uiHelper);
        if (state instanceof AIOMsgListDataState) {
            boolean isEmpty = ((AIOMsgListDataState) state).isEmpty();
            G1(F1(), isEmpty);
            G1(this.rv, !isEmpty);
        }
    }
}
