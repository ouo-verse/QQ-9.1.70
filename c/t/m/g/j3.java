package c.t.m.g;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class j3 {

    /* renamed from: a, reason: collision with root package name */
    public static double[][] f29804a = {new double[]{53.540307d, 122.380829d}, new double[]{53.399707d, 120.821285d}, new double[]{52.749594d, 119.919891d}, new double[]{49.95122d, 116.580048d}, new double[]{47.901614d, 115.437469d}, new double[]{47.070122d, 118.381805d}, new double[]{45.213004d, 112.009735d}, new double[]{42.714732d, 107.83493d}, new double[]{42.779275d, 100.100555d}, new double[]{42.90816d, 96.49704d}, new double[]{44.43378d, 95.442352d}, new double[]{45.614037d, 91.091766d}, new double[]{47.606163d, 91.003876d}, new double[]{49.439557d, 87.180634d}, new double[]{47.398349d, 82.961884d}, new double[]{44.964798d, 79.753876d}, new double[]{42.358544d, 79.885712d}, new double[]{40.513799d, 73.689423d}, new double[]{36.5626d, 73.758774d}, new double[]{33.760882d, 76.457977d}, new double[]{31.989442d, 77.688446d}, new double[]{28.497661d, 84.280243d}, new double[]{27.166695d, 88.394279d}, new double[]{26.755421d, 92.118645d}, new double[]{27.936181d, 97.379379d}, new double[]{24.166802d, 97.115707d}, new double[]{21.350781d, 99.972153d}, new double[]{21.105d, 101.707993d}, new double[]{23.120154d, 105.355453d}, new double[]{21.915019d, 106.646605d}, new double[]{21.350781d, 107.684555d}, new double[]{16.762468d, 109.002914d}, new double[]{18.729502d, 111.174774d}, new double[]{21.2689d, 112.782211d}, new double[]{22.998852d, 117.176743d}, new double[]{25.019304d, 119.973391d}, new double[]{27.117813d, 120.890121d}, new double[]{27.76133d, 121.821041d}, new double[]{30.097613d, 123.451653d}, new double[]{33.155948d, 120.999985d}, new double[]{35.209722d, 120.143051d}, new double[]{36.914764d, 122.913322d}, new double[]{39.842286d, 124.273911d}, new double[]{41.294317d, 128.272934d}, new double[]{42.815551d, 131.197872d}, new double[]{45.02695d, 133.172836d}, new double[]{48.04871d, 135.040512d}, new double[]{48.618385d, 134.337387d}, new double[]{47.886881d, 131.700668d}, new double[]{49.196064d, 130.536118d}, new double[]{50.708634d, 127.613754d}, new double[]{53.13359d, 125.833969d}, new double[]{53.657661d, 123.329086d}};

    /* renamed from: b, reason: collision with root package name */
    public static double f29805b = 360.0d;

    /* renamed from: c, reason: collision with root package name */
    public static double f29806c = 360.0d;

    /* renamed from: d, reason: collision with root package name */
    public static double f29807d = -360.0d;

    /* renamed from: e, reason: collision with root package name */
    public static double f29808e = -360.0d;

    /* renamed from: f, reason: collision with root package name */
    public static List<a> f29809f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public double f29810a;

        /* renamed from: b, reason: collision with root package name */
        public double f29811b;

        public a(double d16, double d17) {
            this.f29810a = d16;
            this.f29811b = d17;
        }

        public double a() {
            return this.f29810a;
        }

        public double b() {
            return this.f29811b;
        }
    }

    static {
        a();
    }

    public static void a() {
        int i3 = 0;
        while (true) {
            double[][] dArr = f29804a;
            if (i3 >= dArr.length) {
                return;
            }
            double[] dArr2 = dArr[i3];
            double d16 = dArr2[0];
            double d17 = dArr2[1];
            if (d16 < f29806c) {
                f29806c = d16;
            }
            if (d16 > f29808e) {
                f29808e = d16;
            }
            if (d17 < f29805b) {
                f29805b = d17;
            }
            if (d17 > f29807d) {
                f29807d = d17;
            }
            f29809f.add(new a(d16, d17));
            i3++;
        }
    }

    public static boolean b(double d16, double d17) {
        a aVar = f29809f.get(0);
        int size = f29809f.size();
        int i3 = 0;
        int i16 = 1;
        while (i16 <= size) {
            a aVar2 = f29809f.get(i16 % size);
            if (d16 > Math.min(aVar.a(), aVar2.a()) && d16 <= Math.max(aVar.a(), aVar2.a()) && d17 <= Math.max(aVar.b(), aVar2.b()) && aVar.a() != aVar2.a()) {
                double a16 = (((d16 - aVar.a()) * (aVar2.b() - aVar.b())) / (aVar2.a() - aVar.a())) + aVar.b();
                if (aVar.b() == aVar2.b() || d17 <= a16) {
                    i3++;
                }
            }
            i16++;
            aVar = aVar2;
        }
        if (i3 % 2 == 0) {
            return false;
        }
        return true;
    }

    public static boolean a(double d16, double d17) {
        return d16 >= f29806c && d17 >= f29805b && d16 <= f29808e && d17 <= f29807d && b(d16, d17);
    }
}
