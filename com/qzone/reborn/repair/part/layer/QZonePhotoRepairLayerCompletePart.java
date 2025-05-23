package com.qzone.reborn.repair.part.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/repair/part/layer/QZonePhotoRepairLayerCompletePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "B9", "initViewModel", "", "status", "C9", "(Ljava/lang/Integer;)V", "onInitView", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "mCompleteContainer", "e", "mContrastOriginArea", "f", "mBeginContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mMoreView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "i", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairLayerCompletePart extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mCompleteContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContrastOriginArea;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mBeginContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mMoreView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(Integer status) {
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        boolean u26 = QZonePhotoRepairLayerViewModel.u2(qZonePhotoRepairLayerViewModel, null, 1, null);
        ViewGroup viewGroup = this.mCompleteContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCompleteContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(u26 ? 0 : 8);
        ImageView imageView = this.mMoreView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
            imageView = null;
        }
        imageView.setVisibility(u26 ? 0 : 8);
        ViewGroup viewGroup2 = this.mContrastOriginArea;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastOriginArea");
            viewGroup2 = null;
        }
        viewGroup2.setVisibility(u26 ? 0 : 8);
        if (u26) {
            QLog.d("QZonePhotoRepairLayerCompletePart", 1, "[repair_photo] end repair " + status);
            ViewGroup viewGroup3 = this.mBeginContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBeginContainer");
                viewGroup3 = null;
            }
            viewGroup3.setVisibility(8);
            xn.c cVar = (xn.c) RFWIocAbilityProvider.g().getIocInterface(xn.c.class, getPartRootView(), null);
            if (cVar != null) {
                cVar.d9(true);
            }
        }
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
        final Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit> function1 = new Function1<QZonePhotoRepairLayerViewModel.Companion.RepairStatusData, Unit>() { // from class: com.qzone.reborn.repair.part.layer.QZonePhotoRepairLayerCompletePart$initViewModel$1
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
                QZonePhotoRepairLayerCompletePart.this.C9(repairStatusData.getStatus());
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.repair.part.layer.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairLayerCompletePart.A9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        B9(rootView);
        initViewModel();
    }

    private final void B9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n_y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026layer_complete_container)");
        this.mCompleteContainer = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.na9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026e_repair_layer_more_icon)");
        this.mMoreView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n_z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026yer_contrast_origin_area)");
        this.mContrastOriginArea = (ViewGroup) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.n_w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ir_layer_begin_container)");
        this.mBeginContainer = (ViewGroup) findViewById4;
    }
}
