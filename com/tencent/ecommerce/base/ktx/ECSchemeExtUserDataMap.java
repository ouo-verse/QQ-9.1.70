package com.tencent.ecommerce.base.ktx;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "Ljava/io/Serializable;", "extUserDataMap", "", "", "(Ljava/util/Map;)V", "getExtUserDataMap", "()Ljava/util/Map;", "setExtUserDataMap", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final /* data */ class ECSchemeExtUserDataMap implements Serializable {
    private Map<Object, ? extends Object> extUserDataMap;

    public ECSchemeExtUserDataMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Map<Object, Object> component1() {
        return this.extUserDataMap;
    }

    public final ECSchemeExtUserDataMap copy(Map<Object, ? extends Object> extUserDataMap) {
        return new ECSchemeExtUserDataMap(extUserDataMap);
    }

    public final Map<Object, Object> getExtUserDataMap() {
        return this.extUserDataMap;
    }

    public int hashCode() {
        Map<Object, ? extends Object> map = this.extUserDataMap;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public final void setExtUserDataMap(Map<Object, ? extends Object> map) {
        this.extUserDataMap = map;
    }

    public String toString() {
        return "ECSchemeExtUserDataMap(extUserDataMap=" + this.extUserDataMap + ")";
    }

    public ECSchemeExtUserDataMap(Map<Object, ? extends Object> map) {
        this.extUserDataMap = map;
    }

    public /* synthetic */ ECSchemeExtUserDataMap(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new LinkedHashMap() : map);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ECSchemeExtUserDataMap) && Intrinsics.areEqual(this.extUserDataMap, ((ECSchemeExtUserDataMap) other).extUserDataMap);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECSchemeExtUserDataMap copy$default(ECSchemeExtUserDataMap eCSchemeExtUserDataMap, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = eCSchemeExtUserDataMap.extUserDataMap;
        }
        return eCSchemeExtUserDataMap.copy(map);
    }
}
