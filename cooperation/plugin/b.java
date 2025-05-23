package cooperation.plugin;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f390257a = {"B", "K", "M", "G"};

    public static final String a(long j3) {
        int i3 = 0;
        float f16 = 0.0f;
        while (j3 >= 1024) {
            j3 /= 1024;
            f16 = (float) (j3 % 1024);
            i3++;
        }
        if (f16 == 0.0f) {
            return String.valueOf(j3) + f390257a[i3];
        }
        return String.format("%.2f", Float.valueOf((f16 / 1024.0f) + ((float) j3))) + f390257a[i3];
    }
}
