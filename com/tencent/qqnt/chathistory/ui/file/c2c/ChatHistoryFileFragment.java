package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi;
import com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment;
import com.tencent.qqnt.chathistory.ui.file.c2c.adapter.ChatHistoryFileAdapter;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.b;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.dialog.C2CFileSearchDialog;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0011\u0012\b\b\u0002\u0010(\u001a\u00020%\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J&\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R*\u00109\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010:R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010'R\u0016\u0010L\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010'\u00a8\u0006Q"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "oi", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "Uh", "mi", "bi", "ai", "ci", WidgetCacheLunarData.JI, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$a;", "state", "di", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$b;", "ei", "Landroid/view/View;", "root", "initView", "Zh", "Th", "hi", "gi", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "t6", "ff", "", "E", "I", "source", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", UserInfo.SEX_FEMALE, "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "H", "Ljava/lang/ref/WeakReference;", "Wh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "Landroid/view/ViewGroup;", "emptyViewContainer", "J", "Landroid/view/View;", "headContainer", "", "K", "Z", "isLoadingMore", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter;", "L", "Lkotlin/Lazy;", "Vh", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter;", "fileAdapter", "M", "mFirstPosition", "N", "mLastPosition", "<init>", "(I)V", "P", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryFileFragment extends BaseSubCategoryFragment<ChatHistoryFileModel> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a P;

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup emptyViewContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private View headContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy fileAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: N, reason: from kotlin metadata */
    private int mLastPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        public static final /* synthetic */ int[] f353517a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44378);
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
                iArr[BottomBarOperationType.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BottomBarOperationType.FAVORITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BottomBarOperationType.WEIYUN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BottomBarOperationType.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f353517a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileFragment$c", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/n;", "Landroid/view/View;", "headerView", "", "adapterPosition", "", "a", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements n {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ChatHistoryFileFragment this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.qqnt.expandRecyclerView.adapter.provider.b.M0(this$0.Vh(), i3, false, false, null, 14, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.qqnt.chathistory.ui.file.c2c.n
        public void a(@Nullable View headerView, final int adapterPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) headerView, adapterPosition);
            } else if (headerView != null) {
                final ChatHistoryFileFragment chatHistoryFileFragment = ChatHistoryFileFragment.this;
                headerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatHistoryFileFragment.c.d(ChatHistoryFileFragment.this, adapterPosition, view);
                    }
                });
            }
        }

        @Override // com.tencent.qqnt.chathistory.ui.file.c2c.n
        public void b(@Nullable View headerView, int adapterPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) headerView, adapterPosition);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353520e;

        d(RecyclerView recyclerView) {
            this.f353520e = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this, (Object) recyclerView);
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
            if (!ChatHistoryFileFragment.this.isResumed()) {
                return;
            }
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353520e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.file.c2c.StickyLayoutManager");
            int findFirstVisibleItemPosition = ((o) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353520e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.file.c2c.StickyLayoutManager");
            int findFirstVisibleItemPosition2 = ((o) layoutManager2).findFirstVisibleItemPosition() + this.f353520e.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (ChatHistoryFileFragment.this.mFirstPosition == -1 || ChatHistoryFileFragment.this.mLastPosition == -1) {
                    ChatHistoryFileFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                    ChatHistoryFileFragment.this.mLastPosition = findFirstVisibleItemPosition2;
                    HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                    HistoryDtReportHelper a16 = companion.a();
                    RecyclerView it = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    HistoryDtReportHelper.j(a16, it, i3, 1, "em_bas_file_entry", 0, null, 32, null);
                    HistoryDtReportHelper a17 = companion.a();
                    RecyclerView it5 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    a17.f(it5, i3, 0);
                    return;
                }
                if (z16) {
                    HistoryDtReportHelper.Companion companion2 = HistoryDtReportHelper.INSTANCE;
                    HistoryDtReportHelper a18 = companion2.a();
                    RecyclerView it6 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it6, "it");
                    HistoryDtReportHelper.j(a18, it6, findFirstVisibleItemPosition - ChatHistoryFileFragment.this.mFirstPosition, 1, "em_bas_file_entry", 1, null, 32, null);
                    HistoryDtReportHelper a19 = companion2.a();
                    RecyclerView it7 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it7, "it");
                    a19.f(it7, findFirstVisibleItemPosition - ChatHistoryFileFragment.this.mFirstPosition, 1);
                    HistoryDtReportHelper a26 = companion2.a();
                    RecyclerView it8 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it8, "it");
                    HistoryDtReportHelper.j(a26, it8, findFirstVisibleItemPosition2 - ChatHistoryFileFragment.this.mLastPosition, 1, "em_bas_file_entry", 0, null, 32, null);
                    HistoryDtReportHelper a27 = companion2.a();
                    RecyclerView it9 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it9, "it");
                    a27.f(it9, findFirstVisibleItemPosition2 - ChatHistoryFileFragment.this.mLastPosition, 0);
                } else {
                    HistoryDtReportHelper.Companion companion3 = HistoryDtReportHelper.INSTANCE;
                    HistoryDtReportHelper a28 = companion3.a();
                    RecyclerView it10 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it10, "it");
                    HistoryDtReportHelper.j(a28, it10, ChatHistoryFileFragment.this.mFirstPosition - findFirstVisibleItemPosition, 1, "em_bas_file_entry", 0, null, 32, null);
                    HistoryDtReportHelper a29 = companion3.a();
                    RecyclerView it11 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it11, "it");
                    a29.f(it11, ChatHistoryFileFragment.this.mFirstPosition - findFirstVisibleItemPosition, 0);
                    HistoryDtReportHelper a36 = companion3.a();
                    RecyclerView it12 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it12, "it");
                    HistoryDtReportHelper.j(a36, it12, ChatHistoryFileFragment.this.mLastPosition - findFirstVisibleItemPosition2, 1, "em_bas_file_entry", 1, null, 32, null);
                    HistoryDtReportHelper a37 = companion3.a();
                    RecyclerView it13 = this.f353520e;
                    Intrinsics.checkNotNullExpressionValue(it13, "it");
                    a37.f(it13, ChatHistoryFileFragment.this.mLastPosition - findFirstVisibleItemPosition2, 1);
                }
                ChatHistoryFileFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                ChatHistoryFileFragment.this.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            P = new a(null);
        }
    }

    public ChatHistoryFileFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        c.b bVar;
        WeakReference<c.b> Wh = Wh();
        if (Wh != null && (bVar = Wh.get()) != null) {
            bVar.k8(getString(R.string.f170728zk1));
        }
        Vh().X0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$exitMultiSelectMode$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ChatHistoryFileFragment.this.Vh().notifyItemRangeChanged(0, ChatHistoryFileFragment.this.Vh().m0().size(), new com.tencent.qqnt.chathistory.util.i(com.tencent.qqnt.chathistory.ui.base.o.class, new com.tencent.qqnt.chathistory.ui.base.o(z16)));
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(BottomBarOperationType operationType) {
        int i3 = b.f353517a[operationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            ji();
                            return;
                        }
                        return;
                    }
                    ci();
                    return;
                }
                ai();
                return;
            }
            bi();
            return;
        }
        mi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatHistoryFileAdapter Vh() {
        return (ChatHistoryFileAdapter) this.fileAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Xh(ChatHistoryFileFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new C2CFileSearchDialog((ChatHistoryFileModel) this$0.rh()).show(this$0.getChildFragmentManager(), "searchDialog");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        HistoryDtReportHelper.n(a16, it, "em_bas_search_box", null, 4, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ChatHistoryFileFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.Zh();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.Vh(), this$0.Vh().m0().size() - 1, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryFileFragment$loadMore$1(this, null), 3, null);
    }

    private final void ai() {
        int collectionSizeOrDefault;
        if (Vh().d1().isEmpty()) {
            return;
        }
        List<MsgRecord> f16 = Vh().f1();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(f16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = f16.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iAIOFavApi.multiFav(requireContext, arrayList2);
        Th();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void bi() {
        int i3;
        if (Vh().d1().isEmpty()) {
            return;
        }
        ChatHistoryFileAdapter Vh = Vh();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        List<com.tencent.qqnt.chathistory.ui.base.item.b> e16 = Vh().e1();
        Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel>");
        if (Vh.h1(requireActivity, e16)) {
            i3 = R.string.zjx;
        } else {
            i3 = R.string.zkq;
        }
        String string = getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "if (isAllDownloading) ge\u2026y_start_file_downloading)");
        QQToast.makeText(getContext(), string, 0).show();
        Th();
    }

    private final void ci() {
        if (Vh().d1().isEmpty()) {
            return;
        }
        IChatHistorySave2WeiYunApi iChatHistorySave2WeiYunApi = (IChatHistorySave2WeiYunApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IChatHistorySave2WeiYunApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iChatHistorySave2WeiYunApi.chatHistorySave2WeiYun(requireContext, Vh().f1());
        Th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(b.a state) {
        boolean z16;
        List<com.tencent.qqnt.chathistory.ui.base.item.a> f16 = ExtensionsKt.f(state.getData(), ChatHistoryFileFragment$notifyFirstPageUI$1.INSTANCE);
        if (f16 != null && !f16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        SmartRefreshLayout smartRefreshLayout = null;
        if (z16) {
            ViewGroup viewGroup = this.emptyViewContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.setVisibility(8);
            View view = this.headContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headContainer");
                view = null;
            }
            view.setVisibility(8);
        } else {
            ViewGroup viewGroup2 = this.emptyViewContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setVisibility(0);
            View view2 = this.headContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headContainer");
                view2 = null;
            }
            view2.setVisibility(0);
            Vh().B0(f16);
        }
        oi();
        Vh().z0(state.a());
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.setEnableLoadMore(state.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(b.C9534b state) {
        List<FileItemModel> data = state.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryFileFragment", "loadMore result " + data.size());
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
            com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a b16 = Vh().b1();
            if (b16 == null) {
                return;
            } else {
                ExtensionsKt.g(b16, data, Vh(), ChatHistoryFileFragment$notifyMorePageUI$1.INSTANCE);
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
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void gi() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        RecyclerView recyclerView;
        c.b bVar;
        if (Vh().Z0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Wh = Wh();
        RecyclerView recyclerView2 = null;
        if (Wh != null && (bVar = Wh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_file_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryFileModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryFileModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.r(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        HistoryDtReportHelper a17 = companion.a();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        } else {
            recyclerView = recyclerView3;
        }
        HistoryDtReportHelper.j(a17, recyclerView, this.mLastPosition - this.mFirstPosition, 1, "em_bas_file_entry", 1, null, 32, null);
        HistoryDtReportHelper a18 = companion.a();
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        a18.f(recyclerView2, this.mLastPosition - this.mFirstPosition, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void hi() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        View gd5;
        c.b bVar2;
        if (Vh().Z0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Wh = Wh();
        if (Wh != null && (bVar2 = Wh.get()) != null) {
            view = bVar2.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_file_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryFileModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryFileModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        WeakReference<c.b> Wh2 = Wh();
        if (Wh2 != null && (bVar = Wh2.get()) != null && (gd5 = bVar.gd()) != null) {
            gd5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryFileFragment.ii(ChatHistoryFileFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    public static final void ii(ChatHistoryFileFragment this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_file_tab"), TuplesKt.to("touin", companion.a().d(this$0.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryFileModel) this$0.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryFileModel) this$0.rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_back_button", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void initView(View root) {
        View findViewById = root.findViewById(R.id.f72183q6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<SmartR\u2026yout>(R.id.refreshLayout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        smartRefreshLayout.X(new HistoryLoadMoreFooter(requireContext));
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.g
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryFileFragment.Yh(ChatHistoryFileFragment.this, fVar);
            }
        });
        View findViewById2 = root.findViewById(R.id.v5a);
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        recyclerView2.setAdapter(Vh());
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        recyclerView2.setItemAnimator(null);
        o oVar = new o(requireContext(), Vh());
        oVar.v(new c());
        recyclerView2.setLayoutManager(oVar);
        recyclerView2.addOnScrollListener(new d(recyclerView2));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById<Recycl\u2026\n            })\n        }");
        this.recyclerView = recyclerView2;
        QUISearchBar qUISearchBar = (QUISearchBar) root.findViewById(R.id.f66403aj);
        qUISearchBar.getInputWidget().setHint(HardCodeUtil.qqStr(R.string.f170725a14));
        qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryFileFragment.Xh(ChatHistoryFileFragment.this, view);
            }
        });
        View findViewById3 = root.findViewById(R.id.v7b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.flEmptyContainer)");
        this.emptyViewContainer = (ViewGroup) findViewById3;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zkd);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_file)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        ViewGroup viewGroup = this.emptyViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
            viewGroup = null;
        }
        viewGroup.addView(build);
        View findViewById4 = root.findViewById(R.id.f165675d35);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.head_container)");
        this.headContainer = findViewById4;
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.i(false);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        ExtensionsKt.w(recyclerView, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$initView$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                SmartRefreshLayout smartRefreshLayout4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                smartRefreshLayout4 = ChatHistoryFileFragment.this.refreshLayout;
                if (smartRefreshLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout4 = null;
                }
                return Boolean.valueOf(smartRefreshLayout4.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$initView$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
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
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ChatHistoryFileFragment.this.Zh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private final void ji() {
        if (Vh().d1().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.setMainTitle(R.string.zjs);
        create.addButton(R.string.zjr, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryFileFragment.ki(ChatHistoryFileFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ki(final ChatHistoryFileFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(((ChatHistoryFileModel) this$0.rh()).M1(), ((ChatHistoryFileModel) this$0.rh()).N1(), ""), new ArrayList<>(this$0.Vh().d1()), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    ChatHistoryFileFragment.li(ChatHistoryFileFragment.this, i16, str);
                }
            });
            ((IChatHistoryMultiActionApi) QRoute.api(IChatHistoryMultiActionApi.class)).deleteChatFile(new Contact(((ChatHistoryFileModel) this$0.rh()).M1(), ((ChatHistoryFileModel) this$0.rh()).N1(), ""), this$0.Vh().f1(), ChatHistoryFileFragment$showMultiDeleteActionSheet$1$1$2.INSTANCE);
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(ChatHistoryFileFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatHistoryFileFragment", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new ChatHistoryFileFragment$showMultiDeleteActionSheet$1$1$1$1(this$0, null), 2, null);
        }
    }

    private final void mi() {
        if (Vh().d1().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.addButton(R.string.f170730zk3);
        create.addButton(R.string.f170731zk4);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryFileFragment.ni(ChatHistoryFileFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ni(ChatHistoryFileFragment this$0, ActionSheet actionSheet, View view, int i3) {
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
        iChatHistoryForwardApi.forwardChatHistory(requireContext, i16, ((ChatHistoryFileModel) this$0.rh()).M1(), ((ChatHistoryFileModel) this$0.rh()).N1(), this$0.Vh().f1());
        actionSheet.dismiss();
        this$0.Th();
    }

    private final void oi() {
        c.b bVar;
        c.b bVar2;
        if (!isResumed()) {
            return;
        }
        WeakReference<c.b> Wh = Wh();
        if (Wh != null && (bVar2 = Wh.get()) != null) {
            bVar2.f3(getString(R.string.f170728zk1), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$showUITitleRight$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                    }
                }

                private static final String a(ChatHistoryFileFragment chatHistoryFileFragment) {
                    int i3;
                    BaseApplication context = BaseApplication.getContext();
                    if (chatHistoryFileFragment.Vh().Z0()) {
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
                    HistoryDtReportHelper.OperationContent operationContent;
                    Map mutableMapOf;
                    Map<String, Object> mutableMapOf2;
                    c.b bVar3;
                    EventCollector.getInstance().onViewClickedBefore(v3);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ChatHistoryFileAdapter Vh = ChatHistoryFileFragment.this.Vh();
                        final ChatHistoryFileFragment chatHistoryFileFragment = ChatHistoryFileFragment.this;
                        boolean X0 = Vh.X0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$showUITitleRight$1$onClick$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    ChatHistoryFileFragment.this.Vh().notifyItemRangeChanged(0, ChatHistoryFileFragment.this.Vh().m0().size(), new com.tencent.qqnt.chathistory.util.i(com.tencent.qqnt.chathistory.ui.base.o.class, new com.tencent.qqnt.chathistory.ui.base.o(z16)));
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                }
                            }
                        });
                        final ChatHistoryFileFragment chatHistoryFileFragment2 = ChatHistoryFileFragment.this;
                        WeakReference<c.b> Wh2 = chatHistoryFileFragment2.Wh();
                        if (Wh2 != null && (bVar3 = Wh2.get()) != null) {
                            bVar3.f3(a(chatHistoryFileFragment2), this);
                        }
                        if (X0) {
                            chatHistoryFileFragment2.yh(((ChatHistoryFileModel) chatHistoryFileFragment2.rh()).M1(), ((ChatHistoryFileModel) chatHistoryFileFragment2.rh()).N1(), BottomBarType.FILE, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$showUITitleRight$1$onClick$2$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
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
                                        ChatHistoryFileFragment.this.Uh(it);
                                    }
                                }
                            });
                            BaseHistoryFragment.wh(chatHistoryFileFragment2, false, false, 2, null);
                        } else {
                            chatHistoryFileFragment2.sh();
                        }
                        if (ChatHistoryFileFragment.this.Vh().Z0()) {
                            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                        } else {
                            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                        }
                        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                        HistoryDtReportHelper a16 = companion.a();
                        Intrinsics.checkNotNull(v3);
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_file_tab"), TuplesKt.to("touin", companion.a().d(ChatHistoryFileFragment.this.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryFileModel) ChatHistoryFileFragment.this.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryFileModel) ChatHistoryFileFragment.this.rh()).N1()));
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
                        a16.k("em_bas_multiple_selection_button", v3, mutableMapOf2);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                    }
                    EventCollector.getInstance().onViewClicked(v3);
                }
            });
        }
        WeakReference<c.b> Wh2 = Wh();
        if (Wh2 != null && (bVar = Wh2.get()) != null) {
            bVar.setEnable(!Vh().m0().isEmpty());
        }
    }

    @Nullable
    public WeakReference<c.b> Wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
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
        gi();
        Vh().i1(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$onHideTitleRightUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryFileFragment.this.Vh().notifyItemRangeChanged(0, ChatHistoryFileFragment.this.Vh().m0().size(), new com.tencent.qqnt.chathistory.util.i(com.tencent.qqnt.chathistory.ui.base.o.class, new com.tencent.qqnt.chathistory.ui.base.o(z16)));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        LiveData obtainUiState = ((ChatHistoryFileModel) rh()).obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.file.c2c.data.b, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.file.c2c.data.b, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.file.c2c.data.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.file.c2c.data.b state) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) state);
                    return;
                }
                if (state instanceof b.a) {
                    ChatHistoryFileFragment chatHistoryFileFragment = ChatHistoryFileFragment.this;
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    chatHistoryFileFragment.di((b.a) state);
                } else if (state instanceof b.C9534b) {
                    ChatHistoryFileFragment chatHistoryFileFragment2 = ChatHistoryFileFragment.this;
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    chatHistoryFileFragment2.ei((b.C9534b) state);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryFileFragment.fi(Function1.this, obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryFileFragment$onViewCreated$2(this, null));
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c.a.b(this);
        oi();
        Vh().notifyItemRangeChanged(0, Vh().m0().size());
        hi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.e2s, container, false);
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryFileModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryFileModel) rh()).N1()));
        a16.v(requireActivity, rootView, "pg_bas_file_tab", mutableMapOf);
        return rootView;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void y5(@Nullable WeakReference<c.b> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
        } else {
            this.titleRightDelegate = weakReference;
        }
    }

    public ChatHistoryFileFragment(int i3) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.source = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new ChatHistoryFileFragment$fileAdapter$2(this));
        this.fileAdapter = lazy;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    public /* synthetic */ ChatHistoryFileFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
