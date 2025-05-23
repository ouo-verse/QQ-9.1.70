package jk0;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import com.tencent.ecommerce.richtext.ui.view.VFrameLayout;
import com.tencent.ecommerce.richtext.utils.e;
import ik0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends d<VFrameLayout> {

    /* renamed from: m, reason: collision with root package name */
    private int f410310m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f410311n;

    public a(fk0.c cVar, lk0.b bVar, d dVar) {
        super(cVar, bVar, dVar);
        this.f410310m = 0;
        this.f410311n = false;
    }

    @Override // ik0.d, ik0.c
    public boolean M(String str, Object obj) {
        String p16 = e.p(obj, null);
        if (p16 != null) {
            str.hashCode();
            if (str.equals("highlightBackgroundColor")) {
                this.f410311n = true;
                this.f410310m = com.tencent.ecommerce.richtext.utils.a.c(p16);
                return true;
            }
        }
        return super.M(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ik0.c
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public VFrameLayout q(@NonNull Context context) {
        VFrameLayout vFrameLayout = new VFrameLayout(context);
        vFrameLayout.a(this);
        return vFrameLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ik0.c
    public void y() {
        if (!this.f410311n) {
            super.y();
            return;
        }
        if (n() != 0) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(this.f410310m));
            com.tencent.ecommerce.richtext.ui.dom.style.b bVar = this.f407895f;
            if (bVar != null) {
                stateListDrawable.addState(new int[0], bVar);
            }
            ((VFrameLayout) n()).setBackground(stateListDrawable);
            ((VFrameLayout) n()).setClickable(true);
        }
    }
}
