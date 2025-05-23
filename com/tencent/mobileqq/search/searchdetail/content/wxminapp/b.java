package com.tencent.mobileqq.search.searchdetail.content.wxminapp;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.model.SearchNetLabel;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.j;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchLabel;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/b;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel;", HippyTKDListViewAdapter.X, "", "getItemType", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "getTemplate", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppDetail;", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppDetail;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppDetail;", "miniAppDetail", "I", "Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/List;", "setTopLabelList", "(Ljava/util/List;)V", "topLabelList", "Lqp2/a;", "J", "Lqp2/a;", "y", "()Lqp2/a;", "backEndReportInfo", "K", "Ljava/lang/String;", "getConditionFilterType", "()Ljava/lang/String;", "B", "(Ljava/lang/String;)V", "conditionFilterType", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "L", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends com.tencent.mobileqq.search.searchdetail.content.template.model.a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchTemplate template;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SearchMiniAppDetail miniAppDetail;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<SearchNetLabel> topLabelList;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final qp2.a backEndReportInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String conditionFilterType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        this.template = template;
        SearchMiniAppDetail searchMiniAppDetail = template.miniAppDetail;
        this.miniAppDetail = searchMiniAppDetail == null ? new SearchMiniAppDetail() : searchMiniAppDetail;
        this.topLabelList = x();
        this.backEndReportInfo = j.k(this);
        this.conditionFilterType = IProfileCardConst.NAME_NO_LIMIT;
    }

    private final List<SearchNetLabel> x() {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        ArrayList<SearchLabel> arrayList2 = this.miniAppDetail.gameLabelList;
        if (arrayList2 != null) {
            ArrayList<SearchLabel> arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                SearchLabel searchLabel = (SearchLabel) obj;
                SearchText searchText = searchLabel.text;
                String str3 = null;
                if (searchText != null) {
                    str = searchText.text;
                } else {
                    str = null;
                }
                boolean z18 = false;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                boolean z19 = !z16;
                SearchIcon searchIcon = searchLabel.icon;
                if (searchIcon != null) {
                    str2 = searchIcon.iconLink;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                boolean z26 = z19 | (!z17);
                SearchIcon searchIcon2 = searchLabel.icon;
                if (searchIcon2 != null) {
                    str3 = searchIcon2.iconToken;
                }
                if (str3 == null || str3.length() == 0) {
                    z18 = true;
                }
                if ((!z18) | z26) {
                    arrayList3.add(obj);
                }
            }
            for (SearchLabel it : arrayList3) {
                SearchNetLabel.Companion companion = SearchNetLabel.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(companion.a(it));
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<SearchNetLabel> A() {
        return this.topLabelList;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.conditionFilterType = str;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 22;
    }

    @NotNull
    public String toString() {
        SearchMiniAppDetail searchMiniAppDetail = this.miniAppDetail;
        return "NetSearchTemplateMiniAppDetailItem miniAppType=" + searchMiniAppDetail.miniAppType + " title=" + searchMiniAppDetail.title;
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final qp2.a getBackEndReportInfo() {
        return this.backEndReportInfo;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final SearchMiniAppDetail getMiniAppDetail() {
        return this.miniAppDetail;
    }
}
