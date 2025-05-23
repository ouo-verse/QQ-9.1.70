package com.tencent.mobileqq.ar.view;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f198806a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f198807b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f198808c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f198809d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f198810e = true;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f198811f = {R.id.f916555r, R.id.f9180566, R.id.f9176562, R.id.f80794cf};

    /* renamed from: g, reason: collision with root package name */
    private final String[] f198812g = {HardCodeUtil.qqStr(R.string.f223946hl), HardCodeUtil.qqStr(R.string.t3g), HardCodeUtil.qqStr(R.string.f224016hs), HardCodeUtil.qqStr(R.string.ztu)};

    /* renamed from: h, reason: collision with root package name */
    private final int[] f198813h = {R.drawable.en8, R.drawable.en9, R.drawable.en_, R.drawable.ena, R.drawable.enb, R.drawable.enc, R.drawable.end, R.drawable.ene};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f198814i = {R.drawable.emp, R.drawable.emq, R.drawable.emr, R.drawable.ems, R.drawable.emt, R.drawable.emu, R.drawable.emv, R.drawable.emw};

    /* renamed from: j, reason: collision with root package name */
    private final int[] f198815j = {R.drawable.f161702en0, R.drawable.f161703en1, R.drawable.f161704en2, R.drawable.f161705en3, R.drawable.f161706en4, R.drawable.en5, R.drawable.en6, R.drawable.en7};

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<a> f198816k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private int f198817l = 0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f198818a;

        /* renamed from: b, reason: collision with root package name */
        public String f198819b;

        public a(int i3, String str) {
            this.f198818a = i3;
            this.f198819b = str;
        }
    }

    public f(int i3) {
        this.f198806a = i3;
    }

    public int a() {
        return this.f198816k.size();
    }

    public String[] b() {
        return this.f198812g;
    }

    public int[] c() {
        return this.f198811f;
    }

    public a d(int i3) {
        if (i3 >= 0 && i3 < a()) {
            return this.f198816k.get(i3);
        }
        return null;
    }

    public int e() {
        return this.f198813h.length;
    }

    public int[] f(int i3) {
        if (i3 == 0) {
            return this.f198814i;
        }
        if (i3 == 1) {
            return this.f198813h;
        }
        if (i3 == 2) {
            return this.f198815j;
        }
        return null;
    }

    public int g(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        return 3;
    }

    public ScanEntryProviderView h(int i3, Context context, d dVar, boolean z16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return new OCRScanEntryView(context, dVar, z16);
            }
            return new QRScanEntryView(context, dVar, z16);
        }
        return new ARScanEntryView(context, dVar, z16);
    }

    public void i() {
        if (this.f198808c) {
            this.f198816k.add(new a(1, "AR"));
        }
        if (this.f198806a == 1) {
            if (this.f198807b) {
                this.f198816k.add(new a(2, HardCodeUtil.qqStr(R.string.t3h)));
            }
            if (this.f198809d) {
                this.f198816k.add(new a(3, "OCR"));
            }
        }
    }

    public void j(int i3) {
        this.f198817l = i3;
    }
}
