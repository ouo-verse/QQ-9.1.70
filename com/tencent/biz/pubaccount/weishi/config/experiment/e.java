package com.tencent.biz.pubaccount.weishi.config.experiment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private d f80654a;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f80655a = new e();
    }

    e() {
        f();
    }

    public static e c() {
        return a.f80655a;
    }

    private String d(d dVar, String str, String str2) {
        return f.c(dVar, str, str2);
    }

    private boolean i(d dVar) {
        return TextUtils.equals(d(dVar, "QQFeedsPreload", "is_preload_data"), "1");
    }

    public String b() {
        d dVar = this.f80654a;
        if (dVar != null) {
            return dVar.b();
        }
        return "";
    }

    public long e() {
        long Z = bb.Z(d(this.f80654a, "QQFeedsPreload", "valid_duration"), 18000L);
        if (Z <= 0) {
            return 18000L;
        }
        return Z;
    }

    public void f() {
        this.f80654a = WSExpPolicyManager.o().n();
    }

    public boolean g() {
        return TextUtils.equals(d(this.f80654a, "AioForwardScene", "image_pre_download"), "1");
    }

    public boolean h() {
        return i(this.f80654a);
    }

    public boolean j() {
        return TextUtils.equals(d(this.f80654a, "QQFeedsPreload", "is_preload_out_valid_duration"), "1");
    }

    public boolean k() {
        return TextUtils.equals(d(this.f80654a, "AioForwardScene", "scene"), "1");
    }

    public void l(d dVar) {
        this.f80654a = dVar;
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return dVar.equals(this.f80654a);
    }
}
