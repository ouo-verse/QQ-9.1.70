package i14;

import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import k14.f;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends b {

    /* renamed from: b, reason: collision with root package name */
    private final c[] f407036b;

    public a(MemoryLeakInspector memoryLeakInspector) {
        this(memoryLeakInspector, new c[]{new j14.b(memoryLeakInspector), new j14.a(memoryLeakInspector), new f(memoryLeakInspector)});
    }

    @Override // i14.c
    public boolean a() {
        for (c cVar : this.f407036b) {
            if (cVar.c()) {
                cVar.a();
            }
        }
        return true;
    }

    @Override // i14.c
    public void b() {
        for (c cVar : this.f407036b) {
            cVar.b();
        }
    }

    public a(MemoryLeakInspector memoryLeakInspector, c[] cVarArr) {
        super(memoryLeakInspector);
        this.f407036b = cVarArr;
    }
}
