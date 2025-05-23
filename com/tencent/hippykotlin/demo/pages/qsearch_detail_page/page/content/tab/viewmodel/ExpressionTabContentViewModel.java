package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchLBSPermissionHelper;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchExpressionContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.kuikly.core.pager.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionTabContentViewModel extends QSearchTabContentViewModel {
    public ExpressionTabContentViewModel(UnifySearchTabInfo unifySearchTabInfo, g gVar, QSearchPagePerfReporter qSearchPagePerfReporter, QSearchLBSPermissionHelper qSearchLBSPermissionHelper, boolean z16) {
        super(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel
    public final QSearchContentNetRepo createContentNetRepo(g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        return new QSearchExpressionContentNetRepo(gVar.getAppVersion(), gVar, unifySearchTabInfo, z16);
    }
}
