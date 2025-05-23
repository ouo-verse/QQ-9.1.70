package dh0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f393825a;

    /* renamed from: b, reason: collision with root package name */
    private int f393826b;

    /* renamed from: c, reason: collision with root package name */
    private int f393827c;

    /* renamed from: d, reason: collision with root package name */
    private int f393828d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f393829e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f393830f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f393831g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f393832h;

    public b(Context context, int i3, int i16, int i17, ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, boolean z16) {
        this.f393825a = context;
        this.f393826b = i3;
        this.f393827c = i16;
        this.f393828d = i17;
        this.f393832h = z16;
        this.f393829e = colorStateList;
        this.f393830f = colorStateList2;
        this.f393831g = colorStateList3;
    }

    private Drawable a(int i3, int i16, boolean z16) {
        return new ClipDrawable(c(i3, i16, z16), 3, 1);
    }

    private Drawable b(int i3, int i16) {
        return new ClipDrawable(d(i3, i16), 3, 1);
    }

    private Drawable d(int i3, int i16) {
        d dVar = new d(AppCompatResources.getDrawable(this.f393825a, i3));
        dVar.mutate();
        if (i16 != -1) {
            dVar.setTint(i16);
        }
        return dVar;
    }

    private int f(int i3) {
        TypedArray obtainStyledAttributes = this.f393825a.obtainStyledAttributes(new int[]{i3});
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ColorStateList e() {
        return this.f393829e;
    }

    public ColorStateList h() {
        return this.f393830f;
    }

    public ColorStateList i() {
        return this.f393831g;
    }

    public int j() {
        return this.f393826b;
    }

    public Drawable[] g() {
        return new Drawable[]{c(this.f393827c, R.attr.colorControlHighlight, this.f393832h), b(this.f393828d, 0), a(this.f393828d, R.attr.colorControlActivated, this.f393832h)};
    }

    private Drawable c(int i3, int i16, boolean z16) {
        return d(i3, !z16 ? f(i16) : -1);
    }
}
