package com.tencent.mobileqq.aio.notification.list;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0001MB\u000f\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationListVB;", "Lcom/tencent/mobileqq/aio/notification/base/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$UpdateRecyclerViewHeightUIState;", "state", "", "y1", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$UpdateContainerSizeUIState;", "v1", "B1", "k1", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$AddNotificationUIState;", "m1", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$UpdateNotificationUIState;", "w1", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$RemoveNotificationUIState;", "r1", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$KeyboardOrPanelUIState;", "q1", "p1", "o1", "Lcom/tencent/mobileqq/aio/notification/base/c;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "u1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lp81/f;", "d", "Lp81/f;", "viewBinding", "Lcom/tencent/mobileqq/aio/notification/list/j;", "e", "Lkotlin/Lazy;", "l1", "()Lcom/tencent/mobileqq/aio/notification/list/j;", "viewModel", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "handler", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "listCloseBtn", BdhLogUtil.LogTag.Tag_Conn, "listCloseBtnContainer", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter;", "D", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter;", "adapter", "E", "maskBg", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationScrollLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationScrollLayout;", "scrollLayout", "G", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState$UpdateContainerSizeUIState;", "lastUpdateContainerSizeUIState", "", "H", "Z", "needAnimOnNextUIState", "<init>", "(Lp81/f;)V", "I", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationListVB extends com.tencent.mobileqq.aio.notification.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View listCloseBtnContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private AIONotificationAdapter adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private View maskBg;

    /* renamed from: F, reason: from kotlin metadata */
    private AIONotificationScrollLayout scrollLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private AIONotificationUIState.UpdateContainerSizeUIState lastUpdateContainerSizeUIState;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needAnimOnNextUIState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p81.f viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout container;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View listCloseBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationListVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.list.AIONotificationListVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/notification/list/AIONotificationListVB$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationListVB.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            outRect.top = (int) aIONotificationUIUtils.w(AIONotificationListVB.this.getMContext());
            outRect.left = (int) aIONotificationUIUtils.w(AIONotificationListVB.this.getMContext());
            outRect.right = (int) aIONotificationUIUtils.w(AIONotificationListVB.this.getMContext());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONotificationListVB(@NotNull p81.f viewBinding) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewBinding);
            return;
        }
        this.viewBinding = viewBinding;
        lazy = LazyKt__LazyJVMKt.lazy(AIONotificationListVB$viewModel$2.INSTANCE);
        this.viewModel = lazy;
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(AIONotificationListVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B1(AIONotificationUIState.UpdateRecyclerViewHeightUIState state) {
        int i3;
        final int a16 = state.a();
        RecyclerView recyclerView = null;
        this.handler.removeCallbacksAndMessages(null);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView2.getLayoutParams();
        if (layoutParams != null) {
            int i16 = layoutParams.height;
            if (i16 < a16) {
                RecyclerView recyclerView3 = this.recyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView3 = null;
                }
                recyclerView3.getLayoutParams().height = a16;
                RecyclerView recyclerView4 = this.recyclerView;
                if (recyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView4 = null;
                }
                recyclerView4.requestLayout();
            } else if (i16 > a16) {
                this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIONotificationListVB.C1(AIONotificationListVB.this, a16);
                    }
                }, 400L);
            }
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        if (state.b()) {
            i3 = com.tencent.qqnt.aio.utils.l.b(8);
        } else {
            i3 = 0;
        }
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(AIONotificationListVB this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.getLayoutParams().height = i3;
        RecyclerView recyclerView3 = this$0.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.requestLayout();
    }

    private final void k1(AIONotificationUIState.UpdateContainerSizeUIState state) {
        int i3;
        boolean z16;
        int b16 = state.b();
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        float z17 = aIONotificationUIUtils.z(getMContext());
        AIONotificationUIState.UpdateContainerSizeUIState updateContainerSizeUIState = this.lastUpdateContainerSizeUIState;
        if (updateContainerSizeUIState != null) {
            i3 = updateContainerSizeUIState.b();
        } else {
            i3 = 0;
        }
        float f16 = -(z17 - i3);
        final float f17 = -(aIONotificationUIUtils.z(getMContext()) - b16);
        boolean z18 = true;
        if (state.a() == 0) {
            View view = this.listCloseBtnContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listCloseBtnContainer");
                view = null;
            }
            if (view.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                final View view2 = this.listCloseBtnContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listCloseBtnContainer");
                    view2 = null;
                }
                view2.setAlpha(1.0f);
                view2.setTranslationY(f16);
                view2.clearAnimation();
                ViewPropertyAnimator duration = view2.animate().setInterpolator(null).alpha(0.0f).translationY(f17).setDuration(200L);
                Intrinsics.checkNotNullExpressionValue(duration, "animate()\n              \u2026IUtils.DEFAULT_ANIM_TIME)");
                aIONotificationUIUtils.m(duration, new Function0<Unit>(view2) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationListVB$changeCloseBtnVisibility$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $this_apply;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$this_apply = view2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            this.$this_apply.setVisibility(8);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }).start();
                return;
            }
        }
        if (state.a() != 0) {
            View view3 = this.listCloseBtnContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listCloseBtnContainer");
                view3 = null;
            }
            if (view3.getVisibility() != 0) {
                z18 = false;
            }
            if (!z18) {
                final View view4 = this.listCloseBtnContainer;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listCloseBtnContainer");
                    view4 = null;
                }
                view4.setVisibility(0);
                view4.setAlpha(0.0f);
                view4.setTranslationY(f16);
                view4.clearAnimation();
                ViewPropertyAnimator duration2 = view4.animate().setInterpolator(null).alpha(1.0f).translationY(f17).setDuration(200L);
                Intrinsics.checkNotNullExpressionValue(duration2, "animate()\n              \u2026IUtils.DEFAULT_ANIM_TIME)");
                aIONotificationUIUtils.m(duration2, new Function0<Unit>(view4, f17) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationListVB$changeCloseBtnVisibility$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $this_apply;
                    final /* synthetic */ float $toTranslationY;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$this_apply = view4;
                        this.$toTranslationY = f17;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, view4, Float.valueOf(f17));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.$this_apply.setAlpha(1.0f);
                            this.$this_apply.setTranslationY(this.$toTranslationY);
                        }
                    }
                }).start();
                return;
            }
            final View view5 = this.listCloseBtnContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listCloseBtnContainer");
                view5 = null;
            }
            view5.clearAnimation();
            ViewPropertyAnimator duration3 = view5.animate().setInterpolator(null).translationY(f17).setDuration(200L);
            Intrinsics.checkNotNullExpressionValue(duration3, "animate()\n              \u2026IUtils.DEFAULT_ANIM_TIME)");
            aIONotificationUIUtils.m(duration3, new Function0<Unit>(view5, f17) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationListVB$changeCloseBtnVisibility$3$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $this_apply;
                final /* synthetic */ float $toTranslationY;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$this_apply = view5;
                    this.$toTranslationY = f17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, view5, Float.valueOf(f17));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        this.$this_apply.setTranslationY(this.$toTranslationY);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }).start();
        }
    }

    private final j l1() {
        return (j) this.viewModel.getValue();
    }

    private final void m1(final AIONotificationUIState.AddNotificationUIState state) {
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.f
            @Override // java.lang.Runnable
            public final void run() {
                AIONotificationListVB.n1(AIONotificationListVB.this, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(AIONotificationListVB this$0, AIONotificationUIState.AddNotificationUIState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        AIONotificationAdapter aIONotificationAdapter = this$0.adapter;
        if (aIONotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aIONotificationAdapter = null;
        }
        aIONotificationAdapter.t0(state.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        View view;
        AIONotificationScrollLayout aIONotificationScrollLayout = this.scrollLayout;
        AIONotificationAdapter aIONotificationAdapter = null;
        if (aIONotificationScrollLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout = null;
        }
        aIONotificationScrollLayout.setScrollEnable(false);
        AIONotificationScrollLayout aIONotificationScrollLayout2 = this.scrollLayout;
        if (aIONotificationScrollLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout2 = null;
        }
        aIONotificationScrollLayout2.setResetScrollYOnEnd(true);
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        View view2 = this.maskBg;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskBg");
            view = null;
        } else {
            view = view2;
        }
        AIONotificationUIUtils.D(aIONotificationUIUtils, view, 0L, 1, null);
        AIONotificationAdapter aIONotificationAdapter2 = this.adapter;
        if (aIONotificationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            aIONotificationAdapter = aIONotificationAdapter2;
        }
        aIONotificationAdapter.y0();
    }

    private final void p1() {
        View view;
        AIONotificationScrollLayout aIONotificationScrollLayout = this.scrollLayout;
        if (aIONotificationScrollLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout = null;
        }
        aIONotificationScrollLayout.setScrollEnable(true);
        AIONotificationScrollLayout aIONotificationScrollLayout2 = this.scrollLayout;
        if (aIONotificationScrollLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout2 = null;
        }
        aIONotificationScrollLayout2.setResetScrollYOnEnd(true);
        AIONotificationScrollLayout aIONotificationScrollLayout3 = this.scrollLayout;
        if (aIONotificationScrollLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout3 = null;
        }
        aIONotificationScrollLayout3.b();
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        View view2 = this.maskBg;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskBg");
            view = null;
        } else {
            view = view2;
        }
        AIONotificationUIUtils.W(aIONotificationUIUtils, view, 0L, 1, null);
    }

    private final void q1(AIONotificationUIState.KeyboardOrPanelUIState state) {
        AIONotificationScrollLayout aIONotificationScrollLayout = this.scrollLayout;
        AIONotificationAdapter aIONotificationAdapter = null;
        if (aIONotificationScrollLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
            aIONotificationScrollLayout = null;
        }
        aIONotificationScrollLayout.setScrollEnable(false);
        if (state.a()) {
            AIONotificationAdapter aIONotificationAdapter2 = this.adapter;
            if (aIONotificationAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aIONotificationAdapter = aIONotificationAdapter2;
            }
            aIONotificationAdapter.C0();
            return;
        }
        AIONotificationAdapter aIONotificationAdapter3 = this.adapter;
        if (aIONotificationAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            aIONotificationAdapter = aIONotificationAdapter3;
        }
        aIONotificationAdapter.W0();
    }

    private final void r1(final AIONotificationUIState.RemoveNotificationUIState state) {
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.d
            @Override // java.lang.Runnable
            public final void run() {
                AIONotificationListVB.s1(AIONotificationListVB.this, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(AIONotificationListVB this$0, AIONotificationUIState.RemoveNotificationUIState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        AIONotificationAdapter aIONotificationAdapter = this$0.adapter;
        if (aIONotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aIONotificationAdapter = null;
        }
        aIONotificationAdapter.U0(state.a());
    }

    private final void v1(AIONotificationUIState.UpdateContainerSizeUIState state) {
        if (Intrinsics.areEqual(this.lastUpdateContainerSizeUIState, state)) {
            return;
        }
        k1(state);
        if (this.needAnimOnNextUIState) {
            AIONotificationScrollLayout aIONotificationScrollLayout = this.scrollLayout;
            if (aIONotificationScrollLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollLayout");
                aIONotificationScrollLayout = null;
            }
            aIONotificationScrollLayout.c();
        }
        this.lastUpdateContainerSizeUIState = state;
    }

    private final void w1(final AIONotificationUIState.UpdateNotificationUIState state) {
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.i
            @Override // java.lang.Runnable
            public final void run() {
                AIONotificationListVB.x1(AIONotificationListVB.this, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(AIONotificationListVB this$0, AIONotificationUIState.UpdateNotificationUIState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        AIONotificationAdapter aIONotificationAdapter = this$0.adapter;
        if (aIONotificationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aIONotificationAdapter = null;
        }
        aIONotificationAdapter.X0(state.a());
    }

    private final void y1(AIONotificationUIState.UpdateRecyclerViewHeightUIState state) {
        B1(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(AIONotificationListVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.aio.notification.base.a
    @NotNull
    public com.tencent.mobileqq.aio.notification.base.c b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.notification.base.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return l1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.bindViewAndData();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        RelativeLayout relativeLayout = this.viewBinding.f425732b;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.aioNotificationExpandContainer");
        this.container = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            relativeLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        layoutParams.height = (int) aIONotificationUIUtils.y(getMContext());
        RecyclerView recyclerView = this.viewBinding.f425735e;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "viewBinding.aioNotificationRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getMContext()));
        AIONotificationAdapter aIONotificationAdapter = new AIONotificationAdapter(recyclerView, l1());
        c cVar = new c(aIONotificationAdapter, aIONotificationAdapter);
        cVar.setAddDuration(200L);
        cVar.setMoveDuration(200L);
        cVar.setRemoveDuration(200L);
        recyclerView.setItemAnimator(cVar);
        recyclerView.setAdapter(aIONotificationAdapter);
        recyclerView.setOverScrollMode(2);
        recyclerView.addItemDecoration(new b());
        this.recyclerView = recyclerView;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter");
        this.adapter = (AIONotificationAdapter) adapter;
        NestedScrollView nestedScrollView = this.viewBinding.f425734d;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "viewBinding.aioNotificationListCloseBtnContainer");
        this.listCloseBtnContainer = nestedScrollView;
        ImageView imageView = this.viewBinding.f425733c;
        imageView.getLayoutParams().height = (int) aIONotificationUIUtils.p(getMContext());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.list.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIONotificationListVB.z1(AIONotificationListVB.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.aioNotificat\u2026)\n            }\n        }");
        this.listCloseBtn = imageView;
        View view = this.viewBinding.f425738h;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.maskBg");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.list.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIONotificationListVB.A1(AIONotificationListVB.this, view2);
            }
        });
        this.maskBg = view;
        AIONotificationScrollLayout aIONotificationScrollLayout = this.viewBinding.f425736f;
        Intrinsics.checkNotNullExpressionValue(aIONotificationScrollLayout, "viewBinding.aioNotificationScrollingLayout");
        Context context = aIONotificationScrollLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aIONotificationScrollLayout.setMaxScrollY(aIONotificationUIUtils.x(context));
        aIONotificationScrollLayout.setOnScrollEnd(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationListVB$onCreateView$4$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONotificationListVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AIONotificationListVB.this.o1();
                    AIONotificationListVB.this.needAnimOnNextUIState = true;
                }
            }
        });
        this.scrollLayout = aIONotificationScrollLayout;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            return null;
        }
        return recyclerView2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        AIONotificationAdapter aIONotificationAdapter = null;
        this.handler.removeCallbacksAndMessages(null);
        AIONotificationAdapter aIONotificationAdapter2 = this.adapter;
        if (aIONotificationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            aIONotificationAdapter = aIONotificationAdapter2;
        }
        aIONotificationAdapter.w0();
        o1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIONotificationUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIONotificationUIState.AddNotificationUIState) {
            m1((AIONotificationUIState.AddNotificationUIState) state);
            return;
        }
        if (state instanceof AIONotificationUIState.UpdateNotificationUIState) {
            w1((AIONotificationUIState.UpdateNotificationUIState) state);
            return;
        }
        if (state instanceof AIONotificationUIState.RemoveNotificationUIState) {
            r1((AIONotificationUIState.RemoveNotificationUIState) state);
            return;
        }
        if (state instanceof AIONotificationUIState.CloseListUIState) {
            o1();
            return;
        }
        if (state instanceof AIONotificationUIState.KeyboardOrPanelUIState) {
            q1((AIONotificationUIState.KeyboardOrPanelUIState) state);
            return;
        }
        if (state instanceof AIONotificationUIState.ExpandListUIState) {
            p1();
            return;
        }
        if (state instanceof AIONotificationUIState.UpdateRecyclerViewHeightUIState) {
            y1((AIONotificationUIState.UpdateRecyclerViewHeightUIState) state);
        } else if (state instanceof AIONotificationUIState.UpdateContainerSizeUIState) {
            v1((AIONotificationUIState.UpdateContainerSizeUIState) state);
        } else {
            super.handleUIState(state);
        }
    }
}
