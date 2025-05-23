package com.tencent.luggage.wxa.np;

import com.tencent.mobileqq.app.face.FaceConstant;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f135896a;

    /* renamed from: b, reason: collision with root package name */
    public String f135897b;

    public h(int i3, String str) {
        this(i3);
        if (i.a(str)) {
            return;
        }
        this.f135897b = str;
    }

    public int a() {
        return this.f135896a;
    }

    public String b() {
        return this.f135897b;
    }

    public boolean c() {
        if (this.f135896a == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof h) && ((h) obj).f135896a == this.f135896a) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SoterCoreResult{errCode=" + this.f135896a + ", errMsg='" + this.f135897b + "'}";
    }

    public void a(int i3) {
        this.f135896a = i3;
    }

    public void a(String str) {
        this.f135897b = str;
    }

    public h(int i3) {
        this.f135896a = i3;
        if (i3 == 0) {
            this.f135897b = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        } else if (i3 != 2) {
            this.f135897b = "errmsg not specified";
        } else {
            this.f135897b = "device not support soter";
        }
    }
}
