package com.tencent.robot.aio.bottombar.picture;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.robot.aio.bottombar.picture.RobotPictureBarUIState;
import com.tencent.robot.aio.bottombar.picture.d;
import hn2.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J$\u0010\u001c\u001a\u00020\u00062\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/bottombar/picture/d;", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarUIState;", "", "maxSize", "", "i1", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "pickPhotoResult", "h1", "m1", "e1", "l1", "j1", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "k1", "f1", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "mUIModel", "afterCreateVM", "state", "d1", "Lcom/tencent/robot/aio/bottombar/picture/a;", "d", "Lcom/tencent/robot/aio/bottombar/picture/a;", "recyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lhn2/l;", "f", "Lhn2/l;", "binding", "<init>", "()V", h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPictureBarVB extends com.tencent.aio.base.mvvm.a<d, RobotPictureBarUIState> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f366930h = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.robot.aio.bottombar.picture.a recyclerViewAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private l binding;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/aio/bottombar/picture/RobotPictureBarVB$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int dip2px = ViewUtils.dip2px(8.0f);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                i3 = layoutManager.getItemCount();
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            if (((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition() == i3 - 1) {
                outRect.right = dip2px;
            }
        }
    }

    private final void e1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2 = this.recyclerView;
        boolean z16 = false;
        if (recyclerView2 != null && recyclerView2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16 && (recyclerView = this.recyclerView) != null) {
            recyclerView.setVisibility(8);
        }
    }

    private final void f1() {
        com.tencent.aio.api.runtime.a aVar;
        if (this.recyclerViewAdapter == null) {
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null) {
                aVar = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                com.tencent.robot.aio.bottombar.picture.a aVar2 = new com.tencent.robot.aio.bottombar.picture.a(new RobotPictureBarVB$initAdapter$1(this), new RobotPictureBarVB$initAdapter$2(this));
                this.recyclerViewAdapter = aVar2;
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView != null) {
                    recyclerView.setAdapter(aVar2);
                }
            }
        }
    }

    private final void g1() {
        l lVar = this.binding;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            lVar = null;
        }
        RobotPictureRecyclerView robotPictureRecyclerView = lVar.f405387b;
        robotPictureRecyclerView.setVisibility(8);
        robotPictureRecyclerView.setOverScrollMode(2);
        robotPictureRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 0, false));
        this.recyclerView = robotPictureRecyclerView;
        robotPictureRecyclerView.addItemDecoration(new b());
    }

    private final void h1(List<LocalMediaInfo> pickPhotoResult) {
        QLog.i("RobotPictureBarVB", 1, "onAddPicItem: " + pickPhotoResult);
        com.tencent.robot.aio.bottombar.picture.a aVar = this.recyclerViewAdapter;
        if (aVar != null) {
            aVar.l0(pickPhotoResult);
        }
        if (!pickPhotoResult.isEmpty()) {
            m1();
            l1();
        }
    }

    private final void i1(int maxSize) {
        QQToast.makeText(getMContext(), 1, "\u6700\u591a\u53ea\u80fd\u9009\u62e9" + maxSize + "\u5f20\u56fe\u7247", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(LocalMediaInfo item) {
        sendIntent(new d.ClearSinglePictureInfo(item));
    }

    private final void l1() {
        com.tencent.aio.api.runtime.a aVar;
        j e16;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext()) != null && (e16 = aVar.e()) != null) {
            e16.h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(200L));
        }
    }

    private final void m1() {
        int i3;
        boolean z16;
        RecyclerView recyclerView;
        com.tencent.robot.aio.bottombar.picture.a aVar = this.recyclerViewAdapter;
        if (aVar != null) {
            i3 = aVar.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null && recyclerView2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (recyclerView = this.recyclerView) != null) {
            recyclerView.setVisibility(0);
        }
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<d, RobotPictureBarUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        super.afterCreateVM(mUIModel);
        g1();
        f1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<d, RobotPictureBarUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new RobotPictureBarVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotPictureBarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof RobotPictureBarUIState.AddPicItem) {
            h1(((RobotPictureBarUIState.AddPicItem) state).a());
            return;
        }
        if (state instanceof RobotPictureBarUIState.HidePictures) {
            e1();
        } else if (state instanceof RobotPictureBarUIState.ShowPictures) {
            m1();
        } else if (state instanceof RobotPictureBarUIState.NotifyOverMaxSelectedSize) {
            i1(((RobotPictureBarUIState.NotifyOverMaxSelectedSize) state).getMaxSize());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        l g16 = l.g(LayoutInflater.from(createViewParams.a()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
    }
}
