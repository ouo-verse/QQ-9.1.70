package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.fc.d;
import com.tencent.luggage.wxa.hc.b;
import com.tencent.luggage.wxa.zf.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.util.Arrays;

/* loaded from: classes9.dex */
public class AppBrandOptionsPickerV3 implements c {

    /* renamed from: a, reason: collision with root package name */
    public String[] f152444a;

    /* renamed from: b, reason: collision with root package name */
    public b f152445b;

    /* renamed from: c, reason: collision with root package name */
    public Context f152446c;

    /* renamed from: d, reason: collision with root package name */
    public int f152447d;

    /* renamed from: e, reason: collision with root package name */
    public int f152448e;

    /* loaded from: classes9.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.fc.d
        public void onOptionsSelect(int i3) {
            AppBrandOptionsPickerV3.this.f152447d = i3;
        }
    }

    @Keep
    public AppBrandOptionsPickerV3(Context context) {
        this.f152446c = context;
        this.f152445b = new b(context);
    }

    public void b(int i3) {
        this.f152445b.b(i3);
    }

    public void c(int i3) {
        this.f152448e = i3;
    }

    public void d(int i3) {
        this.f152445b.l().setCurrentItem(i3);
    }

    public void e() {
        new com.tencent.luggage.wxa.dc.a(this.f152446c, new a()).b(this.f152448e).a(ContextCompat.getColor(this.f152446c, R.color.f156611ai0)).a(this.f152445b);
        a(this.f152446c.getResources().getDimensionPixelSize(R.dimen.c5l));
        b(this.f152446c.getResources().getDimensionPixelSize(R.dimen.cxz));
        a(ContextCompat.getColor(this.f152446c, R.color.f156611ai0));
        this.f152445b.D.a(0, this.f152446c.getResources().getDimensionPixelSize(R.dimen.bht), 0, this.f152446c.getResources().getDimensionPixelSize(R.dimen.bht));
        this.f152445b.D.c().d(ContextCompat.getColor(this.f152446c, R.color.f156614aj0)).c(this.f152446c.getResources().getDimensionPixelSize(R.dimen.bht)).setBackgroundColor(ContextCompat.getColor(this.f152446c, R.color.ah_));
    }

    public void a(String[] strArr) {
        this.f152444a = strArr;
        this.f152445b.a(Arrays.asList(strArr));
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String currentValue() {
        this.f152445b.n();
        return this.f152444a[this.f152447d];
    }

    public int c() {
        this.f152445b.n();
        return this.f152447d;
    }

    @Override // com.tencent.luggage.wxa.zf.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public WheelView getView() {
        return this.f152445b.l();
    }

    public final void a(int i3) {
        this.f152445b.D.c(i3);
    }

    public int a() {
        return c();
    }

    public void a(com.tencent.luggage.wxa.fc.c cVar) {
        this.f152445b.a(cVar);
    }

    public void a(float f16) {
        this.f152445b.a(f16);
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onAttach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onDetach(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onHide(com.tencent.luggage.wxa.zl.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.zf.c
    public void onShow(com.tencent.luggage.wxa.zl.c cVar) {
    }
}
