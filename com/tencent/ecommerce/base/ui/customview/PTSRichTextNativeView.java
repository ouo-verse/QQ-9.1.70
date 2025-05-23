package com.tencent.ecommerce.base.ui.customview;

import android.content.Context;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;

/* loaded from: classes5.dex */
public class PTSRichTextNativeView extends TextView implements IView {

    /* renamed from: d, reason: collision with root package name */
    private TruncateAttr f101149d;

    public PTSRichTextNativeView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        TruncateAttr truncateAttr = this.f101149d;
        if (truncateAttr != null) {
            RichTextUtils.addEllipsis2Text(this, truncateAttr);
            RichTextUtils.adjustImageSpan(this, this.f101149d);
        }
    }

    public void setTruncateAttr(TruncateAttr truncateAttr) {
        this.f101149d = truncateAttr;
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
    }
}
