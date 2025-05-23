package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchLBSPermissionHelper;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchGuildContentNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.kuikly.core.pager.g;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGuildTabContentViewModel extends QSearchTabContentViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchGuildTabContentViewModel.class, "selectedRankRule", "getSelectedRankRule()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/RankRule;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchGuildTabContentViewModel.class, "selectedContentRule", "getSelectedContentRule()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/tab/viewmodel/ContentRule;", 0)};
    public final List<ContentRule> contentRules;
    public final List<RankRule> rankRules;
    public final ReadWriteProperty selectedContentRule$delegate;
    public final ReadWriteProperty selectedRankRule$delegate;

    public QSearchGuildTabContentViewModel(UnifySearchTabInfo unifySearchTabInfo, g gVar, QSearchPagePerfReporter qSearchPagePerfReporter, QSearchLBSPermissionHelper qSearchLBSPermissionHelper, boolean z16) {
        super(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
        List<RankRule> listOf;
        List<ContentRule> listOf2;
        Object first;
        Object first2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RankRule[]{new RankRule("\u667a\u80fd\u6392\u5e8f", 1), new RankRule("\u70ed\u5ea6\u4f18\u5148", 2)});
        this.rankRules = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new ContentRule[]{new ContentRule("\u5168\u90e8\u5185\u5bb9", 1), new ContentRule("\u9891\u9053", 2), new ContentRule("\u5e16\u5b50", 3)});
        this.contentRules = listOf2;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) listOf);
        this.selectedRankRule$delegate = c.a(first);
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) listOf2);
        this.selectedContentRule$delegate = c.a(first2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel
    public final QSearchContentNetRepo createContentNetRepo(g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        return new QSearchGuildContentNetRepo(gVar, unifySearchTabInfo, z16);
    }

    public final ContentRule getSelectedContentRule() {
        return (ContentRule) this.selectedContentRule$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final RankRule getSelectedRankRule() {
        return (RankRule) this.selectedRankRule$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel
    public final void loadData(String str, int i3, boolean z16, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        a aVar = new a(getSelectedRankRule().f114296id, getSelectedContentRule().f114293id, 4);
        QSearchContentNetRepo qSearchContentNetRepo = this.repo;
        Intrinsics.checkNotNull(qSearchContentNetRepo, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchGuildContentNetRepo");
        if (Intrinsics.areEqual(aVar, ((QSearchGuildContentNetRepo) qSearchContentNetRepo).conditionFilter) && Intrinsics.areEqual(str, this.keyword) && Intrinsics.areEqual(getListState(), RefreshListState.Loading.INSTANCE)) {
            return;
        }
        QSearchContentNetRepo qSearchContentNetRepo2 = this.repo;
        Intrinsics.checkNotNull(qSearchContentNetRepo2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchGuildContentNetRepo");
        ((QSearchGuildContentNetRepo) qSearchContentNetRepo2).conditionFilter = aVar;
        this.querySource = i3;
        if (str.length() == 0) {
            this.keyword = "";
            reset();
        } else {
            if (!Intrinsics.areEqual(this.keyword, str)) {
                reset();
            }
            this.keyword = str;
            innerLoadData(function2);
        }
    }
}
