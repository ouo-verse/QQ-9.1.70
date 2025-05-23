package com.tencent.mobileqq.matchfriend.reborn.publish.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "imageUrl", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "tipsList", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.config.b, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class TipsBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String imageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> tipsList;

    public TipsBean(String imageUrl, List<String> tipsList) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(tipsList, "tipsList");
        this.imageUrl = imageUrl;
        this.tipsList = tipsList;
    }

    /* renamed from: a, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<String> b() {
        return this.tipsList;
    }

    public int hashCode() {
        return (this.imageUrl.hashCode() * 31) + this.tipsList.hashCode();
    }

    public String toString() {
        return "TipsBean(imageUrl=" + this.imageUrl + ", tipsList=" + this.tipsList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TipsBean)) {
            return false;
        }
        TipsBean tipsBean = (TipsBean) other;
        return Intrinsics.areEqual(this.imageUrl, tipsBean.imageUrl) && Intrinsics.areEqual(this.tipsList, tipsBean.tipsList);
    }
}
