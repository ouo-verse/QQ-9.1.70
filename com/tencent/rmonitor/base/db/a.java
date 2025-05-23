package com.tencent.rmonitor.base.db;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f365358a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f365359b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f365360c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f365361d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f365362e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f365363f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f365364g = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!TextUtils.equals(this.f365358a, aVar.f365358a) || !TextUtils.equals(this.f365359b, aVar.f365359b) || !TextUtils.equals(this.f365360c, aVar.f365360c) || !TextUtils.equals(this.f365361d, aVar.f365361d) || !TextUtils.equals(this.f365362e, aVar.f365362e) || !TextUtils.equals(this.f365363f, aVar.f365363f)) {
            return false;
        }
        return TextUtils.equals(this.f365364g, aVar.f365364g);
    }
}
