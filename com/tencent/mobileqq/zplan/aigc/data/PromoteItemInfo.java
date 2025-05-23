package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0001\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/n;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "name", "d", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "title", "e", "g", "l", QQWinkConstants.TAB_SUBTITLE, "j", WadlProxyConsts.KEY_JUMP_URL, "i", "imageUrl", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "getBasicInfo", "()Lcom/tencent/mobileqq/zplan/aigc/data/b;", "setBasicInfo", "(Lcom/tencent/mobileqq/zplan/aigc/data/b;)V", "basicInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/aigc/data/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.n, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class PromoteItemInfo extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String subTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String imageUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private b basicInfo;

    public PromoteItemInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: d, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: e, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: g, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.basicInfo.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "PromoteItemInfo(name=" + this.name + ", title=" + this.title + ", subTitle=" + this.subTitle + ", jumpUrl=" + this.jumpUrl + ", imageUrl=" + this.imageUrl + ", basicInfo=" + this.basicInfo + ")";
    }

    public /* synthetic */ PromoteItemInfo(String str, String str2, String str3, String str4, String str5, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? new b(2, "") : bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoteItemInfo(String name, String title, String subTitle, String jumpUrl, String imageUrl, b basicInfo) {
        super(basicInfo.getType(), basicInfo.getExtra());
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        this.name = name;
        this.title = title;
        this.subTitle = subTitle;
        this.jumpUrl = jumpUrl;
        this.imageUrl = imageUrl;
        this.basicInfo = basicInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromoteItemInfo)) {
            return false;
        }
        PromoteItemInfo promoteItemInfo = (PromoteItemInfo) other;
        return Intrinsics.areEqual(this.name, promoteItemInfo.name) && Intrinsics.areEqual(this.title, promoteItemInfo.title) && Intrinsics.areEqual(this.subTitle, promoteItemInfo.subTitle) && Intrinsics.areEqual(this.jumpUrl, promoteItemInfo.jumpUrl) && Intrinsics.areEqual(this.imageUrl, promoteItemInfo.imageUrl) && Intrinsics.areEqual(this.basicInfo, promoteItemInfo.basicInfo);
    }
}
