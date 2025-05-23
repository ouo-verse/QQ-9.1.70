package com.tencent.mobileqq.dating.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class InputBar extends LinearLayout {
    static IPatchRedirector $redirector_;
    private boolean C;
    private int D;
    private int E;
    private View F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private ListView f203453d;

    /* renamed from: e, reason: collision with root package name */
    private int f203454e;

    /* renamed from: f, reason: collision with root package name */
    private int f203455f;

    /* renamed from: h, reason: collision with root package name */
    private int f203456h;

    /* renamed from: i, reason: collision with root package name */
    private int f203457i;

    /* renamed from: m, reason: collision with root package name */
    private int f203458m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
    }

    public InputBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.C = false;
            this.G = 0;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @TargetApi(11)
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.G == 0) {
            this.G = i18;
        }
        if (!this.C) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("InputBar", 4, "inputBar onLayout top is: " + i16 + "changed is: " + z16);
        }
        if (i16 <= 0) {
            return;
        }
        int i19 = this.f203457i;
        if (i19 <= 0) {
            this.f203457i = i16;
            this.E = i16;
            return;
        }
        if (i16 != i19 && i16 == this.E) {
            View view = this.F;
            if (view != null) {
                this.f203453d.removeFooterView(view);
            }
            this.f203457i = i16;
            return;
        }
        if (i16 != i19 && i16 != this.E) {
            getHandler().post(new Runnable(i16) { // from class: com.tencent.mobileqq.dating.widget.InputBar.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f203459d;

                {
                    this.f203459d = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputBar.this, i16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int count;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (InputBar.this.f203455f > this.f203459d - InputBar.this.f203458m) {
                        if (InputBar.this.f203453d.getAdapter() == null) {
                            count = 0;
                        } else {
                            count = InputBar.this.f203453d.getAdapter().getCount();
                        }
                        int footerViewsCount = (count - InputBar.this.D) - InputBar.this.f203453d.getFooterViewsCount();
                        float f16 = InputBar.this.getResources().getDisplayMetrics().density;
                        int bottom = ((InputBar.this.f203458m - this.f203459d) + InputBar.this.f203453d.getBottom()) - (((footerViewsCount - InputBar.this.f203454e) - 1) * ((int) (61.0f * f16)));
                        if (InputBar.this.f203453d.getFooterViewsCount() > 0) {
                            bottom = (int) (bottom - (f16 * 60.0f));
                        }
                        if (bottom > 0) {
                            if (InputBar.this.F != null) {
                                InputBar.this.f203453d.removeFooterView(InputBar.this.F);
                            }
                            InputBar.this.F = new View(InputBar.this.getContext());
                            InputBar.this.F.setLayoutParams(new AbsListView.LayoutParams(-1, bottom));
                            InputBar.this.f203453d.addFooterView(InputBar.this.F);
                        }
                    }
                    InputBar.this.f203453d.setSelectionFromTop(InputBar.this.f203454e + InputBar.this.D, (this.f203459d - InputBar.this.f203456h) - InputBar.this.f203458m);
                }
            });
            this.f203457i = i16;
        }
    }

    public void setmCallback(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
    }

    public InputBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.C = false;
            this.G = 0;
        }
    }
}
