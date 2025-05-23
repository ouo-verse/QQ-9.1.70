package e15;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends a {
    public c(String str, View view) {
        super(str, view);
    }

    @Override // e15.a
    protected void v(String str) {
        ((ImageView) this.f395367e).setBackgroundColor(Color.parseColor(str));
    }
}
