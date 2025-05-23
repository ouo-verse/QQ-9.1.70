package i94;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.sqshow.zootopia.nativeui.data.collect.CollectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Li94/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "type", "Luv4/az;", "Luv4/az;", "()Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(ILuv4/az;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: i94.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class CollectInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final az item;

    public CollectInfo(@CollectType int i3, az item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.type = i3;
        this.item = item;
    }

    /* renamed from: a, reason: from getter */
    public final az getItem() {
        return this.item;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.item.hashCode();
    }

    public String toString() {
        return "CollectInfo(type=" + this.type + ", item=" + this.item + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectInfo)) {
            return false;
        }
        CollectInfo collectInfo = (CollectInfo) other;
        return this.type == collectInfo.type && Intrinsics.areEqual(this.item, collectInfo.item);
    }
}
