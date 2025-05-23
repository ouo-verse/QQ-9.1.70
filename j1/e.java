package j1;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final float f409062a;

    public e(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f409062a = f16;
    }

    @Override // j1.c
    public float a(@NonNull RectF rectF) {
        return this.f409062a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof e) && this.f409062a == ((e) obj).f409062a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f409062a)});
    }
}
