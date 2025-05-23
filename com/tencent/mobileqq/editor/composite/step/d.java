package com.tencent.mobileqq.editor.composite.step;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.e;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public e f204034a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.d f204035b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f204036c;

    /* renamed from: d, reason: collision with root package name */
    private String f204037d;

    /* renamed from: e, reason: collision with root package name */
    private int f204038e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f204039f;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static long a(int i3) {
        return (i3 * 1000000000) / 25;
    }

    private Bitmap c(Bitmap bitmap) {
        if (bitmap.getWidth() % 2 == 1) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return createBitmap;
        }
        return bitmap;
    }

    private void d() throws IOException {
        hd0.c.a("Q.qqstory.publish.upload.PicToVideoConverter", "preparing.");
        this.f204036c = c(this.f204036c);
        hd0.c.a("Q.qqstory.publish.upload.PicToVideoConverter", "bitmap's width = " + this.f204036c.getWidth() + ", height = " + this.f204036c.getHeight());
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(this.f204037d, this.f204036c.getWidth(), this.f204036c.getHeight(), 532480, 1, false, 0);
        cVar.f312562g = 25;
        e eVar = new e();
        this.f204034a = eVar;
        eVar.f(cVar);
        com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.d();
        this.f204035b = dVar;
        dVar.b(cVar, this.f204034a.c());
        this.f204038e = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, this.f204036c);
        this.f204039f = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }

    private void e() {
        hd0.c.a("Q.qqstory.publish.upload.PicToVideoConverter", "releasing.");
        com.tencent.mobileqq.videocodec.mediacodec.encoder.d dVar = this.f204035b;
        if (dVar != null) {
            dVar.d();
            this.f204035b = null;
        }
    }

    public int b(String str, String str2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hd0.c.v("Q.qqstory.publish.upload.PicToVideoConverter", "input file path is %s. output file path is %s.", str, str2);
            if (!com.tencent.biz.qqstory.utils.d.k(str)) {
                hd0.c.g("Q.qqstory.publish.upload.PicToVideoConverter", "input file does not exists or is empty.");
                return 940007;
            }
            this.f204037d = str2;
            try {
                this.f204036c = BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e16) {
                System.gc();
                try {
                    LockMethodProxy.sleep(1000L);
                } catch (InterruptedException e17) {
                    e17.printStackTrace();
                }
                Bitmap decodeScaledBitmap = BaseImageUtil.decodeScaledBitmap(str, 540, 960);
                this.f204036c = decodeScaledBitmap;
                if (decodeScaledBitmap == null) {
                    this.f204036c = BaseImageUtil.decodeScaledBitmap(str, 360, 640);
                }
                if (this.f204036c == null) {
                    hd0.c.i("Q.qqstory.publish.upload.PicToVideoConverter", "decode bitmap <%s> error:%s", str, e16);
                    return 942014;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    d();
                    for (int i16 = 0; i16 < 75; i16++) {
                        this.f204034a.b();
                        this.f204035b.a(GLSLRender.GL_TEXTURE_2D, this.f204038e, this.f204039f, null, a(i16));
                    }
                    this.f204034a.g();
                    e();
                    i3 = 0;
                } catch (Exception e18) {
                    hd0.c.u("Q.qqstory.publish.upload.PicToVideoConverter", "convert picture to video error. %s.", e18);
                    this.f204034a.d();
                    e();
                    i3 = 942013;
                }
                hd0.c.v("Q.qqstory.publish.upload.PicToVideoConverter", "convert image to video done. cost time %d. errorCode is %d.", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i3));
                return i3;
            } catch (Throwable th5) {
                e();
                throw th5;
            }
        }
        throw new IllegalStateException("convert image to video failed. because input path or target path is null!");
    }
}
