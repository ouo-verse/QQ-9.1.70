package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends a {
    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void m() {
        if (k()) {
            q(e() / 2.0f);
            s(c().height() - ((d() * 2.0f) - (f() / 2.0f)));
            r((d() * 2.0f) - (e() / 2.0f));
            p(c().height() - (f() / 2.0f));
            return;
        }
        q(d() / 2.0f);
        s(c().height() - (d() * 1.5f));
        r(d() * 1.5f);
        p(c().height() - (d() / 2.0f));
    }

    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void n() {
        if (l()) {
            v(d());
            w(c().height() - (f() / 2.0f));
            t(e() / 2.0f);
            u(c().height() - d());
            return;
        }
        float e16 = e() / 2.0f;
        float height = c().height() - (f() / 2.0f);
        v(e16);
        w(height);
        t(e16);
        u(height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(float f16, float f17, float f18, @NonNull RectF rectF) {
        o(f16, f17, f18, rectF, 135.0f);
    }
}
