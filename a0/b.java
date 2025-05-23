package a0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.resource.bitmap.y;
import h0.j;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f25294a;

    public b(@NonNull Resources resources) {
        this.f25294a = (Resources) j.d(resources);
    }

    @Override // a0.e
    @Nullable
    public q<BitmapDrawable> a(@NonNull q<Bitmap> qVar, @NonNull com.bumptech.glide.load.e eVar) {
        return y.b(this.f25294a, qVar);
    }
}
