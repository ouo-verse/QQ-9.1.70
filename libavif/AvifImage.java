package libavif;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AvifImage {

    /* renamed from: a, reason: collision with root package name */
    private final long f414844a;

    public AvifImage(long j3) {
        this.f414844a = j3;
    }

    private static native int getDepth0(long j3);

    private static native int getHeight0(long j3);

    private static native int getWidth0(long j3);

    private static native int getYuvFormat0(long j3);

    private static native int getYuvRange0(long j3);

    public int a() {
        return getHeight0(this.f414844a);
    }

    public int b() {
        return getWidth0(this.f414844a);
    }
}
