package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseAnimControlItemAttr;
import com.tencent.kuikly.core.base.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionItemAttr extends QSearchBaseAnimControlItemAttr {
    public ExpressionCardItemModel data;
    public ExpressionInfo expressionInfo;
    public int index;
    public boolean isInGroup;
    public String keyword = "";
    public String traceId = "";
    public w size = new w(69.0f, 69.0f);
    public float borderRadius = 4.0f;

    public final ExpressionInfo getExpressionInfo() {
        ExpressionInfo expressionInfo = this.expressionInfo;
        if (expressionInfo != null) {
            return expressionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("expressionInfo");
        return null;
    }
}
