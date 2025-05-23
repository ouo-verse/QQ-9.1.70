package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<i> f73633a = new ArrayList<>(1);

    public void a(Canvas canvas) {
        int size = this.f73633a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f73633a.get(i3).d(canvas);
        }
    }

    public void b(Context context, int i3, int i16) {
        Resources resources = context.getResources();
        this.f73633a.clear();
        if (i3 != 0) {
            InputStream openRawResource = resources.openRawResource(i3);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(openRawResource), 512);
                    do {
                        try {
                            i iVar = new i(bufferedReader2);
                            bufferedReader2.readLine();
                            bufferedReader2.readLine();
                            TypedArray obtainTypedArray = resources.obtainTypedArray(i16);
                            int length = obtainTypedArray.length();
                            BitmapDrawable[] bitmapDrawableArr = new BitmapDrawable[length];
                            for (int i17 = 0; i17 < length; i17++) {
                                bitmapDrawableArr[i17] = (BitmapDrawable) obtainTypedArray.getDrawable(i17);
                            }
                            iVar.p(bitmapDrawableArr);
                            obtainTypedArray.recycle();
                            this.f73633a.add(iVar);
                            if (bufferedReader2.readLine() == null) {
                                break;
                            }
                        } catch (IOException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            if (QLog.isColorLevel()) {
                                QLog.e("ParticleEffect", 2, "WL_DEBUG loadEmitters ex = ", e);
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e17) {
                                    e = e17;
                                    if (!QLog.isColorLevel()) {
                                        return;
                                    }
                                    QLog.e("ParticleEffect", 2, "WL_DEBUG finally loadEmitters ex = ", e);
                                }
                            }
                            openRawResource.close();
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e18) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("ParticleEffect", 2, "WL_DEBUG finally loadEmitters ex = ", e18);
                                    }
                                    throw th;
                                }
                            }
                            openRawResource.close();
                            throw th;
                        }
                    } while (bufferedReader2.readLine() != null);
                    try {
                        bufferedReader2.close();
                        openRawResource.close();
                    } catch (Exception e19) {
                        e = e19;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.e("ParticleEffect", 2, "WL_DEBUG finally loadEmitters ex = ", e);
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e26) {
                e = e26;
            }
        }
    }

    public void c(PathMeasure pathMeasure) {
        int size = this.f73633a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f73633a.get(i3).o(pathMeasure);
        }
    }

    public void d(float f16) {
        int size = this.f73633a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f73633a.get(i3).q(f16);
        }
    }
}
