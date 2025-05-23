package com.qzone.homepage.ui.Facade;

import android.R;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.homepage.ui.Facade.model.ConfigArea;
import com.qzone.homepage.ui.Facade.ui.FacadeView;
import com.qzone.util.ar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j extends i {

    /* renamed from: l, reason: collision with root package name */
    public String f47620l;

    /* renamed from: m, reason: collision with root package name */
    public String f47621m;

    /* renamed from: n, reason: collision with root package name */
    public int f47622n;

    /* renamed from: o, reason: collision with root package name */
    public int f47623o;

    /* renamed from: p, reason: collision with root package name */
    public int f47624p;

    /* renamed from: q, reason: collision with root package name */
    public int f47625q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f47626r;

    j() {
    }

    public static j d(ConfigArea configArea) {
        j jVar = new j();
        jVar.b(configArea);
        jVar.f47622n = configArea.textColor;
        jVar.f47623o = configArea.textColorClick;
        jVar.f47620l = configArea.text;
        jVar.f47621m = configArea.defaultText;
        jVar.f47624p = configArea.fontSize;
        switch (configArea.contentStyle) {
            case 11:
                jVar.f47625q = 19;
                return jVar;
            case 12:
                jVar.f47625q = 17;
                return jVar;
            case 13:
                jVar.f47625q = 21;
                return jVar;
            default:
                jVar.f47625q = 19;
                return jVar;
        }
    }

    @Override // com.qzone.homepage.ui.Facade.i
    public View c(FacadeView facadeView) {
        TextView textView = new TextView(facadeView.getContext());
        this.f47626r = textView;
        textView.setText(this.f47621m);
        int i3 = this.f47623o;
        if (i3 != 0) {
            this.f47626r.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i3, this.f47622n}));
        } else {
            this.f47626r.setTextColor(this.f47622n);
        }
        this.f47626r.setGravity(this.f47625q);
        this.f47626r.setSingleLine();
        this.f47626r.setEllipsize(TextUtils.TruncateAt.END);
        this.f47626r.setPadding(ar.d(10.0f), 0, ar.d(10.0f), 0);
        this.f47626r.setTextSize(this.f47624p);
        if (!TextUtils.isEmpty(this.f47611c)) {
            this.f47626r.setOnClickListener(new a());
        }
        return this.f47626r;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
