package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.widget.SwipRightMenuBuilder;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f302574b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f302575c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f302576d;

    /* renamed from: a, reason: collision with root package name */
    protected SwipRightMenuBuilder f302577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends f {
        static IPatchRedirector $redirector_;

        a(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, j.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                return;
            }
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length != 2) {
                    return;
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj2;
                    if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0 && zArr.length == 3) {
                        if (swipRightMenuItemArr.length > 0 && zArr[0]) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                            swipRightMenuItem.menuId = 0;
                            swipRightMenuItem.menuType = 0;
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        if (i16 < swipRightMenuItemArr.length && zArr[1]) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                            swipRightMenuItem2.menuId = 1;
                            swipRightMenuItem2.menuType = 1;
                            i16++;
                        }
                        if (i16 < swipRightMenuItemArr.length && zArr[2]) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem3 = swipRightMenuItemArr[i16];
                            swipRightMenuItem3.menuId = 2;
                            swipRightMenuItem3.menuType = 0;
                            i16++;
                        }
                        while (i16 < swipRightMenuItemArr.length) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem4 = swipRightMenuItemArr[i16];
                            swipRightMenuItem4.menuId = -1;
                            swipRightMenuItem4.menuType = -1;
                            i16++;
                        }
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f302574b = new int[]{R.string.epx, R.string.epy, R.string.epw};
        f302575c = new int[]{R.drawable.cjb, R.drawable.cjb, R.drawable.cja};
        f302576d = new int[]{R.id.k28, R.id.k29, R.id.k27};
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public SwipRightMenuBuilder a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SwipRightMenuBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return new a(3, 2, new int[]{context.getResources().getDimensionPixelSize(R.dimen.atw), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, f302576d, f302574b, f302575c);
    }

    public final View b(Context context, int i3, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), swipItemBaseHolder);
        }
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        if (this.f302577a == null) {
            this.f302577a = a(context);
        }
        return this.f302577a.createView(context, inflate, swipItemBaseHolder, -1);
    }

    public void c(Context context, View view, Object obj, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, view, obj, swipItemBaseHolder, onClickListener);
            return;
        }
        SwipRightMenuBuilder swipRightMenuBuilder = this.f302577a;
        if (swipRightMenuBuilder != null) {
            swipRightMenuBuilder.updateRightMenuView(context, view, 0, obj, swipItemBaseHolder, onClickListener);
        }
    }
}
