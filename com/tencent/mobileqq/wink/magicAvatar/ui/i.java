package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/i;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "close", "f", "Landroid/view/View;", "save", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarCropViewModel magicCropVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView close;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View save;

    public i(@NotNull MagicAvatarCropViewModel magicCropVm) {
        Intrinsics.checkNotNullParameter(magicCropVm, "magicCropVm");
        this.magicCropVm = magicCropVm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(i this$0, View view) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.magicCropVm.p2()) {
            this$0.C9();
            this$0.magicCropVm.V2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C9() {
        String str;
        MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
        View view = this.save;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            view = null;
        }
        magicAvatarDataSource.e(view, "em_xsj_save_button");
        View view3 = this.save;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            view3 = null;
        }
        VideoReport.setElementId(view3, "em_xsj_save_button");
        View view4 = this.save;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_NONE);
        View view5 = this.save;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            view5 = null;
        }
        VideoReport.setElementExposePolicy(view5, ExposurePolicy.REPORT_NONE);
        View view6 = this.save;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
            view6 = null;
        }
        VideoReport.setElementEndExposePolicy(view6, EndExposurePolicy.REPORT_NONE);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        MagicAvatarMaterialInfo currentSelectMaterial = this.magicCropVm.getCurrentSelectMaterial();
        if (currentSelectMaterial != null) {
            str = currentSelectMaterial.getStyleName();
        } else {
            str = null;
        }
        reportMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
        View view7 = this.save;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
        } else {
            view2 = view7;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view2, reportMap);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.close)");
        this.close = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f794249q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.save_qr)");
        this.save = findViewById2;
        ImageView imageView = this.close;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.A9(i.this, view2);
            }
        });
        View view2 = this.save;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("save");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                i.B9(i.this, view3);
            }
        });
    }
}
