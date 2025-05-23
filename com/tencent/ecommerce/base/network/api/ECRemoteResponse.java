package com.tencent.ecommerce.base.network.api;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tBI\u0012\u0006\u0010#\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0007\u00a2\u0006\u0004\b1\u00102J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010%\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010'\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u0019\u0010+\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b$\u0010*R\u0017\u0010-\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010.\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b/\u0010\u0015\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/e;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "e", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "compressType", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "compressRatio", "c", "j", "o", "unCompressSucceed", "", "J", "k", "()J", "p", "(J)V", "unCompressTimeCost", h.F, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "f", "code", "g", "msg", "", "[B", "()[B", "data", "i", "channelCode", "channelMsg", DomainData.DOMAIN_NAME, MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "<init>", "(JILjava/lang/String;[BILjava/lang/String;Ljava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.network.api.e, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECRemoteResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int compressType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String compressRatio;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int unCompressSucceed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long unCompressTimeCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long requestId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String msg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final byte[] data;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelMsg;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceInfo;

    public ECRemoteResponse(long j3, int i3, @NotNull String str, @Nullable byte[] bArr, int i16, @NotNull String str2, @NotNull String str3) {
        this.requestId = j3;
        this.code = i3;
        this.msg = str;
        this.data = bArr;
        this.channelCode = i16;
        this.channelMsg = str2;
        this.traceInfo = str3;
        this.compressRatio = "0.0000";
    }

    /* renamed from: a, reason: from getter */
    public final int getChannelCode() {
        return this.channelCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelMsg() {
        return this.channelMsg;
    }

    /* renamed from: c, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCompressRatio() {
        return this.compressRatio;
    }

    /* renamed from: e, reason: from getter */
    public final int getCompressType() {
        return this.compressType;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ECRemoteResponse.class, cls)) {
            return false;
        }
        if (other != null) {
            ECRemoteResponse eCRemoteResponse = (ECRemoteResponse) other;
            if (this.requestId != eCRemoteResponse.requestId || this.code != eCRemoteResponse.code || (!Intrinsics.areEqual(this.msg, eCRemoteResponse.msg))) {
                return false;
            }
            byte[] bArr = this.data;
            if (bArr != null) {
                byte[] bArr2 = eCRemoteResponse.data;
                if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                    return false;
                }
            } else if (eCRemoteResponse.data != null) {
                return false;
            }
            if (this.channelCode == eCRemoteResponse.channelCode && !(!Intrinsics.areEqual(this.channelMsg, eCRemoteResponse.channelMsg))) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.network.api.ECRemoteResponse");
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: h, reason: from getter */
    public final long getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        int i3;
        int a16 = ((((androidx.fragment.app.a.a(this.requestId) * 31) + this.code) * 31) + this.msg.hashCode()) * 31;
        byte[] bArr = this.data;
        if (bArr != null) {
            i3 = Arrays.hashCode(bArr);
        } else {
            i3 = 0;
        }
        return ((((a16 + i3) * 31) + this.channelCode) * 31) + this.channelMsg.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    /* renamed from: j, reason: from getter */
    public final int getUnCompressSucceed() {
        return this.unCompressSucceed;
    }

    /* renamed from: k, reason: from getter */
    public final long getUnCompressTimeCost() {
        return this.unCompressTimeCost;
    }

    public final void l(@NotNull String str) {
        this.compressRatio = str;
    }

    public final void m(int i3) {
        this.compressType = i3;
    }

    public final void n(@NotNull String str) {
        this.traceInfo = str;
    }

    public final void o(int i3) {
        this.unCompressSucceed = i3;
    }

    public final void p(long j3) {
        this.unCompressTimeCost = j3;
    }

    @NotNull
    public String toString() {
        return "ECRemoteResponse(requestId=" + this.requestId + ", code=" + this.code + ", msg=" + this.msg + ", data=" + Arrays.toString(this.data) + ", channelCode=" + this.channelCode + ", channelMsg=" + this.channelMsg + ", traceInfo=" + this.traceInfo + ")";
    }

    public /* synthetic */ ECRemoteResponse(long j3, int i3, String str, byte[] bArr, int i16, String str2, String str3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, str, (i17 & 8) != 0 ? null : bArr, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? "" : str2, (i17 & 64) != 0 ? "" : str3);
    }
}
