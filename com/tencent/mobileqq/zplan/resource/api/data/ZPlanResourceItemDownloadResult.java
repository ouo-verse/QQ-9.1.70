package com.tencent.mobileqq.zplan.resource.api.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010)\u001a\u00020\n\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\bK\u0010LJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R$\u0010.\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b\u0019\u0010+\"\u0004\b,\u0010-R$\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b0\u0010\u0016R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\r\u00105\"\u0004\b6\u00107R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010C\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R$\u0010E\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b/\u0010\u0014\"\u0004\bD\u0010\u0016R$\u0010G\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\bF\u0010\u0016R$\u0010J\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0012\u001a\u0004\b:\u0010\u0014\"\u0004\bI\u0010\u0016\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/data/d;", "", "data", "", "l", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "a", "Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "b", "()Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "downloadTaskInfo", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setFileSavePath", "(Ljava/lang/String;)V", "fileSavePath", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "c", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "f", "()Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "setFullUrlInfo", "(Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;)V", "fullUrlInfo", "d", "Z", "j", "()Z", "setFinished", "(Z)V", "isFinished", "k", "setSuccess", "isSuccess", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setErrCode", "(Ljava/lang/Integer;)V", "errCode", "g", "setErrMsg", "errMsg", "", h.F, "Ljava/lang/Float;", "()Ljava/lang/Float;", "setDownloadProgress", "(Ljava/lang/Float;)V", "downloadProgress", "", "i", "Ljava/lang/Long;", "getWrittenBytes", "()Ljava/lang/Long;", "setWrittenBytes", "(Ljava/lang/Long;)V", "writtenBytes", "getTotalBytes", "setTotalBytes", "totalBytes", "setResHubExtraDesc", "resHubExtraDesc", "setResHubLocalPath", "resHubLocalPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setResHubOriginalPath", "resHubOriginalPath", "<init>", "(Lcom/tencent/mobileqq/zplan/resource/api/data/c;Ljava/lang/String;Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;ZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.resource.api.data.d, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanResourceItemDownloadResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanResourceDownloadTask downloadTaskInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String fileSavePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ZPlanResDownloadUrlRsp fullUrlInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFinished;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSuccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private Integer errCode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String errMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private Float downloadProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private Long writtenBytes;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private Long totalBytes;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String resHubExtraDesc;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String resHubLocalPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String resHubOriginalPath;

    public ZPlanResourceItemDownloadResult(ZPlanResourceDownloadTask downloadTaskInfo, String str, ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp, boolean z16, boolean z17, Integer num, String str2, Float f16, Long l3, Long l16, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(downloadTaskInfo, "downloadTaskInfo");
        this.downloadTaskInfo = downloadTaskInfo;
        this.fileSavePath = str;
        this.fullUrlInfo = zPlanResDownloadUrlRsp;
        this.isFinished = z16;
        this.isSuccess = z17;
        this.errCode = num;
        this.errMsg = str2;
        this.downloadProgress = f16;
        this.writtenBytes = l3;
        this.totalBytes = l16;
        this.resHubExtraDesc = str3;
        this.resHubLocalPath = str4;
        this.resHubOriginalPath = str5;
    }

    /* renamed from: a, reason: from getter */
    public final Float getDownloadProgress() {
        return this.downloadProgress;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanResourceDownloadTask getDownloadTaskInfo() {
        return this.downloadTaskInfo;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getErrCode() {
        return this.errCode;
    }

    /* renamed from: d, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: e, reason: from getter */
    public final String getFileSavePath() {
        return this.fileSavePath;
    }

    /* renamed from: f, reason: from getter */
    public final ZPlanResDownloadUrlRsp getFullUrlInfo() {
        return this.fullUrlInfo;
    }

    /* renamed from: g, reason: from getter */
    public final String getResHubExtraDesc() {
        return this.resHubExtraDesc;
    }

    /* renamed from: h, reason: from getter */
    public final String getResHubLocalPath() {
        return this.resHubLocalPath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.downloadTaskInfo.hashCode() * 31;
        String str = this.fileSavePath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp = this.fullUrlInfo;
        int hashCode3 = (hashCode2 + (zPlanResDownloadUrlRsp == null ? 0 : zPlanResDownloadUrlRsp.hashCode())) * 31;
        boolean z16 = this.isFinished;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        boolean z17 = this.isSuccess;
        int i17 = (i16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        Integer num = this.errCode;
        int hashCode4 = (i17 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.errMsg;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f16 = this.downloadProgress;
        int hashCode6 = (hashCode5 + (f16 == null ? 0 : f16.hashCode())) * 31;
        Long l3 = this.writtenBytes;
        int hashCode7 = (hashCode6 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l16 = this.totalBytes;
        int hashCode8 = (hashCode7 + (l16 == null ? 0 : l16.hashCode())) * 31;
        String str3 = this.resHubExtraDesc;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resHubLocalPath;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.resHubOriginalPath;
        return hashCode10 + (str5 != null ? str5.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getResHubOriginalPath() {
        return this.resHubOriginalPath;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void l(ZPlanResourceItemDownloadResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.isFinished && !data.isFinished) {
            QLog.e("ZPLanSceneResource_DownloadHandler", 1, "updateData status error, downloadProgress= " + data.downloadProgress + ", isSuccess= " + this.isSuccess + " - " + data.downloadTaskInfo.getUniqueTaskId(), new Throwable("TEST"));
        } else {
            this.isFinished = data.isFinished;
            this.isSuccess = data.isSuccess;
            this.fileSavePath = data.fileSavePath;
            this.fullUrlInfo = data.fullUrlInfo;
            this.resHubExtraDesc = data.resHubExtraDesc;
            this.resHubLocalPath = data.resHubLocalPath;
            this.resHubOriginalPath = data.resHubOriginalPath;
        }
        this.errCode = data.errCode;
        this.errMsg = data.errMsg;
        this.downloadProgress = data.downloadProgress;
        this.writtenBytes = data.writtenBytes;
        this.totalBytes = data.totalBytes;
    }

    public String toString() {
        return "ZPlanResourceItemDownloadResult(downloadTaskInfo=" + this.downloadTaskInfo + ", fileSavePath=" + this.fileSavePath + ", fullUrlInfo=" + this.fullUrlInfo + ", isFinished=" + this.isFinished + ", isSuccess=" + this.isSuccess + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", downloadProgress=" + this.downloadProgress + ", writtenBytes=" + this.writtenBytes + ", totalBytes=" + this.totalBytes + ", resHubExtraDesc=" + this.resHubExtraDesc + ", resHubLocalPath=" + this.resHubLocalPath + ", resHubOriginalPath=" + this.resHubOriginalPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResourceItemDownloadResult)) {
            return false;
        }
        ZPlanResourceItemDownloadResult zPlanResourceItemDownloadResult = (ZPlanResourceItemDownloadResult) other;
        return Intrinsics.areEqual(this.downloadTaskInfo, zPlanResourceItemDownloadResult.downloadTaskInfo) && Intrinsics.areEqual(this.fileSavePath, zPlanResourceItemDownloadResult.fileSavePath) && Intrinsics.areEqual(this.fullUrlInfo, zPlanResourceItemDownloadResult.fullUrlInfo) && this.isFinished == zPlanResourceItemDownloadResult.isFinished && this.isSuccess == zPlanResourceItemDownloadResult.isSuccess && Intrinsics.areEqual(this.errCode, zPlanResourceItemDownloadResult.errCode) && Intrinsics.areEqual(this.errMsg, zPlanResourceItemDownloadResult.errMsg) && Intrinsics.areEqual((Object) this.downloadProgress, (Object) zPlanResourceItemDownloadResult.downloadProgress) && Intrinsics.areEqual(this.writtenBytes, zPlanResourceItemDownloadResult.writtenBytes) && Intrinsics.areEqual(this.totalBytes, zPlanResourceItemDownloadResult.totalBytes) && Intrinsics.areEqual(this.resHubExtraDesc, zPlanResourceItemDownloadResult.resHubExtraDesc) && Intrinsics.areEqual(this.resHubLocalPath, zPlanResourceItemDownloadResult.resHubLocalPath) && Intrinsics.areEqual(this.resHubOriginalPath, zPlanResourceItemDownloadResult.resHubOriginalPath);
    }

    public /* synthetic */ ZPlanResourceItemDownloadResult(ZPlanResourceDownloadTask zPlanResourceDownloadTask, String str, ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp, boolean z16, boolean z17, Integer num, String str2, Float f16, Long l3, Long l16, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(zPlanResourceDownloadTask, str, zPlanResDownloadUrlRsp, z16, z17, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? null : f16, (i3 & 256) != 0 ? null : l3, (i3 & 512) != 0 ? null : l16, (i3 & 1024) != 0 ? null : str3, (i3 & 2048) != 0 ? null : str4, (i3 & 4096) != 0 ? null : str5);
    }
}
