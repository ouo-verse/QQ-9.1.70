package it1;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Size;
import android.view.Surface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001cBW\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010*\u001a\u00020&\u00126\u00103\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020.0+\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010*\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)RG\u00103\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020.0+8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010IR\u0016\u0010N\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010IR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010IR\u0018\u0010U\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010MR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lit1/i;", "Lit1/e;", "Landroid/os/Handler$Callback;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "width", "height", "k", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", DomainData.DOMAIN_NAME, "g", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "trtcVideoFrame", "l", "Lit1/d;", "eglCore", "d", "", "eglContext", "i", "f", "init", "destroy", "Landroid/os/Message;", "msg", "", "handleMessage", "Lcom/tencent/trtc/TRTCCloud;", "Lcom/tencent/trtc/TRTCCloud;", "trtcCloud", "", "e", "Ljava/lang/String;", "getTinyId", "()Ljava/lang/String;", "tinyId", "Landroid/view/Surface;", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surface", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Ljava/lang/Void;", tl.h.F, "Lkotlin/jvm/functions/Function2;", "getOnFrameSizeChanged", "()Lkotlin/jvm/functions/Function2;", "onFrameSizeChanged", "tag", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "glHandlerThread", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "glHandler", "D", "Lit1/d;", "Lht1/a;", "E", "Lht1/a;", "normalFilter", "Ljava/nio/FloatBuffer;", UserInfo.SEX_FEMALE, "Ljava/nio/FloatBuffer;", "glCubeBuffer", "G", "glTextureBuffer", "H", "I", "lastFrameWidth", "lastFrameHeight", "J", "Z", "inited", "K", "surfaceWidth", "L", "surfaceHeight", "M", "Ljava/util/concurrent/CountDownLatch;", "destroyCountDownLatch", "N", "logedIfEglStateError", "Lit1/j;", "P", "Lit1/j;", "videoFrameRenderObj", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "mCheckReceiveVideoFrameRunnable", "<init>", "(Lcom/tencent/trtc/TRTCCloud;Ljava/lang/String;Landroid/view/Surface;Lkotlin/jvm/functions/Function2;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i implements e, Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    private Handler glHandler;

    /* renamed from: D, reason: from kotlin metadata */
    private d eglCore;

    /* renamed from: E, reason: from kotlin metadata */
    private ht1.a normalFilter;

    /* renamed from: F, reason: from kotlin metadata */
    private FloatBuffer glCubeBuffer;

    /* renamed from: G, reason: from kotlin metadata */
    private FloatBuffer glTextureBuffer;

    /* renamed from: H, reason: from kotlin metadata */
    private int lastFrameWidth;

    /* renamed from: I, reason: from kotlin metadata */
    private int lastFrameHeight;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile boolean inited;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile int surfaceWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile int surfaceHeight;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private volatile CountDownLatch destroyCountDownLatch;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean logedIfEglStateError;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final VideoFrameRenderObj videoFrameRenderObj;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable mCheckReceiveVideoFrameRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TRTCCloud trtcCloud;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tinyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Surface surface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, Integer, Void> onFrameSizeChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HandlerThread glHandlerThread;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull TRTCCloud trtcCloud, @NotNull String tinyId, @NotNull Surface surface, @NotNull Function2<? super Integer, ? super Integer, Void> onFrameSizeChanged) {
        Intrinsics.checkNotNullParameter(trtcCloud, "trtcCloud");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(onFrameSizeChanged, "onFrameSizeChanged");
        this.trtcCloud = trtcCloud;
        this.tinyId = tinyId;
        this.surface = surface;
        this.onFrameSizeChanged = onFrameSizeChanged;
        this.tag = "QGMC.VideoFrameRender." + tinyId + ":" + hashCode();
        this.surfaceWidth = 1;
        this.surfaceHeight = 1;
        this.videoFrameRenderObj = VideoFrameRenderObj.INSTANCE.a();
        this.mCheckReceiveVideoFrameRunnable = new Runnable() { // from class: it1.f
            @Override // java.lang.Runnable
            public final void run() {
                i.j(i.this);
            }
        };
    }

    private final void d(d eglCore) {
        Size b16 = eglCore.b();
        if (b16.getWidth() == 0 && b16.getHeight() == 0) {
            return;
        }
        if (b16.getWidth() != this.surfaceWidth || b16.getHeight() != this.surfaceHeight) {
            this.surfaceWidth = b16.getWidth();
            this.surfaceHeight = b16.getHeight();
            if (QLog.isColorLevel()) {
                QLog.d(this.tag, 4, "checkAndUpdateSurfaceSize, new size. " + this.surfaceWidth + " - " + this.surfaceHeight);
            }
        }
    }

    private final void f() {
        if (this.eglCore != null) {
            ht1.a aVar = this.normalFilter;
            d dVar = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalFilter");
                aVar = null;
            }
            aVar.b();
            d dVar2 = this.eglCore;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eglCore");
                dVar2 = null;
            }
            dVar2.f();
            d dVar3 = this.eglCore;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eglCore");
            } else {
                dVar = dVar3;
            }
            dVar.a();
        }
    }

    private final void g() {
        this.logedIfEglStateError = false;
        f();
        HandlerThread handlerThread = this.glHandlerThread;
        if (handlerThread == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandlerThread");
            handlerThread = null;
        }
        handlerThread.quit();
        QLog.i(this.tag, 1, "destroyInternal finish.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [it1.j] */
    public static final void h(i this$0, String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.inited) {
            return;
        }
        if (tRTCVideoFrame.texture != null) {
            GLES20.glFinish();
        }
        this$0.k(tRTCVideoFrame.width, tRTCVideoFrame.height);
        this$0.m();
        this$0.videoFrameRenderObj.e(tRTCVideoFrame);
        Handler handler = this$0.glHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandler");
            handler = null;
        }
        handler.obtainMessage(1, this$0.videoFrameRenderObj).sendToTarget();
        try {
            try {
                this$0.videoFrameRenderObj.a(50L);
            } catch (Exception e16) {
                QLog.e(this$0.tag, 1, "wait render finish error:" + e16.getMessage());
            }
        } finally {
            this$0.videoFrameRenderObj.b();
        }
    }

    private final void i(Object eglContext) {
        d dVar;
        if (eglContext instanceof EGLContext) {
            dVar = new d((EGLContext) eglContext, this.surface);
        } else if (eglContext instanceof android.opengl.EGLContext) {
            dVar = new d((android.opengl.EGLContext) eglContext, this.surface);
        } else {
            throw new IllegalArgumentException("eglContext is null!!!");
        }
        this.eglCore = dVar;
        ht1.a aVar = new ht1.a(true);
        this.normalFilter = aVar;
        aVar.d();
        FloatBuffer createNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
        Intrinsics.checkNotNullExpressionValue(createNormalCubeVerticesBuffer, "createNormalCubeVerticesBuffer()");
        this.glCubeBuffer = createNormalCubeVerticesBuffer;
        FloatBuffer createTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
        Intrinsics.checkNotNullExpressionValue(createTextureCoordsBuffer, "createTextureCoordsBuffer(k.a, false, false)");
        this.glTextureBuffer = createTextureCoordsBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.tag, 1, "check receive video frame time out!");
    }

    private final void k(int width, int height) {
        if (this.lastFrameWidth != width || this.lastFrameHeight != height) {
            QLog.d(this.tag, 4, "notify onFrameSizeChanged " + width + " --  " + height);
            this.lastFrameWidth = width;
            this.lastFrameHeight = height;
            this.onFrameSizeChanged.invoke(Integer.valueOf(width), Integer.valueOf(height));
        }
    }

    private final void l(TRTCCloudDef.TRTCVideoFrame trtcVideoFrame) {
        if (!this.surface.isValid()) {
            QLog.d(this.tag, 1, "renderInternal surface is not Valid return");
            return;
        }
        if (trtcVideoFrame == null) {
            return;
        }
        if (this.eglCore == null) {
            try {
                TRTCCloudDef.TRTCTexture tRTCTexture = trtcVideoFrame.texture;
                Object obj = tRTCTexture.eglContext10;
                if (obj == null) {
                    obj = tRTCTexture.eglContext14;
                }
                Intrinsics.checkNotNullExpressionValue(obj, "frame.texture.eglContext\u2026rame.texture.eglContext14");
                i(obj);
            } catch (Exception e16) {
                QLog.e(this.tag, 1, "initGlComponent error:" + e16.getMessage());
                return;
            }
        }
        d dVar = this.eglCore;
        d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eglCore");
            dVar = null;
        }
        if (!dVar.c()) {
            if (!this.logedIfEglStateError) {
                QLog.e(this.tag, 1, "eglCore.isEglInitSuc return false!!!");
                this.logedIfEglStateError = true;
                return;
            }
            return;
        }
        d dVar3 = this.eglCore;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eglCore");
            dVar3 = null;
        }
        dVar3.d();
        d dVar4 = this.eglCore;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eglCore");
            dVar4 = null;
        }
        d(dVar4);
        GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        ht1.a aVar = this.normalFilter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalFilter");
            aVar = null;
        }
        int i3 = trtcVideoFrame.texture.textureId;
        FloatBuffer floatBuffer = this.glCubeBuffer;
        if (floatBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glCubeBuffer");
            floatBuffer = null;
        }
        FloatBuffer floatBuffer2 = this.glTextureBuffer;
        if (floatBuffer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glTextureBuffer");
            floatBuffer2 = null;
        }
        aVar.e(i3, floatBuffer, floatBuffer2);
        d dVar5 = this.eglCore;
        if (dVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eglCore");
        } else {
            dVar2 = dVar5;
        }
        dVar2.e();
    }

    private final void m() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mCheckReceiveVideoFrameRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mCheckReceiveVideoFrameRunnable, 3000L);
    }

    private final void n(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await(60L, TimeUnit.MILLISECONDS);
        } catch (Exception e16) {
            QLog.e(this.tag, 1, "waitRenderDestroy exception:" + e16.getMessage());
        }
    }

    @Override // it1.e
    public void destroy() {
        if (!this.inited) {
            QLog.w(this.tag, 1, "[init] is false. ignore");
            return;
        }
        this.inited = false;
        this.trtcCloud.setRemoteVideoRenderListener(this.tinyId, 2, 3, new TRTCCloudListener.TRTCVideoRenderListener() { // from class: it1.h
            @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
            public final void onRenderVideoFrame(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
                i.e(str, i3, tRTCVideoFrame);
            }
        });
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mCheckReceiveVideoFrameRunnable);
        this.destroyCountDownLatch = new CountDownLatch(1);
        Handler handler = this.glHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandler");
            handler = null;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.glHandler;
        if (handler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandler");
            handler2 = null;
        }
        handler2.obtainMessage(2).sendToTarget();
        CountDownLatch countDownLatch = this.destroyCountDownLatch;
        Intrinsics.checkNotNull(countDownLatch);
        n(countDownLatch);
        this.destroyCountDownLatch = null;
        QLog.i(this.tag, 1, "destroy.");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        VideoFrameRenderObj videoFrameRenderObj;
        CountDownLatch countDownLatch;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 == 2) {
                try {
                    try {
                        g();
                        countDownLatch = this.destroyCountDownLatch;
                        if (countDownLatch == null) {
                            return false;
                        }
                    } catch (Throwable th5) {
                        CountDownLatch countDownLatch2 = this.destroyCountDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                        throw th5;
                    }
                } catch (Exception e16) {
                    QLog.e(this.tag, 1, "destroyInternal error", e16);
                    countDownLatch = this.destroyCountDownLatch;
                    if (countDownLatch == null) {
                        return false;
                    }
                }
                countDownLatch.countDown();
                return false;
            }
            return false;
        }
        Object obj = msg2.obj;
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = null;
        if (obj instanceof VideoFrameRenderObj) {
            videoFrameRenderObj = (VideoFrameRenderObj) obj;
        } else {
            videoFrameRenderObj = null;
        }
        try {
            if (videoFrameRenderObj != null) {
                try {
                    tRTCVideoFrame = videoFrameRenderObj.getFrame();
                } catch (Exception e17) {
                    QLog.e(this.tag, 1, "renderInternal error", e17);
                    if (videoFrameRenderObj == null) {
                        return false;
                    }
                }
            }
            l(tRTCVideoFrame);
            if (videoFrameRenderObj == null) {
                return false;
            }
            videoFrameRenderObj.c();
            return false;
        } catch (Throwable th6) {
            if (videoFrameRenderObj != null) {
                videoFrameRenderObj.c();
            }
            throw th6;
        }
    }

    @Override // it1.e
    public void init() {
        if (this.inited) {
            QLog.w(this.tag, 1, "[init] is inited. ignore");
            return;
        }
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("VideoFrameRender_" + this.tinyId, 0);
        Intrinsics.checkNotNullExpressionValue(newFreeHandlerThread, "newFreeHandlerThread(\n  \u2026RIORITY_DEFAULT\n        )");
        this.glHandlerThread = newFreeHandlerThread;
        HandlerThread handlerThread = null;
        if (newFreeHandlerThread == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandlerThread");
            newFreeHandlerThread = null;
        }
        newFreeHandlerThread.start();
        HandlerThread handlerThread2 = this.glHandlerThread;
        if (handlerThread2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glHandlerThread");
        } else {
            handlerThread = handlerThread2;
        }
        this.glHandler = new Handler(handlerThread.getLooper(), this);
        this.trtcCloud.setRemoteVideoRenderListener(this.tinyId, 2, 3, new TRTCCloudListener.TRTCVideoRenderListener() { // from class: it1.g
            @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
            public final void onRenderVideoFrame(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
                i.h(i.this, str, i3, tRTCVideoFrame);
            }
        });
        QLog.i(this.tag, 1, "init.");
        this.inited = true;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, int i3, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
    }
}
