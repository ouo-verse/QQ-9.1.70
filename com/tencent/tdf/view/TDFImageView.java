package com.tencent.tdf.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.event.IgnoreHitCheckEvent;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TDFImageView extends View implements IgnoreHitCheckEvent, RenderSurface, INativeViewDelegate {
    static IPatchRedirector $redirector_;
    private Bitmap currentBitmap;
    private Image currentImage;
    protected ImageReader imageReader;
    private boolean isAttachedToFlutterRenderer;
    private SurfaceKind kind;
    private INativeViewDelegate mNativeProxy;
    protected TDFEngine tdfEngine;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class SurfaceKind {
        private static final /* synthetic */ SurfaceKind[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SurfaceKind background;
        public static final SurfaceKind overlay;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15592);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            SurfaceKind surfaceKind = new SurfaceKind("background", 0);
            background = surfaceKind;
            SurfaceKind surfaceKind2 = new SurfaceKind("overlay", 1);
            overlay = surfaceKind2;
            $VALUES = new SurfaceKind[]{surfaceKind, surfaceKind2};
        }

        SurfaceKind(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static SurfaceKind valueOf(String str) {
            return (SurfaceKind) Enum.valueOf(SurfaceKind.class, str);
        }

        public static SurfaceKind[] values() {
            return (SurfaceKind[]) $VALUES.clone();
        }
    }

    public TDFImageView(Context context, TDFEngine tDFEngine, int i3, int i16, SurfaceKind surfaceKind) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, tDFEngine, Integer.valueOf(i3), Integer.valueOf(i16), surfaceKind);
            return;
        }
        this.isAttachedToFlutterRenderer = false;
        this.imageReader = createImageReader(i3, i16);
        this.kind = surfaceKind;
        this.tdfEngine = tDFEngine;
        init();
        this.mNativeProxy = new NativeViewDelegate(this);
    }

    private void closeCurrentImage() {
        Image image = this.currentImage;
        if (image != null) {
            image.close();
            this.currentImage = null;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(19)
    private ImageReader createImageReader(int i3, int i16) {
        ImageReader newInstance;
        if (Build.VERSION.SDK_INT >= 29) {
            newInstance = ImageReader.newInstance(i3, i16, 1, 3, 768L);
            return newInstance;
        }
        return ImageReader.newInstance(i3, i16, 1, 3);
    }

    private void init() {
        setAlpha(0.0f);
    }

    @TargetApi(29)
    private void updateCurrentBitmap() {
        HardwareBuffer hardwareBuffer;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        if (Build.VERSION.SDK_INT >= 29) {
            hardwareBuffer = this.currentImage.getHardwareBuffer();
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            this.currentBitmap = wrapHardwareBuffer;
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.currentImage.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.currentImage.getHeight();
        Bitmap bitmap = this.currentBitmap;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.currentBitmap.getHeight() != height) {
            this.currentBitmap = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.currentBitmap.copyPixelsFromBuffer(buffer);
    }

    @TargetApi(19)
    public boolean acquireLatestImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.isAttachedToFlutterRenderer) {
            return false;
        }
        Image acquireLatestImage = this.imageReader.acquireLatestImage();
        if (acquireLatestImage != null) {
            closeCurrentImage();
            this.currentImage = acquireLatestImage;
            invalidate();
        }
        if (acquireLatestImage == null) {
            return false;
        }
        return true;
    }

    protected abstract void attachSurface();

    @Override // com.tencent.tdf.view.RenderSurface
    public void attachSurfaceToRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (this.isAttachedToFlutterRenderer) {
                return;
            }
            attachSurface();
            setAlpha(1.0f);
            this.isAttachedToFlutterRenderer = true;
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void deleteView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        }
    }

    public void detachFromRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.isAttachedToFlutterRenderer) {
            return;
        }
        setAlpha(0.0f);
        acquireLatestImage();
        this.currentBitmap = null;
        closeCurrentImage();
        invalidate();
        this.isAttachedToFlutterRenderer = false;
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public Rect getLayoutRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Rect) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mNativeProxy.getLayoutRect();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Surface getSurface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Surface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.imageReader.getSurface();
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void insertView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, i3);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void onDispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.currentImage.close();
            this.currentBitmap.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.currentImage != null) {
            updateCurrentBitmap();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if ((i3 != this.imageReader.getWidth() || i16 != this.imageReader.getHeight()) && this.kind == SurfaceKind.background && this.isAttachedToFlutterRenderer) {
            resizeIfNeeded(i3, i16);
            this.tdfEngine.onSurfaceCreated(getSurface());
        }
    }

    public void resizeIfNeeded(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (i3 == this.imageReader.getWidth() && i16 == this.imageReader.getHeight()) {
                return;
            }
            closeCurrentImage();
            this.imageReader.close();
            this.imageReader = createImageReader(i3, i16);
        }
    }

    @Override // com.tencent.tdf.view.RenderSurface
    public void setRenderInImageView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
    }

    @Override // com.tencent.tdf.view.INativeViewDelegate
    public void updateLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            resizeIfNeeded(i17, i18);
            this.mNativeProxy.updateLayoutParams(i3, i16, i17, i18);
        }
    }
}
