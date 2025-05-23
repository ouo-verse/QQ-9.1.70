package com.tencent.mobileqq.emoticonview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifIndex8;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class VoiceGifImageV2 extends NativeGifIndex8 {
    static IPatchRedirector $redirector_;
    private boolean mRestart;
    private boolean mRestarting;
    private boolean mRunning;

    public VoiceGifImageV2(File file, int i3, boolean z16) throws IOException {
        super(file, z16, true, 0, 0, 0.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.mRunning = true;
        this.mRestart = false;
        this.mRestarting = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.NativeGifIndex8, com.tencent.image.AbstractGifImage
    public void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doApplyNextFrame();
        if (this.mRestarting) {
            this.mRestarting = false;
            this.mRestart = false;
        }
    }

    @Override // com.tencent.image.NativeGifIndex8, com.tencent.image.AbstractGifImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, rect, paint, Boolean.valueOf(z16));
            return;
        }
        initHandlerAndRunnable();
        if (!this.mRunning && (bitmap = this.mFirstFrameBitmap) != null) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
            }
        } else {
            if (this.mRestart) {
                Bitmap bitmap2 = this.mFirstFrameBitmap;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, (Rect) null, rect, paint);
                }
                if (!AbstractGifImage.sPaused) {
                    executeNewTask();
                    return;
                } else {
                    if (!this.mIsInPendingAction) {
                        AbstractGifImage.sPendingActions.add(new WeakReference<>(this));
                        this.mIsInPendingAction = true;
                        return;
                    }
                    return;
                }
            }
            super.draw(canvas, rect, paint, z16);
        }
    }

    @Override // com.tencent.image.NativeGifIndex8
    public synchronized void getNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mRestart) {
            this.mRestarting = true;
            super.reset();
        }
        super.getNextFrame();
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mRunning = true;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mRunning = false;
            this.mRestart = true;
        }
    }
}
