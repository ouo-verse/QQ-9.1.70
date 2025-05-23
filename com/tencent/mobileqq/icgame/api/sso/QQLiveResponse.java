package com.tencent.mobileqq.icgame.api.sso;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015JL\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\u0006\u0010\"\u001a\u00020\u0006J\t\u0010#\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "T", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Ljava/lang/Object;)V", "getErrMsg", "()Ljava/lang/String;", "()Z", "getRequest", "()Lcom/tencent/biz/richframework/network/request/BaseRequest;", "getRetCode", "()J", "getRsp", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "equals", "other", "hashCode", "", "isFailed", "toString", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final /* data */ class QQLiveResponse<T> {

    @Nullable
    private final String errMsg;
    private final boolean isSuccess;

    @Nullable
    private final BaseRequest request;
    private final long retCode;

    @Nullable
    private final T rsp;

    public QQLiveResponse(@Nullable BaseRequest baseRequest, boolean z16, long j3, @Nullable String str, @Nullable T t16) {
        this.request = baseRequest;
        this.isSuccess = z16;
        this.retCode = j3;
        this.errMsg = str;
        this.rsp = t16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQLiveResponse copy$default(QQLiveResponse qQLiveResponse, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            baseRequest = qQLiveResponse.request;
        }
        if ((i3 & 2) != 0) {
            z16 = qQLiveResponse.isSuccess;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            j3 = qQLiveResponse.retCode;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            str = qQLiveResponse.errMsg;
        }
        String str2 = str;
        T t16 = obj;
        if ((i3 & 16) != 0) {
            t16 = qQLiveResponse.rsp;
        }
        return qQLiveResponse.copy(baseRequest, z17, j16, str2, t16);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final BaseRequest getRequest() {
        return this.request;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRetCode() {
        return this.retCode;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public final T component5() {
        return this.rsp;
    }

    @NotNull
    public final QQLiveResponse<T> copy(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable T rsp) {
        return new QQLiveResponse<>(request, isSuccess, retCode, errMsg, rsp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQLiveResponse)) {
            return false;
        }
        QQLiveResponse qQLiveResponse = (QQLiveResponse) other;
        if (Intrinsics.areEqual(this.request, qQLiveResponse.request) && this.isSuccess == qQLiveResponse.isSuccess && this.retCode == qQLiveResponse.retCode && Intrinsics.areEqual(this.errMsg, qQLiveResponse.errMsg) && Intrinsics.areEqual(this.rsp, qQLiveResponse.rsp)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public final BaseRequest getRequest() {
        return this.request;
    }

    public final long getRetCode() {
        return this.retCode;
    }

    @Nullable
    public final T getRsp() {
        return this.rsp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        BaseRequest baseRequest = this.request;
        int i3 = 0;
        if (baseRequest == null) {
            hashCode = 0;
        } else {
            hashCode = baseRequest.hashCode();
        }
        int i16 = hashCode * 31;
        boolean z16 = this.isSuccess;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int a16 = (((i16 + i17) * 31) + a.a(this.retCode)) * 31;
        String str = this.errMsg;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i18 = (a16 + hashCode2) * 31;
        T t16 = this.rsp;
        if (t16 != null) {
            i3 = t16.hashCode();
        }
        return i18 + i3;
    }

    public final boolean isFailed() {
        if (this.isSuccess && this.retCode == 0) {
            return false;
        }
        return true;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    @NotNull
    public String toString() {
        return "QQLiveResponse(request=" + this.request + ", isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", errMsg=" + this.errMsg + ", rsp=" + this.rsp + ")";
    }
}
