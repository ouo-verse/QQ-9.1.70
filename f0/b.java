package f0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import f0.d;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements d<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f397482a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f397483b;

    public b(int i3, boolean z16) {
        this.f397482a = i3;
        this.f397483b = z16;
    }

    @Override // f0.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, d.a aVar) {
        Drawable currentDrawable = aVar.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f397483b);
        transitionDrawable.startTransition(this.f397482a);
        aVar.d(transitionDrawable);
        return true;
    }
}
