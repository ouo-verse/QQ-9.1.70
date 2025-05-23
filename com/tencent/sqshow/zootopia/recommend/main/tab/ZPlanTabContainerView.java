package com.tencent.sqshow.zootopia.recommend.main.tab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import n74.bl;
import tl.h;

@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0002'bB'\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020\u0007\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0002J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016J\u001e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010)R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\t0+j\b\u0012\u0004\u0012\u00020\t`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010-R0\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0/j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00101R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00103R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00109R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020 0;j\b\u0012\u0004\u0012\u00020 `<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010K\u001a\u00020D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010MR0\u0010Q\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O0/j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u00101R0\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O0/j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020O`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u00101R\u0018\u0010U\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006c"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/a;", "", "r", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "", "index", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/f;", "data", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabItemView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "withAnim", "Lkotlin/Function0;", "callback", "p", "o", "Landroid/animation/AnimatorSet;", "animatorSet", "u", "Llb4/a;", "switcher", "g", "b", h.F, "selectedPos", "", "dataList", "f", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/g;", "l", "e", "c", "d", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", FunctionConfigManagerImpl.CONFIG_CONTENT_URL, "a", "destroy", "Llb4/a;", "mFragSwitcher", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mItemViewPool", "I", "mSelectedTab", "i", "Z", "mShowState", "Ln74/bl;", "Ln74/bl;", "mBinding", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "mTabSelectListenerPool", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "D", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "", "E", "Ljava/lang/String;", "getMSourceId", "()Ljava/lang/String;", "setMSourceId", "(Ljava/lang/String;)V", "mSourceId", "", UserInfo.SEX_FEMALE, "mTabTransY", "", "G", "mTabReselectTimeMap", "H", "mTabLastClickRefreshTimeMap", "Landroid/animation/AnimatorSet;", "mCurrentAnim", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView$TabRefreshTask;", "J", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView$TabRefreshTask;", "mTabRefreshTask", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "TabRefreshTask", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTabContainerView extends FrameLayout implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashSet<g> mTabSelectListenerPool;

    /* renamed from: D, reason: from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* renamed from: E, reason: from kotlin metadata */
    private String mSourceId;

    /* renamed from: F, reason: from kotlin metadata */
    private final float mTabTransY;

    /* renamed from: G, reason: from kotlin metadata */
    private final HashMap<Integer, Long> mTabReselectTimeMap;

    /* renamed from: H, reason: from kotlin metadata */
    private final HashMap<Integer, Long> mTabLastClickRefreshTimeMap;

    /* renamed from: I, reason: from kotlin metadata */
    private AnimatorSet mCurrentAnim;

    /* renamed from: J, reason: from kotlin metadata */
    private final TabRefreshTask mTabRefreshTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private lb4.a mFragSwitcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ZPlanTabData> mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, ZPlanTabItemView> mItemViewPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mSelectedTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mShowState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final bl mBinding;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView$TabRefreshTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView;", "d", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "<init>", "(Ljava/lang/ref/WeakReference;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class TabRefreshTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanTabContainerView> ref;

        public TabRefreshTask(WeakReference<ZPlanTabContainerView> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZPlanTabContainerView zPlanTabContainerView = this.ref.get();
            if (zPlanTabContainerView != null) {
                zPlanTabContainerView.r();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f372630d;

        b(Function0<Unit> function0) {
            this.f372630d = function0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("ZPlanTabContainerView_", 1, "doHideTask onAnimationEnd");
            Function0<Unit> function0 = this.f372630d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/tab/ZPlanTabContainerView$c", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f372631d;

        c(Function0<Unit> function0) {
            this.f372631d = function0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("ZPlanTabContainerView_", 1, "doShowTask onAnimationEnd");
            Function0<Unit> function0 = this.f372631d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanTabContainerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ZPlanTabItemView m(int index, ZPlanTabData data) {
        ZPlanTabItemView zPlanTabItemView = this.mItemViewPool.get(Integer.valueOf(index));
        if (zPlanTabItemView == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zPlanTabItemView = new ZPlanTabItemView(context, null, 0, 6, null);
        }
        zPlanTabItemView.B0(data);
        return zPlanTabItemView;
    }

    private final void n() {
        setVisibility(this.mData.size() > 1 ? 0 : 8);
    }

    private final void o(boolean withAnim, Function0<Unit> callback) {
        long j3;
        QLog.i("ZPlanTabContainerView_", 1, "doHideTask");
        float translationY = getTranslationY();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", translationY, this.mTabTransY));
        if (withAnim) {
            float f16 = this.mTabTransY;
            j3 = (150 * (f16 - translationY)) / f16;
        } else {
            j3 = 0;
        }
        animatorSet.setDuration(j3);
        animatorSet.addListener(new b(callback));
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        u(animatorSet);
    }

    private final void p(boolean withAnim, Function0<Unit> callback) {
        QLog.i("ZPlanTabContainerView_", 1, "doShowTask ");
        float translationY = getTranslationY();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", translationY, 0.0f));
        animatorSet.setDuration(withAnim ? (150 * translationY) / this.mTabTransY : 0L);
        animatorSet.addListener(new c(callback));
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        u(animatorSet);
    }

    private final void q() {
        QLog.i("ZPlanTabContainerView_", 1, "refreshSelectState mSelectedTab:" + this.mSelectedTab);
        for (Map.Entry<Integer, ZPlanTabItemView> entry : this.mItemViewPool.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            int intValue = key.intValue();
            ZPlanTabItemView value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "entry.value");
            ZPlanTabItemView zPlanTabItemView = value;
            if (intValue == this.mSelectedTab) {
                lb4.a aVar = this.mFragSwitcher;
                if (aVar != null) {
                    ZPlanTabData zPlanTabData = this.mData.get(intValue);
                    Intrinsics.checkNotNullExpressionValue(zPlanTabData, "mData[index]");
                    aVar.a(zPlanTabData);
                }
                zPlanTabItemView.C0(ZPlanTabState.SELECTED, true);
            } else {
                ZPlanTabItemView.D0(zPlanTabItemView, ZPlanTabState.NORMAL, false, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        lb4.a aVar = this.mFragSwitcher;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZPlanTabContainerView this$0, int i3, ZPlanTabItemView itemView, HashMap params, ZPlanTabData data, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(data, "$data");
        QLog.i("ZPlanTabContainerView_", 1, "on tab view click, mShowState:" + this$0.mShowState + ", mSelectedTab:" + this$0.mSelectedTab + ", index:" + i3);
        if (this$0.mShowState) {
            this$0.mReporter.e(itemView, "em_zplan_portal_tab", params);
            if (data.getContentUrlInfo().e()) {
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iSchemeApi.launchScheme(context, data.getContentUrlInfo().getUrl());
                return;
            }
            boolean z16 = false;
            boolean z17 = this$0.mSelectedTab == i3;
            if (!z17) {
                Iterator<T> it = this$0.mTabSelectListenerPool.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).ib(this$0.mSelectedTab);
                }
                this$0.mTabReselectTimeMap.clear();
            }
            this$0.mSelectedTab = i3;
            this$0.q();
            if (z17) {
                Long l3 = this$0.mTabReselectTimeMap.get(Integer.valueOf(i3));
                if (System.currentTimeMillis() - (l3 != null ? l3.longValue() : 0L) <= 500) {
                    this$0.mTabReselectTimeMap.remove(Integer.valueOf(i3));
                } else {
                    this$0.mTabReselectTimeMap.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
                }
                Long l16 = this$0.mTabLastClickRefreshTimeMap.get(Integer.valueOf(i3));
                long zPlanPortalTabDoubleClickRefreshLimitSeconds = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanPortalTabDoubleClickRefreshLimitSeconds() * 1000;
                if (System.currentTimeMillis() - (l16 != null ? l16.longValue() : 0L) >= zPlanPortalTabDoubleClickRefreshLimitSeconds) {
                    this$0.mTabLastClickRefreshTimeMap.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
                    z16 = true;
                }
                if (z16) {
                    str = "post refreshData";
                } else {
                    str = "too frequency, doubleClickRefreshTimeDuration = " + zPlanPortalTabDoubleClickRefreshLimitSeconds;
                }
                QLog.i("ZPlanTabContainerView_", 1, "onTabReSelected - " + i3 + ", " + str);
            }
            for (g gVar : this$0.mTabSelectListenerPool) {
                if (z17) {
                    gVar.Be(i3, z16);
                } else {
                    gVar.f(i3);
                }
            }
        }
    }

    private final void u(AnimatorSet animatorSet) {
        AnimatorSet animatorSet2 = this.mCurrentAnim;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.mCurrentAnim = animatorSet;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public int a(ZPlanTabContentUrl contentUrl) {
        Object obj;
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Iterator<T> it = this.mData.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ZPlanTabData) obj).getContentUrlInfo().f(), contentUrl.f())) {
                break;
            }
        }
        ZPlanTabData zPlanTabData = (ZPlanTabData) obj;
        if (zPlanTabData == null) {
            return -1;
        }
        return this.mData.indexOf(zPlanTabData);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void c(int selectedPos) {
        QLog.i("ZPlanTabContainerView_", 1, "tabSelected selectedPos:" + selectedPos);
        this.mSelectedTab = selectedPos;
        q();
        Iterator<T> it = this.mTabSelectListenerPool.iterator();
        while (it.hasNext()) {
            ((g) it.next()).f(this.mSelectedTab);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    /* renamed from: d, reason: from getter */
    public int getMSelectedTab() {
        return this.mSelectedTab;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void destroy() {
        ZPlanTabItemView value;
        this.mTabSelectListenerPool.clear();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTabRefreshTask);
        for (Map.Entry<Integer, ZPlanTabItemView> entry : this.mItemViewPool.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.onDestroy();
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void e(g l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mTabSelectListenerPool.add(l3);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void f(int selectedPos, List<ZPlanTabData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i("ZPlanTabContainerView_", 1, "refreshTabData selectedPos:" + selectedPos + ",");
        this.mSelectedTab = selectedPos;
        this.mData.clear();
        this.mData.addAll(dataList);
        s();
        n();
        Iterator<T> it = this.mTabSelectListenerPool.iterator();
        while (it.hasNext()) {
            ((g) it.next()).f(this.mSelectedTab);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void g(lb4.a switcher) {
        Intrinsics.checkNotNullParameter(switcher, "switcher");
        this.mFragSwitcher = switcher;
    }

    public final void setMSourceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSourceId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanTabContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(View view) {
        QLog.i("ZPlanTabContainerView_", 1, "click on ZPlanTabContainerView");
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void b(boolean withAnim, Function0<Unit> callback) {
        this.mShowState = true;
        p(withAnim, callback);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.a
    public void h(boolean withAnim, Function0<Unit> callback) {
        this.mShowState = false;
        o(withAnim, callback);
    }

    public /* synthetic */ ZPlanTabContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void s() {
        boolean contains;
        lb4.a aVar;
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        Iterator<ZPlanTabData> it = this.mData.iterator();
        long j3 = 0;
        boolean z16 = false;
        long j16 = 0;
        final int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            final ZPlanTabData next = it.next();
            if (next.k() && next.getSTabEndTime() > j3) {
                if (next.getSTabEndTime() <= serverTime) {
                    QLog.w("ZPlanTabContainerView_", 1, "refreshViews data is out. " + next);
                    i3 = i16;
                } else if (j16 != j3) {
                    j16 = RangesKt___RangesKt.coerceAtMost(j16, next.getSTabEndTime());
                } else {
                    j16 = next.getSTabEndTime();
                }
            }
            long j17 = j16;
            if (this.mSelectedTab == i3 && !next.getContentUrlInfo().e() && (aVar = this.mFragSwitcher) != null) {
                aVar.a(next);
            }
            final ZPlanTabItemView m3 = m(i3, next);
            if (this.mSelectedTab == i3) {
                ZPlanTabItemView.D0(m3, ZPlanTabState.SELECTED, z16, 2, null);
            } else {
                ZPlanTabItemView.D0(m3, ZPlanTabState.NORMAL, z16, 2, null);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            if (!Intrinsics.areEqual(m3.getParent(), this.mBinding.f418855c)) {
                ViewParent parent = m3.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(m3);
                }
                this.mBinding.f418855c.addView(m3, layoutParams);
            } else {
                m3.setLayoutParams(layoutParams);
            }
            arrayList.add(m3);
            this.mItemViewPool.put(Integer.valueOf(i3), m3);
            final HashMap hashMap = new HashMap();
            hashMap.put("zplan_tab_id", Integer.valueOf(next.getTabId()));
            hashMap.put("zplan_tab_name", next.getTitle());
            hashMap.put("scheme_info", ((ISchemeApi) QRoute.api(ISchemeApi.class)).convertSchemeToJsonForReport(next.getContentUrlInfo().getUrl()));
            this.mReporter.g(m3, "em_zplan_portal_tab", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            aa.f(m3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanTabContainerView.t(ZPlanTabContainerView.this, i3, m3, hashMap, next, view);
                }
            }, 100L, "ZPlanTabContainerView_");
            i3 = i16;
            j16 = j17;
            j3 = 0;
            z16 = false;
        }
        int childCount = this.mBinding.f418855c.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = this.mBinding.f418855c.getChildAt(i17);
            contains = CollectionsKt___CollectionsKt.contains(arrayList, childAt);
            if (!contains) {
                this.mBinding.f418855c.removeView(childAt);
            }
        }
        long j18 = j16 - serverTime;
        QLog.i("ZPlanTabContainerView_", 1, "refreshViews nextTabRefreshTime:" + j16 + ", delay:" + j18);
        if (j18 > 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mTabRefreshTask);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.mTabRefreshTask, j18 * 1000);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanTabContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
        this.mItemViewPool = new HashMap<>();
        this.mTabSelectListenerPool = new HashSet<>();
        this.mReporter = new ZplanViewReportHelper();
        this.mSourceId = "";
        this.mTabTransY = context.getResources().getDimension(R.dimen.f12577u);
        this.mTabReselectTimeMap = new HashMap<>();
        this.mTabLastClickRefreshTimeMap = new HashMap<>();
        this.mTabRefreshTask = new TabRefreshTask(new WeakReference(this));
        bl g16 = bl.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, this, true)");
        this.mBinding = g16;
        n();
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.main.tab.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTabContainerView.k(view);
            }
        });
    }
}
