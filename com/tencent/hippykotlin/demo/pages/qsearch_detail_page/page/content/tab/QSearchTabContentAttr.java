package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import c01.c;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTabContentAttr extends QSearchReportAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, "currentTabIndex", "getCurrentTabIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, "keyword", "getKeyword()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "getQuerySource()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, "muted", "getMuted()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchTabContentAttr.class, "pageWidth", "getPageWidth()D", 0)};
    public Function1<? super ScrollParams, Unit> dragBeginHandler;
    public int index;
    public QSearchTabContentViewModel viewModel;
    public final ReadWriteProperty currentTabIndex$delegate = c.a(0);
    public final ReadWriteProperty keyword$delegate = c.a("");
    public final ReadWriteProperty querySource$delegate = c.a(2);
    public final ReadWriteProperty muted$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
    public final ReadWriteProperty pageWidth$delegate = c.a(Double.valueOf(0.0d));

    public final int getCurrentTabIndex() {
        return ((Number) this.currentTabIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final String getKeyword() {
        return (String) this.keyword$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean getMuted() {
        return ((Boolean) this.muted$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final PageStatus getPageStatus() {
        return (PageStatus) this.pageStatus$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final int getQuerySource() {
        return ((Number) this.querySource$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final QSearchTabContentViewModel getViewModel() {
        QSearchTabContentViewModel qSearchTabContentViewModel = this.viewModel;
        if (qSearchTabContentViewModel != null) {
            return qSearchTabContentViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
