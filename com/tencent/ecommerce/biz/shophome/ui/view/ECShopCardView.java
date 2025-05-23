package com.tencent.ecommerce.biz.shophome.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import cg0.a;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;", "Landroidx/cardview/widget/CardView;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "ptsLiteEventListener", "", "g", "Lcom/tencent/pts/core/itemview/PTSItemView;", "d", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "Landroid/content/Context;", "context", "", "radius", "<init>", "(Landroid/content/Context;F)V", "e", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopCardView extends CardView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PTSItemView ptsItemView;

    public ECShopCardView(Context context, float f16) {
        super(context);
        this.ptsItemView = new PTSItemView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setRadius(f16);
        setElevation(0.0f);
    }

    public final void g(PTSComposer ptsComposer, IPTSLiteEventListener ptsLiteEventListener) {
        if (TextUtils.isEmpty(ptsComposer.getPageName())) {
            a.b("ECShopCardView", "[refresh] failed, newPageName is null");
            return;
        }
        removeView(this.ptsItemView);
        PTSItemView pTSItemView = new PTSItemView(getContext());
        pTSItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(pTSItemView);
        this.ptsItemView = pTSItemView;
        if (ptsLiteEventListener != null) {
            ptsComposer.layoutToView(pTSItemView, ptsLiteEventListener);
        } else {
            ptsComposer.layoutToView(pTSItemView);
        }
    }

    public static /* synthetic */ void h(ECShopCardView eCShopCardView, PTSComposer pTSComposer, IPTSLiteEventListener iPTSLiteEventListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iPTSLiteEventListener = null;
        }
        eCShopCardView.g(pTSComposer, iPTSLiteEventListener);
    }
}
