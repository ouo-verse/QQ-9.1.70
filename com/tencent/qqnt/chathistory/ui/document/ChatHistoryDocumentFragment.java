package com.tencent.qqnt.chathistory.ui.document;

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
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.document.adapter.ChatHistoryDocumentAdapter;
import com.tencent.qqnt.chathistory.ui.document.data.a;
import com.tencent.qqnt.chathistory.ui.document.dialog.DocumentSearchDialog;
import com.tencent.qqnt.chathistory.ui.document.viewmodel.ChatHistoryDocumentViewModel;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.p;
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
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\\B\u0011\u0012\b\b\u0002\u0010*\u001a\u00020'\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J&\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010)R\u0016\u0010K\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010)R\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR*\u0010X\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010P8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/ChatHistoryDocumentFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/document/viewmodel/ChatHistoryDocumentViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "hi", "Lcom/tencent/qqnt/chathistory/ui/document/data/model/b;", "data", "ci", "Lcom/tencent/qqnt/chathistory/ui/document/data/a$c;", "state", "bi", "Landroid/view/View;", "view", "fi", "Lcom/tencent/qqnt/chathistory/ui/document/data/a$b;", "ai", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "di", "ni", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "Vh", "ri", "ii", "oi", "Wh", "li", "ki", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "t6", "ff", "", "E", "I", "source", "Lcom/tencent/qqnt/chathistory/ui/document/adapter/ChatHistoryDocumentAdapter;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Xh", "()Lcom/tencent/qqnt/chathistory/ui/document/adapter/ChatHistoryDocumentAdapter;", "documentAdapter", "Lcom/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog;", "G", "Yh", "()Lcom/tencent/qqnt/chathistory/ui/document/dialog/DocumentSearchDialog;", "searchDialog", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "H", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Landroid/view/ViewGroup;", "emptyContainer", "Landroidx/recyclerview/widget/RecyclerView;", "J", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/qqnt/chathistory/ui/document/data/model/a;", "K", "Lcom/tencent/qqnt/chathistory/ui/document/data/model/a;", "documentCountNode", "Lcom/tencent/qqnt/chathistory/x2k/p;", "L", "Lcom/tencent/qqnt/chathistory/x2k/p;", "binding", "M", "mFirstPosition", "N", "mLastPosition", "", "P", "Z", "isLoadingMore", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/ref/WeakReference;", "Zh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "<init>", "(I)V", BdhLogUtil.LogTag.Tag_Req, "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryDocumentFragment extends BaseSubCategoryFragment<ChatHistoryDocumentViewModel> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a R;

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy documentAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchDialog;

    /* renamed from: H, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup emptyContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chathistory.ui.document.data.model.a documentCountNode;

    /* renamed from: L, reason: from kotlin metadata */
    private p binding;

    /* renamed from: M, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: N, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/ChatHistoryDocumentFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        public static final /* synthetic */ int[] f353448a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39820);
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
            f353448a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/document/ChatHistoryDocumentFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353450e;

        c(RecyclerView recyclerView) {
            this.f353450e = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this, (Object) recyclerView);
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
            if (!ChatHistoryDocumentFragment.this.isResumed()) {
                return;
            }
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353450e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353450e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353450e.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (ChatHistoryDocumentFragment.this.mFirstPosition == -1 || ChatHistoryDocumentFragment.this.mLastPosition == -1) {
                    ChatHistoryDocumentFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                    ChatHistoryDocumentFragment.this.mLastPosition = findFirstVisibleItemPosition2;
                    HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                    RecyclerView it = this.f353450e;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    HistoryDtReportHelper.j(a16, it, findFirstVisibleItemPosition2 - findFirstVisibleItemPosition, 3, "em_bas_online_document_entry", 0, null, 32, null);
                    return;
                }
                HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                RecyclerView it5 = this.f353450e;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                HistoryDtReportHelper.h(a17, "em_bas_online_document_entry", it5, z16, ChatHistoryDocumentFragment.this.mFirstPosition, findFirstVisibleItemPosition, ChatHistoryDocumentFragment.this.mLastPosition, findFirstVisibleItemPosition2, 3, null, 256, null);
                ChatHistoryDocumentFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                ChatHistoryDocumentFragment.this.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            R = new a(null);
        }
    }

    public ChatHistoryDocumentFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(BottomBarOperationType operationType) {
        int i3 = b.f353448a[operationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    oi();
                    return;
                }
                return;
            }
            ii();
            return;
        }
        ri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        c.b bVar;
        WeakReference<c.b> Zh = Zh();
        if (Zh != null && (bVar = Zh.get()) != null) {
            bVar.k8(getString(R.string.f170728zk1));
        }
        Xh().V0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$exitMultiSelectMode$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryDocumentAdapter Xh;
                ChatHistoryDocumentAdapter Xh2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                Xh = ChatHistoryDocumentFragment.this.Xh();
                Xh2 = ChatHistoryDocumentFragment.this.Xh();
                Xh.notifyItemRangeChanged(0, Xh2.m0().size(), new i(o.class, new o(z16)));
            }
        });
        sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatHistoryDocumentAdapter Xh() {
        return (ChatHistoryDocumentAdapter) this.documentAdapter.getValue();
    }

    private final DocumentSearchDialog Yh() {
        return (DocumentSearchDialog) this.searchDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(a.b state) {
        List<com.tencent.qqnt.chathistory.ui.document.data.model.b> data = state.getData();
        SmartRefreshLayout smartRefreshLayout = null;
        if (data.isEmpty()) {
            ViewGroup viewGroup = this.emptyContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            p pVar = this.binding;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                pVar = null;
            }
            pVar.e().getMRv().setVisibility(8);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.setVisibility(8);
        } else {
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setVisibility(0);
            ViewGroup viewGroup2 = this.emptyContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            p pVar2 = this.binding;
            if (pVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                pVar2 = null;
            }
            pVar2.e().getMRv().setVisibility(0);
            List<com.tencent.qqnt.chathistory.ui.base.item.a> f16 = ExtensionsKt.f(data, ChatHistoryDocumentFragment$handFirstPageUI$firstData$1.INSTANCE);
            this.documentCountNode.g(data.size());
            Xh().B0(f16);
        }
        if (isResumed()) {
            ni();
        }
        Xh().z0(state.a());
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.setEnableLoadMore(state.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(a.c state) {
        List<com.tencent.qqnt.chathistory.ui.document.data.model.b> data = state.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentFragment", "loadMore result " + data.size());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.x();
        if (data.isEmpty()) {
            Xh().E0(this.documentCountNode);
            Xh().z0(false);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setEnableLoadMore(false);
        } else {
            this.documentCountNode.d(data.size());
            com.tencent.qqnt.chathistory.ui.document.data.model.c cVar = (com.tencent.qqnt.chathistory.ui.document.data.model.c) com.tencent.qqnt.chathistory.ui.base.item.c.c(Xh());
            if (cVar == null) {
                return;
            } else {
                ExtensionsKt.g(cVar, data, Xh(), ChatHistoryDocumentFragment$handleLoadMoreUI$1.INSTANCE);
            }
        }
        Xh().z0(state.a());
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
    public final void ci(com.tencent.qqnt.chathistory.ui.document.data.model.b data) {
        int i3 = 0;
        for (Object obj : Xh().m0()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) obj;
            if (bVar instanceof com.tencent.qqnt.chathistory.ui.document.data.model.b) {
                com.tencent.qqnt.chathistory.ui.document.data.model.b bVar2 = (com.tencent.qqnt.chathistory.ui.document.data.model.b) bVar;
                if (bVar2.j() == data.j() && bVar2.k() == data.k()) {
                    bVar2.n(data.l());
                    Xh().notifyItemChanged(i3);
                    com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryDocumentFragment", "handleUpdateUI " + i3);
                }
            }
            i3 = i16;
        }
    }

    private final void di(QUISearchBar view) {
        view.getInputWidget().setHint(HardCodeUtil.qqStr(R.string.f170725a14));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryDocumentFragment.ei(ChatHistoryDocumentFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ChatHistoryDocumentFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.n(a16, it, "em_bas_search_box", null, 4, null);
        DocumentSearchDialog Yh = this$0.Yh();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Yh.showNow(childFragmentManager, "DocumentSearch");
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void fi(View view) {
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
        smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.document.g
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryDocumentFragment.gi(ChatHistoryDocumentFragment.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(ChatHistoryDocumentFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.hi();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.Xh(), this$0.Xh().m0().size() - 1, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryDocumentFragment$loadMore$1(this, null), 3, null);
    }

    private final void ii() {
        int collectionSizeOrDefault;
        if (Xh().X0().isEmpty()) {
            return;
        }
        List<MsgRecord> Z0 = Xh().Z0();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(Z0, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = Z0.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iAIOFavApi.multiFav(requireContext, arrayList2);
        Wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void ki() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        RecyclerView recyclerView;
        c.b bVar;
        if (Xh().W0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Zh = Zh();
        if (Zh != null && (bVar = Zh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_online_document_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDocumentViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDocumentViewModel) rh()).N1()));
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
        HistoryDtReportHelper.j(a17, recyclerView, this.mLastPosition - this.mFirstPosition, 3, "em_bas_online_document_entry", 1, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void li() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        View gd5;
        c.b bVar2;
        if (Xh().W0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Zh = Zh();
        if (Zh != null && (bVar2 = Zh.get()) != null) {
            view = bVar2.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_online_document_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDocumentViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDocumentViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        WeakReference<c.b> Zh2 = Zh();
        if (Zh2 != null && (bVar = Zh2.get()) != null && (gd5 = bVar.gd()) != null) {
            gd5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryDocumentFragment.mi(ChatHistoryDocumentFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    public static final void mi(ChatHistoryDocumentFragment this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_online_document_tab"), TuplesKt.to("touin", companion.a().d(this$0.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDocumentViewModel) this$0.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDocumentViewModel) this$0.rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_back_button", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void ni() {
        c.b bVar;
        c.b bVar2;
        WeakReference<c.b> Zh = Zh();
        if (Zh != null && (bVar2 = Zh.get()) != null) {
            bVar2.f3(getString(R.string.f170728zk1), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$setRight$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                    }
                }

                private static final String a(ChatHistoryDocumentFragment chatHistoryDocumentFragment) {
                    ChatHistoryDocumentAdapter Xh;
                    int i3;
                    BaseApplication context = BaseApplication.getContext();
                    Xh = chatHistoryDocumentFragment.Xh();
                    if (Xh.W0()) {
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
                    ChatHistoryDocumentAdapter Xh;
                    ChatHistoryDocumentAdapter Xh2;
                    HistoryDtReportHelper.OperationContent operationContent;
                    Map mutableMapOf;
                    Map<String, Object> mutableMapOf2;
                    c.b bVar3;
                    EventCollector.getInstance().onViewClickedBefore(v3);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        Xh = ChatHistoryDocumentFragment.this.Xh();
                        final ChatHistoryDocumentFragment chatHistoryDocumentFragment = ChatHistoryDocumentFragment.this;
                        boolean V0 = Xh.V0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$setRight$1$onClick$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                ChatHistoryDocumentAdapter Xh3;
                                ChatHistoryDocumentAdapter Xh4;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    return;
                                }
                                Xh3 = ChatHistoryDocumentFragment.this.Xh();
                                Xh4 = ChatHistoryDocumentFragment.this.Xh();
                                Xh3.notifyItemRangeChanged(0, Xh4.m0().size(), new i(o.class, new o(z16)));
                            }
                        });
                        final ChatHistoryDocumentFragment chatHistoryDocumentFragment2 = ChatHistoryDocumentFragment.this;
                        WeakReference<c.b> Zh2 = chatHistoryDocumentFragment2.Zh();
                        if (Zh2 != null && (bVar3 = Zh2.get()) != null) {
                            bVar3.f3(a(chatHistoryDocumentFragment2), this);
                        }
                        if (V0) {
                            chatHistoryDocumentFragment2.yh(((ChatHistoryDocumentViewModel) chatHistoryDocumentFragment2.rh()).M1(), ((ChatHistoryDocumentViewModel) chatHistoryDocumentFragment2.rh()).N1(), BottomBarType.DOCUMENT, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$setRight$1$onClick$2$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
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
                                        ChatHistoryDocumentFragment.this.Vh(it);
                                    }
                                }
                            });
                            BaseHistoryFragment.wh(chatHistoryDocumentFragment2, false, false, 2, null);
                        } else {
                            chatHistoryDocumentFragment2.sh();
                        }
                        Xh2 = ChatHistoryDocumentFragment.this.Xh();
                        if (Xh2.W0()) {
                            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                        } else {
                            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                        }
                        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                        HistoryDtReportHelper a16 = companion.a();
                        Intrinsics.checkNotNull(v3);
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_online_document_tab"), TuplesKt.to("touin", companion.a().d(ChatHistoryDocumentFragment.this.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDocumentViewModel) ChatHistoryDocumentFragment.this.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDocumentViewModel) ChatHistoryDocumentFragment.this.rh()).N1()));
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
                        a16.k("em_bas_multiple_selection_button", v3, mutableMapOf2);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                    }
                    EventCollector.getInstance().onViewClicked(v3);
                }
            });
        }
        WeakReference<c.b> Zh2 = Zh();
        if (Zh2 != null && (bVar = Zh2.get()) != null) {
            bVar.setEnable(!Xh().m0().isEmpty());
        }
    }

    private final void oi() {
        if (Xh().X0().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.setMainTitle(R.string.zjs);
        create.addButton(R.string.zjr, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryDocumentFragment.pi(ChatHistoryDocumentFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void pi(final ChatHistoryDocumentFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(((ChatHistoryDocumentViewModel) this$0.rh()).M1(), ((ChatHistoryDocumentViewModel) this$0.rh()).N1(), ""), new ArrayList<>(this$0.Xh().X0()), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.document.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    ChatHistoryDocumentFragment.qi(ChatHistoryDocumentFragment.this, i16, str);
                }
            });
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(ChatHistoryDocumentFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatHistoryDocumentFragment", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new ChatHistoryDocumentFragment$showMultiDeleteActionSheet$1$1$1$1(this$0, null), 2, null);
        }
    }

    private final void ri() {
        if (Xh().X0().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.addButton(R.string.f170730zk3);
        create.addButton(R.string.f170731zk4);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryDocumentFragment.si(ChatHistoryDocumentFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void si(ChatHistoryDocumentFragment this$0, ActionSheet actionSheet, View view, int i3) {
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
        iChatHistoryForwardApi.forwardChatHistory(requireContext, i16, ((ChatHistoryDocumentViewModel) this$0.rh()).M1(), ((ChatHistoryDocumentViewModel) this$0.rh()).N1(), this$0.Xh().Z0());
        actionSheet.dismiss();
        this$0.Wh();
    }

    @Nullable
    public WeakReference<c.b> Zh() {
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
        Xh().c1(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$onHideTitleRightUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryDocumentAdapter Xh;
                ChatHistoryDocumentAdapter Xh2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                Xh = ChatHistoryDocumentFragment.this.Xh();
                Xh2 = ChatHistoryDocumentFragment.this.Xh();
                Xh.notifyItemRangeChanged(0, Xh2.m0().size(), new i(o.class, new o(z16)));
            }
        });
        ki();
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
        fi(view);
        View findViewById = view.findViewById(R.id.f792849c);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(Xh());
        recyclerView.addOnScrollListener(new c(recyclerView));
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Recycl\u2026\n            })\n        }");
        this.recyclerView = recyclerView;
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.f66403aj);
        Intrinsics.checkNotNullExpressionValue(qUISearchBar, "this");
        di(qUISearchBar);
        View findViewById2 = view.findViewById(R.id.bwb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.empty_container)");
        this.emptyContainer = (ViewGroup) findViewById2;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zkb);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_document)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup viewGroup = this.emptyContainer;
        RecyclerView recyclerView2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
            viewGroup = null;
        }
        viewGroup.addView(build);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryDocumentFragment$onViewCreated$4(this, null));
        LiveData obtainUiState = ((ChatHistoryDocumentViewModel) rh()).obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.document.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.document.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$onViewCreated$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.document.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.document.data.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof a.b) {
                    ChatHistoryDocumentFragment chatHistoryDocumentFragment = ChatHistoryDocumentFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryDocumentFragment.ai((a.b) it);
                } else if (it instanceof a.c) {
                    ChatHistoryDocumentFragment chatHistoryDocumentFragment2 = ChatHistoryDocumentFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryDocumentFragment2.bi((a.c) it);
                } else if (it instanceof a.C9530a) {
                    ChatHistoryDocumentFragment.this.ci(((a.C9530a) it).a());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.document.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryDocumentFragment.ji(Function1.this, obj);
            }
        });
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        ExtensionsKt.w(recyclerView2, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$onViewCreated$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
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
                smartRefreshLayout = ChatHistoryDocumentFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                return Boolean.valueOf(smartRefreshLayout.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$onViewCreated$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
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
                    ChatHistoryDocumentFragment.this.hi();
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
        ni();
        li();
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
        p pVar = new p(context, null, 2, 0 == true ? 1 : 0);
        this.binding = pVar;
        View mRv = pVar.getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDocumentViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDocumentViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_online_document_tab", mutableMapOf);
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

    public ChatHistoryDocumentFragment(int i3) {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.source = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new ChatHistoryDocumentFragment$documentAdapter$2(this));
        this.documentAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DocumentSearchDialog>() { // from class: com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment$searchDialog$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDocumentFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DocumentSearchDialog invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DocumentSearchDialog((ChatHistoryDocumentViewModel) ChatHistoryDocumentFragment.this.rh()) : (DocumentSearchDialog) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchDialog = lazy2;
        this.documentCountNode = new com.tencent.qqnt.chathistory.ui.document.data.model.a();
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    public /* synthetic */ ChatHistoryDocumentFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
