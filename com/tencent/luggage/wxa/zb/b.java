package com.tencent.luggage.wxa.zb;

import android.content.Context;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements com.tencent.luggage.wxa.ac.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f146470a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f146471b = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    /* renamed from: c, reason: collision with root package name */
    public final int[] f146472c = {R.string.f174572w8, R.string.f174562w7, R.string.f174602wa, R.string.f174532w4, R.string.f174612wb, R.string.f174592w_, R.string.f174582w9, R.string.f174542w5, R.string.f174642we, R.string.f174632wd, R.string.f174622wc, R.string.f174552w6};

    public b(Context context) {
        this.f146470a = context;
    }

    @Override // com.tencent.luggage.wxa.ac.a
    public String a(String str) {
        com.tencent.luggage.wxa.er.a.a(12, this.f146471b.length);
        com.tencent.luggage.wxa.er.a.a(12, this.f146472c.length);
        int i3 = 0;
        while (true) {
            String[] strArr = this.f146471b;
            if (i3 < strArr.length) {
                if (str.equals(strArr[i3])) {
                    return this.f146470a.getResources().getString(this.f146472c[i3]);
                }
                i3++;
            } else {
                return str;
            }
        }
    }
}
