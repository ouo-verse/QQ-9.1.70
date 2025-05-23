package com.tencent.qqnt.chathistory.ui.shortvideo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi;
import com.tencent.qqnt.aio.adapter.api.impl.ChatHistoryShortVideoApiImpl;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.j;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoGroupModel;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import com.tencent.qqnt.chathistory.ui.shortvideo.viewmodel.ChatHistoryShortVideoViewModel;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.x2k.s;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import ew3.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.f;
import r3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001VB\u0011\u0012\b\b\u0002\u00102\u001a\u00020/\u00a2\u0006\u0004\bS\u0010TJ\u001c\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J;\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\r*\b\u0012\u0004\u0012\u00020\u000e0\r2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J&\u0010*\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010+\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R*\u0010A\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010GR\u0016\u0010K\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/ChatHistoryShortVideoFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/viewmodel/ChatHistoryShortVideoViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "", "param", "", "Qh", "Rh", "Lew3/a$b;", "it", "Ph", "", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msgTime", "Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "groupCreator", "Kh", "Lew3/a$a;", "Oh", "", "hasMore", "Nh", "Jh", "Landroid/view/View;", "view", "Th", "Vh", "Yh", "Wh", "Xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "t6", "ff", "", "E", "I", "source", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/a;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Lh", "()Lcom/tencent/qqnt/chathistory/ui/shortvideo/adapter/a;", "shortVideoAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "G", "Ljava/lang/ref/WeakReference;", "Mh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "J", "Landroid/view/ViewGroup;", "emptyView", "K", "Z", "isLoadingMore", "Lcom/tencent/qqnt/chathistory/x2k/s;", "L", "Lcom/tencent/qqnt/chathistory/x2k/s;", "binding", "<init>", "(I)V", "M", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoFragment extends BaseSubCategoryFragment<ChatHistoryShortVideoViewModel> implements com.tencent.qqnt.chathistory.ui.category.c {

    /* renamed from: E, reason: from kotlin metadata */
    private final int source;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy shortVideoAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewGroup emptyView;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: L, reason: from kotlin metadata */
    private s binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/shortvideo/ChatHistoryShortVideoFragment$b", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$a;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryShortVideoApi$ChatHistoryShortVideoEvent;", "type", "", "", "param", "", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IChatHistoryShortVideoApi.a {
        b() {
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi.a
        public void a(@NotNull IChatHistoryShortVideoApi.ChatHistoryShortVideoEvent type, @NotNull Map<String, String> param) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(param, "param");
            if (type == IChatHistoryShortVideoApi.ChatHistoryShortVideoEvent.SHORT_VIDEO_EVENT_POSITION_CHANGE) {
                ChatHistoryShortVideoFragment.this.Qh(param);
            }
        }
    }

    public ChatHistoryShortVideoFragment() {
        this(0, 1, null);
    }

    private final void Jh() {
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06;
        com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a Lh = Lh();
        if (Lh != null && (m06 = Lh.m0()) != null) {
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = m06.get(m06.size() - 1);
            if (bVar instanceof ChatHistoryShortVideoItemModel) {
                Lh().D0(m06.size(), new com.tencent.qqnt.chathistory.ui.shortvideo.data.model.b(((ChatHistoryShortVideoItemModel) bVar).getMsgTime()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.lang.Object] */
    private final List<com.tencent.qqnt.chathistory.ui.base.item.a> Kh(List<? extends com.tencent.qqnt.chathistory.ui.base.item.b> list, Function1<? super Long, ? extends com.tencent.qqnt.chathistory.ui.base.item.a> function1) {
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (com.tencent.qqnt.chathistory.ui.base.item.b bVar : list) {
            if (objectRef.element == 0) {
                ?? invoke = function1.invoke(Long.valueOf(bVar.getMsgTime()));
                objectRef.element = invoke;
                Intrinsics.checkNotNull(invoke);
                arrayList.add(invoke);
            }
            T t16 = objectRef.element;
            if (t16 != 0) {
                com.tencent.qqnt.chathistory.ui.base.item.a aVar = (com.tencent.qqnt.chathistory.ui.base.item.a) t16;
                if (j.d(aVar) == j.d(bVar) && j.c(aVar) == j.c(bVar)) {
                    aVar.f(bVar);
                } else {
                    ?? invoke2 = function1.invoke(Long.valueOf(bVar.getMsgTime()));
                    com.tencent.qqnt.chathistory.ui.base.item.a aVar2 = (com.tencent.qqnt.chathistory.ui.base.item.a) invoke2;
                    arrayList.add(aVar2);
                    aVar2.f(bVar);
                    objectRef.element = invoke2;
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a Lh() {
        return (com.tencent.qqnt.chathistory.ui.shortvideo.adapter.a) this.shortVideoAdapter.getValue();
    }

    private final void Nh(boolean hasMore) {
        Lh().z0(hasMore);
        if (!hasMore) {
            Jh();
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(hasMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(a.GetMoreShortVideoListCompleted it) {
        Integer num;
        List<ChatHistoryShortVideoItemModel> data = it.getData();
        d dVar = d.f354054a;
        int requestCount = it.getRequestCount();
        int receiveCount = it.getReceiveCount();
        SmartRefreshLayout smartRefreshLayout = null;
        if (data != null) {
            num = Integer.valueOf(data.size());
        } else {
            num = null;
        }
        dVar.a("QCHV-ChatHistoryShortVideoFragment", "[handleLoadMoreDataCompleted] request count: " + requestCount + " | receive count: " + receiveCount + " | size:" + num);
        if (data.isEmpty()) {
            Lh().z0(false);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.setEnableLoadMore(false);
        } else {
            try {
                com.tencent.qqnt.chathistory.ui.base.item.a c16 = com.tencent.qqnt.chathistory.ui.base.item.c.c(Lh());
                if (c16 == null || !(c16 instanceof ChatHistoryShortVideoGroupModel)) {
                    return;
                } else {
                    ExtensionsKt.g(c16, data, Lh(), new Function1<Long, com.tencent.qqnt.chathistory.ui.base.item.a>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$handleLoadMoreDataCompleted$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ com.tencent.qqnt.chathistory.ui.base.item.a invoke(Long l3) {
                            return invoke(l3.longValue());
                        }

                        @NotNull
                        public final com.tencent.qqnt.chathistory.ui.base.item.a invoke(long j3) {
                            return new ChatHistoryShortVideoGroupModel(j3);
                        }
                    });
                }
            } catch (Throwable th5) {
                d.f354054a.a("QCHV-ChatHistoryShortVideoFragment", "[handleLoadMoreDataCompleted] ex: " + th5.getMessage());
            }
        }
        Nh(it.b());
        this.isLoadingMore = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(a.GetShortVideoListCompleted it) {
        Integer num;
        d dVar = d.f354054a;
        int requestCount = it.getRequestCount();
        int receiveCount = it.getReceiveCount();
        List<ChatHistoryShortVideoItemModel> data = it.getData();
        SmartRefreshLayout smartRefreshLayout = null;
        if (data != null) {
            num = Integer.valueOf(data.size());
        } else {
            num = null;
        }
        dVar.a("QCHV-ChatHistoryShortVideoFragment", "[handleShortVideoListCompleted] request count: " + requestCount + " | receive count: " + receiveCount + " | size: " + num);
        List<ChatHistoryShortVideoItemModel> data2 = it.getData();
        if (data2.isEmpty()) {
            ViewGroup viewGroup = this.emptyView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.setVisibility(8);
            Xh();
            return;
        }
        ViewGroup viewGroup2 = this.emptyView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(8);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout3;
        }
        smartRefreshLayout.setVisibility(0);
        Lh().B0(Kh(data2, new Function1<Long, com.tencent.qqnt.chathistory.ui.base.item.a>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$handleRefreshDataCompleted$filterData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ com.tencent.qqnt.chathistory.ui.base.item.a invoke(Long l3) {
                return invoke(l3.longValue());
            }

            @NotNull
            public final com.tencent.qqnt.chathistory.ui.base.item.a invoke(long j3) {
                return new ChatHistoryShortVideoGroupModel(j3);
            }
        }));
        Nh(it.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.withIndex(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Qh(Map<String, String> param) {
        Long l3;
        int i3;
        Iterable<IndexedValue> withIndex;
        long parseLong;
        String str = param.get(ChatHistoryShortVideoApiImpl.KEY_CURRENT_MSG_SEQ);
        RecyclerView recyclerView = null;
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                parseLong = -1;
            } else {
                parseLong = Long.parseLong(str);
            }
            l3 = Long.valueOf(parseLong);
        } else {
            l3 = null;
        }
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = Lh().m0();
        String str2 = "";
        if (m06 != null && withIndex != null) {
            i3 = -1;
            for (IndexedValue indexedValue : withIndex) {
                int index = indexedValue.getIndex();
                com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) indexedValue.component2();
                if (bVar instanceof ChatHistoryShortVideoItemModel) {
                    ChatHistoryShortVideoItemModel chatHistoryShortVideoItemModel = (ChatHistoryShortVideoItemModel) bVar;
                    long i16 = chatHistoryShortVideoItemModel.i();
                    if (l3 != null && i16 == l3.longValue()) {
                        str2 = chatHistoryShortVideoItemModel.o();
                        i3 = index;
                    }
                }
            }
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            d.f354054a.a("QCHV-ChatHistoryShortVideoFragment", "[handlerHistoryShortVideoPositionChange] position == -1.");
            return;
        }
        try {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            View findViewByPosition = ((GridLayoutManager) layoutManager).findViewByPosition(i3);
            if (findViewByPosition != null) {
                RecyclerView recyclerView3 = this.recyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView3 = null;
                }
                recyclerView3.stopScroll();
                int top = findViewByPosition.getTop() + (findViewByPosition.getHeight() / 2);
                RecyclerView recyclerView4 = this.recyclerView;
                if (recyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView4 = null;
                }
                int height = top - (recyclerView4.getHeight() / 2);
                RecyclerView recyclerView5 = this.recyclerView;
                if (recyclerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView5;
                }
                recyclerView.scrollBy(0, height);
                d.f354054a.a("QCHV-ChatHistoryShortVideoFragment", "[handlerHistoryShortVideoPositionChange] msgId: " + l3 + " | position:" + i3 + " | dy:" + height + " | detailStr:" + ((Object) str2));
            }
        } catch (Exception e16) {
            d dVar = d.f354054a;
            e16.printStackTrace();
            dVar.a("QCHV-ChatHistoryShortVideoFragment", "[handlerHistoryShortVideoPositionChange] ex: " + Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Rh() {
        LiveData obtainUiState = ((ChatHistoryShortVideoViewModel) rh()).obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ew3.a, Unit> function1 = new Function1<ew3.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$initObserverUiState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ew3.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ew3.a it) {
                if (it instanceof a.GetShortVideoListCompleted) {
                    ChatHistoryShortVideoFragment chatHistoryShortVideoFragment = ChatHistoryShortVideoFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryShortVideoFragment.Ph((a.GetShortVideoListCompleted) it);
                } else if (it instanceof a.GetMoreShortVideoListCompleted) {
                    ChatHistoryShortVideoFragment chatHistoryShortVideoFragment2 = ChatHistoryShortVideoFragment.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    chatHistoryShortVideoFragment2.Oh((a.GetMoreShortVideoListCompleted) it);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryShortVideoFragment.Sh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Th(View view) {
        s sVar = this.binding;
        SmartRefreshLayout smartRefreshLayout = null;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sVar = null;
        }
        SmartRefreshLayout f16 = sVar.f();
        this.refreshLayout = f16;
        if (f16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            f16 = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        f16.X(new HistoryLoadMoreFooter(requireContext));
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.a(false);
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
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.W(new e() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.a
            @Override // r3.e
            public final void E6(f fVar) {
                ChatHistoryShortVideoFragment.Uh(ChatHistoryShortVideoFragment.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ChatHistoryShortVideoFragment this$0, f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.Vh();
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b.K0(this$0.Lh(), this$0.Lh().m0().size() - 1, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryShortVideoFragment$loadMoreSource$1(this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void Wh() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        if (Lh().S0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Mh = Mh();
        if (Mh != null && (bVar = Mh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_short_video_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryShortVideoViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryShortVideoViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.r(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void Xh() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        if (Lh().S0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Mh = Mh();
        if (Mh != null && (bVar = Mh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_short_video_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryShortVideoViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryShortVideoViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_empty_state", mutableMapOf2, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    private final void Yh() {
        HistoryDtReportHelper.OperationContent operationContent;
        View view;
        Map mutableMapOf;
        Map mutableMapOf2;
        c.b bVar;
        if (Lh().S0()) {
            operationContent = HistoryDtReportHelper.OperationContent.SELECT;
        } else {
            operationContent = HistoryDtReportHelper.OperationContent.NORMAL;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        WeakReference<c.b> Mh = Mh();
        if (Mh != null && (bVar = Mh.get()) != null) {
            view = bVar.u();
        } else {
            view = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("pgid", "pg_bas_short_video_tab"), TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryShortVideoViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryShortVideoViewModel) rh()).N1()));
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(operationContent.ordinal())), TuplesKt.to("cur_pg", mutableMapOf));
        HistoryDtReportHelper.p(a16, view, "em_bas_multiple_selection_button", mutableMapOf2, null, 8, null);
    }

    @Nullable
    public WeakReference<c.b> Mh() {
        return this.titleRightDelegate;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void ff() {
        c.a.a(this);
        Wh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class)).setOnHistoryShortEventListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Th(view);
        Rh();
        s sVar = this.binding;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sVar = null;
        }
        this.emptyView = sVar.e();
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = getString(R.string.zkj);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_no_short_video)");
        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        ViewGroup viewGroup = this.emptyView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            viewGroup = null;
        }
        viewGroup.addView(build);
        s sVar2 = this.binding;
        if (sVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            sVar2 = null;
        }
        RecyclerView h16 = sVar2.h();
        h16.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        h16.setAdapter(Lh());
        h16.addItemDecoration(new com.tencent.qqnt.chathistory.ui.shortvideo.adapter.c());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158728ni);
        ViewGroup.LayoutParams layoutParams = h16.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = h16.getLayoutParams();
            int i16 = -2;
            if (layoutParams2 != null) {
                i3 = layoutParams2.width;
            } else {
                i3 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = h16.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
        }
        if (dimensionPixelSize != marginLayoutParams.rightMargin) {
            marginLayoutParams.rightMargin = dimensionPixelSize;
            h16.setLayoutParams(marginLayoutParams);
        }
        this.recyclerView = h16;
        ExtensionsKt.w(h16, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                SmartRefreshLayout smartRefreshLayout;
                smartRefreshLayout = ChatHistoryShortVideoFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                return Boolean.valueOf(smartRefreshLayout.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatHistoryShortVideoFragment.this.Vh();
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryShortVideoFragment$onViewCreated$5(this, null));
        ((IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class)).setOnHistoryShortEventListener(new b());
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        c.a.b(this);
        Yh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        s sVar = new s(context, null, null, false, 14, null);
        this.binding = sVar;
        View mRv = sVar.getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryShortVideoViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryShortVideoViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_short_video_tab", mutableMapOf);
        return mRv;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void y5(@Nullable WeakReference<c.b> weakReference) {
        this.titleRightDelegate = weakReference;
    }

    public /* synthetic */ ChatHistoryShortVideoFragment(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }

    public ChatHistoryShortVideoFragment(int i3) {
        Lazy lazy;
        this.source = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new ChatHistoryShortVideoFragment$shortVideoAdapter$2(this));
        this.shortVideoAdapter = lazy;
    }
}
