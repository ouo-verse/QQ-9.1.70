package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    private float f33876c;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private g1.d f33879f;

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f33874a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final g1.f f33875b = new a();

    /* renamed from: d, reason: collision with root package name */
    private boolean f33877d = true;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private WeakReference<b> f33878e = new WeakReference<>(null);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends g1.f {
        a() {
        }

        @Override // g1.f
        public void a(int i3) {
            l.this.f33877d = true;
            b bVar = (b) l.this.f33878e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // g1.f
        public void b(@NonNull Typeface typeface, boolean z16) {
            if (!z16) {
                l.this.f33877d = true;
                b bVar = (b) l.this.f33878e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public l(@Nullable b bVar) {
        g(bVar);
    }

    private float c(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f33874a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public g1.d d() {
        return this.f33879f;
    }

    @NonNull
    public TextPaint e() {
        return this.f33874a;
    }

    public float f(String str) {
        if (!this.f33877d) {
            return this.f33876c;
        }
        float c16 = c(str);
        this.f33876c = c16;
        this.f33877d = false;
        return c16;
    }

    public void g(@Nullable b bVar) {
        this.f33878e = new WeakReference<>(bVar);
    }

    public void h(@Nullable g1.d dVar, Context context) {
        if (this.f33879f != dVar) {
            this.f33879f = dVar;
            if (dVar != null) {
                dVar.o(context, this.f33874a, this.f33875b);
                b bVar = this.f33878e.get();
                if (bVar != null) {
                    this.f33874a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f33874a, this.f33875b);
                this.f33877d = true;
            }
            b bVar2 = this.f33878e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z16) {
        this.f33877d = z16;
    }

    public void j(Context context) {
        this.f33879f.n(context, this.f33874a, this.f33875b);
    }
}
