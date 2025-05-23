package com.tencent.mobileqq.search.searchdetail.content.model;

import android.graphics.Color;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchLabel;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0002\t8By\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0015\u0010!R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b'\u0010\u0013R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b#\u0010\u0011\"\u0004\b)\u0010\u0013R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R$\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010-\u001a\u0004\b&\u0010.\"\u0004\b/\u00100R\u0019\u00105\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u00103\u001a\u0004\b\u000e\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "text", "b", "I", "i", "()I", "o", "(I)V", "textColor", "c", "k", "bgColor", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$LabelType;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$LabelType;", "j", "()Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$LabelType;", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "f", "getGender", "gender", "g", "l", NodeProps.MARGIN_LEFT, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.MARGIN_RIGHT, "layoutType", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;)V", "searchTextEntity", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "dataReport", "<init>", "(Ljava/lang/String;IILcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$LabelType;Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;IIIILcom/tencent/qqnt/kernel/nativeinterface/SearchText;Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", "LabelType", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class SearchNetLabel {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int textColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int bgColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LabelType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchIcon icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gender;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int marginLeft;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int marginRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int layoutType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private SearchText searchTextEntity;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SearchReportInfo dataReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$LabelType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "TYPE_CONTACT", "TYPE_MEMBER_COUNT", "TYPE_LABEL", "TYPE_TEMPLATE", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public enum LabelType {
        TYPE_CONTACT(-1),
        TYPE_MEMBER_COUNT(1),
        TYPE_LABEL(3),
        TYPE_TEMPLATE(4);

        private final int type;

        LabelType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLabel;", "it", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel;", "a", "", "GENDER_FEMALE", "I", "GENDER_MALE", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.model.SearchNetLabel$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchNetLabel a(@NotNull SearchLabel it) {
            String str;
            String str2;
            int color;
            Intrinsics.checkNotNullParameter(it, "it");
            SearchText searchText = it.text;
            if (searchText != null) {
                str = searchText.text;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            int i3 = 0;
            int i16 = 0;
            SearchNetLabel searchNetLabel = new SearchNetLabel(str, i3, i16, LabelType.TYPE_TEMPLATE, it.icon, 0, 0, 0, it.layout, null, it.reportInfo, ExpMgrListProcessor.CONFIG_ID, null);
            int i17 = it.layout;
            if (i17 != 2) {
                if (i17 != 4) {
                    searchNetLabel.o(BaseApplication.getContext().getColor(R.color.qui_common_text_secondary));
                    searchNetLabel.k(BaseApplication.getContext().getColor(R.color.qui_common_fill_standard_primary));
                } else {
                    SearchText text = it.text;
                    if (text != null) {
                        h hVar = h.f283924a;
                        Intrinsics.checkNotNullExpressionValue(text, "text");
                        Integer a16 = hVar.a(text);
                        if (a16 != null) {
                            color = a16.intValue();
                            searchNetLabel.o(color);
                            searchNetLabel.k(0);
                            searchNetLabel.l(it.margin.marginLeft);
                            searchNetLabel.m(it.margin.marginRight);
                            searchNetLabel.n(it.text);
                        }
                    }
                    color = BaseApplication.getContext().getColor(R.color.qui_common_text_primary);
                    searchNetLabel.o(color);
                    searchNetLabel.k(0);
                    searchNetLabel.l(it.margin.marginLeft);
                    searchNetLabel.m(it.margin.marginRight);
                    searchNetLabel.n(it.text);
                }
            } else {
                searchNetLabel.o(Color.parseColor("#FF0099FF"));
                if (ThemeUtil.isVasDarkTheme()) {
                    str2 = "#400099FF";
                } else {
                    str2 = "#190099FF";
                }
                searchNetLabel.k(Color.parseColor(str2));
            }
            return searchNetLabel;
        }

        Companion() {
        }
    }

    public SearchNetLabel(@NotNull String text, int i3, int i16, @NotNull LabelType type, @Nullable SearchIcon searchIcon, int i17, int i18, int i19, int i26, @Nullable SearchText searchText, @Nullable SearchReportInfo searchReportInfo) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        this.text = text;
        this.textColor = i3;
        this.bgColor = i16;
        this.type = type;
        this.icon = searchIcon;
        this.gender = i17;
        this.marginLeft = i18;
        this.marginRight = i19;
        this.layoutType = i26;
        this.searchTextEntity = searchText;
        this.dataReport = searchReportInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getBgColor() {
        return this.bgColor;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final SearchReportInfo getDataReport() {
        return this.dataReport;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final SearchIcon getIcon() {
        return this.icon;
    }

    /* renamed from: d, reason: from getter */
    public final int getLayoutType() {
        return this.layoutType;
    }

    /* renamed from: e, reason: from getter */
    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchNetLabel)) {
            return false;
        }
        SearchNetLabel searchNetLabel = (SearchNetLabel) other;
        if (Intrinsics.areEqual(this.text, searchNetLabel.text) && this.textColor == searchNetLabel.textColor && this.bgColor == searchNetLabel.bgColor && this.type == searchNetLabel.type && Intrinsics.areEqual(this.icon, searchNetLabel.icon) && this.gender == searchNetLabel.gender && this.marginLeft == searchNetLabel.marginLeft && this.marginRight == searchNetLabel.marginRight && this.layoutType == searchNetLabel.layoutType && Intrinsics.areEqual(this.searchTextEntity, searchNetLabel.searchTextEntity) && Intrinsics.areEqual(this.dataReport, searchNetLabel.dataReport)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getMarginRight() {
        return this.marginRight;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final SearchText getSearchTextEntity() {
        return this.searchTextEntity;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((this.text.hashCode() * 31) + this.textColor) * 31) + this.bgColor) * 31) + this.type.hashCode()) * 31;
        SearchIcon searchIcon = this.icon;
        int i3 = 0;
        if (searchIcon == null) {
            hashCode = 0;
        } else {
            hashCode = searchIcon.hashCode();
        }
        int i16 = (((((((((hashCode3 + hashCode) * 31) + this.gender) * 31) + this.marginLeft) * 31) + this.marginRight) * 31) + this.layoutType) * 31;
        SearchText searchText = this.searchTextEntity;
        if (searchText == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = searchText.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        SearchReportInfo searchReportInfo = this.dataReport;
        if (searchReportInfo != null) {
            i3 = searchReportInfo.hashCode();
        }
        return i17 + i3;
    }

    /* renamed from: i, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final LabelType getType() {
        return this.type;
    }

    public final void k(int i3) {
        this.bgColor = i3;
    }

    public final void l(int i3) {
        this.marginLeft = i3;
    }

    public final void m(int i3) {
        this.marginRight = i3;
    }

    public final void n(@Nullable SearchText searchText) {
        this.searchTextEntity = searchText;
    }

    public final void o(int i3) {
        this.textColor = i3;
    }

    @NotNull
    public String toString() {
        return "SearchNetLabel(text=" + this.text + ", textColor=" + this.textColor + ", bgColor=" + this.bgColor + ", type=" + this.type + ", icon=" + this.icon + ", gender=" + this.gender + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", layoutType=" + this.layoutType + ", searchTextEntity=" + this.searchTextEntity + ", dataReport=" + this.dataReport + ")";
    }

    public /* synthetic */ SearchNetLabel(String str, int i3, int i16, LabelType labelType, SearchIcon searchIcon, int i17, int i18, int i19, int i26, SearchText searchText, SearchReportInfo searchReportInfo, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i27 & 2) != 0 ? SupportMenu.CATEGORY_MASK : i3, (i27 & 4) != 0 ? -16776961 : i16, (i27 & 8) != 0 ? LabelType.TYPE_LABEL : labelType, (i27 & 16) != 0 ? null : searchIcon, (i27 & 32) != 0 ? 1 : i17, (i27 & 64) != 0 ? 0 : i18, (i27 & 128) != 0 ? 0 : i19, (i27 & 256) == 0 ? i26 : 0, (i27 & 512) != 0 ? null : searchText, (i27 & 1024) == 0 ? searchReportInfo : null);
    }
}
