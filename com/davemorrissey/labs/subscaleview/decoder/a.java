package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends T> f32580a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap.Config f32581b;

    public a(@NonNull Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.b
    @NonNull
    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.f32581b == null) {
            return this.f32580a.newInstance();
        }
        return this.f32580a.getConstructor(Bitmap.Config.class).newInstance(this.f32581b);
    }

    public a(@NonNull Class<? extends T> cls, Bitmap.Config config) {
        this.f32580a = cls;
        this.f32581b = config;
    }
}
