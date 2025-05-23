package com.qzone.reborn.repair.part.layer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/s;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "", "initViewModel", "z9", "", "x9", "", "", "D6", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "d", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class s extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    private final Map<String, Object> D6() {
        Intent intent;
        HashMap hashMap = new HashMap();
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(intent.getIntExtra(PictureConst.PARAM_FROM, 0)));
        }
        return hashMap;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    private final String x9() {
        return "pg_qz_pic_preview";
    }

    private final void z9() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getPartRootView(), x9());
        VideoReport.setPageParams(getPartRootView(), new fo.a().d("QZonePhotoRepairLayerReportPart", D6()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        z9();
    }
}
