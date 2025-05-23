package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\u0012\b\u00103\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J<\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J@\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010$\u001a\u00020\u000f2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!2\u0006\u0010#\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020(H\u0016J\u0014\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u000200H\u0016\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/lm;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRichMediaService;", "Lcom/tencent/qqnt/kernel/api/ab;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgId", "elemId", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "videoCodecFormatType", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoRequestWay;", "videoRequestWay", "Lcom/tencent/qqnt/kernel/nativeinterface/IVideoPlayUrlCallback;", "cb", "", "getVideoPlayUrl", "videoCodecFormat", "Lcom/tencent/qqnt/kernel/nativeinterface/RMReqExParams;", "exParams", "getVideoPlayUrlV2", "", "elementType", "downType", "", "isTemp", "", "getRichMediaFileDir", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "downReq", "downloadRichMediaInVisit", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonFileInfo;", "Lkotlin/collections/ArrayList;", "fileInfoList", "savePath", "downloadFileForFileInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/UploadStatusParams;", "param", "updateOnlineVideoElemStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/PicReqParams;", "picInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PicDownParams;", "queryPicDownloadSize", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "bizType", "Lcom/tencent/qqnt/kernel/nativeinterface/RMCodecInfo;", "getRichMediaCodecInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBeaconReportInfo;", "reportRecord", "beaconReportRMData", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRichMediaService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class lm extends BaseService<IKernelRichMediaService, IKernelRichMediaService> implements com.tencent.qqnt.kernel.api.ab {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm(@Nullable IKernelRichMediaService iKernelRichMediaService, @NotNull py content) {
        super("rich_media", content, iKernelRichMediaService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelRichMediaService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void beaconReportRMData(@NotNull RMBeaconReportInfo reportRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) reportRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(reportRecord, "reportRecord");
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.beaconReportRMData(reportRecord);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void downloadFileForFileInfo(@NotNull ArrayList<CommonFileInfo> fileInfoList, @NotNull String savePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileInfoList, (Object) savePath);
            return;
        }
        Intrinsics.checkNotNullParameter(fileInfoList, "fileInfoList");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.downloadFileForFileInfo(fileInfoList, savePath);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void downloadRichMediaInVisit(@Nullable RichDownLoadReq downReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) downReq);
            return;
        }
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.downloadRichMediaInVisit(downReq);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    @Nullable
    public RMCodecInfo getRichMediaCodecInfo(@Nullable RMBizTypeEnum bizType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RMCodecInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bizType);
        }
        IKernelRichMediaService service = getService();
        if (service != null) {
            return service.getRichMediaCodecInfo(bizType);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    @NotNull
    public String getRichMediaFileDir(int elementType, int downType, boolean isTemp) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(elementType), Integer.valueOf(downType), Boolean.valueOf(isTemp));
        }
        IKernelRichMediaService service = getService();
        if (service != null) {
            str = service.getRichMediaFileDir(elementType, downType, isTemp);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void getVideoPlayUrl(@Nullable Contact peer, long msgId, long elemId, @NotNull VideoCodecFormatType videoCodecFormatType, @NotNull VideoRequestWay videoRequestWay, @Nullable IVideoPlayUrlCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, peer, Long.valueOf(msgId), Long.valueOf(elemId), videoCodecFormatType, videoRequestWay, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(videoCodecFormatType, "videoCodecFormatType");
        Intrinsics.checkNotNullParameter(videoRequestWay, "videoRequestWay");
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.getVideoPlayUrl(peer, msgId, elemId, videoCodecFormatType, videoRequestWay, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void getVideoPlayUrlV2(@Nullable Contact peer, long msgId, long elemId, @Nullable VideoCodecFormatType videoCodecFormat, @Nullable RMReqExParams exParams, @Nullable IVideoPlayUrlCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, peer, Long.valueOf(msgId), Long.valueOf(elemId), videoCodecFormat, exParams, cb5);
            return;
        }
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.getVideoPlayUrlV2(peer, msgId, elemId, videoCodecFormat, exParams, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    @Nullable
    public PicDownParams queryPicDownloadSize(@NotNull PicReqParams picInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PicDownParams) iPatchRedirector.redirect((short) 8, (Object) this, (Object) picInfo);
        }
        Intrinsics.checkNotNullParameter(picInfo, "picInfo");
        IKernelRichMediaService service = getService();
        if (service != null) {
            return service.queryPicDownloadSize(picInfo);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.ab
    public void updateOnlineVideoElemStatus(@NotNull UploadStatusParams param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        IKernelRichMediaService service = getService();
        if (service != null) {
            service.updateOnlineVideoElemStatus(param);
        }
    }
}
