package com.tencent.qqnt.shortvideo.compress;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.m;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.compress.api.IVideoManagerConfigApi;
import com.tencent.qqnt.kernel.api.ab;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.RMCodecInfo;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.shortvideo.NTShortVideoUtils;
import com.tencent.qqnt.shortvideo.api.IVideoCompress;
import com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0005\f\r\t\b\u0007B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$c;", "compressTask", "", "e", "d", "c", "<init>", "()V", "a", "b", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AIOVideoCompressProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<Long, WeakReference<c>> f362213b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<AIOVideoCompressProcessor> f362214c;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R<\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0014j\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$a;", "", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "FORCE_COMPRESS", "Z", "", "H265_BIT_RATE_PARAMS", UserInfo.SEX_FEMALE, "", "H265_VIDEO_LIMIT_TIME", "I", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$c;", "Lkotlin/collections/HashMap;", "compressingTaskList", "Ljava/util/HashMap;", "<init>", "()V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AIOVideoCompressProcessor a() {
            return (AIOVideoCompressProcessor) AIOVideoCompressProcessor.f362214c.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u00105\u001a\u00020\r\u0012\b\u00109\u001a\u0004\u0018\u000106\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J(\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\"J'\u0010'\u001a\u00020\u00032\u0016\u0010&\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020%\"\u0004\u0018\u00010\u0002H\u0015\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0003H\u0015J\b\u0010+\u001a\u00020\u0011H\u0015J\u0006\u0010,\u001a\u00020\rR\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0004\u0018\u0001068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00102R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010>R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00102R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00104R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010BR\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$c;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$b;", "", "f", "", "videoInput", "videoTmpPath", "videoOutput", "i", "videoInputPath", "videoOutputPath", "", "k", "g", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "", ReportConstant.COSTREPORT_PREFIX, "p", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "compressInfo", "", "videoDuration", "o", "v", "j", "inVideoPath", "outVideoPath", h.F, "finishCode", "Lcy3/a;", QCircleScheme.AttrDetail.VIDEO_INFO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "listener", "u", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([Ljava/lang/Void;)Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$b;", "result", "r", "onCancelled", DomainData.DOMAIN_NAME, "", "a", "J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "Ljava/lang/String;", "c", "Z", CustomImageProps.QUALITY, "", "d", "Ljava/lang/Object;", "userData", "e", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "videoCompressingPath", "Lcom/tencent/richmedia/videocompress/VideoConverter;", "Lcom/tencent/richmedia/videocompress/VideoConverter;", "converter", "videoPath", "needCompress", "I", "videoInPutCodecFormat", "l", "videoOutPutCodecFormat", "<init>", "(JLjava/lang/String;ZLjava/lang/Object;Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;)V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends AsyncTask<Void, Void, b> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long taskId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inVideoPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Object userData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private IVideoCompress.b listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String outVideoPath;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String videoCompressingPath;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private VideoConverter converter;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String videoPath;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean needCompress;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private int videoInPutCodecFormat;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int videoOutPutCodecFormat;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$c$a", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$e;", "", "percent", "", "a", "", "finishCode", "b", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a implements e {
            a() {
            }

            @Override // com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor.e
            public void a(float percent) {
                IVideoCompress.b bVar = c.this.listener;
                if (bVar != null) {
                    bVar.d(c.this.userData, percent);
                }
            }

            @Override // com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor.e
            public void b(int finishCode) {
                QLog.d("AIOVideoCompressProcessor", 1, "hardware compress finish, taskId=" + c.this.taskId + " code=" + finishCode);
                IVideoCompress.b bVar = c.this.listener;
                if (bVar != null) {
                    bVar.d(c.this.userData, 1.0f);
                }
            }
        }

        public c(long j3, @NotNull String inVideoPath, boolean z16, @Nullable Object obj, @Nullable IVideoCompress.b bVar) {
            Intrinsics.checkNotNullParameter(inVideoPath, "inVideoPath");
            this.taskId = j3;
            this.inVideoPath = inVideoPath;
            this.quality = z16;
            this.userData = obj;
            this.listener = bVar;
            String e16 = NTShortVideoUtils.f362199a.e(inVideoPath, z16);
            this.outVideoPath = e16;
            this.videoCompressingPath = e16 + ".tmp";
            this.videoPath = "";
        }

        private final int f() {
            if (!TextUtils.isEmpty(this.inVideoPath) && m.f352305a.f(this.inVideoPath)) {
                return 0;
            }
            if (QLog.isColorLevel()) {
                QLog.e("AIOVideoCompressProcessor", 2, "[checkArguments] video file not exists, path=" + this.inVideoPath);
            }
            return 2;
        }

        private final boolean g(String videoInputPath) {
            boolean b16 = com.tencent.qqnt.compress.video.config.a.f355762a.b(com.tencent.qqnt.util.video.a.f362991a.a(videoInputPath), ((IVideoManagerConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoManagerConfigApi.class)).getConfig(MobileQQ.sMobileQQ.peekAppRuntime()));
            this.needCompress = b16;
            return b16;
        }

        private final boolean h(String inVideoPath, String outVideoPath) {
            long f16 = NTShortVideoUtils.f(inVideoPath);
            long f17 = NTShortVideoUtils.f(outVideoPath);
            if (f16 <= 0 || f17 <= 0 || f16 / 1000 == f17 / 1000) {
                return true;
            }
            QLog.i("AIOVideoCompressProcessor", 1, "[checkVideoDuration] fail, " + f16 + "->" + f17);
            com.tencent.qqnt.shortvideo.b.INSTANCE.a(null, "aio_video_compress_error");
            return false;
        }

        private final String i(String videoInput, String videoTmpPath, String videoOutput) {
            if (!k(videoInput, videoTmpPath)) {
                QLog.i("AIOVideoCompressProcessor", 1, "failed to compress, use original file, taskId=" + this.taskId);
                m.f352305a.d(videoTmpPath);
                return videoInput;
            }
            long length = new File(videoInput).length();
            long length2 = new File(videoTmpPath).length();
            if (length2 > length) {
                QLog.i("AIOVideoCompressProcessor", 1, "compressed file is bigger than original file, taskId=" + this.taskId + " " + length + "->" + length2);
                m.f352305a.d(videoTmpPath);
                return videoInput;
            }
            if (!new File(videoTmpPath).renameTo(new File(videoOutput))) {
                QLog.i("AIOVideoCompressProcessor", 1, "failed to rename file, taskId=" + this.taskId + " " + videoTmpPath + "->" + videoOutput);
                return videoTmpPath;
            }
            return videoOutput;
        }

        private final VideoConverterConfig j(VideoConverterConfig compressInfo) {
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.isNeedCompress = true;
            videoConverterConfig.rotate = compressInfo.rotate;
            videoConverterConfig.srcWidth = compressInfo.srcWidth;
            videoConverterConfig.srcHeight = compressInfo.srcHeight;
            videoConverterConfig.destWidth = compressInfo.destWidth;
            videoConverterConfig.destHeight = compressInfo.destHeight;
            videoConverterConfig.destQmax = 25;
            videoConverterConfig.videoFrameRate = compressInfo.videoFrameRate;
            videoConverterConfig.videoBitRate = compressInfo.videoBitRate / 1024;
            return videoConverterConfig;
        }

        private final boolean k(String videoInputPath, String videoOutputPath) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            g(videoInputPath);
            if (QLog.isColorLevel()) {
                QLog.d("AIOVideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + this.needCompress);
            }
            if (this.listener != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.shortvideo.compress.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOVideoCompressProcessor.c.l(AIOVideoCompressProcessor.c.this);
                    }
                });
            }
            if (!this.needCompress) {
                QLog.i("AIOVideoCompressProcessor", 1, "no need compress, taskId=" + this.taskId + " path=" + videoInputPath);
                return false;
            }
            Pair<VideoConverterConfig, Float> a16 = com.tencent.qqnt.compress.video.config.a.f355762a.a(videoInputPath);
            VideoConverterConfig first = a16.getFirst();
            boolean o16 = o(first, a16.getSecond().floatValue(), videoInputPath, videoOutputPath);
            if (!o16) {
                this.videoOutPutCodecFormat = 0;
                VideoConverter videoConverter = this.converter;
                Intrinsics.checkNotNull(videoConverter);
                videoConverter.setOutPutVideoCodecMIMEType(MediaCodecSupport.AVC_CODEC_MIME);
                IVideoCompress.b bVar = this.listener;
                if (bVar != null) {
                    bVar.d(this.userData, 1.0f);
                }
                o16 = v(first, videoInputPath, videoOutputPath);
            }
            if (o16) {
                str = videoOutputPath;
            } else {
                str = this.inVideoPath;
            }
            this.videoPath = str;
            long length = new File(videoInputPath).length();
            long length2 = new File(this.videoPath).length();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i("AIOVideoCompressProcessor", 1, "video compression finished, taskId=" + this.taskId + " cost:" + currentTimeMillis2 + "ms path=" + this.inVideoPath + "->" + videoOutputPath + " config=" + first + " fileSourceSize=" + length + " fileTargetSize=" + length2);
            return o16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IVideoCompress.b bVar = this$0.listener;
            if (bVar != null) {
                bVar.c(this$0.userData, this$0.needCompress);
            }
        }

        private final boolean o(VideoConverterConfig compressInfo, float videoDuration, String videoInputPath, String videoOutputPath) {
            int i3;
            RMCodecInfo rMCodecInfo;
            String str;
            d dVar = new d(videoInputPath, videoOutputPath, compressInfo, new a());
            VideoConverter videoConverter = new VideoConverter(new com.tencent.qqnt.shortvideo.compress.d());
            if (ay3.a.f27350a.a()) {
                i3 = 5;
            } else {
                i3 = 1;
            }
            videoConverter.setCompressMode(i3);
            ab g16 = f.g();
            if (g16 != null) {
                rMCodecInfo = g16.getRichMediaCodecInfo(RMBizTypeEnum.KC2CVIDEO);
            } else {
                rMCodecInfo = null;
            }
            if (rMCodecInfo != null) {
                int a16 = u.INSTANCE.a(rMCodecInfo.encodeAbility.getVideoCodecFormat());
                this.videoInPutCodecFormat = a16;
                QLog.i("AIOVideoCompressProcessor", 1, "getVideoCodecFormat, videoInPutCodecFormat=" + a16);
                if (videoDuration > 30.0f) {
                    QLog.i("AIOVideoCompressProcessor", 1, "force encode h264, videoDuration=" + videoDuration);
                    this.videoInPutCodecFormat = 0;
                }
            }
            IVideoCompressApi iVideoCompressApi = (IVideoCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoCompressApi.class);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            this.videoOutPutCodecFormat = iVideoCompressApi.getVideoUploadRequestCodecFormat(peekAppRuntime, this.videoInPutCodecFormat);
            int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("key_video_codec_upload_format", this.videoOutPutCodecFormat);
            this.videoOutPutCodecFormat = decodeInt;
            if (decodeInt == 1) {
                str = MediaCodecSupport.HEVC_CODEC_MIME;
            } else {
                str = MediaCodecSupport.AVC_CODEC_MIME;
            }
            videoConverter.setOutPutVideoCodecMIMEType(str);
            if (Intrinsics.areEqual(str, MediaCodecSupport.HEVC_CODEC_MIME)) {
                dVar.b(0.8f);
            }
            this.converter = videoConverter;
            Intrinsics.checkNotNull(videoConverter);
            int startCompress = videoConverter.startCompress(BaseApplication.getContext(), videoInputPath, dVar, true);
            if (startCompress != -1002) {
                if (startCompress != 0) {
                    QLog.i("AIOVideoCompressProcessor", 1, "compression failed by MediaCodec, taskId=" + this.taskId + " code=" + startCompress);
                    return false;
                }
                if (!h(videoInputPath, videoOutputPath)) {
                    QLog.i("AIOVideoCompressProcessor", 1, "compression failed by MediaCodec, taskId=" + this.taskId + " config=" + compressInfo);
                    return false;
                }
                QLog.i("AIOVideoCompressProcessor", 1, "compression succeeded by MediaCodec, taskId=" + this.taskId);
                return true;
            }
            QLog.i("AIOVideoCompressProcessor", 1, "compression interrupted by MediaCodec, taskId=" + this.taskId);
            return true;
        }

        private final boolean p() {
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            Intrinsics.checkNotNullExpressionValue(codecInfos, "codecInfos");
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                Intrinsics.checkNotNullExpressionValue(supportedTypes, "supportedTypes");
                for (String str : supportedTypes) {
                    if (str.equals("video/dolby-vision")) {
                        QLog.i("AIOVideoCompressProcessor", 1, "isDolbyVisionSupported true, model : " + DeviceInfoMonitor.getModel());
                        return true;
                    }
                }
            }
            return false;
        }

        private final void q(int finishCode, cy3.a videoInfo) {
            AIOVideoCompressProcessor.f362213b.remove(Long.valueOf(this.taskId));
            IVideoCompress.b bVar = this.listener;
            if (bVar != null) {
                bVar.b(this.userData, finishCode, videoInfo);
            }
        }

        private final void s(final String compress) {
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            try {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.shortvideo.compress.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOVideoCompressProcessor.c.t(AIOVideoCompressProcessor.c.this, compress, peekAppRuntime);
                    }
                }, 16, null, true);
            } catch (Exception e16) {
                QLog.e("AIOVideoCompressProcessor", 1, "isDolbyVisionSupported exception: " + e16.getMessage() + "}");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(c this$0, String compress, AppRuntime app) {
            Object obj;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(compress, "$compress");
            Intrinsics.checkNotNullParameter(app, "$app");
            HashMap hashMap = new HashMap();
            hashMap.put("key_codec_format", String.valueOf(this$0.videoOutPutCodecFormat));
            String str = "1";
            if (this$0.quality) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, obj);
            if (!this$0.p()) {
                str = "0";
            }
            hashMap.put("key_dolby_support", str);
            hashMap.put("key_compress", compress);
            v.c(app.getCurrentUin(), "video_compress_report", hashMap);
        }

        private final boolean v(VideoConverterConfig compressInfo, String videoInputPath, String videoOutputPath) {
            ShortVideoTrimmer shortVideoTrimmer = ShortVideoTrimmer.f362237a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            if (!shortVideoTrimmer.d(context)) {
                this.videoPath = this.inVideoPath;
                QLog.w("AIOVideoCompressProcessor", 2, "ShortVideoTrimmer init failure, ignore compress, taskId=" + this.taskId);
                com.tencent.qqnt.shortvideo.b.INSTANCE.a(null, "initVideoTrimError");
                return false;
            }
            QLog.i("AIOVideoCompressProcessor", 2, "try to compress by ShortVideoTrimmer, taskId=" + this.taskId);
            VideoConverterConfig j3 = j(compressInfo);
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            int b16 = shortVideoTrimmer.b(context2, videoInputPath, videoOutputPath, j3);
            if (b16 != 0) {
                QLog.w("AIOVideoCompressProcessor", 1, "compress failed by ShortVideoTrimmer, taskId=" + this.taskId + " ret=" + b16);
                return false;
            }
            QLog.i("AIOVideoCompressProcessor", 1, "compress completed by ShortVideoTrimmer, taskId=" + this.taskId);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @Deprecated(message = "Deprecated in Java")
        @NotNull
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b doInBackground(@NotNull Void... params) {
            Intrinsics.checkNotNullParameter(params, "params");
            int f16 = f();
            if (f16 != 0) {
                return new b(this.taskId, this.inVideoPath, f16, null, 8, null);
            }
            String str = this.inVideoPath;
            String str2 = this.outVideoPath;
            NTShortVideoUtils nTShortVideoUtils = NTShortVideoUtils.f362199a;
            boolean u16 = nTShortVideoUtils.u(str);
            this.videoInPutCodecFormat = u16 ? 1 : 0;
            this.videoOutPutCodecFormat = u16 ? 1 : 0;
            String str3 = "0";
            if (this.quality && !nTShortVideoUtils.w(this.inVideoPath, u16 ? 1 : 0)) {
                this.videoPath = this.inVideoPath;
                if (QLog.isColorLevel()) {
                    long j3 = this.taskId;
                    String str4 = this.videoPath;
                    QLog.d("AIOVideoCompressProcessor", 2, "compress, use raw video, taskId:" + j3 + ", videoPath:" + str4 + " fileSize=" + m.h(str4));
                }
                IVideoCompress.b bVar = this.listener;
                if (bVar != null) {
                    bVar.d(this.userData, 1.0f);
                }
                s("0");
            } else if (m.f352305a.f(str2)) {
                this.videoPath = str2;
                QLog.d("AIOVideoCompressProcessor", 1, "compress, file already exists, taskId=" + this.taskId + " videoPath:" + str2 + " fileSize=" + m.h(str2));
                IVideoCompress.b bVar2 = this.listener;
                if (bVar2 != null) {
                    bVar2.d(this.userData, 1.0f);
                }
            } else {
                this.videoPath = i(str, this.videoCompressingPath, str2);
                if (this.needCompress) {
                    str3 = "1";
                }
                s(str3);
            }
            if (isCancelled()) {
                return new b(this.taskId, this.inVideoPath, 4, null, 8, null);
            }
            if (!TextUtils.isEmpty(this.videoPath) && m.f352305a.f(this.videoPath)) {
                cy3.a aVar = new cy3.a(this.videoPath, this.videoOutPutCodecFormat);
                IVideoCompress.b bVar3 = this.listener;
                boolean z16 = false;
                if (bVar3 != null && !bVar3.a(this.userData, aVar)) {
                    z16 = true;
                }
                if (z16) {
                    QLog.i("AIOVideoCompressProcessor", 1, "compress, after compressing process returns error, taskId=" + this.taskId);
                    return new b(this.taskId, this.inVideoPath, 3, null, 8, null);
                }
                return new b(this.taskId, this.inVideoPath, 0, aVar);
            }
            QLog.w("AIOVideoCompressProcessor", 2, "compress, step: after compress, mVideoPath not exists!!, taskId=" + this.taskId + ", path=" + this.videoPath);
            return new b(this.taskId, this.inVideoPath, 3, null, 8, null);
        }

        public final boolean n() {
            VideoConverter videoConverter = this.converter;
            if (videoConverter != null) {
                Intrinsics.checkNotNull(videoConverter);
                return videoConverter.cancelCompress();
            }
            return false;
        }

        @Override // android.os.AsyncTask
        @Deprecated(message = "Deprecated in Java")
        protected void onCancelled() {
            super.onCancelled();
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoCompressProcessor", 1, "[onCancelled] taskId=" + this.taskId);
            }
            m mVar = m.f352305a;
            mVar.d(this.outVideoPath);
            mVar.d(this.videoCompressingPath);
            IVideoCompress.b bVar = this.listener;
            if (bVar != null) {
                bVar.b(this.userData, 3, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @Deprecated(message = "Deprecated in Java")
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(@NotNull b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onPostExecute(result);
            int i3 = 1;
            QLog.d("AIOVideoCompressProcessor", 1, "CompressTask onPostExecute: result = " + result + ", " + this.taskId);
            if (this.listener == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOVideoCompressProcessor", 2, "onPostExecute, mListener is null ," + this.taskId);
                    return;
                }
                return;
            }
            if (result.getErrorCode() != 0) {
                i3 = 2;
            }
            q(i3, result.getVideoInfo());
        }

        public final void u(@Nullable IVideoCompress.b listener) {
            if (listener == null) {
                return;
            }
            this.listener = listener;
            if (AsyncTask.Status.FINISHED == getStatus()) {
                IVideoCompress.b bVar = this.listener;
                if (bVar != null) {
                    bVar.b(this.userData, 1, get().getVideoInfo());
                    return;
                }
                return;
            }
            if (isCancelled()) {
                IVideoCompress.b bVar2 = this.listener;
                if (bVar2 != null) {
                    bVar2.b(this.userData, 3, null);
                    return;
                }
                return;
            }
            IVideoCompress.b bVar3 = this.listener;
            if (bVar3 != null) {
                bVar3.c(this.userData, this.needCompress);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$d;", "Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;", "", "a", "", "bitRateParams", "", "b", "", "progress", "onProgress", "onSuccess", "", "e", "onFail", "onCancel", "width", "height", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "getEncodeConfig", "", "Ljava/lang/String;", "inputFilePath", "outputFilePath", "c", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "compressInfo", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$e;", "d", "Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$e;", "listener", "", "J", "lastOnProgressLogTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/richmedia/videocompress/VideoConverterConfig;Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$e;)V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements VideoConverter.Processor {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inputFilePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String outputFilePath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final VideoConverterConfig compressInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final e listener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long lastOnProgressLogTime;

        public d(@NotNull String inputFilePath, @NotNull String outputFilePath, @NotNull VideoConverterConfig compressInfo, @Nullable e eVar) {
            Intrinsics.checkNotNullParameter(inputFilePath, "inputFilePath");
            Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
            Intrinsics.checkNotNullParameter(compressInfo, "compressInfo");
            this.inputFilePath = inputFilePath;
            this.outputFilePath = outputFilePath;
            this.compressInfo = compressInfo;
            this.listener = eVar;
        }

        private final boolean a() {
            if (Math.abs(System.currentTimeMillis() - this.lastOnProgressLogTime) > 1000) {
                this.lastOnProgressLogTime = System.currentTimeMillis();
                return true;
            }
            return false;
        }

        public final void b(float bitRateParams) {
            this.compressInfo.videoBitRate = (int) (r0.videoBitRate * bitRateParams);
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        @NotNull
        public VideoConverterConfig getEncodeConfig(int width, int height) {
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            videoConverterConfig.output = this.outputFilePath;
            VideoConverterConfig videoConverterConfig2 = this.compressInfo;
            videoConverterConfig.scaleRate = videoConverterConfig2.scaleRate;
            videoConverterConfig.videoFrameRate = videoConverterConfig2.videoFrameRate;
            videoConverterConfig.videoBitRate = videoConverterConfig2.videoBitRate;
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
            QLog.d("AIOVideoCompressProcessor", 1, "CompressTask, step: HWCompressProcessor onCanceled!");
            e eVar = this.listener;
            if (eVar != null) {
                eVar.b(3);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(@NotNull Throwable e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.i("AIOVideoCompressProcessor", 1, "CompressTask, step: HWCompressProcessor onFailed");
            e eVar = this.listener;
            if (eVar != null) {
                eVar.b(2);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int progress) {
            e eVar;
            if (a() && QLog.isColorLevel()) {
                QLog.d("AIOVideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + progress);
            }
            boolean z16 = false;
            if (progress >= 0 && progress < 10001) {
                z16 = true;
            }
            if (z16 && (eVar = this.listener) != null) {
                eVar.a(progress / 10000.0f);
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            QLog.i("AIOVideoCompressProcessor", 1, "CompressTask, step: HWCompressProcessor onSucceed");
            e eVar = this.listener;
            if (eVar != null) {
                eVar.b(1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$e;", "", "", "percent", "", "a", "", "finishCode", "b", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface e {
        void a(float percent);

        void b(int finishCode);
    }

    static {
        Lazy<AIOVideoCompressProcessor> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOVideoCompressProcessor>() { // from class: com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOVideoCompressProcessor invoke() {
                return new AIOVideoCompressProcessor(null);
            }
        });
        f362214c = lazy;
    }

    public /* synthetic */ AIOVideoCompressProcessor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void c(long taskId) {
        c cVar;
        WeakReference<c> remove = f362213b.remove(Long.valueOf(taskId));
        if (remove != null && (cVar = remove.get()) != null) {
            cVar.n();
            if (cVar.getStatus() != AsyncTask.Status.FINISHED && !cVar.isCancelled()) {
                cVar.cancel(true);
            }
        }
    }

    @Nullable
    public final c d(long taskId) {
        WeakReference<c> weakReference;
        HashMap<Long, WeakReference<c>> hashMap = f362213b;
        if (hashMap.containsKey(Long.valueOf(taskId)) && (weakReference = hashMap.get(Long.valueOf(taskId))) != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void e(long taskId, @NotNull c compressTask) {
        Intrinsics.checkNotNullParameter(compressTask, "compressTask");
        WeakReference<c> weakReference = new WeakReference<>(compressTask);
        f362213b.put(Long.valueOf(taskId), weakReference);
        compressTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    AIOVideoCompressProcessor() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0005\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/AIOVideoCompressProcessor$b;", "", "", "toString", "", "a", "J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "Ljava/lang/String;", "inVideoPath", "", "c", "I", "()I", "errorCode", "Lcy3/a;", "d", "Lcy3/a;", "()Lcy3/a;", QCircleScheme.AttrDetail.VIDEO_INFO, "<init>", "(JLjava/lang/String;ILcy3/a;)V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long taskId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inVideoPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final cy3.a videoInfo;

        public b(long j3, @NotNull String inVideoPath, int i3, @Nullable cy3.a aVar) {
            Intrinsics.checkNotNullParameter(inVideoPath, "inVideoPath");
            this.taskId = j3;
            this.inVideoPath = inVideoPath;
            this.errorCode = i3;
            this.videoInfo = aVar;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final cy3.a getVideoInfo() {
            return this.videoInfo;
        }

        @NotNull
        public String toString() {
            return "{taskId:" + this.taskId + ",input:" + this.inVideoPath + ",error:" + this.errorCode + "}";
        }

        public /* synthetic */ b(long j3, String str, int i3, cy3.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, str, i3, (i16 & 8) != 0 ? null : aVar);
        }
    }
}
