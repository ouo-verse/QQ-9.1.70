package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.PicDownParams;
import com.tencent.qqnt.kernel.nativeinterface.PicReqParams;
import com.tencent.qqnt.kernel.nativeinterface.RMBeaconReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.RMCodecInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.UploadStatusParams;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoRequestWay;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH'J@\u0010\u0012\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H&J(\u0010\"\u001a\u00020\r2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2\u0006\u0010!\u001a\u00020\u001bH&J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H&J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020&H&J\u0014\u0010-\u001a\u0004\u0018\u00010,2\b\u0010+\u001a\u0004\u0018\u00010*H&J\u0010\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020.H&\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/kernel/api/ab;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgId", "elemId", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "videoCodecFormatType", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoRequestWay;", "videoRequestWay", "Lcom/tencent/qqnt/kernel/nativeinterface/IVideoPlayUrlCallback;", "cb", "", "getVideoPlayUrl", "videoCodecFormat", "Lcom/tencent/qqnt/kernel/nativeinterface/RMReqExParams;", "exParams", "getVideoPlayUrlV2", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "downReq", "downloadRichMediaInVisit", "", "elementType", "downType", "", "isTemp", "", "getRichMediaFileDir", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonFileInfo;", "Lkotlin/collections/ArrayList;", "fileInfoList", "savePath", "downloadFileForFileInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/UploadStatusParams;", "param", "updateOnlineVideoElemStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/PicReqParams;", "picInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PicDownParams;", "queryPicDownloadSize", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "bizType", "Lcom/tencent/qqnt/kernel/nativeinterface/RMCodecInfo;", "getRichMediaCodecInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBeaconReportInfo;", "reportRecord", "beaconReportRMData", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ab extends j {
    void beaconReportRMData(@NotNull RMBeaconReportInfo reportRecord);

    void downloadFileForFileInfo(@NotNull ArrayList<CommonFileInfo> fileInfoList, @NotNull String savePath);

    void downloadRichMediaInVisit(@Nullable RichDownLoadReq downReq);

    @Nullable
    RMCodecInfo getRichMediaCodecInfo(@Nullable RMBizTypeEnum bizType);

    @NotNull
    String getRichMediaFileDir(int elementType, int downType, boolean isTemp);

    @Deprecated(message = "\u4e0d\u5141\u8bb8\u518d\u4f7f\u7528\uff0c\u540e\u9762\u7528getVideoPlayUrlV2\u66ff\u6362")
    void getVideoPlayUrl(@Nullable Contact peer, long msgId, long elemId, @NotNull VideoCodecFormatType videoCodecFormatType, @NotNull VideoRequestWay videoRequestWay, @Nullable IVideoPlayUrlCallback cb5);

    void getVideoPlayUrlV2(@Nullable Contact peer, long msgId, long elemId, @Nullable VideoCodecFormatType videoCodecFormat, @Nullable RMReqExParams exParams, @Nullable IVideoPlayUrlCallback cb5);

    @Nullable
    PicDownParams queryPicDownloadSize(@NotNull PicReqParams picInfo);

    void updateOnlineVideoElemStatus(@NotNull UploadStatusParams param);
}
