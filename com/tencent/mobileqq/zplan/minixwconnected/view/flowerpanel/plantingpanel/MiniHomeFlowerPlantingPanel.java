package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.view.MiniHomeFlowerPlantingButton;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.SingleItemShoppingCartData;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.ZPlanSingleItemShoppingCartDialogView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00017\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001@B\u001f\u0012\u0006\u0010<\u001a\u00020;\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J3\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\fH\u0002J\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002R\u001f\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel;", "Landroid/widget/RelativeLayout;", "", "p", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "flowerData", "u", "Landroid/view/View;", "root", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "callback", "w", "j", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/a;", IECSearchBar.METHOD_SET_CALLBACK, "k", "v", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "d", "Lmqq/util/WeakReference;", "l", "()Lmqq/util/WeakReference;", "controller", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/h;", "f", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/h;", "plantingAdapter", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$c;", tl.h.F, "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$c;", "flowerPanelData", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel;", "i", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel;", "flowerViewModel", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/a;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/view/MiniHomeFlowerPlantingButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/view/MiniHomeFlowerPlantingButton;", "plantButton", "D", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "currentSelectFlower", "com/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel$c", "E", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel$c;", "plantButtonAttachListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lmqq/util/WeakReference;)V", UserInfo.SEX_FEMALE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerPlantingPanel extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private MiniHomeFlowerPlantingButton plantButton;

    /* renamed from: D, reason: from kotlin metadata */
    private MiniHomeFlowerPlantingPanelViewModel.FlowerData currentSelectFlower;

    /* renamed from: E, reason: from kotlin metadata */
    private final c plantButtonAttachListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private h plantingAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MiniHomeFlowerPlantingPanelViewModel.FlowerPanelData flowerPanelData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MiniHomeFlowerPlantingPanelViewModel flowerViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a callback;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = ViewUtils.dpToPx(8.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerPlantingPanel(Context context, WeakReference<MiniHomeConnectedController> weakReference) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.controller = weakReference;
        this.plantButtonAttachListener = new c();
    }

    private final void m() {
        MiniHomeConnectedController miniHomeConnectedController;
        Fragment fragment;
        WeakReference<MiniHomeConnectedController> weakReference = this.controller;
        if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null || (fragment = miniHomeConnectedController.getFragment()) == null) {
            return;
        }
        MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel = new MiniHomeFlowerPlantingPanelViewModel();
        this.flowerViewModel = miniHomeFlowerPlantingPanelViewModel;
        LiveData<MiniHomeFlowerPlantingPanelViewModel.FlowerPanelData> O1 = miniHomeFlowerPlantingPanelViewModel.O1();
        if (O1 != null) {
            O1.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniHomeFlowerPlantingPanel.n(MiniHomeFlowerPlantingPanel.this, (MiniHomeFlowerPlantingPanelViewModel.FlowerPanelData) obj);
                }
            });
        }
        MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel2 = this.flowerViewModel;
        if (miniHomeFlowerPlantingPanelViewModel2 != null) {
            Lifecycle lifecycle = fragment.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "it.lifecycle");
            miniHomeFlowerPlantingPanelViewModel2.N1(LifecycleKt.getCoroutineScope(lifecycle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MiniHomeFlowerPlantingPanel this$0, MiniHomeFlowerPlantingPanelViewModel.FlowerPanelData flowerPanelData) {
        List<MiniHomeFlowerPlantingPanelViewModel.FlowerData> a16;
        h hVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.flowerPanelData = flowerPanelData;
        if (flowerPanelData == null || (a16 = flowerPanelData.a()) == null || (hVar = this$0.plantingAdapter) == null) {
            return;
        }
        hVar.submitList(a16);
    }

    private final void p() {
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean q16;
                q16 = MiniHomeFlowerPlantingPanel.q(view, motionEvent);
                return q16;
            }
        });
        try {
            View findViewById = rootView.findViewById(R.id.f163344pm3);
            View findViewById2 = findViewById.findViewById(R.id.f163484qd2);
            MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton = null;
            ImageView imageView = findViewById2 instanceof ImageView ? (ImageView) findViewById2 : null;
            if (imageView != null) {
                imageView.setImageDrawable(ie0.a.f().o(imageView.getContext(), R.drawable.qui_info_circle, R.color.qui_common_icon_secondary, 1001));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniHomeFlowerPlantingPanel.r(MiniHomeFlowerPlantingPanel.this, view);
                    }
                });
            }
            View findViewById3 = findViewById.findViewById(R.id.qcz);
            ImageView imageView2 = findViewById3 instanceof ImageView ? (ImageView) findViewById3 : null;
            if (imageView2 != null) {
                imageView2.setImageDrawable(ie0.a.f().o(imageView2.getContext(), R.drawable.qui_close, R.color.qui_common_icon_primary, 1001));
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniHomeFlowerPlantingPanel.s(MiniHomeFlowerPlantingPanel.this, view);
                    }
                });
            }
            Intrinsics.checkNotNullExpressionValue(findViewById, "this");
            o(findViewById);
            View findViewById4 = rootView.findViewById(R.id.qcy);
            final MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton2 = findViewById4 instanceof MiniHomeFlowerPlantingButton ? (MiniHomeFlowerPlantingButton) findViewById4 : null;
            if (miniHomeFlowerPlantingButton2 != null) {
                miniHomeFlowerPlantingButton2.setEnabled(false);
                ie0.a.f().g(miniHomeFlowerPlantingButton2.getContext(), R.color.qui_button_text_primary_default, 1001);
                miniHomeFlowerPlantingButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniHomeFlowerPlantingPanel.t(MiniHomeFlowerPlantingPanel.this, miniHomeFlowerPlantingButton2, view);
                    }
                });
                miniHomeFlowerPlantingButton2.addOnAttachStateChangeListener(this.plantButtonAttachListener);
                miniHomeFlowerPlantingButton = miniHomeFlowerPlantingButton2;
            }
            this.plantButton = miniHomeFlowerPlantingButton;
        } catch (Exception e16) {
            QLog.e("MiniHomeFlowerPlantingPanel", 2, "initView error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MiniHomeFlowerPlantingPanel this$0, View it) {
        String illustrationUrl;
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniHomeFlowerPlantingPanelViewModel.FlowerPanelData flowerPanelData = this$0.flowerPanelData;
        if (flowerPanelData == null || (illustrationUrl = flowerPanelData.getIllustrationUrl()) == null) {
            return;
        }
        QLog.i("MiniHomeFlowerPlantingPanel", 2, "illustratedUrl = " + illustrationUrl);
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        intent.putExtra("url", illustrationUrl);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        WeakReference<MiniHomeConnectedController> weakReference = this$0.controller;
        if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null || (U = miniHomeConnectedController.U()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_detail_btn", "dt_clck", null, false, false, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MiniHomeFlowerPlantingPanel this$0, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<MiniHomeConnectedController> weakReference = this$0.controller;
        if (weakReference != null && (miniHomeConnectedController = weakReference.get()) != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, "dt_clck", null, false, false, 40, null);
        }
        a aVar = this$0.callback;
        if (aVar != null) {
            aVar.a();
        }
        this$0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final MiniHomeFlowerPlantingPanel this$0, MiniHomeFlowerPlantingButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        final MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData = this$0.currentSelectFlower;
        if (flowerData == null) {
            return;
        }
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QQToastUtil.showQQToastInUiThread(1, this_apply.getContext().getResources().getString(R.string.f171139ci4));
            QLog.w("MiniHomeFlowerPlantingPanel", 1, "plantButton click networkAvailable false, return!");
            return;
        }
        if (i.a(flowerData)) {
            this$0.w(flowerData, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel$initView$3$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    a aVar;
                    if (z16) {
                        MiniHomeFlowerPlantingPanelViewModel.FlowerData.this.j(1);
                        aVar = this$0.callback;
                        if (aVar != null) {
                            aVar.b(MiniHomeFlowerPlantingPanelViewModel.FlowerData.this);
                        }
                        this$0.v();
                        return;
                    }
                    QQToastUtil.showQQToastInUiThread(1, "\u79cd\u690d\u5931\u8d25");
                }
            });
        } else {
            a aVar = this$0.callback;
            if (aVar != null) {
                aVar.b(flowerData);
            }
            this$0.v();
        }
        this$0.u(this_apply, flowerData);
    }

    private final void u(QUIButton qUIButton, MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", flowerData.getFlowerName());
        jSONObject.put("item_id", flowerData.getId());
        jSONObject.put("item_type", flowerData.getFlowerOwnStatus());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026tus)\n        }.toString()");
        WeakReference<MiniHomeConnectedController> weakReference = this.controller;
        if (weakReference == null || (miniHomeConnectedController = weakReference.get()) == null || (U = miniHomeConnectedController.U()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_crop_data", jSONObject2);
        Unit unit = Unit.INSTANCE;
        ZPlanMiniHomeConnectReporter.f(U, qUIButton, "em_zplan_buy", "dt_clck", linkedHashMap, false, false, 32, null);
    }

    private final void w(final MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData, final Function1<? super Boolean, Unit> callback) {
        QLog.i("MiniHomeFlowerPlantingPanel", 1, "showShoppingCart flowerData:" + flowerData.getFlowerName() + ", coinType:" + flowerData.getFlowerCoinType() + ", cost:" + flowerData.getFlowerCost());
        SingleItemShoppingCartData b16 = MiniHomeFlowerPlantingPanelViewModel.FlowerData.INSTANCE.b(flowerData);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new ZPlanSingleItemShoppingCartDialogView(context, b16, new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel$showShoppingCart$dialogView$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel$showShoppingCart$dialogView$1$1", f = "MiniHomeFlowerPlantingPanel.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel$showShoppingCart$dialogView$1$1, reason: invalid class name */
            /* loaded from: classes34.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $callback;
                final /* synthetic */ Function1<Boolean, Unit> $finishCallback;
                final /* synthetic */ MiniHomeFlowerPlantingPanelViewModel.FlowerData $flowerData;
                int label;
                final /* synthetic */ MiniHomeFlowerPlantingPanel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData, MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel, Function1<? super Boolean, Unit> function1, Function1<? super Boolean, Unit> function12, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$flowerData = flowerData;
                    this.this$0 = miniHomeFlowerPlantingPanel;
                    this.$finishCallback = function1;
                    this.$callback = function12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$flowerData, this.this$0, this.$finishCallback, this.$callback, continuation);
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0071  */
                /* JADX WARN: Removed duplicated region for block: B:9:0x007b  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel;
                    p55.j jVar;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        QLog.i("MiniHomeFlowerPlantingPanel", 1, "requestUnlockFlower start, flowerData:" + this.$flowerData.getId() + " name:" + this.$flowerData.getFlowerName() + ", ownStatus:" + this.$flowerData.getFlowerOwnStatus());
                        miniHomeFlowerPlantingPanelViewModel = this.this$0.flowerViewModel;
                        if (miniHomeFlowerPlantingPanelViewModel != null) {
                            MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData = this.$flowerData;
                            this.label = 1;
                            obj = miniHomeFlowerPlantingPanelViewModel.Q1(flowerData, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            jVar = null;
                            QLog.i("MiniHomeFlowerPlantingPanel", 1, "requestUnlockFlower finish, unlockResult:" + (jVar == null ? Boxing.boxInt(jVar.f425408a) : null) + ", unlockMessage:" + (jVar != null ? jVar.f425409b : null));
                            boolean z16 = jVar == null && jVar.f425408a == 0;
                            this.$finishCallback.invoke(Boxing.boxBoolean(z16));
                            this.$callback.invoke(Boxing.boxBoolean(z16));
                            return Unit.INSTANCE;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jVar = (p55.j) obj;
                    if (jVar == null) {
                    }
                    if (jVar != null) {
                    }
                    QLog.i("MiniHomeFlowerPlantingPanel", 1, "requestUnlockFlower finish, unlockResult:" + (jVar == null ? Boxing.boxInt(jVar.f425408a) : null) + ", unlockMessage:" + (jVar != null ? jVar.f425409b : null));
                    if (jVar == null) {
                    }
                    this.$finishCallback.invoke(Boxing.boxBoolean(z16));
                    this.$callback.invoke(Boxing.boxBoolean(z16));
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function1) {
                invoke2((Function1<? super Boolean, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super Boolean, Unit> finishCallback) {
                MiniHomeConnectedController miniHomeConnectedController;
                Fragment fragment;
                LifecycleCoroutineScope lifecycleScope;
                Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
                WeakReference<MiniHomeConnectedController> l3 = MiniHomeFlowerPlantingPanel.this.l();
                if (l3 == null || (miniHomeConnectedController = l3.get()) == null || (fragment = miniHomeConnectedController.getFragment()) == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragment)) == null) {
                    return;
                }
                CorountineFunKt.e(lifecycleScope, "MiniHomeFlowerPlantingPanel_requestUnlockFlower", null, null, null, new AnonymousClass1(flowerData, MiniHomeFlowerPlantingPanel.this, finishCallback, callback, null), 14, null);
            }
        }).x();
    }

    public final View j() {
        View.inflate(getContext(), R.layout.ddd, this);
        p();
        m();
        return this;
    }

    public final void k() {
        if (this.plantButton != null) {
            removeOnAttachStateChangeListener(this.plantButtonAttachListener);
        }
    }

    public final WeakReference<MiniHomeConnectedController> l() {
        return this.controller;
    }

    public final void setCallback(a callback) {
        this.callback = callback;
    }

    public final void v() {
        this.currentSelectFlower = null;
        MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton = this.plantButton;
        if (miniHomeFlowerPlantingButton != null) {
            miniHomeFlowerPlantingButton.setEnabled(false);
        }
        MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton2 = this.plantButton;
        if (miniHomeFlowerPlantingButton2 != null) {
            miniHomeFlowerPlantingButton2.setText(getResources().getString(R.string.xqt));
        }
        h hVar = this.plantingAdapter;
        if (hVar != null) {
            hVar.m0();
        }
    }

    private final void o(View root) {
        View findViewById = root.findViewById(R.id.qgo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.recyclerView)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.plantingAdapter = new h(this.controller, new Function1<MiniHomeFlowerPlantingPanelViewModel.FlowerData, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData) {
                invoke2(flowerData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData) {
                a aVar;
                Intrinsics.checkNotNullParameter(flowerData, "flowerData");
                QLog.i("MiniHomeFlowerPlantingPanel", 1, "onSelected flowerData id=" + flowerData.getId() + ", name=" + flowerData.getFlowerName() + ", status=" + flowerData.getFlowerStatus() + ", coinType=" + flowerData.getFlowerCoinType() + ", cost=" + flowerData.getFlowerCost());
                MiniHomeFlowerPlantingPanel.this.currentSelectFlower = flowerData;
                MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton = MiniHomeFlowerPlantingPanel.this.plantButton;
                if (miniHomeFlowerPlantingButton != null) {
                    miniHomeFlowerPlantingButton.setEnabled(true);
                }
                MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton2 = MiniHomeFlowerPlantingPanel.this.plantButton;
                if (miniHomeFlowerPlantingButton2 != null) {
                    miniHomeFlowerPlantingButton2.u(flowerData);
                }
                aVar = MiniHomeFlowerPlantingPanel.this.callback;
                if (aVar != null) {
                    aVar.c(flowerData);
                }
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4, 1, false));
        recyclerView.setItemAnimator(new com.tencent.mobileqq.zplan.minihome.view.j());
        recyclerView.setAdapter(this.plantingAdapter);
        this.recyclerView = recyclerView;
        recyclerView.addItemDecoration(new b());
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            WeakReference<MiniHomeConnectedController> l3;
            MiniHomeConnectedController miniHomeConnectedController;
            ZPlanMiniHomeConnectReporter U;
            MiniHomeFlowerPlantingButton miniHomeFlowerPlantingButton = MiniHomeFlowerPlantingPanel.this.plantButton;
            if (miniHomeFlowerPlantingButton == null || (l3 = MiniHomeFlowerPlantingPanel.this.l()) == null || (miniHomeConnectedController = l3.get()) == null || (U = miniHomeConnectedController.U()) == null) {
                return;
            }
            ZPlanMiniHomeConnectReporter.f(U, miniHomeFlowerPlantingButton, "em_zplan_buy", "dt_imp", null, false, false, 40, null);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
        }
    }
}
