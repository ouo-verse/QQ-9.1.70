package ik0;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class d<T extends ViewGroup> extends c<T> {

    /* renamed from: k, reason: collision with root package name */
    private String f407900k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<c> f407901l;

    public d(fk0.c cVar, lk0.b bVar, d dVar) {
        super(cVar, bVar, dVar);
        this.f407901l = new ArrayList<>();
    }

    @Override // ik0.c
    public boolean M(String str, Object obj) {
        if (e.p(obj, null) != null) {
            str.hashCode();
            if (str.equals("overflow")) {
                String p16 = e.p(obj, null);
                this.f407900k = p16;
                if (!TextUtils.isEmpty(p16) && this.f407890a != 0) {
                    a0(this.f407900k);
                    return true;
                }
                return true;
            }
        }
        return super.M(str, obj);
    }

    public void Q(c cVar) {
        R(cVar, -1);
    }

    public void R(c cVar, int i3) {
        System.nanoTime();
        if (cVar != null && i3 >= -1) {
            if (i3 >= this.f407901l.size()) {
                i3 = -1;
            }
            if (i3 == -1) {
                this.f407901l.add(cVar);
            } else {
                this.f407901l.add(i3, cVar);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void S(View view, int i3) {
        if (view != null && p() != null) {
            if (i3 >= p().getChildCount()) {
                i3 = -1;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            p().addView(view, i3);
        }
    }

    public void T(int i3) {
        U(null, i3);
    }

    public void U(Context context, int i3) {
        Pair<c, Integer> Z = Z(i3);
        Object obj = Z.first;
        if (obj != null) {
            c cVar = (c) obj;
            if (context != null) {
                cVar.h(context);
            } else {
                cVar.g();
            }
            if (!cVar.v()) {
                S(cVar.n(), ((Integer) Z.second).intValue());
            }
        }
    }

    @Nullable
    public c V(int i3) {
        ArrayList<c> arrayList = this.f407901l;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            return this.f407901l.get(i3);
        }
        return null;
    }

    public int W() {
        return this.f407901l.size();
    }

    public ViewGroup.LayoutParams X(c cVar, View view, int i3, int i16, int i17, int i18, int i19, int i26) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i16);
            layoutParams2.setMargins(i17, i19, i18, i26);
            return layoutParams2;
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(i17, i19, i18, i26);
            return layoutParams;
        }
        return layoutParams;
    }

    @Override // ik0.c
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public ViewGroup p() {
        return (ViewGroup) super.p();
    }

    protected Pair<c, Integer> Z(int i3) {
        if (i3 < 0) {
            i3 = W() - 1;
        }
        if (i3 < 0) {
            return new Pair<>(null, Integer.valueOf(i3));
        }
        return new Pair<>(V(i3), Integer.valueOf(i3));
    }

    public void a0(String str) {
        if (str.equals(NodeProps.VISIBLE)) {
            ((ViewGroup) this.f407890a).setClipToPadding(false);
            ((ViewGroup) this.f407890a).setClipChildren(false);
        } else if (str.equals("hidden")) {
            ((ViewGroup) this.f407890a).setClipToPadding(true);
            ((ViewGroup) this.f407890a).setClipChildren(true);
        }
    }

    @Override // ik0.c
    public void b() {
        if (!t()) {
            super.b();
            int W = W();
            for (int i3 = 0; i3 < W; i3++) {
                c V = V(i3);
                if (V != null) {
                    V.b();
                }
            }
        }
    }

    @Override // ik0.c
    public void d() {
        if (!t()) {
            super.d();
            int W = W();
            for (int i3 = 0; i3 < W; i3++) {
                c V = V(i3);
                if (V != null) {
                    V.d();
                }
            }
        }
    }

    @Override // ik0.c
    public void i() {
        super.i();
        int W = W();
        for (int i3 = 0; i3 < W; i3++) {
            T(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ik0.c
    public void j(Context context) {
        super.j(context);
        int W = W();
        for (int i3 = 0; i3 < W; i3++) {
            U(context, i3);
        }
    }
}
