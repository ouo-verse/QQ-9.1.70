package a0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final r.d f25295a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f25296b;

    /* renamed from: c, reason: collision with root package name */
    private final e<z.c, byte[]> f25297c;

    public c(@NonNull r.d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<z.c, byte[]> eVar2) {
        this.f25295a = dVar;
        this.f25296b = eVar;
        this.f25297c = eVar2;
    }

    @Override // a0.e
    @Nullable
    public q<byte[]> a(@NonNull q<Drawable> qVar, @NonNull com.bumptech.glide.load.e eVar) {
        Drawable drawable = qVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f25296b.a(com.bumptech.glide.load.resource.bitmap.e.b(((BitmapDrawable) drawable).getBitmap(), this.f25295a), eVar);
        }
        if (drawable instanceof z.c) {
            return this.f25297c.a(b(qVar), eVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static q<z.c> b(@NonNull q<Drawable> qVar) {
        return qVar;
    }
}
