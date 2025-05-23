package hynb.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public int f406683a;

    /* renamed from: b, reason: collision with root package name */
    public long f406684b;

    /* renamed from: c, reason: collision with root package name */
    public List<HashSet<Long>> f406685c;

    /* renamed from: d, reason: collision with root package name */
    public int f406686d = 0;

    public n(int i3, long j3) {
        this.f406685c = new ArrayList(this.f406683a);
        this.f406683a = i3;
        this.f406684b = j3;
        for (int i16 = 0; i16 < this.f406683a; i16++) {
            this.f406685c.add(new HashSet<>());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r3 = r8.f406683a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if (r2 >= r3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r3 = r8.f406685c.get((r8.f406686d + r2) % r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r3.size() >= r8.f406684b) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r3.add(java.lang.Long.valueOf(r9));
        r8.f406686d = (r8.f406686d + r2) % r8.f406683a;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r0 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        r0 = (r8.f406686d + 1) % r8.f406683a;
        r8.f406686d = r0;
        r0 = r8.f406685c.get(r0);
        r0.clear();
        r0.add(java.lang.Long.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean a(long j3) {
        if (j3 == 0) {
            return true;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            int i16 = this.f406683a;
            if (i3 >= i16) {
                break;
            }
            if (this.f406685c.get((this.f406686d + i3) % i16).contains(Long.valueOf(j3))) {
                return false;
            }
            i3++;
        }
    }
}
