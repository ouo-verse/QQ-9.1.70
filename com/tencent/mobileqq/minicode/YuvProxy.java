package com.tencent.mobileqq.minicode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;

/* loaded from: classes15.dex */
public class YuvProxy {
    static IPatchRedirector $redirector_;

    /* loaded from: classes15.dex */
    public static class NV21ToBitmap {
        static IPatchRedirector $redirector_;

        /* renamed from: in, reason: collision with root package name */
        private Allocation f246828in;
        private Allocation out;
        private Type.Builder rgbaType;

        /* renamed from: rs, reason: collision with root package name */
        private RenderScript f246829rs;
        private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
        private Type.Builder yuvType;

        @RequiresApi(api = 17)
        public NV21ToBitmap(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            RenderScript create = RenderScript.create(context);
            this.f246829rs = create;
            this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
        }

        public void destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                RenderScript.releaseAllContexts();
            }
        }

        @RequiresApi(api = 17)
        public Bitmap nv21ToBitmap(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (this.yuvType == null) {
                RenderScript renderScript = this.f246829rs;
                Type.Builder x16 = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                this.yuvType = x16;
                this.f246828in = Allocation.createTyped(this.f246829rs, x16.create(), 1);
                RenderScript renderScript2 = this.f246829rs;
                Type.Builder y16 = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i3).setY(i16);
                this.rgbaType = y16;
                this.out = Allocation.createTyped(this.f246829rs, y16.create(), 1);
            }
            this.f246828in.copyFrom(bArr);
            this.yuvToRgbIntrinsic.setInput(this.f246828in);
            this.yuvToRgbIntrinsic.forEach(this.out);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            this.out.copyTo(createBitmap);
            return createBitmap;
        }
    }

    public YuvProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native int ArgbScale(int[] iArr, int i3, int i16, int i17, int[] iArr2, int i18, int i19, int i26, int i27);

    public static native int ArgbScaleClip(int[] iArr, int i3, int i16, int i17, int[] iArr2, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37);

    public static native void Yuv2Rgba(int[] iArr, byte[] bArr, int i3, int i16);

    public static Bitmap getBitmapJava(byte[] bArr, int i3, int i16) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i3, i16, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}
