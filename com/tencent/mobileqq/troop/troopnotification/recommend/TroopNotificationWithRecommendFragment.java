package com.tencent.mobileqq.troop.troopnotification.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mobileqq.troop.utils.ad;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.widget.swipe.CommonSwipeMenuLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.report.TroopFeatureReport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020%0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "Gh", "", "getTitleBarHeight", "Ph", "Oh", "Hh", "", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "D", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "notificationListVM", "Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/f;", "E", "Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/f;", "unreadCategoryProcessor", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "categoryProcessors", "G", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/h;", "I", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/h;", "adapter", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/u;", "J", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/u;", "loadMoreAdapter", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/d;", "K", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/d;", "notificationListAdapter", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "L", "Lkotlin/Lazy;", "Fh", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "loadingDialog", "<init>", "()V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationWithRecommendFragment extends QPublicBaseFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopNotificationWithRecommendViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopNotificationListVM notificationListVM;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.troopnotification.vm.processor.f unreadCategoryProcessor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopnotification.vm.processor.f> categoryProcessors;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private h adapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private u loadMoreAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopnotification.adapter.d notificationListAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendFragment$a;", "", "", "DT_PAGE_ID", "Ljava/lang/String;", "", "PRELOAD_ITEM_OFFSET_INDEX", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/recommend/TroopNotificationWithRecommendFragment$b", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.SimpleOnItemTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f300690d;

        b(RecyclerView recyclerView) {
            this.f300690d = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            CommonSwipeMenuLayout commonSwipeMenuLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rv5, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            if (e16.getAction() == 0 && !(this.f300690d.findChildViewUnder(e16.getX(), e16.getY()) instanceof CommonSwipeMenuLayout) && (commonSwipeMenuLayout = CommonSwipeMenuLayout.f().get()) != null) {
                commonSwipeMenuLayout.j();
            }
            return super.onInterceptTouchEvent(rv5, e16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationWithRecommendFragment() {
        List<com.tencent.mobileqq.troop.troopnotification.vm.processor.f> listOf;
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopnotification.vm.processor.f fVar = new com.tencent.mobileqq.troop.troopnotification.vm.processor.f();
        this.unreadCategoryProcessor = fVar;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(fVar);
        this.categoryProcessors = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$loadingDialog$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQProgressDialog invoke() {
                int titleBarHeight;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QQProgressDialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = TroopNotificationWithRecommendFragment.this.getContext();
                titleBarHeight = TroopNotificationWithRecommendFragment.this.getTitleBarHeight();
                return new QQProgressDialog(context, titleBarHeight);
            }
        });
        this.loadingDialog = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQProgressDialog Fh() {
        return (QQProgressDialog) this.loadingDialog.getValue();
    }

    private final void Gh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ad.f302002a.b(activity, "pg_group_notice_recom", new HashMap<>(), false);
        }
    }

    private final void Hh() {
        TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = this.viewModel;
        if (troopNotificationWithRecommendViewModel != null) {
            LiveData<List<Object>> X1 = troopNotificationWithRecommendViewModel.X1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final TroopNotificationWithRecommendFragment$initObserver$1$1 troopNotificationWithRecommendFragment$initObserver$1$1 = new TroopNotificationWithRecommendFragment$initObserver$1$1(this);
            X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationWithRecommendFragment.Jh(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> Z1 = troopNotificationWithRecommendViewModel.Z1();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initObserver$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean show) {
                    QQProgressDialog Fh;
                    QQProgressDialog Fh2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) show);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(show, "show");
                    if (show.booleanValue()) {
                        Fh2 = TroopNotificationWithRecommendFragment.this.Fh();
                        Fh2.show();
                    } else {
                        Fh = TroopNotificationWithRecommendFragment.this.Fh();
                        Fh.dismiss();
                    }
                }
            };
            Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationWithRecommendFragment.Kh(Function1.this, obj);
                }
            });
            MutableLiveData<Pair<Integer, String>> a26 = troopNotificationWithRecommendViewModel.a2();
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            final Function1<Pair<? extends Integer, ? extends String>, Unit> function12 = new Function1<Pair<? extends Integer, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initObserver$1$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends String> pair) {
                    invoke2((Pair<Integer, String>) pair);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
                
                    if (r0.U1() == true) goto L14;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(Pair<Integer, String> pair) {
                    TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel2;
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
                        return;
                    }
                    troopNotificationWithRecommendViewModel2 = TroopNotificationWithRecommendFragment.this.viewModel;
                    if (troopNotificationWithRecommendViewModel2 != null) {
                        z16 = true;
                    }
                    z16 = false;
                    if (z16) {
                        QQToast.makeText(TroopNotificationWithRecommendFragment.this.getContext(), pair.getFirst().intValue(), pair.getSecond(), 0).show();
                    }
                }
            };
            a26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationWithRecommendFragment.Lh(Function1.this, obj);
                }
            });
            MutableLiveData<Pair<Boolean, Boolean>> T1 = troopNotificationWithRecommendViewModel.T1();
            LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
            final Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> function13 = new Function1<Pair<? extends Boolean, ? extends Boolean>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initObserver$1$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
                    invoke2((Pair<Boolean, Boolean>) pair);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Pair<Boolean, Boolean> pair) {
                    u uVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
                        return;
                    }
                    uVar = TroopNotificationWithRecommendFragment.this.loadMoreAdapter;
                    if (uVar != null) {
                        uVar.setLoadState(pair.getFirst().booleanValue(), pair.getSecond().booleanValue());
                    }
                }
            };
            T1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationWithRecommendFragment.Mh(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> S1 = troopNotificationWithRecommendViewModel.S1();
            LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initObserver$1$5
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    com.tencent.mobileqq.troop.troopnotification.vm.processor.f fVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        fVar = TroopNotificationWithRecommendFragment.this.unreadCategoryProcessor;
                        fVar.d();
                    }
                }
            };
            S1.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopNotificationWithRecommendFragment.Nh(Function1.this, obj);
                }
            });
        }
        TroopNotificationListVM troopNotificationListVM = this.notificationListVM;
        if (troopNotificationListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
            troopNotificationListVM = null;
        }
        com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<com.tencent.qqnt.notification.f>>> j26 = troopNotificationListVM.j2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit> function15 = new Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<com.tencent.qqnt.notification.f>> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<Integer, ? extends List<com.tencent.qqnt.notification.f>> map) {
                TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel2;
                com.tencent.mobileqq.troop.troopnotification.adapter.d dVar;
                TroopNotificationListVM troopNotificationListVM2;
                TroopNotificationListVM troopNotificationListVM3;
                TroopNotificationListVM troopNotificationListVM4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                    return;
                }
                troopNotificationWithRecommendViewModel2 = TroopNotificationWithRecommendFragment.this.viewModel;
                if (troopNotificationWithRecommendViewModel2 != null) {
                    List<com.tencent.qqnt.notification.f> list = map.get(0);
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    troopNotificationWithRecommendViewModel2.i2(list);
                }
                dVar = TroopNotificationWithRecommendFragment.this.notificationListAdapter;
                TroopNotificationListVM troopNotificationListVM5 = null;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationListAdapter");
                    dVar = null;
                }
                dVar.notifyDataSetChanged();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotifyWithRcmdFrag", 2, "onCreateView: notifyDataSetChanged, notification.size=" + map.size());
                }
                troopNotificationListVM2 = TroopNotificationWithRecommendFragment.this.notificationListVM;
                if (troopNotificationListVM2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
                    troopNotificationListVM2 = null;
                }
                TroopNotificationListVM.J2(troopNotificationListVM2, 0, 0, 2, null);
                troopNotificationListVM3 = TroopNotificationWithRecommendFragment.this.notificationListVM;
                if (troopNotificationListVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
                    troopNotificationListVM3 = null;
                }
                troopNotificationListVM3.I2(1, 0);
                troopNotificationListVM4 = TroopNotificationWithRecommendFragment.this.notificationListVM;
                if (troopNotificationListVM4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
                } else {
                    troopNotificationListVM5 = troopNotificationListVM4;
                }
                troopNotificationListVM5.I2(2, 0);
            }
        };
        j26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationWithRecommendFragment.Ih(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Oh() {
        RecyclerView recyclerView;
        this.adapter = new h(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        u uVar = new u();
        uVar.setHasStableIds(true);
        uVar.registerLoadMoreListener(this);
        uVar.setLoadState(false, false);
        this.loadMoreAdapter = uVar;
        TroopNotificationListVM troopNotificationListVM = this.notificationListVM;
        if (troopNotificationListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
            troopNotificationListVM = null;
        }
        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar = new com.tencent.mobileqq.troop.troopnotification.adapter.d(troopNotificationListVM, 0, 0);
        this.notificationListAdapter = dVar;
        dVar.p0(new Function2<com.tencent.mobileqq.troop.troopnotification.render.vh.list.a, Integer, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initRV$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopnotification.render.vh.list.a aVar, Integer num) {
                invoke(aVar, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a vh5, int i3) {
                com.tencent.mobileqq.troop.troopnotification.adapter.d dVar2;
                com.tencent.mobileqq.troop.troopnotification.adapter.d dVar3;
                TroopNotificationListVM troopNotificationListVM2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) vh5, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(vh5, "vh");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotifyWithRcmdFrag", 2, "onBindViewListener: pos=" + i3);
                }
                dVar2 = TroopNotificationWithRecommendFragment.this.notificationListAdapter;
                TroopNotificationListVM troopNotificationListVM3 = null;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notificationListAdapter");
                    dVar2 = null;
                }
                if (dVar2.getItemCount() - i3 < 5) {
                    ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
                    int notificationUnreadCount = iTroopNotificationInnerService != null ? iTroopNotificationInnerService.getNotificationUnreadCount() : 0;
                    dVar3 = TroopNotificationWithRecommendFragment.this.notificationListAdapter;
                    if (dVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationListAdapter");
                        dVar3 = null;
                    }
                    if (dVar3.getItemCount() < notificationUnreadCount) {
                        troopNotificationListVM2 = TroopNotificationWithRecommendFragment.this.notificationListVM;
                        if (troopNotificationListVM2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
                        } else {
                            troopNotificationListVM3 = troopNotificationListVM2;
                        }
                        troopNotificationListVM3.N2(0);
                    }
                }
            }
        });
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar2 = this.notificationListAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListAdapter");
            dVar2 = null;
        }
        adapterArr[0] = dVar2;
        adapterArr[1] = this.adapter;
        adapterArr[2] = this.loadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        View view = this.rootView;
        if (view != null) {
            recyclerView = (RecyclerView) view.findViewById(R.id.i4m);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            recyclerView.setAdapter(rFWConcatAdapter);
            recyclerView.addOnItemTouchListener(new b(recyclerView));
        }
    }

    private final void Ph() {
        QUISecNavBar qUISecNavBar;
        View view = this.rootView;
        if (view != null && (qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.idz)) != null) {
            BaseAction baseAction = BaseAction.ACTION_LEFT_BUTTON;
            String qqStr = HardCodeUtil.qqStr(R.string.f170549u3);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobileqq.qqui.R.string.back)");
            qUISecNavBar.setBaseViewDescription(baseAction, qqStr);
            qUISecNavBar.S(this);
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.TroopNotificationWithRecommendFragment$initTitle$1$1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes19.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f300691a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59051);
                        $redirector_ = redirector;
                        if (redirector != null && redirector.hasPatch((short) 1)) {
                            redirector.redirect((short) 1);
                            return;
                        }
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f300691a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationWithRecommendFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction2) {
                    invoke2(view2, baseAction2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2, @Nullable BaseAction baseAction2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) baseAction2);
                        return;
                    }
                    if ((baseAction2 == null ? -1 : a.f300691a[baseAction2.ordinal()]) == 1) {
                        if (AppSetting.t(TroopNotificationWithRecommendFragment.this.getContext())) {
                            QBaseActivity qBaseActivity = TroopNotificationWithRecommendFragment.this.getQBaseActivity();
                            if (qBaseActivity != null) {
                                qBaseActivity.doOnBackPressed();
                                return;
                            }
                            return;
                        }
                        QBaseActivity qBaseActivity2 = TroopNotificationWithRecommendFragment.this.getQBaseActivity();
                        if (qBaseActivity2 != null) {
                            qBaseActivity2.finish();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Qh() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTitleBarHeight() {
        return BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        this.viewModel = (TroopNotificationWithRecommendViewModel) getViewModel(TroopNotificationWithRecommendViewModel.class);
        this.notificationListVM = TroopNotificationListVM.INSTANCE.a(this);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putInt("KEY_SOURCE_FOR_VM", 3);
        TroopNotificationListVM troopNotificationListVM = this.notificationListVM;
        if (troopNotificationListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
            troopNotificationListVM = null;
        }
        troopNotificationListVM.z2(this, arguments, this.categoryProcessors);
        TroopFeatureReport.c(TroopFeatureReport.f361921a, "TroopNotifyWithRcmdFrag", false, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            this.rootView = inflater.inflate(R.layout.i0d, container, false);
            Ph();
            Oh();
            Hh();
            Gh();
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        TroopNotificationListVM troopNotificationListVM = this.notificationListVM;
        if (troopNotificationListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
            troopNotificationListVM = null;
        }
        troopNotificationListVM.destroy();
        if (QLog.isDebugVersion()) {
            QLog.d("TroopNotifyWithRcmdFrag", 4, "[onDestroy]");
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = this.viewModel;
        if (troopNotificationWithRecommendViewModel != null) {
            troopNotificationWithRecommendViewModel.d2(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = this.viewModel;
        if (troopNotificationWithRecommendViewModel != null) {
            troopNotificationWithRecommendViewModel.f2(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = this.viewModel;
        if (troopNotificationWithRecommendViewModel != null) {
            troopNotificationWithRecommendViewModel.f2(true);
        }
        TroopNotificationListVM troopNotificationListVM = this.notificationListVM;
        if (troopNotificationListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationListVM");
            troopNotificationListVM = null;
        }
        troopNotificationListVM.H2();
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
        TroopNotificationWithRecommendViewModel troopNotificationWithRecommendViewModel = this.viewModel;
        if (troopNotificationWithRecommendViewModel != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            troopNotificationWithRecommendViewModel.b2(viewLifecycleOwner);
        }
    }
}
