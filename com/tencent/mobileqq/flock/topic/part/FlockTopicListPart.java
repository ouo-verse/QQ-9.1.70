package com.tencent.mobileqq.flock.topic.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.widget.FlockBlankView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040 j\u0002`\"\u0012\u0018\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070&\u0012\u0006\u0010,\u001a\u00020\u0018\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040 j\u0002`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/part/FlockTopicListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lpc1/a;", "", "N9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lb55/g;", "it", "F9", "C9", "uiStateData", "G9", "E9", "D9", "L9", "J9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "tagInfo", "L3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/flock/topic/viewmodel/RefreshRequest;", "d", "Lkotlin/jvm/functions/Function1;", "refreshFunc", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "observerData", "f", "Z", "isRefresh", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", tl.h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "smartRefreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "topicListView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "flockConcatAdapter", "Lcom/tencent/mobileqq/flock/topic/adapter/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/flock/topic/adapter/b;", "topicListAdapter", "Lcom/tencent/mobileqq/flock/widget/d;", "D", "Lcom/tencent/mobileqq/flock/widget/d;", "flockListLoadMoreAdapter", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "E", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "flockBlankView", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/lifecycle/LiveData;Z)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockTopicListPart extends Part implements ILoadMoreProvider$LoadMoreListener, pc1.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.topic.adapter.b topicListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.widget.d flockListLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FlockBlankView flockBlankView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Object, Unit> refreshFunc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<b55.g>>> observerData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isRefresh;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SmartRefreshLayout smartRefreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView topicListView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter flockConcatAdapter;

    public FlockTopicListPart(@NotNull Function1<Object, Unit> refreshFunc, @NotNull LiveData<UIStateData<List<b55.g>>> observerData, boolean z16) {
        Intrinsics.checkNotNullParameter(refreshFunc, "refreshFunc");
        Intrinsics.checkNotNullParameter(observerData, "observerData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, refreshFunc, observerData, Boolean.valueOf(z16));
            return;
        }
        this.refreshFunc = refreshFunc;
        this.observerData = observerData;
        this.isRefresh = z16;
    }

    private final void C9(UIStateData<List<b55.g>> it) {
        QLog.d("FlockMemberListPart", 1, "finishRefresh...");
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
        com.tencent.mobileqq.flock.widget.d dVar = this.flockListLoadMoreAdapter;
        if (dVar != null) {
            dVar.setLoadState(false, !it.getIsFinish());
        }
    }

    private final void D9(UIStateData<List<b55.g>> uiStateData) {
        L9(uiStateData);
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.c();
        }
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(8);
        }
    }

    private final void E9(UIStateData<List<b55.g>> uiStateData) {
        J9(uiStateData);
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.c();
        }
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(UIStateData<List<b55.g>> it) {
        int state = it.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state == 4) {
                    if (!it.getIsLoadMore()) {
                        E9(it);
                    }
                    C9(it);
                    return;
                }
                return;
            }
            G9(it);
            C9(it);
            return;
        }
        if (!it.getIsLoadMore()) {
            D9(it);
        }
        C9(it);
    }

    private final void G9(UIStateData<List<b55.g>> uiStateData) {
        I9();
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        com.tencent.mobileqq.flock.topic.adapter.b bVar = this.topicListAdapter;
        if (bVar != null) {
            bVar.setItems(new ArrayList(uiStateData.getData()));
        }
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.flock.topic.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    FlockTopicListPart.H9(FlockTopicListPart.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(FlockTopicListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.topicListView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final void I9() {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.b();
        }
    }

    private final void J9(UIStateData<List<b55.g>> uiStateData) {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.setErrorViewBuilder(new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(5).setTitle("\u52a0\u8f7d\u5931\u8d25\uff0c\u68c0\u67e5\u7f51\u7edc\u518d\u8bd5\u5427"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9(UIStateData<List<b55.g>> uiStateData) {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.setErrorViewBuilder(new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(9).setTitle("\u6682\u65e0\u8be5\u8bdd\u9898"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(FlockTopicListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.refreshFunc.invoke(Boolean.FALSE);
    }

    private final void N9() {
        com.tencent.mobileqq.flock.topic.adapter.b bVar = new com.tencent.mobileqq.flock.topic.adapter.b();
        bVar.setHasStableIds(true);
        this.topicListAdapter = bVar;
        com.tencent.mobileqq.flock.widget.d dVar = new com.tencent.mobileqq.flock.widget.d();
        dVar.setHasStableIds(true);
        dVar.registerLoadMoreListener(this);
        this.flockListLoadMoreAdapter = dVar;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.topicListAdapter, this.flockListLoadMoreAdapter});
        this.flockConcatAdapter = rFWConcatAdapter;
        RecyclerView recyclerView = this.topicListView;
        if (recyclerView != null) {
            recyclerView.setAdapter(rFWConcatAdapter);
        }
    }

    private final void initData() {
        SmartRefreshLayout smartRefreshLayout;
        LiveData<UIStateData<List<b55.g>>> liveData = this.observerData;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends b55.g>>, Unit> function1 = new Function1<UIStateData<List<? extends b55.g>>, Unit>() { // from class: com.tencent.mobileqq.flock.topic.part.FlockTopicListPart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockTopicListPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends b55.g>> uIStateData) {
                invoke2((UIStateData<List<b55.g>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<b55.g>> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockTopicListPart flockTopicListPart = FlockTopicListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockTopicListPart.F9(it);
            }
        };
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.topic.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockTopicListPart.K9(Function1.this, obj);
            }
        });
        if (this.isRefresh && (smartRefreshLayout = this.smartRefreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    @Override // pc1.a
    public void L3(@NotNull b55.g tagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tagInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("KEY_RESULT_FOR_TOPIC", MessageNano.toByteArray(tagInfo));
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        getActivity().finish();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        FlockBlankView flockBlankView;
        SmartRefreshLayout smartRefreshLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (rootView != null && (recyclerView = (RecyclerView) rootView.findViewById(R.id.f7924499)) != null) {
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
        } else {
            recyclerView = null;
        }
        this.topicListView = recyclerView;
        if (rootView != null && (flockBlankView = (FlockBlankView) rootView.findViewById(R.id.vb_)) != null) {
            flockBlankView.setVisibility(8);
        } else {
            flockBlankView = null;
        }
        this.flockBlankView = flockBlankView;
        if (rootView != null && (smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.f86434rn)) != null) {
            smartRefreshLayout.setEnableRefresh(this.isRefresh);
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.flock.topic.part.a
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    FlockTopicListPart.M9(FlockTopicListPart.this, iRefreshLayout);
                }
            });
            smartRefreshLayout2 = smartRefreshLayout;
        }
        this.smartRefreshLayout = smartRefreshLayout2;
        N9();
        initData();
        PartIOCKt.registerIoc(this, this, pc1.a.class);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasMore);
            return;
        }
        QLog.d("FlockMemberListPart", 1, "onLoadsMoreEnd:" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.refreshFunc.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            PartIOCKt.unregisterIoc(this, pc1.a.class);
        }
    }
}
