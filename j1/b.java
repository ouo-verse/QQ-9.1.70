package j1;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f409060a;

    /* renamed from: b, reason: collision with root package name */
    private final float f409061b;

    public b(float f16, @NonNull c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f409060a;
            f16 += ((b) cVar).f409061b;
        }
        this.f409060a = cVar;
        this.f409061b = f16;
    }

    @Override // j1.c
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f409060a.a(rectF) + this.f409061b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f409060a.equals(bVar.f409060a) && this.f409061b == bVar.f409061b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f409060a, Float.valueOf(this.f409061b)});
    }
}
