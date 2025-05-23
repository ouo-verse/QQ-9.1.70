package com.tencent.biz.qqcircle.immersive.personal.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "d", "(Z)V", "isAllSuccess", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "qqLogoFilePath", "f", "templateFilePath", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.utils.d, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class DownloadResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isAllSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String qqLogoFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String templateFilePath;

    public DownloadResult() {
        this(false, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getQqLogoFilePath() {
        return this.qqLogoFilePath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsAllSuccess() {
        return this.isAllSuccess;
    }

    public final void d(boolean z16) {
        this.isAllSuccess = z16;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qqLogoFilePath = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadResult)) {
            return false;
        }
        DownloadResult downloadResult = (DownloadResult) other;
        if (this.isAllSuccess == downloadResult.isAllSuccess && Intrinsics.areEqual(this.qqLogoFilePath, downloadResult.qqLogoFilePath) && Intrinsics.areEqual(this.templateFilePath, downloadResult.templateFilePath)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateFilePath = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isAllSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.qqLogoFilePath.hashCode()) * 31) + this.templateFilePath.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadResult(isAllSuccess=" + this.isAllSuccess + ", qqLogoFilePath=" + this.qqLogoFilePath + ", templateFilePath=" + this.templateFilePath + ")";
    }

    public DownloadResult(boolean z16, @NotNull String qqLogoFilePath, @NotNull String templateFilePath) {
        Intrinsics.checkNotNullParameter(qqLogoFilePath, "qqLogoFilePath");
        Intrinsics.checkNotNullParameter(templateFilePath, "templateFilePath");
        this.isAllSuccess = z16;
        this.qqLogoFilePath = qqLogoFilePath;
        this.templateFilePath = templateFilePath;
    }

    public /* synthetic */ DownloadResult(boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }
}
