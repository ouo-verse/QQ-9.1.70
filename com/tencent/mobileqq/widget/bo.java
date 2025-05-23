package com.tencent.mobileqq.widget;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bo extends BitmapDrawable {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f316751f = {R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    private static final float[] f316752g;

    /* renamed from: h, reason: collision with root package name */
    private static final ColorMatrixColorFilter f316753h;

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f316754i;

    /* renamed from: j, reason: collision with root package name */
    private static final ColorMatrixColorFilter f316755j;

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f316756k;

    /* renamed from: l, reason: collision with root package name */
    private static final ColorMatrixColorFilter f316757l;

    /* renamed from: a, reason: collision with root package name */
    private float f316758a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f316759b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<int[]> f316760c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<ColorFilter> f316761d;

    /* renamed from: e, reason: collision with root package name */
    private ColorFilter f316762e;

    static {
        float[] fArr = {0.0f, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f};
        f316752g = fArr;
        f316753h = new ColorMatrixColorFilter(fArr);
        float[] fArr2 = {0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f316754i = fArr2;
        f316755j = new ColorMatrixColorFilter(fArr2);
        float[] fArr3 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f};
        f316756k = fArr3;
        f316757l = new ColorMatrixColorFilter(fArr3);
    }

    public bo(Resources resources, Bitmap bitmap, boolean z16, boolean z17) {
        super(resources, bitmap);
        this.f316758a = 1.0f;
        this.f316759b = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        if (z17) {
            a(f316751f, f316753h);
        }
        if (z16) {
            a(StateSet.WILD_CARD, f316755j);
        }
    }

    private ColorFilter b(int[] iArr) {
        ArrayList<int[]> arrayList = this.f316760c;
        if (arrayList == null) {
            return null;
        }
        int size = this.f316761d.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (StateSet.stateSetMatches(arrayList.get(i3), iArr)) {
                return this.f316761d.get(i3);
            }
        }
        return null;
    }

    public int a(int[] iArr, ColorFilter colorFilter) {
        if (this.f316760c == null) {
            this.f316760c = new ArrayList<>();
            this.f316761d = new ArrayList<>();
        }
        this.f316760c.add(iArr);
        this.f316761d.add(colorFilter);
        return this.f316761d.size();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorFilter b16 = b(iArr);
        if (this.f316762e != b16) {
            this.f316762e = b16;
            setColorFilter(b16);
            return true;
        }
        return false;
    }
}
