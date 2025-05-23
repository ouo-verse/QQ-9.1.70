package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionTitleMoreCardItemAttr extends QSearchBaseTitleMoreCardItemAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExpressionTitleMoreCardItemAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0)};
    public ExpressionCardItemModel data;
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);

    public final ExpressionCardItemModel getData() {
        ExpressionCardItemModel expressionCardItemModel = this.data;
        if (expressionCardItemModel != null) {
            return expressionCardItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
