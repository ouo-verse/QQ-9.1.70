package com.tencent.mobileqq.qwallet.pet.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u001b\u0010\u0018R\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001a\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/b;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "downloadUrl", "Lcom/tencent/mobileqq/qwallet/pet/data/ModelDownloadState;", "b", "Lcom/tencent/mobileqq/qwallet/pet/data/ModelDownloadState;", "getDownloadState", "()Lcom/tencent/mobileqq/qwallet/pet/data/ModelDownloadState;", "f", "(Lcom/tencent/mobileqq/qwallet/pet/data/ModelDownloadState;)V", "downloadState", "c", "g", "(Ljava/lang/String;)V", "downloadedPath", "d", tl.h.F, "modelName", "Lcom/tencent/mobileqq/qwallet/pet/data/ModelType;", "Lcom/tencent/mobileqq/qwallet/pet/data/ModelType;", "()Lcom/tencent/mobileqq/qwallet/pet/data/ModelType;", "modelType", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/pet/data/ModelDownloadState;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/pet/data/ModelType;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.data.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class DownloadDetail {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String downloadUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ModelDownloadState downloadState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String downloadedPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String modelName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ModelType modelType;

    public DownloadDetail(@Nullable String str, @NotNull ModelDownloadState downloadState, @Nullable String str2, @Nullable String str3, @NotNull ModelType modelType) {
        Intrinsics.checkNotNullParameter(downloadState, "downloadState");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        this.downloadUrl = str;
        this.downloadState = downloadState;
        this.downloadedPath = str2;
        this.modelName = str3;
        this.modelType = modelType;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDownloadedPath() {
        return this.downloadedPath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final ModelType getModelType() {
        return this.modelType;
    }

    public final boolean e() {
        if (this.downloadState == ModelDownloadState.DOWNLOADED && this.downloadedPath != null) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadDetail)) {
            return false;
        }
        DownloadDetail downloadDetail = (DownloadDetail) other;
        if (Intrinsics.areEqual(this.downloadUrl, downloadDetail.downloadUrl) && this.downloadState == downloadDetail.downloadState && Intrinsics.areEqual(this.downloadedPath, downloadDetail.downloadedPath) && Intrinsics.areEqual(this.modelName, downloadDetail.modelName) && this.modelType == downloadDetail.modelType) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull ModelDownloadState modelDownloadState) {
        Intrinsics.checkNotNullParameter(modelDownloadState, "<set-?>");
        this.downloadState = modelDownloadState;
    }

    public final void g(@Nullable String str) {
        this.downloadedPath = str;
    }

    public final void h(@Nullable String str) {
        this.modelName = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.downloadUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = ((hashCode * 31) + this.downloadState.hashCode()) * 31;
        String str2 = this.downloadedPath;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i16 = (hashCode3 + hashCode2) * 31;
        String str3 = this.modelName;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((i16 + i3) * 31) + this.modelType.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadDetail(" + this.downloadState + " " + this.modelName + " " + this.downloadedPath + ")";
    }
}
