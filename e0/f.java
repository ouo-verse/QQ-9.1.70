package e0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class f {
    @NonNull
    public <Z> i<ImageView, Z> a(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new d(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
