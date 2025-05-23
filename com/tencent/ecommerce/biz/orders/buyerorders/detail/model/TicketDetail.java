package com.tencent.ecommerce.biz.orders.buyerorders.detail.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "name", "b", "deadlineStr", "c", "condition", "d", "contact", "e", "note", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "g", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.model.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class TicketDetail {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String deadlineStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String condition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String contact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String note;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final TicketDetail f103227f = new TicketDetail("\u661f\u5df4\u514b\u51b0\u6447\u67e0\u6aac\u8336\u4e2d\u676f\u5238", "2022.08.01-2022.12.03", "\u987b\u4f9d\u636e\u9886\u53d6\u987b\u77e5\u5151\u6362\u4f7f\u7528\u5238\u7801", "242454567777", "\u672c\u4ea7\u54c1\u51711\u5f20\u5151\u6362\u5238\uff0c\u4ec5\u9650123333\u6b21\u5151\u6362\uff1b\u51ed\u5238\u5230\u5e97\u5802\u98df\u6216\u81ea\u52a9\u70b9\u9910\u65f6\uff0c\u53ef\u5151\u63622\u4efd\u542e\u6307\u539f\u5473\u9e21\uff081\u5757\u88c5\uff09");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e$a;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "FAKE", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "a", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.model.e$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final TicketDetail a() {
            return TicketDetail.f103227f;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TicketDetail(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.deadlineStr = str2;
        this.condition = str3;
        this.contact = str4;
        this.note = str5;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deadlineStr;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.condition;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.contact;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.note;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "TicketDetail(name=" + this.name + ", deadlineStr=" + this.deadlineStr + ", condition=" + this.condition + ", contact=" + this.contact + ", note=" + this.note + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketDetail)) {
            return false;
        }
        TicketDetail ticketDetail = (TicketDetail) other;
        return Intrinsics.areEqual(this.name, ticketDetail.name) && Intrinsics.areEqual(this.deadlineStr, ticketDetail.deadlineStr) && Intrinsics.areEqual(this.condition, ticketDetail.condition) && Intrinsics.areEqual(this.contact, ticketDetail.contact) && Intrinsics.areEqual(this.note, ticketDetail.note);
    }
}
