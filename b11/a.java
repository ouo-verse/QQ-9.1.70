package b11;

import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends t01.a {
    @Override // t01.a
    public void d(int i3) {
        super.d(i3);
        this.f435222a.order(ByteOrder.BIG_ENDIAN);
    }

    public void g(int i3) {
        b((byte) (i3 & 255));
        b((byte) ((i3 >> 8) & 255));
        b((byte) ((i3 >> 16) & 255));
        b((byte) ((i3 >> 24) & 255));
    }

    public void h(int i3) {
        b((byte) ((i3 >> 24) & 255));
        b((byte) ((i3 >> 16) & 255));
        b((byte) ((i3 >> 8) & 255));
        b((byte) (i3 & 255));
    }
}
