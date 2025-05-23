package com.tencent.qqnt.chathistory.ui.link;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.link.adapter.ChatHistoryLinkAdapter;
import com.tencent.qqnt.chathistory.ui.link.data.a;
import com.tencent.qqnt.chathistory.ui.link.dialog.LinkSearchDialog;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.q;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001ZB\u0011\u0012\b\b\u0002\u0010-\u001a\u00020*\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J&\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010,R\u0016\u0010J\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010,R\u0016\u0010M\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR*\u0010V\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010N8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/ChatHistoryLinkFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "gi", "Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;", "data", "ai", "Lcom/tencent/qqnt/chathistory/ui/link/data/a$b;", "state", "Zh", "Landroid/view/View;", "view", "di", "Lcom/tencent/qqnt/chathistory/ui/link/data/a$a;", "Yh", "", "show", "mi", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bi", "li", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "fi", "qi", "hi", "ni", "Uh", WidgetCacheLunarData.JI, "ii", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "t6", "ff", "", "E", "I", "source", "Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Vh", "()Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter;", "linkAdapter", "Lcom/tencent/qqnt/chathistory/ui/link/dialog/LinkSearchDialog;", "G", "Wh", "()Lcom/tencent/qqnt/chathistory/ui/link/dialog/LinkSearchDialog;", "searchDialog", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "H", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Landroid/view/ViewGroup;", "emptyContaienr", "Landroidx/recyclerview/widget/RecyclerView;", "J", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/qqnt/chathistory/x2k/q;", "K", "Lcom/tencent/qqnt/chathistory/x2k/q;", "binding", "L", "mFirstPosition", "M", "mLastPosition", "N", "Z", "isLoadingMore", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "P", "Ljava/lang/ref/WeakReference;", "Xh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "<init>", "(I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryLinkFragment extends BaseSubCategoryFragment<ChatHistoryLinkViewModel> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a Q;

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy linkAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchDialog;

    /* renamed from: H, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup emptyContaienr;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: K, reason: from kotlin metadata */
    private q binding;

    /* renamed from: L, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: M, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/ChatHistoryLinkFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f353682a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46530);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BottomBarOperationType.values().length];
            try {
                iArr[BottomBarOperationType.FORWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomBarOperationType.FAVORITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomBarOperationType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f353682a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/link/ChatHistoryLinkFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353684e;

        c(RecyclerView recyclerView) {
            this.f353684e = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this, (Object) recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (!ChatHistoryLinkFragment.this.isResumed()) {
                return;
            }
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353684e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353684e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353684e.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (ChatHistoryLinkFragment.this.mFirstPosition == -1 || ChatHistoryLinkFragment.this.mLastPosition == -1) {
                    ChatHistoryLinkFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                    ChatHistoryLinkFragment.this.mLastPosition = findFirstVisibleItemPosition2;
                    HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                    RecyclerView it = this.f353684e;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    HistoryDtReportHelper.j(a16, it, findFirstVisibleItemPosition2 - findFirstVisibleItemPosition, 1, "em_bas_link_entry", 0, null, 32, null);
                    return;
                }
                HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                RecyclerView it5 = this.f353684e;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                HistoryDtReportHelper.h(a17, "em_bas_link_entry", it5, z16, ChatHistoryLinkFragment.this.mFirstPosition, findFirstVisibleItemPosition, ChatHistoryLinkFragment.this.mLastPosition, findFirstVisibleItemPosition2, 1, null, 256, null);
                ChatHistoryLinkFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                ChatHistoryLinkFragment.this.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            Q = new a(null);
        }
    }

    public ChatHistoryLinkFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        c.b bVar;
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar = Xh.get()) != null) {
            bVar.k8(getString(R.string.f170728zk1));
        }
        Vh().V0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$exitMultiSelectMode$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryLinkAdapter Vh;
                ChatHistoryLinkAdapter Vh2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                Vh = ChatHistoryLinkFragment.this.Vh();
                Vh2 = ChatHistoryLinkFragment.this.Vh();
                Vh.notifyItemRangeChanged(0, Vh2.m0().size(), new i(o.class, new o(z16)));
            }
        });
        sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatHistoryLinkAdapter Vh() {
        return (ChatHistoryLinkAdapter) this.linkAdapter.getValue();
    }

    private final LinkSearchDialog Wh() {
        return (LinkSearchDialog) this.searchDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(a.C9538a state) {
        boolean z16;
        List<com.tencent.qqnt.chathistory.ui.link.data.model.a> data = state.getData();
        List<com.tencent.qqnt.chathistory.ui.link.data.model.a> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            mi(true);
        } else {
            mi(false);
            Vh().B0(ExtensionsKt.f(data, ChatHistoryLinkFragment$handFirstPageUI$firstData$1.INSTANCE));
        }
        if (isResumed()) {
            li();
        }
        Vh().z0(state.a());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(state.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(a.b state) {
        List<com.tencent.qqnt.chathistory.ui.link.data.model.a> data = state.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryLinkFragment", "loadMore result " + data.size());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.x();
        if (data.isEmpty()) {
            Vh().z0(false);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setEnableLoadMore(false);
        } else {
            com.tencent.qqnt.chathistory.ui.link.data.model.b bVar = (com.tencent.qqnt.chathistory.ui.link.data.model.b) com.tencent.qqnt.chathistory.ui.base.item.c.c(Vh());
            if (bVar == null) {
                return;
            } else {
                ExtensionsKt.g(bVar, data, Vh(), ChatHistoryLinkFragment$handleLoadMoreUI$1.INSTANCE);
            }
        }
        Vh().z0(state.a());
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.setEnableLoadMore(state.a());
        this.isLoadingMore = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(com.tencent.qqnt.chathistory.ui.link.data.model.a data) {
        int i3 = 0;
        for (Object obj : Vh().m0()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) obj;
            if (bVar instanceof com.tencent.qqnt.chathistory.ui.link.data.model.a) {
                com.tencent.qqnt.chathistory.ui.link.data.model.a aVar = (com.tencent.qqnt.chathistory.ui.link.data.model.a) bVar;
                if (aVar.j() == data.j() && aVar.k() == data.k()) {
                    aVar.n(data.l());
                    Vh().notifyItemChanged(i3);
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryLinkFragment", "handleUpdateUI " + i3);
                }
            }
            i3 = i16;
        }
    }

    private final void bi(QUISearchBar view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryLinkFragment.ci(ChatHistoryLinkFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(ChatHistoryLinkFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkSearchDialog Wh = this$0.Wh();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Wh.showNow(childFragmentManager, "linkSearch");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.n(a16, it, "em_bas_search_box", null, 4, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void di(View view) {
        View findViewById = view.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        smartRefreshLayout.X(new HistoryLoadMoreFooter(requireContext));
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.S(true);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.link.f
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryLinkFragment.ei(ChatHistoryLinkFragment.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ChatHistoryLinkFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.gi();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.Vh(), this$0.Vh().m0().size() - 1, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(BottomBarOperationType operationType) {
        int i3 = b.f353682a[operationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ni();
                    return;
                }
                return;
            }
            hi();
            return;
        }
        qi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryLinkFragment$loadMore$1(this, null), 3, null);
    }

    private final void hi() {
        int collectionSizeOrDefault;
        if (Vh().X0().isEmpty()) {
            return;
        }
        List<MsgRecord> Z0 = Vh().Z0();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(Z0, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = Z0.iterator();
        while (it.hasNext()) {
            arrayList.add(((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformMsgRecordWithType((MsgRecord) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iAIOFavApi.multiFav(requireContext, arrayList2);
        Uh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void ii() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        RecyclerView recyclerView;
        c.b bVar;
        if (Vh().W0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar = Xh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_link_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryLinkViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryLinkViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.r(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        HistoryDtReportHelper a17 = companion.a();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        } else {
            recyclerView = recyclerView2;
        }
        HistoryDtReportHelper.j(a17, recyclerView, this.mLastPosition - this.mFirstPosition, 1, "em_bas_link_entry", 1, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void ji() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        View gd5;
        c.b bVar2;
        if (Vh().W0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar2 = Xh.get()) != null) {
            view = bVar2.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_link_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryLinkViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryLinkViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        WeakReference<c.b> Xh2 = Xh();
        if (Xh2 != null && (bVar = Xh2.get()) != null && (gd5 = bVar.gd()) != null) {
            gd5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryLinkFragment.ki(ChatHistoryLinkFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    public static final void ki(ChatHistoryLinkFragment this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_link_tab"), TuplesKt.to("touin", companion.a().d(this$0.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryLinkViewModel) this$0.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryLinkViewModel) this$0.rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_back_button", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void li() {
        c.b bVar;
        c.b bVar2;
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar2 = Xh.get()) != null) {
            bVar2.f3(getString(R.string.f170728zk1), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$setRight$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                    }
                }

                private static final String a(ChatHistoryLinkFragment chatHistoryLinkFragment) {
                    ChatHistoryLinkAdapter Vh;
                    int i3;
                    BaseApplication context = BaseApplication.getContext();
                    Vh = chatHistoryLinkFragment.Vh();
                    if (Vh.W0()) {
                        i3 = R.string.f170727zk0;
                    } else {
                        i3 = R.string.f170728zk1;
                    }
                    String string = context.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(i\u2026_find_by_category_choose)");
                    return string;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(@Nullable View v3) {
                    ChatHistoryLinkAdapter Vh;
                    ChatHistoryLinkAdapter Vh2;
                    HistoryDtReportHelper.OperationContent operationContent;
                    Map mutableMapOf;
                    Map<String, Object> mutableMapOf2;
                    c.b bVar3;
                    EventCollector.getInstance().onViewClickedBefore(v3);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        Vh = ChatHistoryLinkFragment.this.Vh();
                        final ChatHistoryLinkFragment chatHistoryLinkFragment = ChatHistoryLinkFragment.this;
                        boolean V0 = Vh.V0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$setRight$1$onClick$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                ChatHistoryLinkAdapter Vh3;
                                ChatHistoryLinkAdapter Vh4;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    return;
                                }
                                Vh3 = ChatHistoryLinkFragment.this.Vh();
                                Vh4 = ChatHistoryLinkFragment.this.Vh();
                                Vh3.notifyItemRangeChanged(0, Vh4.m0().size(), new i(o.class, new o(z16)));
                            }
                        });
                        final ChatHistoryLinkFragment chatHistoryLinkFragment2 = ChatHistoryLinkFragment.this;
                        WeakReference<c.b> Xh2 = chatHistoryLinkFragment2.Xh();
                        if (Xh2 != null && (bVar3 = Xh2.get()) != null) {
                            bVar3.f3(a(chatHistoryLinkFragment2), this);
                        }
                        if (V0) {
                            chatHistoryLinkFragment2.yh(((ChatHistoryLinkViewModel) chatHistoryLinkFragment2.rh()).M1(), ((ChatHistoryLinkViewModel) chatHistoryLinkFragment2.rh()).N1(), BottomBarType.LINK, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$setRight$1$onClick$2$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(BottomBarOperationType bottomBarOperationType) {
                                    invoke2(bottomBarOperationType);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull BottomBarOperationType it) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                    } else {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        ChatHistoryLinkFragment.this.fi(it);
                                    }
                                }
                            });
                            BaseHistoryFragment.wh(chatHistoryLinkFragment2, false, false, 2, null);
                        } else {
                            chatHistoryLinkFragment2.sh();
                        }
                        Vh2 = ChatHistoryLinkFragment.this.Vh();
                        if (Vh2.W0()) {
                            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                        } else {
                            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                        }
                        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                        HistoryDtReportHelper a16 = companion.a();
                        Intrinsics.checkNotNull(v3);
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_link_tab"), TuplesKt.to("touin", companion.a().d(ChatHistoryLinkFragment.this.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryLinkViewModel) ChatHistoryLinkFragment.this.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryLinkViewModel) ChatHistoryLinkFragment.this.rh()).N1()));
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
                        a16.k("em_bas_multiple_selection_button", v3, mutableMapOf2);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                    }
                    EventCollector.getInstance().onViewClicked(v3);
                }
            });
        }
        WeakReference<c.b> Xh2 = Xh();
        if (Xh2 != null && (bVar = Xh2.get()) != null) {
            bVar.setEnable(!Vh().m0().isEmpty());
        }
    }

    private final void mi(boolean show) {
        SmartRefreshLayout smartRefreshLayout = null;
        if (show) {
            ViewGroup viewGroup = this.emptyContaienr;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContaienr");
                viewGroup = null;
            }
            if (viewGroup.getChildCount() == 0) {
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
                String string = getString(R.string.zkf);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_link)");
                QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
                build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                build.setVisibility(0);
                ViewGroup viewGroup2 = this.emptyContaienr;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("emptyContaienr");
                    viewGroup2 = null;
                }
                viewGroup2.addView(build);
            }
            q qVar = this.binding;
            if (qVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                qVar = null;
            }
            qVar.e().getMRv().setVisibility(8);
            ViewGroup viewGroup3 = this.emptyContaienr;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContaienr");
                viewGroup3 = null;
            }
            viewGroup3.setVisibility(0);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.setVisibility(8);
            return;
        }
        q qVar2 = this.binding;
        if (qVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            qVar2 = null;
        }
        qVar2.e().getMRv().setVisibility(0);
        ViewGroup viewGroup4 = this.emptyContaienr;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContaienr");
            viewGroup4 = null;
        }
        viewGroup4.setVisibility(8);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout3;
        }
        smartRefreshLayout.setVisibility(0);
    }

    private final void ni() {
        if (Vh().X0().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.setMainTitle(R.string.zjs);
        create.addButton(R.string.zjr, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryLinkFragment.oi(ChatHistoryLinkFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void oi(final ChatHistoryLinkFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(((ChatHistoryLinkViewModel) this$0.rh()).M1(), ((ChatHistoryLinkViewModel) this$0.rh()).N1(), ""), new ArrayList<>(this$0.Vh().X0()), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.link.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    ChatHistoryLinkFragment.pi(ChatHistoryLinkFragment.this, i16, str);
                }
            });
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(ChatHistoryLinkFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatHistoryLinkFragment", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new ChatHistoryLinkFragment$showMultiDeleteActionSheet$1$1$1$1(this$0, null), 2, null);
        }
    }

    private final void qi() {
        if (Vh().X0().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.addButton(R.string.f170730zk3);
        create.addButton(R.string.f170731zk4);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.d
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryLinkFragment.ri(ChatHistoryLinkFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ri(ChatHistoryLinkFragment this$0, ActionSheet actionSheet, View view, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        IChatHistoryForwardApi iChatHistoryForwardApi = (IChatHistoryForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IChatHistoryForwardApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iChatHistoryForwardApi.forwardChatHistory(requireContext, i16, ((ChatHistoryLinkViewModel) this$0.rh()).M1(), ((ChatHistoryLinkViewModel) this$0.rh()).N1(), this$0.Vh().Z0());
        actionSheet.dismiss();
        this$0.Uh();
    }

    @Nullable
    public WeakReference<c.b> Xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (WeakReference) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.titleRightDelegate;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void ff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        c.a.a(this);
        ii();
        Vh().c1(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$onHideTitleRightUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryLinkAdapter Vh;
                ChatHistoryLinkAdapter Vh2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                Vh = ChatHistoryLinkFragment.this.Vh();
                Vh2 = ChatHistoryLinkFragment.this.Vh();
                Vh.notifyItemRangeChanged(0, Vh2.m0().size(), new i(o.class, new o(z16)));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QUISearchBar searchBar = (QUISearchBar) view.findViewById(R.id.f66403aj);
        String qqStr = HardCodeUtil.qqStr(R.string.f170725a14);
        searchBar.getInputWidget().setHint(qqStr);
        searchBar.getInputWidget().setContentDescription(qqStr);
        searchBar.setContentDescription(qqStr);
        di(view);
        View findViewById = view.findViewById(R.id.f792849c);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(Vh());
        recyclerView.addOnScrollListener(new c(recyclerView));
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Recycl\u2026\n            })\n        }");
        this.recyclerView = recyclerView;
        Intrinsics.checkNotNullExpressionValue(searchBar, "searchBar");
        bi(searchBar);
        View findViewById2 = view.findViewById(R.id.bwb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.empty_container)");
        this.emptyContaienr = (ViewGroup) findViewById2;
        RecyclerView recyclerView2 = null;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryLinkFragment$onViewCreated$2(this, null));
        LiveData obtainUiState = ((ChatHistoryLinkViewModel) rh()).obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.link.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.link.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$onViewCreated$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.link.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.link.data.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof a.C9538a) {
                    ChatHistoryLinkFragment chatHistoryLinkFragment = ChatHistoryLinkFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryLinkFragment.Yh((a.C9538a) it);
                } else if (it instanceof a.b) {
                    ChatHistoryLinkFragment chatHistoryLinkFragment2 = ChatHistoryLinkFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryLinkFragment2.Zh((a.b) it);
                } else if (it instanceof a.c) {
                    ChatHistoryLinkFragment.this.ai(((a.c) it).a());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.link.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryLinkFragment.onViewCreated$lambda$2(Function1.this, obj);
            }
        });
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        ExtensionsKt.w(recyclerView2, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$onViewCreated$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                SmartRefreshLayout smartRefreshLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                smartRefreshLayout = ChatHistoryLinkFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                return Boolean.valueOf(smartRefreshLayout.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$onViewCreated$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
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
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryLinkFragment.this.gi();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c.a.b(this);
        li();
        ji();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        q qVar = new q(context, null, 2, 0 == true ? 1 : 0);
        this.binding = qVar;
        View mRv = qVar.getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryLinkViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryLinkViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_link_tab", mutableMapOf);
        return mRv;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void y5(@Nullable WeakReference<c.b> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) weakReference);
        } else {
            this.titleRightDelegate = weakReference;
        }
    }

    public ChatHistoryLinkFragment(int i3) {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.source = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new ChatHistoryLinkFragment$linkAdapter$2(this));
        this.linkAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinkSearchDialog>() { // from class: com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment$searchDialog$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkSearchDialog invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new LinkSearchDialog((ChatHistoryLinkViewModel) ChatHistoryLinkFragment.this.rh()) : (LinkSearchDialog) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchDialog = lazy2;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    public /* synthetic */ ChatHistoryLinkFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
