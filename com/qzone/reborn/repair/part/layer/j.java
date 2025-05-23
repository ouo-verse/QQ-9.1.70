package com.qzone.reborn.repair.part.layer;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/j;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "z9", "D9", "initViewModel", "Landroid/view/MotionEvent;", "event", "", "C9", "isPressed", "B9", "A9", "onInitView", "d", "Landroid/view/View;", "mContrastView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContrastOriginArea", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mOriginTextView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mContrastOriginIcon", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "i", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mContrastView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContrastOriginArea;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mOriginTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mContrastOriginIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    private final void A9() {
        ImageView imageView = this.mContrastOriginIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastOriginIcon");
            imageView = null;
        }
        fo.c.b("dt_clck", imageView, "em_qz_original_compare", null);
    }

    private final void B9(boolean isPressed) {
        RFWLog.d("QZonePhotoRepairLayerContrastPicPart", RFWLog.USR, "[handleContrastOriginPic] isPressed: " + isPressed);
        ViewGroup viewGroup = this.mContrastOriginArea;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastOriginArea");
            viewGroup = null;
        }
        viewGroup.setBackgroundResource(isPressed ? R.drawable.f16275w : R.drawable.f16285x);
        TextView textView = this.mOriginTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOriginTextView");
            textView = null;
        }
        textView.setVisibility(isPressed ? 0 : 8);
        xn.c cVar = (xn.c) RFWIocAbilityProvider.g().getIocInterface(xn.c.class, getPartRootView(), null);
        if (cVar != null) {
            cVar.d9(!isPressed);
        }
        if (isPressed) {
            A9();
        }
    }

    private final boolean C9(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            B9(true);
        } else if (action == 1) {
            B9(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E9(j this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(event, "event");
        return this$0.C9(event);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    private final void z9(View rootView) {
        View view = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f167311cn0, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context)\n \u2026ayer_center_layout, null)");
        this.mContrastView = inflate;
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.mContrastView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastView");
        } else {
            view = view2;
        }
        viewGroup.addView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        z9(rootView);
        D9(rootView);
        initViewModel();
    }

    private final void D9(View rootView) {
        View findViewById = rootView.findViewById(R.id.n_z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026yer_contrast_origin_area)");
        this.mContrastOriginArea = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.naa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026repair_layer_origin_text)");
        this.mOriginTextView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162910na0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026yer_contrast_origin_icon)");
        this.mContrastOriginIcon = (ImageView) findViewById3;
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView = this.mContrastOriginIcon;
        ViewGroup viewGroup = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastOriginIcon");
            imageView = null;
        }
        a16.m(imageView, getContext().getColor(R.color.qui_common_text_allwhite_primary));
        ViewGroup viewGroup2 = this.mContrastOriginArea;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContrastOriginArea");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.repair.part.layer.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean E9;
                E9 = j.E9(j.this, view, motionEvent);
                return E9;
            }
        });
    }
}
