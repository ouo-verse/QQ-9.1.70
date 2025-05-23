package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "posId", "b", "I", "()I", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "c", "Z", "()Z", "enableShowMask", "e", GetAdInfoRequest.SOURCE_FROM, "", "Ljava/util/List;", "()Ljava/util/List;", "extIds", "<init>", "(Ljava/lang/String;IZLjava/lang/String;Ljava/util/List;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.adv.kuikly.cardad.d, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasKuiklyCardAdReqParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String posId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int busiType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableShowMask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sourceFrom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> extIds;

    public VasKuiklyCardAdReqParams(@Nullable String str, int i3, boolean z16, @NotNull String sourceFrom, @NotNull List<String> extIds) {
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        Intrinsics.checkNotNullParameter(extIds, "extIds");
        this.posId = str;
        this.busiType = i3;
        this.enableShowMask = z16;
        this.sourceFrom = sourceFrom;
        this.extIds = extIds;
    }

    /* renamed from: a, reason: from getter */
    public final int getBusiType() {
        return this.busiType;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableShowMask() {
        return this.enableShowMask;
    }

    @NotNull
    public final List<String> c() {
        return this.extIds;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getPosId() {
        return this.posId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasKuiklyCardAdReqParams)) {
            return false;
        }
        VasKuiklyCardAdReqParams vasKuiklyCardAdReqParams = (VasKuiklyCardAdReqParams) other;
        if (Intrinsics.areEqual(this.posId, vasKuiklyCardAdReqParams.posId) && this.busiType == vasKuiklyCardAdReqParams.busiType && this.enableShowMask == vasKuiklyCardAdReqParams.enableShowMask && Intrinsics.areEqual(this.sourceFrom, vasKuiklyCardAdReqParams.sourceFrom) && Intrinsics.areEqual(this.extIds, vasKuiklyCardAdReqParams.extIds)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.posId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = ((hashCode * 31) + this.busiType) * 31;
        boolean z16 = this.enableShowMask;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((i3 + i16) * 31) + this.sourceFrom.hashCode()) * 31) + this.extIds.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasKuiklyCardAdReqParams(posId=" + this.posId + ", busiType=" + this.busiType + ", enableShowMask=" + this.enableShowMask + ", sourceFrom=" + this.sourceFrom + ", extIds=" + this.extIds + ')';
    }
}
