package com.tencent.state.square.data;

import com.tencent.state.data.Gender;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\nH\u00d6\u0001J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/data/DressInfo;", "", "gender", "Lcom/tencent/state/data/Gender;", "type", "Lcom/tencent/state/square/data/DressType;", "message", "", "goods", "", "", QZoneDTLoginReporter.SCHEMA, "(Lcom/tencent/state/data/Gender;Lcom/tencent/state/square/data/DressType;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getGender", "()Lcom/tencent/state/data/Gender;", "getGoods", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getSchema", "getType", "()Lcom/tencent/state/square/data/DressType;", "setType", "(Lcom/tencent/state/square/data/DressType;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class DressInfo {
    private final Gender gender;
    private final List<Integer> goods;
    private final String message;
    private final String schema;
    private DressType type;

    public DressInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final Gender getGender() {
        return this.gender;
    }

    /* renamed from: component2, reason: from getter */
    public final DressType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<Integer> component4() {
        return this.goods;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public final DressInfo copy(Gender gender, DressType type, String message, List<Integer> goods, String schema) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DressInfo(gender, type, message, goods, schema);
    }

    public final Gender getGender() {
        return this.gender;
    }

    public final List<Integer> getGoods() {
        return this.goods;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final DressType getType() {
        return this.type;
    }

    public int hashCode() {
        Gender gender = this.gender;
        int hashCode = (gender != null ? gender.hashCode() : 0) * 31;
        DressType dressType = this.type;
        int hashCode2 = (hashCode + (dressType != null ? dressType.hashCode() : 0)) * 31;
        String str = this.message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<Integer> list = this.goods;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.schema;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setType(DressType dressType) {
        Intrinsics.checkNotNullParameter(dressType, "<set-?>");
        this.type = dressType;
    }

    public String toString() {
        return "DressInfo(gender=" + this.gender + ", type=" + this.type + ", message=" + this.message + ", goods=" + this.goods + ", schema=" + this.schema + ")";
    }

    public DressInfo(Gender gender, DressType type, String str, List<Integer> list, String str2) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(type, "type");
        this.gender = gender;
        this.type = type;
        this.message = str;
        this.goods = list;
        this.schema = str2;
    }

    public /* synthetic */ DressInfo(Gender gender, DressType dressType, String str, List list, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Gender.UNKNOWN : gender, (i3 & 2) != 0 ? DressType.UNKNOWN : dressType, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 16) == 0 ? str2 : "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressInfo)) {
            return false;
        }
        DressInfo dressInfo = (DressInfo) other;
        return Intrinsics.areEqual(this.gender, dressInfo.gender) && Intrinsics.areEqual(this.type, dressInfo.type) && Intrinsics.areEqual(this.message, dressInfo.message) && Intrinsics.areEqual(this.goods, dressInfo.goods) && Intrinsics.areEqual(this.schema, dressInfo.schema);
    }

    public static /* synthetic */ DressInfo copy$default(DressInfo dressInfo, Gender gender, DressType dressType, String str, List list, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gender = dressInfo.gender;
        }
        if ((i3 & 2) != 0) {
            dressType = dressInfo.type;
        }
        DressType dressType2 = dressType;
        if ((i3 & 4) != 0) {
            str = dressInfo.message;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            list = dressInfo.goods;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            str2 = dressInfo.schema;
        }
        return dressInfo.copy(gender, dressType2, str3, list2, str2);
    }
}
