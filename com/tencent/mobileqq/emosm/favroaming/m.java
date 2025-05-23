package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f204353a;

    /* renamed from: b, reason: collision with root package name */
    public String f204354b;

    /* renamed from: c, reason: collision with root package name */
    public String f204355c;

    /* renamed from: d, reason: collision with root package name */
    public String f204356d;

    /* renamed from: e, reason: collision with root package name */
    public String f204357e;

    /* renamed from: f, reason: collision with root package name */
    public String f204358f;

    /* renamed from: g, reason: collision with root package name */
    public String f204359g;

    /* renamed from: h, reason: collision with root package name */
    public String f204360h;

    public m(String str) {
        this.f204353a = str;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length >= 7) {
                this.f204359g = split[0];
                this.f204360h = split[1];
                this.f204354b = split[2];
                this.f204355c = split[3];
                this.f204356d = split[4];
                this.f204357e = split[5];
                this.f204358f = split[6];
            }
        }
    }

    public boolean a() {
        if (this.f204353a.split("_").length >= 7) {
            return true;
        }
        return false;
    }
}
