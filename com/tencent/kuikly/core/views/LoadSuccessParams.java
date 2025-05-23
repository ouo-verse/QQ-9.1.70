package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/views/au;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "src", "<init>", "(Ljava/lang/String;)V", "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.views.au, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class LoadSuccessParams {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String src;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/views/au$a;", "", "params", "Lcom/tencent/kuikly/core/views/au;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.au$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoadSuccessParams a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            return new LoadSuccessParams(eVar.q("src", ""));
        }

        Companion() {
        }
    }

    public LoadSuccessParams(String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.src = src;
    }

    public int hashCode() {
        return this.src.hashCode();
    }

    public String toString() {
        return "LoadSuccessParams(src=" + this.src + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LoadSuccessParams) && Intrinsics.areEqual(this.src, ((LoadSuccessParams) other).src);
    }
}
