package e0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h0.k;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class c<T> implements h<T> {

    /* renamed from: d, reason: collision with root package name */
    private final int f395281d;

    /* renamed from: e, reason: collision with root package name */
    private final int f395282e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.request.c f395283f;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // e0.h
    public final void a(@NonNull g gVar) {
        gVar.onSizeReady(this.f395281d, this.f395282e);
    }

    @Override // e0.h
    @Nullable
    public final com.bumptech.glide.request.c getRequest() {
        return this.f395283f;
    }

    @Override // e0.h
    public final void h(@Nullable com.bumptech.glide.request.c cVar) {
        this.f395283f = cVar;
    }

    public c(int i3, int i16) {
        if (k.s(i3, i16)) {
            this.f395281d = i3;
            this.f395282e = i16;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i3 + " and height: " + i16);
    }

    @Override // b0.f
    public void onDestroy() {
    }

    @Override // b0.f
    public void onStart() {
    }

    @Override // b0.f
    public void onStop() {
    }

    @Override // e0.h
    public final void c(@NonNull g gVar) {
    }

    @Override // e0.h
    public void e(@Nullable Drawable drawable) {
    }

    @Override // e0.h
    public void f(@Nullable Drawable drawable) {
    }
}
