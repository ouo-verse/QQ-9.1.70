package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.RectF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends a {
    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void m() {
        if (k()) {
            q(c().width() - ((d() * 2.0f) - (f() / 2.0f)));
            s(c().height() - ((d() * 2.0f) - (e() / 2.0f)));
            r(c().width() - (f() / 2.0f));
            p(c().height() - (e() / 2.0f));
            return;
        }
        q(c().width() - (d() * 1.5f));
        s(c().height() - (d() * 1.5f));
        r(c().width() - (d() / 2.0f));
        p(c().height() - (d() / 2.0f));
    }

    @Override // com.tencent.ecommerce.richtext.ui.dom.style.a
    protected void n() {
        if (l()) {
            v(c().width() - (f() / 2.0f));
            w(c().height() - d());
            t(c().width() - d());
            u(c().height() - (e() / 2.0f));
            return;
        }
        float width = c().width() - (f() / 2.0f);
        float height = c().height() - (e() / 2.0f);
        v(width);
        w(height);
        t(width);
        u(height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(float f16, float f17, float f18, @NonNull RectF rectF) {
        o(f16, f17, f18, rectF, 45.0f);
    }
}
