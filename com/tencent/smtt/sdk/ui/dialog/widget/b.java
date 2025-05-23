package com.tencent.smtt.sdk.ui.dialog.widget;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b extends Button {

    /* renamed from: a, reason: collision with root package name */
    private int f369594a;

    /* renamed from: b, reason: collision with root package name */
    private int f369595b;

    /* renamed from: c, reason: collision with root package name */
    private float f369596c;

    /* renamed from: d, reason: collision with root package name */
    private float f369597d;

    /* renamed from: e, reason: collision with root package name */
    private float f369598e;

    /* renamed from: f, reason: collision with root package name */
    private float f369599f;

    /* renamed from: g, reason: collision with root package name */
    private c f369600g;

    /* renamed from: h, reason: collision with root package name */
    private c f369601h;

    /* renamed from: i, reason: collision with root package name */
    private c f369602i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context, int i3, int i16) {
        this(context, r5, r5, r5, r5, i16);
        float f16 = i3;
    }

    public void a() {
        c cVar = new c(this.f369594a, this.f369596c, this.f369597d, this.f369598e, this.f369599f);
        this.f369600g = cVar;
        cVar.a(getWidth(), getHeight());
        c cVar2 = new c(1342177280 | (16777215 & this.f369594a), this.f369596c, this.f369597d, this.f369598e, this.f369599f);
        this.f369601h = cVar2;
        cVar2.a(getWidth(), getHeight());
        c cVar3 = new c(this.f369595b, this.f369596c, this.f369597d, this.f369598e, this.f369599f);
        this.f369602i = cVar3;
        cVar3.a(getWidth(), getHeight());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, -16842919}, this.f369600g);
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, this.f369601h);
        stateListDrawable.addState(new int[]{-16842910}, this.f369602i);
        setBackgroundDrawable(stateListDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        c cVar = this.f369600g;
        if (cVar != null) {
            cVar.a(i17 - i3, i18 - i16);
        }
        c cVar2 = this.f369601h;
        if (cVar2 != null) {
            cVar2.a(i17 - i3, i18 - i16);
        }
        c cVar3 = this.f369602i;
        if (cVar3 != null) {
            cVar3.a(i17 - i3, i18 - i16);
        }
    }

    public b(Context context, float f16, float f17, float f18, float f19, int i3) {
        super(context);
        this.f369600g = null;
        this.f369601h = null;
        this.f369602i = null;
        this.f369596c = f16;
        this.f369597d = f17;
        this.f369598e = f18;
        this.f369599f = f19;
        this.f369594a = i3;
        this.f369595b = Color.parseColor("#D0D0D0");
        a();
    }
}
