package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected static final int[] f185638e;

    /* renamed from: f, reason: collision with root package name */
    protected static final int[] f185639f;

    /* renamed from: g, reason: collision with root package name */
    protected static final int[] f185640g;

    /* renamed from: h, reason: collision with root package name */
    protected static final int[] f185641h;

    /* renamed from: i, reason: collision with root package name */
    protected static final int[] f185642i;

    /* renamed from: j, reason: collision with root package name */
    protected static final int[] f185643j;

    /* renamed from: k, reason: collision with root package name */
    protected static final int[] f185644k;

    /* renamed from: l, reason: collision with root package name */
    protected static final int[] f185645l;

    /* renamed from: m, reason: collision with root package name */
    protected static final int[] f185646m;

    /* renamed from: n, reason: collision with root package name */
    protected static final int[] f185647n;

    /* renamed from: o, reason: collision with root package name */
    protected static final int[] f185648o;

    /* renamed from: p, reason: collision with root package name */
    protected static final int[] f185649p;

    /* renamed from: q, reason: collision with root package name */
    protected static final int[] f185650q;

    /* renamed from: a, reason: collision with root package name */
    protected int f185651a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f185652b;

    /* renamed from: c, reason: collision with root package name */
    protected RecentAdapter f185653c;

    /* renamed from: d, reason: collision with root package name */
    protected j[] f185654d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f185638e = new int[]{0};
        f185639f = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        f185640g = new int[]{0, 1, 2, 3};
        f185641h = new int[]{0, 1};
        f185642i = new int[]{0, 1, 2, 3};
        f185643j = new int[]{0, 1};
        f185644k = new int[]{0, 1, 2};
        f185645l = new int[]{0, 1, 2};
        f185646m = new int[]{0, 1, 2};
        f185647n = new int[]{0, 1, 2};
        f185648o = new int[]{0, 1, 2};
        f185649p = new int[]{0, 1, 2, 3};
        f185650q = new int[]{0, 1, 2, 3};
    }

    public k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f185651a = i3;
        if (i3 == 0) {
            this.f185652b = f185639f;
        } else if (i3 == 1) {
            this.f185652b = f185642i;
        } else if (i3 == 5) {
            this.f185652b = f185647n;
        } else if (i3 == 6) {
            this.f185652b = f185640g;
        } else if (i3 == 7) {
            this.f185652b = f185641h;
        } else if (i3 == 9) {
            this.f185652b = f185648o;
        } else if (i3 == 11) {
            this.f185652b = f185649p;
        } else if (i3 == 12) {
            this.f185652b = f185646m;
        } else if (i3 == 13) {
            this.f185652b = f185650q;
        } else if (i3 == 14) {
            this.f185652b = f185643j;
        } else if (i3 == 15) {
            this.f185652b = f185644k;
        } else if (i3 == 17) {
            this.f185652b = f185645l;
        } else {
            this.f185652b = f185638e;
        }
        this.f185654d = new j[this.f185652b.length];
    }

    @Nullable
    private j a(int i3) {
        return null;
    }

    private int b(Object obj, int i3) {
        if (obj instanceof RecentItemConfessMsg) {
            return this.f185652b[1];
        }
        boolean z16 = obj instanceof Integer;
        if (z16 && ((Integer) obj).intValue() == 16) {
            return this.f185652b[2];
        }
        if (z16 && ((Integer) obj).intValue() == 17) {
            return this.f185652b[3];
        }
        return i3;
    }

    private j c(int i3) {
        return null;
    }

    private int d(Object obj, int i3) {
        if (obj instanceof RecentBaseData) {
            return this.f185652b[1];
        }
        return i3;
    }

    private j e(int i3) {
        if (i3 == 2) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[2] == null) {
                jVarArr[2] = new h();
            }
            return this.f185654d[2];
        }
        return null;
    }

    private int f(Object obj, int i3) {
        int i16;
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() == 18) {
                i16 = this.f185652b[1];
            } else if (num.intValue() == 19) {
                i16 = this.f185652b[1];
            } else {
                return i3;
            }
            return i16;
        }
        if (obj instanceof RecentBaseData) {
            return this.f185652b[2];
        }
        return i3;
    }

    @Nullable
    private j j(int i3) {
        return null;
    }

    private int k(Object obj, int i3) {
        if (obj instanceof RecentMatchChatListItem) {
            return this.f185652b[1];
        }
        boolean z16 = obj instanceof Integer;
        if (z16 && ((Integer) obj).intValue() == 20) {
            return this.f185652b[2];
        }
        if (z16 && ((Integer) obj).intValue() == 21) {
            return this.f185652b[3];
        }
        return i3;
    }

    private j l(int i3) {
        if (i3 == 1) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[1] == null) {
                jVarArr[1] = new h();
            }
            return this.f185654d[1];
        }
        return null;
    }

    private int m(Object obj, int i3) {
        if (obj instanceof String) {
            return this.f185652b[0];
        }
        if (obj instanceof RecentMsgBoxItem) {
            return this.f185652b[1];
        }
        return i3;
    }

    private int n(Object obj, int i3) {
        int i16;
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() == 11) {
                i16 = this.f185652b[1];
            } else if (num.intValue() == 12) {
                i16 = this.f185652b[1];
            } else {
                return i3;
            }
            return i16;
        }
        if (obj instanceof RecentBaseData) {
            return this.f185652b[2];
        }
        return i3;
    }

    private j o(int i3) {
        if (i3 == 2) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[2] == null) {
                jVarArr[2] = new h();
            }
            return this.f185654d[2];
        }
        return null;
    }

    private int p(Object obj, int i3) {
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return this.f185652b[1];
            }
            return i3;
        }
        if (obj instanceof String) {
            return this.f185652b[0];
        }
        return i3;
    }

    private j q(int i3) {
        return null;
    }

    private j r(int i3) {
        return null;
    }

    private j s(int i3) {
        return null;
    }

    private int t(Object obj, int i3) {
        if (obj instanceof RecentBaseData) {
            return this.f185652b[1];
        }
        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 23) {
            return this.f185652b[0];
        }
        return i3;
    }

    private j u(int i3) {
        if (i3 == 2) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[2] == null) {
                jVarArr[2] = new h();
            }
            return this.f185654d[2];
        }
        return null;
    }

    private int v(Object obj, int i3) {
        int i16;
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() == 3) {
                i16 = this.f185652b[3];
            } else if (num.intValue() == 4) {
                i16 = this.f185652b[1];
            } else if (num.intValue() == 5) {
                i16 = this.f185652b[1];
            } else {
                return i3;
            }
            return i16;
        }
        if (obj instanceof RecentBaseData) {
            return this.f185652b[2];
        }
        return i3;
    }

    private j w(int i3) {
        if (i3 == 1) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[1] == null) {
                jVarArr[1] = new f();
            }
            return this.f185654d[1];
        }
        if (i3 == 2) {
            j[] jVarArr2 = this.f185654d;
            if (jVarArr2[2] == null) {
                jVarArr2[2] = new h();
            }
            return this.f185654d[2];
        }
        return null;
    }

    private int x(Object obj, int i3) {
        if (obj instanceof Integer) {
            return this.f185652b[1];
        }
        if (obj instanceof RecentBaseData) {
            return this.f185652b[2];
        }
        return i3;
    }

    public j g(Object obj) {
        j q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j) iPatchRedirector.redirect((short) 6, (Object) this, obj);
        }
        int i3 = i(obj);
        int i16 = this.f185651a;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 5) {
                    if (i16 != 6) {
                        if (i16 != 7) {
                            if (i16 != 9) {
                                switch (i16) {
                                    case 11:
                                        q16 = a(i3);
                                        break;
                                    case 12:
                                        q16 = e(i3);
                                        break;
                                    case 13:
                                        q16 = j(i3);
                                        break;
                                    case 14:
                                        q16 = c(i3);
                                        break;
                                    case 15:
                                        q16 = s(i3);
                                        break;
                                    default:
                                        q16 = null;
                                        break;
                                }
                            } else {
                                q16 = o(i3);
                            }
                        } else {
                            q16 = r(i3);
                        }
                    } else {
                        q16 = l(i3);
                    }
                } else {
                    q16 = w(i3);
                }
            } else {
                q16 = u(i3);
            }
        } else {
            q16 = q(i3);
        }
        if (q16 == null) {
            j[] jVarArr = this.f185654d;
            if (jVarArr[0] == null) {
                jVarArr[0] = new f();
            }
            q16 = this.f185654d[0];
        }
        q16.g(this.f185653c);
        return q16;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f185651a;
    }

    public int i(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, obj)).intValue();
        }
        int i3 = this.f185652b[0];
        int i16 = this.f185651a;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 5) {
                    if (i16 != 6) {
                        if (i16 != 9) {
                            switch (i16) {
                                case 11:
                                    return b(obj, i3);
                                case 12:
                                    return f(obj, i3);
                                case 13:
                                    return k(obj, i3);
                                case 14:
                                    return d(obj, i3);
                                case 15:
                                    return t(obj, i3);
                                default:
                                    return i3;
                            }
                        }
                        return n(obj, i3);
                    }
                    return m(obj, i3);
                }
                return x(obj, i3);
            }
            return v(obj, i3);
        }
        return p(obj, i3);
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f185652b.length;
    }

    public void z(RecentAdapter recentAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentAdapter);
        } else {
            this.f185653c = recentAdapter;
        }
    }
}
