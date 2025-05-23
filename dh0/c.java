package dh0;

import android.R;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends LayerDrawable {
    public c(b bVar) {
        super(bVar.g());
        setId(0, R.id.background);
        setId(1, R.id.secondaryProgress);
        setId(2, R.id.progress);
        c(bVar);
    }

    private d a(int i3) {
        Drawable findDrawableByLayerId = findDrawableByLayerId(i3);
        if (i3 == 16908288) {
            return (d) findDrawableByLayerId;
        }
        if (i3 != 16908301 && i3 != 16908303) {
            throw new RuntimeException();
        }
        return (d) ((ClipDrawable) findDrawableByLayerId).getDrawable();
    }

    private void c(b bVar) {
        d a16 = a(R.id.background);
        d a17 = a(R.id.secondaryProgress);
        d a18 = a(R.id.progress);
        a16.e(bVar.j());
        a17.e(bVar.j());
        a18.e(bVar.j());
        if (bVar.e() != null) {
            a16.setTintList(bVar.e());
        }
        if (bVar.h() != null) {
            a17.setTintList(bVar.h());
        }
        if (bVar.i() != null) {
            a18.setTintList(bVar.i());
        }
    }

    public void d(int i3) {
        a(R.id.background).e(i3);
        a(R.id.secondaryProgress).e(i3);
        a(R.id.progress).e(i3);
    }

    public float b() {
        Drawable d16 = a(R.id.progress).d();
        return d16.getIntrinsicWidth() / d16.getIntrinsicHeight();
    }
}
