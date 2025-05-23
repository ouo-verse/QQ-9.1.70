package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f243141a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<d> f243142b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<f> f243143c;

    /* renamed from: d, reason: collision with root package name */
    private int f243144d;

    /* renamed from: e, reason: collision with root package name */
    private d f243145e;

    /* renamed from: f, reason: collision with root package name */
    private int f243146f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public int f243147g;

    public b(int i3, int i16, ArrayList<d> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), arrayList);
            return;
        }
        this.f243143c = new ArrayList<>();
        this.f243144d = 0;
        this.f243141a = i3;
        this.f243147g = i16;
        this.f243142b = arrayList;
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
            return;
        }
        this.f243141a = bVar.f243141a;
        this.f243147g = bVar.f243147g;
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList == null) {
            this.f243142b = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Iterator<d> it = bVar.f243142b.iterator();
        while (it.hasNext()) {
            this.f243142b.add(it.next().b());
        }
        this.f243144d = bVar.i();
        Log.d("Lyric", "copy -> mType : " + this.f243141a);
    }

    public int b(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, i3)).intValue();
        }
        int i17 = 0;
        if (i3 < 0) {
            Log.w("Lyric", "findEndLineByStartTime -> illegal time");
            return 0;
        }
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList == null) {
            Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
            return -1;
        }
        int size = arrayList.size();
        int i18 = 0;
        while (true) {
            if (i18 < size) {
                d dVar = arrayList.get(i18);
                if (dVar != null && i3 <= dVar.f243149b) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3)).intValue();
        }
        return d(i3);
    }

    public int d(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, i3)).intValue();
        }
        if (i3 < 0) {
            Log.w("Lyric", "findLineNoByStartTime -> illegal time");
            return -1;
        }
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList != null && arrayList.size() != 0) {
            d dVar = this.f243145e;
            if (dVar != null) {
                long j3 = dVar.f243149b;
                long j16 = i3;
                if (j3 < j16 && j3 + dVar.f243150c > j16) {
                    return this.f243146f;
                }
            }
            ArrayList<d> arrayList2 = this.f243142b;
            int size = arrayList2.size();
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i18 < size) {
                    d dVar2 = arrayList2.get(i18);
                    if (dVar2 != null && dVar2.f243149b > i3) {
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
                i17 = size - 1;
            }
            this.f243146f = i17;
            this.f243145e = arrayList2.get(i17);
            return i17;
        }
        Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
        return -1;
    }

    public void e(Paint paint, Paint paint2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, paint, paint2, Integer.valueOf(i3));
        } else {
            f(paint, paint2, i3, false, false);
        }
    }

    public void f(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f243143c.clear();
        this.f243144d = 0;
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.a(paint, paint2, i3, z16, z17);
                this.f243144d += next.c();
                this.f243143c.addAll(next.f243151d);
            }
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (j()) {
            return 0;
        }
        d dVar = this.f243142b.get(r0.size() - 1);
        return (int) (dVar.f243149b + dVar.f243150c);
    }

    public List<d> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f243142b;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f243144d;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList != null && arrayList.size() != 0) {
            return false;
        }
        return true;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f243145e = null;
        }
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        ArrayList<d> arrayList = this.f243142b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f243142b == null) {
            return null;
        }
        for (int i3 = 0; i3 < this.f243142b.size(); i3++) {
            d dVar = this.f243142b.get(i3);
            sb5.append(i3);
            sb5.append(":");
            sb5.append(dVar.f243149b);
            sb5.append(":");
            sb5.append(dVar.f243148a);
            sb5.append(":");
            sb5.append(dVar.f243150c + dVar.f243149b);
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
