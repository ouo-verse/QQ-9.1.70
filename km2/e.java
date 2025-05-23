package km2;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements g {

    /* renamed from: a, reason: collision with root package name */
    private float f412696a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    private final qm2.a f412697b;

    public e(qm2.a aVar) {
        this.f412697b = aVar;
    }

    private float b(float f16) {
        return f16 * this.f412696a;
    }

    @Override // km2.g
    public void a(com.tencent.mobileqq.richmedia.particlesystem.a aVar, jm2.a aVar2, int i3) {
        aVar.f281687i = -b(this.f412697b.b());
        aVar.f281688j = b(this.f412697b.c());
    }

    public void c(float f16) {
        this.f412696a = f16;
    }
}
