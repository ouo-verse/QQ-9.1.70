package com.tencent.qqnt.chathistory.ui.media;

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
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IAIOGroupAlbumForwardApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.aio.adapter.api.IChatHistorySave2WeiYunApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.TailDefaultItemModel;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter;
import com.tencent.qqnt.chathistory.ui.media.data.a;
import com.tencent.qqnt.chathistory.ui.media.data.b;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaModel;
import com.tencent.qqnt.chathistory.ui.media.viewmodel.ChatHistoryMediaViewModel;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.r;
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
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001QB\u0011\u0012\b\b\u0002\u0010/\u001a\u00020,\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J$\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010.R\u0016\u0010D\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010.R*\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/ChatHistoryMediaFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/media/viewmodel/ChatHistoryMediaViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "operationType", "", "ci", "ni", "ei", "di", "gi", "fi", "ki", "ai", "Lcom/tencent/qqnt/chathistory/ui/media/data/a$c;", "uiState", "Uh", "Lcom/tencent/qqnt/chathistory/ui/media/data/a$b;", "Th", "", "hasMore", "Xh", "Sh", "Yh", "", "tag", "bi", "Vh", "pi", "ii", "hi", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "t6", "ff", "", "E", "I", "source", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "G", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "H", "Landroid/view/ViewGroup;", "emptyView", "Z", "isLoadingMore", "Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter;", "J", "Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter;", "adapter", "K", "mFirstPosition", "L", "mLastPosition", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "M", "Ljava/lang/ref/WeakReference;", "Wh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "<init>", "(I)V", "N", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryMediaFragment extends BaseSubCategoryFragment<ChatHistoryMediaViewModel> implements com.tencent.qqnt.chathistory.ui.category.c {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private final ChatHistoryMediaAdapter adapter;

    /* renamed from: K, reason: from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: L, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/ChatHistoryMediaFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$a, reason: from kotlin metadata */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f353745a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47756);
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
            try {
                iArr[BottomBarOperationType.GROUPALBUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f353745a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/media/ChatHistoryMediaFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f353747e;

        c(RecyclerView recyclerView) {
            this.f353747e = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this, (Object) recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Map<String, Object> mutableMapOf;
            Map<String, Object> mutableMapOf2;
            HistoryDtReportHelper.OperationContent operationContent;
            Map<String, Object> mutableMapOf3;
            Map<String, Object> mutableMapOf4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (!ChatHistoryMediaFragment.this.isResumed()) {
                return;
            }
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RecyclerView.LayoutManager layoutManager = this.f353747e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int findFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = this.f353747e.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            int findFirstVisibleItemPosition2 = ((GridLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353747e.getChildCount();
            if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                if (ChatHistoryMediaFragment.this.mFirstPosition == -1 || ChatHistoryMediaFragment.this.mLastPosition == -1) {
                    ChatHistoryMediaFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                    ChatHistoryMediaFragment.this.mLastPosition = findFirstVisibleItemPosition2;
                    HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                    HistoryDtReportHelper a16 = companion.a();
                    RecyclerView it = this.f353747e;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    int i3 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                    HistoryDtReportHelper.OperationContent operationContent2 = HistoryDtReportHelper.OperationContent.NORMAL;
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent2.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.PIC.ordinal())));
                    a16.i(it, i3, 1, "em_bas_photovideo_entry", 0, mutableMapOf);
                    HistoryDtReportHelper a17 = companion.a();
                    RecyclerView it5 = this.f353747e;
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent2.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.VIDEO.ordinal())));
                    a17.i(it5, i3, 2, "em_bas_photovideo_entry", 0, mutableMapOf2);
                    return;
                }
                if (ChatHistoryMediaFragment.this.adapter.Z0()) {
                    operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                } else {
                    operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                }
                HistoryDtReportHelper.OperationContent operationContent3 = operationContent;
                HistoryDtReportHelper.Companion companion2 = HistoryDtReportHelper.INSTANCE;
                HistoryDtReportHelper a18 = companion2.a();
                RecyclerView it6 = this.f353747e;
                Intrinsics.checkNotNullExpressionValue(it6, "it");
                int i16 = ChatHistoryMediaFragment.this.mFirstPosition;
                int i17 = ChatHistoryMediaFragment.this.mLastPosition;
                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent3.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.PIC.ordinal())));
                a18.g("em_bas_photovideo_entry", it6, z16, i16, findFirstVisibleItemPosition, i17, findFirstVisibleItemPosition2, 1, mutableMapOf3);
                HistoryDtReportHelper a19 = companion2.a();
                RecyclerView it7 = this.f353747e;
                Intrinsics.checkNotNullExpressionValue(it7, "it");
                int i18 = ChatHistoryMediaFragment.this.mFirstPosition;
                int i19 = ChatHistoryMediaFragment.this.mLastPosition;
                mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent3.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.VIDEO.ordinal())));
                a19.g("em_bas_photovideo_entry", it7, z16, i18, findFirstVisibleItemPosition, i19, findFirstVisibleItemPosition2, 2, mutableMapOf4);
                ChatHistoryMediaFragment.this.mFirstPosition = findFirstVisibleItemPosition;
                ChatHistoryMediaFragment.this.mLastPosition = findFirstVisibleItemPosition2;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatHistoryMediaFragment() {
        this(0, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ChatHistoryMediaFragment this$0, ChatHistoryMediaAdapter this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.bi("button");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh() {
        int z16 = ExtensionsKt.z(this.adapter, ChatHistoryMediaFragment$appendTailNodeToAdapter$count$1.INSTANCE);
        if (z16 == 0) {
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.a1i);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.chat_history_tab_media)");
        TailDefaultItemModel tailDefaultItemModel = new TailDefaultItemModel(qqStr, z16);
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryMediaFragment", "appendTailNodeToAdapter addTailNode count:" + z16);
        ChatHistoryMediaAdapter chatHistoryMediaAdapter = this.adapter;
        chatHistoryMediaAdapter.D0(chatHistoryMediaAdapter.m0().size(), tailDefaultItemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(a.b uiState) {
        boolean z16;
        List<SearchMediaItemModel> data = uiState.getData();
        List<SearchMediaItemModel> list = data;
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
            this.adapter.B0(ExtensionsKt.f(data, ChatHistoryMediaFragment$dealFirstPageData$1.INSTANCE));
            pi();
        }
        Xh(uiState.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(a.c uiState) {
        List<SearchMediaItemModel> data = uiState.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryMediaFragment", "loadMore result " + data.size());
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
            SearchMediaModel e16 = this.adapter.e1();
            if (e16 == null) {
                return;
            } else {
                ExtensionsKt.g(e16, data, this.adapter, ChatHistoryMediaFragment$dealLoadMoreData$1.INSTANCE);
            }
        }
        Xh(uiState.a());
        this.isLoadingMore = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        c.b bVar;
        WeakReference<c.b> Wh = Wh();
        if (Wh != null && (bVar = Wh.get()) != null) {
            bVar.k8(getString(R.string.f170728zk1));
        }
        this.adapter.X0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$exitMultiSelectMode$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                    ChatHistoryMediaFragment.this.adapter.notifyItemRangeChanged(0, ChatHistoryMediaFragment.this.adapter.m0().size(), new i(o.class, new o(z16)));
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        sh();
    }

    private final void Xh(boolean hasMore) {
        this.adapter.z0(hasMore);
        if (!hasMore) {
            Sh();
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(hasMore);
    }

    private final void Yh() {
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
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.media.a
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryMediaFragment.Zh(ChatHistoryMediaFragment.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(ChatHistoryMediaFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.bi("normal");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.adapter, r0.m0().size() - 1, false, false, null, 14, null);
    }

    private final void ai() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryMediaFragment$initStateObserver$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(String tag) {
        if (this.isLoadingMore) {
            return;
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryMediaFragment", "loadMore " + tag + " invoke");
        this.isLoadingMore = true;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryMediaFragment$loadMore$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(BottomBarOperationType operationType) {
        switch (b.f353745a[operationType.ordinal()]) {
            case 1:
                ni();
                return;
            case 2:
                ei();
                return;
            case 3:
                di();
                return;
            case 4:
                gi();
                return;
            case 5:
                ki();
                return;
            case 6:
                fi();
                return;
            default:
                return;
        }
    }

    private final void di() {
        int collectionSizeOrDefault;
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        List<MsgRecord> h16 = this.adapter.h1();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        IAIOFavApi iAIOFavApi = (IAIOFavApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFavApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iAIOFavApi.multiFav(requireContext, arrayList2);
        Vh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void ei() {
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        ChatHistoryMediaAdapter chatHistoryMediaAdapter = this.adapter;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        List<com.tencent.qqnt.chathistory.ui.base.item.b> g16 = this.adapter.g1();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel>");
        chatHistoryMediaAdapter.j1(requireActivity, requireContext, g16);
        Vh();
    }

    private final void fi() {
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        IAIOGroupAlbumForwardApi iAIOGroupAlbumForwardApi = (IAIOGroupAlbumForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOGroupAlbumForwardApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iAIOGroupAlbumForwardApi.chatHistorySave2GroupAlbum(requireContext, this.adapter.h1());
        Vh();
    }

    private final void gi() {
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        IChatHistorySave2WeiYunApi iChatHistorySave2WeiYunApi = (IChatHistorySave2WeiYunApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IChatHistorySave2WeiYunApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iChatHistorySave2WeiYunApi.chatHistorySave2WeiYun(requireContext, this.adapter.h1());
        Vh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void hi() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        RecyclerView recyclerView;
        Map<String, Object> mutableMapOf3;
        RecyclerView recyclerView2;
        Map<String, Object> mutableMapOf4;
        c.b bVar;
        if (this.adapter.Z0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Wh = Wh();
        if (Wh != null && (bVar = Wh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_picvideo_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryMediaViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryMediaViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.r(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        HistoryDtReportHelper a17 = companion.a();
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            recyclerView = null;
        } else {
            recyclerView = recyclerView3;
        }
        int i3 = this.mLastPosition - this.mFirstPosition;
        HistoryDtReportHelper.OperationContent operationContent2 = HistoryDtReportHelper.OperationContent.NORMAL;
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent2.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.PIC.ordinal())));
        a17.i(recyclerView, i3, 1, "em_bas_photovideo_entry", 1, mutableMapOf3);
        HistoryDtReportHelper a18 = companion.a();
        RecyclerView recyclerView4 = this.recycleView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            recyclerView2 = null;
        } else {
            recyclerView2 = recyclerView4;
        }
        int i16 = this.mLastPosition - this.mFirstPosition;
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent2.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.VIDEO.ordinal())));
        a18.i(recyclerView2, i16, 2, "em_bas_photovideo_entry", 1, mutableMapOf4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void ii() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        View gd5;
        c.b bVar2;
        if (this.adapter.Z0()) {
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
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_picvideo_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryMediaViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryMediaViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
        WeakReference<c.b> Wh2 = Wh();
        if (Wh2 != null && (bVar = Wh2.get()) != null && (gd5 = bVar.gd()) != null) {
            gd5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatHistoryMediaFragment.ji(ChatHistoryMediaFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    public static final void ji(ChatHistoryMediaFragment this$0, View it) {
        Map mutableMapOf;
        Map<String, Object> mutableMapOf2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_picvideo_tab"), TuplesKt.to("touin", companion.a().d(this$0.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryMediaViewModel) this$0.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryMediaViewModel) this$0.rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cur_pg", mutableMapOf));
        a16.m(it, "em_bas_back_button", mutableMapOf2);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void ki() {
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        final ActionSheet createFullScreenDialog = ActionSheet.createFullScreenDialog(requireContext());
        createFullScreenDialog.setMainTitle(R.string.zjs);
        createFullScreenDialog.addButton(R.string.zjr, 3);
        createFullScreenDialog.addCancelButton(R.string.cancel);
        createFullScreenDialog.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryMediaFragment.li(ChatHistoryMediaFragment.this, createFullScreenDialog, view, i3);
            }
        });
        createFullScreenDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void li(final ChatHistoryMediaFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(((ChatHistoryMediaViewModel) this$0.rh()).M1(), ((ChatHistoryMediaViewModel) this$0.rh()).N1(), ""), new ArrayList<>(this$0.adapter.f1()), new IOperateCallback() { // from class: com.tencent.qqnt.chathistory.ui.media.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    ChatHistoryMediaFragment.mi(ChatHistoryMediaFragment.this, i16, str);
                }
            });
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(ChatHistoryMediaFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ChatHistoryMediaFragment", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new ChatHistoryMediaFragment$showMultiDeleteActionSheet$1$1$1$1(i3, this$0, null), 2, null);
    }

    private final void ni() {
        if (this.adapter.f1().isEmpty()) {
            return;
        }
        final ActionSheet createFullScreenDialog = ActionSheet.createFullScreenDialog(requireContext());
        createFullScreenDialog.addButton(R.string.f170730zk3);
        createFullScreenDialog.addButton(R.string.f170731zk4);
        createFullScreenDialog.addCancelButton(R.string.cancel);
        createFullScreenDialog.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChatHistoryMediaFragment.oi(ChatHistoryMediaFragment.this, createFullScreenDialog, view, i3);
            }
        });
        createFullScreenDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void oi(ChatHistoryMediaFragment this$0, ActionSheet actionSheet, View view, int i3) {
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
        iChatHistoryForwardApi.forwardChatHistory(requireContext, i16, ((ChatHistoryMediaViewModel) this$0.rh()).M1(), ((ChatHistoryMediaViewModel) this$0.rh()).N1(), this$0.adapter.h1());
        actionSheet.dismiss();
        this$0.Vh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void pi() {
        c.b bVar;
        c.b bVar2;
        if (isResumed() && ((ChatHistoryMediaViewModel) rh()).M1() != 4) {
            WeakReference<c.b> Wh = Wh();
            if (Wh != null && (bVar2 = Wh.get()) != null) {
                bVar2.f3(getString(R.string.f170728zk1), new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$showTitleRightUI$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
                        }
                    }

                    private static final String a(ChatHistoryMediaFragment chatHistoryMediaFragment) {
                        int i3;
                        BaseApplication context = BaseApplication.getContext();
                        if (chatHistoryMediaFragment.adapter.Z0()) {
                            i3 = R.string.f170727zk0;
                        } else {
                            i3 = R.string.f170728zk1;
                        }
                        String string = context.getString(i3);
                        Intrinsics.checkNotNullExpressionValue(string, "getContext()\n           \u2026_find_by_category_choose)");
                        return string;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r5v1, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
                    @Override // android.view.View.OnClickListener
                    public void onClick(@Nullable View v3) {
                        HistoryDtReportHelper.OperationContent operationContent;
                        c.b bVar3;
                        View u16;
                        Map mutableMapOf;
                        Map<String, Object> mutableMapOf2;
                        c.b bVar4;
                        EventCollector.getInstance().onViewClickedBefore(v3);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ChatHistoryMediaAdapter chatHistoryMediaAdapter = ChatHistoryMediaFragment.this.adapter;
                            final ChatHistoryMediaFragment chatHistoryMediaFragment = ChatHistoryMediaFragment.this;
                            boolean X0 = chatHistoryMediaAdapter.X0(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$showTitleRightUI$1$onClick$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                                        ChatHistoryMediaFragment.this.adapter.notifyItemRangeChanged(0, ChatHistoryMediaFragment.this.adapter.m0().size(), new i(o.class, new o(z16)));
                                    } else {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                    }
                                }
                            });
                            final ChatHistoryMediaFragment chatHistoryMediaFragment2 = ChatHistoryMediaFragment.this;
                            WeakReference<c.b> Wh2 = chatHistoryMediaFragment2.Wh();
                            if (Wh2 != null && (bVar4 = Wh2.get()) != null) {
                                bVar4.f3(a(chatHistoryMediaFragment2), this);
                            }
                            if (X0) {
                                chatHistoryMediaFragment2.yh(((ChatHistoryMediaViewModel) chatHistoryMediaFragment2.rh()).M1(), ((ChatHistoryMediaViewModel) chatHistoryMediaFragment2.rh()).N1(), BottomBarType.MEDIA, new Function1<BottomBarOperationType, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$showTitleRightUI$1$onClick$2$1
                                    static IPatchRedirector $redirector_;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                                            ChatHistoryMediaFragment.this.ci(it);
                                        }
                                    }
                                });
                                BaseHistoryFragment.wh(chatHistoryMediaFragment2, false, false, 2, null);
                            } else {
                                chatHistoryMediaFragment2.sh();
                            }
                            if (ChatHistoryMediaFragment.this.adapter.Z0()) {
                                operationContent = HistoryDtReportHelper.OperationContent.SELECT;
                            } else {
                                operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
                            }
                            WeakReference<c.b> Wh3 = ChatHistoryMediaFragment.this.Wh();
                            if (Wh3 != null && (bVar3 = Wh3.get()) != null && (u16 = bVar3.u()) != null) {
                                ChatHistoryMediaFragment chatHistoryMediaFragment3 = ChatHistoryMediaFragment.this;
                                HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
                                HistoryDtReportHelper a16 = companion.a();
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_picvideo_tab"), TuplesKt.to("touin", companion.a().d(chatHistoryMediaFragment3.rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryMediaViewModel) chatHistoryMediaFragment3.rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryMediaViewModel) chatHistoryMediaFragment3.rh()).N1()));
                                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
                                a16.k("em_bas_multiple_selection_button", u16, mutableMapOf2);
                            }
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                        }
                        EventCollector.getInstance().onViewClicked(v3);
                    }
                });
            }
            WeakReference<c.b> Wh2 = Wh();
            if (Wh2 != null && (bVar = Wh2.get()) != null) {
                bVar.setEnable(!this.adapter.m0().isEmpty());
            }
        }
    }

    @Nullable
    public WeakReference<c.b> Wh() {
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
        hi();
        this.adapter.k1(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$onHideTitleRightUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                    ChatHistoryMediaFragment.this.adapter.notifyItemRangeChanged(0, ChatHistoryMediaFragment.this.adapter.m0().size(), new i(o.class, new o(z16)));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        });
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
        String string = getString(R.string.zkl);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_video_pic)");
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
        Yh();
        View findViewById3 = view.findViewById(R.id.f792849c);
        RecyclerView recyclerView2 = (RecyclerView) findViewById3;
        recyclerView2.setLayoutManager(new GridLayoutManager(requireContext(), 4));
        recyclerView2.setAdapter(this.adapter);
        recyclerView2.addOnScrollListener(new c(recyclerView2));
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<Recycl\u2026\n            })\n        }");
        this.recycleView = recyclerView2;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryMediaFragment$onViewCreated$3(this, null));
        ai();
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            recyclerView = recyclerView3;
        }
        ExtensionsKt.w(recyclerView, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$onViewCreated$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                smartRefreshLayout = ChatHistoryMediaFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                return Boolean.valueOf(smartRefreshLayout.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$onViewCreated$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
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
                    ChatHistoryMediaFragment.this.bi("preLoad");
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
        pi();
        ii();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @NotNull
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        View mRv = new r(context, null, 2, 0 == true ? 1 : 0).getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryMediaViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryMediaViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_picvideo_tab", mutableMapOf);
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

    public ChatHistoryMediaFragment(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.source = i3;
        final ChatHistoryMediaAdapter chatHistoryMediaAdapter = new ChatHistoryMediaAdapter(i3, new Function1<com.tencent.qqnt.chathistory.ui.base.b, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$adapter$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$adapter$1$1", f = "ChatHistoryMediaFragment.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$adapter$1$1, reason: invalid class name */
            /* loaded from: classes23.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.qqnt.chathistory.ui.base.b $it;
                int label;
                final /* synthetic */ ChatHistoryMediaFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ChatHistoryMediaFragment chatHistoryMediaFragment, com.tencent.qqnt.chathistory.ui.base.b bVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = chatHistoryMediaFragment;
                    this.$it = bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, chatHistoryMediaFragment, bVar, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            ChatHistoryMediaViewModel chatHistoryMediaViewModel = (ChatHistoryMediaViewModel) this.this$0.rh();
                            b.a aVar = new b.a(this.$it);
                            this.label = 1;
                            if (chatHistoryMediaViewModel.sendUserIntent(aVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.chathistory.ui.base.b it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ChatHistoryMediaFragment.this), null, null, new AnonymousClass1(ChatHistoryMediaFragment.this, it, null), 3, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.base.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }
        }, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
                }
            }

            public final void invoke(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryMediaFragment.this.vh(z16, z17);
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
        chatHistoryMediaAdapter.C0(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistoryMediaFragment.Rh(ChatHistoryMediaFragment.this, chatHistoryMediaAdapter, view);
            }
        });
        this.adapter = chatHistoryMediaAdapter;
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
    }

    public /* synthetic */ ChatHistoryMediaFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
