package com.tencent.weclip;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WeClip {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f384458a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f384459b;

    public WeClip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f384458a = nativeCreate();
        }
    }

    private native float calculateImageCost(long j3);

    private native void clear(long j3);

    private static native float[] cosineSimilarity(float[] fArr, float[] fArr2, int i3, boolean z16);

    private native String decryptModelErrorDesc(long j3);

    private native long decryptedCost(long j3);

    private native String forwardErrorDesc(long j3);

    private native void initConfig(long j3, int i3, boolean z16, int i16, int i17, byte[] bArr, byte[] bArr2);

    private native long loadModelCost(long j3);

    private native String loadModelErrorDesc(long j3);

    private native float[] modelForwardWithBitmap(long j3, Bitmap bitmap);

    private native long nativeCreate();

    private native void nativeDestroy(long j3);

    private native boolean nativeLoadModel(long j3, String str, String str2, int i3);

    private native float preprocessImageCost(long j3);

    private native void setThreadAffinityMask(long j3, int i3);

    private native long totalLoadModelCost(long j3);

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.f384459b = false;
        clear(this.f384458a);
        i();
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return decryptedCost(this.f384458a);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return decryptModelErrorDesc(this.f384458a);
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return forwardErrorDesc(this.f384458a);
    }

    public void e(int i3, boolean z16, int i16, int i17, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), str, str2);
            return;
        }
        byte[] decode = Base64.decode(str, 0);
        if (decode.length == 0) {
            QLog.d("WinkNewAlbum_WeClip", 1, "iv is empty!");
            return;
        }
        byte[] decode2 = Base64.decode(str2, 0);
        if (decode2.length == 0) {
            QLog.d("WinkNewAlbum_WeClip", 1, "key is empty!");
        } else {
            initConfig(this.f384458a, i3, z16, i16, i17, decode, decode2);
        }
    }

    public boolean f(String str, String str2, LoadModelTYPE loadModelTYPE) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, loadModelTYPE)).booleanValue();
        }
        long j3 = this.f384458a;
        if (j3 == 0) {
            return false;
        }
        boolean nativeLoadModel = nativeLoadModel(j3, str, str2, loadModelTYPE.toInt());
        this.f384459b = nativeLoadModel;
        return nativeLoadModel;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return loadModelErrorDesc(this.f384458a);
    }

    public float[] h(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (float[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        }
        long j3 = this.f384458a;
        if (j3 == 0) {
            return null;
        }
        return modelForwardWithBitmap(j3, bitmap);
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long j3 = this.f384458a;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.f384458a = 0L;
        }
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return totalLoadModelCost(this.f384458a);
    }
}
