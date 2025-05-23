package com.tencent.zplan.meme.encoder.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_ENCODE_NO_FRAME;
import com.tencent.zplan.meme.action.ERROR_GIF_ENCODE_FAIL;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.encoder.a;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 92\u00020\u0001:\u0001\fB'\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00102\u001a\u00020\b\u0012\u0006\u00103\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020\u0006\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0014j\b\u0012\u0004\u0012\u00020\b`\u0015H\u0016R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0014j\b\u0012\u0004\u0012\u00020\b`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0017\u00100\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u00103\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00101R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/zplan/meme/encoder/gif/MemeGifEncoder;", "Lcom/tencent/zplan/meme/encoder/a;", "", "i", "", "j", "", "portraitId", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "close", "", "pixels", "width", "height", "b", "getFrameCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "picList", "Lcooperation/qzone/util/GifCoder;", "c", "Lcooperation/qzone/util/GifCoder;", "gifEncoder", "d", "Z", "gifFrameEncodeImmediately", "Ljava/util/concurrent/CountDownLatch;", "e", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "asyncHandler", "Landroid/os/HandlerThread;", "g", "Landroid/os/HandlerThread;", "handlerThread", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "getConfig", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "Ljava/lang/String;", "tempFilePath", "finalFilePath", "k", "I", "perFrameTime", "<init>", "(Lcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;Ljava/lang/String;I)V", "l", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeGifEncoder implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> picList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final GifCoder gifEncoder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean gifFrameEncodeImmediately;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CountDownLatch countDownLatch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Handler asyncHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private HandlerThread handlerThread;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BusinessConfig config;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String tempFilePath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String finalFilePath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int perFrameTime;

    public MemeGifEncoder(@NotNull BusinessConfig config, @NotNull String tempFilePath, @NotNull String finalFilePath, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(finalFilePath, "finalFilePath");
        this.config = config;
        this.tempFilePath = tempFilePath;
        this.finalFilePath = finalFilePath;
        this.perFrameTime = i3;
        this.picList = new ArrayList<>();
        GifCoder gifCoder = new GifCoder();
        if (config.getBackgroundColor() == 0) {
            gifCoder.setEncoderDispose(3);
            gifCoder.setNeedRemoveSamePixels(false);
            gifCoder.setTransparentThreshold(Meme.f385754h.k().getGifModeConfig().getTransparentThreshold());
        }
        Unit unit = Unit.INSTANCE;
        this.gifEncoder = gifCoder;
        boolean streamingMode = Meme.f385754h.k().getGifModeConfig().getStreamingMode();
        this.gifFrameEncodeImmediately = streamingMode;
        this.countDownLatch = new CountDownLatch(1);
        gifCoder.setUseOrignalBitmap(true);
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeGifEncoder]", 1, "gifFrameEncodeImmediately:" + streamingMode, null, 8, null);
        }
        i();
    }

    private final void i() {
        if (this.gifFrameEncodeImmediately) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("[zplan][MemePlayer-SDK][MemeEncoder][MemeGifEncoder]");
            this.handlerThread = baseHandlerThread;
            baseHandlerThread.setPriority(9);
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
            }
            handlerThread.start();
            HandlerThread handlerThread2 = this.handlerThread;
            if (handlerThread2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
            }
            this.asyncHandler = new Handler(handlerThread2.getLooper());
        }
    }

    private final void j(boolean z16) {
        if (z16) {
            HandlerThread handlerThread = this.handlerThread;
            if (handlerThread == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
            }
            handlerThread.quitSafely();
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        ActionStatus actionStatus;
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        if (this.picList.size() == 0) {
            return ERROR_ENCODE_NO_FRAME.INSTANCE;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.picList);
        if (this.gifFrameEncodeImmediately) {
            Handler handler = this.asyncHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("asyncHandler");
            }
            handler.post(new Runnable() { // from class: com.tencent.zplan.meme.encoder.gif.MemeGifEncoder$encode$result$1
                @Override // java.lang.Runnable
                public final void run() {
                    GifCoder gifCoder;
                    CountDownLatch countDownLatch;
                    gifCoder = MemeGifEncoder.this.gifEncoder;
                    gifCoder.closeEncoder();
                    countDownLatch = MemeGifEncoder.this.countDownLatch;
                    countDownLatch.countDown();
                }
            });
            this.countDownLatch.await();
            if (c.f385288a.h(outputFilePath)) {
                actionStatus = RECORD_COMPLETE.INSTANCE;
            } else {
                actionStatus = ERROR_GIF_ENCODE_FAIL.INSTANCE;
            }
        } else if (this.gifEncoder.encodeGif(outputFilePath, arrayList, frameTime) && c.f385288a.h(outputFilePath)) {
            actionStatus = RECORD_COMPLETE.INSTANCE;
        } else {
            actionStatus = ERROR_GIF_ENCODE_FAIL.INSTANCE;
        }
        int frameCount = getFrameCount();
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeGifEncoder]", 1, "encode " + frameCount + " frames to " + outputFilePath + ", file exists:" + c.f385288a.h(outputFilePath) + ", result:" + actionStatus, null, 8, null);
        }
        return actionStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.graphics.Bitmap] */
    @Override // com.tencent.zplan.meme.encoder.a
    public boolean b(int portraitId, @NotNull byte[] pixels, int width, int height) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        long currentTimeMillis = System.currentTimeMillis();
        f.f(pixels, this.config.getBackgroundColor());
        BusinessConfig.FrameType frameType = this.config.getFrameType();
        String str = this.tempFilePath + File.separator + currentTimeMillis + frameType.suffix();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        try {
            try {
                objectRef.element = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
                int i3 = a.f385847a[frameType.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        f.d((Bitmap) objectRef.element, new File(str));
                    }
                } else {
                    f.e((Bitmap) objectRef.element, 100, str);
                }
                this.picList.add(str);
                if (this.gifFrameEncodeImmediately) {
                    Handler handler = this.asyncHandler;
                    if (handler == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("asyncHandler");
                    }
                    handler.post(new Runnable() { // from class: com.tencent.zplan.meme.encoder.gif.MemeGifEncoder$addFrame$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            GifCoder gifCoder;
                            String str2;
                            int i16;
                            gifCoder = MemeGifEncoder.this.gifEncoder;
                            Bitmap bitmap2 = (Bitmap) objectRef.element;
                            str2 = MemeGifEncoder.this.finalFilePath;
                            i16 = MemeGifEncoder.this.perFrameTime;
                            gifCoder.encodeGif(bitmap2, str2, i16);
                            if (!((Bitmap) objectRef.element).isRecycled()) {
                                ((Bitmap) objectRef.element).recycle();
                            }
                        }
                    });
                }
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeGifEncoder]", 1, "add frame " + str + " costTime:" + (System.currentTimeMillis() - currentTimeMillis), null, 8, null);
                }
                return true;
            } catch (OutOfMemoryError e16) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    a17.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeGifEncoder]", 1, "addFrame OOM", e16);
                }
                System.gc();
                throw e16;
            }
        } finally {
            if (!this.gifFrameEncodeImmediately && (bitmap = (Bitmap) objectRef.element) != null) {
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
        this.gifEncoder.closeEncoder();
        j(this.gifFrameEncodeImmediately);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        return this.picList.size();
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ArrayList<String> getFrames() {
        return this.picList;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        a.C10067a.c(this);
    }
}
