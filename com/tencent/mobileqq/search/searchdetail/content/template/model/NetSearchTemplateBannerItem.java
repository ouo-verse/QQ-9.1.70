package com.tencent.mobileqq.search.searchdetail.content.template.model;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchBanner;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchTemplate;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010,\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00102\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b\u001d\u00101R\"\u00106\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\"\u0010:\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R$\u0010B\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/i;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "width", "height", "", "G", "", "toString", "", "other", "", "equals", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBanner;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchBanner;", "getBanner", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchBanner;", "banner", "H", "Ljava/lang/String;", "y", "()Ljava/lang/String;", "setContentImage", "(Ljava/lang/String;)V", "contentImage", "", "I", UserInfo.SEX_FEMALE, "B", "()F", "setRateWH", "(F)V", "rateWH", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "kotlin.jvm.PlatformType", "J", "Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/util/List;", "setTextLinkList", "(Ljava/util/List;)V", "textLinkList", "K", "Z", "E", "()Z", "(Z)V", "isFullWidth", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setDescription", "description", "M", "D", "setTitle", "title", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "setIcon", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;)V", "icon", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "setButton", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;)V", "button", "Lcom/tencent/mobileqq/search/searchdetail/b;", "commonInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;", "template", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/b;Lcom/tencent/qqnt/kernel/nativeinterface/SearchTemplate;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.i, reason: from toString */
/* loaded from: classes18.dex */
public final class NetSearchTemplateBannerItem extends a {

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @NotNull
    private final SearchBanner banner;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String contentImage;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private float rateWH;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private List<SearchText> textLinkList;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private boolean isFullWidth;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    @NotNull
    private String description;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @Nullable
    private SearchIcon icon;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    @Nullable
    private SearchButton button;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchTemplateBannerItem(@NotNull CommonInfo commonInfo, @NotNull SearchTemplate template) {
        super(commonInfo, template);
        SearchJump searchJump;
        String str;
        float f16;
        String str2;
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        Intrinsics.checkNotNullParameter(template, "template");
        SearchBanner searchBanner = template.banner;
        searchBanner = searchBanner == null ? new SearchBanner() : searchBanner;
        this.banner = searchBanner;
        SearchIcon searchIcon = searchBanner.background;
        if (searchIcon != null) {
            searchJump = searchIcon.jumpLink;
        } else {
            searchJump = null;
        }
        w(searchJump);
        SearchIcon searchIcon2 = searchBanner.background;
        if (searchIcon2 != null) {
            str = searchIcon2.iconLink;
        } else {
            str = null;
        }
        this.contentImage = str == null ? "" : str;
        if (searchIcon2 != null) {
            f16 = j.a(searchIcon2);
        } else {
            f16 = 2.5f;
        }
        this.rateWH = f16;
        ArrayList<SearchText> arrayList = searchBanner.textLinkList;
        this.textLinkList = arrayList == null ? new ArrayList<>() : arrayList;
        SearchText searchText = searchBanner.subTitle;
        if (searchText != null) {
            str2 = searchText.text;
        } else {
            str2 = null;
        }
        this.description = str2 == null ? "" : str2;
        SearchText searchText2 = searchBanner.title;
        String str3 = searchText2 != null ? searchText2.text : null;
        this.title = str3 != null ? str3 : "";
        this.icon = searchBanner.icon;
        this.button = searchBanner.button;
    }

    @Nullable
    /* renamed from: A, reason: from getter */
    public final SearchIcon getIcon() {
        return this.icon;
    }

    /* renamed from: B, reason: from getter */
    public final float getRateWH() {
        return this.rateWH;
    }

    @NotNull
    public final List<SearchText> C() {
        return this.textLinkList;
    }

    @NotNull
    /* renamed from: D, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: E, reason: from getter */
    public final boolean getIsFullWidth() {
        return this.isFullWidth;
    }

    public final void F(boolean z16) {
        this.isFullWidth = z16;
    }

    public final void G(int width, int height) {
        if (width > 0 && height > 0) {
            this.rateWH = width / height;
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetSearchTemplateBannerItem) || !super.equals(other)) {
            return false;
        }
        NetSearchTemplateBannerItem netSearchTemplateBannerItem = (NetSearchTemplateBannerItem) other;
        if (!Intrinsics.areEqual(this.banner, netSearchTemplateBannerItem.banner) || !Intrinsics.areEqual(this.contentImage, netSearchTemplateBannerItem.contentImage)) {
            return false;
        }
        if (this.rateWH == netSearchTemplateBannerItem.rateWH) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(this.textLinkList, netSearchTemplateBannerItem.textLinkList) && this.isFullWidth == netSearchTemplateBannerItem.isFullWidth && Intrinsics.areEqual(this.description, netSearchTemplateBannerItem.description) && Intrinsics.areEqual(this.title, netSearchTemplateBannerItem.title) && Intrinsics.areEqual(this.icon, netSearchTemplateBannerItem.icon) && Intrinsics.areEqual(this.button, netSearchTemplateBannerItem.button)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 5;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.template.model.a
    public int hashCode() {
        int i3;
        int hashCode = ((((((((((((((super.hashCode() * 31) + this.banner.hashCode()) * 31) + this.contentImage.hashCode()) * 31) + Float.floatToIntBits(this.rateWH)) * 31) + this.textLinkList.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isFullWidth)) * 31) + this.description.hashCode()) * 31) + this.title.hashCode()) * 31;
        SearchIcon searchIcon = this.icon;
        int i16 = 0;
        if (searchIcon != null) {
            i3 = searchIcon.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode + i3) * 31;
        SearchButton searchButton = this.button;
        if (searchButton != null) {
            i16 = searchButton.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "NetSearchTemplateBannerItem(commonInfo=" + getCommonInfo() + ", banner=" + this.banner + ", contentImage='" + this.contentImage + "', rateWH=" + this.rateWH + ", textLinkList=" + this.textLinkList + ", isFullWidth=" + this.isFullWidth + ", description='" + this.description + "', title='" + this.title + "', icon=" + this.icon + ", button=" + this.button + ")";
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final SearchButton getButton() {
        return this.button;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getContentImage() {
        return this.contentImage;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getDescription() {
        return this.description;
    }
}
