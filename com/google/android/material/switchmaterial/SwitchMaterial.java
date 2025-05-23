package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import c1.a;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: i, reason: collision with root package name */
    private static final int f34224i = 2131953435;

    /* renamed from: m, reason: collision with root package name */
    private static final int[][] f34225m = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final a f34226d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private ColorStateList f34227e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private ColorStateList f34228f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f34229h;

    public SwitchMaterial(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList a() {
        if (this.f34227e == null) {
            int d16 = z0.a.d(this, com.tencent.mobileqq.R.attr.a8g);
            int d17 = z0.a.d(this, com.tencent.mobileqq.R.attr.a7o);
            float dimension = getResources().getDimension(com.tencent.mobileqq.R.dimen.cvx);
            if (this.f34226d.e()) {
                dimension += ViewUtils.h(this);
            }
            int c16 = this.f34226d.c(d16, dimension);
            int[][] iArr = f34225m;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = z0.a.h(d16, d17, 1.0f);
            iArr2[1] = c16;
            iArr2[2] = z0.a.h(d16, d17, 0.38f);
            iArr2[3] = c16;
            this.f34227e = new ColorStateList(iArr, iArr2);
        }
        return this.f34227e;
    }

    private ColorStateList b() {
        if (this.f34228f == null) {
            int[][] iArr = f34225m;
            int[] iArr2 = new int[iArr.length];
            int d16 = z0.a.d(this, com.tencent.mobileqq.R.attr.a8g);
            int d17 = z0.a.d(this, com.tencent.mobileqq.R.attr.a7o);
            int d18 = z0.a.d(this, com.tencent.mobileqq.R.attr.f155473a82);
            iArr2[0] = z0.a.h(d16, d17, 0.54f);
            iArr2[1] = z0.a.h(d16, d18, 0.32f);
            iArr2[2] = z0.a.h(d16, d17, 0.12f);
            iArr2[3] = z0.a.h(d16, d18, 0.12f);
            this.f34228f = new ColorStateList(iArr, iArr2);
        }
        return this.f34228f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f34229h && getThumbTintList() == null) {
            setThumbTintList(a());
        }
        if (this.f34229h && getTrackTintList() == null) {
            setTrackTintList(b());
        }
    }

    public void setUseMaterialThemeColors(boolean z16) {
        this.f34229h = z16;
        if (z16) {
            setThumbTintList(a());
            setTrackTintList(b());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.s_);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f34224i;
        Context context2 = getContext();
        this.f34226d = new a(context2);
        TypedArray h16 = o.h(context2, attributeSet, w0.a.f444015r8, i3, i16, new int[0]);
        this.f34229h = h16.getBoolean(w0.a.f444027s8, false);
        h16.recycle();
    }
}
