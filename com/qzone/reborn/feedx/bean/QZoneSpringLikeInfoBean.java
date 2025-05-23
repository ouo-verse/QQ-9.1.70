package com.qzone.reborn.feedx.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedx/bean/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "click", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "like", "b", "combo", "getCombo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.feedx.bean.d, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class QZoneSpringLikeInfoBean {

    @SerializedName("click")
    private final String click;

    @SerializedName("combo")
    private final String combo;

    @SerializedName("like")
    private final String like;

    public QZoneSpringLikeInfoBean() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getClick() {
        return this.click;
    }

    /* renamed from: b, reason: from getter */
    public final String getLike() {
        return this.like;
    }

    public int hashCode() {
        return (((this.click.hashCode() * 31) + this.like.hashCode()) * 31) + this.combo.hashCode();
    }

    public String toString() {
        return "QZoneSpringLikeInfoBean(click=" + this.click + ", like=" + this.like + ", combo=" + this.combo + ")";
    }

    public QZoneSpringLikeInfoBean(String click, String like, String combo) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(like, "like");
        Intrinsics.checkNotNullParameter(combo, "combo");
        this.click = click;
        this.like = like;
        this.combo = combo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneSpringLikeInfoBean)) {
            return false;
        }
        QZoneSpringLikeInfoBean qZoneSpringLikeInfoBean = (QZoneSpringLikeInfoBean) other;
        return Intrinsics.areEqual(this.click, qZoneSpringLikeInfoBean.click) && Intrinsics.areEqual(this.like, qZoneSpringLikeInfoBean.like) && Intrinsics.areEqual(this.combo, qZoneSpringLikeInfoBean.combo);
    }

    public /* synthetic */ QZoneSpringLikeInfoBean(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
