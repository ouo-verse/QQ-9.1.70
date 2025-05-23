package com.tencent.mobileqq.guild.component.menu;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import rg1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CustomMenuLayout extends LinearLayout {
    private int C;
    private b D;
    private int E;
    private boolean F;
    private rg1.a G;

    /* renamed from: d, reason: collision with root package name */
    private qg1.a f215933d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.guild.component.menu.b f215934e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f215935f;

    /* renamed from: h, reason: collision with root package name */
    private Context f215936h;

    /* renamed from: i, reason: collision with root package name */
    private int f215937i;

    /* renamed from: m, reason: collision with root package name */
    private int f215938m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CustomMenuLayout.this.f215933d.o();
            CustomMenuLayout.this.f215935f.onClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends LinearLayout {
        public b(Context context) {
            super(context);
            setOrientation(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            addView(CustomMenuLayout.this.G.d(getContext()));
        }
    }

    public CustomMenuLayout(Context context) {
        super(context);
        this.C = 4;
        this.F = false;
        this.f215936h = context;
        setOrientation(1);
        c cVar = new c();
        this.G = cVar;
        setMenuContainerStyle(cVar);
    }

    public static CustomMenuLayout e(qg1.a aVar, Context context, com.tencent.mobileqq.guild.component.menu.b bVar, View.OnClickListener onClickListener, rg1.a aVar2) {
        CustomMenuLayout customMenuLayout = new CustomMenuLayout(context);
        customMenuLayout.setGravity(17);
        customMenuLayout.setPadding(0, 0, 0, 0);
        customMenuLayout.setPopupWindow(aVar);
        customMenuLayout.setMenuList(bVar);
        customMenuLayout.setMenuIconClickListener(onClickListener);
        customMenuLayout.setMenuContainerStyle(aVar2);
        customMenuLayout.d();
        return customMenuLayout;
    }

    private View f(com.tencent.mobileqq.guild.component.menu.a aVar, float[] fArr) {
        StateListDrawable m3 = m(fArr);
        String c16 = aVar.c();
        if (this.F && c16.length() > 4) {
            c16 = c16.substring(0, 3) + "\u2026";
        }
        TextView textView = new TextView(getContext());
        textView.setText(c16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(aVar.b().a());
        textView.setMaxLines(1);
        textView.setContentDescription(aVar.c());
        textView.setTextColor(aVar.b().b(this.f215936h));
        textView.setIncludeFontPadding(true);
        textView.setCompoundDrawables(aVar.f215943c, null, null, null);
        textView.setGravity(17);
        View h16 = h(textView);
        h16.setBackgroundDrawable(m3);
        h16.setId(aVar.a());
        return h16;
    }

    private void g(int i3) {
        View f16;
        float[] o16;
        float[] n3;
        removeAllViews();
        int d16 = this.f215934e.d();
        int i16 = this.C;
        if (i3 != 0) {
            i16--;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CustomMenuLayout", 2, "[menu] showMenu offset: " + i3 + " count: " + d16);
        }
        for (int i17 = 0; i17 < d16; i17++) {
            com.tencent.mobileqq.guild.component.menu.a b16 = this.f215934e.b(i17 + i3);
            if (i17 == 0) {
                if (i3 == 0 && d16 == 1) {
                    n3 = i();
                } else if (d16 <= i16) {
                    n3 = j();
                } else {
                    n3 = n();
                }
                f16 = f(b16, n3);
            } else if ((i3 == 0 && i17 == i16 - 1) || (i3 == 0 && d16 < i16 && i17 == d16 - 1)) {
                if (d16 <= i16) {
                    o16 = l();
                } else {
                    o16 = o();
                }
                f16 = f(b16, o16);
            } else {
                f16 = f(b16, k());
            }
            if (i17 < i16) {
                if (this.D == null) {
                    this.D = new b(this.f215936h);
                }
                this.D.addView(f16, new LinearLayout.LayoutParams(this.f215937i, -1));
                if (i17 < i16 - 1 && i17 != d16 - 1) {
                    this.D.b();
                }
            }
        }
        addView(this.D, new LinearLayout.LayoutParams(-2, this.f215938m));
    }

    private float[] i() {
        int i3 = this.E;
        return new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
    }

    private float[] j() {
        int i3 = this.E;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3};
    }

    private float[] k() {
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] l() {
        int i3 = this.E;
        return new float[]{0.0f, 0.0f, i3, i3, i3, i3, 0.0f, 0.0f};
    }

    private StateListDrawable m(float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.G.e(this.f215936h));
        gradientDrawable.setCornerRadii(fArr);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(this.G.f(this.f215936h));
        gradientDrawable2.setCornerRadii(fArr);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(400);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private float[] n() {
        int i3 = this.E;
        return new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    private float[] o() {
        int i3 = this.E;
        return new float[]{0.0f, 0.0f, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void d() {
        g(0);
    }

    protected View h(View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(view, layoutParams);
        frameLayout.setOnClickListener(new a());
        return frameLayout;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.D = null;
    }

    public void setMenuContainerStyle(rg1.a aVar) {
        this.G = aVar;
        this.E = aVar.c();
        this.f215937i = aVar.a();
        this.f215938m = aVar.b();
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        this.f215935f = onClickListener;
    }

    public void setMenuList(com.tencent.mobileqq.guild.component.menu.b bVar) {
        this.f215934e = bVar.c();
        if (QLog.isColorLevel()) {
            QLog.d("CustomMenuLayout", 4, "[menu] setMenu MENU:" + this.f215934e.toString());
        }
    }

    public void setPopupWindow(qg1.a aVar) {
        this.f215933d = aVar;
    }
}
