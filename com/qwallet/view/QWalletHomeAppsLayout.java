package com.qwallet.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.activity.QWalletServiceManagerActivity;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel;
import com.tencent.mobileqq.qwallet.home.grid.GridAppRvAdapter;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mobileqq.qwallet.utils.m;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0002STB1\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\u000b\u0012\b\b\u0002\u0010O\u001a\u00020\u000b\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0002J4\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J$\u0010\u001d\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0014J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0002H\u0014J\b\u0010$\u001a\u00020\u0002H\u0014R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00100R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR&\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060D0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010F\u00a8\u0006U"}, d2 = {"Lcom/qwallet/view/QWalletHomeAppsLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "Q0", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "financialApps", "lifeApps", "", "N0", "", "J0", "list", "G0", "noFinancial", "H0", "fullApps", "I0", "isVisible", "T0", "Lcom/qwallet/view/QWalletHomeAppsLayout$b;", "viewDataGroup", "apps", "rowSize", "maxLine", "R0", "showFinanceApps", "showLifeApps", "O0", "P0", "onFinishInflate", "Landroid/view/MotionEvent;", "event", NodeProps.ON_INTERCEPT_TOUCH_EVENT, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "d", "Lkotlin/Lazy;", "K0", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "financeTitle", "f", "Lcom/qwallet/view/QWalletHomeAppsLayout$b;", "financeGroup", tl.h.F, "lifeTitle", "i", "lifeGroup", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "financeAppGroup", BdhLogUtil.LogTag.Tag_Conn, "lifeAppGroup", "D", "Z", "twoLineTitleMode", "Landroid/view/View;", "E", "Landroid/view/View;", "addAppsLayout", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/Observer;", "gridAppsObserver", "G", "appSwitchObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "H", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class QWalletHomeAppsLayout extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppGroup lifeAppGroup;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean twoLineTitleMode;

    /* renamed from: E, reason: from kotlin metadata */
    private View addAppsLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Observer<Pair<QWalletHomePage$AppGroup, QWalletHomePage$AppGroup>> gridAppsObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> appSwitchObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView financeTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b financeGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView lifeTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b lifeGroup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppGroup financeAppGroup;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qwallet/view/QWalletHomeAppsLayout$b;", "", "Landroidx/viewpager2/widget/ViewPager2;", "a", "Landroidx/viewpager2/widget/ViewPager2;", "b", "()Landroidx/viewpager2/widget/ViewPager2;", "d", "(Landroidx/viewpager2/widget/ViewPager2;)V", "viewPager", "Lcom/google/android/material/tabs/TabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "()Lcom/google/android/material/tabs/TabLayout;", "c", "(Lcom/google/android/material/tabs/TabLayout;)V", "tabLayout", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewPager2 viewPager;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TabLayout tabLayout;

        @NotNull
        public final TabLayout a() {
            TabLayout tabLayout = this.tabLayout;
            if (tabLayout != null) {
                return tabLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            return null;
        }

        @NotNull
        public final ViewPager2 b() {
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                return viewPager2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            return null;
        }

        public final void c(@NotNull TabLayout tabLayout) {
            Intrinsics.checkNotNullParameter(tabLayout, "<set-?>");
            this.tabLayout = tabLayout;
        }

        public final void d(@NotNull ViewPager2 viewPager2) {
            Intrinsics.checkNotNullParameter(viewPager2, "<set-?>");
            this.viewPager = viewPager2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qwallet/view/QWalletHomeAppsLayout$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            QLog.d("QWalletHomeAppsLayout", 1, "financeViewPager onPageSelected: position " + position);
            b bVar = QWalletHomeAppsLayout.this.financeGroup;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("financeGroup");
                bVar = null;
            }
            RecyclerView.Adapter adapter = bVar.b().getAdapter();
            if (adapter instanceof com.tencent.mobileqq.qwallet.home.grid.b) {
                ((com.tencent.mobileqq.qwallet.home.grid.b) adapter).i0(position);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qwallet/view/QWalletHomeAppsLayout$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            QLog.d("QWalletHomeAppsLayout", 1, "lifeViewPager onPageSelected: position " + position);
            b bVar = QWalletHomeAppsLayout.this.lifeGroup;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifeGroup");
                bVar = null;
            }
            RecyclerView.Adapter adapter = bVar.b().getAdapter();
            if (adapter instanceof com.tencent.mobileqq.qwallet.home.grid.b) {
                ((com.tencent.mobileqq.qwallet.home.grid.b) adapter).i0(position);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(QWalletHomeAppsLayout this$0, Boolean changed) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(changed, "changed");
        if (changed.booleanValue()) {
            this$0.Q0();
        }
    }

    private final int G0(List<QWalletHomePage$AppInfo> list) {
        if (!ol2.a.c() || !(!list.isEmpty())) {
            return 1;
        }
        return list.size();
    }

    private final int H0(boolean noFinancial, List<QWalletHomePage$AppInfo> list) {
        if (ol2.a.c() && (!list.isEmpty())) {
            return list.size();
        }
        if (noFinancial) {
            return 3;
        }
        return 2;
    }

    private final List<QWalletHomePage$AppInfo> I0(List<QWalletHomePage$AppInfo> fullApps) {
        List<QWalletHomePage$AppInfo> emptyList;
        if (fullApps == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : fullApps) {
            String g16 = QWalletUtils.g(((QWalletHomePage$AppInfo) obj).f41686id.get());
            Intrinsics.checkNotNullExpressionValue(g16, "getSwitchAppKey(it.id.get())");
            if (com.tencent.mobileqq.qwallet.utils.g.c(g16, true)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int J0() {
        if (ol2.a.c()) {
            return 4;
        }
        return 5;
    }

    private final QWalletHomeViewModel K0() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(final QWalletHomeAppsLayout this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.financeAppGroup = ((QWalletHomePage$AppGroup) pair.getFirst()).get();
        this$0.lifeAppGroup = ((QWalletHomePage$AppGroup) pair.getSecond()).get();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qwallet.view.e
            @Override // java.lang.Runnable
            public final void run() {
                QWalletHomeAppsLayout.M0(QWalletHomeAppsLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QWalletHomeAppsLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean N0(List<QWalletHomePage$AppInfo> financialApps, List<QWalletHomePage$AppInfo> lifeApps) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        boolean z19;
        String str;
        int i16;
        boolean z26;
        boolean z27;
        String str2;
        if (!ol2.a.c()) {
            return false;
        }
        if (financialApps != null) {
            List<QWalletHomePage$AppInfo> list = financialApps;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    PBStringField pBStringField = ((QWalletHomePage$AppInfo) it.next()).name;
                    if (pBStringField != null && (str2 = pBStringField.get()) != null) {
                        i16 = str2.length();
                    } else {
                        i16 = 0;
                    }
                    if (i16 > 4) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (z26) {
                        z27 = true;
                        break;
                    }
                }
            }
            z27 = false;
            if (z27) {
                z16 = true;
                if (!z16) {
                    if (lifeApps != null) {
                        List<QWalletHomePage$AppInfo> list2 = lifeApps;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it5 = list2.iterator();
                            while (it5.hasNext()) {
                                PBStringField pBStringField2 = ((QWalletHomePage$AppInfo) it5.next()).name;
                                if (pBStringField2 != null && (str = pBStringField2.get()) != null) {
                                    i3 = str.length();
                                } else {
                                    i3 = 0;
                                }
                                if (i3 > 4) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    z19 = true;
                                    break;
                                }
                            }
                        }
                        z19 = false;
                        if (z19) {
                            z17 = true;
                            if (!z17) {
                                return false;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return true;
    }

    private final void O0(List<QWalletHomePage$AppInfo> showFinanceApps, List<QWalletHomePage$AppInfo> showLifeApps) {
        List<QWalletHomePage$AppInfo> list;
        List<QWalletHomePage$AppInfo> list2;
        Set set;
        Set subtract;
        String joinToString$default;
        boolean z16;
        List emptyList;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField2;
        ArrayList arrayList = new ArrayList();
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup = this.financeAppGroup;
        List<QWalletHomePage$AppInfo> list3 = null;
        if (qWalletHomePage$AppGroup != null && (pBRepeatMessageField2 = qWalletHomePage$AppGroup.apps) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "financeAppGroup?.apps?.get() ?: emptyList()");
        }
        arrayList.addAll(list);
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup2 = this.lifeAppGroup;
        if (qWalletHomePage$AppGroup2 != null && (pBRepeatMessageField = qWalletHomePage$AppGroup2.apps) != null) {
            list3 = pBRepeatMessageField.get();
        }
        if (list3 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            Intrinsics.checkNotNullExpressionValue(list3, "lifeAppGroup?.apps?.get() ?: emptyList()");
            list2 = list3;
        }
        arrayList.addAll(list2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(showFinanceApps);
        arrayList2.addAll(showLifeApps);
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        subtract = CollectionsKt___CollectionsKt.subtract(arrayList, set);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(subtract, ",", null, null, 0, null, new Function1<QWalletHomePage$AppInfo, CharSequence>() { // from class: com.qwallet.view.QWalletHomeAppsLayout$reportClosedApps$closedAppIdList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull QWalletHomePage$AppInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it.f41686id.get());
            }
        }, 30, null);
        if (joinToString$default.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            u.m("index.tuijian.close", joinToString$default, null, null, null, 0, 60, null);
        }
    }

    private final boolean P0() {
        return false;
    }

    private final void Q0() {
        List<QWalletHomePage$AppInfo> list;
        List<QWalletHomePage$AppInfo> list2;
        List<QWalletHomePage$AppInfo> list3;
        List<QWalletHomePage$AppInfo> list4;
        List<? extends List<QWalletHomePage$AppInfo>> chunked;
        List<? extends List<QWalletHomePage$AppInfo>> chunked2;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField2;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField3;
        PBRepeatMessageField<QWalletHomePage$AppInfo> pBRepeatMessageField4;
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup = this.financeAppGroup;
        View view = null;
        if (qWalletHomePage$AppGroup != null && (pBRepeatMessageField4 = qWalletHomePage$AppGroup.apps) != null) {
            list = pBRepeatMessageField4.get();
        } else {
            list = null;
        }
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup2 = this.lifeAppGroup;
        if (qWalletHomePage$AppGroup2 != null && (pBRepeatMessageField3 = qWalletHomePage$AppGroup2.apps) != null) {
            list2 = pBRepeatMessageField3.get();
        } else {
            list2 = null;
        }
        this.twoLineTitleMode = N0(list, list2);
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup3 = this.financeAppGroup;
        if (qWalletHomePage$AppGroup3 != null && (pBRepeatMessageField2 = qWalletHomePage$AppGroup3.apps) != null) {
            list3 = pBRepeatMessageField2.get();
        } else {
            list3 = null;
        }
        List<QWalletHomePage$AppInfo> I0 = I0(list3);
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup4 = this.lifeAppGroup;
        if (qWalletHomePage$AppGroup4 != null && (pBRepeatMessageField = qWalletHomePage$AppGroup4.apps) != null) {
            list4 = pBRepeatMessageField.get();
        } else {
            list4 = null;
        }
        List<QWalletHomePage$AppInfo> I02 = I0(list4);
        O0(I0, I02);
        int J0 = J0();
        float f16 = J0;
        int ceil = (int) Math.ceil(I0.size() / f16);
        chunked = CollectionsKt___CollectionsKt.chunked(I0, G0(I0) * J0);
        b bVar = this.financeGroup;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeGroup");
            bVar = null;
        }
        R0(bVar, chunked, ceil, G0(I0));
        int ceil2 = (int) Math.ceil(I02.size() / f16);
        int H0 = H0(chunked.isEmpty(), I02);
        chunked2 = CollectionsKt___CollectionsKt.chunked(I02, J0 * H0);
        boolean z16 = true;
        if (!(!chunked.isEmpty()) || !(!chunked2.isEmpty())) {
            z16 = false;
        }
        T0(z16);
        b bVar2 = this.lifeGroup;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeGroup");
            bVar2 = null;
        }
        R0(bVar2, chunked2, ceil2, H0);
        if (chunked.isEmpty() && chunked2.isEmpty()) {
            View view2 = this.addAppsLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            u.m("index.tuijian_add.show", null, null, null, "\u53bb\u6dfb\u52a0", 0, 46, null);
            return;
        }
        View view3 = this.addAppsLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void R0(b viewDataGroup, List<? extends List<QWalletHomePage$AppInfo>> apps, int rowSize, int maxLine) {
        int coerceAtMost;
        int i3 = 8;
        if (apps.isEmpty()) {
            viewDataGroup.b().setVisibility(8);
            viewDataGroup.a().setVisibility(8);
            return;
        }
        viewDataGroup.b().setVisibility(0);
        GridAppRvAdapter.Companion companion = GridAppRvAdapter.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int b16 = GridAppRvAdapter.Companion.b(companion, context, this.twoLineTitleMode, false, 4, null);
        ViewPager2 b17 = viewDataGroup.b();
        ViewGroup.LayoutParams layoutParams = viewDataGroup.b().getLayoutParams();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(rowSize, maxLine);
        layoutParams.height = coerceAtMost * b16;
        b17.setLayoutParams(layoutParams);
        ol2.b.f(viewDataGroup.b(), 0, false, 6, null);
        TabLayout a16 = viewDataGroup.a();
        if (rowSize > maxLine) {
            i3 = 0;
        }
        a16.setVisibility(i3);
        com.tencent.mobileqq.qwallet.home.grid.b bVar = new com.tencent.mobileqq.qwallet.home.grid.b(J0(), this.twoLineTitleMode);
        viewDataGroup.b().setAdapter(bVar);
        new com.google.android.material.tabs.d(viewDataGroup.a(), viewDataGroup.b(), new d.b() { // from class: com.qwallet.view.f
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i16) {
                QWalletHomeAppsLayout.S0(gVar, i16);
            }
        }).a();
        bVar.submitList(apps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(TabLayout.g gVar, int i3) {
        Intrinsics.checkNotNullParameter(gVar, "<anonymous parameter 0>");
    }

    private final void T0(boolean isVisible) {
        int i3;
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        TextView textView = this.financeTitle;
        String str2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeTitle");
            textView = null;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.financeTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeTitle");
            textView2 = null;
        }
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup = this.financeAppGroup;
        if (qWalletHomePage$AppGroup != null && (pBStringField2 = qWalletHomePage$AppGroup.title) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        textView2.setText(str);
        TextView textView3 = this.lifeTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeTitle");
            textView3 = null;
        }
        textView3.setVisibility(i3);
        TextView textView4 = this.lifeTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeTitle");
            textView4 = null;
        }
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup2 = this.lifeAppGroup;
        if (qWalletHomePage$AppGroup2 != null && (pBStringField = qWalletHomePage$AppGroup2.title) != null) {
            str2 = pBStringField.get();
        }
        textView4.setText(str2);
    }

    private final void initView() {
        View view;
        b bVar = new b();
        this.financeGroup = bVar;
        View findViewById = findViewById(R.id.v65);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.finance_viewPager)");
        bVar.d((ViewPager2) findViewById);
        b bVar2 = this.financeGroup;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeGroup");
            bVar2 = null;
        }
        bVar2.b().registerOnPageChangeCallback(new c());
        b bVar3 = this.financeGroup;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeGroup");
            bVar3 = null;
        }
        View findViewById2 = findViewById(R.id.f165209v63);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.finance_tab)");
        bVar3.c((TabLayout) findViewById2);
        View findViewById3 = findViewById(R.id.f165210v64);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.finance_title)");
        TextView textView = (TextView) findViewById3;
        this.financeTitle = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("financeTitle");
            textView = null;
        }
        ol2.b.f(textView, 15, false, 4, null);
        b bVar4 = new b();
        this.lifeGroup = bVar4;
        View findViewById4 = findViewById(R.id.f166045yi0);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.life_viewPager)");
        bVar4.d((ViewPager2) findViewById4);
        b bVar5 = this.lifeGroup;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeGroup");
            bVar5 = null;
        }
        bVar5.b().registerOnPageChangeCallback(new d());
        b bVar6 = this.lifeGroup;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeGroup");
            bVar6 = null;
        }
        View findViewById5 = findViewById(R.id.yhy);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.life_tab)");
        bVar6.c((TabLayout) findViewById5);
        View findViewById6 = findViewById(R.id.yhz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.life_title)");
        TextView textView2 = (TextView) findViewById6;
        this.lifeTitle = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeTitle");
            textView2 = null;
        }
        ol2.b.f(textView2, 15, false, 4, null);
        View findViewById7 = findViewById(R.id.scy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.add_apps_layout)");
        this.addAppsLayout = findViewById7;
        ol2.b.f((TextView) findViewById(R.id.scz), 0, false, 6, null);
        View view2 = this.addAppsLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            view2 = null;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.scx);
        m mVar = m.f279290a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setColorFilter(mVar.a(context, R.attr.akw));
        View view3 = this.addAppsLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addAppsLayout");
            view = null;
        } else {
            view = view3;
        }
        com.tencent.mobileqq.qwallet.k.d(view, 0L, new Function0<Unit>() { // from class: com.qwallet.view.QWalletHomeAppsLayout$initView$4
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
                com.tencent.mobileqq.base.c.f(QWalletHomeAppsLayout.this.getContext(), new Intent(), QWalletServiceManagerActivity.class, false, 8, null);
                u.m("index.tuijian_add.click", null, null, null, "\u53bb\u6dfb\u52a0", 0, 46, null);
            }
        }, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!P0()) {
            return;
        }
        K0().U1().observeForever(this.gridAppsObserver);
        HomeLegacyBizManager.f277929d.e().observeForever(this.appSwitchObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!P0()) {
            return;
        }
        K0().U1().removeObserver(this.gridAppsObserver);
        HomeLegacyBizManager.f277929d.e().removeObserver(this.appSwitchObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!P0()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        View.inflate(getContext(), R.layout.hij, this);
        initView();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(event);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QWalletHomeAppsLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QWalletHomeAppsLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.qwallet.view.QWalletHomeAppsLayout$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                return ((QWalletHomeFragment) FragmentManager.findFragment(QWalletHomeAppsLayout.this)).Oh();
            }
        });
        this.viewModel = lazy;
        this.gridAppsObserver = new Observer() { // from class: com.qwallet.view.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeAppsLayout.L0(QWalletHomeAppsLayout.this, (Pair) obj);
            }
        };
        this.appSwitchObserver = new Observer() { // from class: com.qwallet.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeAppsLayout.F0(QWalletHomeAppsLayout.this, (Boolean) obj);
            }
        };
    }
}
