package com.tencent.ecommerce.base.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/ui/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "title", "b", "I", "index", "c", "Z", "()Z", "(Z)V", "isSelected", "<init>", "(Ljava/lang/String;IZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.ui.j, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class ItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    public ItemData(String str, int i3, boolean z16) {
        this.title = str;
        this.index = i3;
        this.isSelected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void b(boolean z16) {
        this.isSelected = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.index) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ItemData(title=" + this.title + ", index=" + this.index + ", isSelected=" + this.isSelected + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemData)) {
            return false;
        }
        ItemData itemData = (ItemData) other;
        return Intrinsics.areEqual(this.title, itemData.title) && this.index == itemData.index && this.isSelected == itemData.isSelected;
    }
}
