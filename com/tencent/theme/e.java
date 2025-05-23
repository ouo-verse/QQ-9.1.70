package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    LongSparseArray<Integer> f376050a;

    /* renamed from: b, reason: collision with root package name */
    LongSparseArray<Drawable.ConstantState>[] f376051b;

    /* renamed from: c, reason: collision with root package name */
    SkinEngine f376052c;

    public e(SkinEngine skinEngine, Resources resources, int i3, int i16, int i17, File file, LongSparseArray<Drawable.ConstantState>... longSparseArrayArr) {
        String str;
        CharSequence charSequence;
        i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, skinEngine, resources, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), file, longSparseArrayArr);
            return;
        }
        String str2 = SkinEngine.TAG;
        m.a(SkinEngine.TAG, 1, "DrawableLoader init2");
        this.f376052c = skinEngine;
        LongSparseArray<Drawable.ConstantState>[] longSparseArrayArr2 = new LongSparseArray[longSparseArrayArr.length];
        this.f376051b = longSparseArrayArr2;
        System.arraycopy(longSparseArrayArr, 0, longSparseArrayArr2, 0, longSparseArrayArr.length);
        this.f376050a = new LongSparseArray<>(i3 + 10);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            if (file != null) {
                try {
                    if (file.exists()) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                        m.a(SkinEngine.TAG, 1, "use cache2");
                        while (objectInputStream.available() > 0) {
                            this.f376050a.put(objectInputStream.readLong(), Integer.valueOf(objectInputStream.readInt()));
                        }
                        objectInputStream.close();
                        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        SkinEngine.getInstances().sStatisticMap.put("init_drawable", Long.valueOf(uptimeMillis2));
                        m.a(SkinEngine.TAG, 1, "int DrawablePreloadIntercepter2 cost: " + uptimeMillis2);
                        return;
                    }
                } catch (IOException e16) {
                    m.b(SkinEngine.TAG, 1, "parse cache2 error, ", e16);
                }
            }
            TypedValue typedValue = new TypedValue();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("DrawableLoader constructor firstResourcesId : ");
            int i18 = i16;
            sb5.append(i18);
            sb5.append(", lastDrawableId : ");
            sb5.append(i17);
            m.a(SkinEngine.TAG, 1, sb5.toString());
            int i19 = i18;
            while (true) {
                int i26 = i18 + 1;
                if (i18 < i17) {
                    try {
                        resources.getValue(i19, typedValue, z16);
                        charSequence = typedValue.string;
                    } catch (Throwable th5) {
                        th = th5;
                        str = str2;
                    }
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.endsWith(".9.png") || charSequence2.endsWith(".png") || charSequence2.endsWith(".jpg") || charSequence2.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || charSequence2.endsWith(".webp") || ((iVar = this.f376052c.mSkinLifecycle) != null && iVar.addResources(i19, charSequence2))) {
                            str = str2;
                            try {
                                this.f376050a.put(typedValue.data | (typedValue.assetCookie << 32), Integer.valueOf(i19));
                                i19++;
                                i18 = i26;
                                str2 = str;
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    str2 = str;
                                    m.b(str2, 1, "DrawableLoader constructor loop exception drawable id : " + i19 + ", value : " + ((Object) typedValue.string), th);
                                    i19++;
                                    i18 = i26;
                                    z16 = true;
                                } catch (Throwable th7) {
                                    th = th7;
                                    str2 = str;
                                    long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
                                    SkinEngine.getInstances().sStatisticMap.put("init_drawable", Long.valueOf(uptimeMillis3));
                                    m.a(str2, 1, "int DrawablePreloadIntercepter2 cost: " + uptimeMillis3);
                                    throw th;
                                }
                            }
                            z16 = true;
                        }
                    }
                    str = str2;
                    i19++;
                    i18 = i26;
                    str2 = str;
                    z16 = true;
                } else {
                    long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis;
                    SkinEngine.getInstances().sStatisticMap.put("init_drawable", Long.valueOf(uptimeMillis4));
                    m.a(str2, 1, "int DrawablePreloadIntercepter2 cost: " + uptimeMillis4);
                    return;
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static g c(SkinEngine skinEngine, Resources resources) {
        return new g(skinEngine, resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Resources resources, int i3) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i3, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            this.f376050a.put((typedValue.assetCookie << 32) | typedValue.data, Integer.valueOf(i3));
        }
    }

    public Drawable.ConstantState b(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
        Integer num = this.f376050a.get(j3);
        if (num == null) {
            return this.f376051b[i3].get(j3);
        }
        Integer num2 = SkinEngine.mIconResourceID;
        if (num2 != null && num2.equals(num)) {
            if (SkinEngine.DEBUG) {
                Log.d(SkinEngine.TAG, "To support Samsung multi-window, return default icon resource");
                return null;
            }
            return null;
        }
        return this.f376052c.loadConstantState(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(File file) throws IOException {
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            LongSparseArray<Integer> clone = this.f376050a.clone();
            for (int i3 = 0; i3 < clone.size(); i3++) {
                long keyAt = clone.keyAt(i3);
                Integer valueAt = clone.valueAt(i3);
                if (valueAt != null) {
                    int intValue = valueAt.intValue();
                    objectOutputStream.writeLong(keyAt);
                    objectOutputStream.writeInt(intValue);
                }
            }
            objectOutputStream.close();
        }
    }

    public e(SkinEngine skinEngine, Resources resources, int[] iArr, LongSparseArray<Drawable.ConstantState>... longSparseArrayArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, skinEngine, resources, iArr, longSparseArrayArr);
            return;
        }
        m.a(SkinEngine.TAG, 1, "DrawableLoader init3");
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f376052c = skinEngine;
        LongSparseArray<Drawable.ConstantState>[] longSparseArrayArr2 = new LongSparseArray[longSparseArrayArr.length];
        this.f376051b = longSparseArrayArr2;
        System.arraycopy(longSparseArrayArr, 0, longSparseArrayArr2, 0, longSparseArrayArr.length);
        int length = iArr.length;
        this.f376050a = new LongSparseArray<>(length + 10);
        TypedValue typedValue = new TypedValue();
        m.a(SkinEngine.TAG, 1, "DrawableLoader constructor drawables size : " + length);
        for (int i3 : iArr) {
            try {
                resources.getValue(i3, typedValue, true);
                this.f376050a.put((typedValue.assetCookie << 32) | typedValue.data, Integer.valueOf(i3));
            } catch (Throwable th5) {
                m.b(SkinEngine.TAG, 1, "DrawableLoader constructor loop exception drawable id : " + i3 + ", value : " + ((Object) typedValue.string), th5);
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        SkinEngine.getInstances().sStatisticMap.put("init_drawable", Long.valueOf(uptimeMillis2));
        m.a(SkinEngine.TAG, 1, "int DrawablePreloadIntercepter3 cost: " + uptimeMillis2);
    }
}
