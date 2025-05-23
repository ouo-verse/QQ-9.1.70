package com.tencent.qqnt.compress.api.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.i;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.compress.api.impl.VideoCompressResult;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.converter.AsyncHardwareConverter;
import com.tencent.richmedia.videocompress.converter.HardwareConverter;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\bH\u0002J2\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0017\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002J4\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018J@\u0010$\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020(H\u0016J\u001c\u0010-\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressApiImpl;", "Lcom/tencent/qqnt/compress/api/IVideoCompressApi;", "", "targetToH265", "", "videoInputPath", "Lcom/tencent/qqnt/compress/api/impl/a;", "processor", "Lcom/tencent/qqnt/compress/api/impl/VideoCompressResult;", "compressResult", "hardwareCompressWrapper", "videoOutputPath", "Lcom/tencent/mobileqq/shortvideo/ac$c;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/shortvideo/ac$a;", "compressInfo", "Landroid/content/Context;", "context", "doSoftwareCompressWrapper", "", "doSoftwareCompress", "videoPath", "isSendRawVideo", "isNeedCompress", "Lcom/tencent/mobileqq/shortvideo/VideoCompressProcessor$c;", "listener", "doCompress", "Lmqq/app/AppRuntime;", "appRuntime", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "fileWidth", "fileHeight", "thumbWidth", "thumbHeight", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/u;", "formatInfo", "getVideoDownloadRequestCodecFormat", "videoInPutCodecFormat", "getVideoUploadRequestCodecFormat", "isAIOConfigEnableH265Video", "", "getVideoItemLimitTimeMills", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class VideoCompressApiImpl implements IVideoCompressApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int LONG_VIDEO_LIMIT = 599;

    @NotNull
    public static final String TAG = "VideoCompressApiImpl";
    public static final int VIDEO_COMPRESS_RET_CODE_FAILED = -1;
    public static final int VIDEO_COMPRESS_RET_CODE_SRC_VIDEO_NO_NEED_COMPRESS = 2;
    public static final int VIDEO_COMPRESS_RET_CODE_SUCCESS = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoCompressApiImpl$a;", "", "", "LONG_VIDEO_LIMIT", "I", "", "TAG", "Ljava/lang/String;", "VIDEO_COMPRESS_RET_CODE_FAILED", "VIDEO_COMPRESS_RET_CODE_SRC_VIDEO_NO_NEED_COMPRESS", "VIDEO_COMPRESS_RET_CODE_SUCCESS", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.api.impl.VideoCompressApiImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/compress/api/impl/VideoCompressApiImpl$b", "Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$ProcessCallBack;", "", "w", h.F, "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "getEncodeConfig", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends ShortVideoTrimmer.ProcessCallBack {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoConverterConfig f355703a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f355704b;

        b(VideoConverterConfig videoConverterConfig, String str) {
            this.f355703a = videoConverterConfig;
            this.f355704b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoConverterConfig, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.ProcessCallBack, com.tencent.richmedia.videocompress.VideoConverter.Processor
        @NotNull
        public VideoConverterConfig getEncodeConfig(int w3, int h16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (VideoConverterConfig) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(w3), Integer.valueOf(h16));
            }
            VideoConverterConfig videoConverterConfig = this.f355703a;
            videoConverterConfig.output = this.f355704b;
            return videoConverterConfig;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VideoCompressApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ VideoCompressResult doCompress$default(VideoCompressApiImpl videoCompressApiImpl, String str, String str2, boolean z16, boolean z17, VideoCompressProcessor.c cVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        boolean z18 = z17;
        if ((i3 & 16) != 0) {
            cVar = null;
        }
        return videoCompressApiImpl.doCompress(str, str2, z16, z18, cVar);
    }

    private final int doSoftwareCompress(String videoInputPath, String videoOutputPath, ac.c videoInfo, ac.a compressInfo, Context context) {
        if (!ShortVideoTrimmer.initVideoTrim(context)) {
            QLog.i(TAG, 1, "[doSoftwareCompress], ShortVideoTrimmer init failure");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "initVideoTrimError", true, 0L, 0L, (HashMap<String, String>) null, "", false);
            return -2;
        }
        VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
        videoConverterConfig.isNeedCompress = true;
        videoConverterConfig.rotate = String.valueOf(videoInfo.f287779d);
        videoConverterConfig.srcWidth = videoInfo.f287777b;
        videoConverterConfig.srcHeight = videoInfo.f287778c;
        videoConverterConfig.destWidth = compressInfo.f287758a;
        videoConverterConfig.destHeight = compressInfo.f287759b;
        videoConverterConfig.destQmax = 25;
        videoConverterConfig.videoFrameRate = (int) compressInfo.f287761d;
        videoConverterConfig.videoBitRate = (int) (compressInfo.f287760c / 1024);
        VideoConverter videoConverter = new VideoConverter();
        ShortVideoTrimmer.setSoftwareCompressMode(context, videoConverter);
        return videoConverter.startCompress(context, videoInputPath, new b(videoConverterConfig, videoOutputPath), true);
    }

    private final VideoCompressResult doSoftwareCompressWrapper(String videoInputPath, String videoOutputPath, ac.c videoInfo, ac.a compressInfo, Context context, VideoCompressResult compressResult) {
        int doSoftwareCompress = doSoftwareCompress(videoInputPath, videoOutputPath, videoInfo, compressInfo, context);
        if (doSoftwareCompress != -1002) {
            if (doSoftwareCompress != 0) {
                QLog.i("VideoCompressProcessor", 1, "[doSoftwareCompressWrapper], doSoftwareCompress failed, ret=" + doSoftwareCompress);
                compressResult.b(VideoCompressResult.Result.FAIL);
            } else {
                QLog.i(TAG, 1, "[doSoftwareCompressWrapper], doSoftwareCompress success");
                compressResult.b(VideoCompressResult.Result.SUCCESS);
            }
        } else {
            QLog.i(TAG, 1, "[doSoftwareCompressWrapper], doSoftwareCompress cancelled");
            compressResult.b(VideoCompressResult.Result.FAIL_ERROR_INTERRUPT);
        }
        return compressResult;
    }

    private final VideoCompressResult hardwareCompressWrapper(boolean targetToH265, String videoInputPath, a processor, VideoCompressResult compressResult) {
        int i3;
        boolean z16;
        BaseApplication baseApplication;
        if (targetToH265) {
            if (!ShortVideoUtils.isH265FormatShortVideo(videoInputPath)) {
                QLog.d(TAG, 1, "[hardwareCompressWrapper] mIsH265Video = false");
                compressResult.b(VideoCompressResult.Result.FAIL_SRC_VIDEO_IS_NOT_H265);
                return compressResult;
            }
            if (!com.tencent.mobileqq.shortvideo.h.k(MobileQQ.sMobileQQ.peekAppRuntime())) {
                QLog.d(TAG, 1, "[hardwareCompressWrapper] isConfigEnableAIOH265VideoUpload = false");
                compressResult.b(VideoCompressResult.Result.FAIL_CONFIG_DISABLE_H265);
                return compressResult;
            }
            if (!ShortVideoUtils.isDeviceSupportEncodeH265Video()) {
                QLog.d(TAG, 1, "[hardwareCompressWrapper] isDeviceSupportEncodeH265Video = false");
                compressResult.b(VideoCompressResult.Result.FAIL_DEVICE_NOT_SUPPORT_H265);
                return compressResult;
            }
        }
        boolean h16 = VideoCompressProcessor.CompressTask.h();
        VideoConverter videoConverter = new VideoConverter(new br2.a());
        if (h16) {
            i3 = 5;
        } else {
            i3 = 1;
        }
        videoConverter.setCompressMode(i3);
        if (i3 == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(TAG, 1, "[hardwareCompressWrapper] isAsyncMode = " + z16);
        if (targetToH265) {
            videoConverter.setOutPutVideoCodecMIMEType(MediaCodecSupport.HEVC_CODEC_MIME);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            baseApplication = peekAppRuntime.getApp();
        } else {
            baseApplication = null;
        }
        int startCompress = videoConverter.startCompress(baseApplication, videoInputPath, processor, true);
        if (startCompress != -1002 && startCompress != 0) {
            compressResult.b(VideoCompressResult.Result.FAIL);
        } else {
            compressResult.b(VideoCompressResult.Result.SUCCESS);
        }
        return compressResult;
    }

    public static /* synthetic */ boolean isNeedCompress$default(VideoCompressApiImpl videoCompressApiImpl, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return videoCompressApiImpl.isNeedCompress(str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019e  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qfix.redirect.IPatchRedirector] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.tencent.qqnt.compress.api.impl.VideoCompressApiImpl] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final VideoCompressResult doCompress(@NotNull String videoInputPath, @NotNull String videoOutputPath, boolean targetToH265, boolean isSendRawVideo, @Nullable VideoCompressProcessor.c listener) {
        ac.c cVar;
        long j3;
        String str;
        String str2;
        String str3;
        String str4;
        ac.a aVar;
        String str5;
        BaseApplication baseApplication;
        boolean z16;
        String str6;
        a aVar2;
        VideoCompressResult.Result a16;
        VideoCompressResult.Result result;
        BaseApplication baseApplication2;
        ?? r85 = this;
        ?? r16 = $redirector_;
        if (r16 != 0 && r16.hasPatch((short) 3)) {
            return (VideoCompressResult) r16.redirect((short) 3, new Object[]{r85, videoInputPath, videoOutputPath, Boolean.valueOf(targetToH265), Boolean.valueOf(isSendRawVideo), listener});
        }
        Intrinsics.checkNotNullParameter(videoInputPath, "videoInputPath");
        Intrinsics.checkNotNullParameter(videoOutputPath, "videoOutputPath");
        long currentTimeMillis = System.currentTimeMillis();
        if (!VideoCompressProcessor.CompressTask.m()) {
            HardwareConverter.setChangeOutputFrameRateDisabled(true);
            AsyncHardwareConverter.u(true);
        }
        VideoCompressResult videoCompressResult = new VideoCompressResult(videoInputPath, videoOutputPath, targetToH265, null, 8, null);
        ac.b b16 = ac.b(MobileQQ.sMobileQQ.peekAppRuntime());
        ac.c videoInfo = ac.c(videoInputPath);
        ac.a compressInfo = ac.a(videoInfo, b16, isSendRawVideo);
        Intrinsics.checkNotNullExpressionValue(compressInfo, "compressInfo");
        a aVar3 = new a(videoInputPath, videoOutputPath, compressInfo, listener);
        try {
            if (targetToH265) {
                VideoCompressResult hardwareCompressWrapper = r85.hardwareCompressWrapper(targetToH265, videoInputPath, aVar3, videoCompressResult);
                QLog.i(TAG, 2, "[doCompress], videoSize change: " + new File(videoInputPath).length() + " -> " + new File(videoOutputPath).length() + "; cost time:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return hardwareCompressWrapper;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            BaseApplication app = peekAppRuntime != null ? peekAppRuntime.getApp() : null;
            try {
                try {
                    if (!b16.f287770h.a()) {
                        try {
                            if (!VideoCompressProcessor.CompressTask.i()) {
                                str4 = "; cost time:";
                                aVar = compressInfo;
                                str5 = QCircleScheme.AttrDetail.VIDEO_INFO;
                                baseApplication = app;
                                j3 = currentTimeMillis;
                                z16 = false;
                                str = "[doCompress], videoSize change: ";
                                str2 = " -> ";
                                cVar = videoInfo;
                                str6 = TAG;
                                aVar2 = aVar3;
                                r85.hardwareCompressWrapper(targetToH265, videoInputPath, aVar2, videoCompressResult);
                                a16 = videoCompressResult.a();
                                result = VideoCompressResult.Result.FAIL;
                                if (a16 == result) {
                                    QLog.i(str6, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str4 + (System.currentTimeMillis() - j3) + "ms");
                                    return videoCompressResult;
                                }
                                String str7 = str6;
                                str3 = str4;
                                try {
                                    if (!z16) {
                                        try {
                                            if (QLog.isColorLevel()) {
                                                QLog.i(str7, 2, "[doCompress], try software compress after hardware compress failed");
                                            }
                                            Intrinsics.checkNotNullExpressionValue(cVar, str5);
                                            VideoCompressResult doSoftwareCompressWrapper = doSoftwareCompressWrapper(videoInputPath, videoOutputPath, cVar, aVar, baseApplication, videoCompressResult);
                                            QLog.i(str7, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + "ms");
                                            return doSoftwareCompressWrapper;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            cVar = str7;
                                            r85 = "ms";
                                            QLog.i(cVar, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + r85);
                                            throw th;
                                        }
                                    }
                                    videoCompressResult.b(result);
                                    QLog.i(str7, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + "ms");
                                    return videoCompressResult;
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            r85 = "ms";
                            str2 = " -> ";
                            cVar = TAG;
                            j3 = currentTimeMillis;
                            str = "[doCompress], videoSize change: ";
                            str3 = "; cost time:";
                            QLog.i(cVar, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + r85);
                            throw th;
                        }
                    }
                    doSoftwareCompressWrapper(videoInputPath, videoOutputPath, videoInfo, compressInfo, baseApplication2, videoCompressResult);
                    if (videoCompressResult.a() != VideoCompressResult.Result.SUCCESS && videoCompressResult.a() != VideoCompressResult.Result.FAIL_ERROR_INTERRUPT) {
                        z16 = true;
                        r85.hardwareCompressWrapper(targetToH265, videoInputPath, aVar2, videoCompressResult);
                        a16 = videoCompressResult.a();
                        result = VideoCompressResult.Result.FAIL;
                        if (a16 == result) {
                        }
                    }
                    QLog.i(str6, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str4 + (System.currentTimeMillis() - j3) + "ms");
                    return videoCompressResult;
                } catch (Throwable th8) {
                    th = th8;
                    r85 = "ms";
                    cVar = str6;
                    str3 = str4;
                    QLog.i(cVar, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + r85);
                    throw th;
                }
                QLog.i(TAG, 1, "[doCompress], try software compress first");
                Intrinsics.checkNotNullExpressionValue(videoInfo, "videoInfo");
                str = "[doCompress], videoSize change: ";
                str5 = QCircleScheme.AttrDetail.VIDEO_INFO;
                str2 = " -> ";
                str6 = TAG;
                str4 = "; cost time:";
                aVar2 = aVar3;
                aVar = compressInfo;
                baseApplication2 = app;
                baseApplication = app;
                cVar = videoInfo;
            } catch (Throwable th9) {
                th = th9;
                r85 = "ms";
                str = "[doCompress], videoSize change: ";
                str2 = " -> ";
                cVar = TAG;
                str3 = "; cost time:";
                QLog.i(cVar, 2, str + new File(videoInputPath).length() + str2 + new File(videoOutputPath).length() + str3 + (System.currentTimeMillis() - j3) + r85);
                throw th;
            }
            j3 = currentTimeMillis;
        } catch (Throwable th10) {
            th = th10;
            r85 = "ms";
            cVar = TAG;
            j3 = currentTimeMillis;
            str = "[doCompress], videoSize change: ";
            str2 = " -> ";
        }
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public int getVideoDownloadRequestCodecFormat(@NotNull AppRuntime appRuntime, int busiType, int fileWidth, int fileHeight, int thumbWidth, int thumbHeight, @NotNull u formatInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, appRuntime, Integer.valueOf(busiType), Integer.valueOf(fileWidth), Integer.valueOf(fileHeight), Integer.valueOf(thumbWidth), Integer.valueOf(thumbHeight), formatInfo)).intValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(formatInfo, "formatInfo");
        return i.a(appRuntime, busiType, fileWidth, fileHeight, thumbWidth, thumbHeight, formatInfo);
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public long getVideoItemLimitTimeMills() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return 599000L;
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public int getVideoUploadRequestCodecFormat(@NotNull AppRuntime appRuntime, int videoInPutCodecFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime, videoInPutCodecFormat)).intValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return i.b(appRuntime, videoInPutCodecFormat);
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    public boolean isAIOConfigEnableH265Video(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return i.c(appRuntime);
    }

    public final boolean isNeedCompress(@NonNull @NotNull String videoPath, boolean isSendRawVideo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, videoPath, Boolean.valueOf(isSendRawVideo))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        File file = new File(videoPath);
        if (!file.exists()) {
            return false;
        }
        if (isSendRawVideo && file.length() < ShortVideoConstants.VIDEO_SIZE_LIMIT && !ShortVideoUtils.isH265FormatShortVideo(videoPath)) {
            return false;
        }
        return ac.d(ac.c(videoPath), ac.b(MobileQQ.sMobileQQ.peekAppRuntime()));
    }

    @Override // com.tencent.qqnt.compress.api.IVideoCompressApi
    @NotNull
    public IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath) {
        IOperateResult iOperateResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IOperateResult) iPatchRedirector.redirect((short) 8, (Object) this, (Object) srcVideoPath, (Object) dstVideoPath);
        }
        if (!TextUtils.isEmpty(srcVideoPath) && !TextUtils.isEmpty(dstVideoPath)) {
            if (FileUtils.fileExists(dstVideoPath)) {
                FileUtils.deleteFile(dstVideoPath);
            }
            Intrinsics.checkNotNull(srcVideoPath);
            if (!isNeedCompress$default(this, srcVideoPath, false, 2, null)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[onCompressVideo], no need to compress.srcVideoPath=" + srcVideoPath + ", dstVideoPath=" + dstVideoPath);
                }
                return new IOperateResult(2, "src video no need to compress.");
            }
            Intrinsics.checkNotNull(dstVideoPath);
            VideoCompressResult doCompress$default = doCompress$default(this, srcVideoPath, dstVideoPath, false, false, null, 24, null);
            if (doCompress$default.a() == VideoCompressResult.Result.SUCCESS) {
                iOperateResult = new IOperateResult(0, "");
            } else {
                iOperateResult = new IOperateResult(-1, doCompress$default.toString());
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[onCompressVideo], operateResult=" + iOperateResult + ", srcVideoPath=" + srcVideoPath + ", dstVideoPath=" + dstVideoPath);
            }
            return iOperateResult;
        }
        QLog.e(TAG, 1, "[onCompressVideo], invalidate video path. srcVideoPath=" + srcVideoPath + ", dstVideoPath=" + dstVideoPath);
        return new IOperateResult(-1, "invalidate video path.");
    }
}
