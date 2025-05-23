package com.tencent.lyric.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f147083a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Integer> f147084b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Integer> f147085c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<int[]> f147086d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<int[]> f147087e;

    /* compiled from: P */
    /* renamed from: com.tencent.lyric.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C7007a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f147088a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13769);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f147088a = new a();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f147084b = new ArrayList<>();
        this.f147085c = new ArrayList<>();
        this.f147086d = new ArrayList<>();
        this.f147087e = new ArrayList<>();
    }

    public static a a() {
        return C7007a.f147088a;
    }

    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        if (i3 < 0 || i3 > this.f147083a || this.f147084b.size() <= i3) {
            return -1;
        }
        return this.f147084b.get(i3).intValue();
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (i3 < 0 || i3 > this.f147083a || this.f147085c.size() <= i3) {
            return -1;
        }
        return this.f147085c.get(i3).intValue();
    }

    public boolean d(int i3, int i16) {
        ArrayList<int[]> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        int i17 = i16 * 2;
        if (i3 >= 0 && i3 <= this.f147083a && (arrayList = this.f147087e) != null && i3 < arrayList.size()) {
            int[] iArr = this.f147087e.get(i3);
            if (i16 >= 0 && i17 < iArr.length) {
                if (iArr[i17] > 0) {
                    return true;
                }
                int i18 = i17 - 1;
                if (i18 >= 0 && iArr[i18] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e(int i3) {
        ArrayList<int[]> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        if (i3 >= 0 && i3 <= this.f147083a && (arrayList = this.f147087e) != null && i3 < arrayList.size()) {
            int[] iArr = this.f147087e.get(i3);
            if (iArr.length > 1 && iArr[iArr.length - 1] > 0) {
                return true;
            }
        }
        return false;
    }
}
