package com.tencent.mobileqq.wink.context;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012&\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\u000bR7\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\r\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/context/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "b", "f", "traceId", "c", "missionId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "schemaAttrs", "e", "schemaString", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", "()Lcom/tencent/mobileqq/wink/context/WinkExodus;", "exodus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Lcom/tencent/mobileqq/wink/context/WinkExodus;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.context.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class BuildParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String businessName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String traceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String missionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, String> schemaAttrs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String schemaString;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final WinkExodus exodus;

    public BuildParams(@NotNull String businessName, @Nullable String str, @Nullable String str2, @Nullable HashMap<String, String> hashMap, @Nullable String str3, @Nullable WinkExodus winkExodus) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.businessName = businessName;
        this.traceId = str;
        this.missionId = str2;
        this.schemaAttrs = hashMap;
        this.schemaString = str3;
        this.exodus = winkExodus;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBusinessName() {
        return this.businessName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final WinkExodus getExodus() {
        return this.exodus;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final HashMap<String, String> d() {
        return this.schemaAttrs;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getSchemaString() {
        return this.schemaString;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildParams)) {
            return false;
        }
        BuildParams buildParams = (BuildParams) other;
        if (Intrinsics.areEqual(this.businessName, buildParams.businessName) && Intrinsics.areEqual(this.traceId, buildParams.traceId) && Intrinsics.areEqual(this.missionId, buildParams.missionId) && Intrinsics.areEqual(this.schemaAttrs, buildParams.schemaAttrs) && Intrinsics.areEqual(this.schemaString, buildParams.schemaString) && Intrinsics.areEqual(this.exodus, buildParams.exodus)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = this.businessName.hashCode() * 31;
        String str = this.traceId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode5 + hashCode) * 31;
        String str2 = this.missionId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        HashMap<String, String> hashMap = this.schemaAttrs;
        if (hashMap == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = hashMap.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.schemaString;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        WinkExodus winkExodus = this.exodus;
        if (winkExodus != null) {
            i3 = winkExodus.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "BuildParams(businessName=" + this.businessName + ", traceId=" + this.traceId + ", missionId=" + this.missionId + ", schemaAttrs=" + this.schemaAttrs + ", schemaString=" + this.schemaString + ", exodus=" + this.exodus + ")";
    }
}
