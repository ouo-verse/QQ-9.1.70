package com.tencent.now.linkpkanchorplay.componententry;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.AcceptInvite.AcceptInviteHelper;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog;
import com.tencent.now.linkpkanchorplay.mainpage.view.NewLinkAndPKInviteDialogFragment;
import com.tencent.now.linkpkanchorplay.matchrandom.view.MatchRandomDialog;
import com.tencent.now.linkpkanchorplay.pkhistory.view.PKHistoryDialog;
import com.tencent.now.linkpkanchorplay.rankpkhistory.view.RankPKHistoryDialog;
import com.tencent.now.linkpkanchorplay.search.view.SearchAnchorDialogFragment;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.ag;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0001XB?\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u00101\u001a\u00020.\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/componententry/AnchorPlayUIController;", "Lcom/tencent/component/core/thread/ThreadCenter$HandlerKeyable;", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "pageType", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "v", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "pkType", ReportConstant.COSTREPORT_PREFIX, h.F, "Lg55/ag;", "inviteMsg", "u", "k", DomainData.DOMAIN_NAME, HippyTKDListViewAdapter.X, "w", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "e", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "pkEntranceSupport", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelProvider;", "i", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Lom3/e;", "Lom3/e;", "linkMicStateMgr", "Lcom/tencent/now/linkpkanchorplay/componententry/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/linkpkanchorplay/componententry/e;", "roomInfo", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog;", "D", "Lcom/tencent/now/linkpkanchorplay/linkscreen/view/AnchorOperateLinkDialog;", "anchorOperateDialog", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteDialogFragment;", "E", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteDialogFragment;", "anchorPlayMainDialog", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", UserInfo.SEX_FEMALE, "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "curAnchorPlaySecondaryDialog", "Lcom/tencent/now/linkpkanchorplay/AcceptInvite/AcceptInviteHelper;", "G", "Lcom/tencent/now/linkpkanchorplay/AcceptInvite/AcceptInviteHelper;", "acceptInviteHelper", "Ljm3/a;", "H", "Ljm3/a;", "inviteOperateController", "Lcom/tencent/now/linkpkanchorplay/matchrandom/view/MatchRandomDialog;", "I", "Lcom/tencent/now/linkpkanchorplay/matchrandom/view/MatchRandomDialog;", "matchRandomDialog", "Llm3/a;", "J", "Lkotlin/Lazy;", "j", "()Llm3/a;", "uiViewModel", "Landroidx/lifecycle/Observer;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "K", "Landroidx/lifecycle/Observer;", "eventObserver", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/componententry/f;Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelProvider;Lom3/e;Lcom/tencent/now/linkpkanchorplay/componententry/e;)V", "L", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorPlayUIController implements ThreadCenter.HandlerKeyable {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AnchorRoomInfo roomInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AnchorOperateLinkDialog anchorOperateDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private NewLinkAndPKInviteDialogFragment anchorPlayMainDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private BottomDialog curAnchorPlaySecondaryDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final AcceptInviteHelper acceptInviteHelper;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final jm3.a inviteOperateController;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private MatchRandomDialog matchRandomDialog;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Observer<UIEvent> eventObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f pkEntranceSupport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentManager fm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewModelProvider viewModelProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final om3.e linkMicStateMgr;

    public AnchorPlayUIController(@NotNull Context context, @NotNull f pkEntranceSupport, @NotNull FragmentManager fm5, @NotNull LifecycleOwner lifecycleOwner, @NotNull ViewModelProvider viewModelProvider, @NotNull om3.e linkMicStateMgr, @NotNull AnchorRoomInfo roomInfo) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkEntranceSupport, "pkEntranceSupport");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(linkMicStateMgr, "linkMicStateMgr");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.context = context;
        this.pkEntranceSupport = pkEntranceSupport;
        this.fm = fm5;
        this.lifecycleOwner = lifecycleOwner;
        this.viewModelProvider = viewModelProvider;
        this.linkMicStateMgr = linkMicStateMgr;
        this.roomInfo = roomInfo;
        this.acceptInviteHelper = new AcceptInviteHelper(context, fm5, pkEntranceSupport.k6());
        this.inviteOperateController = new jm3.a(roomInfo.getRoomID(), fm5);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<lm3.a>() { // from class: com.tencent.now.linkpkanchorplay.componententry.AnchorPlayUIController$uiViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final lm3.a invoke() {
                ViewModelProvider viewModelProvider2;
                LifecycleOwner lifecycleOwner2;
                Observer<? super UIEvent> observer;
                viewModelProvider2 = AnchorPlayUIController.this.viewModelProvider;
                ViewModel viewModel = viewModelProvider2.get(lm3.a.class);
                AnchorPlayUIController anchorPlayUIController = AnchorPlayUIController.this;
                lm3.a aVar = (lm3.a) viewModel;
                MutableLiveData<UIEvent> L1 = aVar.L1();
                lifecycleOwner2 = anchorPlayUIController.lifecycleOwner;
                observer = anchorPlayUIController.eventObserver;
                L1.observe(lifecycleOwner2, observer);
                return aVar;
            }
        });
        this.uiViewModel = lazy;
        this.eventObserver = new Observer() { // from class: com.tencent.now.linkpkanchorplay.componententry.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnchorPlayUIController.i(AnchorPlayUIController.this, (UIEvent) obj);
            }
        };
    }

    private final void h() {
        MatchRandomDialog matchRandomDialog = this.matchRandomDialog;
        if (matchRandomDialog != null) {
            matchRandomDialog.uh();
        }
        MatchRandomDialog matchRandomDialog2 = this.matchRandomDialog;
        if (matchRandomDialog2 != null) {
            matchRandomDialog2.dismiss();
        }
        this.matchRandomDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AnchorPlayUIController this$0, UIEvent uIEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uIEvent instanceof UIEvent.ShowSecondaryPageEvent) {
            UIEvent.ShowSecondaryPageEvent showSecondaryPageEvent = (UIEvent.ShowSecondaryPageEvent) uIEvent;
            this$0.v(showSecondaryPageEvent.getPageType(), showSecondaryPageEvent.getPageContext());
            return;
        }
        if (uIEvent instanceof UIEvent.c) {
            this$0.o();
            return;
        }
        if (uIEvent instanceof UIEvent.ShowPKRandomMatchPanel) {
            this$0.s(((UIEvent.ShowPKRandomMatchPanel) uIEvent).getSelectedPKType());
        } else if (uIEvent instanceof UIEvent.ShowReceiveInviteUI) {
            this$0.u(((UIEvent.ShowReceiveInviteUI) uIEvent).getInviteMsg());
        } else if (uIEvent instanceof UIEvent.a) {
            this$0.h();
        }
    }

    private final lm3.a j() {
        return (lm3.a) this.uiViewModel.getValue();
    }

    private final boolean l() {
        Dialog dialog;
        NewLinkAndPKInviteDialogFragment newLinkAndPKInviteDialogFragment = this.anchorPlayMainDialog;
        if (newLinkAndPKInviteDialogFragment != null && (dialog = newLinkAndPKInviteDialogFragment.getDialog()) != null) {
            return dialog.isShowing();
        }
        return false;
    }

    private final boolean m() {
        Dialog dialog;
        BottomDialog bottomDialog = this.curAnchorPlaySecondaryDialog;
        if (bottomDialog != null && (dialog = bottomDialog.getDialog()) != null) {
            return dialog.isShowing();
        }
        return false;
    }

    private final void o() {
        boolean z16;
        Dialog dialog;
        NewLinkAndPKInviteDialogFragment newLinkAndPKInviteDialogFragment = this.anchorPlayMainDialog;
        if (newLinkAndPKInviteDialogFragment != null && (dialog = newLinkAndPKInviteDialogFragment.getDialog()) != null) {
            z16 = dialog.isShowing();
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.anchorPlayMainDialog = null;
        NewLinkAndPKInviteDialogFragment newLinkAndPKInviteDialogFragment2 = new NewLinkAndPKInviteDialogFragment(new AnchorTabPageContext(3, this.roomInfo));
        newLinkAndPKInviteDialogFragment2.show(this.fm, "NewLinkAndPKInviteDialogFragment");
        newLinkAndPKInviteDialogFragment2.sh(j());
        newLinkAndPKInviteDialogFragment2.th(new BottomDialog.a() { // from class: com.tencent.now.linkpkanchorplay.componententry.c
            @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog.a
            public final void onDismiss(DialogInterface dialogInterface) {
                AnchorPlayUIController.p(AnchorPlayUIController.this, dialogInterface);
            }
        });
        this.anchorPlayMainDialog = newLinkAndPKInviteDialogFragment2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AnchorPlayUIController this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.anchorPlayMainDialog = null;
    }

    private final void q() {
        boolean z16;
        Dialog dialog;
        AnchorOperateLinkDialog anchorOperateLinkDialog = this.anchorOperateDialog;
        if (anchorOperateLinkDialog != null && (dialog = anchorOperateLinkDialog.getDialog()) != null) {
            z16 = dialog.isShowing();
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.anchorOperateDialog = null;
        long roomID = this.roomInfo.getRoomID();
        e55.a currentLinkScreenAnchor = this.linkMicStateMgr.getCurrentLinkScreenAnchor();
        Intrinsics.checkNotNull(currentLinkScreenAnchor);
        AnchorOperateLinkDialog anchorOperateLinkDialog2 = new AnchorOperateLinkDialog(roomID, currentLinkScreenAnchor, this.linkMicStateMgr, this.viewModelProvider);
        anchorOperateLinkDialog2.show(this.fm, "anchor_in_link_screen_ctrl");
        anchorOperateLinkDialog2.th(new BottomDialog.a() { // from class: com.tencent.now.linkpkanchorplay.componententry.b
            @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog.a
            public final void onDismiss(DialogInterface dialogInterface) {
                AnchorPlayUIController.r(AnchorPlayUIController.this, dialogInterface);
            }
        });
        this.anchorOperateDialog = anchorOperateLinkDialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AnchorPlayUIController this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.anchorOperateDialog = null;
    }

    private final void s(UIEvent.PKType pkType) {
        MatchRandomDialog matchRandomDialog = this.matchRandomDialog;
        if (matchRandomDialog != null) {
            matchRandomDialog.dismiss();
        }
        MatchRandomDialog matchRandomDialog2 = new MatchRandomDialog(this.roomInfo.getRoomID(), pkType);
        matchRandomDialog2.th(new BottomDialog.a() { // from class: com.tencent.now.linkpkanchorplay.componententry.d
            @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog.a
            public final void onDismiss(DialogInterface dialogInterface) {
                AnchorPlayUIController.t(AnchorPlayUIController.this, dialogInterface);
            }
        });
        matchRandomDialog2.sh(j());
        matchRandomDialog2.show(this.fm, "PKRandomMatch");
        this.matchRandomDialog = matchRandomDialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AnchorPlayUIController this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.matchRandomDialog = null;
    }

    private final void u(ag inviteMsg) {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorPlayUIController", "showReceiveInviteUI", "inviteMsg:" + inviteMsg);
        if (l() || m()) {
            inviteMsg.f401300f = 1;
        }
        this.acceptInviteHelper.p(inviteMsg, this.pkEntranceSupport.E0());
    }

    private final void v(int pageType, AnchorTabPageContext pageContext) {
        BottomDialog searchAnchorDialogFragment;
        BottomDialog bottomDialog;
        if (pageType != 1) {
            if (pageType != 2) {
                if (pageType != 4) {
                    bottomDialog = new BottomDialog();
                } else {
                    searchAnchorDialogFragment = new RankPKHistoryDialog(pageContext);
                }
            } else {
                bottomDialog = new PKHistoryDialog(this.roomInfo.getRoomID());
            }
            bottomDialog.sh(j());
            bottomDialog.rh(true);
            bottomDialog.show(this.fm, "secondaryView_" + pageType);
            this.curAnchorPlaySecondaryDialog = bottomDialog;
        }
        searchAnchorDialogFragment = new SearchAnchorDialogFragment(pageContext);
        bottomDialog = searchAnchorDialogFragment;
        bottomDialog.sh(j());
        bottomDialog.rh(true);
        bottomDialog.show(this.fm, "secondaryView_" + pageType);
        this.curAnchorPlaySecondaryDialog = bottomDialog;
    }

    public final void k() {
        jm3.a aVar = this.inviteOperateController;
        Context context = this.context;
        ViewModelProvider viewModelProvider = this.viewModelProvider;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        om3.e eVar = this.linkMicStateMgr;
        lm3.a uiViewModel = j();
        Intrinsics.checkNotNullExpressionValue(uiViewModel, "uiViewModel");
        aVar.j(context, viewModelProvider, lifecycleOwner, eVar, uiViewModel);
    }

    public final void n() {
        if (!com.tencent.falco.base.downloader.utils.a.a()) {
            UIUtil.h(this.context.getString(R.string.f170672lo), false, 0);
            return;
        }
        om3.d currentState = this.linkMicStateMgr.getCurrentState();
        boolean isInLinking = this.linkMicStateMgr.getIsInLinking();
        boolean i3 = this.linkMicStateMgr.i();
        AegisLogger.INSTANCE.i("PK_Biz|AnchorPlayUIController", "processEntryClick state: " + currentState + " isLinking: " + isInLinking + " isInPk: " + i3);
        if (currentState instanceof d.c) {
            o();
            return;
        }
        if (currentState instanceof d.InvitationSent) {
            this.inviteOperateController.u();
            return;
        }
        if (currentState instanceof d.C10927d) {
            this.acceptInviteHelper.r();
            return;
        }
        if (currentState instanceof d.InLinkScreen) {
            q();
        } else if (currentState instanceof d.InMatch) {
            s(((d.InMatch) currentState).getPkType());
        } else {
            o();
        }
    }

    public final void w() {
        j().t1(new UIEvent.a());
    }

    public final void x() {
        this.inviteOperateController.v();
        this.acceptInviteHelper.j();
        this.anchorPlayMainDialog = null;
        this.anchorOperateDialog = null;
        BottomDialog bottomDialog = this.curAnchorPlaySecondaryDialog;
        if (bottomDialog != null) {
            bottomDialog.dismiss();
        }
        this.curAnchorPlaySecondaryDialog = null;
    }
}
