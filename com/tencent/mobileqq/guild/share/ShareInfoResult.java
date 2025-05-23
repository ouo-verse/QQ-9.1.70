package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b$\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/share/z;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "d", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "secResult", tl.h.F, "shareUrl", "e", "g", "shareInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;", "shareExtendInfo", "i", "(Ljava/lang/String;)V", "longShareUrl", "setShareContentInfoId", "shareContentInfoId", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProShareExtendInfo;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.share.z, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ShareInfoResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProSecurityResult secResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String shareInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProShareExtendInfo shareExtendInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String longShareUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String shareContentInfoId;

    public ShareInfoResult(int i3, @NotNull String errMsg, @Nullable IGProSecurityResult iGProSecurityResult, @NotNull String shareUrl, @NotNull String shareInfo, @Nullable IGProShareExtendInfo iGProShareExtendInfo, @NotNull String longShareUrl, @NotNull String shareContentInfoId) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        Intrinsics.checkNotNullParameter(longShareUrl, "longShareUrl");
        Intrinsics.checkNotNullParameter(shareContentInfoId, "shareContentInfoId");
        this.result = i3;
        this.errMsg = errMsg;
        this.secResult = iGProSecurityResult;
        this.shareUrl = shareUrl;
        this.shareInfo = shareInfo;
        this.shareExtendInfo = iGProShareExtendInfo;
        this.longShareUrl = longShareUrl;
        this.shareContentInfoId = shareContentInfoId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLongShareUrl() {
        return this.longShareUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final IGProSecurityResult getSecResult() {
        return this.secResult;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShareContentInfoId() {
        return this.shareContentInfoId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareInfoResult)) {
            return false;
        }
        ShareInfoResult shareInfoResult = (ShareInfoResult) other;
        if (this.result == shareInfoResult.result && Intrinsics.areEqual(this.errMsg, shareInfoResult.errMsg) && Intrinsics.areEqual(this.secResult, shareInfoResult.secResult) && Intrinsics.areEqual(this.shareUrl, shareInfoResult.shareUrl) && Intrinsics.areEqual(this.shareInfo, shareInfoResult.shareInfo) && Intrinsics.areEqual(this.shareExtendInfo, shareInfoResult.shareExtendInfo) && Intrinsics.areEqual(this.longShareUrl, shareInfoResult.longShareUrl) && Intrinsics.areEqual(this.shareContentInfoId, shareInfoResult.shareContentInfoId)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final IGProShareExtendInfo getShareExtendInfo() {
        return this.shareExtendInfo;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getShareInfo() {
        return this.shareInfo;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.result * 31) + this.errMsg.hashCode()) * 31;
        IGProSecurityResult iGProSecurityResult = this.secResult;
        int i3 = 0;
        if (iGProSecurityResult == null) {
            hashCode = 0;
        } else {
            hashCode = iGProSecurityResult.hashCode();
        }
        int hashCode3 = (((((hashCode2 + hashCode) * 31) + this.shareUrl.hashCode()) * 31) + this.shareInfo.hashCode()) * 31;
        IGProShareExtendInfo iGProShareExtendInfo = this.shareExtendInfo;
        if (iGProShareExtendInfo != null) {
            i3 = iGProShareExtendInfo.hashCode();
        }
        return ((((hashCode3 + i3) * 31) + this.longShareUrl.hashCode()) * 31) + this.shareContentInfoId.hashCode();
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.longShareUrl = str;
    }

    @NotNull
    public String toString() {
        return "ShareInfoResult(result=" + this.result + ", errMsg=" + this.errMsg + ", secResult=" + this.secResult + ", shareUrl=" + this.shareUrl + ", shareInfo=" + this.shareInfo + ", shareExtendInfo=" + this.shareExtendInfo + ", longShareUrl=" + this.longShareUrl + ", shareContentInfoId=" + this.shareContentInfoId + ")";
    }
}
