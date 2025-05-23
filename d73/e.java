package d73;

import android.graphics.Paint;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f393180a;

    /* renamed from: b, reason: collision with root package name */
    public long f393181b;

    /* renamed from: c, reason: collision with root package name */
    public long f393182c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<g> f393183d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public f f393184e = new f();

    /* renamed from: f, reason: collision with root package name */
    public f f393185f = new f();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<a> f393186g;

    public e() {
    }

    public void a(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        int i16;
        int i17;
        int i18;
        ArrayList arrayList;
        int i19;
        int measureText;
        int i26;
        Paint paint3 = paint;
        Paint paint4 = paint2;
        this.f393183d.clear();
        int measureText2 = (int) paint3.measureText(this.f393180a);
        int measureText3 = (int) paint4.measureText(this.f393180a);
        int i27 = 0;
        if (measureText2 <= i3) {
            if (z17) {
                measureText = 0;
                i26 = 0;
            } else {
                measureText = (i3 - ((int) paint4.measureText(this.f393180a))) >> 1;
                i26 = (i3 - measureText2) >> 1;
            }
            this.f393183d.add(new g(this.f393180a, measureText, i26, measureText3, measureText2, this.f393186g));
            return;
        }
        if (z16) {
            this.f393183d.add(new g(this.f393180a, 0, 0, measureText3, measureText2, this.f393186g));
            return;
        }
        String[] b16 = c.b(this.f393180a, paint3, i3, i3);
        int length = b16.length;
        if (length > 0) {
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i46 = 0;
            while (i27 < length) {
                if (!z17) {
                    i39 = (i3 - ((int) paint4.measureText(b16[i27]))) >> 1;
                    i46 = (i3 - ((int) paint3.measureText(b16[i27]))) >> 1;
                }
                if (this.f393186g != null) {
                    i28 += b16[i27].length();
                    arrayList = new ArrayList();
                    while (true) {
                        if (i36 < this.f393186g.size()) {
                            a aVar = this.f393186g.get(i36);
                            if (i27 != 0 && i37 == i36) {
                                i29 = i28 - b16[i27].length();
                                i38 = aVar.f393159c - i29;
                            }
                            int i47 = aVar.f393159c;
                            if (i47 <= i28 && aVar.f393160d >= i28) {
                                if (i27 == 0) {
                                    i16 = length;
                                    i19 = i28;
                                    i17 = i39;
                                    i18 = i46;
                                    arrayList.add(new a(aVar.f393157a, aVar.f393158b, i47, b16[i27].length()));
                                } else {
                                    i16 = length;
                                    i19 = i28;
                                    i17 = i39;
                                    i18 = i46;
                                    arrayList.add(new a(aVar.f393157a, aVar.f393158b, (i47 - i29) - i38, b16[i27].length()));
                                }
                                i36++;
                                i37 = i36;
                                i28 = i19;
                            } else {
                                int i48 = length;
                                int i49 = i28;
                                int i56 = i39;
                                int i57 = i46;
                                if (i27 == 0) {
                                    arrayList.add(aVar);
                                } else {
                                    arrayList.add(new a(aVar.f393157a, aVar.f393158b, (i47 - i29) - i38, (aVar.f393160d - i29) - i38));
                                }
                                i36++;
                                length = i48;
                                i28 = i49;
                                i39 = i56;
                                i46 = i57;
                            }
                        } else {
                            i16 = length;
                            i17 = i39;
                            i18 = i46;
                            break;
                        }
                    }
                } else {
                    i16 = length;
                    i17 = i39;
                    i18 = i46;
                    arrayList = null;
                }
                i39 = i17;
                i46 = i18;
                this.f393183d.add(new g(b16[i27], i39, i46, arrayList));
                i27++;
                paint3 = paint;
                paint4 = paint2;
                length = i16;
            }
        }
    }

    public e b() {
        e eVar = new e();
        eVar.f393180a = this.f393180a;
        eVar.f393182c = this.f393182c;
        eVar.f393181b = this.f393181b;
        if (this.f393186g != null) {
            ArrayList<a> arrayList = new ArrayList<>();
            eVar.f393186g = arrayList;
            arrayList.addAll(this.f393186g);
        }
        eVar.f393183d.addAll(this.f393183d);
        return eVar;
    }

    public int c() {
        return this.f393183d.size();
    }

    public ArrayList<g> d() {
        return this.f393183d;
    }

    public e(g gVar) {
        if (gVar == null) {
            return;
        }
        this.f393180a = gVar.f393191a;
        this.f393186g = gVar.f393196f;
        this.f393181b = gVar.d();
        this.f393182c = gVar.c() - gVar.d();
    }
}
