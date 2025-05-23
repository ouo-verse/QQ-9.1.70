package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/f;", "Lcom/qzone/reborn/layer/part/o;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "P9", "Landroid/os/Bundle;", "data", "", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLayerStateUpdate", "H", "Landroid/view/View;", "mHeaderView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mBackIv", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "mNameTv", "K", "mIndicatorTv", "L", "mDataTv", "M", "Ljava/lang/String;", "mDisplayName", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends com.qzone.reborn.layer.part.o {

    /* renamed from: H, reason: from kotlin metadata */
    private View mHeaderView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mBackIv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mNameTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mIndicatorTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mDataTv;

    /* renamed from: M, reason: from kotlin metadata */
    private String mDisplayName = "";

    private final String P9(RFWLayerState layerState) {
        return "(" + C9(layerState) + "/" + D9(layerState) + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        String string = data != null ? data.getString("key_display_name") : null;
        if (string == null) {
            string = "";
        }
        this.mDisplayName = string;
    }

    @Override // com.qzone.reborn.layer.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        TextView textView = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.clh, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context).i\u2026lbum_header_layout, null)");
        this.mHeaderView = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            View view = this.mHeaderView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderView");
                view = null;
            }
            viewGroup.addView(view, layoutParams);
        }
        View view2 = this.mHeaderView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderView");
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.mnn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mHeaderView.findViewById\u2026_album_layer_header_back)");
        this.mBackIv = (ImageView) findViewById;
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView = this.mBackIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackIv");
            imageView = null;
        }
        a16.m(imageView, -1);
        ImageView imageView2 = this.mBackIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackIv");
            imageView2 = null;
        }
        AccessibilityUtil.s(imageView2, com.qzone.util.l.a(R.string.f2201668d));
        ImageView imageView3 = this.mBackIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackIv");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                f.Q9(f.this, view3);
            }
        });
        View view3 = this.mHeaderView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.mnr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mHeaderView.findViewById\u2026_album_layer_header_name)");
        this.mNameTv = (TextView) findViewById2;
        View view4 = this.mHeaderView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.mnq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mHeaderView.findViewById\u2026m_layer_header_indicator)");
        this.mIndicatorTv = (TextView) findViewById3;
        View view5 = this.mHeaderView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderView");
            view5 = null;
        }
        View findViewById4 = view5.findViewById(R.id.mnp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mHeaderView.findViewById\u2026_album_layer_header_date)");
        TextView textView2 = (TextView) findViewById4;
        this.mDataTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDataTv");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        TextView textView = this.mNameTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
            textView = null;
        }
        textView.setText(this.mDisplayName);
        TextView textView3 = this.mIndicatorTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndicatorTv");
        } else {
            textView2 = textView3;
        }
        textView2.setText(P9(layerState));
    }
}
