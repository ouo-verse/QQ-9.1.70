package com.tencent.robot.aio.panel.menu;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.panel.menu.RobotMenuUIState;
import com.tencent.robot.aio.panel.menu.d;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\n*\u00015\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002<=B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00110\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R#\u00100\u001a\n +*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/RobotMenuPanelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/panel/menu/d;", "Lcom/tencent/robot/aio/panel/menu/RobotMenuUIState;", "Lcom/tencent/robot/aio/panel/menu/RobotMenuUIState$UpdateMenu;", "state", "", "e1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "d1", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mRobotAvatar", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "f", "Landroid/view/View;", "mTipsContainer", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "mMenuEmptyLayout", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "i", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "mEmptyState", "Lcom/tencent/robot/aio/panel/menu/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/panel/menu/c;", "mAdapter", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "c1", "()Landroid/view/View;", "mLoadingView", "", "D", "Z", "mHasCreatedLoadingView", "com/tencent/robot/aio/panel/menu/RobotMenuPanelVB$c", "E", "Lcom/tencent/robot/aio/panel/menu/RobotMenuPanelVB$c;", "mSpanSizeLookup", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMenuPanelVB extends com.tencent.aio.base.mvvm.a<d, RobotMenuUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLoadingView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasCreatedLoadingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c mSpanSizeLookup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mRobotAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mTipsContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mMenuEmptyLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUIEmptyState mEmptyState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.aio.panel.menu.c mAdapter;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/RobotMenuPanelVB$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "vertical", "e", "horizontal", "<init>", "(II)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int vertical;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int horizontal;

        public b(int i3, int i16) {
            this.vertical = i3;
            this.horizontal = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.vertical;
            outRect.top = i3;
            outRect.bottom = i3;
            int i16 = this.horizontal;
            outRect.left = i16;
            outRect.right = i16;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/robot/aio/panel/menu/RobotMenuPanelVB$c", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {
        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (position == 0) {
                RecyclerView recyclerView = RobotMenuPanelVB.this.mRecyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    recyclerView = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                boolean z16 = false;
                if (layoutManager != null && layoutManager.getItemCount() == 1) {
                    z16 = true;
                }
                if (z16) {
                    return 2;
                }
            }
            return 1;
        }
    }

    public RobotMenuPanelVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<View>() { // from class: com.tencent.robot.aio.panel.menu.RobotMenuPanelVB$mLoadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return LoadingUtil.getLoadingDialogTipsRight(RobotMenuPanelVB.this.getMContext(), false);
            }
        });
        this.mLoadingView = lazy;
        this.mSpanSizeLookup = new c();
    }

    private final View c1() {
        return (View) this.mLoadingView.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.view.View] */
    private final void e1(RobotMenuUIState.UpdateMenu state) {
        int i3;
        int i16 = 8;
        QUIEmptyState qUIEmptyState = null;
        if (state.getIsLoading()) {
            this.mHasCreatedLoadingView = true;
            View hostView = getHostView();
            Intrinsics.checkNotNull(hostView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) hostView;
            if (c1().getParent() == null) {
                View c16 = c1();
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.leftToLeft = 0;
                layoutParams.rightToRight = 0;
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                Unit unit = Unit.INSTANCE;
                viewGroup.addView(c16, layoutParams);
            }
            c1().setVisibility(0);
            View view = this.mTipsContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsContainer");
                view = null;
            }
            view.setVisibility(8);
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            View view2 = this.mTipsContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsContainer");
                view2 = null;
            }
            recyclerView.setVisibility(view2.getVisibility());
            ViewGroup viewGroup2 = this.mMenuEmptyLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMenuEmptyLayout");
                viewGroup2 = null;
            }
            ?? r06 = this.mTipsContainer;
            if (r06 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsContainer");
            } else {
                qUIEmptyState = r06;
            }
            viewGroup2.setVisibility(qUIEmptyState.getVisibility());
            return;
        }
        if (this.mHasCreatedLoadingView) {
            c1().setVisibility(8);
        }
        View view3 = this.mTipsContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipsContainer");
            view3 = null;
        }
        if (state.getHasMenu()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view3.setVisibility(i3);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        View view4 = this.mTipsContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipsContainer");
            view4 = null;
        }
        recyclerView2.setVisibility(view4.getVisibility());
        ViewGroup viewGroup3 = this.mMenuEmptyLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuEmptyLayout");
            viewGroup3 = null;
        }
        if (!state.getHasMenu()) {
            i16 = 0;
        }
        viewGroup3.setVisibility(i16);
        if (!state.getHasMenu()) {
            QUIEmptyState qUIEmptyState2 = this.mEmptyState;
            if (qUIEmptyState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
            } else {
                qUIEmptyState = qUIEmptyState2;
            }
            qUIEmptyState.setImageView(0, 14, true);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        this.mAdapter = new com.tencent.robot.aio.panel.menu.c();
        RecyclerView recyclerView = this.mRecyclerView;
        com.tencent.robot.aio.panel.menu.c cVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        com.tencent.robot.aio.panel.menu.c cVar2 = this.mAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar2 = null;
        }
        recyclerView.setAdapter(cVar2);
        ImageView imageView = this.mRobotAvatar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAvatar");
            imageView = null;
        }
        com.tencent.robot.aio.panel.menu.c cVar3 = this.mAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            cVar = cVar3;
        }
        sendIntent(new d.a(imageView, cVar));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<d, RobotMenuUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new RobotMenuPanelVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotMenuUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotMenuUIState.UpdateMenu) {
            e1((RobotMenuUIState.UpdateMenu) state);
        } else {
            QLog.w("RobotMenuPanelVB", 1, "handleUIState");
        }
        super.handleUIState(state);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends RobotMenuUIState>> getObserverStates() {
        List<Class<? extends RobotMenuUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(RobotMenuUIState.UpdateMenu.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View root = LayoutInflater.from(createViewParams.a()).inflate(R.layout.ho8, createViewParams.b(), false);
        View findViewById = root.findViewById(R.id.z47);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(createViewParams.a(), 2);
        gridLayoutManager.setSpanSizeLookup(this.mSpanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setOverScrollMode(2);
        recyclerView.addItemDecoration(new b(ViewUtils.dip2px(5.0f), ViewUtils.dip2px(5.0f)));
        recyclerView.setPadding(ViewUtils.dip2px(11.0f), ViewUtils.dip2px(5.7f), ViewUtils.dip2px(11.0f), ViewUtils.dip2px(11.0f));
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<Recycl\u2026)\n            )\n        }");
        this.mRecyclerView = recyclerView;
        View findViewById2 = root.findViewById(R.id.f7627418);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.robot_avatar)");
        this.mRobotAvatar = (ImageView) findViewById2;
        View findViewById3 = root.findViewById(R.id.f97855li);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.tips_container)");
        this.mTipsContainer = findViewById3;
        View findViewById4 = root.findViewById(R.id.z3s);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.menu_empty_layout)");
        this.mMenuEmptyLayout = (ViewGroup) findViewById4;
        this.mEmptyState = new QUIEmptyState.Builder(createViewParams.a()).setBackgroundColorType(0).setHalfScreenState(true).build();
        ViewGroup viewGroup = this.mMenuEmptyLayout;
        QUIEmptyState qUIEmptyState = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuEmptyLayout");
            viewGroup = null;
        }
        QUIEmptyState qUIEmptyState2 = this.mEmptyState;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        viewGroup.addView(qUIEmptyState, 0);
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }
}
