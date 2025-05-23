package com.tencent.libra.drawable;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.libra.request.SingleRequest;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraBitmapDrawable extends BitmapDrawable {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraBitmapDrawable");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ChangeBitmapTask implements Runnable {
        private final WeakReference<LibraBitmapDrawable> mDrawableWRF;
        private Bitmap mSoftBitmap;

        public ChangeBitmapTask(LibraBitmapDrawable libraBitmapDrawable, Bitmap bitmap) {
            this.mDrawableWRF = new WeakReference<>(libraBitmapDrawable);
            this.mSoftBitmap = bitmap;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            try {
                LibraBitmapDrawable libraBitmapDrawable = this.mDrawableWRF.get();
                if (libraBitmapDrawable != null && libraBitmapDrawable.getCallback() != null) {
                    libraBitmapDrawable.setBitmap(this.mSoftBitmap);
                    RFWLog.i(LibraBitmapDrawable.TAG, RFWLog.USR, "resetBitmap success");
                    return;
                }
                if (!this.mSoftBitmap.isRecycled()) {
                    this.mSoftBitmap.recycle();
                }
                this.mSoftBitmap = null;
            } catch (Throwable th5) {
                RFWLog.fatal(LibraBitmapDrawable.TAG, RFWLog.USR, th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class ConvertHardWareBitmapTask implements Runnable {
        private final WeakReference<LibraBitmapDrawable> mDrawableWRF;

        public ConvertHardWareBitmapTask(LibraBitmapDrawable libraBitmapDrawable) {
            this.mDrawableWRF = new WeakReference<>(libraBitmapDrawable);
        }

        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            Bitmap bitmap;
            Bitmap.Config config;
            Bitmap.Config config2;
            LibraBitmapDrawable libraBitmapDrawable = this.mDrawableWRF.get();
            if (libraBitmapDrawable != null && libraBitmapDrawable.getCallback() != null && (bitmap = libraBitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                Bitmap.Config config3 = bitmap.getConfig();
                config = Bitmap.Config.HARDWARE;
                if (config3 == config) {
                    RFWLog.e(LibraBitmapDrawable.TAG, RFWLog.USR, new RuntimeException("find hardware bitmap,but view or canvas is not support"));
                    Bitmap convertHardWareBitmapAfterAndroidP = RFWImageUtil.convertHardWareBitmapAfterAndroidP(bitmap);
                    Bitmap.Config config4 = convertHardWareBitmapAfterAndroidP.getConfig();
                    config2 = Bitmap.Config.HARDWARE;
                    if (config4 != config2) {
                        libraBitmapDrawable.drawSoftBitmap(convertHardWareBitmapAfterAndroidP);
                    } else {
                        RFWLog.e(LibraBitmapDrawable.TAG, RFWLog.USR, "convert hardwareBitmap failed");
                    }
                }
            }
        }
    }

    public LibraBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawSoftBitmap(Bitmap bitmap) {
        if (getCallback() != null) {
            RFWThreadManager.getInstance().runOnUiThread(new ChangeBitmapTask(this, bitmap));
        }
    }

    private boolean isViewSetSoftWareLayerType() {
        if (!(getCallback() instanceof View) || ((View) getCallback()).getLayerType() != 1) {
            return false;
        }
        return true;
    }

    private void printErrorInfo() {
        int i3;
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            Object tag = view.getTag(R.id.yhw);
            if (tag instanceof SingleRequest) {
                i3 = ((SingleRequest) tag).getOption().getSeq();
            } else {
                i3 = -1;
            }
            LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, i3, "[printErrorInfo] context=", view.getContext(), ",view=", view);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap.Config config;
        try {
            Bitmap bitmap = getBitmap();
            if (bitmap.isRecycled()) {
                RFWLog.w(TAG, RFWLog.USR, "[draw] bitmap is recycled");
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (!canvas.isHardwareAccelerated() || isViewSetSoftWareLayerType())) {
                Bitmap.Config config2 = bitmap.getConfig();
                config = Bitmap.Config.HARDWARE;
                if (config2 == config) {
                    RFWThreadManager.getInstance().execOnAsyncDisplayThread(new ConvertHardWareBitmapTask(this));
                    return;
                }
            }
            super.draw(canvas);
        } catch (Exception e16) {
            RFWLog.fatal(TAG, RFWLog.USR, e16);
            printErrorInfo();
        }
    }
}
