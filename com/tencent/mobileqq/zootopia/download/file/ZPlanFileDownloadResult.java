package com.tencent.mobileqq.zootopia.download.file;

import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.zootopia.download.BaseDownloadTask;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadEntity;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u001f\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u008d\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\r\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\n\u0012\b\u0010&\u001a\u0004\u0018\u00010\r\u0012\b\u0010'\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bG\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\rH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\rH\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u00b4\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0004\b(\u0010)J\t\u0010*\u001a\u00020\u0004H\u00d6\u0001J\t\u0010+\u001a\u00020\nH\u00d6\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u00d6\u0003R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b2\u00101R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b3\u00101R\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b\u001c\u00105R\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b7\u00108R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b9\u00101R\u0017\u0010\u001f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010 \u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b \u0010:\u001a\u0004\b=\u0010<R\u0019\u0010!\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b>\u00101R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010/\u001a\u0004\b?\u00101R\u0019\u0010#\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010/\u001a\u0004\b@\u00101R\u0019\u0010$\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010/\u001a\u0004\bA\u00101R\u0019\u0010%\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u0015R\u0019\u0010&\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010\u0017R\u0019\u0010'\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b'\u0010D\u001a\u0004\bF\u0010\u0017\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "Ljava/io/Serializable;", "Lnx4/a$b;", "convertToLuaDownloadResult", "", "component1", "component2", "component3", "", "component4", "", "component5", "component6", "", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "()Ljava/lang/Integer;", "component14", "()Ljava/lang/Long;", "component15", "url", "uniqueKey", "downloadId", "isSuccess", QzoneIPCModule.RESULT_CODE, "message", "totalLength", "receivedLength", "savePath", "saveDir", "initSaveName", "realSaveName", "averageSpeed", "costTime", "startTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "getUniqueKey", "getDownloadId", "Z", "()Z", "I", "getResultCode", "()I", "getMessage", "J", "getTotalLength", "()J", "getReceivedLength", "getSavePath", "getSaveDir", "getInitSaveName", "getRealSaveName", "Ljava/lang/Integer;", "getAverageSpeed", "Ljava/lang/Long;", "getCostTime", "getStartTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class ZPlanFileDownloadResult implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer averageSpeed;
    private final Long costTime;
    private final String downloadId;
    private final String initSaveName;
    private final boolean isSuccess;
    private final String message;
    private final String realSaveName;
    private final long receivedLength;
    private final int resultCode;
    private final String saveDir;
    private final String savePath;
    private final Long startTime;
    private final long totalLength;
    private final String uniqueKey;
    private final String url;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult$a;", "", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", "baseDownloadTask", "Lcom/tencent/halley/downloader/DownloaderTask;", "sdkDownloaderTask", "Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "b", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "fileDownloadEntity", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanFileDownloadResult b(BaseDownloadTask baseDownloadTask, DownloaderTask sdkDownloaderTask) {
            Intrinsics.checkNotNullParameter(baseDownloadTask, "baseDownloadTask");
            return new ZPlanFileDownloadResult(baseDownloadTask.getUrl(), baseDownloadTask.getTaskUniqueTraceKey(), baseDownloadTask.getId(), baseDownloadTask.getDownloadStatus() == 5, baseDownloadTask.getDownloadFailCode(), baseDownloadTask.getDownloadFailInfo(), baseDownloadTask.getCurTotalLength(), baseDownloadTask.getCurReceivedLength(), sdkDownloaderTask != null ? sdkDownloaderTask.getFullSavePath() : null, sdkDownloaderTask != null ? sdkDownloaderTask.getFileDir() : null, sdkDownloaderTask != null ? sdkDownloaderTask.getFileName() : null, sdkDownloaderTask != null ? sdkDownloaderTask.getRealSaveName() : null, sdkDownloaderTask != null ? Integer.valueOf(sdkDownloaderTask.getCurAverageSpeed()) : null, sdkDownloaderTask != null ? Long.valueOf(sdkDownloaderTask.getTotalCostTime()) : null, sdkDownloaderTask != null ? Long.valueOf(sdkDownloaderTask.getTaskStartTime()) : null);
        }

        Companion() {
        }

        public final ZPlanFileDownloadResult a(FileDownloadEntity fileDownloadEntity) {
            Intrinsics.checkNotNullParameter(fileDownloadEntity, "fileDownloadEntity");
            String str = fileDownloadEntity.url;
            Intrinsics.checkNotNullExpressionValue(str, "fileDownloadEntity.url");
            FileDownloadManager fileDownloadManager = FileDownloadManager.f328148a;
            int i3 = fileDownloadEntity.category;
            String str2 = fileDownloadEntity.url;
            Intrinsics.checkNotNullExpressionValue(str2, "fileDownloadEntity.url");
            String h16 = fileDownloadManager.h(i3, str2);
            boolean z16 = fileDownloadEntity.downloadStatus == 5;
            long j3 = fileDownloadEntity.size;
            return new ZPlanFileDownloadResult(str, "", h16, z16, 0, "", j3, j3, fileDownloadEntity.filePath, "", null, null, null, 0L, null);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSaveDir() {
        return this.saveDir;
    }

    /* renamed from: component11, reason: from getter */
    public final String getInitSaveName() {
        return this.initSaveName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getRealSaveName() {
        return this.realSaveName;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getAverageSpeed() {
        return this.averageSpeed;
    }

    /* renamed from: component14, reason: from getter */
    public final Long getCostTime() {
        return this.costTime;
    }

    /* renamed from: component15, reason: from getter */
    public final Long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDownloadId() {
        return this.downloadId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component5, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTotalLength() {
        return this.totalLength;
    }

    /* renamed from: component8, reason: from getter */
    public final long getReceivedLength() {
        return this.receivedLength;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSavePath() {
        return this.savePath;
    }

    public final a.b convertToLuaDownloadResult() {
        return new a.b(this.url, Integer.valueOf(this.resultCode), Boolean.valueOf(this.isSuccess), this.message, Boolean.FALSE, null, null, null, null, this.costTime, Long.valueOf(this.totalLength));
    }

    public final Integer getAverageSpeed() {
        return this.averageSpeed;
    }

    public final Long getCostTime() {
        return this.costTime;
    }

    public final String getDownloadId() {
        return this.downloadId;
    }

    public final String getInitSaveName() {
        return this.initSaveName;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRealSaveName() {
        return this.realSaveName;
    }

    public final long getReceivedLength() {
        return this.receivedLength;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getSaveDir() {
        return this.saveDir;
    }

    public final String getSavePath() {
        return this.savePath;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final long getTotalLength() {
        return this.totalLength;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.url.hashCode() * 31) + this.uniqueKey.hashCode()) * 31) + this.downloadId.hashCode()) * 31;
        boolean z16 = this.isSuccess;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((hashCode + i3) * 31) + this.resultCode) * 31) + this.message.hashCode()) * 31) + c.a(this.totalLength)) * 31) + c.a(this.receivedLength)) * 31;
        String str = this.savePath;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.saveDir;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.initSaveName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.realSaveName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.averageSpeed;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Long l3 = this.costTime;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l16 = this.startTime;
        return hashCode8 + (l16 != null ? l16.hashCode() : 0);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public String toString() {
        return "ZPlanFileDownloadResult(url=" + this.url + ", uniqueKey=" + this.uniqueKey + ", downloadId=" + this.downloadId + ", isSuccess=" + this.isSuccess + ", resultCode=" + this.resultCode + ", message=" + this.message + ", totalLength=" + this.totalLength + ", receivedLength=" + this.receivedLength + ", savePath=" + this.savePath + ", saveDir=" + this.saveDir + ", initSaveName=" + this.initSaveName + ", realSaveName=" + this.realSaveName + ", averageSpeed=" + this.averageSpeed + ", costTime=" + this.costTime + ", startTime=" + this.startTime + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanFileDownloadResult)) {
            return false;
        }
        ZPlanFileDownloadResult zPlanFileDownloadResult = (ZPlanFileDownloadResult) other;
        return Intrinsics.areEqual(this.url, zPlanFileDownloadResult.url) && Intrinsics.areEqual(this.uniqueKey, zPlanFileDownloadResult.uniqueKey) && Intrinsics.areEqual(this.downloadId, zPlanFileDownloadResult.downloadId) && this.isSuccess == zPlanFileDownloadResult.isSuccess && this.resultCode == zPlanFileDownloadResult.resultCode && Intrinsics.areEqual(this.message, zPlanFileDownloadResult.message) && this.totalLength == zPlanFileDownloadResult.totalLength && this.receivedLength == zPlanFileDownloadResult.receivedLength && Intrinsics.areEqual(this.savePath, zPlanFileDownloadResult.savePath) && Intrinsics.areEqual(this.saveDir, zPlanFileDownloadResult.saveDir) && Intrinsics.areEqual(this.initSaveName, zPlanFileDownloadResult.initSaveName) && Intrinsics.areEqual(this.realSaveName, zPlanFileDownloadResult.realSaveName) && Intrinsics.areEqual(this.averageSpeed, zPlanFileDownloadResult.averageSpeed) && Intrinsics.areEqual(this.costTime, zPlanFileDownloadResult.costTime) && Intrinsics.areEqual(this.startTime, zPlanFileDownloadResult.startTime);
    }

    public ZPlanFileDownloadResult(String url, String uniqueKey, String downloadId, boolean z16, int i3, String message, long j3, long j16, String str, String str2, String str3, String str4, Integer num, Long l3, Long l16) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(downloadId, "downloadId");
        Intrinsics.checkNotNullParameter(message, "message");
        this.url = url;
        this.uniqueKey = uniqueKey;
        this.downloadId = downloadId;
        this.isSuccess = z16;
        this.resultCode = i3;
        this.message = message;
        this.totalLength = j3;
        this.receivedLength = j16;
        this.savePath = str;
        this.saveDir = str2;
        this.initSaveName = str3;
        this.realSaveName = str4;
        this.averageSpeed = num;
        this.costTime = l3;
        this.startTime = l16;
    }

    public final ZPlanFileDownloadResult copy(String url, String uniqueKey, String downloadId, boolean isSuccess, int resultCode, String message, long totalLength, long receivedLength, String savePath, String saveDir, String initSaveName, String realSaveName, Integer averageSpeed, Long costTime, Long startTime) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(downloadId, "downloadId");
        Intrinsics.checkNotNullParameter(message, "message");
        return new ZPlanFileDownloadResult(url, uniqueKey, downloadId, isSuccess, resultCode, message, totalLength, receivedLength, savePath, saveDir, initSaveName, realSaveName, averageSpeed, costTime, startTime);
    }
}
