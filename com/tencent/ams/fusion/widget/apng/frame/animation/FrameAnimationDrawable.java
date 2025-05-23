package com.tencent.ams.fusion.widget.apng.frame.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class FrameAnimationDrawable<Decoder extends FrameSeqDecoder> extends Drawable implements Animatable2, FrameSeqDecoder.RenderListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_ANIMATION_END = 2;
    private static final int MSG_ANIMATION_START = 1;
    private static final String TAG = "FrameAnimationDrawable";
    private Set<Animatable2.AnimationCallback> animationCallbacks;
    private boolean autoPlay;
    private Bitmap bitmap;
    protected boolean canTranslate;
    private DrawFilter drawFilter;
    private final Decoder frameSeqDecoder;
    private Runnable invalidateRunnable;
    private Matrix matrix;
    private final Set<WeakReference<ImageView>> obtainedImageViews;
    private WeakReference<Handler> outHandler;
    private final Paint paint;
    private int rotate;
    private Handler uiHandler;

    public FrameAnimationDrawable(Decoder decoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) decoder);
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.matrix = new Matrix();
        this.animationCallbacks = new HashSet();
        this.canTranslate = false;
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimationDrawable.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        Iterator it = FrameAnimationDrawable.this.animationCallbacks.iterator();
                        while (it.hasNext()) {
                            ((Animatable2.AnimationCallback) it.next()).onAnimationEnd(FrameAnimationDrawable.this);
                        }
                        return;
                    }
                    return;
                }
                Iterator it5 = FrameAnimationDrawable.this.animationCallbacks.iterator();
                while (it5.hasNext()) {
                    ((Animatable2.AnimationCallback) it5.next()).onAnimationStart(FrameAnimationDrawable.this);
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimationDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FrameAnimationDrawable.this.invalidateSelf();
                }
            }
        };
        this.autoPlay = true;
        this.obtainedImageViews = new HashSet();
        paint.setAntiAlias(true);
        this.frameSeqDecoder = decoder;
    }

    private void hookRecordCallbacks() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z16 = false;
        for (WeakReference<ImageView> weakReference : this.obtainedImageViews) {
            ImageView imageView = weakReference.get();
            if (imageView == null) {
                arrayList.add(weakReference);
            } else if (imageView == callback) {
                z16 = true;
            } else {
                imageView.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.obtainedImageViews.remove((WeakReference) it.next());
        }
        if (!z16) {
            this.obtainedImageViews.add(new WeakReference<>((ImageView) callback));
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2
    public void clearAnimationCallbacks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.animationCallbacks.clear();
        }
    }

    protected abstract Decoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
            return;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.setDrawFilter(this.drawFilter);
            canvas.drawBitmap(this.bitmap, this.matrix, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Drawable.Callback) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return super.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        try {
            Rect bounds = this.frameSeqDecoder.getBounds();
            if (bounds == null) {
                return 0;
            }
            return bounds.height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        try {
            Rect bounds = this.frameSeqDecoder.getBounds();
            if (bounds == null) {
                return 0;
            }
            return bounds.width();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getMemorySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        int memorySize = this.frameSeqDecoder.getMemorySize();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            memorySize += this.bitmap.getAllocationByteCount();
        }
        return Math.max(1, memorySize);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        super.invalidateSelf();
        Iterator<WeakReference<ImageView>> it = this.obtainedImageViews.iterator();
        while (it.hasNext()) {
            ImageView imageView = it.next().get();
            if (imageView != null && imageView != getCallback()) {
                imageView.invalidateDrawable(this);
            }
        }
    }

    public boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.frameSeqDecoder.isPaused();
    }

    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.frameSeqDecoder.isRunning();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.RenderListener
    public void onEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            Message.obtain(this.uiHandler, 2).sendToTarget();
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.RenderListener
    public void onRender(ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) byteBuffer);
            return;
        }
        if (!isRunning()) {
            return;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / this.frameSeqDecoder.getSampleSize(), this.frameSeqDecoder.getBounds().height() / this.frameSeqDecoder.getSampleSize(), Bitmap.Config.ARGB_8888);
        }
        byteBuffer.rewind();
        if (byteBuffer.remaining() < this.bitmap.getByteCount()) {
            Log.e(TAG, "onRender:Buffer not large enough for pixels");
            return;
        }
        try {
            this.bitmap.copyPixelsFromBuffer(byteBuffer);
            WeakReference<Handler> weakReference = this.outHandler;
            if (weakReference != null && weakReference.get() != null) {
                this.outHandler.get().post(this.invalidateRunnable);
            } else {
                this.uiHandler.post(this.invalidateRunnable);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.RenderListener
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            Message.obtain(this.uiHandler, 1).sendToTarget();
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.frameSeqDecoder.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2
    public void registerAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) animationCallback);
        } else {
            this.animationCallbacks.add(animationCallback);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.eraseColor(0);
        }
        this.frameSeqDecoder.reset();
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.frameSeqDecoder.resume();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.paint.setAlpha(i3);
        }
    }

    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.autoPlay = z16;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.setBounds(i3, i16, i17, i18);
        if (getBounds() != null && this.frameSeqDecoder.getBounds() != null && this.frameSeqDecoder.getBounds().width() != 0 && this.frameSeqDecoder.getBounds().height() != 0) {
            boolean desiredSize = this.frameSeqDecoder.setDesiredSize(getBounds().width(), getBounds().height());
            float width = ((getBounds().width() * 1.0f) * this.frameSeqDecoder.getSampleSize()) / this.frameSeqDecoder.getBounds().width();
            float height = ((getBounds().height() * 1.0f) * this.frameSeqDecoder.getSampleSize()) / this.frameSeqDecoder.getBounds().height();
            if (this.canTranslate) {
                this.matrix.reset();
                if (width != 0.0f && height != 0.0f) {
                    this.matrix.postTranslate(i3 / width, i16 / height);
                }
                this.matrix.postScale(width, height);
            } else {
                this.matrix.setScale(width, height);
            }
            if (desiredSize) {
                this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / this.frameSeqDecoder.getSampleSize(), this.frameSeqDecoder.getBounds().height() / this.frameSeqDecoder.getSampleSize(), Bitmap.Config.ARGB_8888);
            }
        }
    }

    public void setCanTranslate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.canTranslate = z16;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) colorFilter);
        } else {
            this.paint.setColorFilter(colorFilter);
        }
    }

    public void setLoopLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.frameSeqDecoder.setLoopLimit(i3);
        }
    }

    public void setOutHandler(WeakReference<Handler> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weakReference);
        } else {
            this.outHandler = weakReference;
        }
    }

    public void setRotate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.rotate = i3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        hookRecordCallbacks();
        if (this.autoPlay) {
            if (z16) {
                if (!isRunning()) {
                    start();
                }
            } else if (isRunning()) {
                stop();
            }
        }
        return super.setVisible(z16, z17);
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.frameSeqDecoder.initThreadIfNecessary();
        this.frameSeqDecoder.addRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.start();
        } else if (!this.frameSeqDecoder.isRunning()) {
            this.frameSeqDecoder.start();
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.frameSeqDecoder.removeRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.stop();
        } else {
            this.frameSeqDecoder.stopIfNeeded();
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.Animatable2
    public boolean unregisterAnimationCallback(Animatable2.AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) animationCallback)).booleanValue();
        }
        return this.animationCallbacks.remove(animationCallback);
    }

    public FrameAnimationDrawable(Loader loader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loader);
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.matrix = new Matrix();
        this.animationCallbacks = new HashSet();
        this.canTranslate = false;
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimationDrawable.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        Iterator it = FrameAnimationDrawable.this.animationCallbacks.iterator();
                        while (it.hasNext()) {
                            ((Animatable2.AnimationCallback) it.next()).onAnimationEnd(FrameAnimationDrawable.this);
                        }
                        return;
                    }
                    return;
                }
                Iterator it5 = FrameAnimationDrawable.this.animationCallbacks.iterator();
                while (it5.hasNext()) {
                    ((Animatable2.AnimationCallback) it5.next()).onAnimationStart(FrameAnimationDrawable.this);
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.FrameAnimationDrawable.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimationDrawable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FrameAnimationDrawable.this.invalidateSelf();
                }
            }
        };
        this.autoPlay = true;
        this.obtainedImageViews = new HashSet();
        paint.setAntiAlias(true);
        this.frameSeqDecoder = createFrameSeqDecoder(loader, this);
    }
}
