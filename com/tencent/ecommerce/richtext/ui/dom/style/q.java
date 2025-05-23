package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q extends a {
    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void m() {
        if (k()) {
            q(c().width() - ((d() * 2.0f) - (e() / 2.0f)));
            s(f() / 2.0f);
            r(c().width() - (e() / 2.0f));
            p((d() * 2.0f) - (f() / 2.0f));
            return;
        }
        q(c().width() - (d() * 1.5f));
        s(d() / 2.0f);
        r(c().width() - (d() / 2.0f));
        p(d() * 1.5f);
    }

    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void n() {
        if (l()) {
            v(c().width() - d());
            w(f() / 2.0f);
            t(c().width() - (e() / 2.0f));
            u(d());
            return;
        }
        float width = c().width() - (e() / 2.0f);
        float f16 = f() / 2.0f;
        v(width);
        w(f16);
        t(width);
        u(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(float f16, float f17, float f18, @NonNull RectF rectF) {
        o(f16, f17, f18, rectF, 315.0f);
    }
}
