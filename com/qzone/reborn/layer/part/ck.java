package com.qzone.reborn.layer.part;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/layer/part/ck;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/layer/route/QZoneLocalLayerExtraInfoBean;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "onLayerStateUpdate", "i", "Landroid/view/View;", "headerView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "indicatorTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ck extends com.qzone.reborn.albumx.common.layer.part.c<QZoneLocalLayerExtraInfoBean> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView indicatorTv;

    private final String F9(RFWLayerState layerState) {
        return B9(layerState) + "/" + C9(layerState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(ck this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            this$0.getActivity().onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cfm, (ViewGroup) null);
        this.headerView = inflate;
        this.indicatorTv = inflate != null ? (TextView) inflate.findViewById(R.id.nm5) : null;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.headerView, layoutParams);
        View view = this.headerView;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.n0j) : null;
        fo.c.n(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.cj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ck.G9(ck.this, view2);
                }
            });
        }
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        View view = this.headerView;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.indicatorTv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.indicatorTv;
        if (textView2 == null) {
            return;
        }
        textView2.setText(F9(layerState));
    }
}
