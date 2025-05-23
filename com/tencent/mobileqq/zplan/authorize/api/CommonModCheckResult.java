package com.tencent.mobileqq.zplan.authorize.api;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/CommonModCheckResult;", "Ljava/io/Serializable;", "downloadText", "", "loadingText", "newGuideUrl", "modInfoListByteArrayList", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDownloadText", "()Ljava/lang/String;", "getLoadingText", "getModInfoListByteArrayList", "()Ljava/util/List;", "getNewGuideUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class CommonModCheckResult implements Serializable {
    private final String downloadText;
    private final String loadingText;
    private final List<byte[]> modInfoListByteArrayList;
    private final String newGuideUrl;

    public CommonModCheckResult(String downloadText, String loadingText, String newGuideUrl, List<byte[]> modInfoListByteArrayList) {
        Intrinsics.checkNotNullParameter(downloadText, "downloadText");
        Intrinsics.checkNotNullParameter(loadingText, "loadingText");
        Intrinsics.checkNotNullParameter(newGuideUrl, "newGuideUrl");
        Intrinsics.checkNotNullParameter(modInfoListByteArrayList, "modInfoListByteArrayList");
        this.downloadText = downloadText;
        this.loadingText = loadingText;
        this.newGuideUrl = newGuideUrl;
        this.modInfoListByteArrayList = modInfoListByteArrayList;
    }

    /* renamed from: component1, reason: from getter */
    public final String getDownloadText() {
        return this.downloadText;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLoadingText() {
        return this.loadingText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNewGuideUrl() {
        return this.newGuideUrl;
    }

    public final List<byte[]> component4() {
        return this.modInfoListByteArrayList;
    }

    public final CommonModCheckResult copy(String downloadText, String loadingText, String newGuideUrl, List<byte[]> modInfoListByteArrayList) {
        Intrinsics.checkNotNullParameter(downloadText, "downloadText");
        Intrinsics.checkNotNullParameter(loadingText, "loadingText");
        Intrinsics.checkNotNullParameter(newGuideUrl, "newGuideUrl");
        Intrinsics.checkNotNullParameter(modInfoListByteArrayList, "modInfoListByteArrayList");
        return new CommonModCheckResult(downloadText, loadingText, newGuideUrl, modInfoListByteArrayList);
    }

    public final String getDownloadText() {
        return this.downloadText;
    }

    public final String getLoadingText() {
        return this.loadingText;
    }

    public final List<byte[]> getModInfoListByteArrayList() {
        return this.modInfoListByteArrayList;
    }

    public final String getNewGuideUrl() {
        return this.newGuideUrl;
    }

    public int hashCode() {
        return (((((this.downloadText.hashCode() * 31) + this.loadingText.hashCode()) * 31) + this.newGuideUrl.hashCode()) * 31) + this.modInfoListByteArrayList.hashCode();
    }

    public String toString() {
        return "CommonModCheckResult(downloadText=" + this.downloadText + ", loadingText=" + this.loadingText + ", newGuideUrl=" + this.newGuideUrl + ", modInfoListByteArrayList=" + this.modInfoListByteArrayList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonModCheckResult copy$default(CommonModCheckResult commonModCheckResult, String str, String str2, String str3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = commonModCheckResult.downloadText;
        }
        if ((i3 & 2) != 0) {
            str2 = commonModCheckResult.loadingText;
        }
        if ((i3 & 4) != 0) {
            str3 = commonModCheckResult.newGuideUrl;
        }
        if ((i3 & 8) != 0) {
            list = commonModCheckResult.modInfoListByteArrayList;
        }
        return commonModCheckResult.copy(str, str2, str3, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonModCheckResult)) {
            return false;
        }
        CommonModCheckResult commonModCheckResult = (CommonModCheckResult) other;
        return Intrinsics.areEqual(this.downloadText, commonModCheckResult.downloadText) && Intrinsics.areEqual(this.loadingText, commonModCheckResult.loadingText) && Intrinsics.areEqual(this.newGuideUrl, commonModCheckResult.newGuideUrl) && Intrinsics.areEqual(this.modInfoListByteArrayList, commonModCheckResult.modInfoListByteArrayList);
    }
}
