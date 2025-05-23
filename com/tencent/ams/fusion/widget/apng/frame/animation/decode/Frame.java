package com.tencent.ams.fusion.widget.apng.frame.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class Frame<R extends Reader, W extends Writer> {
    static IPatchRedirector $redirector_;
    public int frameDuration;
    public int frameHeight;
    public int frameWidth;
    public int frameX;
    public int frameY;
    protected final R reader;

    public Frame(R r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r16);
        } else {
            this.reader = r16;
        }
    }

    public abstract Bitmap draw(Canvas canvas, Paint paint, int i3, Bitmap bitmap, W w3);
}
