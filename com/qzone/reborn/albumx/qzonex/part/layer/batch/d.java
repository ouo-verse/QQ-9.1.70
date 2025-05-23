package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/d;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "D9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", tl.h.F, "Landroid/view/View;", "footerView", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "rvSelectedMedia", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "flBottomOperateContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btnConfirm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends com.qzone.reborn.albumx.qzonex.part.layer.b {

    /* renamed from: C, reason: from kotlin metadata */
    private QUIButton btnConfirm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rvSelectedMedia;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flBottomOperateContainer;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        E9(rootView);
        D9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
    }

    private final void E9(View rootView) {
        if (rootView == null) {
            return;
        }
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f128663z, (ViewGroup) null);
        this.footerView = inflate;
        this.rvSelectedMedia = inflate != null ? (RecyclerView) inflate.findViewById(R.id.nf_) : null;
        View view = this.footerView;
        this.flBottomOperateContainer = view != null ? (FrameLayout) view.findViewById(R.id.f19305b) : null;
        View view2 = this.footerView;
        this.btnConfirm = view2 != null ? (QUIButton) view2.findViewById(R.id.f19495u) : null;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        View view3 = this.footerView;
        if (view3 != null) {
            view3.setClickable(false);
        }
        View view4 = this.footerView;
        if (view4 != null) {
            view4.setEnabled(false);
        }
        ((ViewGroup) rootView).addView(this.footerView, layoutParams);
    }

    private final void D9() {
    }
}
