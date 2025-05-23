package com.qzone.reborn.repair.part.layer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.layer.part.cq;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/ak;", "Lcom/qzone/reborn/layer/part/cq;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "", "clickPicCloseHost", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "e", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ak extends cq {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public boolean clickPicCloseHost() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r1.intValue() != 0) goto L22;
     */
    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getLoadingDrawable() {
        Context context = getContext();
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = null;
        Drawable drawable = context != null ? context.getDrawable(R.drawable.f162601b70) : null;
        if (drawable != null) {
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = this.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                qZonePhotoRepairLayerViewModel2 = null;
            }
            if (qZonePhotoRepairLayerViewModel2.getInitSrStatus() != null) {
                QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
                if (qZonePhotoRepairLayerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                } else {
                    qZonePhotoRepairLayerViewModel = qZonePhotoRepairLayerViewModel3;
                }
                Integer initSrStatus = qZonePhotoRepairLayerViewModel.getInitSrStatus();
                if (initSrStatus != null) {
                }
            }
            return drawable;
        }
        return super.getLoadingDrawable();
    }

    @Override // com.tencent.richframework.gallery.part.QQMediaStrategyPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
    }
}
