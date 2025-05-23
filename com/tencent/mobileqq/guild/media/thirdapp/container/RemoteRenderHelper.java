package com.tencent.mobileqq.guild.media.thirdapp.container;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.util.AppSetting;
import com.tencent.util.UiThreadUtil;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\u000e\u0015B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0006\u0010\f\u001a\u00020\u0002R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010*R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00109R\u0013\u0010=\u001a\u0004\u0018\u00010;8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/RemoteRenderHelper;", "", "", "d", "e", "f", "g", "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", h.F, "", "a", "I", "getDisplayWidth", "()I", "setDisplayWidth", "(I)V", "displayWidth", "b", "getDisplayHeight", "setDisplayHeight", "displayHeight", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "msgHandler", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "msgHandlerThread", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "currentBitmap", "Landroid/media/Image;", "Landroid/media/Image;", "currentImage", "Landroid/media/ImageReader;", "Landroid/media/ImageReader;", "imageReader", "", "Z", "isAttachedToRenderer", "isDestroy", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/RemoteRenderHelper$b;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "bitmapUpdateCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "k", "Ljava/util/concurrent/atomic/AtomicInteger;", "imageIndex", "l", "Ljava/lang/Object;", "imageLock", "Landroid/media/ImageReader$OnImageAvailableListener;", "Landroid/media/ImageReader$OnImageAvailableListener;", "imageUpdateListener", "Landroid/view/Surface;", "()Landroid/view/Surface;", "surface", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RemoteRenderHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int displayWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int displayHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Handler msgHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private HandlerThread msgHandlerThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Bitmap currentBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Image currentImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageReader imageReader;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isAttachedToRenderer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> bitmapUpdateCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger imageIndex;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object imageLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageReader.OnImageAvailableListener imageUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/RemoteRenderHelper$b;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@Nullable Bitmap bitmap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RemoteRenderHelper() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    private final void d() {
        if (this.isAttachedToRenderer && !this.isDestroy) {
            Image image = null;
            try {
                ImageReader imageReader = this.imageReader;
                if (imageReader != null) {
                    image = imageReader.acquireLatestImage();
                }
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "[acquireLatestImage] error! " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("RemoteWeb.RemoteRenderHelper", 1, (String) it.next(), th5);
                }
            }
            if (image != null) {
                e();
                synchronized (this.imageLock) {
                    this.currentImage = image;
                    Unit unit = Unit.INSTANCE;
                }
                o();
            }
        }
    }

    private final void e() {
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
    private final void f() {
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
    private final void g() {
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

    private final void i() {
        ImageReader imageReader;
        ImageReader imageReader2 = this.imageReader;
        if (imageReader2 != null) {
            Handler handler = this.msgHandler;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgHandler");
                handler = null;
            }
            imageReader2.setOnImageAvailableListener(null, handler);
        }
        if (Build.VERSION.SDK_INT >= 28 && (imageReader = this.imageReader) != null) {
            imageReader.discardFreeBuffers();
        }
        ImageReader imageReader3 = this.imageReader;
        if (imageReader3 != null) {
            imageReader3.close();
        }
        this.imageReader = null;
    }

    private final void j() {
        if (!this.isAttachedToRenderer) {
            return;
        }
        Logger.f235387a.d().d("RemoteWeb.RemoteRenderHelper", 1, "[detachFromRenderer] ");
        d();
        e();
        n();
        i();
        this.isAttachedToRenderer = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(RemoteRenderHelper this$0, ImageReader imageReader) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (AppSetting.isDebugVersion()) {
            Logger.f235387a.d().d("RemoteWeb.RemoteRenderHelper", 1, "[onImageAvailable] " + this$0.imageIndex.incrementAndGet());
        }
        this$0.d();
    }

    private final void m() {
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

    private final void n() {
        this.bitmapUpdateCallback.clear();
    }

    private final void o() {
        if (this.currentImage == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            f();
        } else {
            g();
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.g
            @Override // java.lang.Runnable
            public final void run() {
                RemoteRenderHelper.p(RemoteRenderHelper.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RemoteRenderHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.bitmapUpdateCallback.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this$0.currentBitmap);
        }
    }

    public final void h() {
        if (this.isDestroy) {
            return;
        }
        this.isDestroy = true;
        Logger.f235387a.d().d("RemoteWeb.RemoteRenderHelper", 1, "[destroy]");
        j();
        HandlerThread handlerThread = this.msgHandlerThread;
        if (handlerThread == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgHandlerThread");
            handlerThread = null;
        }
        handlerThread.quitSafely();
        this.bitmapUpdateCallback.clear();
    }

    @Nullable
    public final Surface k() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            return imageReader.getSurface();
        }
        return null;
    }

    public RemoteRenderHelper(int i3, int i16) {
        this.displayWidth = i3;
        this.displayHeight = i16;
        this.bitmapUpdateCallback = new CopyOnWriteArrayList<>();
        this.imageIndex = new AtomicInteger(0);
        this.imageLock = new Object();
        this.imageUpdateListener = new ImageReader.OnImageAvailableListener() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.f
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader) {
                RemoteRenderHelper.l(RemoteRenderHelper.this, imageReader);
            }
        };
        m();
    }

    public /* synthetic */ RemoteRenderHelper(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
    }
}
