package d73;

import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f393161a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<e> f393162b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<g> f393163c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f393164d = 0;

    /* renamed from: e, reason: collision with root package name */
    private e f393165e;

    /* renamed from: f, reason: collision with root package name */
    private int f393166f;

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public int f393167g;

    public b(int i3, int i16, ArrayList<e> arrayList) {
        this.f393161a = i3;
        this.f393167g = i16;
        this.f393162b = arrayList;
    }

    public void a(b bVar) {
        this.f393161a = bVar.f393161a;
        this.f393167g = bVar.f393167g;
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList == null) {
            this.f393162b = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Iterator<e> it = bVar.f393162b.iterator();
        while (it.hasNext()) {
            this.f393162b.add(it.next().b());
        }
        this.f393164d = bVar.j();
        Log.d("Lyric", "copy -> mType : " + this.f393161a);
    }

    public int b(int i3) {
        int i16;
        int i17 = 0;
        if (i3 < 0) {
            Log.w("Lyric", "findEndLineByStartTime -> illegal time");
            return 0;
        }
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList == null) {
            Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
            return -1;
        }
        int size = arrayList.size();
        int i18 = 0;
        while (true) {
            if (i18 < size) {
                e eVar = arrayList.get(i18);
                if (eVar != null && i3 <= eVar.f393181b) {
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
        return d(i3);
    }

    public int d(int i3) {
        int i16;
        if (i3 < 0) {
            Log.w("Lyric", "findLineNoByStartTime -> illegal time");
            return -1;
        }
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList != null && arrayList.size() != 0) {
            e eVar = this.f393165e;
            if (eVar != null) {
                long j3 = eVar.f393181b;
                long j16 = i3;
                if (j3 < j16 && j3 + eVar.f393182c > j16) {
                    return this.f393166f;
                }
            }
            ArrayList<e> arrayList2 = this.f393162b;
            int size = arrayList2.size();
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i18 < size) {
                    e eVar2 = arrayList2.get(i18);
                    if (eVar2 != null && eVar2.f393181b > i3) {
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
            this.f393166f = i17;
            this.f393165e = arrayList2.get(i17);
            return i17;
        }
        Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
        return -1;
    }

    public int e(long j3) {
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList == null || arrayList.isEmpty() || j3 < 0) {
            return -1;
        }
        int size = this.f393162b.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                e eVar = this.f393162b.get(i3);
                long j16 = eVar.f393181b;
                if (j3 >= j16 && j3 <= j16 + eVar.f393182c) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1 && j3 == 0) {
            return 0;
        }
        return i3;
    }

    public void f(Paint paint, Paint paint2, int i3) {
        h(paint, paint2, i3, false, false);
    }

    public void g(Paint paint, Paint paint2, int i3, boolean z16) {
        h(paint, paint2, i3, z16, false);
    }

    public void h(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        this.f393163c.clear();
        this.f393164d = 0;
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                next.a(paint, paint2, i3, z16, z17);
                this.f393164d += next.c();
                this.f393163c.addAll(next.f393183d);
            }
        }
    }

    public List<e> i() {
        return this.f393162b;
    }

    public int j() {
        return this.f393164d;
    }

    public boolean k() {
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList != null && arrayList.size() != 0) {
            return false;
        }
        return true;
    }

    public int l() {
        ArrayList<e> arrayList = this.f393162b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.f393162b == null) {
            return null;
        }
        for (int i3 = 0; i3 < this.f393162b.size(); i3++) {
            e eVar = this.f393162b.get(i3);
            sb5.append(i3);
            sb5.append(":");
            sb5.append(eVar.f393181b);
            sb5.append(":");
            sb5.append(eVar.f393180a);
            sb5.append(":");
            sb5.append(eVar.f393182c + eVar.f393181b);
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
