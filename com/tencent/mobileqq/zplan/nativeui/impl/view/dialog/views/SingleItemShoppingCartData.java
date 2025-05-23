package com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "b", "e", "text", "I", "d", "()I", "price", "iconUrl", "cornerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class SingleItemShoppingCartData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int price;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cornerUrl;

    public SingleItemShoppingCartData(String id5, String text, int i3, String iconUrl, String cornerUrl) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(cornerUrl, "cornerUrl");
        this.id = id5;
        this.text = text;
        this.price = i3;
        this.iconUrl = iconUrl;
        this.cornerUrl = cornerUrl;
    }

    /* renamed from: a, reason: from getter */
    public final String getCornerUrl() {
        return this.cornerUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* renamed from: e, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.price) * 31) + this.iconUrl.hashCode()) * 31) + this.cornerUrl.hashCode();
    }

    public String toString() {
        return "SingleItemShoppingCartData(id=" + this.id + ", text=" + this.text + ", price=" + this.price + ", iconUrl=" + this.iconUrl + ", cornerUrl=" + this.cornerUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleItemShoppingCartData)) {
            return false;
        }
        SingleItemShoppingCartData singleItemShoppingCartData = (SingleItemShoppingCartData) other;
        return Intrinsics.areEqual(this.id, singleItemShoppingCartData.id) && Intrinsics.areEqual(this.text, singleItemShoppingCartData.text) && this.price == singleItemShoppingCartData.price && Intrinsics.areEqual(this.iconUrl, singleItemShoppingCartData.iconUrl) && Intrinsics.areEqual(this.cornerUrl, singleItemShoppingCartData.cornerUrl);
    }
}
