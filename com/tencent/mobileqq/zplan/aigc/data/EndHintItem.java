package com.tencent.mobileqq.zplan.aigc.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/f;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "hintText", "I", "e", "()I", "g", "(I)V", "status", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "getBasicInfo", "()Lcom/tencent/mobileqq/zplan/aigc/data/b;", "setBasicInfo", "(Lcom/tencent/mobileqq/zplan/aigc/data/b;)V", "basicInfo", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/zplan/aigc/data/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.f, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class EndHintItem extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String hintText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private b basicInfo;

    public EndHintItem() {
        this(null, 0, null, 7, null);
    }

    /* renamed from: d, reason: from getter */
    public final String getHintText() {
        return this.hintText;
    }

    /* renamed from: e, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hintText = str;
    }

    public final void g(int i3) {
        this.status = i3;
    }

    public int hashCode() {
        return (((this.hintText.hashCode() * 31) + this.status) * 31) + this.basicInfo.hashCode();
    }

    public String toString() {
        return "EndHintItem(hintText=" + this.hintText + ", status=" + this.status + ", basicInfo=" + this.basicInfo + ")";
    }

    public /* synthetic */ EndHintItem(String str, int i3, b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? new b(5, "") : bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EndHintItem(String hintText, int i3, b basicInfo) {
        super(basicInfo.getType(), basicInfo.getExtra());
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        this.hintText = hintText;
        this.status = i3;
        this.basicInfo = basicInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EndHintItem)) {
            return false;
        }
        EndHintItem endHintItem = (EndHintItem) other;
        return Intrinsics.areEqual(this.hintText, endHintItem.hintText) && this.status == endHintItem.status && Intrinsics.areEqual(this.basicInfo, endHintItem.basicInfo);
    }
}
