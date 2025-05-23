package com.tencent.sqshow.zootopia.widget.menu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "id", "b", "iconResId", "d", "textStrId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "textTitle", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "Lcom/tencent/sqshow/zootopia/widget/menu/a;", "()Lcom/tencent/sqshow/zootopia/widget/menu/a;", "actionHandler", "<init>", "(IIILjava/lang/String;Lcom/tencent/sqshow/zootopia/widget/menu/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.widget.menu.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZplanMenuDataItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textStrId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String textTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final a actionHandler;

    public ZplanMenuDataItem(int i3, int i16, int i17, String str, a actionHandler) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.id = i3;
        this.iconResId = i16;
        this.textStrId = i17;
        this.textTitle = str;
        this.actionHandler = actionHandler;
    }

    /* renamed from: a, reason: from getter */
    public final a getActionHandler() {
        return this.actionHandler;
    }

    /* renamed from: b, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final int getTextStrId() {
        return this.textStrId;
    }

    /* renamed from: e, reason: from getter */
    public final String getTextTitle() {
        return this.textTitle;
    }

    public int hashCode() {
        int i3 = ((((this.id * 31) + this.iconResId) * 31) + this.textStrId) * 31;
        String str = this.textTitle;
        return ((i3 + (str == null ? 0 : str.hashCode())) * 31) + this.actionHandler.hashCode();
    }

    public String toString() {
        return "ZplanMenuDataItem(id=" + this.id + ", iconResId=" + this.iconResId + ", textStrId=" + this.textStrId + ", textTitle=" + this.textTitle + ", actionHandler=" + this.actionHandler + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanMenuDataItem)) {
            return false;
        }
        ZplanMenuDataItem zplanMenuDataItem = (ZplanMenuDataItem) other;
        return this.id == zplanMenuDataItem.id && this.iconResId == zplanMenuDataItem.iconResId && this.textStrId == zplanMenuDataItem.textStrId && Intrinsics.areEqual(this.textTitle, zplanMenuDataItem.textTitle) && Intrinsics.areEqual(this.actionHandler, zplanMenuDataItem.actionHandler);
    }
}
