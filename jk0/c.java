package jk0;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.TextUtils;
import com.tencent.ecommerce.richtext.ui.dom.style.o;
import com.tencent.ecommerce.richtext.ui.view.VTextView;
import com.tencent.ecommerce.richtext.utils.e;
import ik0.d;
import lk0.f;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends ik0.c<VTextView> implements f {
    public c(fk0.c cVar, lk0.b bVar, d dVar) {
        super(cVar, bVar, dVar);
    }

    private void R(lk0.b bVar) {
        if (bVar instanceof lk0.d) {
            ((lk0.d) bVar).d1(this);
        }
    }

    private void S(Object obj) {
        Layout d16;
        VTextView n3 = n();
        if (n3 == null || (d16 = n3.d()) == null) {
            return;
        }
        String p16 = e.p(obj, null);
        if (TextUtils.isEmpty(p16)) {
            return;
        }
        d16.getPaint().setColor(e.g(p16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ik0.c
    public boolean M(String str, Object obj) {
        if ("color".equals(str)) {
            S(obj);
            return true;
        }
        return super.M(str, obj);
    }

    @Override // ik0.c
    public void O(Object obj) {
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            if (n() != null && !obj.equals(n().d())) {
                n().setRichText(((lk0.d) this.f407893d).a1(), ((lk0.d) this.f407893d).U0());
                o m3 = this.f407893d.m();
                n().setTextLayout(layout, m3.a(0), m3.a(1));
                n().invalidate();
            }
        }
    }

    @Override // ik0.c
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public VTextView q(@NonNull Context context) {
        VTextView vTextView = new VTextView(context);
        vTextView.a(this);
        R(this.f407893d);
        return vTextView;
    }

    @Override // lk0.f
    public void onLoadFinish(boolean z16) {
        if (n() != null) {
            n().postInvalidate();
        }
    }
}
