package com.tencent.mobileqq.qqecommerce.biz.sdk.api;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u001e\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001*B?\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b'\u0010(J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000bH\u00c6\u0003JG\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u000bH\u00d6\u0001R\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u0017\u0010\u0016\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b&\u0010!\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/ECQQRemoteResponse;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "", "component1", "component2", "", "component3", "", "component4", "component5", "component6", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "code", "msg", "data", "channelCode", "channelMsg", "copy", "toString", "J", "getRequestId", "()J", "I", "getCode", "()I", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "[B", "getData", "()[B", "getChannelCode", "getChannelMsg", "<init>", "(JILjava/lang/String;[BILjava/lang/String;)V", "Companion", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class ECQQRemoteResponse implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int channelCode;

    @NotNull
    private final String channelMsg;
    private final int code;

    @Nullable
    private final byte[] data;

    @NotNull
    private final String msg;
    private final long requestId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/ECQQRemoteResponse$a;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lorg/json/JSONObject;", "data", "", "channelCode", "", "channelMsg", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/ECQQRemoteResponse;", "a", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ECQQRemoteResponse b(Companion companion, long j3, JSONObject jSONObject, int i3, String str, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                i3 = 0;
            }
            int i17 = i3;
            if ((i16 & 8) != 0) {
                str = "";
            }
            return companion.a(j3, jSONObject, i17, str);
        }

        @NotNull
        public final ECQQRemoteResponse a(long requestId, @NotNull JSONObject data, int channelCode, @NotNull String channelMsg) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(channelMsg, "channelMsg");
            String jSONObject = data.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
            byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return new ECQQRemoteResponse(requestId, 0, "", bytes, channelCode, channelMsg);
        }

        Companion() {
        }
    }

    public ECQQRemoteResponse(long j3, int i3, @NotNull String msg2, @Nullable byte[] bArr, int i16, @NotNull String channelMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(channelMsg, "channelMsg");
        this.requestId = j3;
        this.code = i3;
        this.msg = msg2;
        this.data = bArr;
        this.channelCode = i16;
        this.channelMsg = channelMsg;
    }

    public static /* synthetic */ ECQQRemoteResponse copy$default(ECQQRemoteResponse eCQQRemoteResponse, long j3, int i3, String str, byte[] bArr, int i16, String str2, int i17, Object obj) {
        long j16;
        int i18;
        String str3;
        byte[] bArr2;
        int i19;
        String str4;
        if ((i17 & 1) != 0) {
            j16 = eCQQRemoteResponse.requestId;
        } else {
            j16 = j3;
        }
        if ((i17 & 2) != 0) {
            i18 = eCQQRemoteResponse.code;
        } else {
            i18 = i3;
        }
        if ((i17 & 4) != 0) {
            str3 = eCQQRemoteResponse.msg;
        } else {
            str3 = str;
        }
        if ((i17 & 8) != 0) {
            bArr2 = eCQQRemoteResponse.data;
        } else {
            bArr2 = bArr;
        }
        if ((i17 & 16) != 0) {
            i19 = eCQQRemoteResponse.channelCode;
        } else {
            i19 = i16;
        }
        if ((i17 & 32) != 0) {
            str4 = eCQQRemoteResponse.channelMsg;
        } else {
            str4 = str2;
        }
        return eCQQRemoteResponse.copy(j16, i18, str3, bArr2, i19, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: component5, reason: from getter */
    public final int getChannelCode() {
        return this.channelCode;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getChannelMsg() {
        return this.channelMsg;
    }

    @NotNull
    public final ECQQRemoteResponse copy(long requestId, int code, @NotNull String msg2, @Nullable byte[] data, int channelCode, @NotNull String channelMsg) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(channelMsg, "channelMsg");
        return new ECQQRemoteResponse(requestId, code, msg2, data, channelCode, channelMsg);
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
        if (!Intrinsics.areEqual(ECQQRemoteResponse.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse");
        ECQQRemoteResponse eCQQRemoteResponse = (ECQQRemoteResponse) other;
        if (this.requestId != eCQQRemoteResponse.requestId || this.code != eCQQRemoteResponse.code || !Intrinsics.areEqual(this.msg, eCQQRemoteResponse.msg)) {
            return false;
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            byte[] bArr2 = eCQQRemoteResponse.data;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (eCQQRemoteResponse.data != null) {
            return false;
        }
        if (this.channelCode == eCQQRemoteResponse.channelCode && Intrinsics.areEqual(this.channelMsg, eCQQRemoteResponse.channelMsg)) {
            return true;
        }
        return false;
    }

    public final int getChannelCode() {
        return this.channelCode;
    }

    @NotNull
    public final String getChannelMsg() {
        return this.channelMsg;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final byte[] getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

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
    public String toString() {
        return "ECQQRemoteResponse(requestId=" + this.requestId + ", code=" + this.code + ", msg=" + this.msg + ", data=" + Arrays.toString(this.data) + ", channelCode=" + this.channelCode + ", channelMsg=" + this.channelMsg + ')';
    }

    public /* synthetic */ ECQQRemoteResponse(long j3, int i3, String str, byte[] bArr, int i16, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, str, (i17 & 8) != 0 ? null : bArr, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? "" : str2);
    }
}
