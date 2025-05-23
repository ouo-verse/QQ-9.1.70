package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class bm {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Conversation f180603a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, ConversationTitleBtnCtrl> f180604b;

    public bm(Conversation conversation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
        } else {
            this.f180604b = new HashMap();
            this.f180603a = conversation;
        }
    }

    private void m() {
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).q();
        }
    }

    private void n() {
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).r();
        }
    }

    public ConversationTitleBtnCtrl a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConversationTitleBtnCtrl) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        ConversationTitleBtnCtrl conversationTitleBtnCtrl = new ConversationTitleBtnCtrl(this.f180603a);
        this.f180604b.put(Integer.valueOf(i3), conversationTitleBtnCtrl);
        return conversationTitleBtnCtrl;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).d();
        }
    }

    public ConversationTitleBtnCtrl c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConversationTitleBtnCtrl) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.f180604b.get(Integer.valueOf(i3));
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).i();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).j();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).k();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).l();
        }
        this.f180604b.clear();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).m();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).n();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).o();
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).p(z16);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            n();
            m();
        }
    }

    public void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f180604b.remove(Integer.valueOf(i3));
        }
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).u(i3);
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).v(i3);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).w();
        }
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        Iterator<Integer> it = this.f180604b.keySet().iterator();
        while (it.hasNext()) {
            this.f180604b.get(Integer.valueOf(it.next().intValue())).x(z16);
        }
    }
}
