package com.tencent.mobileqq.kandian.biz.detail;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\tJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/detail/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "replaceUrl", "b", "extractParamKey", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.kandian.biz.detail.e, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class UrlOverrideInfo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Gson f239371d = new GsonBuilder().create();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String replaceUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String extractParamKey;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/detail/e$a;", "", "", "jsonStr", "Lcom/tencent/mobileqq/kandian/biz/detail/e;", "a", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.detail.e$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UrlOverrideInfo a(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            Object fromJson = UrlOverrideInfo.f239371d.fromJson(jsonStr, (Class<Object>) UrlOverrideInfo.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(jsonStr, U\u2026OverrideInfo::class.java)");
            return (UrlOverrideInfo) fromJson;
        }

        Companion() {
        }
    }

    /* renamed from: b, reason: from getter */
    public final String getExtractParamKey() {
        return this.extractParamKey;
    }

    /* renamed from: c, reason: from getter */
    public final String getReplaceUrl() {
        return this.replaceUrl;
    }

    public int hashCode() {
        return (this.replaceUrl.hashCode() * 31) + this.extractParamKey.hashCode();
    }

    public String toString() {
        return "UrlOverrideInfo(replaceUrl=" + this.replaceUrl + ", extractParamKey=" + this.extractParamKey + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UrlOverrideInfo)) {
            return false;
        }
        UrlOverrideInfo urlOverrideInfo = (UrlOverrideInfo) other;
        return Intrinsics.areEqual(this.replaceUrl, urlOverrideInfo.replaceUrl) && Intrinsics.areEqual(this.extractParamKey, urlOverrideInfo.extractParamKey);
    }
}
