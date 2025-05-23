package com.tencent.mobileqq.qqgamepub.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqgamepub.view.a> f264606a;

    /* renamed from: b, reason: collision with root package name */
    private List<QQGameMsgInfo> f264607b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f264608c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f264606a = new ArrayList();
        this.f264607b = new ArrayList();
        this.f264608c = new byte[0];
    }

    public void a(int i3, com.tencent.mobileqq.qqgamepub.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) aVar);
        } else if (aVar != null) {
            synchronized (this.f264608c) {
                this.f264606a.add(i3, aVar);
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.f264606a != null) {
            for (int i3 = 0; i3 < this.f264606a.size(); i3++) {
                if (this.f264606a.get(i3) instanceof GameArkView) {
                    ((GameArkView) this.f264606a.get(i3)).e();
                    if (QLog.isColorLevel()) {
                        QLog.d("GameMsgDataModel", 2, "header destroy i=" + i3);
                    }
                }
            }
            this.f264606a.clear();
        }
    }

    public com.tencent.mobileqq.qqgamepub.view.a c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        List<com.tencent.mobileqq.qqgamepub.view.a> list = this.f264606a;
        if (list != null && i3 < list.size()) {
            return this.f264606a.get(i3);
        }
        return null;
    }

    public QQGameMsgInfo d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QQGameMsgInfo) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        List<QQGameMsgInfo> list = this.f264607b;
        if (list != null && i3 < list.size()) {
            return this.f264607b.get(i3);
        }
        return null;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f264606a.size();
    }

    public List<com.tencent.mobileqq.qqgamepub.view.a> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f264606a;
    }

    public List<QQGameMsgInfo> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f264607b;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f264607b.size();
    }

    public boolean i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3)).booleanValue();
        }
        if (i3 == this.f264606a.size() - 1) {
            return true;
        }
        return false;
    }

    public boolean j(com.tencent.mobileqq.qqgamepub.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar)).booleanValue();
        }
        return aVar instanceof MoreMsgHeaderView;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        List<QQGameMsgInfo> list = this.f264607b;
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public boolean l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        if (i3 < this.f264606a.size() - 1) {
            return true;
        }
        return false;
    }

    public boolean m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3)).booleanValue();
        }
        if (i3 < this.f264606a.size()) {
            return true;
        }
        return false;
    }

    public void n(List<com.tencent.mobileqq.qqgamepub.view.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.f264606a.clear();
            this.f264606a.addAll(list);
        }
    }

    public void o(List<QQGameMsgInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.f264607b.clear();
            this.f264607b.addAll(list);
        }
    }
}
