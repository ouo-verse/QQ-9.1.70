package com.tencent.mobileqq.icgame.context;

import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/icgame/context/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "b", "c", "traceId", QZoneDTLoginReporter.SCHEMA, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.context.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class BuildParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String traceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String schema;

    public BuildParams(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.appId = str;
        this.traceId = str2;
        this.schema = str3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildParams)) {
            return false;
        }
        BuildParams buildParams = (BuildParams) other;
        if (Intrinsics.areEqual(this.appId, buildParams.appId) && Intrinsics.areEqual(this.traceId, buildParams.traceId) && Intrinsics.areEqual(this.schema, buildParams.schema)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.appId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.traceId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.schema;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "BuildParams(appId=" + this.appId + ", traceId=" + this.traceId + ", schema=" + this.schema + ")";
    }
}
