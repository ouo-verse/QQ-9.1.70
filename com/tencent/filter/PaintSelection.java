package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes6.dex */
public class PaintSelection {
    static IPatchRedirector $redirector_;
    private boolean available;
    private int bpp;
    private int height;
    private final long nativeObj;
    private QImage srcimage;
    private int width;

    public PaintSelection(QImage qImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qImage);
            return;
        }
        this.available = false;
        this.width = qImage.getWidth();
        this.height = qImage.getHeight();
        this.bpp = qImage.getPixelFormat();
        this.srcimage = qImage;
        this.nativeObj = nativePaintSection(qImage);
        this.available = true;
    }

    public static native void FormatAlphaBitmap(Bitmap bitmap);

    public static native boolean HasAlphaBitmap(Bitmap bitmap);

    public static native void ProcessBitmap(Bitmap bitmap, Bitmap bitmap2);

    private void checkavailable() {
        if (this.available) {
        } else {
            throw new RuntimeException("use bad addr");
        }
    }

    private native void nativeAddRound(long j3, int i3, int i16, double d16);

    private native void nativeDispose(long j3);

    private native byte[] nativeGetResult(long j3, int i3);

    private native int[] nativeGetSelectRect(long j3);

    private native int nativeGetcurrentUndoMark(long j3);

    private native void nativeInpaint(long j3);

    private native long nativePaintSection(QImage qImage);

    private native void nativeRedo(long j3);

    private native void nativeReverseSelected(long j3);

    private native void nativeRmRound(long j3, int i3, int i16, int i17, int i18, double d16);

    private native void nativeSetSelectionMode(long j3, int i3);

    private native void nativeTouchBegin(long j3, int i3, int i16);

    private native void nativeTouchMove(long j3, int i3, int i16, double d16, double d17);

    private native void nativeUndo(long j3);

    private native void nativeUpdateUndoMark(long j3);

    public static native void reverseBitmapAlpha(Bitmap bitmap);

    private native void touchBegin1(int i3, int i16);

    public void addRound(int i3, int i16, int i17, int i18, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16));
        } else {
            checkavailable();
            nativeAddRound(this.nativeObj, i17, i18, d16);
        }
    }

    public void dispose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (this.available) {
            nativeDispose(this.nativeObj);
            this.srcimage.Dispose();
            this.srcimage = null;
            this.available = false;
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            dispose();
            super.finalize();
        }
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.height;
    }

    public byte[] getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        checkavailable();
        return nativeGetResult(this.nativeObj, this.width * this.height * this.bpp);
    }

    public Rect getSelectRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Rect) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        checkavailable();
        int[] nativeGetSelectRect = nativeGetSelectRect(this.nativeObj);
        return new Rect(nativeGetSelectRect[0], nativeGetSelectRect[1], nativeGetSelectRect[2], nativeGetSelectRect[3]);
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.width;
    }

    public int getcurrentUndoMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        checkavailable();
        return nativeGetcurrentUndoMark(this.nativeObj);
    }

    public QImage getimage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QImage) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        checkavailable();
        return this.srcimage;
    }

    public void inpaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            checkavailable();
            nativeInpaint(this.nativeObj);
        }
    }

    public void redo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            checkavailable();
            nativeRedo(this.nativeObj);
        }
    }

    public void reverseSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            checkavailable();
            nativeReverseSelected(this.nativeObj);
        }
    }

    public void rmRound(int i3, int i16, int i17, int i18, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Double.valueOf(d16));
        } else {
            checkavailable();
            nativeRmRound(this.nativeObj, i3, i16, i17, i18, d16);
        }
    }

    public void setSelectionMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            checkavailable();
            nativeSetSelectionMode(this.nativeObj, i3);
        }
    }

    public void touchBegin(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            checkavailable();
            nativeTouchBegin(this.nativeObj, i3, i16);
        }
    }

    public void touchMove(int i3, int i16, double d16, double d17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16), Double.valueOf(d17));
        } else {
            checkavailable();
            nativeTouchMove(this.nativeObj, i3, i16, d16, d17);
        }
    }

    public void undo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            checkavailable();
            nativeUndo(this.nativeObj);
        }
    }

    public void updateUndoMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            checkavailable();
            nativeUpdateUndoMark(this.nativeObj);
        }
    }
}
