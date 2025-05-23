package ir;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements TypeEvaluator<ArrayList<Integer>> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<C10548a> f408220a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Integer> f408221b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Integer> f408222c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f408223d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<TimeInterpolator> f408224e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private long f408225f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ir.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10548a {

        /* renamed from: a, reason: collision with root package name */
        public long f408226a;

        /* renamed from: b, reason: collision with root package name */
        public long f408227b;

        /* renamed from: c, reason: collision with root package name */
        public long f408228c;

        public C10548a(long j3, long j16, int i3) {
            this.f408226a = j3;
            this.f408227b = j16;
            this.f408228c = i3;
        }
    }

    public int a(String str, long j3, long j16, int i3, int i16, TimeInterpolator timeInterpolator) {
        int size = this.f408222c.size();
        this.f408220a.add(new C10548a(j3, j16, size));
        this.f408222c.add(Integer.valueOf(i3));
        this.f408223d.add(Integer.valueOf(i16));
        this.f408224e.add(timeInterpolator);
        long j17 = j3 + j16;
        if (j17 > this.f408225f) {
            this.f408225f = j17;
        }
        return size;
    }

    public long c() {
        return this.f408225f;
    }

    public ArrayList<Integer> d() {
        return this.f408223d;
    }

    public ArrayList<Integer> e() {
        return this.f408222c;
    }

    public ArrayList<Integer> f(long j3) {
        return evaluate(((float) j3) / ((float) this.f408225f), this.f408222c, this.f408223d);
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ArrayList<Integer> evaluate(float f16, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.size() != arrayList2.size()) {
            return null;
        }
        int size = arrayList.size();
        if (this.f408221b == null) {
            this.f408221b = new ArrayList<>();
        }
        this.f408221b.clear();
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = arrayList.get(i3).intValue();
            int intValue2 = arrayList2.get(i3).intValue();
            long j3 = this.f408220a.get(i3).f408226a;
            long j16 = this.f408220a.get(i3).f408227b;
            long j17 = (int) (((float) this.f408225f) * f16);
            if (j17 < j3) {
                this.f408221b.add(0);
            } else if (j17 > j3 + j16) {
                this.f408221b.add(Integer.valueOf(intValue2));
            } else {
                this.f408221b.add(Integer.valueOf((int) (intValue + ((intValue2 - intValue) * this.f408224e.get(i3).getInterpolation(((float) (j17 - j3)) / ((float) j16))))));
            }
        }
        return this.f408221b;
    }
}
