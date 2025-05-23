package com.tencent.qidian.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.proto.mobileqq_qidian$GroupItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f342874a;

    /* renamed from: b, reason: collision with root package name */
    public int f342875b;

    /* renamed from: c, reason: collision with root package name */
    public String f342876c;

    public b(mobileqq_qidian$GroupItem mobileqq_qidian_groupitem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a(mobileqq_qidian_groupitem);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileqq_qidian_groupitem);
        }
    }

    public void a(mobileqq_qidian$GroupItem mobileqq_qidian_groupitem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) mobileqq_qidian_groupitem);
            return;
        }
        if (mobileqq_qidian_groupitem.uint64_groupid.has()) {
            this.f342874a = mobileqq_qidian_groupitem.uint64_groupid.get();
        }
        if (mobileqq_qidian_groupitem.uint32_group_level.has()) {
            this.f342875b = mobileqq_qidian_groupitem.uint32_group_level.get();
        }
        if (mobileqq_qidian_groupitem.str_group_name.has()) {
            this.f342876c = mobileqq_qidian_groupitem.str_group_name.get();
        }
    }

    public mobileqq_qidian$GroupItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (mobileqq_qidian$GroupItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        mobileqq_qidian$GroupItem mobileqq_qidian_groupitem = new mobileqq_qidian$GroupItem();
        mobileqq_qidian_groupitem.uint64_groupid.set(this.f342874a);
        mobileqq_qidian_groupitem.uint32_group_level.set(this.f342875b);
        mobileqq_qidian_groupitem.str_group_name.set(this.f342876c);
        return mobileqq_qidian_groupitem;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
