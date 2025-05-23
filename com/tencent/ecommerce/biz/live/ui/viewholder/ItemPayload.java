package com.tencent.ecommerce.biz.live.ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/PayloadType;", "a", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/PayloadType;", "payloadType", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(Lcom/tencent/ecommerce/biz/live/ui/viewholder/PayloadType;Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.live.ui.viewholder.h, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ItemPayload {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final PayloadType payloadType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Object data;

    public ItemPayload(PayloadType payloadType, Object obj) {
        this.payloadType = payloadType;
        this.data = obj;
    }

    /* renamed from: a, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public int hashCode() {
        PayloadType payloadType = this.payloadType;
        int hashCode = (payloadType != null ? payloadType.hashCode() : 0) * 31;
        Object obj = this.data;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "ItemPayload(payloadType=" + this.payloadType + ", data=" + this.data + ")";
    }

    public /* synthetic */ ItemPayload(PayloadType payloadType, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(payloadType, (i3 & 2) != 0 ? null : obj);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemPayload)) {
            return false;
        }
        ItemPayload itemPayload = (ItemPayload) other;
        return Intrinsics.areEqual(this.payloadType, itemPayload.payloadType) && Intrinsics.areEqual(this.data, itemPayload.data);
    }
}
