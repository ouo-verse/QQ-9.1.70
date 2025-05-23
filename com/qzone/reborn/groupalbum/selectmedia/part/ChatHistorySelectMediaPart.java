package com.qzone.reborn.groupalbum.selectmedia.part;

import aj.a;
import aj.b;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaModel;
import com.qzone.reborn.groupalbum.selectmedia.event.ChatHistorySelectMediaFinishEvent;
import com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel;
import com.qzone.reborn.groupalbum.selectmedia.widget.GroupAlbumSmartRefreshLayout;
import com.qzone.reborn.groupalbum.selectmedia.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import tl.h;
import yi.DownLoadParam;
import yi.MultiPayLoad;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u001c\u0010\u001e\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040!0 H\u0016J\u0012\u0010#\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016R\u001b\u0010)\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/part/ChatHistorySelectMediaPart;", "Lcom/qzone/reborn/base/k;", "Lbj/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "Q9", "Laj/a$c;", "uiState", "L9", "Laj/a$b;", "K9", "O9", "", "tag", "T9", "U9", "S9", "Lcom/qzone/reborn/groupalbum/selectmedia/event/ChatHistorySelectMediaFinishEvent;", "event", "N9", "onInitView", "r8", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onReceiveEvent", "Lcom/qzone/reborn/groupalbum/selectmedia/viewmodel/ChatHistoryMediaViewModel;", "d", "Lkotlin/Lazy;", "M9", "()Lcom/qzone/reborn/groupalbum/selectmedia/viewmodel/ChatHistoryMediaViewModel;", "mediaSelectVm", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/qzone/reborn/groupalbum/selectmedia/widget/GroupAlbumSmartRefreshLayout;", "f", "Lcom/qzone/reborn/groupalbum/selectmedia/widget/GroupAlbumSmartRefreshLayout;", "refreshLayout", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "emptyView", "", "i", "Z", "isLoadingMore", "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/selectmedia/adapter/ChatHistorySelectMediaAdapter;", "adapter", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaPart extends k implements bj.a, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaSelectVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumSmartRefreshLayout refreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup emptyView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ChatHistorySelectMediaAdapter adapter;

    public ChatHistorySelectMediaPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatHistoryMediaViewModel>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$mediaSelectVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChatHistoryMediaViewModel invoke() {
                return (ChatHistoryMediaViewModel) ChatHistorySelectMediaPart.this.getViewModel(ChatHistoryMediaViewModel.class);
            }
        });
        this.mediaSelectVm = lazy;
        final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter = new ChatHistorySelectMediaAdapter(0, new Function1<DownLoadParam, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$1$1", f = "ChatHistorySelectMediaPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$1$1, reason: invalid class name */
            /* loaded from: classes37.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DownLoadParam $it;
                int label;
                final /* synthetic */ ChatHistorySelectMediaPart this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ChatHistorySelectMediaPart chatHistorySelectMediaPart, DownLoadParam downLoadParam, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = chatHistorySelectMediaPart;
                    this.$it = downLoadParam;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.M9().U1(new b.a(this.$it));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownLoadParam it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LifecycleOwner lifecycleOwner = ChatHistorySelectMediaPart.this.getPartHost().getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new AnonymousClass1(ChatHistorySelectMediaPart.this, it, null), 3, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownLoadParam downLoadParam) {
                invoke2(downLoadParam);
                return Unit.INSTANCE;
            }
        }, new Function2<Boolean, Boolean, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$2$1", f = "ChatHistorySelectMediaPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$adapter$2$1, reason: invalid class name */
            /* loaded from: classes37.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ boolean $isEnabled;
                int label;
                final /* synthetic */ ChatHistorySelectMediaPart this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ChatHistorySelectMediaPart chatHistorySelectMediaPart, boolean z16, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = chatHistorySelectMediaPart;
                    this.$isEnabled = z16;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$isEnabled, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.M9().b2(this.$isEnabled);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void invoke(boolean z16, boolean z17) {
                LifecycleOwner lifecycleOwner = ChatHistorySelectMediaPart.this.getPartHost().getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new AnonymousClass1(ChatHistorySelectMediaPart.this, z16, null), 3, null);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }
        });
        chatHistorySelectMediaAdapter.A0(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatHistorySelectMediaPart.J9(ChatHistorySelectMediaPart.this, chatHistorySelectMediaAdapter, view);
            }
        });
        this.adapter = chatHistorySelectMediaAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(ChatHistorySelectMediaPart this$0, ChatHistorySelectMediaAdapter this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.T9("button");
        xi.b.F0(this_apply, this_apply.m0().size() - 1, false, false, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(a.GetMediaListCompleted uiState) {
        List<SearchMediaItemModel> a16 = uiState.a();
        List<SearchMediaItemModel> list = a16;
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout = null;
        if (list == null || list.isEmpty()) {
            ViewGroup viewGroup = this.emptyView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            RecyclerView recyclerView = this.recycleView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                recyclerView = null;
            }
            recyclerView.setVisibility(8);
        } else {
            ViewGroup viewGroup2 = this.emptyView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            RecyclerView recyclerView2 = this.recycleView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                recyclerView2 = null;
            }
            recyclerView2.setVisibility(0);
            this.adapter.z0(com.qzone.reborn.groupalbum.selectmedia.util.b.b(a16, new Function1<Long, zi.a>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$dealFirstPageData$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ zi.a invoke(Long l3) {
                    return invoke(l3.longValue());
                }

                public final zi.a invoke(long j3) {
                    return new SearchMediaModel(j3);
                }
            }));
            U9();
        }
        this.adapter.x0(uiState.c());
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout2 = this.refreshLayout;
        if (groupAlbumSmartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            groupAlbumSmartRefreshLayout = groupAlbumSmartRefreshLayout2;
        }
        groupAlbumSmartRefreshLayout.setEnableLoadMore(uiState.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(a.GetMoreMediaListCompleted uiState) {
        boolean z16;
        List<SearchMediaItemModel> a16 = uiState.a();
        com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaPart", "loadMore result " + a16.size());
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout = this.refreshLayout;
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout2 = null;
        if (groupAlbumSmartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            groupAlbumSmartRefreshLayout = null;
        }
        groupAlbumSmartRefreshLayout.finishLoadMore();
        if (a16.isEmpty()) {
            z16 = true;
        } else {
            SearchMediaModel Y0 = this.adapter.Y0();
            if (Y0 == null) {
                return;
            }
            com.qzone.reborn.groupalbum.selectmedia.util.b.c(Y0, a16, this.adapter, new Function1<Long, zi.a>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$dealLoadMoreData$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ zi.a invoke(Long l3) {
                    return invoke(l3.longValue());
                }

                public final zi.a invoke(long j3) {
                    return new SearchMediaModel(j3);
                }
            });
            z16 = false;
        }
        if (z16) {
            this.adapter.x0(false);
            GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout3 = this.refreshLayout;
            if (groupAlbumSmartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                groupAlbumSmartRefreshLayout2 = groupAlbumSmartRefreshLayout3;
            }
            groupAlbumSmartRefreshLayout2.setEnableLoadMore(false);
        } else {
            this.adapter.x0(uiState.c());
            GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout4 = this.refreshLayout;
            if (groupAlbumSmartRefreshLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                groupAlbumSmartRefreshLayout2 = groupAlbumSmartRefreshLayout4;
            }
            groupAlbumSmartRefreshLayout2.setEnableLoadMore(uiState.c());
        }
        this.isLoadingMore = false;
    }

    private final void N9(ChatHistorySelectMediaFinishEvent event) {
        if (getActivity() == null || getActivity().isDestroyed() || getActivity().isFinishing()) {
            return;
        }
        getActivity().finish();
    }

    private final void O9() {
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout = this.refreshLayout;
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout2 = null;
        if (groupAlbumSmartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            groupAlbumSmartRefreshLayout = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        groupAlbumSmartRefreshLayout.setRefreshFooter(new HistoryLoadMoreFooter(activity));
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout3 = this.refreshLayout;
        if (groupAlbumSmartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            groupAlbumSmartRefreshLayout3 = null;
        }
        groupAlbumSmartRefreshLayout3.setEnableLoadMoreWhenContentNotFull(true);
        GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout4 = this.refreshLayout;
        if (groupAlbumSmartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            groupAlbumSmartRefreshLayout2 = groupAlbumSmartRefreshLayout4;
        }
        groupAlbumSmartRefreshLayout2.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.e
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                ChatHistorySelectMediaPart.P9(ChatHistorySelectMediaPart.this, iRefreshLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ChatHistorySelectMediaPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.T9("normal");
        xi.b.F0(this$0.adapter, r0.m0().size() - 1, false, false, null, 14, null);
    }

    private final void Q9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ChatHistorySelectMediaPart$initStateObserver$1(this, null));
    }

    private final void S9() {
        String str;
        int i3;
        String name;
        List<MsgRecord> Z0 = this.adapter.Z0();
        ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
        forwardGroupAlbumBean.context = getActivity();
        forwardGroupAlbumBean.groupId = M9().R1();
        forwardGroupAlbumBean.isSingleMedia = false;
        CommonAlbumInfo albumInfo = M9().getAlbumInfo();
        String str2 = "";
        if (albumInfo == null || (str = albumInfo.getAlbumId()) == null) {
            str = "";
        }
        forwardGroupAlbumBean.albumId = str;
        CommonAlbumInfo albumInfo2 = M9().getAlbumInfo();
        if (albumInfo2 != null && (name = albumInfo2.getName()) != null) {
            str2 = name;
        }
        forwardGroupAlbumBean.albumName = str2;
        if (M9().getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String() == 4) {
            i3 = 6;
        } else {
            i3 = M9().getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String() == 2 ? 7 : 5;
        }
        forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(Z0);
        ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(String tag) {
        if (this.isLoadingMore) {
            return;
        }
        com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaPart", "loadMore " + tag + " invoke");
        this.isLoadingMore = true;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ChatHistorySelectMediaPart$loadMore$1(this, null));
    }

    private final void U9() {
        this.adapter.S0(new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$showTitleRightUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter;
                ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter2;
                chatHistorySelectMediaAdapter = ChatHistorySelectMediaPart.this.adapter;
                chatHistorySelectMediaAdapter2 = ChatHistorySelectMediaPart.this.adapter;
                chatHistorySelectMediaAdapter.notifyItemRangeChanged(0, chatHistorySelectMediaAdapter2.m0().size(), new com.qzone.reborn.groupalbum.selectmedia.util.f(MultiPayLoad.class, new MultiPayLoad(z16)));
            }
        });
    }

    public final ChatHistoryMediaViewModel M9() {
        Object value = this.mediaSelectVm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mediaSelectVm>(...)");
        return (ChatHistoryMediaViewModel) value;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        R9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof ChatHistorySelectMediaFinishEvent) {
            N9((ChatHistorySelectMediaFinishEvent) event);
        }
    }

    @Override // bj.a
    public void r8() {
        if (this.adapter.Z0().isEmpty()) {
            return;
        }
        S9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ChatHistorySelectMediaFinishEvent.class);
        return arrayListOf;
    }

    private final void R9(View rootView) {
        if (rootView == null) {
            return;
        }
        registerIoc(this, bj.a.class);
        View findViewById = rootView.findViewById(R.id.ne_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.refresh_layout)");
        this.refreshLayout = (GroupAlbumSmartRefreshLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.fa7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.flEmptyContainer)");
        this.emptyView = (ViewGroup) findViewById2;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string = rootView.getResources().getString(R.string.zkl);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.resources.getSt\u2026hat_history_no_video_pic)");
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
        O9();
        View findViewById3 = rootView.findViewById(R.id.nfe);
        RecyclerView recyclerView2 = (RecyclerView) findViewById3;
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView2.setAdapter(this.adapter);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Re\u2026apter = adapter\n        }");
        this.recycleView = recyclerView2;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ChatHistorySelectMediaPart$initView$3(this, null));
        Q9();
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        } else {
            recyclerView = recyclerView3;
        }
        com.qzone.reborn.groupalbum.selectmedia.util.b.f(recyclerView, new Function0<Boolean>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$initView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                GroupAlbumSmartRefreshLayout groupAlbumSmartRefreshLayout;
                groupAlbumSmartRefreshLayout = ChatHistorySelectMediaPart.this.refreshLayout;
                if (groupAlbumSmartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    groupAlbumSmartRefreshLayout = null;
                }
                return Boolean.valueOf(groupAlbumSmartRefreshLayout.a());
            }
        }, new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.part.ChatHistorySelectMediaPart$initView$5
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
                ChatHistorySelectMediaPart.this.T9("preLoad");
            }
        });
    }
}
