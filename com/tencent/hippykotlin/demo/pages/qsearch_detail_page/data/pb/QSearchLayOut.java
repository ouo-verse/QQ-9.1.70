package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLayOut implements ISSOReqModel, ISSORspModel<QSearchLayOut> {
    public final float bottomCorner;
    public final String highlight;
    public final float marginTop;
    public final boolean showDivider;
    public final float topCorner;
    public final boolean useOneCard;

    public QSearchLayOut(String str, float f16, float f17, float f18, boolean z16, boolean z17) {
        this.highlight = str;
        this.marginTop = f16;
        this.topCorner = f17;
        this.bottomCorner = f18;
        this.showDivider = z16;
        this.useOneCard = z17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("highlight", this.highlight);
        eVar.v(LayoutAttrDefine.MARGIN_TOP, Float.valueOf(this.marginTop));
        eVar.v("top_corner", Float.valueOf(this.topCorner));
        eVar.v("bottom_corner", Float.valueOf(this.bottomCorner));
        eVar.w("show_divider", this.showDivider);
        eVar.w("use_one_card", this.useOneCard);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchLayOut decode(e eVar) {
        return new QSearchLayOut(eVar.q("highlight", ""), (float) eVar.i(LayoutAttrDefine.MARGIN_TOP, 0.0d), (float) eVar.i("top_corner", 0.0d), (float) eVar.i("bottom_corner", 0.0d), eVar.g("show_divider", false), eVar.g("use_one_card", false));
    }
}
