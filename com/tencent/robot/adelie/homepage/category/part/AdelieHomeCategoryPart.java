package com.tencent.robot.adelie.homepage.category.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import com.tencent.robot.adelie.homepage.category.part.AdelieHomeCategoryPart;
import com.tencent.robot.adelie.homepage.category.part.tab.AdelieHomeCategoryTabBar;
import com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.robot.adelie.homepage.category.viewmodel.Category;
import com.tencent.robot.adelie.homepage.category.viewmodel.CategoryType;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideTabChangeStopAnimationEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ?2\u00020\u0001:\u0002@AB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00103\u001a\n .*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R!\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/c;", "category", "", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "K9", "M9", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "categories", "", "toggleTabBarVisibilityByCategorySize", "H9", "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/tencent/robot/adelie/homepage/category/part/tab/AdelieHomeCategoryTabBar;", "e", "Lcom/tencent/robot/adelie/homepage/category/part/tab/AdelieHomeCategoryTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "f", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", h.F, "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "Landroid/widget/RelativeLayout;", "i", "Landroid/widget/RelativeLayout;", "errorPage", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "J9", "()Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;", "viewModel", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "categoryLiveData", "Landroidx/lifecycle/Observer;", "D", "I9", "()Landroidx/lifecycle/Observer;", "categoryObserver", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "E", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCategoryPart extends Part {

    @NotNull
    private static final b E = new b(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LiveData<Category> categoryLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy categoryObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifeCycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieHomeCategoryTabBar tabBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScanningLightView loadingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout errorPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B%\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart$a$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "m0", "l0", "k0", "Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;", "viewModel", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotTabInfo;", "D", "Ljava/util/List;", "data", "", "E", "viewHolders", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/robot/adelie/homepage/category/viewmodel/AdelieHomeCategoryViewModel;Ljava/util/List;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.Adapter<C9752a> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final AdelieHomeCategoryViewModel viewModel;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final List<RobotTabInfo> data;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final List<C9752a> viewHolders;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LifecycleOwner lifeCycleOwner;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/adelie/homepage/category/part/b;", "E", "Lcom/tencent/robot/adelie/homepage/category/part/b;", "l", "()Lcom/tencent/robot/adelie/homepage/category/part/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/robot/adelie/homepage/category/part/b;)V", "page", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.adelie.homepage.category.part.AdelieHomeCategoryPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9752a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            @Nullable
            private com.tencent.robot.adelie.homepage.category.part.b page;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9752a(@NotNull View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Nullable
            /* renamed from: l, reason: from getter */
            public final com.tencent.robot.adelie.homepage.category.part.b getPage() {
                return this.page;
            }

            public final void m(@Nullable com.tencent.robot.adelie.homepage.category.part.b bVar) {
                this.page = bVar;
            }
        }

        public a(@NotNull LifecycleOwner lifeCycleOwner, @NotNull AdelieHomeCategoryViewModel viewModel, @NotNull List<RobotTabInfo> data) {
            Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            Intrinsics.checkNotNullParameter(data, "data");
            this.lifeCycleOwner = lifeCycleOwner;
            this.viewModel = viewModel;
            this.data = data;
            this.viewHolders = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull C9752a holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            com.tencent.robot.adelie.homepage.category.part.b page = holder.getPage();
            com.tencent.robot.adelie.homepage.category.part.b bVar = new com.tencent.robot.adelie.homepage.category.part.b(this.lifeCycleOwner, this.viewModel, this.data.get(position));
            if (page != null) {
                page.onPartDestroy(null);
            }
            bVar.onInitView(holder.itemView);
            bVar.onPartResume(null);
            holder.m(bVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public C9752a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167572ds4, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      \u2026  false\n                )");
            C9752a c9752a = new C9752a(inflate);
            synchronized (this.viewHolders) {
                this.viewHolders.add(c9752a);
            }
            return c9752a;
        }

        public final void k0() {
            Iterator<T> it = this.viewHolders.iterator();
            while (it.hasNext()) {
                com.tencent.robot.adelie.homepage.category.part.b page = ((C9752a) it.next()).getPage();
                if (page != null) {
                    page.onPartPause(null);
                }
            }
        }

        public final void l0() {
            Iterator<T> it = this.viewHolders.iterator();
            while (it.hasNext()) {
                com.tencent.robot.adelie.homepage.category.part.b page = ((C9752a) it.next()).getPage();
                if (page != null) {
                    page.onPartResume(null);
                }
            }
        }

        public final void m0(@Nullable Activity activity) {
            Iterator<T> it = this.viewHolders.iterator();
            while (it.hasNext()) {
                com.tencent.robot.adelie.homepage.category.part.b page = ((C9752a) it.next()).getPage();
                if (page != null) {
                    page.onPartDestroy(activity);
                }
            }
            this.viewHolders.clear();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f365974a;

        static {
            int[] iArr = new int[CategoryType.values().length];
            try {
                iArr[CategoryType.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CategoryType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CategoryType.BACKEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f365974a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/adelie/homepage/category/part/AdelieHomeCategoryPart$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdelieRobotGuideTabChangeStopAnimationEvent f365975b;

        d(AdelieRobotGuideTabChangeStopAnimationEvent adelieRobotGuideTabChangeStopAnimationEvent) {
            this.f365975b = adelieRobotGuideTabChangeStopAnimationEvent;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffset > 0.0f) {
                SimpleEventBus.getInstance().dispatchEvent(this.f365975b, false);
                QLog.i("AdelieHomeCategoryPart", 1, "AdelieHomeCategoryPart initTabsChangeStopGuideAnimation onPageScrolled");
            }
        }
    }

    public AdelieHomeCategoryPart(@NotNull LifecycleOwner lifeCycleOwner) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        this.lifeCycleOwner = lifeCycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieHomeCategoryViewModel>() { // from class: com.tencent.robot.adelie.homepage.category.part.AdelieHomeCategoryPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AdelieHomeCategoryViewModel invoke() {
                return (AdelieHomeCategoryViewModel) AdelieHomeCategoryPart.this.getViewModel(AdelieHomeCategoryViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new AdelieHomeCategoryPart$categoryObserver$2(this));
        this.categoryObserver = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(final List<RobotTabInfo> categories, final boolean toggleTabBarVisibilityByCategorySize) {
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.category.part.AdelieHomeCategoryPart$bindCategoryInfo$1
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
                ViewPager2 viewPager2;
                ViewPager2 viewPager22;
                AdelieHomeCategoryTabBar adelieHomeCategoryTabBar;
                ViewPager2 viewPager23;
                AdelieHomeCategoryTabBar adelieHomeCategoryTabBar2;
                AdelieHomeCategoryTabBar adelieHomeCategoryTabBar3;
                AdelieHomeCategoryTabBar adelieHomeCategoryTabBar4;
                ViewPager2 viewPager24;
                LifecycleOwner lifecycleOwner;
                AdelieHomeCategoryViewModel viewModel;
                viewPager2 = AdelieHomeCategoryPart.this.viewPager;
                RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
                AdelieHomeCategoryPart.a aVar = adapter instanceof AdelieHomeCategoryPart.a ? (AdelieHomeCategoryPart.a) adapter : null;
                if (aVar != null) {
                    aVar.m0(AdelieHomeCategoryPart.this.getActivity());
                }
                viewPager22 = AdelieHomeCategoryPart.this.viewPager;
                if (viewPager22 != null) {
                    lifecycleOwner = AdelieHomeCategoryPart.this.lifeCycleOwner;
                    viewModel = AdelieHomeCategoryPart.this.J9();
                    Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
                    viewPager22.setAdapter(new AdelieHomeCategoryPart.a(lifecycleOwner, viewModel, categories));
                }
                if (categories.size() > 1) {
                    adelieHomeCategoryTabBar2 = AdelieHomeCategoryPart.this.tabBar;
                    if (adelieHomeCategoryTabBar2 != null) {
                        adelieHomeCategoryTabBar2.setVisibility(0);
                    }
                    adelieHomeCategoryTabBar3 = AdelieHomeCategoryPart.this.tabBar;
                    if (adelieHomeCategoryTabBar3 != null) {
                        adelieHomeCategoryTabBar3.setData(categories);
                    }
                    adelieHomeCategoryTabBar4 = AdelieHomeCategoryPart.this.tabBar;
                    if (adelieHomeCategoryTabBar4 != null) {
                        viewPager24 = AdelieHomeCategoryPart.this.viewPager;
                        adelieHomeCategoryTabBar4.bindViewPager2(viewPager24);
                        return;
                    }
                    return;
                }
                if (toggleTabBarVisibilityByCategorySize) {
                    adelieHomeCategoryTabBar = AdelieHomeCategoryPart.this.tabBar;
                    if (adelieHomeCategoryTabBar != null) {
                        adelieHomeCategoryTabBar.setVisibility(8);
                    }
                    viewPager23 = AdelieHomeCategoryPart.this.viewPager;
                    Object layoutParams = viewPager23 != null ? viewPager23.getLayoutParams() : null;
                    LinearLayoutCompat.LayoutParams layoutParams2 = layoutParams instanceof LinearLayoutCompat.LayoutParams ? (LinearLayoutCompat.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = b.M;
                    }
                }
            }
        });
    }

    private final Observer<Category> I9() {
        return (Observer) this.categoryObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdelieHomeCategoryViewModel J9() {
        return (AdelieHomeCategoryViewModel) this.viewModel.getValue();
    }

    private final void K9(View rootView) {
        RelativeLayout relativeLayout;
        int i3;
        Button button;
        ImageView imageView;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.uwt);
        } else {
            relativeLayout = null;
        }
        this.errorPage = relativeLayout;
        if (je0.a.a(BaseApplication.getContext())) {
            i3 = R.drawable.mi5;
        } else {
            i3 = R.drawable.f160066mi4;
        }
        if (rootView != null && (imageView = (ImageView) rootView.findViewById(R.id.byb)) != null) {
            imageView.setImageResource(i3);
        }
        if (rootView != null && (button = (Button) rootView.findViewById(R.id.by7)) != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.category.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieHomeCategoryPart.L9(AdelieHomeCategoryPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(AdelieHomeCategoryPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdelieHomeCategoryViewModel J9 = this$0.J9();
        if (J9 != null) {
            J9.T1(this$0.J9().getFirstPageCategoryInfo());
        }
        ScanningLightView scanningLightView = this$0.loadingView;
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
        RelativeLayout relativeLayout = this$0.errorPage;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M9() {
        final AdelieRobotGuideTabChangeStopAnimationEvent adelieRobotGuideTabChangeStopAnimationEvent = new AdelieRobotGuideTabChangeStopAnimationEvent();
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new d(adelieRobotGuideTabChangeStopAnimationEvent));
        }
        AdelieHomeCategoryTabBar adelieHomeCategoryTabBar = this.tabBar;
        if (adelieHomeCategoryTabBar != null) {
            adelieHomeCategoryTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.robot.adelie.homepage.category.part.e
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    AdelieHomeCategoryPart.N9(AdelieRobotGuideTabChangeStopAnimationEvent.this, i3, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(AdelieRobotGuideTabChangeStopAnimationEvent event, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(event, "$event");
        if (i3 != 0) {
            SimpleEventBus.getInstance().dispatchEvent(event, false);
            QLog.i("AdelieHomeCategoryPart", 1, "AdelieHomeCategoryPart initTabsChangeStopGuideAnimation tabChange:");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(AdelieHomeCategoryPart this$0) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScanningLightView scanningLightView = this$0.loadingView;
        if (scanningLightView != null) {
            drawable = scanningLightView.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        ScanningLightView scanningLightView2 = this$0.loadingView;
        if (scanningLightView2 != null) {
            int width = scanningLightView2.getWidth();
            if (intrinsicWidth != 0 && width != 0) {
                float f16 = width / intrinsicWidth;
                Matrix matrix = new Matrix();
                matrix.setScale(f16, f16);
                ScanningLightView scanningLightView3 = this$0.loadingView;
                if (scanningLightView3 != null) {
                    scanningLightView3.setImageMatrix(matrix);
                }
                ScanningLightView scanningLightView4 = this$0.loadingView;
                if (scanningLightView4 != null) {
                    scanningLightView4.setVisibility(0);
                }
                QLog.e("AdelieHomeCategoryPart", 1, "showLoading at:" + System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(Category category) {
        int i3 = c.f365974a[category.getType().ordinal()];
        if (i3 != 2) {
            if (i3 != 3 || category.a().isEmpty()) {
                return;
            }
            RelativeLayout relativeLayout = this.errorPage;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            ScanningLightView scanningLightView = this.loadingView;
            if (scanningLightView != null) {
                scanningLightView.setVisibility(8);
            }
            AdelieHomeCategoryTabBar adelieHomeCategoryTabBar = this.tabBar;
            if (adelieHomeCategoryTabBar != null) {
                adelieHomeCategoryTabBar.setVisibility(0);
            }
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setVisibility(0);
            }
            QLog.e("AdelieHomeCategoryPart", 1, "hideLoading at:" + System.currentTimeMillis());
            return;
        }
        RelativeLayout relativeLayout2 = this.errorPage;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        ScanningLightView scanningLightView2 = this.loadingView;
        if (scanningLightView2 != null) {
            scanningLightView2.setVisibility(8);
        }
        AdelieHomeCategoryTabBar adelieHomeCategoryTabBar2 = this.tabBar;
        if (adelieHomeCategoryTabBar2 != null) {
            adelieHomeCategoryTabBar2.setVisibility(8);
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        RecyclerView.Adapter adapter;
        super.onConfigurationChanged(configuration);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            int currentItem = viewPager2.getCurrentItem();
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 != null) {
                viewPager22.setCurrentItem(0, false);
            }
            ViewPager2 viewPager23 = this.viewPager;
            if (viewPager23 != null) {
                viewPager23.setCurrentItem(currentItem, true);
            }
            ViewPager2 viewPager24 = this.viewPager;
            if (viewPager24 != null) {
                viewPager24.requestLayout();
            }
            ViewPager2 viewPager25 = this.viewPager;
            if (viewPager25 != null && (adapter = viewPager25.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ScanningLightView scanningLightView;
        AdelieHomeCategoryTabBar adelieHomeCategoryTabBar;
        super.onInitView(rootView);
        ViewPager2 viewPager2 = null;
        if (rootView != null) {
            scanningLightView = (ScanningLightView) rootView.findViewById(R.id.efs);
        } else {
            scanningLightView = null;
        }
        this.loadingView = scanningLightView;
        if (scanningLightView != null) {
            scanningLightView.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.category.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieHomeCategoryPart.O9(AdelieHomeCategoryPart.this);
                }
            });
        }
        if (rootView != null) {
            adelieHomeCategoryTabBar = (AdelieHomeCategoryTabBar) rootView.findViewById(R.id.f164750tp4);
        } else {
            adelieHomeCategoryTabBar = null;
        }
        this.tabBar = adelieHomeCategoryTabBar;
        if (adelieHomeCategoryTabBar != null) {
            adelieHomeCategoryTabBar.setVisibility(8);
        }
        if (rootView != null) {
            viewPager2 = (ViewPager2) rootView.findViewById(R.id.tp8);
        }
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.setVisibility(8);
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(1);
        }
        M9();
        K9(rootView);
        LiveData<Category> O1 = J9().O1();
        this.categoryLiveData = O1;
        if (O1 != null) {
            O1.observe(this.lifeCycleOwner, I9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        RecyclerView.Adapter adapter;
        a aVar;
        ViewParent viewParent;
        ViewGroup viewGroup;
        super.onPartDestroy(activity);
        QLog.i("AdelieHomeCategoryPart", 1, "onPartDestroy, activity:" + activity);
        J9().M1(this.lifeCycleOwner);
        LiveData<Category> liveData = this.categoryLiveData;
        if (liveData != null) {
            liveData.removeObserver(I9());
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            adapter = viewPager2.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof a) {
            aVar = (a) adapter;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.m0(activity);
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setAdapter(null);
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 != null) {
            viewParent = viewPager23.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        } else {
            viewGroup = null;
        }
        AdelieHomeCategoryTabBar adelieHomeCategoryTabBar = this.tabBar;
        if (adelieHomeCategoryTabBar != null && viewGroup != null) {
            viewGroup.removeView(adelieHomeCategoryTabBar);
        }
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 != null && viewGroup != null) {
            viewGroup.removeView(viewPager24);
        }
        this.tabBar = null;
        this.viewPager = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        RecyclerView.Adapter adapter;
        super.onPartPause(activity);
        QLog.i("AdelieHomeCategoryPart", 1, "onPartPause:" + this);
        ViewPager2 viewPager2 = this.viewPager;
        a aVar = null;
        if (viewPager2 != null) {
            adapter = viewPager2.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof a) {
            aVar = (a) adapter;
        }
        if (aVar != null) {
            aVar.k0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        RecyclerView.Adapter adapter;
        super.onPartResume(activity);
        QLog.i("AdelieHomeCategoryPart", 1, "onPartResume:" + this);
        ViewPager2 viewPager2 = this.viewPager;
        a aVar = null;
        if (viewPager2 != null) {
            adapter = viewPager2.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof a) {
            aVar = (a) adapter;
        }
        if (aVar != null) {
            aVar.l0();
        }
    }
}
