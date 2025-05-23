package com.tencent.qqnt.compress.api.impl;

import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J@\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressApiNtImpl;", "Lcom/tencent/qqnt/compress/api/IVideoCompressApi;", "Lmqq/app/AppRuntime;", "appRuntime", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "fileWidth", "fileHeight", "thumbWidth", "thumbHeight", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/u;", "formatInfo", "getVideoDownloadRequestCodecFormat", "videoInPutCodecFormat", "getVideoUploadRequestCodecFormat", "", "isAIOConfigEnableH265Video", "", "getVideoItemLimitTimeMills", "", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "<init>", "()V", "Companion", "a", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class VideoCompressApiNtImpl implements IVideoCompressApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "VideoCompressApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.api.impl.VideoCompressApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VideoCompressApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public int getVideoDownloadRequestCodecFormat(@NotNull AppRuntime appRuntime, int busiType, int fileWidth, int fileHeight, int thumbWidth, int thumbHeight, @NotNull u formatInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, appRuntime, Integer.valueOf(busiType), Integer.valueOf(fileWidth), Integer.valueOf(fileHeight), Integer.valueOf(thumbWidth), Integer.valueOf(thumbHeight), formatInfo)).intValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(formatInfo, "formatInfo");
        return 1;
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public long getVideoItemLimitTimeMills() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public int getVideoUploadRequestCodecFormat(@NotNull AppRuntime appRuntime, int videoInPutCodecFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, videoInPutCodecFormat)).intValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return videoInPutCodecFormat;
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public boolean isAIOConfigEnableH265Video(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return true;
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    @NotNull
    public IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IOperateResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) srcVideoPath, (Object) dstVideoPath);
        }
        return new IOperateResult(-1, "");
    }
}
