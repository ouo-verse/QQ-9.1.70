package com.tencent.libra.extension.gif;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final GifInfoHandle f118746a;

    public b(@NonNull f fVar) throws IOException {
        this(fVar, null);
    }

    private void a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (bitmap.getWidth() >= this.f118746a.o() && bitmap.getHeight() >= this.f118746a.n()) {
                if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                    return;
                }
                throw new IllegalArgumentException("Only Config.ARGB_8888 is supported. Current bitmap config: " + bitmap.getConfig());
            }
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
        throw new IllegalArgumentException("Bitmap is recycled");
    }

    public int b(@IntRange(from = 0) int i3) {
        return this.f118746a.g(i3);
    }

    public int c() {
        return this.f118746a.h();
    }

    public int d() {
        return this.f118746a.m();
    }

    public int e() {
        return this.f118746a.q();
    }

    public void f(@IntRange(from = 0, to = 2147483647L) int i3, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.f118746a.C(i3, bitmap);
    }

    public b(@NonNull f fVar, @Nullable c cVar) throws IOException {
        this.f118746a = fVar.a();
    }
}
