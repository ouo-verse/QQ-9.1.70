package l61;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements XPanelContainer.g {

    /* renamed from: d, reason: collision with root package name */
    private Context f413885d;

    /* renamed from: e, reason: collision with root package name */
    private XPanelContainer f413886e;

    /* renamed from: f, reason: collision with root package name */
    private SparseArrayCompat<e<? extends View>> f413887f = new SparseArrayCompat<>();

    /* renamed from: h, reason: collision with root package name */
    private List<c> f413888h = new ArrayList();

    public d(Context context) {
        this.f413885d = context;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
        for (int i3 = 0; i3 < this.f413887f.size(); i3++) {
            SparseArrayCompat<e<? extends View>> sparseArrayCompat = this.f413887f;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i3)).E();
        }
        Iterator<c> it = this.f413888h.iterator();
        while (it.hasNext()) {
            it.next().E();
        }
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int i3) {
        e<? extends View> eVar = this.f413887f.get(i3);
        if (eVar != null) {
            return eVar.c(this.f413885d);
        }
        c(false);
        return null;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int i3) {
        e<? extends View> eVar = this.f413887f.get(i3);
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public XPanelContainer a() {
        return this.f413886e;
    }

    public <T extends e<? extends View>> T b(int i3) {
        return (T) this.f413887f.get(i3);
    }

    public void c(boolean z16) {
        XPanelContainer xPanelContainer = this.f413886e;
        if (xPanelContainer != null) {
            xPanelContainer.t(z16);
        }
    }

    public void d(e<? extends View> eVar) {
        if (eVar != null) {
            this.f413887f.put(eVar.a(), eVar);
        }
    }

    public void e(XPanelContainer xPanelContainer) {
        this.f413886e = xPanelContainer;
    }

    public void f(int i3, boolean z16) {
        XPanelContainer xPanelContainer = this.f413886e;
        if (xPanelContainer != null) {
            xPanelContainer.O(i3, z16);
        }
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int i3, int i16) {
        for (int i17 = 0; i17 < this.f413887f.size(); i17++) {
            SparseArrayCompat<e<? extends View>> sparseArrayCompat = this.f413887f;
            sparseArrayCompat.get(sparseArrayCompat.keyAt(i17)).onPanelChanged(i3, i16);
        }
        Iterator<c> it = this.f413888h.iterator();
        while (it.hasNext()) {
            it.next().onPanelChanged(i3, i16);
        }
    }
}
