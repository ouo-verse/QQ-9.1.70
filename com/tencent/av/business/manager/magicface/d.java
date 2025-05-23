package com.tencent.av.business.manager.magicface;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends MagicfaceBaseDecoder {
    public d() {
        AVCoreLog.printColorLog("MagicfaceNormalDecoder", "==init==");
    }

    @TargetApi(16)
    private Bitmap l(String str, Bitmap bitmap) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        if (i3 * i16 == 0) {
            return null;
        }
        options.inBitmap = bitmap;
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        for (int i17 = i3 * i16; i17 > 921600; i17 /= 4) {
            options.inSampleSize *= 2;
        }
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog("MagicfaceNormalDecoder", "getBitmap|decodeFile failed.");
            return null;
        }
    }

    @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder
    public int a() {
        Bitmap bitmap;
        boolean z16;
        boolean z17;
        int i3;
        long j3;
        String str;
        c cVar = this.f73352a;
        MagicfaceDataVideoJason magicfaceDataVideoJason = cVar.f73369c;
        long j16 = 1000 / magicfaceDataVideoJason.fps;
        int i16 = magicfaceDataVideoJason.repeat_count;
        String b16 = cVar.b();
        Bitmap bitmap2 = null;
        if (this.f73352a.f73369c.hasbackground) {
            bitmap = l(this.f73356e + MagicfaceDataVideoJason.Background, null);
        } else {
            bitmap = null;
        }
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            String str2 = "MagicfaceNormalDecoder";
            if (i18 >= i16) {
                break;
            }
            long j26 = j18;
            int i19 = 0;
            while (i19 < this.f73352a.a() && this.f73355d) {
                this.f73352a.g(i17, i18);
                int i26 = i17 + 1;
                String str3 = this.f73356e + this.f73352a.c(i19) + File.separator + this.f73352a.f73369c.src_prefix + i19 + ".png";
                StringBuilder sb5 = new StringBuilder();
                int i27 = i18;
                sb5.append("maigcfaceDecoder:");
                sb5.append(this.f73352a.a());
                sb5.append("|");
                sb5.append(str3);
                AVCoreLog.printColorLog(str2, sb5.toString());
                long currentTimeMillis = System.currentTimeMillis();
                bitmap2 = l(str3, bitmap2);
                long currentTimeMillis2 = j17 + (System.currentTimeMillis() - currentTimeMillis);
                long currentTimeMillis3 = System.currentTimeMillis() - j19;
                if (currentTimeMillis3 < j16) {
                    try {
                        LockMethodProxy.sleep(j16 - currentTimeMillis3);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                c cVar2 = this.f73352a;
                MagicfaceDataAudioJason magicfaceDataAudioJason = cVar2.f73370d;
                if (i19 == magicfaceDataAudioJason.frame_index && this.f73353b != null) {
                    d(b16, magicfaceDataAudioJason.is_repeat);
                } else if (i19 == cVar2.f73373g && this.f73353b != null) {
                    b(b16);
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                if (bitmap2 == null) {
                    AVCoreLog.printColorLog(str2, "maigcfaceDecoder bmp null:" + str3);
                } else {
                    WeakReference<MagicfaceBaseDecoder.b> weakReference = this.f73354c;
                    if (weakReference != null && weakReference.get() != null) {
                        MagicfaceBaseDecoder.b bVar = this.f73354c.get();
                        long currentTimeMillis5 = System.currentTimeMillis();
                        c cVar3 = this.f73352a;
                        MagicfaceDataVideoJason magicfaceDataVideoJason2 = cVar3.f73369c;
                        if (magicfaceDataVideoJason2.width == -1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (magicfaceDataVideoJason2.height == -1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        i3 = i19;
                        j3 = j16;
                        str = str2;
                        bVar.a(bitmap2, bitmap, z16, z17, false, false, cVar3.f73372f);
                        j26 += System.currentTimeMillis() - currentTimeMillis5;
                        i19 = i3 + 1;
                        str2 = str;
                        i17 = i26;
                        i18 = i27;
                        j17 = currentTimeMillis2;
                        j19 = currentTimeMillis4;
                        j16 = j3;
                    }
                }
                j3 = j16;
                i3 = i19;
                str = str2;
                i19 = i3 + 1;
                str2 = str;
                i17 = i26;
                i18 = i27;
                j17 = currentTimeMillis2;
                j19 = currentTimeMillis4;
                j16 = j3;
            }
            i18++;
            j18 = j26;
            j16 = j16;
        }
        AVCoreLog.printColorLog("MagicfaceNormalDecoder", String.format("maigcfaceDecoder| readCost=%s(ms), renderCost=%s(ms), r=(%s), frame(%s)", Long.valueOf(j17), Long.valueOf(j18), Integer.valueOf(i16), Integer.valueOf(this.f73352a.a())));
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        if (i17 != i16 * this.f73352a.a()) {
            return 0;
        }
        return 1;
    }
}
