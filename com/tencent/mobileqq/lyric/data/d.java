package com.tencent.mobileqq.lyric.data;

import android.graphics.Paint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f243148a;

    /* renamed from: b, reason: collision with root package name */
    public long f243149b;

    /* renamed from: c, reason: collision with root package name */
    public long f243150c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<f> f243151d;

    /* renamed from: e, reason: collision with root package name */
    public e f243152e;

    /* renamed from: f, reason: collision with root package name */
    public e f243153f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<a> f243154g;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243151d = new ArrayList<>();
        this.f243152e = new e();
        this.f243153f = new e();
    }

    public void a(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        int i16;
        int i17;
        int i18;
        ArrayList arrayList;
        int i19;
        int i26;
        int measureText;
        Paint paint3 = paint;
        Paint paint4 = paint2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 1;
        int i28 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, paint3, paint4, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f243151d.clear();
        int measureText2 = (int) paint3.measureText(this.f243148a);
        int measureText3 = (int) paint4.measureText(this.f243148a);
        if (measureText2 <= i3) {
            if (z17) {
                measureText = 0;
                i26 = 0;
            } else {
                i26 = (i3 - measureText2) >> 1;
                measureText = (i3 - ((int) paint4.measureText(this.f243148a))) >> 1;
            }
            this.f243151d.add(new f(this.f243148a, measureText, i26, measureText3, measureText2, this.f243154g));
            return;
        }
        if (z16) {
            this.f243151d.add(new f(this.f243148a, 0, 0, measureText3, measureText2, this.f243154g));
            return;
        }
        String[] b16 = c.b(this.f243148a, paint3, i3, i3);
        int length = b16.length;
        if (length > 0) {
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i46 = 0;
            int i47 = 0;
            while (i28 < length) {
                if (!z17) {
                    i46 = (i3 - ((int) paint4.measureText(b16[i28]))) >> i27;
                    i47 = (i3 - ((int) paint3.measureText(b16[i28]))) >> i27;
                }
                if (this.f243154g != null) {
                    i29 += b16[i28].length();
                    arrayList = new ArrayList();
                    while (true) {
                        if (i36 < this.f243154g.size()) {
                            a aVar = this.f243154g.get(i36);
                            if (i28 != 0 && i37 == i36) {
                                int length2 = i29 - b16[i28].length();
                                i39 = length2;
                                i38 = aVar.f243139c - length2;
                            }
                            int i48 = aVar.f243139c;
                            if (i48 <= i29 && aVar.f243140d >= i29) {
                                if (i28 == 0) {
                                    i16 = length;
                                    i19 = i29;
                                    i17 = i46;
                                    i18 = i47;
                                    arrayList.add(new a(aVar.f243137a, aVar.f243138b, i48, b16[i28].length()));
                                } else {
                                    i16 = length;
                                    i19 = i29;
                                    i17 = i46;
                                    i18 = i47;
                                    arrayList.add(new a(aVar.f243137a, aVar.f243138b, (i48 - i39) - i38, b16[i28].length()));
                                }
                                i36++;
                                i37 = i36;
                                i29 = i19;
                            } else {
                                int i49 = length;
                                int i56 = i29;
                                int i57 = i46;
                                int i58 = i47;
                                if (i28 == 0) {
                                    arrayList.add(aVar);
                                } else {
                                    arrayList.add(new a(aVar.f243137a, aVar.f243138b, (i48 - i39) - i38, (aVar.f243140d - i39) - i38));
                                }
                                i36++;
                                length = i49;
                                i29 = i56;
                                i46 = i57;
                                i47 = i58;
                            }
                        } else {
                            i16 = length;
                            i17 = i46;
                            i18 = i47;
                            break;
                        }
                    }
                } else {
                    i16 = length;
                    i17 = i46;
                    i18 = i47;
                    arrayList = null;
                }
                i46 = i17;
                i47 = i18;
                this.f243151d.add(new f(b16[i28], i46, i47, arrayList));
                i28++;
                paint3 = paint;
                paint4 = paint2;
                length = i16;
                i27 = 1;
            }
        }
    }

    public d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        d dVar = new d();
        dVar.f243148a = this.f243148a;
        dVar.f243150c = this.f243150c;
        dVar.f243149b = this.f243149b;
        if (this.f243154g != null) {
            ArrayList<a> arrayList = new ArrayList<>();
            dVar.f243154g = arrayList;
            arrayList.addAll(this.f243154g);
        }
        dVar.f243151d.addAll(this.f243151d);
        return dVar;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f243151d.size();
    }

    public ArrayList<f> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f243151d;
    }
}
