package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<HotPicTagInfo> f237010a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<HotPicTagInfo> f237011b;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f237010a = new SparseArray<>();
            this.f237011b = new ArrayList<>();
        }
    }

    public void a(HotPicTagInfo hotPicTagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hotPicTagInfo);
        } else {
            this.f237011b.add(hotPicTagInfo);
            this.f237010a.put(hotPicTagInfo.tagId, hotPicTagInfo);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f237011b.clear();
            this.f237010a.clear();
        }
    }

    public HotPicTagInfo c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HotPicTagInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f237010a.get(i3);
    }

    public HotPicTagInfo d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HotPicTagInfo) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return this.f237011b.get(i3);
    }

    public List<HotPicTagInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f237011b;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f237011b.size();
    }
}
