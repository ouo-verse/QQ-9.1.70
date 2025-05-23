package do2;

import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.w;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0017\u0010\u0014\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Ldo2/n;", "Lcom/tencent/mobileqq/search/model/x;", "Lcom/tencent/mobileqq/search/model/w;", "", "l", "", "Lcom/tencent/mobileqq/search/model/y;", "o", "Landroid/view/View;", "view", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "getItemCount", tl.h.F, "I", ReportConstant.COSTREPORT_PREFIX, "()I", IProfileCardConst.KEY_FROM_TYPE, "i", "Ljava/util/List;", "resultList", "Ljava/lang/String;", "keyword", BdhLogUtil.LogTag.Tag_Conn, "recallReason", "D", "t", "u", "(I)V", "resultListSize", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class n extends x implements w {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final String recallReason;

    /* renamed from: D, reason: from kotlin metadata */
    private int resultListSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int fromType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<? extends y> resultList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyword;

    public n(int i3, @NotNull List<? extends y> resultList, @NotNull String keyword, @Nullable String str) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.fromType = i3;
        this.resultList = resultList;
        this.keyword = keyword;
        this.recallReason = str;
        r(6);
        this.resultListSize = resultList.size();
    }

    @Override // com.tencent.mobileqq.search.model.w
    /* renamed from: getItemCount, reason: from getter */
    public int getResultListSize() {
        return this.resultListSize;
    }

    @Override // com.tencent.mobileqq.search.model.v
    @NotNull
    /* renamed from: h */
    public String getRecallReason() {
        boolean z16;
        String str = this.recallReason;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return this.recallReason;
        }
        String recallReason = super.getRecallReason();
        Intrinsics.checkNotNullExpressionValue(recallReason, "super.getRetRecallReason()");
        return recallReason;
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public String l() {
        return "\u8054\u7cfb\u4eba";
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    /* renamed from: m, reason: from getter */
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 3;
    }

    @Override // com.tencent.mobileqq.search.model.x
    @NotNull
    public List<y> o() {
        List<? extends y> list = this.resultList;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mobileqq.search.model.ISearchResultModel>");
        return TypeIntrinsics.asMutableList(list);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToNtContactSearchActivity(view.getContext(), this.keyword, this.fromType, 1);
        SearchUtils.c1(this.keyword, 20, 0, view);
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            SearchUtils.W0("all_result", "more_contact", this.keyword);
            SearchUtils.V0("search", "contact", "more", 0, 0, SearchUtils.b0(this.fromType));
            ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.fromType, "0X8009D39", 0, 0, null, null);
        }
    }

    /* renamed from: s, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    public final int t() {
        return this.resultListSize;
    }

    public final void u(int i3) {
        this.resultListSize = i3;
    }
}
