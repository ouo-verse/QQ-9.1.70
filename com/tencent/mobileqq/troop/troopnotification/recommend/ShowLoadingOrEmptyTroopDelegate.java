package com.tencent.mobileqq.troop.troopnotification.recommend;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopnotification.recommend.ShowLoadingOrEmptyTroopDelegate;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/ShowLoadingOrEmptyTroopDelegate;", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/t;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "isForViewType", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "ShowEmptyTroopSection", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ShowLoadingOrEmptyTroopDelegate extends t<Object> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u000f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010!\u001a\n \u001d*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/ShowLoadingOrEmptyTroopDelegate$ShowEmptyTroopSection;", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/s;", "", "Landroid/content/Context;", "context", "", "t", "Landroid/view/View;", "containerView", "", "onInitView", "data", "position", "", "payload", "onBindData", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "emptyContainerView", "e", "Landroid/view/View;", "splitLine", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "f", "Lkotlin/Lazy;", "r", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyUi", "kotlin.jvm.PlatformType", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "()Landroid/view/View;", "loadingUi", "<init>", "()V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class ShowEmptyTroopSection extends s<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: m, reason: collision with root package name */
        private static final int f300685m;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private LinearLayout emptyContainerView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View splitLine;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy emptyUi;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy loadingUi;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/ShowLoadingOrEmptyTroopDelegate$ShowEmptyTroopSection$a;", "", "", "CONTAINER_MIN_HEIGHT", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopnotification.recommend.ShowLoadingOrEmptyTroopDelegate$ShowEmptyTroopSection$a, reason: from kotlin metadata */
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

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58849);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
                f300685m = ViewUtils.f352270a.b(160);
            }
        }

        public ShowEmptyTroopSection() {
            Lazy lazy;
            Lazy lazy2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.ShowLoadingOrEmptyTroopDelegate$ShowEmptyTroopSection$emptyUi$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShowLoadingOrEmptyTroopDelegate.ShowEmptyTroopSection.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final QUIEmptyState invoke() {
                        View view;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        view = ((Section) ShowLoadingOrEmptyTroopDelegate.ShowEmptyTroopSection.this).mRootView;
                        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(view.getContext());
                        builder.setImageType(16);
                        builder.setTitle("\u6682\u65e0\u6570\u636e");
                        builder.setHalfScreenState(true);
                        return builder.build();
                    }
                });
                this.emptyUi = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.ShowLoadingOrEmptyTroopDelegate$ShowEmptyTroopSection$loadingUi$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShowLoadingOrEmptyTroopDelegate.ShowEmptyTroopSection.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final View invoke() {
                        View view;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        view = ((Section) ShowLoadingOrEmptyTroopDelegate.ShowEmptyTroopSection.this).mRootView;
                        return LoadingUtil.getLoadingDialogTipsRight(view.getContext(), false);
                    }
                });
                this.loadingUi = lazy2;
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        private final QUIEmptyState r() {
            return (QUIEmptyState) this.emptyUi.getValue();
        }

        private final View s() {
            return (View) this.loadingUi.getValue();
        }

        private final int t(Context context) {
            WindowManager windowManager;
            int i3;
            Object systemService = context.getSystemService("window");
            if (systemService instanceof WindowManager) {
                windowManager = (WindowManager) systemService;
            } else {
                windowManager = null;
            }
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i3 = point.y;
            } else {
                i3 = -1;
            }
            if (ScreenUtil.checkNavigationBarShow(context)) {
                return i3 - ScreenUtil.getNavigationBarHeight(context);
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u(LinearLayout it, ShowEmptyTroopSection this$0) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(it, "$it");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int[] iArr = new int[2];
            it.getLocationOnScreen(iArr);
            if (iArr[1] > 0) {
                ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
                Context context = this$0.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                int t16 = this$0.t(context) - iArr[1];
                if (t16 > 0) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(t16, f300685m);
                    layoutParams.height = coerceAtLeast;
                }
            }
            it.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onBindData(@Nullable Object data, int position, @Nullable List<Object> payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, data, Integer.valueOf(position), payload);
                return;
            }
            if (Intrinsics.areEqual(this.mRootView.getTag(R.id.bwb), data)) {
                if (QLog.isColorLevel()) {
                    QLog.i("ShowEmptyTroopSection", 2, "[onBindData] same data");
                    return;
                }
                return;
            }
            this.mRootView.setTag(R.id.bwb, data);
            final LinearLayout linearLayout = this.emptyContainerView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                linearLayout.removeAllViews();
                if (data == TroopNotifyWithRecommendPlaceHolder.SHOW_LOADING_TROOP) {
                    linearLayout.addView(s());
                } else {
                    linearLayout.addView(r());
                    View view = this.splitLine;
                    if (view != null) {
                        if (data == TroopNotifyWithRecommendPlaceHolder.SHOW_ALL_EMPTY) {
                            i3 = 8;
                        }
                        view.setVisibility(i3);
                    }
                }
                linearLayout.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShowLoadingOrEmptyTroopDelegate.ShowEmptyTroopSection.u(linearLayout, this);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@Nullable View containerView) {
            LinearLayout linearLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView);
                return;
            }
            View view = null;
            if (containerView != null) {
                linearLayout = (LinearLayout) containerView.findViewById(R.id.bwb);
            } else {
                linearLayout = null;
            }
            this.emptyContainerView = linearLayout;
            if (containerView != null) {
                view = containerView.findViewById(R.id.j0s);
            }
            this.splitLine = view;
        }
    }

    public ShowLoadingOrEmptyTroopDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.i0f;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<Object>>> sections) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, parent, itemView, sections);
            return;
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(ShowEmptyTroopSection.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected boolean isForViewType(@NotNull Object item, @NotNull List<Object> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        if (item != TroopNotifyWithRecommendPlaceHolder.SHOW_EMPTY_TROOP && item != TroopNotifyWithRecommendPlaceHolder.SHOW_LOADING_TROOP && item != TroopNotifyWithRecommendPlaceHolder.SHOW_ALL_EMPTY) {
            return false;
        }
        return true;
    }
}
