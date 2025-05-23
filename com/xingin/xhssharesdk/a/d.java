package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.d.a;
import com.xingin.xhssharesdk.a.f;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.l;
import com.xingin.xhssharesdk.a.p;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class d<FieldDescriptorType extends a<FieldDescriptorType>> {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f389903d = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f389905b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f389906c = false;

    /* renamed from: a, reason: collision with root package name */
    public final o f389904a = p.d(16);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a<T extends a<T>> extends Comparable<T> {
        void a();

        k.a b(l.a aVar, l lVar);

        void b();

        c0.b c();
    }

    static {
        new d(0);
    }

    public d() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0012. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static int a(c0.a aVar, int i3, String str) {
        int i16;
        int v3;
        int n3 = g.n(i3);
        if (aVar == c0.a.f389886d) {
            n3 *= 2;
        }
        int i17 = 4;
        switch (aVar.ordinal()) {
            case 0:
                ((Double) str).doubleValue();
                i17 = 8;
                return n3 + i17;
            case 1:
                ((Float) str).floatValue();
                return n3 + i17;
            case 2:
                i17 = g.d(((Long) str).longValue());
                return n3 + i17;
            case 3:
                i17 = g.d(((Long) str).longValue());
                return n3 + i17;
            case 4:
                i17 = g.b(((Integer) str).intValue());
                return n3 + i17;
            case 5:
            case 15:
                ((Long) str).longValue();
                i17 = 8;
                return n3 + i17;
            case 6:
            case 14:
                ((Integer) str).intValue();
                return n3 + i17;
            case 7:
                ((Boolean) str).booleanValue();
                i17 = 1;
                return n3 + i17;
            case 8:
                if (!(str instanceof e)) {
                    i17 = g.g(str);
                    return n3 + i17;
                }
                i17 = g.e((e) str);
                return n3 + i17;
            case 9:
                i17 = ((l) str).b();
                return n3 + i17;
            case 10:
                if (str instanceof h) {
                    h hVar = (h) str;
                    if (hVar.f389926b != null) {
                        i16 = hVar.f389926b.f389910d.length;
                    } else if (hVar.f389925a != null) {
                        i16 = hVar.f389925a.b();
                    } else {
                        i16 = 0;
                    }
                    v3 = g.v(i16);
                    i17 = v3 + i16;
                    return n3 + i17;
                }
                i17 = g.f((l) str);
                return n3 + i17;
            case 11:
                if (!(str instanceof e)) {
                    i16 = ((byte[]) str).length;
                    v3 = g.v(i16);
                    i17 = v3 + i16;
                    return n3 + i17;
                }
                i17 = g.e((e) str);
                return n3 + i17;
            case 12:
                i17 = g.v(((Integer) str).intValue());
                return n3 + i17;
            case 13:
                i17 = str instanceof f.a ? g.b(((f.a) str).a()) : g.b(((Integer) str).intValue());
                return n3 + i17;
            case 16:
                int intValue = ((Integer) str).intValue();
                i17 = g.v((intValue >> 31) ^ (intValue << 1));
                return n3 + i17;
            case 17:
                long longValue = ((Long) str).longValue();
                i17 = g.d((longValue >> 63) ^ (longValue << 1));
                return n3 + i17;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static Object c(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((r2 instanceof com.xingin.xhssharesdk.a.f.a) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if ((r2 instanceof byte[]) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if ((r2 instanceof com.xingin.xhssharesdk.a.h) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(c0.a aVar, Object obj) {
        obj.getClass();
        boolean z16 = false;
        switch (aVar.f389888a) {
            case INT:
                z16 = obj instanceof Integer;
                break;
            case LONG:
                z16 = obj instanceof Long;
                break;
            case FLOAT:
                z16 = obj instanceof Float;
                break;
            case DOUBLE:
                z16 = obj instanceof Double;
                break;
            case BOOLEAN:
                z16 = obj instanceof Boolean;
                break;
            case STRING:
                z16 = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof e)) {
                    break;
                }
                z16 = true;
                break;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z16 = true;
                break;
            case MESSAGE:
                if (!(obj instanceof l)) {
                    break;
                }
                z16 = true;
                break;
        }
        if (z16) {
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(g gVar, c0.a aVar, int i3, String str) {
        int intValue;
        if (aVar == c0.a.f389886d) {
            gVar.o(i3, 3);
            ((l) str).a(gVar);
            gVar.o(i3, 4);
            return;
        }
        gVar.o(i3, aVar.f389889b);
        switch (aVar.ordinal()) {
            case 0:
                gVar.q(Double.doubleToRawLongBits(((Double) str).doubleValue()));
                return;
            case 1:
                gVar.x(Float.floatToRawIntBits(((Float) str).floatValue()));
                return;
            case 2:
                gVar.y(((Long) str).longValue());
                return;
            case 3:
                gVar.y(((Long) str).longValue());
                return;
            case 4:
                gVar.z(((Integer) str).intValue());
                return;
            case 5:
                gVar.q(((Long) str).longValue());
                return;
            case 6:
                gVar.x(((Integer) str).intValue());
                return;
            case 7:
                gVar.i(((Boolean) str).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case 8:
                if (!(str instanceof e)) {
                    gVar.t(str);
                    return;
                }
                break;
            case 9:
                ((l) str).a(gVar);
                return;
            case 10:
                gVar.s((l) str);
                return;
            case 11:
                if (!(str instanceof e)) {
                    byte[] bArr = (byte[]) str;
                    gVar.m(bArr, bArr.length);
                    return;
                }
                break;
            case 12:
                gVar.A(((Integer) str).intValue());
                return;
            case 13:
                if (str instanceof f.a) {
                    intValue = ((f.a) str).a();
                } else {
                    intValue = ((Integer) str).intValue();
                }
                gVar.z(intValue);
                return;
            case 14:
                gVar.x(((Integer) str).intValue());
                return;
            case 15:
                gVar.q(((Long) str).longValue());
                return;
            case 16:
                int intValue2 = ((Integer) str).intValue();
                gVar.A((intValue2 >> 31) ^ (intValue2 << 1));
                return;
            case 17:
                long longValue = ((Long) str).longValue();
                gVar.y((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
        gVar.r((e) str);
    }

    public static <T extends a<T>> d<T> i() {
        return new d<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final d<FieldDescriptorType> clone() {
        Iterable<Map.Entry> entrySet;
        d<FieldDescriptorType> dVar = (d<FieldDescriptorType>) new d();
        for (int i3 = 0; i3 < this.f389904a.f389956e.size(); i3++) {
            p<K, V>.b bVar = this.f389904a.f389956e.get(i3);
            dVar.f((a) bVar.getKey(), bVar.getValue());
        }
        o oVar = this.f389904a;
        if (oVar.f389957f.isEmpty()) {
            entrySet = p.a.f389961b;
        } else {
            entrySet = oVar.f389957f.entrySet();
        }
        for (Map.Entry entry : entrySet) {
            dVar.f((a) entry.getKey(), entry.getValue());
        }
        dVar.f389906c = this.f389906c;
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return this.f389904a.equals(((d) obj).f389904a);
    }

    public final void f(FieldDescriptorType fielddescriptortype, Object obj) {
        fielddescriptortype.a();
        fielddescriptortype.b();
        d(null, obj);
        if (obj instanceof h) {
            this.f389906c = true;
        }
        this.f389904a.put(fielddescriptortype, obj);
    }

    public final void g(Map.Entry<FieldDescriptorType, Object> entry) {
        o oVar;
        Object c16;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof h) {
            value = ((h) value).a();
        }
        key.a();
        if (key.c() == c0.b.MESSAGE) {
            Object obj = this.f389904a.get(key);
            if (obj instanceof h) {
                obj = ((h) obj).a();
            }
            if (obj != null) {
                c16 = key.b(((l) obj).d(), (l) value).e();
                oVar = this.f389904a;
                oVar.put(key, c16);
            }
        }
        oVar = this.f389904a;
        c16 = c(value);
        oVar.put(key, c16);
    }

    public final void h() {
        if (this.f389905b) {
            return;
        }
        this.f389904a.g();
        this.f389905b = true;
    }

    public final int hashCode() {
        return this.f389904a.hashCode();
    }

    public d(int i3) {
        h();
    }
}
