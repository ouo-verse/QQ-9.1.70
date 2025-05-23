package g0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import h0.j;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: b, reason: collision with root package name */
    private final Object f401019b;

    public b(@NonNull Object obj) {
        this.f401019b = j.d(obj);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f401019b.toString().getBytes(c.f31560a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f401019b.equals(((b) obj).f401019b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f401019b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f401019b + '}';
    }
}
