package com.qzone.business.tianshu.model;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import cooperation.vip.pb.TianShuAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/business/tianshu/model/QZoneFeedGuideTianshuInfo;", "Lcom/qzone/business/tianshu/model/TianShuInfo;", "originAdItem", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "(Lcooperation/vip/pb/TianShuAccess$AdItem;)V", "adItem", "getAdItem", "()Lcooperation/vip/pb/TianShuAccess$AdItem;", "setAdItem", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "getOriginAdItem", "pic", "getPic", "setPic", "text", "getText", IECSearchBar.METHOD_SET_TEXT, "title", "getTitle", "setTitle", "url", "getUrl", "setUrl", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneFeedGuideTianshuInfo extends TianShuInfo {
    private TianShuAccess.AdItem adItem;
    private String buttonText;
    private final TianShuAccess.AdItem originAdItem;
    private String pic;
    private String text;
    private String title;
    private String url;

    public QZoneFeedGuideTianshuInfo(TianShuAccess.AdItem originAdItem) {
        Intrinsics.checkNotNullParameter(originAdItem, "originAdItem");
        this.originAdItem = originAdItem;
    }

    public final TianShuAccess.AdItem getAdItem() {
        return this.adItem;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final TianShuAccess.AdItem getOriginAdItem() {
        return this.originAdItem;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setAdItem(TianShuAccess.AdItem adItem) {
        this.adItem = adItem;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setPic(String str) {
        this.pic = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
