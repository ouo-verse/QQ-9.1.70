package e0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e0.e
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void n(@Nullable Drawable drawable) {
        ((ImageView) this.f395285d).setImageDrawable(drawable);
    }
}
