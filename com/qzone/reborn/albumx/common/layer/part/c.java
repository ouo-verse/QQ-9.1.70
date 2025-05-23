package com.qzone.reborn.albumx.common.layer.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/c;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", tl.h.F, "Landroid/view/View;", "D9", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "maskView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class c<T> extends i<T> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View maskView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: D9, reason: from getter */
    public final View getMaskView() {
        return this.maskView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(getContext()) + ViewUtils.dip2px(66.0f));
        View view = new View(getContext());
        this.maskView = view;
        view.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.awl));
        View view2 = this.maskView;
        if (view2 != null) {
            view2.setClickable(false);
        }
        View view3 = this.maskView;
        if (view3 != null) {
            view3.setEnabled(false);
        }
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.maskView, layoutParams);
    }
}
