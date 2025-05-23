package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class p extends a {
    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void m() {
        if (k()) {
            q(f() / 2.0f);
            s(e() / 2.0f);
            r((d() * 2.0f) - (f() / 2.0f));
            p((d() * 2.0f) - (e() / 2.0f));
            return;
        }
        q(d() / 2.0f);
        s(d() / 2.0f);
        r(d() * 1.5f);
        p(d() * 1.5f);
    }

    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void n() {
        if (l()) {
            v(f() / 2.0f);
            w(d());
            t(d());
            u(e() / 2.0f);
            return;
        }
        float f16 = f() / 2.0f;
        float e16 = e() / 2.0f;
        v(f16);
        w(e16);
        t(f16);
        u(e16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(float f16, float f17, float f18, @NonNull RectF rectF) {
        o(f16, f17, f18, rectF, 225.0f);
    }
}
