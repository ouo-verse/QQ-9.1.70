package com.tencent.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f147055a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<e> f147056b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<f> f147057c;

    /* renamed from: d, reason: collision with root package name */
    private int f147058d;

    /* renamed from: e, reason: collision with root package name */
    private e f147059e;

    /* renamed from: f, reason: collision with root package name */
    private int f147060f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public int f147061g;

    public a(int i3, int i16, ArrayList<e> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), arrayList);
            return;
        }
        this.f147057c = new ArrayList<>();
        this.f147058d = 0;
        this.f147055a = i3;
        this.f147061g = i16;
        this.f147056b = arrayList;
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
            return;
        }
        this.f147055a = aVar.f147055a;
        this.f147061g = aVar.f147061g;
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList == null) {
            this.f147056b = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Iterator<e> it = aVar.f147056b.iterator();
        while (it.hasNext()) {
            this.f147056b.add(it.next().c());
        }
        this.f147058d = aVar.q();
    }

    public int b(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, i3)).intValue();
        }
        int i17 = 0;
        if (i3 < 0) {
            Log.w("Lyric", "findEndLineByStartTime -> illegal time");
            return 0;
        }
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList == null) {
            Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
            return -1;
        }
        int size = arrayList.size();
        int i18 = 0;
        while (true) {
            if (i18 < size) {
                e eVar = arrayList.get(i18);
                if (eVar != null && i3 <= eVar.f147071b) {
                    i16 = i18 - 1;
                    break;
                }
                i18++;
            } else {
                i16 = 0;
                break;
            }
        }
        if (i16 >= 0) {
            i17 = i16;
        }
        if (i18 == size) {
            return size - 1;
        }
        return i17;
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        return d(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d(int i3) {
        int i16;
        int i17;
        int i18;
        e m3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this, i3)).intValue();
        }
        if (i3 < 0) {
            Log.w("Lyric", "findLineNoByStartTime -> illegal time");
            return -1;
        }
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<e> arrayList2 = this.f147056b;
            int size = arrayList2.size();
            e eVar = this.f147059e;
            int i19 = 0;
            if (eVar != null) {
                long j16 = i3;
                if (eVar.f147071b < j16) {
                    int i26 = this.f147060f;
                    if (i26 < size - 1) {
                        if (arrayList2.get(i26 + 1).f147071b > j16) {
                            return this.f147060f;
                        }
                        i16 = this.f147060f;
                        while (true) {
                            if (i16 < size) {
                                e eVar2 = arrayList2.get(i16);
                                if (eVar2 != null && eVar2.f147071b > i3) {
                                    i17 = i16 - 1;
                                    break;
                                }
                                i16++;
                            } else {
                                i17 = 0;
                                break;
                            }
                        }
                        if (i17 >= 0) {
                            i19 = i17;
                        }
                        if (i16 == size) {
                            i19 = size - 1;
                        }
                        i18 = i19 + 1;
                        m3 = m(i19);
                        e m16 = m(i18);
                        if (m3 != null && m16 != null) {
                            j3 = i3;
                            if (m3.f147071b + m3.f147072c < j3 && m16.f147071b >= j3) {
                                i19 = i18;
                            }
                        }
                        this.f147060f = i19;
                        this.f147059e = arrayList2.get(i19);
                        return i19;
                    }
                    return i26;
                }
            }
            i16 = 0;
            while (true) {
                if (i16 < size) {
                }
                i16++;
            }
            if (i17 >= 0) {
            }
            if (i16 == size) {
            }
            i18 = i19 + 1;
            m3 = m(i19);
            e m162 = m(i18);
            if (m3 != null) {
                j3 = i3;
                if (m3.f147071b + m3.f147072c < j3) {
                    i19 = i18;
                }
            }
            this.f147060f = i19;
            this.f147059e = arrayList2.get(i19);
            return i19;
        }
        Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
        return -1;
    }

    public void e(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f147057c.clear();
        this.f147058d = 0;
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            int i19 = -1;
            while (it.hasNext()) {
                e next = it.next();
                i19++;
                if (i19 >= i17) {
                    if (i19 <= i18) {
                        next.a(paint, paint2, i3, z16, z17, z18, i16);
                        this.f147058d += next.e();
                        this.f147057c.addAll(next.f147073d);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void f(Paint paint, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, paint, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            g(paint, i3, z16, 0);
        }
    }

    public void g(Paint paint, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, paint, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
            return;
        }
        this.f147057c.clear();
        this.f147058d = 0;
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.f147074e != null) {
                    next.a(paint, paint, (i3 * 4) / 5, false, true, z16, i16);
                    this.f147058d += next.e();
                    this.f147057c.addAll(next.f147073d);
                } else {
                    Log.i("Lyric", "generateUILyricLineList: mCharacters is null");
                    next.a(paint, paint, (i3 * 4) / 5, true, true, true, 1);
                }
            }
        }
    }

    public void h(Paint paint, Paint paint2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, paint, paint2, Integer.valueOf(i3));
        } else {
            j(paint, paint2, i3, false, false, false);
        }
    }

    public void i(Paint paint, Paint paint2, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            j(paint, paint2, i3, z16, false, false);
        }
    }

    public void j(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.f147057c.clear();
        this.f147058d = 0;
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                next.a(paint, paint2, i3, z16, z17, z18, 0);
                this.f147058d += next.e();
                this.f147057c.addAll(next.f147073d);
            }
        }
    }

    public void k(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16));
        } else {
            l(paint, paint2, i3, z16, z17, z18, i16, false);
        }
    }

    public void l(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19));
            return;
        }
        this.f147057c.clear();
        this.f147058d = 0;
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                next.b(paint, paint2, i3, z16, z17, z18, i16, z19);
                this.f147058d += next.e();
                this.f147057c.addAll(next.f147073d);
            }
        }
    }

    public e m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (e) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        if (t() || this.f147056b.size() <= i3) {
            return null;
        }
        return this.f147056b.get(i3);
    }

    public int n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this, i3)).intValue();
        }
        return com.tencent.lyric.util.a.a().b(i3);
    }

    public List<e> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f147056b;
    }

    public int p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, i3)).intValue();
        }
        return com.tencent.lyric.util.a.a().c(i3);
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f147058d;
    }

    public boolean r(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        return com.tencent.lyric.util.a.a().d(i3, i16);
    }

    public boolean s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, i3)).booleanValue();
        }
        return com.tencent.lyric.util.a.a().e(i3);
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null && arrayList.size() != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f147056b == null) {
            return null;
        }
        for (int i3 = 0; i3 < this.f147056b.size(); i3++) {
            e eVar = this.f147056b.get(i3);
            sb5.append(i3);
            sb5.append(":");
            sb5.append(eVar.f147071b);
            sb5.append(":");
            sb5.append(eVar.d());
            sb5.append(":");
            sb5.append(eVar.f147072c + eVar.f147071b);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public void u(List<f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
            return;
        }
        if (this.f147057c == null) {
            this.f147057c = new ArrayList<>();
        }
        this.f147057c.clear();
        this.f147057c.addAll(list);
        this.f147058d = this.f147057c.size();
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        ArrayList<e> arrayList = this.f147056b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
