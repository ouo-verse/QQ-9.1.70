package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB#\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "ptsLiteEventListener", "", "b", "Lcom/tencent/pts/core/itemview/PTSItemView;", "d", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "e", "Landroid/widget/LinearLayout;", "ptsItemViewContainer", "f", "a", "()Landroid/widget/LinearLayout;", "setCustomViewContainer", "(Landroid/widget/LinearLayout;)V", "customViewContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECBasePtsView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PTSItemView ptsItemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout ptsItemViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout customViewContainer;

    public ECBasePtsView(Context context) {
        super(context);
        this.ptsItemView = new PTSItemView(getContext());
        this.ptsItemViewContainer = new LinearLayout(getContext());
        this.customViewContainer = new LinearLayout(getContext());
        this.ptsItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setOrientation(1);
        addView(this.ptsItemViewContainer);
        addView(this.customViewContainer);
        this.ptsItemViewContainer.addView(this.ptsItemView);
    }

    /* renamed from: a, reason: from getter */
    public final LinearLayout getCustomViewContainer() {
        return this.customViewContainer;
    }

    public final void b(PTSComposer ptsComposer, IPTSLiteEventListener ptsLiteEventListener) {
        if (TextUtils.isEmpty(ptsComposer.getPageName())) {
            cg0.a.b("ECBaseView", "[refresh] failed, newPageName is null");
            return;
        }
        this.ptsItemViewContainer.removeView(this.ptsItemView);
        PTSItemView pTSItemView = new PTSItemView(getContext());
        pTSItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.ptsItemViewContainer.addView(pTSItemView);
        this.ptsItemView = pTSItemView;
        ptsComposer.layoutToView(pTSItemView, ptsLiteEventListener);
    }

    public final void setCustomViewContainer(LinearLayout linearLayout) {
        this.customViewContainer = linearLayout;
    }

    public ECBasePtsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ptsItemView = new PTSItemView(getContext());
        this.ptsItemViewContainer = new LinearLayout(getContext());
        this.customViewContainer = new LinearLayout(getContext());
        this.ptsItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setOrientation(1);
        addView(this.ptsItemViewContainer);
        addView(this.customViewContainer);
        this.ptsItemViewContainer.addView(this.ptsItemView);
    }

    public ECBasePtsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.ptsItemView = new PTSItemView(getContext());
        this.ptsItemViewContainer = new LinearLayout(getContext());
        this.customViewContainer = new LinearLayout(getContext());
        this.ptsItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setOrientation(1);
        addView(this.ptsItemViewContainer);
        addView(this.customViewContainer);
        this.ptsItemViewContainer.addView(this.ptsItemView);
    }
}
