package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rmonitor/base/meta/DeviceMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getParams", "()Lorg/json/JSONObject;", "setParams", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class DeviceMeta extends MonitorMeta {

    @Nullable
    private JSONObject params;

    public DeviceMeta() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DeviceMeta copy$default(DeviceMeta deviceMeta, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = deviceMeta.params;
        }
        return deviceMeta.copy(jSONObject);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    @NotNull
    public final DeviceMeta copy(@Nullable JSONObject params) {
        return new DeviceMeta(params);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof DeviceMeta) || !Intrinsics.areEqual(this.params, ((DeviceMeta) other).params)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Nullable
    public final JSONObject getParams() {
        return this.params;
    }

    public int hashCode() {
        JSONObject jSONObject = this.params;
        if (jSONObject != null) {
            return jSONObject.hashCode();
        }
        return 0;
    }

    public final void setParams(@Nullable JSONObject jSONObject) {
        this.params = jSONObject;
    }

    @NotNull
    public String toString() {
        return "DeviceMeta(params=" + this.params + ")";
    }

    public DeviceMeta(@Nullable JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public /* synthetic */ DeviceMeta(JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jSONObject);
    }
}
