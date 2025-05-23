package com.tencent.mobileqq.mutualmark.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark$MutualMark;
import tencent.im.mutualmark.mutualmark$ResourceInfo;
import tencent.im.mutualmark.mutualmark$ResourceInfo_17;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f252129a;

    /* renamed from: b, reason: collision with root package name */
    public long f252130b;

    /* renamed from: c, reason: collision with root package name */
    public float f252131c;

    /* renamed from: d, reason: collision with root package name */
    public long f252132d;

    /* renamed from: e, reason: collision with root package name */
    public long f252133e;

    /* renamed from: f, reason: collision with root package name */
    public long f252134f;

    /* renamed from: g, reason: collision with root package name */
    public long f252135g;

    /* renamed from: h, reason: collision with root package name */
    public long f252136h;

    /* renamed from: i, reason: collision with root package name */
    public long f252137i;

    /* renamed from: j, reason: collision with root package name */
    public String f252138j;

    /* renamed from: k, reason: collision with root package name */
    public String f252139k;

    /* renamed from: l, reason: collision with root package name */
    public String f252140l;

    /* renamed from: m, reason: collision with root package name */
    public String f252141m;

    /* renamed from: n, reason: collision with root package name */
    public String f252142n;

    /* renamed from: o, reason: collision with root package name */
    public String f252143o;

    /* renamed from: p, reason: collision with root package name */
    public String f252144p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f252145q;

    /* renamed from: r, reason: collision with root package name */
    public String f252146r;

    /* renamed from: s, reason: collision with root package name */
    public int f252147s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f252148t;

    /* renamed from: u, reason: collision with root package name */
    public String f252149u;

    /* renamed from: v, reason: collision with root package name */
    public int f252150v;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252138j = "";
        this.f252139k = "";
        this.f252140l = "";
        this.f252141m = "";
        this.f252142n = "";
        this.f252143o = "";
        this.f252144p = "";
        this.f252145q = false;
        this.f252146r = "";
    }

    public static e a(mutualmark$MutualMark mutualmark_mutualmark) {
        boolean z16;
        e eVar = new e();
        eVar.f252129a = mutualmark_mutualmark.uint64_type.get();
        eVar.f252130b = mutualmark_mutualmark.uint64_level.get();
        eVar.f252131c = mutualmark_mutualmark.float_count.get();
        eVar.f252132d = mutualmark_mutualmark.uint64_day.get();
        eVar.f252133e = mutualmark_mutualmark.uint64_time.get();
        eVar.f252135g = mutualmark_mutualmark.uint64_icon_status.get();
        eVar.f252137i = mutualmark_mutualmark.uint64_sub_level.get();
        if (eVar.f252135g != 2) {
            eVar.f252136h = 0L;
        } else if (mutualmark_mutualmark.uint64_icon_status_end_time.has()) {
            eVar.f252136h = mutualmark_mutualmark.uint64_icon_status_end_time.get();
        }
        if (mutualmark_mutualmark.uint32_close_flag.has()) {
            if (mutualmark_mutualmark.uint32_close_flag.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.f252145q = z16;
        }
        mutualmark$ResourceInfo mutualmark_resourceinfo = null;
        if (mutualmark_mutualmark.bytes_resource_info.has()) {
            mutualmark$ResourceInfo_17 mutualmark_resourceinfo_17 = new mutualmark$ResourceInfo_17();
            try {
                mutualmark_resourceinfo_17.mergeFrom(mutualmark_mutualmark.bytes_resource_info.get().toByteArray());
            } catch (Throwable th5) {
                QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + th5.getMessage());
                mutualmark_resourceinfo_17 = null;
            }
            c(eVar, mutualmark_resourceinfo_17);
        }
        if (mutualmark_mutualmark.bytes_grade_resource_info.has()) {
            mutualmark$ResourceInfo mutualmark_resourceinfo2 = new mutualmark$ResourceInfo();
            try {
                mutualmark_resourceinfo2.mergeFrom(mutualmark_mutualmark.bytes_grade_resource_info.get().toByteArray());
                mutualmark_resourceinfo = mutualmark_resourceinfo2;
            } catch (Throwable th6) {
                QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + th6.getMessage());
            }
            b(eVar, mutualmark_resourceinfo);
        }
        if (mutualmark_mutualmark.bytes_min_ver.has() && !TextUtils.isEmpty(mutualmark_mutualmark.bytes_min_ver.get().toStringUtf8())) {
            eVar.f252138j = mutualmark_mutualmark.bytes_min_ver.get().toStringUtf8();
        }
        if (mutualmark_mutualmark.bytes_max_ver.has() && !TextUtils.isEmpty(mutualmark_mutualmark.bytes_max_ver.get().toStringUtf8())) {
            eVar.f252139k = mutualmark_mutualmark.bytes_max_ver.get().toStringUtf8();
        }
        if (g.j(eVar.f252138j, eVar.f252139k) && !eVar.f252145q) {
            eVar.f252145q = false;
        } else {
            eVar.f252145q = true;
        }
        if (mutualmark_mutualmark.icon_url.has()) {
            eVar.f252146r = mutualmark_mutualmark.icon_url.get();
        }
        if (mutualmark_mutualmark.mark_version.has()) {
            eVar.f252147s = mutualmark_mutualmark.mark_version.get();
        }
        if (mutualmark_mutualmark.is_wearing.has()) {
            eVar.f252148t = mutualmark_mutualmark.is_wearing.get();
        }
        if (mutualmark_mutualmark.icon_format.has()) {
            eVar.f252149u = mutualmark_mutualmark.icon_format.get();
        }
        return eVar;
    }

    private static void b(e eVar, mutualmark$ResourceInfo mutualmark_resourceinfo) {
        if (eVar != null && mutualmark_resourceinfo != null) {
            if (mutualmark_resourceinfo.bytes_static_url.has()) {
                String stringUtf8 = mutualmark_resourceinfo.bytes_static_url.get().toStringUtf8();
                eVar.f252140l = stringUtf8;
                eVar.f252140l = g.b(stringUtf8);
            }
            if (mutualmark_resourceinfo.bytes_dynamic_url.has()) {
                String stringUtf82 = mutualmark_resourceinfo.bytes_dynamic_url.get().toStringUtf8();
                eVar.f252141m = stringUtf82;
                eVar.f252141m = g.b(stringUtf82);
            }
            if (mutualmark_resourceinfo.bytes_cartoon_url.has()) {
                String stringUtf83 = mutualmark_resourceinfo.bytes_cartoon_url.get().toStringUtf8();
                eVar.f252142n = stringUtf83;
                eVar.f252142n = g.b(stringUtf83);
            }
            if (mutualmark_resourceinfo.bytes_cartoon_md5.has()) {
                eVar.f252143o = mutualmark_resourceinfo.bytes_cartoon_md5.get().toStringUtf8();
            }
            if (mutualmark_resourceinfo.bytes_word.has()) {
                eVar.f252144p = mutualmark_resourceinfo.bytes_word.get().toStringUtf8();
            }
        }
    }

    private static void c(e eVar, mutualmark$ResourceInfo_17 mutualmark_resourceinfo_17) {
        if (eVar != null && mutualmark_resourceinfo_17 != null) {
            if (mutualmark_resourceinfo_17.bytes_static_url.has()) {
                String stringUtf8 = mutualmark_resourceinfo_17.bytes_static_url.get().toStringUtf8();
                eVar.f252140l = stringUtf8;
                eVar.f252140l = g.b(stringUtf8);
            }
            if (mutualmark_resourceinfo_17.bytes_dynamic_url.has()) {
                String stringUtf82 = mutualmark_resourceinfo_17.bytes_dynamic_url.get().toStringUtf8();
                eVar.f252141m = stringUtf82;
                eVar.f252141m = g.b(stringUtf82);
            }
            if (mutualmark_resourceinfo_17.bytes_cartoon_url.has()) {
                String stringUtf83 = mutualmark_resourceinfo_17.bytes_cartoon_url.get().toStringUtf8();
                eVar.f252142n = stringUtf83;
                eVar.f252142n = g.b(stringUtf83);
            }
            if (mutualmark_resourceinfo_17.bytes_cartoon_md5.has()) {
                eVar.f252143o = mutualmark_resourceinfo_17.bytes_cartoon_md5.get().toStringUtf8();
            }
            if (mutualmark_resourceinfo_17.bytes_word.has()) {
                eVar.f252144p = mutualmark_resourceinfo_17.bytes_word.get().toStringUtf8();
            }
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MutualMarkPullInfo{type:" + this.f252129a + ", level:" + this.f252130b + ", count:" + this.f252131c + ", continue_days:" + this.f252132d + ", last_action_time:" + this.f252133e + ", last_change_time:" + this.f252134f + ", icon_status:" + this.f252135g + ", icon_status_end_time:" + this.f252136h + ", sub_level:" + this.f252137i + ", icon_static_url:" + this.f252140l + ", icon_dynamic_url:" + this.f252141m + ", icon_cartoon_url:" + this.f252142n + ", icon_cartoon_md5:" + this.f252143o + ", icon_name:" + this.f252144p + ", user_close_flag:" + this.f252145q + ", minVersion:" + this.f252138j + ", maxVersion:" + this.f252139k + ", icon_url:" + this.f252146r + ", mark_version:" + this.f252147s + ", is_wearing:" + this.f252148t + ", icon_format:" + this.f252149u + ", , order_num=" + this.f252150v + "}";
    }
}
