package com.tencent.ecommerce.biz.shophome.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB5\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\f\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "orderByKey", "b", "orderByName", "c", "I", "()I", "(I)V", "orderByValue", "d", "Z", "sortable", "e", "disabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZ)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.model.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderByTabInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderByKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderByName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int orderByValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean sortable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean disabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/a$a;", "", "", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "a", "", "ORDER_BY_KEY_COMPREHENSIVE", "Ljava/lang/String;", "ORDER_BY_KEY_NEWS_TIME", "ORDER_BY_KEY_PRICE", "ORDER_BY_KEY_SALE_NUMS", "ORDER_BY_UNKNOWN", "", "ORDER_BY_VALUE_ASCENDING", "I", "ORDER_BY_VALUE_DESCENDING", "ORDER_BY_VALUE_HIDE", "ORDER_BY_VALUE_UNKNOWN", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.model.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<ECOrderByTabInfo> a() {
            List<ECOrderByTabInfo> listOf;
            boolean z16 = false;
            DefaultConstructorMarker defaultConstructorMarker = null;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECOrderByTabInfo[]{new ECOrderByTabInfo("1", "\u7efc\u5408", 0, false, false, 28, null), new ECOrderByTabInfo("2", "\u9500\u91cf", 0, false, false, 28, null), new ECOrderByTabInfo("3", "\u65b0\u54c1", 0 == true ? 1 : 0, false, z16, 28, defaultConstructorMarker), new ECOrderByTabInfo("4", "\u4ef7\u683c", 0 == true ? 1 : 0, true, z16, 16, defaultConstructorMarker)});
            return listOf;
        }
    }

    public ECOrderByTabInfo(String str, String str2, int i3, boolean z16, boolean z17) {
        this.orderByKey = str;
        this.orderByName = str2;
        this.orderByValue = i3;
        this.sortable = z16;
        this.disabled = z17;
    }

    /* renamed from: a, reason: from getter */
    public final int getOrderByValue() {
        return this.orderByValue;
    }

    public final void b(int i3) {
        this.orderByValue = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.orderByKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderByName;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.orderByValue) * 31;
        boolean z16 = this.sortable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.disabled;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "ECOrderByTabInfo(orderByKey=" + this.orderByKey + ", orderByName=" + this.orderByName + ", orderByValue=" + this.orderByValue + ", sortable=" + this.sortable + ", disabled=" + this.disabled + ")";
    }

    public /* synthetic */ ECOrderByTabInfo(String str, String str2, int i3, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderByTabInfo)) {
            return false;
        }
        ECOrderByTabInfo eCOrderByTabInfo = (ECOrderByTabInfo) other;
        return Intrinsics.areEqual(this.orderByKey, eCOrderByTabInfo.orderByKey) && Intrinsics.areEqual(this.orderByName, eCOrderByTabInfo.orderByName) && this.orderByValue == eCOrderByTabInfo.orderByValue && this.sortable == eCOrderByTabInfo.sortable && this.disabled == eCOrderByTabInfo.disabled;
    }
}
