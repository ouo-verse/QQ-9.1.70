package com.tencent.mobileqq.qqcamera.api.impl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mobileqq.camera.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcamera.api.ICameraUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CameraUtilsImpl implements ICameraUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CameraUtilsImpl";

    public CameraUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public Bitmap clipJpegToBitmap(byte[] bArr, Rect rect, boolean z16, int i3) throws IOException, OutOfMemoryError {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, bArr, rect, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        return a.b(bArr, rect, z16, i3);
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public int getJpegRotation(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.f(com.tencent.mobileqq.camera.a.d(), i3, i16);
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public Class getNearbyPeoplePhotoUploadProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return NearbyPeoplePhotoUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public byte[] getStructMsgBytes(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
        }
        AbsStructMsg e16 = i.e(bundle);
        if (e16 != null) {
            return e16.getBytes();
        }
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public Bitmap rotateBitmap(Bitmap bitmap, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return a.p(bitmap, i3, z16);
    }

    @Override // com.tencent.mobileqq.qqcamera.api.ICameraUtils
    public boolean tryRecycle(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap)).booleanValue();
        }
        return a.s(bitmap);
    }
}
