package e45;

import c45.b;
import cooperation.qzone.ShareElfFile;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {
    public final int a(int i3, c45.b bVar, Object obj) {
        int b16;
        if (!f.a(bVar, obj) || obj == null) {
            return 0;
        }
        if (bVar instanceof b.f) {
            b16 = b(i3) * (((b.f) bVar).f30310b ? 1 : ((List) obj).size());
        } else if (bVar instanceof b.C0166b) {
            b16 = b(i3) * ((Map) obj).size();
        } else {
            b16 = b(i3);
        }
        return 0 + b16 + b.a(bVar, obj);
    }

    public final int c(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        if ((i3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) {
            return 4;
        }
        return 5;
    }

    public final int b(int i3) {
        return c(j.a(i3, 0));
    }
}
