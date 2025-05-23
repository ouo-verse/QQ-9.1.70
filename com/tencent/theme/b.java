package com.tencent.theme;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends SparseArray<ColorStateList> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    SparseArray<Integer> f376044d;

    /* renamed from: e, reason: collision with root package name */
    SparseArray<ColorStateList> f376045e;

    /* renamed from: f, reason: collision with root package name */
    SkinEngine f376046f;

    public b(SkinEngine skinEngine, Resources resources, SparseArray<ColorStateList> sparseArray, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, skinEngine, resources, sparseArray, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f376046f = skinEngine;
        this.f376045e = sparseArray;
        this.f376044d = new SparseArray<>(i3 + 10);
        long uptimeMillis = SystemClock.uptimeMillis();
        TypedValue typedValue = new TypedValue();
        while (i16 <= i17) {
            try {
                resources.getValue(i16, typedValue, true);
                int i18 = typedValue.type;
                if ((i18 < 28 || i18 > 31) && typedValue.string.toString().endsWith(".xml")) {
                    this.f376044d.put((typedValue.assetCookie << 24) | typedValue.data, Integer.valueOf(i16));
                }
            } catch (Resources.NotFoundException e16) {
                if (SkinEngine.DEBUG) {
                    m.a("ColorStateListPreloadIntercepter", 1, e16.getMessage());
                }
            }
            i16++;
        }
        if (SkinEngine.DEBUG) {
            Log.d(SkinEngine.TAG, "int ColorStateListPreloadIntercepter cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
        }
    }

    @Override // android.util.SparseArray
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ColorStateList get(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        Integer num = this.f376044d.get(i3);
        if (num == null) {
            return this.f376045e.get(i3);
        }
        return this.f376046f.loadColorStateList(num.intValue());
    }

    public b(SkinEngine skinEngine, Resources resources, int[] iArr, SparseArray<ColorStateList> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, skinEngine, resources, iArr, sparseArray);
            return;
        }
        m.a(SkinEngine.TAG, 1, "ColorStateListPreloadIntercepter init 2");
        this.f376046f = skinEngine;
        this.f376045e = sparseArray;
        this.f376044d = new SparseArray<>(iArr.length + 10);
        long uptimeMillis = SystemClock.uptimeMillis();
        TypedValue typedValue = new TypedValue();
        for (int i3 : iArr) {
            try {
                resources.getValue(i3, typedValue, true);
                int i16 = typedValue.type;
                if (i16 < 28 || i16 > 31) {
                    CharSequence charSequence = typedValue.string;
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    if (!TextUtils.isEmpty(charSequence2) && charSequence2.endsWith(".xml")) {
                        this.f376044d.put((typedValue.assetCookie << 24) | typedValue.data, Integer.valueOf(i3));
                    }
                }
            } catch (Exception e16) {
                if (SkinEngine.DEBUG) {
                    m.a(SkinEngine.TAG, 1, "init color error, res id : " + i3 + ",e=" + e16.getMessage());
                }
            }
        }
        m.a(SkinEngine.TAG, 1, "init ColorStateListPreloadIntercepter2 cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
    }
}
