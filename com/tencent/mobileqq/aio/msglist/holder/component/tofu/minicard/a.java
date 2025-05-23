package com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f192057a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f192058b;

    /* renamed from: c, reason: collision with root package name */
    public e f192059c;

    /* renamed from: d, reason: collision with root package name */
    public List<c> f192060d;

    /* renamed from: e, reason: collision with root package name */
    public f f192061e;

    /* renamed from: f, reason: collision with root package name */
    public C7322a f192062f;

    /* renamed from: g, reason: collision with root package name */
    public d f192063g;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7322a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f192064a;

        /* renamed from: b, reason: collision with root package name */
        public String f192065b;

        /* renamed from: c, reason: collision with root package name */
        public long f192066c;

        /* renamed from: d, reason: collision with root package name */
        public long f192067d;

        /* renamed from: e, reason: collision with root package name */
        public String f192068e;

        public C7322a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f192069a;

        /* renamed from: b, reason: collision with root package name */
        public int f192070b;

        /* renamed from: c, reason: collision with root package name */
        public String f192071c;

        /* renamed from: d, reason: collision with root package name */
        public String f192072d;

        /* renamed from: e, reason: collision with root package name */
        public int f192073e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f192069a = -1;
            this.f192070b = -1;
            this.f192071c = "";
            this.f192072d = "";
            this.f192073e = -1;
        }

        public boolean a() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f192069a > 0 || (i3 = this.f192070b) == 1 || i3 == 2 || !TextUtils.isEmpty(this.f192071c) || !TextUtils.isEmpty(this.f192072d) || this.f192073e > 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "age=" + this.f192069a + "|gender=" + this.f192070b + "|place=" + this.f192071c + "|addSrc=" + this.f192072d + "|commFrdCnt=" + this.f192073e + "|";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f192074a;

        /* renamed from: b, reason: collision with root package name */
        public String f192075b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f192074a = "";
                this.f192075b = "";
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "oriUrl=" + this.f192074a + "|mediumUrl=" + this.f192075b + "|";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public List<String> f192076a;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f192077b;

        /* renamed from: c, reason: collision with root package name */
        public List<Boolean> f192078c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f192079d;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            List<String> list = this.f192076a;
            if (list != null && list.size() != 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "QCircleInfo{mPicUrls=" + this.f192076a + ", mJumpSchema=" + this.f192077b + ", mIsPicList=" + this.f192078c + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f192080a;

        /* renamed from: b, reason: collision with root package name */
        public String f192081b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f192082c;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f192080a = "";
            this.f192081b = "";
            this.f192082c = new ArrayList();
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            List<String> list = this.f192082c;
            if (list != null && list.size() != 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "qzoneName=" + this.f192080a + "|updateContent=" + this.f192081b + "|imgUrls=" + Arrays.toString(this.f192082c.toArray()) + "|";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f192083a;

        /* renamed from: b, reason: collision with root package name */
        public String f192084b;

        /* renamed from: c, reason: collision with root package name */
        public String f192085c;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f192083a = 0;
            this.f192084b = "";
            this.f192085c = "";
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "actionId=" + this.f192083a + "|actionAndData=" + this.f192084b + "|plainText=" + this.f192085c + "|";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f192058b = new ArrayList();
            this.f192060d = new ArrayList();
        }
    }

    public boolean a() {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        b bVar = this.f192057a;
        if (bVar != null && !bVar.a()) {
            return false;
        }
        List<String> list = this.f192058b;
        if (list != null && list.size() > 0) {
            return false;
        }
        d dVar = this.f192063g;
        if (dVar != null && !dVar.a() && (!this.f192063g.f192079d || (eVar = this.f192059c) == null || eVar.a())) {
            return false;
        }
        e eVar2 = this.f192059c;
        if (eVar2 != null && !eVar2.a()) {
            return false;
        }
        List<c> list2 = this.f192060d;
        if ((list2 != null && list2.size() > 0) || this.f192061e != null || this.f192062f != null) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "baseProfile=" + this.f192057a + "|\npersonalLabels=" + Arrays.toString(this.f192058b.toArray()) + "|\nqZoneInfo=" + this.f192059c + "|\nnicePics=" + Arrays.toString(this.f192060d.toArray()) + "|\nsign=" + this.f192061e + "|\naskAnonymously=" + this.f192062f + "|\n";
    }
}
