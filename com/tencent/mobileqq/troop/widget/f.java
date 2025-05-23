package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class f extends SwipRightMenuBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final int[] f302521a;

    /* renamed from: b, reason: collision with root package name */
    protected final int[] f302522b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f302523c;

    /* renamed from: d, reason: collision with root package name */
    protected final int[] f302524d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f302525e;

    public f(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            return;
        }
        this.f302524d = iArr;
        this.f302525e = i17;
        this.f302521a = iArr2;
        this.f302522b = iArr3;
        this.f302523c = iArr4;
    }

    @Override // com.tencent.widget.SwipRightMenuBuilder
    public View createRightMenuItem(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
        SimpleTextView simpleTextView = new SimpleTextView(context);
        simpleTextView.setLayoutParams(new LinearLayout.LayoutParams(this.f302524d[i3], this.f302525e));
        simpleTextView.setGravity(17);
        simpleTextView.setTextSize(16.0f);
        simpleTextView.setTextColor(-1);
        return simpleTextView;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    @Override // com.tencent.widget.SwipRightMenuBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View updateRightMenuItem(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener) {
        com.tencent.mobileqq.troop.data.n nVar;
        int i16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, swipRightMenuItem, onClickListener);
        }
        SimpleTextView simpleTextView = null;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[1];
                if (obj2 instanceof com.tencent.mobileqq.troop.data.n) {
                    nVar = (com.tencent.mobileqq.troop.data.n) obj2;
                    if (swipRightMenuItem != null && swipRightMenuItem.menuType >= 0 && (i16 = swipRightMenuItem.menuId) >= 0 && nVar != null) {
                        view = swipRightMenuItem.menuView;
                        if (view instanceof SimpleTextView) {
                            simpleTextView = (SimpleTextView) view;
                        }
                        if (simpleTextView != null) {
                            int i17 = this.f302522b[i16];
                            int i18 = this.f302523c[i16];
                            int i19 = this.f302521a[i16];
                            simpleTextView.setVisibility(0);
                            simpleTextView.setText(simpleTextView.getContext().getResources().getString(i17));
                            simpleTextView.setBackgroundResource(i18);
                            simpleTextView.setId(i19);
                            simpleTextView.setTag(nVar);
                            simpleTextView.setContentDescription(simpleTextView.getResources().getString(i17));
                            simpleTextView.setOnClickListener(onClickListener);
                            simpleTextView.requestLayout();
                            swipRightMenuItem.menuWidth = this.f302524d[swipRightMenuItem.menuType];
                            swipRightMenuItem.menuHeight = this.f302525e;
                        }
                    }
                }
            }
            nVar = null;
            if (swipRightMenuItem != null) {
                view = swipRightMenuItem.menuView;
                if (view instanceof SimpleTextView) {
                }
                if (simpleTextView != null) {
                }
            }
        }
        return simpleTextView;
    }
}
