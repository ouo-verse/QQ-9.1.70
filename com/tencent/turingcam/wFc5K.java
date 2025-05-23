package com.tencent.turingcam;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.View;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.DO0IX;
import com.tencent.turingcam.spXPg;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public class wFc5K extends spXPg {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<View> f382410b;

    /* renamed from: c, reason: collision with root package name */
    private int f382411c;

    /* renamed from: d, reason: collision with root package name */
    private int f382412d;

    /* renamed from: e, reason: collision with root package name */
    private long f382413e;

    /* renamed from: f, reason: collision with root package name */
    private long f382414f;

    public wFc5K() {
        super("3");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382411c = 0;
            this.f382412d = 180;
        }
    }

    @Override // com.tencent.turingcam.spXPg
    public long a(DO0IX.spXPg spxpg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) spxpg)).longValue();
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (Camera.getNumberOfCameras() == 1) {
                Camera.getCameraInfo(1, cameraInfo);
            }
            View b16 = spxpg.b();
            this.f382413e = System.currentTimeMillis();
            this.f382414f = spxpg.e();
            if (b16 == null) {
                G2SZT.b().a("checker_start_codes", a(), String.valueOf(TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS));
                return TroopMemberInfo.VALUE_MEMBER_CLOSE_SHARE_LBS;
            }
            if (!(b16 instanceof CFgXs)) {
                G2SZT.b().a("checker_start_codes", a(), String.valueOf(-1002L));
                return -1002L;
            }
            int b17 = spxpg.b(180);
            if (b17 > 0) {
                this.f382412d = b17;
            }
            this.f382410b = new WeakReference<>(b16);
            this.f382411c = 0;
            G2SZT.b().a("checker_start_codes", a(), String.valueOf(0L));
            return 0L;
        } catch (Exception unused) {
            G2SZT.b().a("checker_start_codes", a(), String.valueOf(-1002L));
            return -1002L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    @Override // com.tencent.turingcam.spXPg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(spXPg.C10028spXPg c10028spXPg, Camera camera2, EQsUZ eQsUZ) {
        CFgXs cFgXs;
        Bitmap bitmap;
        Bitmap decodeByteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, c10028spXPg, camera2, eQsUZ)).booleanValue();
        }
        if (c10028spXPg.f382372a - this.f382413e < this.f382414f) {
            return false;
        }
        byte[] bArr = c10028spXPg.f382373b;
        uAnWx[] uanwxArr = null;
        if (bArr != null) {
            WeakReference<View> weakReference = this.f382410b;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.f382410b.get();
                if (view instanceof CFgXs) {
                    cFgXs = (CFgXs) view;
                    if (cFgXs != null && (bitmap = cFgXs.getBitmap()) != null) {
                        Camera.Parameters parameters = camera2.getParameters();
                        int i3 = parameters.getPreviewSize().width;
                        int i16 = parameters.getPreviewSize().height;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i3, i16, null);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(new Rect(0, 0, i3, i16), 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
                        if (decodeByteArray != null) {
                            float max = ((this.f382412d * 1.0f) / Math.max(decodeByteArray.getWidth(), decodeByteArray.getHeight())) * 1.0f;
                            Matrix matrix = new Matrix();
                            int rotation = cFgXs.getDisplay().getRotation();
                            int i17 = rotation * 90;
                            if (rotation == 0) {
                                i17 = 0;
                            } else if (rotation == 1) {
                                i17 = 90;
                            } else if (rotation == 2) {
                                i17 = 180;
                            } else if (rotation == 3) {
                                i17 = 270;
                            }
                            Camera.getCameraInfo(1, new Camera.CameraInfo());
                            matrix.preRotate((r1.orientation + i17) % 360);
                            matrix.postScale(max, max);
                            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                            decodeByteArray.recycle();
                            if (createBitmap != null) {
                                float max2 = ((this.f382412d * 1.0f) / Math.max(bitmap.getWidth(), bitmap.getHeight())) * 1.0f;
                                matrix.reset();
                                matrix.preScale(-max2, max2);
                                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                bitmap.recycle();
                                if (createBitmap2 != null) {
                                    uanwxArr = new uAnWx[]{a(createBitmap, 0), a(createBitmap2, 1)};
                                    createBitmap.recycle();
                                    createBitmap2.recycle();
                                }
                            }
                        }
                    }
                }
            }
            cFgXs = null;
            if (cFgXs != null) {
                Camera.Parameters parameters2 = camera2.getParameters();
                int i36 = parameters2.getPreviewSize().width;
                int i162 = parameters2.getPreviewSize().height;
                YuvImage yuvImage2 = new YuvImage(bArr, 17, i36, i162, null);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                yuvImage2.compressToJpeg(new Rect(0, 0, i36, i162), 100, byteArrayOutputStream2);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeByteArray = BitmapFactory.decodeByteArray(byteArray2, 0, byteArray2.length, options2);
                if (decodeByteArray != null) {
                }
            }
        }
        if (uanwxArr != null) {
            G2SZT.b().a("checker_handle_codes", a(), String.valueOf(0L));
            eQsUZ.f381792a.addAll(Arrays.asList(uanwxArr));
            return true;
        }
        int i18 = this.f382411c;
        this.f382411c = i18 + 1;
        return i18 >= 5;
    }

    private uAnWx a(Bitmap bitmap, int i3) {
        uAnWx uanwx = new uAnWx();
        uanwx.f382396a = a();
        uanwx.f382397b = i3;
        uanwx.f382399d = bitmap.getWidth();
        uanwx.f382400e = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        uanwx.f382398c = byteArrayOutputStream.toByteArray();
        return uanwx;
    }
}
