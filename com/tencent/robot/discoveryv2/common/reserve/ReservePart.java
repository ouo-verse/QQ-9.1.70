package com.tencent.robot.discoveryv2.common.reserve;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.reserve.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y34.ReserveParams;
import y34.d;
import y34.e;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/reserve/ReservePart;", "Lo34/a;", "", "E9", "D9", "initViewModel", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "Ljava/lang/String;", "troopUin", "Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "e", "Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "viewModel", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "reserveLayout", h.F, "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "currentLoadState", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ReservePart extends o34.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ReserveViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout reserveLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadState currentLoadState = LoadState.NONE;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367725a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadState.LOAD_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f367725a = iArr;
        }
    }

    private final void D9() {
        ConstraintLayout constraintLayout = (ConstraintLayout) getPartRootView().findViewById(R.id.b_1);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
        frameLayout.setBackgroundColor(frameLayout.getContext().getColor(R.color.qui_common_fill_light_primary));
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        frameLayout.setLayoutParams(layoutParams);
        this.reserveLayout = frameLayout;
        constraintLayout.addView(frameLayout);
    }

    private final void E9() {
        String stringExtra = getPartHost().getHostActivity().getIntent().getStringExtra("param_uin");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.troopUin = stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(LoadState loadState) {
        y34.b eVar;
        if (this.currentLoadState == loadState) {
            return;
        }
        int i3 = a.f367725a[loadState.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                eVar = new y34.a();
            } else {
                eVar = new d();
            }
        } else {
            eVar = new e();
        }
        String str = this.troopUin;
        FrameLayout frameLayout = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        ReserveViewModel reserveViewModel = this.viewModel;
        if (reserveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            reserveViewModel = null;
        }
        ReserveParams reserveParams = new ReserveParams(str, reserveViewModel);
        FrameLayout frameLayout2 = this.reserveLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reserveLayout");
        } else {
            frameLayout = frameLayout2;
        }
        eVar.a(reserveParams, frameLayout);
    }

    private final void initViewModel() {
        ReserveViewModel reserveViewModel = (ReserveViewModel) z9(ReserveViewModel.class);
        this.viewModel = reserveViewModel;
        ReserveViewModel reserveViewModel2 = null;
        if (reserveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            reserveViewModel = null;
        }
        reserveViewModel.Q1();
        ReserveViewModel reserveViewModel3 = this.viewModel;
        if (reserveViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            reserveViewModel2 = reserveViewModel3;
        }
        MutableLiveData<b> P1 = reserveViewModel2.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.robot.discoveryv2.common.reserve.ReservePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                if (bVar instanceof b.UpdateLoadStateUIState) {
                    ReservePart.this.G9(((b.UpdateLoadStateUIState) bVar).getLoadState());
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discoveryv2.common.reserve.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservePart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        E9();
        D9();
        initViewModel();
    }
}
