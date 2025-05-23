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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010\u0012\u001a\u00020\u0005J\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/localedit/fakenative/meta/CommonConvertResult;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toJsonString", "toMap", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class CommonConvertResult {
    private final int code;

    @NotNull
    private final String message;

    public CommonConvertResult() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonConvertResult copy$default(CommonConvertResult commonConvertResult, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = commonConvertResult.code;
        }
        if ((i16 & 2) != 0) {
            str = commonConvertResult.message;
        }
        return commonConvertResult.copy(i3, str);
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
    public final CommonConvertResult copy(int code, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new CommonConvertResult(code, message);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonConvertResult)) {
            return false;
        }
        CommonConvertResult commonConvertResult = (CommonConvertResult) other;
        if (this.code == commonConvertResult.code && Intrinsics.areEqual(this.message, commonConvertResult.message)) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
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
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(this.code)), TuplesKt.to("message", this.message));
        return mapOf;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(toMap());
        return list.toString();
    }

    public CommonConvertResult(int i3, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i3;
        this.message = message;
    }

    public /* synthetic */ CommonConvertResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str);
    }
}
