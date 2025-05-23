package j1;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f409059a;

    public a(float f16) {
        this.f409059a = f16;
    }

    @Override // j1.c
    public float a(@NonNull RectF rectF) {
        return this.f409059a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && this.f409059a == ((a) obj).f409059a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f409059a)});
    }
}
