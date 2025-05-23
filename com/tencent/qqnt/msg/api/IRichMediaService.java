package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.RMBeaconReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.RMCodecInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.UploadStatusParams;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\fH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H&J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\fH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H&J4\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H'J@\u0010'\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010&H&J@\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\f2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`.2\u0006\u0010/\u001a\u00020!H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H&\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/msg/api/IRichMediaService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "beaconReportRMData", "", "reportRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBeaconReportInfo;", "downloadFileForFileInfo", "fileInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonFileInfo;", "Lkotlin/collections/ArrayList;", "savePath", "", "downloadRichMediaInVisit", "downReq", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "getFileMediaFileDir", "getFileMediaFileDirs", "", "getPicMediaFileDir", "isThumb", "", "getPicMediaFileDirs", "getRichMediaCodecInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RMCodecInfo;", "bizType", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "getVideoMediaFileDir", "getVideoMediaFileDirs", "getVideoPlayUrl", "peer", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "msgId", "", "elemId", "videoCodecFormat", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "cb", "Lcom/tencent/qqnt/kernel/nativeinterface/IVideoPlayUrlCallback;", "getVideoPlayUrlV2", "exParams", "Lcom/tencent/qqnt/kernel/nativeinterface/RMReqExParams;", "reportRichMediaMetricCounter", "name", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "count", "updateOnlineVideoElemStatus", "param", "Lcom/tencent/qqnt/kernel/nativeinterface/UploadStatusParams;", "msg_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IRichMediaService extends QRouteApi {
    void beaconReportRMData(@NotNull RMBeaconReportInfo reportRecord);

    void downloadFileForFileInfo(@NotNull ArrayList<CommonFileInfo> fileInfoList, @NotNull String savePath);

    void downloadRichMediaInVisit(@Nullable RichDownLoadReq downReq);

    @NotNull
    String getFileMediaFileDir();

    @NotNull
    List<String> getFileMediaFileDirs();

    @NotNull
    String getPicMediaFileDir(boolean isThumb);

    @NotNull
    List<String> getPicMediaFileDirs(boolean isThumb);

    @Nullable
    RMCodecInfo getRichMediaCodecInfo(@Nullable RMBizTypeEnum bizType);

    @NotNull
    String getVideoMediaFileDir();

    @NotNull
    List<String> getVideoMediaFileDirs();

    @Deprecated(message = "\u4e0d\u5141\u8bb8\u518d\u4f7f\u7528\uff0c\u540e\u9762\u7528getVideoPlayUrlV2\u66ff\u6362")
    void getVideoPlayUrl(@Nullable Contact peer, long msgId, long elemId, @NotNull VideoCodecFormatType videoCodecFormat, @Nullable IVideoPlayUrlCallback cb5);

    void getVideoPlayUrlV2(@Nullable Contact peer, long msgId, long elemId, @Nullable VideoCodecFormatType videoCodecFormat, @Nullable RMReqExParams exParams, @Nullable IVideoPlayUrlCallback cb5);

    void reportRichMediaMetricCounter(@NotNull String name, @Nullable HashMap<String, String> params, long count);

    void updateOnlineVideoElemStatus(@NotNull UploadStatusParams param);
}
