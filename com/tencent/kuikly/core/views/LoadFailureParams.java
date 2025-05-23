package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/views/as;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "src", "b", "I", "()I", "errorCode", "c", "errorMsg", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.views.as, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class LoadFailureParams {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String src;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String errorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/views/as$a;", "", "params", "Lcom/tencent/kuikly/core/views/as;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.as$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoadFailureParams a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            return new LoadFailureParams(eVar.q("src", ""), eVar.k("errorCode", -1), eVar.q("errorMsg", ""));
        }

        Companion() {
        }
    }

    public LoadFailureParams(String src, int i3, String errorMsg) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.src = src;
        this.errorCode = i3;
        this.errorMsg = errorMsg;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public int hashCode() {
        return (((this.src.hashCode() * 31) + this.errorCode) * 31) + this.errorMsg.hashCode();
    }

    public String toString() {
        return "LoadFailureParams(src=" + this.src + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadFailureParams)) {
            return false;
        }
        LoadFailureParams loadFailureParams = (LoadFailureParams) other;
        return Intrinsics.areEqual(this.src, loadFailureParams.src) && this.errorCode == loadFailureParams.errorCode && Intrinsics.areEqual(this.errorMsg, loadFailureParams.errorMsg);
    }
}
