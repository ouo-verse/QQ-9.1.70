package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.os.Bundle;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.helper.ah;
import com.tencent.mobileqq.activity.aio.helper.q;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOShortcutBarLogic implements d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f179845a = false;

    /* renamed from: b, reason: collision with root package name */
    private AIOShortcutBarHelper f179846b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<b> f179847c;

    /* renamed from: d, reason: collision with root package name */
    private a f179848d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, List<AIOShortcutBarHelper.b>> f179849e;

    public AIOShortcutBarLogic(AIOShortcutBarHelper aIOShortcutBarHelper) {
        this.f179846b = aIOShortcutBarHelper;
    }

    private void d(int i3, Bundle bundle) {
        SparseArray<b> sparseArray = this.f179847c;
        if (sparseArray != null && sparseArray.size() != 0) {
            for (int i16 = 0; i16 < this.f179847c.size(); i16++) {
                b valueAt = this.f179847c.valueAt(i16);
                if (valueAt != null) {
                    valueAt.c(i3, bundle);
                }
            }
        }
    }

    private boolean e(int i3) {
        b h16;
        if (i3 == 0 || (h16 = h(i3)) == null || h16.getView() == null) {
            return false;
        }
        return true;
    }

    private b g(int i3) {
        b bVar;
        View view;
        b bVar2 = null;
        int i16 = 0;
        for (int i17 = 0; i17 < this.f179847c.size(); i17++) {
            int keyAt = this.f179847c.keyAt(i17);
            if (keyAt != i3 && (bVar = this.f179847c.get(keyAt)) != null && (view = bVar.getView()) != null && view.getVisibility() == 0 && (i16 == 0 || i16 > keyAt)) {
                i16 = keyAt;
                bVar2 = bVar;
            }
        }
        return bVar2;
    }

    private b h(int i3) {
        SparseArray<b> sparseArray = this.f179847c;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i3);
    }

    private void i(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOShortcutBarLogic", 2, "initCache aioType: " + i3);
        }
        if (this.f179847c == null) {
            this.f179847c = new SparseArray<>();
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 5) {
                    l();
                }
            } else {
                k();
            }
        } else {
            j();
        }
        for (int i16 = 0; i16 < this.f179847c.size(); i16++) {
            this.f179847c.valueAt(i16).b(this);
        }
    }

    private void j() {
        this.f179847c.append(1, new q());
    }

    private void k() {
        this.f179847c.append(2, new ah());
    }

    private void l() {
        this.f179847c.append(1, new q());
    }

    private void n() {
        Map<Integer, List<AIOShortcutBarHelper.b>> map = this.f179849e;
        if (map != null) {
            map.clear();
        }
        SparseArray<b> sparseArray = this.f179847c;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d
    public a a() {
        AIOShortcutBarHelper aIOShortcutBarHelper;
        if (this.f179848d == null && (aIOShortcutBarHelper = this.f179846b) != null) {
            this.f179848d = new a(aIOShortcutBarHelper);
        }
        return this.f179848d;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d
    public boolean b(int i3) {
        View view;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        if (!e(i3)) {
            return false;
        }
        View view2 = h(i3).getView();
        if (this.f179846b.A() != i3) {
            view2.setVisibility(8);
            return false;
        }
        if (this.f179845a) {
            this.f179845a = false;
        }
        this.f179846b.M(8);
        m(i3, 8);
        b g16 = g(this.f179846b.A());
        if (g16 != null) {
            i16 = g16.getPriority();
            view = g16.getView();
            layoutParams = g16.getParams();
        } else {
            view = null;
            i16 = 0;
            layoutParams = null;
        }
        if (i16 != 0 && view != null) {
            this.f179846b.L(i16, view, layoutParams);
            m(i16, 0);
            return true;
        }
        this.f179846b.J();
        this.f179846b.K();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d
    public boolean c(int i3) {
        if (!e(i3)) {
            return false;
        }
        b h16 = h(i3);
        if (this.f179845a && i3 != this.f179846b.A()) {
            this.f179846b.H(h16.getView());
            h16.getView().setVisibility(0);
            return false;
        }
        int A = this.f179846b.A();
        if (A <= i3 && A != 0) {
            if (A == i3 && this.f179846b.B() != 0) {
                this.f179846b.M(0);
                this.f179846b.N();
                this.f179846b.O();
                m(i3, 0);
                return true;
            }
            if (this.f179846b.B() != 0) {
                this.f179846b.L(i3, h16.getView(), h16.getParams());
                this.f179846b.M(0);
                m(i3, 0);
                return true;
            }
            h16.getView().setVisibility(0);
            return false;
        }
        this.f179846b.L(i3, h16.getView(), h16.getParams());
        this.f179846b.M(0);
        m(i3, 0);
        return true;
    }

    public void f(int i3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOShortcutBarLogic", 2, "disPatchChatPieEvent event: " + i3 + ", bundle\uff1a" + bundle.toString());
        }
        SparseArray<b> sparseArray = this.f179847c;
        if ((sparseArray == null || sparseArray.size() == 0) && i3 != 4 && i3 != 5) {
            i(this.f179846b.e());
        }
        d(i3, bundle);
        if (i3 == 4) {
            n();
        }
    }

    public void m(int i3, final int i16) {
        final List<AIOShortcutBarHelper.b> list;
        Map<Integer, List<AIOShortcutBarHelper.b>> map = this.f179849e;
        if (map == null || (list = map.get(Integer.valueOf(i3))) == null) {
            return;
        }
        com.tencent.qav.thread.a.d().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarLogic.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((AIOShortcutBarHelper.b) it.next()).onVisibilityChanged(i16);
                }
            }
        }, 50L);
    }

    public void o(Spanned spanned) {
        if (this.f179847c == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f179847c.size(); i3++) {
            b valueAt = this.f179847c.valueAt(i3);
            if (valueAt != null) {
                valueAt.a(spanned);
            }
        }
    }
}
