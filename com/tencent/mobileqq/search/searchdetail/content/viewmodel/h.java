package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import android.app.Activity;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.repo.LoadMoreType;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.kernel.nativeinterface.SearchChannelConditonFilter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/h;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "Landroid/app/Activity;", "context", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/g;", TransferConfig.ExtendParamFloats.KEY_RULE, "", ICustomDataEditor.STRING_ARRAY_PARAM_3, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/c;", "Y2", "", "keyword", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "refreshType", "source", "R2", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/LoadMoreType;", "loadMoreType", NowProxyConstants.AccountInfoKey.A2, "", "W", "Ljava/util/List;", "W2", "()Ljava/util/List;", "rankRules", "X", "V2", "contentRules", "Y", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/g;", "getSelectedRankRule", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/g;", "setSelectedRankRule", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/g;)V", "selectedRankRule", "Z", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/c;", "getSelectedContentRule", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/c;", "setSelectedContentRule", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/c;)V", "selectedContentRule", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends k {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final List<RankRule> rankRules;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final List<ContentRule> contentRules;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private RankRule selectedRankRule;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private ContentRule selectedContentRule;

    public h() {
        List<RankRule> listOf;
        List<ContentRule> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new RankRule[]{new RankRule("\u667a\u80fd\u6392\u5e8f", 1), new RankRule("\u70ed\u5ea6\u4f18\u5148", 2)});
        this.rankRules = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new ContentRule[]{new ContentRule("\u5168\u90e8\u5185\u5bb9", 1), new ContentRule("\u9891\u9053", 2), new ContentRule("\u5e16\u5b50", 3)});
        this.contentRules = listOf2;
        this.selectedRankRule = listOf.get(0);
        this.selectedContentRule = listOf2.get(0);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void A2(@NotNull String keyword, @NotNull LoadMoreType loadMoreType, @NotNull String source) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        Intrinsics.checkNotNullParameter(source, "source");
        SearchChannelConditonFilter searchChannelConditonFilter = new SearchChannelConditonFilter();
        searchChannelConditonFilter.rankType = this.selectedRankRule.getId();
        searchChannelConditonFilter.contentType = this.selectedContentRule.getId();
        e2(keyword, searchChannelConditonFilter, null, source, loadMoreType);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.viewmodel.k
    public void R2(@NotNull Activity context, @NotNull String keyword, @NotNull RefreshType refreshType, @NotNull String source) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        Intrinsics.checkNotNullParameter(source, "source");
        SearchChannelConditonFilter searchChannelConditonFilter = new SearchChannelConditonFilter();
        searchChannelConditonFilter.rankType = this.selectedRankRule.getId();
        searchChannelConditonFilter.contentType = this.selectedContentRule.getId();
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData != null) {
            z16 = pageData.getDisableCorrectionQuery();
        } else {
            z16 = false;
        }
        f2(context, keyword, z16, refreshType, searchChannelConditonFilter, null, source);
    }

    @NotNull
    public final List<ContentRule> V2() {
        return this.contentRules;
    }

    @NotNull
    public final List<RankRule> W2() {
        return this.rankRules;
    }

    public final void Y2(@NotNull Activity context, @NotNull ContentRule rule) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (rule.getId() == this.selectedContentRule.getId()) {
            return;
        }
        this.selectedContentRule = rule;
        Q2(ToastView.ICON_LOADING);
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        R2(context, str, RefreshType.TYPE_FINGER_PULL2REFRESH, "setContentRule");
    }

    public final void a3(@NotNull Activity context, @NotNull RankRule rule) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rule, "rule");
        if (rule.getId() == this.selectedRankRule.getId()) {
            return;
        }
        this.selectedRankRule = rule;
        Q2(ToastView.ICON_LOADING);
        SearchDetailTabContentFragment.PageData pageData = getPageData();
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        R2(context, str, RefreshType.TYPE_FINGER_PULL2REFRESH, "setRankRule");
    }
}
