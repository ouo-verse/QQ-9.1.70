package com.tencent.mobileqq.emoticonview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VoiceGifImage extends NativeGifImage {
    static IPatchRedirector $redirector_;
    boolean IS_ENABLE_DEBUG_LOG;
    private boolean restart;
    private boolean restarting;
    private boolean running;

    public VoiceGifImage(File file, int i3, boolean z16) throws IOException {
        super(file, z16, true, 0, 0, 0.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.IS_ENABLE_DEBUG_LOG = false;
        this.running = true;
        this.restart = false;
        this.restarting = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
    public void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
            QLog.d("VoiceGifImage", 2, "doApplyNextFrame");
        }
        super.doApplyNextFrame();
        if (this.restarting) {
            this.restarting = false;
            this.restart = false;
        }
    }

    @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, rect, paint, Boolean.valueOf(z16));
            return;
        }
        initHandlerAndRunnable();
        if (!this.running && (bitmap = this.mFirstFrameBitmap) != null) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
                if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running ");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running, mFirstFrameBitmap is null");
                return;
            }
            return;
        }
        if (this.restart) {
            Bitmap bitmap2 = this.mFirstFrameBitmap;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, rect, paint);
            } else if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart, mFirstFrameBitmap is null");
            }
            if (!AbstractGifImage.sPaused) {
                executeNewTask();
                if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart  !sPaused");
                    return;
                }
                return;
            }
            if (!this.mIsInPendingAction) {
                AbstractGifImage.sPendingActions.add(new WeakReference<>(this));
                this.mIsInPendingAction = true;
                if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !mIsInPendingAction  !mIsInPendingAction");
                    return;
                }
                return;
            }
            return;
        }
        super.draw(canvas, rect, paint, z16);
        if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
            QLog.d("VoiceGifImage", 2, "VoiceGifImage draw else");
        }
    }

    @Override // com.tencent.image.NativeGifImage
    public synchronized void getNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.restart) {
            this.restarting = true;
            super.reset();
            if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
                QLog.d("VoiceGifImage", 2, "getNextFrame restart");
            }
        }
        super.getNextFrame();
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.running = true;
        if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
            QLog.d("VoiceGifImage", 2, "getNextFrame start");
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.running = false;
        this.restart = true;
        if (QLog.isColorLevel() && this.IS_ENABLE_DEBUG_LOG) {
            QLog.d("VoiceGifImage", 2, "getNextFrame stop");
        }
    }
}
