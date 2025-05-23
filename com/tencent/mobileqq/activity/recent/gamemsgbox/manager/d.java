package com.tencent.mobileqq.activity.recent.gamemsgbox.manager;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.recent.gamemsgbox.repo.c f185544f;

    /* renamed from: h, reason: collision with root package name */
    private BusinessObserver f185545h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else {
                if (!(obj instanceof ie1.a)) {
                    return;
                }
                ie1.a aVar = (ie1.a) obj;
                if (i3 == 8224) {
                    d.this.g(aVar.f407561b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static d f185547a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21745);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f185547a = new d(null);
            }
        }
    }

    /* synthetic */ d(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
    }

    public static d f() {
        return b.f185547a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            QLog.d("GameMsgUserInfoManager", 1, "onGameUsrInfoChangedNotify: " + arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof gd1.a) {
                    gd1.a aVar = (gd1.a) next;
                    this.f185544f.a(aVar);
                    com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b.j().t(com.tencent.mobileqq.activity.recent.gamemsgbox.manager.b.j().l(aVar.f401938b), aVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void b(AppRuntime appRuntime, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) entityManager);
            return;
        }
        super.b(appRuntime, entityManager);
        AppInterface appInterface = this.f185537d;
        if (appInterface == null) {
            return;
        }
        appInterface.addObserver(this.f185545h);
        this.f185544f.e(this.f185538e);
    }

    @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.manager.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f185544f.c();
        AppInterface appInterface = this.f185537d;
        if (appInterface == null) {
            return;
        }
        appInterface.removeObserver(this.f185545h);
        super.c();
    }

    public gd1.a e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (gd1.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f185544f.d(str);
    }

    public void h(GameUserInfo gameUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gameUserInfo);
        } else if (gameUserInfo != null && !TextUtils.isEmpty(gameUserInfo.mRoleId)) {
            this.f185544f.b(gameUserInfo);
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185545h = new a();
            this.f185544f = new com.tencent.mobileqq.activity.recent.gamemsgbox.repo.c();
        }
    }
}
