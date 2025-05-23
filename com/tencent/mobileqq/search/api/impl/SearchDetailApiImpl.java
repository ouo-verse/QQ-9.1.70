package com.tencent.mobileqq.search.api.impl;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.search.api.ISearchDetailApi;
import com.tencent.mobileqq.search.searchdetail.content.model.g;
import com.tencent.mobileqq.search.searchdetail.content.repo.SearchDetailTabContentRepo;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchMiniAppDetailView;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchTemplateTitleView;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppExposeReportManager;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.SearchWXMiniAppStayReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/api/impl/SearchDetailApiImpl;", "Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "Lkn2/c;", "createSearchNetContentRepo", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lqp2/b;", "ioc", "Lqp2/c;", "createSearchMiniAppReportManager", "", "keyword", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "tabMask", "sessionId", "searchId", "parentSearchId", "Lqp2/d;", "createSearchMiniAppStayReportManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Lsp2/b;", "createTemplateTitleView", "Lsp2/c;", "createMinAppView", "Lcom/tencent/mobileqq/search/searchdetail/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lqp2/a;", "getBackEndReportFromItem", "Lcom/tencent/mobileqq/search/searchdetail/c;", "totalCountWithoutTitle", "", "setWithoutTitlePosition", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailApiImpl implements ISearchDetailApi {
    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @NotNull
    public sp2.c createMinAppView(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new QSearchMiniAppDetailView(context, attrs);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @NotNull
    public qp2.c createSearchMiniAppReportManager(@NotNull RecyclerView recyclerView, @NotNull qp2.b ioc) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(ioc, "ioc");
        return new SearchWXMiniAppExposeReportManager(recyclerView, ioc);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @NotNull
    public qp2.d createSearchMiniAppStayReportManager(@NotNull String keyword, int querySource, int tabMask, @NotNull String sessionId, @NotNull String searchId, @NotNull String parentSearchId) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(parentSearchId, "parentSearchId");
        return new SearchWXMiniAppStayReportManager(keyword, querySource, tabMask, sessionId, searchId, parentSearchId);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @NotNull
    public kn2.c createSearchNetContentRepo() {
        return new SearchDetailTabContentRepo();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @NotNull
    public sp2.b createTemplateTitleView(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new QSearchTemplateTitleView(context, attrs);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    @Nullable
    public qp2.a getBackEndReportFromItem(@NotNull com.tencent.mobileqq.search.searchdetail.a item) {
        com.tencent.mobileqq.search.searchdetail.content.wxminapp.b bVar;
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) {
            bVar = (com.tencent.mobileqq.search.searchdetail.content.wxminapp.b) item;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        return bVar.getBackEndReportInfo();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchDetailApi
    public void setWithoutTitlePosition(@NotNull com.tencent.mobileqq.search.searchdetail.c item, int totalCountWithoutTitle) {
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar;
        JSONObject jsonReportInfo;
        Intrinsics.checkNotNullParameter(item, "item");
        Integer num = null;
        if (item instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a) {
            aVar = (com.tencent.mobileqq.search.searchdetail.content.template.model.a) item;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            g reportInfoWrapper = aVar.getReportInfoWrapper();
            if (reportInfoWrapper != null && (jsonReportInfo = reportInfoWrapper.getJsonReportInfo()) != null) {
                num = Integer.valueOf(jsonReportInfo.optInt("serial_number", -1));
            }
            if (num != null && num.intValue() != -1) {
                aVar.o(totalCountWithoutTitle + num.intValue());
            }
        }
    }
}
