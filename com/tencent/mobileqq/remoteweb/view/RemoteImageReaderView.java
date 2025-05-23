package com.tencent.mobileqq.remoteweb.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.util.UiThreadUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002CDB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0003J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J(\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010%R\u0016\u0010-\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010%R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/RemoteImageReaderView;", "Landroid/view/View;", "", "c", "d", "e", "f", "", "width", "height", "Landroid/media/ImageReader;", "g", h.F, "j", "k", "newImageReader", "setImageReader", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "oldWidth", "oldHeight", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/os/Handler;", "Landroid/os/Handler;", "msgHandler", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "msgHandlerThread", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "currentBitmap", "Landroid/media/Image;", "Landroid/media/Image;", "currentImage", "", "i", "Z", "isAttachedToRenderer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/media/ImageReader;", "imageReader", BdhLogUtil.LogTag.Tag_Conn, "userDefaultImageReader", "D", "isDestroy", "Ljava/util/concurrent/atomic/AtomicInteger;", "E", "Ljava/util/concurrent/atomic/AtomicInteger;", "imageIndex", "", UserInfo.SEX_FEMALE, "Ljava/lang/Object;", "imageLock", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/remoteweb/view/RemoteImageReaderView$b;", "G", "Ljava/util/concurrent/CopyOnWriteArrayList;", "bitmapUpdateCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "b", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteImageReaderView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean userDefaultImageReader;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final AtomicInteger imageIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Object imageLock;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> bitmapUpdateCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler msgHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HandlerThread msgHandlerThread;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Bitmap currentBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Image currentImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isAttachedToRenderer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageReader imageReader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/RemoteImageReaderView$a;", "", "", "MAX_BUFFER_SIZE", "I", "", "REMOTE_COMMON_THREAD_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.view.RemoteImageReaderView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/RemoteImageReaderView$b;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a(@Nullable Bitmap bitmap);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteImageReaderView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    private final void c() {
        if (this.isAttachedToRenderer && !this.isDestroy) {
            Image image = null;
            try {
                ImageReader imageReader = this.imageReader;
                if (imageReader != null) {
                    image = imageReader.acquireLatestImage();
                }
            } catch (Throwable th5) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str = "[acquireLatestImage] error! " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteImageReaderView", 1, (String) it.next(), th5);
                }
            }
            if (image != null) {
                d();
                synchronized (this.imageLock) {
                    this.currentImage = image;
                    Unit unit = Unit.INSTANCE;
                }
                k();
                if (UiThreadUtil.isOnUiThread()) {
                    invalidate();
                } else {
                    postInvalidate();
                }
            }
        }
    }

    private final void d() {
        if (this.currentImage != null) {
            synchronized (this.imageLock) {
                Image image = this.currentImage;
                if (image != null) {
                    image.close();
                }
                this.currentImage = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000c, code lost:
    
        r1 = r1.getHardwareBuffer();
     */
    @TargetApi(29)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e() {
        HardwareBuffer hardwareBuffer;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        if (this.currentImage == null) {
            return;
        }
        synchronized (this.imageLock) {
            Image image = this.currentImage;
            if (image != null && hardwareBuffer != null) {
                Intrinsics.checkNotNullExpressionValue(hardwareBuffer, "currentImage?.hardwareBuffer ?: return");
                named = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(named);
                wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
                this.currentBitmap = wrapHardwareBuffer;
                hardwareBuffer.close();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        if (r3 == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f() {
        Image.Plane[] planeArr;
        int i3;
        Object firstOrNull;
        boolean z16;
        if (this.currentImage == null) {
            return;
        }
        synchronized (this.imageLock) {
            Image image = this.currentImage;
            if (image != null) {
                planeArr = image.getPlanes();
            } else {
                planeArr = null;
            }
            if (planeArr == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(planeArr, "currentImage?.planes ?: return");
            Image image2 = this.currentImage;
            boolean z17 = false;
            if (image2 != null) {
                i3 = image2.getHeight();
            } else {
                i3 = 0;
            }
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(planeArr);
            Image.Plane plane = (Image.Plane) firstOrNull;
            if (plane == null) {
                return;
            }
            int rowStride = plane.getRowStride() / Math.max(1, plane.getPixelStride());
            if (rowStride != 0 && i3 != 0) {
                if (this.currentBitmap != null) {
                    Bitmap bitmap = this.currentBitmap;
                    if (bitmap != null && bitmap.getWidth() == rowStride) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Bitmap bitmap2 = this.currentBitmap;
                        if (bitmap2 != null && bitmap2.getHeight() == i3) {
                            z17 = true;
                        }
                    }
                }
                this.currentBitmap = Bitmap.createBitmap(rowStride, i3, Bitmap.Config.ARGB_8888);
                ByteBuffer buffer = plane.getBuffer();
                buffer.rewind();
                Bitmap bitmap3 = this.currentBitmap;
                if (bitmap3 != null) {
                    bitmap3.copyPixelsFromBuffer(buffer);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private final ImageReader g(int width, int height) {
        ImageReader newInstance;
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteImageReaderView", 1, "[createImageReader] width " + width + ", height " + height);
        this.userDefaultImageReader = true;
        if (Build.VERSION.SDK_INT >= 29) {
            newInstance = ImageReader.newInstance(width, height, 1, 3, 768L);
            Intrinsics.checkNotNullExpressionValue(newInstance, "{\n            ImageReade\u2026T\n            )\n        }");
            return newInstance;
        }
        ImageReader newInstance2 = ImageReader.newInstance(width, height, 1, 3);
        Intrinsics.checkNotNullExpressionValue(newInstance2, "{\n            ImageReade\u2026E\n            )\n        }");
        return newInstance2;
    }

    private final void h() {
        if (this.imageReader == null) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            this.imageReader = g(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: com.tencent.mobileqq.remoteweb.view.d
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader2) {
                    RemoteImageReaderView.i(RemoteImageReaderView.this, imageReader2);
                }
            };
            Handler handler = this.msgHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgHandler");
                handler = null;
            }
            imageReader.setOnImageAvailableListener(onImageAvailableListener, handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(RemoteImageReaderView this$0, ImageReader imageReader) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteImageReaderView", 1, "[onImageAvailable] " + this$0.imageIndex.incrementAndGet());
        }
        this$0.c();
    }

    private final void j() {
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("RemoteWeb_ImageReader_Thread", 0);
        Intrinsics.checkNotNullExpressionValue(newFreeHandlerThread, "newFreeHandlerThread(\n  \u2026RIORITY_DEFAULT\n        )");
        this.msgHandlerThread = newFreeHandlerThread;
        HandlerThread handlerThread = null;
        if (newFreeHandlerThread == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgHandlerThread");
            newFreeHandlerThread = null;
        }
        newFreeHandlerThread.start();
        HandlerThread handlerThread2 = this.msgHandlerThread;
        if (handlerThread2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgHandlerThread");
        } else {
            handlerThread = handlerThread2;
        }
        this.msgHandler = new Handler(handlerThread.getLooper());
    }

    private final void k() {
        if (this.currentImage == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            e();
        } else {
            f();
        }
        Iterator<T> it = this.bitmapUpdateCallback.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.currentBitmap);
        }
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(oldWidth), Integer.valueOf(oldHeight));
        }
    }

    public final void setImageReader(@NotNull ImageReader newImageReader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newImageReader);
            return;
        }
        Intrinsics.checkNotNullParameter(newImageReader, "newImageReader");
        if (this.imageReader != null) {
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                bVar.a().add("[setImageReader] imageReader is not null!");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteImageReaderView", 1, (String) it.next(), null);
                }
                return;
            }
            throw new RuntimeException("imageReader is already set!");
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteImageReaderView", 1, "[setImageReader]");
        this.imageReader = newImageReader;
        this.userDefaultImageReader = false;
        h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteImageReaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ RemoteImageReaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteImageReaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.userDefaultImageReader = true;
        this.imageIndex = new AtomicInteger(0);
        this.imageLock = new Object();
        this.bitmapUpdateCallback = new CopyOnWriteArrayList<>();
        j();
        setClickable(true);
    }
}
