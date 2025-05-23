package com.tencent.robot.aio.bottombar;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.aio.bottombar.RobotBottomBarUIState;
import com.tencent.robot.aio.bottombar.b;
import com.tencent.robot.aio.bottombar.event.RobotBottomBarEvent;
import com.tencent.robot.aio.bottombar.model.OptionType;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.aio.bottombar.viewholder.BlurSource;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J6\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001c\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J$\u0010$\u001a\u00020\t2\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\tH\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/robot/aio/bottombar/RobotBottomBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/bottombar/b;", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarUIState;", "", "f1", "", "Lcom/tencent/robot/aio/bottombar/model/a;", VideoTemplateParser.ITEM_LIST, "", "m1", "i1", "j1", "q1", ICustomDataEditor.NUMBER_PARAM_1, "h1", "itemData", "l1", "", "show", "Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bgList", "o1", "newData", "p1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "mUIModel", "afterCreateVM", "state", "g1", "bindViewAndData", "Lg24/b;", "d", "Lg24/b;", "bottomBarAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/robot/aio/bottombar/viewholder/a;", "f", "Lcom/tencent/robot/aio/bottombar/viewholder/a;", "blurSource", "Landroid/view/View$OnLayoutChangeListener;", h.F, "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", "Li24/a;", "i", "Li24/a;", "bottomItemOptionHandler", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBottomBarVB extends com.tencent.aio.base.mvvm.a<com.tencent.robot.aio.bottombar.b, RobotBottomBarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g24.b bottomBarAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BlurSource blurSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnLayoutChangeListener layoutChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i24.a bottomItemOptionHandler;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366881a;

        static {
            int[] iArr = new int[OptionType.values().length];
            try {
                iArr[OptionType.OPTION_CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f366881a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/robot/aio/bottombar/RobotBottomBarVB$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int a16 = x.a(8.0f);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager != null) {
                i3 = layoutManager.getItemCount();
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
            if (viewLayoutPosition == 0) {
                outRect.left = a16;
            } else if (viewLayoutPosition == i3 - 1) {
                outRect.left = a16;
                outRect.right = a16;
            } else {
                outRect.left = a16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(RobotBottomBarVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(b.a.f366882d);
    }

    private final int f1() {
        return l.b(28);
    }

    private final void h1() {
        com.tencent.aio.api.runtime.a aVar;
        j e16;
        RecyclerView recyclerView = this.recyclerView;
        boolean z16 = false;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (e16 = aVar.e()) != null) {
                e16.h(RobotBottomBarEvent.OnRobotBottomBarHide.f366888d);
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
        }
    }

    private final void i1() {
        if (getMUIModel() == null) {
            QLog.i("RobotBottomBarVB", 1, "initAdaptersIfNeed but VM is null.");
        }
    }

    private final void j1() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.aio.api.runtime.a aVar2;
        if (this.bottomBarAdapter == null) {
            FrameworkVM mUIModel = getMUIModel();
            if (mUIModel != null) {
                aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                QLog.d("RobotBottomBarVB", 4, "initViewIfNeed ");
                FrameworkVM mUIModel2 = getMUIModel();
                if (mUIModel2 != null && (aVar2 = (com.tencent.aio.api.runtime.a) mUIModel2.getMContext()) != null) {
                    g24.b bVar = new g24.b(aVar2, new RobotBottomBarVB$initViewIfNeed$1(this));
                    BlurSource blurSource = this.blurSource;
                    if (blurSource != null) {
                        bVar.o0(blurSource);
                    }
                    this.bottomBarAdapter = bVar;
                    RecyclerView recyclerView = this.recyclerView;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(bVar);
                    }
                    RecyclerView recyclerView2 = this.recyclerView;
                    if (recyclerView2 != null) {
                        recyclerView2.addItemDecoration(new c());
                    }
                } else {
                    return;
                }
            }
        }
        if (this.layoutChangeListener == null) {
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.robot.aio.bottombar.c
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    RobotBottomBarVB.k1(RobotBottomBarVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            };
            this.layoutChangeListener = onLayoutChangeListener;
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.addOnLayoutChangeListener(onLayoutChangeListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(RobotBottomBarVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        g24.b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BlurSource blurSource = this$0.blurSource;
        if (blurSource != null && (bVar = this$0.bottomBarAdapter) != null) {
            bVar.o0(blurSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(RobotBottomBarItemModel itemData) {
        if (getMUIModel() != null) {
            if (b.f366881a[itemData.getOptionType().ordinal()] == 1) {
                sendIntent(new b.C9758b(itemData));
                return;
            }
            i24.a aVar = this.bottomItemOptionHandler;
            if (aVar != null) {
                aVar.a(itemData);
            }
        }
    }

    private final void m1(List<RobotBottomBarItemModel> itemList) {
        i1();
        j1();
        g24.b bVar = this.bottomBarAdapter;
        if (bVar != null) {
            g24.b.n0(bVar, itemList, null, 2, null);
        }
        q1();
    }

    private final void n1() {
        boolean z16;
        k kVar;
        d.i iVar;
        com.tencent.aio.api.runtime.a aVar;
        j e16;
        List<com.tencent.mobileqq.album.ext.c> b16;
        com.tencent.aio.api.runtime.a aVar2;
        j e17;
        g24.b bVar = this.bottomBarAdapter;
        boolean z17 = true;
        if (bVar != null && bVar.getItemCount() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        FrameworkVM mUIModel = getMUIModel();
        Integer num = null;
        if (mUIModel != null && (aVar2 = (com.tencent.aio.api.runtime.a) mUIModel.getSafetyContext()) != null && (e17 = aVar2.e()) != null) {
            kVar = e17.k(InputEvent.RobotGetSelectMediaInfo.f188580d);
        } else {
            kVar = null;
        }
        if (kVar instanceof d.i) {
            iVar = (d.i) kVar;
        } else {
            iVar = null;
        }
        if (iVar != null && (b16 = iVar.b()) != null) {
            num = Integer.valueOf(b16.size());
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            z17 = false;
        }
        if (!z17 && num != null && num.intValue() == 0) {
            FrameworkVM mUIModel2 = getMUIModel();
            if (mUIModel2 != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel2.getMContext()) != null && (e16 = aVar.e()) != null) {
                e16.h(RobotBottomBarEvent.OnRobotBottomBarShow.f366889d);
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            QLog.d("RobotBottomBarVB", 4, "tryShowBottomSectionBar");
        }
    }

    private final void o1(boolean show, View bgView, ArrayList<Object> bgList) {
        BlurSource blurSource = new BlurSource(show, bgView, bgList);
        g24.b bVar = this.bottomBarAdapter;
        if (bVar != null) {
            bVar.o0(blurSource);
        }
        this.blurSource = blurSource;
    }

    private final void p1(RobotBottomBarItemModel newData) {
        g24.b bVar = this.bottomBarAdapter;
        if (bVar != null) {
            bVar.p0(newData);
        }
    }

    private final void q1() {
        QLog.d("RobotBottomBarVB", 4, "updateVisible");
        g24.b bVar = this.bottomBarAdapter;
        boolean z16 = false;
        if (bVar != null && bVar.getItemCount() == 0) {
            z16 = true;
        }
        if (z16) {
            h1();
        } else {
            n1();
        }
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<com.tencent.robot.aio.bottombar.b, RobotBottomBarUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        super.afterCreateVM(mUIModel);
        if (mUIModel == null) {
            return;
        }
        this.bottomItemOptionHandler = new i24.a(mUIModel.getMContext());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        getHostView().post(new Runnable() { // from class: com.tencent.robot.aio.bottombar.d
            @Override // java.lang.Runnable
            public final void run() {
                RobotBottomBarVB.e1(RobotBottomBarVB.this);
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<com.tencent.robot.aio.bottombar.b, RobotBottomBarUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotBottomBarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotBottomBarUIState.ShowRobotBottomBar) {
            n1();
            return;
        }
        if (state instanceof RobotBottomBarUIState.HideRobotBottomBar) {
            h1();
            return;
        }
        if (state instanceof RobotBottomBarUIState.PostThemeChanged) {
            g24.b bVar = this.bottomBarAdapter;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (state instanceof RobotBottomBarUIState.UpdateBlurState) {
            RobotBottomBarUIState.UpdateBlurState updateBlurState = (RobotBottomBarUIState.UpdateBlurState) state;
            o1(updateBlurState.getShow(), updateBlurState.getBgView(), updateBlurState.a());
        } else if (state instanceof RobotBottomBarUIState.SubmitBottomItemList) {
            m1(((RobotBottomBarUIState.SubmitBottomItemList) state).a());
        } else if (state instanceof RobotBottomBarUIState.UpdateBottomItem) {
            p1(((RobotBottomBarUIState.UpdateBottomItem) state).getData());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        InterceptTouchEventRecyclerView interceptTouchEventRecyclerView = new InterceptTouchEventRecyclerView(getMContext());
        interceptTouchEventRecyclerView.setVisibility(8);
        interceptTouchEventRecyclerView.setItemAnimator(null);
        interceptTouchEventRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, f1()));
        interceptTouchEventRecyclerView.setOverScrollMode(0);
        interceptTouchEventRecyclerView.setLayoutManager(new LinearLayoutManager(getMContext(), 0, false));
        this.recyclerView = interceptTouchEventRecyclerView;
        Intrinsics.checkNotNull(interceptTouchEventRecyclerView);
        return interceptTouchEventRecyclerView;
    }
}
