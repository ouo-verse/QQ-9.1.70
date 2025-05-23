package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
class TroopNativeUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f301976a;

    TroopNativeUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f301976a = false;
            a();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            System.loadLibrary("qq_troop");
            this.f301976a = true;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopNativeUtils", 2, "load library error", th5);
            }
            this.f301976a = false;
        }
    }

    protected native void blurBitmap(Bitmap bitmap, int i3, int i16);

    protected native void doBlur(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19);

    public native void yuv420spToArgb(byte[] bArr, int[] iArr, int i3, int i16, int i17);
}
