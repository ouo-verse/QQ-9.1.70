package com.tencent.qidian.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$PubAccItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f342877a;

    /* renamed from: b, reason: collision with root package name */
    public String f342878b;

    /* renamed from: c, reason: collision with root package name */
    public int f342879c;

    /* renamed from: d, reason: collision with root package name */
    public int f342880d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f342881e;

    /* renamed from: f, reason: collision with root package name */
    public String f342882f;

    /* renamed from: g, reason: collision with root package name */
    public String f342883g;

    public c(mobileqq_qidian$PubAccItem mobileqq_qidian_pubaccitem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileqq_qidian_pubaccitem);
            return;
        }
        this.f342877a = "";
        this.f342878b = "";
        this.f342881e = false;
        this.f342882f = "";
        this.f342883g = "";
        a(mobileqq_qidian_pubaccitem);
    }

    public void a(mobileqq_qidian$PubAccItem mobileqq_qidian_pubaccitem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mobileqq_qidian_pubaccitem);
            return;
        }
        if (mobileqq_qidian_pubaccitem.str_uin.has()) {
            this.f342877a = mobileqq_qidian_pubaccitem.str_uin.get();
        }
        if (mobileqq_qidian_pubaccitem.str_name.has()) {
            this.f342878b = mobileqq_qidian_pubaccitem.str_name.get();
        }
        if (mobileqq_qidian_pubaccitem.uint32_type.has()) {
            this.f342879c = mobileqq_qidian_pubaccitem.uint32_type.get();
        }
        if (mobileqq_qidian_pubaccitem.uint32_verity.has()) {
            this.f342880d = mobileqq_qidian_pubaccitem.uint32_verity.get();
        }
        if (mobileqq_qidian_pubaccitem.str_face_url.has()) {
            this.f342882f = mobileqq_qidian_pubaccitem.str_face_url.get();
        }
        if (mobileqq_qidian_pubaccitem.str_qr_url.has()) {
            this.f342883g = mobileqq_qidian_pubaccitem.str_qr_url.get();
        }
    }

    public mobileqq_qidian$PubAccItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (mobileqq_qidian$PubAccItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        mobileqq_qidian$PubAccItem mobileqq_qidian_pubaccitem = new mobileqq_qidian$PubAccItem();
        mobileqq_qidian_pubaccitem.str_uin.set(this.f342877a);
        mobileqq_qidian_pubaccitem.str_name.set(this.f342878b);
        mobileqq_qidian_pubaccitem.uint32_type.set(this.f342879c);
        mobileqq_qidian_pubaccitem.uint32_verity.set(this.f342880d);
        mobileqq_qidian_pubaccitem.str_face_url.set(this.f342882f);
        mobileqq_qidian_pubaccitem.str_qr_url.set(this.f342883g);
        return mobileqq_qidian_pubaccitem;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.f342877a.equals(this.f342877a) || !cVar.f342878b.equals(this.f342878b) || cVar.f342879c != this.f342879c || cVar.f342880d != this.f342880d || !cVar.f342882f.equals(this.f342882f) || !cVar.f342883g.equals(this.f342883g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return ((((((((((((403 + this.f342877a.hashCode()) * 31) + this.f342878b.hashCode()) * 31) + this.f342879c) * 31) + this.f342880d) * 31) + (!this.f342881e ? 1 : 0)) * 31) + this.f342882f.hashCode()) * 31) + this.f342883g.hashCode();
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f342877a = "";
        this.f342878b = "";
        this.f342881e = false;
        this.f342882f = "";
        this.f342883g = "";
    }
}
