package nz4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c implements Iterator {

    /* renamed from: d, reason: collision with root package name */
    public int f421644d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final int f421645e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.xingin.xhssharesdk.a.e f421646f;

    public c(com.xingin.xhssharesdk.a.e eVar) {
        this.f421646f = eVar;
        this.f421645e = eVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f421644d < this.f421645e) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            com.xingin.xhssharesdk.a.e eVar = this.f421646f;
            int i3 = this.f421644d;
            this.f421644d = i3 + 1;
            return Byte.valueOf(eVar.a(i3));
        } catch (IndexOutOfBoundsException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
