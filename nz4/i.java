package nz4;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class i {

    /* renamed from: d, reason: collision with root package name */
    public static final i f421649d = new i(0, new int[0], new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f421650a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f421651b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f421652c;

    public i() {
        this(0, new int[8], new Object[8]);
    }

    public static i a(i iVar, i iVar2) {
        int i3 = iVar.f421650a + iVar2.f421650a;
        int[] copyOf = Arrays.copyOf(iVar.f421651b, i3);
        System.arraycopy(iVar2.f421651b, 0, copyOf, iVar.f421650a, iVar2.f421650a);
        Object[] copyOf2 = Arrays.copyOf(iVar.f421652c, i3);
        System.arraycopy(iVar2.f421652c, 0, copyOf2, iVar.f421650a, iVar2.f421650a);
        return new i(i3, copyOf, copyOf2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f421650a == iVar.f421650a && Arrays.equals(this.f421651b, iVar.f421651b) && Arrays.deepEquals(this.f421652c, iVar.f421652c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.deepHashCode(this.f421652c) + ((Arrays.hashCode(this.f421651b) + ((this.f421650a + 527) * 31)) * 31);
    }

    public i(int i3, int[] iArr, Object[] objArr) {
        this.f421650a = i3;
        this.f421651b = iArr;
        this.f421652c = objArr;
    }
}
