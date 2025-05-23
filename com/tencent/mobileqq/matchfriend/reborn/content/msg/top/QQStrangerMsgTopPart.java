package com.tencent.mobileqq.matchfriend.reborn.content.msg.top;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c82.QQStrangerMsgMatchChatData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.QQStrangerSimpleEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.QQStrangerMsgMoreSignalAdapter;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel.QQStrangerMsgTopViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J+\u0010\u0018\u001a\u00020\u00062!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0014\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R#\u00102\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010/\u001a\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerMsgTopPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "remainPlayTime", "", "K9", "Lkotlin/Function0;", "block", "P9", "", "tinyId", "emojiId", "J9", "O9", "M9", "Lkotlin/Function1;", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "Lkotlin/ParameterName;", "name", "cardInfo", "", "predicate", "N9", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/viewmodel/QQStrangerMsgTopViewModel;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/viewmodel/QQStrangerMsgTopViewModel;", "viewModel", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/b;", h.F, "G9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/b;", "matchChatAdapter", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/a;", "i", "E9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/a;", "cardAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "F9", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopPart extends com.tencent.mobileqq.matchfriend.reborn.content.msg.part.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy matchChatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy cardAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy concatAdapter;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerMsgTopPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            int num_backgournd_icon = adapter != null ? adapter.getNUM_BACKGOURND_ICON() : 0;
            int dpToPx = ViewUtils.dpToPx(4.0f);
            int dip2px = ViewUtils.dip2px(4.0f);
            if (childAdapterPosition == 0) {
                dpToPx = ViewUtils.dpToPx(16.0f);
            }
            if (childAdapterPosition == num_backgournd_icon - 1) {
                dip2px = ViewUtils.dpToPx(16.0f);
            }
            outRect.set(dpToPx, 0, dip2px, 0);
        }
    }

    public QQStrangerMsgTopPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerMsgTopViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerMsgTopViewModel invoke() {
                Object partHost = QQStrangerMsgTopPart.this.getPartHost();
                Fragment fragment = partHost instanceof Fragment ? (Fragment) partHost : null;
                ActivityResultCaller parentFragment = fragment != null ? fragment.getParentFragment() : null;
                IPartHost iPartHost = parentFragment instanceof IPartHost ? (IPartHost) parentFragment : null;
                if (iPartHost == null) {
                    iPartHost = QQStrangerMsgTopPart.this.getPartHost();
                }
                return (QQStrangerMsgTopViewModel) QQStrangerMsgTopPart.this.getViewModel(iPartHost, null, QQStrangerMsgTopViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$matchChatAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b invoke() {
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b bVar = new com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b();
                bVar.setHasStableIds(true);
                return bVar;
            }
        });
        this.matchChatAdapter = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$cardAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a invoke() {
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a aVar = new com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a();
                aVar.setHasStableIds(true);
                return aVar;
            }
        });
        this.cardAdapter = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RFWConcatAdapter>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$concatAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RFWConcatAdapter invoke() {
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b G9;
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a E9;
                RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                G9 = QQStrangerMsgTopPart.this.G9();
                E9 = QQStrangerMsgTopPart.this.E9();
                QQStrangerMsgMoreSignalAdapter qQStrangerMsgMoreSignalAdapter = new QQStrangerMsgMoreSignalAdapter();
                qQStrangerMsgMoreSignalAdapter.setHasStableIds(true);
                Unit unit = Unit.INSTANCE;
                return new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{G9, E9, qQStrangerMsgMoreSignalAdapter});
            }
        });
        this.concatAdapter = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a E9() {
        return (com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a) this.cardAdapter.getValue();
    }

    private final RFWConcatAdapter F9() {
        return (RFWConcatAdapter) this.concatAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b G9() {
        return (com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b) this.matchChatAdapter.getValue();
    }

    private final QQStrangerMsgTopViewModel H9() {
        return (QQStrangerMsgTopViewModel) this.viewModel.getValue();
    }

    private final void I9(Prompt$CardInfo cardInfo) {
        QQStrangerMsgTopViewModel H9 = H9();
        String c16 = c82.a.c(cardInfo);
        String str = cardInfo.recm_trace.get();
        if (str == null) {
            str = "";
        }
        H9.P1(c16, str);
    }

    private final void J9(long tinyId, int emojiId) {
        H9().R1(tinyId, emojiId);
    }

    private final void K9(final int remainPlayTime) {
        P9(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$handleUpdateMatchChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.b G9;
                List listOf;
                G9 = QQStrangerMsgTopPart.this.G9();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new QQStrangerMsgMatchChatData(remainPlayTime));
                G9.setItems(listOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9(final long tinyId) {
        QLog.d("QQStrangerMsgTopPart", 1, "removeNoChatUserCardByTinyId " + tinyId);
        N9(new Function1<Prompt$CardInfo, Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$removeNoChatUserCardByTinyId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Prompt$CardInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.card_type.get() == 3 && c82.a.d(it) == tinyId);
            }
        });
    }

    private final void N9(Function1<? super Prompt$CardInfo, Boolean> predicate) {
        List<Prompt$CardInfo> items = E9().getItems();
        if (items == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(items);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Prompt$CardInfo it = (Prompt$CardInfo) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!predicate.invoke(it).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() != items.size()) {
            E9().setItems(arrayList2);
        }
    }

    private final void O9(final long tinyId) {
        QLog.d("QQStrangerMsgTopPart", 1, "removeUserCardByTinyId " + tinyId);
        N9(new Function1<Prompt$CardInfo, Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$removeUserCardByTinyId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Prompt$CardInfo it) {
                List listOf;
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z16 = false;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 2});
                if (listOf.contains(Integer.valueOf(it.card_type.get())) && c82.a.d(it) == tinyId) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
        });
    }

    private final void P9(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMsgTopPart.Q9(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.omo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.msg_top)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b());
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setAdapter(F9());
        MutableLiveData<List<Prompt$CardInfo>> M1 = H9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends Prompt$CardInfo>, Unit> function1 = new Function1<List<? extends Prompt$CardInfo>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Prompt$CardInfo> list) {
                invoke2((List<Prompt$CardInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Prompt$CardInfo> list) {
                com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.a E9;
                E9 = QQStrangerMsgTopPart.this.E9();
                E9.setItems(list);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerMsgTopPart.L9(Function1.this, obj);
            }
        });
        if (H9().getHasRequest()) {
            return;
        }
        H9().Q1();
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
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d("QQStrangerMsgTopPart", 1, "onReceiveEvent " + event);
        if (event instanceof QQStrangerMsgMatchChatUpdateEvent) {
            K9(((QQStrangerMsgMatchChatUpdateEvent) event).getRemainMatchTime());
            return;
        }
        if (event instanceof QQStrangerSendEmojiMsgEvent) {
            QQStrangerSendEmojiMsgEvent qQStrangerSendEmojiMsgEvent = (QQStrangerSendEmojiMsgEvent) event;
            J9(qQStrangerSendEmojiMsgEvent.getTinyId(), qQStrangerSendEmojiMsgEvent.getEmojiId());
        } else if (event instanceof QQStrangerMsgUserCardRemoveEvent) {
            O9(((QQStrangerMsgUserCardRemoveEvent) event).getTinyId());
        } else if (event instanceof QQStrangerSimpleEvent.QQStrangerOnMsgSentEvent) {
            M9(((QQStrangerSimpleEvent.QQStrangerOnMsgSentEvent) event).getTinyId());
        } else if (event instanceof QQStrangerMsgNoLongerRecommendEvent) {
            I9(((QQStrangerMsgNoLongerRecommendEvent) event).getCardInfo());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerMsgMatchChatUpdateEvent.class, QQStrangerSendEmojiMsgEvent.class, QQStrangerMsgUserCardRemoveEvent.class, QQStrangerSimpleEvent.QQStrangerOnMsgSentEvent.class, QQStrangerMsgNoLongerRecommendEvent.class);
        return arrayListOf;
    }
}
