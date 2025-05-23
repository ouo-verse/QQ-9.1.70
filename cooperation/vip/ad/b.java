package cooperation.vip.ad;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends Scroller {

    /* renamed from: a, reason: collision with root package name */
    public int f391157a;

    public b(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f391157a = 1500;
    }

    public void a(int i3) {
        this.f391157a = i3;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18) {
        startScroll(i3, i16, i17, i18, this.f391157a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i3, int i16, int i17, int i18, int i19) {
        super.startScroll(i3, i16, i17, i18, this.f391157a);
    }
}
