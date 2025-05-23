package jj0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ljj0/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "typeName", "b", "typeStr", "c", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "typeNum", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: jj0.e, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ECTransactionSaasInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String typeName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String typeStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer typeNum;

    public ECTransactionSaasInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Integer getTypeNum() {
        return this.typeNum;
    }

    public int hashCode() {
        String str = this.typeName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.typeStr;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.typeNum;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ECTransactionSaasInfo(typeName=" + this.typeName + ", typeStr=" + this.typeStr + ", typeNum=" + this.typeNum + ")";
    }

    public ECTransactionSaasInfo(String str, String str2, Integer num) {
        this.typeName = str;
        this.typeStr = str2;
        this.typeNum = num;
    }

    public /* synthetic */ ECTransactionSaasInfo(String str, String str2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : num);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECTransactionSaasInfo)) {
            return false;
        }
        ECTransactionSaasInfo eCTransactionSaasInfo = (ECTransactionSaasInfo) other;
        return Intrinsics.areEqual(this.typeName, eCTransactionSaasInfo.typeName) && Intrinsics.areEqual(this.typeStr, eCTransactionSaasInfo.typeStr) && Intrinsics.areEqual(this.typeNum, eCTransactionSaasInfo.typeNum);
    }
}
