package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.Nullable;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class KidModeObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    static final HashMap<Integer, k> f290902d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ClearPasswordResult extends ResultBase {
        static IPatchRedirector $redirector_;

        public ClearPasswordResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class QueryPasswordStateResult extends ResultBase {
        static IPatchRedirector $redirector_;
        public int passwordState;
        public String salt;

        public QueryPasswordStateResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.passwordState = 0;
                this.salt = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ResultBase implements Serializable {
        static IPatchRedirector $redirector_;
        public int errCode;
        public String errMessage;

        ResultBase() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.errCode = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class SetNewPasswordResult extends ResultBase {
        static IPatchRedirector $redirector_;
        public String token;

        public SetNewPasswordResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class VerifyPasswordResult extends ResultBase {
        static IPatchRedirector $redirector_;
        public String token;

        public VerifyPasswordResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements k {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.b((ClearPasswordResult) bundle.getSerializable("NOTIFY_RESULT_OBJECT"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements k {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.d(z16, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements k {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.f(z16, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements k {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.h(z16, bundle.getInt("advance_setting_field"), bundle.getInt("advance_setting_value"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements k {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.g(z16, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements k {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.k(z16, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements k {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.e(z16, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements k {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            QueryPasswordStateResult queryPasswordStateResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                queryPasswordStateResult = (QueryPasswordStateResult) bundle.getSerializable("NOTIFY_RESULT_OBJECT");
            } else {
                queryPasswordStateResult = null;
            }
            kidModeObserver.c(queryPasswordStateResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements k {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.i((SetNewPasswordResult) bundle.getSerializable("NOTIFY_RESULT_OBJECT"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements k {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver.k
        public void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, kidModeObserver, Boolean.valueOf(z16), bundle);
            } else {
                kidModeObserver.j((VerifyPasswordResult) bundle.getSerializable("NOTIFY_RESULT_OBJECT"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface k {
        void a(KidModeObserver kidModeObserver, boolean z16, Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f290902d = new HashMap<>();
            a();
        }
    }

    public KidModeObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static void a() {
        HashMap<Integer, k> hashMap = f290902d;
        hashMap.put(3, new b());
        hashMap.put(4, new c());
        hashMap.put(1, new d());
        hashMap.put(2, new e());
        hashMap.put(5, new f());
        hashMap.put(7, new g());
        hashMap.put(8, new h());
        hashMap.put(9, new i());
        hashMap.put(10, new j());
        hashMap.put(11, new a());
    }

    public void b(ClearPasswordResult clearPasswordResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) clearPasswordResult);
        }
    }

    public void c(@Nullable QueryPasswordStateResult queryPasswordStateResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) queryPasswordStateResult);
        }
    }

    public void d(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), bundle);
        }
    }

    public void e(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle);
        }
    }

    public void f(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
        }
    }

    public void g(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), bundle);
        }
    }

    public void h(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void i(SetNewPasswordResult setNewPasswordResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) setNewPasswordResult);
        }
    }

    public void j(@Nullable VerifyPasswordResult verifyPasswordResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) verifyPasswordResult);
        }
    }

    public void k(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        k kVar = f290902d.get(Integer.valueOf(i3));
        if (kVar != null) {
            kVar.a(this, z16, bundle);
            return;
        }
        QLog.w("KidModeObserver", 1, "onReceive, unknown type " + i3);
    }
}
