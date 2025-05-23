package com.tencent.mobileqq.z1.download.data;

import androidx.fragment.app.a;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0010H\u00c6\u0003J\t\u0010,\u001a\u00020\u0012H\u00c6\u0003J\t\u0010-\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\nH\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\t\u00105\u001a\u00020\nH\u00c6\u0003J\t\u00106\u001a\u00020\nH\u00c6\u0003J\u008d\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00c6\u0001J\u0013\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001e\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "Ljava/io/Serializable;", "id", "", "url", "", "version", "filePath", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "size", "", "progress", "", "completeTime", "startTime", "modVersionSimpleData", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "isSilentDownload", "", "needNotification", "diffPatchInfo", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJFJJLcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;ZZLcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "getCompleteTime", "()J", "getDiffPatchInfo", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "getDownloadStatus", "()I", "getFilePath", "()Ljava/lang/String;", "getId", "()Z", "getModVersionSimpleData", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "getNeedNotification", HippyQQPagView.FunctionName.GET_PROGRESS, "()F", "getSize", "getStartTime", "getUrl", "getVersion", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaResData implements Serializable {
    private final long completeTime;

    @Nullable
    private final ZPlanMapDiffPatchInfo diffPatchInfo;
    private final int downloadStatus;

    @NotNull
    private final String filePath;
    private final int id;
    private final boolean isSilentDownload;

    @NotNull
    private final ZPlanModVersionSimpleData modVersionSimpleData;
    private final boolean needNotification;
    private final float progress;
    private final long size;
    private final long startTime;

    @NotNull
    private final String url;

    @NotNull
    private final String version;

    public ZootopiaResData(int i3, @NotNull String url, @NotNull String version, @NotNull String filePath, int i16, long j3, float f16, long j16, long j17, @NotNull ZPlanModVersionSimpleData modVersionSimpleData, boolean z16, boolean z17, @Nullable ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        this.id = i3;
        this.url = url;
        this.version = version;
        this.filePath = filePath;
        this.downloadStatus = i16;
        this.size = j3;
        this.progress = f16;
        this.completeTime = j16;
        this.startTime = j17;
        this.modVersionSimpleData = modVersionSimpleData;
        this.isSilentDownload = z16;
        this.needNotification = z17;
        this.diffPatchInfo = zPlanMapDiffPatchInfo;
    }

    public static /* synthetic */ ZootopiaResData copy$default(ZootopiaResData zootopiaResData, int i3, String str, String str2, String str3, int i16, long j3, float f16, long j16, long j17, ZPlanModVersionSimpleData zPlanModVersionSimpleData, boolean z16, boolean z17, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, int i17, Object obj) {
        int i18;
        String str4;
        String str5;
        String str6;
        int i19;
        long j18;
        float f17;
        long j19;
        long j26;
        ZPlanModVersionSimpleData zPlanModVersionSimpleData2;
        boolean z18;
        boolean z19;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo2;
        if ((i17 & 1) != 0) {
            i18 = zootopiaResData.id;
        } else {
            i18 = i3;
        }
        if ((i17 & 2) != 0) {
            str4 = zootopiaResData.url;
        } else {
            str4 = str;
        }
        if ((i17 & 4) != 0) {
            str5 = zootopiaResData.version;
        } else {
            str5 = str2;
        }
        if ((i17 & 8) != 0) {
            str6 = zootopiaResData.filePath;
        } else {
            str6 = str3;
        }
        if ((i17 & 16) != 0) {
            i19 = zootopiaResData.downloadStatus;
        } else {
            i19 = i16;
        }
        if ((i17 & 32) != 0) {
            j18 = zootopiaResData.size;
        } else {
            j18 = j3;
        }
        if ((i17 & 64) != 0) {
            f17 = zootopiaResData.progress;
        } else {
            f17 = f16;
        }
        if ((i17 & 128) != 0) {
            j19 = zootopiaResData.completeTime;
        } else {
            j19 = j16;
        }
        if ((i17 & 256) != 0) {
            j26 = zootopiaResData.startTime;
        } else {
            j26 = j17;
        }
        if ((i17 & 512) != 0) {
            zPlanModVersionSimpleData2 = zootopiaResData.modVersionSimpleData;
        } else {
            zPlanModVersionSimpleData2 = zPlanModVersionSimpleData;
        }
        if ((i17 & 1024) != 0) {
            z18 = zootopiaResData.isSilentDownload;
        } else {
            z18 = z16;
        }
        boolean z26 = z18;
        if ((i17 & 2048) != 0) {
            z19 = zootopiaResData.needNotification;
        } else {
            z19 = z17;
        }
        if ((i17 & 4096) != 0) {
            zPlanMapDiffPatchInfo2 = zootopiaResData.diffPatchInfo;
        } else {
            zPlanMapDiffPatchInfo2 = zPlanMapDiffPatchInfo;
        }
        return zootopiaResData.copy(i18, str4, str5, str6, i19, j18, f17, j19, j26, zPlanModVersionSimpleData2, z26, z19, zPlanMapDiffPatchInfo2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsSilentDownload() {
        return this.isSilentDownload;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getNeedNotification() {
        return this.needNotification;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component7, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCompleteTime() {
        return this.completeTime;
    }

    /* renamed from: component9, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final ZootopiaResData copy(int id5, @NotNull String url, @NotNull String version, @NotNull String filePath, int downloadStatus, long size, float progress, long completeTime, long startTime, @NotNull ZPlanModVersionSimpleData modVersionSimpleData, boolean isSilentDownload, boolean needNotification, @Nullable ZPlanMapDiffPatchInfo diffPatchInfo) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        return new ZootopiaResData(id5, url, version, filePath, downloadStatus, size, progress, completeTime, startTime, modVersionSimpleData, isSilentDownload, needNotification, diffPatchInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaResData)) {
            return false;
        }
        ZootopiaResData zootopiaResData = (ZootopiaResData) other;
        if (this.id == zootopiaResData.id && Intrinsics.areEqual(this.url, zootopiaResData.url) && Intrinsics.areEqual(this.version, zootopiaResData.version) && Intrinsics.areEqual(this.filePath, zootopiaResData.filePath) && this.downloadStatus == zootopiaResData.downloadStatus && this.size == zootopiaResData.size && Float.compare(this.progress, zootopiaResData.progress) == 0 && this.completeTime == zootopiaResData.completeTime && this.startTime == zootopiaResData.startTime && Intrinsics.areEqual(this.modVersionSimpleData, zootopiaResData.modVersionSimpleData) && this.isSilentDownload == zootopiaResData.isSilentDownload && this.needNotification == zootopiaResData.needNotification && Intrinsics.areEqual(this.diffPatchInfo, zootopiaResData.diffPatchInfo)) {
            return true;
        }
        return false;
    }

    public final long getCompleteTime() {
        return this.completeTime;
    }

    @Nullable
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    public final boolean getNeedNotification() {
        return this.needNotification;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((this.id * 31) + this.url.hashCode()) * 31) + this.version.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.downloadStatus) * 31) + a.a(this.size)) * 31) + Float.floatToIntBits(this.progress)) * 31) + a.a(this.completeTime)) * 31) + a.a(this.startTime)) * 31) + this.modVersionSimpleData.hashCode()) * 31;
        boolean z16 = this.isSilentDownload;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.needNotification;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffPatchInfo;
        if (zPlanMapDiffPatchInfo == null) {
            hashCode = 0;
        } else {
            hashCode = zPlanMapDiffPatchInfo.hashCode();
        }
        return i18 + hashCode;
    }

    public final boolean isSilentDownload() {
        return this.isSilentDownload;
    }

    @NotNull
    public String toString() {
        return "ZootopiaResData(id=" + this.id + ", url=" + this.url + ", version=" + this.version + ", filePath=" + this.filePath + ", downloadStatus=" + this.downloadStatus + ", size=" + this.size + ", progress=" + this.progress + ", completeTime=" + this.completeTime + ", startTime=" + this.startTime + ", modVersionSimpleData=" + this.modVersionSimpleData + ", isSilentDownload=" + this.isSilentDownload + ", needNotification=" + this.needNotification + ", diffPatchInfo=" + this.diffPatchInfo + ')';
    }

    public /* synthetic */ ZootopiaResData(int i3, String str, String str2, String str3, int i16, long j3, float f16, long j16, long j17, ZPlanModVersionSimpleData zPlanModVersionSimpleData, boolean z16, boolean z17, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, i16, j3, f16, j16, j17, zPlanModVersionSimpleData, (i17 & 1024) != 0 ? false : z16, (i17 & 2048) != 0 ? false : z17, (i17 & 4096) != 0 ? null : zPlanMapDiffPatchInfo);
    }
}
