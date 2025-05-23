package com.tencent.state.publicchat.data;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zr4.a;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0015\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J9\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/publicchat/data/ElemConfInfo;", "", "Lcom/tencent/state/publicchat/data/ElemType;", "component1", "", "", "component2", "", "component3", "elemType", "display", "attributes", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/state/publicchat/data/ElemType;", "getElemType", "()Lcom/tencent/state/publicchat/data/ElemType;", "Ljava/util/Map;", "getDisplay", "()Ljava/util/Map;", "Ljava/util/List;", "getAttributes", "()Ljava/util/List;", "<init>", "(Lcom/tencent/state/publicchat/data/ElemType;Ljava/util/Map;Ljava/util/List;)V", "Lzr4/a;", "pb", "(Lzr4/a;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ElemConfInfo {
    private final List<String> attributes;
    private final Map<String, String> display;
    private final ElemType elemType;

    public ElemConfInfo(ElemType elemType, Map<String, String> display, List<String> attributes) {
        Intrinsics.checkNotNullParameter(elemType, "elemType");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.elemType = elemType;
        this.display = display;
        this.attributes = attributes;
    }

    /* renamed from: component1, reason: from getter */
    public final ElemType getElemType() {
        return this.elemType;
    }

    public final Map<String, String> component2() {
        return this.display;
    }

    public final List<String> component3() {
        return this.attributes;
    }

    public final ElemConfInfo copy(ElemType elemType, Map<String, String> display, List<String> attributes) {
        Intrinsics.checkNotNullParameter(elemType, "elemType");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new ElemConfInfo(elemType, display, attributes);
    }

    public final List<String> getAttributes() {
        return this.attributes;
    }

    public final Map<String, String> getDisplay() {
        return this.display;
    }

    public final ElemType getElemType() {
        return this.elemType;
    }

    public int hashCode() {
        ElemType elemType = this.elemType;
        int hashCode = (elemType != null ? elemType.hashCode() : 0) * 31;
        Map<String, String> map = this.display;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<String> list = this.attributes;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ElemConfInfo(elemType=" + this.elemType + ", display=" + this.display + ", attributes=" + this.attributes + ")";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r3 = kotlin.collections.ArraysKt___ArraysKt.toList(r3);
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ElemConfInfo(a aVar) {
        this(r0, r1, r3);
        ElemType parse = ElemType.INSTANCE.parse(Integer.valueOf(aVar != null ? aVar.f453078a : 0));
        Map<String, String> emptyMap = (aVar == null || (emptyMap = aVar.f453079b) == null) ? MapsKt__MapsKt.emptyMap() : emptyMap;
        List emptyList = (aVar == null || (r3 = aVar.f453080c) == null || emptyList == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ElemConfInfo)) {
            return false;
        }
        ElemConfInfo elemConfInfo = (ElemConfInfo) other;
        return Intrinsics.areEqual(this.elemType, elemConfInfo.elemType) && Intrinsics.areEqual(this.display, elemConfInfo.display) && Intrinsics.areEqual(this.attributes, elemConfInfo.attributes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElemConfInfo copy$default(ElemConfInfo elemConfInfo, ElemType elemType, Map map, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            elemType = elemConfInfo.elemType;
        }
        if ((i3 & 2) != 0) {
            map = elemConfInfo.display;
        }
        if ((i3 & 4) != 0) {
            list = elemConfInfo.attributes;
        }
        return elemConfInfo.copy(elemType, map, list);
    }
}
