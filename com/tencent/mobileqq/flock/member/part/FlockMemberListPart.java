package com.tencent.mobileqq.flock.member.part;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.utils.FlockJumpHelper;
import com.tencent.mobileqq.flock.widget.FlockBlankView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/flock/member/part/FlockMemberListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lnc1/a;", "", "Q9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/flock/member/bean/a;", "it", "H9", "E9", "uiStateData", "I9", "G9", "L9", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "", "D5", "uin", "Q3", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "d", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "smartRefreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "memberListView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "flockConcatAdapter", "Lcom/tencent/mobileqq/flock/member/adapter/b;", h.F, "Lcom/tencent/mobileqq/flock/member/adapter/b;", "memberListAdapter", "Lcom/tencent/mobileqq/flock/member/viewmodel/b;", "i", "Lcom/tencent/mobileqq/flock/member/viewmodel/b;", "flockMemberListViewModel", "Lcom/tencent/mobileqq/flock/widget/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/flock/widget/d;", "flockListLoadMoreAdapter", "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/flock/widget/FlockBlankView;", "flockBlankView", "Landroid/app/Dialog;", "D", "Landroid/app/Dialog;", "F9", "()Landroid/app/Dialog;", "R9", "(Landroid/app/Dialog;)V", "dialog", "<init>", "()V", "E", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockMemberListPart extends Part implements ILoadMoreProvider$LoadMoreListener, nc1.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FlockBlankView flockBlankView;

    /* renamed from: D, reason: from kotlin metadata */
    public Dialog dialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SmartRefreshLayout smartRefreshLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView memberListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter flockConcatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.member.adapter.b memberListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.member.viewmodel.b flockMemberListViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.flock.widget.d flockListLoadMoreAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/member/part/FlockMemberListPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.member.part.FlockMemberListPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockMemberListPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void E9(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> it) {
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

    private final void G9(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> uiStateData) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> it) {
        int state = it.getState();
        if (state != 2 && state != 3) {
            if (state == 4) {
                if (!it.getIsLoadMore()) {
                    G9(it);
                }
                E9(it);
                return;
            }
            return;
        }
        I9(it);
        E9(it);
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setEnableRefresh(false);
        }
        com.tencent.mobileqq.flock.widget.d dVar = this.flockListLoadMoreAdapter;
        if (dVar != null) {
            dVar.resetAutoLoadMoreTimes();
        }
        com.tencent.mobileqq.flock.widget.d dVar2 = this.flockListLoadMoreAdapter;
        if (dVar2 != null) {
            dVar2.setMaxAutoLoadMoreTimes(4);
        }
    }

    private final void I9(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> uiStateData) {
        K9();
        SmartRefreshLayout smartRefreshLayout = this.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        com.tencent.mobileqq.flock.member.adapter.b bVar = this.memberListAdapter;
        if (bVar != null) {
            bVar.setItems(new ArrayList(uiStateData.getData()));
        }
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.flock.member.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    FlockMemberListPart.J9(FlockMemberListPart.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(FlockMemberListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.memberListView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final void K9() {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.b();
        }
    }

    private final void L9(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> uiStateData) {
        FlockBlankView flockBlankView = this.flockBlankView;
        if (flockBlankView != null) {
            flockBlankView.setErrorViewBuilder(new QUIEmptyState.Builder(getContext()).setBackgroundColorType(0).setImageType(5).setTitle("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5").setButton("\u5237\u65b0", new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.member.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FlockMemberListPart.M9(FlockMemberListPart.this, view);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(final FlockMemberListPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.flock.member.part.e
            @Override // java.lang.Runnable
            public final void run() {
                FlockMemberListPart.N9(FlockMemberListPart.this);
            }
        }, 200L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(FlockMemberListPart this$0) {
        boolean z16;
        com.tencent.mobileqq.flock.member.viewmodel.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        SmartRefreshLayout smartRefreshLayout = this$0.smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        SmartRefreshLayout smartRefreshLayout2 = this$0.smartRefreshLayout;
        if (smartRefreshLayout2 != null) {
            z16 = smartRefreshLayout2.autoRefresh();
        } else {
            z16 = false;
        }
        if (!z16 && (bVar = this$0.flockMemberListViewModel) != null) {
            bVar.Q1(false);
        }
        QLog.d("FlockMemberListPart", 1, "autoRefresh... " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(FlockMemberListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.flock.member.viewmodel.b bVar = this$0.flockMemberListViewModel;
        if (bVar != null) {
            bVar.Q1(false);
        }
    }

    private final void Q9() {
        com.tencent.mobileqq.flock.member.adapter.b bVar = new com.tencent.mobileqq.flock.member.adapter.b();
        bVar.setHasStableIds(true);
        this.memberListAdapter = bVar;
        com.tencent.mobileqq.flock.widget.d dVar = new com.tencent.mobileqq.flock.widget.d();
        dVar.setHasStableIds(true);
        dVar.registerLoadMoreListener(this);
        this.flockListLoadMoreAdapter = dVar;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.memberListAdapter, this.flockListLoadMoreAdapter});
        this.flockConcatAdapter = rFWConcatAdapter;
        RecyclerView recyclerView = this.memberListView;
        if (recyclerView != null) {
            recyclerView.setAdapter(rFWConcatAdapter);
        }
    }

    private final void initData() {
        LiveData<UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>> M1;
        com.tencent.mobileqq.flock.member.viewmodel.b bVar = this.flockMemberListViewModel;
        if (bVar != null && (M1 = bVar.M1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.member.bean.a>>, Unit> function1 = new Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.member.bean.a>>, Unit>() { // from class: com.tencent.mobileqq.flock.member.part.FlockMemberListPart$initData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockMemberListPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends com.tencent.mobileqq.flock.member.bean.a>> uIStateData) {
                    invoke2((UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<com.tencent.mobileqq.flock.member.bean.a>> it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    if (FlockMemberListPart.this.F9().isShowing()) {
                        FlockMemberListPart.this.F9().dismiss();
                    }
                    FlockMemberListPart flockMemberListPart = FlockMemberListPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    flockMemberListPart.H9(it);
                }
            };
            M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.member.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FlockMemberListPart.O9(Function1.this, obj);
                }
            });
        }
        com.tencent.mobileqq.flock.member.viewmodel.b bVar2 = this.flockMemberListViewModel;
        if (bVar2 != null) {
            bVar2.Q1(false);
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(getContext(), 2, true);
        Intrinsics.checkNotNullExpressionValue(showOnlyLoadingImageDialog, "showOnlyLoadingImageDial\u2026.LOADING_TYPE_GRAY, true)");
        R9(showOnlyLoadingImageDialog);
        F9().show();
    }

    @Override // nc1.a
    @NotNull
    public String D5() {
        String N1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.flock.member.viewmodel.b bVar = this.flockMemberListViewModel;
        if (bVar == null || (N1 = bVar.N1()) == null) {
            return "";
        }
        return N1;
    }

    @NotNull
    public final Dialog F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Dialog dialog = this.dialog;
        if (dialog != null) {
            return dialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        return null;
    }

    @Override // nc1.a
    public void Q3(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        FlockJumpHelper.Companion companion = FlockJumpHelper.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.b(activity, uin, 2);
    }

    public final void R9(@NotNull Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialog);
        } else {
            Intrinsics.checkNotNullParameter(dialog, "<set-?>");
            this.dialog = dialog;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        FlockBlankView flockBlankView;
        SmartRefreshLayout smartRefreshLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (rootView != null && (recyclerView = (RecyclerView) rootView.findViewById(R.id.f790748s)) != null) {
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
        } else {
            recyclerView = null;
        }
        this.memberListView = recyclerView;
        if (rootView != null && (flockBlankView = (FlockBlankView) rootView.findViewById(R.id.vb_)) != null) {
            flockBlankView.setVisibility(8);
        } else {
            flockBlankView = null;
        }
        this.flockBlankView = flockBlankView;
        if (rootView != null && (smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.f86434rn)) != null) {
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.flock.member.part.a
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    FlockMemberListPart.P9(FlockMemberListPart.this, iRefreshLayout);
                }
            });
            smartRefreshLayout2 = smartRefreshLayout;
        }
        this.smartRefreshLayout = smartRefreshLayout2;
        this.flockMemberListViewModel = (com.tencent.mobileqq.flock.member.viewmodel.b) getViewModel(com.tencent.mobileqq.flock.member.viewmodel.b.class);
        PartIOCKt.registerIoc(this, this, nc1.a.class);
        Q9();
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasMore);
            return;
        }
        QLog.d("FlockMemberListPart", 1, "onLoadsMoreEnd:" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.flock.member.viewmodel.b bVar = this.flockMemberListViewModel;
        if (bVar != null) {
            bVar.Q1(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            PartIOCKt.unregisterIoc(this, nc1.a.class);
        }
    }
}
