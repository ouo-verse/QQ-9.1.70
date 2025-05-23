package com.tencent.qqcamerakit.capture.cameraextend;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqcamerakit.capture.CameraHandler;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.camera.CameraControl;
import com.tencent.qqcamerakit.capture.d;
import com.tencent.qqcamerakit.common.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends AsyncTask<Void, Void, String> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private CameraHandler.c f344886a;

    public c(CameraHandler.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.f344886a = cVar;
        }
    }

    public Bitmap a(byte[] bArr, d dVar, boolean z16, int i3) throws IOException, OutOfMemoryError {
        boolean z17;
        double d16;
        double d17;
        double d18;
        double d19;
        double d26;
        boolean z18;
        double d27;
        double d28;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, this, bArr, dVar, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i16 = options.outHeight;
        int i17 = options.outWidth;
        if (i17 > i16) {
            z17 = true;
        } else {
            z17 = false;
        }
        double max = (Math.max(i16, i17) * 1.0d) / Math.min(i16, i17);
        double d29 = (dVar.f344912b * 1.0d) / dVar.f344911a;
        double d36 = i17;
        double d37 = i16;
        if (max > d29) {
            if (z17) {
                d18 = d29 * d37;
                d17 = d37;
                d16 = d18;
            } else {
                d19 = d29 * d36;
                d16 = d36;
                d17 = d19;
            }
        } else if (max < d29) {
            if (z17) {
                d19 = (1.0d / d29) * d36;
                d16 = d36;
                d17 = d19;
            } else {
                d18 = (1.0d / d29) * d37;
                d17 = d37;
                d16 = d18;
            }
        } else {
            d16 = d36;
            d17 = d37;
        }
        if (e.f()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("clipJpegToBitmap tw=");
            d26 = d16;
            sb5.append(d26);
            sb5.append(" th=");
            d27 = d37;
            d28 = d17;
            sb5.append(d28);
            sb5.append(" bw=");
            sb5.append(i17);
            sb5.append(" bh=");
            sb5.append(i16);
            sb5.append(" br=");
            sb5.append(max);
            sb5.append(" sr=");
            sb5.append(d29);
            String sb6 = sb5.toString();
            z18 = false;
            e.e("TakePictureTask", 2, sb6);
        } else {
            d26 = d16;
            z18 = false;
            d27 = d37;
            d28 = d17;
        }
        options.inJustDecodeBounds = z18;
        Rect rect = new Rect((int) ((d36 - d26) / 2.0d), (int) ((d27 - d28) / 2.0d), (int) ((d36 + d26) / 2.0d), (int) ((d27 + d28) / 2.0d));
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, true);
        Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
        newInstance.recycle();
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, decodeRegion.getWidth() / 2.0f, decodeRegion.getHeight() / 2.0f);
        if (z16) {
            matrix.postScale(-1.0f, 1.0f);
        }
        return Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
        }
        byte[] bArr = this.f344886a.f344787f;
        File file = new File(this.f344886a.f344782a);
        if (bArr != null) {
            try {
                CameraHandler.c cVar = this.f344886a;
                int i3 = cVar.f344786e;
                boolean z16 = true;
                if (i3 != 1) {
                    z16 = false;
                }
                f(a(bArr, this.f344886a.f344783b, z16, d(i3, cVar.f344785d)), this.f344886a.f344788g, file);
            } catch (IOException e16) {
                e16.printStackTrace();
            } catch (OutOfMemoryError e17) {
                e.b("TakePictureTask", 2, "[onPictureTaken] createBitmap failed orientation:" + this.f344886a.f344785d + ", " + e17.getMessage(), e17);
            }
        }
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            return CameraControl.l().h();
        }
        return com.tencent.qqcamerakit.capture.camera2.b.Q().K();
    }

    public int d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i16 == -1) {
            i16 = 0;
        }
        int i17 = ((i16 + 45) / 90) * 90;
        if (i3 == 1) {
            return ((c() - i17) + 360) % 360;
        }
        return (c() + i17) % 360;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        c.b bVar = this.f344886a.f344784c;
        if (bVar != null) {
            bVar.a(str);
            if (str == null && e.f()) {
                e.e("TakePictureTask", 2, "Picture bitmap data error or output file not exist");
            }
        }
    }

    public boolean f(Bitmap bitmap, int i3, File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, bitmap, Integer.valueOf(i3), file)).booleanValue();
        }
        File file2 = new File(file.getParent());
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!file.exists() || !file.isFile()) {
            file.createNewFile();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e16) {
                    throw e16;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                throw e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
