package com.gyf.immersionbar;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.tencent.mapsdk.internal.by;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements Cloneable {
    public View W;
    public View X;

    @ColorInt
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    @ColorInt
    public int f36016a0;

    /* renamed from: i0, reason: collision with root package name */
    m f36029i0;

    /* renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f36019d = 0;

    /* renamed from: e, reason: collision with root package name */
    @ColorInt
    public int f36021e = -16777216;

    /* renamed from: f, reason: collision with root package name */
    public int f36023f = -16777216;

    /* renamed from: h, reason: collision with root package name */
    @FloatRange(from = 0.0d, to = by.f147964a)
    public float f36026h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    @FloatRange(from = 0.0d, to = by.f147964a)
    public float f36028i = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    @FloatRange(from = 0.0d, to = by.f147964a)
    public float f36030m = 0.0f;

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float C = 0.0f;
    public boolean D = false;
    public boolean E = false;
    public BarHide F = BarHide.FLAG_SHOW_BAR;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float K = 0.0f;

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float L = 0.0f;
    public boolean M = true;

    @ColorInt
    public int N = -16777216;

    @ColorInt
    public int P = -16777216;
    Map<View, Map<Integer, Integer>> Q = new HashMap();

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float R = 0.0f;

    @ColorInt
    public int S = 0;

    @ColorInt
    public int T = -16777216;

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float U = 0.0f;
    public boolean V = false;
    public boolean Y = true;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f36017b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f36018c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public int f36020d0 = 18;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f36022e0 = true;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f36024f0 = true;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f36025g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f36027h0 = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
