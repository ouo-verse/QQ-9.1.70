package com.tencent.luggage.wxa.kl;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.x0;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public HashSet f132631a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public HashSet f132632b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public HashSet f132633c = new HashSet();

    public void a(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return;
        }
        this.f132632b.add(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return;
        }
        this.f132631a.add(onClickListener);
    }

    public void c(View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            return;
        }
        this.f132633c.add(onClickListener);
    }

    public boolean a(View view) {
        if (this.f132632b.isEmpty()) {
            return false;
        }
        Iterator it = this.f132632b.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
        return true;
    }

    public boolean b(View view) {
        if (this.f132631a.isEmpty()) {
            return false;
        }
        Iterator it = this.f132631a.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
        return true;
    }

    public boolean c(View view) {
        if (this.f132633c.isEmpty()) {
            return false;
        }
        Iterator it = this.f132633c.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
        return true;
    }

    public static float a(Context context) {
        float f16 = com.tencent.luggage.wxa.kn.a.f(context);
        if (f16 == 0.8f) {
            return 0.91f;
        }
        if (f16 == 1.0f) {
            return 1.0f;
        }
        if (f16 == 1.1f || f16 == 1.12f) {
            return 1.11f;
        }
        if (f16 == 1.125f || f16 == 1.4f || f16 == 1.55f || f16 == 1.65f) {
            return 1.18f;
        }
        if (com.tencent.luggage.wxa.tn.e.f141559a || com.tencent.luggage.wxa.tn.e.f141565g || com.tencent.luggage.wxa.tn.e.f141566h || x0.a() || x0.c()) {
            throw new IllegalStateException(String.format("unhandled scale[%f]", Float.valueOf(f16)));
        }
        w.h("MicroMsg.AppBrandActionBarCommon", "getActionBarTextSizeScale: unhandled scale[%f]", Float.valueOf(f16));
        return 1.0f;
    }
}
