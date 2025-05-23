package com.tencent.biz.pubaccount.weishi.view.tab;

import a20.c;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.view.tab.WSTabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    public static float f82510k = ScreenUtil.dip2px(22.0f);

    /* renamed from: l, reason: collision with root package name */
    public static float f82511l = ScreenUtil.dip2px(15.0f);

    /* renamed from: m, reason: collision with root package name */
    public static float f82512m = ScreenUtil.dip2px(2.0f);

    /* renamed from: a, reason: collision with root package name */
    private WSTabLayout.e f82513a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f82514b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f82515c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f82516d;

    /* renamed from: e, reason: collision with root package name */
    private KandianUrlImageView f82517e;

    /* renamed from: f, reason: collision with root package name */
    private int f82518f = 0;

    /* renamed from: g, reason: collision with root package name */
    private c f82519g;

    /* renamed from: h, reason: collision with root package name */
    private TabLayoutCompat.f f82520h;

    /* renamed from: i, reason: collision with root package name */
    private int f82521i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f82522j;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.view.tab.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class ViewOnClickListenerC0841a implements View.OnClickListener {
        ViewOnClickListenerC0841a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f82513a != null) {
                if (a.this.f82522j) {
                    a.this.f82513a.b(a.this);
                } else {
                    a.this.f82513a.a(a.this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Function0<Boolean> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke() {
            return Boolean.valueOf(a.this.f82522j);
        }
    }

    public a(View view) {
        this.f82514b = (TextView) view.findViewById(R.id.f125467m5);
        this.f82515c = (TextView) view.findViewById(R.id.f125457m4);
        this.f82516d = (TextView) view.findViewById(R.id.f125367lv);
        this.f82517e = (KandianUrlImageView) view.findViewById(R.id.f125227lh);
        view.setOnClickListener(new ViewOnClickListenerC0841a());
        g(view);
    }

    private void g(View view) {
        com.tencent.biz.pubaccount.weishi.util.c.a(view, new b());
    }

    public TabLayoutCompat.f e() {
        return this.f82520h;
    }

    public TextView f() {
        return this.f82514b;
    }

    public void h(WSTabLayout.e eVar) {
        this.f82513a = eVar;
    }

    public void i(int i3) {
        this.f82514b.setTextColor(i3);
        this.f82515c.setTextColor(i3);
        this.f82522j = true;
    }

    public void j(TabLayoutCompat.f fVar) {
        this.f82520h = fVar;
    }

    public void m() {
        this.f82514b.setTextColor(Color.rgb(153, 153, 153));
        this.f82515c.setTextColor(Color.rgb(153, 153, 153));
        this.f82522j = false;
    }

    public void c(float f16) {
        if (bb.D(f16, 0.0f)) {
            return;
        }
        if (f16 > 0.6d) {
            f16 = 0.6f;
        }
        int i3 = (int) (f16 * 255.0f);
        this.f82514b.setTextColor(Color.rgb(i3, i3, i3));
    }

    public void d(float f16) {
        if (bb.D(f16, 0.0f)) {
            return;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (f16 < 0.6d) {
            f16 = 0.6f;
        }
        int i3 = (int) (f16 * 255.0f);
        this.f82514b.setTextColor(Color.rgb(i3, i3, i3));
    }

    private void l(boolean z16) {
        if (z16) {
            this.f82514b.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.f82514b.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void k(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f82519g = cVar;
        if (TextUtils.isEmpty(cVar.a()) && TextUtils.isEmpty(cVar.d())) {
            this.f82514b.setVisibility(8);
            this.f82515c.setVisibility(8);
            this.f82517e.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(cVar.a())) {
            this.f82521i = 2;
            this.f82514b.setVisibility(8);
            this.f82515c.setVisibility(8);
            this.f82517e.setVisibility(0);
            WSPicLoader.g().w(this.f82517e, cVar.a(), BaseApplication.getContext().getResources().getDrawable(R.drawable.ocw));
            return;
        }
        this.f82521i = 1;
        this.f82514b.setVisibility(0);
        this.f82517e.setVisibility(8);
        this.f82514b.setText(cVar.d());
        this.f82514b.setTextSize(cVar.e());
        l(cVar.f());
        if (!TextUtils.isEmpty(cVar.c())) {
            this.f82515c.setVisibility(0);
            this.f82515c.setText(cVar.c());
        } else {
            this.f82515c.setVisibility(8);
        }
    }
}
