package com.tencent.mobileqq.search.api;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp2.d;
import sp2.b;
import sp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH&J\u001c\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u001c\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH&J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH&\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchDetailApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lkn2/c;", "createSearchNetContentRepo", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lqp2/b;", "ioc", "Lqp2/c;", "createSearchMiniAppReportManager", "", "keyword", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "tabMask", "sessionId", "searchId", "parentSearchId", "Lqp2/d;", "createSearchMiniAppStayReportManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "Lsp2/b;", "createTemplateTitleView", "Lsp2/c;", "createMinAppView", "Lcom/tencent/mobileqq/search/searchdetail/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lqp2/a;", "getBackEndReportFromItem", "Lcom/tencent/mobileqq/search/searchdetail/c;", "totalCountWithoutTitle", "", "setWithoutTitlePosition", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchDetailApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        public static /* synthetic */ c a(ISearchDetailApi iSearchDetailApi, Context context, AttributeSet attributeSet, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    attributeSet = null;
                }
                return iSearchDetailApi.createMinAppView(context, attributeSet);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMinAppView");
        }

        public static /* synthetic */ b b(ISearchDetailApi iSearchDetailApi, Context context, AttributeSet attributeSet, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    attributeSet = null;
                }
                return iSearchDetailApi.createTemplateTitleView(context, attributeSet);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTemplateTitleView");
        }
    }

    @NotNull
    c createMinAppView(@NotNull Context context, @Nullable AttributeSet attrs);

    @NotNull
    qp2.c createSearchMiniAppReportManager(@NotNull RecyclerView recyclerView, @NotNull qp2.b ioc);

    @NotNull
    d createSearchMiniAppStayReportManager(@NotNull String keyword, int querySource, int tabMask, @NotNull String sessionId, @NotNull String searchId, @NotNull String parentSearchId);

    @NotNull
    kn2.c createSearchNetContentRepo();

    @NotNull
    b createTemplateTitleView(@NotNull Context context, @Nullable AttributeSet attrs);

    @Nullable
    qp2.a getBackEndReportFromItem(@NotNull com.tencent.mobileqq.search.searchdetail.a item);

    void setWithoutTitlePosition(@NotNull com.tencent.mobileqq.search.searchdetail.c item, int totalCountWithoutTitle);
}
