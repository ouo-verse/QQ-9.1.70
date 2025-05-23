package com.tencent.qqnt.msg.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.injector.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqnt.kernel.api.ab;
import com.tencent.qqnt.kernel.nativeinterface.CommonFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.InitGlobalPathConfig;
import com.tencent.qqnt.kernel.nativeinterface.RMBeaconReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.RMCodecInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.UploadStatusParams;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoRequestWay;
import com.tencent.qqnt.kernel.nativeinterface.WrapperEngineGlobalConfig;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J4\u0010\u0016\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J@\u0010\u0019\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0&2\u0006\u0010$\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&H\u0016J\b\u0010*\u001a\u00020\tH\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0&H\u0016J(\u00101\u001a\u00020\u00022\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.2\u0006\u00100\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0016J@\u0010:\u001a\u00020\u00022\u0006\u00105\u001a\u00020\t2&\u00108\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u000106j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`72\u0006\u00109\u001a\u00020\u000fH\u0016R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/msg/api/impl/RichMediaServiceImpl;", "Lcom/tencent/qqnt/msg/api/IRichMediaService;", "", "inject", "", "elementType", "downType", "", "isTemp", "", "getRichMediaFileDir", "newDir", "getOldRichMediaFileDir", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgId", "elemId", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "videoCodecFormat", "Lcom/tencent/qqnt/kernel/nativeinterface/IVideoPlayUrlCallback;", "cb", "getVideoPlayUrl", "Lcom/tencent/qqnt/kernel/nativeinterface/RMReqExParams;", "exParams", "getVideoPlayUrlV2", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "bizType", "Lcom/tencent/qqnt/kernel/nativeinterface/RMCodecInfo;", "getRichMediaCodecInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBeaconReportInfo;", "reportRecord", "beaconReportRMData", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "downReq", "downloadRichMediaInVisit", "isThumb", "getPicMediaFileDir", "", "getPicMediaFileDirs", "getVideoMediaFileDir", "getVideoMediaFileDirs", "getFileMediaFileDir", "getFileMediaFileDirs", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonFileInfo;", "Lkotlin/collections/ArrayList;", "fileInfoList", "savePath", "downloadFileForFileInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/UploadStatusParams;", "param", "updateOnlineVideoElemStatus", "name", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "count", "reportRichMediaMetricCounter", "Ldx3/c;", "sInitialModule", "Ldx3/c;", "getSInitialModule", "()Ldx3/c;", "setSInitialModule", "(Ldx3/c;)V", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RichMediaServiceImpl implements IRichMediaService {
    static IPatchRedirector $redirector_;
    private static ArrayList sInitialModule_AutoGenClazzList_QAutoInjectTransform;

    @QAutoInject(configPath = "AutoInjectYml/Service/Msg/Inject_InitialModule.yml", version = 1)
    @Nullable
    private dx3.c sInitialModule;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sInitialModule_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(o.class);
    }

    public RichMediaServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            inject();
        }
    }

    private final String getOldRichMediaFileDir(String newDir) {
        WrapperEngineGlobalConfig wrapperEngineGlobalConfig;
        boolean startsWith$default;
        String replace$default;
        dx3.c cVar = this.sInitialModule;
        if (cVar != null) {
            if (cVar != null) {
                wrapperEngineGlobalConfig = cVar.d();
            } else {
                wrapperEngineGlobalConfig = null;
            }
            Intrinsics.checkNotNull(wrapperEngineGlobalConfig);
            InitGlobalPathConfig initGlobalPathConfig = wrapperEngineGlobalConfig.globalPathConfig;
            String newBasePath = initGlobalPathConfig.mobileGlobalDataPath;
            Intrinsics.checkNotNullExpressionValue(newBasePath, "newBasePath");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(newDir, newBasePath, false, 2, null);
            if (startsWith$default) {
                String oldBaseOath = initGlobalPathConfig.mobileGlobalDBPath;
                Intrinsics.checkNotNullExpressionValue(oldBaseOath, "oldBaseOath");
                replace$default = StringsKt__StringsJVMKt.replace$default(newDir, newBasePath, oldBaseOath, false, 4, (Object) null);
                return replace$default;
            }
        }
        return null;
    }

    private final String getRichMediaFileDir(int elementType, int downType, boolean isTemp) {
        String richMediaFileDir;
        ab g16 = f.g();
        if (g16 == null || (richMediaFileDir = g16.getRichMediaFileDir(elementType, downType, isTemp)) == null) {
            return "";
        }
        return richMediaFileDir;
    }

    @QAutoInitMethod
    private final void inject() {
        this.sInitialModule = (dx3.c) com.tencent.mobileqq.qroute.utils.b.a(sInitialModule_AutoGenClazzList_QAutoInjectTransform);
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void beaconReportRMData(@NotNull RMBeaconReportInfo reportRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) reportRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(reportRecord, "reportRecord");
        ab g16 = f.g();
        if (g16 != null) {
            g16.beaconReportRMData(reportRecord);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void downloadFileForFileInfo(@NotNull ArrayList<CommonFileInfo> fileInfoList, @NotNull String savePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileInfoList, (Object) savePath);
            return;
        }
        Intrinsics.checkNotNullParameter(fileInfoList, "fileInfoList");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        ab g16 = f.g();
        if (g16 != null) {
            g16.downloadFileForFileInfo(fileInfoList, savePath);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void downloadRichMediaInVisit(@Nullable RichDownLoadReq downReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) downReq);
            return;
        }
        ab g16 = f.g();
        if (g16 != null) {
            g16.downloadRichMediaInVisit(downReq);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public String getFileMediaFileDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return getRichMediaFileDir(3, 1, false);
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public List<String> getFileMediaFileDirs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        String fileMediaFileDir = getFileMediaFileDir();
        if (!TextUtils.isEmpty(fileMediaFileDir)) {
            arrayList.add(fileMediaFileDir);
            String oldRichMediaFileDir = getOldRichMediaFileDir(fileMediaFileDir);
            if (oldRichMediaFileDir != null) {
                arrayList.add(oldRichMediaFileDir);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public String getPicMediaFileDir(boolean isThumb) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, isThumb);
        }
        if (isThumb) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        return getRichMediaFileDir(2, i3, false);
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public List<String> getPicMediaFileDirs(boolean isThumb) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, isThumb);
        }
        ArrayList arrayList = new ArrayList();
        String picMediaFileDir = getPicMediaFileDir(isThumb);
        if (!TextUtils.isEmpty(picMediaFileDir)) {
            arrayList.add(picMediaFileDir);
            String oldRichMediaFileDir = getOldRichMediaFileDir(picMediaFileDir);
            if (oldRichMediaFileDir != null) {
                arrayList.add(oldRichMediaFileDir);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @Nullable
    public RMCodecInfo getRichMediaCodecInfo(@Nullable RMBizTypeEnum bizType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RMCodecInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bizType);
        }
        ab g16 = f.g();
        if (g16 != null) {
            return g16.getRichMediaCodecInfo(bizType);
        }
        return null;
    }

    @Nullable
    public final dx3.c getSInitialModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (dx3.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sInitialModule;
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public String getVideoMediaFileDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return getRichMediaFileDir(5, 1, false);
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    @NotNull
    public List<String> getVideoMediaFileDirs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        String videoMediaFileDir = getVideoMediaFileDir();
        if (!TextUtils.isEmpty(videoMediaFileDir)) {
            arrayList.add(videoMediaFileDir);
            String oldRichMediaFileDir = getOldRichMediaFileDir(videoMediaFileDir);
            if (oldRichMediaFileDir != null) {
                arrayList.add(oldRichMediaFileDir);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void getVideoPlayUrl(@Nullable Contact peer, long msgId, long elemId, @NotNull VideoCodecFormatType videoCodecFormat, @Nullable IVideoPlayUrlCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, peer, Long.valueOf(msgId), Long.valueOf(elemId), videoCodecFormat, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
        ab g16 = f.g();
        if (g16 != null) {
            g16.getVideoPlayUrl(peer, msgId, elemId, videoCodecFormat, VideoRequestWay.KHAND, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void getVideoPlayUrlV2(@Nullable Contact peer, long msgId, long elemId, @Nullable VideoCodecFormatType videoCodecFormat, @Nullable RMReqExParams exParams, @Nullable IVideoPlayUrlCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, peer, Long.valueOf(msgId), Long.valueOf(elemId), videoCodecFormat, exParams, cb5);
            return;
        }
        ab g16 = f.g();
        if (g16 != null) {
            g16.getVideoPlayUrlV2(peer, msgId, elemId, videoCodecFormat, exParams, cb5);
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void reportRichMediaMetricCounter(@NotNull String name, @Nullable HashMap<String, String> params, long count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, name, params, Long.valueOf(count));
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        dx3.c cVar = this.sInitialModule;
        if (cVar != null) {
            cVar.onReportCountIndicators(params, name, count);
        }
    }

    public final void setSInitialModule(@Nullable dx3.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.sInitialModule = cVar;
        }
    }

    @Override // com.tencent.qqnt.msg.api.IRichMediaService
    public void updateOnlineVideoElemStatus(@NotNull UploadStatusParams param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        ab g16 = f.g();
        if (g16 != null) {
            g16.updateOnlineVideoElemStatus(param);
        }
    }
}
