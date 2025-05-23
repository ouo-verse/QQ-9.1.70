package n15;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010>\u001a\u00020)\u0012\u0006\u0010?\u001a\u00020)\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u0016\u0010\u001cR\u001e\u0010!\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u001e\u0010$\u001a\n \u001f*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010#R\u001e\u0010(\u001a\n \u001f*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Ln15/a;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "", "i", "c", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "d", "g", "f", "a", "", "invert", "b", "Landroid/graphics/SurfaceTexture;", "st", "onFrameAvailable", "flipY", h.F, "Ln15/e;", "Ln15/e;", "mTextureRender", "e", "Landroid/graphics/SurfaceTexture;", "mSurfaceTexture", "Landroid/view/Surface;", "<set-?>", "Landroid/view/Surface;", "()Landroid/view/Surface;", "surface", "Landroid/opengl/EGLDisplay;", "kotlin.jvm.PlatformType", "Landroid/opengl/EGLDisplay;", "mEGLDisplay", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLContext;", "mEGLContext", "Landroid/opengl/EGLSurface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/opengl/EGLSurface;", "mEGLSurface", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mWidth", "D", "mHeight", "Ljava/lang/Object;", "E", "Ljava/lang/Object;", "mFrameSyncObject", UserInfo.SEX_FEMALE, "Z", "mFrameAvailable", "Ljava/nio/ByteBuffer;", "G", "Ljava/nio/ByteBuffer;", "mPixelBuf", "Ln15/d;", "H", "Ln15/d;", "mFrameWrapper", "width", "height", "<init>", "(II)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements SurfaceTexture.OnFrameAvailableListener {
    private static final boolean J = false;

    /* renamed from: C, reason: from kotlin metadata */
    private int mWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mFrameAvailable;

    /* renamed from: G, reason: from kotlin metadata */
    private ByteBuffer mPixelBuf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private e mTextureRender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SurfaceTexture mSurfaceTexture;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;

    /* renamed from: E, reason: from kotlin metadata */
    private final Object mFrameSyncObject = new Object();

    /* renamed from: H, reason: from kotlin metadata */
    private final d mFrameWrapper = new d();

    public a(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.mWidth = i3;
            this.mHeight = i16;
            c();
            f();
            i();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final Bitmap d(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        if (bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap ret = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        Intrinsics.checkNotNullExpressionValue(ret, "ret");
        return ret;
    }

    private final void i() {
        e eVar = new e();
        this.mTextureRender = eVar;
        Intrinsics.checkNotNull(eVar);
        eVar.f();
        if (J) {
            e eVar2 = this.mTextureRender;
            Intrinsics.checkNotNull(eVar2);
            Log.d("STextureRender", "textureID=" + eVar2.getMTextureId());
        }
        e eVar3 = this.mTextureRender;
        Intrinsics.checkNotNull(eVar3);
        SurfaceTexture surfaceTexture = new SurfaceTexture(eVar3.getMTextureId());
        this.mSurfaceTexture = surfaceTexture;
        Intrinsics.checkNotNull(surfaceTexture);
        surfaceTexture.setOnFrameAvailableListener(this);
        this.surface = new Surface(this.mSurfaceTexture);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mWidth * this.mHeight * 4);
        this.mPixelBuf = allocateDirect;
        if (allocateDirect != null) {
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public final void a() {
        synchronized (this.mFrameSyncObject) {
            do {
                if (!this.mFrameAvailable) {
                    try {
                        this.mFrameSyncObject.wait(2500L);
                    } catch (InterruptedException e16) {
                        throw new RuntimeException(e16);
                    }
                } else {
                    this.mFrameAvailable = false;
                    Unit unit = Unit.INSTANCE;
                }
            } while (this.mFrameAvailable);
            throw new RuntimeException("frame wait timed out");
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        Intrinsics.checkNotNull(surfaceTexture);
        surfaceTexture.updateTexImage();
    }

    public final void b(boolean invert) {
        this.mFrameWrapper.b(this.mWidth, this.mHeight);
        e eVar = this.mTextureRender;
        Intrinsics.checkNotNull(eVar);
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        Intrinsics.checkNotNull(surfaceTexture);
        eVar.c(surfaceTexture, invert);
    }

    /* renamed from: e, reason: from getter */
    public final Surface getSurface() {
        return this.surface;
    }

    public final void f() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public final void g() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroySurface(eGLDisplay, this.mEGLSurface);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        Surface surface = this.surface;
        Intrinsics.checkNotNull(surface);
        surface.release();
        this.mTextureRender = null;
        this.surface = null;
        this.mSurfaceTexture = null;
    }

    public final Bitmap h(boolean flipY) {
        ByteBuffer byteBuffer = this.mPixelBuf;
        Intrinsics.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        GLES20.glReadPixels(0, 0, this.mWidth, this.mHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mPixelBuf);
        Bitmap bmp = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        ByteBuffer byteBuffer2 = this.mPixelBuf;
        Intrinsics.checkNotNull(byteBuffer2);
        byteBuffer2.rewind();
        bmp.copyPixelsFromBuffer(this.mPixelBuf);
        if (flipY) {
            Intrinsics.checkNotNullExpressionValue(bmp, "bmp");
            bmp = d(bmp);
        }
        Intrinsics.checkNotNullExpressionValue(bmp, "bmp");
        return bmp;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture st5) {
        Intrinsics.checkNotNullParameter(st5, "st");
        if (J) {
            Log.d("STextureRender", "new frame available");
        }
        synchronized (this.mFrameSyncObject) {
            if (!this.mFrameAvailable) {
                this.mFrameAvailable = true;
                this.mFrameSyncObject.notifyAll();
                Unit unit = Unit.INSTANCE;
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    private final void c() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                    this.mEGLContext = eglCreateContext;
                    if (eglCreateContext != null) {
                        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.mWidth, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.mHeight, 12344}, 0);
                        this.mEGLSurface = eglCreatePbufferSurface;
                        if (eglCreatePbufferSurface == null) {
                            throw new RuntimeException("surface was null");
                        }
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.mEGLDisplay = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }
}
