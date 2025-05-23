package com.tencent.mobileqq.activity.qqsettingme.config;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.ac;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSettingMeBizBean implements Comparable<QQSettingMeBizBean> {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ac I;
    public String J;
    public String K;
    public Boolean L;

    /* renamed from: d, reason: collision with root package name */
    private String f184983d;

    /* renamed from: e, reason: collision with root package name */
    private b f184984e;

    /* renamed from: f, reason: collision with root package name */
    public int f184985f;

    /* renamed from: h, reason: collision with root package name */
    private String f184986h;

    /* renamed from: i, reason: collision with root package name */
    private String f184987i;

    /* renamed from: m, reason: collision with root package name */
    private a f184988m;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class ActionType {
        private static final /* synthetic */ ActionType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ActionType DEFAULT;
        public static final ActionType MINIAPP;
        public static final ActionType SCHEMA;
        public static final ActionType WEB;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35509);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ActionType actionType = new ActionType("DEFAULT", 0);
            DEFAULT = actionType;
            ActionType actionType2 = new ActionType("WEB", 1);
            WEB = actionType2;
            ActionType actionType3 = new ActionType("MINIAPP", 2);
            MINIAPP = actionType3;
            ActionType actionType4 = new ActionType("SCHEMA", 3);
            SCHEMA = actionType4;
            $VALUES = new ActionType[]{actionType, actionType2, actionType3, actionType4};
        }

        ActionType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ActionType f184989a;

        /* renamed from: b, reason: collision with root package name */
        public String f184990b;

        public a(ActionType actionType, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) actionType, (Object) str);
            } else {
                this.f184989a = actionType;
                this.f184990b = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f184991a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f184992b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f184991a = str;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }

        public b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f184991a = str;
                this.f184992b = str2;
            }
        }
    }

    public QQSettingMeBizBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.L = Boolean.FALSE;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(QQSettingMeBizBean qQSettingMeBizBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQSettingMeBizBean)).intValue();
        }
        int i3 = this.C;
        int i16 = qQSettingMeBizBean.C;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    public a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f184988m;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f184987i;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f184985f;
    }

    public ac k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ac) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.I;
    }

    public TianshuRedTouch l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        ac acVar = this.I;
        if (acVar == null) {
            return null;
        }
        return acVar.a();
    }

    public View m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (View) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        ac acVar = this.I;
        if (acVar == null) {
            return null;
        }
        return acVar.d();
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f184983d;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f184986h;
    }

    public RedTouchTextView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (RedTouchTextView) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        ac acVar = this.I;
        if (acVar == null) {
            return null;
        }
        return acVar.b();
    }

    public RedTouch q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (RedTouch) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        ac acVar = this.I;
        if (acVar == null) {
            return null;
        }
        return acVar.c();
    }

    public b r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f184984e;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.E;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.H;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.F;
    }

    public void w(ac acVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) acVar);
        } else {
            this.I = acVar;
        }
    }

    public void x(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) charSequence);
        } else {
            this.f184984e.f184991a = charSequence;
        }
    }

    public QQSettingMeBizBean(String str, int i3, b bVar, int i16, a aVar, String str2, String str3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        this(str, i3, bVar, i16, aVar, str2, str3, z16, z17, z18, z19, z26, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), bVar, Integer.valueOf(i16), aVar, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26));
    }

    public QQSettingMeBizBean(String str, int i3, b bVar, int i16, a aVar, String str2, String str3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), bVar, Integer.valueOf(i16), aVar, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27));
            return;
        }
        this.L = Boolean.FALSE;
        this.f184983d = str;
        this.C = i3;
        this.f184984e = bVar;
        this.f184985f = i16;
        this.f184988m = aVar;
        this.f184986h = str2;
        this.f184987i = str3;
        this.D = z16;
        this.E = z17;
        this.F = z18;
        this.G = z19;
        this.H = z26;
        this.L = Boolean.valueOf(z27);
    }

    public QQSettingMeBizBean(String str, int i3, b bVar, String str2, String str3, a aVar, String str4, String str5, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), bVar, str2, str3, aVar, str4, str5, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.L = Boolean.FALSE;
        this.f184983d = str;
        this.C = i3;
        this.f184984e = bVar;
        this.J = str2;
        this.K = str3;
        this.f184988m = aVar;
        this.f184986h = str4;
        this.f184987i = str5;
        this.D = z16;
        this.E = z17;
        this.F = z18;
        this.G = z19;
        this.H = z26;
    }
}
