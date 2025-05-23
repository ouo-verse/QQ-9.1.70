package com.tencent.localedit.fakenative.meta;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dJ\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/localedit/fakenative/meta/ConvertPerformanceData;", "", "convertStart", "", "convertEnd", "useCache", "", "useChunkImport", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Z)V", "getConvertEnd", "()Ljava/lang/Long;", "setConvertEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getConvertStart", "setConvertStart", "getUseCache", "()Ljava/lang/Boolean;", "setUseCache", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUseChunkImport", "()Z", "setUseChunkImport", "(Z)V", "canUse", "toJson", "Lorg/json/JSONObject;", "toMap", "", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class ConvertPerformanceData {

    @Nullable
    private Long convertEnd;

    @Nullable
    private Long convertStart;

    @Nullable
    private Boolean useCache;
    private boolean useChunkImport;

    public ConvertPerformanceData() {
        this(null, null, null, false, 15, null);
    }

    public final boolean canUse() {
        if (this.convertStart != null && this.convertEnd != null && this.useCache != null) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Long getConvertEnd() {
        return this.convertEnd;
    }

    @Nullable
    public final Long getConvertStart() {
        return this.convertStart;
    }

    @Nullable
    public final Boolean getUseCache() {
        return this.useCache;
    }

    public final boolean getUseChunkImport() {
        return this.useChunkImport;
    }

    public final void setConvertEnd(@Nullable Long l3) {
        this.convertEnd = l3;
    }

    public final void setConvertStart(@Nullable Long l3) {
        this.convertStart = l3;
    }

    public final void setUseCache(@Nullable Boolean bool) {
        this.useCache = bool;
    }

    public final void setUseChunkImport(boolean z16) {
        this.useChunkImport = z16;
    }

    @NotNull
    public final JSONObject toJson() {
        return new JSONObject(toMap());
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("convert_start", this.convertStart), TuplesKt.to("convert_end", this.convertEnd), TuplesKt.to("use_cache", this.useCache), TuplesKt.to("use_chunk_import", Boolean.valueOf(this.useChunkImport)));
        return mapOf;
    }

    @NotNull
    public String toString() {
        String jSONObject = toJson().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toJson().toString()");
        return jSONObject;
    }

    public ConvertPerformanceData(@Nullable Long l3, @Nullable Long l16, @Nullable Boolean bool, boolean z16) {
        this.convertStart = l3;
        this.convertEnd = l16;
        this.useCache = bool;
        this.useChunkImport = z16;
    }

    public /* synthetic */ ConvertPerformanceData(Long l3, Long l16, Boolean bool, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : l16, (i3 & 4) != 0 ? null : bool, (i3 & 8) != 0 ? false : z16);
    }
}
