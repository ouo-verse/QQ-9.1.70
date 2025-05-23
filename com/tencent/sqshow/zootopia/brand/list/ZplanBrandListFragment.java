package com.tencent.sqshow.zootopia.brand.list;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.brand.list.view.ZplanBrandItemView;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.p;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import r84.ZootopiaBrandMallItemData;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u001a\u0010.\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0014H\u0016J\u001a\u00101\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020/H\u0016J\b\u00107\u001a\u000206H\u0014J\b\u00108\u001a\u00020\u0014H\u0016R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010MR\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010MR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/ZplanBrandListFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Lk84/a;", "Ldb4/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView$c;", "", "initViewModel", "Qh", "Ln74/b;", "viewBinding", "Th", "Xh", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/RecyclerViewWithHeaderFooterFix;", "recyclerView", "Zh", "", "Lr84/a;", "dataList", "Vh", "", "isFirstRequest", "Uh", "ai", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "ne", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "isMachineRefresh", "xe", "", "reqType", "J3", "endOfRefresh", NodeProps.ON_CLICK, "status", "I4", "", "getSubSource", "onBackPressedEvent", "Lcom/tencent/common/app/AppInterface;", "N", "Lcom/tencent/common/app/AppInterface;", "app", "P", "Ln74/b;", "binding", "Lg84/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lg84/d;", "viewModel", "Lid3/d;", BdhLogUtil.LogTag.Tag_Req, "Lid3/d;", "dtReporter", "Lcom/tencent/sqshow/zootopia/brand/list/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/brand/list/a;", "listAdapter", "T", "Z", "needAnimation", "U", "hasAnimationDone", "V", "isAnimating", "W", "Ljava/util/List;", "cacheDataList", "X", "hasPaused", "Loa4/a;", "Y", "Lkotlin/Lazy;", "Wh", "()Loa4/a;", "mapResViewModel", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mItemDecoration", "<init>", "()V", "a0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanBrandListFragment extends ZootopiaBaseFragment implements k84.a, db4.a, View.OnClickListener, XPullToRefreshView.c {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: P, reason: from kotlin metadata */
    private n74.b binding;

    /* renamed from: Q, reason: from kotlin metadata */
    private g84.d viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private final id3.d dtReporter = new id3.d(null, 1, null);

    /* renamed from: S, reason: from kotlin metadata */
    private a listAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean needAnimation;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasAnimationDone;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: W, reason: from kotlin metadata */
    private List<ZootopiaBrandMallItemData> cacheDataList;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy mapResViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    private RecyclerView.ItemDecoration mItemDecoration;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/ZplanBrandListFragment$a;", "", "Landroid/os/Bundle;", "arguments", "", "c", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromSource", "bundle", "", "b", "", "SPAN_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.brand.list.ZplanBrandListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(Context context, ZootopiaSource fromSource, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZplanBrandListFragment.class, fromSource, bundle, false, 16, null);
            if (c(bundle) && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(Bundle arguments) {
            if (arguments != null) {
                return arguments.getBoolean("transitionAnimation", false);
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/brand/list/ZplanBrandListFragment$b", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroid/support/v7/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f370110d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f370111e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f370112f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.FloatRef f370113h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f370114i;

        b(int i3, Ref.IntRef intRef, int i16, Ref.FloatRef floatRef, int i17) {
            this.f370110d = i3;
            this.f370111e = intRef;
            this.f370112f = i16;
            this.f370113h = floatRef;
            this.f370114i = i17;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (view instanceof ZplanBrandItemView) {
                Object tag = ((ZplanBrandItemView) view).getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) tag).intValue() % this.f370110d;
                if (intValue == 0) {
                    outRect.set(this.f370111e.element, 0, 0, 0);
                    return;
                } else {
                    outRect.set((int) (this.f370111e.element + (intValue * ((this.f370112f + this.f370113h.element) - (this.f370114i / r6)))), 0, 0, 0);
                    return;
                }
            }
            outRect.set(0, 0, 0, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/brand/list/ZplanBrandListFragment$c", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f370116b;

        c(int i3) {
            this.f370116b = i3;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            a aVar = ZplanBrandListFragment.this.listAdapter;
            if ((aVar != null ? aVar.getItemViewType(position) : 0) == 202205) {
                return 1;
            }
            return this.f370116b;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/brand/list/ZplanBrandListFragment$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("ZplanBrandListFragment", 1, "startPageAnimation - onAnimationEnd");
            ZplanBrandListFragment.this.isAnimating = false;
            List list = ZplanBrandListFragment.this.cacheDataList;
            if (list != null) {
                ZplanBrandListFragment zplanBrandListFragment = ZplanBrandListFragment.this;
                zplanBrandListFragment.Vh(list);
                zplanBrandListFragment.cacheDataList = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            QLog.i("ZplanBrandListFragment", 1, "startPageAnimation - onAnimationStart");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }

    public ZplanBrandListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.sqshow.zootopia.brand.list.ZplanBrandListFragment$mapResViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = h.a(ZplanBrandListFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResViewModel = lazy;
    }

    private final void Qh() {
        MutableLiveData<ErrorMessage> Q1;
        MutableLiveData<List<ZootopiaBrandMallItemData>> P1;
        g84.d dVar = this.viewModel;
        if (dVar != null && (P1 = dVar.P1()) != null) {
            P1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.brand.list.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZplanBrandListFragment.Rh(ZplanBrandListFragment.this, (List) obj);
                }
            });
        }
        g84.d dVar2 = this.viewModel;
        if (dVar2 == null || (Q1 = dVar2.Q1()) == null) {
            return;
        }
        Q1.observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.brand.list.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanBrandListFragment.Sh(ZplanBrandListFragment.this, (ErrorMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZplanBrandListFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4(it.isEmpty() ? 3 : 4);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Vh(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ZplanBrandListFragment this$0, ErrorMessage errorMessage) {
        MutableLiveData<List<ZootopiaBrandMallItemData>> P1;
        List<ZootopiaBrandMallItemData> value;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g84.d dVar = this$0.viewModel;
        boolean z16 = false;
        if (dVar != null && (P1 = dVar.P1()) != null && (value = P1.getValue()) != null && !value.isEmpty()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this$0.I4(2);
    }

    private final void Uh(boolean isFirstRequest) {
        g84.d dVar = this.viewModel;
        if (dVar != null) {
            dVar.O1(isFirstRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(List<ZootopiaBrandMallItemData> dataList) {
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout;
        QLog.i("ZplanBrandListFragment", 1, "finalRenderListData, isAnimating = " + this.isAnimating);
        if (this.isAnimating) {
            this.cacheDataList = dataList;
            return;
        }
        a aVar = this.listAdapter;
        if (aVar != null) {
            aVar.fillList(dataList);
        }
        n74.b bVar = this.binding;
        if (bVar != null && (zootopiaPullRefreshLayout = bVar.f418780b) != null) {
            zootopiaPullRefreshLayout.s(true);
        }
        if (!this.needAnimation || this.hasAnimationDone) {
            return;
        }
        ai();
        this.hasAnimationDone = true;
    }

    private final oa4.a Wh() {
        return (oa4.a) this.mapResViewModel.getValue();
    }

    private final void Xh() {
        n74.b bVar = this.binding;
        if (bVar == null) {
            return;
        }
        bVar.f418780b.G(false);
        bVar.f418780b.setPullRefreshMode(1);
        bVar.f418780b.setRefreshCallback(this);
        RecyclerViewWithHeaderFooterFix recyclerView = bVar.f418780b.E();
        recyclerView.setClipChildren(false);
        recyclerView.setItemAnimator(null);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        a aVar = new a(requireContext, Wh(), this, Ch(), null, 16, null);
        this.listAdapter = aVar;
        recyclerView.setAdapter(aVar);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Zh(recyclerView);
        p.a(recyclerView, Ch());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ZplanBrandListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZplanBrandListFragment", 1, "retry load");
        this$0.I4(1);
        this$0.ne();
    }

    private final void Zh(RecyclerViewWithHeaderFooterFix recyclerView) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = getResources().getDimensionPixelSize(R.dimen.f116058);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f116159);
        u.Companion companion = u.INSTANCE;
        Context context = getContext();
        if (context == null) {
            context = recyclerView.getContext();
        }
        int c16 = companion.c(context);
        int b16 = i.b(5);
        int i3 = ((c16 - (intRef.element * 2)) + b16) / (b16 + dimensionPixelSize);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        int i16 = i3 * dimensionPixelSize;
        float f16 = i3 - 1;
        float f17 = ((c16 - (intRef.element * 2)) - i16) / f16;
        floatRef.element = f17;
        if (f17 < i.e(1)) {
            float e16 = i.e(1);
            floatRef.element = e16;
            intRef.element = (int) (((c16 - i16) - (e16 * f16)) / 2);
        }
        RecyclerView.ItemDecoration itemDecoration = this.mItemDecoration;
        if (itemDecoration != null) {
            recyclerView.removeItemDecoration(itemDecoration);
        }
        RecyclerView.ItemDecoration bVar = new b(i3, intRef, dimensionPixelSize, floatRef, c16);
        this.mItemDecoration = bVar;
        recyclerView.addItemDecoration(bVar);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(requireContext(), i3);
        }
        gridLayoutManager.setSpanCount(i3);
        gridLayoutManager.setSpanSizeLookup(new c(i3));
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(FrameLayout animationView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(animationView, "$animationView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f16 = (0.19999999f * floatValue) + 0.8f;
        animationView.setScaleX(f16);
        animationView.setScaleY(f16);
        animationView.setAlpha(floatValue);
    }

    private final void initViewModel() {
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return;
        }
        this.viewModel = (g84.d) new ViewModelProvider(this, new g84.a(appInterface, Ch())).get(g84.d.class);
    }

    @Override // db4.a
    public void I4(int status) {
        QLog.i("ZplanBrandListFragment", 1, "updateCardListStatus status = " + status);
        n74.b bVar = this.binding;
        if (bVar != null) {
            if (status == 1) {
                bVar.f418782d.setVisibility(0);
                bVar.f418781c.setVisibility(8);
                bVar.f418780b.setVisibility(8);
                return;
            }
            if (status == 2) {
                bVar.f418781c.setVisibility(0);
                bVar.f418782d.setVisibility(8);
                bVar.f418780b.setVisibility(8);
            } else if (status == 3) {
                bVar.f418781c.setVisibility(0);
                bVar.f418782d.setVisibility(8);
                bVar.f418780b.setVisibility(8);
            } else {
                if (status != 4) {
                    return;
                }
                bVar.f418780b.setVisibility(0);
                bVar.f418782d.setVisibility(8);
                bVar.f418781c.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_BRAND_LIST;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 == R.id.plc) {
            this.dtReporter.c("clck", view, new LinkedHashMap());
            onBackPressedEvent();
        } else if (id5 == R.id.pld) {
            this.dtReporter.c("clck", view, new LinkedHashMap());
            String buildMallScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildMallScheme(Ch(), 0);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = getContext();
            if (context == null) {
                context = BaseApplication.context;
            }
            Intrinsics.checkNotNullExpressionValue(context, "context ?: MobileQQ.context");
            iSchemeApi.launchScheme(context, buildMallScheme);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout;
        RecyclerViewWithHeaderFooterFix E;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.d("ZplanBrandListFragment", 1, "onConfigurationChanged " + newConfig);
        try {
            n74.b bVar = this.binding;
            if (bVar == null || (zootopiaPullRefreshLayout = bVar.f418780b) == null || (E = zootopiaPullRefreshLayout.E()) == null) {
                return;
            }
            Zh(E);
            RecyclerView.Adapter adapter = E.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e16) {
            QLog.e("ZplanBrandListFragment", 1, "onConfiguration " + e16);
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.app = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity activity;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        n74.b g16 = n74.b.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null && (frameLayout = g16.f418788j) != null) {
            frameLayout.setPadding(0, Bh(), 0, 0);
        }
        n74.b bVar = this.binding;
        if (bVar != null && (activity = getActivity()) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch()));
            id3.d dVar = this.dtReporter;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FrameLayout root = bVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            dVar.j(activity, root, "pg_zplan_brand_gallery", hashMap);
        }
        n74.b bVar2 = this.binding;
        if (bVar2 != null) {
            return bVar2.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.hasPaused = true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
        if (this.hasPaused) {
            this.hasPaused = false;
            QLog.i("ZplanBrandListFragment", 1, "onResume - manualRefreshData");
            Uh(false);
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.needAnimation = INSTANCE.c(getArguments());
        n74.b bVar = this.binding;
        if (bVar != null) {
            Xh();
            I4(1);
            bVar.f418784f.setOnClickListener(this);
            bVar.f418785g.setOnClickListener(this);
            bVar.f418781c.getBtnNetworkError().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.brand.list.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZplanBrandListFragment.Yh(ZplanBrandListFragment.this, view2);
                }
            });
            initViewModel();
            Qh();
            Th(bVar);
        }
        Uh(true);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void xe(XPullToRefreshView recyclerView, boolean isMachineRefresh) {
        ne();
    }

    private final void ai() {
        final FrameLayout frameLayout;
        this.isAnimating = true;
        n74.b bVar = this.binding;
        if (bVar == null || (frameLayout = bVar.f418787i) == null) {
            return;
        }
        QLog.i("ZplanBrandListFragment", 1, "startPageAnimation");
        frameLayout.setPivotX(ScreenUtils.getScreenWidth(getContext()));
        frameLayout.setPivotY(ScreenUtils.getScreenHeight(getContext()));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.3f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.brand.list.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZplanBrandListFragment.bi(frameLayout, valueAnimator);
            }
        });
        ofFloat.addListener(new d());
        ofFloat.start();
    }

    @Override // k84.a
    public void ne() {
        Uh(false);
    }

    private final void Th(n74.b viewBinding) {
        id3.d dVar = this.dtReporter;
        ImageView imageView = viewBinding.f418784f;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.commonTitlebarBack");
        id3.d.i(dVar, imageView, "em_zplan_back_btn", new LinkedHashMap(), false, true, null, false, false, 224, null);
        id3.d dVar2 = this.dtReporter;
        LinearLayout linearLayout = viewBinding.f418785g;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.commonTitlebarRightIcon");
        id3.d.i(dVar2, linearLayout, "em_zplan_customiztion", new LinkedHashMap(), false, true, null, false, false, 224, null);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void endOfRefresh() {
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void J3(XPullToRefreshView recyclerView, int reqType) {
    }
}
