package com.tencent.mobileqq.troop.homework.notice.detail.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i;
import com.tencent.mobileqq.troop.homework.notice.remind.HWNoticeRemindFragment;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0018\u0010M\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010\u0018\u001a\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailRemindPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "W9", "Q9", "N9", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$c;", "confirmedCountData", "O9", "V9", "aa", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i;", "d", "Lkotlin/Lazy;", "U9", "()Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i;", "viewModel", "", "e", "T9", "()Ljava/lang/String;", "troopUin", "f", "Landroid/view/View;", "rootLayout", "Landroidx/core/widget/NestedScrollView;", tl.h.F, "Landroidx/core/widget/NestedScrollView;", "scrollView", "i", "headerView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "troopName", BdhLogUtil.LogTag.Tag_Conn, "confirmCntInfo", "D", "bottomButton", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "emptyViewGroup", "Lcom/tencent/mobileqq/troop/homework/notice/detail/adapter/a;", "G", "Lcom/tencent/mobileqq/troop/homework/notice/detail/adapter/a;", "listAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "H", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "I", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "loadMoreAdapter", "J", "Z", "isInited", "K", "isListEnd", "L", "Ljava/lang/String;", "noticeAuthorUin", "Ljava/lang/Runnable;", "M", "Ljava/lang/Runnable;", "scrollEventTask", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "N", "S9", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "<init>", "()V", "P", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWDetailRemindPart extends Part implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final String Q;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView confirmCntInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView bottomButton;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewGroup emptyViewGroup;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.detail.adapter.a listAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.common.a loadMoreAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isInited;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isListEnd;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String noticeAuthorUin;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Runnable scrollEventTask;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View rootLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private NestedScrollView scrollView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView troopName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailRemindPart$a;", "", "", "RECYCLER_VIEW_ITEM_HEIGHT_DP", "I", "RECYCLER_VIEW_PRELOAD_ITEM_MIN_COUNT", "", "SCROLL_VIEW_SCROLL_EVENT_INTERVAL_MS", "J", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            Q = HWDetailRemindPart.class.getSimpleName();
        }
    }

    public HWDetailRemindPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailRemindPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HWDetailRemindPart hWDetailRemindPart = HWDetailRemindPart.this;
                    Intent intent = hWDetailRemindPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.troop.homework.notice.detail.g.e(hWDetailRemindPart, intent);
                }
            });
            this.viewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailRemindPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String stringExtra = HWDetailRemindPart.this.getActivity().getIntent().getStringExtra("TROOP_UIN");
                    return stringExtra == null ? "0" : stringExtra;
                }
            });
            this.troopUin = lazy2;
            this.scrollEventTask = new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.f
                @Override // java.lang.Runnable
                public final void run() {
                    HWDetailRemindPart.Z9(HWDetailRemindPart.this);
                }
            };
            lazy3 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$emptyView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailRemindPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUIEmptyState invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new QUIEmptyState.Builder(HWDetailRemindPart.this.getContext()).setImageType(16).setTitle("\u6682\u65e0\u4eba\u786e\u8ba4").setBackgroundColorType(2).build() : (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.emptyView = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void N9() {
        String troopUin = T9();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        com.tencent.mobileqq.troop.homework.notice.detail.adapter.a aVar = new com.tencent.mobileqq.troop.homework.notice.detail.adapter.a(troopUin);
        aVar.setHasStableIds(true);
        this.listAdapter = aVar;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.common.a();
        aVar2.setHasStableIds(true);
        aVar2.registerLoadMoreListener(this);
        aVar2.setLoadState(false, true);
        this.loadMoreAdapter = aVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.troop.homework.notice.detail.adapter.a aVar3 = this.listAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            aVar3 = null;
        }
        adapterArr[0] = aVar3;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = this.loadMoreAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aVar4 = null;
        }
        adapterArr[1] = aVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        U9().Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(i.c confirmedCountData) {
        TextView textView;
        ITroopInfoService iTroopInfoService;
        TroopInfo findTroopInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TextView textView2 = null;
        if (peekAppRuntime != null && (iTroopInfoService = (ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")) != null && (findTroopInfo = iTroopInfoService.findTroopInfo(T9())) != null) {
            TextView textView3 = this.troopName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopName");
                textView3 = null;
            }
            textView3.setText(findTroopInfo.getNewTroopNameOrTroopName());
        }
        TextView textView4 = this.confirmCntInfo;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmCntInfo");
            textView4 = null;
        }
        textView4.setText(confirmedCountData.a() + "/" + confirmedCountData.c() + "\u5df2\u786e\u8ba4");
        View view = this.headerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view = null;
        }
        view.setVisibility(0);
        if (Intrinsics.areEqual(this.noticeAuthorUin, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()) && confirmedCountData.c() != confirmedCountData.a()) {
            TextView textView5 = this.bottomButton;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
                textView5 = null;
            }
            textView5.setText(getContext().getString(R.string.f2340078s));
            TextView textView6 = this.bottomButton;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
                textView6 = null;
            }
            textView6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.lwx));
            TextView textView7 = this.bottomButton;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
                textView7 = null;
            }
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HWDetailRemindPart.P9(HWDetailRemindPart.this, view2);
                }
            });
            TextView textView8 = this.bottomButton;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
                textView8 = null;
            }
            textView8.setVisibility(0);
            com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
            TextView textView9 = this.bottomButton;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
                textView = null;
            } else {
                textView = textView9;
            }
            h.a.m(aVar, textView, "em_group_remind_confirm", ExposurePolicy.REPORT_NONE, null, null, null, 56, null);
            TextView textView10 = this.bottomButton;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
            } else {
                textView2 = textView10;
            }
            aVar.f(textView2);
            return;
        }
        TextView textView11 = this.bottomButton;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomButton");
        } else {
            textView2 = textView11;
        }
        textView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(HWDetailRemindPart this$0, View view) {
        Bundle bundle;
        Intent intent;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        HWNoticeRemindFragment hWNoticeRemindFragment = new HWNoticeRemindFragment();
        hWNoticeRemindFragment.setArguments(new Bundle(bundle));
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        hWNoticeRemindFragment.show(((FragmentActivity) context).getSupportFragmentManager(), HWNoticeRemindFragment.class.getSimpleName());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        View findViewById = getPartRootView().findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.root_layout)");
        this.rootLayout = findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.iig);
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById2;
        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.j
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                HWDetailRemindPart.R9(HWDetailRemindPart.this, view, i3, i16, i17, i18);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Ne\u2026)\n            }\n        }");
        this.scrollView = nestedScrollView;
        View findViewById3 = getPartRootView().findViewById(R.id.u4e);
        View findViewById4 = findViewById3.findViewById(R.id.k0i);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.troop_name)");
        this.troopName = (TextView) findViewById4;
        View findViewById5 = findViewById3.findViewById(R.id.u4_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.confirm_cnt_info)");
        this.confirmCntInfo = (TextView) findViewById5;
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Vi\u2026nfirm_cnt_info)\n        }");
        this.headerView = findViewById3;
        View findViewById6 = getPartRootView().findViewById(R.id.i4m);
        RecyclerView recyclerView = (RecyclerView) findViewById6;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setOverScrollMode(2);
        recyclerView.setItemAnimator(null);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Re\u2026Animator = null\n        }");
        this.recyclerView = recyclerView;
        View findViewById7 = getPartRootView().findViewById(R.id.f72793rt);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<Te\u2026(R.id.remind_confirm_btn)");
        this.bottomButton = (TextView) findViewById7;
        View findViewById8 = getPartRootView().findViewById(R.id.uu6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026.empty_confirm_viewgroup)");
        this.emptyViewGroup = (ViewGroup) findViewById8;
        N9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(HWDetailRemindPart this$0, View view, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isListEnd) {
            return;
        }
        com.tencent.qav.thread.a.d().removeCallbacks(this$0.scrollEventTask);
        com.tencent.qav.thread.a.d().postDelayed(this$0.scrollEventTask, 500L);
    }

    private final QUIEmptyState S9() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T9() {
        return (String) this.troopUin.getValue();
    }

    private final com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i U9() {
        return (com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i) this.viewModel.getValue();
    }

    private final void V9() {
        if (this.isListEnd) {
            return;
        }
        int[] iArr = new int[2];
        RecyclerView recyclerView = this.recyclerView;
        NestedScrollView nestedScrollView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        NestedScrollView nestedScrollView2 = this.scrollView;
        if (nestedScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            nestedScrollView2 = null;
        }
        nestedScrollView2.getLocationInWindow(iArr2);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        int height = recyclerView2.getHeight();
        NestedScrollView nestedScrollView3 = this.scrollView;
        if (nestedScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            nestedScrollView = nestedScrollView3;
        }
        int height2 = nestedScrollView.getHeight();
        int i3 = iArr2[1] - iArr[1];
        int i16 = (height - i3) - height2;
        if (i3 > 0 && i16 >= 0 && i16 < l.b(56) * 5) {
            if (QLog.isColorLevel()) {
                QLog.d(Q, 2, "onScrollEvent, requestListData, recyclerViewLocations[1]=" + iArr[1] + ", scrollViewLocations[1]=" + iArr2[1] + ", recyclerViewHeight=" + height + ", scrollViewHeight=" + height2 + ", recyclerViewScrollDistance=" + i3 + ", recyclerViewRemainDistance=" + i16);
            }
            U9().Q1();
        }
    }

    private final void W9() {
        LiveData<GetGroupSchoolNoticeDetailRsp> O1 = U9().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetGroupSchoolNoticeDetailRsp, Unit> function1 = new Function1<GetGroupSchoolNoticeDetailRsp, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$observeLiveData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWDetailRemindPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
                invoke2(getGroupSchoolNoticeDetailRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
                boolean z16;
                String troopUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getGroupSchoolNoticeDetailRsp);
                    return;
                }
                z16 = HWDetailRemindPart.this.isInited;
                if (z16) {
                    return;
                }
                HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
                String valueOf = String.valueOf(getGroupSchoolNoticeDetailRsp.authorUin);
                troopUin = HWDetailRemindPart.this.T9();
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                if (hWNoticeUtils.j(valueOf, troopUin)) {
                    HWDetailRemindPart.this.isInited = true;
                    HWDetailRemindPart.this.noticeAuthorUin = String.valueOf(getGroupSchoolNoticeDetailRsp.authorUin);
                    HWDetailRemindPart.this.Q9();
                }
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWDetailRemindPart.X9(Function1.this, obj);
            }
        });
        LiveData<i.c> N1 = U9().N1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<i.c, Unit> function12 = new Function1<i.c, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart$observeLiveData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWDetailRemindPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c it) {
                com.tencent.mobileqq.troop.homework.notice.detail.adapter.a aVar;
                com.tencent.mobileqq.troop.homework.notice.common.a aVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                HWDetailRemindPart hWDetailRemindPart = HWDetailRemindPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hWDetailRemindPart.O9(it);
                HWDetailRemindPart.this.isListEnd = it.d();
                aVar = HWDetailRemindPart.this.listAdapter;
                com.tencent.mobileqq.troop.homework.notice.common.a aVar3 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                    aVar = null;
                }
                aVar.setItems(it.b());
                aVar2 = HWDetailRemindPart.this.loadMoreAdapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                } else {
                    aVar3 = aVar2;
                }
                aVar3.setLoadState(false, !it.d());
                if (it.b().isEmpty()) {
                    HWDetailRemindPart.this.aa();
                }
            }
        };
        N1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWDetailRemindPart.Y9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(HWDetailRemindPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        ViewGroup viewGroup = this.emptyViewGroup;
        RecyclerView recyclerView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyViewGroup");
            viewGroup = null;
        }
        viewGroup.addView(S9(), -1, -1);
        viewGroup.setVisibility(0);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        W9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            com.tencent.qav.thread.a.d().removeCallbacks(this.scrollEventTask);
        }
    }
}
