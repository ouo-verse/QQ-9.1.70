package com.qzone.reborn.qzmoment.view.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        if (r8 == 0) goto L66;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0090 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.support.v8.renderscript.BaseObj] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap b(Context context, Bitmap bitmap, int i3) throws RSRuntimeException {
        Allocation allocation;
        Object obj;
        Allocation allocation2;
        Object obj2;
        Allocation createFromBitmap;
        Allocation createTyped;
        RenderScript renderScript = null;
        r1 = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = null;
        renderScript = null;
        renderScript = null;
        if (context == 0 || bitmap == null) {
            return null;
        }
        ?? r26 = Build.VERSION.SDK_INT;
        if (r26 != 26) {
            ?? r36 = 27;
            try {
                if (r26 != 27) {
                    try {
                        RenderScript create = RenderScript.create(context);
                        try {
                            create.setMessageHandler(new RenderScript.RSMessageHandler());
                            createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                            try {
                                createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                            } catch (Exception e16) {
                                e = e16;
                                obj2 = null;
                                allocation2 = createFromBitmap;
                                renderScript = create;
                                context = obj2;
                                r26 = allocation2;
                                r36 = obj2;
                                QLog.e("QZMBlur", 1, "rs  e = " + e);
                                if (renderScript != null) {
                                }
                                if (r26 != 0) {
                                }
                                if (r36 != 0) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj = null;
                                allocation = createFromBitmap;
                                renderScript = create;
                                context = obj;
                                r26 = allocation;
                                r36 = obj;
                                QLog.e("QZMBlur", 1, "rs  throwable = " + th);
                            }
                        } catch (Exception e17) {
                            e = e17;
                            allocation2 = null;
                            obj2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            allocation = null;
                            obj = null;
                        }
                        try {
                            scriptIntrinsicBlur = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                            scriptIntrinsicBlur.setInput(createFromBitmap);
                            scriptIntrinsicBlur.setRadius(i3);
                            scriptIntrinsicBlur.forEach(createTyped);
                            createTyped.copyTo(bitmap);
                            create.destroy();
                            createFromBitmap.destroy();
                            createTyped.destroy();
                            scriptIntrinsicBlur.destroy();
                        } catch (Exception e18) {
                            e = e18;
                            ScriptIntrinsicBlur scriptIntrinsicBlur2 = scriptIntrinsicBlur;
                            renderScript = create;
                            context = scriptIntrinsicBlur2;
                            r26 = createFromBitmap;
                            r36 = createTyped;
                            QLog.e("QZMBlur", 1, "rs  e = " + e);
                            if (renderScript != null) {
                                renderScript.destroy();
                            }
                            if (r26 != 0) {
                                r26.destroy();
                            }
                            if (r36 != 0) {
                                r36.destroy();
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            ScriptIntrinsicBlur scriptIntrinsicBlur3 = scriptIntrinsicBlur;
                            renderScript = create;
                            context = scriptIntrinsicBlur3;
                            r26 = createFromBitmap;
                            r36 = createTyped;
                            QLog.e("QZMBlur", 1, "rs  throwable = " + th);
                        }
                    } catch (Exception e19) {
                        e = e19;
                        context = 0;
                        r26 = 0;
                        r36 = 0;
                    } catch (Throwable th8) {
                        th = th8;
                        context = 0;
                        r26 = 0;
                        r36 = 0;
                    }
                    return bitmap;
                }
            } finally {
                if (renderScript != null) {
                    renderScript.destroy();
                }
                if (r26 != 0) {
                    r26.destroy();
                }
                if (r36 != 0) {
                    r36.destroy();
                }
                if (context != 0) {
                    context.destroy();
                }
            }
        }
        return c(bitmap, i3, true);
    }

    private static Bitmap c(Bitmap bitmap, int i3, boolean z16) {
        int[] iArr;
        int i16 = i3;
        Bitmap copy = z16 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i16 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i17 = width * height;
        int[] iArr2 = new int[i17];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i18 = width - 1;
        int i19 = height - 1;
        int i26 = i16 + i16 + 1;
        int[] iArr3 = new int[i17];
        int[] iArr4 = new int[i17];
        int[] iArr5 = new int[i17];
        int[] iArr6 = new int[Math.max(width, height)];
        int i27 = (i26 + 1) >> 1;
        int i28 = i27 * i27;
        int i29 = i28 * 256;
        int[] iArr7 = new int[i29];
        for (int i36 = 0; i36 < i29; i36++) {
            iArr7[i36] = i36 / i28;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i26, 3);
        int i37 = i16 + 1;
        int i38 = 0;
        int i39 = 0;
        int i46 = 0;
        while (i38 < height) {
            Bitmap bitmap2 = copy;
            int i47 = height;
            int i48 = 0;
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = -i16;
            int i68 = 0;
            while (i67 <= i16) {
                int i69 = i19;
                int[] iArr9 = iArr6;
                int i75 = iArr2[i39 + Math.min(i18, Math.max(i67, 0))];
                int[] iArr10 = iArr8[i67 + i16];
                iArr10[0] = (i75 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr10[1] = (i75 & 65280) >> 8;
                iArr10[2] = i75 & 255;
                int abs = i37 - Math.abs(i67);
                int i76 = iArr10[0];
                i68 += i76 * abs;
                int i77 = iArr10[1];
                i48 += i77 * abs;
                int i78 = iArr10[2];
                i49 += abs * i78;
                if (i67 > 0) {
                    i59 += i76;
                    i65 += i77;
                    i66 += i78;
                } else {
                    i56 += i76;
                    i57 += i77;
                    i58 += i78;
                }
                i67++;
                i19 = i69;
                iArr6 = iArr9;
            }
            int i79 = i19;
            int[] iArr11 = iArr6;
            int i85 = i16;
            int i86 = i68;
            int i87 = 0;
            while (i87 < width) {
                iArr3[i39] = iArr7[i86];
                iArr4[i39] = iArr7[i48];
                iArr5[i39] = iArr7[i49];
                int i88 = i86 - i56;
                int i89 = i48 - i57;
                int i95 = i49 - i58;
                int[] iArr12 = iArr8[((i85 - i16) + i26) % i26];
                int i96 = i56 - iArr12[0];
                int i97 = i57 - iArr12[1];
                int i98 = i58 - iArr12[2];
                if (i38 == 0) {
                    iArr = iArr7;
                    iArr11[i87] = Math.min(i87 + i16 + 1, i18);
                } else {
                    iArr = iArr7;
                }
                int i99 = iArr2[i46 + iArr11[i87]];
                int i100 = (i99 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr12[0] = i100;
                int i101 = (i99 & 65280) >> 8;
                iArr12[1] = i101;
                int i102 = i99 & 255;
                iArr12[2] = i102;
                int i103 = i59 + i100;
                int i104 = i65 + i101;
                int i105 = i66 + i102;
                i86 = i88 + i103;
                i48 = i89 + i104;
                i49 = i95 + i105;
                i85 = (i85 + 1) % i26;
                int[] iArr13 = iArr8[i85 % i26];
                int i106 = iArr13[0];
                i56 = i96 + i106;
                int i107 = iArr13[1];
                i57 = i97 + i107;
                int i108 = iArr13[2];
                i58 = i98 + i108;
                i59 = i103 - i106;
                i65 = i104 - i107;
                i66 = i105 - i108;
                i39++;
                i87++;
                iArr7 = iArr;
            }
            i46 += width;
            i38++;
            copy = bitmap2;
            height = i47;
            i19 = i79;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i109 = i19;
        int[] iArr14 = iArr6;
        int i110 = height;
        int[] iArr15 = iArr7;
        int i111 = 0;
        while (i111 < width) {
            int i112 = -i16;
            int i113 = i26;
            int[] iArr16 = iArr2;
            int i114 = 0;
            int i115 = 0;
            int i116 = 0;
            int i117 = 0;
            int i118 = 0;
            int i119 = 0;
            int i120 = 0;
            int i121 = i112;
            int i122 = i112 * width;
            int i123 = 0;
            int i124 = 0;
            while (i121 <= i16) {
                int i125 = width;
                int max = Math.max(0, i122) + i111;
                int[] iArr17 = iArr8[i121 + i16];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i37 - Math.abs(i121);
                i123 += iArr3[max] * abs2;
                i124 += iArr4[max] * abs2;
                i114 += iArr5[max] * abs2;
                if (i121 > 0) {
                    i118 += iArr17[0];
                    i119 += iArr17[1];
                    i120 += iArr17[2];
                } else {
                    i115 += iArr17[0];
                    i116 += iArr17[1];
                    i117 += iArr17[2];
                }
                int i126 = i109;
                if (i121 < i126) {
                    i122 += i125;
                }
                i121++;
                i109 = i126;
                width = i125;
            }
            int i127 = width;
            int i128 = i109;
            int i129 = i16;
            int i130 = i111;
            int i131 = i110;
            int i132 = 0;
            while (i132 < i131) {
                iArr16[i130] = (iArr16[i130] & (-16777216)) | (iArr15[i123] << 16) | (iArr15[i124] << 8) | iArr15[i114];
                int i133 = i123 - i115;
                int i134 = i124 - i116;
                int i135 = i114 - i117;
                int[] iArr18 = iArr8[((i129 - i16) + i113) % i113];
                int i136 = i115 - iArr18[0];
                int i137 = i116 - iArr18[1];
                int i138 = i117 - iArr18[2];
                if (i111 == 0) {
                    iArr14[i132] = Math.min(i132 + i37, i128) * i127;
                }
                int i139 = iArr14[i132] + i111;
                int i140 = iArr3[i139];
                iArr18[0] = i140;
                int i141 = iArr4[i139];
                iArr18[1] = i141;
                int i142 = iArr5[i139];
                iArr18[2] = i142;
                int i143 = i118 + i140;
                int i144 = i119 + i141;
                int i145 = i120 + i142;
                i123 = i133 + i143;
                i124 = i134 + i144;
                i114 = i135 + i145;
                i129 = (i129 + 1) % i113;
                int[] iArr19 = iArr8[i129];
                int i146 = iArr19[0];
                i115 = i136 + i146;
                int i147 = iArr19[1];
                i116 = i137 + i147;
                int i148 = iArr19[2];
                i117 = i138 + i148;
                i118 = i143 - i146;
                i119 = i144 - i147;
                i120 = i145 - i148;
                i130 += i127;
                i132++;
                i16 = i3;
            }
            i111++;
            i16 = i3;
            i109 = i128;
            i110 = i131;
            i26 = i113;
            iArr2 = iArr16;
            width = i127;
        }
        int i149 = width;
        bitmap3.setPixels(iArr2, 0, i149, 0, 0, i149, i110);
        return bitmap3;
    }

    public static Bitmap a(Context context, Bitmap bitmap, b bVar) {
        Bitmap c16;
        if (context == null || bitmap == null || bVar == null) {
            return null;
        }
        int i3 = bVar.f59078a;
        int i16 = bVar.f59081d;
        int i17 = i3 / i16;
        int i18 = bVar.f59079b / i16;
        if (c.b(i17, i18)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i19 = bVar.f59081d;
        canvas.scale(1.0f / i19, 1.0f / i19);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(bVar.f59082e, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            c16 = b(context, createBitmap, bVar.f59080c);
        } catch (RSRuntimeException unused) {
            c16 = c(createBitmap, bVar.f59080c, true);
        }
        if (xe.a.f447839a.a()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("of  | bitmap.size = ");
            sb5.append(c16 != null ? c16.getByteCount() : 0);
            sb5.append(" | factor.mWidth = ");
            sb5.append(bVar.f59078a);
            sb5.append(" | factor.mHeight = ");
            sb5.append(bVar.f59079b);
            sb5.append(" | width = ");
            sb5.append(i17);
            sb5.append(" | height = ");
            sb5.append(i18);
            QLog.d("QZMBlur", 1, sb5.toString());
            return c16;
        }
        if (bVar.f59081d == 1) {
            return c16;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(c16, bVar.f59078a, bVar.f59079b, true);
        if (c16 != null) {
            c16.recycle();
        }
        return createScaledBitmap;
    }
}
