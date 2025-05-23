package com.tencent.theme;

import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends LongSparseArray {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    LongSparseArray<Integer> f376047d;

    /* renamed from: e, reason: collision with root package name */
    LongSparseArray f376048e;

    /* renamed from: f, reason: collision with root package name */
    SkinEngine f376049f;

    public c(SkinEngine skinEngine, Resources resources, LongSparseArray longSparseArray, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, skinEngine, resources, longSparseArray, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f376049f = skinEngine;
        this.f376048e = longSparseArray;
        this.f376047d = new LongSparseArray<>(i3 + 10);
        long uptimeMillis = SystemClock.uptimeMillis();
        TypedValue typedValue = new TypedValue();
        while (i16 <= i17) {
            try {
                resources.getValue(i16, typedValue, true);
                int i18 = typedValue.type;
                if ((i18 < 28 || i18 > 31) && typedValue.string.toString().endsWith(".xml")) {
                    this.f376047d.put((typedValue.assetCookie << 32) | typedValue.data, Integer.valueOf(i16));
                }
            } catch (Resources.NotFoundException e16) {
                if (SkinEngine.DEBUG) {
                    m.a("ColorStateListPreloadIntercepter", 1, e16.getMessage());
                }
            }
            i16++;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        SkinEngine.getInstances().sStatisticMap.put("init_color", Long.valueOf(uptimeMillis2));
        m.a(SkinEngine.TAG, 1, "int ColorStateListPreloadIntercepter cost: " + uptimeMillis2);
    }

    @Override // android.util.LongSparseArray
    public Object get(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        Integer num = this.f376047d.get(j3);
        if (num == null) {
            return this.f376048e.get(j3);
        }
        return this.f376049f.loadColorStateList(num.intValue());
    }

    public c(SkinEngine skinEngine, Resources resources, int[] iArr, LongSparseArray longSparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, skinEngine, resources, iArr, longSparseArray);
            return;
        }
        m.a(SkinEngine.TAG, 1, "ColorStateListPreloadIntercepter init 2");
        this.f376049f = skinEngine;
        this.f376048e = longSparseArray;
        this.f376047d = new LongSparseArray<>(iArr.length + 10);
        long uptimeMillis = SystemClock.uptimeMillis();
        TypedValue typedValue = new TypedValue();
        for (int i3 : iArr) {
            try {
                resources.getValue(i3, typedValue, true);
                int i16 = typedValue.type;
                if (i16 < 28 || i16 > 31) {
                    CharSequence charSequence = typedValue.string;
                    if (!TextUtils.isEmpty(charSequence == null ? "" : charSequence.toString())) {
                        this.f376047d.put((typedValue.assetCookie << 32) | typedValue.data, Integer.valueOf(i3));
                    } else if (SkinEngine.DEBUG) {
                        m.a(SkinEngine.TAG, 1, "not find res : " + i3 + " value : " + typedValue);
                    }
                }
            } catch (Exception e16) {
                if (SkinEngine.DEBUG) {
                    m.a(SkinEngine.TAG, 1, "init color error, res id : " + i3 + ",msg:" + e16.getMessage());
                }
            }
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        SkinEngine.getInstances().sStatisticMap.put("init_color", Long.valueOf(uptimeMillis2));
        m.a(SkinEngine.TAG, 1, "init ColorStateListPreloadIntercepter2 cost: " + uptimeMillis2);
    }
}
