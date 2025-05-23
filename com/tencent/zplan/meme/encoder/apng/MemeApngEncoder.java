package com.tencent.zplan.meme.encoder.apng;

import android.graphics.Bitmap;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.common.soloader.c;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Constant;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_APNG_ENCODE_FAIL;
import com.tencent.zplan.meme.action.ERROR_APNG_ENV_INIT_FAIL;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.encoder.a;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\u0019B\u001f\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010K\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\bL\u0010MJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\f\u0010\u0010\u001a\u00020\t*\u00020\u0003H\u0002J\f\u0010\u0011\u001a\u00020\t*\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00150!j\b\u0012\u0004\u0012\u00020\u0015`\"H\u0016J\u0016\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00150!j\b\u0012\u0004\u0012\u00020\u0015`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010+R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u00105R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010+\u00a8\u0006N"}, d2 = {"Lcom/tencent/zplan/meme/encoder/apng/MemeApngEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder;", "Lcom/tencent/zplan/meme/encoder/a;", "", "skipFirst", "skipPalette", "skipColor", "", "zipLevel", "", ReportConstant.COSTREPORT_PREFIX, "set", "t", "w", "v", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", DomainData.DOMAIN_NAME, "init", "portraitId", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "close", "", "pixels", "width", "height", "b", "getFrameCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p", "apngInputPath", "gifOutputPath", "o", "", "J", "nativeHandle", "c", "I", "nativeVersion", "d", "frameCount", "e", "Ljava/util/ArrayList;", "framePathList", "f", "delayDenominator", "g", "Ljava/lang/String;", "tmpOutputPath", "Landroid/os/Handler;", h.F, "Landroid/os/Handler;", "asyncHandler", "Landroid/os/HandlerThread;", "i", "Landroid/os/HandlerThread;", "handlerThread", "Ljava/util/concurrent/CountDownLatch;", "j", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "k", "Z", "encodeImmediately", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "l", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tempFilePath", "<init>", "(Lcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;I)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeApngEncoder extends ApolloApngEncoder implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: o, reason: collision with root package name */
    private static boolean f385791o;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long nativeHandle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int nativeVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> framePathList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int delayDenominator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String tmpOutputPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Handler asyncHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HandlerThread handlerThread;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final CountDownLatch countDownLatch;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean encodeImmediately;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final BusinessConfig config;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String tempFilePath;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int frameTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/meme/encoder/apng/MemeApngEncoder$a;", "", "", "c", "d", "", "apngInputPath", "gifOutputPath", "a", "soLoaded", "Z", "b", "()Z", "e", "(Z)V", "SO_NAME", "Ljava/lang/String;", "TAG", "", "zipLevel", "I", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.apng.MemeApngEncoder$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@NotNull String apngInputPath, @NotNull String gifOutputPath) {
            Intrinsics.checkNotNullParameter(apngInputPath, "apngInputPath");
            Intrinsics.checkNotNullParameter(gifOutputPath, "gifOutputPath");
            return new MemeApngEncoder(new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null), "", 1000).o(apngInputPath, gifOutputPath);
        }

        public final boolean b() {
            return MemeApngEncoder.f385791o;
        }

        public final boolean c() {
            if (b()) {
                return true;
            }
            return false;
        }

        public final boolean d() {
            if (b()) {
                return true;
            }
            e(c.INSTANCE.b(SoLoadConstants.APNG_SO));
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "load apng so, success:" + b(), null, 8, null);
            }
            return b();
        }

        public final void e(boolean z16) {
            MemeApngEncoder.f385791o = z16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MemeApngEncoder(@NotNull BusinessConfig config, @NotNull String tempFilePath, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        this.config = config;
        this.tempFilePath = tempFilePath;
        this.frameTime = i3;
        this.framePathList = new ArrayList<>();
        this.delayDenominator = 1000 / i3;
        this.tmpOutputPath = "";
        this.countDownLatch = new CountDownLatch(1);
        INSTANCE.d();
    }

    private final boolean n() {
        long nativeHeapFreeSize = Debug.getNativeHeapFreeSize();
        long apngCheckHeapSize = Meme.f385754h.k().getApngModeConfig().getApngCheckHeapSize();
        if (apngCheckHeapSize <= 0 || nativeHeapFreeSize >= apngCheckHeapSize) {
            return false;
        }
        return true;
    }

    private final void q(boolean z16) {
        if (!z16) {
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]");
        this.handlerThread = baseHandlerThread;
        Intrinsics.checkNotNull(baseHandlerThread);
        baseHandlerThread.setPriority(9);
        HandlerThread handlerThread = this.handlerThread;
        Intrinsics.checkNotNull(handlerThread);
        handlerThread.start();
        HandlerThread handlerThread2 = this.handlerThread;
        Intrinsics.checkNotNull(handlerThread2);
        this.asyncHandler = new Handler(handlerThread2.getLooper());
    }

    private final void r(boolean z16) {
        HandlerThread handlerThread;
        if (z16 && (handlerThread = this.handlerThread) != null) {
            handlerThread.quitSafely();
        }
    }

    private final void s(boolean skipFirst, boolean skipPalette, boolean skipColor, int zipLevel) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return;
        }
        nativeEncoderSetOptimization(j3, skipFirst, skipPalette, skipColor, zipLevel);
    }

    private final void t(boolean set) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return;
        }
        try {
            nativeEncoderSetTrueColorBoost(j3, set);
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "setTrueColorBoost", th5);
            }
        }
    }

    private final boolean u() {
        if (this.nativeVersion >= 118) {
            return true;
        }
        return false;
    }

    private final boolean v() {
        if (this.nativeVersion >= 117) {
            return true;
        }
        return false;
    }

    private final boolean w() {
        if (this.nativeVersion >= 114 && Meme.f385754h.k().getApngModeConfig().getStreamingMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        ActionStatus actionStatus;
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        long currentTimeMillis = System.currentTimeMillis();
        if (INSTANCE.c() && this.nativeHandle != 0) {
            if (TextUtils.isEmpty(outputFilePath)) {
                return ERROR_APNG_ENCODE_FAIL.INSTANCE;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            if (this.encodeImmediately) {
                Handler handler = this.asyncHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tencent.zplan.meme.encoder.apng.MemeApngEncoder$encode$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            long j3;
                            boolean nativeEncoderEncodeFrameEnd;
                            CountDownLatch countDownLatch;
                            Ref.BooleanRef booleanRef2 = booleanRef;
                            MemeApngEncoder memeApngEncoder = MemeApngEncoder.this;
                            j3 = memeApngEncoder.nativeHandle;
                            nativeEncoderEncodeFrameEnd = memeApngEncoder.nativeEncoderEncodeFrameEnd(j3);
                            booleanRef2.element = nativeEncoderEncodeFrameEnd;
                            countDownLatch = MemeApngEncoder.this.countDownLatch;
                            countDownLatch.countDown();
                        }
                    });
                }
                this.countDownLatch.await();
            } else {
                String str = outputFilePath + util.base64_pad_url + System.nanoTime();
                this.tmpOutputPath = str;
                booleanRef.element = nativeEncoderAssemble(this.nativeHandle, str);
            }
            if (booleanRef.element && com.tencent.zplan.common.utils.c.f385288a.j(this.tmpOutputPath, outputFilePath)) {
                actionStatus = RECORD_COMPLETE.INSTANCE;
            } else {
                actionStatus = ERROR_APNG_ENCODE_FAIL.INSTANCE;
            }
            long i3 = com.tencent.zplan.common.utils.c.f385288a.i(outputFilePath);
            int frameCount = getFrameCount();
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "assemble to " + outputFilePath + ", result:" + actionStatus + ", fileSize:" + i3 + ", frameCount:" + frameCount + ", costTime:" + (System.currentTimeMillis() - currentTimeMillis), null, 8, null);
            }
            return actionStatus;
        }
        return ERROR_APNG_ENV_INIT_FAIL.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x011d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011a, code lost:
    
        if (r8 == null) goto L51;
     */
    @Override // com.tencent.zplan.meme.encoder.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int portraitId, @NotNull final byte[] pixels, final int width, final int height) {
        Handler handler;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (!INSTANCE.c() || this.nativeHandle == 0) {
            return false;
        }
        this.frameCount++;
        int backgroundColor = this.config.getBackgroundColor();
        if (backgroundColor != 0) {
            f.f(pixels, backgroundColor);
        }
        BusinessConfig.FrameType frameType = this.config.getFrameType();
        boolean saveEachFrame2File = this.config.getSaveEachFrame2File();
        if (n()) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "addFrame " + this.frameCount + " exit due to checkSize", null, 8, null);
            }
            return false;
        }
        if (this.frameCount == 1 && this.encodeImmediately && (handler = this.asyncHandler) != null) {
            handler.post(new Runnable() { // from class: com.tencent.zplan.meme.encoder.apng.MemeApngEncoder$addFrame$1
                @Override // java.lang.Runnable
                public final void run() {
                    long j3;
                    String str;
                    MemeApngEncoder.this.tmpOutputPath = Constant.f385743c.a() + File.separator + System.nanoTime();
                    MemeApngEncoder memeApngEncoder = MemeApngEncoder.this;
                    j3 = memeApngEncoder.nativeHandle;
                    str = MemeApngEncoder.this.tmpOutputPath;
                    memeApngEncoder.nativeEncoderEncodeFramePrepare(j3, str, width, height);
                }
            });
        }
        if (this.encodeImmediately) {
            Handler handler2 = this.asyncHandler;
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: com.tencent.zplan.meme.encoder.apng.MemeApngEncoder$addFrame$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        long j3;
                        int i3;
                        MemeApngEncoder memeApngEncoder = MemeApngEncoder.this;
                        j3 = memeApngEncoder.nativeHandle;
                        byte[] bArr = pixels;
                        int i16 = width;
                        int i17 = height;
                        i3 = MemeApngEncoder.this.delayDenominator;
                        memeApngEncoder.nativeEncoderEncodeFrame(j3, bArr, i16, i17, 1, i3);
                    }
                });
            }
        } else {
            nativeEncoderAddFrame(this.nativeHandle, pixels, width, height, 1, this.delayDenominator);
        }
        if (!saveEachFrame2File) {
            return true;
        }
        Bitmap bitmap = null;
        try {
            try {
                bitmap = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
                String str = this.tempFilePath + File.separator + SystemClock.elapsedRealtime() + frameType.suffix();
                int i3 = a.f385812a[frameType.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        f.d(bitmap, new File(str));
                    }
                } else {
                    f.e(bitmap, 100, str);
                }
                this.framePathList.add(str);
            } catch (OutOfMemoryError e16) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    a17.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "addFrame OOM", e16);
                }
                System.gc();
            }
        } finally {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean c() {
        return a.C10067a.b(this);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void close() {
        if (!INSTANCE.c()) {
            return;
        }
        long j3 = this.nativeHandle;
        if (j3 != 0) {
            nativeEncoderRelease(j3);
            this.nativeHandle = 0L;
        }
        r(this.encodeImmediately);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        return this.frameCount;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        boolean c16 = INSTANCE.c();
        if (!c16) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.d(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "init, isReady:" + c16 + ", return!!", null, 8, null);
                return;
            }
            return;
        }
        close();
        this.nativeHandle = nativeEncoderInit();
        s(false, false, false, 1);
        t(true);
        try {
            this.nativeVersion = nativeEncoderVersion();
        } catch (Throwable th5) {
            d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                a17.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "nativeEncoderVersion error", th5);
            }
        }
        this.encodeImmediately = w();
        boolean v3 = v();
        boolean apngFullRectMode = this.config.getOptimization().getApngFullRectMode();
        boolean u16 = u();
        boolean apngCompressMode = this.config.getOptimization().getApngCompressMode();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("nativeVersion:" + this.nativeVersion + ", ");
        sb5.append("encodeImmediately:" + this.encodeImmediately + ", ");
        sb5.append("delayDenominator:" + this.delayDenominator + ", ");
        sb5.append("supportFullRectMode:" + v3 + ", fullRectModeConfig:" + apngFullRectMode + ", ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("supportCompressMode:");
        sb6.append(u16);
        sb6.append(", compressModeConfig:");
        sb6.append(apngCompressMode);
        sb5.append(sb6.toString());
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "StringBuilder().apply(builderAction).toString()");
        d a18 = LogUtil.f385285b.a();
        if (a18 != null) {
            d.a.c(a18, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, sb7, null, 8, null);
        }
        if (v3) {
            nativeEncoderSetFullRectMode(this.nativeHandle, apngFullRectMode);
        }
        if (u16) {
            nativeEncoderSetCompressMode(this.nativeHandle, apngCompressMode);
        }
        q(this.encodeImmediately);
    }

    public final boolean o(@NotNull String apngInputPath, @NotNull String gifOutputPath) {
        Intrinsics.checkNotNullParameter(apngInputPath, "apngInputPath");
        Intrinsics.checkNotNullParameter(gifOutputPath, "gifOutputPath");
        LogUtil logUtil = LogUtil.f385285b;
        d a16 = logUtil.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "convertToGif " + apngInputPath + " to " + gifOutputPath, null, 8, null);
        }
        File file = new File(apngInputPath);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        try {
            com.tencent.zplan.common.utils.c.f385288a.d(gifOutputPath);
            if (nativeEncoderVersion() >= 116) {
                int apng2GifLimitAlpha = Meme.f385754h.k().getApngModeConfig().getApng2GifLimitAlpha();
                d a17 = logUtil.a();
                if (a17 != null) {
                    d.a.c(a17, "[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "convertToGif limited alpha: " + apng2GifLimitAlpha, null, 8, null);
                }
                nativeEncoderSetGifLimitedAlpha(apng2GifLimitAlpha);
            }
            return nativeEncoderConvertGif(apngInputPath, gifOutputPath, 1);
        } catch (Throwable th5) {
            d a18 = LogUtil.f385285b.a();
            if (a18 == null) {
                return false;
            }
            a18.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeApngEncoder]", 1, "convertToGif", th5);
            return false;
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ArrayList<String> getFrames() {
        return this.framePathList;
    }
}
