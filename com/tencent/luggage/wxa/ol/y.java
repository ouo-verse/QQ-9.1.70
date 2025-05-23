package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y extends LinearLayout implements r0 {

    /* renamed from: i, reason: collision with root package name */
    public static final int f136978i = 2131363113;

    /* renamed from: a, reason: collision with root package name */
    public View f136979a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f136980b;

    /* renamed from: c, reason: collision with root package name */
    public b f136981c;

    /* renamed from: d, reason: collision with root package name */
    public z f136982d;

    /* renamed from: e, reason: collision with root package name */
    public EditText f136983e;

    /* renamed from: f, reason: collision with root package name */
    public View f136984f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fi.a f136985g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f136986h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y.this.j();
            y.this.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    public y(Context context) {
        super(context);
        this.f136980b = false;
        this.f136985g = null;
        this.f136986h = false;
        i();
    }

    public void b(View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.r0
    public boolean e() {
        return ViewCompat.isLaidOut(this);
    }

    public final View f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167654dz1, (ViewGroup) null);
        this.f136979a = inflate;
        com.tencent.luggage.wxa.jl.c.a(inflate, Button.class, Integer.valueOf(R.string.f1640024n), false, null, null, null, null, null, null, null, null, null);
        this.f136979a.setOnClickListener(new a());
        return this.f136979a;
    }

    public void g() {
        this.f136979a.setBackgroundResource(R.color.ao9);
        this.f136979a.findViewById(R.id.bmt).setBackgroundResource(R.color.b1h);
        this.f136979a.findViewById(R.id.tix).setBackgroundResource(R.color.b1h);
        this.f136982d.a();
    }

    public EditText getAttachedEditText() {
        return this.f136983e;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        com.tencent.luggage.wxa.fi.a aVar;
        com.tencent.luggage.wxa.kj.c0 customViewContainer;
        if (getVisibility() != 0 || !this.f136986h || (aVar = this.f136985g) == null || (customViewContainer = aVar.getCustomViewContainer()) == null || !(customViewContainer.c() instanceof ViewGroup) || ((ViewGroup) customViewContainer.c()).getChildCount() <= 0 || ((ViewGroup) customViewContainer.c()).getChildAt(0).getLayoutParams() == null) {
            return 0;
        }
        return Math.max(((ViewGroup) customViewContainer.c()).getChildAt(0).getLayoutParams().height, 0);
    }

    public int getPanelHeight() {
        return com.tencent.luggage.wxa.kn.a.a(getContext(), 270);
    }

    public void h() {
        setVisibility(8);
        k();
    }

    public final void i() {
        ViewGroup viewGroup;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNumberKeyboardPanel", "init");
        super.setId(f136978i);
        setOrientation(1);
        setBackgroundColor(-1);
        if (this.f136986h) {
            com.tencent.luggage.wxa.fi.a aVar = this.f136985g;
            this.f136984f = aVar;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", viewGroup.getClass().toString(), Integer.valueOf(viewGroup.getId()));
                viewGroup.removeView(this.f136984f);
            }
            addView(this.f136984f);
        }
        addView(f(), new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.kn.a.a(getContext(), 30)));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, com.tencent.luggage.wxa.kn.a.a(getContext(), 240));
        z zVar = new z(getContext());
        this.f136982d = zVar;
        addView(zVar, layoutParams);
    }

    public final void j() {
        b bVar;
        if (!this.f136980b && (bVar = this.f136981c) != null) {
            this.f136980b = true;
            bVar.a();
            this.f136980b = false;
        }
    }

    public final void k() {
        EditText editText = this.f136983e;
        if (editText != null) {
            editText.clearFocus();
            this.f136983e = null;
            this.f136981c = null;
            this.f136980b = false;
        }
    }

    public void l() {
        View view;
        View view2;
        if (this.f136986h && this.f136984f == null) {
            com.tencent.luggage.wxa.fi.a aVar = this.f136985g;
            this.f136984f = aVar;
            b(aVar);
            addView(this.f136984f, 0);
        }
        if (this.f136986h && (view2 = this.f136984f) != this.f136985g) {
            b(view2);
            com.tencent.luggage.wxa.fi.a aVar2 = this.f136985g;
            this.f136984f = aVar2;
            b(aVar2);
            addView(this.f136984f, 0);
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
        }
        if (this.f136986h && this.f136984f.getParent() != this) {
            b(this.f136984f);
            addView(this.f136984f, 0);
        }
        if (!this.f136986h && (view = this.f136984f) != null && view.getParent() == this) {
            removeView(this.f136984f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }

    public void setComponentView(boolean z16) {
        this.f136986h = z16;
    }

    public <_Input extends EditText & com.tencent.luggage.wxa.tl.b> void setInputEditText(_Input _input) {
        this.f136983e = _input;
        this.f136982d.a(_input);
    }

    public <_InputEventReceiver extends com.tencent.luggage.wxa.tl.b> void setInputEventReceiver(_InputEventReceiver _inputeventreceiver) {
        this.f136982d.a(_inputeventreceiver);
    }

    public void setOnDoneListener(b bVar) {
        this.f136981c = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (getVisibility() == i3 && (getVisibility() == 0 || getVisibility() == 8)) {
            return;
        }
        if (i3 != 0) {
            super.setVisibility(8);
            j();
        } else {
            super.setVisibility(i3);
        }
    }

    public void setXMode(int i3) {
        this.f136982d.setXMode(i3);
    }

    public static y a(View view) {
        return (y) view.getRootView().findViewById(f136978i);
    }

    public static y a(View view, com.tencent.luggage.wxa.fi.a aVar) {
        y a16 = a(view);
        q b16 = q.b(view);
        if (b16 == null) {
            return null;
        }
        if (a16 == null) {
            a16 = new y(view.getContext());
        }
        b16.a((View) a16, false);
        if (a16.f136985g != aVar) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
            a16.f136985g = aVar;
        }
        return a16;
    }

    public void a(EditText editText) {
        if (editText == null) {
            return;
        }
        if (this.f136983e != editText) {
            k();
        }
        setInputEditText(editText);
        setVisibility(0);
    }

    public void a(com.tencent.luggage.wxa.tl.b bVar) {
        if (bVar == null) {
            return;
        }
        setInputEventReceiver(bVar);
        setVisibility(0);
    }

    @Override // android.view.View
    public void setId(int i3) {
    }
}
