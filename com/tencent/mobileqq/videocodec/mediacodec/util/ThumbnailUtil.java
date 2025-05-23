package com.tencent.mobileqq.videocodec.mediacodec.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.c;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.IntBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThumbnailUtil {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onResult(boolean z16, String str);
    }

    public static void a(int i3, int i16, int i17, c cVar, a aVar) {
        int i18 = i16 * i17;
        int[] iArr = new int[i18];
        int[] iArr2 = new int[i18];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        if (i3 != 0) {
            GLES20.glGenFramebuffers(1, r11, 0);
            GLES20.glBindFramebuffer(36160, r11[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
            GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, r11, 0);
            int[] iArr3 = {0};
        } else {
            GLES20.glReadPixels(0, 0, i16, i17, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        }
        cVar.getClass();
        ThreadManagerV2.executeOnFileThread(new Runnable(i17, i16, iArr, iArr2, b(cVar.f312558c), Bitmap.CompressFormat.PNG, 100, aVar) { // from class: com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int C;
            final /* synthetic */ a D;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f312670d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f312671e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int[] f312672f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int[] f312673h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f312674i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ Bitmap.CompressFormat f312675m;

            {
                this.f312670d = i17;
                this.f312671e = i16;
                this.f312672f = iArr;
                this.f312673h = iArr2;
                this.f312674i = r9;
                this.f312675m = r10;
                this.C = r11;
                this.D = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i17), Integer.valueOf(i16), iArr, iArr2, r9, r10, Integer.valueOf(r11), aVar);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v3, types: [android.graphics.Bitmap] */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v13, types: [android.graphics.Bitmap$CompressFormat] */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v2 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v21 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream] */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileOutputStream] */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileOutputStream] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i19;
                a aVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z16 = false;
                int i26 = 0;
                while (true) {
                    i19 = this.f312670d;
                    if (i26 >= i19) {
                        break;
                    }
                    int i27 = 0;
                    while (true) {
                        int i28 = this.f312671e;
                        if (i27 < i28) {
                            int i29 = this.f312672f[(i26 * i28) + i27];
                            this.f312673h[(((this.f312670d - i26) - 1) * i28) + i27] = (i29 & (-16711936)) | ((i29 << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((i29 >> 16) & 255);
                            i27++;
                        }
                    }
                    i26++;
                }
                ?? createBitmap = Bitmap.createBitmap(this.f312673h, this.f312671e, i19, Bitmap.Config.ARGB_8888);
                ?? r26 = 0;
                r26 = 0;
                r26 = 0;
                r26 = 0;
                try {
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                try {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f312674i);
                        try {
                            r26 = this.f312675m;
                            createBitmap.compress(r26, this.C, fileOutputStream);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                            z16 = true;
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            r26 = fileOutputStream;
                            e.printStackTrace();
                            if (r26 != 0) {
                                r26.close();
                                r26 = r26;
                            }
                            aVar2 = this.D;
                            if (aVar2 != null) {
                            }
                        } catch (IOException e19) {
                            e = e19;
                            r26 = fileOutputStream;
                            e.printStackTrace();
                            if (r26 != 0) {
                                r26.close();
                                r26 = r26;
                            }
                            aVar2 = this.D;
                            if (aVar2 != null) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            r26 = fileOutputStream;
                            if (r26 != 0) {
                                try {
                                    r26.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e27) {
                        e = e27;
                    } catch (IOException e28) {
                        e = e28;
                    }
                    aVar2 = this.D;
                    if (aVar2 != null) {
                        aVar2.onResult(z16, this.f312674i);
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static String b(String str) {
        return str + ".thumb.png";
    }
}
