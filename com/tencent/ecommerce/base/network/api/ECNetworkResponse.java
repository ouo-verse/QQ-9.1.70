package com.tencent.ecommerce.base.network.api;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB+\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/d;", BdhLogUtil.LogTag.Tag_Req, "", "", "e", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "message", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "d", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.network.api.d, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECNetworkResponse<R> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String message;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final R data;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceInfo;

    public ECNetworkResponse(int i3, @NotNull String str, @Nullable R r16, @NotNull String str2) {
        this.code = i3;
        this.message = str;
        this.data = r16;
        this.traceInfo = str2;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final R b() {
        return this.data;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    @NotNull
    public final String e() {
        return "ECNetworkResponse(code=" + this.code + " msg=" + this.message + ')';
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECNetworkResponse) {
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) other;
                if (this.code != eCNetworkResponse.code || !Intrinsics.areEqual(this.message, eCNetworkResponse.message) || !Intrinsics.areEqual(this.data, eCNetworkResponse.data) || !Intrinsics.areEqual(this.traceInfo, eCNetworkResponse.traceInfo)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.code * 31;
        String str = this.message;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        R r16 = this.data;
        if (r16 != null) {
            i16 = r16.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.traceInfo;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "ECNetworkResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ", traceInfo=" + this.traceInfo + ")";
    }

    public /* synthetic */ ECNetworkResponse(int i3, String str, Object obj, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, obj, (i16 & 8) != 0 ? "" : str2);
    }
}
