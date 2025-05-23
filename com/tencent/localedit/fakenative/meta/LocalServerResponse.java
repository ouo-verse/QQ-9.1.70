package com.tencent.localedit.fakenative.meta;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0001H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u0019\u001a\u00020\u0005J\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/localedit/fakenative/meta/LocalServerResponse;", "", "code", "", "message", "", "data", "total", "(ILjava/lang/String;Ljava/lang/Object;I)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toJsonString", "toMap", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class LocalServerResponse {
    private final int code;

    @NotNull
    private final Object data;

    @NotNull
    private final String message;
    private final int total;

    public LocalServerResponse() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ LocalServerResponse copy$default(LocalServerResponse localServerResponse, int i3, String str, Object obj, int i16, int i17, Object obj2) {
        if ((i17 & 1) != 0) {
            i3 = localServerResponse.code;
        }
        if ((i17 & 2) != 0) {
            str = localServerResponse.message;
        }
        if ((i17 & 4) != 0) {
            obj = localServerResponse.data;
        }
        if ((i17 & 8) != 0) {
            i16 = localServerResponse.total;
        }
        return localServerResponse.copy(i3, str, obj, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final LocalServerResponse copy(int code, @NotNull String message, @NotNull Object data, int total) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        return new LocalServerResponse(code, message, data, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalServerResponse)) {
            return false;
        }
        LocalServerResponse localServerResponse = (LocalServerResponse) other;
        if (this.code == localServerResponse.code && Intrinsics.areEqual(this.message, localServerResponse.message) && Intrinsics.areEqual(this.data, localServerResponse.data) && this.total == localServerResponse.total) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((this.code * 31) + this.message.hashCode()) * 31) + this.data.hashCode()) * 31) + this.total;
    }

    @NotNull
    public final String toJsonString() {
        String jSONObject = new JSONObject(toMap()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(toMap()).toString()");
        return jSONObject;
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(this.code)), TuplesKt.to("message", this.message), TuplesKt.to("data", this.data), TuplesKt.to("total", Integer.valueOf(this.total)));
        return mapOf;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(toMap());
        return list.toString();
    }

    public LocalServerResponse(int i3, @NotNull String message, @NotNull Object data, int i16) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(data, "data");
        this.code = i3;
        this.message = message;
        this.data = data;
        this.total = i16;
    }

    public /* synthetic */ LocalServerResponse(int i3, String str, String str2, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? "" : str2, (i17 & 8) != 0 ? 0 : i16);
    }
}
