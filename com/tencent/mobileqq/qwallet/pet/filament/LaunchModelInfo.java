package com.tencent.mobileqq.qwallet.pet.filament;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "dirPath", "b", "f", WadlProxyConsts.PARAM_FILENAME, "actionTypeName", "d", "I", "()I", "beginTime", "e", "endTime", "elapseAnimTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "g", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.filament.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class LaunchModelInfo {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dirPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String fileName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String actionTypeName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int beginTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int elapseAnimTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/b$a;", "", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "downloadDetail", "", "actionTypeName", "Lcom/tencent/mobileqq/qwallet/pet/data/k;", "subAction", "Lcom/tencent/mobileqq/qwallet/pet/filament/b;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.filament.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ LaunchModelInfo b(Companion companion, DownloadDetail downloadDetail, String str, k kVar, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                kVar = null;
            }
            return companion.a(downloadDetail, str, kVar);
        }

        @Nullable
        public final LaunchModelInfo a(@Nullable DownloadDetail downloadDetail, @Nullable String actionTypeName, @Nullable k subAction) {
            String downloadedPath;
            String modelName;
            int i3;
            int i16;
            int i17;
            if (downloadDetail == null || (downloadedPath = downloadDetail.getDownloadedPath()) == null || (modelName = downloadDetail.getModelName()) == null) {
                return null;
            }
            if (subAction != null) {
                i3 = subAction.getBeginTime();
            } else {
                i3 = 0;
            }
            if (subAction != null) {
                i16 = subAction.getEndTime();
            } else {
                i16 = 0;
            }
            if (subAction != null) {
                i17 = subAction.getElapseAnimTime();
            } else {
                i17 = 0;
            }
            return new LaunchModelInfo(downloadedPath, modelName, actionTypeName, i3, i16, i17);
        }

        Companion() {
        }
    }

    public LaunchModelInfo(@NotNull String dirPath, @NotNull String fileName, @Nullable String str, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(dirPath, "dirPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.dirPath = dirPath;
        this.fileName = fileName;
        this.actionTypeName = str;
        this.beginTime = i3;
        this.endTime = i16;
        this.elapseAnimTime = i17;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getActionTypeName() {
        return this.actionTypeName;
    }

    /* renamed from: b, reason: from getter */
    public final int getBeginTime() {
        return this.beginTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDirPath() {
        return this.dirPath;
    }

    /* renamed from: d, reason: from getter */
    public final int getElapseAnimTime() {
        return this.elapseAnimTime;
    }

    /* renamed from: e, reason: from getter */
    public final int getEndTime() {
        return this.endTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LaunchModelInfo)) {
            return false;
        }
        LaunchModelInfo launchModelInfo = (LaunchModelInfo) other;
        if (Intrinsics.areEqual(this.dirPath, launchModelInfo.dirPath) && Intrinsics.areEqual(this.fileName, launchModelInfo.fileName) && Intrinsics.areEqual(this.actionTypeName, launchModelInfo.actionTypeName) && this.beginTime == launchModelInfo.beginTime && this.endTime == launchModelInfo.endTime && this.elapseAnimTime == launchModelInfo.elapseAnimTime) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.dirPath.hashCode() * 31) + this.fileName.hashCode()) * 31;
        String str = this.actionTypeName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((hashCode2 + hashCode) * 31) + this.beginTime) * 31) + this.endTime) * 31) + this.elapseAnimTime;
    }

    @NotNull
    public String toString() {
        return "LaunchModelInfo(dirPath=" + this.dirPath + ", fileName=" + this.fileName + ", actionTypeName=" + this.actionTypeName + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", elapseAnimTime=" + this.elapseAnimTime + ")";
    }
}
