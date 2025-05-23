package com.tencent.qqnt.chathistory.ui.sticker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOEmotionAddApi;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.TailDefaultItemModel;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.sticker.adapter.ChatHistoryStickerAdapter;
import com.tencent.qqnt.chathistory.ui.sticker.data.a;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.chathistory.ui.sticker.viewmodel.ChatStickerViewModel;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.t;
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
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001NB\u0011\u0012\b\b\u0002\u0010,\u001a\u00020)\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J&\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010+R\u0016\u0010A\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010+R*\u0010J\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/ChatHistoryStickerFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/sticker/viewmodel/ChatStickerViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "Zh", "ci", "bi", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/a$a;", "uiState", "Vh", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/a$b;", "Uh", "", "hasMore", "Yh", "Th", "ii", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "oi", "mi", "ei", "di", WidgetCacheLunarData.JI, "Wh", "gi", "fi", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "t6", "ff", "", "E", "I", "source", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "G", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "H", "Landroid/view/ViewGroup;", "emptyView", "Z", "isLoadingMore", "Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter;", "J", "Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter;", "adapter", "K", "mFirstPosition", "L", "mLastPosition", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "M", "Ljava/lang/ref/WeakReference;", "Xh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "<init>", "(I)V", "N", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryStickerFragment extends BaseSubCategoryFragment<ChatStickerViewModel> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a N;

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: G, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup emptyView;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryStickerAdapter adapter;

    /* renamed from: K, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: L, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/ChatHistoryStickerFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        public static final /* synthetic */ int[] f353881a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50092);
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
                iArr[BottomBarOperationType.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f353881a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/chathistory/ui/sticker/ChatHistoryStickerFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
            } else {
                AbstractGifImage.pauseAll();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            RecyclerView recyclerView2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (!ChatHistoryStickerFragment.this.isResumed()) {
                return;
            }
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView recyclerView3 = ChatHistoryStickerFragment.this.recycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                recyclerView3 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int findFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView recyclerView4 = ChatHistoryStickerFragment.this.recycleView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                recyclerView4 = null;
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView4.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int findFirstVisibleItemPosition2 = ((GridLayoutManager) layoutManager2).findFirstVisibleItemPosition();
            RecyclerView recyclerView5 = ChatHistoryStickerFragment.this.recycleView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                recyclerView5 = null;
            }
            int childCount = findFirstVisibleItemPosition2 + recyclerView5.getChildCount();
            if (findFirstVisibleItemPosition != -1 && childCount != -1) {
                if (ChatHistoryStickerFragment.this.mFirstPosition == -1 || ChatHistoryStickerFragment.this.mLastPosition == -1) {
                    ChatHistoryStickerFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                    ChatHistoryStickerFragment.this.mLastPosition = childCount;
                    HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                    RecyclerView recyclerView6 = ChatHistoryStickerFragment.this.recycleView;
                    if (recyclerView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                        recyclerView2 = null;
                    } else {
                        recyclerView2 = recyclerView6;
                    }
                    HistoryDtReportHelper.j(a16, recyclerView2, childCount - findFirstVisibleItemPosition, 1, "em_bas_expression_entry", 0, null, 32, null);
                    return;
                }
                HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                RecyclerView recyclerView7 = ChatHistoryStickerFragment.this.recycleView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                    recyclerView7 = null;
                }
                HistoryDtReportHelper.h(a17, "em_bas_expression_entry", recyclerView7, z16, ChatHistoryStickerFragment.this.mFirstPosition, findFirstVisibleItemPosition, ChatHistoryStickerFragment.this.mLastPosition, childCount, 1, null, 256, null);
                ChatHistoryStickerFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                ChatHistoryStickerFragment.this.mLastPosition = childCount;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            N = new a(null);
        }
    }

    public ChatHistoryStickerFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ChatHistoryStickerFragment this$0, ChatHistoryStickerAdapter this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.ci();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Th() {
        int z16 = ExtensionsKt.z(this.adapter, ChatHistoryStickerFragment$appendTailNodeToAdapter$count$1.INSTANCE);
        if (z16 == 0) {
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.a1f);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.chat_history_tab_emotion)");
        TailDefaultItemModel tailDefaultItemModel = new TailDefaultItemModel(qqStr, z16);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryStickerFragment", "appendTailNodeToAdapter addTailNode count:" + z16);
        ChatHistoryStickerAdapter chatHistoryStickerAdapter = this.adapter;
        chatHistoryStickerAdapter.D0(chatHistoryStickerAdapter.m0().size(), tailDefaultItemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(a.b uiState) {
        boolean z16;
        List<SearchStickerItemModel> data = uiState.getData();
        List<SearchStickerItemModel> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        RecyclerView recyclerView = null;
        if (z16) {
            ViewGroup viewGroup = this.emptyView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            RecyclerView recyclerView2 = this.recycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
        } else {
            ViewGroup viewGroup2 = this.emptyView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            RecyclerView recyclerView3 = this.recycleView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
            this.adapter.B0(ExtensionsKt.f(data, ChatHistoryStickerFragment$dealFirstPageData$1.INSTANCE));
            AbstractGifImage.resumeAll();
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryStickerFragment", "dealFirstPage isResumed " + isResumed() + " hasMore " + uiState.a());
        if (isResumed()) {
            ii();
        }
        Yh(uiState.a());
        if (!isResumed()) {
            AbstractGifImage.pauseAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(a.C9551a uiState) {
        List<SearchStickerItemModel> data = uiState.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryStickerFragment", "loadMore result " + data.size());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.x();
        if (data.isEmpty()) {
            this.adapter.z0(false);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout2 = smartRefreshLayout3;
            }
            smartRefreshLayout2.setEnableLoadMore(false);
        } else {
            com.tencent.qqnt.chathistory.ui.sticker.data.model.a a16 = this.adapter.a1();
            if (a16 == null) {
                return;
            } else {
                ExtensionsKt.g(a16, data, this.adapter, ChatHistoryStickerFragment$dealLoadMoreData$1.INSTANCE);
            }
        }
        Yh(uiState.a());
        this.isLoadingMore = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        c.b bVar;
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar = Xh.get()) != null) {
            bVar.k8(getString(R.string.f170728zk1));
        }
        this.adapter.W0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$exitMultiSelectMode$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryStickerAdapter chatHistoryStickerAdapter;
                ChatHistoryStickerAdapter chatHistoryStickerAdapter2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                chatHistoryStickerAdapter = ChatHistoryStickerFragment.this.adapter;
                chatHistoryStickerAdapter2 = ChatHistoryStickerFragment.this.adapter;
                chatHistoryStickerAdapter.notifyItemRangeChanged(0, chatHistoryStickerAdapter2.m0().size(), new i(o.class, new o(z16)));
            }
        });
        sh();
    }

    private final void Yh(boolean hasMore) {
        this.adapter.z0(hasMore);
        if (!hasMore) {
            Th();
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(hasMore);
    }

    private final void Zh() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
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
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.Q(true);
        SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
        if (smartRefreshLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout5;
        }
        smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.sticker.c
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryStickerFragment.ai(ChatHistoryStickerFragment.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ChatHistoryStickerFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.ci();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.adapter, r1.m0().size() - 1, false, false, null, 14, null);
    }

    private final void bi() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryStickerFragment$initStateObserver$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryStickerFragment$loadMore$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void di() {
        int collectionSizeOrDefault;
        if (this.adapter.b1().isEmpty()) {
            return;
        }
        List<MsgRecord> d16 = this.adapter.d1();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = d16.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (((ChatStickerViewModel) rh()).M1() == 4) {
            IAIOEmotionAddApi iAIOEmotionAddApi = (IAIOEmotionAddApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmotionAddApi.class);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iAIOEmotionAddApi.addEmotion(requireContext, arrayList2);
        } else {
            IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            iAIOFavApi.multiFav(requireContext2, arrayList2);
        }
        Wh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void ei() {
        if (this.adapter.b1().isEmpty()) {
            return;
        }
        ChatHistoryStickerAdapter chatHistoryStickerAdapter = this.adapter;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        List<com.tencent.qqnt.chathistory.ui.base.item.b> c16 = this.adapter.c1();
        Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel>");
        chatHistoryStickerAdapter.f1(requireActivity, requireContext, c16);
        Wh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void fi() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        RecyclerView recyclerView;
        c.b bVar;
        if (this.adapter.X0()) {
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
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_emoticon_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatStickerViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatStickerViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.r(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        HistoryDtReportHelper a17 = companion.a();
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            recyclerView = null;
        } else {
            recyclerView = recyclerView2;
        }
        HistoryDtReportHelper.j(a17, recyclerView, this.mLastPosition - this.mFirstPosition, 1, "em_bas_expression_entry", 1, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void gi() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        View gd5;
        c.b bVar2;
        if (this.adapter.X0()) {
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
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_emoticon_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatStickerViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatStickerViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        WeakReference<c.b> Xh2 = Xh();
        if (Xh2 != null && (bVar = Xh2.get()) != null && (gd5 = bVar.gd()) != null) {
            gd5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryStickerFragment.hi(ChatHistoryStickerFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    public static final void hi(ChatHistoryStickerFragment this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_emoticon_tab"), TuplesKt.to("touin", companion.a().d(this$0.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatStickerViewModel) this$0.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatStickerViewModel) this$0.rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_back_button", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void ii() {
        c.b bVar;
        c.b bVar2;
        WeakReference<c.b> Xh = Xh();
        if (Xh != null && (bVar2 = Xh.get()) != null) {
            bVar2.f3(getString(R.string.f170728zk1), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$setRight$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
                    }
                }

                private static final String a(ChatHistoryStickerFragment chatHistoryStickerFragment) {
                    ChatHistoryStickerAdapter chatHistoryStickerAdapter;
                    int i3;
                    BaseApplication context = BaseApplication.getContext();
                    chatHistoryStickerAdapter = chatHistoryStickerFragment.adapter;
                    if (chatHistoryStickerAdapter.X0()) {
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
                    ChatHistoryStickerAdapter chatHistoryStickerAdapter;
                    ChatHistoryStickerAdapter chatHistoryStickerAdapter2;
                    HistoryDtReportHelper.OperationContent operationContent;
                    Map mutableMapOf;
                    Map<String, Object> mutableMapOf2;
                    c.b bVar3;
                    EventCollector.getInstance().onViewClickedBefore(v3);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        chatHistoryStickerAdapter = ChatHistoryStickerFragment.this.adapter;
                        final ChatHistoryStickerFragment chatHistoryStickerFragment = ChatHistoryStickerFragment.this;
                        boolean W0 = chatHistoryStickerAdapter.W0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$setRight$1$onClick$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z16) {
                                ChatHistoryStickerAdapter chatHistoryStickerAdapter3;
                                ChatHistoryStickerAdapter chatHistoryStickerAdapter4;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    return;
                                }
                                chatHistoryStickerAdapter3 = ChatHistoryStickerFragment.this.adapter;
                                chatHistoryStickerAdapter4 = ChatHistoryStickerFragment.this.adapter;
                                chatHistoryStickerAdapter3.notifyItemRangeChanged(0, chatHistoryStickerAdapter4.m0().size(), new i(o.class, new o(z16)));
                            }
                        });
                        final ChatHistoryStickerFragment chatHistoryStickerFragment2 = ChatHistoryStickerFragment.this;
                        WeakReference<c.b> Xh2 = chatHistoryStickerFragment2.Xh();
                        if (Xh2 != null && (bVar3 = Xh2.get()) != null) {
                            bVar3.f3(a(chatHistoryStickerFragment2), this);
                        }
                        if (W0) {
                            chatHistoryStickerFragment2.yh(((ChatStickerViewModel) chatHistoryStickerFragment2.rh()).M1(), ((ChatStickerViewModel) chatHistoryStickerFragment2.rh()).N1(), BottomBarType.STICKER, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$setRight$1$onClick$2$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
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
                                        ChatHistoryStickerFragment.this.oi(it);
                                    }
                                }
                            });
                            BaseHistoryFragment.wh(chatHistoryStickerFragment2, false, false, 2, null);
                        } else {
                            chatHistoryStickerFragment2.sh();
                        }
                        chatHistoryStickerAdapter2 = ChatHistoryStickerFragment.this.adapter;
                        if (chatHistoryStickerAdapter2.X0()) {
                            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                        } else {
                            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                        }
                        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                        HistoryDtReportHelper a16 = companion.a();
                        Intrinsics.checkNotNull(v3);
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_emoticon_tab"), TuplesKt.to("touin", companion.a().d(ChatHistoryStickerFragment.this.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatStickerViewModel) ChatHistoryStickerFragment.this.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatStickerViewModel) ChatHistoryStickerFragment.this.rh()).N1()));
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
            bVar.setEnable(!this.adapter.m0().isEmpty());
        }
    }

    private final void ji() {
        if (this.adapter.b1().isEmpty()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.setMainTitle(R.string.zjs);
        create.addButton(R.string.zjr, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryStickerFragment.ki(ChatHistoryStickerFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ki(final ChatHistoryStickerFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(((ChatStickerViewModel) this$0.rh()).M1(), ((ChatStickerViewModel) this$0.rh()).N1(), ""), new ArrayList<>(this$0.adapter.b1()), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.sticker.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    ChatHistoryStickerFragment.li(ChatHistoryStickerFragment.this, i16, str);
                }
            });
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(ChatHistoryStickerFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatHistoryStickerFragment", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            LifecycleOwnerKt.getLifecycleScope(this$0).launchWhenCreated(new ChatHistoryStickerFragment$showMultiDeleteActionSheet$1$1$1$1(this$0, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void mi() {
        if (this.adapter.b1().isEmpty()) {
            return;
        }
        if (((ChatStickerViewModel) rh()).M1() == 4) {
            IChatHistoryForwardApi iChatHistoryForwardApi = (IChatHistoryForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IChatHistoryForwardApi.class);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iChatHistoryForwardApi.forwardChatHistory(requireContext, 1, ((ChatStickerViewModel) rh()).M1(), ((ChatStickerViewModel) rh()).N1(), this.adapter.d1());
            Wh();
            return;
        }
        final ActionSheet create = ActionSheet.create(requireContext());
        create.addButton(R.string.f170730zk3);
        create.addButton(R.string.f170731zk4);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryStickerFragment.ni(ChatHistoryStickerFragment.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ni(ChatHistoryStickerFragment this$0, ActionSheet actionSheet, View view, int i3) {
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
        iChatHistoryForwardApi.forwardChatHistory(requireContext, i16, ((ChatStickerViewModel) this$0.rh()).M1(), ((ChatStickerViewModel) this$0.rh()).N1(), this$0.adapter.d1());
        actionSheet.dismiss();
        this$0.Wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(BottomBarOperationType operationType) {
        int i3 = b.f353881a[operationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        ji();
                        return;
                    }
                    return;
                }
                di();
                return;
            }
            ei();
            return;
        }
        mi();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        c.a.a(this);
        fi();
        this.adapter.g1(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$onHideTitleRightUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistoryStickerAdapter chatHistoryStickerAdapter;
                ChatHistoryStickerAdapter chatHistoryStickerAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                chatHistoryStickerAdapter = ChatHistoryStickerFragment.this.adapter;
                chatHistoryStickerAdapter2 = ChatHistoryStickerFragment.this.adapter;
                chatHistoryStickerAdapter.notifyItemRangeChanged(0, chatHistoryStickerAdapter2.m0().size(), new i(o.class, new o(z16)));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.v7b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.flEmptyContainer)");
        this.emptyView = (ViewGroup) findViewById2;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zkk);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_sticker)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        ViewGroup viewGroup = this.emptyView;
        RecyclerView recyclerView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            viewGroup = null;
        }
        viewGroup.addView(build);
        Zh();
        View findViewById3 = view.findViewById(R.id.f792849c);
        RecyclerView recyclerView2 = (RecyclerView) findViewById3;
        recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        recyclerView2.setAdapter(this.adapter);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<Recycl\u2026apter = adapter\n        }");
        this.recycleView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            recyclerView2 = null;
        }
        recyclerView2.addOnScrollListener(new c());
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryStickerFragment$onViewCreated$4(this, null));
        bi();
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            recyclerView = recyclerView3;
        }
        ExtensionsKt.w(recyclerView, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$onViewCreated$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
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
                smartRefreshLayout = ChatHistoryStickerFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                return Boolean.valueOf(smartRefreshLayout.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$onViewCreated$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
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
                    ChatHistoryStickerFragment.this.ci();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        c.a.b(this);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryStickerFragment", "onShowTitleRightUI");
        ii();
        gi();
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
        View mRv = new t(context, null, 2, 0 == true ? 1 : 0).getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatStickerViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatStickerViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_emoticon_tab", mutableMapOf);
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

    public ChatHistoryStickerFragment(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.source = i3;
        final ChatHistoryStickerAdapter chatHistoryStickerAdapter = new ChatHistoryStickerAdapter(LifecycleOwnerKt.getLifecycleScope(this), i3, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment$adapter$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerFragment.this);
                }
            }

            public final void invoke(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryStickerFragment.this.vh(z16, z17);
                } else {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }
        });
        chatHistoryStickerAdapter.C0(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryStickerFragment.Sh(ChatHistoryStickerFragment.this, chatHistoryStickerAdapter, view);
            }
        });
        this.adapter = chatHistoryStickerAdapter;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    public /* synthetic */ ChatHistoryStickerFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
