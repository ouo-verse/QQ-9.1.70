package com.tencent.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f147070a;

    /* renamed from: b, reason: collision with root package name */
    public long f147071b;

    /* renamed from: c, reason: collision with root package name */
    public long f147072c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<f> f147073d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<b> f147074e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<d> f147075f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<b> f147076g;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f147073d = new ArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean g(b bVar, b bVar2) {
        if (bVar2.f147064c >= bVar.f147064c && bVar2.f147065d <= bVar.f147065d) {
            return true;
        }
        return false;
    }

    private ArrayList<b> i(String str, String[] strArr, ArrayList<b> arrayList) {
        int i3;
        int i16;
        Iterator<b> it;
        int i17;
        int i18;
        int i19;
        int indexOf;
        int i26;
        int i27 = 1;
        if (strArr.length == 1) {
            return arrayList;
        }
        ArrayList<b> arrayList2 = new ArrayList<>();
        Iterator<b> it5 = arrayList.iterator();
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        while (it5.hasNext()) {
            b next = it5.next();
            if (i28 <= next.f147064c) {
                if (i29 == strArr.length - i27) {
                    i3 = this.f147070a.length();
                } else {
                    i36 += strArr[i29].length();
                    i29++;
                    i3 = str.indexOf(strArr[i29], i36);
                }
            } else {
                int i38 = i37;
                i3 = i28;
                i28 = i38;
            }
            if (next.f147064c >= i28 && i3 >= next.f147065d) {
                arrayList2.add(next);
                it = it5;
                i16 = i3;
                i37 = i28;
                i19 = i27;
            } else {
                i16 = i3;
                b bVar = next;
                while (true) {
                    int i39 = bVar.f147064c;
                    if (i39 < i16 && (i26 = bVar.f147065d) > i16) {
                        long j3 = ((((float) bVar.f147063b) * 1.0f) * (i16 - i39)) / (i26 - i39);
                        it = it5;
                        i17 = i28;
                        b bVar2 = bVar;
                        i18 = i16;
                        b bVar3 = new b(bVar.f147062a, j3, i39, i16);
                        b bVar4 = new b(bVar2.f147062a + j3, bVar2.f147063b - j3, i18, bVar2.f147065d);
                        arrayList2.add(bVar3);
                        bVar = bVar4;
                    } else {
                        it = it5;
                        i17 = i28;
                        i18 = i16;
                        bVar = bVar;
                    }
                    if (i18 < bVar.f147065d) {
                        i19 = 1;
                        if (i29 == strArr.length - 1) {
                            indexOf = this.f147070a.length();
                        } else {
                            i36 += strArr[i29].length();
                            i29++;
                            indexOf = str.indexOf(strArr[i29], i36);
                        }
                        i16 = indexOf;
                    } else {
                        i19 = 1;
                        i16 = i18;
                        i18 = i17;
                    }
                    if (i16 >= bVar.f147065d) {
                        break;
                    }
                    it5 = it;
                    i28 = i18;
                }
                arrayList2.add(bVar);
                i37 = i18;
            }
            it5 = it;
            i27 = i19;
            i28 = i16;
        }
        return arrayList2;
    }

    public void a(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, paint, paint2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16));
        } else {
            b(paint, paint2, i3, z16, z17, z18, i16, false);
        }
    }

    public void b(Paint paint, Paint paint2, int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19) {
        ArrayList<b> arrayList;
        int measureText;
        ArrayList<b> arrayList2;
        int i17;
        ArrayList arrayList3;
        int i18;
        f fVar;
        int i19;
        e eVar = this;
        Paint paint3 = paint;
        Paint paint4 = paint2;
        int i26 = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 1;
        int i28 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, eVar, paint3, paint4, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19));
            return;
        }
        eVar.f147073d.clear();
        int measureText2 = (int) paint3.measureText(eVar.f147070a);
        if (measureText2 <= i26) {
            if (z17) {
                i19 = 0;
            } else {
                i28 = (i26 - ((int) paint4.measureText(eVar.f147070a))) >> 1;
                i19 = (i26 - measureText2) >> 1;
            }
            eVar.f147073d.add(new f(eVar.f147070a, i28, i19, eVar.f147074e));
        } else if (z16) {
            if (z18) {
                for (int measureText3 = (int) paint3.measureText(eVar.f147070a); i26 > 0 && i26 <= measureText3; measureText3 = (int) paint3.measureText(eVar.f147070a)) {
                    paint3.setTextSize(paint.getTextSize() - 1.0f);
                }
                Log.i("Sentence", "generateUILyricLineList -> " + paint.getTextSize());
            }
            eVar.f147073d.add(new f(eVar.f147070a, 0, 0, eVar.f147074e));
        } else if (z19) {
            int measureText4 = (int) paint3.measureText(eVar.f147070a);
            String str = eVar.f147070a;
            Log.i("Sentence", "generateUILyricLineList -> before subtext " + str);
            while (i26 > 0 && i26 <= measureText4 && str.length() >= 2) {
                str = str.substring(0, str.length() - 2);
                measureText4 = (int) paint3.measureText(str);
            }
            Log.i("Sentence", "generateUILyricLineList -> after subtext " + str);
            eVar.f147073d.add(new f(str + MiniBoxNoticeInfo.APPNAME_SUFFIX, 0, 0, eVar.f147074e));
        } else {
            if (i16 > 0) {
                float measureText5 = paint3.measureText(eVar.f147070a);
                while (true) {
                    int i29 = (int) measureText5;
                    if (i26 <= 0 || i26 * i16 > i29) {
                        break;
                    }
                    paint3.setTextSize(paint.getTextSize() - 1.0f);
                    measureText5 = paint3.measureText(eVar.f147070a);
                }
                Log.i("Sentence", "generateUILyricLineList -> " + paint.getTextSize());
            }
            String[] b16 = c.b(eVar.f147070a, paint3, i26, i26);
            int length = b16.length;
            if (length > 0) {
                ArrayList<b> arrayList4 = eVar.f147074e;
                if (arrayList4 != null) {
                    arrayList = eVar.i(eVar.f147070a, b16, arrayList4);
                    eVar.f147076g = arrayList;
                } else {
                    arrayList = null;
                }
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i46 = 0;
                int i47 = 0;
                int i48 = 0;
                while (i28 < length) {
                    String str2 = b16[i28];
                    int length2 = str2.length();
                    if (z17) {
                        measureText = i48;
                    } else {
                        i47 = (i26 - ((int) paint4.measureText(str2))) >> i27;
                        measureText = (i26 - ((int) paint3.measureText(str2))) >> i27;
                    }
                    if (arrayList != null) {
                        i36 += length2;
                        arrayList3 = new ArrayList();
                        while (true) {
                            if (i37 < arrayList.size()) {
                                b bVar = arrayList.get(i37);
                                if (i28 != 0 && i38 == i37) {
                                    int i49 = i36 - length2;
                                    i46 = i49;
                                    i39 = bVar.f147064c - i49;
                                }
                                int i56 = bVar.f147064c;
                                if (i56 <= i36 && bVar.f147065d >= i36) {
                                    if (i28 == 0) {
                                        arrayList2 = arrayList;
                                        i17 = measureText;
                                        arrayList3.add(new b(bVar.f147062a, bVar.f147063b, i56, length2));
                                    } else {
                                        arrayList2 = arrayList;
                                        i17 = measureText;
                                        arrayList3.add(new b(bVar.f147062a, bVar.f147063b, (i56 - i46) - i39, length2));
                                    }
                                    i37++;
                                    i38 = i37;
                                } else {
                                    ArrayList<b> arrayList5 = arrayList;
                                    int i57 = measureText;
                                    if (i28 == 0) {
                                        arrayList3.add(bVar);
                                    } else {
                                        arrayList3.add(new b(bVar.f147062a, bVar.f147063b, (i56 - i46) - i39, (bVar.f147065d - i46) - i39));
                                    }
                                    i37++;
                                    arrayList = arrayList5;
                                    measureText = i57;
                                }
                            } else {
                                arrayList2 = arrayList;
                                i17 = measureText;
                                break;
                            }
                        }
                    } else {
                        arrayList2 = arrayList;
                        i17 = measureText;
                        arrayList3 = null;
                    }
                    if (i28 == 0) {
                        i18 = i17;
                        fVar = new f(b16[i28], i47, i18, arrayList3);
                    } else {
                        i18 = i17;
                        fVar = new f(b16[i28], i47, i18, arrayList3);
                    }
                    this.f147073d.add(fVar);
                    i28++;
                    paint4 = paint2;
                    i26 = i3;
                    arrayList = arrayList2;
                    eVar = this;
                    i48 = i18;
                    i27 = 1;
                    paint3 = paint;
                }
            }
        }
    }

    public e c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e eVar = new e();
        eVar.f147070a = this.f147070a;
        eVar.f147072c = this.f147072c;
        eVar.f147071b = this.f147071b;
        if (this.f147074e != null) {
            ArrayList<b> arrayList = new ArrayList<>();
            eVar.f147074e = arrayList;
            arrayList.addAll(this.f147074e);
        }
        eVar.f147073d.addAll(this.f147073d);
        return eVar;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<d> arrayList = this.f147075f;
        if (arrayList != null && !arrayList.isEmpty()) {
            String str = this.f147070a;
            if (str != null && !str.isEmpty()) {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    for (d dVar : arrayList) {
                        if (sb5.length() > 0) {
                            sb5.append("<seg>");
                        }
                        sb5.append(str.substring(dVar.f147068c, dVar.f147069d));
                    }
                    return sb5.toString();
                } catch (Exception unused) {
                }
            }
            return str;
        }
        return this.f147070a;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f147073d.size();
    }

    public ArrayList<f> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f147073d;
    }

    public int[] h(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) iArr);
        }
        ArrayList<b> arrayList = this.f147076g;
        if (arrayList == null) {
            return iArr;
        }
        int[] iArr2 = new int[arrayList.size()];
        int i3 = 0;
        for (int i16 = 0; i16 < this.f147074e.size(); i16++) {
            b bVar = this.f147074e.get(i16);
            while (i3 < this.f147076g.size() && g(bVar, this.f147076g.get(i3))) {
                iArr2[i3] = iArr[i16];
                i3++;
            }
        }
        return iArr2;
    }

    public e(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        this.f147073d = new ArrayList<>();
        if (fVar == null) {
            return;
        }
        this.f147070a = fVar.f147077a;
        this.f147074e = fVar.f147080d;
        this.f147071b = fVar.e();
        this.f147072c = fVar.d() - fVar.e();
    }
}
