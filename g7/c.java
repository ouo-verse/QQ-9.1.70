package g7;

import com.qzone.jbox2d.common.Vec2;
import f7.g;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements g, a {

    /* renamed from: a, reason: collision with root package name */
    private final b f401481a;

    /* renamed from: c, reason: collision with root package name */
    private int[] f401483c;

    /* renamed from: d, reason: collision with root package name */
    private int f401484d;

    /* renamed from: e, reason: collision with root package name */
    private int f401485e;

    /* renamed from: i, reason: collision with root package name */
    private int f401489i;

    /* renamed from: b, reason: collision with root package name */
    private int f401482b = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f401487g = 16;

    /* renamed from: h, reason: collision with root package name */
    private int f401488h = 0;

    /* renamed from: f, reason: collision with root package name */
    private long[] f401486f = new long[16];

    public c(b bVar) {
        for (int i3 = 0; i3 < this.f401487g; i3++) {
            this.f401486f[i3] = 0;
        }
        this.f401484d = 16;
        this.f401485e = 0;
        this.f401483c = new int[16];
        this.f401481a = bVar;
        this.f401489i = -1;
    }

    @Override // g7.a
    public final void a(g gVar, com.qzone.jbox2d.collision.a aVar) {
        this.f401481a.a(gVar, aVar);
    }

    @Override // g7.a
    public final void b(int i3, com.qzone.jbox2d.collision.a aVar, Vec2 vec2) {
        if (this.f401481a.b(i3, aVar, vec2)) {
            f(i3);
        }
    }

    @Override // g7.a
    public final int c(com.qzone.jbox2d.collision.a aVar, Object obj) {
        int c16 = this.f401481a.c(aVar, obj);
        this.f401482b++;
        f(c16);
        return c16;
    }

    @Override // g7.a
    public boolean d(int i3, int i16) {
        com.qzone.jbox2d.collision.a fatAABB = this.f401481a.getFatAABB(i3);
        com.qzone.jbox2d.collision.a fatAABB2 = this.f401481a.getFatAABB(i16);
        Vec2 vec2 = fatAABB2.f47986a;
        float f16 = vec2.f48119x;
        Vec2 vec22 = fatAABB.f47987b;
        if (f16 - vec22.f48119x <= 0.0f && vec2.f48120y - vec22.f48120y <= 0.0f) {
            Vec2 vec23 = fatAABB.f47986a;
            float f17 = vec23.f48119x;
            Vec2 vec24 = fatAABB2.f47987b;
            if (f17 - vec24.f48119x <= 0.0f && vec23.f48120y - vec24.f48120y <= 0.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // g7.a
    public final void destroyProxy(int i3) {
        g(i3);
        this.f401482b--;
        this.f401481a.destroyProxy(i3);
    }

    protected final void f(int i3) {
        int i16 = this.f401485e;
        int i17 = this.f401484d;
        if (i16 == i17) {
            int[] iArr = this.f401483c;
            int i18 = i17 * 2;
            this.f401484d = i18;
            int[] iArr2 = new int[i18];
            this.f401483c = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        int[] iArr3 = this.f401483c;
        int i19 = this.f401485e;
        iArr3[i19] = i3;
        this.f401485e = i19 + 1;
    }

    @Override // g7.a
    public Object getUserData(int i3) {
        return this.f401481a.getUserData(i3);
    }

    @Override // f7.g
    public final boolean treeCallback(int i3) {
        if (i3 == this.f401489i) {
            return true;
        }
        int i16 = this.f401488h;
        int i17 = this.f401487g;
        if (i16 == i17) {
            long[] jArr = this.f401486f;
            int i18 = i17 * 2;
            this.f401487g = i18;
            long[] jArr2 = new long[i18];
            this.f401486f = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            for (int length = jArr.length; length < this.f401487g; length++) {
                this.f401486f[length] = 0;
            }
        }
        int i19 = this.f401489i;
        if (i3 < i19) {
            this.f401486f[this.f401488h] = (i3 << 32) | i19;
        } else {
            this.f401486f[this.f401488h] = (i19 << 32) | i3;
        }
        this.f401488h++;
        return true;
    }

    @Override // g7.a
    public final void e(f7.d dVar) {
        int i3 = 0;
        this.f401488h = 0;
        for (int i16 = 0; i16 < this.f401485e; i16++) {
            int i17 = this.f401483c[i16];
            this.f401489i = i17;
            if (i17 != -1) {
                this.f401481a.a(this, this.f401481a.getFatAABB(i17));
            }
        }
        this.f401485e = 0;
        Arrays.sort(this.f401486f, 0, this.f401488h);
        while (i3 < this.f401488h) {
            long j3 = this.f401486f[i3];
            dVar.addPair(this.f401481a.getUserData((int) (j3 >> 32)), this.f401481a.getUserData((int) j3));
            do {
                i3++;
                if (i3 < this.f401488h) {
                }
            } while (this.f401486f[i3] == j3);
        }
    }

    protected final void g(int i3) {
        for (int i16 = 0; i16 < this.f401485e; i16++) {
            int[] iArr = this.f401483c;
            if (iArr[i16] == i3) {
                iArr[i16] = -1;
            }
        }
    }
}
