package com.tencent.libra.extension.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.libra.extension.gif.e;
import com.tencent.libra.extension.gif.f;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifTextureView extends TextureView {
    private static final ImageView.ScaleType[] C = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d, reason: collision with root package name */
    private ImageView.ScaleType f118734d;

    /* renamed from: e, reason: collision with root package name */
    private final Matrix f118735e;

    /* renamed from: f, reason: collision with root package name */
    private f f118736f;

    /* renamed from: h, reason: collision with root package name */
    private RenderThread f118737h;

    /* renamed from: i, reason: collision with root package name */
    private float f118738i;

    /* renamed from: m, reason: collision with root package name */
    private e.b f118739m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f118741a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f118741a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f118741a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f118741a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f118741a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f118741a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f118741a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f118741a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f118741a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
    }

    public GifTextureView(Context context) {
        super(context);
        this.f118734d = ImageView.ScaleType.FIT_CENTER;
        this.f118735e = new Matrix();
        this.f118738i = 1.0f;
        g(null, 0, 0);
    }

    private static f f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(l.f118781w, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (e.f118748a.contains(resourceTypeName)) {
                return new f.d(typedArray.getResources(), typedValue.resourceId);
            }
            if (!HippyControllerProps.STRING.equals(resourceTypeName)) {
                throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new f.b(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    private void g(AttributeSet attributeSet, int i3, int i16) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = C;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f118734d = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, l.f118780v, i3, i16);
            this.f118736f = f(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(l.f118782x, false));
            obtainStyledAttributes.recycle();
            this.f118739m = new e.b(this, attributeSet, i3, i16);
        } else {
            super.setOpaque(false);
            this.f118739m = new e.b();
        }
        if (!isInEditMode()) {
            RenderThread renderThread = new RenderThread(this);
            this.f118737h = renderThread;
            if (this.f118736f != null) {
                renderThread.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float q16 = gifInfoHandle.q() / width;
        float h16 = gifInfoHandle.h() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.q(), gifInfoHandle.h());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f16 = 1.0f;
        switch (a.f118741a[this.f118734d.ordinal()]) {
            case 1:
                matrix.setScale(q16, h16, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(q16, h16);
                matrix.setScale(q16 * min, min * h16, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.q() > width || gifInfoHandle.h() > height) {
                    f16 = Math.min(1.0f / q16, 1.0f / h16);
                }
                matrix.setScale(q16 * f16, f16 * h16, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(q16, h16);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(q16, h16);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(q16, h16);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f118735e);
                matrix.preScale(q16, h16);
                break;
        }
        super.setTransform(matrix);
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.f118735e);
        return matrix;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f118737h.d(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f118737h.F = gifViewSavedState.f118742d[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        long[] jArr;
        RenderThread renderThread = this.f118737h;
        renderThread.F = renderThread.D.p();
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (this.f118739m.f118751a) {
            jArr = this.f118737h.F;
        } else {
            jArr = null;
        }
        return new GifViewSavedState(onSaveInstanceState, jArr);
    }

    public void setFreezesAnimation(boolean z16) {
        this.f118739m.f118751a = z16;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable f fVar) {
        setInputSource(fVar, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z16) {
        if (z16 != isOpaque()) {
            super.setOpaque(z16);
            setInputSource(this.f118736f);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f118734d = scaleType;
        i(this.f118737h.D);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f16) {
        this.f118738i = f16;
        this.f118737h.D.G(f16);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.f118735e.set(matrix);
        i(this.f118737h.D);
    }

    public synchronized void setInputSource(@Nullable f fVar, @Nullable b bVar) {
        this.f118737h.d(this, bVar);
        try {
            this.f118737h.join();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        this.f118736f = fVar;
        RenderThread renderThread = new RenderThread(this);
        this.f118737h = renderThread;
        if (fVar != null) {
            renderThread.start();
        }
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f118734d = ImageView.ScaleType.FIT_CENTER;
        this.f118735e = new Matrix();
        this.f118738i = 1.0f;
        g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f118734d = ImageView.ScaleType.FIT_CENTER;
        this.f118735e = new Matrix();
        this.f118738i = 1.0f;
        g(attributeSet, i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class RenderThread extends BaseThread implements TextureView.SurfaceTextureListener {
        final com.tencent.libra.extension.gif.a C;
        private GifInfoHandle D;
        private IOException E;
        long[] F;
        private final WeakReference<GifTextureView> G;

        RenderThread(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.C = new com.tencent.libra.extension.gif.a();
            this.D = new GifInfoHandle();
            this.G = new WeakReference<>(gifTextureView);
        }

        void d(@NonNull GifTextureView gifTextureView, @Nullable b bVar) {
            k kVar;
            this.C.b();
            if (bVar != null) {
                kVar = new k(bVar);
            } else {
                kVar = null;
            }
            gifTextureView.h(kVar);
            this.D.v();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            GifTextureView gifTextureView = this.G.get();
            if (gifTextureView != null) {
                gifTextureView.i(this.D);
            }
            this.C.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.C.b();
            this.D.v();
            interrupt();
            return true;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.G.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle a16 = gifTextureView.f118736f.a();
                this.D = a16;
                a16.F((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f118739m.f118752b >= 0) {
                    this.D.E(gifTextureView.f118739m.f118752b);
                }
                final GifTextureView gifTextureView2 = this.G.get();
                if (gifTextureView2 != null) {
                    gifTextureView2.h(this);
                    boolean isAvailable = gifTextureView2.isAvailable();
                    this.C.d(isAvailable);
                    if (isAvailable) {
                        gifTextureView2.post(new Runnable() { // from class: com.tencent.libra.extension.gif.GifTextureView.RenderThread.1
                            @Override // java.lang.Runnable
                            public void run() {
                                gifTextureView2.i(RenderThread.this.D);
                            }
                        });
                    }
                    this.D.G(gifTextureView2.f118738i);
                    while (!isInterrupted()) {
                        try {
                            this.C.a();
                            GifTextureView gifTextureView3 = this.G.get();
                            if (gifTextureView3 == null) {
                                break;
                            }
                            SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                Surface surface = new Surface(surfaceTexture);
                                try {
                                    this.D.a(surface, this.F);
                                } finally {
                                    surface.release();
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.D.w();
                    this.D = new GifInfoHandle();
                    return;
                }
                this.D.w();
            } catch (IOException e16) {
                this.E = e16;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }
}
