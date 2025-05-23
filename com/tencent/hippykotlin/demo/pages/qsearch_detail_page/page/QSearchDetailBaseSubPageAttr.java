package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public class QSearchDetailBaseSubPageAttr extends QSearchReportAttr {
    public QSearchDetailViewModel viewModel;

    public final QSearchDetailViewModel getViewModel() {
        QSearchDetailViewModel qSearchDetailViewModel = this.viewModel;
        if (qSearchDetailViewModel != null) {
            return qSearchDetailViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
