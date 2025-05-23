package com.tencent.libra.cache;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: a, reason: collision with root package name */
    protected final T f118633a;

    public a(T t16) {
        this.f118633a = t16;
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f118633a.getConstantState();
        if (constantState == null) {
            return this.f118633a;
        }
        return (T) constantState.newDrawable();
    }

    @Override // com.tencent.libra.cache.Initializable
    public void initialize() {
        T t16 = this.f118633a;
        if (t16 instanceof BitmapDrawable) {
            ((BitmapDrawable) t16).getBitmap().prepareToDraw();
        }
    }
}
