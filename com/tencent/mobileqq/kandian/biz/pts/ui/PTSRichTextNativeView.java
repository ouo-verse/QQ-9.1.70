package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;

/* loaded from: classes33.dex */
public class PTSRichTextNativeView extends TextView implements IView {
    private TruncateAttr truncateAttr;

    public PTSRichTextNativeView(PTSNodeRichText pTSNodeRichText) {
        super(pTSNodeRichText.getContext());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        TruncateAttr truncateAttr = this.truncateAttr;
        if (truncateAttr != null) {
            RichTextUtils.addEllipsis2Text(this, truncateAttr);
            RichTextUtils.adjustImageSpan(this, this.truncateAttr);
        }
    }

    public void setTruncateAttr(TruncateAttr truncateAttr) {
        this.truncateAttr = truncateAttr;
    }

    public PTSRichTextNativeView(Context context) {
        super(context);
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
    }
}
