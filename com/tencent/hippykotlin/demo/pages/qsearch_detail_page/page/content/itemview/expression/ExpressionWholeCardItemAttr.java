package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.expression;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemAttr;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionWholeCardItemAttr extends QSearchBaseWholeCardItemAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ExpressionWholeCardItemAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0)};
    public ExpressionItemModel data;
    public int lineIndex;
    public String keyword = "";
    public String traceId = "";
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
}
