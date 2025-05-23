package com.tencent.av.ui.funchat.magicface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MagicfaceViewForAV extends SurfaceView implements SurfaceHolder.Callback, MagicfaceBaseDecoder.b {

    /* renamed from: d, reason: collision with root package name */
    private SurfaceHolder f75809d;

    /* renamed from: e, reason: collision with root package name */
    private float f75810e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f75811f;

    /* renamed from: h, reason: collision with root package name */
    private int f75812h;

    public MagicfaceViewForAV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f75811f = false;
        b();
    }

    private void b() {
        SurfaceHolder holder = getHolder();
        this.f75809d = holder;
        holder.addCallback(this);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f75810e = displayMetrics.density;
        this.f75812h = displayMetrics.widthPixels;
        AVCoreLog.printColorLog("MagicfaceViewForAV", "init() density: " + this.f75812h + "|" + this.f75810e);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Bitmap bitmap, Bitmap bitmap2, boolean z16, boolean z17, boolean z18, boolean z19, Rect rect) {
        Throwable th5;
        Canvas lockCanvas;
        float f16;
        Rect rect2;
        Canvas canvas = null;
        try {
            try {
                int width = getWidth();
                int height = getHeight();
                lockCanvas = this.f75809d.lockCanvas(null);
                if (lockCanvas != null) {
                    try {
                        Paint paint = new Paint();
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        lockCanvas.drawPaint(paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                        paint.setFilterBitmap(true);
                        paint.setAntiAlias(true);
                        Rect rect3 = new Rect();
                        if (z16 && z17) {
                            rect3.top = 0;
                            rect3.left = 0;
                            rect3.right = width;
                            rect3.bottom = height;
                        } else if (z16) {
                            rect3.left = 0;
                            rect3.right = width;
                            int width2 = (rect3.width() * bitmap.getHeight()) / bitmap.getWidth();
                            int i3 = (int) (rect.top * this.f75810e);
                            rect3.top = i3;
                            rect3.bottom = i3 + width2;
                        } else if (z17) {
                            rect3.top = 0;
                            rect3.bottom = height;
                            int height2 = (rect3.height() * bitmap.getWidth()) / bitmap.getHeight();
                            int i16 = (int) (rect.left * this.f75810e);
                            rect3.left = i16;
                            rect3.right = i16 + height2;
                        } else if (!z18 && !z19 && !z18 && !z19) {
                            rect3.set(rect);
                            int width3 = lockCanvas.getWidth();
                            int i17 = this.f75812h;
                            if (width3 != i17) {
                                f16 = width3 / i17;
                            } else {
                                f16 = 1.0f;
                            }
                            float f17 = f16 * (this.f75810e / 2.0f);
                            if (e.k()) {
                                QLog.w("MagicfaceViewForAV", 1, "frameData, ration[" + f17 + "], mDensity[" + this.f75810e + "], dstRect[" + rect3.toString() + "]");
                            }
                            rect3.left = (int) (rect3.left * f17);
                            rect3.top = (int) (rect3.top * f17);
                            rect3.right = (int) (rect3.right * f17);
                            rect3.bottom = (int) (rect3.bottom * f17);
                        }
                        if (e.k()) {
                            QLog.w("MagicfaceViewForAV", 1, "frameData, viewSize[" + width + ", " + height + "], matchWidth[" + z16 + "], matchHeight[" + z17 + "], rect[" + rect.toString() + "], dstRect[" + rect3.toString() + "]");
                        }
                        if (bitmap2 != null) {
                            rect2 = null;
                            lockCanvas.drawBitmap(bitmap2, (Rect) null, rect3, paint);
                        } else {
                            rect2 = null;
                        }
                        lockCanvas.drawBitmap(bitmap, rect2, rect3, paint);
                    } catch (Exception e16) {
                        e = e16;
                        canvas = lockCanvas;
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("MagicfaceViewForAV", 2, "frameData Exception", e);
                            }
                            if (canvas != null && this.f75811f) {
                                this.f75809d.unlockCanvasAndPost(canvas);
                            }
                            return;
                        } catch (Throwable th6) {
                            th = th6;
                            th5 = th;
                            if (canvas != null) {
                                if (this.f75811f) {
                                    try {
                                        this.f75809d.unlockCanvasAndPost(canvas);
                                        throw th5;
                                    } catch (Exception e17) {
                                        AVCoreLog.printErrorLog("MagicfaceViewForAV", e17.getMessage());
                                        throw th5;
                                    }
                                }
                                throw th5;
                            }
                            throw th5;
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        canvas = lockCanvas;
                        if (canvas != null) {
                        }
                    }
                }
            } catch (Exception e18) {
                e = e18;
            } catch (Throwable th8) {
                th = th8;
                th5 = th;
                if (canvas != null) {
                }
            }
            if (lockCanvas != null && this.f75811f) {
                this.f75809d.unlockCanvasAndPost(lockCanvas);
            }
        } catch (Exception e19) {
            AVCoreLog.printErrorLog("MagicfaceViewForAV", e19.getMessage());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f75811f = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f75811f = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
    }
}
