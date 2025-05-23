package com.qzone.reborn.repair.part.layer;

import android.animation.Animator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerLoadingPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "B9", "D9", "initViewModel", "", "status", "F9", "(Ljava/lang/Integer;)V", "G9", "E9", "hideLoadingView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Landroid/view/View;", "mLoadingView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mLoadingContainer", "f", "mLoadingTextArea", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mLoadingIcon", "i", "mBeginContainer", "Lcom/airbnb/lottie/LottieAnimationView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/airbnb/lottie/LottieAnimationView;", "mMaskLottieView", BdhLogUtil.LogTag.Tag_Conn, "mStarLottieView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "D", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "Lcom/qzone/reborn/repair/utils/aa;", "E", "Lcom/qzone/reborn/repair/utils/aa;", "mRepairAnimalManager", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerLoadingPart extends RFWLayerBasePart {
    private static final int G = (int) ((ar.k() * 260.0f) / com.tencent.luggage.wxa.uf.f.CTRL_INDEX);

    /* renamed from: C, reason: from kotlin metadata */
    private LottieAnimationView mStarLottieView;

    /* renamed from: D, reason: from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.repair.utils.aa mRepairAnimalManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mLoadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLoadingContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLoadingTextArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mLoadingIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mBeginContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView mMaskLottieView;

    private final void B9(View rootView) {
        View view = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f167312cn1, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context)\n \u2026yer_loading_layout, null)");
        this.mLoadingView = inflate;
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.mLoadingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        } else {
            view = view2;
        }
        viewGroup.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
        this.mPhotoRepairViewModel = qZonePhotoRepairLayerViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        MutableLiveData<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData> n26 = qZonePhotoRepairLayerViewModel.n2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit> function1 = new Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerLoadingPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                invoke2(repairStatusData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZonePhotoRepairLayerViewModel.Companion.RepairStatusData repairStatusData) {
                if (!repairStatusData.getIsSilentRepair()) {
                    QZonePhotoRepairLayerLoadingPart.this.F9(repairStatusData.getStatus());
                } else {
                    QLog.d("QZonePhotoRepairLayerLoadingPart", 1, "[repair_photo] isSilentRepair return");
                }
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.repair.part.layer.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerLoadingPart.C9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        B9(rootView);
        D9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.qzone.reborn.repair.utils.aa aaVar = this.mRepairAnimalManager;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepairAnimalManager");
            aaVar = null;
        }
        aaVar.i();
    }

    private final void E9() {
        QLog.d("QZonePhotoRepairLayerLoadingPart", 1, "[repair_photo] show complete anim");
        ViewGroup viewGroup = this.mLoadingTextArea;
        LottieAnimationView lottieAnimationView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTextArea");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        com.qzone.reborn.repair.utils.aa aaVar = this.mRepairAnimalManager;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepairAnimalManager");
            aaVar = null;
        }
        aaVar.d();
        LottieAnimationView lottieAnimationView2 = this.mMaskLottieView;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskLottieView");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.addAnimatorListener(new b());
    }

    private final void G9() {
        QLog.d("QZonePhotoRepairLayerLoadingPart", 1, "[repair_photo] show repairing");
        ViewGroup viewGroup = this.mLoadingContainer;
        com.qzone.reborn.repair.utils.aa aaVar = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        com.qzone.reborn.repair.utils.aa aaVar2 = this.mRepairAnimalManager;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepairAnimalManager");
            aaVar2 = null;
        }
        aaVar2.e();
        com.qzone.reborn.repair.utils.aa aaVar3 = this.mRepairAnimalManager;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepairAnimalManager");
        } else {
            aaVar = aaVar3;
        }
        aaVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingView() {
        QLog.d("QZonePhotoRepairLayerLoadingPart", 1, "[repair_photo] hide loading");
        ViewGroup viewGroup = this.mLoadingContainer;
        LottieAnimationView lottieAnimationView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        LottieAnimationView lottieAnimationView2 = this.mMaskLottieView;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskLottieView");
            lottieAnimationView2 = null;
        }
        lottieAnimationView2.setVisibility(8);
        LottieAnimationView lottieAnimationView3 = this.mStarLottieView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStarLottieView");
        } else {
            lottieAnimationView = lottieAnimationView3;
        }
        lottieAnimationView.setVisibility(8);
    }

    private final void D9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f162912na2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_layer_loading_container)");
        this.mLoadingContainer = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.na5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_layer_loading_text_area)");
        this.mLoadingTextArea = (ViewGroup) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162913na3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026epair_layer_loading_icon)");
        this.mLoadingIcon = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.na7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026repair_layer_lottie_view)");
        this.mStarLottieView = (LottieAnimationView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.na8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026r_layer_mask_lottie_view)");
        this.mMaskLottieView = (LottieAnimationView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.n_w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026ir_layer_begin_container)");
        this.mBeginContainer = (ViewGroup) findViewById6;
        ViewGroup viewGroup = this.mLoadingTextArea;
        LottieAnimationView lottieAnimationView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTextArea");
            viewGroup = null;
        }
        viewGroup.setPadding(0, G, 0, 0);
        ImageView imageView = this.mLoadingIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIcon");
            imageView = null;
        }
        ImageView imageView2 = this.mLoadingIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIcon");
            imageView2 = null;
        }
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView2.getContext(), 4));
        LottieAnimationView lottieAnimationView2 = this.mStarLottieView;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStarLottieView");
            lottieAnimationView2 = null;
        }
        LottieAnimationView lottieAnimationView3 = this.mMaskLottieView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskLottieView");
        } else {
            lottieAnimationView = lottieAnimationView3;
        }
        com.qzone.reborn.repair.utils.aa aaVar = new com.qzone.reborn.repair.utils.aa(lottieAnimationView2, lottieAnimationView);
        this.mRepairAnimalManager = aaVar;
        aaVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(Integer status) {
        if (status != null && status.intValue() == 0) {
            G9();
        } else if (status != null && status.intValue() == 1) {
            E9();
        } else {
            hideLoadingView();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerLoadingPart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.i("QZonePhotoRepairLayerLoadingPart", 1, "[onAnimationEnd] mask " + animator);
            QZonePhotoRepairLayerLoadingPart.this.hideLoadingView();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.i("QZonePhotoRepairLayerLoadingPart", 1, "[onAnimationStart] mask " + animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
