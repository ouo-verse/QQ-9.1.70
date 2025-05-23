package com.tencent.robot.profile.parts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.parts.RobotProfileTitlePart;
import com.tencent.robot.profile.setting.RobotMainSettingFragment;
import com.tencent.robot.share.RobotQRCodePosterShareActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0018\u001c\u0018\u0000 J2\u00020\u0001:\u0001KB\u001f\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00102\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u001aR\u001b\u00105\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u0010\u001eR\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "R9", "S9", "", "state", "ba", "Q9", "T9", "", "isOffline", IProfileProtocolConst.PARAM_IS_FRIEND, "isInTroop", "aa", "showSettingBtn", "settingView", "W9", "showShareBtn", "shareView", "X9", "com/tencent/robot/profile/parts/RobotProfileTitlePart$c", "N9", "()Lcom/tencent/robot/profile/parts/RobotProfileTitlePart$c;", "Y9", "com/tencent/robot/profile/parts/RobotProfileTitlePart$b", "M9", "()Lcom/tencent/robot/profile/parts/RobotProfileTitlePart$b;", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "d", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "f", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "titleRoot", "i", "Lkotlin/Lazy;", "P9", "shareActionBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O9", "settingActionBtn", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "primaryMask", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "D", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mScrollListener", "E", "I", "mTitleState", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet;", "shareActionSheet", "Ljava/lang/Runnable;", "G", "Ljava/lang/Runnable;", "shareActionSheetRunnable", "<init>", "(Lcom/tencent/robot/profile/RobotProfileViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;)V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileTitlePart extends Part {
    private static final int I = ViewUtils.dip2px(214.0f);
    private static final int J = ViewUtils.dip2px(230.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private View primaryMask;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RecyclerView.OnScrollListener mScrollListener;

    /* renamed from: E, reason: from kotlin metadata */
    private int mTitleState;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RobotQRCodePosterShareActionSheet shareActionSheet;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Runnable shareActionSheetRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISecNavBar quiSecNavBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup titleRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareActionBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy settingActionBtn;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/profile/parts/RobotProfileTitlePart$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable = R.drawable.qui_setting_icon_allwhite_primary;

        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            u64.g gVar = u64.g.f438512a;
            RobotProfileTitlePart robotProfileTitlePart = RobotProfileTitlePart.this;
            if (!gVar.g()) {
                com.tencent.robot.profile.setting.b.f368096a.f(robotProfileTitlePart.viewModel.getRobotProfileRaw());
                RobotMainSettingFragment.Companion companion = RobotMainSettingFragment.INSTANCE;
                Context context = robotProfileTitlePart.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.a(context, robotProfileTitlePart.viewModel.getRobotUin(), robotProfileTitlePart.viewModel.getTroopUin());
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public String b() {
            return HardCodeUtil.qqStr(R.string.f223296fu);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return true;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return this.drawable;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/profile/parts/RobotProfileTitlePart$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "", "kotlin.jvm.PlatformType", "b", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends com.tencent.biz.qui.quisecnavbar.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable = R.drawable.qui_share_icon_allwhite_primary;

        c() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            u64.g gVar = u64.g.f438512a;
            RobotProfileTitlePart robotProfileTitlePart = RobotProfileTitlePart.this;
            if (!gVar.g()) {
                robotProfileTitlePart.Y9();
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public String b() {
            return HardCodeUtil.qqStr(R.string.bbp);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return true;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return this.drawable;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/profile/parts/RobotProfileTitlePart$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f368040d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f368041e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RobotProfileTitlePart f368042f;

        d(LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, RobotProfileTitlePart robotProfileTitlePart) {
            this.f368040d = linearLayoutManager;
            this.f368041e = recyclerView;
            this.f368042f = robotProfileTitlePart;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int findFirstVisibleItemPosition = this.f368040d.findFirstVisibleItemPosition();
            int computeVerticalScrollOffset = this.f368041e.computeVerticalScrollOffset();
            if (findFirstVisibleItemPosition < 0 || (findFirstVisibleItemPosition == 0 && computeVerticalScrollOffset <= RobotProfileTitlePart.I)) {
                this.f368042f.ba(0);
                return;
            }
            if (findFirstVisibleItemPosition > 0 || (findFirstVisibleItemPosition == 0 && computeVerticalScrollOffset >= RobotProfileTitlePart.J)) {
                this.f368042f.ba(2);
                return;
            }
            if (!recyclerView.canScrollVertically(1)) {
                this.f368042f.ba(2);
                return;
            }
            float f16 = (computeVerticalScrollOffset - RobotProfileTitlePart.I) / (RobotProfileTitlePart.J - RobotProfileTitlePart.I);
            View view = this.f368042f.primaryMask;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryMask");
                view = null;
            }
            view.setAlpha(f16);
            this.f368042f.ba(1);
        }
    }

    public RobotProfileTitlePart(@NotNull RobotProfileViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner, @NotNull QUISecNavBar quiSecNavBar) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(quiSecNavBar, "quiSecNavBar");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.quiSecNavBar = quiSecNavBar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.robot.profile.parts.RobotProfileTitlePart$shareActionBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotProfileTitlePart.c invoke() {
                RobotProfileTitlePart.c N9;
                N9 = RobotProfileTitlePart.this.N9();
                return N9;
            }
        });
        this.shareActionBtn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.robot.profile.parts.RobotProfileTitlePart$settingActionBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotProfileTitlePart.b invoke() {
                RobotProfileTitlePart.b M9;
                M9 = RobotProfileTitlePart.this.M9();
                return M9;
            }
        });
        this.settingActionBtn = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b M9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c N9() {
        return new c();
    }

    private final b O9() {
        return (b) this.settingActionBtn.getValue();
    }

    private final c P9() {
        return (c) this.shareActionBtn.getValue();
    }

    private final void Q9() {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext()) + com.tencent.biz.qui.quisecnavbar.f.g();
        View view = new View(getContext());
        view.setAlpha(0.0f);
        view.setBackgroundColor(view.getContext().getColor(R.color.qui_common_bg_nav_secondary));
        this.primaryMask = view;
        ViewGroup viewGroup = this.titleRoot;
        View view2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRoot");
            viewGroup = null;
        }
        View view3 = this.primaryMask;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryMask");
        } else {
            view2 = view3;
        }
        viewGroup.addView(view2, -1, statusBarHeight);
    }

    private final void R9() {
        if (this.mScrollListener != null) {
            return;
        }
        ViewGroup viewGroup = this.titleRoot;
        LinearLayoutManager linearLayoutManager = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleRoot");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.f772743x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "titleRoot.findViewById(R.id.robot_profile_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager == null) {
            return;
        }
        d dVar = new d(linearLayoutManager, recyclerView, this);
        recyclerView.addOnScrollListener(dVar);
        this.mScrollListener = dVar;
    }

    private final void S9() {
        this.quiSecNavBar.setTitleAlpha(0.0f);
        this.quiSecNavBar.d(P9());
        this.quiSecNavBar.d(O9());
        this.quiSecNavBar.setRightIconVisible(P9(), false);
        this.quiSecNavBar.setRightIconVisible(O9(), false);
        this.quiSecNavBar.setLeftIconWithCircle(true);
        this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
        this.quiSecNavBar.setElevation(1.0f);
    }

    private final void T9() {
        LiveData<Boolean> v26 = this.viewModel.v2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileTitlePart$observeSquare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean booleanValue = it.booleanValue();
                RobotProfileTitlePart robotProfileTitlePart = RobotProfileTitlePart.this;
                if (booleanValue) {
                    robotProfileTitlePart.viewModel.x2();
                    new com.tencent.videocut.utils.dsl.b();
                } else {
                    new com.tencent.videocut.utils.dsl.a(booleanValue);
                }
            }
        };
        v26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileTitlePart.U9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W9(boolean showSettingBtn, View settingView) {
        boolean z16 = false;
        if (settingView != null && settingView.getVisibility() == 8) {
            z16 = true;
        }
        if (z16 && showSettingBtn) {
            VideoReport.setElementId(settingView, "em_bas_settings");
            VideoReport.setElementClickPolicy(settingView, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(settingView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(settingView, EndExposurePolicy.REPORT_NONE);
        }
    }

    private final void X9(boolean showShareBtn, View shareView) {
        boolean z16 = false;
        if (shareView != null && shareView.getVisibility() == 8) {
            z16 = true;
        }
        if (z16 && showShareBtn) {
            VideoReport.setElementId(shareView, "em_bas_share_btn");
            VideoReport.setElementClickPolicy(shareView, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(shareView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(shareView, EndExposurePolicy.REPORT_NONE);
            VideoReport.reportEvent("imp", shareView, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        ViewGroup viewGroup;
        RobotInfo value = this.viewModel.q2().getValue();
        if (value != null && getActivity() != null) {
            Object broadcastGetMessage = broadcastGetMessage("action_get_qr_code_poster_bitmap", null);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            ViewGroup viewGroup2 = this.titleRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleRoot");
                viewGroup = null;
            } else {
                viewGroup = viewGroup2;
            }
            RobotQRCodePosterShareActionSheet robotQRCodePosterShareActionSheet = new RobotQRCodePosterShareActionSheet(activity, viewGroup, value, "bot_profile", new e());
            this.shareActionSheet = robotQRCodePosterShareActionSheet;
            if (broadcastGetMessage instanceof Bitmap) {
                robotQRCodePosterShareActionSheet.u((Bitmap) broadcastGetMessage);
                return;
            }
            robotQRCodePosterShareActionSheet.u(null);
            Runnable runnable = new Runnable() { // from class: com.tencent.robot.profile.parts.s
                @Override // java.lang.Runnable
                public final void run() {
                    RobotProfileTitlePart.Z9(RobotProfileTitlePart.this);
                }
            };
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 10000L);
            this.shareActionSheetRunnable = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(RobotProfileTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object broadcastGetMessage = this$0.broadcastGetMessage("action_get_qr_code_poster_bitmap", null);
        if (broadcastGetMessage instanceof Bitmap) {
            RobotQRCodePosterShareActionSheet robotQRCodePosterShareActionSheet = this$0.shareActionSheet;
            if (robotQRCodePosterShareActionSheet != null) {
                robotQRCodePosterShareActionSheet.t((Bitmap) broadcastGetMessage);
            }
        } else {
            v44.c.f440966a.g(1, R.string.f222246d0);
        }
        RobotQRCodePosterShareActionSheet robotQRCodePosterShareActionSheet2 = this$0.shareActionSheet;
        if (robotQRCodePosterShareActionSheet2 != null) {
            robotQRCodePosterShareActionSheet2.i();
        }
        this$0.shareActionSheetRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(boolean isOffline, boolean isFriend, boolean isInTroop) {
        TextView textView;
        boolean z16;
        View g16 = this.quiSecNavBar.g(BaseAction.ACTION_CENTER_TEXT);
        View view = null;
        if (g16 instanceof TextView) {
            textView = (TextView) g16;
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setTextColor(getContext().getColorStateList(R.color.qui_common_text_nav_secondary));
        }
        View view2 = this.primaryMask;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryMask");
        } else {
            view = view2;
        }
        view.setBackgroundColor(getContext().getColor(R.color.qui_common_bg_nav_secondary));
        boolean z17 = !isOffline;
        if (isOffline && !isFriend && !isInTroop) {
            z16 = false;
        } else {
            z16 = true;
        }
        View h16 = this.quiSecNavBar.h(P9());
        View h17 = this.quiSecNavBar.h(O9());
        X9(z17, h16);
        W9(z16, h17);
        this.quiSecNavBar.setRightIconVisible(P9(), z17);
        this.quiSecNavBar.setRightIconVisible(O9(), z16);
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(int state) {
        if (this.mTitleState == state) {
            return;
        }
        this.mTitleState = state;
        View view = null;
        if (state == 0) {
            View view2 = this.primaryMask;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryMask");
                view2 = null;
            }
            view2.setAlpha(0.0f);
        }
        if (state != 0 && state != 1) {
            if (state == 2) {
                View view3 = this.primaryMask;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("primaryMask");
                } else {
                    view = view3;
                }
                view.setAlpha(1.0f);
                this.quiSecNavBar.setLeftIconWithCircle(false);
                this.quiSecNavBar.setRightIconWithCircle(false);
                this.quiSecNavBar.setCenterText(getContext().getString(R.string.f222816ej));
                this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_navigation_02_selector);
                this.quiSecNavBar.setRightIconRes(P9(), R.drawable.qui_share_for_navigation);
                this.quiSecNavBar.setRightIconRes(O9(), R.drawable.qui_setting_icon_navigation_01);
            }
        } else {
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setRightIconWithCircle(true);
            this.quiSecNavBar.setCenterText("");
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
            this.quiSecNavBar.setRightIconRes(P9(), R.drawable.qui_share_icon_allwhite_primary);
            this.quiSecNavBar.setRightIconRes(O9(), R.drawable.qui_setting_icon_allwhite_primary);
        }
        Activity activity = getActivity();
        if (activity != null) {
            QUIImmersiveHelper.u(activity.getWindow(), true, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.titleRoot = (ViewGroup) rootView;
        S9();
        Q9();
        LiveData<Boolean> k26 = this.viewModel.k2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileTitlePart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isOffline) {
                GroupRobotProfile robotProfileRaw = RobotProfileTitlePart.this.viewModel.getRobotProfileRaw();
                boolean z16 = robotProfileRaw != null ? robotProfileRaw.isFriend : false;
                GroupRobotProfile robotProfileRaw2 = RobotProfileTitlePart.this.viewModel.getRobotProfileRaw();
                boolean z17 = (robotProfileRaw2 != null ? robotProfileRaw2.robotMembership : -1) != -1;
                RobotProfileTitlePart robotProfileTitlePart = RobotProfileTitlePart.this;
                Intrinsics.checkNotNullExpressionValue(isOffline, "isOffline");
                robotProfileTitlePart.aa(isOffline.booleanValue(), z16, z17);
            }
        };
        k26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileTitlePart.V9(Function1.this, obj);
            }
        });
        T9();
        this.viewModel.c2();
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/robot/profile/parts/RobotProfileTitlePart$e", "Lcom/tencent/robot/share/RobotQRCodePosterShareActionSheet$a;", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements RobotQRCodePosterShareActionSheet.a {
        e() {
        }

        @Override // com.tencent.robot.share.RobotQRCodePosterShareActionSheet.a
        public void b() {
            RobotProfileTitlePart.this.shareActionSheet = null;
            Runnable runnable = RobotProfileTitlePart.this.shareActionSheetRunnable;
            if (runnable != null) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
            }
        }

        @Override // com.tencent.robot.share.RobotQRCodePosterShareActionSheet.a
        public void a() {
        }
    }
}
